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
/* loaded from: classes26.dex */
public class e extends com.baidu.adp.base.c<MoreActivity> {
    private NavigationBar mNavigationBar;
    private MoreActivity moN;
    private d moO;
    private com.baidu.tbadk.core.dialog.i moP;
    private k moQ;
    private SettingTextNormalImageView moR;
    private SettingTextImageView moS;
    private TbSettingTextTipView moT;
    private TbSettingTextTipView moU;
    private TbSettingTextTipView moV;
    private TbSettingTextTipView moW;
    private TbSettingTextTipView moX;
    private TbSettingTextTipView moY;
    private TbSettingTextTipView moZ;
    private SettingTextVersionView mpa;
    private TbSettingTextTipView mpb;
    private TbSettingTextTipView mpc;
    private TbSettingTextNewDotView mpd;
    private TextView mpe;
    private RelativeLayout mpf;
    private View mpg;
    private View mph;
    private View mpi;
    private View mpj;
    private View mpk;
    private View mpl;
    private View mpm;
    private RelativeLayout mpn;
    private BdSwitchView mpo;
    private RelativeLayout mpp;
    private BdSwitchView mpq;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.mpi = null;
        this.mpj = null;
        this.mpk = null;
        this.mpl = null;
        this.mpm = null;
        this.mpn = null;
        this.mpo = null;
        this.mpp = null;
        this.mpq = null;
        this.moN = moreActivity;
        this.moO = dVar;
        this.moN.setContentView(R.layout.more_activity);
        btD();
        dyG();
    }

    public void dyE() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.moS.setVisibility(8);
        } else {
            this.moS.setVisibility(0);
        }
    }

    public void aZ(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.moS != null) {
                this.moS.dzN();
                return;
            }
            return;
        }
        this.moS.dzO();
        this.moS.setIcon(str, z);
    }

    public void dyF() {
        if (this.mpa != null) {
            this.mpa.refresh();
        }
        if (this.mpd != null) {
            this.mpd.refresh();
        }
    }

    public void dyG() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.mpo.turnOn();
        } else {
            this.mpo.turnOff();
        }
    }

    public void If(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != i) {
            if (i == 1) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.SET_NIGHT_MODE).dK("obj_type", "1").dK("obj_source", "0"));
            } else if (i == 0 || i == 4) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.SET_NIGHT_MODE).dK("obj_type", "0").dK("obj_source", "0"));
            }
            BitmapHelper.clearCashBitmap();
        }
    }

    public void dxF() {
        this.moS.recycle();
        this.moT.recycle();
        this.moU.recycle();
        this.moV.recycle();
        this.moW.recycle();
        this.moY.recycle();
        this.moZ.recycle();
        this.mpa.recycle();
        this.mpb.recycle();
        this.mpc.recycle();
    }

    public void onChangeSkinType(int i) {
        qE(i);
        if (this.moQ != null) {
            this.moN.getLayoutMode().setNightMode(i == 1);
            this.moN.getLayoutMode().onModeChanged(this.moQ.getView());
        }
        if (i == 1) {
            this.mpo.turnOnNoCallback();
        } else {
            this.mpo.turnOffNoCallback();
        }
    }

    public void qE(int i) {
        ap.setBackgroundColor(this.mpf, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.moS.qE(i);
        this.moN.getLayoutMode().setNightMode(i == 1);
        this.moN.getLayoutMode().onModeChanged(this.mpf);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        dyF();
        this.mpo.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        this.mpq.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        ap.setBackgroundColor(this.mpg, R.color.cp_bg_line_d);
        this.moR.setLocalIcon(ap.oB(R.drawable.icon_mine_list_baidu));
        if (this.moQ != null) {
            this.moQ.onChangeSkinType();
        }
        this.moR.qE(i);
        this.moS.qE(i);
        this.moT.onChangeSkinType(i);
        this.moU.onChangeSkinType(i);
        this.moV.onChangeSkinType(i);
        this.moW.onChangeSkinType(i);
        this.moX.onChangeSkinType(i);
        this.moY.onChangeSkinType(i);
        this.moZ.onChangeSkinType(i);
        this.mpa.onChangeSkinType(i);
        this.mpb.onChangeSkinType(i);
        this.mpc.onChangeSkinType(i);
        this.mpd.onChangeSkinType(i);
    }

    private void btD() {
        View.OnClickListener clickListener = getClickListener();
        this.mpf = (RelativeLayout) this.moN.findViewById(R.id.parent);
        this.mpg = this.moN.findViewById(R.id.scroll);
        this.moN.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.moN.findViewById(R.id.view_navigation_bar);
        this.mph = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.moN.getPageContext().getString(R.string.setup));
        this.mNavigationBar.showBottomLine();
        this.moR = (SettingTextNormalImageView) this.moN.findViewById(R.id.accountSafeSetting);
        this.moS = (SettingTextImageView) this.moN.findViewById(R.id.personInfo);
        this.moT = (TbSettingTextTipView) this.moN.findViewById(R.id.interest_label_setting);
        this.moT.setTopLineVisibility(true);
        this.moU = (TbSettingTextTipView) this.moN.findViewById(R.id.accountManager);
        this.moU.setTopLineVisibility(true);
        this.moV = (TbSettingTextTipView) this.moN.findViewById(R.id.browseSetting);
        this.moV.setBottomLineVisibility(true);
        this.moW = (TbSettingTextTipView) this.moN.findViewById(R.id.youngsterSetting);
        this.moW.setBottomLineVisibility(true);
        if (com.baidu.tbadk.youngster.b.c.bDa()) {
            this.moW.setTip(this.moN.getString(R.string.youngster_settings_tip_open));
        } else {
            this.moW.setTip(this.moN.getString(R.string.youngster_settings_tip_close));
        }
        this.moX = (TbSettingTextTipView) this.moN.findViewById(R.id.adSetting);
        this.moX.setBottomLineVisibility(true);
        this.moY = (TbSettingTextTipView) this.moN.findViewById(R.id.messageSetting);
        this.moY.setBottomLineVisibility(true);
        this.moV.setBottomLineVisibility(true);
        this.moZ = (TbSettingTextTipView) this.moN.findViewById(R.id.secretSetting);
        this.moZ.setBottomLineVisibility(true);
        this.mpa = (SettingTextVersionView) this.moN.findViewById(R.id.versionInfo);
        this.mpb = (TbSettingTextTipView) this.moN.findViewById(R.id.feedBack);
        this.mpb.setTopLineVisibility(true);
        this.mpb.setBottomLineVisibility(true);
        this.mpc = (TbSettingTextTipView) this.moN.findViewById(R.id.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.mpc.setVisibility(8);
            this.mpc.setBottomLineVisibility(false);
        } else {
            this.mpc.setVisibility(0);
            this.mpc.setBottomLineVisibility(true);
        }
        this.mpd = (TbSettingTextNewDotView) this.moN.findViewById(R.id.systemhelpsetting);
        this.mpe = (TextView) this.moN.findViewById(R.id.quit);
        this.mpn = (RelativeLayout) this.moN.findViewById(R.id.eyeshield_mode);
        this.mpo = (BdSwitchView) this.moN.findViewById(R.id.item_switch);
        l.addToParentArea(this.moN.getPageContext().getPageActivity(), this.mpo, 10, 10, 10, 10);
        this.mpp = (RelativeLayout) this.moN.findViewById(R.id.follow_system_day_night_mode);
        this.mpq = (BdSwitchView) this.moN.findViewById(R.id.follow_system_item_switch);
        l.addToParentArea(this.moN.getPageContext().getPageActivity(), this.mpq, 10, 10, 10, 10);
        this.mpi = this.moN.findViewById(R.id.divide_view2);
        this.mpj = this.moN.findViewById(R.id.divide_view1);
        this.mpk = this.moN.findViewById(R.id.divide_view3);
        this.mpl = this.moN.findViewById(R.id.divide_view4);
        this.mpm = this.moN.findViewById(R.id.divide_view5);
        dyF();
        dyE();
        this.moS.dzN();
        qE(TbadkCoreApplication.getInst().getSkinType());
        this.mpj.setVisibility(0);
        this.mpk.setVisibility(0);
        this.mpl.setVisibility(0);
        this.mpm.setVisibility(0);
        ad(clickListener);
        if (!dyH()) {
            this.moV.setTip(this.moN.getResources().getString(R.string.browsing_settings_tip_no_night));
            this.mpi.setVisibility(8);
            this.mpn.setVisibility(8);
        } else {
            this.mpi.setVisibility(0);
            this.mpn.setVisibility(0);
        }
        this.mpp.setVisibility(dyI() ? 0 : 8);
        if (com.baidu.tbadk.core.sharedPref.b.blO().getBoolean("key_is_follow_system_mode", false)) {
            this.mpq.turnOnNoCallback();
        } else {
            this.mpq.turnOffNoCallback();
        }
    }

    private boolean dyH() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private boolean dyI() {
        if (dyH()) {
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return com.baidu.tbadk.core.sharedPref.b.blO().getBoolean("key_is_dark_mode_notify_shown", false);
        }
        return false;
    }

    private void alq() {
        this.moQ = new k(getPageContext().getPageActivity());
        this.moQ.setTitleText(getPageContext().getString(R.string.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getPageContext().getString(R.string.quite_current_account), this.moQ);
        gVar.setTextColor(R.color.cp_cont_h);
        arrayList.add(gVar);
        this.moN.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.moN.getLayoutMode().onModeChanged(this.moQ.getView());
        k.c cVar = new k.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (i == gVar.getId()) {
                    e.this.Gz();
                    e.this.moO.Ia(12);
                }
            }
        };
        k.a aVar = new k.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                e.this.Gz();
            }
        };
        this.moQ.ba(arrayList);
        this.moQ.a(cVar);
        this.moQ.a(aVar);
        this.moP = new com.baidu.tbadk.core.dialog.i(this.mContext);
        this.moP.setCanceledOnTouchOutside(true);
        this.moP.a(this.moQ);
    }

    private void ad(View.OnClickListener onClickListener) {
        this.moR.setOnClickListener(onClickListener);
        this.mph.setOnClickListener(onClickListener);
        this.moS.setOnClickListener(onClickListener);
        this.moT.setOnClickListener(onClickListener);
        this.moU.setOnClickListener(onClickListener);
        this.moV.setOnClickListener(onClickListener);
        this.moW.setOnClickListener(onClickListener);
        this.moX.setOnClickListener(onClickListener);
        this.moY.setOnClickListener(onClickListener);
        this.moZ.setOnClickListener(onClickListener);
        this.mpa.setOnClickListener(onClickListener);
        this.mpb.setOnClickListener(onClickListener);
        this.mpc.setOnClickListener(onClickListener);
        this.mpd.setOnClickListener(onClickListener);
        this.mpe.setOnClickListener(onClickListener);
        this.mpo.setOnSwitchStateChangeListener(this.moN);
        this.mpq.setOnSwitchStateChangeListener(this.moN);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.mph) {
                    e.this.moO.Ia(0);
                } else if (view == e.this.moS) {
                    e.this.moO.Ia(1);
                } else if (view == e.this.moT) {
                    e.this.moO.Ia(15);
                } else if (view == e.this.moU) {
                    e.this.moO.Ia(2);
                } else if (view == e.this.moV) {
                    e.this.moO.Ia(3);
                } else if (view == e.this.moW) {
                    e.this.moO.Ia(17);
                } else if (view == e.this.moY) {
                    e.this.moO.Ia(4);
                } else if (view == e.this.moZ) {
                    e.this.moO.Ia(9);
                } else if (view == e.this.mpa) {
                    e.this.moO.Ia(6);
                } else if (view == e.this.mpb) {
                    e.this.moO.Ia(7);
                } else if (view == e.this.mpc) {
                    e.this.moO.Ia(8);
                } else if (view == e.this.mpd) {
                    e.this.moO.Ia(5);
                } else if (view == e.this.mpe) {
                    e.this.moO.Ia(10);
                } else if (view == e.this.moR) {
                    e.this.moO.Ia(13);
                } else if (view == e.this.moX) {
                    e.this.moO.Ia(16);
                }
            }
        };
    }

    public void dyJ() {
        if (this.moP == null) {
            alq();
        }
        this.moP.Pd();
    }

    public void Gz() {
        if (this.moP != null) {
            this.moP.dismiss();
        }
    }

    public BdSwitchView dyK() {
        return this.mpo;
    }

    public BdSwitchView dyL() {
        return this.mpq;
    }

    public void onResume() {
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.moN).areNotificationsEnabled();
        if (this.moY != null) {
            this.moY.setTipViewColor(R.color.cp_cont_b);
            this.moY.setTip(areNotificationsEnabled ? "" : this.moN.getString(R.string.may_lose_important_msg));
        }
    }
}
