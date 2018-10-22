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
    private PopupWindow fYR;
    private ImageView hEA;
    private RelativeLayout hEt;
    private ImageView hEu;
    public ImageView hEv;
    private RelativeLayout hEw;
    private ImageView hEx;
    public ImageView hEy;
    private View hEz;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private int hEs = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0175e.ds28);
    private boolean hEB = false;
    private Handler mHandler = new Handler();
    private Runnable fYW = new Runnable() { // from class: com.baidu.tieba.view.d.4
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.hEx;
            if (imageView != null) {
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(d.this.fYR, imageView);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_person_tab_feedback_tips", true);
                d.this.hEB = true;
                d.this.mHandler.postDelayed(d.this.fYX, 3000L);
            }
        }
    };
    private Runnable fYX = new Runnable() { // from class: com.baidu.tieba.view.d.5
        @Override // java.lang.Runnable
        public void run() {
            d.this.bkY();
        }
    };
    private View.OnClickListener fYY = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.6
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
        this.hEt = (RelativeLayout) LayoutInflater.from(context).inflate(e.h.item_person_host_navigation_dressup, (ViewGroup) null);
        this.hEu = (ImageView) this.hEt.findViewById(e.g.person_navigation_dressup_img);
        this.hEv = (ImageView) this.hEt.findViewById(e.g.person_navigation_dressup_red_tip);
        this.hEw = (RelativeLayout) LayoutInflater.from(context).inflate(e.h.item_person_host_navigation_setting, (ViewGroup) null);
        this.hEx = (ImageView) this.hEw.findViewById(e.g.person_navigation_setting_img);
        this.hEy = (ImageView) this.hEw.findViewById(e.g.person_navigation_setting_red_tip);
        this.hEz = LayoutInflater.from(this.mContext).inflate(e.h.item_person_host_navigation_scan, (ViewGroup) null);
        this.hEA = (ImageView) this.hEz.findViewById(e.g.person_navigation_scan_img);
    }

    @Override // com.baidu.tieba.view.f
    public void box() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.hEt != null && this.hEt.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hEt, (View.OnClickListener) null);
            }
            if (this.hEw != null && this.hEw.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hEw, (View.OnClickListener) null);
            }
            if (this.hEz != null && this.hEz.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.hEz, (View.OnClickListener) null);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(g gVar) {
        if (this.hEt != null) {
            this.hEt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
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
        if (this.hEw != null) {
            this.hEw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
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
        if (this.hEz != null) {
            this.hEz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.3
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
        if (i == 5 && this.hEy != null) {
            this.hEy.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.hEv != null) {
            this.hEv.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.hEu != null) {
            if (2 == i) {
                al.a(this.hEu, e.f.icon_person_dressup_s, e.f.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                al.a(this.hEu, e.f.icon_person_dressup, e.f.icon_person_dressup);
            } else {
                al.a(this.hEu, e.f.icon_person_dressup_s, e.f.icon_person_dressup_s);
            }
            if (this.hEv != null) {
                al.c(this.hEv, e.f.icon_news_down_bar_one);
            }
        }
        if (this.hEx != null) {
            if (2 == i) {
                al.a(this.hEx, e.f.icon_home_setting_s, e.f.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                al.a(this.hEx, e.f.icon_home_setting_w, e.f.icon_home_setting_w);
            } else {
                al.a(this.hEx, e.f.icon_home_setting_s, e.f.icon_home_setting_s);
            }
            if (this.hEy != null) {
                al.c(this.hEy, e.f.icon_news_down_bar_one);
            }
        }
        al.c(this.hEA, e.f.selector_top_bar_scan);
    }

    @Override // com.baidu.tieba.view.f
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.hEu != null) {
                al.a(this.hEu, e.f.icon_person_dressup_s, e.f.icon_person_dressup_s);
            }
            if (this.hEx != null) {
                al.a(this.hEx, e.f.icon_home_setting_s, e.f.icon_home_setting_s);
            }
        } else {
            if (this.hEu != null) {
                al.a(this.hEu, e.f.icon_person_dressup, e.f.icon_person_dressup);
            }
            if (this.hEx != null) {
                al.a(this.hEx, e.f.icon_home_setting_w, e.f.icon_home_setting_w);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.hEu != null) {
                this.hEu.setAlpha(f2);
            }
            if (this.hEx != null) {
                this.hEx.setAlpha(f2);
            }
        }
    }

    public void bpb() {
        if (!this.hEB) {
            this.hEB = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_person_tab_feedback_tips", false);
            if (!this.hEB) {
                View inflate = LayoutInflater.from(this.mContext).inflate(e.h.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(e.g.arrow_up);
                TextView textView = (TextView) inflate.findViewById(e.g.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = l.h(this.mContext, e.C0175e.ds32);
                textView.setText(e.j.person_tab_feedback_tips);
                textView.setOnClickListener(this.fYY);
                this.fYR = new PopupWindow(inflate, -2, -2);
                this.mHandler.removeCallbacks(this.fYW);
                this.mHandler.postDelayed(this.fYW, 100L);
            }
        }
    }

    public void bkX() {
        this.mHandler.removeCallbacks(this.fYW);
        this.mHandler.removeCallbacks(this.fYX);
        bkY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkY() {
        com.baidu.adp.lib.g.g.a(this.fYR);
    }

    @Override // com.baidu.tieba.view.f
    public void e(UserData userData) {
    }
}
