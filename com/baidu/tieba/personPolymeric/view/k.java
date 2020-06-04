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
    private RelativeLayout fhM;
    private View fhN;
    private TextView fhP;
    private ImageView fhQ;
    private View kwM;
    private ImageView kwN;
    private ImageView kwO;
    private com.baidu.tieba.view.f kwP;
    private PersonStatus kwQ;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private int mStatusBarHeight;
    private UserData mUserData;

    public k(TbPageContext tbPageContext, View view, View view2, boolean z) {
        this(tbPageContext, view, z);
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.kwM = view2;
        Hc();
    }

    public k(TbPageContext tbPageContext, View view, boolean z) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.fhM = (RelativeLayout) view.findViewById(R.id.person_center_nav_layout);
        this.fhN = view.findViewById(R.id.person_center_nav_bg);
        this.fhP = (TextView) view.findViewById(R.id.person_center_nav_title);
        this.fhQ = (ImageView) view.findViewById(R.id.person_center_nav_back_img);
        this.fhQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (k.this.kwP == null) {
                    if (k.this.mPageContext != null) {
                        k.this.mPageContext.getPageActivity().finish();
                        return;
                    }
                    return;
                }
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.gZy = 8;
                k.this.kwP.a(view2, bVar);
            }
        });
        this.kwN = (ImageView) view.findViewById(R.id.person_center_nav_chat_img);
        this.kwN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new an("c12503").dh("obj_locate", "1"));
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.gZy = 40;
                bVar.gZz = new Bundle();
                bVar.gZz.putSerializable(UserData.TYPE_USER, k.this.mUserData);
                if (k.this.kwP != null) {
                    k.this.kwP.a(view2, bVar);
                }
            }
        });
        this.kwO = (ImageView) view.findViewById(R.id.person_center_nav_more_img);
        this.kwO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TiebaStatic.log(new an("c12503").dh("obj_locate", "2"));
                    if (k.this.kwP != null) {
                        com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                        bVar.gZy = 9;
                        k.this.kwP.a(view2, bVar);
                    }
                }
            }
        });
    }

    private void Hc() {
        if (this.kwM != null) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                ViewGroup.LayoutParams layoutParams = this.kwM.getLayoutParams();
                layoutParams.height = this.mStatusBarHeight;
                this.kwM.setLayoutParams(layoutParams);
                return;
            }
            this.kwM.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, PersonStatus personStatus) {
        if (aVar != null && aVar.getUserData() != null) {
            this.mUserData = aVar.getUserData();
            this.fhP.setText(this.mUserData.getName_show());
        }
        this.kwQ = personStatus;
        cQc();
    }

    public void a(PersonStatus personStatus) {
        this.kwQ = personStatus;
        cQc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cQc() {
        if (this.mIsHost) {
            this.kwO.setVisibility(8);
            this.kwN.setVisibility(8);
        } else if (TbadkCoreApplication.isLogin()) {
            this.kwN.setVisibility(0);
            this.kwO.setVisibility(0);
        } else {
            this.kwO.setVisibility(8);
            this.kwN.setVisibility(8);
        }
    }

    public View cQd() {
        return this.fhM;
    }

    public boolean cQe() {
        return this.mIsHost;
    }

    public void aq(float f) {
        float f2;
        float f3 = 1.0f;
        if (f >= 0.0f || f <= 1.0f) {
            if (this.kwM != null) {
                this.kwM.setAlpha(f);
            }
            this.fhN.setAlpha(f);
            this.fhP.setAlpha(f);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 <= 1.0f) {
            f3 = f2 < 0.0f ? 0.0f : f2;
        }
        this.fhQ.setAlpha(f3);
        this.kwO.setAlpha(f3);
        this.kwN.setAlpha(f3);
    }

    public void tj(boolean z) {
        if (z) {
            this.fhN.setVisibility(8);
            this.fhP.setVisibility(8);
            return;
        }
        this.fhN.setVisibility(0);
        this.fhP.setVisibility(0);
    }

    public void tk(boolean z) {
        if (this.fhQ != null) {
            if (z) {
                SvgManager.aUW().a(this.fhQ, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aUW().a(this.kwO, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aUW().a(this.kwN, R.drawable.icon_pure_topbar_createchat44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return;
            }
            SvgManager.aUW().a(this.fhQ, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.aUW().a(this.kwO, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.aUW().a(this.kwN, R.drawable.icon_pure_topbar_createchat44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kwM != null) {
            am.setBackgroundColor(this.kwM, R.color.cp_bg_line_d);
        }
        am.setBackgroundColor(this.fhN, R.color.cp_bg_line_d);
        am.setViewTextColor(this.fhP, (int) R.color.cp_cont_b);
        tk(this.fhN.getAlpha() > 0.5f);
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        this.kwP = fVar;
    }
}
