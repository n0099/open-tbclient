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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.constant.PersonStatus;
/* loaded from: classes23.dex */
public class k {
    private RelativeLayout goJ;
    private View goK;
    private TextView goM;
    private ImageView goN;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private int mStatusBarHeight;
    private UserData mUserData;
    private View mhd;
    private ImageView mhe;
    private ImageView mhf;
    private com.baidu.tieba.view.f mhg;
    private PersonStatus mhh;

    public k(TbPageContext tbPageContext, View view, View view2, boolean z) {
        this(tbPageContext, view, z);
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.mhd = view2;
        SQ();
    }

    public k(TbPageContext tbPageContext, View view, boolean z) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.goJ = (RelativeLayout) view.findViewById(R.id.person_center_nav_layout);
        this.goK = view.findViewById(R.id.person_center_nav_bg);
        this.goM = (TextView) view.findViewById(R.id.person_center_nav_title);
        this.goN = (ImageView) view.findViewById(R.id.person_center_nav_back_img);
        this.goN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (k.this.mhg == null) {
                    if (k.this.mPageContext != null) {
                        k.this.mPageContext.getPageActivity().finish();
                        return;
                    }
                    return;
                }
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.itD = 8;
                k.this.mhg.a(view2, bVar);
            }
        });
        this.mhe = (ImageView) view.findViewById(R.id.person_center_nav_chat_img);
        this.mhe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new ar("c12503").dR("obj_locate", "1"));
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.itD = 40;
                bVar.itE = new Bundle();
                bVar.itE.putSerializable(UserData.TYPE_USER, k.this.mUserData);
                if (k.this.mhg != null) {
                    k.this.mhg.a(view2, bVar);
                }
            }
        });
        this.mhf = (ImageView) view.findViewById(R.id.person_center_nav_more_img);
        this.mhf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TiebaStatic.log(new ar("c12503").dR("obj_locate", "2"));
                    if (k.this.mhg != null) {
                        com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                        bVar.itD = 9;
                        k.this.mhg.a(view2, bVar);
                    }
                }
            }
        });
    }

    private void SQ() {
        if (this.mhd != null) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                ViewGroup.LayoutParams layoutParams = this.mhd.getLayoutParams();
                layoutParams.height = this.mStatusBarHeight;
                this.mhd.setLayoutParams(layoutParams);
                return;
            }
            this.mhd.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, PersonStatus personStatus) {
        if (aVar != null && aVar.getUserData() != null) {
            this.mUserData = aVar.getUserData();
            this.goM.setText(this.mUserData.getName_show());
        }
        this.mhh = personStatus;
        dvQ();
    }

    public void a(PersonStatus personStatus) {
        this.mhh = personStatus;
        dvQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dvQ() {
        if (this.mIsHost) {
            this.mhf.setVisibility(8);
            this.mhe.setVisibility(8);
        } else if (TbadkCoreApplication.isLogin()) {
            this.mhe.setVisibility(0);
            this.mhf.setVisibility(0);
        } else {
            this.mhf.setVisibility(8);
            this.mhe.setVisibility(8);
        }
    }

    public View dvR() {
        return this.goJ;
    }

    public boolean dvS() {
        return this.mIsHost;
    }

    public void aR(float f) {
        float f2;
        float f3 = 1.0f;
        if (f >= 0.0f || f <= 1.0f) {
            if (this.mhd != null) {
                this.mhd.setAlpha(f);
            }
            this.goK.setAlpha(f);
            this.goM.setAlpha(f);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 <= 1.0f) {
            f3 = f2 < 0.0f ? 0.0f : f2;
        }
        this.goN.setAlpha(f3);
        this.mhf.setAlpha(f3);
        this.mhe.setAlpha(f3);
    }

    public void wj(boolean z) {
        if (z) {
            this.goK.setVisibility(8);
            this.goM.setVisibility(8);
            return;
        }
        this.goK.setVisibility(0);
        this.goM.setVisibility(0);
    }

    public void wk(boolean z) {
        if (this.goN != null) {
            if (z) {
                SvgManager.bqB().a(this.goN, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bqB().a(this.mhf, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bqB().a(this.mhe, R.drawable.icon_pure_topbar_createchat44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return;
            }
            SvgManager.bqB().a(this.goN, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bqB().a(this.mhf, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bqB().a(this.mhe, R.drawable.icon_pure_topbar_createchat44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mhd != null) {
            ap.setBackgroundColor(this.mhd, R.color.CAM_X0201);
        }
        ap.setBackgroundColor(this.goK, R.color.CAM_X0201);
        ap.setViewTextColor(this.goM, R.color.CAM_X0105);
        wk(this.goK.getAlpha() > 0.5f);
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        this.mhg = fVar;
    }
}
