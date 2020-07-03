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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.e.a;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.newdetail.a.b;
/* loaded from: classes8.dex */
public class HotTopicDetailSpecialItem extends RelativeLayout implements View.OnClickListener {
    private f<b> agW;
    private TextView iFF;
    private int iqP;
    private TextView irc;
    private TbImageView iri;
    private View irj;
    private View irk;
    private ImageView irl;
    private TextView irm;
    private ViewGroup jOX;
    private b jOY;

    public HotTopicDetailSpecialItem(Context context) {
        super(context);
        this.iqP = 3;
        initView();
    }

    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iqP = 3;
        initView();
    }

    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iqP = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_special_item, (ViewGroup) this, true);
        this.jOX = (ViewGroup) findViewById(R.id.rootLayout);
        this.jOX.setOnClickListener(this);
        this.iri = (TbImageView) findViewById(R.id.coverView);
        this.irj = findViewById(R.id.coverGradientMask);
        this.irk = findViewById(R.id.videoTimeContainer);
        this.irl = (ImageView) findViewById(R.id.videoPlayIcon);
        this.irm = (TextView) findViewById(R.id.videoPlayTime);
        this.iFF = (TextView) findViewById(R.id.descView);
        this.irc = (TextView) findViewById(R.id.tagView);
        this.iri.setPlaceHolder(2);
        this.iri.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.iri.setConrers(15);
    }

    public void setOnItemCoverListener(f<b> fVar) {
        this.agW = fVar;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.jOY = bVar;
            if (TextUtils.isEmpty(bVar.cover)) {
                this.iri.setVisibility(8);
                this.irj.setVisibility(8);
                this.irk.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.irc.getLayoutParams();
                layoutParams.addRule(8, 0);
                layoutParams.addRule(3, R.id.descView);
                this.irc.setLayoutParams(layoutParams);
            } else {
                this.iri.startLoad(bVar.cover, 10, false);
                this.iri.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.irc.getLayoutParams();
                layoutParams2.addRule(8, R.id.coverView);
                layoutParams2.addRule(3, 0);
                this.irc.setLayoutParams(layoutParams2);
                if (bVar.time > 0) {
                    this.irk.setVisibility(0);
                    this.irj.setVisibility(0);
                    this.irm.setText(StringUtils.translateSecondsToString(bVar.time));
                } else {
                    this.irk.setVisibility(8);
                    this.irj.setVisibility(8);
                }
            }
            this.iFF.setText(bVar.desc);
            String str = "" + this.irc.getContext().getResources().getString(R.string.hot_topic_special_item_reply, ar.numberUniformFormatExtra(bVar.aoN));
            String numberUniformFormatExtra = ar.numberUniformFormatExtra(bVar.likeNum);
            if (str.length() > 0) {
                str = str + "  ";
            }
            this.irc.setText(str + this.irc.getContext().getResources().getString(R.string.hot_topic_special_item_like, numberUniformFormatExtra));
            setPadding(0, 0, 0, bVar.isLast ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40) : 0);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iqP != i) {
            a.f(this.jOX, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
            an.setViewTextColor(this.iFF, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.irc, (int) R.color.cp_cont_d);
            an.setViewTextColor(this.irm, (int) R.color.cp_cont_a);
            this.irl.setImageDrawable(SvgManager.aWQ().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
            this.iqP = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jOY != null && this.jOY.dLi != null) {
            if (this.agW != null) {
                this.agW.a(view, this.jOY, 0, 0L);
            }
            aw.a((AbsThreadDataSupport) this.jOY.dLi, view.getContext(), 17, false);
        }
    }
}
