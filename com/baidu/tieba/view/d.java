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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class d implements f {
    private PopupWindow fJL;
    private RelativeLayout hpo;
    private ImageView hpp;
    public ImageView hpq;
    private RelativeLayout hpr;
    private ImageView hps;
    public ImageView hpt;
    private View hpu;
    private ImageView hpv;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private int hpn = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(f.e.ds28);
    private boolean hpw = false;
    private Handler mHandler = new Handler();
    private Runnable fJQ = new Runnable() { // from class: com.baidu.tieba.view.d.4
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.hps;
            if (imageView != null) {
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(d.this.fJL, imageView);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_person_tab_feedback_tips", true);
                d.this.hpw = true;
                d.this.mHandler.postDelayed(d.this.fJR, 3000L);
            }
        }
    };
    private Runnable fJR = new Runnable() { // from class: com.baidu.tieba.view.d.5
        @Override // java.lang.Runnable
        public void run() {
            d.this.bfi();
        }
    };
    private View.OnClickListener fJS = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bfh();
        }
    };

    public d(int i) {
        this.mFrom = i;
    }

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.hpo = (RelativeLayout) LayoutInflater.from(context).inflate(f.h.item_person_host_navigation_dressup, (ViewGroup) null);
        this.hpp = (ImageView) this.hpo.findViewById(f.g.person_navigation_dressup_img);
        this.hpq = (ImageView) this.hpo.findViewById(f.g.person_navigation_dressup_red_tip);
        this.hpr = (RelativeLayout) LayoutInflater.from(context).inflate(f.h.item_person_host_navigation_setting, (ViewGroup) null);
        this.hps = (ImageView) this.hpr.findViewById(f.g.person_navigation_setting_img);
        this.hpt = (ImageView) this.hpr.findViewById(f.g.person_navigation_setting_red_tip);
        this.hpu = LayoutInflater.from(this.mContext).inflate(f.h.item_person_host_navigation_scan, (ViewGroup) null);
        this.hpv = (ImageView) this.hpu.findViewById(f.g.person_navigation_scan_img);
    }

    @Override // com.baidu.tieba.view.f
    public void biL() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.hpo != null && this.hpo.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hpo, (View.OnClickListener) null);
            }
            if (this.hpr != null && this.hpr.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hpr, (View.OnClickListener) null);
            }
            if (this.hpu != null && this.hpu.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.hpu, (View.OnClickListener) null);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(g gVar) {
        if (this.hpo != null) {
            this.hpo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new an("c12523").r("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new an("c12502").ae("obj_locate", "1"));
                    }
                    d.this.B(6, false);
                    com.baidu.tieba.o.a.boy().c(6, false, true);
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DressupCenterActivityConfig(d.this.mContext)));
                        return;
                    }
                    BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(f.j.plugin_video_installing), 0).xm();
                }
            });
        }
        if (this.hpr != null) {
            this.hpr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new an("c12523").r("obj_locate", 23));
                    } else {
                        TiebaStatic.log(new an("c12502").ae("obj_locate", "2"));
                    }
                    d.this.B(5, false);
                    TiebaStatic.log(new an("c12502").ae("obj_locate", "2"));
                    d.this.B(5, false);
                    com.baidu.tieba.o.a.boy().c(5, false, true);
                    if (!TbadkCoreApplication.getInst().appResponseToCmd(2015004)) {
                        BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(f.j.plugin_video_installing), 0).xm();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015004, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.hpu != null) {
            this.hpu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c12706"));
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(QRCodeScanActivityConfig.class)) {
                        BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(f.j.plugin_video_installing), 0).xm();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new QRCodeScanActivityConfig(d.this.mContext)));
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.f
    public void B(int i, boolean z) {
        if (i == 5 && this.hpt != null) {
            this.hpt.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.hpq != null) {
            this.hpq.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.hpp != null) {
            if (2 == i) {
                am.a(this.hpp, f.C0146f.icon_person_dressup_s, f.C0146f.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                am.a(this.hpp, f.C0146f.icon_person_dressup, f.C0146f.icon_person_dressup);
            } else {
                am.a(this.hpp, f.C0146f.icon_person_dressup_s, f.C0146f.icon_person_dressup_s);
            }
            if (this.hpq != null) {
                am.c(this.hpq, f.C0146f.icon_news_down_bar_one);
            }
        }
        if (this.hps != null) {
            if (2 == i) {
                am.a(this.hps, f.C0146f.icon_home_setting_s, f.C0146f.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                am.a(this.hps, f.C0146f.icon_home_setting_w, f.C0146f.icon_home_setting_w);
            } else {
                am.a(this.hps, f.C0146f.icon_home_setting_s, f.C0146f.icon_home_setting_s);
            }
            if (this.hpt != null) {
                am.c(this.hpt, f.C0146f.icon_news_down_bar_one);
            }
        }
        am.c(this.hpv, f.C0146f.selector_top_bar_scan);
    }

    @Override // com.baidu.tieba.view.f
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.hpp != null) {
                am.a(this.hpp, f.C0146f.icon_person_dressup_s, f.C0146f.icon_person_dressup_s);
            }
            if (this.hps != null) {
                am.a(this.hps, f.C0146f.icon_home_setting_s, f.C0146f.icon_home_setting_s);
            }
        } else {
            if (this.hpp != null) {
                am.a(this.hpp, f.C0146f.icon_person_dressup, f.C0146f.icon_person_dressup);
            }
            if (this.hps != null) {
                am.a(this.hps, f.C0146f.icon_home_setting_w, f.C0146f.icon_home_setting_w);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.hpp != null) {
                this.hpp.setAlpha(f2);
            }
            if (this.hps != null) {
                this.hps.setAlpha(f2);
            }
        }
    }

    public void bjp() {
        if (!this.hpw) {
            this.hpw = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_person_tab_feedback_tips", false);
            if (!this.hpw) {
                View inflate = LayoutInflater.from(this.mContext).inflate(f.h.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(f.g.arrow_up);
                TextView textView = (TextView) inflate.findViewById(f.g.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = l.f(this.mContext, f.e.ds32);
                textView.setText(f.j.person_tab_feedback_tips);
                textView.setOnClickListener(this.fJS);
                this.fJL = new PopupWindow(inflate, -2, -2);
                this.mHandler.removeCallbacks(this.fJQ);
                this.mHandler.postDelayed(this.fJQ, 100L);
            }
        }
    }

    public void bfh() {
        this.mHandler.removeCallbacks(this.fJQ);
        this.mHandler.removeCallbacks(this.fJR);
        bfi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfi() {
        com.baidu.adp.lib.g.g.a(this.fJL);
    }

    @Override // com.baidu.tieba.view.f
    public void e(UserData userData) {
    }
}
