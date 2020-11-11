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
    private RelativeLayout gpc;
    private View gpd;
    private TextView gpf;
    private ImageView gpg;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private int mStatusBarHeight;
    private UserData mUserData;
    private View mgK;
    private ImageView mgL;
    private ImageView mgM;
    private com.baidu.tieba.view.f mgN;
    private PersonStatus mgO;

    public k(TbPageContext tbPageContext, View view, View view2, boolean z) {
        this(tbPageContext, view, z);
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.mgK = view2;
        Tz();
    }

    public k(TbPageContext tbPageContext, View view, boolean z) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.gpc = (RelativeLayout) view.findViewById(R.id.person_center_nav_layout);
        this.gpd = view.findViewById(R.id.person_center_nav_bg);
        this.gpf = (TextView) view.findViewById(R.id.person_center_nav_title);
        this.gpg = (ImageView) view.findViewById(R.id.person_center_nav_back_img);
        this.gpg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (k.this.mgN == null) {
                    if (k.this.mPageContext != null) {
                        k.this.mPageContext.getPageActivity().finish();
                        return;
                    }
                    return;
                }
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.isP = 8;
                k.this.mgN.a(view2, bVar);
            }
        });
        this.mgL = (ImageView) view.findViewById(R.id.person_center_nav_chat_img);
        this.mgL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new aq("c12503").dR("obj_locate", "1"));
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.isP = 40;
                bVar.isQ = new Bundle();
                bVar.isQ.putSerializable(UserData.TYPE_USER, k.this.mUserData);
                if (k.this.mgN != null) {
                    k.this.mgN.a(view2, bVar);
                }
            }
        });
        this.mgM = (ImageView) view.findViewById(R.id.person_center_nav_more_img);
        this.mgM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TiebaStatic.log(new aq("c12503").dR("obj_locate", "2"));
                    if (k.this.mgN != null) {
                        com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                        bVar.isP = 9;
                        k.this.mgN.a(view2, bVar);
                    }
                }
            }
        });
    }

    private void Tz() {
        if (this.mgK != null) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                ViewGroup.LayoutParams layoutParams = this.mgK.getLayoutParams();
                layoutParams.height = this.mStatusBarHeight;
                this.mgK.setLayoutParams(layoutParams);
                return;
            }
            this.mgK.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, PersonStatus personStatus) {
        if (aVar != null && aVar.getUserData() != null) {
            this.mUserData = aVar.getUserData();
            this.gpf.setText(this.mUserData.getName_show());
        }
        this.mgO = personStatus;
        dwq();
    }

    public void a(PersonStatus personStatus) {
        this.mgO = personStatus;
        dwq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dwq() {
        if (this.mIsHost) {
            this.mgM.setVisibility(8);
            this.mgL.setVisibility(8);
        } else if (TbadkCoreApplication.isLogin()) {
            this.mgL.setVisibility(0);
            this.mgM.setVisibility(0);
        } else {
            this.mgM.setVisibility(8);
            this.mgL.setVisibility(8);
        }
    }

    public View dwr() {
        return this.gpc;
    }

    public boolean dws() {
        return this.mIsHost;
    }

    public void aK(float f) {
        float f2;
        float f3 = 1.0f;
        if (f >= 0.0f || f <= 1.0f) {
            if (this.mgK != null) {
                this.mgK.setAlpha(f);
            }
            this.gpd.setAlpha(f);
            this.gpf.setAlpha(f);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 <= 1.0f) {
            f3 = f2 < 0.0f ? 0.0f : f2;
        }
        this.gpg.setAlpha(f3);
        this.mgM.setAlpha(f3);
        this.mgL.setAlpha(f3);
    }

    public void wg(boolean z) {
        if (z) {
            this.gpd.setVisibility(8);
            this.gpf.setVisibility(8);
            return;
        }
        this.gpd.setVisibility(0);
        this.gpf.setVisibility(0);
    }

    public void wh(boolean z) {
        if (this.gpg != null) {
            if (z) {
                SvgManager.brn().a(this.gpg, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.brn().a(this.mgM, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.brn().a(this.mgL, R.drawable.icon_pure_topbar_createchat44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return;
            }
            SvgManager.brn().a(this.gpg, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.brn().a(this.mgM, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.brn().a(this.mgL, R.drawable.icon_pure_topbar_createchat44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mgK != null) {
            ap.setBackgroundColor(this.mgK, R.color.cp_bg_line_d);
        }
        ap.setBackgroundColor(this.gpd, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.gpf, (int) R.color.cp_cont_b);
        wh(this.gpd.getAlpha() > 0.5f);
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        this.mgN = fVar;
    }
}
