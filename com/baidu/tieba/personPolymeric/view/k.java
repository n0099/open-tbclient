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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.constant.PersonStatus;
/* loaded from: classes11.dex */
public class k {
    private RelativeLayout eUO;
    private View eUP;
    private TextView eUR;
    private ImageView eUS;
    private View kdL;
    private ImageView kdM;
    private ImageView kdN;
    private com.baidu.tieba.view.f kdO;
    private PersonStatus kdP;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private int mStatusBarHeight;
    private UserData mUserData;

    public k(TbPageContext tbPageContext, View view, View view2, boolean z) {
        this(tbPageContext, view, z);
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.kdL = view2;
        Fm();
    }

    public k(TbPageContext tbPageContext, View view, boolean z) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.eUO = (RelativeLayout) view.findViewById(R.id.person_center_nav_layout);
        this.eUP = view.findViewById(R.id.person_center_nav_bg);
        this.eUR = (TextView) view.findViewById(R.id.person_center_nav_title);
        this.eUS = (ImageView) view.findViewById(R.id.person_center_nav_back_img);
        this.eUS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (k.this.kdO == null) {
                    if (k.this.mPageContext != null) {
                        k.this.mPageContext.getPageActivity().finish();
                        return;
                    }
                    return;
                }
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.gKv = 8;
                k.this.kdO.a(view2, bVar);
            }
        });
        this.kdM = (ImageView) view.findViewById(R.id.person_center_nav_chat_img);
        this.kdM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new an("c12503").cI("obj_locate", "1"));
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.gKv = 40;
                bVar.gKw = new Bundle();
                bVar.gKw.putSerializable(UserData.TYPE_USER, k.this.mUserData);
                if (k.this.kdO != null) {
                    k.this.kdO.a(view2, bVar);
                }
            }
        });
        this.kdN = (ImageView) view.findViewById(R.id.person_center_nav_more_img);
        this.kdN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TiebaStatic.log(new an("c12503").cI("obj_locate", "2"));
                    if (k.this.kdO != null) {
                        com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                        bVar.gKv = 9;
                        k.this.kdO.a(view2, bVar);
                    }
                }
            }
        });
    }

    private void Fm() {
        if (this.kdL != null) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                ViewGroup.LayoutParams layoutParams = this.kdL.getLayoutParams();
                layoutParams.height = this.mStatusBarHeight;
                this.kdL.setLayoutParams(layoutParams);
                return;
            }
            this.kdL.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, PersonStatus personStatus) {
        if (aVar != null && aVar.getUserData() != null) {
            this.mUserData = aVar.getUserData();
            this.eUR.setText(this.mUserData.getName_show());
        }
        this.kdP = personStatus;
        cIP();
    }

    public void a(PersonStatus personStatus) {
        this.kdP = personStatus;
        cIP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cIP() {
        if (this.mIsHost) {
            this.kdN.setVisibility(8);
            this.kdM.setVisibility(8);
        } else if (TbadkCoreApplication.isLogin()) {
            this.kdM.setVisibility(0);
            this.kdN.setVisibility(0);
        } else {
            this.kdN.setVisibility(8);
            this.kdM.setVisibility(8);
        }
    }

    public View cIQ() {
        return this.eUO;
    }

    public boolean cIR() {
        return this.mIsHost;
    }

    public void ar(float f) {
        float f2;
        float f3 = 1.0f;
        if (f >= 0.0f || f <= 1.0f) {
            if (this.kdL != null) {
                this.kdL.setAlpha(f);
            }
            this.eUP.setAlpha(f);
            this.eUR.setAlpha(f);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 <= 1.0f) {
            f3 = f2 < 0.0f ? 0.0f : f2;
        }
        this.eUS.setAlpha(f3);
        this.kdN.setAlpha(f3);
        this.kdM.setAlpha(f3);
    }

    public void sL(boolean z) {
        if (z) {
            this.eUP.setVisibility(8);
            this.eUR.setVisibility(8);
            return;
        }
        this.eUP.setVisibility(0);
        this.eUR.setVisibility(0);
    }

    public void sM(boolean z) {
        if (this.eUS != null) {
            if (z) {
                SvgManager.aOU().a(this.eUS, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aOU().a(this.kdN, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aOU().a(this.kdM, R.drawable.icon_pure_topbar_createchat44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return;
            }
            SvgManager.aOU().a(this.eUS, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.aOU().a(this.kdN, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.aOU().a(this.kdM, R.drawable.icon_pure_topbar_createchat44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kdL != null) {
            am.setBackgroundColor(this.kdL, R.color.cp_bg_line_d);
        }
        am.setBackgroundColor(this.eUP, R.color.cp_bg_line_d);
        am.setViewTextColor(this.eUR, (int) R.color.cp_cont_b);
        sM(this.eUP.getAlpha() > 0.5f);
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        this.kdO = fVar;
    }
}
