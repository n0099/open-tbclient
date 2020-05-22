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
    private View.OnClickListener aUZ;
    private LinearLayout hdp;
    private TbSettingTextTipView kUb;
    private TbSettingTextTipView kUc;
    private TbSettingTextTipView kUd;
    private TbSettingTextTipView kUe;
    private View kUf;
    private TbSettingTextTipView kUg;
    private TbSettingTextTipView kUh;
    private SecretSettingActivity kUi;
    private View kUj;
    private String[] kUk;
    private TbSettingTextTipView kUl;
    private a kUm;
    private View mBack;
    private NavigationBar mNavigationBar;

    /* loaded from: classes13.dex */
    public interface a {
        void cWQ();

        void cWR();

        void cWS();

        void cWT();

        void cWU();

        void cWV();

        void cWW();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.aUZ = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.kUm != null) {
                    if (view == c.this.mBack) {
                        c.this.kUm.onBackPressed();
                    } else if (view == c.this.kUb) {
                        c.this.kUm.cWQ();
                    } else if (view == c.this.kUc) {
                        c.this.kUm.cWR();
                    } else if (view == c.this.kUd) {
                        c.this.kUm.cWT();
                    } else if (view == c.this.kUh) {
                        c.this.kUm.cWS();
                    } else if (view == c.this.kUe) {
                        c.this.kUm.cWU();
                    } else if (view == c.this.kUg) {
                        c.this.kUm.cWV();
                    } else if (view == c.this.kUl) {
                        c.this.kUm.cWW();
                    }
                }
            }
        };
        this.kUi = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        g(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.kUi.getLayoutMode().setNightMode(i == 1);
        this.kUi.getLayoutMode().onModeChanged(this.hdp);
        this.mNavigationBar.onChangeSkinType(this.kUi.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.hdp = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
        this.kUb = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.kUc = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
        this.kUh = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
        this.kUd = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
        this.kUe = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.user_mute_list);
        this.kUg = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
        this.kUf = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
        this.mBack.setOnClickListener(this.aUZ);
        this.kUb.setOnClickListener(this.aUZ);
        this.kUe.setOnClickListener(this.aUZ);
        this.kUh.setOnClickListener(this.aUZ);
        this.kUc.setOnClickListener(this.aUZ);
        this.kUd.setOnClickListener(this.aUZ);
        this.kUg.setOnClickListener(this.aUZ);
        this.kUj = this.kUi.findViewById(R.id.privacy_setting_container);
        this.kUk = this.kUi.getResources().getStringArray(R.array.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.kUh.setVisibility(0);
        } else {
            this.kUh.setVisibility(8);
        }
        this.kUl = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
        this.kUl.setOnClickListener(this.aUZ);
    }

    public void a(a aVar) {
        this.kUm = aVar;
    }

    public void cWX() {
        this.kUb.recycle();
    }

    public void tQ(boolean z) {
        if (z) {
            this.kUj.setVisibility(0);
        } else {
            this.kUj.setVisibility(8);
        }
        if (SwitchManager.getInstance().findType("reply_private_setting_switch") == 1) {
            this.kUf.setVisibility(0);
            this.kUg.setVisibility(0);
            return;
        }
        this.kUf.setVisibility(8);
        this.kUg.setVisibility(8);
    }

    public void bD(String str, int i) {
        int i2 = i - 1;
        if (this.kUk != null && i2 < this.kUk.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.kUc.setTip(this.kUk[i2]);
            } else if (TextUtils.equals(str, TbEnum.ParamKey.GROUP)) {
                this.kUh.setTip(this.kUk[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.kUd.setTip(this.kUk[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.kUg.setTip(this.kUi.getString(R.string.all_person));
                } else {
                    this.kUg.setTip(this.kUk[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.kUk != null) {
            int length = this.kUk.length;
            int cWL = aVar.cWL() - 1;
            if (cWL < length && cWL >= 0) {
                this.kUh.setTip(this.kUk[cWL]);
            }
            int cWJ = aVar.cWJ() - 1;
            if (cWJ < length && cWJ >= 0) {
                this.kUc.setTip(this.kUk[cWJ]);
            }
            int cWK = aVar.cWK() - 1;
            if (cWK < length && cWK >= 0) {
                this.kUd.setTip(this.kUk[cWK]);
            }
            int cWN = aVar.cWN() - 1;
            if (cWN < length && cWN >= 0) {
                if (cWN == 0) {
                    this.kUg.setTip(this.kUi.getString(R.string.all_person));
                } else {
                    this.kUg.setTip(this.kUk[cWN]);
                }
            }
        }
    }
}
