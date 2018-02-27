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
    private PopupWindow fYL;
    public ImageView hAA;
    private ImageView hAB;
    private View hAC;
    private ImageView hAD;
    private RelativeLayout hAv;
    private ImageView hAw;
    public ImageView hAx;
    private RelativeLayout hAy;
    private ImageView hAz;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private int hAu = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds28);
    private boolean hAE = false;
    private Handler mHandler = new Handler();
    private Runnable fYR = new Runnable() { // from class: com.baidu.tieba.view.f.5
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = f.this.hAz;
            if (imageView != null) {
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(f.this.fYL, imageView);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_person_tab_feedback_tips", true);
                f.this.hAE = true;
                f.this.mHandler.postDelayed(f.this.fYS, 3000L);
            }
        }
    };
    private Runnable fYS = new Runnable() { // from class: com.baidu.tieba.view.f.6
        @Override // java.lang.Runnable
        public void run() {
            f.this.bgo();
        }
    };
    private View.OnClickListener fYT = new View.OnClickListener() { // from class: com.baidu.tieba.view.f.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.bgn();
        }
    };

    public f(int i) {
        this.mFrom = i;
    }

    @Override // com.baidu.tieba.view.h
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.hAv = (RelativeLayout) LayoutInflater.from(context).inflate(d.h.item_person_host_navigation_dressup, (ViewGroup) null);
        this.hAw = (ImageView) this.hAv.findViewById(d.g.person_navigation_dressup_img);
        this.hAx = (ImageView) this.hAv.findViewById(d.g.person_navigation_dressup_red_tip);
        this.hAy = (RelativeLayout) LayoutInflater.from(context).inflate(d.h.item_person_host_navigation_setting, (ViewGroup) null);
        this.hAz = (ImageView) this.hAy.findViewById(d.g.person_navigation_setting_img);
        this.hAA = (ImageView) this.hAy.findViewById(d.g.person_navigation_setting_red_tip);
        if (this.hAB == null) {
            this.hAB = new ImageView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, this.hAu, 0);
            this.hAB.setLayoutParams(layoutParams);
            this.hAB.setScaleType(ImageView.ScaleType.CENTER);
        }
        this.hAC = LayoutInflater.from(this.mContext).inflate(d.h.item_person_host_navigation_scan, (ViewGroup) null);
        this.hAD = (ImageView) this.hAC.findViewById(d.g.person_navigation_scan_img);
    }

    @Override // com.baidu.tieba.view.h
    public void bjM() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.hAv != null && this.hAv.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hAv, (View.OnClickListener) null);
            }
            if (this.hAy != null && this.hAy.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hAy, (View.OnClickListener) null);
            }
            if (this.hAC != null && this.hAC.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.hAC, (View.OnClickListener) null);
            }
        } else if (this.hAB != null && this.hAB.getParent() == null) {
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hAB, (View.OnClickListener) null);
        }
    }

    @Override // com.baidu.tieba.view.h
    public void setOnViewResponseListener(i iVar) {
        if (this.hAv != null) {
            this.hAv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.mFrom == 1) {
                        TiebaStatic.log(new ak("c12523").s("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new ak("c12502").ab("obj_locate", "1"));
                    }
                    f.this.Q(6, false);
                    com.baidu.tieba.m.a.bpl().c(6, false, true);
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DressupCenterActivityConfig(f.this.mContext)));
                        return;
                    }
                    BdToast.a(f.this.mContext, f.this.mContext.getResources().getString(d.j.plugin_video_installing), 0).Bc();
                }
            });
        }
        if (this.hAy != null) {
            this.hAy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.f.2
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
                    com.baidu.tieba.m.a.bpl().c(5, false, true);
                    if (!TbadkCoreApplication.getInst().appResponseToCmd(2015004)) {
                        BdToast.a(f.this.mContext, f.this.mContext.getResources().getString(d.j.plugin_video_installing), 0).Bc();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015004, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.hAB != null) {
            this.hAB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.f.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016559));
                }
            });
        }
        if (this.hAC != null) {
            this.hAC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.f.4
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
        if (i == 5 && this.hAA != null) {
            this.hAA.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.hAx != null) {
            this.hAx.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.h
    public void onChangeSkinType(int i) {
        if (this.hAw != null) {
            if (2 == i) {
                aj.a(this.hAw, d.f.icon_person_dressup_s, d.f.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.a(this.hAw, d.f.icon_person_dressup, d.f.icon_person_dressup);
            } else {
                aj.a(this.hAw, d.f.icon_person_dressup_s, d.f.icon_person_dressup_s);
            }
            if (this.hAx != null) {
                aj.c(this.hAx, d.f.icon_news_down_bar_one);
            }
        }
        if (this.hAz != null) {
            if (2 == i) {
                aj.a(this.hAz, d.f.icon_home_setting_s, d.f.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.a(this.hAz, d.f.icon_home_setting_w, d.f.icon_home_setting_w);
            } else {
                aj.a(this.hAz, d.f.icon_home_setting_s, d.f.icon_home_setting_s);
            }
            if (this.hAA != null) {
                aj.c(this.hAA, d.f.icon_news_down_bar_one);
            }
        }
        if (this.hAB != null) {
            if (2 == i) {
                aj.a(this.hAB, d.f.icon_person_editor, d.f.icon_person_editor_s);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.a(this.hAB, d.f.icon_person_editor_s, d.f.icon_person_editor_s);
            } else {
                aj.a(this.hAB, d.f.icon_person_editor, d.f.icon_person_editor);
            }
        }
        aj.c(this.hAD, d.f.selector_top_bar_scan);
    }

    @Override // com.baidu.tieba.view.h
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.hAw != null) {
                aj.a(this.hAw, d.f.icon_person_dressup_s, d.f.icon_person_dressup_s);
            }
            if (this.hAz != null) {
                aj.a(this.hAz, d.f.icon_home_setting_s, d.f.icon_home_setting_s);
            }
            if (this.hAB != null) {
                aj.a(this.hAB, d.f.icon_person_editor, d.f.icon_person_editor);
            }
        } else {
            if (this.hAw != null) {
                aj.a(this.hAw, d.f.icon_person_dressup, d.f.icon_person_dressup);
            }
            if (this.hAz != null) {
                aj.a(this.hAz, d.f.icon_home_setting_w, d.f.icon_home_setting_w);
            }
            if (this.hAB != null) {
                aj.a(this.hAB, d.f.icon_person_editor_s, d.f.icon_person_editor_s);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.hAw != null) {
                this.hAw.setAlpha(f2);
            }
            if (this.hAz != null) {
                this.hAz.setAlpha(f2);
            }
            if (this.hAB != null) {
                this.hAB.setAlpha(f2);
            }
        }
    }

    public void bko() {
        if (!this.hAE) {
            this.hAE = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_person_tab_feedback_tips", false);
            if (!this.hAE) {
                View inflate = LayoutInflater.from(this.mContext).inflate(d.h.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(d.g.arrow_up);
                TextView textView = (TextView) inflate.findViewById(d.g.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds32);
                textView.setText(d.j.person_tab_feedback_tips);
                textView.setOnClickListener(this.fYT);
                this.fYL = new PopupWindow(inflate, -2, -2);
                this.mHandler.removeCallbacks(this.fYR);
                this.mHandler.postDelayed(this.fYR, 100L);
            }
        }
    }

    public void bgn() {
        this.mHandler.removeCallbacks(this.fYR);
        this.mHandler.removeCallbacks(this.fYS);
        bgo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgo() {
        com.baidu.adp.lib.g.g.b(this.fYL);
    }

    @Override // com.baidu.tieba.view.h
    public void e(UserData userData) {
    }
}
