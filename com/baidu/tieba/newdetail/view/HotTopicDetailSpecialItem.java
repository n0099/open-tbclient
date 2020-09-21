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
/* loaded from: classes20.dex */
public class HotTopicDetailSpecialItem extends RelativeLayout implements View.OnClickListener {
    private TextView aiT;
    private f<b> ait;
    private int iUD;
    private TbImageView iUL;
    private View iUM;
    private View iUN;
    private ImageView iUO;
    private TextView iUP;
    private TextView jjv;
    private b kvA;
    private ViewGroup kvz;

    public HotTopicDetailSpecialItem(Context context) {
        super(context);
        this.iUD = 3;
        initView();
    }

    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iUD = 3;
        initView();
    }

    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iUD = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_special_item, (ViewGroup) this, true);
        this.kvz = (ViewGroup) findViewById(R.id.rootLayout);
        this.kvz.setOnClickListener(this);
        this.iUL = (TbImageView) findViewById(R.id.coverView);
        this.iUM = findViewById(R.id.coverGradientMask);
        this.iUN = findViewById(R.id.videoTimeContainer);
        this.iUO = (ImageView) findViewById(R.id.videoPlayIcon);
        this.iUP = (TextView) findViewById(R.id.videoPlayTime);
        this.jjv = (TextView) findViewById(R.id.descView);
        this.aiT = (TextView) findViewById(R.id.tagView);
        this.iUL.setPlaceHolder(2);
        this.iUL.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.iUL.setConrers(15);
    }

    public void setOnItemCoverListener(f<b> fVar) {
        this.ait = fVar;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.kvA = bVar;
            if (TextUtils.isEmpty(bVar.cover)) {
                this.iUL.setVisibility(8);
                this.iUM.setVisibility(8);
                this.iUN.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aiT.getLayoutParams();
                layoutParams.addRule(8, 0);
                layoutParams.addRule(3, R.id.descView);
                this.aiT.setLayoutParams(layoutParams);
            } else {
                this.iUL.startLoad(bVar.cover, 10, false);
                this.iUL.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aiT.getLayoutParams();
                layoutParams2.addRule(8, R.id.coverView);
                layoutParams2.addRule(3, 0);
                this.aiT.setLayoutParams(layoutParams2);
                if (bVar.time > 0) {
                    this.iUN.setVisibility(0);
                    this.iUM.setVisibility(0);
                    this.iUP.setText(StringUtils.translateSecondsToString(bVar.time));
                } else {
                    this.iUN.setVisibility(8);
                    this.iUM.setVisibility(8);
                }
            }
            this.jjv.setText(bVar.desc);
            String str = "" + this.aiT.getContext().getResources().getString(R.string.hot_topic_special_item_reply, at.numberUniformFormatExtra(bVar.aul));
            String numberUniformFormatExtra = at.numberUniformFormatExtra(bVar.likeNum);
            if (str.length() > 0) {
                str = str + "  ";
            }
            this.aiT.setText(str + this.aiT.getContext().getResources().getString(R.string.hot_topic_special_item_like, numberUniformFormatExtra));
            setPadding(0, 0, 0, bVar.hVb ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40) : 0);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iUD != i) {
            a.g(this.kvz, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.jjv, R.color.cp_cont_b);
            ap.setViewTextColor(this.aiT, R.color.cp_cont_d);
            ap.setViewTextColor(this.iUP, R.color.cp_cont_a);
            this.iUO.setImageDrawable(SvgManager.bkl().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
            this.iUD = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kvA != null && this.kvA.dXg != null) {
            if (this.ait != null) {
                this.ait.a(view, this.kvA, 0, 0L);
            }
            ay.a((AbsThreadDataSupport) this.kvA.dXg, view.getContext(), 17, false);
        }
    }
}
