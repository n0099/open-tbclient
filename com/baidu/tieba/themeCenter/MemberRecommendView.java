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
    private TextView WO;
    private TextView bll;
    private TbImageView dek;
    private com.baidu.tieba.themeCenter.dressCenter.k del;
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
        this.dek = (TbImageView) this.mRootView.findViewById(i.f.vip_icon);
        this.dek.setDefaultResource(i.e.icon_vip_orange);
        this.dek.setDefaultBgResource(i.e.transparent_bg);
        this.WO = (TextView) this.mRootView.findViewById(i.f.title_view);
        this.bll = (TextView) this.mRootView.findViewById(i.f.jump_button);
        this.bll.setOnClickListener(new a(this));
    }

    public void a(com.baidu.tieba.themeCenter.dressCenter.k kVar) {
        if (kVar != null) {
            this.del = kVar;
            this.dek.d(this.del.getIconUrl(), 10, false);
            this.WO.setText(this.del.azw());
            if (StringUtils.isNull(this.del.Ue())) {
                this.bll.setVisibility(8);
                return;
            }
            this.bll.setVisibility(0);
            this.bll.setText(this.del.Ue());
        }
    }

    public void vx() {
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
