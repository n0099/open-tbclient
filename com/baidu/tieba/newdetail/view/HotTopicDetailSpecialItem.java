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
    private int kgI;
    private TbImageView kgQ;
    private View kgR;
    private View kgS;
    private ImageView kgT;
    private TextView kgU;
    private TextView kvU;
    private ViewGroup lzF;
    private b lzG;

    public HotTopicDetailSpecialItem(Context context) {
        super(context);
        this.kgI = 3;
        initView();
    }

    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kgI = 3;
        initView();
    }

    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kgI = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_special_item, (ViewGroup) this, true);
        this.lzF = (ViewGroup) findViewById(R.id.rootLayout);
        this.lzF.setOnClickListener(this);
        this.kgQ = (TbImageView) findViewById(R.id.coverView);
        this.kgR = findViewById(R.id.coverGradientMask);
        this.kgS = findViewById(R.id.videoTimeContainer);
        this.kgT = (ImageView) findViewById(R.id.videoPlayIcon);
        this.kgU = (TextView) findViewById(R.id.videoPlayTime);
        this.kvU = (TextView) findViewById(R.id.descView);
        this.ajQ = (TextView) findViewById(R.id.tagView);
        this.kgQ.setPlaceHolder(2);
        this.kgQ.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.kgQ.setConrers(15);
    }

    public void setOnItemCoverListener(f<b> fVar) {
        this.ajq = fVar;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.lzG = bVar;
            if (TextUtils.isEmpty(bVar.cover)) {
                this.kgQ.setVisibility(8);
                this.kgR.setVisibility(8);
                this.kgS.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ajQ.getLayoutParams();
                layoutParams.addRule(8, 0);
                layoutParams.addRule(3, R.id.descView);
                this.ajQ.setLayoutParams(layoutParams);
            } else {
                this.kgQ.startLoad(bVar.cover, 10, false);
                this.kgQ.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ajQ.getLayoutParams();
                layoutParams2.addRule(8, R.id.coverView);
                layoutParams2.addRule(3, 0);
                this.ajQ.setLayoutParams(layoutParams2);
                if (bVar.time > 0) {
                    this.kgS.setVisibility(0);
                    this.kgR.setVisibility(0);
                    this.kgU.setText(StringUtils.translateSecondsToString(bVar.time));
                } else {
                    this.kgS.setVisibility(8);
                    this.kgR.setVisibility(8);
                }
            }
            this.kvU.setText(bVar.desc);
            String str = "" + this.ajQ.getContext().getResources().getString(R.string.hot_topic_special_item_reply, au.numberUniformFormatExtra(bVar.iBm));
            String numberUniformFormatExtra = au.numberUniformFormatExtra(bVar.likeNum);
            if (str.length() > 0) {
                str = str + "  ";
            }
            this.ajQ.setText(str + this.ajQ.getContext().getResources().getString(R.string.hot_topic_special_item_like, numberUniformFormatExtra));
            setPadding(0, 0, 0, bVar.jbp ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40) : 0);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kgI != i) {
            a.m(this.lzF, R.color.CAM_X0205, R.color.CAM_X0204);
            ap.setViewTextColor(this.kvU, R.color.CAM_X0105);
            ap.setViewTextColor(this.ajQ, R.color.CAM_X0109);
            ap.setViewTextColor(this.kgU, R.color.CAM_X0101);
            this.kgT.setImageDrawable(SvgManager.bsR().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
            this.kgI = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.lzG != null && this.lzG.eJQ != null) {
            if (this.ajq != null) {
                this.ajq.a(view, this.lzG, 0, 0L);
            }
            az.a((com.baidu.tbadk.core.data.a) this.lzG.eJQ, view.getContext(), 17, false);
        }
    }
}
