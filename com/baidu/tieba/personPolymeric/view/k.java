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
/* loaded from: classes24.dex */
public class k {
    private RelativeLayout gwS;
    private View gwT;
    private TextView gwV;
    private ImageView gwW;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private int mStatusBarHeight;
    private UserData mUserData;
    private View mvj;
    private ImageView mvk;
    private ImageView mvl;
    private com.baidu.tieba.view.f mvm;
    private PersonStatus mvn;

    public k(TbPageContext tbPageContext, View view, View view2, boolean z) {
        this(tbPageContext, view, z);
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.mvj = view2;
        Vq();
    }

    public k(TbPageContext tbPageContext, View view, boolean z) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.gwS = (RelativeLayout) view.findViewById(R.id.person_center_nav_layout);
        this.gwT = view.findViewById(R.id.person_center_nav_bg);
        this.gwV = (TextView) view.findViewById(R.id.person_center_nav_title);
        this.gwW = (ImageView) view.findViewById(R.id.person_center_nav_back_img);
        this.gwW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (k.this.mvm == null) {
                    if (k.this.mPageContext != null) {
                        k.this.mPageContext.getPageActivity().finish();
                        return;
                    }
                    return;
                }
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.iEv = 8;
                k.this.mvm.a(view2, bVar);
            }
        });
        this.mvk = (ImageView) view.findViewById(R.id.person_center_nav_chat_img);
        this.mvk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new ar("c12503").dY("obj_locate", "1"));
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.iEv = 40;
                bVar.iEw = new Bundle();
                bVar.iEw.putSerializable(UserData.TYPE_USER, k.this.mUserData);
                if (k.this.mvm != null) {
                    k.this.mvm.a(view2, bVar);
                }
            }
        });
        this.mvl = (ImageView) view.findViewById(R.id.person_center_nav_more_img);
        this.mvl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TiebaStatic.log(new ar("c12503").dY("obj_locate", "2"));
                    if (k.this.mvm != null) {
                        com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                        bVar.iEv = 9;
                        k.this.mvm.a(view2, bVar);
                    }
                }
            }
        });
    }

    private void Vq() {
        if (this.mvj != null) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                ViewGroup.LayoutParams layoutParams = this.mvj.getLayoutParams();
                layoutParams.height = this.mStatusBarHeight;
                this.mvj.setLayoutParams(layoutParams);
                return;
            }
            this.mvj.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, PersonStatus personStatus) {
        if (aVar != null && aVar.getUserData() != null) {
            this.mUserData = aVar.getUserData();
            this.gwV.setText(this.mUserData.getName_show());
        }
        this.mvn = personStatus;
        dBi();
    }

    public void a(PersonStatus personStatus) {
        this.mvn = personStatus;
        dBi();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dBi() {
        if (this.mIsHost) {
            this.mvl.setVisibility(8);
            this.mvk.setVisibility(8);
        } else if (TbadkCoreApplication.isLogin()) {
            this.mvk.setVisibility(0);
            this.mvl.setVisibility(0);
        } else {
            this.mvl.setVisibility(8);
            this.mvk.setVisibility(8);
        }
    }

    public View dBj() {
        return this.gwS;
    }

    public boolean dBk() {
        return this.mIsHost;
    }

    public void aS(float f) {
        float f2;
        float f3 = 1.0f;
        if (f >= 0.0f || f <= 1.0f) {
            if (this.mvj != null) {
                this.mvj.setAlpha(f);
            }
            this.gwT.setAlpha(f);
            this.gwV.setAlpha(f);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 <= 1.0f) {
            f3 = f2 < 0.0f ? 0.0f : f2;
        }
        this.gwW.setAlpha(f3);
        this.mvl.setAlpha(f3);
        this.mvk.setAlpha(f3);
    }

    public void wN(boolean z) {
        if (z) {
            this.gwT.setVisibility(8);
            this.gwV.setVisibility(8);
            return;
        }
        this.gwT.setVisibility(0);
        this.gwV.setVisibility(0);
    }

    public void wO(boolean z) {
        if (this.gwW != null) {
            if (z) {
                SvgManager.btW().a(this.gwW, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.btW().a(this.mvl, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.btW().a(this.mvk, R.drawable.icon_pure_topbar_createchat44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return;
            }
            SvgManager.btW().a(this.gwW, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.btW().a(this.mvl, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.btW().a(this.mvk, R.drawable.icon_pure_topbar_createchat44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mvj != null) {
            ap.setBackgroundColor(this.mvj, R.color.CAM_X0201);
        }
        ap.setBackgroundColor(this.gwT, R.color.CAM_X0201);
        ap.setViewTextColor(this.gwV, R.color.CAM_X0105);
        wO(this.gwT.getAlpha() > 0.5f);
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        this.mvm = fVar;
    }
}
