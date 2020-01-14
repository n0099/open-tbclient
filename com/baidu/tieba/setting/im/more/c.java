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
/* loaded from: classes11.dex */
public class c extends com.baidu.adp.base.c<SecretSettingActivity> {
    private View.OnClickListener arL;
    private LinearLayout gcq;
    private TbSettingTextTipView jQc;
    private TbSettingTextTipView jQd;
    private TbSettingTextTipView jQe;
    private TbSettingTextTipView jQf;
    private View jQg;
    private TbSettingTextTipView jQh;
    private TbSettingTextTipView jQi;
    private SecretSettingActivity jQj;
    private View jQk;
    private String[] jQl;
    private TbSettingTextTipView jQm;
    private a jQn;
    private View mBack;
    private NavigationBar mNavigationBar;

    /* loaded from: classes11.dex */
    public interface a {
        void cDt();

        void cDu();

        void cDv();

        void cDw();

        void cDx();

        void cDy();

        void cDz();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.arL = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.jQn != null) {
                    if (view == c.this.mBack) {
                        c.this.jQn.onBackPressed();
                    } else if (view == c.this.jQc) {
                        c.this.jQn.cDt();
                    } else if (view == c.this.jQd) {
                        c.this.jQn.cDu();
                    } else if (view == c.this.jQe) {
                        c.this.jQn.cDw();
                    } else if (view == c.this.jQi) {
                        c.this.jQn.cDv();
                    } else if (view == c.this.jQf) {
                        c.this.jQn.cDx();
                    } else if (view == c.this.jQh) {
                        c.this.jQn.cDy();
                    } else if (view == c.this.jQm) {
                        c.this.jQn.cDz();
                    }
                }
            }
        };
        this.jQj = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        g(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.jQj.getLayoutMode().setNightMode(i == 1);
        this.jQj.getLayoutMode().onModeChanged(this.gcq);
        this.mNavigationBar.onChangeSkinType(this.jQj.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.gcq = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
        this.jQc = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.jQd = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
        this.jQi = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
        this.jQe = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
        this.jQf = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.user_mute_list);
        this.jQh = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
        this.jQg = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
        this.mBack.setOnClickListener(this.arL);
        this.jQc.setOnClickListener(this.arL);
        this.jQf.setOnClickListener(this.arL);
        this.jQi.setOnClickListener(this.arL);
        this.jQd.setOnClickListener(this.arL);
        this.jQe.setOnClickListener(this.arL);
        this.jQh.setOnClickListener(this.arL);
        this.jQk = this.jQj.findViewById(R.id.privacy_setting_container);
        this.jQl = this.jQj.getResources().getStringArray(R.array.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.jQi.setVisibility(0);
        } else {
            this.jQi.setVisibility(8);
        }
        this.jQm = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
        this.jQm.setOnClickListener(this.arL);
    }

    public void a(a aVar) {
        this.jQn = aVar;
    }

    public void cDA() {
        this.jQc.recycle();
    }

    public void si(boolean z) {
        if (z) {
            this.jQk.setVisibility(0);
        } else {
            this.jQk.setVisibility(8);
        }
        if (SwitchManager.getInstance().findType("reply_private_setting_switch") == 1) {
            this.jQg.setVisibility(0);
            this.jQh.setVisibility(0);
            return;
        }
        this.jQg.setVisibility(8);
        this.jQh.setVisibility(8);
    }

    public void bt(String str, int i) {
        int i2 = i - 1;
        if (this.jQl != null && i2 < this.jQl.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.jQd.setTip(this.jQl[i2]);
            } else if (TextUtils.equals(str, TbEnum.ParamKey.GROUP)) {
                this.jQi.setTip(this.jQl[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.jQe.setTip(this.jQl[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.jQh.setTip(this.jQj.getString(R.string.all_person));
                } else {
                    this.jQh.setTip(this.jQl[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.jQl != null) {
            int length = this.jQl.length;
            int cDo = aVar.cDo() - 1;
            if (cDo < length && cDo >= 0) {
                this.jQi.setTip(this.jQl[cDo]);
            }
            int cDm = aVar.cDm() - 1;
            if (cDm < length && cDm >= 0) {
                this.jQd.setTip(this.jQl[cDm]);
            }
            int cDn = aVar.cDn() - 1;
            if (cDn < length && cDn >= 0) {
                this.jQe.setTip(this.jQl[cDn]);
            }
            int cDq = aVar.cDq() - 1;
            if (cDq < length && cDq >= 0) {
                if (cDq == 0) {
                    this.jQh.setTip(this.jQj.getString(R.string.all_person));
                } else {
                    this.jQh.setTip(this.jQl[cDq]);
                }
            }
        }
    }
}
