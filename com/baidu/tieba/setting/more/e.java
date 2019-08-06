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
    private MoreActivity iSG;
    private d iSH;
    private i iSI;
    private k iSJ;
    private SettingTextNormalImageView iSK;
    private SettingTextImageView iSL;
    private TbSettingTextTipView iSM;
    private TbSettingTextTipView iSN;
    private TbSettingTextTipView iSO;
    private TbSettingTextTipView iSP;
    private TbSettingTextTipView iSQ;
    private TbSettingTextTipView iSR;
    private SettingTextVersionView iSS;
    private TbSettingTextTipView iST;
    private TbSettingTextTipView iSU;
    private TbSettingTextNewDotView iSV;
    private TextView iSW;
    private RelativeLayout iSX;
    private View iSY;
    private View iSZ;
    private View iTa;
    private View iTb;
    private View iTc;
    private View iTd;
    private View iTe;
    private RelativeLayout iTf;
    private BdSwitchView iTg;
    private NavigationBar mNavigationBar;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.iTa = null;
        this.iTb = null;
        this.iTc = null;
        this.iTd = null;
        this.iTe = null;
        this.iTf = null;
        this.iTg = null;
        this.iSG = moreActivity;
        this.iSH = dVar;
        this.iSG.setContentView(R.layout.more_activity);
        aqx();
        ckS();
    }

    public void ckQ() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.iSL.setVisibility(8);
        } else {
            this.iSL.setVisibility(0);
        }
    }

    public void az(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.iSL != null) {
                this.iSL.clS();
                return;
            }
            return;
        }
        this.iSL.clT();
        this.iSL.setIcon(str, z);
    }

    public void ckR() {
        if (this.iSS != null) {
            this.iSS.refresh();
        }
        if (this.iSV != null) {
            this.iSV.refresh();
        }
    }

    public void ckS() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.iTg.nm();
        } else {
            this.iTg.nn();
        }
    }

    public void Ao(int i) {
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

    public void cjV() {
        this.iSL.recycle();
        this.iSM.recycle();
        this.iSN.recycle();
        this.iSO.recycle();
        this.iSQ.recycle();
        this.iSR.recycle();
        this.iSS.recycle();
        this.iST.recycle();
        this.iSU.recycle();
    }

    public void onChangeSkinType(int i) {
        ka(i);
        if (this.iSJ != null) {
            this.iSG.getLayoutMode().setNightMode(i == 1);
            this.iSG.getLayoutMode().onModeChanged(this.iSJ.ahb());
        }
        if (i == 1) {
            this.iTg.nk();
        } else {
            this.iTg.nl();
        }
    }

    public void ka(int i) {
        am.l(this.iSX, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iSL.ka(i);
        this.iSG.getLayoutMode().setNightMode(i == 1);
        this.iSG.getLayoutMode().onModeChanged(this.iSX);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ckR();
        this.iTg.setBackgroundRes(am.ij(R.drawable.bg_switch_open), am.ij(R.drawable.bg_switch_close), am.ij(R.drawable.btn_handle));
        am.l(this.iSY, R.color.cp_bg_line_d);
        this.iSK.setLocalIcon(am.in(R.drawable.icon_mine_list_baidu));
        if (this.iSJ != null) {
            this.iSJ.onChangeSkinType();
        }
    }

    private void aqx() {
        View.OnClickListener clickListener = getClickListener();
        this.iSX = (RelativeLayout) this.iSG.findViewById(R.id.parent);
        this.iSY = this.iSG.findViewById(R.id.scroll);
        this.iSG.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.iSG.findViewById(R.id.view_navigation_bar);
        this.iSZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.iSG.getPageContext().getString(R.string.setup));
        this.mNavigationBar.showBottomLine();
        this.iSK = (SettingTextNormalImageView) this.iSG.findViewById(R.id.accountSafeSetting);
        this.iSL = (SettingTextImageView) this.iSG.findViewById(R.id.personInfo);
        this.iSM = (TbSettingTextTipView) this.iSG.findViewById(R.id.interest_label_setting);
        this.iSM.setTopLineVisibility(true);
        this.iSN = (TbSettingTextTipView) this.iSG.findViewById(R.id.accountManager);
        this.iSN.setTopLineVisibility(true);
        this.iSO = (TbSettingTextTipView) this.iSG.findViewById(R.id.browseSetting);
        this.iSO.setBottomLineVisibility(true);
        this.iSP = (TbSettingTextTipView) this.iSG.findViewById(R.id.adSetting);
        this.iSP.setBottomLineVisibility(true);
        this.iSQ = (TbSettingTextTipView) this.iSG.findViewById(R.id.messageSetting);
        this.iSQ.setBottomLineVisibility(true);
        this.iSO.setBottomLineVisibility(true);
        this.iSR = (TbSettingTextTipView) this.iSG.findViewById(R.id.secretSetting);
        this.iSR.setBottomLineVisibility(true);
        this.iSS = (SettingTextVersionView) this.iSG.findViewById(R.id.versionInfo);
        this.iST = (TbSettingTextTipView) this.iSG.findViewById(R.id.feedBack);
        this.iST.setTopLineVisibility(true);
        this.iST.setBottomLineVisibility(true);
        this.iSU = (TbSettingTextTipView) this.iSG.findViewById(R.id.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.iSU.setVisibility(8);
            this.iSU.setBottomLineVisibility(false);
        } else {
            this.iSU.setVisibility(0);
            this.iSU.setBottomLineVisibility(true);
        }
        this.iSV = (TbSettingTextNewDotView) this.iSG.findViewById(R.id.systemhelpsetting);
        this.iSW = (TextView) this.iSG.findViewById(R.id.quit);
        this.iTf = (RelativeLayout) this.iSG.findViewById(R.id.eyeshield_mode);
        this.iTg = (BdSwitchView) this.iSG.findViewById(R.id.item_switch);
        l.b(this.iSG.getPageContext().getPageActivity(), this.iTg, 10, 10, 10, 10);
        this.iTa = this.iSG.findViewById(R.id.divide_view2);
        this.iTb = this.iSG.findViewById(R.id.divide_view1);
        this.iTc = this.iSG.findViewById(R.id.divide_view3);
        this.iTd = this.iSG.findViewById(R.id.divide_view4);
        this.iTe = this.iSG.findViewById(R.id.divide_view5);
        ckR();
        ckQ();
        this.iSL.clS();
        ka(TbadkCoreApplication.getInst().getSkinType());
        this.iTb.setVisibility(0);
        this.iTc.setVisibility(0);
        this.iTd.setVisibility(0);
        this.iTe.setVisibility(0);
        Z(clickListener);
        if (!ckT()) {
            this.iSO.setTip(this.iSG.getResources().getString(R.string.browsing_settings_tip_no_night));
            this.iTa.setVisibility(8);
            this.iTf.setVisibility(8);
            return;
        }
        this.iTa.setVisibility(0);
        this.iTf.setVisibility(0);
    }

    private boolean ckT() {
        return MessageManager.getInstance().runTask(2001281, Boolean.class) != null;
    }

    private void AT() {
        this.iSJ = new k(getPageContext().getPageActivity());
        this.iSJ.setTitleText(getPageContext().getString(R.string.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getPageContext().getString(R.string.quite_current_account), this.iSJ);
        gVar.setTextColor(R.color.cp_cont_h);
        arrayList.add(gVar);
        this.iSG.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.iSG.getLayoutMode().onModeChanged(this.iSJ.ahb());
        k.c cVar = new k.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (i == gVar.getId()) {
                    e.this.azR();
                    e.this.iSH.Aj(12);
                }
            }
        };
        k.a aVar = new k.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                e.this.azR();
            }
        };
        this.iSJ.W(arrayList);
        this.iSJ.a(cVar);
        this.iSJ.a(aVar);
        this.iSI = new i(this.mContext);
        this.iSI.setCanceledOnTouchOutside(true);
        this.iSI.setContentView(this.iSJ.ahd());
    }

    private void Z(View.OnClickListener onClickListener) {
        this.iSK.setOnClickListener(onClickListener);
        this.iSZ.setOnClickListener(onClickListener);
        this.iSL.setOnClickListener(onClickListener);
        this.iSM.setOnClickListener(onClickListener);
        this.iSN.setOnClickListener(onClickListener);
        this.iSO.setOnClickListener(onClickListener);
        this.iSP.setOnClickListener(onClickListener);
        this.iSQ.setOnClickListener(onClickListener);
        this.iSR.setOnClickListener(onClickListener);
        this.iSS.setOnClickListener(onClickListener);
        this.iST.setOnClickListener(onClickListener);
        this.iSU.setOnClickListener(onClickListener);
        this.iSV.setOnClickListener(onClickListener);
        this.iSW.setOnClickListener(onClickListener);
        this.iTg.setOnSwitchStateChangeListener(this.iSG);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.iSZ) {
                    e.this.iSH.Aj(0);
                } else if (view == e.this.iSL) {
                    e.this.iSH.Aj(1);
                } else if (view == e.this.iSM) {
                    e.this.iSH.Aj(15);
                } else if (view == e.this.iSN) {
                    e.this.iSH.Aj(2);
                } else if (view == e.this.iSO) {
                    e.this.iSH.Aj(3);
                } else if (view == e.this.iSQ) {
                    e.this.iSH.Aj(4);
                } else if (view == e.this.iSR) {
                    e.this.iSH.Aj(9);
                } else if (view == e.this.iSS) {
                    e.this.iSH.Aj(6);
                } else if (view == e.this.iST) {
                    e.this.iSH.Aj(7);
                } else if (view == e.this.iSU) {
                    e.this.iSH.Aj(8);
                } else if (view == e.this.iSV) {
                    e.this.iSH.Aj(5);
                } else if (view == e.this.iSW) {
                    e.this.iSH.Aj(10);
                } else if (view == e.this.iSK) {
                    e.this.iSH.Aj(13);
                } else if (view == e.this.iSP) {
                    e.this.iSH.Aj(16);
                }
            }
        };
    }

    public void ckU() {
        if (this.iSI == null) {
            AT();
        }
        this.iSI.showDialog();
    }

    public void azR() {
        if (this.iSI != null) {
            this.iSI.dismiss();
        }
    }

    public BdSwitchView ckV() {
        return this.iTg;
    }
}
