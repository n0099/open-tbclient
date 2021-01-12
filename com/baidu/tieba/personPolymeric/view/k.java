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
/* loaded from: classes7.dex */
public class k {
    private RelativeLayout gDs;
    private View gDt;
    private TextView gDv;
    private ImageView gDw;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private int mStatusBarHeight;
    private UserData mUserData;
    private View mvT;
    private ImageView mvU;
    private ImageView mvV;
    private com.baidu.tieba.view.f mvW;
    private PersonStatus mvX;

    public k(TbPageContext tbPageContext, View view, View view2, boolean z) {
        this(tbPageContext, view, z);
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.mvT = view2;
        SA();
    }

    public k(TbPageContext tbPageContext, View view, boolean z) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.gDs = (RelativeLayout) view.findViewById(R.id.person_center_nav_layout);
        this.gDt = view.findViewById(R.id.person_center_nav_bg);
        this.gDv = (TextView) view.findViewById(R.id.person_center_nav_title);
        this.gDw = (ImageView) view.findViewById(R.id.person_center_nav_back_img);
        this.gDw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (k.this.mvW == null) {
                    if (k.this.mPageContext != null) {
                        k.this.mPageContext.getPageActivity().finish();
                        return;
                    }
                    return;
                }
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.iMc = 8;
                k.this.mvW.a(view2, bVar);
            }
        });
        this.mvU = (ImageView) view.findViewById(R.id.person_center_nav_chat_img);
        this.mvU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new aq("c12503").dW("obj_locate", "1"));
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.iMc = 40;
                bVar.iMd = new Bundle();
                bVar.iMd.putSerializable(UserData.TYPE_USER, k.this.mUserData);
                if (k.this.mvW != null) {
                    k.this.mvW.a(view2, bVar);
                }
            }
        });
        this.mvV = (ImageView) view.findViewById(R.id.person_center_nav_more_img);
        this.mvV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TiebaStatic.log(new aq("c12503").dW("obj_locate", "2"));
                    if (k.this.mvW != null) {
                        com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                        bVar.iMc = 9;
                        k.this.mvW.a(view2, bVar);
                    }
                }
            }
        });
    }

    private void SA() {
        if (this.mvT != null) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                ViewGroup.LayoutParams layoutParams = this.mvT.getLayoutParams();
                layoutParams.height = this.mStatusBarHeight;
                this.mvT.setLayoutParams(layoutParams);
                return;
            }
            this.mvT.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, PersonStatus personStatus) {
        if (aVar != null && aVar.getUserData() != null) {
            this.mUserData = aVar.getUserData();
            this.gDv.setText(this.mUserData.getName_show());
        }
        this.mvX = personStatus;
        dxh();
    }

    public void a(PersonStatus personStatus) {
        this.mvX = personStatus;
        dxh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dxh() {
        if (this.mIsHost) {
            this.mvV.setVisibility(8);
            this.mvU.setVisibility(8);
        } else if (TbadkCoreApplication.isLogin()) {
            this.mvU.setVisibility(0);
            this.mvV.setVisibility(0);
        } else {
            this.mvV.setVisibility(8);
            this.mvU.setVisibility(8);
        }
    }

    public View dxi() {
        return this.gDs;
    }

    public boolean dxj() {
        return this.mIsHost;
    }

    public void aU(float f) {
        float f2;
        float f3 = 1.0f;
        if (f >= 0.0f || f <= 1.0f) {
            if (this.mvT != null) {
                this.mvT.setAlpha(f);
            }
            this.gDt.setAlpha(f);
            this.gDv.setAlpha(f);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 <= 1.0f) {
            f3 = f2 < 0.0f ? 0.0f : f2;
        }
        this.gDw.setAlpha(f3);
        this.mvV.setAlpha(f3);
        this.mvU.setAlpha(f3);
    }

    public void wK(boolean z) {
        if (z) {
            this.gDt.setVisibility(8);
            this.gDv.setVisibility(8);
            return;
        }
        this.gDt.setVisibility(0);
        this.gDv.setVisibility(0);
    }

    public void wL(boolean z) {
        if (this.gDw != null) {
            if (z) {
                SvgManager.bsx().a(this.gDw, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bsx().a(this.mvV, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bsx().a(this.mvU, R.drawable.icon_pure_topbar_createchat44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return;
            }
            SvgManager.bsx().a(this.gDw, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bsx().a(this.mvV, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bsx().a(this.mvU, R.drawable.icon_pure_topbar_createchat44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mvT != null) {
            ao.setBackgroundColor(this.mvT, R.color.CAM_X0201);
        }
        ao.setBackgroundColor(this.gDt, R.color.CAM_X0201);
        ao.setViewTextColor(this.gDv, R.color.CAM_X0105);
        wL(this.gDt.getAlpha() > 0.5f);
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        this.mvW = fVar;
    }
}
