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
    private PopupWindow fYW;
    private RelativeLayout hAI;
    private ImageView hAJ;
    public ImageView hAK;
    private RelativeLayout hAL;
    private ImageView hAM;
    public ImageView hAN;
    private ImageView hAO;
    private View hAP;
    private ImageView hAQ;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private int hAH = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds28);
    private boolean hAR = false;
    private Handler mHandler = new Handler();
    private Runnable fZc = new Runnable() { // from class: com.baidu.tieba.view.f.5
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = f.this.hAM;
            if (imageView != null) {
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(f.this.fYW, imageView);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_person_tab_feedback_tips", true);
                f.this.hAR = true;
                f.this.mHandler.postDelayed(f.this.fZd, 3000L);
            }
        }
    };
    private Runnable fZd = new Runnable() { // from class: com.baidu.tieba.view.f.6
        @Override // java.lang.Runnable
        public void run() {
            f.this.bgp();
        }
    };
    private View.OnClickListener fZe = new View.OnClickListener() { // from class: com.baidu.tieba.view.f.7
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
        this.hAI = (RelativeLayout) LayoutInflater.from(context).inflate(d.h.item_person_host_navigation_dressup, (ViewGroup) null);
        this.hAJ = (ImageView) this.hAI.findViewById(d.g.person_navigation_dressup_img);
        this.hAK = (ImageView) this.hAI.findViewById(d.g.person_navigation_dressup_red_tip);
        this.hAL = (RelativeLayout) LayoutInflater.from(context).inflate(d.h.item_person_host_navigation_setting, (ViewGroup) null);
        this.hAM = (ImageView) this.hAL.findViewById(d.g.person_navigation_setting_img);
        this.hAN = (ImageView) this.hAL.findViewById(d.g.person_navigation_setting_red_tip);
        if (this.hAO == null) {
            this.hAO = new ImageView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, this.hAH, 0);
            this.hAO.setLayoutParams(layoutParams);
            this.hAO.setScaleType(ImageView.ScaleType.CENTER);
        }
        this.hAP = LayoutInflater.from(this.mContext).inflate(d.h.item_person_host_navigation_scan, (ViewGroup) null);
        this.hAQ = (ImageView) this.hAP.findViewById(d.g.person_navigation_scan_img);
    }

    @Override // com.baidu.tieba.view.h
    public void bjN() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.hAI != null && this.hAI.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hAI, (View.OnClickListener) null);
            }
            if (this.hAL != null && this.hAL.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hAL, (View.OnClickListener) null);
            }
            if (this.hAP != null && this.hAP.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.hAP, (View.OnClickListener) null);
            }
        } else if (this.hAO != null && this.hAO.getParent() == null) {
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hAO, (View.OnClickListener) null);
        }
    }

    @Override // com.baidu.tieba.view.h
    public void setOnViewResponseListener(i iVar) {
        if (this.hAI != null) {
            this.hAI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.f.1
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
                    BdToast.a(f.this.mContext, f.this.mContext.getResources().getString(d.j.plugin_video_installing), 0).Bc();
                }
            });
        }
        if (this.hAL != null) {
            this.hAL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.f.2
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
                        BdToast.a(f.this.mContext, f.this.mContext.getResources().getString(d.j.plugin_video_installing), 0).Bc();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015004, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.hAO != null) {
            this.hAO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.f.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016559));
                }
            });
        }
        if (this.hAP != null) {
            this.hAP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.f.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ak("c12706"));
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(QRCodeScanActivityConfig.class)) {
                        BdToast.a(f.this.mContext, f.this.mContext.getResources().getString(d.j.plugin_video_installing), 0).Bc();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new QRCodeScanActivityConfig(f.this.mContext)));
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.h
    public void Q(int i, boolean z) {
        if (i == 5 && this.hAN != null) {
            this.hAN.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.hAK != null) {
            this.hAK.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.h
    public void onChangeSkinType(int i) {
        if (this.hAJ != null) {
            if (2 == i) {
                aj.a(this.hAJ, d.f.icon_person_dressup_s, d.f.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.a(this.hAJ, d.f.icon_person_dressup, d.f.icon_person_dressup);
            } else {
                aj.a(this.hAJ, d.f.icon_person_dressup_s, d.f.icon_person_dressup_s);
            }
            if (this.hAK != null) {
                aj.c(this.hAK, d.f.icon_news_down_bar_one);
            }
        }
        if (this.hAM != null) {
            if (2 == i) {
                aj.a(this.hAM, d.f.icon_home_setting_s, d.f.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.a(this.hAM, d.f.icon_home_setting_w, d.f.icon_home_setting_w);
            } else {
                aj.a(this.hAM, d.f.icon_home_setting_s, d.f.icon_home_setting_s);
            }
            if (this.hAN != null) {
                aj.c(this.hAN, d.f.icon_news_down_bar_one);
            }
        }
        if (this.hAO != null) {
            if (2 == i) {
                aj.a(this.hAO, d.f.icon_person_editor, d.f.icon_person_editor_s);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.a(this.hAO, d.f.icon_person_editor_s, d.f.icon_person_editor_s);
            } else {
                aj.a(this.hAO, d.f.icon_person_editor, d.f.icon_person_editor);
            }
        }
        aj.c(this.hAQ, d.f.selector_top_bar_scan);
    }

    @Override // com.baidu.tieba.view.h
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.hAJ != null) {
                aj.a(this.hAJ, d.f.icon_person_dressup_s, d.f.icon_person_dressup_s);
            }
            if (this.hAM != null) {
                aj.a(this.hAM, d.f.icon_home_setting_s, d.f.icon_home_setting_s);
            }
            if (this.hAO != null) {
                aj.a(this.hAO, d.f.icon_person_editor, d.f.icon_person_editor);
            }
        } else {
            if (this.hAJ != null) {
                aj.a(this.hAJ, d.f.icon_person_dressup, d.f.icon_person_dressup);
            }
            if (this.hAM != null) {
                aj.a(this.hAM, d.f.icon_home_setting_w, d.f.icon_home_setting_w);
            }
            if (this.hAO != null) {
                aj.a(this.hAO, d.f.icon_person_editor_s, d.f.icon_person_editor_s);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.hAJ != null) {
                this.hAJ.setAlpha(f2);
            }
            if (this.hAM != null) {
                this.hAM.setAlpha(f2);
            }
            if (this.hAO != null) {
                this.hAO.setAlpha(f2);
            }
        }
    }

    public void bkp() {
        if (!this.hAR) {
            this.hAR = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_person_tab_feedback_tips", false);
            if (!this.hAR) {
                View inflate = LayoutInflater.from(this.mContext).inflate(d.h.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(d.g.arrow_up);
                TextView textView = (TextView) inflate.findViewById(d.g.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds32);
                textView.setText(d.j.person_tab_feedback_tips);
                textView.setOnClickListener(this.fZe);
                this.fYW = new PopupWindow(inflate, -2, -2);
                this.mHandler.removeCallbacks(this.fZc);
                this.mHandler.postDelayed(this.fZc, 100L);
            }
        }
    }

    public void bgo() {
        this.mHandler.removeCallbacks(this.fZc);
        this.mHandler.removeCallbacks(this.fZd);
        bgp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgp() {
        com.baidu.adp.lib.g.g.b(this.fYW);
    }

    @Override // com.baidu.tieba.view.h
    public void e(UserData userData) {
    }
}
