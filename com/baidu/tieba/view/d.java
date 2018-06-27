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
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class d implements f {
    private PopupWindow fJD;
    private RelativeLayout hof;
    private ImageView hog;
    public ImageView hoh;
    private RelativeLayout hoi;
    private ImageView hoj;
    public ImageView hok;
    private View hol;
    private ImageView hom;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private int hoe = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds28);
    private boolean hon = false;
    private Handler mHandler = new Handler();
    private Runnable fJJ = new Runnable() { // from class: com.baidu.tieba.view.d.4
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.hoj;
            if (imageView != null) {
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(d.this.fJD, imageView);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_person_tab_feedback_tips", true);
                d.this.hon = true;
                d.this.mHandler.postDelayed(d.this.fJK, 3000L);
            }
        }
    };
    private Runnable fJK = new Runnable() { // from class: com.baidu.tieba.view.d.5
        @Override // java.lang.Runnable
        public void run() {
            d.this.bgU();
        }
    };
    private View.OnClickListener fJL = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bgT();
        }
    };

    public d(int i) {
        this.mFrom = i;
    }

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.hof = (RelativeLayout) LayoutInflater.from(context).inflate(d.i.item_person_host_navigation_dressup, (ViewGroup) null);
        this.hog = (ImageView) this.hof.findViewById(d.g.person_navigation_dressup_img);
        this.hoh = (ImageView) this.hof.findViewById(d.g.person_navigation_dressup_red_tip);
        this.hoi = (RelativeLayout) LayoutInflater.from(context).inflate(d.i.item_person_host_navigation_setting, (ViewGroup) null);
        this.hoj = (ImageView) this.hoi.findViewById(d.g.person_navigation_setting_img);
        this.hok = (ImageView) this.hoi.findViewById(d.g.person_navigation_setting_red_tip);
        this.hol = LayoutInflater.from(this.mContext).inflate(d.i.item_person_host_navigation_scan, (ViewGroup) null);
        this.hom = (ImageView) this.hol.findViewById(d.g.person_navigation_scan_img);
    }

    @Override // com.baidu.tieba.view.f
    public void bkv() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.hof != null && this.hof.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hof, (View.OnClickListener) null);
            }
            if (this.hoi != null && this.hoi.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hoi, (View.OnClickListener) null);
            }
            if (this.hol != null && this.hol.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.hol, (View.OnClickListener) null);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(g gVar) {
        if (this.hof != null) {
            this.hof.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new an("c12523").r("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new an("c12502").ah("obj_locate", "1"));
                    }
                    d.this.C(6, false);
                    com.baidu.tieba.o.a.bpR().b(6, false, true);
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DressupCenterActivityConfig(d.this.mContext)));
                        return;
                    }
                    BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(d.k.plugin_video_installing), 0).xv();
                }
            });
        }
        if (this.hoi != null) {
            this.hoi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new an("c12523").r("obj_locate", 23));
                    } else {
                        TiebaStatic.log(new an("c12502").ah("obj_locate", "2"));
                    }
                    d.this.C(5, false);
                    TiebaStatic.log(new an("c12502").ah("obj_locate", "2"));
                    d.this.C(5, false);
                    com.baidu.tieba.o.a.bpR().b(5, false, true);
                    if (!TbadkCoreApplication.getInst().appResponseToCmd(2015004)) {
                        BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(d.k.plugin_video_installing), 0).xv();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015004, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.hol != null) {
            this.hol.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c12706"));
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(QRCodeScanActivityConfig.class)) {
                        BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(d.k.plugin_video_installing), 0).xv();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new QRCodeScanActivityConfig(d.this.mContext)));
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.f
    public void C(int i, boolean z) {
        if (i == 5 && this.hok != null) {
            this.hok.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.hoh != null) {
            this.hoh.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.hog != null) {
            if (2 == i) {
                am.a(this.hog, d.f.icon_person_dressup_s, d.f.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                am.a(this.hog, d.f.icon_person_dressup, d.f.icon_person_dressup);
            } else {
                am.a(this.hog, d.f.icon_person_dressup_s, d.f.icon_person_dressup_s);
            }
            if (this.hoh != null) {
                am.c(this.hoh, d.f.icon_news_down_bar_one);
            }
        }
        if (this.hoj != null) {
            if (2 == i) {
                am.a(this.hoj, d.f.icon_home_setting_s, d.f.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                am.a(this.hoj, d.f.icon_home_setting_w, d.f.icon_home_setting_w);
            } else {
                am.a(this.hoj, d.f.icon_home_setting_s, d.f.icon_home_setting_s);
            }
            if (this.hok != null) {
                am.c(this.hok, d.f.icon_news_down_bar_one);
            }
        }
        am.c(this.hom, d.f.selector_top_bar_scan);
    }

    @Override // com.baidu.tieba.view.f
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.hog != null) {
                am.a(this.hog, d.f.icon_person_dressup_s, d.f.icon_person_dressup_s);
            }
            if (this.hoj != null) {
                am.a(this.hoj, d.f.icon_home_setting_s, d.f.icon_home_setting_s);
            }
        } else {
            if (this.hog != null) {
                am.a(this.hog, d.f.icon_person_dressup, d.f.icon_person_dressup);
            }
            if (this.hoj != null) {
                am.a(this.hoj, d.f.icon_home_setting_w, d.f.icon_home_setting_w);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.hog != null) {
                this.hog.setAlpha(f2);
            }
            if (this.hoj != null) {
                this.hoj.setAlpha(f2);
            }
        }
    }

    public void bkY() {
        if (!this.hon) {
            this.hon = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_person_tab_feedback_tips", false);
            if (!this.hon) {
                View inflate = LayoutInflater.from(this.mContext).inflate(d.i.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(d.g.arrow_up);
                TextView textView = (TextView) inflate.findViewById(d.g.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = l.e(this.mContext, d.e.ds32);
                textView.setText(d.k.person_tab_feedback_tips);
                textView.setOnClickListener(this.fJL);
                this.fJD = new PopupWindow(inflate, -2, -2);
                this.mHandler.removeCallbacks(this.fJJ);
                this.mHandler.postDelayed(this.fJJ, 100L);
            }
        }
    }

    public void bgT() {
        this.mHandler.removeCallbacks(this.fJJ);
        this.mHandler.removeCallbacks(this.fJK);
        bgU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgU() {
        com.baidu.adp.lib.g.g.a(this.fJD);
    }

    @Override // com.baidu.tieba.view.f
    public void e(UserData userData) {
    }
}
