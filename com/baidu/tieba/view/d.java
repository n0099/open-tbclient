package com.baidu.tieba.view;

import android.app.Activity;
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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.b.a;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
/* loaded from: classes5.dex */
public class d implements f {
    private com.baidu.tbadk.core.util.b.a buX;
    private PopupWindow fYQ;
    private RelativeLayout hEs;
    private ImageView hEt;
    public ImageView hEu;
    private RelativeLayout hEv;
    private ImageView hEw;
    public ImageView hEx;
    private View hEy;
    private ImageView hEz;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private int hEr = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0175e.ds28);
    private boolean hEA = false;
    private Handler mHandler = new Handler();
    private Runnable fYV = new Runnable() { // from class: com.baidu.tieba.view.d.4
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.hEw;
            if (imageView != null) {
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(d.this.fYQ, imageView);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_person_tab_feedback_tips", true);
                d.this.hEA = true;
                d.this.mHandler.postDelayed(d.this.fYW, 3000L);
            }
        }
    };
    private Runnable fYW = new Runnable() { // from class: com.baidu.tieba.view.d.5
        @Override // java.lang.Runnable
        public void run() {
            d.this.bkY();
        }
    };
    private View.OnClickListener fYX = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bkX();
        }
    };

    public d(int i) {
        this.mFrom = i;
    }

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.hEs = (RelativeLayout) LayoutInflater.from(context).inflate(e.h.item_person_host_navigation_dressup, (ViewGroup) null);
        this.hEt = (ImageView) this.hEs.findViewById(e.g.person_navigation_dressup_img);
        this.hEu = (ImageView) this.hEs.findViewById(e.g.person_navigation_dressup_red_tip);
        this.hEv = (RelativeLayout) LayoutInflater.from(context).inflate(e.h.item_person_host_navigation_setting, (ViewGroup) null);
        this.hEw = (ImageView) this.hEv.findViewById(e.g.person_navigation_setting_img);
        this.hEx = (ImageView) this.hEv.findViewById(e.g.person_navigation_setting_red_tip);
        this.hEy = LayoutInflater.from(this.mContext).inflate(e.h.item_person_host_navigation_scan, (ViewGroup) null);
        this.hEz = (ImageView) this.hEy.findViewById(e.g.person_navigation_scan_img);
    }

    @Override // com.baidu.tieba.view.f
    public void box() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.hEs != null && this.hEs.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hEs, (View.OnClickListener) null);
            }
            if (this.hEv != null && this.hEv.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hEv, (View.OnClickListener) null);
            }
            if (this.hEy != null && this.hEy.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.hEy, (View.OnClickListener) null);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(g gVar) {
        if (this.hEs != null) {
            this.hEs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new am("c12523").x("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new am("c12502").ax("obj_locate", "1"));
                    }
                    d.this.C(6, false);
                    com.baidu.tieba.o.a.buu().c(6, false, true);
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DressupCenterActivityConfig(d.this.mContext)));
                        return;
                    }
                    BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(e.j.plugin_video_installing), 0).AC();
                }
            });
        }
        if (this.hEv != null) {
            this.hEv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new am("c12523").x("obj_locate", 23));
                    } else {
                        TiebaStatic.log(new am("c12502").ax("obj_locate", "2"));
                    }
                    d.this.C(5, false);
                    TiebaStatic.log(new am("c12502").ax("obj_locate", "2"));
                    d.this.C(5, false);
                    com.baidu.tieba.o.a.buu().c(5, false, true);
                    if (!TbadkCoreApplication.getInst().appResponseToCmd(2015004)) {
                        BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(e.j.plugin_video_installing), 0).AC();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015004, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.hEy != null) {
            this.hEy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mContext instanceof Activity) {
                        if (TbadkCoreApplication.getInst().appResponseToIntentClass(QRCodeScanActivityConfig.class)) {
                            Activity activity = (Activity) d.this.mContext;
                            if (d.this.buX == null) {
                                d.this.buX = new com.baidu.tbadk.core.util.b.a();
                            }
                            d.this.buX.Di();
                            d.this.buX.c(activity, "android.permission.CAMERA");
                            d.this.buX.a(new a.InterfaceC0126a() { // from class: com.baidu.tieba.view.d.3.1
                                @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0126a
                                public void Dj() {
                                    TiebaStatic.log(new am("c12706"));
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new QRCodeScanActivityConfig(d.this.mContext)));
                                }
                            });
                            d.this.buX.z(activity);
                            return;
                        }
                        BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(e.j.plugin_video_installing), 0).AC();
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.f
    public void C(int i, boolean z) {
        if (i == 5 && this.hEx != null) {
            this.hEx.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.hEu != null) {
            this.hEu.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.hEt != null) {
            if (2 == i) {
                al.a(this.hEt, e.f.icon_person_dressup_s, e.f.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                al.a(this.hEt, e.f.icon_person_dressup, e.f.icon_person_dressup);
            } else {
                al.a(this.hEt, e.f.icon_person_dressup_s, e.f.icon_person_dressup_s);
            }
            if (this.hEu != null) {
                al.c(this.hEu, e.f.icon_news_down_bar_one);
            }
        }
        if (this.hEw != null) {
            if (2 == i) {
                al.a(this.hEw, e.f.icon_home_setting_s, e.f.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                al.a(this.hEw, e.f.icon_home_setting_w, e.f.icon_home_setting_w);
            } else {
                al.a(this.hEw, e.f.icon_home_setting_s, e.f.icon_home_setting_s);
            }
            if (this.hEx != null) {
                al.c(this.hEx, e.f.icon_news_down_bar_one);
            }
        }
        al.c(this.hEz, e.f.selector_top_bar_scan);
    }

    @Override // com.baidu.tieba.view.f
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.hEt != null) {
                al.a(this.hEt, e.f.icon_person_dressup_s, e.f.icon_person_dressup_s);
            }
            if (this.hEw != null) {
                al.a(this.hEw, e.f.icon_home_setting_s, e.f.icon_home_setting_s);
            }
        } else {
            if (this.hEt != null) {
                al.a(this.hEt, e.f.icon_person_dressup, e.f.icon_person_dressup);
            }
            if (this.hEw != null) {
                al.a(this.hEw, e.f.icon_home_setting_w, e.f.icon_home_setting_w);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.hEt != null) {
                this.hEt.setAlpha(f2);
            }
            if (this.hEw != null) {
                this.hEw.setAlpha(f2);
            }
        }
    }

    public void bpb() {
        if (!this.hEA) {
            this.hEA = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_person_tab_feedback_tips", false);
            if (!this.hEA) {
                View inflate = LayoutInflater.from(this.mContext).inflate(e.h.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(e.g.arrow_up);
                TextView textView = (TextView) inflate.findViewById(e.g.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = l.h(this.mContext, e.C0175e.ds32);
                textView.setText(e.j.person_tab_feedback_tips);
                textView.setOnClickListener(this.fYX);
                this.fYQ = new PopupWindow(inflate, -2, -2);
                this.mHandler.removeCallbacks(this.fYV);
                this.mHandler.postDelayed(this.fYV, 100L);
            }
        }
    }

    public void bkX() {
        this.mHandler.removeCallbacks(this.fYV);
        this.mHandler.removeCallbacks(this.fYW);
        bkY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkY() {
        com.baidu.adp.lib.g.g.a(this.fYQ);
    }

    @Override // com.baidu.tieba.view.f
    public void e(UserData userData) {
    }
}
