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
    private View aNy;
    private View.OnClickListener cud;
    private LinearLayout dyl;
    private TbSettingTextTipView gYZ;
    private TbSettingTextTipView gZa;
    private TbSettingTextTipView gZb;
    private TbSettingTextTipView gZc;
    private View gZd;
    private TbSettingTextTipView gZe;
    private View gZf;
    private TbSettingTextTipView gZg;
    private SecretSettingActivity gZh;
    private View gZi;
    private String[] gZj;
    private TbSettingTextTipView gZk;
    private a gZl;
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
        this.cud = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.gZl != null) {
                    if (view == c.this.aNy) {
                        c.this.gZl.onBackPressed();
                    } else if (view == c.this.gYZ) {
                        c.this.gZl.bxK();
                    } else if (view == c.this.gZa) {
                        c.this.gZl.bxL();
                    } else if (view == c.this.gZb) {
                        c.this.gZl.bxN();
                    } else if (view == c.this.gZg) {
                        c.this.gZl.bxM();
                    } else if (view == c.this.gZc) {
                        c.this.gZl.bxO();
                    } else if (view == c.this.gZe) {
                        c.this.gZl.bxP();
                    } else if (view == c.this.gZk) {
                        c.this.gZl.bxQ();
                    }
                }
            }
        };
        this.gZh = secretSettingActivity;
        secretSettingActivity.setContentView(e.h.secret_setting_activity);
        g(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.gZh.getLayoutMode().setNightMode(i == 1);
        this.gZh.getLayoutMode().onModeChanged(this.dyl);
        this.mNavigationBar.onChangeSkinType(this.gZh.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.dyl = (LinearLayout) secretSettingActivity.findViewById(e.g.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(e.g.view_navigation_bar);
        this.aNy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(e.j.secretSetting));
        this.gYZ = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.black_address_list);
        this.gZa = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.privacy_attention_bar);
        this.gZg = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.privacy_attention_group);
        this.gZf = secretSettingActivity.findViewById(e.g.divide_line_under_privacy_attention_group);
        this.gZb = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.privacy_attention_live);
        this.gZc = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.user_mute_list);
        this.gZe = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.thread_reply_setting);
        this.gZd = secretSettingActivity.findViewById(e.g.container_thread_reply_setting);
        this.aNy.setOnClickListener(this.cud);
        this.gYZ.setOnClickListener(this.cud);
        this.gZc.setOnClickListener(this.cud);
        this.gZg.setOnClickListener(this.cud);
        this.gZa.setOnClickListener(this.cud);
        this.gZb.setOnClickListener(this.cud);
        this.gZe.setOnClickListener(this.cud);
        this.gZi = this.gZh.findViewById(e.g.privacy_setting_container);
        this.gZj = this.gZh.getResources().getStringArray(e.b.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.gZg.setVisibility(0);
            this.gZf.setVisibility(0);
        } else {
            this.gZg.setVisibility(8);
            this.gZf.setVisibility(8);
        }
        this.gZk = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.privacy_permission);
        this.gZk.setOnClickListener(this.cud);
    }

    public void a(a aVar) {
        this.gZl = aVar;
    }

    public void bxR() {
        this.gYZ.recycle();
    }

    public void mW(boolean z) {
        if (z) {
            this.gZi.setVisibility(0);
        } else {
            this.gZi.setVisibility(8);
        }
        if (d.iQ().aO("reply_private_setting_switch") == 1) {
            this.gZd.setVisibility(0);
            this.gZe.setVisibility(0);
            return;
        }
        this.gZd.setVisibility(8);
        this.gZe.setVisibility(8);
    }

    public void aT(String str, int i) {
        int i2 = i - 1;
        if (this.gZj != null && i2 < this.gZj.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.gZa.setTip(this.gZj[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.gZg.setTip(this.gZj[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.gZb.setTip(this.gZj[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.gZe.setTip(this.gZh.getString(e.j.all_person));
                } else {
                    this.gZe.setTip(this.gZj[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.gZj != null) {
            int length = this.gZj.length;
            int bxF = aVar.bxF() - 1;
            if (bxF < length && bxF >= 0) {
                this.gZg.setTip(this.gZj[bxF]);
            }
            int bxE = aVar.bxE() - 1;
            if (bxE < length && bxE >= 0) {
                this.gZa.setTip(this.gZj[bxE]);
            }
            int LR = aVar.LR() - 1;
            if (LR < length && LR >= 0) {
                this.gZb.setTip(this.gZj[LR]);
            }
            int bxH = aVar.bxH() - 1;
            if (bxH < length && bxH >= 0) {
                if (bxH == 0) {
                    this.gZe.setTip(this.gZh.getString(e.j.all_person));
                } else {
                    this.gZe.setTip(this.gZj[bxH]);
                }
            }
        }
    }
}
