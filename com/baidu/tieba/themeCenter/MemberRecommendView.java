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
    private TextView WM;
    private TextView bla;
    private TbImageView ddK;
    private com.baidu.tieba.themeCenter.dressCenter.k ddL;
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
        this.ddK = (TbImageView) this.mRootView.findViewById(i.f.vip_icon);
        this.ddK.setDefaultResource(i.e.icon_vip_orange);
        this.ddK.setDefaultBgResource(i.e.transparent_bg);
        this.WM = (TextView) this.mRootView.findViewById(i.f.title_view);
        this.bla = (TextView) this.mRootView.findViewById(i.f.jump_button);
        this.bla.setOnClickListener(new a(this));
    }

    public void a(com.baidu.tieba.themeCenter.dressCenter.k kVar) {
        if (kVar != null) {
            this.ddL = kVar;
            this.ddK.d(this.ddL.getIconUrl(), 10, false);
            this.WM.setText(this.ddL.azq());
            if (StringUtils.isNull(this.ddL.Ui())) {
                this.bla.setVisibility(8);
                return;
            }
            this.bla.setVisibility(0);
            this.bla.setText(this.ddL.Ui());
        }
    }

    public void vA() {
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
