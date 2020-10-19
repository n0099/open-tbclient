package com.baidu.tieba.personPolymeric.view;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.constant.PersonStatus;
/* loaded from: classes24.dex */
public class k {
    private RelativeLayout fZk;
    private View fZl;
    private TextView fZn;
    private ImageView fZo;
    private View lOp;
    private ImageView lOq;
    private ImageView lOr;
    private com.baidu.tieba.view.f lOs;
    private PersonStatus lOt;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private int mStatusBarHeight;
    private UserData mUserData;

    public k(TbPageContext tbPageContext, View view, View view2, boolean z) {
        this(tbPageContext, view, z);
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.lOp = view2;
        PW();
    }

    public k(TbPageContext tbPageContext, View view, boolean z) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.fZk = (RelativeLayout) view.findViewById(R.id.person_center_nav_layout);
        this.fZl = view.findViewById(R.id.person_center_nav_bg);
        this.fZn = (TextView) view.findViewById(R.id.person_center_nav_title);
        this.fZo = (ImageView) view.findViewById(R.id.person_center_nav_back_img);
        this.fZo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (k.this.lOs == null) {
                    if (k.this.mPageContext != null) {
                        k.this.mPageContext.getPageActivity().finish();
                        return;
                    }
                    return;
                }
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.iaq = 8;
                k.this.lOs.a(view2, bVar);
            }
        });
        this.lOq = (ImageView) view.findViewById(R.id.person_center_nav_chat_img);
        this.lOq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new aq("c12503").dK("obj_locate", "1"));
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.iaq = 40;
                bVar.iar = new Bundle();
                bVar.iar.putSerializable(UserData.TYPE_USER, k.this.mUserData);
                if (k.this.lOs != null) {
                    k.this.lOs.a(view2, bVar);
                }
            }
        });
        this.lOr = (ImageView) view.findViewById(R.id.person_center_nav_more_img);
        this.lOr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TiebaStatic.log(new aq("c12503").dK("obj_locate", "2"));
                    if (k.this.lOs != null) {
                        com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                        bVar.iaq = 9;
                        k.this.lOs.a(view2, bVar);
                    }
                }
            }
        });
    }

    private void PW() {
        if (this.lOp != null) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                ViewGroup.LayoutParams layoutParams = this.lOp.getLayoutParams();
                layoutParams.height = this.mStatusBarHeight;
                this.lOp.setLayoutParams(layoutParams);
                return;
            }
            this.lOp.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, PersonStatus personStatus) {
        if (aVar != null && aVar.getUserData() != null) {
            this.mUserData = aVar.getUserData();
            this.fZn.setText(this.mUserData.getName_show());
        }
        this.lOt = personStatus;
        dqH();
    }

    public void a(PersonStatus personStatus) {
        this.lOt = personStatus;
        dqH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dqH() {
        if (this.mIsHost) {
            this.lOr.setVisibility(8);
            this.lOq.setVisibility(8);
        } else if (TbadkCoreApplication.isLogin()) {
            this.lOq.setVisibility(0);
            this.lOr.setVisibility(0);
        } else {
            this.lOr.setVisibility(8);
            this.lOq.setVisibility(8);
        }
    }

    public View dqI() {
        return this.fZk;
    }

    public boolean dqJ() {
        return this.mIsHost;
    }

    public void aG(float f) {
        float f2;
        float f3 = 1.0f;
        if (f >= 0.0f || f <= 1.0f) {
            if (this.lOp != null) {
                this.lOp.setAlpha(f);
            }
            this.fZl.setAlpha(f);
            this.fZn.setAlpha(f);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 <= 1.0f) {
            f3 = f2 < 0.0f ? 0.0f : f2;
        }
        this.fZo.setAlpha(f3);
        this.lOr.setAlpha(f3);
        this.lOq.setAlpha(f3);
    }

    public void vG(boolean z) {
        if (z) {
            this.fZl.setVisibility(8);
            this.fZn.setVisibility(8);
            return;
        }
        this.fZl.setVisibility(0);
        this.fZn.setVisibility(0);
    }

    public void vH(boolean z) {
        if (this.fZo != null) {
            if (z) {
                SvgManager.bmU().a(this.fZo, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bmU().a(this.lOr, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bmU().a(this.lOq, R.drawable.icon_pure_topbar_createchat44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return;
            }
            SvgManager.bmU().a(this.fZo, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bmU().a(this.lOr, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bmU().a(this.lOq, R.drawable.icon_pure_topbar_createchat44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lOp != null) {
            ap.setBackgroundColor(this.lOp, R.color.cp_bg_line_d);
        }
        ap.setBackgroundColor(this.fZl, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.fZn, R.color.cp_cont_b);
        vH(this.fZl.getAlpha() > 0.5f);
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        this.lOs = fVar;
    }
}
