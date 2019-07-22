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
    private View cfb;
    private View.OnClickListener dWK;
    private LinearLayout fgy;
    private TbSettingTextTipView iPG;
    private TbSettingTextTipView iPH;
    private TbSettingTextTipView iPI;
    private TbSettingTextTipView iPJ;
    private View iPK;
    private TbSettingTextTipView iPL;
    private View iPM;
    private TbSettingTextTipView iPN;
    private SecretSettingActivity iPO;
    private View iPP;
    private String[] iPQ;
    private TbSettingTextTipView iPR;
    private a iPS;
    private NavigationBar mNavigationBar;

    /* loaded from: classes3.dex */
    public interface a {
        void cjA();

        void cjB();

        void cjC();

        void cjw();

        void cjx();

        void cjy();

        void cjz();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.dWK = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.iPS != null) {
                    if (view == c.this.cfb) {
                        c.this.iPS.onBackPressed();
                    } else if (view == c.this.iPG) {
                        c.this.iPS.cjw();
                    } else if (view == c.this.iPH) {
                        c.this.iPS.cjx();
                    } else if (view == c.this.iPI) {
                        c.this.iPS.cjz();
                    } else if (view == c.this.iPN) {
                        c.this.iPS.cjy();
                    } else if (view == c.this.iPJ) {
                        c.this.iPS.cjA();
                    } else if (view == c.this.iPL) {
                        c.this.iPS.cjB();
                    } else if (view == c.this.iPR) {
                        c.this.iPS.cjC();
                    }
                }
            }
        };
        this.iPO = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        g(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.iPO.getLayoutMode().setNightMode(i == 1);
        this.iPO.getLayoutMode().onModeChanged(this.fgy);
        this.mNavigationBar.onChangeSkinType(this.iPO.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.fgy = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.cfb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
        this.iPG = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.iPH = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
        this.iPN = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
        this.iPM = secretSettingActivity.findViewById(R.id.divide_line_under_privacy_attention_group);
        this.iPI = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
        this.iPJ = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.user_mute_list);
        this.iPL = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
        this.iPK = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
        this.cfb.setOnClickListener(this.dWK);
        this.iPG.setOnClickListener(this.dWK);
        this.iPJ.setOnClickListener(this.dWK);
        this.iPN.setOnClickListener(this.dWK);
        this.iPH.setOnClickListener(this.dWK);
        this.iPI.setOnClickListener(this.dWK);
        this.iPL.setOnClickListener(this.dWK);
        this.iPP = this.iPO.findViewById(R.id.privacy_setting_container);
        this.iPQ = this.iPO.getResources().getStringArray(R.array.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.iPN.setVisibility(0);
            this.iPM.setVisibility(0);
        } else {
            this.iPN.setVisibility(8);
            this.iPM.setVisibility(8);
        }
        this.iPR = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
        this.iPR.setOnClickListener(this.dWK);
    }

    public void a(a aVar) {
        this.iPS = aVar;
    }

    public void cjD() {
        this.iPG.recycle();
    }

    public void qA(boolean z) {
        if (z) {
            this.iPP.setVisibility(0);
        } else {
            this.iPP.setVisibility(8);
        }
        if (d.hS().az("reply_private_setting_switch") == 1) {
            this.iPK.setVisibility(0);
            this.iPL.setVisibility(0);
            return;
        }
        this.iPK.setVisibility(8);
        this.iPL.setVisibility(8);
    }

    public void bm(String str, int i) {
        int i2 = i - 1;
        if (this.iPQ != null && i2 < this.iPQ.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.iPH.setTip(this.iPQ[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.iPN.setTip(this.iPQ[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.iPI.setTip(this.iPQ[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.iPL.setTip(this.iPO.getString(R.string.all_person));
                } else {
                    this.iPL.setTip(this.iPQ[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.iPQ != null) {
            int length = this.iPQ.length;
            int cjr = aVar.cjr() - 1;
            if (cjr < length && cjr >= 0) {
                this.iPN.setTip(this.iPQ[cjr]);
            }
            int cjq = aVar.cjq() - 1;
            if (cjq < length && cjq >= 0) {
                this.iPH.setTip(this.iPQ[cjq]);
            }
            int arx = aVar.arx() - 1;
            if (arx < length && arx >= 0) {
                this.iPI.setTip(this.iPQ[arx]);
            }
            int cjt = aVar.cjt() - 1;
            if (cjt < length && cjt >= 0) {
                if (cjt == 0) {
                    this.iPL.setTip(this.iPO.getString(R.string.all_person));
                } else {
                    this.iPL.setTip(this.iPQ[cjt]);
                }
            }
        }
    }
}
