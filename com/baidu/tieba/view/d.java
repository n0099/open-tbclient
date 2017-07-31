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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d implements f {
    private RelativeLayout gvM;
    private ImageView gvN;
    public ImageView gvO;
    private RelativeLayout gvP;
    private ImageView gvQ;
    public ImageView gvR;
    private PopupWindow gvS;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private boolean gvT = false;
    private Handler mHandler = new Handler();
    private Runnable gmx = new Runnable() { // from class: com.baidu.tieba.view.d.3
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.gvQ;
            if (imageView != null) {
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(d.this.gvS, imageView);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_person_tab_feedback_tips", true);
                d.this.gvT = true;
                d.this.mHandler.postDelayed(d.this.gmy, 3000L);
            }
        }
    };
    private Runnable gmy = new Runnable() { // from class: com.baidu.tieba.view.d.4
        @Override // java.lang.Runnable
        public void run() {
            d.this.but();
        }
    };
    private View.OnClickListener gmz = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.aYz();
        }
    };

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
            this.mNavigationBar = navigationBar;
            this.gvM = (RelativeLayout) LayoutInflater.from(context).inflate(d.j.item_person_host_navigation_dressup, (ViewGroup) null);
            this.gvN = (ImageView) this.gvM.findViewById(d.h.person_navigation_dressup_img);
            this.gvO = (ImageView) this.gvM.findViewById(d.h.person_navigation_dressup_red_tip);
        }
        if (TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
            if (this.mNavigationBar == null) {
                this.mNavigationBar = navigationBar;
            }
            this.gvP = (RelativeLayout) LayoutInflater.from(context).inflate(d.j.item_person_host_navigation_setting, (ViewGroup) null);
            this.gvQ = (ImageView) this.gvP.findViewById(d.h.person_navigation_setting_img);
            this.gvR = (ImageView) this.gvP.findViewById(d.h.person_navigation_setting_red_tip);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void VU() {
        if (this.gvP != null && this.gvP.getParent() == null) {
            this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gvP, (View.OnClickListener) null);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(g gVar) {
        if (this.gvM != null) {
            this.gvM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.m(6, false);
                    com.baidu.tieba.j.a.biy().E(6, false);
                    TiebaStatic.log(new aj("c10601"));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(d.this.mContext)));
                }
            });
        }
        if (this.gvP != null) {
            this.gvP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.m(5, false);
                    com.baidu.tieba.j.a.biy().E(5, false);
                    TiebaStatic.log(new aj("c10598"));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MORE, new IntentConfig(view.getContext())));
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.f
    public void m(int i, boolean z) {
        if (i == 5 && this.gvR != null) {
            this.gvR.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.gvO != null) {
            this.gvO.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.gvN != null) {
            if (2 == i) {
                ai.b(this.gvN, d.g.icon_person_dressup_s, d.g.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                ai.b(this.gvN, d.g.icon_person_dressup, d.g.icon_person_dressup);
            } else {
                ai.b(this.gvN, d.g.icon_person_dressup_s, d.g.icon_person_dressup_s);
            }
            if (this.gvO != null) {
                ai.c(this.gvO, d.g.icon_news_down_bar_one);
            }
        }
        if (this.gvQ != null) {
            if (2 == i) {
                ai.b(this.gvQ, d.g.icon_home_setting_s, d.g.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                ai.b(this.gvQ, d.g.icon_home_setting_w, d.g.icon_home_setting_w);
            } else {
                ai.b(this.gvQ, d.g.icon_home_setting_s, d.g.icon_home_setting_s);
            }
            if (this.gvR != null) {
                ai.c(this.gvR, d.g.icon_news_down_bar_one);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void b(float f, boolean z) {
        float f2;
        if (z) {
            if (this.gvN != null) {
                ai.b(this.gvN, d.g.icon_person_dressup_s, d.g.icon_person_dressup_s);
            }
            if (this.gvQ != null) {
                ai.b(this.gvQ, d.g.icon_home_setting_s, d.g.icon_home_setting_s);
            }
        } else {
            if (this.gvN != null) {
                ai.b(this.gvN, d.g.icon_person_dressup, d.g.icon_person_dressup);
            }
            if (this.gvQ != null) {
                ai.b(this.gvQ, d.g.icon_home_setting_w, d.g.icon_home_setting_w);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.gvN != null) {
                this.gvN.setAlpha(f2);
            }
            if (this.gvQ != null) {
                this.gvQ.setAlpha(f2);
            }
        }
    }

    public void aYy() {
        if (!this.gvT) {
            this.gvT = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_person_tab_feedback_tips", false);
            if (!this.gvT) {
                View inflate = LayoutInflater.from(this.mContext).inflate(d.j.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(d.h.arrow_up);
                TextView textView = (TextView) inflate.findViewById(d.h.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32);
                textView.setText(d.l.person_tab_feedback_tips);
                textView.setOnClickListener(this.gmz);
                this.gvS = new PopupWindow(inflate, -2, -2);
                this.mHandler.removeCallbacks(this.gmx);
                this.mHandler.postDelayed(this.gmx, 100L);
            }
        }
    }

    public void aYz() {
        this.mHandler.removeCallbacks(this.gmx);
        this.mHandler.removeCallbacks(this.gmy);
        but();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void but() {
        com.baidu.adp.lib.g.g.a(this.gvS);
    }

    @Override // com.baidu.tieba.view.f
    public void dA(boolean z) {
    }
}
