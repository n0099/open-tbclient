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
/* loaded from: classes20.dex */
public class HotTopicDetailSpecialItem extends RelativeLayout implements View.OnClickListener {
    private f<b> aiR;
    private TextView ajr;
    private int jCS;
    private TbImageView jDa;
    private View jDb;
    private View jDc;
    private ImageView jDd;
    private TextView jDe;
    private TextView jRA;
    private ViewGroup ldw;
    private b ldx;

    public HotTopicDetailSpecialItem(Context context) {
        super(context);
        this.jCS = 3;
        initView();
    }

    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jCS = 3;
        initView();
    }

    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jCS = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_special_item, (ViewGroup) this, true);
        this.ldw = (ViewGroup) findViewById(R.id.rootLayout);
        this.ldw.setOnClickListener(this);
        this.jDa = (TbImageView) findViewById(R.id.coverView);
        this.jDb = findViewById(R.id.coverGradientMask);
        this.jDc = findViewById(R.id.videoTimeContainer);
        this.jDd = (ImageView) findViewById(R.id.videoPlayIcon);
        this.jDe = (TextView) findViewById(R.id.videoPlayTime);
        this.jRA = (TextView) findViewById(R.id.descView);
        this.ajr = (TextView) findViewById(R.id.tagView);
        this.jDa.setPlaceHolder(2);
        this.jDa.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.jDa.setConrers(15);
    }

    public void setOnItemCoverListener(f<b> fVar) {
        this.aiR = fVar;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.ldx = bVar;
            if (TextUtils.isEmpty(bVar.cover)) {
                this.jDa.setVisibility(8);
                this.jDb.setVisibility(8);
                this.jDc.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ajr.getLayoutParams();
                layoutParams.addRule(8, 0);
                layoutParams.addRule(3, R.id.descView);
                this.ajr.setLayoutParams(layoutParams);
            } else {
                this.jDa.startLoad(bVar.cover, 10, false);
                this.jDa.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ajr.getLayoutParams();
                layoutParams2.addRule(8, R.id.coverView);
                layoutParams2.addRule(3, 0);
                this.ajr.setLayoutParams(layoutParams2);
                if (bVar.time > 0) {
                    this.jDc.setVisibility(0);
                    this.jDb.setVisibility(0);
                    this.jDe.setText(StringUtils.translateSecondsToString(bVar.time));
                } else {
                    this.jDc.setVisibility(8);
                    this.jDb.setVisibility(8);
                }
            }
            this.jRA.setText(bVar.desc);
            String str = "" + this.ajr.getContext().getResources().getString(R.string.hot_topic_special_item_reply, au.numberUniformFormatExtra(bVar.icP));
            String numberUniformFormatExtra = au.numberUniformFormatExtra(bVar.likeNum);
            if (str.length() > 0) {
                str = str + "  ";
            }
            this.ajr.setText(str + this.ajr.getContext().getResources().getString(R.string.hot_topic_special_item_like, numberUniformFormatExtra));
            setPadding(0, 0, 0, bVar.iDk ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40) : 0);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jCS != i) {
            a.h(this.ldw, R.color.CAM_X0205, R.color.CAM_X0204);
            ap.setViewTextColor(this.jRA, R.color.CAM_X0105);
            ap.setViewTextColor(this.ajr, R.color.CAM_X0109);
            ap.setViewTextColor(this.jDe, R.color.CAM_X0101);
            this.jDd.setImageDrawable(SvgManager.bqB().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
            this.jCS = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ldx != null && this.ldx.evQ != null) {
            if (this.aiR != null) {
                this.aiR.a(view, this.ldx, 0, 0L);
            }
            az.a((com.baidu.tbadk.core.data.a) this.ldx.evQ, view.getContext(), 17, false);
        }
    }
}
