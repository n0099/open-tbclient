package com.baidu.tieba.view;

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
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class d implements f {
    private PopupWindow fte;
    private RelativeLayout gXl;
    private ImageView gXm;
    public ImageView gXn;
    private RelativeLayout gXo;
    private ImageView gXp;
    public ImageView gXq;
    private ImageView gXr;
    private View gXs;
    private ImageView gXt;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private int gXk = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds28);
    private boolean gXu = false;
    private Handler mHandler = new Handler();
    private Runnable ftk = new Runnable() { // from class: com.baidu.tieba.view.d.5
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.gXp;
            if (imageView != null) {
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(d.this.fte, imageView);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_person_tab_feedback_tips", true);
                d.this.gXu = true;
                d.this.mHandler.postDelayed(d.this.ftl, 3000L);
            }
        }
    };
    private Runnable ftl = new Runnable() { // from class: com.baidu.tieba.view.d.6
        @Override // java.lang.Runnable
        public void run() {
            d.this.bbn();
        }
    };
    private View.OnClickListener ftm = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            d.this.bbm();
        }
    };

    public d(int i) {
        this.mFrom = i;
    }

    @Override // com.baidu.tieba.view.f
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.gXl = (RelativeLayout) LayoutInflater.from(context).inflate(d.i.item_person_host_navigation_dressup, (ViewGroup) null);
        this.gXm = (ImageView) this.gXl.findViewById(d.g.person_navigation_dressup_img);
        this.gXn = (ImageView) this.gXl.findViewById(d.g.person_navigation_dressup_red_tip);
        this.gXo = (RelativeLayout) LayoutInflater.from(context).inflate(d.i.item_person_host_navigation_setting, (ViewGroup) null);
        this.gXp = (ImageView) this.gXo.findViewById(d.g.person_navigation_setting_img);
        this.gXq = (ImageView) this.gXo.findViewById(d.g.person_navigation_setting_red_tip);
        if (this.gXr == null) {
            this.gXr = new ImageView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, this.gXk, 0);
            this.gXr.setLayoutParams(layoutParams);
            this.gXr.setScaleType(ImageView.ScaleType.CENTER);
        }
        this.gXs = LayoutInflater.from(this.mContext).inflate(d.i.item_person_host_navigation_scan, (ViewGroup) null);
        this.gXt = (ImageView) this.gXs.findViewById(d.g.person_navigation_scan_img);
    }

    @Override // com.baidu.tieba.view.f
    public void beP() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.gXl != null && this.gXl.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gXl, (View.OnClickListener) null);
            }
            if (this.gXo != null && this.gXo.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gXo, (View.OnClickListener) null);
            }
            if (this.gXs != null && this.gXs.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.gXs, (View.OnClickListener) null);
            }
        } else if (this.gXr != null && this.gXr.getParent() == null) {
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gXr, (View.OnClickListener) null);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(g gVar) {
        if (this.gXl != null) {
            this.gXl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new al("c12523").r("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new al("c12502").ac("obj_locate", "1"));
                    }
                    d.this.C(6, false);
                    com.baidu.tieba.n.a.bkt().b(6, false, true);
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DressupCenterActivityConfig(d.this.mContext)));
                        return;
                    }
                    BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(d.k.plugin_video_installing), 0).tL();
                }
            });
        }
        if (this.gXo != null) {
            this.gXo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new al("c12523").r("obj_locate", 23));
                    } else {
                        TiebaStatic.log(new al("c12502").ac("obj_locate", "2"));
                    }
                    d.this.C(5, false);
                    TiebaStatic.log(new al("c12502").ac("obj_locate", "2"));
                    d.this.C(5, false);
                    com.baidu.tieba.n.a.bkt().b(5, false, true);
                    if (!TbadkCoreApplication.getInst().appResponseToCmd(2015004)) {
                        BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(d.k.plugin_video_installing), 0).tL();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015004, new IntentConfig(view2.getContext())));
                }
            });
        }
        if (this.gXr != null) {
            this.gXr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016559));
                }
            });
        }
        if (this.gXs != null) {
            this.gXs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.log(new al("c12706"));
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(QRCodeScanActivityConfig.class)) {
                        BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(d.k.plugin_video_installing), 0).tL();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new QRCodeScanActivityConfig(d.this.mContext)));
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.f
    public void C(int i, boolean z) {
        if (i == 5 && this.gXq != null) {
            this.gXq.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.gXn != null) {
            this.gXn.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.gXm != null) {
            if (2 == i) {
                ak.a(this.gXm, d.f.icon_person_dressup_s, d.f.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                ak.a(this.gXm, d.f.icon_person_dressup, d.f.icon_person_dressup);
            } else {
                ak.a(this.gXm, d.f.icon_person_dressup_s, d.f.icon_person_dressup_s);
            }
            if (this.gXn != null) {
                ak.c(this.gXn, d.f.icon_news_down_bar_one);
            }
        }
        if (this.gXp != null) {
            if (2 == i) {
                ak.a(this.gXp, d.f.icon_home_setting_s, d.f.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                ak.a(this.gXp, d.f.icon_home_setting_w, d.f.icon_home_setting_w);
            } else {
                ak.a(this.gXp, d.f.icon_home_setting_s, d.f.icon_home_setting_s);
            }
            if (this.gXq != null) {
                ak.c(this.gXq, d.f.icon_news_down_bar_one);
            }
        }
        if (this.gXr != null) {
            if (2 == i) {
                ak.a(this.gXr, d.f.icon_person_editor, d.f.icon_person_editor_s);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                ak.a(this.gXr, d.f.icon_person_editor_s, d.f.icon_person_editor_s);
            } else {
                ak.a(this.gXr, d.f.icon_person_editor, d.f.icon_person_editor);
            }
        }
        ak.c(this.gXt, d.f.selector_top_bar_scan);
    }

    @Override // com.baidu.tieba.view.f
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.gXm != null) {
                ak.a(this.gXm, d.f.icon_person_dressup_s, d.f.icon_person_dressup_s);
            }
            if (this.gXp != null) {
                ak.a(this.gXp, d.f.icon_home_setting_s, d.f.icon_home_setting_s);
            }
            if (this.gXr != null) {
                ak.a(this.gXr, d.f.icon_person_editor, d.f.icon_person_editor);
            }
        } else {
            if (this.gXm != null) {
                ak.a(this.gXm, d.f.icon_person_dressup, d.f.icon_person_dressup);
            }
            if (this.gXp != null) {
                ak.a(this.gXp, d.f.icon_home_setting_w, d.f.icon_home_setting_w);
            }
            if (this.gXr != null) {
                ak.a(this.gXr, d.f.icon_person_editor_s, d.f.icon_person_editor_s);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.gXm != null) {
                this.gXm.setAlpha(f2);
            }
            if (this.gXp != null) {
                this.gXp.setAlpha(f2);
            }
            if (this.gXr != null) {
                this.gXr.setAlpha(f2);
            }
        }
    }

    public void bft() {
        if (!this.gXu) {
            this.gXu = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_person_tab_feedback_tips", false);
            if (!this.gXu) {
                View inflate = LayoutInflater.from(this.mContext).inflate(d.i.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(d.g.arrow_up);
                TextView textView = (TextView) inflate.findViewById(d.g.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = l.e(this.mContext, d.e.ds32);
                textView.setText(d.k.person_tab_feedback_tips);
                textView.setOnClickListener(this.ftm);
                this.fte = new PopupWindow(inflate, -2, -2);
                this.mHandler.removeCallbacks(this.ftk);
                this.mHandler.postDelayed(this.ftk, 100L);
            }
        }
    }

    public void bbm() {
        this.mHandler.removeCallbacks(this.ftk);
        this.mHandler.removeCallbacks(this.ftl);
        bbn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbn() {
        com.baidu.adp.lib.g.g.a(this.fte);
    }

    @Override // com.baidu.tieba.view.f
    public void e(UserData userData) {
    }
}
