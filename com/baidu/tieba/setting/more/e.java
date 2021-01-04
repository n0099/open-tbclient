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
/* loaded from: classes8.dex */
public class e extends com.baidu.adp.base.d<MoreActivity> {
    private NavigationBar mNavigationBar;
    private TbSettingTextTipView nbA;
    private TbSettingTextTipView nbB;
    private TbSettingTextTipView nbC;
    private TbSettingTextTipView nbD;
    private SettingTextVersionView nbE;
    private TbSettingTextTipView nbF;
    private TbSettingTextTipView nbG;
    private TbSettingTextNewDotView nbH;
    private TextView nbI;
    private RelativeLayout nbJ;
    private View nbK;
    private View nbL;
    private View nbM;
    private View nbN;
    private View nbO;
    private View nbP;
    private View nbQ;
    private RelativeLayout nbR;
    private BdSwitchView nbS;
    private RelativeLayout nbT;
    private BdSwitchView nbU;
    private MoreActivity nbr;
    private d nbs;
    private com.baidu.tbadk.core.dialog.i nbt;
    private k nbu;
    private SettingTextNormalImageView nbv;
    private SettingTextImageView nbw;
    private TbSettingTextTipView nbx;
    private TbSettingTextTipView nby;
    private TbSettingTextTipView nbz;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.nbM = null;
        this.nbN = null;
        this.nbO = null;
        this.nbP = null;
        this.nbQ = null;
        this.nbR = null;
        this.nbS = null;
        this.nbT = null;
        this.nbU = null;
        this.nbr = moreActivity;
        this.nbs = dVar;
        this.nbr.setContentView(R.layout.more_activity);
        bDf();
        dIW();
    }

    public void dIU() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.nbw.setVisibility(8);
        } else {
            this.nbw.setVisibility(0);
        }
    }

    public void bc(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.nbw != null) {
                this.nbw.dKd();
                return;
            }
            return;
        }
        this.nbw.dKe();
        this.nbw.setIcon(str, z);
    }

    public void dIV() {
        if (this.nbE != null) {
            this.nbE.refresh();
        }
        if (this.nbH != null) {
            this.nbH.refresh();
        }
    }

    public void dIW() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.nbS.turnOn();
        } else {
            this.nbS.turnOff();
        }
    }

    public void JX(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != i) {
            if (i == 1) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.SET_NIGHT_MODE).dX("obj_type", "1").dX("obj_source", "0"));
            } else if (i == 0 || i == 4) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.SET_NIGHT_MODE).dX("obj_type", "0").dX("obj_source", "0"));
            }
            BitmapHelper.clearCashBitmap();
        }
    }

    public void dHV() {
        this.nbw.recycle();
        this.nbx.recycle();
        this.nby.recycle();
        this.nbz.recycle();
        this.nbA.recycle();
        this.nbC.recycle();
        this.nbD.recycle();
        this.nbE.recycle();
        this.nbF.recycle();
        this.nbG.recycle();
    }

    public void onChangeSkinType(int i) {
        sk(i);
        if (this.nbu != null) {
            this.nbr.getLayoutMode().setNightMode(i == 1);
            this.nbr.getLayoutMode().onModeChanged(this.nbu.getView());
        }
        if (i == 1) {
            this.nbS.turnOnNoCallback();
        } else {
            this.nbS.turnOffNoCallback();
        }
    }

    public void sk(int i) {
        ao.setBackgroundColor(this.nbJ, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.nbw.sk(i);
        this.nbr.getLayoutMode().setNightMode(i == 1);
        this.nbr.getLayoutMode().onModeChanged(this.nbJ);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        dIV();
        this.nbS.setBackgroundRes(ao.getBitmap(R.drawable.bg_switch_open), ao.getBitmap(R.drawable.bg_switch_close), ao.getBitmap(R.drawable.btn_handle));
        this.nbU.setBackgroundRes(ao.getBitmap(R.drawable.bg_switch_open), ao.getBitmap(R.drawable.bg_switch_close), ao.getBitmap(R.drawable.btn_handle));
        ao.setBackgroundColor(this.nbK, R.color.CAM_X0201);
        this.nbv.setLocalIcon(ao.qc(R.drawable.icon_mine_list_baidu));
        if (this.nbu != null) {
            this.nbu.onChangeSkinType();
        }
        this.nbv.sk(i);
        this.nbw.sk(i);
        this.nbx.onChangeSkinType(i);
        this.nby.onChangeSkinType(i);
        this.nbz.onChangeSkinType(i);
        this.nbA.onChangeSkinType(i);
        this.nbB.onChangeSkinType(i);
        this.nbC.onChangeSkinType(i);
        this.nbD.onChangeSkinType(i);
        this.nbE.onChangeSkinType(i);
        this.nbF.onChangeSkinType(i);
        this.nbG.onChangeSkinType(i);
        this.nbH.onChangeSkinType(i);
    }

    private void bDf() {
        View.OnClickListener clickListener = getClickListener();
        this.nbJ = (RelativeLayout) this.nbr.findViewById(R.id.parent);
        this.nbK = this.nbr.findViewById(R.id.scroll);
        this.nbr.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.nbr.findViewById(R.id.view_navigation_bar);
        this.nbL = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.nbr.getPageContext().getString(R.string.setup));
        this.mNavigationBar.showBottomLine();
        this.nbv = (SettingTextNormalImageView) this.nbr.findViewById(R.id.accountSafeSetting);
        this.nbw = (SettingTextImageView) this.nbr.findViewById(R.id.personInfo);
        this.nbx = (TbSettingTextTipView) this.nbr.findViewById(R.id.interest_label_setting);
        this.nbx.setTopLineVisibility(true);
        this.nby = (TbSettingTextTipView) this.nbr.findViewById(R.id.accountManager);
        this.nby.setTopLineVisibility(true);
        this.nbz = (TbSettingTextTipView) this.nbr.findViewById(R.id.browseSetting);
        this.nbz.setBottomLineVisibility(true);
        this.nbA = (TbSettingTextTipView) this.nbr.findViewById(R.id.youngsterSetting);
        this.nbA.setBottomLineVisibility(true);
        if (com.baidu.tbadk.youngster.b.c.bMD()) {
            this.nbA.setTip(this.nbr.getString(R.string.youngster_settings_tip_open));
        } else {
            this.nbA.setTip(this.nbr.getString(R.string.youngster_settings_tip_close));
        }
        this.nbB = (TbSettingTextTipView) this.nbr.findViewById(R.id.adSetting);
        this.nbB.setBottomLineVisibility(true);
        this.nbC = (TbSettingTextTipView) this.nbr.findViewById(R.id.messageSetting);
        this.nbC.setBottomLineVisibility(true);
        this.nbz.setBottomLineVisibility(true);
        this.nbD = (TbSettingTextTipView) this.nbr.findViewById(R.id.secretSetting);
        this.nbD.setBottomLineVisibility(true);
        this.nbE = (SettingTextVersionView) this.nbr.findViewById(R.id.versionInfo);
        this.nbF = (TbSettingTextTipView) this.nbr.findViewById(R.id.feedBack);
        this.nbF.setTopLineVisibility(true);
        this.nbF.setBottomLineVisibility(true);
        this.nbG = (TbSettingTextTipView) this.nbr.findViewById(R.id.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.nbG.setVisibility(8);
            this.nbG.setBottomLineVisibility(false);
        } else {
            this.nbG.setVisibility(0);
            this.nbG.setBottomLineVisibility(true);
        }
        this.nbH = (TbSettingTextNewDotView) this.nbr.findViewById(R.id.systemhelpsetting);
        this.nbI = (TextView) this.nbr.findViewById(R.id.quit);
        this.nbR = (RelativeLayout) this.nbr.findViewById(R.id.eyeshield_mode);
        this.nbS = (BdSwitchView) this.nbr.findViewById(R.id.item_switch);
        l.addToParentArea(this.nbr.getPageContext().getPageActivity(), this.nbS, 10, 10, 10, 10);
        this.nbT = (RelativeLayout) this.nbr.findViewById(R.id.follow_system_day_night_mode);
        this.nbU = (BdSwitchView) this.nbr.findViewById(R.id.follow_system_item_switch);
        l.addToParentArea(this.nbr.getPageContext().getPageActivity(), this.nbU, 10, 10, 10, 10);
        this.nbM = this.nbr.findViewById(R.id.divide_view2);
        this.nbN = this.nbr.findViewById(R.id.divide_view1);
        this.nbO = this.nbr.findViewById(R.id.divide_view3);
        this.nbP = this.nbr.findViewById(R.id.divide_view4);
        this.nbQ = this.nbr.findViewById(R.id.divide_view5);
        dIV();
        dIU();
        this.nbw.dKd();
        sk(TbadkCoreApplication.getInst().getSkinType());
        this.nbN.setVisibility(0);
        this.nbO.setVisibility(0);
        this.nbP.setVisibility(0);
        this.nbQ.setVisibility(0);
        ag(clickListener);
        if (!dIX()) {
            this.nbz.setTip(this.nbr.getResources().getString(R.string.browsing_settings_tip_no_night));
            this.nbM.setVisibility(8);
            this.nbR.setVisibility(8);
        } else {
            this.nbM.setVisibility(0);
            this.nbR.setVisibility(0);
        }
        this.nbT.setVisibility(dIY() ? 0 : 8);
        if (com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean("key_is_follow_system_mode", false)) {
            this.nbU.turnOnNoCallback();
        } else {
            this.nbU.turnOffNoCallback();
        }
    }

    private boolean dIX() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private boolean dIY() {
        if (dIX()) {
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean("key_is_dark_mode_notify_shown", false);
        }
        return false;
    }

    private void atC() {
        this.nbu = new k(getPageContext().getPageActivity());
        this.nbu.setTitleText(getPageContext().getString(R.string.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getPageContext().getString(R.string.quite_current_account), this.nbu);
        gVar.setTextColor(R.color.CAM_X0301);
        arrayList.add(gVar);
        this.nbr.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.nbr.getLayoutMode().onModeChanged(this.nbu.getView());
        k.c cVar = new k.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (i == gVar.getId()) {
                    e.this.If();
                    e.this.nbs.JS(12);
                }
            }
        };
        k.a aVar = new k.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                e.this.If();
            }
        };
        this.nbu.bB(arrayList);
        this.nbu.a(cVar);
        this.nbu.a(aVar);
        this.nbt = new com.baidu.tbadk.core.dialog.i(this.mContext);
        this.nbt.setCanceledOnTouchOutside(true);
        this.nbt.a(this.nbu);
    }

    private void ag(View.OnClickListener onClickListener) {
        this.nbv.setOnClickListener(onClickListener);
        this.nbL.setOnClickListener(onClickListener);
        this.nbw.setOnClickListener(onClickListener);
        this.nbx.setOnClickListener(onClickListener);
        this.nby.setOnClickListener(onClickListener);
        this.nbz.setOnClickListener(onClickListener);
        this.nbA.setOnClickListener(onClickListener);
        this.nbB.setOnClickListener(onClickListener);
        this.nbC.setOnClickListener(onClickListener);
        this.nbD.setOnClickListener(onClickListener);
        this.nbE.setOnClickListener(onClickListener);
        this.nbF.setOnClickListener(onClickListener);
        this.nbG.setOnClickListener(onClickListener);
        this.nbH.setOnClickListener(onClickListener);
        this.nbI.setOnClickListener(onClickListener);
        this.nbS.setOnSwitchStateChangeListener(this.nbr);
        this.nbU.setOnSwitchStateChangeListener(this.nbr);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.nbL) {
                    e.this.nbs.JS(0);
                } else if (view == e.this.nbw) {
                    e.this.nbs.JS(1);
                } else if (view == e.this.nbx) {
                    e.this.nbs.JS(15);
                } else if (view == e.this.nby) {
                    e.this.nbs.JS(2);
                } else if (view == e.this.nbz) {
                    e.this.nbs.JS(3);
                } else if (view == e.this.nbA) {
                    e.this.nbs.JS(17);
                } else if (view == e.this.nbC) {
                    e.this.nbs.JS(4);
                } else if (view == e.this.nbD) {
                    e.this.nbs.JS(9);
                } else if (view == e.this.nbE) {
                    e.this.nbs.JS(6);
                } else if (view == e.this.nbF) {
                    e.this.nbs.JS(7);
                } else if (view == e.this.nbG) {
                    e.this.nbs.JS(8);
                } else if (view == e.this.nbH) {
                    e.this.nbs.JS(5);
                } else if (view == e.this.nbI) {
                    e.this.nbs.JS(10);
                } else if (view == e.this.nbv) {
                    e.this.nbs.JS(13);
                } else if (view == e.this.nbB) {
                    e.this.nbs.JS(16);
                }
            }
        };
    }

    public void dIZ() {
        if (this.nbt == null) {
            atC();
        }
        this.nbt.SY();
    }

    public void If() {
        if (this.nbt != null) {
            this.nbt.dismiss();
        }
    }

    public BdSwitchView dJa() {
        return this.nbS;
    }

    public BdSwitchView dJb() {
        return this.nbU;
    }

    public void onResume() {
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.nbr).areNotificationsEnabled();
        if (this.nbC != null) {
            this.nbC.setTipViewColor(R.color.CAM_X0105);
            this.nbC.setTip(areNotificationsEnabled ? "" : this.nbr.getString(R.string.may_lose_important_msg));
        }
    }
}
