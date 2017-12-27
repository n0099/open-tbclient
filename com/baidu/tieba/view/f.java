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
    private PopupWindow fTQ;
    private RelativeLayout hJb;
    private ImageView hJc;
    public ImageView hJd;
    private RelativeLayout hJe;
    private ImageView hJf;
    public ImageView hJg;
    private ImageView hJh;
    private View hJi;
    private ImageView hJj;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private int hJa = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds28);
    private boolean hJk = false;
    private Handler mHandler = new Handler();
    private Runnable fTW = new Runnable() { // from class: com.baidu.tieba.view.f.5
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = f.this.hJf;
            if (imageView != null) {
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(f.this.fTQ, imageView);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_person_tab_feedback_tips", true);
                f.this.hJk = true;
                f.this.mHandler.postDelayed(f.this.fTX, 3000L);
            }
        }
    };
    private Runnable fTX = new Runnable() { // from class: com.baidu.tieba.view.f.6
        @Override // java.lang.Runnable
        public void run() {
            f.this.beG();
        }
    };
    private View.OnClickListener fTY = new View.OnClickListener() { // from class: com.baidu.tieba.view.f.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.beF();
        }
    };

    public f(int i) {
        this.mFrom = i;
    }

    @Override // com.baidu.tieba.view.h
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.hJb = (RelativeLayout) LayoutInflater.from(context).inflate(d.h.item_person_host_navigation_dressup, (ViewGroup) null);
        this.hJc = (ImageView) this.hJb.findViewById(d.g.person_navigation_dressup_img);
        this.hJd = (ImageView) this.hJb.findViewById(d.g.person_navigation_dressup_red_tip);
        this.hJe = (RelativeLayout) LayoutInflater.from(context).inflate(d.h.item_person_host_navigation_setting, (ViewGroup) null);
        this.hJf = (ImageView) this.hJe.findViewById(d.g.person_navigation_setting_img);
        this.hJg = (ImageView) this.hJe.findViewById(d.g.person_navigation_setting_red_tip);
        if (this.hJh == null) {
            this.hJh = new ImageView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, this.hJa, 0);
            this.hJh.setLayoutParams(layoutParams);
            this.hJh.setScaleType(ImageView.ScaleType.CENTER);
        }
        this.hJi = LayoutInflater.from(this.mContext).inflate(d.h.item_person_host_navigation_scan, (ViewGroup) null);
        this.hJj = (ImageView) this.hJi.findViewById(d.g.person_navigation_scan_img);
    }

    @Override // com.baidu.tieba.view.h
    public void biB() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.hJb != null && this.hJb.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hJb, (View.OnClickListener) null);
            }
            if (this.hJe != null && this.hJe.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hJe, (View.OnClickListener) null);
            }
            if (this.hJi != null && this.hJi.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.hJi, (View.OnClickListener) null);
            }
        } else if (this.hJh != null && this.hJh.getParent() == null) {
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hJh, (View.OnClickListener) null);
        }
    }

    @Override // com.baidu.tieba.view.h
    public void setOnViewResponseListener(i iVar) {
        if (this.hJb != null) {
            this.hJb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.mFrom == 1) {
                        TiebaStatic.log(new ak("c12523").s("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new ak("c12502").ab("obj_locate", "1"));
                    }
                    f.this.K(6, false);
                    com.baidu.tieba.m.a.buv().c(6, false, true);
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(f.this.mContext)));
                        return;
                    }
                    BdToast.a(f.this.mContext, f.this.mContext.getResources().getString(d.j.plugin_video_installing), 0).AQ();
                }
            });
        }
        if (this.hJe != null) {
            this.hJe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.f.2
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
                    com.baidu.tieba.m.a.buv().c(5, false, true);
                    if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
                        BdToast.a(f.this.mContext, f.this.mContext.getResources().getString(d.j.plugin_video_installing), 0).AQ();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MORE, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.hJh != null) {
            this.hJh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.f.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_SHOW_WRITE_TAB));
                }
            });
        }
        if (this.hJi != null) {
            this.hJi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.f.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ak("c12706"));
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(QRCodeScanActivityConfig.class)) {
                        BdToast.a(f.this.mContext, f.this.mContext.getResources().getString(d.j.plugin_video_installing), 0).AQ();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new QRCodeScanActivityConfig(f.this.mContext)));
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.h
    public void K(int i, boolean z) {
        if (i == 5 && this.hJg != null) {
            this.hJg.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.hJd != null) {
            this.hJd.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.h
    public void onChangeSkinType(int i) {
        if (this.hJc != null) {
            if (2 == i) {
                aj.a(this.hJc, d.f.icon_person_dressup_s, d.f.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.a(this.hJc, d.f.icon_person_dressup, d.f.icon_person_dressup);
            } else {
                aj.a(this.hJc, d.f.icon_person_dressup_s, d.f.icon_person_dressup_s);
            }
            if (this.hJd != null) {
                aj.c(this.hJd, d.f.icon_news_down_bar_one);
            }
        }
        if (this.hJf != null) {
            if (2 == i) {
                aj.a(this.hJf, d.f.icon_home_setting_s, d.f.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.a(this.hJf, d.f.icon_home_setting_w, d.f.icon_home_setting_w);
            } else {
                aj.a(this.hJf, d.f.icon_home_setting_s, d.f.icon_home_setting_s);
            }
            if (this.hJg != null) {
                aj.c(this.hJg, d.f.icon_news_down_bar_one);
            }
        }
        if (this.hJh != null) {
            if (2 == i) {
                aj.a(this.hJh, d.f.icon_person_editor, d.f.icon_person_editor_s);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.a(this.hJh, d.f.icon_person_editor_s, d.f.icon_person_editor_s);
            } else {
                aj.a(this.hJh, d.f.icon_person_editor, d.f.icon_person_editor);
            }
        }
        aj.c(this.hJj, d.f.selector_top_bar_scan);
    }

    @Override // com.baidu.tieba.view.h
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.hJc != null) {
                aj.a(this.hJc, d.f.icon_person_dressup_s, d.f.icon_person_dressup_s);
            }
            if (this.hJf != null) {
                aj.a(this.hJf, d.f.icon_home_setting_s, d.f.icon_home_setting_s);
            }
            if (this.hJh != null) {
                aj.a(this.hJh, d.f.icon_person_editor, d.f.icon_person_editor);
            }
        } else {
            if (this.hJc != null) {
                aj.a(this.hJc, d.f.icon_person_dressup, d.f.icon_person_dressup);
            }
            if (this.hJf != null) {
                aj.a(this.hJf, d.f.icon_home_setting_w, d.f.icon_home_setting_w);
            }
            if (this.hJh != null) {
                aj.a(this.hJh, d.f.icon_person_editor_s, d.f.icon_person_editor_s);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.hJc != null) {
                this.hJc.setAlpha(f2);
            }
            if (this.hJf != null) {
                this.hJf.setAlpha(f2);
            }
            if (this.hJh != null) {
                this.hJh.setAlpha(f2);
            }
        }
    }

    public void bjd() {
        if (!this.hJk) {
            this.hJk = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_person_tab_feedback_tips", false);
            if (!this.hJk) {
                View inflate = LayoutInflater.from(this.mContext).inflate(d.h.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(d.g.arrow_up);
                TextView textView = (TextView) inflate.findViewById(d.g.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds32);
                textView.setText(d.j.person_tab_feedback_tips);
                textView.setOnClickListener(this.fTY);
                this.fTQ = new PopupWindow(inflate, -2, -2);
                this.mHandler.removeCallbacks(this.fTW);
                this.mHandler.postDelayed(this.fTW, 100L);
            }
        }
    }

    public void beF() {
        this.mHandler.removeCallbacks(this.fTW);
        this.mHandler.removeCallbacks(this.fTX);
        beG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beG() {
        com.baidu.adp.lib.g.g.b(this.fTQ);
    }

    @Override // com.baidu.tieba.view.h
    public void e(UserData userData) {
    }
}
