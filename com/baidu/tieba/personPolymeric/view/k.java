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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.constant.PersonStatus;
/* loaded from: classes11.dex */
public class k {
    private RelativeLayout eqV;
    private View eqW;
    private TextView eqY;
    private ImageView eqZ;
    private View jrW;
    private ImageView jrX;
    private ImageView jrY;
    private com.baidu.tieba.view.e jrZ;
    private PersonStatus jsa;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private int mStatusBarHeight;
    private UserData mUserData;

    public k(TbPageContext tbPageContext, View view, View view2, boolean z) {
        this(tbPageContext, view, z);
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.jrW = view2;
        Ah();
    }

    public k(TbPageContext tbPageContext, View view, boolean z) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.eqV = (RelativeLayout) view.findViewById(R.id.person_center_nav_layout);
        this.eqW = view.findViewById(R.id.person_center_nav_bg);
        this.eqY = (TextView) view.findViewById(R.id.person_center_nav_title);
        this.eqZ = (ImageView) view.findViewById(R.id.person_center_nav_back_img);
        this.eqZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (k.this.jrZ == null) {
                    if (k.this.mPageContext != null) {
                        k.this.mPageContext.getPageActivity().finish();
                        return;
                    }
                    return;
                }
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.gaE = 8;
                k.this.jrZ.a(view2, bVar);
            }
        });
        this.jrX = (ImageView) view.findViewById(R.id.person_center_nav_chat_img);
        this.jrX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new an("c12503").cy("obj_locate", "1"));
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.gaE = 40;
                bVar.gaF = new Bundle();
                bVar.gaF.putSerializable(UserData.TYPE_USER, k.this.mUserData);
                if (k.this.jrZ != null) {
                    k.this.jrZ.a(view2, bVar);
                }
            }
        });
        this.jrY = (ImageView) view.findViewById(R.id.person_center_nav_more_img);
        this.jrY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TiebaStatic.log(new an("c12503").cy("obj_locate", "2"));
                    if (k.this.jrZ != null) {
                        com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                        bVar.gaE = 9;
                        k.this.jrZ.a(view2, bVar);
                    }
                }
            }
        });
    }

    private void Ah() {
        if (this.jrW != null) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                ViewGroup.LayoutParams layoutParams = this.jrW.getLayoutParams();
                layoutParams.height = this.mStatusBarHeight;
                this.jrW.setLayoutParams(layoutParams);
                return;
            }
            this.jrW.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, PersonStatus personStatus) {
        if (aVar != null && aVar.getUserData() != null) {
            this.mUserData = aVar.getUserData();
            this.eqY.setText(this.mUserData.getName_show());
        }
        this.jsa = personStatus;
        cxM();
    }

    public void a(PersonStatus personStatus) {
        this.jsa = personStatus;
        cxM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cxM() {
        if (this.mIsHost) {
            this.jrY.setVisibility(8);
            this.jrX.setVisibility(8);
        } else if (TbadkCoreApplication.isLogin()) {
            this.jrX.setVisibility(0);
            this.jrY.setVisibility(0);
        } else {
            this.jrY.setVisibility(8);
            this.jrX.setVisibility(8);
        }
    }

    public View cxN() {
        return this.eqV;
    }

    public boolean cxO() {
        return this.mIsHost;
    }

    public void aH(float f) {
        float f2;
        float f3 = 1.0f;
        if (f >= 0.0f || f <= 1.0f) {
            if (this.jrW != null) {
                this.jrW.setAlpha(f);
            }
            this.eqW.setAlpha(f);
            this.eqY.setAlpha(f);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 <= 1.0f) {
            f3 = f2 < 0.0f ? 0.0f : f2;
        }
        this.eqZ.setAlpha(f3);
        this.jrY.setAlpha(f3);
        this.jrX.setAlpha(f3);
    }

    public void rB(boolean z) {
        if (z) {
            this.eqW.setVisibility(8);
            this.eqY.setVisibility(8);
            return;
        }
        this.eqW.setVisibility(0);
        this.eqY.setVisibility(0);
    }

    public void rC(boolean z) {
        if (this.eqZ != null) {
            if (z) {
                SvgManager.aGC().a(this.eqZ, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aGC().a(this.jrY, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aGC().a(this.jrX, R.drawable.icon_pure_topbar_createchat44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return;
            }
            SvgManager.aGC().a(this.eqZ, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.aGC().a(this.jrY, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.aGC().a(this.jrX, R.drawable.icon_pure_topbar_createchat44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jrW != null) {
            am.setBackgroundColor(this.jrW, R.color.cp_bg_line_d);
        }
        am.setBackgroundColor(this.eqW, R.color.cp_bg_line_d);
        am.setViewTextColor(this.eqY, (int) R.color.cp_cont_b);
        rC(this.eqW.getAlpha() > 0.5f);
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.e eVar) {
        this.jrZ = eVar;
    }
}
