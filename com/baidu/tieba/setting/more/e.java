package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
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
    private MoreActivity iRC;
    private d iRD;
    private i iRE;
    private k iRF;
    private SettingTextNormalImageView iRG;
    private SettingTextImageView iRH;
    private TbSettingTextTipView iRI;
    private TbSettingTextTipView iRJ;
    private TbSettingTextTipView iRK;
    private TbSettingTextTipView iRL;
    private TbSettingTextTipView iRM;
    private TbSettingTextTipView iRN;
    private SettingTextVersionView iRO;
    private TbSettingTextTipView iRP;
    private TbSettingTextTipView iRQ;
    private TbSettingTextNewDotView iRR;
    private TextView iRS;
    private RelativeLayout iRT;
    private View iRU;
    private View iRV;
    private View iRW;
    private View iRX;
    private View iRY;
    private View iRZ;
    private View iSa;
    private RelativeLayout iSb;
    private BdSwitchView iSc;
    private NavigationBar mNavigationBar;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.iRW = null;
        this.iRX = null;
        this.iRY = null;
        this.iRZ = null;
        this.iSa = null;
        this.iSb = null;
        this.iSc = null;
        this.iRC = moreActivity;
        this.iRD = dVar;
        this.iRC.setContentView(R.layout.more_activity);
        aqv();
        ckA();
    }

    public void cky() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.iRH.setVisibility(8);
        } else {
            this.iRH.setVisibility(0);
        }
    }

    public void az(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.iRH != null) {
                this.iRH.clA();
                return;
            }
            return;
        }
        this.iRH.clB();
        this.iRH.setIcon(str, z);
    }

    public void ckz() {
        if (this.iRO != null) {
            this.iRO.refresh();
        }
        if (this.iRR != null) {
            this.iRR.refresh();
        }
    }

    public void ckA() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.iSc.nm();
        } else {
            this.iSc.nn();
        }
    }

    public void Am(int i) {
        if (i == 1) {
            if (TbadkCoreApplication.getInst().getSkinType() != 1) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new an("c10647").bT("obj_type", "1").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
            } else {
                return;
            }
        } else if (i == 0) {
            if (TbadkCoreApplication.getInst().getSkinType() != 0) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.log(new an("c10647").bT("obj_type", "0").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
            } else {
                return;
            }
        }
        BitmapHelper.clearCashBitmap();
    }

    public void cjD() {
        this.iRH.recycle();
        this.iRI.recycle();
        this.iRJ.recycle();
        this.iRK.recycle();
        this.iRM.recycle();
        this.iRN.recycle();
        this.iRO.recycle();
        this.iRP.recycle();
        this.iRQ.recycle();
    }

    public void onChangeSkinType(int i) {
        jZ(i);
        if (this.iRF != null) {
            this.iRC.getLayoutMode().setNightMode(i == 1);
            this.iRC.getLayoutMode().onModeChanged(this.iRF.agZ());
        }
        if (i == 1) {
            this.iSc.nk();
        } else {
            this.iSc.nl();
        }
    }

    public void jZ(int i) {
        am.l(this.iRT, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iRH.jZ(i);
        this.iRC.getLayoutMode().setNightMode(i == 1);
        this.iRC.getLayoutMode().onModeChanged(this.iRT);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ckz();
        this.iSc.setBackgroundRes(am.ij(R.drawable.bg_switch_open), am.ij(R.drawable.bg_switch_close), am.ij(R.drawable.btn_handle));
        am.l(this.iRU, R.color.cp_bg_line_d);
        this.iRG.setLocalIcon(am.in(R.drawable.icon_mine_list_baidu));
        if (this.iRF != null) {
            this.iRF.onChangeSkinType();
        }
    }

    private void aqv() {
        View.OnClickListener clickListener = getClickListener();
        this.iRT = (RelativeLayout) this.iRC.findViewById(R.id.parent);
        this.iRU = this.iRC.findViewById(R.id.scroll);
        this.iRC.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.iRC.findViewById(R.id.view_navigation_bar);
        this.iRV = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.iRC.getPageContext().getString(R.string.setup));
        this.mNavigationBar.showBottomLine();
        this.iRG = (SettingTextNormalImageView) this.iRC.findViewById(R.id.accountSafeSetting);
        this.iRH = (SettingTextImageView) this.iRC.findViewById(R.id.personInfo);
        this.iRI = (TbSettingTextTipView) this.iRC.findViewById(R.id.interest_label_setting);
        this.iRI.setTopLineVisibility(true);
        this.iRJ = (TbSettingTextTipView) this.iRC.findViewById(R.id.accountManager);
        this.iRJ.setTopLineVisibility(true);
        this.iRK = (TbSettingTextTipView) this.iRC.findViewById(R.id.browseSetting);
        this.iRK.setBottomLineVisibility(true);
        this.iRL = (TbSettingTextTipView) this.iRC.findViewById(R.id.adSetting);
        this.iRL.setBottomLineVisibility(true);
        this.iRM = (TbSettingTextTipView) this.iRC.findViewById(R.id.messageSetting);
        this.iRM.setBottomLineVisibility(true);
        this.iRK.setBottomLineVisibility(true);
        this.iRN = (TbSettingTextTipView) this.iRC.findViewById(R.id.secretSetting);
        this.iRN.setBottomLineVisibility(true);
        this.iRO = (SettingTextVersionView) this.iRC.findViewById(R.id.versionInfo);
        this.iRP = (TbSettingTextTipView) this.iRC.findViewById(R.id.feedBack);
        this.iRP.setTopLineVisibility(true);
        this.iRP.setBottomLineVisibility(true);
        this.iRQ = (TbSettingTextTipView) this.iRC.findViewById(R.id.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.iRQ.setVisibility(8);
            this.iRQ.setBottomLineVisibility(false);
        } else {
            this.iRQ.setVisibility(0);
            this.iRQ.setBottomLineVisibility(true);
        }
        this.iRR = (TbSettingTextNewDotView) this.iRC.findViewById(R.id.systemhelpsetting);
        this.iRS = (TextView) this.iRC.findViewById(R.id.quit);
        this.iSb = (RelativeLayout) this.iRC.findViewById(R.id.eyeshield_mode);
        this.iSc = (BdSwitchView) this.iRC.findViewById(R.id.item_switch);
        l.b(this.iRC.getPageContext().getPageActivity(), this.iSc, 10, 10, 10, 10);
        this.iRW = this.iRC.findViewById(R.id.divide_view2);
        this.iRX = this.iRC.findViewById(R.id.divide_view1);
        this.iRY = this.iRC.findViewById(R.id.divide_view3);
        this.iRZ = this.iRC.findViewById(R.id.divide_view4);
        this.iSa = this.iRC.findViewById(R.id.divide_view5);
        ckz();
        cky();
        this.iRH.clA();
        jZ(TbadkCoreApplication.getInst().getSkinType());
        this.iRX.setVisibility(0);
        this.iRY.setVisibility(0);
        this.iRZ.setVisibility(0);
        this.iSa.setVisibility(0);
        Z(clickListener);
        if (!ckB()) {
            this.iRK.setTip(this.iRC.getResources().getString(R.string.browsing_settings_tip_no_night));
            this.iRW.setVisibility(8);
            this.iSb.setVisibility(8);
            return;
        }
        this.iRW.setVisibility(0);
        this.iSb.setVisibility(0);
    }

    private boolean ckB() {
        return MessageManager.getInstance().runTask(2001281, Boolean.class) != null;
    }

    private void AT() {
        this.iRF = new k(getPageContext().getPageActivity());
        this.iRF.setTitleText(getPageContext().getString(R.string.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getPageContext().getString(R.string.quite_current_account), this.iRF);
        gVar.setTextColor(R.color.cp_cont_h);
        arrayList.add(gVar);
        this.iRC.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.iRC.getLayoutMode().onModeChanged(this.iRF.agZ());
        k.c cVar = new k.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (i == gVar.getId()) {
                    e.this.azP();
                    e.this.iRD.Ah(12);
                }
            }
        };
        k.a aVar = new k.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                e.this.azP();
            }
        };
        this.iRF.W(arrayList);
        this.iRF.a(cVar);
        this.iRF.a(aVar);
        this.iRE = new i(this.mContext);
        this.iRE.setCanceledOnTouchOutside(true);
        this.iRE.setContentView(this.iRF.ahb());
    }

    private void Z(View.OnClickListener onClickListener) {
        this.iRG.setOnClickListener(onClickListener);
        this.iRV.setOnClickListener(onClickListener);
        this.iRH.setOnClickListener(onClickListener);
        this.iRI.setOnClickListener(onClickListener);
        this.iRJ.setOnClickListener(onClickListener);
        this.iRK.setOnClickListener(onClickListener);
        this.iRL.setOnClickListener(onClickListener);
        this.iRM.setOnClickListener(onClickListener);
        this.iRN.setOnClickListener(onClickListener);
        this.iRO.setOnClickListener(onClickListener);
        this.iRP.setOnClickListener(onClickListener);
        this.iRQ.setOnClickListener(onClickListener);
        this.iRR.setOnClickListener(onClickListener);
        this.iRS.setOnClickListener(onClickListener);
        this.iSc.setOnSwitchStateChangeListener(this.iRC);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.iRV) {
                    e.this.iRD.Ah(0);
                } else if (view == e.this.iRH) {
                    e.this.iRD.Ah(1);
                } else if (view == e.this.iRI) {
                    e.this.iRD.Ah(15);
                } else if (view == e.this.iRJ) {
                    e.this.iRD.Ah(2);
                } else if (view == e.this.iRK) {
                    e.this.iRD.Ah(3);
                } else if (view == e.this.iRM) {
                    e.this.iRD.Ah(4);
                } else if (view == e.this.iRN) {
                    e.this.iRD.Ah(9);
                } else if (view == e.this.iRO) {
                    e.this.iRD.Ah(6);
                } else if (view == e.this.iRP) {
                    e.this.iRD.Ah(7);
                } else if (view == e.this.iRQ) {
                    e.this.iRD.Ah(8);
                } else if (view == e.this.iRR) {
                    e.this.iRD.Ah(5);
                } else if (view == e.this.iRS) {
                    e.this.iRD.Ah(10);
                } else if (view == e.this.iRG) {
                    e.this.iRD.Ah(13);
                } else if (view == e.this.iRL) {
                    e.this.iRD.Ah(16);
                }
            }
        };
    }

    public void ckC() {
        if (this.iRE == null) {
            AT();
        }
        this.iRE.showDialog();
    }

    public void azP() {
        if (this.iRE != null) {
            this.iRE.dismiss();
        }
    }

    public BdSwitchView ckD() {
        return this.iSc;
    }
}
