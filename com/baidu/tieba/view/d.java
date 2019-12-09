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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
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
    private PopupWindow hZH;
    private RelativeLayout jJD;
    private ImageView jJE;
    public ImageView jJF;
    private RelativeLayout jJG;
    private ImageView jJH;
    public ImageView jJI;
    private View jJJ;
    private ImageView jJK;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgement;
    private int jJC = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds28);
    private boolean jJL = false;
    private Handler mHandler = new Handler();
    private Runnable fTy = new Runnable() { // from class: com.baidu.tieba.view.d.4
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.jJH;
            if (imageView != null) {
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(d.this.hZH, imageView);
                com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.SHOW_PERSON_TAB_FEEDBACK_TIPS, true);
                d.this.jJL = true;
                d.this.mHandler.postDelayed(d.this.fTz, 3000L);
            }
        }
    };
    private Runnable fTz = new Runnable() { // from class: com.baidu.tieba.view.d.5
        @Override // java.lang.Runnable
        public void run() {
            d.this.bra();
        }
    };
    private View.OnClickListener fTA = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bWN();
        }
    };

    public d(int i) {
        this.mFrom = i;
    }

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.jJD = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_dressup, (ViewGroup) null);
        this.jJE = (ImageView) this.jJD.findViewById(R.id.person_navigation_dressup_img);
        this.jJF = (ImageView) this.jJD.findViewById(R.id.person_navigation_dressup_red_tip);
        this.jJG = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_setting, (ViewGroup) null);
        this.jJH = (ImageView) this.jJG.findViewById(R.id.person_navigation_setting_img);
        this.jJI = (ImageView) this.jJG.findViewById(R.id.person_navigation_setting_red_tip);
        this.jJJ = LayoutInflater.from(this.mContext).inflate(R.layout.item_person_host_navigation_scan, (ViewGroup) null);
        this.jJK = (ImageView) this.jJJ.findViewById(R.id.person_navigation_scan_img);
    }

    @Override // com.baidu.tieba.view.f
    public void caD() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.jJD != null && this.jJD.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jJD, (View.OnClickListener) null);
            }
            if (this.jJG != null && this.jJG.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jJG, (View.OnClickListener) null);
            }
            if (this.jJJ != null && this.jJJ.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.jJJ, (View.OnClickListener) null);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(g gVar) {
        if (this.jJD != null) {
            this.jJD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new an("c12523").O("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new an("c12502").bS("obj_locate", "1"));
                    }
                    d.this.O(6, false);
                    com.baidu.tieba.o.a.chb().e(6, false, true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(d.this.mContext)));
                }
            });
        }
        if (this.jJG != null) {
            this.jJG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new an("c12523").O("obj_locate", 23));
                    } else {
                        TiebaStatic.log(new an("c12502").bS("obj_locate", "2"));
                    }
                    d.this.O(5, false);
                    TiebaStatic.log(new an("c12502").bS("obj_locate", "2"));
                    d.this.O(5, false);
                    com.baidu.tieba.o.a.chb().e(5, false, true);
                    if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
                        BdToast.b(d.this.mContext, d.this.mContext.getResources().getString(R.string.plugin_video_installing), 0).akR();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MORE, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.jJJ != null) {
            this.jJJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mContext instanceof Activity) {
                        Activity activity = (Activity) d.this.mContext;
                        if (d.this.mPermissionJudgement == null) {
                            d.this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
                        }
                        d.this.mPermissionJudgement.clearRequestPermissionList();
                        d.this.mPermissionJudgement.appendRequestPermission(activity, "android.permission.CAMERA");
                        d.this.mPermissionJudgement.a(new a.InterfaceC0279a() { // from class: com.baidu.tieba.view.d.3.1
                            @Override // com.baidu.tbadk.core.util.c.a.InterfaceC0279a
                            public void onPermissionsGranted() {
                                TiebaStatic.log(new an("c12706"));
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new QRCodeScanActivityConfig(d.this.mContext)));
                            }
                        });
                        d.this.mPermissionJudgement.startRequestPermission(activity);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.f
    public void O(int i, boolean z) {
        if (i == 5 && this.jJI != null) {
            this.jJI.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.jJF != null) {
            this.jJF.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.jJE != null) {
            if (2 == i) {
                SvgManager.amL().a(this.jJE, R.drawable.icon_pure_topbar_store_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                SvgManager.amL().a(this.jJE, R.drawable.icon_pure_topbar_store_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.amL().a(this.jJE, R.drawable.icon_pure_topbar_store_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.jJF != null) {
                am.setImageResource(this.jJF, R.drawable.icon_news_down_bar_one);
            }
        }
        if (this.jJH != null) {
            if (2 == i) {
                SvgManager.amL().a(this.jJH, R.drawable.icon_pure_topbar_set_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                SvgManager.amL().a(this.jJH, R.drawable.icon_pure_topbar_set_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.amL().a(this.jJH, R.drawable.icon_pure_topbar_set_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.jJI != null) {
                am.setImageResource(this.jJI, R.drawable.icon_news_down_bar_one);
            }
        }
        SvgManager.amL().a(this.jJK, R.drawable.icon_pure_topbar_scan_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    @Override // com.baidu.tieba.view.f
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.jJE != null) {
                SvgManager.amL().a(this.jJE, R.drawable.icon_pure_topbar_store_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.jJH != null) {
                SvgManager.amL().a(this.jJH, R.drawable.icon_pure_topbar_set_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        } else {
            if (this.jJE != null) {
                SvgManager.amL().a(this.jJE, R.drawable.icon_pure_topbar_store_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.jJH != null) {
                SvgManager.amL().a(this.jJH, R.drawable.icon_pure_topbar_set_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.jJE != null) {
                this.jJE.setAlpha(f2);
            }
            if (this.jJH != null) {
                this.jJH.setAlpha(f2);
            }
        }
    }

    public void cbd() {
        if (!this.jJL) {
            this.jJL = com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(SharedPrefConfig.SHOW_PERSON_TAB_FEEDBACK_TIPS, false);
            if (!this.jJL) {
                View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(R.id.arrow_up);
                TextView textView = (TextView) inflate.findViewById(R.id.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = l.getDimens(this.mContext, R.dimen.ds32);
                textView.setText(R.string.person_tab_feedback_tips);
                textView.setOnClickListener(this.fTA);
                this.hZH = new PopupWindow(inflate, -2, -2);
                this.mHandler.removeCallbacks(this.fTy);
                this.mHandler.postDelayed(this.fTy, 100L);
            }
        }
    }

    public void bWN() {
        this.mHandler.removeCallbacks(this.fTy);
        this.mHandler.removeCallbacks(this.fTz);
        bra();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bra() {
        com.baidu.adp.lib.g.g.dismissPopupWindow(this.hZH);
    }

    @Override // com.baidu.tieba.view.f
    public void setUserData(UserData userData) {
    }
}
