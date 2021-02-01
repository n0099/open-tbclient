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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class e extends com.baidu.adp.base.d<MoreActivity> {
    private NavigationBar mNavigationBar;
    private TbSettingTextTipView ngA;
    private TbSettingTextTipView ngB;
    private TbSettingTextTipView ngC;
    private TbSettingTextTipView ngD;
    private TbSettingTextTipView ngE;
    private TbSettingTextTipView ngF;
    private SettingTextVersionView ngG;
    private TbSettingTextTipView ngH;
    private TbSettingTextTipView ngI;
    private TbSettingTextNewDotView ngJ;
    private TextView ngK;
    private RelativeLayout ngL;
    private View ngM;
    private View ngN;
    private View ngO;
    private View ngP;
    private View ngQ;
    private View ngR;
    private View ngS;
    private RelativeLayout ngT;
    private BdSwitchView ngU;
    private RelativeLayout ngV;
    private BdSwitchView ngW;
    private MoreActivity ngt;
    private d ngu;
    private com.baidu.tbadk.core.dialog.i ngv;
    private k ngw;
    private SettingTextNormalImageView ngx;
    private SettingTextImageView ngy;
    private TbSettingTextTipView ngz;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.ngO = null;
        this.ngP = null;
        this.ngQ = null;
        this.ngR = null;
        this.ngS = null;
        this.ngT = null;
        this.ngU = null;
        this.ngV = null;
        this.ngW = null;
        this.ngt = moreActivity;
        this.ngu = dVar;
        this.ngt.setContentView(R.layout.more_activity);
        bzE();
        dHq();
    }

    public void dHo() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.ngy.setVisibility(8);
        } else {
            this.ngy.setVisibility(0);
        }
    }

    public void bc(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.ngy != null) {
                this.ngy.dIx();
                return;
            }
            return;
        }
        this.ngy.dIy();
        this.ngy.setIcon(str, z);
    }

    public void dHp() {
        if (this.ngG != null) {
            this.ngG.refresh();
        }
        if (this.ngJ != null) {
            this.ngJ.refresh();
        }
    }

    public void dHq() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.ngU.turnOn();
        } else {
            this.ngU.turnOff();
        }
    }

    public void IK(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != i) {
            if (i == 1) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.SET_NIGHT_MODE).dR("obj_type", "1").dR("obj_source", "0"));
            } else if (i == 0 || i == 4) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.SET_NIGHT_MODE).dR("obj_type", "0").dR("obj_source", "0"));
            }
            BitmapHelper.clearCashBitmap();
        }
    }

    public void dGp() {
        this.ngy.recycle();
        this.ngz.recycle();
        this.ngA.recycle();
        this.ngB.recycle();
        this.ngC.recycle();
        this.ngE.recycle();
        this.ngF.recycle();
        this.ngG.recycle();
        this.ngH.recycle();
        this.ngI.recycle();
    }

    public void onChangeSkinType(int i) {
        qJ(i);
        if (this.ngw != null) {
            this.ngt.getLayoutMode().setNightMode(i == 1);
            this.ngt.getLayoutMode().onModeChanged(this.ngw.getView());
        }
        if (i == 1) {
            this.ngU.turnOnNoCallback();
        } else {
            this.ngU.turnOffNoCallback();
        }
    }

    public void qJ(int i) {
        ap.setBackgroundColor(this.ngL, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.ngy.qJ(i);
        this.ngt.getLayoutMode().setNightMode(i == 1);
        this.ngt.getLayoutMode().onModeChanged(this.ngL);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        dHp();
        this.ngU.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        this.ngW.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        ap.setBackgroundColor(this.ngM, R.color.CAM_X0201);
        this.ngx.setLocalIcon(ap.oA(R.drawable.icon_mine_list_baidu));
        if (this.ngw != null) {
            this.ngw.onChangeSkinType();
        }
        this.ngx.qJ(i);
        this.ngy.qJ(i);
        this.ngz.onChangeSkinType(i);
        this.ngA.onChangeSkinType(i);
        this.ngB.onChangeSkinType(i);
        this.ngC.onChangeSkinType(i);
        this.ngD.onChangeSkinType(i);
        this.ngE.onChangeSkinType(i);
        this.ngF.onChangeSkinType(i);
        this.ngG.onChangeSkinType(i);
        this.ngH.onChangeSkinType(i);
        this.ngI.onChangeSkinType(i);
        this.ngJ.onChangeSkinType(i);
    }

    private void bzE() {
        View.OnClickListener clickListener = getClickListener();
        this.ngL = (RelativeLayout) this.ngt.findViewById(R.id.parent);
        this.ngM = this.ngt.findViewById(R.id.scroll);
        this.ngt.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.ngt.findViewById(R.id.view_navigation_bar);
        this.ngN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.ngt.getPageContext().getString(R.string.setup));
        this.mNavigationBar.showBottomLine();
        this.ngx = (SettingTextNormalImageView) this.ngt.findViewById(R.id.accountSafeSetting);
        this.ngy = (SettingTextImageView) this.ngt.findViewById(R.id.personInfo);
        this.ngz = (TbSettingTextTipView) this.ngt.findViewById(R.id.interest_label_setting);
        this.ngz.setTopLineVisibility(true);
        this.ngA = (TbSettingTextTipView) this.ngt.findViewById(R.id.accountManager);
        this.ngA.setTopLineVisibility(true);
        this.ngB = (TbSettingTextTipView) this.ngt.findViewById(R.id.browseSetting);
        this.ngB.setBottomLineVisibility(true);
        this.ngC = (TbSettingTextTipView) this.ngt.findViewById(R.id.youngsterSetting);
        this.ngC.setBottomLineVisibility(true);
        if (com.baidu.tbadk.youngster.b.c.bJf()) {
            this.ngC.setTip(this.ngt.getString(R.string.youngster_settings_tip_open));
        } else {
            this.ngC.setTip(this.ngt.getString(R.string.youngster_settings_tip_close));
        }
        this.ngD = (TbSettingTextTipView) this.ngt.findViewById(R.id.adSetting);
        this.ngD.setBottomLineVisibility(true);
        this.ngE = (TbSettingTextTipView) this.ngt.findViewById(R.id.messageSetting);
        this.ngE.setBottomLineVisibility(true);
        this.ngB.setBottomLineVisibility(true);
        this.ngF = (TbSettingTextTipView) this.ngt.findViewById(R.id.secretSetting);
        this.ngF.setBottomLineVisibility(true);
        this.ngG = (SettingTextVersionView) this.ngt.findViewById(R.id.versionInfo);
        this.ngH = (TbSettingTextTipView) this.ngt.findViewById(R.id.feedBack);
        this.ngH.setTopLineVisibility(true);
        this.ngH.setBottomLineVisibility(true);
        this.ngI = (TbSettingTextTipView) this.ngt.findViewById(R.id.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.ngI.setVisibility(8);
            this.ngI.setBottomLineVisibility(false);
        } else {
            this.ngI.setVisibility(0);
            this.ngI.setBottomLineVisibility(true);
        }
        this.ngJ = (TbSettingTextNewDotView) this.ngt.findViewById(R.id.systemhelpsetting);
        this.ngK = (TextView) this.ngt.findViewById(R.id.quit);
        this.ngT = (RelativeLayout) this.ngt.findViewById(R.id.eyeshield_mode);
        this.ngU = (BdSwitchView) this.ngt.findViewById(R.id.item_switch);
        l.addToParentArea(this.ngt.getPageContext().getPageActivity(), this.ngU, 10, 10, 10, 10);
        this.ngV = (RelativeLayout) this.ngt.findViewById(R.id.follow_system_day_night_mode);
        this.ngW = (BdSwitchView) this.ngt.findViewById(R.id.follow_system_item_switch);
        l.addToParentArea(this.ngt.getPageContext().getPageActivity(), this.ngW, 10, 10, 10, 10);
        this.ngO = this.ngt.findViewById(R.id.divide_view2);
        this.ngP = this.ngt.findViewById(R.id.divide_view1);
        this.ngQ = this.ngt.findViewById(R.id.divide_view3);
        this.ngR = this.ngt.findViewById(R.id.divide_view4);
        this.ngS = this.ngt.findViewById(R.id.divide_view5);
        dHp();
        dHo();
        this.ngy.dIx();
        qJ(TbadkCoreApplication.getInst().getSkinType());
        this.ngP.setVisibility(0);
        this.ngQ.setVisibility(0);
        this.ngR.setVisibility(0);
        this.ngS.setVisibility(0);
        ag(clickListener);
        if (!dHr()) {
            this.ngB.setTip(this.ngt.getResources().getString(R.string.browsing_settings_tip_no_night));
            this.ngO.setVisibility(8);
            this.ngT.setVisibility(8);
        } else {
            this.ngO.setVisibility(0);
            this.ngT.setVisibility(0);
        }
        this.ngV.setVisibility(dHs() ? 0 : 8);
        if (com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("key_is_follow_system_mode", false)) {
            this.ngW.turnOnNoCallback();
        } else {
            this.ngW.turnOffNoCallback();
        }
    }

    private boolean dHr() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private boolean dHs() {
        if (dHr()) {
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("key_is_dark_mode_notify_shown", false);
        }
        return false;
    }

    private void aqg() {
        this.ngw = new k(getPageContext().getPageActivity());
        this.ngw.setTitleText(getPageContext().getString(R.string.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getPageContext().getString(R.string.quite_current_account), this.ngw);
        gVar.setTextColor(R.color.CAM_X0301);
        arrayList.add(gVar);
        this.ngt.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.ngt.getLayoutMode().onModeChanged(this.ngw.getView());
        k.c cVar = new k.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (i == gVar.getId()) {
                    e.this.FA();
                    e.this.ngu.IF(12);
                }
            }
        };
        k.a aVar = new k.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                e.this.FA();
            }
        };
        this.ngw.bw(arrayList);
        this.ngw.a(cVar);
        this.ngw.a(aVar);
        this.ngv = new com.baidu.tbadk.core.dialog.i(this.mContext);
        this.ngv.setCanceledOnTouchOutside(true);
        this.ngv.a(this.ngw);
    }

    private void ag(View.OnClickListener onClickListener) {
        this.ngx.setOnClickListener(onClickListener);
        this.ngN.setOnClickListener(onClickListener);
        this.ngy.setOnClickListener(onClickListener);
        this.ngz.setOnClickListener(onClickListener);
        this.ngA.setOnClickListener(onClickListener);
        this.ngB.setOnClickListener(onClickListener);
        this.ngC.setOnClickListener(onClickListener);
        this.ngD.setOnClickListener(onClickListener);
        this.ngE.setOnClickListener(onClickListener);
        this.ngF.setOnClickListener(onClickListener);
        this.ngG.setOnClickListener(onClickListener);
        this.ngH.setOnClickListener(onClickListener);
        this.ngI.setOnClickListener(onClickListener);
        this.ngJ.setOnClickListener(onClickListener);
        this.ngK.setOnClickListener(onClickListener);
        this.ngU.setOnSwitchStateChangeListener(this.ngt);
        this.ngW.setOnSwitchStateChangeListener(this.ngt);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.ngN) {
                    e.this.ngu.IF(0);
                } else if (view == e.this.ngy) {
                    e.this.ngu.IF(1);
                } else if (view == e.this.ngz) {
                    e.this.ngu.IF(15);
                } else if (view == e.this.ngA) {
                    e.this.ngu.IF(2);
                } else if (view == e.this.ngB) {
                    e.this.ngu.IF(3);
                } else if (view == e.this.ngC) {
                    e.this.ngu.IF(17);
                } else if (view == e.this.ngE) {
                    e.this.ngu.IF(4);
                } else if (view == e.this.ngF) {
                    e.this.ngu.IF(9);
                } else if (view == e.this.ngG) {
                    e.this.ngu.IF(6);
                } else if (view == e.this.ngH) {
                    e.this.ngu.IF(7);
                } else if (view == e.this.ngI) {
                    e.this.ngu.IF(8);
                } else if (view == e.this.ngJ) {
                    e.this.ngu.IF(5);
                } else if (view == e.this.ngK) {
                    e.this.ngu.IF(10);
                } else if (view == e.this.ngx) {
                    e.this.ngu.IF(13);
                } else if (view == e.this.ngD) {
                    e.this.ngu.IF(16);
                }
            }
        };
    }

    public void dHt() {
        if (this.ngv == null) {
            aqg();
        }
        this.ngv.QE();
    }

    public void FA() {
        if (this.ngv != null) {
            this.ngv.dismiss();
        }
    }

    public BdSwitchView dHu() {
        return this.ngU;
    }

    public BdSwitchView dHv() {
        return this.ngW;
    }

    public void onResume() {
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.ngt).areNotificationsEnabled();
        if (this.ngE != null) {
            this.ngE.setTipViewColor(R.color.CAM_X0105);
            this.ngE.setTip(areNotificationsEnabled ? "" : this.ngt.getString(R.string.may_lose_important_msg));
        }
    }
}
