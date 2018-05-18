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
    private PopupWindow ful;
    private RelativeLayout gYp;
    private ImageView gYq;
    public ImageView gYr;
    private RelativeLayout gYs;
    private ImageView gYt;
    public ImageView gYu;
    private ImageView gYv;
    private View gYw;
    private ImageView gYx;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private int gYo = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds28);
    private boolean gYy = false;
    private Handler mHandler = new Handler();
    private Runnable fur = new Runnable() { // from class: com.baidu.tieba.view.d.5
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.gYt;
            if (imageView != null) {
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(d.this.ful, imageView);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_person_tab_feedback_tips", true);
                d.this.gYy = true;
                d.this.mHandler.postDelayed(d.this.fus, 3000L);
            }
        }
    };
    private Runnable fus = new Runnable() { // from class: com.baidu.tieba.view.d.6
        @Override // java.lang.Runnable
        public void run() {
            d.this.bbn();
        }
    };
    private View.OnClickListener fut = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.7
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
        this.gYp = (RelativeLayout) LayoutInflater.from(context).inflate(d.i.item_person_host_navigation_dressup, (ViewGroup) null);
        this.gYq = (ImageView) this.gYp.findViewById(d.g.person_navigation_dressup_img);
        this.gYr = (ImageView) this.gYp.findViewById(d.g.person_navigation_dressup_red_tip);
        this.gYs = (RelativeLayout) LayoutInflater.from(context).inflate(d.i.item_person_host_navigation_setting, (ViewGroup) null);
        this.gYt = (ImageView) this.gYs.findViewById(d.g.person_navigation_setting_img);
        this.gYu = (ImageView) this.gYs.findViewById(d.g.person_navigation_setting_red_tip);
        if (this.gYv == null) {
            this.gYv = new ImageView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, this.gYo, 0);
            this.gYv.setLayoutParams(layoutParams);
            this.gYv.setScaleType(ImageView.ScaleType.CENTER);
        }
        this.gYw = LayoutInflater.from(this.mContext).inflate(d.i.item_person_host_navigation_scan, (ViewGroup) null);
        this.gYx = (ImageView) this.gYw.findViewById(d.g.person_navigation_scan_img);
    }

    @Override // com.baidu.tieba.view.f
    public void beP() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.gYp != null && this.gYp.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gYp, (View.OnClickListener) null);
            }
            if (this.gYs != null && this.gYs.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gYs, (View.OnClickListener) null);
            }
            if (this.gYw != null && this.gYw.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.gYw, (View.OnClickListener) null);
            }
        } else if (this.gYv != null && this.gYv.getParent() == null) {
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gYv, (View.OnClickListener) null);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void setOnViewResponseListener(g gVar) {
        if (this.gYp != null) {
            this.gYp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new al("c12523").r("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new al("c12502").ac("obj_locate", "1"));
                    }
                    d.this.C(6, false);
                    com.baidu.tieba.n.a.bks().b(6, false, true);
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DressupCenterActivityConfig(d.this.mContext)));
                        return;
                    }
                    BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(d.k.plugin_video_installing), 0).tK();
                }
            });
        }
        if (this.gYs != null) {
            this.gYs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
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
                    com.baidu.tieba.n.a.bks().b(5, false, true);
                    if (!TbadkCoreApplication.getInst().appResponseToCmd(2015004)) {
                        BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(d.k.plugin_video_installing), 0).tK();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015004, new IntentConfig(view2.getContext())));
                }
            });
        }
        if (this.gYv != null) {
            this.gYv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016559));
                }
            });
        }
        if (this.gYw != null) {
            this.gYw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.log(new al("c12706"));
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(QRCodeScanActivityConfig.class)) {
                        BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(d.k.plugin_video_installing), 0).tK();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new QRCodeScanActivityConfig(d.this.mContext)));
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.f
    public void C(int i, boolean z) {
        if (i == 5 && this.gYu != null) {
            this.gYu.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.gYr != null) {
            this.gYr.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.f
    public void onChangeSkinType(int i) {
        if (this.gYq != null) {
            if (2 == i) {
                ak.a(this.gYq, d.f.icon_person_dressup_s, d.f.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                ak.a(this.gYq, d.f.icon_person_dressup, d.f.icon_person_dressup);
            } else {
                ak.a(this.gYq, d.f.icon_person_dressup_s, d.f.icon_person_dressup_s);
            }
            if (this.gYr != null) {
                ak.c(this.gYr, d.f.icon_news_down_bar_one);
            }
        }
        if (this.gYt != null) {
            if (2 == i) {
                ak.a(this.gYt, d.f.icon_home_setting_s, d.f.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                ak.a(this.gYt, d.f.icon_home_setting_w, d.f.icon_home_setting_w);
            } else {
                ak.a(this.gYt, d.f.icon_home_setting_s, d.f.icon_home_setting_s);
            }
            if (this.gYu != null) {
                ak.c(this.gYu, d.f.icon_news_down_bar_one);
            }
        }
        if (this.gYv != null) {
            if (2 == i) {
                ak.a(this.gYv, d.f.icon_person_editor, d.f.icon_person_editor_s);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                ak.a(this.gYv, d.f.icon_person_editor_s, d.f.icon_person_editor_s);
            } else {
                ak.a(this.gYv, d.f.icon_person_editor, d.f.icon_person_editor);
            }
        }
        ak.c(this.gYx, d.f.selector_top_bar_scan);
    }

    @Override // com.baidu.tieba.view.f
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.gYq != null) {
                ak.a(this.gYq, d.f.icon_person_dressup_s, d.f.icon_person_dressup_s);
            }
            if (this.gYt != null) {
                ak.a(this.gYt, d.f.icon_home_setting_s, d.f.icon_home_setting_s);
            }
            if (this.gYv != null) {
                ak.a(this.gYv, d.f.icon_person_editor, d.f.icon_person_editor);
            }
        } else {
            if (this.gYq != null) {
                ak.a(this.gYq, d.f.icon_person_dressup, d.f.icon_person_dressup);
            }
            if (this.gYt != null) {
                ak.a(this.gYt, d.f.icon_home_setting_w, d.f.icon_home_setting_w);
            }
            if (this.gYv != null) {
                ak.a(this.gYv, d.f.icon_person_editor_s, d.f.icon_person_editor_s);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.gYq != null) {
                this.gYq.setAlpha(f2);
            }
            if (this.gYt != null) {
                this.gYt.setAlpha(f2);
            }
            if (this.gYv != null) {
                this.gYv.setAlpha(f2);
            }
        }
    }

    public void bft() {
        if (!this.gYy) {
            this.gYy = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_person_tab_feedback_tips", false);
            if (!this.gYy) {
                View inflate = LayoutInflater.from(this.mContext).inflate(d.i.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(d.g.arrow_up);
                TextView textView = (TextView) inflate.findViewById(d.g.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = l.e(this.mContext, d.e.ds32);
                textView.setText(d.k.person_tab_feedback_tips);
                textView.setOnClickListener(this.fut);
                this.ful = new PopupWindow(inflate, -2, -2);
                this.mHandler.removeCallbacks(this.fur);
                this.mHandler.postDelayed(this.fur, 100L);
            }
        }
    }

    public void bbm() {
        this.mHandler.removeCallbacks(this.fur);
        this.mHandler.removeCallbacks(this.fus);
        bbn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbn() {
        com.baidu.adp.lib.g.g.a(this.ful);
    }

    @Override // com.baidu.tieba.view.f
    public void e(UserData userData) {
    }
}
