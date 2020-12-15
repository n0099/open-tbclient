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
    private RelativeLayout gwU;
    private View gwV;
    private TextView gwX;
    private ImageView gwY;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private int mStatusBarHeight;
    private UserData mUserData;
    private View mvl;
    private ImageView mvm;
    private ImageView mvn;
    private com.baidu.tieba.view.f mvo;
    private PersonStatus mvp;

    public k(TbPageContext tbPageContext, View view, View view2, boolean z) {
        this(tbPageContext, view, z);
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.mvl = view2;
        Vq();
    }

    public k(TbPageContext tbPageContext, View view, boolean z) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.gwU = (RelativeLayout) view.findViewById(R.id.person_center_nav_layout);
        this.gwV = view.findViewById(R.id.person_center_nav_bg);
        this.gwX = (TextView) view.findViewById(R.id.person_center_nav_title);
        this.gwY = (ImageView) view.findViewById(R.id.person_center_nav_back_img);
        this.gwY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (k.this.mvo == null) {
                    if (k.this.mPageContext != null) {
                        k.this.mPageContext.getPageActivity().finish();
                        return;
                    }
                    return;
                }
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.iEx = 8;
                k.this.mvo.a(view2, bVar);
            }
        });
        this.mvm = (ImageView) view.findViewById(R.id.person_center_nav_chat_img);
        this.mvm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new ar("c12503").dY("obj_locate", "1"));
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.iEx = 40;
                bVar.iEy = new Bundle();
                bVar.iEy.putSerializable(UserData.TYPE_USER, k.this.mUserData);
                if (k.this.mvo != null) {
                    k.this.mvo.a(view2, bVar);
                }
            }
        });
        this.mvn = (ImageView) view.findViewById(R.id.person_center_nav_more_img);
        this.mvn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TiebaStatic.log(new ar("c12503").dY("obj_locate", "2"));
                    if (k.this.mvo != null) {
                        com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                        bVar.iEx = 9;
                        k.this.mvo.a(view2, bVar);
                    }
                }
            }
        });
    }

    private void Vq() {
        if (this.mvl != null) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                ViewGroup.LayoutParams layoutParams = this.mvl.getLayoutParams();
                layoutParams.height = this.mStatusBarHeight;
                this.mvl.setLayoutParams(layoutParams);
                return;
            }
            this.mvl.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, PersonStatus personStatus) {
        if (aVar != null && aVar.getUserData() != null) {
            this.mUserData = aVar.getUserData();
            this.gwX.setText(this.mUserData.getName_show());
        }
        this.mvp = personStatus;
        dBj();
    }

    public void a(PersonStatus personStatus) {
        this.mvp = personStatus;
        dBj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dBj() {
        if (this.mIsHost) {
            this.mvn.setVisibility(8);
            this.mvm.setVisibility(8);
        } else if (TbadkCoreApplication.isLogin()) {
            this.mvm.setVisibility(0);
            this.mvn.setVisibility(0);
        } else {
            this.mvn.setVisibility(8);
            this.mvm.setVisibility(8);
        }
    }

    public View dBk() {
        return this.gwU;
    }

    public boolean dBl() {
        return this.mIsHost;
    }

    public void aS(float f) {
        float f2;
        float f3 = 1.0f;
        if (f >= 0.0f || f <= 1.0f) {
            if (this.mvl != null) {
                this.mvl.setAlpha(f);
            }
            this.gwV.setAlpha(f);
            this.gwX.setAlpha(f);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 <= 1.0f) {
            f3 = f2 < 0.0f ? 0.0f : f2;
        }
        this.gwY.setAlpha(f3);
        this.mvn.setAlpha(f3);
        this.mvm.setAlpha(f3);
    }

    public void wN(boolean z) {
        if (z) {
            this.gwV.setVisibility(8);
            this.gwX.setVisibility(8);
            return;
        }
        this.gwV.setVisibility(0);
        this.gwX.setVisibility(0);
    }

    public void wO(boolean z) {
        if (this.gwY != null) {
            if (z) {
                SvgManager.btW().a(this.gwY, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.btW().a(this.mvn, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.btW().a(this.mvm, R.drawable.icon_pure_topbar_createchat44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return;
            }
            SvgManager.btW().a(this.gwY, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.btW().a(this.mvn, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.btW().a(this.mvm, R.drawable.icon_pure_topbar_createchat44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mvl != null) {
            ap.setBackgroundColor(this.mvl, R.color.CAM_X0201);
        }
        ap.setBackgroundColor(this.gwV, R.color.CAM_X0201);
        ap.setViewTextColor(this.gwX, (int) R.color.CAM_X0105);
        wO(this.gwV.getAlpha() > 0.5f);
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        this.mvo = fVar;
    }
}
