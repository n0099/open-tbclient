package com.baidu.tieba.setting.im.more;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.b.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<SecretSettingActivity> {
    private View aNz;
    private View.OnClickListener cue;
    private LinearLayout dym;
    private TbSettingTextTipView gZa;
    private TbSettingTextTipView gZb;
    private TbSettingTextTipView gZc;
    private TbSettingTextTipView gZd;
    private View gZe;
    private TbSettingTextTipView gZf;
    private View gZg;
    private TbSettingTextTipView gZh;
    private SecretSettingActivity gZi;
    private View gZj;
    private String[] gZk;
    private TbSettingTextTipView gZl;
    private a gZm;
    private NavigationBar mNavigationBar;

    /* loaded from: classes3.dex */
    public interface a {
        void bxK();

        void bxL();

        void bxM();

        void bxN();

        void bxO();

        void bxP();

        void bxQ();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.cue = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.gZm != null) {
                    if (view == c.this.aNz) {
                        c.this.gZm.onBackPressed();
                    } else if (view == c.this.gZa) {
                        c.this.gZm.bxK();
                    } else if (view == c.this.gZb) {
                        c.this.gZm.bxL();
                    } else if (view == c.this.gZc) {
                        c.this.gZm.bxN();
                    } else if (view == c.this.gZh) {
                        c.this.gZm.bxM();
                    } else if (view == c.this.gZd) {
                        c.this.gZm.bxO();
                    } else if (view == c.this.gZf) {
                        c.this.gZm.bxP();
                    } else if (view == c.this.gZl) {
                        c.this.gZm.bxQ();
                    }
                }
            }
        };
        this.gZi = secretSettingActivity;
        secretSettingActivity.setContentView(e.h.secret_setting_activity);
        g(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.gZi.getLayoutMode().setNightMode(i == 1);
        this.gZi.getLayoutMode().onModeChanged(this.dym);
        this.mNavigationBar.onChangeSkinType(this.gZi.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.dym = (LinearLayout) secretSettingActivity.findViewById(e.g.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(e.g.view_navigation_bar);
        this.aNz = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(e.j.secretSetting));
        this.gZa = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.black_address_list);
        this.gZb = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.privacy_attention_bar);
        this.gZh = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.privacy_attention_group);
        this.gZg = secretSettingActivity.findViewById(e.g.divide_line_under_privacy_attention_group);
        this.gZc = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.privacy_attention_live);
        this.gZd = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.user_mute_list);
        this.gZf = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.thread_reply_setting);
        this.gZe = secretSettingActivity.findViewById(e.g.container_thread_reply_setting);
        this.aNz.setOnClickListener(this.cue);
        this.gZa.setOnClickListener(this.cue);
        this.gZd.setOnClickListener(this.cue);
        this.gZh.setOnClickListener(this.cue);
        this.gZb.setOnClickListener(this.cue);
        this.gZc.setOnClickListener(this.cue);
        this.gZf.setOnClickListener(this.cue);
        this.gZj = this.gZi.findViewById(e.g.privacy_setting_container);
        this.gZk = this.gZi.getResources().getStringArray(e.b.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.gZh.setVisibility(0);
            this.gZg.setVisibility(0);
        } else {
            this.gZh.setVisibility(8);
            this.gZg.setVisibility(8);
        }
        this.gZl = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.privacy_permission);
        this.gZl.setOnClickListener(this.cue);
    }

    public void a(a aVar) {
        this.gZm = aVar;
    }

    public void bxR() {
        this.gZa.recycle();
    }

    public void mW(boolean z) {
        if (z) {
            this.gZj.setVisibility(0);
        } else {
            this.gZj.setVisibility(8);
        }
        if (d.iQ().aO("reply_private_setting_switch") == 1) {
            this.gZe.setVisibility(0);
            this.gZf.setVisibility(0);
            return;
        }
        this.gZe.setVisibility(8);
        this.gZf.setVisibility(8);
    }

    public void aT(String str, int i) {
        int i2 = i - 1;
        if (this.gZk != null && i2 < this.gZk.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.gZb.setTip(this.gZk[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.gZh.setTip(this.gZk[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.gZc.setTip(this.gZk[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.gZf.setTip(this.gZi.getString(e.j.all_person));
                } else {
                    this.gZf.setTip(this.gZk[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.gZk != null) {
            int length = this.gZk.length;
            int bxF = aVar.bxF() - 1;
            if (bxF < length && bxF >= 0) {
                this.gZh.setTip(this.gZk[bxF]);
            }
            int bxE = aVar.bxE() - 1;
            if (bxE < length && bxE >= 0) {
                this.gZb.setTip(this.gZk[bxE]);
            }
            int LR = aVar.LR() - 1;
            if (LR < length && LR >= 0) {
                this.gZc.setTip(this.gZk[LR]);
            }
            int bxH = aVar.bxH() - 1;
            if (bxH < length && bxH >= 0) {
                if (bxH == 0) {
                    this.gZf.setTip(this.gZi.getString(e.j.all_person));
                } else {
                    this.gZf.setTip(this.gZk[bxH]);
                }
            }
        }
    }
}
