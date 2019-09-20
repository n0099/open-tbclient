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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.c.a;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class d implements f {
    private PopupWindow ibS;
    private RelativeLayout jKF;
    private ImageView jKG;
    public ImageView jKH;
    private RelativeLayout jKI;
    private ImageView jKJ;
    public ImageView jKK;
    private View jKL;
    private ImageView jKM;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgement;
    private int jKE = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds28);
    private boolean jKN = false;
    private Handler mHandler = new Handler();
    private Runnable fUV = new Runnable() { // from class: com.baidu.tieba.view.d.4
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.jKJ;
            if (imageView != null) {
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(d.this.ibS, imageView);
                com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("show_person_tab_feedback_tips", true);
                d.this.jKN = true;
                d.this.mHandler.postDelayed(d.this.fUW, 3000L);
            }
        }
    };
    private Runnable fUW = new Runnable() { // from class: com.baidu.tieba.view.d.5
        @Override // java.lang.Runnable
        public void run() {
            d.this.btZ();
        }
    };
    private View.OnClickListener fUX = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bZN();
        }
    };

    public d(int i) {
        this.mFrom = i;
    }

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.jKF = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_dressup, (ViewGroup) null);
        this.jKG = (ImageView) this.jKF.findViewById(R.id.person_navigation_dressup_img);
        this.jKH = (ImageView) this.jKF.findViewById(R.id.person_navigation_dressup_red_tip);
        this.jKI = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_setting, (ViewGroup) null);
        this.jKJ = (ImageView) this.jKI.findViewById(R.id.person_navigation_setting_img);
        this.jKK = (ImageView) this.jKI.findViewById(R.id.person_navigation_setting_red_tip);
        this.jKL = LayoutInflater.from(this.mContext).inflate(R.layout.item_person_host_navigation_scan, (ViewGroup) null);
        this.jKM = (ImageView) this.jKL.findViewById(R.id.person_navigation_scan_img);
    }

    @Override // com.baidu.tieba.view.f
    public void cdE() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.jKF != null && this.jKF.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jKF, (View.OnClickListener) null);
            }
            if (this.jKI != null && this.jKI.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jKI, (View.OnClickListener) null);
            }
            if (this.jKL != null && this.jKL.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.jKL, (View.OnClickListener) null);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(g gVar) {
        if (this.jKF != null) {
            this.jKF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new an("c12523").P("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new an("c12502").bT("obj_locate", "1"));
                    }
                    d.this.Q(6, false);
                    com.baidu.tieba.o.a.cjV().e(6, false, true);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DressupCenterActivityConfig(d.this.mContext)));
                }
            });
        }
        if (this.jKI != null) {
            this.jKI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new an("c12523").P("obj_locate", 23));
                    } else {
                        TiebaStatic.log(new an("c12502").bT("obj_locate", "2"));
                    }
                    d.this.Q(5, false);
                    TiebaStatic.log(new an("c12502").bT("obj_locate", "2"));
                    d.this.Q(5, false);
                    com.baidu.tieba.o.a.cjV().e(5, false, true);
                    if (!TbadkCoreApplication.getInst().appResponseToCmd(2015004)) {
                        BdToast.b(d.this.mContext, d.this.mContext.getResources().getString(R.string.plugin_video_installing), 0).agW();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015004, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.jKL != null) {
            this.jKL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mContext instanceof Activity) {
                        Activity activity = (Activity) d.this.mContext;
                        if (d.this.mPermissionJudgement == null) {
                            d.this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
                        }
                        d.this.mPermissionJudgement.ake();
                        d.this.mPermissionJudgement.e(activity, "android.permission.CAMERA");
                        d.this.mPermissionJudgement.a(new a.InterfaceC0252a() { // from class: com.baidu.tieba.view.d.3.1
                            @Override // com.baidu.tbadk.core.util.c.a.InterfaceC0252a
                            public void akf() {
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
    public void Q(int i, boolean z) {
        if (i == 5 && this.jKK != null) {
            this.jKK.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.jKH != null) {
            this.jKH.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.jKG != null) {
            if (2 == i) {
                SvgManager.ajv().a(this.jKG, R.drawable.icon_pure_topbar_store_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                SvgManager.ajv().a(this.jKG, R.drawable.icon_pure_topbar_store_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.ajv().a(this.jKG, R.drawable.icon_pure_topbar_store_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.jKH != null) {
                am.c(this.jKH, (int) R.drawable.icon_news_down_bar_one);
            }
        }
        if (this.jKJ != null) {
            if (2 == i) {
                SvgManager.ajv().a(this.jKJ, R.drawable.icon_pure_topbar_set_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                SvgManager.ajv().a(this.jKJ, R.drawable.icon_pure_topbar_set_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.ajv().a(this.jKJ, R.drawable.icon_pure_topbar_set_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.jKK != null) {
                am.c(this.jKK, (int) R.drawable.icon_news_down_bar_one);
            }
        }
        SvgManager.ajv().a(this.jKM, R.drawable.icon_pure_topbar_scan_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    @Override // com.baidu.tieba.view.f
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.jKG != null) {
                SvgManager.ajv().a(this.jKG, R.drawable.icon_pure_topbar_store_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.jKJ != null) {
                SvgManager.ajv().a(this.jKJ, R.drawable.icon_pure_topbar_set_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        } else {
            if (this.jKG != null) {
                SvgManager.ajv().a(this.jKG, R.drawable.icon_pure_topbar_store_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.jKJ != null) {
                SvgManager.ajv().a(this.jKJ, R.drawable.icon_pure_topbar_set_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.jKG != null) {
                this.jKG.setAlpha(f2);
            }
            if (this.jKJ != null) {
                this.jKJ.setAlpha(f2);
            }
        }
    }

    public void ced() {
        if (!this.jKN) {
            this.jKN = com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("show_person_tab_feedback_tips", false);
            if (!this.jKN) {
                View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(R.id.arrow_up);
                TextView textView = (TextView) inflate.findViewById(R.id.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = l.g(this.mContext, R.dimen.ds32);
                textView.setText(R.string.person_tab_feedback_tips);
                textView.setOnClickListener(this.fUX);
                this.ibS = new PopupWindow(inflate, -2, -2);
                this.mHandler.removeCallbacks(this.fUV);
                this.mHandler.postDelayed(this.fUV, 100L);
            }
        }
    }

    public void bZN() {
        this.mHandler.removeCallbacks(this.fUV);
        this.mHandler.removeCallbacks(this.fUW);
        btZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btZ() {
        com.baidu.adp.lib.g.g.a(this.ibS);
    }

    @Override // com.baidu.tieba.view.f
    public void setUserData(UserData userData) {
    }
}
