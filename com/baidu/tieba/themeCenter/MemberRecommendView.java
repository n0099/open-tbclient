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
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class MemberRecommendView extends FrameLayout {
    private TextView WR;
    private TextView blP;
    private TbImageView dfQ;
    private com.baidu.tieba.themeCenter.dressCenter.k dfR;
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
        this.mRootView = LayoutInflater.from(this.mContext).inflate(i.g.member_extend_view, this);
        this.dfQ = (TbImageView) this.mRootView.findViewById(i.f.vip_icon);
        this.dfQ.setDefaultResource(i.e.icon_vip_orange);
        this.dfQ.setDefaultBgResource(i.e.transparent_bg);
        this.WR = (TextView) this.mRootView.findViewById(i.f.title_view);
        this.blP = (TextView) this.mRootView.findViewById(i.f.jump_button);
        this.blP.setOnClickListener(new a(this));
    }

    public void a(com.baidu.tieba.themeCenter.dressCenter.k kVar) {
        if (kVar != null) {
            this.dfR = kVar;
            this.dfQ.d(this.dfR.getIconUrl(), 10, false);
            this.WR.setText(this.dfR.aAm());
            if (StringUtils.isNull(this.dfR.Uz())) {
                this.blP.setVisibility(8);
                return;
            }
            this.blP.setVisibility(0);
            this.blP.setText(this.dfR.Uz());
        }
    }

    public void vB() {
        TbPageContext tbPageContext = (TbPageContext) com.baidu.adp.base.l.C(this.mContext);
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ad(TbadkApplication.getInst().getSkinType() == 1);
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
