package com.baidu.tieba.themeCenter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class MemberRecommendView extends FrameLayout {
    private TextView Yh;
    private TextView bxl;
    private TbImageView dLc;
    private com.baidu.tieba.themeCenter.dressCenter.k dLd;
    private int fromType;
    private Context mContext;
    private View mRootView;

    public MemberRecommendView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    public MemberRecommendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    public MemberRecommendView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(n.h.member_extend_view, this);
        this.dLc = (TbImageView) this.mRootView.findViewById(n.g.vip_icon);
        this.dLc.setDefaultResource(n.f.icon_vip_orange);
        this.dLc.setDefaultBgResource(n.f.transparent_bg);
        this.Yh = (TextView) this.mRootView.findViewById(n.g.title_view);
        this.bxl = (TextView) this.mRootView.findViewById(n.g.jump_button);
        this.bxl.setOnClickListener(new a(this));
    }

    public void a(com.baidu.tieba.themeCenter.dressCenter.k kVar) {
        if (kVar != null) {
            this.dLd = kVar;
            this.dLc.d(this.dLd.getIconUrl(), 10, false);
            this.Yh.setText(this.dLd.aHL());
            if (StringUtils.isNull(this.dLd.YK())) {
                this.bxl.setVisibility(8);
                return;
            }
            this.bxl.setVisibility(0);
            this.bxl.setText(this.dLd.YK());
        }
    }

    public void vR() {
        TbPageContext tbPageContext = (TbPageContext) com.baidu.adp.base.l.C(this.mContext);
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ac(TbadkApplication.getInst().getSkinType() == 1);
            tbPageContext.getLayoutMode().k(this.mRootView);
        }
    }

    public int getFromType() {
        return this.fromType;
    }

    public void setFromType(int i) {
        this.fromType = i;
    }
}
