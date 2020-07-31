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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes16.dex */
public class d {
    private PopupWindow kBq;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private PermissionJudgePolicy mPermissionJudgement;
    private RelativeLayout mqp;
    private ImageView mqq;
    public ImageView mqr;
    private RelativeLayout mqs;
    private ImageView mqt;
    public ImageView mqu;
    private View mqv;
    private ImageView mqw;
    private int mqo = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds28);
    private boolean mqx = false;
    private Handler mHandler = new Handler();
    private Runnable ihx = new Runnable() { // from class: com.baidu.tieba.view.d.4
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.mqt;
            if (imageView != null) {
                com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(d.this.kBq, imageView);
                com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.SHOW_PERSON_TAB_FEEDBACK_TIPS, true);
                d.this.mqx = true;
                d.this.mHandler.postDelayed(d.this.ihy, 3000L);
            }
        }
    };
    private Runnable ihy = new Runnable() { // from class: com.baidu.tieba.view.d.5
        @Override // java.lang.Runnable
        public void run() {
            d.this.cjz();
        }
    };
    private View.OnClickListener ihz = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.cRz();
        }
    };

    public d(int i) {
        this.mFrom = i;
    }

    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.mqp = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_dressup, (ViewGroup) null);
        this.mqq = (ImageView) this.mqp.findViewById(R.id.person_navigation_dressup_img);
        this.mqr = (ImageView) this.mqp.findViewById(R.id.person_navigation_dressup_red_tip);
        this.mqs = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_setting, (ViewGroup) null);
        this.mqt = (ImageView) this.mqs.findViewById(R.id.person_navigation_setting_img);
        this.mqu = (ImageView) this.mqs.findViewById(R.id.person_navigation_setting_red_tip);
        this.mqv = LayoutInflater.from(this.mContext).inflate(R.layout.item_person_host_navigation_scan, (ViewGroup) null);
        this.mqw = (ImageView) this.mqv.findViewById(R.id.person_navigation_scan_img);
    }

    public void dtL() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.mqp != null && this.mqp.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mqp, (View.OnClickListener) null);
            }
            if (this.mqs != null && this.mqs.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mqs, (View.OnClickListener) null);
            }
            if (this.mqv != null && this.mqv.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mqv, (View.OnClickListener) null);
            }
        }
    }

    public void setOnViewResponseListener(f fVar) {
        if (this.mqp != null) {
            this.mqp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new ap("c12523").ah("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new ap("c12502").dn("obj_locate", "1"));
                    }
                    d.this.ab(6, false);
                    com.baidu.tieba.p.a.ddy().g(6, false, true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(d.this.mContext)));
                }
            });
        }
        if (this.mqs != null) {
            this.mqs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new ap("c12523").ah("obj_locate", 23));
                    } else {
                        TiebaStatic.log(new ap("c12502").dn("obj_locate", "2"));
                    }
                    d.this.ab(5, false);
                    TiebaStatic.log(new ap("c12502").dn("obj_locate", "2"));
                    d.this.ab(5, false);
                    com.baidu.tieba.p.a.ddy().g(5, false, true);
                    if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
                        BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(R.string.plugin_video_installing), 0).aYR();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MORE, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.mqv != null) {
            this.mqv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.3
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
                                TiebaStatic.log(new ap("c12706"));
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new QRCodeScanActivityConfig(d.this.mContext)));
                            }
                        });
                        d.this.mPermissionJudgement.startRequestPermission(activity);
                    }
                }
            });
        }
    }

    public void ab(int i, boolean z) {
        if (i == 5 && this.mqu != null) {
            this.mqu.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.mqr != null) {
            this.mqr.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mqq != null) {
            if (2 == i) {
                SvgManager.baR().a(this.mqq, R.drawable.icon_pure_topbar_store44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                SvgManager.baR().a(this.mqq, R.drawable.icon_pure_topbar_store44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.baR().a(this.mqq, R.drawable.icon_pure_topbar_store44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.mqr != null) {
                ao.setImageResource(this.mqr, R.drawable.icon_news_down_bar_one);
            }
        }
        if (this.mqt != null) {
            if (2 == i) {
                SvgManager.baR().a(this.mqt, R.drawable.icon_pure_topbar_set44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                SvgManager.baR().a(this.mqt, R.drawable.icon_pure_topbar_set44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.baR().a(this.mqt, R.drawable.icon_pure_topbar_set44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.mqu != null) {
                ao.setImageResource(this.mqu, R.drawable.icon_news_down_bar_one);
            }
        }
        SvgManager.baR().a(this.mqw, R.drawable.icon_pure_topbar_scan44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void cRz() {
        this.mHandler.removeCallbacks(this.ihx);
        this.mHandler.removeCallbacks(this.ihy);
        cjz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjz() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.kBq);
    }
}
