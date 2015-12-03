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
    private TextView XE;
    private TextView btu;
    private TbImageView dDy;
    private com.baidu.tieba.themeCenter.dressCenter.k dDz;
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
        this.mRootView = LayoutInflater.from(this.mContext).inflate(n.g.member_extend_view, this);
        this.dDy = (TbImageView) this.mRootView.findViewById(n.f.vip_icon);
        this.dDy.setDefaultResource(n.e.icon_vip_orange);
        this.dDy.setDefaultBgResource(n.e.transparent_bg);
        this.XE = (TextView) this.mRootView.findViewById(n.f.title_view);
        this.btu = (TextView) this.mRootView.findViewById(n.f.jump_button);
        this.btu.setOnClickListener(new a(this));
    }

    public void a(com.baidu.tieba.themeCenter.dressCenter.k kVar) {
        if (kVar != null) {
            this.dDz = kVar;
            this.dDy.d(this.dDz.getIconUrl(), 10, false);
            this.XE.setText(this.dDz.aFw());
            if (StringUtils.isNull(this.dDz.XF())) {
                this.btu.setVisibility(8);
                return;
            }
            this.btu.setVisibility(0);
            this.btu.setText(this.dDz.XF());
        }
    }

    public void wh() {
        TbPageContext tbPageContext = (TbPageContext) com.baidu.adp.base.l.C(this.mContext);
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().af(TbadkApplication.getInst().getSkinType() == 1);
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
