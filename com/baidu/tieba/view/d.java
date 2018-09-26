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
import com.baidu.tieba.e;
/* loaded from: classes2.dex */
public class d implements f {
    private PopupWindow fRq;
    private RelativeLayout hxg;
    private ImageView hxh;
    public ImageView hxi;
    private RelativeLayout hxj;
    private ImageView hxk;
    public ImageView hxl;
    private View hxm;
    private ImageView hxn;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private int hxf = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0141e.ds28);
    private boolean hxo = false;
    private Handler mHandler = new Handler();
    private Runnable fRv = new Runnable() { // from class: com.baidu.tieba.view.d.4
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.hxk;
            if (imageView != null) {
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(d.this.fRq, imageView);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_person_tab_feedback_tips", true);
                d.this.hxo = true;
                d.this.mHandler.postDelayed(d.this.fRw, 3000L);
            }
        }
    };
    private Runnable fRw = new Runnable() { // from class: com.baidu.tieba.view.d.5
        @Override // java.lang.Runnable
        public void run() {
            d.this.bhM();
        }
    };
    private View.OnClickListener fRx = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bhL();
        }
    };

    public d(int i) {
        this.mFrom = i;
    }

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.hxg = (RelativeLayout) LayoutInflater.from(context).inflate(e.h.item_person_host_navigation_dressup, (ViewGroup) null);
        this.hxh = (ImageView) this.hxg.findViewById(e.g.person_navigation_dressup_img);
        this.hxi = (ImageView) this.hxg.findViewById(e.g.person_navigation_dressup_red_tip);
        this.hxj = (RelativeLayout) LayoutInflater.from(context).inflate(e.h.item_person_host_navigation_setting, (ViewGroup) null);
        this.hxk = (ImageView) this.hxj.findViewById(e.g.person_navigation_setting_img);
        this.hxl = (ImageView) this.hxj.findViewById(e.g.person_navigation_setting_red_tip);
        this.hxm = LayoutInflater.from(this.mContext).inflate(e.h.item_person_host_navigation_scan, (ViewGroup) null);
        this.hxn = (ImageView) this.hxm.findViewById(e.g.person_navigation_scan_img);
    }

    @Override // com.baidu.tieba.view.f
    public void blm() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.hxg != null && this.hxg.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hxg, (View.OnClickListener) null);
            }
            if (this.hxj != null && this.hxj.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hxj, (View.OnClickListener) null);
            }
            if (this.hxm != null && this.hxm.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.hxm, (View.OnClickListener) null);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(g gVar) {
        if (this.hxg != null) {
            this.hxg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new am("c12523").w("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new am("c12502").al("obj_locate", "1"));
                    }
                    d.this.C(6, false);
                    com.baidu.tieba.o.a.brf().c(6, false, true);
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DressupCenterActivityConfig(d.this.mContext)));
                        return;
                    }
                    BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(e.j.plugin_video_installing), 0).yt();
                }
            });
        }
        if (this.hxj != null) {
            this.hxj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new am("c12523").w("obj_locate", 23));
                    } else {
                        TiebaStatic.log(new am("c12502").al("obj_locate", "2"));
                    }
                    d.this.C(5, false);
                    TiebaStatic.log(new am("c12502").al("obj_locate", "2"));
                    d.this.C(5, false);
                    com.baidu.tieba.o.a.brf().c(5, false, true);
                    if (!TbadkCoreApplication.getInst().appResponseToCmd(2015004)) {
                        BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(e.j.plugin_video_installing), 0).yt();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015004, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.hxm != null) {
            this.hxm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new am("c12706"));
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(QRCodeScanActivityConfig.class)) {
                        BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(e.j.plugin_video_installing), 0).yt();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new QRCodeScanActivityConfig(d.this.mContext)));
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.f
    public void C(int i, boolean z) {
        if (i == 5 && this.hxl != null) {
            this.hxl.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.hxi != null) {
            this.hxi.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.hxh != null) {
            if (2 == i) {
                al.a(this.hxh, e.f.icon_person_dressup_s, e.f.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                al.a(this.hxh, e.f.icon_person_dressup, e.f.icon_person_dressup);
            } else {
                al.a(this.hxh, e.f.icon_person_dressup_s, e.f.icon_person_dressup_s);
            }
            if (this.hxi != null) {
                al.c(this.hxi, e.f.icon_news_down_bar_one);
            }
        }
        if (this.hxk != null) {
            if (2 == i) {
                al.a(this.hxk, e.f.icon_home_setting_s, e.f.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                al.a(this.hxk, e.f.icon_home_setting_w, e.f.icon_home_setting_w);
            } else {
                al.a(this.hxk, e.f.icon_home_setting_s, e.f.icon_home_setting_s);
            }
            if (this.hxl != null) {
                al.c(this.hxl, e.f.icon_news_down_bar_one);
            }
        }
        al.c(this.hxn, e.f.selector_top_bar_scan);
    }

    @Override // com.baidu.tieba.view.f
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.hxh != null) {
                al.a(this.hxh, e.f.icon_person_dressup_s, e.f.icon_person_dressup_s);
            }
            if (this.hxk != null) {
                al.a(this.hxk, e.f.icon_home_setting_s, e.f.icon_home_setting_s);
            }
        } else {
            if (this.hxh != null) {
                al.a(this.hxh, e.f.icon_person_dressup, e.f.icon_person_dressup);
            }
            if (this.hxk != null) {
                al.a(this.hxk, e.f.icon_home_setting_w, e.f.icon_home_setting_w);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.hxh != null) {
                this.hxh.setAlpha(f2);
            }
            if (this.hxk != null) {
                this.hxk.setAlpha(f2);
            }
        }
    }

    public void blQ() {
        if (!this.hxo) {
            this.hxo = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_person_tab_feedback_tips", false);
            if (!this.hxo) {
                View inflate = LayoutInflater.from(this.mContext).inflate(e.h.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(e.g.arrow_up);
                TextView textView = (TextView) inflate.findViewById(e.g.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = l.h(this.mContext, e.C0141e.ds32);
                textView.setText(e.j.person_tab_feedback_tips);
                textView.setOnClickListener(this.fRx);
                this.fRq = new PopupWindow(inflate, -2, -2);
                this.mHandler.removeCallbacks(this.fRv);
                this.mHandler.postDelayed(this.fRv, 100L);
            }
        }
    }

    public void bhL() {
        this.mHandler.removeCallbacks(this.fRv);
        this.mHandler.removeCallbacks(this.fRw);
        bhM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhM() {
        com.baidu.adp.lib.g.g.a(this.fRq);
    }

    @Override // com.baidu.tieba.view.f
    public void e(UserData userData) {
    }
}
