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
    private View cgb;
    private View.OnClickListener dYB;
    private LinearLayout fiN;
    private TbSettingTextTipView iTg;
    private TbSettingTextTipView iTh;
    private TbSettingTextTipView iTi;
    private TbSettingTextTipView iTj;
    private View iTk;
    private TbSettingTextTipView iTl;
    private TbSettingTextTipView iTm;
    private SecretSettingActivity iTn;
    private View iTo;
    private String[] iTp;
    private TbSettingTextTipView iTq;
    private a iTr;
    private NavigationBar mNavigationBar;

    /* loaded from: classes3.dex */
    public interface a {
        void ckA();

        void ckB();

        void ckC();

        void ckD();

        void ckE();

        void ckF();

        void ckG();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.dYB = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.iTr != null) {
                    if (view == c.this.cgb) {
                        c.this.iTr.onBackPressed();
                    } else if (view == c.this.iTg) {
                        c.this.iTr.ckA();
                    } else if (view == c.this.iTh) {
                        c.this.iTr.ckB();
                    } else if (view == c.this.iTi) {
                        c.this.iTr.ckD();
                    } else if (view == c.this.iTm) {
                        c.this.iTr.ckC();
                    } else if (view == c.this.iTj) {
                        c.this.iTr.ckE();
                    } else if (view == c.this.iTl) {
                        c.this.iTr.ckF();
                    } else if (view == c.this.iTq) {
                        c.this.iTr.ckG();
                    }
                }
            }
        };
        this.iTn = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        g(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.iTn.getLayoutMode().setNightMode(i == 1);
        this.iTn.getLayoutMode().onModeChanged(this.fiN);
        this.mNavigationBar.onChangeSkinType(this.iTn.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.fiN = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.cgb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
        this.iTg = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.iTh = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
        this.iTm = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
        this.iTi = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
        this.iTj = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.user_mute_list);
        this.iTl = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
        this.iTk = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
        this.cgb.setOnClickListener(this.dYB);
        this.iTg.setOnClickListener(this.dYB);
        this.iTj.setOnClickListener(this.dYB);
        this.iTm.setOnClickListener(this.dYB);
        this.iTh.setOnClickListener(this.dYB);
        this.iTi.setOnClickListener(this.dYB);
        this.iTl.setOnClickListener(this.dYB);
        this.iTo = this.iTn.findViewById(R.id.privacy_setting_container);
        this.iTp = this.iTn.getResources().getStringArray(R.array.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.iTm.setVisibility(0);
        } else {
            this.iTm.setVisibility(8);
        }
        this.iTq = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
        this.iTq.setOnClickListener(this.dYB);
    }

    public void a(a aVar) {
        this.iTr = aVar;
    }

    public void ckH() {
        this.iTg.recycle();
    }

    public void qE(boolean z) {
        if (z) {
            this.iTo.setVisibility(0);
        } else {
            this.iTo.setVisibility(8);
        }
        if (d.hS().az("reply_private_setting_switch") == 1) {
            this.iTk.setVisibility(0);
            this.iTl.setVisibility(0);
            return;
        }
        this.iTk.setVisibility(8);
        this.iTl.setVisibility(8);
    }

    public void bo(String str, int i) {
        int i2 = i - 1;
        if (this.iTp != null && i2 < this.iTp.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.iTh.setTip(this.iTp[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.iTm.setTip(this.iTp[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.iTi.setTip(this.iTp[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.iTl.setTip(this.iTn.getString(R.string.all_person));
                } else {
                    this.iTl.setTip(this.iTp[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.iTp != null) {
            int length = this.iTp.length;
            int ckv = aVar.ckv() - 1;
            if (ckv < length && ckv >= 0) {
                this.iTm.setTip(this.iTp[ckv]);
            }
            int cku = aVar.cku() - 1;
            if (cku < length && cku >= 0) {
                this.iTh.setTip(this.iTp[cku]);
            }
            int arL = aVar.arL() - 1;
            if (arL < length && arL >= 0) {
                this.iTi.setTip(this.iTp[arL]);
            }
            int ckx = aVar.ckx() - 1;
            if (ckx < length && ckx >= 0) {
                if (ckx == 0) {
                    this.iTl.setTip(this.iTn.getString(R.string.all_person));
                } else {
                    this.iTl.setTip(this.iTp[ckx]);
                }
            }
        }
    }
}
