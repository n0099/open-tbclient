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
    private View cdY;
    private View.OnClickListener dSP;
    private LinearLayout fby;
    private a iJA;
    private TbSettingTextTipView iJo;
    private TbSettingTextTipView iJp;
    private TbSettingTextTipView iJq;
    private TbSettingTextTipView iJr;
    private View iJs;
    private TbSettingTextTipView iJt;
    private View iJu;
    private TbSettingTextTipView iJv;
    private SecretSettingActivity iJw;
    private View iJx;
    private String[] iJy;
    private TbSettingTextTipView iJz;
    private NavigationBar mNavigationBar;

    /* loaded from: classes3.dex */
    public interface a {
        void cgF();

        void cgG();

        void cgH();

        void cgI();

        void cgJ();

        void cgK();

        void cgL();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.dSP = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.iJA != null) {
                    if (view == c.this.cdY) {
                        c.this.iJA.onBackPressed();
                    } else if (view == c.this.iJo) {
                        c.this.iJA.cgF();
                    } else if (view == c.this.iJp) {
                        c.this.iJA.cgG();
                    } else if (view == c.this.iJq) {
                        c.this.iJA.cgI();
                    } else if (view == c.this.iJv) {
                        c.this.iJA.cgH();
                    } else if (view == c.this.iJr) {
                        c.this.iJA.cgJ();
                    } else if (view == c.this.iJt) {
                        c.this.iJA.cgK();
                    } else if (view == c.this.iJz) {
                        c.this.iJA.cgL();
                    }
                }
            }
        };
        this.iJw = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        g(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        this.iJw.getLayoutMode().setNightMode(i == 1);
        this.iJw.getLayoutMode().onModeChanged(this.fby);
        this.mNavigationBar.onChangeSkinType(this.iJw.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.fby = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
        this.cdY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
        this.iJo = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
        this.iJp = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
        this.iJv = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
        this.iJu = secretSettingActivity.findViewById(R.id.divide_line_under_privacy_attention_group);
        this.iJq = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
        this.iJr = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.user_mute_list);
        this.iJt = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
        this.iJs = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
        this.cdY.setOnClickListener(this.dSP);
        this.iJo.setOnClickListener(this.dSP);
        this.iJr.setOnClickListener(this.dSP);
        this.iJv.setOnClickListener(this.dSP);
        this.iJp.setOnClickListener(this.dSP);
        this.iJq.setOnClickListener(this.dSP);
        this.iJt.setOnClickListener(this.dSP);
        this.iJx = this.iJw.findViewById(R.id.privacy_setting_container);
        this.iJy = this.iJw.getResources().getStringArray(R.array.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.iJv.setVisibility(0);
            this.iJu.setVisibility(0);
        } else {
            this.iJv.setVisibility(8);
            this.iJu.setVisibility(8);
        }
        this.iJz = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
        this.iJz.setOnClickListener(this.dSP);
    }

    public void a(a aVar) {
        this.iJA = aVar;
    }

    public void cgM() {
        this.iJo.recycle();
    }

    public void ql(boolean z) {
        if (z) {
            this.iJx.setVisibility(0);
        } else {
            this.iJx.setVisibility(8);
        }
        if (d.hI().ay("reply_private_setting_switch") == 1) {
            this.iJs.setVisibility(0);
            this.iJt.setVisibility(0);
            return;
        }
        this.iJs.setVisibility(8);
        this.iJt.setVisibility(8);
    }

    public void bl(String str, int i) {
        int i2 = i - 1;
        if (this.iJy != null && i2 < this.iJy.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.iJp.setTip(this.iJy[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.iJv.setTip(this.iJy[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.iJq.setTip(this.iJy[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.iJt.setTip(this.iJw.getString(R.string.all_person));
                } else {
                    this.iJt.setTip(this.iJy[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.iJy != null) {
            int length = this.iJy.length;
            int cgA = aVar.cgA() - 1;
            if (cgA < length && cgA >= 0) {
                this.iJv.setTip(this.iJy[cgA]);
            }
            int cgz = aVar.cgz() - 1;
            if (cgz < length && cgz >= 0) {
                this.iJp.setTip(this.iJy[cgz]);
            }
            int aqs = aVar.aqs() - 1;
            if (aqs < length && aqs >= 0) {
                this.iJq.setTip(this.iJy[aqs]);
            }
            int cgC = aVar.cgC() - 1;
            if (cgC < length && cgC >= 0) {
                if (cgC == 0) {
                    this.iJt.setTip(this.iJw.getString(R.string.all_person));
                } else {
                    this.iJt.setTip(this.iJy[cgC]);
                }
            }
        }
    }
}
