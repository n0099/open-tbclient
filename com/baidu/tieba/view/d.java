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
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d implements f {
    private PopupWindow eQd;
    private RelativeLayout gCJ;
    private ImageView gCK;
    public ImageView gCL;
    private RelativeLayout gCM;
    private ImageView gCN;
    public ImageView gCO;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private UserData mUserData;
    private boolean ePU = false;
    private Handler mHandler = new Handler();
    private Runnable eQg = new Runnable() { // from class: com.baidu.tieba.view.d.3
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.gCN;
            if (imageView != null) {
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(d.this.eQd, imageView);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_person_tab_feedback_tips", true);
                d.this.ePU = true;
                d.this.mHandler.postDelayed(d.this.eQh, 3000L);
            }
        }
    };
    private Runnable eQh = new Runnable() { // from class: com.baidu.tieba.view.d.4
        @Override // java.lang.Runnable
        public void run() {
            d.this.aSS();
        }
    };
    private View.OnClickListener eQi = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.aSR();
        }
    };

    public d(int i) {
        this.mFrom = i;
    }

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
            this.gCJ = (RelativeLayout) LayoutInflater.from(context).inflate(d.j.item_person_host_navigation_dressup, (ViewGroup) null);
            this.gCK = (ImageView) this.gCJ.findViewById(d.h.person_navigation_dressup_img);
            this.gCL = (ImageView) this.gCJ.findViewById(d.h.person_navigation_dressup_red_tip);
        }
        if (TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
            this.gCM = (RelativeLayout) LayoutInflater.from(context).inflate(d.j.item_person_host_navigation_setting, (ViewGroup) null);
            this.gCN = (ImageView) this.gCM.findViewById(d.h.person_navigation_setting_img);
            this.gCO = (ImageView) this.gCM.findViewById(d.h.person_navigation_setting_red_tip);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void bxX() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.gCJ != null && this.gCJ.getParent() == null) {
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gCJ, (View.OnClickListener) null);
        }
        if (this.gCM != null && this.gCM.getParent() == null) {
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gCM, (View.OnClickListener) null);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(g gVar) {
        if (this.gCJ != null) {
            this.gCJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new ak("c12523").r("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new ak("c12502").ad("obj_locate", "1"));
                    }
                    d.this.y(6, false);
                    com.baidu.tieba.j.a.bgO().b(6, false, true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(d.this.mContext)));
                }
            });
        }
        if (this.gCM != null) {
            this.gCM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new ak("c12523").r("obj_locate", 23));
                    } else {
                        TiebaStatic.log(new ak("c12502").ad("obj_locate", "2"));
                    }
                    d.this.y(5, false);
                    com.baidu.tieba.j.a.bgO().b(5, false, true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MORE, new IntentConfig(view.getContext())));
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.f
    public void y(int i, boolean z) {
        if (i == 5 && this.gCO != null) {
            this.gCO.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.gCL != null) {
            this.gCL.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.gCK != null) {
            if (2 == i) {
                aj.a(this.gCK, d.g.icon_person_dressup_s, d.g.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.a(this.gCK, d.g.icon_person_dressup, d.g.icon_person_dressup);
            } else {
                aj.a(this.gCK, d.g.icon_person_dressup_s, d.g.icon_person_dressup_s);
            }
            if (this.gCL != null) {
                aj.c(this.gCL, d.g.icon_news_down_bar_one);
            }
        }
        if (this.gCN != null) {
            if (2 == i) {
                aj.a(this.gCN, d.g.icon_home_setting_s, d.g.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.a(this.gCN, d.g.icon_home_setting_w, d.g.icon_home_setting_w);
            } else {
                aj.a(this.gCN, d.g.icon_home_setting_s, d.g.icon_home_setting_s);
            }
            if (this.gCO != null) {
                aj.c(this.gCO, d.g.icon_news_down_bar_one);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.gCK != null) {
                aj.a(this.gCK, d.g.icon_person_dressup_s, d.g.icon_person_dressup_s);
            }
            if (this.gCN != null) {
                aj.a(this.gCN, d.g.icon_home_setting_s, d.g.icon_home_setting_s);
            }
        } else {
            if (this.gCK != null) {
                aj.a(this.gCK, d.g.icon_person_dressup, d.g.icon_person_dressup);
            }
            if (this.gCN != null) {
                aj.a(this.gCN, d.g.icon_home_setting_w, d.g.icon_home_setting_w);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.gCK != null) {
                this.gCK.setAlpha(f2);
            }
            if (this.gCN != null) {
                this.gCN.setAlpha(f2);
            }
        }
    }

    public void aWT() {
        if (!this.ePU) {
            this.ePU = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_person_tab_feedback_tips", false);
            if (!this.ePU) {
                View inflate = LayoutInflater.from(this.mContext).inflate(d.j.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(d.h.arrow_up);
                TextView textView = (TextView) inflate.findViewById(d.h.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = l.f(this.mContext, d.f.ds32);
                textView.setText(d.l.person_tab_feedback_tips);
                textView.setOnClickListener(this.eQi);
                this.eQd = new PopupWindow(inflate, -2, -2);
                this.mHandler.removeCallbacks(this.eQg);
                this.mHandler.postDelayed(this.eQg, 100L);
            }
        }
    }

    public void aSR() {
        this.mHandler.removeCallbacks(this.eQg);
        this.mHandler.removeCallbacks(this.eQh);
        aSS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSS() {
        com.baidu.adp.lib.g.g.a(this.eQd);
    }

    @Override // com.baidu.tieba.view.f
    public void e(UserData userData) {
        this.mUserData = userData;
    }
}
