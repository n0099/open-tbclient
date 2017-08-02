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
    private RelativeLayout guB;
    private ImageView guC;
    public ImageView guD;
    private RelativeLayout guE;
    private ImageView guF;
    public ImageView guG;
    private PopupWindow guH;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private boolean guI = false;
    private Handler mHandler = new Handler();
    private Runnable glm = new Runnable() { // from class: com.baidu.tieba.view.d.3
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.guF;
            if (imageView != null) {
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(d.this.guH, imageView);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_person_tab_feedback_tips", true);
                d.this.guI = true;
                d.this.mHandler.postDelayed(d.this.gln, 3000L);
            }
        }
    };
    private Runnable gln = new Runnable() { // from class: com.baidu.tieba.view.d.4
        @Override // java.lang.Runnable
        public void run() {
            d.this.bum();
        }
    };
    private View.OnClickListener glo = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.aYo();
        }
    };

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
            this.mNavigationBar = navigationBar;
            this.guB = (RelativeLayout) LayoutInflater.from(context).inflate(d.j.item_person_host_navigation_dressup, (ViewGroup) null);
            this.guC = (ImageView) this.guB.findViewById(d.h.person_navigation_dressup_img);
            this.guD = (ImageView) this.guB.findViewById(d.h.person_navigation_dressup_red_tip);
        }
        if (TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
            if (this.mNavigationBar == null) {
                this.mNavigationBar = navigationBar;
            }
            this.guE = (RelativeLayout) LayoutInflater.from(context).inflate(d.j.item_person_host_navigation_setting, (ViewGroup) null);
            this.guF = (ImageView) this.guE.findViewById(d.h.person_navigation_setting_img);
            this.guG = (ImageView) this.guE.findViewById(d.h.person_navigation_setting_red_tip);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void VP() {
        if (this.guE != null && this.guE.getParent() == null) {
            this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.guE, (View.OnClickListener) null);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(g gVar) {
        if (this.guB != null) {
            this.guB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.m(6, false);
                    com.baidu.tieba.j.a.bio().D(6, false);
                    TiebaStatic.log(new aj("c10601"));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(d.this.mContext)));
                }
            });
        }
        if (this.guE != null) {
            this.guE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.m(5, false);
                    com.baidu.tieba.j.a.bio().D(5, false);
                    TiebaStatic.log(new aj("c10598"));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MORE, new IntentConfig(view.getContext())));
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.f
    public void m(int i, boolean z) {
        if (i == 5 && this.guG != null) {
            this.guG.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.guD != null) {
            this.guD.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.guC != null) {
            if (2 == i) {
                ai.b(this.guC, d.g.icon_person_dressup_s, d.g.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                ai.b(this.guC, d.g.icon_person_dressup, d.g.icon_person_dressup);
            } else {
                ai.b(this.guC, d.g.icon_person_dressup_s, d.g.icon_person_dressup_s);
            }
            if (this.guD != null) {
                ai.c(this.guD, d.g.icon_news_down_bar_one);
            }
        }
        if (this.guF != null) {
            if (2 == i) {
                ai.b(this.guF, d.g.icon_home_setting_s, d.g.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                ai.b(this.guF, d.g.icon_home_setting_w, d.g.icon_home_setting_w);
            } else {
                ai.b(this.guF, d.g.icon_home_setting_s, d.g.icon_home_setting_s);
            }
            if (this.guG != null) {
                ai.c(this.guG, d.g.icon_news_down_bar_one);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void b(float f, boolean z) {
        float f2;
        if (z) {
            if (this.guC != null) {
                ai.b(this.guC, d.g.icon_person_dressup_s, d.g.icon_person_dressup_s);
            }
            if (this.guF != null) {
                ai.b(this.guF, d.g.icon_home_setting_s, d.g.icon_home_setting_s);
            }
        } else {
            if (this.guC != null) {
                ai.b(this.guC, d.g.icon_person_dressup, d.g.icon_person_dressup);
            }
            if (this.guF != null) {
                ai.b(this.guF, d.g.icon_home_setting_w, d.g.icon_home_setting_w);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.guC != null) {
                this.guC.setAlpha(f2);
            }
            if (this.guF != null) {
                this.guF.setAlpha(f2);
            }
        }
    }

    public void aYn() {
        if (!this.guI) {
            this.guI = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_person_tab_feedback_tips", false);
            if (!this.guI) {
                View inflate = LayoutInflater.from(this.mContext).inflate(d.j.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(d.h.arrow_up);
                TextView textView = (TextView) inflate.findViewById(d.h.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32);
                textView.setText(d.l.person_tab_feedback_tips);
                textView.setOnClickListener(this.glo);
                this.guH = new PopupWindow(inflate, -2, -2);
                this.mHandler.removeCallbacks(this.glm);
                this.mHandler.postDelayed(this.glm, 100L);
            }
        }
    }

    public void aYo() {
        this.mHandler.removeCallbacks(this.glm);
        this.mHandler.removeCallbacks(this.gln);
        bum();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bum() {
        com.baidu.adp.lib.g.g.a(this.guH);
    }

    @Override // com.baidu.tieba.view.f
    public void dA(boolean z) {
    }
}
