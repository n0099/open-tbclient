package com.baidu.tieba.view;

import android.app.Activity;
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
import com.baidu.tbadk.core.util.b.a;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class d implements f {
    private PopupWindow hYZ;
    private RelativeLayout jHd;
    private ImageView jHe;
    public ImageView jHf;
    private RelativeLayout jHg;
    private ImageView jHh;
    public ImageView jHi;
    private View jHj;
    private ImageView jHk;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private int jHc = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds28);
    private boolean jHl = false;
    private Handler mHandler = new Handler();
    private Runnable fSo = new Runnable() { // from class: com.baidu.tieba.view.d.4
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.jHh;
            if (imageView != null) {
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(d.this.hYZ, imageView);
                com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("show_person_tab_feedback_tips", true);
                d.this.jHl = true;
                d.this.mHandler.postDelayed(d.this.fSp, 3000L);
            }
        }
    };
    private Runnable fSp = new Runnable() { // from class: com.baidu.tieba.view.d.5
        @Override // java.lang.Runnable
        public void run() {
            d.this.bsY();
        }
    };
    private View.OnClickListener fSq = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bYI();
        }
    };

    public d(int i) {
        this.mFrom = i;
    }

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.jHd = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_dressup, (ViewGroup) null);
        this.jHe = (ImageView) this.jHd.findViewById(R.id.person_navigation_dressup_img);
        this.jHf = (ImageView) this.jHd.findViewById(R.id.person_navigation_dressup_red_tip);
        this.jHg = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_setting, (ViewGroup) null);
        this.jHh = (ImageView) this.jHg.findViewById(R.id.person_navigation_setting_img);
        this.jHi = (ImageView) this.jHg.findViewById(R.id.person_navigation_setting_red_tip);
        this.jHj = LayoutInflater.from(this.mContext).inflate(R.layout.item_person_host_navigation_scan, (ViewGroup) null);
        this.jHk = (ImageView) this.jHj.findViewById(R.id.person_navigation_scan_img);
    }

    @Override // com.baidu.tieba.view.f
    public void ccy() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.jHd != null && this.jHd.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jHd, (View.OnClickListener) null);
            }
            if (this.jHg != null && this.jHg.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jHg, (View.OnClickListener) null);
            }
            if (this.jHj != null && this.jHj.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.jHj, (View.OnClickListener) null);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(g gVar) {
        if (this.jHd != null) {
            this.jHd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new an("c12523").P("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new an("c12502").bT("obj_locate", "1"));
                    }
                    d.this.P(6, false);
                    com.baidu.tieba.o.a.ciR().e(6, false, true);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DressupCenterActivityConfig(d.this.mContext)));
                }
            });
        }
        if (this.jHg != null) {
            this.jHg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new an("c12523").P("obj_locate", 23));
                    } else {
                        TiebaStatic.log(new an("c12502").bT("obj_locate", "2"));
                    }
                    d.this.P(5, false);
                    TiebaStatic.log(new an("c12502").bT("obj_locate", "2"));
                    d.this.P(5, false);
                    com.baidu.tieba.o.a.ciR().e(5, false, true);
                    if (!TbadkCoreApplication.getInst().appResponseToCmd(2015004)) {
                        BdToast.b(d.this.mContext, d.this.mContext.getResources().getString(R.string.plugin_video_installing), 0).agQ();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015004, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.jHj != null) {
            this.jHj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mContext instanceof Activity) {
                        Activity activity = (Activity) d.this.mContext;
                        if (d.this.mPermissionJudgement == null) {
                            d.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                        }
                        d.this.mPermissionJudgement.ajQ();
                        d.this.mPermissionJudgement.e(activity, "android.permission.CAMERA");
                        d.this.mPermissionJudgement.a(new a.InterfaceC0238a() { // from class: com.baidu.tieba.view.d.3.1
                            @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0238a
                            public void ajR() {
                                TiebaStatic.log(new an("c12706"));
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new QRCodeScanActivityConfig(d.this.mContext)));
                            }
                        });
                        d.this.mPermissionJudgement.ad(activity);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.f
    public void P(int i, boolean z) {
        if (i == 5 && this.jHi != null) {
            this.jHi.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.jHf != null) {
            this.jHf.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.jHe != null) {
            if (2 == i) {
                am.a(this.jHe, (int) R.drawable.icon_person_dressup_s, (int) R.drawable.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                am.a(this.jHe, (int) R.drawable.icon_person_dressup, (int) R.drawable.icon_person_dressup);
            } else {
                am.a(this.jHe, (int) R.drawable.icon_person_dressup_s, (int) R.drawable.icon_person_dressup_s);
            }
            if (this.jHf != null) {
                am.c(this.jHf, (int) R.drawable.icon_news_down_bar_one);
            }
        }
        if (this.jHh != null) {
            if (2 == i) {
                am.a(this.jHh, (int) R.drawable.icon_home_setting_s, (int) R.drawable.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                am.a(this.jHh, (int) R.drawable.icon_home_setting_w, (int) R.drawable.icon_home_setting_w);
            } else {
                am.a(this.jHh, (int) R.drawable.icon_home_setting_s, (int) R.drawable.icon_home_setting_s);
            }
            if (this.jHi != null) {
                am.c(this.jHi, (int) R.drawable.icon_news_down_bar_one);
            }
        }
        am.c(this.jHk, (int) R.drawable.selector_top_bar_scan);
    }

    @Override // com.baidu.tieba.view.f
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.jHe != null) {
                am.a(this.jHe, (int) R.drawable.icon_person_dressup_s, (int) R.drawable.icon_person_dressup_s);
            }
            if (this.jHh != null) {
                am.a(this.jHh, (int) R.drawable.icon_home_setting_s, (int) R.drawable.icon_home_setting_s);
            }
        } else {
            if (this.jHe != null) {
                am.a(this.jHe, (int) R.drawable.icon_person_dressup, (int) R.drawable.icon_person_dressup);
            }
            if (this.jHh != null) {
                am.a(this.jHh, (int) R.drawable.icon_home_setting_w, (int) R.drawable.icon_home_setting_w);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.jHe != null) {
                this.jHe.setAlpha(f2);
            }
            if (this.jHh != null) {
                this.jHh.setAlpha(f2);
            }
        }
    }

    public void ccX() {
        if (!this.jHl) {
            this.jHl = com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("show_person_tab_feedback_tips", false);
            if (!this.jHl) {
                View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(R.id.arrow_up);
                TextView textView = (TextView) inflate.findViewById(R.id.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = l.g(this.mContext, R.dimen.ds32);
                textView.setText(R.string.person_tab_feedback_tips);
                textView.setOnClickListener(this.fSq);
                this.hYZ = new PopupWindow(inflate, -2, -2);
                this.mHandler.removeCallbacks(this.fSo);
                this.mHandler.postDelayed(this.fSo, 100L);
            }
        }
    }

    public void bYI() {
        this.mHandler.removeCallbacks(this.fSo);
        this.mHandler.removeCallbacks(this.fSp);
        bsY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsY() {
        com.baidu.adp.lib.g.g.a(this.hYZ);
    }

    @Override // com.baidu.tieba.view.f
    public void setUserData(UserData userData) {
    }
}
