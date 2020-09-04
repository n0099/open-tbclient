package com.baidu.tieba.setting.more;

import android.os.Build;
import android.support.v4.app.NotificationManagerCompat;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes20.dex */
public class e extends com.baidu.adp.base.c<MoreActivity> {
    private MoreActivity lPZ;
    private BdSwitchView lQA;
    private RelativeLayout lQB;
    private BdSwitchView lQC;
    private d lQa;
    private com.baidu.tbadk.core.dialog.i lQb;
    private k lQc;
    private SettingTextNormalImageView lQd;
    private SettingTextImageView lQe;
    private TbSettingTextTipView lQf;
    private TbSettingTextTipView lQg;
    private TbSettingTextTipView lQh;
    private TbSettingTextTipView lQi;
    private TbSettingTextTipView lQj;
    private TbSettingTextTipView lQk;
    private TbSettingTextTipView lQl;
    private SettingTextVersionView lQm;
    private TbSettingTextTipView lQn;
    private TbSettingTextTipView lQo;
    private TbSettingTextNewDotView lQp;
    private TextView lQq;
    private RelativeLayout lQr;
    private View lQs;
    private View lQt;
    private View lQu;
    private View lQv;
    private View lQw;
    private View lQx;
    private View lQy;
    private RelativeLayout lQz;
    private NavigationBar mNavigationBar;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.lQu = null;
        this.lQv = null;
        this.lQw = null;
        this.lQx = null;
        this.lQy = null;
        this.lQz = null;
        this.lQA = null;
        this.lQB = null;
        this.lQC = null;
        this.lPZ = moreActivity;
        this.lQa = dVar;
        this.lPZ.setContentView(R.layout.more_activity);
        bpZ();
        drf();
    }

    public void drd() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.lQe.setVisibility(8);
        } else {
            this.lQe.setVisibility(0);
        }
    }

    public void aV(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.lQe != null) {
                this.lQe.dsm();
                return;
            }
            return;
        }
        this.lQe.dsn();
        this.lQe.setIcon(str, z);
    }

    public void dre() {
        if (this.lQm != null) {
            this.lQm.refresh();
        }
        if (this.lQp != null) {
            this.lQp.refresh();
        }
    }

    public void drf() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.lQA.turnOn();
        } else {
            this.lQA.turnOff();
        }
    }

    public void GW(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != i) {
            if (i == 1) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.SET_NIGHT_MODE).dD("obj_type", "1").dD("obj_source", "0"));
            } else if (i == 0 || i == 4) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.SET_NIGHT_MODE).dD("obj_type", "0").dD("obj_source", "0"));
            }
            BitmapHelper.clearCashBitmap();
        }
    }

    public void dqg() {
        this.lQe.recycle();
        this.lQf.recycle();
        this.lQg.recycle();
        this.lQh.recycle();
        this.lQi.recycle();
        this.lQk.recycle();
        this.lQl.recycle();
        this.lQm.recycle();
        this.lQn.recycle();
        this.lQo.recycle();
    }

    public void onChangeSkinType(int i) {
        pT(i);
        if (this.lQc != null) {
            this.lPZ.getLayoutMode().setNightMode(i == 1);
            this.lPZ.getLayoutMode().onModeChanged(this.lQc.getView());
        }
        if (i == 1) {
            this.lQA.turnOnNoCallback();
        } else {
            this.lQA.turnOffNoCallback();
        }
    }

    public void pT(int i) {
        ap.setBackgroundColor(this.lQr, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.lQe.pT(i);
        this.lPZ.getLayoutMode().setNightMode(i == 1);
        this.lPZ.getLayoutMode().onModeChanged(this.lQr);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        dre();
        this.lQA.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        this.lQC.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        ap.setBackgroundColor(this.lQs, R.color.cp_bg_line_d);
        this.lQd.setLocalIcon(ap.nS(R.drawable.icon_mine_list_baidu));
        if (this.lQc != null) {
            this.lQc.onChangeSkinType();
        }
        this.lQd.pT(i);
        this.lQe.pT(i);
        this.lQf.onChangeSkinType(i);
        this.lQg.onChangeSkinType(i);
        this.lQh.onChangeSkinType(i);
        this.lQi.onChangeSkinType(i);
        this.lQj.onChangeSkinType(i);
        this.lQk.onChangeSkinType(i);
        this.lQl.onChangeSkinType(i);
        this.lQm.onChangeSkinType(i);
        this.lQn.onChangeSkinType(i);
        this.lQo.onChangeSkinType(i);
        this.lQp.onChangeSkinType(i);
    }

    private void bpZ() {
        View.OnClickListener clickListener = getClickListener();
        this.lQr = (RelativeLayout) this.lPZ.findViewById(R.id.parent);
        this.lQs = this.lPZ.findViewById(R.id.scroll);
        this.lPZ.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.lPZ.findViewById(R.id.view_navigation_bar);
        this.lQt = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.lPZ.getPageContext().getString(R.string.setup));
        this.mNavigationBar.showBottomLine();
        this.lQd = (SettingTextNormalImageView) this.lPZ.findViewById(R.id.accountSafeSetting);
        this.lQe = (SettingTextImageView) this.lPZ.findViewById(R.id.personInfo);
        this.lQf = (TbSettingTextTipView) this.lPZ.findViewById(R.id.interest_label_setting);
        this.lQf.setTopLineVisibility(true);
        this.lQg = (TbSettingTextTipView) this.lPZ.findViewById(R.id.accountManager);
        this.lQg.setTopLineVisibility(true);
        this.lQh = (TbSettingTextTipView) this.lPZ.findViewById(R.id.browseSetting);
        this.lQh.setBottomLineVisibility(true);
        this.lQi = (TbSettingTextTipView) this.lPZ.findViewById(R.id.youngsterSetting);
        this.lQi.setBottomLineVisibility(true);
        if (com.baidu.tbadk.youngster.b.b.bzf()) {
            this.lQi.setTip(this.lPZ.getString(R.string.youngster_settings_tip_open));
        } else {
            this.lQi.setTip(this.lPZ.getString(R.string.youngster_settings_tip_close));
        }
        this.lQj = (TbSettingTextTipView) this.lPZ.findViewById(R.id.adSetting);
        this.lQj.setBottomLineVisibility(true);
        this.lQk = (TbSettingTextTipView) this.lPZ.findViewById(R.id.messageSetting);
        this.lQk.setBottomLineVisibility(true);
        this.lQh.setBottomLineVisibility(true);
        this.lQl = (TbSettingTextTipView) this.lPZ.findViewById(R.id.secretSetting);
        this.lQl.setBottomLineVisibility(true);
        this.lQm = (SettingTextVersionView) this.lPZ.findViewById(R.id.versionInfo);
        this.lQn = (TbSettingTextTipView) this.lPZ.findViewById(R.id.feedBack);
        this.lQn.setTopLineVisibility(true);
        this.lQn.setBottomLineVisibility(true);
        this.lQo = (TbSettingTextTipView) this.lPZ.findViewById(R.id.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.lQo.setVisibility(8);
            this.lQo.setBottomLineVisibility(false);
        } else {
            this.lQo.setVisibility(0);
            this.lQo.setBottomLineVisibility(true);
        }
        this.lQp = (TbSettingTextNewDotView) this.lPZ.findViewById(R.id.systemhelpsetting);
        this.lQq = (TextView) this.lPZ.findViewById(R.id.quit);
        this.lQz = (RelativeLayout) this.lPZ.findViewById(R.id.eyeshield_mode);
        this.lQA = (BdSwitchView) this.lPZ.findViewById(R.id.item_switch);
        l.addToParentArea(this.lPZ.getPageContext().getPageActivity(), this.lQA, 10, 10, 10, 10);
        this.lQB = (RelativeLayout) this.lPZ.findViewById(R.id.follow_system_day_night_mode);
        this.lQC = (BdSwitchView) this.lPZ.findViewById(R.id.follow_system_item_switch);
        l.addToParentArea(this.lPZ.getPageContext().getPageActivity(), this.lQC, 10, 10, 10, 10);
        this.lQu = this.lPZ.findViewById(R.id.divide_view2);
        this.lQv = this.lPZ.findViewById(R.id.divide_view1);
        this.lQw = this.lPZ.findViewById(R.id.divide_view3);
        this.lQx = this.lPZ.findViewById(R.id.divide_view4);
        this.lQy = this.lPZ.findViewById(R.id.divide_view5);
        dre();
        drd();
        this.lQe.dsm();
        pT(TbadkCoreApplication.getInst().getSkinType());
        this.lQv.setVisibility(0);
        this.lQw.setVisibility(0);
        this.lQx.setVisibility(0);
        this.lQy.setVisibility(0);
        ad(clickListener);
        if (!drg()) {
            this.lQh.setTip(this.lPZ.getResources().getString(R.string.browsing_settings_tip_no_night));
            this.lQu.setVisibility(8);
            this.lQz.setVisibility(8);
        } else {
            this.lQu.setVisibility(0);
            this.lQz.setVisibility(0);
        }
        this.lQB.setVisibility(drh() ? 0 : 8);
        if (com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("key_is_follow_system_mode", false)) {
            this.lQC.turnOnNoCallback();
        } else {
            this.lQC.turnOffNoCallback();
        }
    }

    private boolean drg() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private boolean drh() {
        if (drg()) {
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("key_is_dark_mode_notify_shown", false);
        }
        return false;
    }

    private void ahV() {
        this.lQc = new k(getPageContext().getPageActivity());
        this.lQc.setTitleText(getPageContext().getString(R.string.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getPageContext().getString(R.string.quite_current_account), this.lQc);
        gVar.setTextColor(R.color.cp_cont_h);
        arrayList.add(gVar);
        this.lPZ.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.lPZ.getLayoutMode().onModeChanged(this.lQc.getView());
        k.c cVar = new k.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (i == gVar.getId()) {
                    e.this.Fd();
                    e.this.lQa.GR(12);
                }
            }
        };
        k.a aVar = new k.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                e.this.Fd();
            }
        };
        this.lQc.aT(arrayList);
        this.lQc.a(cVar);
        this.lQc.a(aVar);
        this.lQb = new com.baidu.tbadk.core.dialog.i(this.mContext);
        this.lQb.setCanceledOnTouchOutside(true);
        this.lQb.a(this.lQc);
    }

    private void ad(View.OnClickListener onClickListener) {
        this.lQd.setOnClickListener(onClickListener);
        this.lQt.setOnClickListener(onClickListener);
        this.lQe.setOnClickListener(onClickListener);
        this.lQf.setOnClickListener(onClickListener);
        this.lQg.setOnClickListener(onClickListener);
        this.lQh.setOnClickListener(onClickListener);
        this.lQi.setOnClickListener(onClickListener);
        this.lQj.setOnClickListener(onClickListener);
        this.lQk.setOnClickListener(onClickListener);
        this.lQl.setOnClickListener(onClickListener);
        this.lQm.setOnClickListener(onClickListener);
        this.lQn.setOnClickListener(onClickListener);
        this.lQo.setOnClickListener(onClickListener);
        this.lQp.setOnClickListener(onClickListener);
        this.lQq.setOnClickListener(onClickListener);
        this.lQA.setOnSwitchStateChangeListener(this.lPZ);
        this.lQC.setOnSwitchStateChangeListener(this.lPZ);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.lQt) {
                    e.this.lQa.GR(0);
                } else if (view == e.this.lQe) {
                    e.this.lQa.GR(1);
                } else if (view == e.this.lQf) {
                    e.this.lQa.GR(15);
                } else if (view == e.this.lQg) {
                    e.this.lQa.GR(2);
                } else if (view == e.this.lQh) {
                    e.this.lQa.GR(3);
                } else if (view == e.this.lQi) {
                    e.this.lQa.GR(17);
                } else if (view == e.this.lQk) {
                    e.this.lQa.GR(4);
                } else if (view == e.this.lQl) {
                    e.this.lQa.GR(9);
                } else if (view == e.this.lQm) {
                    e.this.lQa.GR(6);
                } else if (view == e.this.lQn) {
                    e.this.lQa.GR(7);
                } else if (view == e.this.lQo) {
                    e.this.lQa.GR(8);
                } else if (view == e.this.lQp) {
                    e.this.lQa.GR(5);
                } else if (view == e.this.lQq) {
                    e.this.lQa.GR(10);
                } else if (view == e.this.lQd) {
                    e.this.lQa.GR(13);
                } else if (view == e.this.lQj) {
                    e.this.lQa.GR(16);
                }
            }
        };
    }

    public void dri() {
        if (this.lQb == null) {
            ahV();
        }
        this.lQb.Nv();
    }

    public void Fd() {
        if (this.lQb != null) {
            this.lQb.dismiss();
        }
    }

    public BdSwitchView drj() {
        return this.lQA;
    }

    public BdSwitchView drk() {
        return this.lQC;
    }

    public void onResume() {
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.lPZ).areNotificationsEnabled();
        if (this.lQk != null) {
            this.lQk.setTipViewColor(R.color.cp_cont_b);
            this.lQk.setTip(areNotificationsEnabled ? "" : this.lPZ.getString(R.string.may_lose_important_msg));
        }
    }
}
