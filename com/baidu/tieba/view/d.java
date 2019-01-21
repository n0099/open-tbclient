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
    private PopupWindow gle;
    private RelativeLayout hRH;
    private ImageView hRI;
    public ImageView hRJ;
    private RelativeLayout hRK;
    private ImageView hRL;
    public ImageView hRM;
    private View hRN;
    private ImageView hRO;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private int hRG = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds28);
    private boolean hRP = false;
    private Handler mHandler = new Handler();
    private Runnable ehE = new Runnable() { // from class: com.baidu.tieba.view.d.4
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.hRL;
            if (imageView != null) {
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(d.this.gle, imageView);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_person_tab_feedback_tips", true);
                d.this.hRP = true;
                d.this.mHandler.postDelayed(d.this.ehF, 3000L);
            }
        }
    };
    private Runnable ehF = new Runnable() { // from class: com.baidu.tieba.view.d.5
        @Override // java.lang.Runnable
        public void run() {
            d.this.aIM();
        }
    };
    private View.OnClickListener ehG = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bnG();
        }
    };

    public d(int i) {
        this.mFrom = i;
    }

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.hRH = (RelativeLayout) LayoutInflater.from(context).inflate(e.h.item_person_host_navigation_dressup, (ViewGroup) null);
        this.hRI = (ImageView) this.hRH.findViewById(e.g.person_navigation_dressup_img);
        this.hRJ = (ImageView) this.hRH.findViewById(e.g.person_navigation_dressup_red_tip);
        this.hRK = (RelativeLayout) LayoutInflater.from(context).inflate(e.h.item_person_host_navigation_setting, (ViewGroup) null);
        this.hRL = (ImageView) this.hRK.findViewById(e.g.person_navigation_setting_img);
        this.hRM = (ImageView) this.hRK.findViewById(e.g.person_navigation_setting_red_tip);
        this.hRN = LayoutInflater.from(this.mContext).inflate(e.h.item_person_host_navigation_scan, (ViewGroup) null);
        this.hRO = (ImageView) this.hRN.findViewById(e.g.person_navigation_scan_img);
    }

    @Override // com.baidu.tieba.view.f
    public void brf() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.hRH != null && this.hRH.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hRH, (View.OnClickListener) null);
            }
            if (this.hRK != null && this.hRK.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hRK, (View.OnClickListener) null);
            }
            if (this.hRN != null && this.hRN.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.hRN, (View.OnClickListener) null);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(g gVar) {
        if (this.hRH != null) {
            this.hRH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new am("c12523").y("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new am("c12502").aB("obj_locate", "1"));
                    }
                    d.this.C(6, false);
                    com.baidu.tieba.o.a.bxf().c(6, false, true);
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DressupCenterActivityConfig(d.this.mContext)));
                        return;
                    }
                    BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(e.j.plugin_video_installing), 0).Ca();
                }
            });
        }
        if (this.hRK != null) {
            this.hRK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new am("c12523").y("obj_locate", 23));
                    } else {
                        TiebaStatic.log(new am("c12502").aB("obj_locate", "2"));
                    }
                    d.this.C(5, false);
                    TiebaStatic.log(new am("c12502").aB("obj_locate", "2"));
                    d.this.C(5, false);
                    com.baidu.tieba.o.a.bxf().c(5, false, true);
                    if (!TbadkCoreApplication.getInst().appResponseToCmd(2015004)) {
                        BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(e.j.plugin_video_installing), 0).Ca();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015004, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.hRN != null) {
            this.hRN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mContext instanceof Activity) {
                        if (TbadkCoreApplication.getInst().appResponseToIntentClass(QRCodeScanActivityConfig.class)) {
                            Activity activity = (Activity) d.this.mContext;
                            if (d.this.mPermissionJudgement == null) {
                                d.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                            }
                            d.this.mPermissionJudgement.EG();
                            d.this.mPermissionJudgement.c(activity, "android.permission.CAMERA");
                            d.this.mPermissionJudgement.a(new a.InterfaceC0160a() { // from class: com.baidu.tieba.view.d.3.1
                                @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0160a
                                public void EH() {
                                    TiebaStatic.log(new am("c12706"));
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new QRCodeScanActivityConfig(d.this.mContext)));
                                }
                            });
                            d.this.mPermissionJudgement.B(activity);
                            return;
                        }
                        BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(e.j.plugin_video_installing), 0).Ca();
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.f
    public void C(int i, boolean z) {
        if (i == 5 && this.hRM != null) {
            this.hRM.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.hRJ != null) {
            this.hRJ.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.hRI != null) {
            if (2 == i) {
                al.a(this.hRI, e.f.icon_person_dressup_s, e.f.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                al.a(this.hRI, e.f.icon_person_dressup, e.f.icon_person_dressup);
            } else {
                al.a(this.hRI, e.f.icon_person_dressup_s, e.f.icon_person_dressup_s);
            }
            if (this.hRJ != null) {
                al.c(this.hRJ, e.f.icon_news_down_bar_one);
            }
        }
        if (this.hRL != null) {
            if (2 == i) {
                al.a(this.hRL, e.f.icon_home_setting_s, e.f.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                al.a(this.hRL, e.f.icon_home_setting_w, e.f.icon_home_setting_w);
            } else {
                al.a(this.hRL, e.f.icon_home_setting_s, e.f.icon_home_setting_s);
            }
            if (this.hRM != null) {
                al.c(this.hRM, e.f.icon_news_down_bar_one);
            }
        }
        al.c(this.hRO, e.f.selector_top_bar_scan);
    }

    @Override // com.baidu.tieba.view.f
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.hRI != null) {
                al.a(this.hRI, e.f.icon_person_dressup_s, e.f.icon_person_dressup_s);
            }
            if (this.hRL != null) {
                al.a(this.hRL, e.f.icon_home_setting_s, e.f.icon_home_setting_s);
            }
        } else {
            if (this.hRI != null) {
                al.a(this.hRI, e.f.icon_person_dressup, e.f.icon_person_dressup);
            }
            if (this.hRL != null) {
                al.a(this.hRL, e.f.icon_home_setting_w, e.f.icon_home_setting_w);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.hRI != null) {
                this.hRI.setAlpha(f2);
            }
            if (this.hRL != null) {
                this.hRL.setAlpha(f2);
            }
        }
    }

    public void brJ() {
        if (!this.hRP) {
            this.hRP = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_person_tab_feedback_tips", false);
            if (!this.hRP) {
                View inflate = LayoutInflater.from(this.mContext).inflate(e.h.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(e.g.arrow_up);
                TextView textView = (TextView) inflate.findViewById(e.g.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = l.h(this.mContext, e.C0210e.ds32);
                textView.setText(e.j.person_tab_feedback_tips);
                textView.setOnClickListener(this.ehG);
                this.gle = new PopupWindow(inflate, -2, -2);
                this.mHandler.removeCallbacks(this.ehE);
                this.mHandler.postDelayed(this.ehE, 100L);
            }
        }
    }

    public void bnG() {
        this.mHandler.removeCallbacks(this.ehE);
        this.mHandler.removeCallbacks(this.ehF);
        aIM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIM() {
        com.baidu.adp.lib.g.g.a(this.gle);
    }

    @Override // com.baidu.tieba.view.f
    public void e(UserData userData) {
    }
}
