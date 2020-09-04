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
    private f<b> ahY;
    private TextView aiz;
    private int iLX;
    private TbImageView iMf;
    private View iMg;
    private View iMh;
    private ImageView iMi;
    private TextView iMj;
    private TextView jaP;
    private ViewGroup kna;
    private b knb;

    public HotTopicDetailSpecialItem(Context context) {
        super(context);
        this.iLX = 3;
        initView();
    }

    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iLX = 3;
        initView();
    }

    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iLX = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_special_item, (ViewGroup) this, true);
        this.kna = (ViewGroup) findViewById(R.id.rootLayout);
        this.kna.setOnClickListener(this);
        this.iMf = (TbImageView) findViewById(R.id.coverView);
        this.iMg = findViewById(R.id.coverGradientMask);
        this.iMh = findViewById(R.id.videoTimeContainer);
        this.iMi = (ImageView) findViewById(R.id.videoPlayIcon);
        this.iMj = (TextView) findViewById(R.id.videoPlayTime);
        this.jaP = (TextView) findViewById(R.id.descView);
        this.aiz = (TextView) findViewById(R.id.tagView);
        this.iMf.setPlaceHolder(2);
        this.iMf.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.iMf.setConrers(15);
    }

    public void setOnItemCoverListener(f<b> fVar) {
        this.ahY = fVar;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.knb = bVar;
            if (TextUtils.isEmpty(bVar.cover)) {
                this.iMf.setVisibility(8);
                this.iMg.setVisibility(8);
                this.iMh.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aiz.getLayoutParams();
                layoutParams.addRule(8, 0);
                layoutParams.addRule(3, R.id.descView);
                this.aiz.setLayoutParams(layoutParams);
            } else {
                this.iMf.startLoad(bVar.cover, 10, false);
                this.iMf.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aiz.getLayoutParams();
                layoutParams2.addRule(8, R.id.coverView);
                layoutParams2.addRule(3, 0);
                this.aiz.setLayoutParams(layoutParams2);
                if (bVar.time > 0) {
                    this.iMh.setVisibility(0);
                    this.iMg.setVisibility(0);
                    this.iMj.setText(StringUtils.translateSecondsToString(bVar.time));
                } else {
                    this.iMh.setVisibility(8);
                    this.iMg.setVisibility(8);
                }
            }
            this.jaP.setText(bVar.desc);
            String str = "" + this.aiz.getContext().getResources().getString(R.string.hot_topic_special_item_reply, at.numberUniformFormatExtra(bVar.atJ));
            String numberUniformFormatExtra = at.numberUniformFormatExtra(bVar.likeNum);
            if (str.length() > 0) {
                str = str + "  ";
            }
            this.aiz.setText(str + this.aiz.getContext().getResources().getString(R.string.hot_topic_special_item_like, numberUniformFormatExtra));
            setPadding(0, 0, 0, bVar.hOb ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40) : 0);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iLX != i) {
            a.g(this.kna, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.jaP, R.color.cp_cont_b);
            ap.setViewTextColor(this.aiz, R.color.cp_cont_d);
            ap.setViewTextColor(this.iMj, R.color.cp_cont_a);
            this.iMi.setImageDrawable(SvgManager.bjq().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
            this.iLX = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.knb != null && this.knb.dUW != null) {
            if (this.ahY != null) {
                this.ahY.a(view, this.knb, 0, 0L);
            }
            ay.a((AbsThreadDataSupport) this.knb.dUW, view.getContext(), 17, false);
        }
    }
}
