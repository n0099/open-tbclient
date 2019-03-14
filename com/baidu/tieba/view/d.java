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
    private PopupWindow hAX;
    private RelativeLayout jij;
    private ImageView jik;
    public ImageView jil;
    private RelativeLayout jim;
    private ImageView jin;
    public ImageView jio;
    private View jip;
    private ImageView jiq;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private int jii = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds28);
    private boolean jir = false;
    private Handler mHandler = new Handler();
    private Runnable fwL = new Runnable() { // from class: com.baidu.tieba.view.d.4
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.jin;
            if (imageView != null) {
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(d.this.hAX, imageView);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_person_tab_feedback_tips", true);
                d.this.jir = true;
                d.this.mHandler.postDelayed(d.this.fwM, 3000L);
            }
        }
    };
    private Runnable fwM = new Runnable() { // from class: com.baidu.tieba.view.d.5
        @Override // java.lang.Runnable
        public void run() {
            d.this.bjC();
        }
    };
    private View.OnClickListener fwN = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.6
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
        this.jij = (RelativeLayout) LayoutInflater.from(context).inflate(d.h.item_person_host_navigation_dressup, (ViewGroup) null);
        this.jik = (ImageView) this.jij.findViewById(d.g.person_navigation_dressup_img);
        this.jil = (ImageView) this.jij.findViewById(d.g.person_navigation_dressup_red_tip);
        this.jim = (RelativeLayout) LayoutInflater.from(context).inflate(d.h.item_person_host_navigation_setting, (ViewGroup) null);
        this.jin = (ImageView) this.jim.findViewById(d.g.person_navigation_setting_img);
        this.jio = (ImageView) this.jim.findViewById(d.g.person_navigation_setting_red_tip);
        this.jip = LayoutInflater.from(this.mContext).inflate(d.h.item_person_host_navigation_scan, (ViewGroup) null);
        this.jiq = (ImageView) this.jip.findViewById(d.g.person_navigation_scan_img);
    }

    @Override // com.baidu.tieba.view.f
    public void bRC() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.jij != null && this.jij.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jij, (View.OnClickListener) null);
            }
            if (this.jim != null && this.jim.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jim, (View.OnClickListener) null);
            }
            if (this.jip != null && this.jip.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.jip, (View.OnClickListener) null);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(g gVar) {
        if (this.jij != null) {
            this.jij.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new am("c12523").T("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new am("c12502").bJ("obj_locate", "1"));
                    }
                    d.this.I(6, false);
                    com.baidu.tieba.o.a.bXW().d(6, false, true);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DressupCenterActivityConfig(d.this.mContext)));
                }
            });
        }
        if (this.jim != null) {
            this.jim.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
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
                    com.baidu.tieba.o.a.bXW().d(5, false, true);
                    if (!TbadkCoreApplication.getInst().appResponseToCmd(2015004)) {
                        BdToast.b(d.this.mContext, d.this.mContext.getResources().getString(d.j.plugin_video_installing), 0).abh();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015004, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.jip != null) {
            this.jip.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mContext instanceof Activity) {
                        Activity activity = (Activity) d.this.mContext;
                        if (d.this.mPermissionJudgement == null) {
                            d.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                        }
                        d.this.mPermissionJudgement.adQ();
                        d.this.mPermissionJudgement.e(activity, "android.permission.CAMERA");
                        d.this.mPermissionJudgement.a(new a.InterfaceC0227a() { // from class: com.baidu.tieba.view.d.3.1
                            @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0227a
                            public void adR() {
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
        if (i == 5 && this.jio != null) {
            this.jio.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.jil != null) {
            this.jil.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.jik != null) {
            if (2 == i) {
                al.a(this.jik, d.f.icon_person_dressup_s, d.f.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                al.a(this.jik, d.f.icon_person_dressup, d.f.icon_person_dressup);
            } else {
                al.a(this.jik, d.f.icon_person_dressup_s, d.f.icon_person_dressup_s);
            }
            if (this.jil != null) {
                al.c(this.jil, d.f.icon_news_down_bar_one);
            }
        }
        if (this.jin != null) {
            if (2 == i) {
                al.a(this.jin, d.f.icon_home_setting_s, d.f.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                al.a(this.jin, d.f.icon_home_setting_w, d.f.icon_home_setting_w);
            } else {
                al.a(this.jin, d.f.icon_home_setting_s, d.f.icon_home_setting_s);
            }
            if (this.jio != null) {
                al.c(this.jio, d.f.icon_news_down_bar_one);
            }
        }
        al.c(this.jiq, d.f.selector_top_bar_scan);
    }

    @Override // com.baidu.tieba.view.f
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.jik != null) {
                al.a(this.jik, d.f.icon_person_dressup_s, d.f.icon_person_dressup_s);
            }
            if (this.jin != null) {
                al.a(this.jin, d.f.icon_home_setting_s, d.f.icon_home_setting_s);
            }
        } else {
            if (this.jik != null) {
                al.a(this.jik, d.f.icon_person_dressup, d.f.icon_person_dressup);
            }
            if (this.jin != null) {
                al.a(this.jin, d.f.icon_home_setting_w, d.f.icon_home_setting_w);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.jik != null) {
                this.jik.setAlpha(f2);
            }
            if (this.jin != null) {
                this.jin.setAlpha(f2);
            }
        }
    }

    public void bSh() {
        if (!this.jir) {
            this.jir = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_person_tab_feedback_tips", false);
            if (!this.jir) {
                View inflate = LayoutInflater.from(this.mContext).inflate(d.h.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(d.g.arrow_up);
                TextView textView = (TextView) inflate.findViewById(d.g.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = l.h(this.mContext, d.e.ds32);
                textView.setText(d.j.person_tab_feedback_tips);
                textView.setOnClickListener(this.fwN);
                this.hAX = new PopupWindow(inflate, -2, -2);
                this.mHandler.removeCallbacks(this.fwL);
                this.mHandler.postDelayed(this.fwL, 100L);
            }
        }
    }

    public void bOa() {
        this.mHandler.removeCallbacks(this.fwL);
        this.mHandler.removeCallbacks(this.fwM);
        bjC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjC() {
        com.baidu.adp.lib.g.g.a(this.hAX);
    }

    @Override // com.baidu.tieba.view.f
    public void setUserData(UserData userData) {
    }
}
