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
    private MoreActivity ngT;
    private d ngU;
    private com.baidu.tbadk.core.dialog.i ngV;
    private k ngW;
    private SettingTextNormalImageView ngX;
    private SettingTextImageView ngY;
    private TbSettingTextTipView ngZ;
    private TbSettingTextTipView nha;
    private TbSettingTextTipView nhb;
    private TbSettingTextTipView nhc;
    private TbSettingTextTipView nhd;
    private TbSettingTextTipView nhe;
    private TbSettingTextTipView nhf;
    private SettingTextVersionView nhg;
    private TbSettingTextTipView nhh;
    private TbSettingTextTipView nhi;
    private TbSettingTextNewDotView nhj;
    private TextView nhk;
    private RelativeLayout nhl;
    private View nhm;
    private View nhn;
    private View nho;
    private View nhp;
    private View nhq;
    private View nhr;
    private View nhs;
    private RelativeLayout nht;
    private BdSwitchView nhu;
    private RelativeLayout nhv;
    private BdSwitchView nhw;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.nho = null;
        this.nhp = null;
        this.nhq = null;
        this.nhr = null;
        this.nhs = null;
        this.nht = null;
        this.nhu = null;
        this.nhv = null;
        this.nhw = null;
        this.ngT = moreActivity;
        this.ngU = dVar;
        this.ngT.setContentView(R.layout.more_activity);
        bzE();
        dHy();
    }

    public void dHw() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.ngY.setVisibility(8);
        } else {
            this.ngY.setVisibility(0);
        }
    }

    public void bc(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.ngY != null) {
                this.ngY.dIF();
                return;
            }
            return;
        }
        this.ngY.dIG();
        this.ngY.setIcon(str, z);
    }

    public void dHx() {
        if (this.nhg != null) {
            this.nhg.refresh();
        }
        if (this.nhj != null) {
            this.nhj.refresh();
        }
    }

    public void dHy() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.nhu.turnOn();
        } else {
            this.nhu.turnOff();
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

    public void dGx() {
        this.ngY.recycle();
        this.ngZ.recycle();
        this.nha.recycle();
        this.nhb.recycle();
        this.nhc.recycle();
        this.nhe.recycle();
        this.nhf.recycle();
        this.nhg.recycle();
        this.nhh.recycle();
        this.nhi.recycle();
    }

    public void onChangeSkinType(int i) {
        qJ(i);
        if (this.ngW != null) {
            this.ngT.getLayoutMode().setNightMode(i == 1);
            this.ngT.getLayoutMode().onModeChanged(this.ngW.getView());
        }
        if (i == 1) {
            this.nhu.turnOnNoCallback();
        } else {
            this.nhu.turnOffNoCallback();
        }
    }

    public void qJ(int i) {
        ap.setBackgroundColor(this.nhl, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.ngY.qJ(i);
        this.ngT.getLayoutMode().setNightMode(i == 1);
        this.ngT.getLayoutMode().onModeChanged(this.nhl);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        dHx();
        this.nhu.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        this.nhw.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        ap.setBackgroundColor(this.nhm, R.color.CAM_X0201);
        this.ngX.setLocalIcon(ap.oA(R.drawable.icon_mine_list_baidu));
        if (this.ngW != null) {
            this.ngW.onChangeSkinType();
        }
        this.ngX.qJ(i);
        this.ngY.qJ(i);
        this.ngZ.onChangeSkinType(i);
        this.nha.onChangeSkinType(i);
        this.nhb.onChangeSkinType(i);
        this.nhc.onChangeSkinType(i);
        this.nhd.onChangeSkinType(i);
        this.nhe.onChangeSkinType(i);
        this.nhf.onChangeSkinType(i);
        this.nhg.onChangeSkinType(i);
        this.nhh.onChangeSkinType(i);
        this.nhi.onChangeSkinType(i);
        this.nhj.onChangeSkinType(i);
    }

    private void bzE() {
        View.OnClickListener clickListener = getClickListener();
        this.nhl = (RelativeLayout) this.ngT.findViewById(R.id.parent);
        this.nhm = this.ngT.findViewById(R.id.scroll);
        this.ngT.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.ngT.findViewById(R.id.view_navigation_bar);
        this.nhn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.ngT.getPageContext().getString(R.string.setup));
        this.mNavigationBar.showBottomLine();
        this.ngX = (SettingTextNormalImageView) this.ngT.findViewById(R.id.accountSafeSetting);
        this.ngY = (SettingTextImageView) this.ngT.findViewById(R.id.personInfo);
        this.ngZ = (TbSettingTextTipView) this.ngT.findViewById(R.id.interest_label_setting);
        this.ngZ.setTopLineVisibility(true);
        this.nha = (TbSettingTextTipView) this.ngT.findViewById(R.id.accountManager);
        this.nha.setTopLineVisibility(true);
        this.nhb = (TbSettingTextTipView) this.ngT.findViewById(R.id.browseSetting);
        this.nhb.setBottomLineVisibility(true);
        this.nhc = (TbSettingTextTipView) this.ngT.findViewById(R.id.youngsterSetting);
        this.nhc.setBottomLineVisibility(true);
        if (com.baidu.tbadk.youngster.b.c.bJf()) {
            this.nhc.setTip(this.ngT.getString(R.string.youngster_settings_tip_open));
        } else {
            this.nhc.setTip(this.ngT.getString(R.string.youngster_settings_tip_close));
        }
        this.nhd = (TbSettingTextTipView) this.ngT.findViewById(R.id.adSetting);
        this.nhd.setBottomLineVisibility(true);
        this.nhe = (TbSettingTextTipView) this.ngT.findViewById(R.id.messageSetting);
        this.nhe.setBottomLineVisibility(true);
        this.nhb.setBottomLineVisibility(true);
        this.nhf = (TbSettingTextTipView) this.ngT.findViewById(R.id.secretSetting);
        this.nhf.setBottomLineVisibility(true);
        this.nhg = (SettingTextVersionView) this.ngT.findViewById(R.id.versionInfo);
        this.nhh = (TbSettingTextTipView) this.ngT.findViewById(R.id.feedBack);
        this.nhh.setTopLineVisibility(true);
        this.nhh.setBottomLineVisibility(true);
        this.nhi = (TbSettingTextTipView) this.ngT.findViewById(R.id.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.nhi.setVisibility(8);
            this.nhi.setBottomLineVisibility(false);
        } else {
            this.nhi.setVisibility(0);
            this.nhi.setBottomLineVisibility(true);
        }
        this.nhj = (TbSettingTextNewDotView) this.ngT.findViewById(R.id.systemhelpsetting);
        this.nhk = (TextView) this.ngT.findViewById(R.id.quit);
        this.nht = (RelativeLayout) this.ngT.findViewById(R.id.eyeshield_mode);
        this.nhu = (BdSwitchView) this.ngT.findViewById(R.id.item_switch);
        l.addToParentArea(this.ngT.getPageContext().getPageActivity(), this.nhu, 10, 10, 10, 10);
        this.nhv = (RelativeLayout) this.ngT.findViewById(R.id.follow_system_day_night_mode);
        this.nhw = (BdSwitchView) this.ngT.findViewById(R.id.follow_system_item_switch);
        l.addToParentArea(this.ngT.getPageContext().getPageActivity(), this.nhw, 10, 10, 10, 10);
        this.nho = this.ngT.findViewById(R.id.divide_view2);
        this.nhp = this.ngT.findViewById(R.id.divide_view1);
        this.nhq = this.ngT.findViewById(R.id.divide_view3);
        this.nhr = this.ngT.findViewById(R.id.divide_view4);
        this.nhs = this.ngT.findViewById(R.id.divide_view5);
        dHx();
        dHw();
        this.ngY.dIF();
        qJ(TbadkCoreApplication.getInst().getSkinType());
        this.nhp.setVisibility(0);
        this.nhq.setVisibility(0);
        this.nhr.setVisibility(0);
        this.nhs.setVisibility(0);
        ag(clickListener);
        if (!dHz()) {
            this.nhb.setTip(this.ngT.getResources().getString(R.string.browsing_settings_tip_no_night));
            this.nho.setVisibility(8);
            this.nht.setVisibility(8);
        } else {
            this.nho.setVisibility(0);
            this.nht.setVisibility(0);
        }
        this.nhv.setVisibility(dHA() ? 0 : 8);
        if (com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("key_is_follow_system_mode", false)) {
            this.nhw.turnOnNoCallback();
        } else {
            this.nhw.turnOffNoCallback();
        }
    }

    private boolean dHz() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private boolean dHA() {
        if (dHz()) {
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("key_is_dark_mode_notify_shown", false);
        }
        return false;
    }

    private void aqg() {
        this.ngW = new k(getPageContext().getPageActivity());
        this.ngW.setTitleText(getPageContext().getString(R.string.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getPageContext().getString(R.string.quite_current_account), this.ngW);
        gVar.setTextColor(R.color.CAM_X0301);
        arrayList.add(gVar);
        this.ngT.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.ngT.getLayoutMode().onModeChanged(this.ngW.getView());
        k.c cVar = new k.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (i == gVar.getId()) {
                    e.this.FA();
                    e.this.ngU.IF(12);
                }
            }
        };
        k.a aVar = new k.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                e.this.FA();
            }
        };
        this.ngW.bw(arrayList);
        this.ngW.a(cVar);
        this.ngW.a(aVar);
        this.ngV = new com.baidu.tbadk.core.dialog.i(this.mContext);
        this.ngV.setCanceledOnTouchOutside(true);
        this.ngV.a(this.ngW);
    }

    private void ag(View.OnClickListener onClickListener) {
        this.ngX.setOnClickListener(onClickListener);
        this.nhn.setOnClickListener(onClickListener);
        this.ngY.setOnClickListener(onClickListener);
        this.ngZ.setOnClickListener(onClickListener);
        this.nha.setOnClickListener(onClickListener);
        this.nhb.setOnClickListener(onClickListener);
        this.nhc.setOnClickListener(onClickListener);
        this.nhd.setOnClickListener(onClickListener);
        this.nhe.setOnClickListener(onClickListener);
        this.nhf.setOnClickListener(onClickListener);
        this.nhg.setOnClickListener(onClickListener);
        this.nhh.setOnClickListener(onClickListener);
        this.nhi.setOnClickListener(onClickListener);
        this.nhj.setOnClickListener(onClickListener);
        this.nhk.setOnClickListener(onClickListener);
        this.nhu.setOnSwitchStateChangeListener(this.ngT);
        this.nhw.setOnSwitchStateChangeListener(this.ngT);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.nhn) {
                    e.this.ngU.IF(0);
                } else if (view == e.this.ngY) {
                    e.this.ngU.IF(1);
                } else if (view == e.this.ngZ) {
                    e.this.ngU.IF(15);
                } else if (view == e.this.nha) {
                    e.this.ngU.IF(2);
                } else if (view == e.this.nhb) {
                    e.this.ngU.IF(3);
                } else if (view == e.this.nhc) {
                    e.this.ngU.IF(17);
                } else if (view == e.this.nhe) {
                    e.this.ngU.IF(4);
                } else if (view == e.this.nhf) {
                    e.this.ngU.IF(9);
                } else if (view == e.this.nhg) {
                    e.this.ngU.IF(6);
                } else if (view == e.this.nhh) {
                    e.this.ngU.IF(7);
                } else if (view == e.this.nhi) {
                    e.this.ngU.IF(8);
                } else if (view == e.this.nhj) {
                    e.this.ngU.IF(5);
                } else if (view == e.this.nhk) {
                    e.this.ngU.IF(10);
                } else if (view == e.this.ngX) {
                    e.this.ngU.IF(13);
                } else if (view == e.this.nhd) {
                    e.this.ngU.IF(16);
                }
            }
        };
    }

    public void dHB() {
        if (this.ngV == null) {
            aqg();
        }
        this.ngV.QE();
    }

    public void FA() {
        if (this.ngV != null) {
            this.ngV.dismiss();
        }
    }

    public BdSwitchView dHC() {
        return this.nhu;
    }

    public BdSwitchView dHD() {
        return this.nhw;
    }

    public void onResume() {
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.ngT).areNotificationsEnabled();
        if (this.nhe != null) {
            this.nhe.setTipViewColor(R.color.CAM_X0105);
            this.nhe.setTip(areNotificationsEnabled ? "" : this.ngT.getString(R.string.may_lose_important_msg));
        }
    }
}
