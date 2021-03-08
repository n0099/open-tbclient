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
/* loaded from: classes7.dex */
public class k {
    private RelativeLayout gHZ;
    private View gIa;
    private TextView gIc;
    private ImageView gId;
    private View mHp;
    private ImageView mHq;
    private ImageView mHr;
    private com.baidu.tieba.view.f mHs;
    private PersonStatus mHt;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private int mStatusBarHeight;
    private UserData mUserData;

    public k(TbPageContext tbPageContext, View view, View view2, boolean z) {
        this(tbPageContext, view, z);
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.mHp = view2;
        Uk();
    }

    public k(TbPageContext tbPageContext, View view, boolean z) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.gHZ = (RelativeLayout) view.findViewById(R.id.person_center_nav_layout);
        this.gIa = view.findViewById(R.id.person_center_nav_bg);
        this.gIc = (TextView) view.findViewById(R.id.person_center_nav_title);
        this.gId = (ImageView) view.findViewById(R.id.person_center_nav_back_img);
        this.gId.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (k.this.mHs == null) {
                    if (k.this.mPageContext != null) {
                        k.this.mPageContext.getPageActivity().finish();
                        return;
                    }
                    return;
                }
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.iTH = 8;
                k.this.mHs.a(view2, bVar);
            }
        });
        this.mHq = (ImageView) view.findViewById(R.id.person_center_nav_chat_img);
        this.mHq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new ar("c12503").dR("obj_locate", "1"));
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.iTH = 40;
                bVar.iTI = new Bundle();
                bVar.iTI.putSerializable(UserData.TYPE_USER, k.this.mUserData);
                if (k.this.mHs != null) {
                    k.this.mHs.a(view2, bVar);
                }
            }
        });
        this.mHr = (ImageView) view.findViewById(R.id.person_center_nav_more_img);
        this.mHr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TiebaStatic.log(new ar("c12503").dR("obj_locate", "2"));
                    if (k.this.mHs != null) {
                        com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                        bVar.iTH = 9;
                        k.this.mHs.a(view2, bVar);
                    }
                }
            }
        });
    }

    private void Uk() {
        if (this.mHp != null) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                ViewGroup.LayoutParams layoutParams = this.mHp.getLayoutParams();
                layoutParams.height = this.mStatusBarHeight;
                this.mHp.setLayoutParams(layoutParams);
                return;
            }
            this.mHp.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, PersonStatus personStatus) {
        if (aVar != null && aVar.getUserData() != null) {
            this.mUserData = aVar.getUserData();
            this.gIc.setText(this.mUserData.getName_show());
        }
        this.mHt = personStatus;
        dzG();
    }

    public void a(PersonStatus personStatus) {
        this.mHt = personStatus;
        dzG();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dzG() {
        if (this.mIsHost) {
            this.mHr.setVisibility(8);
            this.mHq.setVisibility(8);
        } else if (TbadkCoreApplication.isLogin()) {
            this.mHq.setVisibility(0);
            this.mHr.setVisibility(0);
        } else {
            this.mHr.setVisibility(8);
            this.mHq.setVisibility(8);
        }
    }

    public View dzH() {
        return this.gHZ;
    }

    public boolean dzI() {
        return this.mIsHost;
    }

    public void bb(float f) {
        float f2;
        float f3 = 1.0f;
        if (f >= 0.0f || f <= 1.0f) {
            if (this.mHp != null) {
                this.mHp.setAlpha(f);
            }
            this.gIa.setAlpha(f);
            this.gIc.setAlpha(f);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 <= 1.0f) {
            f3 = f2 < 0.0f ? 0.0f : f2;
        }
        this.gId.setAlpha(f3);
        this.mHr.setAlpha(f3);
        this.mHq.setAlpha(f3);
    }

    public void xb(boolean z) {
        if (z) {
            this.gIa.setVisibility(8);
            this.gIc.setVisibility(8);
            return;
        }
        this.gIa.setVisibility(0);
        this.gIc.setVisibility(0);
    }

    public void xc(boolean z) {
        if (this.gId != null) {
            if (z) {
                SvgManager.bsU().a(this.gId, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bsU().a(this.mHr, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bsU().a(this.mHq, R.drawable.icon_pure_topbar_createchat44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return;
            }
            SvgManager.bsU().a(this.gId, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bsU().a(this.mHr, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bsU().a(this.mHq, R.drawable.icon_pure_topbar_createchat44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mHp != null) {
            ap.setBackgroundColor(this.mHp, R.color.CAM_X0201);
        }
        ap.setBackgroundColor(this.gIa, R.color.CAM_X0201);
        ap.setViewTextColor(this.gIc, R.color.CAM_X0105);
        xc(this.gIa.getAlpha() > 0.5f);
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        this.mHs = fVar;
    }
}
