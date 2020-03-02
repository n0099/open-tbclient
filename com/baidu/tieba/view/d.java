package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.b.a;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes9.dex */
public class d {
    private PopupWindow iTW;
    private ImageView kIA;
    private RelativeLayout kIt;
    private ImageView kIu;
    public ImageView kIv;
    private RelativeLayout kIw;
    private ImageView kIx;
    public ImageView kIy;
    private View kIz;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private int kIs = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds28);
    private boolean kIB = false;
    private Handler mHandler = new Handler();
    private Runnable gNl = new Runnable() { // from class: com.baidu.tieba.view.d.4
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.kIx;
            if (imageView != null) {
                com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(d.this.iTW, imageView);
                com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.SHOW_PERSON_TAB_FEEDBACK_TIPS, true);
                d.this.kIB = true;
                d.this.mHandler.postDelayed(d.this.gNm, 3000L);
            }
        }
    };
    private Runnable gNm = new Runnable() { // from class: com.baidu.tieba.view.d.5
        @Override // java.lang.Runnable
        public void run() {
            d.this.bLg();
        }
    };
    private View.OnClickListener gNn = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.crh();
        }
    };

    public d(int i) {
        this.mFrom = i;
    }

    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.kIt = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_dressup, (ViewGroup) null);
        this.kIu = (ImageView) this.kIt.findViewById(R.id.person_navigation_dressup_img);
        this.kIv = (ImageView) this.kIt.findViewById(R.id.person_navigation_dressup_red_tip);
        this.kIw = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_setting, (ViewGroup) null);
        this.kIx = (ImageView) this.kIw.findViewById(R.id.person_navigation_setting_img);
        this.kIy = (ImageView) this.kIw.findViewById(R.id.person_navigation_setting_red_tip);
        this.kIz = LayoutInflater.from(this.mContext).inflate(R.layout.item_person_host_navigation_scan, (ViewGroup) null);
        this.kIA = (ImageView) this.kIz.findViewById(R.id.person_navigation_scan_img);
    }

    public void cTw() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.kIt != null && this.kIt.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.kIt, (View.OnClickListener) null);
            }
            if (this.kIw != null && this.kIw.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.kIw, (View.OnClickListener) null);
            }
            if (this.kIz != null && this.kIz.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.kIz, (View.OnClickListener) null);
            }
        }
    }

    public void setOnViewResponseListener(e eVar) {
        if (this.kIt != null) {
            this.kIt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new an("c12523").X("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new an("c12502").cy("obj_locate", "1"));
                    }
                    d.this.P(6, false);
                    com.baidu.tieba.p.a.cDP().g(6, false, true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(d.this.mContext)));
                }
            });
        }
        if (this.kIw != null) {
            this.kIw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new an("c12523").X("obj_locate", 23));
                    } else {
                        TiebaStatic.log(new an("c12502").cy("obj_locate", "2"));
                    }
                    d.this.P(5, false);
                    TiebaStatic.log(new an("c12502").cy("obj_locate", "2"));
                    d.this.P(5, false);
                    com.baidu.tieba.p.a.cDP().g(5, false, true);
                    if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
                        BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(R.string.plugin_video_installing), 0).aEH();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MORE, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.kIz != null) {
            this.kIz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mContext instanceof Activity) {
                        Activity activity = (Activity) d.this.mContext;
                        if (d.this.mPermissionJudgement == null) {
                            d.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                        }
                        d.this.mPermissionJudgement.clearRequestPermissionList();
                        d.this.mPermissionJudgement.appendRequestPermission(activity, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
                        d.this.mPermissionJudgement.a(new a.InterfaceC0378a() { // from class: com.baidu.tieba.view.d.3.1
                            @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0378a
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

    public void P(int i, boolean z) {
        if (i == 5 && this.kIy != null) {
            this.kIy.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.kIv != null) {
            this.kIv.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kIu != null) {
            if (2 == i) {
                SvgManager.aGC().a(this.kIu, R.drawable.icon_pure_topbar_store44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                SvgManager.aGC().a(this.kIu, R.drawable.icon_pure_topbar_store44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aGC().a(this.kIu, R.drawable.icon_pure_topbar_store44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.kIv != null) {
                am.setImageResource(this.kIv, R.drawable.icon_news_down_bar_one);
            }
        }
        if (this.kIx != null) {
            if (2 == i) {
                SvgManager.aGC().a(this.kIx, R.drawable.icon_pure_topbar_set44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                SvgManager.aGC().a(this.kIx, R.drawable.icon_pure_topbar_set44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aGC().a(this.kIx, R.drawable.icon_pure_topbar_set44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.kIy != null) {
                am.setImageResource(this.kIy, R.drawable.icon_news_down_bar_one);
            }
        }
        SvgManager.aGC().a(this.kIA, R.drawable.icon_pure_topbar_scan44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void crh() {
        this.mHandler.removeCallbacks(this.gNl);
        this.mHandler.removeCallbacks(this.gNm);
        bLg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLg() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.iTW);
    }
}
