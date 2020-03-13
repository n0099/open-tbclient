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
    private View.OnClickListener auY;
    private LinearLayout geH;
    private TbSettingTextTipView jRl;
    private TbSettingTextTipView jRm;
    private TbSettingTextTipView jRn;
    private TbSettingTextTipView jRo;
    private View jRp;
    private TbSettingTextTipView jRq;
    private TbSettingTextTipView jRr;
    private SecretSettingActivity jRs;
    private View jRt;
    private String[] jRu;
    private TbSettingTextTipView jRv;
    private a jRw;
    private View mBack;
    private NavigationBar mNavigationBar;

    /* loaded from: classes13.dex */
    public interface a {
        void cEX();

        void cEY();

        void cEZ();

        void cFa();

        void cFb();

        void cFc();

        void cFd();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.auY = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.jRw != null) {
                    if (view == c.this.mBack) {
                        c.this.jRw.onBackPressed();
                    } else if (view == c.this.jRl) {
                        c.this.jRw.cEX();
                    } else if (view == c.this.jRm) {
                        c.this.jRw.cEY();
                    } else if (view == c.this.jRn) {
                        c.this.jRw.cFa();
                    } else if (view == c.this.jRr) {
                        c.this.jRw.cEZ();
                    } else if (view == c.this.jRo) {
                        c.this.jRw.cFb();
                    } else if (view == c.this.jRq) {
                        c.this.jRw.cFc();
                    } else if (view == c.this.jRv) {
                        c.this.jRw.cFd();
                    }
                }
            }
        };
        this.jRs = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        g(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.jRs.getLayoutMode().setNightMode(i == 1);
        this.jRs.getLayoutMode().onModeChanged(this.geH);
        this.mNavigationBar.onChangeSkinType(this.jRs.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.geH = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
        this.jRl = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.jRm = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
        this.jRr = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
        this.jRn = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
        this.jRo = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.user_mute_list);
        this.jRq = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
        this.jRp = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
        this.mBack.setOnClickListener(this.auY);
        this.jRl.setOnClickListener(this.auY);
        this.jRo.setOnClickListener(this.auY);
        this.jRr.setOnClickListener(this.auY);
        this.jRm.setOnClickListener(this.auY);
        this.jRn.setOnClickListener(this.auY);
        this.jRq.setOnClickListener(this.auY);
        this.jRt = this.jRs.findViewById(R.id.privacy_setting_container);
        this.jRu = this.jRs.getResources().getStringArray(R.array.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.jRr.setVisibility(0);
        } else {
            this.jRr.setVisibility(8);
        }
        this.jRv = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
        this.jRv.setOnClickListener(this.auY);
    }

    public void a(a aVar) {
        this.jRw = aVar;
    }

    public void cFe() {
        this.jRl.recycle();
    }

    public void sl(boolean z) {
        if (z) {
            this.jRt.setVisibility(0);
        } else {
            this.jRt.setVisibility(8);
        }
        if (SwitchManager.getInstance().findType("reply_private_setting_switch") == 1) {
            this.jRp.setVisibility(0);
            this.jRq.setVisibility(0);
            return;
        }
        this.jRp.setVisibility(8);
        this.jRq.setVisibility(8);
    }

    public void bs(String str, int i) {
        int i2 = i - 1;
        if (this.jRu != null && i2 < this.jRu.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.jRm.setTip(this.jRu[i2]);
            } else if (TextUtils.equals(str, TbEnum.ParamKey.GROUP)) {
                this.jRr.setTip(this.jRu[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.jRn.setTip(this.jRu[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.jRq.setTip(this.jRs.getString(R.string.all_person));
                } else {
                    this.jRq.setTip(this.jRu[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.jRu != null) {
            int length = this.jRu.length;
            int cES = aVar.cES() - 1;
            if (cES < length && cES >= 0) {
                this.jRr.setTip(this.jRu[cES]);
            }
            int cEQ = aVar.cEQ() - 1;
            if (cEQ < length && cEQ >= 0) {
                this.jRm.setTip(this.jRu[cEQ]);
            }
            int cER = aVar.cER() - 1;
            if (cER < length && cER >= 0) {
                this.jRn.setTip(this.jRu[cER]);
            }
            int cEU = aVar.cEU() - 1;
            if (cEU < length && cEU >= 0) {
                if (cEU == 0) {
                    this.jRq.setTip(this.jRs.getString(R.string.all_person));
                } else {
                    this.jRq.setTip(this.jRu[cEU]);
                }
            }
        }
    }
}
