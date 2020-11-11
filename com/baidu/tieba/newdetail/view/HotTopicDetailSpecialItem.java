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
/* loaded from: classes21.dex */
public class HotTopicDetailSpecialItem extends RelativeLayout implements View.OnClickListener {
    private f<b> aiM;
    private TextView ajm;
    private int jBV;
    private TbImageView jCd;
    private View jCe;
    private View jCf;
    private ImageView jCg;
    private TextView jCh;
    private TextView jQQ;
    private ViewGroup ldf;
    private b ldg;

    public HotTopicDetailSpecialItem(Context context) {
        super(context);
        this.jBV = 3;
        initView();
    }

    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jBV = 3;
        initView();
    }

    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jBV = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_special_item, (ViewGroup) this, true);
        this.ldf = (ViewGroup) findViewById(R.id.rootLayout);
        this.ldf.setOnClickListener(this);
        this.jCd = (TbImageView) findViewById(R.id.coverView);
        this.jCe = findViewById(R.id.coverGradientMask);
        this.jCf = findViewById(R.id.videoTimeContainer);
        this.jCg = (ImageView) findViewById(R.id.videoPlayIcon);
        this.jCh = (TextView) findViewById(R.id.videoPlayTime);
        this.jQQ = (TextView) findViewById(R.id.descView);
        this.ajm = (TextView) findViewById(R.id.tagView);
        this.jCd.setPlaceHolder(2);
        this.jCd.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.jCd.setConrers(15);
    }

    public void setOnItemCoverListener(f<b> fVar) {
        this.aiM = fVar;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.ldg = bVar;
            if (TextUtils.isEmpty(bVar.cover)) {
                this.jCd.setVisibility(8);
                this.jCe.setVisibility(8);
                this.jCf.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ajm.getLayoutParams();
                layoutParams.addRule(8, 0);
                layoutParams.addRule(3, R.id.descView);
                this.ajm.setLayoutParams(layoutParams);
            } else {
                this.jCd.startLoad(bVar.cover, 10, false);
                this.jCd.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ajm.getLayoutParams();
                layoutParams2.addRule(8, R.id.coverView);
                layoutParams2.addRule(3, 0);
                this.ajm.setLayoutParams(layoutParams2);
                if (bVar.time > 0) {
                    this.jCf.setVisibility(0);
                    this.jCe.setVisibility(0);
                    this.jCh.setText(StringUtils.translateSecondsToString(bVar.time));
                } else {
                    this.jCf.setVisibility(8);
                    this.jCe.setVisibility(8);
                }
            }
            this.jQQ.setText(bVar.desc);
            String str = "" + this.ajm.getContext().getResources().getString(R.string.hot_topic_special_item_reply, at.numberUniformFormatExtra(bVar.auV));
            String numberUniformFormatExtra = at.numberUniformFormatExtra(bVar.likeNum);
            if (str.length() > 0) {
                str = str + "  ";
            }
            this.ajm.setText(str + this.ajm.getContext().getResources().getString(R.string.hot_topic_special_item_like, numberUniformFormatExtra));
            setPadding(0, 0, 0, bVar.iCv ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40) : 0);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jBV != i) {
            a.g(this.ldf, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.jQQ, R.color.cp_cont_b);
            ap.setViewTextColor(this.ajm, R.color.cp_cont_d);
            ap.setViewTextColor(this.jCh, R.color.cp_cont_a);
            this.jCg.setImageDrawable(SvgManager.brn().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
            this.jBV = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ldg != null && this.ldg.exA != null) {
            if (this.aiM != null) {
                this.aiM.a(view, this.ldg, 0, 0L);
            }
            ay.a((AbsThreadDataSupport) this.ldg.exA, view.getContext(), 17, false);
        }
    }
}
