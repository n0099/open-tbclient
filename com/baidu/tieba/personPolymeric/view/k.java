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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.constant.PersonStatus;
/* loaded from: classes18.dex */
public class k {
    private RelativeLayout fyi;
    private View fyj;
    private TextView fyl;
    private ImageView fym;
    private View kZF;
    private ImageView kZG;
    private ImageView kZH;
    private com.baidu.tieba.view.f kZI;
    private PersonStatus kZJ;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private int mStatusBarHeight;
    private UserData mUserData;

    public k(TbPageContext tbPageContext, View view, View view2, boolean z) {
        this(tbPageContext, view, z);
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.kZF = view2;
        Iv();
    }

    public k(TbPageContext tbPageContext, View view, boolean z) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.fyi = (RelativeLayout) view.findViewById(R.id.person_center_nav_layout);
        this.fyj = view.findViewById(R.id.person_center_nav_bg);
        this.fyl = (TextView) view.findViewById(R.id.person_center_nav_title);
        this.fym = (ImageView) view.findViewById(R.id.person_center_nav_back_img);
        this.fym.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (k.this.kZI == null) {
                    if (k.this.mPageContext != null) {
                        k.this.mPageContext.getPageActivity().finish();
                        return;
                    }
                    return;
                }
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.hrw = 8;
                k.this.kZI.a(view2, bVar);
            }
        });
        this.kZG = (ImageView) view.findViewById(R.id.person_center_nav_chat_img);
        this.kZG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new ap("c12503").dn("obj_locate", "1"));
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.hrw = 40;
                bVar.hrx = new Bundle();
                bVar.hrx.putSerializable(UserData.TYPE_USER, k.this.mUserData);
                if (k.this.kZI != null) {
                    k.this.kZI.a(view2, bVar);
                }
            }
        });
        this.kZH = (ImageView) view.findViewById(R.id.person_center_nav_more_img);
        this.kZH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TiebaStatic.log(new ap("c12503").dn("obj_locate", "2"));
                    if (k.this.kZI != null) {
                        com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                        bVar.hrw = 9;
                        k.this.kZI.a(view2, bVar);
                    }
                }
            }
        });
    }

    private void Iv() {
        if (this.kZF != null) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                ViewGroup.LayoutParams layoutParams = this.kZF.getLayoutParams();
                layoutParams.height = this.mStatusBarHeight;
                this.kZF.setLayoutParams(layoutParams);
                return;
            }
            this.kZF.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, PersonStatus personStatus) {
        if (aVar != null && aVar.getUserData() != null) {
            this.mUserData = aVar.getUserData();
            this.fyl.setText(this.mUserData.getName_show());
        }
        this.kZJ = personStatus;
        cYk();
    }

    public void a(PersonStatus personStatus) {
        this.kZJ = personStatus;
        cYk();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cYk() {
        if (this.mIsHost) {
            this.kZH.setVisibility(8);
            this.kZG.setVisibility(8);
        } else if (TbadkCoreApplication.isLogin()) {
            this.kZG.setVisibility(0);
            this.kZH.setVisibility(0);
        } else {
            this.kZH.setVisibility(8);
            this.kZG.setVisibility(8);
        }
    }

    public View cYl() {
        return this.fyi;
    }

    public boolean cYm() {
        return this.mIsHost;
    }

    public void au(float f) {
        float f2;
        float f3 = 1.0f;
        if (f >= 0.0f || f <= 1.0f) {
            if (this.kZF != null) {
                this.kZF.setAlpha(f);
            }
            this.fyj.setAlpha(f);
            this.fyl.setAlpha(f);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 <= 1.0f) {
            f3 = f2 < 0.0f ? 0.0f : f2;
        }
        this.fym.setAlpha(f3);
        this.kZH.setAlpha(f3);
        this.kZG.setAlpha(f3);
    }

    public void ud(boolean z) {
        if (z) {
            this.fyj.setVisibility(8);
            this.fyl.setVisibility(8);
            return;
        }
        this.fyj.setVisibility(0);
        this.fyl.setVisibility(0);
    }

    public void ue(boolean z) {
        if (this.fym != null) {
            if (z) {
                SvgManager.baR().a(this.fym, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.baR().a(this.kZH, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.baR().a(this.kZG, R.drawable.icon_pure_topbar_createchat44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return;
            }
            SvgManager.baR().a(this.fym, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.baR().a(this.kZH, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.baR().a(this.kZG, R.drawable.icon_pure_topbar_createchat44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kZF != null) {
            ao.setBackgroundColor(this.kZF, R.color.cp_bg_line_d);
        }
        ao.setBackgroundColor(this.fyj, R.color.cp_bg_line_d);
        ao.setViewTextColor(this.fyl, R.color.cp_cont_b);
        ue(this.fyj.getAlpha() > 0.5f);
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        this.kZI = fVar;
    }
}
