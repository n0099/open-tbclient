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
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes2.dex */
public class d {
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private PermissionJudgePolicy mPermissionJudgement;
    private PopupWindow mfJ;
    private RelativeLayout nZi;
    private ImageView nZj;
    public ImageView nZk;
    private RelativeLayout nZl;
    private ImageView nZm;
    public ImageView nZn;
    private View nZo;
    private ImageView nZp;
    private int nZh = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds28);
    private boolean nZq = false;
    private Handler mHandler = new Handler();
    private Runnable jMq = new Runnable() { // from class: com.baidu.tieba.view.d.4
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.nZm;
            if (imageView != null) {
                com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(d.this.mfJ, imageView);
                com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.SHOW_PERSON_TAB_FEEDBACK_TIPS, true);
                d.this.nZq = true;
                d.this.mHandler.postDelayed(d.this.jMr, IMConnection.RETRY_DELAY_TIMES);
            }
        }
    };
    private Runnable jMr = new Runnable() { // from class: com.baidu.tieba.view.d.5
        @Override // java.lang.Runnable
        public void run() {
            d.this.cMe();
        }
    };
    private View.OnClickListener jMs = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dsy();
        }
    };

    public d(int i) {
        this.mFrom = i;
    }

    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.nZi = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_dressup, (ViewGroup) null);
        this.nZj = (ImageView) this.nZi.findViewById(R.id.person_navigation_dressup_img);
        this.nZk = (ImageView) this.nZi.findViewById(R.id.person_navigation_dressup_red_tip);
        this.nZl = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_setting, (ViewGroup) null);
        this.nZm = (ImageView) this.nZl.findViewById(R.id.person_navigation_setting_img);
        this.nZn = (ImageView) this.nZl.findViewById(R.id.person_navigation_setting_red_tip);
        this.nZo = LayoutInflater.from(this.mContext).inflate(R.layout.item_person_host_navigation_scan, (ViewGroup) null);
        this.nZp = (ImageView) this.nZo.findViewById(R.id.person_navigation_scan_img);
    }

    public void dWi() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.nZi != null && this.nZi.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.nZi, (View.OnClickListener) null);
            }
            if (this.nZl != null && this.nZl.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.nZl, (View.OnClickListener) null);
            }
            if (this.nZo != null && this.nZo.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.nZo, (View.OnClickListener) null);
            }
        }
    }

    public void setOnViewResponseListener(f fVar) {
        if (this.nZi != null) {
            this.nZi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new ar("c12523").ap("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new ar("c12502").dR("obj_locate", "1"));
                    }
                    d.this.ae(6, false);
                    com.baidu.tieba.p.a.dFe().h(6, false, true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(d.this.mContext)));
                }
            });
        }
        if (this.nZl != null) {
            this.nZl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new ar("c12523").ap("obj_locate", 23));
                    } else {
                        TiebaStatic.log(new ar("c12502").dR("obj_locate", "2"));
                    }
                    d.this.ae(5, false);
                    TiebaStatic.log(new ar("c12502").dR("obj_locate", "2"));
                    d.this.ae(5, false);
                    com.baidu.tieba.p.a.dFe().h(5, false, true);
                    if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
                        BdToast.b(d.this.mContext, d.this.mContext.getResources().getString(R.string.plugin_video_installing), 0).bqD();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MORE, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.nZo != null) {
            this.nZo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mContext instanceof Activity) {
                        Activity activity = (Activity) d.this.mContext;
                        if (d.this.mPermissionJudgement == null) {
                            d.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        d.this.mPermissionJudgement.clearRequestPermissionList();
                        d.this.mPermissionJudgement.appendRequestPermission(activity, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
                        d.this.mPermissionJudgement.a(new PermissionJudgePolicy.b() { // from class: com.baidu.tieba.view.d.3.1
                            @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.b
                            public void onPermissionsGranted() {
                                TiebaStatic.log(new ar("c12706"));
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new QRCodeScanActivityConfig(d.this.mContext)));
                            }
                        });
                        d.this.mPermissionJudgement.startRequestPermission(activity);
                    }
                }
            });
        }
    }

    public void ae(int i, boolean z) {
        if (i == 5 && this.nZn != null) {
            this.nZn.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.nZk != null) {
            this.nZk.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.nZj != null) {
            if (2 == i) {
                SvgManager.bsR().a(this.nZj, R.drawable.icon_pure_topbar_store44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                SvgManager.bsR().a(this.nZj, R.drawable.icon_pure_topbar_store44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.bsR().a(this.nZj, R.drawable.icon_pure_topbar_store44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.nZk != null) {
                ap.setImageResource(this.nZk, R.drawable.icon_news_down_bar_one);
            }
        }
        if (this.nZm != null) {
            if (2 == i) {
                SvgManager.bsR().a(this.nZm, R.drawable.icon_pure_topbar_set44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                SvgManager.bsR().a(this.nZm, R.drawable.icon_pure_topbar_set44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.bsR().a(this.nZm, R.drawable.icon_pure_topbar_set44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.nZn != null) {
                ap.setImageResource(this.nZn, R.drawable.icon_news_down_bar_one);
            }
        }
        SvgManager.bsR().a(this.nZp, R.drawable.icon_pure_topbar_scan44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void dsy() {
        this.mHandler.removeCallbacks(this.jMq);
        this.mHandler.removeCallbacks(this.jMr);
        cMe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMe() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.mfJ);
    }
}
