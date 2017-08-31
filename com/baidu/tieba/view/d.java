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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d implements f {
    private PopupWindow eUZ;
    private RelativeLayout gwg;
    private ImageView gwh;
    public ImageView gwi;
    private RelativeLayout gwj;
    private ImageView gwk;
    public ImageView gwl;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private boolean eUT = false;
    private Handler mHandler = new Handler();
    private Runnable eVb = new Runnable() { // from class: com.baidu.tieba.view.d.3
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.gwk;
            if (imageView != null) {
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(d.this.eUZ, imageView);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_person_tab_feedback_tips", true);
                d.this.eUT = true;
                d.this.mHandler.postDelayed(d.this.eVc, 3000L);
            }
        }
    };
    private Runnable eVc = new Runnable() { // from class: com.baidu.tieba.view.d.4
        @Override // java.lang.Runnable
        public void run() {
            d.this.aUy();
        }
    };
    private View.OnClickListener eVd = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.aUx();
        }
    };

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
            this.mNavigationBar = navigationBar;
            this.gwg = (RelativeLayout) LayoutInflater.from(context).inflate(d.j.item_person_host_navigation_dressup, (ViewGroup) null);
            this.gwh = (ImageView) this.gwg.findViewById(d.h.person_navigation_dressup_img);
            this.gwi = (ImageView) this.gwg.findViewById(d.h.person_navigation_dressup_red_tip);
        }
        if (TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
            if (this.mNavigationBar == null) {
                this.mNavigationBar = navigationBar;
            }
            this.gwj = (RelativeLayout) LayoutInflater.from(context).inflate(d.j.item_person_host_navigation_setting, (ViewGroup) null);
            this.gwk = (ImageView) this.gwj.findViewById(d.h.person_navigation_setting_img);
            this.gwl = (ImageView) this.gwj.findViewById(d.h.person_navigation_setting_red_tip);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void Xq() {
        if (this.gwj != null && this.gwj.getParent() == null) {
            this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gwj, (View.OnClickListener) null);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(g gVar) {
        if (this.gwg != null) {
            this.gwg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.l(6, false);
                    com.baidu.tieba.j.a.bhY().b(6, false, true);
                    TiebaStatic.log(new ak("c10601"));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(d.this.mContext)));
                }
            });
        }
        if (this.gwj != null) {
            this.gwj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.l(5, false);
                    com.baidu.tieba.j.a.bhY().b(5, false, true);
                    TiebaStatic.log(new ak("c10598"));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MORE, new IntentConfig(view.getContext())));
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.f
    public void l(int i, boolean z) {
        if (i == 5 && this.gwl != null) {
            this.gwl.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.gwi != null) {
            this.gwi.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.gwh != null) {
            if (2 == i) {
                aj.a(this.gwh, d.g.icon_person_dressup_s, d.g.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.a(this.gwh, d.g.icon_person_dressup, d.g.icon_person_dressup);
            } else {
                aj.a(this.gwh, d.g.icon_person_dressup_s, d.g.icon_person_dressup_s);
            }
            if (this.gwi != null) {
                aj.c(this.gwi, d.g.icon_news_down_bar_one);
            }
        }
        if (this.gwk != null) {
            if (2 == i) {
                aj.a(this.gwk, d.g.icon_home_setting_s, d.g.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.a(this.gwk, d.g.icon_home_setting_w, d.g.icon_home_setting_w);
            } else {
                aj.a(this.gwk, d.g.icon_home_setting_s, d.g.icon_home_setting_s);
            }
            if (this.gwl != null) {
                aj.c(this.gwl, d.g.icon_news_down_bar_one);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void b(float f, boolean z) {
        float f2;
        if (z) {
            if (this.gwh != null) {
                aj.a(this.gwh, d.g.icon_person_dressup_s, d.g.icon_person_dressup_s);
            }
            if (this.gwk != null) {
                aj.a(this.gwk, d.g.icon_home_setting_s, d.g.icon_home_setting_s);
            }
        } else {
            if (this.gwh != null) {
                aj.a(this.gwh, d.g.icon_person_dressup, d.g.icon_person_dressup);
            }
            if (this.gwk != null) {
                aj.a(this.gwk, d.g.icon_home_setting_w, d.g.icon_home_setting_w);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.gwh != null) {
                this.gwh.setAlpha(f2);
            }
            if (this.gwk != null) {
                this.gwk.setAlpha(f2);
            }
        }
    }

    public void aYm() {
        if (!this.eUT) {
            this.eUT = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_person_tab_feedback_tips", false);
            if (!this.eUT) {
                View inflate = LayoutInflater.from(this.mContext).inflate(d.j.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(d.h.arrow_up);
                TextView textView = (TextView) inflate.findViewById(d.h.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32);
                textView.setText(d.l.person_tab_feedback_tips);
                textView.setOnClickListener(this.eVd);
                this.eUZ = new PopupWindow(inflate, -2, -2);
                this.mHandler.removeCallbacks(this.eVb);
                this.mHandler.postDelayed(this.eVb, 100L);
            }
        }
    }

    public void aUx() {
        this.mHandler.removeCallbacks(this.eVb);
        this.mHandler.removeCallbacks(this.eVc);
        aUy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUy() {
        com.baidu.adp.lib.g.g.a(this.eUZ);
    }

    @Override // com.baidu.tieba.view.f
    public void dE(boolean z) {
    }
}
