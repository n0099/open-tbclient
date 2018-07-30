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
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class d implements f {
    private PopupWindow fJS;
    private RelativeLayout hpn;
    private ImageView hpo;
    public ImageView hpp;
    private RelativeLayout hpq;
    private ImageView hpr;
    public ImageView hps;
    private View hpt;
    private ImageView hpu;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private int hpm = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds28);
    private boolean hpv = false;
    private Handler mHandler = new Handler();
    private Runnable fJX = new Runnable() { // from class: com.baidu.tieba.view.d.4
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.hpr;
            if (imageView != null) {
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(d.this.fJS, imageView);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_person_tab_feedback_tips", true);
                d.this.hpv = true;
                d.this.mHandler.postDelayed(d.this.fJY, 3000L);
            }
        }
    };
    private Runnable fJY = new Runnable() { // from class: com.baidu.tieba.view.d.5
        @Override // java.lang.Runnable
        public void run() {
            d.this.bfn();
        }
    };
    private View.OnClickListener fJZ = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bfm();
        }
    };

    public d(int i) {
        this.mFrom = i;
    }

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.hpn = (RelativeLayout) LayoutInflater.from(context).inflate(d.h.item_person_host_navigation_dressup, (ViewGroup) null);
        this.hpo = (ImageView) this.hpn.findViewById(d.g.person_navigation_dressup_img);
        this.hpp = (ImageView) this.hpn.findViewById(d.g.person_navigation_dressup_red_tip);
        this.hpq = (RelativeLayout) LayoutInflater.from(context).inflate(d.h.item_person_host_navigation_setting, (ViewGroup) null);
        this.hpr = (ImageView) this.hpq.findViewById(d.g.person_navigation_setting_img);
        this.hps = (ImageView) this.hpq.findViewById(d.g.person_navigation_setting_red_tip);
        this.hpt = LayoutInflater.from(this.mContext).inflate(d.h.item_person_host_navigation_scan, (ViewGroup) null);
        this.hpu = (ImageView) this.hpt.findViewById(d.g.person_navigation_scan_img);
    }

    @Override // com.baidu.tieba.view.f
    public void biO() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.hpn != null && this.hpn.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hpn, (View.OnClickListener) null);
            }
            if (this.hpq != null && this.hpq.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hpq, (View.OnClickListener) null);
            }
            if (this.hpt != null && this.hpt.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.hpt, (View.OnClickListener) null);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(g gVar) {
        if (this.hpn != null) {
            this.hpn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new an("c12523").r("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new an("c12502").af("obj_locate", "1"));
                    }
                    d.this.B(6, false);
                    com.baidu.tieba.o.a.box().c(6, false, true);
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DressupCenterActivityConfig(d.this.mContext)));
                        return;
                    }
                    BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(d.j.plugin_video_installing), 0).xn();
                }
            });
        }
        if (this.hpq != null) {
            this.hpq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new an("c12523").r("obj_locate", 23));
                    } else {
                        TiebaStatic.log(new an("c12502").af("obj_locate", "2"));
                    }
                    d.this.B(5, false);
                    TiebaStatic.log(new an("c12502").af("obj_locate", "2"));
                    d.this.B(5, false);
                    com.baidu.tieba.o.a.box().c(5, false, true);
                    if (!TbadkCoreApplication.getInst().appResponseToCmd(2015004)) {
                        BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(d.j.plugin_video_installing), 0).xn();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015004, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.hpt != null) {
            this.hpt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c12706"));
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(QRCodeScanActivityConfig.class)) {
                        BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(d.j.plugin_video_installing), 0).xn();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new QRCodeScanActivityConfig(d.this.mContext)));
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.f
    public void B(int i, boolean z) {
        if (i == 5 && this.hps != null) {
            this.hps.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.hpp != null) {
            this.hpp.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.hpo != null) {
            if (2 == i) {
                am.a(this.hpo, d.f.icon_person_dressup_s, d.f.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                am.a(this.hpo, d.f.icon_person_dressup, d.f.icon_person_dressup);
            } else {
                am.a(this.hpo, d.f.icon_person_dressup_s, d.f.icon_person_dressup_s);
            }
            if (this.hpp != null) {
                am.c(this.hpp, d.f.icon_news_down_bar_one);
            }
        }
        if (this.hpr != null) {
            if (2 == i) {
                am.a(this.hpr, d.f.icon_home_setting_s, d.f.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                am.a(this.hpr, d.f.icon_home_setting_w, d.f.icon_home_setting_w);
            } else {
                am.a(this.hpr, d.f.icon_home_setting_s, d.f.icon_home_setting_s);
            }
            if (this.hps != null) {
                am.c(this.hps, d.f.icon_news_down_bar_one);
            }
        }
        am.c(this.hpu, d.f.selector_top_bar_scan);
    }

    @Override // com.baidu.tieba.view.f
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.hpo != null) {
                am.a(this.hpo, d.f.icon_person_dressup_s, d.f.icon_person_dressup_s);
            }
            if (this.hpr != null) {
                am.a(this.hpr, d.f.icon_home_setting_s, d.f.icon_home_setting_s);
            }
        } else {
            if (this.hpo != null) {
                am.a(this.hpo, d.f.icon_person_dressup, d.f.icon_person_dressup);
            }
            if (this.hpr != null) {
                am.a(this.hpr, d.f.icon_home_setting_w, d.f.icon_home_setting_w);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.hpo != null) {
                this.hpo.setAlpha(f2);
            }
            if (this.hpr != null) {
                this.hpr.setAlpha(f2);
            }
        }
    }

    public void bjs() {
        if (!this.hpv) {
            this.hpv = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_person_tab_feedback_tips", false);
            if (!this.hpv) {
                View inflate = LayoutInflater.from(this.mContext).inflate(d.h.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(d.g.arrow_up);
                TextView textView = (TextView) inflate.findViewById(d.g.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = l.f(this.mContext, d.e.ds32);
                textView.setText(d.j.person_tab_feedback_tips);
                textView.setOnClickListener(this.fJZ);
                this.fJS = new PopupWindow(inflate, -2, -2);
                this.mHandler.removeCallbacks(this.fJX);
                this.mHandler.postDelayed(this.fJX, 100L);
            }
        }
    }

    public void bfm() {
        this.mHandler.removeCallbacks(this.fJX);
        this.mHandler.removeCallbacks(this.fJY);
        bfn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfn() {
        com.baidu.adp.lib.g.g.a(this.fJS);
    }

    @Override // com.baidu.tieba.view.f
    public void e(UserData userData) {
    }
}
