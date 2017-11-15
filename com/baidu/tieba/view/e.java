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
    private PopupWindow eYZ;
    private RelativeLayout gNr;
    private ImageView gNs;
    public ImageView gNt;
    private RelativeLayout gNu;
    private ImageView gNv;
    public ImageView gNw;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private boolean gNx = false;
    private Handler mHandler = new Handler();
    private Runnable eZc = new Runnable() { // from class: com.baidu.tieba.view.e.3
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = e.this.gNv;
            if (imageView != null) {
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(e.this.eYZ, imageView);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_person_tab_feedback_tips", true);
                e.this.gNx = true;
                e.this.mHandler.postDelayed(e.this.eZd, 3000L);
            }
        }
    };
    private Runnable eZd = new Runnable() { // from class: com.baidu.tieba.view.e.4
        @Override // java.lang.Runnable
        public void run() {
            e.this.aWj();
        }
    };
    private View.OnClickListener eZe = new View.OnClickListener() { // from class: com.baidu.tieba.view.e.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.aWi();
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
            this.gNr = (RelativeLayout) LayoutInflater.from(context).inflate(d.h.item_person_host_navigation_dressup, (ViewGroup) null);
            this.gNs = (ImageView) this.gNr.findViewById(d.g.person_navigation_dressup_img);
            this.gNt = (ImageView) this.gNr.findViewById(d.g.person_navigation_dressup_red_tip);
        }
        if (TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
            this.gNu = (RelativeLayout) LayoutInflater.from(context).inflate(d.h.item_person_host_navigation_setting, (ViewGroup) null);
            this.gNv = (ImageView) this.gNu.findViewById(d.g.person_navigation_setting_img);
            this.gNw = (ImageView) this.gNu.findViewById(d.g.person_navigation_setting_red_tip);
        }
    }

    @Override // com.baidu.tieba.view.g
    public void bBu() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.gNr != null && this.gNr.getParent() == null) {
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gNr, (View.OnClickListener) null);
        }
        if (this.gNu != null && this.gNu.getParent() == null) {
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gNu, (View.OnClickListener) null);
        }
    }

    @Override // com.baidu.tieba.view.g
    public void setOnViewResponseListener(h hVar) {
        if (this.gNr != null) {
            this.gNr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.mFrom == 1) {
                        TiebaStatic.log(new ak("c12523").r("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new ak("c12502").ac("obj_locate", "1"));
                    }
                    e.this.A(6, false);
                    com.baidu.tieba.j.a.bkh().c(6, false, true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(e.this.mContext)));
                }
            });
        }
        if (this.gNu != null) {
            this.gNu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.mFrom == 1) {
                        TiebaStatic.log(new ak("c12523").r("obj_locate", 23));
                    } else {
                        TiebaStatic.log(new ak("c12502").ac("obj_locate", "2"));
                    }
                    e.this.A(5, false);
                    TiebaStatic.log(new ak("c12502").ac("obj_locate", "2"));
                    e.this.A(5, false);
                    com.baidu.tieba.j.a.bkh().c(5, false, true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MORE, new IntentConfig(view.getContext())));
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.g
    public void A(int i, boolean z) {
        if (i == 5 && this.gNw != null) {
            this.gNw.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.gNt != null) {
            this.gNt.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.g
    public void onChangeSkinType(int i) {
        if (this.gNs != null) {
            if (2 == i) {
                aj.a(this.gNs, d.f.icon_person_dressup_s, d.f.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.a(this.gNs, d.f.icon_person_dressup, d.f.icon_person_dressup);
            } else {
                aj.a(this.gNs, d.f.icon_person_dressup_s, d.f.icon_person_dressup_s);
            }
            if (this.gNt != null) {
                aj.c(this.gNt, d.f.icon_news_down_bar_one);
            }
        }
        if (this.gNv != null) {
            if (2 == i) {
                aj.a(this.gNv, d.f.icon_home_setting_s, d.f.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.a(this.gNv, d.f.icon_home_setting_w, d.f.icon_home_setting_w);
            } else {
                aj.a(this.gNv, d.f.icon_home_setting_s, d.f.icon_home_setting_s);
            }
            if (this.gNw != null) {
                aj.c(this.gNw, d.f.icon_news_down_bar_one);
            }
        }
    }

    @Override // com.baidu.tieba.view.g
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.gNs != null) {
                aj.a(this.gNs, d.f.icon_person_dressup_s, d.f.icon_person_dressup_s);
            }
            if (this.gNv != null) {
                aj.a(this.gNv, d.f.icon_home_setting_s, d.f.icon_home_setting_s);
            }
        } else {
            if (this.gNs != null) {
                aj.a(this.gNs, d.f.icon_person_dressup, d.f.icon_person_dressup);
            }
            if (this.gNv != null) {
                aj.a(this.gNv, d.f.icon_home_setting_w, d.f.icon_home_setting_w);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.gNs != null) {
                this.gNs.setAlpha(f2);
            }
            if (this.gNv != null) {
                this.gNv.setAlpha(f2);
            }
        }
    }

    public void aZZ() {
        if (!this.gNx) {
            this.gNx = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_person_tab_feedback_tips", false);
            if (!this.gNx) {
                View inflate = LayoutInflater.from(this.mContext).inflate(d.h.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(d.g.arrow_up);
                TextView textView = (TextView) inflate.findViewById(d.g.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds32);
                textView.setText(d.j.person_tab_feedback_tips);
                textView.setOnClickListener(this.eZe);
                this.eYZ = new PopupWindow(inflate, -2, -2);
                this.mHandler.removeCallbacks(this.eZc);
                this.mHandler.postDelayed(this.eZc, 100L);
            }
        }
    }

    public void aWi() {
        this.mHandler.removeCallbacks(this.eZc);
        this.mHandler.removeCallbacks(this.eZd);
        aWj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWj() {
        com.baidu.adp.lib.g.g.a(this.eYZ);
    }

    @Override // com.baidu.tieba.view.g
    public void f(UserData userData) {
    }
}
