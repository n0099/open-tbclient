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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.e.a;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.newdetail.a.b;
/* loaded from: classes15.dex */
public class HotTopicDetailSpecialItem extends RelativeLayout implements View.OnClickListener {
    private f<b> agN;
    private TextView iLL;
    private int iwV;
    private TextView ixi;
    private TbImageView ixo;
    private View ixp;
    private View ixq;
    private ImageView ixr;
    private TextView ixs;
    private ViewGroup jXx;
    private b jXy;

    public HotTopicDetailSpecialItem(Context context) {
        super(context);
        this.iwV = 3;
        initView();
    }

    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iwV = 3;
        initView();
    }

    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iwV = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_special_item, (ViewGroup) this, true);
        this.jXx = (ViewGroup) findViewById(R.id.rootLayout);
        this.jXx.setOnClickListener(this);
        this.ixo = (TbImageView) findViewById(R.id.coverView);
        this.ixp = findViewById(R.id.coverGradientMask);
        this.ixq = findViewById(R.id.videoTimeContainer);
        this.ixr = (ImageView) findViewById(R.id.videoPlayIcon);
        this.ixs = (TextView) findViewById(R.id.videoPlayTime);
        this.iLL = (TextView) findViewById(R.id.descView);
        this.ixi = (TextView) findViewById(R.id.tagView);
        this.ixo.setPlaceHolder(2);
        this.ixo.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.ixo.setConrers(15);
    }

    public void setOnItemCoverListener(f<b> fVar) {
        this.agN = fVar;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.jXy = bVar;
            if (TextUtils.isEmpty(bVar.cover)) {
                this.ixo.setVisibility(8);
                this.ixp.setVisibility(8);
                this.ixq.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ixi.getLayoutParams();
                layoutParams.addRule(8, 0);
                layoutParams.addRule(3, R.id.descView);
                this.ixi.setLayoutParams(layoutParams);
            } else {
                this.ixo.startLoad(bVar.cover, 10, false);
                this.ixo.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ixi.getLayoutParams();
                layoutParams2.addRule(8, R.id.coverView);
                layoutParams2.addRule(3, 0);
                this.ixi.setLayoutParams(layoutParams2);
                if (bVar.time > 0) {
                    this.ixq.setVisibility(0);
                    this.ixp.setVisibility(0);
                    this.ixs.setText(StringUtils.translateSecondsToString(bVar.time));
                } else {
                    this.ixq.setVisibility(8);
                    this.ixp.setVisibility(8);
                }
            }
            this.iLL.setText(bVar.desc);
            String str = "" + this.ixi.getContext().getResources().getString(R.string.hot_topic_special_item_reply, as.numberUniformFormatExtra(bVar.aoJ));
            String numberUniformFormatExtra = as.numberUniformFormatExtra(bVar.likeNum);
            if (str.length() > 0) {
                str = str + "  ";
            }
            this.ixi.setText(str + this.ixi.getContext().getResources().getString(R.string.hot_topic_special_item_like, numberUniformFormatExtra));
            setPadding(0, 0, 0, bVar.isLast ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40) : 0);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iwV != i) {
            a.h(this.jXx, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
            ao.setViewTextColor(this.iLL, R.color.cp_cont_b);
            ao.setViewTextColor(this.ixi, R.color.cp_cont_d);
            ao.setViewTextColor(this.ixs, R.color.cp_cont_a);
            this.ixr.setImageDrawable(SvgManager.baR().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
            this.iwV = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jXy != null && this.jXy.dLK != null) {
            if (this.agN != null) {
                this.agN.a(view, this.jXy, 0, 0L);
            }
            ax.a((AbsThreadDataSupport) this.jXy.dLK, view.getContext(), 17, false);
        }
    }
}
