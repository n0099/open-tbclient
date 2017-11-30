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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e implements g {
    private PopupWindow ffQ;
    private RelativeLayout gYn;
    private ImageView gYo;
    public ImageView gYp;
    private RelativeLayout gYq;
    private ImageView gYr;
    public ImageView gYs;
    private ImageView gYt;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private int gYm = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds28);
    private boolean gYu = false;
    private Handler mHandler = new Handler();
    private Runnable ffU = new Runnable() { // from class: com.baidu.tieba.view.e.4
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = e.this.gYr;
            if (imageView != null) {
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(e.this.ffQ, imageView);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_person_tab_feedback_tips", true);
                e.this.gYu = true;
                e.this.mHandler.postDelayed(e.this.ffV, 3000L);
            }
        }
    };
    private Runnable ffV = new Runnable() { // from class: com.baidu.tieba.view.e.5
        @Override // java.lang.Runnable
        public void run() {
            e.this.aXi();
        }
    };
    private View.OnClickListener ffW = new View.OnClickListener() { // from class: com.baidu.tieba.view.e.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.aXh();
        }
    };

    public e(int i) {
        this.mFrom = i;
    }

    @Override // com.baidu.tieba.view.g
    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
            this.gYn = (RelativeLayout) LayoutInflater.from(context).inflate(d.h.item_person_host_navigation_dressup, (ViewGroup) null);
            this.gYo = (ImageView) this.gYn.findViewById(d.g.person_navigation_dressup_img);
            this.gYp = (ImageView) this.gYn.findViewById(d.g.person_navigation_dressup_red_tip);
        }
        if (TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
            this.gYq = (RelativeLayout) LayoutInflater.from(context).inflate(d.h.item_person_host_navigation_setting, (ViewGroup) null);
            this.gYr = (ImageView) this.gYq.findViewById(d.g.person_navigation_setting_img);
            this.gYs = (ImageView) this.gYq.findViewById(d.g.person_navigation_setting_red_tip);
        }
        if (this.gYt == null) {
            this.gYt = new ImageView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, this.gYm, 0);
            this.gYt.setLayoutParams(layoutParams);
            this.gYt.setScaleType(ImageView.ScaleType.CENTER);
        }
    }

    @Override // com.baidu.tieba.view.g
    public void bba() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.gYn != null && this.gYn.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gYn, (View.OnClickListener) null);
            }
            if (this.gYq != null && this.gYq.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gYq, (View.OnClickListener) null);
            }
        } else if (this.gYt != null && this.gYt.getParent() == null) {
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gYt, (View.OnClickListener) null);
        }
    }

    @Override // com.baidu.tieba.view.g
    public void setOnViewResponseListener(h hVar) {
        if (this.gYn != null) {
            this.gYn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.mFrom == 1) {
                        TiebaStatic.log(new ak("c12523").r("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new ak("c12502").ac("obj_locate", "1"));
                    }
                    e.this.z(6, false);
                    com.baidu.tieba.m.a.bmh().c(6, false, true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(e.this.mContext)));
                }
            });
        }
        if (this.gYq != null) {
            this.gYq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.mFrom == 1) {
                        TiebaStatic.log(new ak("c12523").r("obj_locate", 23));
                    } else {
                        TiebaStatic.log(new ak("c12502").ac("obj_locate", "2"));
                    }
                    e.this.z(5, false);
                    TiebaStatic.log(new ak("c12502").ac("obj_locate", "2"));
                    e.this.z(5, false);
                    com.baidu.tieba.m.a.bmh().c(5, false, true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MORE, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.gYt != null) {
            this.gYt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_SHOW_WRITE_TAB));
                }
            });
        }
    }

    @Override // com.baidu.tieba.view.g
    public void z(int i, boolean z) {
        if (i == 5 && this.gYs != null) {
            this.gYs.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.gYp != null) {
            this.gYp.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.g
    public void onChangeSkinType(int i) {
        if (this.gYo != null) {
            if (2 == i) {
                aj.a(this.gYo, d.f.icon_person_dressup_s, d.f.icon_person_dressup);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.a(this.gYo, d.f.icon_person_dressup, d.f.icon_person_dressup);
            } else {
                aj.a(this.gYo, d.f.icon_person_dressup_s, d.f.icon_person_dressup_s);
            }
            if (this.gYp != null) {
                aj.c(this.gYp, d.f.icon_news_down_bar_one);
            }
        }
        if (this.gYr != null) {
            if (2 == i) {
                aj.a(this.gYr, d.f.icon_home_setting_s, d.f.icon_home_setting_w);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.a(this.gYr, d.f.icon_home_setting_w, d.f.icon_home_setting_w);
            } else {
                aj.a(this.gYr, d.f.icon_home_setting_s, d.f.icon_home_setting_s);
            }
            if (this.gYs != null) {
                aj.c(this.gYs, d.f.icon_news_down_bar_one);
            }
        }
        if (this.gYt != null) {
            if (2 == i) {
                aj.a(this.gYt, d.f.icon_person_editor, d.f.icon_person_editor_s);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                aj.a(this.gYt, d.f.icon_person_editor_s, d.f.icon_person_editor_s);
            } else {
                aj.a(this.gYt, d.f.icon_person_editor, d.f.icon_person_editor);
            }
        }
    }

    @Override // com.baidu.tieba.view.g
    public void c(float f, boolean z) {
        float f2;
        if (z) {
            if (this.gYo != null) {
                aj.a(this.gYo, d.f.icon_person_dressup_s, d.f.icon_person_dressup_s);
            }
            if (this.gYr != null) {
                aj.a(this.gYr, d.f.icon_home_setting_s, d.f.icon_home_setting_s);
            }
            if (this.gYt != null) {
                aj.a(this.gYt, d.f.icon_person_editor, d.f.icon_person_editor);
            }
        } else {
            if (this.gYo != null) {
                aj.a(this.gYo, d.f.icon_person_dressup, d.f.icon_person_dressup);
            }
            if (this.gYr != null) {
                aj.a(this.gYr, d.f.icon_home_setting_w, d.f.icon_home_setting_w);
            }
            if (this.gYt != null) {
                aj.a(this.gYt, d.f.icon_person_editor_s, d.f.icon_person_editor_s);
            }
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            if (this.gYo != null) {
                this.gYo.setAlpha(f2);
            }
            if (this.gYr != null) {
                this.gYr.setAlpha(f2);
            }
            if (this.gYt != null) {
                this.gYt.setAlpha(f2);
            }
        }
    }

    public void bbC() {
        if (!this.gYu) {
            this.gYu = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_person_tab_feedback_tips", false);
            if (!this.gYu) {
                View inflate = LayoutInflater.from(this.mContext).inflate(d.h.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(d.g.arrow_up);
                TextView textView = (TextView) inflate.findViewById(d.g.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds32);
                textView.setText(d.j.person_tab_feedback_tips);
                textView.setOnClickListener(this.ffW);
                this.ffQ = new PopupWindow(inflate, -2, -2);
                this.mHandler.removeCallbacks(this.ffU);
                this.mHandler.postDelayed(this.ffU, 100L);
            }
        }
    }

    public void aXh() {
        this.mHandler.removeCallbacks(this.ffU);
        this.mHandler.removeCallbacks(this.ffV);
        aXi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXi() {
        com.baidu.adp.lib.g.g.a(this.ffQ);
    }

    @Override // com.baidu.tieba.view.g
    public void d(UserData userData) {
    }
}
