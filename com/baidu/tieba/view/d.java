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
    private PopupWindow hAK;
    private RelativeLayout jhX;
    private ImageView jhY;
    public ImageView jhZ;
    private RelativeLayout jia;
    private ImageView jib;
    public ImageView jic;
    private View jie;
    private ImageView jif;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private int jhW = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds28);
    private boolean jig = false;
    private Handler mHandler = new Handler();
    private Runnable fwy = new Runnable() { // from class: com.baidu.tieba.view.d.4
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.jib;
            if (imageView != null) {
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(d.this.hAK, imageView);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_person_tab_feedback_tips", true);
                d.this.jig = true;
                d.this.mHandler.postDelayed(d.this.fwz, 3000L);
            }
        }
    };
    private Runnable fwz = new Runnable() { // from class: com.baidu.tieba.view.d.5
        @Override // java.lang.Runnable
        public void run() {
            d.this.bjA();
        }
    };
    private View.OnClickListener fwA = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bNX();
        }
    };

    public d(int i) {
        this.mFrom = i;
    }

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.jhX = (RelativeLayout) LayoutInflater.from(context).inflate(d.h.item_person_host_navigation_dressup, (ViewGroup) null);
        this.jhY = (ImageView) this.jhX.findViewById(d.g.person_navigation_dressup_img);
        this.jhZ = (ImageView) this.jhX.findViewById(d.g.person_navigation_dressup_red_tip);
        this.jia = (RelativeLayout) LayoutInflater.from(context).inflate(d.h.item_person_host_navigation_setting, (ViewGroup) null);
        this.jib = (ImageView) this.jia.findViewById(d.g.person_navigation_setting_img);
        this.jic = (ImageView) this.jia.findViewById(d.g.person_navigation_setting_red_tip);
        this.jie = LayoutInflater.from(this.mContext).inflate(d.h.item_person_host_navigation_scan, (ViewGroup) null);
        this.jif = (ImageView) this.jie.findViewById(d.g.person_navigation_scan_img);
    }

    @Override // com.baidu.tieba.view.f
    public void bRy() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.jhX != null && this.jhX.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jhX, (View.OnClickListener) null);
            }
            if (this.jia != null && this.jia.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jia, (View.OnClickListener) null);
            }
            if (this.jie != null && this.jie.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.jie, (View.OnClickListener) null);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(g gVar) {
        if (this.jhX != null) {
            this.jhX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new am("c12523").T("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new am("c12502").bJ("obj_locate", "1"));
                    }
                    d.this.I(6, false);
                    com.baidu.tieba.o.a.bXS().d(6, false, true);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DressupCenterActivityConfig(d.this.mContext)));
                }
            });
        }
        if (this.jia != null) {
            this.jia.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
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
                    com.baidu.tieba.o.a.bXS().d(5, false, true);
                    if (!TbadkCoreApplication.getInst().appResponseToCmd(2015004)) {
                        BdToast.b(d.this.mContext, d.this.mContext.getResources().getString(d.j.plugin_video_installing), 0).abe();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015004, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.jie != null) {
            this.jie.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mContext instanceof Activity) {
                        Activity activity = (Activity) d.this.mContext;
                        if (d.this.mPermissionJudgement == null) {
                            d.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                        }
                        d.this.mPermissionJudgement.adN();
                        d.this.mPermissionJudgement.e(activity, "android.permission.CAMERA");
                        d.this.mPermissionJudgement.a(new a.InterfaceC0227a() { // from class: com.baidu.tieba.view.d.3.1
                            @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0227a
                            public void adO() {
                                TiebaStatic.log(new am("c12706"));
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new QRCodeScanActivityConfig(d.this.mContext)));
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
        if (i == 5 && this.jic != null) {
            this.jic.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.jhZ != null) {
            this.jhZ.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.jhY != null) {
            if (2 == i) {
                al.a(this.jhY, d.f.icon_person_dressup_s, d.f.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                al.a(this.jhY, d.f.icon_person_dressup, d.f.icon_person_dressup);
            } else {
                al.a(this.jhY, d.f.icon_person_dressup_s, d.f.icon_person_dressup_s);
            }
            if (this.jhZ != null) {
                al.c(this.jhZ, d.f.icon_news_down_bar_one);
            }
        }
        if (this.jib != null) {
            if (2 == i) {
                al.a(this.jib, d.f.icon_home_setting_s, d.f.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                al.a(this.jib, d.f.icon_home_setting_w, d.f.icon_home_setting_w);
            } else {
                al.a(this.jib, d.f.icon_home_setting_s, d.f.icon_home_setting_s);
            }
            if (this.jic != null) {
                al.c(this.jic, d.f.icon_news_down_bar_one);
            }
        }
        al.c(this.jif, d.f.selector_top_bar_scan);
    }

    @Override // com.baidu.tieba.view.f
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.jhY != null) {
                al.a(this.jhY, d.f.icon_person_dressup_s, d.f.icon_person_dressup_s);
            }
            if (this.jib != null) {
                al.a(this.jib, d.f.icon_home_setting_s, d.f.icon_home_setting_s);
            }
        } else {
            if (this.jhY != null) {
                al.a(this.jhY, d.f.icon_person_dressup, d.f.icon_person_dressup);
            }
            if (this.jib != null) {
                al.a(this.jib, d.f.icon_home_setting_w, d.f.icon_home_setting_w);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.jhY != null) {
                this.jhY.setAlpha(f2);
            }
            if (this.jib != null) {
                this.jib.setAlpha(f2);
            }
        }
    }

    public void bSd() {
        if (!this.jig) {
            this.jig = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_person_tab_feedback_tips", false);
            if (!this.jig) {
                View inflate = LayoutInflater.from(this.mContext).inflate(d.h.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(d.g.arrow_up);
                TextView textView = (TextView) inflate.findViewById(d.g.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = l.h(this.mContext, d.e.ds32);
                textView.setText(d.j.person_tab_feedback_tips);
                textView.setOnClickListener(this.fwA);
                this.hAK = new PopupWindow(inflate, -2, -2);
                this.mHandler.removeCallbacks(this.fwy);
                this.mHandler.postDelayed(this.fwy, 100L);
            }
        }
    }

    public void bNX() {
        this.mHandler.removeCallbacks(this.fwy);
        this.mHandler.removeCallbacks(this.fwz);
        bjA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjA() {
        com.baidu.adp.lib.g.g.a(this.hAK);
    }

    @Override // com.baidu.tieba.view.f
    public void setUserData(UserData userData) {
    }
}
