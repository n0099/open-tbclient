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
    private RelativeLayout gxE;
    private ImageView gxF;
    public ImageView gxG;
    private RelativeLayout gxH;
    private ImageView gxI;
    public ImageView gxJ;
    private PopupWindow gxK;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private boolean gxL = false;
    private Handler mHandler = new Handler();
    private Runnable goq = new Runnable() { // from class: com.baidu.tieba.view.d.3
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.gxI;
            if (imageView != null) {
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(d.this.gxK, imageView);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_person_tab_feedback_tips", true);
                d.this.gxL = true;
                d.this.mHandler.postDelayed(d.this.gor, 3000L);
            }
        }
    };
    private Runnable gor = new Runnable() { // from class: com.baidu.tieba.view.d.4
        @Override // java.lang.Runnable
        public void run() {
            d.this.buU();
        }
    };
    private View.OnClickListener gos = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.aZb();
        }
    };

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
            this.mNavigationBar = navigationBar;
            this.gxE = (RelativeLayout) LayoutInflater.from(context).inflate(d.j.item_person_host_navigation_dressup, (ViewGroup) null);
            this.gxF = (ImageView) this.gxE.findViewById(d.h.person_navigation_dressup_img);
            this.gxG = (ImageView) this.gxE.findViewById(d.h.person_navigation_dressup_red_tip);
        }
        if (TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
            if (this.mNavigationBar == null) {
                this.mNavigationBar = navigationBar;
            }
            this.gxH = (RelativeLayout) LayoutInflater.from(context).inflate(d.j.item_person_host_navigation_setting, (ViewGroup) null);
            this.gxI = (ImageView) this.gxH.findViewById(d.h.person_navigation_setting_img);
            this.gxJ = (ImageView) this.gxH.findViewById(d.h.person_navigation_setting_red_tip);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void Wn() {
        if (this.gxH != null && this.gxH.getParent() == null) {
            this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gxH, (View.OnClickListener) null);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(g gVar) {
        if (this.gxE != null) {
            this.gxE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.m(6, false);
                    com.baidu.tieba.j.a.biZ().E(6, false);
                    TiebaStatic.log(new aj("c10601"));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(d.this.mContext)));
                }
            });
        }
        if (this.gxH != null) {
            this.gxH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.m(5, false);
                    com.baidu.tieba.j.a.biZ().E(5, false);
                    TiebaStatic.log(new aj("c10598"));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MORE, new IntentConfig(view.getContext())));
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.f
    public void m(int i, boolean z) {
        if (i == 5 && this.gxJ != null) {
            this.gxJ.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.gxG != null) {
            this.gxG.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.gxF != null) {
            if (2 == i) {
                ai.b(this.gxF, d.g.icon_person_dressup_s, d.g.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                ai.b(this.gxF, d.g.icon_person_dressup, d.g.icon_person_dressup);
            } else {
                ai.b(this.gxF, d.g.icon_person_dressup_s, d.g.icon_person_dressup_s);
            }
            if (this.gxG != null) {
                ai.c(this.gxG, d.g.icon_news_down_bar_one);
            }
        }
        if (this.gxI != null) {
            if (2 == i) {
                ai.b(this.gxI, d.g.icon_home_setting_s, d.g.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                ai.b(this.gxI, d.g.icon_home_setting_w, d.g.icon_home_setting_w);
            } else {
                ai.b(this.gxI, d.g.icon_home_setting_s, d.g.icon_home_setting_s);
            }
            if (this.gxJ != null) {
                ai.c(this.gxJ, d.g.icon_news_down_bar_one);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void b(float f, boolean z) {
        float f2;
        if (z) {
            if (this.gxF != null) {
                ai.b(this.gxF, d.g.icon_person_dressup_s, d.g.icon_person_dressup_s);
            }
            if (this.gxI != null) {
                ai.b(this.gxI, d.g.icon_home_setting_s, d.g.icon_home_setting_s);
            }
        } else {
            if (this.gxF != null) {
                ai.b(this.gxF, d.g.icon_person_dressup, d.g.icon_person_dressup);
            }
            if (this.gxI != null) {
                ai.b(this.gxI, d.g.icon_home_setting_w, d.g.icon_home_setting_w);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.gxF != null) {
                this.gxF.setAlpha(f2);
            }
            if (this.gxI != null) {
                this.gxI.setAlpha(f2);
            }
        }
    }

    public void aZa() {
        if (!this.gxL) {
            this.gxL = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_person_tab_feedback_tips", false);
            if (!this.gxL) {
                View inflate = LayoutInflater.from(this.mContext).inflate(d.j.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(d.h.arrow_up);
                TextView textView = (TextView) inflate.findViewById(d.h.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32);
                textView.setText(d.l.person_tab_feedback_tips);
                textView.setOnClickListener(this.gos);
                this.gxK = new PopupWindow(inflate, -2, -2);
                this.mHandler.removeCallbacks(this.goq);
                this.mHandler.postDelayed(this.goq, 100L);
            }
        }
    }

    public void aZb() {
        this.mHandler.removeCallbacks(this.goq);
        this.mHandler.removeCallbacks(this.gor);
        buU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buU() {
        com.baidu.adp.lib.g.g.a(this.gxK);
    }

    @Override // com.baidu.tieba.view.f
    public void dB(boolean z) {
    }
}
