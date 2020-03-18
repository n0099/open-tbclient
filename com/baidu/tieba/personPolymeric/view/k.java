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
    private RelativeLayout ers;
    private View ert;
    private TextView erv;
    private ImageView erw;
    private View jtv;
    private ImageView jtw;
    private ImageView jtx;
    private com.baidu.tieba.view.e jty;
    private PersonStatus jtz;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private int mStatusBarHeight;
    private UserData mUserData;

    public k(TbPageContext tbPageContext, View view, View view2, boolean z) {
        this(tbPageContext, view, z);
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.jtv = view2;
        Ao();
    }

    public k(TbPageContext tbPageContext, View view, boolean z) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.ers = (RelativeLayout) view.findViewById(R.id.person_center_nav_layout);
        this.ert = view.findViewById(R.id.person_center_nav_bg);
        this.erv = (TextView) view.findViewById(R.id.person_center_nav_title);
        this.erw = (ImageView) view.findViewById(R.id.person_center_nav_back_img);
        this.erw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (k.this.jty == null) {
                    if (k.this.mPageContext != null) {
                        k.this.mPageContext.getPageActivity().finish();
                        return;
                    }
                    return;
                }
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.gbm = 8;
                k.this.jty.a(view2, bVar);
            }
        });
        this.jtw = (ImageView) view.findViewById(R.id.person_center_nav_chat_img);
        this.jtw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new an("c12503").cx("obj_locate", "1"));
                com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                bVar.gbm = 40;
                bVar.gbn = new Bundle();
                bVar.gbn.putSerializable(UserData.TYPE_USER, k.this.mUserData);
                if (k.this.jty != null) {
                    k.this.jty.a(view2, bVar);
                }
            }
        });
        this.jtx = (ImageView) view.findViewById(R.id.person_center_nav_more_img);
        this.jtx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TiebaStatic.log(new an("c12503").cx("obj_locate", "2"));
                    if (k.this.jty != null) {
                        com.baidu.tieba.personPolymeric.event.b bVar = new com.baidu.tieba.personPolymeric.event.b();
                        bVar.gbm = 9;
                        k.this.jty.a(view2, bVar);
                    }
                }
            }
        });
    }

    private void Ao() {
        if (this.jtv != null) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                ViewGroup.LayoutParams layoutParams = this.jtv.getLayoutParams();
                layoutParams.height = this.mStatusBarHeight;
                this.jtv.setLayoutParams(layoutParams);
                return;
            }
            this.jtv.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, PersonStatus personStatus) {
        if (aVar != null && aVar.getUserData() != null) {
            this.mUserData = aVar.getUserData();
            this.erv.setText(this.mUserData.getName_show());
        }
        this.jtz = personStatus;
        cyf();
    }

    public void a(PersonStatus personStatus) {
        this.jtz = personStatus;
        cyf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cyf() {
        if (this.mIsHost) {
            this.jtx.setVisibility(8);
            this.jtw.setVisibility(8);
        } else if (TbadkCoreApplication.isLogin()) {
            this.jtw.setVisibility(0);
            this.jtx.setVisibility(0);
        } else {
            this.jtx.setVisibility(8);
            this.jtw.setVisibility(8);
        }
    }

    public View cyg() {
        return this.ers;
    }

    public boolean cyh() {
        return this.mIsHost;
    }

    public void aH(float f) {
        float f2;
        float f3 = 1.0f;
        if (f >= 0.0f || f <= 1.0f) {
            if (this.jtv != null) {
                this.jtv.setAlpha(f);
            }
            this.ert.setAlpha(f);
            this.erv.setAlpha(f);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 <= 1.0f) {
            f3 = f2 < 0.0f ? 0.0f : f2;
        }
        this.erw.setAlpha(f3);
        this.jtx.setAlpha(f3);
        this.jtw.setAlpha(f3);
    }

    public void rH(boolean z) {
        if (z) {
            this.ert.setVisibility(8);
            this.erv.setVisibility(8);
            return;
        }
        this.ert.setVisibility(0);
        this.erv.setVisibility(0);
    }

    public void rI(boolean z) {
        if (this.erw != null) {
            if (z) {
                SvgManager.aGG().a(this.erw, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aGG().a(this.jtx, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aGG().a(this.jtw, R.drawable.icon_pure_topbar_createchat44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return;
            }
            SvgManager.aGG().a(this.erw, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.aGG().a(this.jtx, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.aGG().a(this.jtw, R.drawable.icon_pure_topbar_createchat44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jtv != null) {
            am.setBackgroundColor(this.jtv, R.color.cp_bg_line_d);
        }
        am.setBackgroundColor(this.ert, R.color.cp_bg_line_d);
        am.setViewTextColor(this.erv, (int) R.color.cp_cont_b);
        rI(this.ert.getAlpha() > 0.5f);
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.e eVar) {
        this.jty = eVar;
    }
}
