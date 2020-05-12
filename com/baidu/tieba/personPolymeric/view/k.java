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
    private RelativeLayout eUT;
    private View eUU;
    private TextView eUW;
    private ImageView eUX;
    private View kdP;
    private ImageView kdQ;
    private ImageView kdR;
    private com.baidu.tieba.view.f kdS;
    private PersonStatus kdT;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private int mStatusBarHeight;
    private UserData mUserData;

    public k(TbPageContext tbPageContext, View view, View view2, boolean z) {
        this(tbPageContext, view, z);
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.kdP = view2;
        Fl();
    }

    public k(TbPageContext tbPageContext, View view, boolean z) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.eUT = (RelativeLayout) view.findViewById(R.id.person_center_nav_layout);
        this.eUU = view.findViewById(R.id.person_center_nav_bg);
        this.eUW = (TextView) view.findViewById(R.id.person_center_nav_title);
        this.eUX = (ImageView) view.findViewById(R.id.person_center_nav_back_img);
        this.eUX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (k.this.kdS == null) {
                    if (k.this.mPageContext != null) {
                        k.this.mPageContext.getPageActivity().finish();
                        return;
                    }
                    return;
                }
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.gKB = 8;
                k.this.kdS.a(view2, bVar);
            }
        });
        this.kdQ = (ImageView) view.findViewById(R.id.person_center_nav_chat_img);
        this.kdQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new an("c12503").cI("obj_locate", "1"));
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.gKB = 40;
                bVar.gKC = new Bundle();
                bVar.gKC.putSerializable(UserData.TYPE_USER, k.this.mUserData);
                if (k.this.kdS != null) {
                    k.this.kdS.a(view2, bVar);
                }
            }
        });
        this.kdR = (ImageView) view.findViewById(R.id.person_center_nav_more_img);
        this.kdR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TiebaStatic.log(new an("c12503").cI("obj_locate", "2"));
                    if (k.this.kdS != null) {
                        com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                        bVar.gKB = 9;
                        k.this.kdS.a(view2, bVar);
                    }
                }
            }
        });
    }

    private void Fl() {
        if (this.kdP != null) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                ViewGroup.LayoutParams layoutParams = this.kdP.getLayoutParams();
                layoutParams.height = this.mStatusBarHeight;
                this.kdP.setLayoutParams(layoutParams);
                return;
            }
            this.kdP.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, PersonStatus personStatus) {
        if (aVar != null && aVar.getUserData() != null) {
            this.mUserData = aVar.getUserData();
            this.eUW.setText(this.mUserData.getName_show());
        }
        this.kdT = personStatus;
        cIN();
    }

    public void a(PersonStatus personStatus) {
        this.kdT = personStatus;
        cIN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cIN() {
        if (this.mIsHost) {
            this.kdR.setVisibility(8);
            this.kdQ.setVisibility(8);
        } else if (TbadkCoreApplication.isLogin()) {
            this.kdQ.setVisibility(0);
            this.kdR.setVisibility(0);
        } else {
            this.kdR.setVisibility(8);
            this.kdQ.setVisibility(8);
        }
    }

    public View cIO() {
        return this.eUT;
    }

    public boolean cIP() {
        return this.mIsHost;
    }

    public void ar(float f) {
        float f2;
        float f3 = 1.0f;
        if (f >= 0.0f || f <= 1.0f) {
            if (this.kdP != null) {
                this.kdP.setAlpha(f);
            }
            this.eUU.setAlpha(f);
            this.eUW.setAlpha(f);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 <= 1.0f) {
            f3 = f2 < 0.0f ? 0.0f : f2;
        }
        this.eUX.setAlpha(f3);
        this.kdR.setAlpha(f3);
        this.kdQ.setAlpha(f3);
    }

    public void sL(boolean z) {
        if (z) {
            this.eUU.setVisibility(8);
            this.eUW.setVisibility(8);
            return;
        }
        this.eUU.setVisibility(0);
        this.eUW.setVisibility(0);
    }

    public void sM(boolean z) {
        if (this.eUX != null) {
            if (z) {
                SvgManager.aOR().a(this.eUX, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aOR().a(this.kdR, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aOR().a(this.kdQ, R.drawable.icon_pure_topbar_createchat44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return;
            }
            SvgManager.aOR().a(this.eUX, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.aOR().a(this.kdR, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.aOR().a(this.kdQ, R.drawable.icon_pure_topbar_createchat44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kdP != null) {
            am.setBackgroundColor(this.kdP, R.color.cp_bg_line_d);
        }
        am.setBackgroundColor(this.eUU, R.color.cp_bg_line_d);
        am.setViewTextColor(this.eUW, (int) R.color.cp_cont_b);
        sM(this.eUU.getAlpha() > 0.5f);
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        this.kdS = fVar;
    }
}
