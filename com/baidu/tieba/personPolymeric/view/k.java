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
/* loaded from: classes9.dex */
public class k {
    private RelativeLayout emt;
    private View emu;
    private TextView emw;
    private ImageView emx;
    private View jqI;
    private ImageView jqJ;
    private ImageView jqK;
    private com.baidu.tieba.view.e jqL;
    private PersonStatus jqM;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private int mStatusBarHeight;
    private UserData mUserData;

    public k(TbPageContext tbPageContext, View view, View view2, boolean z) {
        this(tbPageContext, view, z);
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.jqI = view2;
        xO();
    }

    public k(TbPageContext tbPageContext, View view, boolean z) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.emt = (RelativeLayout) view.findViewById(R.id.person_center_nav_layout);
        this.emu = view.findViewById(R.id.person_center_nav_bg);
        this.emw = (TextView) view.findViewById(R.id.person_center_nav_title);
        this.emx = (ImageView) view.findViewById(R.id.person_center_nav_back_img);
        this.emx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (k.this.jqL == null) {
                    if (k.this.mPageContext != null) {
                        k.this.mPageContext.getPageActivity().finish();
                        return;
                    }
                    return;
                }
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.fYp = 8;
                k.this.jqL.a(view2, bVar);
            }
        });
        this.jqJ = (ImageView) view.findViewById(R.id.person_center_nav_chat_img);
        this.jqJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new an("c12503").cp("obj_locate", "1"));
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.fYp = 40;
                bVar.fYq = new Bundle();
                bVar.fYq.putSerializable(UserData.TYPE_USER, k.this.mUserData);
                if (k.this.jqL != null) {
                    k.this.jqL.a(view2, bVar);
                }
            }
        });
        this.jqK = (ImageView) view.findViewById(R.id.person_center_nav_more_img);
        this.jqK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TiebaStatic.log(new an("c12503").cp("obj_locate", "2"));
                    if (k.this.jqL != null) {
                        com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                        bVar.fYp = 9;
                        k.this.jqL.a(view2, bVar);
                    }
                }
            }
        });
    }

    private void xO() {
        if (this.jqI != null) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                ViewGroup.LayoutParams layoutParams = this.jqI.getLayoutParams();
                layoutParams.height = this.mStatusBarHeight;
                this.jqI.setLayoutParams(layoutParams);
                return;
            }
            this.jqI.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, PersonStatus personStatus) {
        if (aVar != null && aVar.getUserData() != null) {
            this.mUserData = aVar.getUserData();
            this.emw.setText(this.mUserData.getName_show());
        }
        this.jqM = personStatus;
        cwm();
    }

    public void a(PersonStatus personStatus) {
        this.jqM = personStatus;
        cwm();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cwm() {
        if (this.mIsHost) {
            this.jqK.setVisibility(8);
            this.jqJ.setVisibility(8);
        } else if (TbadkCoreApplication.isLogin()) {
            this.jqJ.setVisibility(0);
            this.jqK.setVisibility(0);
        } else {
            this.jqK.setVisibility(8);
            this.jqJ.setVisibility(8);
        }
    }

    public View cwn() {
        return this.emt;
    }

    public boolean cwo() {
        return this.mIsHost;
    }

    public void aI(float f) {
        float f2;
        float f3 = 1.0f;
        if (f >= 0.0f || f <= 1.0f) {
            if (this.jqI != null) {
                this.jqI.setAlpha(f);
            }
            this.emu.setAlpha(f);
            this.emw.setAlpha(f);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 <= 1.0f) {
            f3 = f2 < 0.0f ? 0.0f : f2;
        }
        this.emx.setAlpha(f3);
        this.jqK.setAlpha(f3);
        this.jqJ.setAlpha(f3);
    }

    public void ry(boolean z) {
        if (z) {
            this.emu.setVisibility(8);
            this.emw.setVisibility(8);
            return;
        }
        this.emu.setVisibility(0);
        this.emw.setVisibility(0);
    }

    public void rz(boolean z) {
        if (this.emx != null) {
            if (z) {
                SvgManager.aEp().a(this.emx, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aEp().a(this.jqK, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aEp().a(this.jqJ, R.drawable.icon_pure_topbar_createchat44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return;
            }
            SvgManager.aEp().a(this.emx, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.aEp().a(this.jqK, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.aEp().a(this.jqJ, R.drawable.icon_pure_topbar_createchat44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jqI != null) {
            am.setBackgroundColor(this.jqI, R.color.cp_bg_line_d);
        }
        am.setBackgroundColor(this.emu, R.color.cp_bg_line_d);
        am.setViewTextColor(this.emw, (int) R.color.cp_cont_b);
        rz(this.emu.getAlpha() > 0.5f);
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.e eVar) {
        this.jqL = eVar;
    }
}
