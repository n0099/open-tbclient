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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class f implements h {
    private PopupWindow fVq;
    private RelativeLayout hyI;
    private ImageView hyJ;
    public ImageView hyK;
    private RelativeLayout hyL;
    private ImageView hyM;
    public ImageView hyN;
    private ImageView hyO;
    private View hyP;
    private ImageView hyQ;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private int hyH = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds28);
    private boolean hyR = false;
    private Handler mHandler = new Handler();
    private Runnable fVw = new Runnable() { // from class: com.baidu.tieba.view.f.5
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = f.this.hyM;
            if (imageView != null) {
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(f.this.fVq, imageView);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_person_tab_feedback_tips", true);
                f.this.hyR = true;
                f.this.mHandler.postDelayed(f.this.fVx, 3000L);
            }
        }
    };
    private Runnable fVx = new Runnable() { // from class: com.baidu.tieba.view.f.6
        @Override // java.lang.Runnable
        public void run() {
            f.this.beK();
        }
    };
    private View.OnClickListener fVy = new View.OnClickListener() { // from class: com.baidu.tieba.view.f.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.beJ();
        }
    };

    public f(int i) {
        this.mFrom = i;
    }

    @Override // com.baidu.tieba.view.h
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.hyI = (RelativeLayout) LayoutInflater.from(context).inflate(d.h.item_person_host_navigation_dressup, (ViewGroup) null);
        this.hyJ = (ImageView) this.hyI.findViewById(d.g.person_navigation_dressup_img);
        this.hyK = (ImageView) this.hyI.findViewById(d.g.person_navigation_dressup_red_tip);
        this.hyL = (RelativeLayout) LayoutInflater.from(context).inflate(d.h.item_person_host_navigation_setting, (ViewGroup) null);
        this.hyM = (ImageView) this.hyL.findViewById(d.g.person_navigation_setting_img);
        this.hyN = (ImageView) this.hyL.findViewById(d.g.person_navigation_setting_red_tip);
        if (this.hyO == null) {
            this.hyO = new ImageView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, this.hyH, 0);
            this.hyO.setLayoutParams(layoutParams);
            this.hyO.setScaleType(ImageView.ScaleType.CENTER);
        }
        this.hyP = LayoutInflater.from(this.mContext).inflate(d.h.item_person_host_navigation_scan, (ViewGroup) null);
        this.hyQ = (ImageView) this.hyP.findViewById(d.g.person_navigation_scan_img);
    }

    @Override // com.baidu.tieba.view.h
    public void biC() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.hyI != null && this.hyI.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hyI, (View.OnClickListener) null);
            }
            if (this.hyL != null && this.hyL.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hyL, (View.OnClickListener) null);
            }
            if (this.hyP != null && this.hyP.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.hyP, (View.OnClickListener) null);
            }
        } else if (this.hyO != null && this.hyO.getParent() == null) {
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hyO, (View.OnClickListener) null);
        }
    }

    @Override // com.baidu.tieba.view.h
    public void setOnViewResponseListener(i iVar) {
        if (this.hyI != null) {
            this.hyI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.mFrom == 1) {
                        TiebaStatic.log(new ak("c12523").s("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new ak("c12502").ab("obj_locate", "1"));
                    }
                    f.this.K(6, false);
                    com.baidu.tieba.m.a.bnO().c(6, false, true);
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(f.this.mContext)));
                        return;
                    }
                    BdToast.a(f.this.mContext, f.this.mContext.getResources().getString(d.j.plugin_video_installing), 0).AI();
                }
            });
        }
        if (this.hyL != null) {
            this.hyL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.mFrom == 1) {
                        TiebaStatic.log(new ak("c12523").s("obj_locate", 23));
                    } else {
                        TiebaStatic.log(new ak("c12502").ab("obj_locate", "2"));
                    }
                    f.this.K(5, false);
                    TiebaStatic.log(new ak("c12502").ab("obj_locate", "2"));
                    f.this.K(5, false);
                    com.baidu.tieba.m.a.bnO().c(5, false, true);
                    if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
                        BdToast.a(f.this.mContext, f.this.mContext.getResources().getString(d.j.plugin_video_installing), 0).AI();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MORE, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.hyO != null) {
            this.hyO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.f.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_SHOW_WRITE_TAB));
                }
            });
        }
        if (this.hyP != null) {
            this.hyP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.f.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ak("c12706"));
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(QRCodeScanActivityConfig.class)) {
                        BdToast.a(f.this.mContext, f.this.mContext.getResources().getString(d.j.plugin_video_installing), 0).AI();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new QRCodeScanActivityConfig(f.this.mContext)));
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.h
    public void K(int i, boolean z) {
        if (i == 5 && this.hyN != null) {
            this.hyN.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.hyK != null) {
            this.hyK.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.h
    public void onChangeSkinType(int i) {
        if (this.hyJ != null) {
            if (2 == i) {
                aj.a(this.hyJ, d.f.icon_person_dressup_s, d.f.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.a(this.hyJ, d.f.icon_person_dressup, d.f.icon_person_dressup);
            } else {
                aj.a(this.hyJ, d.f.icon_person_dressup_s, d.f.icon_person_dressup_s);
            }
            if (this.hyK != null) {
                aj.c(this.hyK, d.f.icon_news_down_bar_one);
            }
        }
        if (this.hyM != null) {
            if (2 == i) {
                aj.a(this.hyM, d.f.icon_home_setting_s, d.f.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.a(this.hyM, d.f.icon_home_setting_w, d.f.icon_home_setting_w);
            } else {
                aj.a(this.hyM, d.f.icon_home_setting_s, d.f.icon_home_setting_s);
            }
            if (this.hyN != null) {
                aj.c(this.hyN, d.f.icon_news_down_bar_one);
            }
        }
        if (this.hyO != null) {
            if (2 == i) {
                aj.a(this.hyO, d.f.icon_person_editor, d.f.icon_person_editor_s);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.a(this.hyO, d.f.icon_person_editor_s, d.f.icon_person_editor_s);
            } else {
                aj.a(this.hyO, d.f.icon_person_editor, d.f.icon_person_editor);
            }
        }
        aj.c(this.hyQ, d.f.selector_top_bar_scan);
    }

    @Override // com.baidu.tieba.view.h
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.hyJ != null) {
                aj.a(this.hyJ, d.f.icon_person_dressup_s, d.f.icon_person_dressup_s);
            }
            if (this.hyM != null) {
                aj.a(this.hyM, d.f.icon_home_setting_s, d.f.icon_home_setting_s);
            }
            if (this.hyO != null) {
                aj.a(this.hyO, d.f.icon_person_editor, d.f.icon_person_editor);
            }
        } else {
            if (this.hyJ != null) {
                aj.a(this.hyJ, d.f.icon_person_dressup, d.f.icon_person_dressup);
            }
            if (this.hyM != null) {
                aj.a(this.hyM, d.f.icon_home_setting_w, d.f.icon_home_setting_w);
            }
            if (this.hyO != null) {
                aj.a(this.hyO, d.f.icon_person_editor_s, d.f.icon_person_editor_s);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.hyJ != null) {
                this.hyJ.setAlpha(f2);
            }
            if (this.hyM != null) {
                this.hyM.setAlpha(f2);
            }
            if (this.hyO != null) {
                this.hyO.setAlpha(f2);
            }
        }
    }

    public void bje() {
        if (!this.hyR) {
            this.hyR = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_person_tab_feedback_tips", false);
            if (!this.hyR) {
                View inflate = LayoutInflater.from(this.mContext).inflate(d.h.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(d.g.arrow_up);
                TextView textView = (TextView) inflate.findViewById(d.g.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds32);
                textView.setText(d.j.person_tab_feedback_tips);
                textView.setOnClickListener(this.fVy);
                this.fVq = new PopupWindow(inflate, -2, -2);
                this.mHandler.removeCallbacks(this.fVw);
                this.mHandler.postDelayed(this.fVw, 100L);
            }
        }
    }

    public void beJ() {
        this.mHandler.removeCallbacks(this.fVw);
        this.mHandler.removeCallbacks(this.fVx);
        beK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beK() {
        com.baidu.adp.lib.g.g.b(this.fVq);
    }

    @Override // com.baidu.tieba.view.h
    public void e(UserData userData) {
    }
}
