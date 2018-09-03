package com.baidu.tieba.setting.more;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class d extends com.baidu.adp.base.c<MoreActivity> {
    private TbSettingTextTipView gAa;
    private SettingTextVersionView gAb;
    private TbSettingTextTipView gAc;
    private TbSettingTextTipView gAd;
    private TbSettingTextNewDotView gAe;
    private TextView gAf;
    private RelativeLayout gAg;
    private View gAh;
    private View gAi;
    private View gAj;
    private View gAk;
    private View gAl;
    private View gAm;
    private View gAn;
    private RelativeLayout gAo;
    private BdSwitchView gAp;
    private MoreActivity gzP;
    private c gzQ;
    private AlertDialog gzR;
    private View gzS;
    private TbSettingTextTipView gzT;
    private SettingTextImageView gzU;
    private TbSettingTextTipView gzV;
    private TbSettingTextTipView gzW;
    private TbSettingTextTipView gzX;
    private MsgSettingItemView gzY;
    private TbSettingTextTipView gzZ;
    private NavigationBar mNavigationBar;

    public d(MoreActivity moreActivity, c cVar) {
        super(moreActivity.getPageContext());
        this.gAj = null;
        this.gAk = null;
        this.gAl = null;
        this.gAm = null;
        this.gAn = null;
        this.gAo = null;
        this.gAp = null;
        this.gzP = moreActivity;
        this.gzQ = cVar;
        this.gzP.setContentView(f.h.more_activity);
        FQ();
        bqh();
    }

    public void bqf() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.gzU.setVisibility(8);
        } else {
            this.gzU.setVisibility(0);
        }
    }

    public void S(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.gzU != null) {
                this.gzU.bri();
                return;
            }
            return;
        }
        this.gzU.brj();
        this.gzU.setIcon(str, z);
    }

    public void bqg() {
        if (this.gAb != null) {
            this.gAb.refresh();
        }
        if (this.gAe != null) {
            this.gAe.refresh();
        }
    }

    public void bqh() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.gAp.mE();
        } else {
            this.gAp.mF();
        }
    }

    public void sQ(int i) {
        if (i == 1) {
            if (TbadkCoreApplication.getInst().getSkinType() != 1) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new an("c10647").ae("obj_type", "1").ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
            } else {
                return;
            }
        } else if (i == 0) {
            if (TbadkCoreApplication.getInst().getSkinType() != 0) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.log(new an("c10647").ae("obj_type", "0").ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
            } else {
                return;
            }
        }
        BitmapHelper.clearCashBitmap();
    }

    public void bpj() {
        this.gzU.recycle();
        this.gzV.recycle();
        this.gzW.recycle();
        this.gzX.recycle();
        this.gzZ.recycle();
        this.gAa.recycle();
        this.gAb.recycle();
        this.gAc.recycle();
        this.gAd.recycle();
    }

    public void onChangeSkinType(int i) {
        ex(i);
        if (this.gzS != null) {
            this.gzP.getLayoutMode().setNightMode(i == 1);
            this.gzP.getLayoutMode().onModeChanged(this.gzS);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MoreActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void ex(int i) {
        am.j(this.gAg, f.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gzU.ex(i);
        this.gzP.getLayoutMode().setNightMode(i == 1);
        this.gzP.getLayoutMode().onModeChanged(this.gAg);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gzY.d(this.gzP.getPageContext(), i);
        bqg();
        this.gAp.setBackgroundRes(am.cT(f.C0146f.bg_switch_open), am.cT(f.C0146f.bg_switch_close), am.cT(f.C0146f.btn_handle));
        am.j(this.gAh, f.d.cp_bg_line_d);
    }

    private void FQ() {
        View.OnClickListener clickListener = getClickListener();
        this.gAg = (RelativeLayout) this.gzP.findViewById(f.g.parent);
        this.gAh = this.gzP.findViewById(f.g.scroll);
        this.gzP.findViewById(f.g.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.gzP.findViewById(f.g.view_navigation_bar);
        this.gAi = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.gzP.getPageContext().getString(f.j.setup));
        this.mNavigationBar.showBottomLine();
        this.gzT = (TbSettingTextTipView) this.gzP.findViewById(f.g.accountSafeSetting);
        this.gzU = (SettingTextImageView) this.gzP.findViewById(f.g.personInfo);
        this.gzV = (TbSettingTextTipView) this.gzP.findViewById(f.g.interest_label_setting);
        this.gzV.setTopLineVisibility(true);
        this.gzW = (TbSettingTextTipView) this.gzP.findViewById(f.g.accountManager);
        this.gzW.setTopLineVisibility(true);
        this.gzX = (TbSettingTextTipView) this.gzP.findViewById(f.g.browseSetting);
        this.gzX.setBottomLineVisibility(true);
        this.gzZ = (TbSettingTextTipView) this.gzP.findViewById(f.g.messageSetting);
        this.gzZ.setBottomLineVisibility(true);
        this.gzX.setBottomLineVisibility(true);
        this.gAa = (TbSettingTextTipView) this.gzP.findViewById(f.g.secretSetting);
        this.gAa.setBottomLineVisibility(true);
        this.gAb = (SettingTextVersionView) this.gzP.findViewById(f.g.versionInfo);
        this.gAc = (TbSettingTextTipView) this.gzP.findViewById(f.g.feedBack);
        this.gAc.setTopLineVisibility(true);
        this.gAc.setBottomLineVisibility(true);
        this.gAd = (TbSettingTextTipView) this.gzP.findViewById(f.g.recommend);
        this.gzY = (MsgSettingItemView) this.gzP.findViewById(f.g.memberAdSetting);
        bqi();
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.gAd.setVisibility(8);
            this.gAd.setBottomLineVisibility(false);
        } else {
            this.gAd.setVisibility(0);
            this.gAd.setBottomLineVisibility(true);
        }
        this.gAe = (TbSettingTextNewDotView) this.gzP.findViewById(f.g.systemhelpsetting);
        this.gAf = (TextView) this.gzP.findViewById(f.g.quit);
        this.gAo = (RelativeLayout) this.gzP.findViewById(f.g.eyeshield_mode);
        this.gAp = (BdSwitchView) this.gzP.findViewById(f.g.item_switch);
        l.a(this.gzP.getPageContext().getPageActivity(), this.gAp, 10, 10, 10, 10);
        this.gAj = this.gzP.findViewById(f.g.divide_view2);
        this.gAk = this.gzP.findViewById(f.g.divide_view1);
        this.gAl = this.gzP.findViewById(f.g.divide_view3);
        this.gAm = this.gzP.findViewById(f.g.divide_view4);
        this.gAn = this.gzP.findViewById(f.g.divide_view5);
        bqg();
        bqf();
        this.gzU.bri();
        ex(TbadkCoreApplication.getInst().getSkinType());
        this.gAk.setVisibility(0);
        this.gAl.setVisibility(0);
        this.gAm.setVisibility(0);
        this.gAn.setVisibility(0);
        T(clickListener);
        if (!bql()) {
            this.gzX.setTip(this.gzP.getResources().getString(f.j.browsing_settings_tip_no_night));
            this.gAj.setVisibility(8);
            this.gAo.setVisibility(8);
            return;
        }
        this.gAj.setVisibility(0);
        this.gAo.setVisibility(0);
    }

    private void bqi() {
        int i;
        int i2 = 0;
        this.gzY.setText(f.j.member_ad_setting_text);
        this.gzY.setTipImageResource(f.C0146f.label_red_svip);
        this.gzY.setOnSwitchStateChangeListener(this.gzP);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.gzY.setVisibility(8);
        } else if (i2 == 0) {
            this.gzY.mD();
        } else {
            this.gzY.mC();
        }
    }

    public void bqj() {
        this.gzY.mD();
    }

    public void bqk() {
        this.gzY.mC();
    }

    private boolean bql() {
        return MessageManager.getInstance().runTask(2001281, Boolean.class) != null;
    }

    private void bcV() {
        this.gzS = LayoutInflater.from(this.gzP.getPageContext().getPageActivity()).inflate(f.h.quit_dialog, (ViewGroup) null);
        this.gzP.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gzP.getLayoutMode().onModeChanged(this.gzS);
        ((TextView) this.gzS.findViewById(f.g.id_close_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.ZD();
                d.this.gzQ.sL(11);
            }
        });
        ((TextView) this.gzS.findViewById(f.g.id_quit_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.ZD();
                d.this.gzQ.sL(12);
            }
        });
        this.gzR = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
        this.gzR.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.g.a(this.gzR, this.mContext.getPageActivity());
        if (this.gzR.getWindow() != null) {
            WindowManager.LayoutParams attributes = this.gzR.getWindow().getAttributes();
            attributes.dimAmount = 0.7f;
            this.gzR.getWindow().setAttributes(attributes);
            this.gzR.getWindow().setContentView(this.gzS);
        }
    }

    private void T(View.OnClickListener onClickListener) {
        this.gzT.setOnClickListener(onClickListener);
        this.gAi.setOnClickListener(onClickListener);
        this.gzU.setOnClickListener(onClickListener);
        this.gzV.setOnClickListener(onClickListener);
        this.gzW.setOnClickListener(onClickListener);
        this.gzX.setOnClickListener(onClickListener);
        this.gzZ.setOnClickListener(onClickListener);
        this.gAa.setOnClickListener(onClickListener);
        this.gAb.setOnClickListener(onClickListener);
        this.gAc.setOnClickListener(onClickListener);
        this.gAd.setOnClickListener(onClickListener);
        this.gAe.setOnClickListener(onClickListener);
        this.gAf.setOnClickListener(onClickListener);
        this.gAp.setOnSwitchStateChangeListener(this.gzP);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == d.this.gAi) {
                    d.this.gzQ.sL(0);
                } else if (view == d.this.gzU) {
                    d.this.gzQ.sL(1);
                } else if (view == d.this.gzV) {
                    d.this.gzQ.sL(15);
                } else if (view == d.this.gzW) {
                    d.this.gzQ.sL(2);
                } else if (view == d.this.gzX) {
                    d.this.gzQ.sL(3);
                } else if (view == d.this.gzZ) {
                    d.this.gzQ.sL(4);
                } else if (view == d.this.gAa) {
                    d.this.gzQ.sL(9);
                } else if (view == d.this.gAb) {
                    d.this.gzQ.sL(6);
                } else if (view == d.this.gAc) {
                    d.this.gzQ.sL(7);
                } else if (view == d.this.gAd) {
                    d.this.gzQ.sL(8);
                } else if (view == d.this.gAe) {
                    d.this.gzQ.sL(5);
                } else if (view == d.this.gAf) {
                    d.this.gzQ.sL(10);
                } else if (view == d.this.gzT) {
                    d.this.gzQ.sL(13);
                }
            }
        };
    }

    public void bqm() {
        if (this.gzR == null) {
            bcV();
        }
        com.baidu.adp.lib.g.g.a(this.gzR, this.gzP.getPageContext());
    }

    public void ZD() {
        if (this.gzR != null) {
            com.baidu.adp.lib.g.g.b(this.gzR, this.gzP.getPageContext());
        }
    }

    public BdSwitchView bqn() {
        return this.gAp;
    }
}
