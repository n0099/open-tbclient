package com.baidu.tieba.newdetail.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.e.a;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.newdetail.a.b;
/* loaded from: classes15.dex */
public class HotTopicDetailSpecialItem extends RelativeLayout implements View.OnClickListener {
    private f<b> ahW;
    private TextView aix;
    private int iLR;
    private TbImageView iLZ;
    private View iMa;
    private View iMb;
    private ImageView iMc;
    private TextView iMd;
    private TextView jaJ;
    private ViewGroup kmT;
    private b kmU;

    public HotTopicDetailSpecialItem(Context context) {
        super(context);
        this.iLR = 3;
        initView();
    }

    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iLR = 3;
        initView();
    }

    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iLR = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_special_item, (ViewGroup) this, true);
        this.kmT = (ViewGroup) findViewById(R.id.rootLayout);
        this.kmT.setOnClickListener(this);
        this.iLZ = (TbImageView) findViewById(R.id.coverView);
        this.iMa = findViewById(R.id.coverGradientMask);
        this.iMb = findViewById(R.id.videoTimeContainer);
        this.iMc = (ImageView) findViewById(R.id.videoPlayIcon);
        this.iMd = (TextView) findViewById(R.id.videoPlayTime);
        this.jaJ = (TextView) findViewById(R.id.descView);
        this.aix = (TextView) findViewById(R.id.tagView);
        this.iLZ.setPlaceHolder(2);
        this.iLZ.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.iLZ.setConrers(15);
    }

    public void setOnItemCoverListener(f<b> fVar) {
        this.ahW = fVar;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.kmU = bVar;
            if (TextUtils.isEmpty(bVar.cover)) {
                this.iLZ.setVisibility(8);
                this.iMa.setVisibility(8);
                this.iMb.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aix.getLayoutParams();
                layoutParams.addRule(8, 0);
                layoutParams.addRule(3, R.id.descView);
                this.aix.setLayoutParams(layoutParams);
            } else {
                this.iLZ.startLoad(bVar.cover, 10, false);
                this.iLZ.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aix.getLayoutParams();
                layoutParams2.addRule(8, R.id.coverView);
                layoutParams2.addRule(3, 0);
                this.aix.setLayoutParams(layoutParams2);
                if (bVar.time > 0) {
                    this.iMb.setVisibility(0);
                    this.iMa.setVisibility(0);
                    this.iMd.setText(StringUtils.translateSecondsToString(bVar.time));
                } else {
                    this.iMb.setVisibility(8);
                    this.iMa.setVisibility(8);
                }
            }
            this.jaJ.setText(bVar.desc);
            String str = "" + this.aix.getContext().getResources().getString(R.string.hot_topic_special_item_reply, at.numberUniformFormatExtra(bVar.atH));
            String numberUniformFormatExtra = at.numberUniformFormatExtra(bVar.likeNum);
            if (str.length() > 0) {
                str = str + "  ";
            }
            this.aix.setText(str + this.aix.getContext().getResources().getString(R.string.hot_topic_special_item_like, numberUniformFormatExtra));
            setPadding(0, 0, 0, bVar.hNV ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40) : 0);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iLR != i) {
            a.g(this.kmT, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.jaJ, R.color.cp_cont_b);
            ap.setViewTextColor(this.aix, R.color.cp_cont_d);
            ap.setViewTextColor(this.iMd, R.color.cp_cont_a);
            this.iMc.setImageDrawable(SvgManager.bjq().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
            this.iLR = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kmU != null && this.kmU.dUS != null) {
            if (this.ahW != null) {
                this.ahW.a(view, this.kmU, 0, 0L);
            }
            ay.a((AbsThreadDataSupport) this.kmU.dUS, view.getContext(), 17, false);
        }
    }
}
