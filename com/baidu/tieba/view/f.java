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
    private PopupWindow fVL;
    private RelativeLayout hzc;
    private ImageView hzd;
    public ImageView hze;
    private RelativeLayout hzf;
    private ImageView hzg;
    public ImageView hzh;
    private ImageView hzi;
    private View hzj;
    private ImageView hzk;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private int hzb = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds28);
    private boolean hzl = false;
    private Handler mHandler = new Handler();
    private Runnable fVR = new Runnable() { // from class: com.baidu.tieba.view.f.5
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = f.this.hzg;
            if (imageView != null) {
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(f.this.fVL, imageView);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_person_tab_feedback_tips", true);
                f.this.hzl = true;
                f.this.mHandler.postDelayed(f.this.fVS, 3000L);
            }
        }
    };
    private Runnable fVS = new Runnable() { // from class: com.baidu.tieba.view.f.6
        @Override // java.lang.Runnable
        public void run() {
            f.this.beP();
        }
    };
    private View.OnClickListener fVT = new View.OnClickListener() { // from class: com.baidu.tieba.view.f.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.beO();
        }
    };

    public f(int i) {
        this.mFrom = i;
    }

    @Override // com.baidu.tieba.view.h
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.hzc = (RelativeLayout) LayoutInflater.from(context).inflate(d.h.item_person_host_navigation_dressup, (ViewGroup) null);
        this.hzd = (ImageView) this.hzc.findViewById(d.g.person_navigation_dressup_img);
        this.hze = (ImageView) this.hzc.findViewById(d.g.person_navigation_dressup_red_tip);
        this.hzf = (RelativeLayout) LayoutInflater.from(context).inflate(d.h.item_person_host_navigation_setting, (ViewGroup) null);
        this.hzg = (ImageView) this.hzf.findViewById(d.g.person_navigation_setting_img);
        this.hzh = (ImageView) this.hzf.findViewById(d.g.person_navigation_setting_red_tip);
        if (this.hzi == null) {
            this.hzi = new ImageView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, this.hzb, 0);
            this.hzi.setLayoutParams(layoutParams);
            this.hzi.setScaleType(ImageView.ScaleType.CENTER);
        }
        this.hzj = LayoutInflater.from(this.mContext).inflate(d.h.item_person_host_navigation_scan, (ViewGroup) null);
        this.hzk = (ImageView) this.hzj.findViewById(d.g.person_navigation_scan_img);
    }

    @Override // com.baidu.tieba.view.h
    public void biD() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.hzc != null && this.hzc.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hzc, (View.OnClickListener) null);
            }
            if (this.hzf != null && this.hzf.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hzf, (View.OnClickListener) null);
            }
            if (this.hzj != null && this.hzj.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.hzj, (View.OnClickListener) null);
            }
        } else if (this.hzi != null && this.hzi.getParent() == null) {
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hzi, (View.OnClickListener) null);
        }
    }

    @Override // com.baidu.tieba.view.h
    public void setOnViewResponseListener(i iVar) {
        if (this.hzc != null) {
            this.hzc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.mFrom == 1) {
                        TiebaStatic.log(new ak("c12523").s("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new ak("c12502").aa("obj_locate", "1"));
                    }
                    f.this.K(6, false);
                    com.baidu.tieba.m.a.bnP().c(6, false, true);
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(f.this.mContext)));
                        return;
                    }
                    BdToast.a(f.this.mContext, f.this.mContext.getResources().getString(d.j.plugin_video_installing), 0).AJ();
                }
            });
        }
        if (this.hzf != null) {
            this.hzf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.mFrom == 1) {
                        TiebaStatic.log(new ak("c12523").s("obj_locate", 23));
                    } else {
                        TiebaStatic.log(new ak("c12502").aa("obj_locate", "2"));
                    }
                    f.this.K(5, false);
                    TiebaStatic.log(new ak("c12502").aa("obj_locate", "2"));
                    f.this.K(5, false);
                    com.baidu.tieba.m.a.bnP().c(5, false, true);
                    if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
                        BdToast.a(f.this.mContext, f.this.mContext.getResources().getString(d.j.plugin_video_installing), 0).AJ();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MORE, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.hzi != null) {
            this.hzi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.f.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_SHOW_WRITE_TAB));
                }
            });
        }
        if (this.hzj != null) {
            this.hzj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.f.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ak("c12706"));
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(QRCodeScanActivityConfig.class)) {
                        BdToast.a(f.this.mContext, f.this.mContext.getResources().getString(d.j.plugin_video_installing), 0).AJ();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new QRCodeScanActivityConfig(f.this.mContext)));
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.h
    public void K(int i, boolean z) {
        if (i == 5 && this.hzh != null) {
            this.hzh.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.hze != null) {
            this.hze.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.h
    public void onChangeSkinType(int i) {
        if (this.hzd != null) {
            if (2 == i) {
                aj.a(this.hzd, d.f.icon_person_dressup_s, d.f.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.a(this.hzd, d.f.icon_person_dressup, d.f.icon_person_dressup);
            } else {
                aj.a(this.hzd, d.f.icon_person_dressup_s, d.f.icon_person_dressup_s);
            }
            if (this.hze != null) {
                aj.c(this.hze, d.f.icon_news_down_bar_one);
            }
        }
        if (this.hzg != null) {
            if (2 == i) {
                aj.a(this.hzg, d.f.icon_home_setting_s, d.f.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.a(this.hzg, d.f.icon_home_setting_w, d.f.icon_home_setting_w);
            } else {
                aj.a(this.hzg, d.f.icon_home_setting_s, d.f.icon_home_setting_s);
            }
            if (this.hzh != null) {
                aj.c(this.hzh, d.f.icon_news_down_bar_one);
            }
        }
        if (this.hzi != null) {
            if (2 == i) {
                aj.a(this.hzi, d.f.icon_person_editor, d.f.icon_person_editor_s);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.a(this.hzi, d.f.icon_person_editor_s, d.f.icon_person_editor_s);
            } else {
                aj.a(this.hzi, d.f.icon_person_editor, d.f.icon_person_editor);
            }
        }
        aj.c(this.hzk, d.f.selector_top_bar_scan);
    }

    @Override // com.baidu.tieba.view.h
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.hzd != null) {
                aj.a(this.hzd, d.f.icon_person_dressup_s, d.f.icon_person_dressup_s);
            }
            if (this.hzg != null) {
                aj.a(this.hzg, d.f.icon_home_setting_s, d.f.icon_home_setting_s);
            }
            if (this.hzi != null) {
                aj.a(this.hzi, d.f.icon_person_editor, d.f.icon_person_editor);
            }
        } else {
            if (this.hzd != null) {
                aj.a(this.hzd, d.f.icon_person_dressup, d.f.icon_person_dressup);
            }
            if (this.hzg != null) {
                aj.a(this.hzg, d.f.icon_home_setting_w, d.f.icon_home_setting_w);
            }
            if (this.hzi != null) {
                aj.a(this.hzi, d.f.icon_person_editor_s, d.f.icon_person_editor_s);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.hzd != null) {
                this.hzd.setAlpha(f2);
            }
            if (this.hzg != null) {
                this.hzg.setAlpha(f2);
            }
            if (this.hzi != null) {
                this.hzi.setAlpha(f2);
            }
        }
    }

    public void bjf() {
        if (!this.hzl) {
            this.hzl = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_person_tab_feedback_tips", false);
            if (!this.hzl) {
                View inflate = LayoutInflater.from(this.mContext).inflate(d.h.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(d.g.arrow_up);
                TextView textView = (TextView) inflate.findViewById(d.g.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds32);
                textView.setText(d.j.person_tab_feedback_tips);
                textView.setOnClickListener(this.fVT);
                this.fVL = new PopupWindow(inflate, -2, -2);
                this.mHandler.removeCallbacks(this.fVR);
                this.mHandler.postDelayed(this.fVR, 100L);
            }
        }
    }

    public void beO() {
        this.mHandler.removeCallbacks(this.fVR);
        this.mHandler.removeCallbacks(this.fVS);
        beP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beP() {
        com.baidu.adp.lib.g.g.b(this.fVL);
    }

    @Override // com.baidu.tieba.view.h
    public void e(UserData userData) {
    }
}
