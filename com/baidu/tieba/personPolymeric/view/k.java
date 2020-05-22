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
    private RelativeLayout fhB;
    private View fhC;
    private TextView fhE;
    private ImageView fhF;
    private View kvG;
    private ImageView kvH;
    private ImageView kvI;
    private com.baidu.tieba.view.f kvJ;
    private PersonStatus kvK;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private int mStatusBarHeight;
    private UserData mUserData;

    public k(TbPageContext tbPageContext, View view, View view2, boolean z) {
        this(tbPageContext, view, z);
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.kvG = view2;
        Hc();
    }

    public k(TbPageContext tbPageContext, View view, boolean z) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.fhB = (RelativeLayout) view.findViewById(R.id.person_center_nav_layout);
        this.fhC = view.findViewById(R.id.person_center_nav_bg);
        this.fhE = (TextView) view.findViewById(R.id.person_center_nav_title);
        this.fhF = (ImageView) view.findViewById(R.id.person_center_nav_back_img);
        this.fhF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (k.this.kvJ == null) {
                    if (k.this.mPageContext != null) {
                        k.this.mPageContext.getPageActivity().finish();
                        return;
                    }
                    return;
                }
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.gZn = 8;
                k.this.kvJ.a(view2, bVar);
            }
        });
        this.kvH = (ImageView) view.findViewById(R.id.person_center_nav_chat_img);
        this.kvH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new an("c12503").dh("obj_locate", "1"));
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.gZn = 40;
                bVar.gZo = new Bundle();
                bVar.gZo.putSerializable(UserData.TYPE_USER, k.this.mUserData);
                if (k.this.kvJ != null) {
                    k.this.kvJ.a(view2, bVar);
                }
            }
        });
        this.kvI = (ImageView) view.findViewById(R.id.person_center_nav_more_img);
        this.kvI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TiebaStatic.log(new an("c12503").dh("obj_locate", "2"));
                    if (k.this.kvJ != null) {
                        com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                        bVar.gZn = 9;
                        k.this.kvJ.a(view2, bVar);
                    }
                }
            }
        });
    }

    private void Hc() {
        if (this.kvG != null) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                ViewGroup.LayoutParams layoutParams = this.kvG.getLayoutParams();
                layoutParams.height = this.mStatusBarHeight;
                this.kvG.setLayoutParams(layoutParams);
                return;
            }
            this.kvG.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, PersonStatus personStatus) {
        if (aVar != null && aVar.getUserData() != null) {
            this.mUserData = aVar.getUserData();
            this.fhE.setText(this.mUserData.getName_show());
        }
        this.kvK = personStatus;
        cPM();
    }

    public void a(PersonStatus personStatus) {
        this.kvK = personStatus;
        cPM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cPM() {
        if (this.mIsHost) {
            this.kvI.setVisibility(8);
            this.kvH.setVisibility(8);
        } else if (TbadkCoreApplication.isLogin()) {
            this.kvH.setVisibility(0);
            this.kvI.setVisibility(0);
        } else {
            this.kvI.setVisibility(8);
            this.kvH.setVisibility(8);
        }
    }

    public View cPN() {
        return this.fhB;
    }

    public boolean cPO() {
        return this.mIsHost;
    }

    public void aq(float f) {
        float f2;
        float f3 = 1.0f;
        if (f >= 0.0f || f <= 1.0f) {
            if (this.kvG != null) {
                this.kvG.setAlpha(f);
            }
            this.fhC.setAlpha(f);
            this.fhE.setAlpha(f);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 <= 1.0f) {
            f3 = f2 < 0.0f ? 0.0f : f2;
        }
        this.fhF.setAlpha(f3);
        this.kvI.setAlpha(f3);
        this.kvH.setAlpha(f3);
    }

    public void tj(boolean z) {
        if (z) {
            this.fhC.setVisibility(8);
            this.fhE.setVisibility(8);
            return;
        }
        this.fhC.setVisibility(0);
        this.fhE.setVisibility(0);
    }

    public void tk(boolean z) {
        if (this.fhF != null) {
            if (z) {
                SvgManager.aUV().a(this.fhF, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aUV().a(this.kvI, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aUV().a(this.kvH, R.drawable.icon_pure_topbar_createchat44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return;
            }
            SvgManager.aUV().a(this.fhF, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.aUV().a(this.kvI, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.aUV().a(this.kvH, R.drawable.icon_pure_topbar_createchat44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kvG != null) {
            am.setBackgroundColor(this.kvG, R.color.cp_bg_line_d);
        }
        am.setBackgroundColor(this.fhC, R.color.cp_bg_line_d);
        am.setViewTextColor(this.fhE, (int) R.color.cp_cont_b);
        tk(this.fhC.getAlpha() > 0.5f);
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        this.kvJ = fVar;
    }
}
