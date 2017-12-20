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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e implements g {
    private PopupWindow fgO;
    private RelativeLayout haZ;
    private ImageView hba;
    public ImageView hbb;
    private RelativeLayout hbc;
    private ImageView hbd;
    public ImageView hbe;
    private ImageView hbf;
    private View hbg;
    private ImageView hbh;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private int haY = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds28);
    private boolean hbi = false;
    private Handler mHandler = new Handler();
    private Runnable fgS = new Runnable() { // from class: com.baidu.tieba.view.e.5
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = e.this.hbd;
            if (imageView != null) {
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(e.this.fgO, imageView);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_person_tab_feedback_tips", true);
                e.this.hbi = true;
                e.this.mHandler.postDelayed(e.this.fgT, 3000L);
            }
        }
    };
    private Runnable fgT = new Runnable() { // from class: com.baidu.tieba.view.e.6
        @Override // java.lang.Runnable
        public void run() {
            e.this.aXp();
        }
    };
    private View.OnClickListener fgU = new View.OnClickListener() { // from class: com.baidu.tieba.view.e.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.aXo();
        }
    };

    public e(int i) {
        this.mFrom = i;
    }

    @Override // com.baidu.tieba.view.g
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
            this.haZ = (RelativeLayout) LayoutInflater.from(context).inflate(d.h.item_person_host_navigation_dressup, (ViewGroup) null);
            this.hba = (ImageView) this.haZ.findViewById(d.g.person_navigation_dressup_img);
            this.hbb = (ImageView) this.haZ.findViewById(d.g.person_navigation_dressup_red_tip);
        }
        if (TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
            this.hbc = (RelativeLayout) LayoutInflater.from(context).inflate(d.h.item_person_host_navigation_setting, (ViewGroup) null);
            this.hbd = (ImageView) this.hbc.findViewById(d.g.person_navigation_setting_img);
            this.hbe = (ImageView) this.hbc.findViewById(d.g.person_navigation_setting_red_tip);
        }
        if (this.hbf == null) {
            this.hbf = new ImageView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, this.haY, 0);
            this.hbf.setLayoutParams(layoutParams);
            this.hbf.setScaleType(ImageView.ScaleType.CENTER);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(QRCodeScanActivityConfig.class)) {
            this.hbg = LayoutInflater.from(this.mContext).inflate(d.h.item_person_host_navigation_scan, (ViewGroup) null);
            this.hbh = (ImageView) this.hbg.findViewById(d.g.person_navigation_scan_img);
        }
    }

    @Override // com.baidu.tieba.view.g
    public void bbh() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.haZ != null && this.haZ.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.haZ, (View.OnClickListener) null);
            }
            if (this.hbc != null && this.hbc.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hbc, (View.OnClickListener) null);
            }
            if (this.hbg != null && this.hbg.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.hbg, (View.OnClickListener) null);
            }
        } else if (this.hbf != null && this.hbf.getParent() == null) {
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hbf, (View.OnClickListener) null);
        }
    }

    @Override // com.baidu.tieba.view.g
    public void setOnViewResponseListener(h hVar) {
        if (this.haZ != null) {
            this.haZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.mFrom == 1) {
                        TiebaStatic.log(new ak("c12523").r("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new ak("c12502").ac("obj_locate", "1"));
                    }
                    e.this.z(6, false);
                    com.baidu.tieba.m.a.bmM().c(6, false, true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(e.this.mContext)));
                }
            });
        }
        if (this.hbc != null) {
            this.hbc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.mFrom == 1) {
                        TiebaStatic.log(new ak("c12523").r("obj_locate", 23));
                    } else {
                        TiebaStatic.log(new ak("c12502").ac("obj_locate", "2"));
                    }
                    e.this.z(5, false);
                    TiebaStatic.log(new ak("c12502").ac("obj_locate", "2"));
                    e.this.z(5, false);
                    com.baidu.tieba.m.a.bmM().c(5, false, true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MORE, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.hbf != null) {
            this.hbf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_SHOW_WRITE_TAB));
                }
            });
        }
        if (this.hbg != null) {
            this.hbg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.e.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ak("c12706"));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new QRCodeScanActivityConfig(e.this.mContext)));
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.g
    public void z(int i, boolean z) {
        if (i == 5 && this.hbe != null) {
            this.hbe.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.hbb != null) {
            this.hbb.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.g
    public void onChangeSkinType(int i) {
        if (this.hba != null) {
            if (2 == i) {
                aj.a(this.hba, d.f.icon_person_dressup_s, d.f.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.a(this.hba, d.f.icon_person_dressup, d.f.icon_person_dressup);
            } else {
                aj.a(this.hba, d.f.icon_person_dressup_s, d.f.icon_person_dressup_s);
            }
            if (this.hbb != null) {
                aj.c(this.hbb, d.f.icon_news_down_bar_one);
            }
        }
        if (this.hbd != null) {
            if (2 == i) {
                aj.a(this.hbd, d.f.icon_home_setting_s, d.f.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.a(this.hbd, d.f.icon_home_setting_w, d.f.icon_home_setting_w);
            } else {
                aj.a(this.hbd, d.f.icon_home_setting_s, d.f.icon_home_setting_s);
            }
            if (this.hbe != null) {
                aj.c(this.hbe, d.f.icon_news_down_bar_one);
            }
        }
        if (this.hbf != null) {
            if (2 == i) {
                aj.a(this.hbf, d.f.icon_person_editor, d.f.icon_person_editor_s);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.a(this.hbf, d.f.icon_person_editor_s, d.f.icon_person_editor_s);
            } else {
                aj.a(this.hbf, d.f.icon_person_editor, d.f.icon_person_editor);
            }
        }
        aj.c(this.hbh, d.f.selector_top_bar_scan);
    }

    @Override // com.baidu.tieba.view.g
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.hba != null) {
                aj.a(this.hba, d.f.icon_person_dressup_s, d.f.icon_person_dressup_s);
            }
            if (this.hbd != null) {
                aj.a(this.hbd, d.f.icon_home_setting_s, d.f.icon_home_setting_s);
            }
            if (this.hbf != null) {
                aj.a(this.hbf, d.f.icon_person_editor, d.f.icon_person_editor);
            }
        } else {
            if (this.hba != null) {
                aj.a(this.hba, d.f.icon_person_dressup, d.f.icon_person_dressup);
            }
            if (this.hbd != null) {
                aj.a(this.hbd, d.f.icon_home_setting_w, d.f.icon_home_setting_w);
            }
            if (this.hbf != null) {
                aj.a(this.hbf, d.f.icon_person_editor_s, d.f.icon_person_editor_s);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.hba != null) {
                this.hba.setAlpha(f2);
            }
            if (this.hbd != null) {
                this.hbd.setAlpha(f2);
            }
            if (this.hbf != null) {
                this.hbf.setAlpha(f2);
            }
        }
    }

    public void bbJ() {
        if (!this.hbi) {
            this.hbi = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_person_tab_feedback_tips", false);
            if (!this.hbi) {
                View inflate = LayoutInflater.from(this.mContext).inflate(d.h.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(d.g.arrow_up);
                TextView textView = (TextView) inflate.findViewById(d.g.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds32);
                textView.setText(d.j.person_tab_feedback_tips);
                textView.setOnClickListener(this.fgU);
                this.fgO = new PopupWindow(inflate, -2, -2);
                this.mHandler.removeCallbacks(this.fgS);
                this.mHandler.postDelayed(this.fgS, 100L);
            }
        }
    }

    public void aXo() {
        this.mHandler.removeCallbacks(this.fgS);
        this.mHandler.removeCallbacks(this.fgT);
        aXp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXp() {
        com.baidu.adp.lib.g.g.a(this.fgO);
    }

    @Override // com.baidu.tieba.view.g
    public void e(UserData userData) {
    }
}
