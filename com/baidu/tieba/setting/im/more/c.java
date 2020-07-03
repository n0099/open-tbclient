package com.baidu.tieba.setting.im.more;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public class c extends com.baidu.adp.base.c<SecretSettingActivity> {
    private View.OnClickListener aXG;
    private LinearLayout hpL;
    private TbSettingTextTipView lph;
    private TbSettingTextTipView lpi;
    private TbSettingTextTipView lpj;
    private TbSettingTextTipView lpk;
    private View lpl;
    private TbSettingTextTipView lpm;
    private TbSettingTextTipView lpn;
    private SecretSettingActivity lpo;
    private View lpp;
    private String[] lpq;
    private TbSettingTextTipView lpr;
    private a lps;
    private View mBack;
    private NavigationBar mNavigationBar;

    /* loaded from: classes13.dex */
    public interface a {
        void dbA();

        void dbB();

        void dbv();

        void dbw();

        void dbx();

        void dby();

        void dbz();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.aXG = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.lps != null) {
                    if (view == c.this.mBack) {
                        c.this.lps.onBackPressed();
                    } else if (view == c.this.lph) {
                        c.this.lps.dbv();
                    } else if (view == c.this.lpi) {
                        c.this.lps.dbw();
                    } else if (view == c.this.lpj) {
                        c.this.lps.dby();
                    } else if (view == c.this.lpn) {
                        c.this.lps.dbx();
                    } else if (view == c.this.lpk) {
                        c.this.lps.dbz();
                    } else if (view == c.this.lpm) {
                        c.this.lps.dbA();
                    } else if (view == c.this.lpr) {
                        c.this.lps.dbB();
                    }
                }
            }
        };
        this.lpo = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        g(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.lpo.getLayoutMode().setNightMode(i == 1);
        this.lpo.getLayoutMode().onModeChanged(this.hpL);
        this.mNavigationBar.onChangeSkinType(this.lpo.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.hpL = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
        this.lph = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.lpi = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
        this.lpn = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
        this.lpj = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
        this.lpk = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.user_mute_list);
        this.lpm = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
        this.lpl = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
        this.mBack.setOnClickListener(this.aXG);
        this.lph.setOnClickListener(this.aXG);
        this.lpk.setOnClickListener(this.aXG);
        this.lpn.setOnClickListener(this.aXG);
        this.lpi.setOnClickListener(this.aXG);
        this.lpj.setOnClickListener(this.aXG);
        this.lpm.setOnClickListener(this.aXG);
        this.lpp = this.lpo.findViewById(R.id.privacy_setting_container);
        this.lpq = this.lpo.getResources().getStringArray(R.array.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.lpn.setVisibility(0);
        } else {
            this.lpn.setVisibility(8);
        }
        this.lpr = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
        this.lpr.setOnClickListener(this.aXG);
    }

    public void a(a aVar) {
        this.lps = aVar;
    }

    public void dbC() {
        this.lph.recycle();
    }

    public void uf(boolean z) {
        if (z) {
            this.lpp.setVisibility(0);
        } else {
            this.lpp.setVisibility(8);
        }
        if (SwitchManager.getInstance().findType("reply_private_setting_switch") == 1) {
            this.lpl.setVisibility(0);
            this.lpm.setVisibility(0);
            return;
        }
        this.lpl.setVisibility(8);
        this.lpm.setVisibility(8);
    }

    public void bC(String str, int i) {
        int i2 = i - 1;
        if (this.lpq != null && i2 < this.lpq.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.lpi.setTip(this.lpq[i2]);
            } else if (TextUtils.equals(str, TbEnum.ParamKey.GROUP)) {
                this.lpn.setTip(this.lpq[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.lpj.setTip(this.lpq[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.lpm.setTip(this.lpo.getString(R.string.all_person));
                } else {
                    this.lpm.setTip(this.lpq[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.lpq != null) {
            int length = this.lpq.length;
            int dbq = aVar.dbq() - 1;
            if (dbq < length && dbq >= 0) {
                this.lpn.setTip(this.lpq[dbq]);
            }
            int dbo = aVar.dbo() - 1;
            if (dbo < length && dbo >= 0) {
                this.lpi.setTip(this.lpq[dbo]);
            }
            int dbp = aVar.dbp() - 1;
            if (dbp < length && dbp >= 0) {
                this.lpj.setTip(this.lpq[dbp]);
            }
            int dbs = aVar.dbs() - 1;
            if (dbs < length && dbs >= 0) {
                if (dbs == 0) {
                    this.lpm.setTip(this.lpo.getString(R.string.all_person));
                } else {
                    this.lpm.setTip(this.lpq[dbs]);
                }
            }
        }
    }
}
