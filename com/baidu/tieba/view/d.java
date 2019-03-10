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
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class d implements f {
    private PopupWindow hBd;
    private RelativeLayout jir;
    private ImageView jis;
    public ImageView jit;
    private RelativeLayout jiu;
    private ImageView jiv;
    public ImageView jiw;
    private View jix;
    private ImageView jiy;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private int jiq = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds28);
    private boolean jiz = false;
    private Handler mHandler = new Handler();
    private Runnable fwM = new Runnable() { // from class: com.baidu.tieba.view.d.4
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.jiv;
            if (imageView != null) {
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(d.this.hBd, imageView);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_person_tab_feedback_tips", true);
                d.this.jiz = true;
                d.this.mHandler.postDelayed(d.this.fwN, 3000L);
            }
        }
    };
    private Runnable fwN = new Runnable() { // from class: com.baidu.tieba.view.d.5
        @Override // java.lang.Runnable
        public void run() {
            d.this.bjD();
        }
    };
    private View.OnClickListener fwO = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bOa();
        }
    };

    public d(int i) {
        this.mFrom = i;
    }

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.jir = (RelativeLayout) LayoutInflater.from(context).inflate(d.h.item_person_host_navigation_dressup, (ViewGroup) null);
        this.jis = (ImageView) this.jir.findViewById(d.g.person_navigation_dressup_img);
        this.jit = (ImageView) this.jir.findViewById(d.g.person_navigation_dressup_red_tip);
        this.jiu = (RelativeLayout) LayoutInflater.from(context).inflate(d.h.item_person_host_navigation_setting, (ViewGroup) null);
        this.jiv = (ImageView) this.jiu.findViewById(d.g.person_navigation_setting_img);
        this.jiw = (ImageView) this.jiu.findViewById(d.g.person_navigation_setting_red_tip);
        this.jix = LayoutInflater.from(this.mContext).inflate(d.h.item_person_host_navigation_scan, (ViewGroup) null);
        this.jiy = (ImageView) this.jix.findViewById(d.g.person_navigation_scan_img);
    }

    @Override // com.baidu.tieba.view.f
    public void bRA() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.jir != null && this.jir.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jir, (View.OnClickListener) null);
            }
            if (this.jiu != null && this.jiu.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jiu, (View.OnClickListener) null);
            }
            if (this.jix != null && this.jix.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.jix, (View.OnClickListener) null);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(g gVar) {
        if (this.jir != null) {
            this.jir.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new am("c12523").T("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new am("c12502").bJ("obj_locate", "1"));
                    }
                    d.this.I(6, false);
                    com.baidu.tieba.o.a.bXU().d(6, false, true);
                    if (com.baidu.tbadk.plugins.c.ay(d.this.mContext, "com.baidu.tieba.pluginResource")) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DressupCenterActivityConfig(d.this.mContext)));
                    }
                }
            });
        }
        if (this.jiu != null) {
            this.jiu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new am("c12523").T("obj_locate", 23));
                    } else {
                        TiebaStatic.log(new am("c12502").bJ("obj_locate", "2"));
                    }
                    d.this.I(5, false);
                    TiebaStatic.log(new am("c12502").bJ("obj_locate", "2"));
                    d.this.I(5, false);
                    com.baidu.tieba.o.a.bXU().d(5, false, true);
                    if (!TbadkCoreApplication.getInst().appResponseToCmd(2015004)) {
                        BdToast.b(d.this.mContext, d.this.mContext.getResources().getString(d.j.plugin_video_installing), 0).abh();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015004, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.jix != null) {
            this.jix.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mContext instanceof Activity) {
                        final Activity activity = (Activity) d.this.mContext;
                        if (d.this.mPermissionJudgement == null) {
                            d.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                        }
                        d.this.mPermissionJudgement.adQ();
                        d.this.mPermissionJudgement.e(activity, "android.permission.CAMERA");
                        d.this.mPermissionJudgement.a(new a.InterfaceC0193a() { // from class: com.baidu.tieba.view.d.3.1
                            @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0193a
                            public void adR() {
                                TiebaStatic.log(new am("c12706"));
                                if (com.baidu.tbadk.plugins.c.ay(activity, "com.baidu.tieba.pluginExtend")) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new QRCodeScanActivityConfig(d.this.mContext)));
                                }
                            }
                        });
                        d.this.mPermissionJudgement.Y(activity);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.f
    public void I(int i, boolean z) {
        if (i == 5 && this.jiw != null) {
            this.jiw.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.jit != null) {
            this.jit.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.jis != null) {
            if (2 == i) {
                al.a(this.jis, d.f.icon_person_dressup_s, d.f.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                al.a(this.jis, d.f.icon_person_dressup, d.f.icon_person_dressup);
            } else {
                al.a(this.jis, d.f.icon_person_dressup_s, d.f.icon_person_dressup_s);
            }
            if (this.jit != null) {
                al.c(this.jit, d.f.icon_news_down_bar_one);
            }
        }
        if (this.jiv != null) {
            if (2 == i) {
                al.a(this.jiv, d.f.icon_home_setting_s, d.f.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                al.a(this.jiv, d.f.icon_home_setting_w, d.f.icon_home_setting_w);
            } else {
                al.a(this.jiv, d.f.icon_home_setting_s, d.f.icon_home_setting_s);
            }
            if (this.jiw != null) {
                al.c(this.jiw, d.f.icon_news_down_bar_one);
            }
        }
        al.c(this.jiy, d.f.selector_top_bar_scan);
    }

    @Override // com.baidu.tieba.view.f
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.jis != null) {
                al.a(this.jis, d.f.icon_person_dressup_s, d.f.icon_person_dressup_s);
            }
            if (this.jiv != null) {
                al.a(this.jiv, d.f.icon_home_setting_s, d.f.icon_home_setting_s);
            }
        } else {
            if (this.jis != null) {
                al.a(this.jis, d.f.icon_person_dressup, d.f.icon_person_dressup);
            }
            if (this.jiv != null) {
                al.a(this.jiv, d.f.icon_home_setting_w, d.f.icon_home_setting_w);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.jis != null) {
                this.jis.setAlpha(f2);
            }
            if (this.jiv != null) {
                this.jiv.setAlpha(f2);
            }
        }
    }

    public void bSf() {
        if (!this.jiz) {
            this.jiz = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_person_tab_feedback_tips", false);
            if (!this.jiz) {
                View inflate = LayoutInflater.from(this.mContext).inflate(d.h.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(d.g.arrow_up);
                TextView textView = (TextView) inflate.findViewById(d.g.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = l.h(this.mContext, d.e.ds32);
                textView.setText(d.j.person_tab_feedback_tips);
                textView.setOnClickListener(this.fwO);
                this.hBd = new PopupWindow(inflate, -2, -2);
                this.mHandler.removeCallbacks(this.fwM);
                this.mHandler.postDelayed(this.fwM, 100L);
            }
        }
    }

    public void bOa() {
        this.mHandler.removeCallbacks(this.fwM);
        this.mHandler.removeCallbacks(this.fwN);
        bjD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjD() {
        com.baidu.adp.lib.g.g.a(this.hBd);
    }

    @Override // com.baidu.tieba.view.f
    public void setUserData(UserData userData) {
    }
}
