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
    private RelativeLayout eqI;
    private View eqJ;
    private TextView eqL;
    private ImageView eqM;
    private View jrK;
    private ImageView jrL;
    private ImageView jrM;
    private com.baidu.tieba.view.e jrN;
    private PersonStatus jrO;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private int mStatusBarHeight;
    private UserData mUserData;

    public k(TbPageContext tbPageContext, View view, View view2, boolean z) {
        this(tbPageContext, view, z);
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.jrK = view2;
        Ah();
    }

    public k(TbPageContext tbPageContext, View view, boolean z) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.eqI = (RelativeLayout) view.findViewById(R.id.person_center_nav_layout);
        this.eqJ = view.findViewById(R.id.person_center_nav_bg);
        this.eqL = (TextView) view.findViewById(R.id.person_center_nav_title);
        this.eqM = (ImageView) view.findViewById(R.id.person_center_nav_back_img);
        this.eqM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (k.this.jrN == null) {
                    if (k.this.mPageContext != null) {
                        k.this.mPageContext.getPageActivity().finish();
                        return;
                    }
                    return;
                }
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.gar = 8;
                k.this.jrN.a(view2, bVar);
            }
        });
        this.jrL = (ImageView) view.findViewById(R.id.person_center_nav_chat_img);
        this.jrL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new an("c12503").cy("obj_locate", "1"));
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.gar = 40;
                bVar.gas = new Bundle();
                bVar.gas.putSerializable(UserData.TYPE_USER, k.this.mUserData);
                if (k.this.jrN != null) {
                    k.this.jrN.a(view2, bVar);
                }
            }
        });
        this.jrM = (ImageView) view.findViewById(R.id.person_center_nav_more_img);
        this.jrM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TiebaStatic.log(new an("c12503").cy("obj_locate", "2"));
                    if (k.this.jrN != null) {
                        com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                        bVar.gar = 9;
                        k.this.jrN.a(view2, bVar);
                    }
                }
            }
        });
    }

    private void Ah() {
        if (this.jrK != null) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                ViewGroup.LayoutParams layoutParams = this.jrK.getLayoutParams();
                layoutParams.height = this.mStatusBarHeight;
                this.jrK.setLayoutParams(layoutParams);
                return;
            }
            this.jrK.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, PersonStatus personStatus) {
        if (aVar != null && aVar.getUserData() != null) {
            this.mUserData = aVar.getUserData();
            this.eqL.setText(this.mUserData.getName_show());
        }
        this.jrO = personStatus;
        cxL();
    }

    public void a(PersonStatus personStatus) {
        this.jrO = personStatus;
        cxL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cxL() {
        if (this.mIsHost) {
            this.jrM.setVisibility(8);
            this.jrL.setVisibility(8);
        } else if (TbadkCoreApplication.isLogin()) {
            this.jrL.setVisibility(0);
            this.jrM.setVisibility(0);
        } else {
            this.jrM.setVisibility(8);
            this.jrL.setVisibility(8);
        }
    }

    public View cxM() {
        return this.eqI;
    }

    public boolean cxN() {
        return this.mIsHost;
    }

    public void aH(float f) {
        float f2;
        float f3 = 1.0f;
        if (f >= 0.0f || f <= 1.0f) {
            if (this.jrK != null) {
                this.jrK.setAlpha(f);
            }
            this.eqJ.setAlpha(f);
            this.eqL.setAlpha(f);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 <= 1.0f) {
            f3 = f2 < 0.0f ? 0.0f : f2;
        }
        this.eqM.setAlpha(f3);
        this.jrM.setAlpha(f3);
        this.jrL.setAlpha(f3);
    }

    public void rB(boolean z) {
        if (z) {
            this.eqJ.setVisibility(8);
            this.eqL.setVisibility(8);
            return;
        }
        this.eqJ.setVisibility(0);
        this.eqL.setVisibility(0);
    }

    public void rC(boolean z) {
        if (this.eqM != null) {
            if (z) {
                SvgManager.aGC().a(this.eqM, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aGC().a(this.jrM, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aGC().a(this.jrL, R.drawable.icon_pure_topbar_createchat44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return;
            }
            SvgManager.aGC().a(this.eqM, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.aGC().a(this.jrM, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.aGC().a(this.jrL, R.drawable.icon_pure_topbar_createchat44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jrK != null) {
            am.setBackgroundColor(this.jrK, R.color.cp_bg_line_d);
        }
        am.setBackgroundColor(this.eqJ, R.color.cp_bg_line_d);
        am.setViewTextColor(this.eqL, (int) R.color.cp_cont_b);
        rC(this.eqJ.getAlpha() > 0.5f);
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.e eVar) {
        this.jrN = eVar;
    }
}
