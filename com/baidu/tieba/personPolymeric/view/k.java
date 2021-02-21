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
    private RelativeLayout gGq;
    private View gGr;
    private TextView gGt;
    private ImageView gGu;
    private View mFm;
    private ImageView mFn;
    private ImageView mFo;
    private com.baidu.tieba.view.f mFp;
    private PersonStatus mFq;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private int mStatusBarHeight;
    private UserData mUserData;

    public k(TbPageContext tbPageContext, View view, View view2, boolean z) {
        this(tbPageContext, view, z);
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.mFm = view2;
        Uh();
    }

    public k(TbPageContext tbPageContext, View view, boolean z) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.gGq = (RelativeLayout) view.findViewById(R.id.person_center_nav_layout);
        this.gGr = view.findViewById(R.id.person_center_nav_bg);
        this.gGt = (TextView) view.findViewById(R.id.person_center_nav_title);
        this.gGu = (ImageView) view.findViewById(R.id.person_center_nav_back_img);
        this.gGu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (k.this.mFp == null) {
                    if (k.this.mPageContext != null) {
                        k.this.mPageContext.getPageActivity().finish();
                        return;
                    }
                    return;
                }
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.iRY = 8;
                k.this.mFp.a(view2, bVar);
            }
        });
        this.mFn = (ImageView) view.findViewById(R.id.person_center_nav_chat_img);
        this.mFn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new ar("c12503").dR("obj_locate", "1"));
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.iRY = 40;
                bVar.iRZ = new Bundle();
                bVar.iRZ.putSerializable(UserData.TYPE_USER, k.this.mUserData);
                if (k.this.mFp != null) {
                    k.this.mFp.a(view2, bVar);
                }
            }
        });
        this.mFo = (ImageView) view.findViewById(R.id.person_center_nav_more_img);
        this.mFo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TiebaStatic.log(new ar("c12503").dR("obj_locate", "2"));
                    if (k.this.mFp != null) {
                        com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                        bVar.iRY = 9;
                        k.this.mFp.a(view2, bVar);
                    }
                }
            }
        });
    }

    private void Uh() {
        if (this.mFm != null) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                ViewGroup.LayoutParams layoutParams = this.mFm.getLayoutParams();
                layoutParams.height = this.mStatusBarHeight;
                this.mFm.setLayoutParams(layoutParams);
                return;
            }
            this.mFm.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, PersonStatus personStatus) {
        if (aVar != null && aVar.getUserData() != null) {
            this.mUserData = aVar.getUserData();
            this.gGt.setText(this.mUserData.getName_show());
        }
        this.mFq = personStatus;
        dzx();
    }

    public void a(PersonStatus personStatus) {
        this.mFq = personStatus;
        dzx();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dzx() {
        if (this.mIsHost) {
            this.mFo.setVisibility(8);
            this.mFn.setVisibility(8);
        } else if (TbadkCoreApplication.isLogin()) {
            this.mFn.setVisibility(0);
            this.mFo.setVisibility(0);
        } else {
            this.mFo.setVisibility(8);
            this.mFn.setVisibility(8);
        }
    }

    public View dzy() {
        return this.gGq;
    }

    public boolean dzz() {
        return this.mIsHost;
    }

    public void aX(float f) {
        float f2;
        float f3 = 1.0f;
        if (f >= 0.0f || f <= 1.0f) {
            if (this.mFm != null) {
                this.mFm.setAlpha(f);
            }
            this.gGr.setAlpha(f);
            this.gGt.setAlpha(f);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 <= 1.0f) {
            f3 = f2 < 0.0f ? 0.0f : f2;
        }
        this.gGu.setAlpha(f3);
        this.mFo.setAlpha(f3);
        this.mFn.setAlpha(f3);
    }

    public void xb(boolean z) {
        if (z) {
            this.gGr.setVisibility(8);
            this.gGt.setVisibility(8);
            return;
        }
        this.gGr.setVisibility(0);
        this.gGt.setVisibility(0);
    }

    public void xc(boolean z) {
        if (this.gGu != null) {
            if (z) {
                SvgManager.bsR().a(this.gGu, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bsR().a(this.mFo, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bsR().a(this.mFn, R.drawable.icon_pure_topbar_createchat44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return;
            }
            SvgManager.bsR().a(this.gGu, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bsR().a(this.mFo, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bsR().a(this.mFn, R.drawable.icon_pure_topbar_createchat44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mFm != null) {
            ap.setBackgroundColor(this.mFm, R.color.CAM_X0201);
        }
        ap.setBackgroundColor(this.gGr, R.color.CAM_X0201);
        ap.setViewTextColor(this.gGt, R.color.CAM_X0105);
        xc(this.gGr.getAlpha() > 0.5f);
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        this.mFp = fVar;
    }
}
