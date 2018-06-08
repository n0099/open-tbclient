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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class d implements f {
    private PopupWindow fFC;
    private RelativeLayout hka;
    private ImageView hkb;
    public ImageView hkc;
    private RelativeLayout hkd;
    private ImageView hke;
    public ImageView hkf;
    private View hkg;
    private ImageView hkh;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private int hjZ = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds28);
    private boolean hki = false;
    private Handler mHandler = new Handler();
    private Runnable fFI = new Runnable() { // from class: com.baidu.tieba.view.d.4
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.hke;
            if (imageView != null) {
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(d.this.fFC, imageView);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_person_tab_feedback_tips", true);
                d.this.hki = true;
                d.this.mHandler.postDelayed(d.this.fFJ, 3000L);
            }
        }
    };
    private Runnable fFJ = new Runnable() { // from class: com.baidu.tieba.view.d.5
        @Override // java.lang.Runnable
        public void run() {
            d.this.bgm();
        }
    };
    private View.OnClickListener fFK = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bgl();
        }
    };

    public d(int i) {
        this.mFrom = i;
    }

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.hka = (RelativeLayout) LayoutInflater.from(context).inflate(d.i.item_person_host_navigation_dressup, (ViewGroup) null);
        this.hkb = (ImageView) this.hka.findViewById(d.g.person_navigation_dressup_img);
        this.hkc = (ImageView) this.hka.findViewById(d.g.person_navigation_dressup_red_tip);
        this.hkd = (RelativeLayout) LayoutInflater.from(context).inflate(d.i.item_person_host_navigation_setting, (ViewGroup) null);
        this.hke = (ImageView) this.hkd.findViewById(d.g.person_navigation_setting_img);
        this.hkf = (ImageView) this.hkd.findViewById(d.g.person_navigation_setting_red_tip);
        this.hkg = LayoutInflater.from(this.mContext).inflate(d.i.item_person_host_navigation_scan, (ViewGroup) null);
        this.hkh = (ImageView) this.hkg.findViewById(d.g.person_navigation_scan_img);
    }

    @Override // com.baidu.tieba.view.f
    public void bjP() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.hka != null && this.hka.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hka, (View.OnClickListener) null);
            }
            if (this.hkd != null && this.hkd.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hkd, (View.OnClickListener) null);
            }
            if (this.hkg != null && this.hkg.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.hkg, (View.OnClickListener) null);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(g gVar) {
        if (this.hka != null) {
            this.hka.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new am("c12523").r("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new am("c12502").ah("obj_locate", "1"));
                    }
                    d.this.C(6, false);
                    com.baidu.tieba.o.a.bpq().b(6, false, true);
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DressupCenterActivityConfig(d.this.mContext)));
                        return;
                    }
                    BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(d.k.plugin_video_installing), 0).xi();
                }
            });
        }
        if (this.hkd != null) {
            this.hkd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new am("c12523").r("obj_locate", 23));
                    } else {
                        TiebaStatic.log(new am("c12502").ah("obj_locate", "2"));
                    }
                    d.this.C(5, false);
                    TiebaStatic.log(new am("c12502").ah("obj_locate", "2"));
                    d.this.C(5, false);
                    com.baidu.tieba.o.a.bpq().b(5, false, true);
                    if (!TbadkCoreApplication.getInst().appResponseToCmd(2015004)) {
                        BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(d.k.plugin_video_installing), 0).xi();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015004, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.hkg != null) {
            this.hkg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new am("c12706"));
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(QRCodeScanActivityConfig.class)) {
                        BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(d.k.plugin_video_installing), 0).xi();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new QRCodeScanActivityConfig(d.this.mContext)));
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.f
    public void C(int i, boolean z) {
        if (i == 5 && this.hkf != null) {
            this.hkf.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.hkc != null) {
            this.hkc.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.hkb != null) {
            if (2 == i) {
                al.a(this.hkb, d.f.icon_person_dressup_s, d.f.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                al.a(this.hkb, d.f.icon_person_dressup, d.f.icon_person_dressup);
            } else {
                al.a(this.hkb, d.f.icon_person_dressup_s, d.f.icon_person_dressup_s);
            }
            if (this.hkc != null) {
                al.c(this.hkc, d.f.icon_news_down_bar_one);
            }
        }
        if (this.hke != null) {
            if (2 == i) {
                al.a(this.hke, d.f.icon_home_setting_s, d.f.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                al.a(this.hke, d.f.icon_home_setting_w, d.f.icon_home_setting_w);
            } else {
                al.a(this.hke, d.f.icon_home_setting_s, d.f.icon_home_setting_s);
            }
            if (this.hkf != null) {
                al.c(this.hkf, d.f.icon_news_down_bar_one);
            }
        }
        al.c(this.hkh, d.f.selector_top_bar_scan);
    }

    @Override // com.baidu.tieba.view.f
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.hkb != null) {
                al.a(this.hkb, d.f.icon_person_dressup_s, d.f.icon_person_dressup_s);
            }
            if (this.hke != null) {
                al.a(this.hke, d.f.icon_home_setting_s, d.f.icon_home_setting_s);
            }
        } else {
            if (this.hkb != null) {
                al.a(this.hkb, d.f.icon_person_dressup, d.f.icon_person_dressup);
            }
            if (this.hke != null) {
                al.a(this.hke, d.f.icon_home_setting_w, d.f.icon_home_setting_w);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.hkb != null) {
                this.hkb.setAlpha(f2);
            }
            if (this.hke != null) {
                this.hke.setAlpha(f2);
            }
        }
    }

    public void bkt() {
        if (!this.hki) {
            this.hki = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_person_tab_feedback_tips", false);
            if (!this.hki) {
                View inflate = LayoutInflater.from(this.mContext).inflate(d.i.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(d.g.arrow_up);
                TextView textView = (TextView) inflate.findViewById(d.g.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = l.e(this.mContext, d.e.ds32);
                textView.setText(d.k.person_tab_feedback_tips);
                textView.setOnClickListener(this.fFK);
                this.fFC = new PopupWindow(inflate, -2, -2);
                this.mHandler.removeCallbacks(this.fFI);
                this.mHandler.postDelayed(this.fFI, 100L);
            }
        }
    }

    public void bgl() {
        this.mHandler.removeCallbacks(this.fFI);
        this.mHandler.removeCallbacks(this.fFJ);
        bgm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgm() {
        com.baidu.adp.lib.g.g.a(this.fFC);
    }

    @Override // com.baidu.tieba.view.f
    public void e(UserData userData) {
    }
}
