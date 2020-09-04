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
    private RelativeLayout fJE;
    private View fJF;
    private TextView fJH;
    private ImageView fJI;
    private View lqh;
    private ImageView lqi;
    private ImageView lqj;
    private com.baidu.tieba.view.f lqk;
    private PersonStatus lql;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private int mStatusBarHeight;
    private UserData mUserData;

    public k(TbPageContext tbPageContext, View view, View view2, boolean z) {
        this(tbPageContext, view, z);
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.lqh = view2;
        Oo();
    }

    public k(TbPageContext tbPageContext, View view, boolean z) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.fJE = (RelativeLayout) view.findViewById(R.id.person_center_nav_layout);
        this.fJF = view.findViewById(R.id.person_center_nav_bg);
        this.fJH = (TextView) view.findViewById(R.id.person_center_nav_title);
        this.fJI = (ImageView) view.findViewById(R.id.person_center_nav_back_img);
        this.fJI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (k.this.lqk == null) {
                    if (k.this.mPageContext != null) {
                        k.this.mPageContext.getPageActivity().finish();
                        return;
                    }
                    return;
                }
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.hEt = 8;
                k.this.lqk.a(view2, bVar);
            }
        });
        this.lqi = (ImageView) view.findViewById(R.id.person_center_nav_chat_img);
        this.lqi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new aq("c12503").dD("obj_locate", "1"));
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.hEt = 40;
                bVar.hEu = new Bundle();
                bVar.hEu.putSerializable(UserData.TYPE_USER, k.this.mUserData);
                if (k.this.lqk != null) {
                    k.this.lqk.a(view2, bVar);
                }
            }
        });
        this.lqj = (ImageView) view.findViewById(R.id.person_center_nav_more_img);
        this.lqj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TiebaStatic.log(new aq("c12503").dD("obj_locate", "2"));
                    if (k.this.lqk != null) {
                        com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                        bVar.hEt = 9;
                        k.this.lqk.a(view2, bVar);
                    }
                }
            }
        });
    }

    private void Oo() {
        if (this.lqh != null) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                ViewGroup.LayoutParams layoutParams = this.lqh.getLayoutParams();
                layoutParams.height = this.mStatusBarHeight;
                this.lqh.setLayoutParams(layoutParams);
                return;
            }
            this.lqh.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, PersonStatus personStatus) {
        if (aVar != null && aVar.getUserData() != null) {
            this.mUserData = aVar.getUserData();
            this.fJH.setText(this.mUserData.getName_show());
        }
        this.lql = personStatus;
        djq();
    }

    public void a(PersonStatus personStatus) {
        this.lql = personStatus;
        djq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void djq() {
        if (this.mIsHost) {
            this.lqj.setVisibility(8);
            this.lqi.setVisibility(8);
        } else if (TbadkCoreApplication.isLogin()) {
            this.lqi.setVisibility(0);
            this.lqj.setVisibility(0);
        } else {
            this.lqj.setVisibility(8);
            this.lqi.setVisibility(8);
        }
    }

    public View djr() {
        return this.fJE;
    }

    public boolean djs() {
        return this.mIsHost;
    }

    public void aA(float f) {
        float f2;
        float f3 = 1.0f;
        if (f >= 0.0f || f <= 1.0f) {
            if (this.lqh != null) {
                this.lqh.setAlpha(f);
            }
            this.fJF.setAlpha(f);
            this.fJH.setAlpha(f);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 <= 1.0f) {
            f3 = f2 < 0.0f ? 0.0f : f2;
        }
        this.fJI.setAlpha(f3);
        this.lqj.setAlpha(f3);
        this.lqi.setAlpha(f3);
    }

    public void uR(boolean z) {
        if (z) {
            this.fJF.setVisibility(8);
            this.fJH.setVisibility(8);
            return;
        }
        this.fJF.setVisibility(0);
        this.fJH.setVisibility(0);
    }

    public void uS(boolean z) {
        if (this.fJI != null) {
            if (z) {
                SvgManager.bjq().a(this.fJI, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bjq().a(this.lqj, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bjq().a(this.lqi, R.drawable.icon_pure_topbar_createchat44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return;
            }
            SvgManager.bjq().a(this.fJI, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bjq().a(this.lqj, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bjq().a(this.lqi, R.drawable.icon_pure_topbar_createchat44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lqh != null) {
            ap.setBackgroundColor(this.lqh, R.color.cp_bg_line_d);
        }
        ap.setBackgroundColor(this.fJF, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.fJH, (int) R.color.cp_cont_b);
        uS(this.fJF.getAlpha() > 0.5f);
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        this.lqk = fVar;
    }
}
