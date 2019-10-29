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
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e extends com.baidu.adp.base.c<MoreActivity> {
    private MoreActivity iUM;
    private d iUN;
    private i iUO;
    private k iUP;
    private SettingTextNormalImageView iUQ;
    private SettingTextImageView iUR;
    private TbSettingTextTipView iUS;
    private TbSettingTextTipView iUT;
    private TbSettingTextTipView iUU;
    private TbSettingTextTipView iUV;
    private TbSettingTextTipView iUW;
    private TbSettingTextTipView iUX;
    private SettingTextVersionView iUY;
    private TbSettingTextTipView iUZ;
    private TbSettingTextTipView iVa;
    private TbSettingTextNewDotView iVb;
    private TextView iVc;
    private RelativeLayout iVd;
    private View iVe;
    private View iVf;
    private View iVg;
    private View iVh;
    private View iVi;
    private View iVj;
    private View iVk;
    private RelativeLayout iVl;
    private BdSwitchView iVm;
    private RelativeLayout iVn;
    private BdSwitchView iVo;
    private NavigationBar mNavigationBar;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.iVg = null;
        this.iVh = null;
        this.iVi = null;
        this.iVj = null;
        this.iVk = null;
        this.iVl = null;
        this.iVm = null;
        this.iVn = null;
        this.iVo = null;
        this.iUM = moreActivity;
        this.iUN = dVar;
        this.iUM.setContentView(R.layout.more_activity);
        asD();
        cjq();
    }

    public void cjo() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.iUR.setVisibility(8);
        } else {
            this.iUR.setVisibility(0);
        }
    }

    public void au(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.iUR != null) {
                this.iUR.ckr();
                return;
            }
            return;
        }
        this.iUR.cks();
        this.iUR.setIcon(str, z);
    }

    public void cjp() {
        if (this.iUY != null) {
            this.iUY.refresh();
        }
        if (this.iVb != null) {
            this.iVb.refresh();
        }
    }

    public void cjq() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.iVm.turnOn();
        } else {
            this.iVm.turnOff();
        }
    }

    public void yZ(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != i) {
            if (i == 1) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new an(TbadkCoreStatisticKey.SET_NIGHT_MODE).bS("obj_type", "1").bS("obj_source", "0"));
            } else if (i == 0 || i == 4) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.log(new an(TbadkCoreStatisticKey.SET_NIGHT_MODE).bS("obj_type", "0").bS("obj_source", "0"));
            }
            BitmapHelper.clearCashBitmap();
        }
    }

    public void cit() {
        this.iUR.recycle();
        this.iUS.recycle();
        this.iUT.recycle();
        this.iUU.recycle();
        this.iUW.recycle();
        this.iUX.recycle();
        this.iUY.recycle();
        this.iUZ.recycle();
        this.iVa.recycle();
    }

    public void onChangeSkinType(int i) {
        jA(i);
        if (this.iUP != null) {
            this.iUM.getLayoutMode().setNightMode(i == 1);
            this.iUM.getLayoutMode().onModeChanged(this.iUP.alc());
        }
        if (i == 1) {
            this.iVm.turnOnNoCallback();
        } else {
            this.iVm.turnOffNoCallback();
        }
    }

    public void jA(int i) {
        am.setBackgroundColor(this.iVd, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iUR.jA(i);
        this.iUM.getLayoutMode().setNightMode(i == 1);
        this.iUM.getLayoutMode().onModeChanged(this.iVd);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        cjp();
        this.iVm.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        this.iVo.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        am.setBackgroundColor(this.iVe, R.color.cp_bg_line_d);
        this.iUQ.setLocalIcon(am.is(R.drawable.icon_mine_list_baidu));
        if (this.iUP != null) {
            this.iUP.onChangeSkinType();
        }
    }

    private void asD() {
        View.OnClickListener clickListener = getClickListener();
        this.iVd = (RelativeLayout) this.iUM.findViewById(R.id.parent);
        this.iVe = this.iUM.findViewById(R.id.scroll);
        this.iUM.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.iUM.findViewById(R.id.view_navigation_bar);
        this.iVf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.iUM.getPageContext().getString(R.string.setup));
        this.mNavigationBar.showBottomLine();
        this.iUQ = (SettingTextNormalImageView) this.iUM.findViewById(R.id.accountSafeSetting);
        this.iUR = (SettingTextImageView) this.iUM.findViewById(R.id.personInfo);
        this.iUS = (TbSettingTextTipView) this.iUM.findViewById(R.id.interest_label_setting);
        this.iUS.setTopLineVisibility(true);
        this.iUT = (TbSettingTextTipView) this.iUM.findViewById(R.id.accountManager);
        this.iUT.setTopLineVisibility(true);
        this.iUU = (TbSettingTextTipView) this.iUM.findViewById(R.id.browseSetting);
        this.iUU.setBottomLineVisibility(true);
        this.iUV = (TbSettingTextTipView) this.iUM.findViewById(R.id.adSetting);
        this.iUV.setBottomLineVisibility(true);
        this.iUW = (TbSettingTextTipView) this.iUM.findViewById(R.id.messageSetting);
        this.iUW.setBottomLineVisibility(true);
        this.iUU.setBottomLineVisibility(true);
        this.iUX = (TbSettingTextTipView) this.iUM.findViewById(R.id.secretSetting);
        this.iUX.setBottomLineVisibility(true);
        this.iUY = (SettingTextVersionView) this.iUM.findViewById(R.id.versionInfo);
        this.iUZ = (TbSettingTextTipView) this.iUM.findViewById(R.id.feedBack);
        this.iUZ.setTopLineVisibility(true);
        this.iUZ.setBottomLineVisibility(true);
        this.iVa = (TbSettingTextTipView) this.iUM.findViewById(R.id.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.iVa.setVisibility(8);
            this.iVa.setBottomLineVisibility(false);
        } else {
            this.iVa.setVisibility(0);
            this.iVa.setBottomLineVisibility(true);
        }
        this.iVb = (TbSettingTextNewDotView) this.iUM.findViewById(R.id.systemhelpsetting);
        this.iVc = (TextView) this.iUM.findViewById(R.id.quit);
        this.iVl = (RelativeLayout) this.iUM.findViewById(R.id.eyeshield_mode);
        this.iVm = (BdSwitchView) this.iUM.findViewById(R.id.item_switch);
        l.addToParentArea(this.iUM.getPageContext().getPageActivity(), this.iVm, 10, 10, 10, 10);
        this.iVn = (RelativeLayout) this.iUM.findViewById(R.id.follow_system_day_night_mode);
        this.iVo = (BdSwitchView) this.iUM.findViewById(R.id.follow_system_item_switch);
        l.addToParentArea(this.iUM.getPageContext().getPageActivity(), this.iVo, 10, 10, 10, 10);
        this.iVg = this.iUM.findViewById(R.id.divide_view2);
        this.iVh = this.iUM.findViewById(R.id.divide_view1);
        this.iVi = this.iUM.findViewById(R.id.divide_view3);
        this.iVj = this.iUM.findViewById(R.id.divide_view4);
        this.iVk = this.iUM.findViewById(R.id.divide_view5);
        cjp();
        cjo();
        this.iUR.ckr();
        jA(TbadkCoreApplication.getInst().getSkinType());
        this.iVh.setVisibility(0);
        this.iVi.setVisibility(0);
        this.iVj.setVisibility(0);
        this.iVk.setVisibility(0);
        aa(clickListener);
        if (!cjr()) {
            this.iUU.setTip(this.iUM.getResources().getString(R.string.browsing_settings_tip_no_night));
            this.iVg.setVisibility(8);
            this.iVl.setVisibility(8);
        } else {
            this.iVg.setVisibility(0);
            this.iVl.setVisibility(0);
        }
        this.iVn.setVisibility(cjs() ? 0 : 8);
        if (com.baidu.tbadk.core.sharedPref.b.alR().getBoolean("key_is_follow_system_mode", false)) {
            this.iVo.turnOnNoCallback();
        } else {
            this.iVo.turnOffNoCallback();
        }
    }

    private boolean cjr() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private boolean cjs() {
        if (cjr()) {
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return com.baidu.tbadk.core.sharedPref.b.alR().getBoolean("key_is_dark_mode_notify_shown", false);
        }
        return false;
    }

    private void FS() {
        this.iUP = new k(getPageContext().getPageActivity());
        this.iUP.setTitleText(getPageContext().getString(R.string.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getPageContext().getString(R.string.quite_current_account), this.iUP);
        gVar.setTextColor(R.color.cp_cont_h);
        arrayList.add(gVar);
        this.iUM.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.iUM.getLayoutMode().onModeChanged(this.iUP.alc());
        k.c cVar = new k.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (i == gVar.getId()) {
                    e.this.aAm();
                    e.this.iUN.yU(12);
                }
            }
        };
        k.a aVar = new k.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                e.this.aAm();
            }
        };
        this.iUP.at(arrayList);
        this.iUP.a(cVar);
        this.iUP.a(aVar);
        this.iUO = new i(this.mContext);
        this.iUO.setCanceledOnTouchOutside(true);
        this.iUO.a(this.iUP);
    }

    private void aa(View.OnClickListener onClickListener) {
        this.iUQ.setOnClickListener(onClickListener);
        this.iVf.setOnClickListener(onClickListener);
        this.iUR.setOnClickListener(onClickListener);
        this.iUS.setOnClickListener(onClickListener);
        this.iUT.setOnClickListener(onClickListener);
        this.iUU.setOnClickListener(onClickListener);
        this.iUV.setOnClickListener(onClickListener);
        this.iUW.setOnClickListener(onClickListener);
        this.iUX.setOnClickListener(onClickListener);
        this.iUY.setOnClickListener(onClickListener);
        this.iUZ.setOnClickListener(onClickListener);
        this.iVa.setOnClickListener(onClickListener);
        this.iVb.setOnClickListener(onClickListener);
        this.iVc.setOnClickListener(onClickListener);
        this.iVm.setOnSwitchStateChangeListener(this.iUM);
        this.iVo.setOnSwitchStateChangeListener(this.iUM);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.iVf) {
                    e.this.iUN.yU(0);
                } else if (view == e.this.iUR) {
                    e.this.iUN.yU(1);
                } else if (view == e.this.iUS) {
                    e.this.iUN.yU(15);
                } else if (view == e.this.iUT) {
                    e.this.iUN.yU(2);
                } else if (view == e.this.iUU) {
                    e.this.iUN.yU(3);
                } else if (view == e.this.iUW) {
                    e.this.iUN.yU(4);
                } else if (view == e.this.iUX) {
                    e.this.iUN.yU(9);
                } else if (view == e.this.iUY) {
                    e.this.iUN.yU(6);
                } else if (view == e.this.iUZ) {
                    e.this.iUN.yU(7);
                } else if (view == e.this.iVa) {
                    e.this.iUN.yU(8);
                } else if (view == e.this.iVb) {
                    e.this.iUN.yU(5);
                } else if (view == e.this.iVc) {
                    e.this.iUN.yU(10);
                } else if (view == e.this.iUQ) {
                    e.this.iUN.yU(13);
                } else if (view == e.this.iUV) {
                    e.this.iUN.yU(16);
                }
            }
        };
    }

    public void cjt() {
        if (this.iUO == null) {
            FS();
        }
        this.iUO.showDialog();
    }

    public void aAm() {
        if (this.iUO != null) {
            this.iUO.dismiss();
        }
    }

    public BdSwitchView cju() {
        return this.iVm;
    }

    public BdSwitchView cjv() {
        return this.iVo;
    }
}
