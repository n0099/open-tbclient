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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.f.a;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.newdetail.a.b;
/* loaded from: classes8.dex */
public class HotTopicDetailSpecialItem extends RelativeLayout implements View.OnClickListener {
    private TextView ajQ;
    private f<b> ajq;
    private int kgW;
    private TbImageView khe;
    private View khf;
    private View khg;
    private ImageView khh;
    private TextView khi;
    private TextView kwi;
    private ViewGroup lzT;
    private b lzU;

    public HotTopicDetailSpecialItem(Context context) {
        super(context);
        this.kgW = 3;
        initView();
    }

    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kgW = 3;
        initView();
    }

    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kgW = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_special_item, (ViewGroup) this, true);
        this.lzT = (ViewGroup) findViewById(R.id.rootLayout);
        this.lzT.setOnClickListener(this);
        this.khe = (TbImageView) findViewById(R.id.coverView);
        this.khf = findViewById(R.id.coverGradientMask);
        this.khg = findViewById(R.id.videoTimeContainer);
        this.khh = (ImageView) findViewById(R.id.videoPlayIcon);
        this.khi = (TextView) findViewById(R.id.videoPlayTime);
        this.kwi = (TextView) findViewById(R.id.descView);
        this.ajQ = (TextView) findViewById(R.id.tagView);
        this.khe.setPlaceHolder(2);
        this.khe.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.khe.setConrers(15);
    }

    public void setOnItemCoverListener(f<b> fVar) {
        this.ajq = fVar;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.lzU = bVar;
            if (TextUtils.isEmpty(bVar.cover)) {
                this.khe.setVisibility(8);
                this.khf.setVisibility(8);
                this.khg.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ajQ.getLayoutParams();
                layoutParams.addRule(8, 0);
                layoutParams.addRule(3, R.id.descView);
                this.ajQ.setLayoutParams(layoutParams);
            } else {
                this.khe.startLoad(bVar.cover, 10, false);
                this.khe.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ajQ.getLayoutParams();
                layoutParams2.addRule(8, R.id.coverView);
                layoutParams2.addRule(3, 0);
                this.ajQ.setLayoutParams(layoutParams2);
                if (bVar.time > 0) {
                    this.khg.setVisibility(0);
                    this.khf.setVisibility(0);
                    this.khi.setText(StringUtils.translateSecondsToString(bVar.time));
                } else {
                    this.khg.setVisibility(8);
                    this.khf.setVisibility(8);
                }
            }
            this.kwi.setText(bVar.desc);
            String str = "" + this.ajQ.getContext().getResources().getString(R.string.hot_topic_special_item_reply, au.numberUniformFormatExtra(bVar.iBA));
            String numberUniformFormatExtra = au.numberUniformFormatExtra(bVar.likeNum);
            if (str.length() > 0) {
                str = str + "  ";
            }
            this.ajQ.setText(str + this.ajQ.getContext().getResources().getString(R.string.hot_topic_special_item_like, numberUniformFormatExtra));
            setPadding(0, 0, 0, bVar.jbD ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40) : 0);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kgW != i) {
            a.m(this.lzT, R.color.CAM_X0205, R.color.CAM_X0204);
            ap.setViewTextColor(this.kwi, R.color.CAM_X0105);
            ap.setViewTextColor(this.ajQ, R.color.CAM_X0109);
            ap.setViewTextColor(this.khi, R.color.CAM_X0101);
            this.khh.setImageDrawable(SvgManager.bsR().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
            this.kgW = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.lzU != null && this.lzU.eJQ != null) {
            if (this.ajq != null) {
                this.ajq.a(view, this.lzU, 0, 0L);
            }
            az.a((com.baidu.tbadk.core.data.a) this.lzU.eJQ, view.getContext(), 17, false);
        }
    }
}
