package com.baidu.tieba.setting.more;

import android.os.Build;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationManagerCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class e extends com.baidu.adp.base.d<MoreActivity> {
    private NavigationBar mNavigationBar;
    private MoreActivity mWK;
    private d mWL;
    private com.baidu.tbadk.core.dialog.i mWN;
    private k mWO;
    private SettingTextNormalImageView mWP;
    private SettingTextImageView mWQ;
    private TbSettingTextTipView mWR;
    private TbSettingTextTipView mWS;
    private TbSettingTextTipView mWT;
    private TbSettingTextTipView mWU;
    private TbSettingTextTipView mWV;
    private TbSettingTextTipView mWW;
    private TbSettingTextTipView mWX;
    private SettingTextVersionView mWY;
    private TbSettingTextTipView mWZ;
    private TbSettingTextTipView mXa;
    private TbSettingTextNewDotView mXb;
    private TextView mXc;
    private RelativeLayout mXd;
    private View mXe;
    private View mXf;
    private View mXg;
    private View mXh;
    private View mXi;
    private View mXj;
    private View mXk;
    private RelativeLayout mXl;
    private BdSwitchView mXm;
    private RelativeLayout mXn;
    private BdSwitchView mXo;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.mXg = null;
        this.mXh = null;
        this.mXi = null;
        this.mXj = null;
        this.mXk = null;
        this.mXl = null;
        this.mXm = null;
        this.mXn = null;
        this.mXo = null;
        this.mWK = moreActivity;
        this.mWL = dVar;
        this.mWK.setContentView(R.layout.more_activity);
        bzm();
        dFf();
    }

    public void dFd() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.mWQ.setVisibility(8);
        } else {
            this.mWQ.setVisibility(0);
        }
    }

    public void bc(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.mWQ != null) {
                this.mWQ.dGm();
                return;
            }
            return;
        }
        this.mWQ.dGn();
        this.mWQ.setIcon(str, z);
    }

    public void dFe() {
        if (this.mWY != null) {
            this.mWY.refresh();
        }
        if (this.mXb != null) {
            this.mXb.refresh();
        }
    }

    public void dFf() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.mXm.turnOn();
        } else {
            this.mXm.turnOff();
        }
    }

    public void Iq(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != i) {
            if (i == 1) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.SET_NIGHT_MODE).dW("obj_type", "1").dW("obj_source", "0"));
            } else if (i == 0 || i == 4) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.SET_NIGHT_MODE).dW("obj_type", "0").dW("obj_source", "0"));
            }
            BitmapHelper.clearCashBitmap();
        }
    }

    public void dEe() {
        this.mWQ.recycle();
        this.mWR.recycle();
        this.mWS.recycle();
        this.mWT.recycle();
        this.mWU.recycle();
        this.mWW.recycle();
        this.mWX.recycle();
        this.mWY.recycle();
        this.mWZ.recycle();
        this.mXa.recycle();
    }

    public void onChangeSkinType(int i) {
        qE(i);
        if (this.mWO != null) {
            this.mWK.getLayoutMode().setNightMode(i == 1);
            this.mWK.getLayoutMode().onModeChanged(this.mWO.getView());
        }
        if (i == 1) {
            this.mXm.turnOnNoCallback();
        } else {
            this.mXm.turnOffNoCallback();
        }
    }

    public void qE(int i) {
        ao.setBackgroundColor(this.mXd, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mWQ.qE(i);
        this.mWK.getLayoutMode().setNightMode(i == 1);
        this.mWK.getLayoutMode().onModeChanged(this.mXd);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        dFe();
        this.mXm.setBackgroundRes(ao.getBitmap(R.drawable.bg_switch_open), ao.getBitmap(R.drawable.bg_switch_close), ao.getBitmap(R.drawable.btn_handle));
        this.mXo.setBackgroundRes(ao.getBitmap(R.drawable.bg_switch_open), ao.getBitmap(R.drawable.bg_switch_close), ao.getBitmap(R.drawable.btn_handle));
        ao.setBackgroundColor(this.mXe, R.color.CAM_X0201);
        this.mWP.setLocalIcon(ao.ov(R.drawable.icon_mine_list_baidu));
        if (this.mWO != null) {
            this.mWO.onChangeSkinType();
        }
        this.mWP.qE(i);
        this.mWQ.qE(i);
        this.mWR.onChangeSkinType(i);
        this.mWS.onChangeSkinType(i);
        this.mWT.onChangeSkinType(i);
        this.mWU.onChangeSkinType(i);
        this.mWV.onChangeSkinType(i);
        this.mWW.onChangeSkinType(i);
        this.mWX.onChangeSkinType(i);
        this.mWY.onChangeSkinType(i);
        this.mWZ.onChangeSkinType(i);
        this.mXa.onChangeSkinType(i);
        this.mXb.onChangeSkinType(i);
    }

    private void bzm() {
        View.OnClickListener clickListener = getClickListener();
        this.mXd = (RelativeLayout) this.mWK.findViewById(R.id.parent);
        this.mXe = this.mWK.findViewById(R.id.scroll);
        this.mWK.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.mWK.findViewById(R.id.view_navigation_bar);
        this.mXf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.mWK.getPageContext().getString(R.string.setup));
        this.mNavigationBar.showBottomLine();
        this.mWP = (SettingTextNormalImageView) this.mWK.findViewById(R.id.accountSafeSetting);
        this.mWQ = (SettingTextImageView) this.mWK.findViewById(R.id.personInfo);
        this.mWR = (TbSettingTextTipView) this.mWK.findViewById(R.id.interest_label_setting);
        this.mWR.setTopLineVisibility(true);
        this.mWS = (TbSettingTextTipView) this.mWK.findViewById(R.id.accountManager);
        this.mWS.setTopLineVisibility(true);
        this.mWT = (TbSettingTextTipView) this.mWK.findViewById(R.id.browseSetting);
        this.mWT.setBottomLineVisibility(true);
        this.mWU = (TbSettingTextTipView) this.mWK.findViewById(R.id.youngsterSetting);
        this.mWU.setBottomLineVisibility(true);
        if (com.baidu.tbadk.youngster.b.c.bIM()) {
            this.mWU.setTip(this.mWK.getString(R.string.youngster_settings_tip_open));
        } else {
            this.mWU.setTip(this.mWK.getString(R.string.youngster_settings_tip_close));
        }
        this.mWV = (TbSettingTextTipView) this.mWK.findViewById(R.id.adSetting);
        this.mWV.setBottomLineVisibility(true);
        this.mWW = (TbSettingTextTipView) this.mWK.findViewById(R.id.messageSetting);
        this.mWW.setBottomLineVisibility(true);
        this.mWT.setBottomLineVisibility(true);
        this.mWX = (TbSettingTextTipView) this.mWK.findViewById(R.id.secretSetting);
        this.mWX.setBottomLineVisibility(true);
        this.mWY = (SettingTextVersionView) this.mWK.findViewById(R.id.versionInfo);
        this.mWZ = (TbSettingTextTipView) this.mWK.findViewById(R.id.feedBack);
        this.mWZ.setTopLineVisibility(true);
        this.mWZ.setBottomLineVisibility(true);
        this.mXa = (TbSettingTextTipView) this.mWK.findViewById(R.id.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.mXa.setVisibility(8);
            this.mXa.setBottomLineVisibility(false);
        } else {
            this.mXa.setVisibility(0);
            this.mXa.setBottomLineVisibility(true);
        }
        this.mXb = (TbSettingTextNewDotView) this.mWK.findViewById(R.id.systemhelpsetting);
        this.mXc = (TextView) this.mWK.findViewById(R.id.quit);
        this.mXl = (RelativeLayout) this.mWK.findViewById(R.id.eyeshield_mode);
        this.mXm = (BdSwitchView) this.mWK.findViewById(R.id.item_switch);
        l.addToParentArea(this.mWK.getPageContext().getPageActivity(), this.mXm, 10, 10, 10, 10);
        this.mXn = (RelativeLayout) this.mWK.findViewById(R.id.follow_system_day_night_mode);
        this.mXo = (BdSwitchView) this.mWK.findViewById(R.id.follow_system_item_switch);
        l.addToParentArea(this.mWK.getPageContext().getPageActivity(), this.mXo, 10, 10, 10, 10);
        this.mXg = this.mWK.findViewById(R.id.divide_view2);
        this.mXh = this.mWK.findViewById(R.id.divide_view1);
        this.mXi = this.mWK.findViewById(R.id.divide_view3);
        this.mXj = this.mWK.findViewById(R.id.divide_view4);
        this.mXk = this.mWK.findViewById(R.id.divide_view5);
        dFe();
        dFd();
        this.mWQ.dGm();
        qE(TbadkCoreApplication.getInst().getSkinType());
        this.mXh.setVisibility(0);
        this.mXi.setVisibility(0);
        this.mXj.setVisibility(0);
        this.mXk.setVisibility(0);
        ag(clickListener);
        if (!dFg()) {
            this.mWT.setTip(this.mWK.getResources().getString(R.string.browsing_settings_tip_no_night));
            this.mXg.setVisibility(8);
            this.mXl.setVisibility(8);
        } else {
            this.mXg.setVisibility(0);
            this.mXl.setVisibility(0);
        }
        this.mXn.setVisibility(dFh() ? 0 : 8);
        if (com.baidu.tbadk.core.sharedPref.b.brx().getBoolean("key_is_follow_system_mode", false)) {
            this.mXo.turnOnNoCallback();
        } else {
            this.mXo.turnOffNoCallback();
        }
    }

    private boolean dFg() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private boolean dFh() {
        if (dFg()) {
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return com.baidu.tbadk.core.sharedPref.b.brx().getBoolean("key_is_dark_mode_notify_shown", false);
        }
        return false;
    }

    private void apI() {
        this.mWO = new k(getPageContext().getPageActivity());
        this.mWO.setTitleText(getPageContext().getString(R.string.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getPageContext().getString(R.string.quite_current_account), this.mWO);
        gVar.setTextColor(R.color.CAM_X0301);
        arrayList.add(gVar);
        this.mWK.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.mWK.getLayoutMode().onModeChanged(this.mWO.getView());
        k.c cVar = new k.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (i == gVar.getId()) {
                    e.this.Ek();
                    e.this.mWL.Il(12);
                }
            }
        };
        k.a aVar = new k.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                e.this.Ek();
            }
        };
        this.mWO.bB(arrayList);
        this.mWO.a(cVar);
        this.mWO.a(aVar);
        this.mWN = new com.baidu.tbadk.core.dialog.i(this.mContext);
        this.mWN.setCanceledOnTouchOutside(true);
        this.mWN.a(this.mWO);
    }

    private void ag(View.OnClickListener onClickListener) {
        this.mWP.setOnClickListener(onClickListener);
        this.mXf.setOnClickListener(onClickListener);
        this.mWQ.setOnClickListener(onClickListener);
        this.mWR.setOnClickListener(onClickListener);
        this.mWS.setOnClickListener(onClickListener);
        this.mWT.setOnClickListener(onClickListener);
        this.mWU.setOnClickListener(onClickListener);
        this.mWV.setOnClickListener(onClickListener);
        this.mWW.setOnClickListener(onClickListener);
        this.mWX.setOnClickListener(onClickListener);
        this.mWY.setOnClickListener(onClickListener);
        this.mWZ.setOnClickListener(onClickListener);
        this.mXa.setOnClickListener(onClickListener);
        this.mXb.setOnClickListener(onClickListener);
        this.mXc.setOnClickListener(onClickListener);
        this.mXm.setOnSwitchStateChangeListener(this.mWK);
        this.mXo.setOnSwitchStateChangeListener(this.mWK);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.mXf) {
                    e.this.mWL.Il(0);
                } else if (view == e.this.mWQ) {
                    e.this.mWL.Il(1);
                } else if (view == e.this.mWR) {
                    e.this.mWL.Il(15);
                } else if (view == e.this.mWS) {
                    e.this.mWL.Il(2);
                } else if (view == e.this.mWT) {
                    e.this.mWL.Il(3);
                } else if (view == e.this.mWU) {
                    e.this.mWL.Il(17);
                } else if (view == e.this.mWW) {
                    e.this.mWL.Il(4);
                } else if (view == e.this.mWX) {
                    e.this.mWL.Il(9);
                } else if (view == e.this.mWY) {
                    e.this.mWL.Il(6);
                } else if (view == e.this.mWZ) {
                    e.this.mWL.Il(7);
                } else if (view == e.this.mXa) {
                    e.this.mWL.Il(8);
                } else if (view == e.this.mXb) {
                    e.this.mWL.Il(5);
                } else if (view == e.this.mXc) {
                    e.this.mWL.Il(10);
                } else if (view == e.this.mWP) {
                    e.this.mWL.Il(13);
                } else if (view == e.this.mWV) {
                    e.this.mWL.Il(16);
                }
            }
        };
    }

    public void dFi() {
        if (this.mWN == null) {
            apI();
        }
        this.mWN.Pd();
    }

    public void Ek() {
        if (this.mWN != null) {
            this.mWN.dismiss();
        }
    }

    public BdSwitchView dFj() {
        return this.mXm;
    }

    public BdSwitchView dFk() {
        return this.mXo;
    }

    public void onResume() {
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.mWK).areNotificationsEnabled();
        if (this.mWW != null) {
            this.mWW.setTipViewColor(R.color.CAM_X0105);
            this.mWW.setTip(areNotificationsEnabled ? "" : this.mWK.getString(R.string.may_lose_important_msg));
        }
    }
}
