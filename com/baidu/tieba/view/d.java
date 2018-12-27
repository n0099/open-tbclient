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
    private com.baidu.tbadk.core.util.b.a bzi;
    private PopupWindow gka;
    private ImageView hQA;
    public ImageView hQB;
    private RelativeLayout hQC;
    private ImageView hQD;
    public ImageView hQE;
    private View hQF;
    private ImageView hQG;
    private RelativeLayout hQz;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private int hQy = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds28);
    private boolean hQH = false;
    private Handler mHandler = new Handler();
    private Runnable egX = new Runnable() { // from class: com.baidu.tieba.view.d.4
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.hQD;
            if (imageView != null) {
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(d.this.gka, imageView);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_person_tab_feedback_tips", true);
                d.this.hQH = true;
                d.this.mHandler.postDelayed(d.this.egY, 3000L);
            }
        }
    };
    private Runnable egY = new Runnable() { // from class: com.baidu.tieba.view.d.5
        @Override // java.lang.Runnable
        public void run() {
            d.this.aIp();
        }
    };
    private View.OnClickListener egZ = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bmY();
        }
    };

    public d(int i) {
        this.mFrom = i;
    }

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.hQz = (RelativeLayout) LayoutInflater.from(context).inflate(e.h.item_person_host_navigation_dressup, (ViewGroup) null);
        this.hQA = (ImageView) this.hQz.findViewById(e.g.person_navigation_dressup_img);
        this.hQB = (ImageView) this.hQz.findViewById(e.g.person_navigation_dressup_red_tip);
        this.hQC = (RelativeLayout) LayoutInflater.from(context).inflate(e.h.item_person_host_navigation_setting, (ViewGroup) null);
        this.hQD = (ImageView) this.hQC.findViewById(e.g.person_navigation_setting_img);
        this.hQE = (ImageView) this.hQC.findViewById(e.g.person_navigation_setting_red_tip);
        this.hQF = LayoutInflater.from(this.mContext).inflate(e.h.item_person_host_navigation_scan, (ViewGroup) null);
        this.hQG = (ImageView) this.hQF.findViewById(e.g.person_navigation_scan_img);
    }

    @Override // com.baidu.tieba.view.f
    public void bqw() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.hQz != null && this.hQz.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hQz, (View.OnClickListener) null);
            }
            if (this.hQC != null && this.hQC.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hQC, (View.OnClickListener) null);
            }
            if (this.hQF != null && this.hQF.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.hQF, (View.OnClickListener) null);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(g gVar) {
        if (this.hQz != null) {
            this.hQz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new am("c12523").x("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new am("c12502").aA("obj_locate", "1"));
                    }
                    d.this.C(6, false);
                    com.baidu.tieba.o.a.bww().c(6, false, true);
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DressupCenterActivityConfig(d.this.mContext)));
                        return;
                    }
                    BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(e.j.plugin_video_installing), 0).BN();
                }
            });
        }
        if (this.hQC != null) {
            this.hQC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new am("c12523").x("obj_locate", 23));
                    } else {
                        TiebaStatic.log(new am("c12502").aA("obj_locate", "2"));
                    }
                    d.this.C(5, false);
                    TiebaStatic.log(new am("c12502").aA("obj_locate", "2"));
                    d.this.C(5, false);
                    com.baidu.tieba.o.a.bww().c(5, false, true);
                    if (!TbadkCoreApplication.getInst().appResponseToCmd(2015004)) {
                        BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(e.j.plugin_video_installing), 0).BN();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015004, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.hQF != null) {
            this.hQF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mContext instanceof Activity) {
                        if (TbadkCoreApplication.getInst().appResponseToIntentClass(QRCodeScanActivityConfig.class)) {
                            Activity activity = (Activity) d.this.mContext;
                            if (d.this.bzi == null) {
                                d.this.bzi = new com.baidu.tbadk.core.util.b.a();
                            }
                            d.this.bzi.Et();
                            d.this.bzi.c(activity, "android.permission.CAMERA");
                            d.this.bzi.a(new a.InterfaceC0160a() { // from class: com.baidu.tieba.view.d.3.1
                                @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0160a
                                public void Eu() {
                                    TiebaStatic.log(new am("c12706"));
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new QRCodeScanActivityConfig(d.this.mContext)));
                                }
                            });
                            d.this.bzi.A(activity);
                            return;
                        }
                        BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(e.j.plugin_video_installing), 0).BN();
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.f
    public void C(int i, boolean z) {
        if (i == 5 && this.hQE != null) {
            this.hQE.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.hQB != null) {
            this.hQB.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.hQA != null) {
            if (2 == i) {
                al.a(this.hQA, e.f.icon_person_dressup_s, e.f.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                al.a(this.hQA, e.f.icon_person_dressup, e.f.icon_person_dressup);
            } else {
                al.a(this.hQA, e.f.icon_person_dressup_s, e.f.icon_person_dressup_s);
            }
            if (this.hQB != null) {
                al.c(this.hQB, e.f.icon_news_down_bar_one);
            }
        }
        if (this.hQD != null) {
            if (2 == i) {
                al.a(this.hQD, e.f.icon_home_setting_s, e.f.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                al.a(this.hQD, e.f.icon_home_setting_w, e.f.icon_home_setting_w);
            } else {
                al.a(this.hQD, e.f.icon_home_setting_s, e.f.icon_home_setting_s);
            }
            if (this.hQE != null) {
                al.c(this.hQE, e.f.icon_news_down_bar_one);
            }
        }
        al.c(this.hQG, e.f.selector_top_bar_scan);
    }

    @Override // com.baidu.tieba.view.f
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.hQA != null) {
                al.a(this.hQA, e.f.icon_person_dressup_s, e.f.icon_person_dressup_s);
            }
            if (this.hQD != null) {
                al.a(this.hQD, e.f.icon_home_setting_s, e.f.icon_home_setting_s);
            }
        } else {
            if (this.hQA != null) {
                al.a(this.hQA, e.f.icon_person_dressup, e.f.icon_person_dressup);
            }
            if (this.hQD != null) {
                al.a(this.hQD, e.f.icon_home_setting_w, e.f.icon_home_setting_w);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.hQA != null) {
                this.hQA.setAlpha(f2);
            }
            if (this.hQD != null) {
                this.hQD.setAlpha(f2);
            }
        }
    }

    public void bra() {
        if (!this.hQH) {
            this.hQH = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_person_tab_feedback_tips", false);
            if (!this.hQH) {
                View inflate = LayoutInflater.from(this.mContext).inflate(e.h.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(e.g.arrow_up);
                TextView textView = (TextView) inflate.findViewById(e.g.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = l.h(this.mContext, e.C0210e.ds32);
                textView.setText(e.j.person_tab_feedback_tips);
                textView.setOnClickListener(this.egZ);
                this.gka = new PopupWindow(inflate, -2, -2);
                this.mHandler.removeCallbacks(this.egX);
                this.mHandler.postDelayed(this.egX, 100L);
            }
        }
    }

    public void bmY() {
        this.mHandler.removeCallbacks(this.egX);
        this.mHandler.removeCallbacks(this.egY);
        aIp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIp() {
        com.baidu.adp.lib.g.g.a(this.gka);
    }

    @Override // com.baidu.tieba.view.f
    public void e(UserData userData) {
    }
}
