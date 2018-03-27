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
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class f implements h {
    private PopupWindow fZb;
    private RelativeLayout hAT;
    private ImageView hAU;
    public ImageView hAV;
    private RelativeLayout hAW;
    private ImageView hAX;
    public ImageView hAY;
    private ImageView hAZ;
    private View hBa;
    private ImageView hBb;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private int hAS = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds28);
    private boolean hBc = false;
    private Handler mHandler = new Handler();
    private Runnable fZh = new Runnable() { // from class: com.baidu.tieba.view.f.5
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = f.this.hAX;
            if (imageView != null) {
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(f.this.fZb, imageView);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_person_tab_feedback_tips", true);
                f.this.hBc = true;
                f.this.mHandler.postDelayed(f.this.fZi, 3000L);
            }
        }
    };
    private Runnable fZi = new Runnable() { // from class: com.baidu.tieba.view.f.6
        @Override // java.lang.Runnable
        public void run() {
            f.this.bgp();
        }
    };
    private View.OnClickListener fZj = new View.OnClickListener() { // from class: com.baidu.tieba.view.f.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.bgo();
        }
    };

    public f(int i) {
        this.mFrom = i;
    }

    @Override // com.baidu.tieba.view.h
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.hAT = (RelativeLayout) LayoutInflater.from(context).inflate(d.h.item_person_host_navigation_dressup, (ViewGroup) null);
        this.hAU = (ImageView) this.hAT.findViewById(d.g.person_navigation_dressup_img);
        this.hAV = (ImageView) this.hAT.findViewById(d.g.person_navigation_dressup_red_tip);
        this.hAW = (RelativeLayout) LayoutInflater.from(context).inflate(d.h.item_person_host_navigation_setting, (ViewGroup) null);
        this.hAX = (ImageView) this.hAW.findViewById(d.g.person_navigation_setting_img);
        this.hAY = (ImageView) this.hAW.findViewById(d.g.person_navigation_setting_red_tip);
        if (this.hAZ == null) {
            this.hAZ = new ImageView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, this.hAS, 0);
            this.hAZ.setLayoutParams(layoutParams);
            this.hAZ.setScaleType(ImageView.ScaleType.CENTER);
        }
        this.hBa = LayoutInflater.from(this.mContext).inflate(d.h.item_person_host_navigation_scan, (ViewGroup) null);
        this.hBb = (ImageView) this.hBa.findViewById(d.g.person_navigation_scan_img);
    }

    @Override // com.baidu.tieba.view.h
    public void bjN() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.hAT != null && this.hAT.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hAT, (View.OnClickListener) null);
            }
            if (this.hAW != null && this.hAW.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hAW, (View.OnClickListener) null);
            }
            if (this.hBa != null && this.hBa.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.hBa, (View.OnClickListener) null);
            }
        } else if (this.hAZ != null && this.hAZ.getParent() == null) {
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hAZ, (View.OnClickListener) null);
        }
    }

    @Override // com.baidu.tieba.view.h
    public void setOnViewResponseListener(i iVar) {
        if (this.hAT != null) {
            this.hAT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.mFrom == 1) {
                        TiebaStatic.log(new ak("c12523").s("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new ak("c12502").ab("obj_locate", "1"));
                    }
                    f.this.Q(6, false);
                    com.baidu.tieba.m.a.bpm().c(6, false, true);
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DressupCenterActivityConfig(f.this.mContext)));
                        return;
                    }
                    BdToast.a(f.this.mContext, f.this.mContext.getResources().getString(d.j.plugin_video_installing), 0).Bd();
                }
            });
        }
        if (this.hAW != null) {
            this.hAW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.mFrom == 1) {
                        TiebaStatic.log(new ak("c12523").s("obj_locate", 23));
                    } else {
                        TiebaStatic.log(new ak("c12502").ab("obj_locate", "2"));
                    }
                    f.this.Q(5, false);
                    TiebaStatic.log(new ak("c12502").ab("obj_locate", "2"));
                    f.this.Q(5, false);
                    com.baidu.tieba.m.a.bpm().c(5, false, true);
                    if (!TbadkCoreApplication.getInst().appResponseToCmd(2015004)) {
                        BdToast.a(f.this.mContext, f.this.mContext.getResources().getString(d.j.plugin_video_installing), 0).Bd();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015004, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.hAZ != null) {
            this.hAZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.f.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016559));
                }
            });
        }
        if (this.hBa != null) {
            this.hBa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.f.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ak("c12706"));
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(QRCodeScanActivityConfig.class)) {
                        BdToast.a(f.this.mContext, f.this.mContext.getResources().getString(d.j.plugin_video_installing), 0).Bd();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new QRCodeScanActivityConfig(f.this.mContext)));
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.h
    public void Q(int i, boolean z) {
        if (i == 5 && this.hAY != null) {
            this.hAY.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.hAV != null) {
            this.hAV.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.h
    public void onChangeSkinType(int i) {
        if (this.hAU != null) {
            if (2 == i) {
                aj.a(this.hAU, d.f.icon_person_dressup_s, d.f.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.a(this.hAU, d.f.icon_person_dressup, d.f.icon_person_dressup);
            } else {
                aj.a(this.hAU, d.f.icon_person_dressup_s, d.f.icon_person_dressup_s);
            }
            if (this.hAV != null) {
                aj.c(this.hAV, d.f.icon_news_down_bar_one);
            }
        }
        if (this.hAX != null) {
            if (2 == i) {
                aj.a(this.hAX, d.f.icon_home_setting_s, d.f.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.a(this.hAX, d.f.icon_home_setting_w, d.f.icon_home_setting_w);
            } else {
                aj.a(this.hAX, d.f.icon_home_setting_s, d.f.icon_home_setting_s);
            }
            if (this.hAY != null) {
                aj.c(this.hAY, d.f.icon_news_down_bar_one);
            }
        }
        if (this.hAZ != null) {
            if (2 == i) {
                aj.a(this.hAZ, d.f.icon_person_editor, d.f.icon_person_editor_s);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.a(this.hAZ, d.f.icon_person_editor_s, d.f.icon_person_editor_s);
            } else {
                aj.a(this.hAZ, d.f.icon_person_editor, d.f.icon_person_editor);
            }
        }
        aj.c(this.hBb, d.f.selector_top_bar_scan);
    }

    @Override // com.baidu.tieba.view.h
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.hAU != null) {
                aj.a(this.hAU, d.f.icon_person_dressup_s, d.f.icon_person_dressup_s);
            }
            if (this.hAX != null) {
                aj.a(this.hAX, d.f.icon_home_setting_s, d.f.icon_home_setting_s);
            }
            if (this.hAZ != null) {
                aj.a(this.hAZ, d.f.icon_person_editor, d.f.icon_person_editor);
            }
        } else {
            if (this.hAU != null) {
                aj.a(this.hAU, d.f.icon_person_dressup, d.f.icon_person_dressup);
            }
            if (this.hAX != null) {
                aj.a(this.hAX, d.f.icon_home_setting_w, d.f.icon_home_setting_w);
            }
            if (this.hAZ != null) {
                aj.a(this.hAZ, d.f.icon_person_editor_s, d.f.icon_person_editor_s);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.hAU != null) {
                this.hAU.setAlpha(f2);
            }
            if (this.hAX != null) {
                this.hAX.setAlpha(f2);
            }
            if (this.hAZ != null) {
                this.hAZ.setAlpha(f2);
            }
        }
    }

    public void bkp() {
        if (!this.hBc) {
            this.hBc = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_person_tab_feedback_tips", false);
            if (!this.hBc) {
                View inflate = LayoutInflater.from(this.mContext).inflate(d.h.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(d.g.arrow_up);
                TextView textView = (TextView) inflate.findViewById(d.g.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds32);
                textView.setText(d.j.person_tab_feedback_tips);
                textView.setOnClickListener(this.fZj);
                this.fZb = new PopupWindow(inflate, -2, -2);
                this.mHandler.removeCallbacks(this.fZh);
                this.mHandler.postDelayed(this.fZh, 100L);
            }
        }
    }

    public void bgo() {
        this.mHandler.removeCallbacks(this.fZh);
        this.mHandler.removeCallbacks(this.fZi);
        bgp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgp() {
        com.baidu.adp.lib.g.g.b(this.fZb);
    }

    @Override // com.baidu.tieba.view.h
    public void e(UserData userData) {
    }
}
