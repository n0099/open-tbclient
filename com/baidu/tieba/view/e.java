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
    private PopupWindow eYE;
    private RelativeLayout gMj;
    private ImageView gMk;
    public ImageView gMl;
    private RelativeLayout gMm;
    private ImageView gMn;
    public ImageView gMo;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private boolean gMp = false;
    private Handler mHandler = new Handler();
    private Runnable eYH = new Runnable() { // from class: com.baidu.tieba.view.e.3
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = e.this.gMn;
            if (imageView != null) {
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(e.this.eYE, imageView);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_person_tab_feedback_tips", true);
                e.this.gMp = true;
                e.this.mHandler.postDelayed(e.this.eYI, 3000L);
            }
        }
    };
    private Runnable eYI = new Runnable() { // from class: com.baidu.tieba.view.e.4
        @Override // java.lang.Runnable
        public void run() {
            e.this.aWb();
        }
    };
    private View.OnClickListener eYJ = new View.OnClickListener() { // from class: com.baidu.tieba.view.e.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.aWa();
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
            this.gMj = (RelativeLayout) LayoutInflater.from(context).inflate(d.h.item_person_host_navigation_dressup, (ViewGroup) null);
            this.gMk = (ImageView) this.gMj.findViewById(d.g.person_navigation_dressup_img);
            this.gMl = (ImageView) this.gMj.findViewById(d.g.person_navigation_dressup_red_tip);
        }
        if (TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
            this.gMm = (RelativeLayout) LayoutInflater.from(context).inflate(d.h.item_person_host_navigation_setting, (ViewGroup) null);
            this.gMn = (ImageView) this.gMm.findViewById(d.g.person_navigation_setting_img);
            this.gMo = (ImageView) this.gMm.findViewById(d.g.person_navigation_setting_red_tip);
        }
    }

    @Override // com.baidu.tieba.view.g
    public void bBi() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.gMj != null && this.gMj.getParent() == null) {
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gMj, (View.OnClickListener) null);
        }
        if (this.gMm != null && this.gMm.getParent() == null) {
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gMm, (View.OnClickListener) null);
        }
    }

    @Override // com.baidu.tieba.view.g
    public void setOnViewResponseListener(h hVar) {
        if (this.gMj != null) {
            this.gMj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.mFrom == 1) {
                        TiebaStatic.log(new ak("c12523").r("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new ak("c12502").ac("obj_locate", "1"));
                    }
                    e.this.z(6, false);
                    com.baidu.tieba.j.a.bjW().c(6, false, true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(e.this.mContext)));
                }
            });
        }
        if (this.gMm != null) {
            this.gMm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.e.2
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
                    com.baidu.tieba.j.a.bjW().c(5, false, true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MORE, new IntentConfig(view.getContext())));
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.g
    public void z(int i, boolean z) {
        if (i == 5 && this.gMo != null) {
            this.gMo.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.gMl != null) {
            this.gMl.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.g
    public void onChangeSkinType(int i) {
        if (this.gMk != null) {
            if (2 == i) {
                aj.a(this.gMk, d.f.icon_person_dressup_s, d.f.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.a(this.gMk, d.f.icon_person_dressup, d.f.icon_person_dressup);
            } else {
                aj.a(this.gMk, d.f.icon_person_dressup_s, d.f.icon_person_dressup_s);
            }
            if (this.gMl != null) {
                aj.c(this.gMl, d.f.icon_news_down_bar_one);
            }
        }
        if (this.gMn != null) {
            if (2 == i) {
                aj.a(this.gMn, d.f.icon_home_setting_s, d.f.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.a(this.gMn, d.f.icon_home_setting_w, d.f.icon_home_setting_w);
            } else {
                aj.a(this.gMn, d.f.icon_home_setting_s, d.f.icon_home_setting_s);
            }
            if (this.gMo != null) {
                aj.c(this.gMo, d.f.icon_news_down_bar_one);
            }
        }
    }

    @Override // com.baidu.tieba.view.g
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.gMk != null) {
                aj.a(this.gMk, d.f.icon_person_dressup_s, d.f.icon_person_dressup_s);
            }
            if (this.gMn != null) {
                aj.a(this.gMn, d.f.icon_home_setting_s, d.f.icon_home_setting_s);
            }
        } else {
            if (this.gMk != null) {
                aj.a(this.gMk, d.f.icon_person_dressup, d.f.icon_person_dressup);
            }
            if (this.gMn != null) {
                aj.a(this.gMn, d.f.icon_home_setting_w, d.f.icon_home_setting_w);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.gMk != null) {
                this.gMk.setAlpha(f2);
            }
            if (this.gMn != null) {
                this.gMn.setAlpha(f2);
            }
        }
    }

    public void aZR() {
        if (!this.gMp) {
            this.gMp = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_person_tab_feedback_tips", false);
            if (!this.gMp) {
                View inflate = LayoutInflater.from(this.mContext).inflate(d.h.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(d.g.arrow_up);
                TextView textView = (TextView) inflate.findViewById(d.g.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds32);
                textView.setText(d.j.person_tab_feedback_tips);
                textView.setOnClickListener(this.eYJ);
                this.eYE = new PopupWindow(inflate, -2, -2);
                this.mHandler.removeCallbacks(this.eYH);
                this.mHandler.postDelayed(this.eYH, 100L);
            }
        }
    }

    public void aWa() {
        this.mHandler.removeCallbacks(this.eYH);
        this.mHandler.removeCallbacks(this.eYI);
        aWb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWb() {
        com.baidu.adp.lib.g.g.a(this.eYE);
    }

    @Override // com.baidu.tieba.view.g
    public void f(UserData userData) {
    }
}
