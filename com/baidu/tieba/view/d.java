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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes9.dex */
public class d {
    private PopupWindow ksC;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private PermissionJudgePolicy mPermissionJudgement;
    private RelativeLayout mir;
    private ImageView mis;
    public ImageView mit;
    private RelativeLayout miu;
    private ImageView miv;
    public ImageView miw;
    private View mix;
    private ImageView miy;
    private int miq = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds28);
    private boolean miz = false;
    private Handler mHandler = new Handler();
    private Runnable ibv = new Runnable() { // from class: com.baidu.tieba.view.d.4
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.miv;
            if (imageView != null) {
                com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(d.this.ksC, imageView);
                com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.SHOW_PERSON_TAB_FEEDBACK_TIPS, true);
                d.this.miz = true;
                d.this.mHandler.postDelayed(d.this.ibw, 3000L);
            }
        }
    };
    private Runnable ibw = new Runnable() { // from class: com.baidu.tieba.view.d.5
        @Override // java.lang.Runnable
        public void run() {
            d.this.cga();
        }
    };
    private View.OnClickListener ibx = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.cNM();
        }
    };

    public d(int i) {
        this.mFrom = i;
    }

    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.mir = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_dressup, (ViewGroup) null);
        this.mis = (ImageView) this.mir.findViewById(R.id.person_navigation_dressup_img);
        this.mit = (ImageView) this.mir.findViewById(R.id.person_navigation_dressup_red_tip);
        this.miu = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_setting, (ViewGroup) null);
        this.miv = (ImageView) this.miu.findViewById(R.id.person_navigation_setting_img);
        this.miw = (ImageView) this.miu.findViewById(R.id.person_navigation_setting_red_tip);
        this.mix = LayoutInflater.from(this.mContext).inflate(R.layout.item_person_host_navigation_scan, (ViewGroup) null);
        this.miy = (ImageView) this.mix.findViewById(R.id.person_navigation_scan_img);
    }

    public void dqz() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.mir != null && this.mir.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mir, (View.OnClickListener) null);
            }
            if (this.miu != null && this.miu.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.miu, (View.OnClickListener) null);
            }
            if (this.mix != null && this.mix.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mix, (View.OnClickListener) null);
            }
        }
    }

    public void setOnViewResponseListener(f fVar) {
        if (this.mir != null) {
            this.mir.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new ao("c12523").ag("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new ao("c12502").dk("obj_locate", "1"));
                    }
                    d.this.ac(6, false);
                    com.baidu.tieba.p.a.dar().g(6, false, true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(d.this.mContext)));
                }
            });
        }
        if (this.miu != null) {
            this.miu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new ao("c12523").ag("obj_locate", 23));
                    } else {
                        TiebaStatic.log(new ao("c12502").dk("obj_locate", "2"));
                    }
                    d.this.ac(5, false);
                    TiebaStatic.log(new ao("c12502").dk("obj_locate", "2"));
                    d.this.ac(5, false);
                    com.baidu.tieba.p.a.dar().g(5, false, true);
                    if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
                        BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(R.string.plugin_video_installing), 0).aUS();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MORE, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.mix != null) {
            this.mix.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.3
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
                                TiebaStatic.log(new ao("c12706"));
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new QRCodeScanActivityConfig(d.this.mContext)));
                            }
                        });
                        d.this.mPermissionJudgement.startRequestPermission(activity);
                    }
                }
            });
        }
    }

    public void ac(int i, boolean z) {
        if (i == 5 && this.miw != null) {
            this.miw.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.mit != null) {
            this.mit.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mis != null) {
            if (2 == i) {
                SvgManager.aWQ().a(this.mis, R.drawable.icon_pure_topbar_store44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                SvgManager.aWQ().a(this.mis, R.drawable.icon_pure_topbar_store44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aWQ().a(this.mis, R.drawable.icon_pure_topbar_store44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.mit != null) {
                an.setImageResource(this.mit, R.drawable.icon_news_down_bar_one);
            }
        }
        if (this.miv != null) {
            if (2 == i) {
                SvgManager.aWQ().a(this.miv, R.drawable.icon_pure_topbar_set44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                SvgManager.aWQ().a(this.miv, R.drawable.icon_pure_topbar_set44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aWQ().a(this.miv, R.drawable.icon_pure_topbar_set44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.miw != null) {
                an.setImageResource(this.miw, R.drawable.icon_news_down_bar_one);
            }
        }
        SvgManager.aWQ().a(this.miy, R.drawable.icon_pure_topbar_scan44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void cNM() {
        this.mHandler.removeCallbacks(this.ibv);
        this.mHandler.removeCallbacks(this.ibw);
        cga();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cga() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.ksC);
    }
}
