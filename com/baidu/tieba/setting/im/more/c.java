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
    private View cdX;
    private View.OnClickListener dSO;
    private LinearLayout fbx;
    private TbSettingTextTipView iJi;
    private TbSettingTextTipView iJj;
    private TbSettingTextTipView iJk;
    private TbSettingTextTipView iJl;
    private View iJm;
    private TbSettingTextTipView iJn;
    private View iJo;
    private TbSettingTextTipView iJp;
    private SecretSettingActivity iJq;
    private View iJr;
    private String[] iJs;
    private TbSettingTextTipView iJt;
    private a iJu;
    private NavigationBar mNavigationBar;

    /* loaded from: classes3.dex */
    public interface a {
        void cgC();

        void cgD();

        void cgE();

        void cgF();

        void cgG();

        void cgH();

        void cgI();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.dSO = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.iJu != null) {
                    if (view == c.this.cdX) {
                        c.this.iJu.onBackPressed();
                    } else if (view == c.this.iJi) {
                        c.this.iJu.cgC();
                    } else if (view == c.this.iJj) {
                        c.this.iJu.cgD();
                    } else if (view == c.this.iJk) {
                        c.this.iJu.cgF();
                    } else if (view == c.this.iJp) {
                        c.this.iJu.cgE();
                    } else if (view == c.this.iJl) {
                        c.this.iJu.cgG();
                    } else if (view == c.this.iJn) {
                        c.this.iJu.cgH();
                    } else if (view == c.this.iJt) {
                        c.this.iJu.cgI();
                    }
                }
            }
        };
        this.iJq = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        g(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.iJq.getLayoutMode().setNightMode(i == 1);
        this.iJq.getLayoutMode().onModeChanged(this.fbx);
        this.mNavigationBar.onChangeSkinType(this.iJq.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.fbx = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.cdX = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
        this.iJi = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.iJj = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
        this.iJp = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
        this.iJo = secretSettingActivity.findViewById(R.id.divide_line_under_privacy_attention_group);
        this.iJk = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
        this.iJl = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.user_mute_list);
        this.iJn = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
        this.iJm = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
        this.cdX.setOnClickListener(this.dSO);
        this.iJi.setOnClickListener(this.dSO);
        this.iJl.setOnClickListener(this.dSO);
        this.iJp.setOnClickListener(this.dSO);
        this.iJj.setOnClickListener(this.dSO);
        this.iJk.setOnClickListener(this.dSO);
        this.iJn.setOnClickListener(this.dSO);
        this.iJr = this.iJq.findViewById(R.id.privacy_setting_container);
        this.iJs = this.iJq.getResources().getStringArray(R.array.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.iJp.setVisibility(0);
            this.iJo.setVisibility(0);
        } else {
            this.iJp.setVisibility(8);
            this.iJo.setVisibility(8);
        }
        this.iJt = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
        this.iJt.setOnClickListener(this.dSO);
    }

    public void a(a aVar) {
        this.iJu = aVar;
    }

    public void cgJ() {
        this.iJi.recycle();
    }

    public void qk(boolean z) {
        if (z) {
            this.iJr.setVisibility(0);
        } else {
            this.iJr.setVisibility(8);
        }
        if (d.hI().ay("reply_private_setting_switch") == 1) {
            this.iJm.setVisibility(0);
            this.iJn.setVisibility(0);
            return;
        }
        this.iJm.setVisibility(8);
        this.iJn.setVisibility(8);
    }

    public void bl(String str, int i) {
        int i2 = i - 1;
        if (this.iJs != null && i2 < this.iJs.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.iJj.setTip(this.iJs[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.iJp.setTip(this.iJs[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.iJk.setTip(this.iJs[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.iJn.setTip(this.iJq.getString(R.string.all_person));
                } else {
                    this.iJn.setTip(this.iJs[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.iJs != null) {
            int length = this.iJs.length;
            int cgx = aVar.cgx() - 1;
            if (cgx < length && cgx >= 0) {
                this.iJp.setTip(this.iJs[cgx]);
            }
            int cgw = aVar.cgw() - 1;
            if (cgw < length && cgw >= 0) {
                this.iJj.setTip(this.iJs[cgw]);
            }
            int aqs = aVar.aqs() - 1;
            if (aqs < length && aqs >= 0) {
                this.iJk.setTip(this.iJs[aqs]);
            }
            int cgz = aVar.cgz() - 1;
            if (cgz < length && cgz >= 0) {
                if (cgz == 0) {
                    this.iJn.setTip(this.iJq.getString(R.string.all_person));
                } else {
                    this.iJn.setTip(this.iJs[cgz]);
                }
            }
        }
    }
}
