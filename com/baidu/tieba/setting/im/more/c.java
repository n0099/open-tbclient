package com.baidu.tieba.setting.im.more;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.b.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<SecretSettingActivity> {
    private View cfi;
    private View.OnClickListener dWR;
    private LinearLayout fgY;
    private TbSettingTextTipView iQK;
    private TbSettingTextTipView iQL;
    private TbSettingTextTipView iQM;
    private TbSettingTextTipView iQN;
    private View iQO;
    private TbSettingTextTipView iQP;
    private View iQQ;
    private TbSettingTextTipView iQR;
    private SecretSettingActivity iQS;
    private View iQT;
    private String[] iQU;
    private TbSettingTextTipView iQV;
    private a iQW;
    private NavigationBar mNavigationBar;

    /* loaded from: classes3.dex */
    public interface a {
        void cjO();

        void cjP();

        void cjQ();

        void cjR();

        void cjS();

        void cjT();

        void cjU();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.dWR = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.iQW != null) {
                    if (view == c.this.cfi) {
                        c.this.iQW.onBackPressed();
                    } else if (view == c.this.iQK) {
                        c.this.iQW.cjO();
                    } else if (view == c.this.iQL) {
                        c.this.iQW.cjP();
                    } else if (view == c.this.iQM) {
                        c.this.iQW.cjR();
                    } else if (view == c.this.iQR) {
                        c.this.iQW.cjQ();
                    } else if (view == c.this.iQN) {
                        c.this.iQW.cjS();
                    } else if (view == c.this.iQP) {
                        c.this.iQW.cjT();
                    } else if (view == c.this.iQV) {
                        c.this.iQW.cjU();
                    }
                }
            }
        };
        this.iQS = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        g(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.iQS.getLayoutMode().setNightMode(i == 1);
        this.iQS.getLayoutMode().onModeChanged(this.fgY);
        this.mNavigationBar.onChangeSkinType(this.iQS.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.fgY = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.cfi = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
        this.iQK = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.iQL = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
        this.iQR = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
        this.iQQ = secretSettingActivity.findViewById(R.id.divide_line_under_privacy_attention_group);
        this.iQM = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
        this.iQN = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.user_mute_list);
        this.iQP = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
        this.iQO = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
        this.cfi.setOnClickListener(this.dWR);
        this.iQK.setOnClickListener(this.dWR);
        this.iQN.setOnClickListener(this.dWR);
        this.iQR.setOnClickListener(this.dWR);
        this.iQL.setOnClickListener(this.dWR);
        this.iQM.setOnClickListener(this.dWR);
        this.iQP.setOnClickListener(this.dWR);
        this.iQT = this.iQS.findViewById(R.id.privacy_setting_container);
        this.iQU = this.iQS.getResources().getStringArray(R.array.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.iQR.setVisibility(0);
            this.iQQ.setVisibility(0);
        } else {
            this.iQR.setVisibility(8);
            this.iQQ.setVisibility(8);
        }
        this.iQV = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
        this.iQV.setOnClickListener(this.dWR);
    }

    public void a(a aVar) {
        this.iQW = aVar;
    }

    public void cjV() {
        this.iQK.recycle();
    }

    public void qB(boolean z) {
        if (z) {
            this.iQT.setVisibility(0);
        } else {
            this.iQT.setVisibility(8);
        }
        if (d.hS().az("reply_private_setting_switch") == 1) {
            this.iQO.setVisibility(0);
            this.iQP.setVisibility(0);
            return;
        }
        this.iQO.setVisibility(8);
        this.iQP.setVisibility(8);
    }

    public void bm(String str, int i) {
        int i2 = i - 1;
        if (this.iQU != null && i2 < this.iQU.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.iQL.setTip(this.iQU[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.iQR.setTip(this.iQU[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.iQM.setTip(this.iQU[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.iQP.setTip(this.iQS.getString(R.string.all_person));
                } else {
                    this.iQP.setTip(this.iQU[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.iQU != null) {
            int length = this.iQU.length;
            int cjJ = aVar.cjJ() - 1;
            if (cjJ < length && cjJ >= 0) {
                this.iQR.setTip(this.iQU[cjJ]);
            }
            int cjI = aVar.cjI() - 1;
            if (cjI < length && cjI >= 0) {
                this.iQL.setTip(this.iQU[cjI]);
            }
            int arz = aVar.arz() - 1;
            if (arz < length && arz >= 0) {
                this.iQM.setTip(this.iQU[arz]);
            }
            int cjL = aVar.cjL() - 1;
            if (cjL < length && cjL >= 0) {
                if (cjL == 0) {
                    this.iQP.setTip(this.iQS.getString(R.string.all_person));
                } else {
                    this.iQP.setTip(this.iQU[cjL]);
                }
            }
        }
    }
}
