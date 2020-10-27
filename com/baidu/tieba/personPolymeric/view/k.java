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
/* loaded from: classes24.dex */
public class k {
    private RelativeLayout gjp;
    private View gjq;
    private TextView gjs;
    private ImageView gjt;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private int mStatusBarHeight;
    private UserData mUserData;
    private View maN;
    private ImageView maO;
    private ImageView maP;
    private com.baidu.tieba.view.f maQ;
    private PersonStatus maR;

    public k(TbPageContext tbPageContext, View view, View view2, boolean z) {
        this(tbPageContext, view, z);
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.maN = view2;
        QR();
    }

    public k(TbPageContext tbPageContext, View view, boolean z) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.gjp = (RelativeLayout) view.findViewById(R.id.person_center_nav_layout);
        this.gjq = view.findViewById(R.id.person_center_nav_bg);
        this.gjs = (TextView) view.findViewById(R.id.person_center_nav_title);
        this.gjt = (ImageView) view.findViewById(R.id.person_center_nav_back_img);
        this.gjt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (k.this.maQ == null) {
                    if (k.this.mPageContext != null) {
                        k.this.mPageContext.getPageActivity().finish();
                        return;
                    }
                    return;
                }
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.imR = 8;
                k.this.maQ.a(view2, bVar);
            }
        });
        this.maO = (ImageView) view.findViewById(R.id.person_center_nav_chat_img);
        this.maO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new aq("c12503").dR("obj_locate", "1"));
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.imR = 40;
                bVar.imS = new Bundle();
                bVar.imS.putSerializable(UserData.TYPE_USER, k.this.mUserData);
                if (k.this.maQ != null) {
                    k.this.maQ.a(view2, bVar);
                }
            }
        });
        this.maP = (ImageView) view.findViewById(R.id.person_center_nav_more_img);
        this.maP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TiebaStatic.log(new aq("c12503").dR("obj_locate", "2"));
                    if (k.this.maQ != null) {
                        com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                        bVar.imR = 9;
                        k.this.maQ.a(view2, bVar);
                    }
                }
            }
        });
    }

    private void QR() {
        if (this.maN != null) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                ViewGroup.LayoutParams layoutParams = this.maN.getLayoutParams();
                layoutParams.height = this.mStatusBarHeight;
                this.maN.setLayoutParams(layoutParams);
                return;
            }
            this.maN.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, PersonStatus personStatus) {
        if (aVar != null && aVar.getUserData() != null) {
            this.mUserData = aVar.getUserData();
            this.gjs.setText(this.mUserData.getName_show());
        }
        this.maR = personStatus;
        dtO();
    }

    public void a(PersonStatus personStatus) {
        this.maR = personStatus;
        dtO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dtO() {
        if (this.mIsHost) {
            this.maP.setVisibility(8);
            this.maO.setVisibility(8);
        } else if (TbadkCoreApplication.isLogin()) {
            this.maO.setVisibility(0);
            this.maP.setVisibility(0);
        } else {
            this.maP.setVisibility(8);
            this.maO.setVisibility(8);
        }
    }

    public View dtP() {
        return this.gjp;
    }

    public boolean dtQ() {
        return this.mIsHost;
    }

    public void aI(float f) {
        float f2;
        float f3 = 1.0f;
        if (f >= 0.0f || f <= 1.0f) {
            if (this.maN != null) {
                this.maN.setAlpha(f);
            }
            this.gjq.setAlpha(f);
            this.gjs.setAlpha(f);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 <= 1.0f) {
            f3 = f2 < 0.0f ? 0.0f : f2;
        }
        this.gjt.setAlpha(f3);
        this.maP.setAlpha(f3);
        this.maO.setAlpha(f3);
    }

    public void vX(boolean z) {
        if (z) {
            this.gjq.setVisibility(8);
            this.gjs.setVisibility(8);
            return;
        }
        this.gjq.setVisibility(0);
        this.gjs.setVisibility(0);
    }

    public void vY(boolean z) {
        if (this.gjt != null) {
            if (z) {
                SvgManager.boN().a(this.gjt, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.boN().a(this.maP, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.boN().a(this.maO, R.drawable.icon_pure_topbar_createchat44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return;
            }
            SvgManager.boN().a(this.gjt, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.boN().a(this.maP, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.boN().a(this.maO, R.drawable.icon_pure_topbar_createchat44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.maN != null) {
            ap.setBackgroundColor(this.maN, R.color.cp_bg_line_d);
        }
        ap.setBackgroundColor(this.gjq, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.gjs, R.color.cp_cont_b);
        vY(this.gjq.getAlpha() > 0.5f);
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        this.maQ = fVar;
    }
}
