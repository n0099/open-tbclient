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
/* loaded from: classes8.dex */
public class k {
    private TextView elA;
    private ImageView elB;
    private RelativeLayout elx;
    private View ely;
    private View jng;
    private ImageView jnh;
    private ImageView jni;
    private com.baidu.tieba.view.e jnj;
    private PersonStatus jnk;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private int mStatusBarHeight;
    private UserData mUserData;

    public k(TbPageContext tbPageContext, View view, View view2, boolean z) {
        this(tbPageContext, view, z);
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.jng = view2;
        xy();
    }

    public k(TbPageContext tbPageContext, View view, boolean z) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.elx = (RelativeLayout) view.findViewById(R.id.person_center_nav_layout);
        this.ely = view.findViewById(R.id.person_center_nav_bg);
        this.elA = (TextView) view.findViewById(R.id.person_center_nav_title);
        this.elB = (ImageView) view.findViewById(R.id.person_center_nav_back_img);
        this.elB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (k.this.jnj == null) {
                    if (k.this.mPageContext != null) {
                        k.this.mPageContext.getPageActivity().finish();
                        return;
                    }
                    return;
                }
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.fVg = 8;
                k.this.jnj.a(view2, bVar);
            }
        });
        this.jnh = (ImageView) view.findViewById(R.id.person_center_nav_chat_img);
        this.jnh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new an("c12503").cp("obj_locate", "1"));
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.fVg = 40;
                bVar.fVh = new Bundle();
                bVar.fVh.putSerializable(UserData.TYPE_USER, k.this.mUserData);
                if (k.this.jnj != null) {
                    k.this.jnj.a(view2, bVar);
                }
            }
        });
        this.jni = (ImageView) view.findViewById(R.id.person_center_nav_more_img);
        this.jni.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TiebaStatic.log(new an("c12503").cp("obj_locate", "2"));
                    if (k.this.jnj != null) {
                        com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                        bVar.fVg = 9;
                        k.this.jnj.a(view2, bVar);
                    }
                }
            }
        });
    }

    private void xy() {
        if (this.jng != null) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                ViewGroup.LayoutParams layoutParams = this.jng.getLayoutParams();
                layoutParams.height = this.mStatusBarHeight;
                this.jng.setLayoutParams(layoutParams);
                return;
            }
            this.jng.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, PersonStatus personStatus) {
        if (aVar != null && aVar.getUserData() != null) {
            this.mUserData = aVar.getUserData();
            this.elA.setText(this.mUserData.getName_show());
        }
        this.jnk = personStatus;
        cvf();
    }

    public void a(PersonStatus personStatus) {
        this.jnk = personStatus;
        cvf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cvf() {
        if (this.mIsHost) {
            this.jni.setVisibility(8);
            this.jnh.setVisibility(8);
        } else if (TbadkCoreApplication.isLogin()) {
            this.jnh.setVisibility(0);
            this.jni.setVisibility(0);
        } else {
            this.jni.setVisibility(8);
            this.jnh.setVisibility(8);
        }
    }

    public View cvg() {
        return this.elx;
    }

    public boolean cvh() {
        return this.mIsHost;
    }

    public void aJ(float f) {
        float f2;
        float f3 = 1.0f;
        if (f >= 0.0f || f <= 1.0f) {
            if (this.jng != null) {
                this.jng.setAlpha(f);
            }
            this.ely.setAlpha(f);
            this.elA.setAlpha(f);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 <= 1.0f) {
            f3 = f2 < 0.0f ? 0.0f : f2;
        }
        this.elB.setAlpha(f3);
        this.jni.setAlpha(f3);
        this.jnh.setAlpha(f3);
    }

    public void rl(boolean z) {
        if (z) {
            this.ely.setVisibility(8);
            this.elA.setVisibility(8);
            return;
        }
        this.ely.setVisibility(0);
        this.elA.setVisibility(0);
    }

    public void rm(boolean z) {
        if (this.elB != null) {
            if (z) {
                SvgManager.aDW().a(this.elB, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aDW().a(this.jni, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aDW().a(this.jnh, R.drawable.icon_pure_topbar_createchat44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return;
            }
            SvgManager.aDW().a(this.elB, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.aDW().a(this.jni, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.aDW().a(this.jnh, R.drawable.icon_pure_topbar_createchat44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jng != null) {
            am.setBackgroundColor(this.jng, R.color.cp_bg_line_d);
        }
        am.setBackgroundColor(this.ely, R.color.cp_bg_line_d);
        am.setViewTextColor(this.elA, (int) R.color.cp_cont_b);
        rm(this.ely.getAlpha() > 0.5f);
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.e eVar) {
        this.jnj = eVar;
    }
}
