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
/* loaded from: classes8.dex */
public class k {
    private RelativeLayout gGc;
    private View gGd;
    private TextView gGf;
    private ImageView gGg;
    private View mEX;
    private ImageView mEY;
    private ImageView mEZ;
    private com.baidu.tieba.view.f mFa;
    private PersonStatus mFb;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private int mStatusBarHeight;
    private UserData mUserData;

    public k(TbPageContext tbPageContext, View view, View view2, boolean z) {
        this(tbPageContext, view, z);
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.mEX = view2;
        Uh();
    }

    public k(TbPageContext tbPageContext, View view, boolean z) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.gGc = (RelativeLayout) view.findViewById(R.id.person_center_nav_layout);
        this.gGd = view.findViewById(R.id.person_center_nav_bg);
        this.gGf = (TextView) view.findViewById(R.id.person_center_nav_title);
        this.gGg = (ImageView) view.findViewById(R.id.person_center_nav_back_img);
        this.gGg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (k.this.mFa == null) {
                    if (k.this.mPageContext != null) {
                        k.this.mPageContext.getPageActivity().finish();
                        return;
                    }
                    return;
                }
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.iRK = 8;
                k.this.mFa.a(view2, bVar);
            }
        });
        this.mEY = (ImageView) view.findViewById(R.id.person_center_nav_chat_img);
        this.mEY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new ar("c12503").dR("obj_locate", "1"));
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.iRK = 40;
                bVar.iRL = new Bundle();
                bVar.iRL.putSerializable(UserData.TYPE_USER, k.this.mUserData);
                if (k.this.mFa != null) {
                    k.this.mFa.a(view2, bVar);
                }
            }
        });
        this.mEZ = (ImageView) view.findViewById(R.id.person_center_nav_more_img);
        this.mEZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TiebaStatic.log(new ar("c12503").dR("obj_locate", "2"));
                    if (k.this.mFa != null) {
                        com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                        bVar.iRK = 9;
                        k.this.mFa.a(view2, bVar);
                    }
                }
            }
        });
    }

    private void Uh() {
        if (this.mEX != null) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                ViewGroup.LayoutParams layoutParams = this.mEX.getLayoutParams();
                layoutParams.height = this.mStatusBarHeight;
                this.mEX.setLayoutParams(layoutParams);
                return;
            }
            this.mEX.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, PersonStatus personStatus) {
        if (aVar != null && aVar.getUserData() != null) {
            this.mUserData = aVar.getUserData();
            this.gGf.setText(this.mUserData.getName_show());
        }
        this.mFb = personStatus;
        dzq();
    }

    public void a(PersonStatus personStatus) {
        this.mFb = personStatus;
        dzq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dzq() {
        if (this.mIsHost) {
            this.mEZ.setVisibility(8);
            this.mEY.setVisibility(8);
        } else if (TbadkCoreApplication.isLogin()) {
            this.mEY.setVisibility(0);
            this.mEZ.setVisibility(0);
        } else {
            this.mEZ.setVisibility(8);
            this.mEY.setVisibility(8);
        }
    }

    public View dzr() {
        return this.gGc;
    }

    public boolean dzs() {
        return this.mIsHost;
    }

    public void aX(float f) {
        float f2;
        float f3 = 1.0f;
        if (f >= 0.0f || f <= 1.0f) {
            if (this.mEX != null) {
                this.mEX.setAlpha(f);
            }
            this.gGd.setAlpha(f);
            this.gGf.setAlpha(f);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 <= 1.0f) {
            f3 = f2 < 0.0f ? 0.0f : f2;
        }
        this.gGg.setAlpha(f3);
        this.mEZ.setAlpha(f3);
        this.mEY.setAlpha(f3);
    }

    public void xb(boolean z) {
        if (z) {
            this.gGd.setVisibility(8);
            this.gGf.setVisibility(8);
            return;
        }
        this.gGd.setVisibility(0);
        this.gGf.setVisibility(0);
    }

    public void xc(boolean z) {
        if (this.gGg != null) {
            if (z) {
                SvgManager.bsR().a(this.gGg, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bsR().a(this.mEZ, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bsR().a(this.mEY, R.drawable.icon_pure_topbar_createchat44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return;
            }
            SvgManager.bsR().a(this.gGg, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bsR().a(this.mEZ, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bsR().a(this.mEY, R.drawable.icon_pure_topbar_createchat44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mEX != null) {
            ap.setBackgroundColor(this.mEX, R.color.CAM_X0201);
        }
        ap.setBackgroundColor(this.gGd, R.color.CAM_X0201);
        ap.setViewTextColor(this.gGf, R.color.CAM_X0105);
        xc(this.gGd.getAlpha() > 0.5f);
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        this.mFa = fVar;
    }
}
