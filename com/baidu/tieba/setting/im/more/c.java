package com.baidu.tieba.setting.im.more;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.b.d;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.e;
import com.baidu.tieba.setting.more.MsgSettingItemView;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<SecretSettingActivity> {
    private View aEa;
    private View.OnClickListener cgg;
    private LinearLayout dfe;
    private a gFA;
    private TbSettingTextTipView gFm;
    private TbSettingTextTipView gFn;
    private TbSettingTextTipView gFo;
    private TbSettingTextTipView gFp;
    private MsgSettingItemView gFq;
    private View gFr;
    private TbSettingTextTipView gFs;
    private View gFt;
    private TbSettingTextTipView gFu;
    private SecretSettingActivity gFv;
    private View gFw;
    private String[] gFx;
    private TbSettingTextTipView gFy;
    private BdSwitchView.a gFz;
    private NavigationBar mNavigationBar;

    /* loaded from: classes3.dex */
    public interface a {
        void a(BdSwitchView.SwitchState switchState);

        void brK();

        void brL();

        void brM();

        void brN();

        void brO();

        void brP();

        void brQ();

        void onBackPressed();
    }

    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        this.mNavigationBar = null;
        this.cgg = new View.OnClickListener() { // from class: com.baidu.tieba.setting.im.more.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.gFA != null) {
                    if (view == c.this.aEa) {
                        c.this.gFA.onBackPressed();
                    } else if (view == c.this.gFm) {
                        c.this.gFA.brK();
                    } else if (view == c.this.gFn) {
                        c.this.gFA.brL();
                    } else if (view == c.this.gFo) {
                        c.this.gFA.brN();
                    } else if (view == c.this.gFu) {
                        c.this.gFA.brM();
                    } else if (view == c.this.gFp) {
                        c.this.gFA.brO();
                    } else if (view == c.this.gFs) {
                        c.this.gFA.brP();
                    } else if (view == c.this.gFy) {
                        c.this.gFA.brQ();
                    }
                }
            }
        };
        this.gFz = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.im.more.c.2
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == c.this.gFq.getSwitchView() && c.this.gFA != null) {
                    c.this.gFA.a(switchState);
                }
            }
        };
        this.gFv = secretSettingActivity;
        secretSettingActivity.setContentView(e.h.secret_setting_activity);
        g(secretSettingActivity);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.im.more.SecretSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.gFv.getLayoutMode().setNightMode(i == 1);
        this.gFv.getLayoutMode().onModeChanged(this.dfe);
        this.mNavigationBar.onChangeSkinType(this.gFv.getPageContext(), i);
        this.gFq.d(this.gFv.getPageContext(), i);
    }

    private void g(SecretSettingActivity secretSettingActivity) {
        this.dfe = (LinearLayout) secretSettingActivity.findViewById(e.g.parent);
        this.mNavigationBar = (NavigationBar) secretSettingActivity.findViewById(e.g.view_navigation_bar);
        this.aEa = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(secretSettingActivity.getPageContext().getString(e.j.secretSetting));
        this.gFm = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.black_address_list);
        this.gFn = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.privacy_attention_bar);
        this.gFu = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.privacy_attention_group);
        this.gFt = secretSettingActivity.findViewById(e.g.divide_line_under_privacy_attention_group);
        this.gFo = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.privacy_attention_live);
        this.gFp = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.user_mute_list);
        this.gFs = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.thread_reply_setting);
        this.gFr = secretSettingActivity.findViewById(e.g.container_thread_reply_setting);
        this.gFq = (MsgSettingItemView) this.gFv.findViewById(e.g.recently_bar_switch);
        this.gFq.setLineVisibility(false);
        this.gFq.setSpaceView(8);
        this.gFq.setText(e.j.privacy_hide_recently_bar_text);
        this.gFq.setOnSwitchStateChangeListener(this.gFz);
        mn(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
        this.aEa.setOnClickListener(this.cgg);
        this.gFm.setOnClickListener(this.cgg);
        this.gFp.setOnClickListener(this.cgg);
        this.gFu.setOnClickListener(this.cgg);
        this.gFn.setOnClickListener(this.cgg);
        this.gFo.setOnClickListener(this.cgg);
        this.gFs.setOnClickListener(this.cgg);
        this.gFw = this.gFv.findViewById(e.g.privacy_setting_container);
        this.gFx = this.gFv.getResources().getStringArray(e.b.privacy_setting_config);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
            this.gFu.setVisibility(0);
            this.gFt.setVisibility(0);
        } else {
            this.gFu.setVisibility(8);
            this.gFt.setVisibility(8);
        }
        this.gFy = (TbSettingTextTipView) secretSettingActivity.findViewById(e.g.privacy_permission);
        this.gFy.setOnClickListener(this.cgg);
    }

    public void a(a aVar) {
        this.gFA = aVar;
    }

    public void brR() {
        this.gFm.recycle();
    }

    public void mm(boolean z) {
        if (z) {
            this.gFw.setVisibility(0);
        } else {
            this.gFw.setVisibility(8);
        }
        if (d.iB().aO("reply_private_setting_switch") == 1) {
            this.gFr.setVisibility(0);
            this.gFs.setVisibility(0);
            return;
        }
        this.gFr.setVisibility(8);
        this.gFs.setVisibility(8);
    }

    public void aN(String str, int i) {
        int i2 = i - 1;
        if (this.gFx != null && i2 < this.gFx.length && i2 >= 0) {
            if (TextUtils.equals(str, "like")) {
                this.gFn.setTip(this.gFx[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.gFu.setTip(this.gFx[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.gFo.setTip(this.gFx[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.gFs.setTip(this.gFv.getString(e.j.all_person));
                } else {
                    this.gFs.setTip(this.gFx[i2]);
                }
            }
        }
    }

    public void d(com.baidu.tieba.setting.im.more.a aVar) {
        if (aVar != null && this.gFx != null) {
            int length = this.gFx.length;
            int brF = aVar.brF() - 1;
            if (brF < length && brF >= 0) {
                this.gFu.setTip(this.gFx[brF]);
            }
            int brE = aVar.brE() - 1;
            if (brE < length && brE >= 0) {
                this.gFn.setTip(this.gFx[brE]);
            }
            int Im = aVar.Im() - 1;
            if (Im < length && Im >= 0) {
                this.gFo.setTip(this.gFx[Im]);
            }
            int brH = aVar.brH() - 1;
            if (brH < length && brH >= 0) {
                if (brH == 0) {
                    this.gFs.setTip(this.gFv.getString(e.j.all_person));
                } else {
                    this.gFs.setTip(this.gFx[brH]);
                }
            }
        }
    }

    public void mn(boolean z) {
        if (z) {
            this.gFq.getSwitchView().nI();
        } else {
            this.gFq.getSwitchView().nJ();
        }
    }
}
