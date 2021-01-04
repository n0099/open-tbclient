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
/* loaded from: classes8.dex */
public class HotTopicDetailSpecialItem extends RelativeLayout implements View.OnClickListener {
    private TextView akS;
    private f<b> aks;
    private int kdK;
    private TbImageView kdS;
    private View kdT;
    private View kdU;
    private ImageView kdV;
    private TextView kdW;
    private TextView kss;
    private ViewGroup lwg;
    private b lwh;

    public HotTopicDetailSpecialItem(Context context) {
        super(context);
        this.kdK = 3;
        initView();
    }

    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kdK = 3;
        initView();
    }

    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kdK = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_special_item, (ViewGroup) this, true);
        this.lwg = (ViewGroup) findViewById(R.id.rootLayout);
        this.lwg.setOnClickListener(this);
        this.kdS = (TbImageView) findViewById(R.id.coverView);
        this.kdT = findViewById(R.id.coverGradientMask);
        this.kdU = findViewById(R.id.videoTimeContainer);
        this.kdV = (ImageView) findViewById(R.id.videoPlayIcon);
        this.kdW = (TextView) findViewById(R.id.videoPlayTime);
        this.kss = (TextView) findViewById(R.id.descView);
        this.akS = (TextView) findViewById(R.id.tagView);
        this.kdS.setPlaceHolder(2);
        this.kdS.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.kdS.setConrers(15);
    }

    public void setOnItemCoverListener(f<b> fVar) {
        this.aks = fVar;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.lwh = bVar;
            if (TextUtils.isEmpty(bVar.cover)) {
                this.kdS.setVisibility(8);
                this.kdT.setVisibility(8);
                this.kdU.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.akS.getLayoutParams();
                layoutParams.addRule(8, 0);
                layoutParams.addRule(3, R.id.descView);
                this.akS.setLayoutParams(layoutParams);
            } else {
                this.kdS.startLoad(bVar.cover, 10, false);
                this.kdS.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.akS.getLayoutParams();
                layoutParams2.addRule(8, R.id.coverView);
                layoutParams2.addRule(3, 0);
                this.akS.setLayoutParams(layoutParams2);
                if (bVar.time > 0) {
                    this.kdU.setVisibility(0);
                    this.kdT.setVisibility(0);
                    this.kdW.setText(StringUtils.translateSecondsToString(bVar.time));
                } else {
                    this.kdU.setVisibility(8);
                    this.kdT.setVisibility(8);
                }
            }
            this.kss.setText(bVar.desc);
            String str = "" + this.akS.getContext().getResources().getString(R.string.hot_topic_special_item_reply, at.numberUniformFormatExtra(bVar.iAj));
            String numberUniformFormatExtra = at.numberUniformFormatExtra(bVar.likeNum);
            if (str.length() > 0) {
                str = str + "  ";
            }
            this.akS.setText(str + this.akS.getContext().getResources().getString(R.string.hot_topic_special_item_like, numberUniformFormatExtra));
            setPadding(0, 0, 0, bVar.jap ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40) : 0);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kdK != i) {
            a.m(this.lwg, R.color.CAM_X0205, R.color.CAM_X0204);
            ao.setViewTextColor(this.kss, R.color.CAM_X0105);
            ao.setViewTextColor(this.akS, R.color.CAM_X0109);
            ao.setViewTextColor(this.kdW, R.color.CAM_X0101);
            this.kdV.setImageDrawable(SvgManager.bwq().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
            this.kdK = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.lwh != null && this.lwh.eMv != null) {
            if (this.aks != null) {
                this.aks.a(view, this.lwh, 0, 0L);
            }
            ay.a((com.baidu.tbadk.core.data.a) this.lwh.eMv, view.getContext(), 17, false);
        }
    }
}
