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
    private MoreActivity isM;
    private d isN;
    private com.baidu.tbadk.core.dialog.g isO;
    private i isP;
    private SettingTextNormalImageView isQ;
    private SettingTextImageView isR;
    private TbSettingTextTipView isS;
    private TbSettingTextTipView isT;
    private TbSettingTextTipView isU;
    private TbSettingTextTipView isV;
    private TbSettingTextTipView isW;
    private TbSettingTextTipView isX;
    private SettingTextVersionView isY;
    private TbSettingTextTipView isZ;
    private TbSettingTextTipView ita;
    private TbSettingTextNewDotView itb;
    private TextView itc;
    private RelativeLayout itd;
    private View ite;
    private View itf;
    private View itg;
    private View ith;
    private View iti;
    private View itj;
    private View itk;
    private RelativeLayout itl;
    private BdSwitchView itm;
    private NavigationBar mNavigationBar;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.itg = null;
        this.ith = null;
        this.iti = null;
        this.itj = null;
        this.itk = null;
        this.itl = null;
        this.itm = null;
        this.isM = moreActivity;
        this.isN = dVar;
        this.isM.setContentView(d.h.more_activity);
        akr();
        bZE();
    }

    public void bZC() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.isR.setVisibility(8);
        } else {
            this.isR.setVisibility(0);
        }
    }

    public void at(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.isR != null) {
                this.isR.caD();
                return;
            }
            return;
        }
        this.isR.caE();
        this.isR.setIcon(str, z);
    }

    public void bZD() {
        if (this.isY != null) {
            this.isY.refresh();
        }
        if (this.itb != null) {
            this.itb.refresh();
        }
    }

    public void bZE() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.itm.oa();
        } else {
            this.itm.ob();
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

    public void bYG() {
        this.isR.recycle();
        this.isS.recycle();
        this.isT.recycle();
        this.isU.recycle();
        this.isW.recycle();
        this.isX.recycle();
        this.isY.recycle();
        this.isZ.recycle();
        this.ita.recycle();
    }

    public void onChangeSkinType(int i) {
        jg(i);
        if (this.isP != null) {
            this.isM.getLayoutMode().setNightMode(i == 1);
            this.isM.getLayoutMode().onModeChanged(this.isP.abi());
        }
    }

    public void jg(int i) {
        al.l(this.itd, d.C0236d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.isR.jg(i);
        this.isM.getLayoutMode().setNightMode(i == 1);
        this.isM.getLayoutMode().onModeChanged(this.itd);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        bZD();
        this.itm.setBackgroundRes(al.hq(d.f.bg_switch_open), al.hq(d.f.bg_switch_close), al.hq(d.f.btn_handle));
        al.l(this.ite, d.C0236d.cp_bg_line_d);
        this.isQ.setLocalIcon(al.hu(d.f.icon_mine_list_baidu));
        if (this.isP != null) {
            this.isP.onChangeSkinType();
        }
    }

    private void akr() {
        View.OnClickListener clickListener = getClickListener();
        this.itd = (RelativeLayout) this.isM.findViewById(d.g.parent);
        this.ite = this.isM.findViewById(d.g.scroll);
        this.isM.findViewById(d.g.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.isM.findViewById(d.g.view_navigation_bar);
        this.itf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.isM.getPageContext().getString(d.j.setup));
        this.mNavigationBar.showBottomLine();
        this.isQ = (SettingTextNormalImageView) this.isM.findViewById(d.g.accountSafeSetting);
        this.isR = (SettingTextImageView) this.isM.findViewById(d.g.personInfo);
        this.isS = (TbSettingTextTipView) this.isM.findViewById(d.g.interest_label_setting);
        this.isS.setTopLineVisibility(true);
        this.isT = (TbSettingTextTipView) this.isM.findViewById(d.g.accountManager);
        this.isT.setTopLineVisibility(true);
        this.isU = (TbSettingTextTipView) this.isM.findViewById(d.g.browseSetting);
        this.isU.setBottomLineVisibility(true);
        this.isV = (TbSettingTextTipView) this.isM.findViewById(d.g.adSetting);
        this.isV.setBottomLineVisibility(true);
        this.isW = (TbSettingTextTipView) this.isM.findViewById(d.g.messageSetting);
        this.isW.setBottomLineVisibility(true);
        this.isU.setBottomLineVisibility(true);
        this.isX = (TbSettingTextTipView) this.isM.findViewById(d.g.secretSetting);
        this.isX.setBottomLineVisibility(true);
        this.isY = (SettingTextVersionView) this.isM.findViewById(d.g.versionInfo);
        this.isZ = (TbSettingTextTipView) this.isM.findViewById(d.g.feedBack);
        this.isZ.setTopLineVisibility(true);
        this.isZ.setBottomLineVisibility(true);
        this.ita = (TbSettingTextTipView) this.isM.findViewById(d.g.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.ita.setVisibility(8);
            this.ita.setBottomLineVisibility(false);
        } else {
            this.ita.setVisibility(0);
            this.ita.setBottomLineVisibility(true);
        }
        this.itb = (TbSettingTextNewDotView) this.isM.findViewById(d.g.systemhelpsetting);
        this.itc = (TextView) this.isM.findViewById(d.g.quit);
        this.itl = (RelativeLayout) this.isM.findViewById(d.g.eyeshield_mode);
        this.itm = (BdSwitchView) this.isM.findViewById(d.g.item_switch);
        l.b(this.isM.getPageContext().getPageActivity(), this.itm, 10, 10, 10, 10);
        this.itg = this.isM.findViewById(d.g.divide_view2);
        this.ith = this.isM.findViewById(d.g.divide_view1);
        this.iti = this.isM.findViewById(d.g.divide_view3);
        this.itj = this.isM.findViewById(d.g.divide_view4);
        this.itk = this.isM.findViewById(d.g.divide_view5);
        bZD();
        bZC();
        this.isR.caD();
        jg(TbadkCoreApplication.getInst().getSkinType());
        this.ith.setVisibility(0);
        this.iti.setVisibility(0);
        this.itj.setVisibility(0);
        this.itk.setVisibility(0);
        U(clickListener);
        if (!bZF()) {
            this.isU.setTip(this.isM.getResources().getString(d.j.browsing_settings_tip_no_night));
            this.itg.setVisibility(8);
            this.itl.setVisibility(8);
            return;
        }
        this.itg.setVisibility(0);
        this.itl.setVisibility(0);
    }

    private boolean bZF() {
        return MessageManager.getInstance().runTask(2001281, Boolean.class) != null;
    }

    private void zn() {
        this.isP = new i(getPageContext().getPageActivity());
        this.isP.setTitleText(getPageContext().getString(d.j.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.f fVar = new com.baidu.tbadk.core.dialog.f(getPageContext().getString(d.j.quite_current_account), this.isP);
        fVar.setTextColor(d.C0236d.cp_cont_h);
        arrayList.add(fVar);
        this.isM.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.isM.getLayoutMode().onModeChanged(this.isP.abi());
        i.c cVar = new i.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(i iVar, int i, View view) {
                if (i == fVar.getId()) {
                    e.this.atz();
                    e.this.isN.yy(12);
                }
            }
        };
        i.a aVar = new i.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.i.a
            public void onClick() {
                e.this.atz();
            }
        };
        this.isP.P(arrayList);
        this.isP.a(cVar);
        this.isP.a(aVar);
        this.isO = new com.baidu.tbadk.core.dialog.g(this.mContext);
        this.isO.setCanceledOnTouchOutside(true);
        this.isO.setContentView(this.isP.abk());
    }

    private void U(View.OnClickListener onClickListener) {
        this.isQ.setOnClickListener(onClickListener);
        this.itf.setOnClickListener(onClickListener);
        this.isR.setOnClickListener(onClickListener);
        this.isS.setOnClickListener(onClickListener);
        this.isT.setOnClickListener(onClickListener);
        this.isU.setOnClickListener(onClickListener);
        this.isV.setOnClickListener(onClickListener);
        this.isW.setOnClickListener(onClickListener);
        this.isX.setOnClickListener(onClickListener);
        this.isY.setOnClickListener(onClickListener);
        this.isZ.setOnClickListener(onClickListener);
        this.ita.setOnClickListener(onClickListener);
        this.itb.setOnClickListener(onClickListener);
        this.itc.setOnClickListener(onClickListener);
        this.itm.setOnSwitchStateChangeListener(this.isM);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.itf) {
                    e.this.isN.yy(0);
                } else if (view == e.this.isR) {
                    e.this.isN.yy(1);
                } else if (view == e.this.isS) {
                    e.this.isN.yy(15);
                } else if (view == e.this.isT) {
                    e.this.isN.yy(2);
                } else if (view == e.this.isU) {
                    e.this.isN.yy(3);
                } else if (view == e.this.isW) {
                    e.this.isN.yy(4);
                } else if (view == e.this.isX) {
                    e.this.isN.yy(9);
                } else if (view == e.this.isY) {
                    e.this.isN.yy(6);
                } else if (view == e.this.isZ) {
                    e.this.isN.yy(7);
                } else if (view == e.this.ita) {
                    e.this.isN.yy(8);
                } else if (view == e.this.itb) {
                    e.this.isN.yy(5);
                } else if (view == e.this.itc) {
                    e.this.isN.yy(10);
                } else if (view == e.this.isQ) {
                    e.this.isN.yy(13);
                } else if (view == e.this.isV) {
                    e.this.isN.yy(16);
                }
            }
        };
    }

    public void bZG() {
        if (this.isO == null) {
            zn();
        }
        this.isO.showDialog();
    }

    public void atz() {
        if (this.isO != null) {
            this.isO.dismiss();
        }
    }

    public BdSwitchView bZH() {
        return this.itm;
    }
}
