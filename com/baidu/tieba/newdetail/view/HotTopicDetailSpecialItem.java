package com.baidu.tieba.newdetail.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.f.a;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.newdetail.a.b;
/* loaded from: classes7.dex */
public class HotTopicDetailSpecialItem extends RelativeLayout implements View.OnClickListener {
    private f<b> ajB;
    private TextView akb;
    private int jZf;
    private TbImageView jZn;
    private View jZo;
    private View jZp;
    private ImageView jZq;
    private TextView jZr;
    private TextView knN;
    private ViewGroup lrA;
    private b lrB;

    public HotTopicDetailSpecialItem(Context context) {
        super(context);
        this.jZf = 3;
        initView();
    }

    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jZf = 3;
        initView();
    }

    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jZf = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_special_item, (ViewGroup) this, true);
        this.lrA = (ViewGroup) findViewById(R.id.rootLayout);
        this.lrA.setOnClickListener(this);
        this.jZn = (TbImageView) findViewById(R.id.coverView);
        this.jZo = findViewById(R.id.coverGradientMask);
        this.jZp = findViewById(R.id.videoTimeContainer);
        this.jZq = (ImageView) findViewById(R.id.videoPlayIcon);
        this.jZr = (TextView) findViewById(R.id.videoPlayTime);
        this.knN = (TextView) findViewById(R.id.descView);
        this.akb = (TextView) findViewById(R.id.tagView);
        this.jZn.setPlaceHolder(2);
        this.jZn.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.jZn.setConrers(15);
    }

    public void setOnItemCoverListener(f<b> fVar) {
        this.ajB = fVar;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.lrB = bVar;
            if (TextUtils.isEmpty(bVar.cover)) {
                this.jZn.setVisibility(8);
                this.jZo.setVisibility(8);
                this.jZp.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.akb.getLayoutParams();
                layoutParams.addRule(8, 0);
                layoutParams.addRule(3, R.id.descView);
                this.akb.setLayoutParams(layoutParams);
            } else {
                this.jZn.startLoad(bVar.cover, 10, false);
                this.jZn.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.akb.getLayoutParams();
                layoutParams2.addRule(8, R.id.coverView);
                layoutParams2.addRule(3, 0);
                this.akb.setLayoutParams(layoutParams2);
                if (bVar.time > 0) {
                    this.jZp.setVisibility(0);
                    this.jZo.setVisibility(0);
                    this.jZr.setText(StringUtils.translateSecondsToString(bVar.time));
                } else {
                    this.jZp.setVisibility(8);
                    this.jZo.setVisibility(8);
                }
            }
            this.knN.setText(bVar.desc);
            String str = "" + this.akb.getContext().getResources().getString(R.string.hot_topic_special_item_reply, at.numberUniformFormatExtra(bVar.ivC));
            String numberUniformFormatExtra = at.numberUniformFormatExtra(bVar.likeNum);
            if (str.length() > 0) {
                str = str + "  ";
            }
            this.akb.setText(str + this.akb.getContext().getResources().getString(R.string.hot_topic_special_item_like, numberUniformFormatExtra));
            setPadding(0, 0, 0, bVar.iVI ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40) : 0);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jZf != i) {
            a.m(this.lrA, R.color.CAM_X0205, R.color.CAM_X0204);
            ao.setViewTextColor(this.knN, R.color.CAM_X0105);
            ao.setViewTextColor(this.akb, R.color.CAM_X0109);
            ao.setViewTextColor(this.jZr, R.color.CAM_X0101);
            this.jZq.setImageDrawable(SvgManager.bsx().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
            this.jZf = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.lrB != null && this.lrB.eHK != null) {
            if (this.ajB != null) {
                this.ajB.a(view, this.lrB, 0, 0L);
            }
            ay.a((com.baidu.tbadk.core.data.a) this.lrB.eHK, view.getContext(), 17, false);
        }
    }
}
