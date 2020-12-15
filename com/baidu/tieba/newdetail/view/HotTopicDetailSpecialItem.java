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
    private TbImageView jQE;
    private View jQF;
    private View jQG;
    private ImageView jQH;
    private TextView jQI;
    private int jQw;
    private TextView kfg;
    private ViewGroup lqY;
    private b lqZ;

    public HotTopicDetailSpecialItem(Context context) {
        super(context);
        this.jQw = 3;
        initView();
    }

    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jQw = 3;
        initView();
    }

    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jQw = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_special_item, (ViewGroup) this, true);
        this.lqY = (ViewGroup) findViewById(R.id.rootLayout);
        this.lqY.setOnClickListener(this);
        this.jQE = (TbImageView) findViewById(R.id.coverView);
        this.jQF = findViewById(R.id.coverGradientMask);
        this.jQG = findViewById(R.id.videoTimeContainer);
        this.jQH = (ImageView) findViewById(R.id.videoPlayIcon);
        this.jQI = (TextView) findViewById(R.id.videoPlayTime);
        this.kfg = (TextView) findViewById(R.id.descView);
        this.akq = (TextView) findViewById(R.id.tagView);
        this.jQE.setPlaceHolder(2);
        this.jQE.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.jQE.setConrers(15);
    }

    public void setOnItemCoverListener(f<b> fVar) {
        this.ajQ = fVar;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.lqZ = bVar;
            if (TextUtils.isEmpty(bVar.cover)) {
                this.jQE.setVisibility(8);
                this.jQF.setVisibility(8);
                this.jQG.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.akq.getLayoutParams();
                layoutParams.addRule(8, 0);
                layoutParams.addRule(3, R.id.descView);
                this.akq.setLayoutParams(layoutParams);
            } else {
                this.jQE.startLoad(bVar.cover, 10, false);
                this.jQE.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.akq.getLayoutParams();
                layoutParams2.addRule(8, R.id.coverView);
                layoutParams2.addRule(3, 0);
                this.akq.setLayoutParams(layoutParams2);
                if (bVar.time > 0) {
                    this.jQG.setVisibility(0);
                    this.jQF.setVisibility(0);
                    this.jQI.setText(StringUtils.translateSecondsToString(bVar.time));
                } else {
                    this.jQG.setVisibility(8);
                    this.jQF.setVisibility(8);
                }
            }
            this.kfg.setText(bVar.desc);
            String str = "" + this.akq.getContext().getResources().getString(R.string.hot_topic_special_item_reply, au.numberUniformFormatExtra(bVar.inP));
            String numberUniformFormatExtra = au.numberUniformFormatExtra(bVar.likeNum);
            if (str.length() > 0) {
                str = str + "  ";
            }
            this.akq.setText(str + this.akq.getContext().getResources().getString(R.string.hot_topic_special_item_like, numberUniformFormatExtra));
            setPadding(0, 0, 0, bVar.iOe ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40) : 0);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jQw != i) {
            a.g(this.lqY, R.color.CAM_X0205, R.color.CAM_X0204);
            ap.setViewTextColor(this.kfg, R.color.CAM_X0105);
            ap.setViewTextColor(this.akq, R.color.CAM_X0109);
            ap.setViewTextColor(this.jQI, R.color.CAM_X0101);
            this.jQH.setImageDrawable(SvgManager.btW().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
            this.jQw = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.lqZ != null && this.lqZ.eCR != null) {
            if (this.ajQ != null) {
                this.ajQ.a(view, this.lqZ, 0, 0L);
            }
            az.a((com.baidu.tbadk.core.data.a) this.lqZ.eCR, view.getContext(), 17, false);
        }
    }
}
