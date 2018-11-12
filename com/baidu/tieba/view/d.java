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
    private com.baidu.tbadk.core.util.b.a bvI;
    private PopupWindow gaq;
    private RelativeLayout hGd;
    private ImageView hGe;
    public ImageView hGf;
    private RelativeLayout hGg;
    private ImageView hGh;
    public ImageView hGi;
    private View hGj;
    private ImageView hGk;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private int hGc = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0200e.ds28);
    private boolean hGl = false;
    private Handler mHandler = new Handler();
    private Runnable dXC = new Runnable() { // from class: com.baidu.tieba.view.d.4
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.hGh;
            if (imageView != null) {
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(d.this.gaq, imageView);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_person_tab_feedback_tips", true);
                d.this.hGl = true;
                d.this.mHandler.postDelayed(d.this.dXD, 3000L);
            }
        }
    };
    private Runnable dXD = new Runnable() { // from class: com.baidu.tieba.view.d.5
        @Override // java.lang.Runnable
        public void run() {
            d.this.aFO();
        }
    };
    private View.OnClickListener dXE = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bku();
        }
    };

    public d(int i) {
        this.mFrom = i;
    }

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.hGd = (RelativeLayout) LayoutInflater.from(context).inflate(e.h.item_person_host_navigation_dressup, (ViewGroup) null);
        this.hGe = (ImageView) this.hGd.findViewById(e.g.person_navigation_dressup_img);
        this.hGf = (ImageView) this.hGd.findViewById(e.g.person_navigation_dressup_red_tip);
        this.hGg = (RelativeLayout) LayoutInflater.from(context).inflate(e.h.item_person_host_navigation_setting, (ViewGroup) null);
        this.hGh = (ImageView) this.hGg.findViewById(e.g.person_navigation_setting_img);
        this.hGi = (ImageView) this.hGg.findViewById(e.g.person_navigation_setting_red_tip);
        this.hGj = LayoutInflater.from(this.mContext).inflate(e.h.item_person_host_navigation_scan, (ViewGroup) null);
        this.hGk = (ImageView) this.hGj.findViewById(e.g.person_navigation_scan_img);
    }

    @Override // com.baidu.tieba.view.f
    public void bnS() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.hGd != null && this.hGd.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hGd, (View.OnClickListener) null);
            }
            if (this.hGg != null && this.hGg.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hGg, (View.OnClickListener) null);
            }
            if (this.hGj != null && this.hGj.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.hGj, (View.OnClickListener) null);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(g gVar) {
        if (this.hGd != null) {
            this.hGd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new am("c12523").x("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new am("c12502").ax("obj_locate", "1"));
                    }
                    d.this.C(6, false);
                    com.baidu.tieba.o.a.btQ().c(6, false, true);
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DressupCenterActivityConfig(d.this.mContext)));
                        return;
                    }
                    BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(e.j.plugin_video_installing), 0).AJ();
                }
            });
        }
        if (this.hGg != null) {
            this.hGg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
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
                    com.baidu.tieba.o.a.btQ().c(5, false, true);
                    if (!TbadkCoreApplication.getInst().appResponseToCmd(2015004)) {
                        BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(e.j.plugin_video_installing), 0).AJ();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015004, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.hGj != null) {
            this.hGj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mContext instanceof Activity) {
                        if (TbadkCoreApplication.getInst().appResponseToIntentClass(QRCodeScanActivityConfig.class)) {
                            Activity activity = (Activity) d.this.mContext;
                            if (d.this.bvI == null) {
                                d.this.bvI = new com.baidu.tbadk.core.util.b.a();
                            }
                            d.this.bvI.Dp();
                            d.this.bvI.c(activity, "android.permission.CAMERA");
                            d.this.bvI.a(new a.InterfaceC0150a() { // from class: com.baidu.tieba.view.d.3.1
                                @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0150a
                                public void Dq() {
                                    TiebaStatic.log(new am("c12706"));
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new QRCodeScanActivityConfig(d.this.mContext)));
                                }
                            });
                            d.this.bvI.A(activity);
                            return;
                        }
                        BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(e.j.plugin_video_installing), 0).AJ();
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.f
    public void C(int i, boolean z) {
        if (i == 5 && this.hGi != null) {
            this.hGi.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.hGf != null) {
            this.hGf.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.hGe != null) {
            if (2 == i) {
                al.a(this.hGe, e.f.icon_person_dressup_s, e.f.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                al.a(this.hGe, e.f.icon_person_dressup, e.f.icon_person_dressup);
            } else {
                al.a(this.hGe, e.f.icon_person_dressup_s, e.f.icon_person_dressup_s);
            }
            if (this.hGf != null) {
                al.c(this.hGf, e.f.icon_news_down_bar_one);
            }
        }
        if (this.hGh != null) {
            if (2 == i) {
                al.a(this.hGh, e.f.icon_home_setting_s, e.f.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                al.a(this.hGh, e.f.icon_home_setting_w, e.f.icon_home_setting_w);
            } else {
                al.a(this.hGh, e.f.icon_home_setting_s, e.f.icon_home_setting_s);
            }
            if (this.hGi != null) {
                al.c(this.hGi, e.f.icon_news_down_bar_one);
            }
        }
        al.c(this.hGk, e.f.selector_top_bar_scan);
    }

    @Override // com.baidu.tieba.view.f
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.hGe != null) {
                al.a(this.hGe, e.f.icon_person_dressup_s, e.f.icon_person_dressup_s);
            }
            if (this.hGh != null) {
                al.a(this.hGh, e.f.icon_home_setting_s, e.f.icon_home_setting_s);
            }
        } else {
            if (this.hGe != null) {
                al.a(this.hGe, e.f.icon_person_dressup, e.f.icon_person_dressup);
            }
            if (this.hGh != null) {
                al.a(this.hGh, e.f.icon_home_setting_w, e.f.icon_home_setting_w);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.hGe != null) {
                this.hGe.setAlpha(f2);
            }
            if (this.hGh != null) {
                this.hGh.setAlpha(f2);
            }
        }
    }

    public void bow() {
        if (!this.hGl) {
            this.hGl = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_person_tab_feedback_tips", false);
            if (!this.hGl) {
                View inflate = LayoutInflater.from(this.mContext).inflate(e.h.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(e.g.arrow_up);
                TextView textView = (TextView) inflate.findViewById(e.g.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = l.h(this.mContext, e.C0200e.ds32);
                textView.setText(e.j.person_tab_feedback_tips);
                textView.setOnClickListener(this.dXE);
                this.gaq = new PopupWindow(inflate, -2, -2);
                this.mHandler.removeCallbacks(this.dXC);
                this.mHandler.postDelayed(this.dXC, 100L);
            }
        }
    }

    public void bku() {
        this.mHandler.removeCallbacks(this.dXC);
        this.mHandler.removeCallbacks(this.dXD);
        aFO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFO() {
        com.baidu.adp.lib.g.g.a(this.gaq);
    }

    @Override // com.baidu.tieba.view.f
    public void e(UserData userData) {
    }
}
