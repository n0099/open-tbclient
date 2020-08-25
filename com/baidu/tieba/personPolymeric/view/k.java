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
/* loaded from: classes18.dex */
public class k {
    private RelativeLayout fJA;
    private View fJB;
    private TextView fJD;
    private ImageView fJE;
    private View lpW;
    private ImageView lpX;
    private ImageView lpY;
    private com.baidu.tieba.view.f lpZ;
    private PersonStatus lqa;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private int mStatusBarHeight;
    private UserData mUserData;

    public k(TbPageContext tbPageContext, View view, View view2, boolean z) {
        this(tbPageContext, view, z);
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.lpW = view2;
        Oo();
    }

    public k(TbPageContext tbPageContext, View view, boolean z) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.fJA = (RelativeLayout) view.findViewById(R.id.person_center_nav_layout);
        this.fJB = view.findViewById(R.id.person_center_nav_bg);
        this.fJD = (TextView) view.findViewById(R.id.person_center_nav_title);
        this.fJE = (ImageView) view.findViewById(R.id.person_center_nav_back_img);
        this.fJE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (k.this.lpZ == null) {
                    if (k.this.mPageContext != null) {
                        k.this.mPageContext.getPageActivity().finish();
                        return;
                    }
                    return;
                }
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.hEn = 8;
                k.this.lpZ.a(view2, bVar);
            }
        });
        this.lpX = (ImageView) view.findViewById(R.id.person_center_nav_chat_img);
        this.lpX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new aq("c12503").dD("obj_locate", "1"));
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.hEn = 40;
                bVar.hEo = new Bundle();
                bVar.hEo.putSerializable(UserData.TYPE_USER, k.this.mUserData);
                if (k.this.lpZ != null) {
                    k.this.lpZ.a(view2, bVar);
                }
            }
        });
        this.lpY = (ImageView) view.findViewById(R.id.person_center_nav_more_img);
        this.lpY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TiebaStatic.log(new aq("c12503").dD("obj_locate", "2"));
                    if (k.this.lpZ != null) {
                        com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                        bVar.hEn = 9;
                        k.this.lpZ.a(view2, bVar);
                    }
                }
            }
        });
    }

    private void Oo() {
        if (this.lpW != null) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                ViewGroup.LayoutParams layoutParams = this.lpW.getLayoutParams();
                layoutParams.height = this.mStatusBarHeight;
                this.lpW.setLayoutParams(layoutParams);
                return;
            }
            this.lpW.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, PersonStatus personStatus) {
        if (aVar != null && aVar.getUserData() != null) {
            this.mUserData = aVar.getUserData();
            this.fJD.setText(this.mUserData.getName_show());
        }
        this.lqa = personStatus;
        djn();
    }

    public void a(PersonStatus personStatus) {
        this.lqa = personStatus;
        djn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void djn() {
        if (this.mIsHost) {
            this.lpY.setVisibility(8);
            this.lpX.setVisibility(8);
        } else if (TbadkCoreApplication.isLogin()) {
            this.lpX.setVisibility(0);
            this.lpY.setVisibility(0);
        } else {
            this.lpY.setVisibility(8);
            this.lpX.setVisibility(8);
        }
    }

    public View djo() {
        return this.fJA;
    }

    public boolean djp() {
        return this.mIsHost;
    }

    public void aA(float f) {
        float f2;
        float f3 = 1.0f;
        if (f >= 0.0f || f <= 1.0f) {
            if (this.lpW != null) {
                this.lpW.setAlpha(f);
            }
            this.fJB.setAlpha(f);
            this.fJD.setAlpha(f);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 <= 1.0f) {
            f3 = f2 < 0.0f ? 0.0f : f2;
        }
        this.fJE.setAlpha(f3);
        this.lpY.setAlpha(f3);
        this.lpX.setAlpha(f3);
    }

    public void uP(boolean z) {
        if (z) {
            this.fJB.setVisibility(8);
            this.fJD.setVisibility(8);
            return;
        }
        this.fJB.setVisibility(0);
        this.fJD.setVisibility(0);
    }

    public void uQ(boolean z) {
        if (this.fJE != null) {
            if (z) {
                SvgManager.bjq().a(this.fJE, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bjq().a(this.lpY, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bjq().a(this.lpX, R.drawable.icon_pure_topbar_createchat44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return;
            }
            SvgManager.bjq().a(this.fJE, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bjq().a(this.lpY, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bjq().a(this.lpX, R.drawable.icon_pure_topbar_createchat44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lpW != null) {
            ap.setBackgroundColor(this.lpW, R.color.cp_bg_line_d);
        }
        ap.setBackgroundColor(this.fJB, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.fJD, R.color.cp_cont_b);
        uQ(this.fJB.getAlpha() > 0.5f);
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        this.lpZ = fVar;
    }
}
