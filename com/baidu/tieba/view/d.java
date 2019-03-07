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
    private PopupWindow hBc;
    private RelativeLayout jhW;
    private ImageView jhX;
    public ImageView jhY;
    private RelativeLayout jhZ;
    private ImageView jia;
    public ImageView jib;
    private View jic;
    private ImageView jie;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private int jhV = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds28);
    private boolean jif = false;
    private Handler mHandler = new Handler();
    private Runnable fwM = new Runnable() { // from class: com.baidu.tieba.view.d.4
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.jia;
            if (imageView != null) {
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(d.this.hBc, imageView);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_person_tab_feedback_tips", true);
                d.this.jif = true;
                d.this.mHandler.postDelayed(d.this.fwN, 3000L);
            }
        }
    };
    private Runnable fwN = new Runnable() { // from class: com.baidu.tieba.view.d.5
        @Override // java.lang.Runnable
        public void run() {
            d.this.bjC();
        }
    };
    private View.OnClickListener fwO = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bNZ();
        }
    };

    public d(int i) {
        this.mFrom = i;
    }

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.jhW = (RelativeLayout) LayoutInflater.from(context).inflate(d.h.item_person_host_navigation_dressup, (ViewGroup) null);
        this.jhX = (ImageView) this.jhW.findViewById(d.g.person_navigation_dressup_img);
        this.jhY = (ImageView) this.jhW.findViewById(d.g.person_navigation_dressup_red_tip);
        this.jhZ = (RelativeLayout) LayoutInflater.from(context).inflate(d.h.item_person_host_navigation_setting, (ViewGroup) null);
        this.jia = (ImageView) this.jhZ.findViewById(d.g.person_navigation_setting_img);
        this.jib = (ImageView) this.jhZ.findViewById(d.g.person_navigation_setting_red_tip);
        this.jic = LayoutInflater.from(this.mContext).inflate(d.h.item_person_host_navigation_scan, (ViewGroup) null);
        this.jie = (ImageView) this.jic.findViewById(d.g.person_navigation_scan_img);
    }

    @Override // com.baidu.tieba.view.f
    public void bRz() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.jhW != null && this.jhW.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jhW, (View.OnClickListener) null);
            }
            if (this.jhZ != null && this.jhZ.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jhZ, (View.OnClickListener) null);
            }
            if (this.jic != null && this.jic.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.jic, (View.OnClickListener) null);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(g gVar) {
        if (this.jhW != null) {
            this.jhW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new am("c12523").T("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new am("c12502").bJ("obj_locate", "1"));
                    }
                    d.this.I(6, false);
                    com.baidu.tieba.o.a.bXT().d(6, false, true);
                    if (com.baidu.tbadk.plugins.c.ay(d.this.mContext, "com.baidu.tieba.pluginResource")) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DressupCenterActivityConfig(d.this.mContext)));
                    }
                }
            });
        }
        if (this.jhZ != null) {
            this.jhZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
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
                    com.baidu.tieba.o.a.bXT().d(5, false, true);
                    if (!TbadkCoreApplication.getInst().appResponseToCmd(2015004)) {
                        BdToast.b(d.this.mContext, d.this.mContext.getResources().getString(d.j.plugin_video_installing), 0).abh();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015004, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.jic != null) {
            this.jic.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.3
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
        if (i == 5 && this.jib != null) {
            this.jib.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.jhY != null) {
            this.jhY.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.jhX != null) {
            if (2 == i) {
                al.a(this.jhX, d.f.icon_person_dressup_s, d.f.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                al.a(this.jhX, d.f.icon_person_dressup, d.f.icon_person_dressup);
            } else {
                al.a(this.jhX, d.f.icon_person_dressup_s, d.f.icon_person_dressup_s);
            }
            if (this.jhY != null) {
                al.c(this.jhY, d.f.icon_news_down_bar_one);
            }
        }
        if (this.jia != null) {
            if (2 == i) {
                al.a(this.jia, d.f.icon_home_setting_s, d.f.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                al.a(this.jia, d.f.icon_home_setting_w, d.f.icon_home_setting_w);
            } else {
                al.a(this.jia, d.f.icon_home_setting_s, d.f.icon_home_setting_s);
            }
            if (this.jib != null) {
                al.c(this.jib, d.f.icon_news_down_bar_one);
            }
        }
        al.c(this.jie, d.f.selector_top_bar_scan);
    }

    @Override // com.baidu.tieba.view.f
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.jhX != null) {
                al.a(this.jhX, d.f.icon_person_dressup_s, d.f.icon_person_dressup_s);
            }
            if (this.jia != null) {
                al.a(this.jia, d.f.icon_home_setting_s, d.f.icon_home_setting_s);
            }
        } else {
            if (this.jhX != null) {
                al.a(this.jhX, d.f.icon_person_dressup, d.f.icon_person_dressup);
            }
            if (this.jia != null) {
                al.a(this.jia, d.f.icon_home_setting_w, d.f.icon_home_setting_w);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.jhX != null) {
                this.jhX.setAlpha(f2);
            }
            if (this.jia != null) {
                this.jia.setAlpha(f2);
            }
        }
    }

    public void bSe() {
        if (!this.jif) {
            this.jif = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_person_tab_feedback_tips", false);
            if (!this.jif) {
                View inflate = LayoutInflater.from(this.mContext).inflate(d.h.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(d.g.arrow_up);
                TextView textView = (TextView) inflate.findViewById(d.g.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = l.h(this.mContext, d.e.ds32);
                textView.setText(d.j.person_tab_feedback_tips);
                textView.setOnClickListener(this.fwO);
                this.hBc = new PopupWindow(inflate, -2, -2);
                this.mHandler.removeCallbacks(this.fwM);
                this.mHandler.postDelayed(this.fwM, 100L);
            }
        }
    }

    public void bNZ() {
        this.mHandler.removeCallbacks(this.fwM);
        this.mHandler.removeCallbacks(this.fwN);
        bjC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjC() {
        com.baidu.adp.lib.g.g.a(this.hBc);
    }

    @Override // com.baidu.tieba.view.f
    public void setUserData(UserData userData) {
    }
}
