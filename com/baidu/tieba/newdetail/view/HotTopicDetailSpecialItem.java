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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.e.a;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.newdetail.a.b;
/* loaded from: classes21.dex */
public class HotTopicDetailSpecialItem extends RelativeLayout implements View.OnClickListener {
    private f<b> ajQ;
    private TextView akq;
    private TbImageView jQC;
    private View jQD;
    private View jQE;
    private ImageView jQF;
    private TextView jQG;
    private int jQu;
    private TextView kfe;
    private ViewGroup lqW;
    private b lqX;

    public HotTopicDetailSpecialItem(Context context) {
        super(context);
        this.jQu = 3;
        initView();
    }

    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jQu = 3;
        initView();
    }

    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jQu = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_special_item, (ViewGroup) this, true);
        this.lqW = (ViewGroup) findViewById(R.id.rootLayout);
        this.lqW.setOnClickListener(this);
        this.jQC = (TbImageView) findViewById(R.id.coverView);
        this.jQD = findViewById(R.id.coverGradientMask);
        this.jQE = findViewById(R.id.videoTimeContainer);
        this.jQF = (ImageView) findViewById(R.id.videoPlayIcon);
        this.jQG = (TextView) findViewById(R.id.videoPlayTime);
        this.kfe = (TextView) findViewById(R.id.descView);
        this.akq = (TextView) findViewById(R.id.tagView);
        this.jQC.setPlaceHolder(2);
        this.jQC.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.jQC.setConrers(15);
    }

    public void setOnItemCoverListener(f<b> fVar) {
        this.ajQ = fVar;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.lqX = bVar;
            if (TextUtils.isEmpty(bVar.cover)) {
                this.jQC.setVisibility(8);
                this.jQD.setVisibility(8);
                this.jQE.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.akq.getLayoutParams();
                layoutParams.addRule(8, 0);
                layoutParams.addRule(3, R.id.descView);
                this.akq.setLayoutParams(layoutParams);
            } else {
                this.jQC.startLoad(bVar.cover, 10, false);
                this.jQC.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.akq.getLayoutParams();
                layoutParams2.addRule(8, R.id.coverView);
                layoutParams2.addRule(3, 0);
                this.akq.setLayoutParams(layoutParams2);
                if (bVar.time > 0) {
                    this.jQE.setVisibility(0);
                    this.jQD.setVisibility(0);
                    this.jQG.setText(StringUtils.translateSecondsToString(bVar.time));
                } else {
                    this.jQE.setVisibility(8);
                    this.jQD.setVisibility(8);
                }
            }
            this.kfe.setText(bVar.desc);
            String str = "" + this.akq.getContext().getResources().getString(R.string.hot_topic_special_item_reply, au.numberUniformFormatExtra(bVar.inN));
            String numberUniformFormatExtra = au.numberUniformFormatExtra(bVar.likeNum);
            if (str.length() > 0) {
                str = str + "  ";
            }
            this.akq.setText(str + this.akq.getContext().getResources().getString(R.string.hot_topic_special_item_like, numberUniformFormatExtra));
            setPadding(0, 0, 0, bVar.iOc ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40) : 0);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jQu != i) {
            a.g(this.lqW, R.color.CAM_X0205, R.color.CAM_X0204);
            ap.setViewTextColor(this.kfe, R.color.CAM_X0105);
            ap.setViewTextColor(this.akq, R.color.CAM_X0109);
            ap.setViewTextColor(this.jQG, R.color.CAM_X0101);
            this.jQF.setImageDrawable(SvgManager.btW().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
            this.jQu = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.lqX != null && this.lqX.eCR != null) {
            if (this.ajQ != null) {
                this.ajQ.a(view, this.lqX, 0, 0L);
            }
            az.a((com.baidu.tbadk.core.data.a) this.lqX.eCR, view.getContext(), 17, false);
        }
    }
}
