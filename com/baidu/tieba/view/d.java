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
    private PopupWindow iay;
    private View jKA;
    private ImageView jKB;
    private RelativeLayout jKu;
    private ImageView jKv;
    public ImageView jKw;
    private RelativeLayout jKx;
    private ImageView jKy;
    public ImageView jKz;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgement;
    private int jKt = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds28);
    private boolean jKC = false;
    private Handler mHandler = new Handler();
    private Runnable fUp = new Runnable() { // from class: com.baidu.tieba.view.d.4
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.jKy;
            if (imageView != null) {
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(d.this.iay, imageView);
                com.baidu.tbadk.core.sharedPref.b.alR().putBoolean(SharedPrefConfig.SHOW_PERSON_TAB_FEEDBACK_TIPS, true);
                d.this.jKC = true;
                d.this.mHandler.postDelayed(d.this.fUq, 3000L);
            }
        }
    };
    private Runnable fUq = new Runnable() { // from class: com.baidu.tieba.view.d.5
        @Override // java.lang.Runnable
        public void run() {
            d.this.brc();
        }
    };
    private View.OnClickListener fUr = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bWP();
        }
    };

    public d(int i) {
        this.mFrom = i;
    }

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.jKu = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_dressup, (ViewGroup) null);
        this.jKv = (ImageView) this.jKu.findViewById(R.id.person_navigation_dressup_img);
        this.jKw = (ImageView) this.jKu.findViewById(R.id.person_navigation_dressup_red_tip);
        this.jKx = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_setting, (ViewGroup) null);
        this.jKy = (ImageView) this.jKx.findViewById(R.id.person_navigation_setting_img);
        this.jKz = (ImageView) this.jKx.findViewById(R.id.person_navigation_setting_red_tip);
        this.jKA = LayoutInflater.from(this.mContext).inflate(R.layout.item_person_host_navigation_scan, (ViewGroup) null);
        this.jKB = (ImageView) this.jKA.findViewById(R.id.person_navigation_scan_img);
    }

    @Override // com.baidu.tieba.view.f
    public void caF() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.jKu != null && this.jKu.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jKu, (View.OnClickListener) null);
            }
            if (this.jKx != null && this.jKx.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jKx, (View.OnClickListener) null);
            }
            if (this.jKA != null && this.jKA.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.jKA, (View.OnClickListener) null);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(g gVar) {
        if (this.jKu != null) {
            this.jKu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new an("c12523").O("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new an("c12502").bS("obj_locate", "1"));
                    }
                    d.this.O(6, false);
                    com.baidu.tieba.o.a.chd().e(6, false, true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(d.this.mContext)));
                }
            });
        }
        if (this.jKx != null) {
            this.jKx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
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
                    com.baidu.tieba.o.a.chd().e(5, false, true);
                    if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
                        BdToast.b(d.this.mContext, d.this.mContext.getResources().getString(R.string.plugin_video_installing), 0).akT();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MORE, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.jKA != null) {
            this.jKA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mContext instanceof Activity) {
                        Activity activity = (Activity) d.this.mContext;
                        if (d.this.mPermissionJudgement == null) {
                            d.this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
                        }
                        d.this.mPermissionJudgement.clearRequestPermissionList();
                        d.this.mPermissionJudgement.appendRequestPermission(activity, "android.permission.CAMERA");
                        d.this.mPermissionJudgement.a(new a.InterfaceC0284a() { // from class: com.baidu.tieba.view.d.3.1
                            @Override // com.baidu.tbadk.core.util.c.a.InterfaceC0284a
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
        if (i == 5 && this.jKz != null) {
            this.jKz.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.jKw != null) {
            this.jKw.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.jKv != null) {
            if (2 == i) {
                SvgManager.amN().a(this.jKv, R.drawable.icon_pure_topbar_store_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                SvgManager.amN().a(this.jKv, R.drawable.icon_pure_topbar_store_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.amN().a(this.jKv, R.drawable.icon_pure_topbar_store_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.jKw != null) {
                am.setImageResource(this.jKw, R.drawable.icon_news_down_bar_one);
            }
        }
        if (this.jKy != null) {
            if (2 == i) {
                SvgManager.amN().a(this.jKy, R.drawable.icon_pure_topbar_set_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                SvgManager.amN().a(this.jKy, R.drawable.icon_pure_topbar_set_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.amN().a(this.jKy, R.drawable.icon_pure_topbar_set_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.jKz != null) {
                am.setImageResource(this.jKz, R.drawable.icon_news_down_bar_one);
            }
        }
        SvgManager.amN().a(this.jKB, R.drawable.icon_pure_topbar_scan_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    @Override // com.baidu.tieba.view.f
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.jKv != null) {
                SvgManager.amN().a(this.jKv, R.drawable.icon_pure_topbar_store_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.jKy != null) {
                SvgManager.amN().a(this.jKy, R.drawable.icon_pure_topbar_set_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        } else {
            if (this.jKv != null) {
                SvgManager.amN().a(this.jKv, R.drawable.icon_pure_topbar_store_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.jKy != null) {
                SvgManager.amN().a(this.jKy, R.drawable.icon_pure_topbar_set_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.jKv != null) {
                this.jKv.setAlpha(f2);
            }
            if (this.jKy != null) {
                this.jKy.setAlpha(f2);
            }
        }
    }

    public void cbf() {
        if (!this.jKC) {
            this.jKC = com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(SharedPrefConfig.SHOW_PERSON_TAB_FEEDBACK_TIPS, false);
            if (!this.jKC) {
                View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(R.id.arrow_up);
                TextView textView = (TextView) inflate.findViewById(R.id.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = l.getDimens(this.mContext, R.dimen.ds32);
                textView.setText(R.string.person_tab_feedback_tips);
                textView.setOnClickListener(this.fUr);
                this.iay = new PopupWindow(inflate, -2, -2);
                this.mHandler.removeCallbacks(this.fUp);
                this.mHandler.postDelayed(this.fUp, 100L);
            }
        }
    }

    public void bWP() {
        this.mHandler.removeCallbacks(this.fUp);
        this.mHandler.removeCallbacks(this.fUq);
        brc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brc() {
        com.baidu.adp.lib.g.g.dismissPopupWindow(this.iay);
    }

    @Override // com.baidu.tieba.view.f
    public void setUserData(UserData userData) {
    }
}
