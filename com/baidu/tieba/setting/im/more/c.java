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
    private View.OnClickListener dSP;
    private LinearLayout fby;
    private TbSettingTextTipView iJk;
    private TbSettingTextTipView iJl;
    private TbSettingTextTipView iJm;
    private TbSettingTextTipView iJn;
    private View iJo;
    private TbSettingTextTipView iJp;
    private View iJq;
    private TbSettingTextTipView iJr;
    private SecretSettingActivity iJs;
    private View iJt;
    private String[] iJu;
    private TbSettingTextTipView iJv;
    private a iJw;
    private NavigationBar mNavigationBar;

    /* loaded from: classes3.dex */
    public interface a {
        void cgE();

        void cgF();

        void cgG();

        void cgH();

        void cgI();

        void cgJ();

        void cgK();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.dSP = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.iJw != null) {
                    if (view == c.this.cdX) {
                        c.this.iJw.onBackPressed();
                    } else if (view == c.this.iJk) {
                        c.this.iJw.cgE();
                    } else if (view == c.this.iJl) {
                        c.this.iJw.cgF();
                    } else if (view == c.this.iJm) {
                        c.this.iJw.cgH();
                    } else if (view == c.this.iJr) {
                        c.this.iJw.cgG();
                    } else if (view == c.this.iJn) {
                        c.this.iJw.cgI();
                    } else if (view == c.this.iJp) {
                        c.this.iJw.cgJ();
                    } else if (view == c.this.iJv) {
                        c.this.iJw.cgK();
                    }
                }
            }
        };
        this.iJs = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        g(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.iJs.getLayoutMode().setNightMode(i == 1);
        this.iJs.getLayoutMode().onModeChanged(this.fby);
        this.mNavigationBar.onChangeSkinType(this.iJs.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.fby = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.cdX = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
        this.iJk = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.iJl = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
        this.iJr = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
        this.iJq = secretSettingActivity.findViewById(R.id.divide_line_under_privacy_attention_group);
        this.iJm = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
        this.iJn = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.user_mute_list);
        this.iJp = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
        this.iJo = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
        this.cdX.setOnClickListener(this.dSP);
        this.iJk.setOnClickListener(this.dSP);
        this.iJn.setOnClickListener(this.dSP);
        this.iJr.setOnClickListener(this.dSP);
        this.iJl.setOnClickListener(this.dSP);
        this.iJm.setOnClickListener(this.dSP);
        this.iJp.setOnClickListener(this.dSP);
        this.iJt = this.iJs.findViewById(R.id.privacy_setting_container);
        this.iJu = this.iJs.getResources().getStringArray(R.array.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.iJr.setVisibility(0);
            this.iJq.setVisibility(0);
        } else {
            this.iJr.setVisibility(8);
            this.iJq.setVisibility(8);
        }
        this.iJv = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
        this.iJv.setOnClickListener(this.dSP);
    }

    public void a(a aVar) {
        this.iJw = aVar;
    }

    public void cgL() {
        this.iJk.recycle();
    }

    public void qk(boolean z) {
        if (z) {
            this.iJt.setVisibility(0);
        } else {
            this.iJt.setVisibility(8);
        }
        if (d.hI().ay("reply_private_setting_switch") == 1) {
            this.iJo.setVisibility(0);
            this.iJp.setVisibility(0);
            return;
        }
        this.iJo.setVisibility(8);
        this.iJp.setVisibility(8);
    }

    public void bl(String str, int i) {
        int i2 = i - 1;
        if (this.iJu != null && i2 < this.iJu.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.iJl.setTip(this.iJu[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.iJr.setTip(this.iJu[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.iJm.setTip(this.iJu[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.iJp.setTip(this.iJs.getString(R.string.all_person));
                } else {
                    this.iJp.setTip(this.iJu[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.iJu != null) {
            int length = this.iJu.length;
            int cgz = aVar.cgz() - 1;
            if (cgz < length && cgz >= 0) {
                this.iJr.setTip(this.iJu[cgz]);
            }
            int cgy = aVar.cgy() - 1;
            if (cgy < length && cgy >= 0) {
                this.iJl.setTip(this.iJu[cgy]);
            }
            int aqs = aVar.aqs() - 1;
            if (aqs < length && aqs >= 0) {
                this.iJm.setTip(this.iJu[aqs]);
            }
            int cgB = aVar.cgB() - 1;
            if (cgB < length && cgB >= 0) {
                if (cgB == 0) {
                    this.iJp.setTip(this.iJs.getString(R.string.all_person));
                } else {
                    this.iJp.setTip(this.iJu[cgB]);
                }
            }
        }
    }
}
