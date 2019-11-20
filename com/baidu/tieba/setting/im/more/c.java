package com.baidu.tieba.setting.im.more;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.b.d;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<SecretSettingActivity> {
    private View.OnClickListener ajc;
    private LinearLayout fkI;
    private TbSettingTextTipView iSa;
    private TbSettingTextTipView iSb;
    private TbSettingTextTipView iSc;
    private TbSettingTextTipView iSd;
    private View iSe;
    private TbSettingTextTipView iSf;
    private TbSettingTextTipView iSg;
    private SecretSettingActivity iSh;
    private View iSi;
    private String[] iSj;
    private TbSettingTextTipView iSk;
    private a iSl;
    private View mBack;
    private NavigationBar mNavigationBar;

    /* loaded from: classes3.dex */
    public interface a {
        void cik();

        void cil();

        void cim();

        void cin();

        void cio();

        void cip();

        void ciq();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.ajc = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.iSl != null) {
                    if (view == c.this.mBack) {
                        c.this.iSl.onBackPressed();
                    } else if (view == c.this.iSa) {
                        c.this.iSl.cik();
                    } else if (view == c.this.iSb) {
                        c.this.iSl.cil();
                    } else if (view == c.this.iSc) {
                        c.this.iSl.cin();
                    } else if (view == c.this.iSg) {
                        c.this.iSl.cim();
                    } else if (view == c.this.iSd) {
                        c.this.iSl.cio();
                    } else if (view == c.this.iSf) {
                        c.this.iSl.cip();
                    } else if (view == c.this.iSk) {
                        c.this.iSl.ciq();
                    }
                }
            }
        };
        this.iSh = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        g(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.iSh.getLayoutMode().setNightMode(i == 1);
        this.iSh.getLayoutMode().onModeChanged(this.fkI);
        this.mNavigationBar.onChangeSkinType(this.iSh.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.fkI = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
        this.iSa = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.iSb = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
        this.iSg = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
        this.iSc = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
        this.iSd = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.user_mute_list);
        this.iSf = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
        this.iSe = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
        this.mBack.setOnClickListener(this.ajc);
        this.iSa.setOnClickListener(this.ajc);
        this.iSd.setOnClickListener(this.ajc);
        this.iSg.setOnClickListener(this.ajc);
        this.iSb.setOnClickListener(this.ajc);
        this.iSc.setOnClickListener(this.ajc);
        this.iSf.setOnClickListener(this.ajc);
        this.iSi = this.iSh.findViewById(R.id.privacy_setting_container);
        this.iSj = this.iSh.getResources().getStringArray(R.array.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.iSg.setVisibility(0);
        } else {
            this.iSg.setVisibility(8);
        }
        this.iSk = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
        this.iSk.setOnClickListener(this.ajc);
    }

    public void a(a aVar) {
        this.iSl = aVar;
    }

    public void cir() {
        this.iSa.recycle();
    }

    public void qn(boolean z) {
        if (z) {
            this.iSi.setVisibility(0);
        } else {
            this.iSi.setVisibility(8);
        }
        if (d.ft().af("reply_private_setting_switch") == 1) {
            this.iSe.setVisibility(0);
            this.iSf.setVisibility(0);
            return;
        }
        this.iSe.setVisibility(8);
        this.iSf.setVisibility(8);
    }

    public void bj(String str, int i) {
        int i2 = i - 1;
        if (this.iSj != null && i2 < this.iSj.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.iSb.setTip(this.iSj[i2]);
            } else if (TextUtils.equals(str, TbEnum.ParamKey.GROUP)) {
                this.iSg.setTip(this.iSj[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.iSc.setTip(this.iSj[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.iSf.setTip(this.iSh.getString(R.string.all_person));
                } else {
                    this.iSf.setTip(this.iSj[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.iSj != null) {
            int length = this.iSj.length;
            int cif = aVar.cif() - 1;
            if (cif < length && cif >= 0) {
                this.iSg.setTip(this.iSj[cif]);
            }
            int cie = aVar.cie() - 1;
            if (cie < length && cie >= 0) {
                this.iSb.setTip(this.iSj[cie]);
            }
            int atx = aVar.atx() - 1;
            if (atx < length && atx >= 0) {
                this.iSc.setTip(this.iSj[atx]);
            }
            int cih = aVar.cih() - 1;
            if (cih < length && cih >= 0) {
                if (cih == 0) {
                    this.iSf.setTip(this.iSh.getString(R.string.all_person));
                } else {
                    this.iSf.setTip(this.iSj[cih]);
                }
            }
        }
    }
}
