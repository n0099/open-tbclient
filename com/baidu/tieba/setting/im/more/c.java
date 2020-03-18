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
    private View.OnClickListener avi;
    private LinearLayout gfp;
    private TbSettingTextTipView jSN;
    private TbSettingTextTipView jSO;
    private TbSettingTextTipView jSP;
    private TbSettingTextTipView jSQ;
    private View jSR;
    private TbSettingTextTipView jSS;
    private TbSettingTextTipView jST;
    private SecretSettingActivity jSU;
    private View jSV;
    private String[] jSW;
    private TbSettingTextTipView jSX;
    private a jSY;
    private View mBack;
    private NavigationBar mNavigationBar;

    /* loaded from: classes13.dex */
    public interface a {
        void cFr();

        void cFs();

        void cFt();

        void cFu();

        void cFv();

        void cFw();

        void cFx();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.avi = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.jSY != null) {
                    if (view == c.this.mBack) {
                        c.this.jSY.onBackPressed();
                    } else if (view == c.this.jSN) {
                        c.this.jSY.cFr();
                    } else if (view == c.this.jSO) {
                        c.this.jSY.cFs();
                    } else if (view == c.this.jSP) {
                        c.this.jSY.cFu();
                    } else if (view == c.this.jST) {
                        c.this.jSY.cFt();
                    } else if (view == c.this.jSQ) {
                        c.this.jSY.cFv();
                    } else if (view == c.this.jSS) {
                        c.this.jSY.cFw();
                    } else if (view == c.this.jSX) {
                        c.this.jSY.cFx();
                    }
                }
            }
        };
        this.jSU = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        g(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.jSU.getLayoutMode().setNightMode(i == 1);
        this.jSU.getLayoutMode().onModeChanged(this.gfp);
        this.mNavigationBar.onChangeSkinType(this.jSU.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.gfp = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
        this.jSN = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.jSO = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
        this.jST = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
        this.jSP = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
        this.jSQ = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.user_mute_list);
        this.jSS = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
        this.jSR = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
        this.mBack.setOnClickListener(this.avi);
        this.jSN.setOnClickListener(this.avi);
        this.jSQ.setOnClickListener(this.avi);
        this.jST.setOnClickListener(this.avi);
        this.jSO.setOnClickListener(this.avi);
        this.jSP.setOnClickListener(this.avi);
        this.jSS.setOnClickListener(this.avi);
        this.jSV = this.jSU.findViewById(R.id.privacy_setting_container);
        this.jSW = this.jSU.getResources().getStringArray(R.array.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.jST.setVisibility(0);
        } else {
            this.jST.setVisibility(8);
        }
        this.jSX = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
        this.jSX.setOnClickListener(this.avi);
    }

    public void a(a aVar) {
        this.jSY = aVar;
    }

    public void cFy() {
        this.jSN.recycle();
    }

    public void sr(boolean z) {
        if (z) {
            this.jSV.setVisibility(0);
        } else {
            this.jSV.setVisibility(8);
        }
        if (SwitchManager.getInstance().findType("reply_private_setting_switch") == 1) {
            this.jSR.setVisibility(0);
            this.jSS.setVisibility(0);
            return;
        }
        this.jSR.setVisibility(8);
        this.jSS.setVisibility(8);
    }

    public void bs(String str, int i) {
        int i2 = i - 1;
        if (this.jSW != null && i2 < this.jSW.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.jSO.setTip(this.jSW[i2]);
            } else if (TextUtils.equals(str, TbEnum.ParamKey.GROUP)) {
                this.jST.setTip(this.jSW[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.jSP.setTip(this.jSW[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.jSS.setTip(this.jSU.getString(R.string.all_person));
                } else {
                    this.jSS.setTip(this.jSW[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.jSW != null) {
            int length = this.jSW.length;
            int cFm = aVar.cFm() - 1;
            if (cFm < length && cFm >= 0) {
                this.jST.setTip(this.jSW[cFm]);
            }
            int cFk = aVar.cFk() - 1;
            if (cFk < length && cFk >= 0) {
                this.jSO.setTip(this.jSW[cFk]);
            }
            int cFl = aVar.cFl() - 1;
            if (cFl < length && cFl >= 0) {
                this.jSP.setTip(this.jSW[cFl]);
            }
            int cFo = aVar.cFo() - 1;
            if (cFo < length && cFo >= 0) {
                if (cFo == 0) {
                    this.jSS.setTip(this.jSU.getString(R.string.all_person));
                } else {
                    this.jSS.setTip(this.jSW[cFo]);
                }
            }
        }
    }
}
