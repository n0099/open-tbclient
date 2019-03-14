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
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e extends com.baidu.adp.base.c<MoreActivity> {
    private MoreActivity isF;
    private d isG;
    private com.baidu.tbadk.core.dialog.g isH;
    private i isI;
    private SettingTextNormalImageView isJ;
    private SettingTextImageView isK;
    private TbSettingTextTipView isL;
    private TbSettingTextTipView isM;
    private TbSettingTextTipView isN;
    private TbSettingTextTipView isO;
    private TbSettingTextTipView isP;
    private TbSettingTextTipView isQ;
    private SettingTextVersionView isR;
    private TbSettingTextTipView isS;
    private TbSettingTextTipView isT;
    private TbSettingTextNewDotView isU;
    private TextView isV;
    private RelativeLayout isW;
    private View isX;
    private View isY;
    private View isZ;
    private View ita;
    private View itb;
    private View itc;
    private View itd;
    private RelativeLayout ite;
    private BdSwitchView itf;
    private NavigationBar mNavigationBar;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.isZ = null;
        this.ita = null;
        this.itb = null;
        this.itc = null;
        this.itd = null;
        this.ite = null;
        this.itf = null;
        this.isF = moreActivity;
        this.isG = dVar;
        this.isF.setContentView(d.h.more_activity);
        akq();
        bZG();
    }

    public void bZE() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.isK.setVisibility(8);
        } else {
            this.isK.setVisibility(0);
        }
    }

    public void at(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.isK != null) {
                this.isK.caF();
                return;
            }
            return;
        }
        this.isK.caG();
        this.isK.setIcon(str, z);
    }

    public void bZF() {
        if (this.isR != null) {
            this.isR.refresh();
        }
        if (this.isU != null) {
            this.isU.refresh();
        }
    }

    public void bZG() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.itf.oa();
        } else {
            this.itf.ob();
        }
    }

    public void yD(int i) {
        if (i == 1) {
            if (TbadkCoreApplication.getInst().getSkinType() != 1) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new am("c10647").bJ("obj_type", "1").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
            } else {
                return;
            }
        } else if (i == 0) {
            if (TbadkCoreApplication.getInst().getSkinType() != 0) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.log(new am("c10647").bJ("obj_type", "0").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
            } else {
                return;
            }
        }
        BitmapHelper.clearCashBitmap();
    }

    public void bYI() {
        this.isK.recycle();
        this.isL.recycle();
        this.isM.recycle();
        this.isN.recycle();
        this.isP.recycle();
        this.isQ.recycle();
        this.isR.recycle();
        this.isS.recycle();
        this.isT.recycle();
    }

    public void onChangeSkinType(int i) {
        jg(i);
        if (this.isI != null) {
            this.isF.getLayoutMode().setNightMode(i == 1);
            this.isF.getLayoutMode().onModeChanged(this.isI.abi());
        }
    }

    public void jg(int i) {
        al.l(this.isW, d.C0277d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.isK.jg(i);
        this.isF.getLayoutMode().setNightMode(i == 1);
        this.isF.getLayoutMode().onModeChanged(this.isW);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        bZF();
        this.itf.setBackgroundRes(al.hq(d.f.bg_switch_open), al.hq(d.f.bg_switch_close), al.hq(d.f.btn_handle));
        al.l(this.isX, d.C0277d.cp_bg_line_d);
        this.isJ.setLocalIcon(al.hu(d.f.icon_mine_list_baidu));
        if (this.isI != null) {
            this.isI.onChangeSkinType();
        }
    }

    private void akq() {
        View.OnClickListener clickListener = getClickListener();
        this.isW = (RelativeLayout) this.isF.findViewById(d.g.parent);
        this.isX = this.isF.findViewById(d.g.scroll);
        this.isF.findViewById(d.g.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.isF.findViewById(d.g.view_navigation_bar);
        this.isY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.isF.getPageContext().getString(d.j.setup));
        this.mNavigationBar.showBottomLine();
        this.isJ = (SettingTextNormalImageView) this.isF.findViewById(d.g.accountSafeSetting);
        this.isK = (SettingTextImageView) this.isF.findViewById(d.g.personInfo);
        this.isL = (TbSettingTextTipView) this.isF.findViewById(d.g.interest_label_setting);
        this.isL.setTopLineVisibility(true);
        this.isM = (TbSettingTextTipView) this.isF.findViewById(d.g.accountManager);
        this.isM.setTopLineVisibility(true);
        this.isN = (TbSettingTextTipView) this.isF.findViewById(d.g.browseSetting);
        this.isN.setBottomLineVisibility(true);
        this.isO = (TbSettingTextTipView) this.isF.findViewById(d.g.adSetting);
        this.isO.setBottomLineVisibility(true);
        this.isP = (TbSettingTextTipView) this.isF.findViewById(d.g.messageSetting);
        this.isP.setBottomLineVisibility(true);
        this.isN.setBottomLineVisibility(true);
        this.isQ = (TbSettingTextTipView) this.isF.findViewById(d.g.secretSetting);
        this.isQ.setBottomLineVisibility(true);
        this.isR = (SettingTextVersionView) this.isF.findViewById(d.g.versionInfo);
        this.isS = (TbSettingTextTipView) this.isF.findViewById(d.g.feedBack);
        this.isS.setTopLineVisibility(true);
        this.isS.setBottomLineVisibility(true);
        this.isT = (TbSettingTextTipView) this.isF.findViewById(d.g.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.isT.setVisibility(8);
            this.isT.setBottomLineVisibility(false);
        } else {
            this.isT.setVisibility(0);
            this.isT.setBottomLineVisibility(true);
        }
        this.isU = (TbSettingTextNewDotView) this.isF.findViewById(d.g.systemhelpsetting);
        this.isV = (TextView) this.isF.findViewById(d.g.quit);
        this.ite = (RelativeLayout) this.isF.findViewById(d.g.eyeshield_mode);
        this.itf = (BdSwitchView) this.isF.findViewById(d.g.item_switch);
        l.b(this.isF.getPageContext().getPageActivity(), this.itf, 10, 10, 10, 10);
        this.isZ = this.isF.findViewById(d.g.divide_view2);
        this.ita = this.isF.findViewById(d.g.divide_view1);
        this.itb = this.isF.findViewById(d.g.divide_view3);
        this.itc = this.isF.findViewById(d.g.divide_view4);
        this.itd = this.isF.findViewById(d.g.divide_view5);
        bZF();
        bZE();
        this.isK.caF();
        jg(TbadkCoreApplication.getInst().getSkinType());
        this.ita.setVisibility(0);
        this.itb.setVisibility(0);
        this.itc.setVisibility(0);
        this.itd.setVisibility(0);
        U(clickListener);
        if (!bZH()) {
            this.isN.setTip(this.isF.getResources().getString(d.j.browsing_settings_tip_no_night));
            this.isZ.setVisibility(8);
            this.ite.setVisibility(8);
            return;
        }
        this.isZ.setVisibility(0);
        this.ite.setVisibility(0);
    }

    private boolean bZH() {
        return MessageManager.getInstance().runTask(2001281, Boolean.class) != null;
    }

    private void zn() {
        this.isI = new i(getPageContext().getPageActivity());
        this.isI.setTitleText(getPageContext().getString(d.j.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.f fVar = new com.baidu.tbadk.core.dialog.f(getPageContext().getString(d.j.quite_current_account), this.isI);
        fVar.setTextColor(d.C0277d.cp_cont_h);
        arrayList.add(fVar);
        this.isF.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.isF.getLayoutMode().onModeChanged(this.isI.abi());
        i.c cVar = new i.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(i iVar, int i, View view) {
                if (i == fVar.getId()) {
                    e.this.aty();
                    e.this.isG.yy(12);
                }
            }
        };
        i.a aVar = new i.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.i.a
            public void onClick() {
                e.this.aty();
            }
        };
        this.isI.P(arrayList);
        this.isI.a(cVar);
        this.isI.a(aVar);
        this.isH = new com.baidu.tbadk.core.dialog.g(this.mContext);
        this.isH.setCanceledOnTouchOutside(true);
        this.isH.setContentView(this.isI.abk());
    }

    private void U(View.OnClickListener onClickListener) {
        this.isJ.setOnClickListener(onClickListener);
        this.isY.setOnClickListener(onClickListener);
        this.isK.setOnClickListener(onClickListener);
        this.isL.setOnClickListener(onClickListener);
        this.isM.setOnClickListener(onClickListener);
        this.isN.setOnClickListener(onClickListener);
        this.isO.setOnClickListener(onClickListener);
        this.isP.setOnClickListener(onClickListener);
        this.isQ.setOnClickListener(onClickListener);
        this.isR.setOnClickListener(onClickListener);
        this.isS.setOnClickListener(onClickListener);
        this.isT.setOnClickListener(onClickListener);
        this.isU.setOnClickListener(onClickListener);
        this.isV.setOnClickListener(onClickListener);
        this.itf.setOnSwitchStateChangeListener(this.isF);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.isY) {
                    e.this.isG.yy(0);
                } else if (view == e.this.isK) {
                    e.this.isG.yy(1);
                } else if (view == e.this.isL) {
                    e.this.isG.yy(15);
                } else if (view == e.this.isM) {
                    e.this.isG.yy(2);
                } else if (view == e.this.isN) {
                    e.this.isG.yy(3);
                } else if (view == e.this.isP) {
                    e.this.isG.yy(4);
                } else if (view == e.this.isQ) {
                    e.this.isG.yy(9);
                } else if (view == e.this.isR) {
                    e.this.isG.yy(6);
                } else if (view == e.this.isS) {
                    e.this.isG.yy(7);
                } else if (view == e.this.isT) {
                    e.this.isG.yy(8);
                } else if (view == e.this.isU) {
                    e.this.isG.yy(5);
                } else if (view == e.this.isV) {
                    e.this.isG.yy(10);
                } else if (view == e.this.isJ) {
                    e.this.isG.yy(13);
                } else if (view == e.this.isO) {
                    e.this.isG.yy(16);
                }
            }
        };
    }

    public void bZI() {
        if (this.isH == null) {
            zn();
        }
        this.isH.showDialog();
    }

    public void aty() {
        if (this.isH != null) {
            this.isH.dismiss();
        }
    }

    public BdSwitchView bZJ() {
        return this.itf;
    }
}
