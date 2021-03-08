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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.f.a;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.newdetail.a.b;
/* loaded from: classes7.dex */
public class HotTopicDetailSpecialItem extends RelativeLayout implements View.OnClickListener {
    private f<b> akI;
    private TextView ali;
    private int kiZ;
    private TbImageView kjh;
    private View kji;
    private View kjj;
    private ImageView kjk;
    private TextView kjl;
    private TextView kyk;
    private ViewGroup lBV;
    private b lBW;

    public HotTopicDetailSpecialItem(Context context) {
        super(context);
        this.kiZ = 3;
        initView();
    }

    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kiZ = 3;
        initView();
    }

    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kiZ = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_special_item, (ViewGroup) this, true);
        this.lBV = (ViewGroup) findViewById(R.id.rootLayout);
        this.lBV.setOnClickListener(this);
        this.kjh = (TbImageView) findViewById(R.id.coverView);
        this.kji = findViewById(R.id.coverGradientMask);
        this.kjj = findViewById(R.id.videoTimeContainer);
        this.kjk = (ImageView) findViewById(R.id.videoPlayIcon);
        this.kjl = (TextView) findViewById(R.id.videoPlayTime);
        this.kyk = (TextView) findViewById(R.id.descView);
        this.ali = (TextView) findViewById(R.id.tagView);
        this.kjh.setPlaceHolder(2);
        this.kjh.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.kjh.setConrers(15);
    }

    public void setOnItemCoverListener(f<b> fVar) {
        this.akI = fVar;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.lBW = bVar;
            if (TextUtils.isEmpty(bVar.cover)) {
                this.kjh.setVisibility(8);
                this.kji.setVisibility(8);
                this.kjj.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ali.getLayoutParams();
                layoutParams.addRule(8, 0);
                layoutParams.addRule(3, R.id.descView);
                this.ali.setLayoutParams(layoutParams);
            } else {
                this.kjh.startLoad(bVar.cover, 10, false);
                this.kjh.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ali.getLayoutParams();
                layoutParams2.addRule(8, R.id.coverView);
                layoutParams2.addRule(3, 0);
                this.ali.setLayoutParams(layoutParams2);
                if (bVar.time > 0) {
                    this.kjj.setVisibility(0);
                    this.kji.setVisibility(0);
                    this.kjl.setText(StringUtils.translateSecondsToString(bVar.time));
                } else {
                    this.kjj.setVisibility(8);
                    this.kji.setVisibility(8);
                }
            }
            this.kyk.setText(bVar.desc);
            String str = "" + this.ali.getContext().getResources().getString(R.string.hot_topic_special_item_reply, au.numberUniformFormatExtra(bVar.iDj));
            String numberUniformFormatExtra = au.numberUniformFormatExtra(bVar.likeNum);
            if (str.length() > 0) {
                str = str + "  ";
            }
            this.ali.setText(str + this.ali.getContext().getResources().getString(R.string.hot_topic_special_item_like, numberUniformFormatExtra));
            setPadding(0, 0, 0, bVar.jdm ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40) : 0);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kiZ != i) {
            a.m(this.lBV, R.color.CAM_X0205, R.color.CAM_X0204);
            ap.setViewTextColor(this.kyk, R.color.CAM_X0105);
            ap.setViewTextColor(this.ali, R.color.CAM_X0109);
            ap.setViewTextColor(this.kjl, R.color.CAM_X0101);
            this.kjk.setImageDrawable(SvgManager.bsU().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
            this.kiZ = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.lBW != null && this.lBW.eLr != null) {
            if (this.akI != null) {
                this.akI.a(view, this.lBW, 0, 0L);
            }
            az.a((com.baidu.tbadk.core.data.a) this.lBW.eLr, view.getContext(), 17, false);
        }
    }
}
