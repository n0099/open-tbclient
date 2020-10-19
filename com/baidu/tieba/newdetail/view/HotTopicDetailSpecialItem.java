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
    private f<b> aiL;
    private TextView ajl;
    private int jjB;
    private TbImageView jjJ;
    private View jjK;
    private View jjL;
    private ImageView jjM;
    private TextView jjN;
    private TextView jyt;
    private ViewGroup kKL;
    private b kKM;

    public HotTopicDetailSpecialItem(Context context) {
        super(context);
        this.jjB = 3;
        initView();
    }

    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jjB = 3;
        initView();
    }

    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jjB = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_special_item, (ViewGroup) this, true);
        this.kKL = (ViewGroup) findViewById(R.id.rootLayout);
        this.kKL.setOnClickListener(this);
        this.jjJ = (TbImageView) findViewById(R.id.coverView);
        this.jjK = findViewById(R.id.coverGradientMask);
        this.jjL = findViewById(R.id.videoTimeContainer);
        this.jjM = (ImageView) findViewById(R.id.videoPlayIcon);
        this.jjN = (TextView) findViewById(R.id.videoPlayTime);
        this.jyt = (TextView) findViewById(R.id.descView);
        this.ajl = (TextView) findViewById(R.id.tagView);
        this.jjJ.setPlaceHolder(2);
        this.jjJ.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.jjJ.setConrers(15);
    }

    public void setOnItemCoverListener(f<b> fVar) {
        this.aiL = fVar;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.kKM = bVar;
            if (TextUtils.isEmpty(bVar.cover)) {
                this.jjJ.setVisibility(8);
                this.jjK.setVisibility(8);
                this.jjL.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ajl.getLayoutParams();
                layoutParams.addRule(8, 0);
                layoutParams.addRule(3, R.id.descView);
                this.ajl.setLayoutParams(layoutParams);
            } else {
                this.jjJ.startLoad(bVar.cover, 10, false);
                this.jjJ.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ajl.getLayoutParams();
                layoutParams2.addRule(8, R.id.coverView);
                layoutParams2.addRule(3, 0);
                this.ajl.setLayoutParams(layoutParams2);
                if (bVar.time > 0) {
                    this.jjL.setVisibility(0);
                    this.jjK.setVisibility(0);
                    this.jjN.setText(StringUtils.translateSecondsToString(bVar.time));
                } else {
                    this.jjL.setVisibility(8);
                    this.jjK.setVisibility(8);
                }
            }
            this.jyt.setText(bVar.desc);
            String str = "" + this.ajl.getContext().getResources().getString(R.string.hot_topic_special_item_reply, at.numberUniformFormatExtra(bVar.auU));
            String numberUniformFormatExtra = at.numberUniformFormatExtra(bVar.likeNum);
            if (str.length() > 0) {
                str = str + "  ";
            }
            this.ajl.setText(str + this.ajl.getContext().getResources().getString(R.string.hot_topic_special_item_like, numberUniformFormatExtra));
            setPadding(0, 0, 0, bVar.ika ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40) : 0);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jjB != i) {
            a.g(this.kKL, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.jyt, R.color.cp_cont_b);
            ap.setViewTextColor(this.ajl, R.color.cp_cont_d);
            ap.setViewTextColor(this.jjN, R.color.cp_cont_a);
            this.jjM.setImageDrawable(SvgManager.bmU().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
            this.jjB = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kKM != null && this.kKM.eji != null) {
            if (this.aiL != null) {
                this.aiL.a(view, this.kKM, 0, 0L);
            }
            ay.a((AbsThreadDataSupport) this.kKM.eji, view.getContext(), 17, false);
        }
    }
}
