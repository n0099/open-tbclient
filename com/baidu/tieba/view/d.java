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
    private PopupWindow hZV;
    private RelativeLayout jIk;
    private ImageView jIl;
    public ImageView jIm;
    private RelativeLayout jIn;
    private ImageView jIo;
    public ImageView jIp;
    private View jIq;
    private ImageView jIr;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private int jIj = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds28);
    private boolean jIs = false;
    private Handler mHandler = new Handler();
    private Runnable fTe = new Runnable() { // from class: com.baidu.tieba.view.d.4
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.jIo;
            if (imageView != null) {
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(d.this.hZV, imageView);
                com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("show_person_tab_feedback_tips", true);
                d.this.jIs = true;
                d.this.mHandler.postDelayed(d.this.fTf, 3000L);
            }
        }
    };
    private Runnable fTf = new Runnable() { // from class: com.baidu.tieba.view.d.5
        @Override // java.lang.Runnable
        public void run() {
            d.this.btl();
        }
    };
    private View.OnClickListener fTg = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bYZ();
        }
    };

    public d(int i) {
        this.mFrom = i;
    }

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.jIk = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_dressup, (ViewGroup) null);
        this.jIl = (ImageView) this.jIk.findViewById(R.id.person_navigation_dressup_img);
        this.jIm = (ImageView) this.jIk.findViewById(R.id.person_navigation_dressup_red_tip);
        this.jIn = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_setting, (ViewGroup) null);
        this.jIo = (ImageView) this.jIn.findViewById(R.id.person_navigation_setting_img);
        this.jIp = (ImageView) this.jIn.findViewById(R.id.person_navigation_setting_red_tip);
        this.jIq = LayoutInflater.from(this.mContext).inflate(R.layout.item_person_host_navigation_scan, (ViewGroup) null);
        this.jIr = (ImageView) this.jIq.findViewById(R.id.person_navigation_scan_img);
    }

    @Override // com.baidu.tieba.view.f
    public void ccQ() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.jIk != null && this.jIk.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jIk, (View.OnClickListener) null);
            }
            if (this.jIn != null && this.jIn.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jIn, (View.OnClickListener) null);
            }
            if (this.jIq != null && this.jIq.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.jIq, (View.OnClickListener) null);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(g gVar) {
        if (this.jIk != null) {
            this.jIk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new an("c12523").P("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new an("c12502").bT("obj_locate", "1"));
                    }
                    d.this.P(6, false);
                    com.baidu.tieba.o.a.cjj().e(6, false, true);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DressupCenterActivityConfig(d.this.mContext)));
                }
            });
        }
        if (this.jIn != null) {
            this.jIn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
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
                    com.baidu.tieba.o.a.cjj().e(5, false, true);
                    if (!TbadkCoreApplication.getInst().appResponseToCmd(2015004)) {
                        BdToast.b(d.this.mContext, d.this.mContext.getResources().getString(R.string.plugin_video_installing), 0).agS();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015004, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.jIq != null) {
            this.jIq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mContext instanceof Activity) {
                        Activity activity = (Activity) d.this.mContext;
                        if (d.this.mPermissionJudgement == null) {
                            d.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                        }
                        d.this.mPermissionJudgement.ajS();
                        d.this.mPermissionJudgement.e(activity, "android.permission.CAMERA");
                        d.this.mPermissionJudgement.a(new a.InterfaceC0243a() { // from class: com.baidu.tieba.view.d.3.1
                            @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0243a
                            public void ajT() {
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
        if (i == 5 && this.jIp != null) {
            this.jIp.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.jIm != null) {
            this.jIm.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.jIl != null) {
            if (2 == i) {
                am.a(this.jIl, (int) R.drawable.icon_person_dressup_s, (int) R.drawable.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                am.a(this.jIl, (int) R.drawable.icon_person_dressup, (int) R.drawable.icon_person_dressup);
            } else {
                am.a(this.jIl, (int) R.drawable.icon_person_dressup_s, (int) R.drawable.icon_person_dressup_s);
            }
            if (this.jIm != null) {
                am.c(this.jIm, (int) R.drawable.icon_news_down_bar_one);
            }
        }
        if (this.jIo != null) {
            if (2 == i) {
                am.a(this.jIo, (int) R.drawable.icon_home_setting_s, (int) R.drawable.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                am.a(this.jIo, (int) R.drawable.icon_home_setting_w, (int) R.drawable.icon_home_setting_w);
            } else {
                am.a(this.jIo, (int) R.drawable.icon_home_setting_s, (int) R.drawable.icon_home_setting_s);
            }
            if (this.jIp != null) {
                am.c(this.jIp, (int) R.drawable.icon_news_down_bar_one);
            }
        }
        am.c(this.jIr, (int) R.drawable.selector_top_bar_scan);
    }

    @Override // com.baidu.tieba.view.f
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.jIl != null) {
                am.a(this.jIl, (int) R.drawable.icon_person_dressup_s, (int) R.drawable.icon_person_dressup_s);
            }
            if (this.jIo != null) {
                am.a(this.jIo, (int) R.drawable.icon_home_setting_s, (int) R.drawable.icon_home_setting_s);
            }
        } else {
            if (this.jIl != null) {
                am.a(this.jIl, (int) R.drawable.icon_person_dressup, (int) R.drawable.icon_person_dressup);
            }
            if (this.jIo != null) {
                am.a(this.jIo, (int) R.drawable.icon_home_setting_w, (int) R.drawable.icon_home_setting_w);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.jIl != null) {
                this.jIl.setAlpha(f2);
            }
            if (this.jIo != null) {
                this.jIo.setAlpha(f2);
            }
        }
    }

    public void cdp() {
        if (!this.jIs) {
            this.jIs = com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("show_person_tab_feedback_tips", false);
            if (!this.jIs) {
                View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(R.id.arrow_up);
                TextView textView = (TextView) inflate.findViewById(R.id.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = l.g(this.mContext, R.dimen.ds32);
                textView.setText(R.string.person_tab_feedback_tips);
                textView.setOnClickListener(this.fTg);
                this.hZV = new PopupWindow(inflate, -2, -2);
                this.mHandler.removeCallbacks(this.fTe);
                this.mHandler.postDelayed(this.fTe, 100L);
            }
        }
    }

    public void bYZ() {
        this.mHandler.removeCallbacks(this.fTe);
        this.mHandler.removeCallbacks(this.fTf);
        btl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btl() {
        com.baidu.adp.lib.g.g.a(this.hZV);
    }

    @Override // com.baidu.tieba.view.f
    public void setUserData(UserData userData) {
    }
}
