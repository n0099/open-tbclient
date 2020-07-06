package com.baidu.tieba.setting.more;

import android.os.Build;
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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes13.dex */
public class e extends com.baidu.adp.base.c<MoreActivity> {
    private View lrA;
    private View lrB;
    private View lrC;
    private View lrD;
    private RelativeLayout lrE;
    private BdSwitchView lrF;
    private RelativeLayout lrG;
    private BdSwitchView lrH;
    private MoreActivity lrf;
    private d lrg;
    private com.baidu.tbadk.core.dialog.i lrh;
    private k lri;
    private SettingTextNormalImageView lrj;
    private SettingTextImageView lrk;
    private TbSettingTextTipView lrl;
    private TbSettingTextTipView lrm;
    private TbSettingTextTipView lrn;
    private TbSettingTextTipView lro;
    private TbSettingTextTipView lrp;
    private TbSettingTextTipView lrq;
    private SettingTextVersionView lrr;
    private TbSettingTextTipView lrs;
    private TbSettingTextTipView lrt;
    private TbSettingTextNewDotView lru;
    private TextView lrv;
    private RelativeLayout lrw;
    private View lrx;
    private View lry;
    private View lrz;
    private NavigationBar mNavigationBar;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.lrz = null;
        this.lrA = null;
        this.lrB = null;
        this.lrC = null;
        this.lrD = null;
        this.lrE = null;
        this.lrF = null;
        this.lrG = null;
        this.lrH = null;
        this.lrf = moreActivity;
        this.lrg = dVar;
        this.lrf.setContentView(R.layout.more_activity);
        bdD();
        dcB();
    }

    public void dcz() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.lrk.setVisibility(8);
        } else {
            this.lrk.setVisibility(0);
        }
    }

    public void aU(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.lrk != null) {
                this.lrk.ddE();
                return;
            }
            return;
        }
        this.lrk.ddF();
        this.lrk.setIcon(str, z);
    }

    public void dcA() {
        if (this.lrr != null) {
            this.lrr.refresh();
        }
        if (this.lru != null) {
            this.lru.refresh();
        }
    }

    public void dcB() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.lrF.turnOn();
        } else {
            this.lrF.turnOff();
        }
    }

    public void Ed(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != i) {
            if (i == 1) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new ao(TbadkCoreStatisticKey.SET_NIGHT_MODE).dk("obj_type", "1").dk("obj_source", "0"));
            } else if (i == 0 || i == 4) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.log(new ao(TbadkCoreStatisticKey.SET_NIGHT_MODE).dk("obj_type", "0").dk("obj_source", "0"));
            }
            BitmapHelper.clearCashBitmap();
        }
    }

    public void dbD() {
        this.lrk.recycle();
        this.lrl.recycle();
        this.lrm.recycle();
        this.lrn.recycle();
        this.lrp.recycle();
        this.lrq.recycle();
        this.lrr.recycle();
        this.lrs.recycle();
        this.lrt.recycle();
    }

    public void onChangeSkinType(int i) {
        nq(i);
        if (this.lri != null) {
            this.lrf.getLayoutMode().setNightMode(i == 1);
            this.lrf.getLayoutMode().onModeChanged(this.lri.getView());
        }
        if (i == 1) {
            this.lrF.turnOnNoCallback();
        } else {
            this.lrF.turnOffNoCallback();
        }
    }

    public void nq(int i) {
        an.setBackgroundColor(this.lrw, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.lrk.nq(i);
        this.lrf.getLayoutMode().setNightMode(i == 1);
        this.lrf.getLayoutMode().onModeChanged(this.lrw);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        dcA();
        this.lrF.setBackgroundRes(an.getBitmap(R.drawable.bg_switch_open), an.getBitmap(R.drawable.bg_switch_close), an.getBitmap(R.drawable.btn_handle));
        this.lrH.setBackgroundRes(an.getBitmap(R.drawable.bg_switch_open), an.getBitmap(R.drawable.bg_switch_close), an.getBitmap(R.drawable.btn_handle));
        an.setBackgroundColor(this.lrx, R.color.cp_bg_line_d);
        this.lrj.setLocalIcon(an.lr(R.drawable.icon_mine_list_baidu));
        if (this.lri != null) {
            this.lri.onChangeSkinType();
        }
        this.lrj.nq(i);
        this.lrk.nq(i);
        this.lrl.onChangeSkinType(i);
        this.lrm.onChangeSkinType(i);
        this.lrn.onChangeSkinType(i);
        this.lro.onChangeSkinType(i);
        this.lrp.onChangeSkinType(i);
        this.lrq.onChangeSkinType(i);
        this.lrr.onChangeSkinType(i);
        this.lrs.onChangeSkinType(i);
        this.lrt.onChangeSkinType(i);
        this.lru.onChangeSkinType(i);
    }

    private void bdD() {
        View.OnClickListener clickListener = getClickListener();
        this.lrw = (RelativeLayout) this.lrf.findViewById(R.id.parent);
        this.lrx = this.lrf.findViewById(R.id.scroll);
        this.lrf.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.lrf.findViewById(R.id.view_navigation_bar);
        this.lry = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.lrf.getPageContext().getString(R.string.setup));
        this.mNavigationBar.showBottomLine();
        this.lrj = (SettingTextNormalImageView) this.lrf.findViewById(R.id.accountSafeSetting);
        this.lrk = (SettingTextImageView) this.lrf.findViewById(R.id.personInfo);
        this.lrl = (TbSettingTextTipView) this.lrf.findViewById(R.id.interest_label_setting);
        this.lrl.setTopLineVisibility(true);
        this.lrm = (TbSettingTextTipView) this.lrf.findViewById(R.id.accountManager);
        this.lrm.setTopLineVisibility(true);
        this.lrn = (TbSettingTextTipView) this.lrf.findViewById(R.id.browseSetting);
        this.lrn.setBottomLineVisibility(true);
        this.lro = (TbSettingTextTipView) this.lrf.findViewById(R.id.adSetting);
        this.lro.setBottomLineVisibility(true);
        this.lrp = (TbSettingTextTipView) this.lrf.findViewById(R.id.messageSetting);
        this.lrp.setBottomLineVisibility(true);
        this.lrn.setBottomLineVisibility(true);
        this.lrq = (TbSettingTextTipView) this.lrf.findViewById(R.id.secretSetting);
        this.lrq.setBottomLineVisibility(true);
        this.lrr = (SettingTextVersionView) this.lrf.findViewById(R.id.versionInfo);
        this.lrs = (TbSettingTextTipView) this.lrf.findViewById(R.id.feedBack);
        this.lrs.setTopLineVisibility(true);
        this.lrs.setBottomLineVisibility(true);
        this.lrt = (TbSettingTextTipView) this.lrf.findViewById(R.id.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.lrt.setVisibility(8);
            this.lrt.setBottomLineVisibility(false);
        } else {
            this.lrt.setVisibility(0);
            this.lrt.setBottomLineVisibility(true);
        }
        this.lru = (TbSettingTextNewDotView) this.lrf.findViewById(R.id.systemhelpsetting);
        this.lrv = (TextView) this.lrf.findViewById(R.id.quit);
        this.lrE = (RelativeLayout) this.lrf.findViewById(R.id.eyeshield_mode);
        this.lrF = (BdSwitchView) this.lrf.findViewById(R.id.item_switch);
        l.addToParentArea(this.lrf.getPageContext().getPageActivity(), this.lrF, 10, 10, 10, 10);
        this.lrG = (RelativeLayout) this.lrf.findViewById(R.id.follow_system_day_night_mode);
        this.lrH = (BdSwitchView) this.lrf.findViewById(R.id.follow_system_item_switch);
        l.addToParentArea(this.lrf.getPageContext().getPageActivity(), this.lrH, 10, 10, 10, 10);
        this.lrz = this.lrf.findViewById(R.id.divide_view2);
        this.lrA = this.lrf.findViewById(R.id.divide_view1);
        this.lrB = this.lrf.findViewById(R.id.divide_view3);
        this.lrC = this.lrf.findViewById(R.id.divide_view4);
        this.lrD = this.lrf.findViewById(R.id.divide_view5);
        dcA();
        dcz();
        this.lrk.ddE();
        nq(TbadkCoreApplication.getInst().getSkinType());
        this.lrA.setVisibility(0);
        this.lrB.setVisibility(0);
        this.lrC.setVisibility(0);
        this.lrD.setVisibility(0);
        ab(clickListener);
        if (!dcC()) {
            this.lrn.setTip(this.lrf.getResources().getString(R.string.browsing_settings_tip_no_night));
            this.lrz.setVisibility(8);
            this.lrE.setVisibility(8);
        } else {
            this.lrz.setVisibility(0);
            this.lrE.setVisibility(0);
        }
        this.lrG.setVisibility(dcD() ? 0 : 8);
        if (com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean("key_is_follow_system_mode", false)) {
            this.lrH.turnOnNoCallback();
        } else {
            this.lrH.turnOffNoCallback();
        }
    }

    private boolean dcC() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private boolean dcD() {
        if (dcC()) {
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean("key_is_dark_mode_notify_shown", false);
        }
        return false;
    }

    private void aaH() {
        this.lri = new k(getPageContext().getPageActivity());
        this.lri.setTitleText(getPageContext().getString(R.string.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getPageContext().getString(R.string.quite_current_account), this.lri);
        gVar.setTextColor(R.color.cp_cont_h);
        arrayList.add(gVar);
        this.lrf.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.lrf.getLayoutMode().onModeChanged(this.lri.getView());
        k.c cVar = new k.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (i == gVar.getId()) {
                    e.this.yY();
                    e.this.lrg.DY(12);
                }
            }
        };
        k.a aVar = new k.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                e.this.yY();
            }
        };
        this.lri.aL(arrayList);
        this.lri.a(cVar);
        this.lri.a(aVar);
        this.lrh = new com.baidu.tbadk.core.dialog.i(this.mContext);
        this.lrh.setCanceledOnTouchOutside(true);
        this.lrh.a(this.lri);
    }

    private void ab(View.OnClickListener onClickListener) {
        this.lrj.setOnClickListener(onClickListener);
        this.lry.setOnClickListener(onClickListener);
        this.lrk.setOnClickListener(onClickListener);
        this.lrl.setOnClickListener(onClickListener);
        this.lrm.setOnClickListener(onClickListener);
        this.lrn.setOnClickListener(onClickListener);
        this.lro.setOnClickListener(onClickListener);
        this.lrp.setOnClickListener(onClickListener);
        this.lrq.setOnClickListener(onClickListener);
        this.lrr.setOnClickListener(onClickListener);
        this.lrs.setOnClickListener(onClickListener);
        this.lrt.setOnClickListener(onClickListener);
        this.lru.setOnClickListener(onClickListener);
        this.lrv.setOnClickListener(onClickListener);
        this.lrF.setOnSwitchStateChangeListener(this.lrf);
        this.lrH.setOnSwitchStateChangeListener(this.lrf);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.lry) {
                    e.this.lrg.DY(0);
                } else if (view == e.this.lrk) {
                    e.this.lrg.DY(1);
                } else if (view == e.this.lrl) {
                    e.this.lrg.DY(15);
                } else if (view == e.this.lrm) {
                    e.this.lrg.DY(2);
                } else if (view == e.this.lrn) {
                    e.this.lrg.DY(3);
                } else if (view == e.this.lrp) {
                    e.this.lrg.DY(4);
                } else if (view == e.this.lrq) {
                    e.this.lrg.DY(9);
                } else if (view == e.this.lrr) {
                    e.this.lrg.DY(6);
                } else if (view == e.this.lrs) {
                    e.this.lrg.DY(7);
                } else if (view == e.this.lrt) {
                    e.this.lrg.DY(8);
                } else if (view == e.this.lru) {
                    e.this.lrg.DY(5);
                } else if (view == e.this.lrv) {
                    e.this.lrg.DY(10);
                } else if (view == e.this.lrj) {
                    e.this.lrg.DY(13);
                } else if (view == e.this.lro) {
                    e.this.lrg.DY(16);
                }
            }
        };
    }

    public void dcE() {
        if (this.lrh == null) {
            aaH();
        }
        this.lrh.showDialog();
    }

    public void yY() {
        if (this.lrh != null) {
            this.lrh.dismiss();
        }
    }

    public BdSwitchView dcF() {
        return this.lrF;
    }

    public BdSwitchView dcG() {
        return this.lrH;
    }
}
