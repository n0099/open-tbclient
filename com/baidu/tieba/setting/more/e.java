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
    private SettingTextVersionView nbD;
    private TbSettingTextTipView nbE;
    private TbSettingTextTipView nbF;
    private TbSettingTextNewDotView nbG;
    private TextView nbH;
    private RelativeLayout nbI;
    private View nbJ;
    private View nbK;
    private View nbL;
    private View nbM;
    private View nbN;
    private View nbO;
    private View nbP;
    private RelativeLayout nbQ;
    private BdSwitchView nbR;
    private RelativeLayout nbS;
    private BdSwitchView nbT;
    private MoreActivity nbq;
    private d nbr;
    private com.baidu.tbadk.core.dialog.i nbs;
    private k nbt;
    private SettingTextNormalImageView nbu;
    private SettingTextImageView nbv;
    private TbSettingTextTipView nbw;
    private TbSettingTextTipView nbx;
    private TbSettingTextTipView nby;
    private TbSettingTextTipView nbz;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.nbL = null;
        this.nbM = null;
        this.nbN = null;
        this.nbO = null;
        this.nbP = null;
        this.nbQ = null;
        this.nbR = null;
        this.nbS = null;
        this.nbT = null;
        this.nbq = moreActivity;
        this.nbr = dVar;
        this.nbq.setContentView(R.layout.more_activity);
        bDg();
        dIX();
    }

    public void dIV() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.nbv.setVisibility(8);
        } else {
            this.nbv.setVisibility(0);
        }
    }

    public void bc(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.nbv != null) {
                this.nbv.dKe();
                return;
            }
            return;
        }
        this.nbv.dKf();
        this.nbv.setIcon(str, z);
    }

    public void dIW() {
        if (this.nbD != null) {
            this.nbD.refresh();
        }
        if (this.nbG != null) {
            this.nbG.refresh();
        }
    }

    public void dIX() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.nbR.turnOn();
        } else {
            this.nbR.turnOff();
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

    public void dHW() {
        this.nbv.recycle();
        this.nbw.recycle();
        this.nbx.recycle();
        this.nby.recycle();
        this.nbz.recycle();
        this.nbB.recycle();
        this.nbC.recycle();
        this.nbD.recycle();
        this.nbE.recycle();
        this.nbF.recycle();
    }

    public void onChangeSkinType(int i) {
        sk(i);
        if (this.nbt != null) {
            this.nbq.getLayoutMode().setNightMode(i == 1);
            this.nbq.getLayoutMode().onModeChanged(this.nbt.getView());
        }
        if (i == 1) {
            this.nbR.turnOnNoCallback();
        } else {
            this.nbR.turnOffNoCallback();
        }
    }

    public void sk(int i) {
        ao.setBackgroundColor(this.nbI, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.nbv.sk(i);
        this.nbq.getLayoutMode().setNightMode(i == 1);
        this.nbq.getLayoutMode().onModeChanged(this.nbI);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        dIW();
        this.nbR.setBackgroundRes(ao.getBitmap(R.drawable.bg_switch_open), ao.getBitmap(R.drawable.bg_switch_close), ao.getBitmap(R.drawable.btn_handle));
        this.nbT.setBackgroundRes(ao.getBitmap(R.drawable.bg_switch_open), ao.getBitmap(R.drawable.bg_switch_close), ao.getBitmap(R.drawable.btn_handle));
        ao.setBackgroundColor(this.nbJ, R.color.CAM_X0201);
        this.nbu.setLocalIcon(ao.qc(R.drawable.icon_mine_list_baidu));
        if (this.nbt != null) {
            this.nbt.onChangeSkinType();
        }
        this.nbu.sk(i);
        this.nbv.sk(i);
        this.nbw.onChangeSkinType(i);
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
    }

    private void bDg() {
        View.OnClickListener clickListener = getClickListener();
        this.nbI = (RelativeLayout) this.nbq.findViewById(R.id.parent);
        this.nbJ = this.nbq.findViewById(R.id.scroll);
        this.nbq.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.nbq.findViewById(R.id.view_navigation_bar);
        this.nbK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.nbq.getPageContext().getString(R.string.setup));
        this.mNavigationBar.showBottomLine();
        this.nbu = (SettingTextNormalImageView) this.nbq.findViewById(R.id.accountSafeSetting);
        this.nbv = (SettingTextImageView) this.nbq.findViewById(R.id.personInfo);
        this.nbw = (TbSettingTextTipView) this.nbq.findViewById(R.id.interest_label_setting);
        this.nbw.setTopLineVisibility(true);
        this.nbx = (TbSettingTextTipView) this.nbq.findViewById(R.id.accountManager);
        this.nbx.setTopLineVisibility(true);
        this.nby = (TbSettingTextTipView) this.nbq.findViewById(R.id.browseSetting);
        this.nby.setBottomLineVisibility(true);
        this.nbz = (TbSettingTextTipView) this.nbq.findViewById(R.id.youngsterSetting);
        this.nbz.setBottomLineVisibility(true);
        if (com.baidu.tbadk.youngster.b.c.bME()) {
            this.nbz.setTip(this.nbq.getString(R.string.youngster_settings_tip_open));
        } else {
            this.nbz.setTip(this.nbq.getString(R.string.youngster_settings_tip_close));
        }
        this.nbA = (TbSettingTextTipView) this.nbq.findViewById(R.id.adSetting);
        this.nbA.setBottomLineVisibility(true);
        this.nbB = (TbSettingTextTipView) this.nbq.findViewById(R.id.messageSetting);
        this.nbB.setBottomLineVisibility(true);
        this.nby.setBottomLineVisibility(true);
        this.nbC = (TbSettingTextTipView) this.nbq.findViewById(R.id.secretSetting);
        this.nbC.setBottomLineVisibility(true);
        this.nbD = (SettingTextVersionView) this.nbq.findViewById(R.id.versionInfo);
        this.nbE = (TbSettingTextTipView) this.nbq.findViewById(R.id.feedBack);
        this.nbE.setTopLineVisibility(true);
        this.nbE.setBottomLineVisibility(true);
        this.nbF = (TbSettingTextTipView) this.nbq.findViewById(R.id.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.nbF.setVisibility(8);
            this.nbF.setBottomLineVisibility(false);
        } else {
            this.nbF.setVisibility(0);
            this.nbF.setBottomLineVisibility(true);
        }
        this.nbG = (TbSettingTextNewDotView) this.nbq.findViewById(R.id.systemhelpsetting);
        this.nbH = (TextView) this.nbq.findViewById(R.id.quit);
        this.nbQ = (RelativeLayout) this.nbq.findViewById(R.id.eyeshield_mode);
        this.nbR = (BdSwitchView) this.nbq.findViewById(R.id.item_switch);
        l.addToParentArea(this.nbq.getPageContext().getPageActivity(), this.nbR, 10, 10, 10, 10);
        this.nbS = (RelativeLayout) this.nbq.findViewById(R.id.follow_system_day_night_mode);
        this.nbT = (BdSwitchView) this.nbq.findViewById(R.id.follow_system_item_switch);
        l.addToParentArea(this.nbq.getPageContext().getPageActivity(), this.nbT, 10, 10, 10, 10);
        this.nbL = this.nbq.findViewById(R.id.divide_view2);
        this.nbM = this.nbq.findViewById(R.id.divide_view1);
        this.nbN = this.nbq.findViewById(R.id.divide_view3);
        this.nbO = this.nbq.findViewById(R.id.divide_view4);
        this.nbP = this.nbq.findViewById(R.id.divide_view5);
        dIW();
        dIV();
        this.nbv.dKe();
        sk(TbadkCoreApplication.getInst().getSkinType());
        this.nbM.setVisibility(0);
        this.nbN.setVisibility(0);
        this.nbO.setVisibility(0);
        this.nbP.setVisibility(0);
        ag(clickListener);
        if (!dIY()) {
            this.nby.setTip(this.nbq.getResources().getString(R.string.browsing_settings_tip_no_night));
            this.nbL.setVisibility(8);
            this.nbQ.setVisibility(8);
        } else {
            this.nbL.setVisibility(0);
            this.nbQ.setVisibility(0);
        }
        this.nbS.setVisibility(dIZ() ? 0 : 8);
        if (com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean("key_is_follow_system_mode", false)) {
            this.nbT.turnOnNoCallback();
        } else {
            this.nbT.turnOffNoCallback();
        }
    }

    private boolean dIY() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private boolean dIZ() {
        if (dIY()) {
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean("key_is_dark_mode_notify_shown", false);
        }
        return false;
    }

    private void atD() {
        this.nbt = new k(getPageContext().getPageActivity());
        this.nbt.setTitleText(getPageContext().getString(R.string.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getPageContext().getString(R.string.quite_current_account), this.nbt);
        gVar.setTextColor(R.color.CAM_X0301);
        arrayList.add(gVar);
        this.nbq.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.nbq.getLayoutMode().onModeChanged(this.nbt.getView());
        k.c cVar = new k.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (i == gVar.getId()) {
                    e.this.If();
                    e.this.nbr.JS(12);
                }
            }
        };
        k.a aVar = new k.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                e.this.If();
            }
        };
        this.nbt.bB(arrayList);
        this.nbt.a(cVar);
        this.nbt.a(aVar);
        this.nbs = new com.baidu.tbadk.core.dialog.i(this.mContext);
        this.nbs.setCanceledOnTouchOutside(true);
        this.nbs.a(this.nbt);
    }

    private void ag(View.OnClickListener onClickListener) {
        this.nbu.setOnClickListener(onClickListener);
        this.nbK.setOnClickListener(onClickListener);
        this.nbv.setOnClickListener(onClickListener);
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
        this.nbR.setOnSwitchStateChangeListener(this.nbq);
        this.nbT.setOnSwitchStateChangeListener(this.nbq);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.nbK) {
                    e.this.nbr.JS(0);
                } else if (view == e.this.nbv) {
                    e.this.nbr.JS(1);
                } else if (view == e.this.nbw) {
                    e.this.nbr.JS(15);
                } else if (view == e.this.nbx) {
                    e.this.nbr.JS(2);
                } else if (view == e.this.nby) {
                    e.this.nbr.JS(3);
                } else if (view == e.this.nbz) {
                    e.this.nbr.JS(17);
                } else if (view == e.this.nbB) {
                    e.this.nbr.JS(4);
                } else if (view == e.this.nbC) {
                    e.this.nbr.JS(9);
                } else if (view == e.this.nbD) {
                    e.this.nbr.JS(6);
                } else if (view == e.this.nbE) {
                    e.this.nbr.JS(7);
                } else if (view == e.this.nbF) {
                    e.this.nbr.JS(8);
                } else if (view == e.this.nbG) {
                    e.this.nbr.JS(5);
                } else if (view == e.this.nbH) {
                    e.this.nbr.JS(10);
                } else if (view == e.this.nbu) {
                    e.this.nbr.JS(13);
                } else if (view == e.this.nbA) {
                    e.this.nbr.JS(16);
                }
            }
        };
    }

    public void dJa() {
        if (this.nbs == null) {
            atD();
        }
        this.nbs.SY();
    }

    public void If() {
        if (this.nbs != null) {
            this.nbs.dismiss();
        }
    }

    public BdSwitchView dJb() {
        return this.nbR;
    }

    public BdSwitchView dJc() {
        return this.nbT;
    }

    public void onResume() {
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.nbq).areNotificationsEnabled();
        if (this.nbB != null) {
            this.nbB.setTipViewColor(R.color.CAM_X0105);
            this.nbB.setTip(areNotificationsEnabled ? "" : this.nbq.getString(R.string.may_lose_important_msg));
        }
    }
}
