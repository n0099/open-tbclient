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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.constant.PersonStatus;
/* loaded from: classes8.dex */
public class k {
    private RelativeLayout gHY;
    private View gHZ;
    private TextView gIb;
    private ImageView gIc;
    private com.baidu.tieba.view.f mAA;
    private PersonStatus mAB;
    private View mAx;
    private ImageView mAy;
    private ImageView mAz;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private int mStatusBarHeight;
    private UserData mUserData;

    public k(TbPageContext tbPageContext, View view, View view2, boolean z) {
        this(tbPageContext, view, z);
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.mAx = view2;
        Wt();
    }

    public k(TbPageContext tbPageContext, View view, boolean z) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.gHY = (RelativeLayout) view.findViewById(R.id.person_center_nav_layout);
        this.gHZ = view.findViewById(R.id.person_center_nav_bg);
        this.gIb = (TextView) view.findViewById(R.id.person_center_nav_title);
        this.gIc = (ImageView) view.findViewById(R.id.person_center_nav_back_img);
        this.gIc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (k.this.mAA == null) {
                    if (k.this.mPageContext != null) {
                        k.this.mPageContext.getPageActivity().finish();
                        return;
                    }
                    return;
                }
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.iQJ = 8;
                k.this.mAA.a(view2, bVar);
            }
        });
        this.mAy = (ImageView) view.findViewById(R.id.person_center_nav_chat_img);
        this.mAy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new aq("c12503").dX("obj_locate", "1"));
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.iQJ = 40;
                bVar.iQK = new Bundle();
                bVar.iQK.putSerializable(UserData.TYPE_USER, k.this.mUserData);
                if (k.this.mAA != null) {
                    k.this.mAA.a(view2, bVar);
                }
            }
        });
        this.mAz = (ImageView) view.findViewById(R.id.person_center_nav_more_img);
        this.mAz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TiebaStatic.log(new aq("c12503").dX("obj_locate", "2"));
                    if (k.this.mAA != null) {
                        com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                        bVar.iQJ = 9;
                        k.this.mAA.a(view2, bVar);
                    }
                }
            }
        });
    }

    private void Wt() {
        if (this.mAx != null) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                ViewGroup.LayoutParams layoutParams = this.mAx.getLayoutParams();
                layoutParams.height = this.mStatusBarHeight;
                this.mAx.setLayoutParams(layoutParams);
                return;
            }
            this.mAx.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, PersonStatus personStatus) {
        if (aVar != null && aVar.getUserData() != null) {
            this.mUserData = aVar.getUserData();
            this.gIb.setText(this.mUserData.getName_show());
        }
        this.mAB = personStatus;
        dAZ();
    }

    public void a(PersonStatus personStatus) {
        this.mAB = personStatus;
        dAZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dAZ() {
        if (this.mIsHost) {
            this.mAz.setVisibility(8);
            this.mAy.setVisibility(8);
        } else if (TbadkCoreApplication.isLogin()) {
            this.mAy.setVisibility(0);
            this.mAz.setVisibility(0);
        } else {
            this.mAz.setVisibility(8);
            this.mAy.setVisibility(8);
        }
    }

    public View dBa() {
        return this.gHY;
    }

    public boolean dBb() {
        return this.mIsHost;
    }

    public void aU(float f) {
        float f2;
        float f3 = 1.0f;
        if (f >= 0.0f || f <= 1.0f) {
            if (this.mAx != null) {
                this.mAx.setAlpha(f);
            }
            this.gHZ.setAlpha(f);
            this.gIb.setAlpha(f);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 <= 1.0f) {
            f3 = f2 < 0.0f ? 0.0f : f2;
        }
        this.gIc.setAlpha(f3);
        this.mAz.setAlpha(f3);
        this.mAy.setAlpha(f3);
    }

    public void wO(boolean z) {
        if (z) {
            this.gHZ.setVisibility(8);
            this.gIb.setVisibility(8);
            return;
        }
        this.gHZ.setVisibility(0);
        this.gIb.setVisibility(0);
    }

    public void wP(boolean z) {
        if (this.gIc != null) {
            if (z) {
                SvgManager.bwr().a(this.gIc, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bwr().a(this.mAz, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bwr().a(this.mAy, R.drawable.icon_pure_topbar_createchat44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return;
            }
            SvgManager.bwr().a(this.gIc, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bwr().a(this.mAz, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bwr().a(this.mAy, R.drawable.icon_pure_topbar_createchat44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mAx != null) {
            ao.setBackgroundColor(this.mAx, R.color.CAM_X0201);
        }
        ao.setBackgroundColor(this.gHZ, R.color.CAM_X0201);
        ao.setViewTextColor(this.gIb, R.color.CAM_X0105);
        wP(this.gHZ.getAlpha() > 0.5f);
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        this.mAA = fVar;
    }
}
