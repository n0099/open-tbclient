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
    private RelativeLayout eqH;
    private View eqI;
    private TextView eqK;
    private ImageView eqL;
    private View jrI;
    private ImageView jrJ;
    private ImageView jrK;
    private com.baidu.tieba.view.e jrL;
    private PersonStatus jrM;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private int mStatusBarHeight;
    private UserData mUserData;

    public k(TbPageContext tbPageContext, View view, View view2, boolean z) {
        this(tbPageContext, view, z);
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.jrI = view2;
        Af();
    }

    public k(TbPageContext tbPageContext, View view, boolean z) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.eqH = (RelativeLayout) view.findViewById(R.id.person_center_nav_layout);
        this.eqI = view.findViewById(R.id.person_center_nav_bg);
        this.eqK = (TextView) view.findViewById(R.id.person_center_nav_title);
        this.eqL = (ImageView) view.findViewById(R.id.person_center_nav_back_img);
        this.eqL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (k.this.jrL == null) {
                    if (k.this.mPageContext != null) {
                        k.this.mPageContext.getPageActivity().finish();
                        return;
                    }
                    return;
                }
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.gap = 8;
                k.this.jrL.a(view2, bVar);
            }
        });
        this.jrJ = (ImageView) view.findViewById(R.id.person_center_nav_chat_img);
        this.jrJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new an("c12503").cy("obj_locate", "1"));
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.gap = 40;
                bVar.gaq = new Bundle();
                bVar.gaq.putSerializable(UserData.TYPE_USER, k.this.mUserData);
                if (k.this.jrL != null) {
                    k.this.jrL.a(view2, bVar);
                }
            }
        });
        this.jrK = (ImageView) view.findViewById(R.id.person_center_nav_more_img);
        this.jrK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TiebaStatic.log(new an("c12503").cy("obj_locate", "2"));
                    if (k.this.jrL != null) {
                        com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                        bVar.gap = 9;
                        k.this.jrL.a(view2, bVar);
                    }
                }
            }
        });
    }

    private void Af() {
        if (this.jrI != null) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                ViewGroup.LayoutParams layoutParams = this.jrI.getLayoutParams();
                layoutParams.height = this.mStatusBarHeight;
                this.jrI.setLayoutParams(layoutParams);
                return;
            }
            this.jrI.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, PersonStatus personStatus) {
        if (aVar != null && aVar.getUserData() != null) {
            this.mUserData = aVar.getUserData();
            this.eqK.setText(this.mUserData.getName_show());
        }
        this.jrM = personStatus;
        cxJ();
    }

    public void a(PersonStatus personStatus) {
        this.jrM = personStatus;
        cxJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cxJ() {
        if (this.mIsHost) {
            this.jrK.setVisibility(8);
            this.jrJ.setVisibility(8);
        } else if (TbadkCoreApplication.isLogin()) {
            this.jrJ.setVisibility(0);
            this.jrK.setVisibility(0);
        } else {
            this.jrK.setVisibility(8);
            this.jrJ.setVisibility(8);
        }
    }

    public View cxK() {
        return this.eqH;
    }

    public boolean cxL() {
        return this.mIsHost;
    }

    public void aH(float f) {
        float f2;
        float f3 = 1.0f;
        if (f >= 0.0f || f <= 1.0f) {
            if (this.jrI != null) {
                this.jrI.setAlpha(f);
            }
            this.eqI.setAlpha(f);
            this.eqK.setAlpha(f);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 <= 1.0f) {
            f3 = f2 < 0.0f ? 0.0f : f2;
        }
        this.eqL.setAlpha(f3);
        this.jrK.setAlpha(f3);
        this.jrJ.setAlpha(f3);
    }

    public void rB(boolean z) {
        if (z) {
            this.eqI.setVisibility(8);
            this.eqK.setVisibility(8);
            return;
        }
        this.eqI.setVisibility(0);
        this.eqK.setVisibility(0);
    }

    public void rC(boolean z) {
        if (this.eqL != null) {
            if (z) {
                SvgManager.aGA().a(this.eqL, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aGA().a(this.jrK, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aGA().a(this.jrJ, R.drawable.icon_pure_topbar_createchat44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return;
            }
            SvgManager.aGA().a(this.eqL, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.aGA().a(this.jrK, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.aGA().a(this.jrJ, R.drawable.icon_pure_topbar_createchat44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jrI != null) {
            am.setBackgroundColor(this.jrI, R.color.cp_bg_line_d);
        }
        am.setBackgroundColor(this.eqI, R.color.cp_bg_line_d);
        am.setViewTextColor(this.eqK, (int) R.color.cp_cont_b);
        rC(this.eqI.getAlpha() > 0.5f);
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.e eVar) {
        this.jrL = eVar;
    }
}
