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
    private TextView iLJ;
    private int iwT;
    private TextView ixg;
    private TbImageView ixm;
    private View ixn;
    private View ixo;
    private ImageView ixp;
    private TextView ixq;
    private ViewGroup jXv;
    private b jXw;

    public HotTopicDetailSpecialItem(Context context) {
        super(context);
        this.iwT = 3;
        initView();
    }

    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iwT = 3;
        initView();
    }

    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iwT = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_special_item, (ViewGroup) this, true);
        this.jXv = (ViewGroup) findViewById(R.id.rootLayout);
        this.jXv.setOnClickListener(this);
        this.ixm = (TbImageView) findViewById(R.id.coverView);
        this.ixn = findViewById(R.id.coverGradientMask);
        this.ixo = findViewById(R.id.videoTimeContainer);
        this.ixp = (ImageView) findViewById(R.id.videoPlayIcon);
        this.ixq = (TextView) findViewById(R.id.videoPlayTime);
        this.iLJ = (TextView) findViewById(R.id.descView);
        this.ixg = (TextView) findViewById(R.id.tagView);
        this.ixm.setPlaceHolder(2);
        this.ixm.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.ixm.setConrers(15);
    }

    public void setOnItemCoverListener(f<b> fVar) {
        this.agN = fVar;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.jXw = bVar;
            if (TextUtils.isEmpty(bVar.cover)) {
                this.ixm.setVisibility(8);
                this.ixn.setVisibility(8);
                this.ixo.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ixg.getLayoutParams();
                layoutParams.addRule(8, 0);
                layoutParams.addRule(3, R.id.descView);
                this.ixg.setLayoutParams(layoutParams);
            } else {
                this.ixm.startLoad(bVar.cover, 10, false);
                this.ixm.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ixg.getLayoutParams();
                layoutParams2.addRule(8, R.id.coverView);
                layoutParams2.addRule(3, 0);
                this.ixg.setLayoutParams(layoutParams2);
                if (bVar.time > 0) {
                    this.ixo.setVisibility(0);
                    this.ixn.setVisibility(0);
                    this.ixq.setText(StringUtils.translateSecondsToString(bVar.time));
                } else {
                    this.ixo.setVisibility(8);
                    this.ixn.setVisibility(8);
                }
            }
            this.iLJ.setText(bVar.desc);
            String str = "" + this.ixg.getContext().getResources().getString(R.string.hot_topic_special_item_reply, as.numberUniformFormatExtra(bVar.aoJ));
            String numberUniformFormatExtra = as.numberUniformFormatExtra(bVar.likeNum);
            if (str.length() > 0) {
                str = str + "  ";
            }
            this.ixg.setText(str + this.ixg.getContext().getResources().getString(R.string.hot_topic_special_item_like, numberUniformFormatExtra));
            setPadding(0, 0, 0, bVar.isLast ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40) : 0);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iwT != i) {
            a.h(this.jXv, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
            ao.setViewTextColor(this.iLJ, R.color.cp_cont_b);
            ao.setViewTextColor(this.ixg, R.color.cp_cont_d);
            ao.setViewTextColor(this.ixq, R.color.cp_cont_a);
            this.ixp.setImageDrawable(SvgManager.baR().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
            this.iwT = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jXw != null && this.jXw.dLK != null) {
            if (this.agN != null) {
                this.agN.a(view, this.jXw, 0, 0L);
            }
            ax.a((AbsThreadDataSupport) this.jXw.dLK, view.getContext(), 17, false);
        }
    }
}
