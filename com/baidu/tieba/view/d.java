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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.b.a;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class d implements f {
    private PopupWindow hSI;
    private RelativeLayout jAR;
    private ImageView jAS;
    public ImageView jAT;
    private RelativeLayout jAU;
    private ImageView jAV;
    public ImageView jAW;
    private View jAX;
    private ImageView jAY;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private int jAQ = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds28);
    private boolean jAZ = false;
    private Handler mHandler = new Handler();
    private Runnable fNo = new Runnable() { // from class: com.baidu.tieba.view.d.4
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.jAV;
            if (imageView != null) {
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(d.this.hSI, imageView);
                com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("show_person_tab_feedback_tips", true);
                d.this.jAZ = true;
                d.this.mHandler.postDelayed(d.this.fNp, 3000L);
            }
        }
    };
    private Runnable fNp = new Runnable() { // from class: com.baidu.tieba.view.d.5
        @Override // java.lang.Runnable
        public void run() {
            d.this.bqS();
        }
    };
    private View.OnClickListener fNq = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bVQ();
        }
    };

    public d(int i) {
        this.mFrom = i;
    }

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.jAR = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_dressup, (ViewGroup) null);
        this.jAS = (ImageView) this.jAR.findViewById(R.id.person_navigation_dressup_img);
        this.jAT = (ImageView) this.jAR.findViewById(R.id.person_navigation_dressup_red_tip);
        this.jAU = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_setting, (ViewGroup) null);
        this.jAV = (ImageView) this.jAU.findViewById(R.id.person_navigation_setting_img);
        this.jAW = (ImageView) this.jAU.findViewById(R.id.person_navigation_setting_red_tip);
        this.jAX = LayoutInflater.from(this.mContext).inflate(R.layout.item_person_host_navigation_scan, (ViewGroup) null);
        this.jAY = (ImageView) this.jAX.findViewById(R.id.person_navigation_scan_img);
    }

    @Override // com.baidu.tieba.view.f
    public void bZF() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.jAR != null && this.jAR.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jAR, (View.OnClickListener) null);
            }
            if (this.jAU != null && this.jAU.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jAU, (View.OnClickListener) null);
            }
            if (this.jAX != null && this.jAX.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.jAX, (View.OnClickListener) null);
            }
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(g gVar) {
        if (this.jAR != null) {
            this.jAR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new am("c12523").P("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new am("c12502").bT("obj_locate", "1"));
                    }
                    d.this.N(6, false);
                    com.baidu.tieba.o.a.cfX().d(6, false, true);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DressupCenterActivityConfig(d.this.mContext)));
                }
            });
        }
        if (this.jAU != null) {
            this.jAU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new am("c12523").P("obj_locate", 23));
                    } else {
                        TiebaStatic.log(new am("c12502").bT("obj_locate", "2"));
                    }
                    d.this.N(5, false);
                    TiebaStatic.log(new am("c12502").bT("obj_locate", "2"));
                    d.this.N(5, false);
                    com.baidu.tieba.o.a.cfX().d(5, false, true);
                    if (!TbadkCoreApplication.getInst().appResponseToCmd(2015004)) {
                        BdToast.b(d.this.mContext, d.this.mContext.getResources().getString(R.string.plugin_video_installing), 0).afO();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015004, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.jAX != null) {
            this.jAX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mContext instanceof Activity) {
                        Activity activity = (Activity) d.this.mContext;
                        if (d.this.mPermissionJudgement == null) {
                            d.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                        }
                        d.this.mPermissionJudgement.aiM();
                        d.this.mPermissionJudgement.e(activity, "android.permission.CAMERA");
                        d.this.mPermissionJudgement.a(new a.InterfaceC0241a() { // from class: com.baidu.tieba.view.d.3.1
                            @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0241a
                            public void aiN() {
                                TiebaStatic.log(new am("c12706"));
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new QRCodeScanActivityConfig(d.this.mContext)));
                            }
                        });
                        d.this.mPermissionJudgement.aa(activity);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.f
    public void N(int i, boolean z) {
        if (i == 5 && this.jAW != null) {
            this.jAW.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.jAT != null) {
            this.jAT.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.jAS != null) {
            if (2 == i) {
                al.a(this.jAS, (int) R.drawable.icon_person_dressup_s, (int) R.drawable.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                al.a(this.jAS, (int) R.drawable.icon_person_dressup, (int) R.drawable.icon_person_dressup);
            } else {
                al.a(this.jAS, (int) R.drawable.icon_person_dressup_s, (int) R.drawable.icon_person_dressup_s);
            }
            if (this.jAT != null) {
                al.c(this.jAT, (int) R.drawable.icon_news_down_bar_one);
            }
        }
        if (this.jAV != null) {
            if (2 == i) {
                al.a(this.jAV, (int) R.drawable.icon_home_setting_s, (int) R.drawable.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                al.a(this.jAV, (int) R.drawable.icon_home_setting_w, (int) R.drawable.icon_home_setting_w);
            } else {
                al.a(this.jAV, (int) R.drawable.icon_home_setting_s, (int) R.drawable.icon_home_setting_s);
            }
            if (this.jAW != null) {
                al.c(this.jAW, (int) R.drawable.icon_news_down_bar_one);
            }
        }
        al.c(this.jAY, (int) R.drawable.selector_top_bar_scan);
    }

    @Override // com.baidu.tieba.view.f
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.jAS != null) {
                al.a(this.jAS, (int) R.drawable.icon_person_dressup_s, (int) R.drawable.icon_person_dressup_s);
            }
            if (this.jAV != null) {
                al.a(this.jAV, (int) R.drawable.icon_home_setting_s, (int) R.drawable.icon_home_setting_s);
            }
        } else {
            if (this.jAS != null) {
                al.a(this.jAS, (int) R.drawable.icon_person_dressup, (int) R.drawable.icon_person_dressup);
            }
            if (this.jAV != null) {
                al.a(this.jAV, (int) R.drawable.icon_home_setting_w, (int) R.drawable.icon_home_setting_w);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.jAS != null) {
                this.jAS.setAlpha(f2);
            }
            if (this.jAV != null) {
                this.jAV.setAlpha(f2);
            }
        }
    }

    public void cae() {
        if (!this.jAZ) {
            this.jAZ = com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("show_person_tab_feedback_tips", false);
            if (!this.jAZ) {
                View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(R.id.arrow_up);
                TextView textView = (TextView) inflate.findViewById(R.id.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = l.g(this.mContext, R.dimen.ds32);
                textView.setText(R.string.person_tab_feedback_tips);
                textView.setOnClickListener(this.fNq);
                this.hSI = new PopupWindow(inflate, -2, -2);
                this.mHandler.removeCallbacks(this.fNo);
                this.mHandler.postDelayed(this.fNo, 100L);
            }
        }
    }

    public void bVQ() {
        this.mHandler.removeCallbacks(this.fNo);
        this.mHandler.removeCallbacks(this.fNp);
        bqS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqS() {
        com.baidu.adp.lib.g.g.a(this.hSI);
    }

    @Override // com.baidu.tieba.view.f
    public void setUserData(UserData userData) {
    }
}
