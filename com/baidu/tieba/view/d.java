package com.baidu.tieba.view;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d implements f {
    private PopupWindow eVT;
    private RelativeLayout gxa;
    private ImageView gxb;
    public ImageView gxc;
    private RelativeLayout gxd;
    private ImageView gxe;
    public ImageView gxf;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private boolean eVN = false;
    private Handler mHandler = new Handler();
    private Runnable eVV = new Runnable() { // from class: com.baidu.tieba.view.d.3
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.gxe;
            if (imageView != null) {
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(d.this.eVT, imageView);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_person_tab_feedback_tips", true);
                d.this.eVN = true;
                d.this.mHandler.postDelayed(d.this.eVW, 3000L);
            }
        }
    };
    private Runnable eVW = new Runnable() { // from class: com.baidu.tieba.view.d.4
        @Override // java.lang.Runnable
        public void run() {
            d.this.aUJ();
        }
    };
    private View.OnClickListener eVX = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.aUI();
        }
    };

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
            this.mNavigationBar = navigationBar;
            this.gxa = (RelativeLayout) LayoutInflater.from(context).inflate(d.j.item_person_host_navigation_dressup, (ViewGroup) null);
            this.gxb = (ImageView) this.gxa.findViewById(d.h.person_navigation_dressup_img);
            this.gxc = (ImageView) this.gxa.findViewById(d.h.person_navigation_dressup_red_tip);
        }
        if (TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
            if (this.mNavigationBar == null) {
                this.mNavigationBar = navigationBar;
            }
            this.gxd = (RelativeLayout) LayoutInflater.from(context).inflate(d.j.item_person_host_navigation_setting, (ViewGroup) null);
            this.gxe = (ImageView) this.gxd.findViewById(d.h.person_navigation_setting_img);
            this.gxf = (ImageView) this.gxd.findViewById(d.h.person_navigation_setting_red_tip);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void XB() {
        if (this.gxd != null && this.gxd.getParent() == null) {
            this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gxd, (View.OnClickListener) null);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(g gVar) {
        if (this.gxa != null) {
            this.gxa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.l(6, false);
                    com.baidu.tieba.j.a.bij().b(6, false, true);
                    TiebaStatic.log(new ak("c10601"));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(d.this.mContext)));
                }
            });
        }
        if (this.gxd != null) {
            this.gxd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.l(5, false);
                    com.baidu.tieba.j.a.bij().b(5, false, true);
                    TiebaStatic.log(new ak("c10598"));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MORE, new IntentConfig(view.getContext())));
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.f
    public void l(int i, boolean z) {
        if (i == 5 && this.gxf != null) {
            this.gxf.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.gxc != null) {
            this.gxc.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.gxb != null) {
            if (2 == i) {
                aj.a(this.gxb, d.g.icon_person_dressup_s, d.g.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.a(this.gxb, d.g.icon_person_dressup, d.g.icon_person_dressup);
            } else {
                aj.a(this.gxb, d.g.icon_person_dressup_s, d.g.icon_person_dressup_s);
            }
            if (this.gxc != null) {
                aj.c(this.gxc, d.g.icon_news_down_bar_one);
            }
        }
        if (this.gxe != null) {
            if (2 == i) {
                aj.a(this.gxe, d.g.icon_home_setting_s, d.g.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.a(this.gxe, d.g.icon_home_setting_w, d.g.icon_home_setting_w);
            } else {
                aj.a(this.gxe, d.g.icon_home_setting_s, d.g.icon_home_setting_s);
            }
            if (this.gxf != null) {
                aj.c(this.gxf, d.g.icon_news_down_bar_one);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void b(float f, boolean z) {
        float f2;
        if (z) {
            if (this.gxb != null) {
                aj.a(this.gxb, d.g.icon_person_dressup_s, d.g.icon_person_dressup_s);
            }
            if (this.gxe != null) {
                aj.a(this.gxe, d.g.icon_home_setting_s, d.g.icon_home_setting_s);
            }
        } else {
            if (this.gxb != null) {
                aj.a(this.gxb, d.g.icon_person_dressup, d.g.icon_person_dressup);
            }
            if (this.gxe != null) {
                aj.a(this.gxe, d.g.icon_home_setting_w, d.g.icon_home_setting_w);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.gxb != null) {
                this.gxb.setAlpha(f2);
            }
            if (this.gxe != null) {
                this.gxe.setAlpha(f2);
            }
        }
    }

    public void aYx() {
        if (!this.eVN) {
            this.eVN = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_person_tab_feedback_tips", false);
            if (!this.eVN) {
                View inflate = LayoutInflater.from(this.mContext).inflate(d.j.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(d.h.arrow_up);
                TextView textView = (TextView) inflate.findViewById(d.h.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds32);
                textView.setText(d.l.person_tab_feedback_tips);
                textView.setOnClickListener(this.eVX);
                this.eVT = new PopupWindow(inflate, -2, -2);
                this.mHandler.removeCallbacks(this.eVV);
                this.mHandler.postDelayed(this.eVV, 100L);
            }
        }
    }

    public void aUI() {
        this.mHandler.removeCallbacks(this.eVV);
        this.mHandler.removeCallbacks(this.eVW);
        aUJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUJ() {
        com.baidu.adp.lib.g.g.a(this.eVT);
    }

    @Override // com.baidu.tieba.view.f
    public void dF(boolean z) {
    }
}
