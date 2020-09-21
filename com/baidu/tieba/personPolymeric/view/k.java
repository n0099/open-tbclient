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
/* loaded from: classes23.dex */
public class k {
    private RelativeLayout fMT;
    private View fMU;
    private TextView fMW;
    private ImageView fMX;
    private View lza;
    private ImageView lzb;
    private ImageView lzc;
    private com.baidu.tieba.view.f lzd;
    private PersonStatus lze;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private int mStatusBarHeight;
    private UserData mUserData;

    public k(TbPageContext tbPageContext, View view, View view2, boolean z) {
        this(tbPageContext, view, z);
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.lza = view2;
        OR();
    }

    public k(TbPageContext tbPageContext, View view, boolean z) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.fMT = (RelativeLayout) view.findViewById(R.id.person_center_nav_layout);
        this.fMU = view.findViewById(R.id.person_center_nav_bg);
        this.fMW = (TextView) view.findViewById(R.id.person_center_nav_title);
        this.fMX = (ImageView) view.findViewById(R.id.person_center_nav_back_img);
        this.fMX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (k.this.lzd == null) {
                    if (k.this.mPageContext != null) {
                        k.this.mPageContext.getPageActivity().finish();
                        return;
                    }
                    return;
                }
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.hLv = 8;
                k.this.lzd.a(view2, bVar);
            }
        });
        this.lzb = (ImageView) view.findViewById(R.id.person_center_nav_chat_img);
        this.lzb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new aq("c12503").dF("obj_locate", "1"));
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.hLv = 40;
                bVar.hLw = new Bundle();
                bVar.hLw.putSerializable(UserData.TYPE_USER, k.this.mUserData);
                if (k.this.lzd != null) {
                    k.this.lzd.a(view2, bVar);
                }
            }
        });
        this.lzc = (ImageView) view.findViewById(R.id.person_center_nav_more_img);
        this.lzc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TiebaStatic.log(new aq("c12503").dF("obj_locate", "2"));
                    if (k.this.lzd != null) {
                        com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                        bVar.hLv = 9;
                        k.this.lzd.a(view2, bVar);
                    }
                }
            }
        });
    }

    private void OR() {
        if (this.lza != null) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                ViewGroup.LayoutParams layoutParams = this.lza.getLayoutParams();
                layoutParams.height = this.mStatusBarHeight;
                this.lza.setLayoutParams(layoutParams);
                return;
            }
            this.lza.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, PersonStatus personStatus) {
        if (aVar != null && aVar.getUserData() != null) {
            this.mUserData = aVar.getUserData();
            this.fMW.setText(this.mUserData.getName_show());
        }
        this.lze = personStatus;
        dmV();
    }

    public void a(PersonStatus personStatus) {
        this.lze = personStatus;
        dmV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dmV() {
        if (this.mIsHost) {
            this.lzc.setVisibility(8);
            this.lzb.setVisibility(8);
        } else if (TbadkCoreApplication.isLogin()) {
            this.lzb.setVisibility(0);
            this.lzc.setVisibility(0);
        } else {
            this.lzc.setVisibility(8);
            this.lzb.setVisibility(8);
        }
    }

    public View dmW() {
        return this.fMT;
    }

    public boolean dmX() {
        return this.mIsHost;
    }

    public void aA(float f) {
        float f2;
        float f3 = 1.0f;
        if (f >= 0.0f || f <= 1.0f) {
            if (this.lza != null) {
                this.lza.setAlpha(f);
            }
            this.fMU.setAlpha(f);
            this.fMW.setAlpha(f);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 <= 1.0f) {
            f3 = f2 < 0.0f ? 0.0f : f2;
        }
        this.fMX.setAlpha(f3);
        this.lzc.setAlpha(f3);
        this.lzb.setAlpha(f3);
    }

    public void uZ(boolean z) {
        if (z) {
            this.fMU.setVisibility(8);
            this.fMW.setVisibility(8);
            return;
        }
        this.fMU.setVisibility(0);
        this.fMW.setVisibility(0);
    }

    public void va(boolean z) {
        if (this.fMX != null) {
            if (z) {
                SvgManager.bkl().a(this.fMX, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bkl().a(this.lzc, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bkl().a(this.lzb, R.drawable.icon_pure_topbar_createchat44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return;
            }
            SvgManager.bkl().a(this.fMX, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bkl().a(this.lzc, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bkl().a(this.lzb, R.drawable.icon_pure_topbar_createchat44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lza != null) {
            ap.setBackgroundColor(this.lza, R.color.cp_bg_line_d);
        }
        ap.setBackgroundColor(this.fMU, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.fMW, (int) R.color.cp_cont_b);
        va(this.fMU.getAlpha() > 0.5f);
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        this.lzd = fVar;
    }
}
