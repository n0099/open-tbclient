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
    private MoreActivity isL;
    private d isM;
    private com.baidu.tbadk.core.dialog.g isN;
    private i isO;
    private SettingTextNormalImageView isP;
    private SettingTextImageView isQ;
    private TbSettingTextTipView isR;
    private TbSettingTextTipView isS;
    private TbSettingTextTipView isT;
    private TbSettingTextTipView isU;
    private TbSettingTextTipView isV;
    private TbSettingTextTipView isW;
    private SettingTextVersionView isX;
    private TbSettingTextTipView isY;
    private TbSettingTextTipView isZ;
    private TbSettingTextNewDotView ita;
    private TextView itb;
    private RelativeLayout itc;
    private View itd;
    private View ite;
    private View itf;
    private View itg;
    private View ith;
    private View iti;
    private View itj;
    private RelativeLayout itk;
    private BdSwitchView itl;
    private NavigationBar mNavigationBar;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.itf = null;
        this.itg = null;
        this.ith = null;
        this.iti = null;
        this.itj = null;
        this.itk = null;
        this.itl = null;
        this.isL = moreActivity;
        this.isM = dVar;
        this.isL.setContentView(d.h.more_activity);
        akr();
        bZD();
    }

    public void bZB() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.isQ.setVisibility(8);
        } else {
            this.isQ.setVisibility(0);
        }
    }

    public void as(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.isQ != null) {
                this.isQ.caC();
                return;
            }
            return;
        }
        this.isQ.caD();
        this.isQ.setIcon(str, z);
    }

    public void bZC() {
        if (this.isX != null) {
            this.isX.refresh();
        }
        if (this.ita != null) {
            this.ita.refresh();
        }
    }

    public void bZD() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.itl.oa();
        } else {
            this.itl.ob();
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

    public void bYF() {
        this.isQ.recycle();
        this.isR.recycle();
        this.isS.recycle();
        this.isT.recycle();
        this.isV.recycle();
        this.isW.recycle();
        this.isX.recycle();
        this.isY.recycle();
        this.isZ.recycle();
    }

    public void onChangeSkinType(int i) {
        jg(i);
        if (this.isO != null) {
            this.isL.getLayoutMode().setNightMode(i == 1);
            this.isL.getLayoutMode().onModeChanged(this.isO.abi());
        }
    }

    public void jg(int i) {
        al.l(this.itc, d.C0236d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.isQ.jg(i);
        this.isL.getLayoutMode().setNightMode(i == 1);
        this.isL.getLayoutMode().onModeChanged(this.itc);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        bZC();
        this.itl.setBackgroundRes(al.hq(d.f.bg_switch_open), al.hq(d.f.bg_switch_close), al.hq(d.f.btn_handle));
        al.l(this.itd, d.C0236d.cp_bg_line_d);
        this.isP.setLocalIcon(al.hu(d.f.icon_mine_list_baidu));
        if (this.isO != null) {
            this.isO.onChangeSkinType();
        }
    }

    private void akr() {
        View.OnClickListener clickListener = getClickListener();
        this.itc = (RelativeLayout) this.isL.findViewById(d.g.parent);
        this.itd = this.isL.findViewById(d.g.scroll);
        this.isL.findViewById(d.g.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.isL.findViewById(d.g.view_navigation_bar);
        this.ite = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.isL.getPageContext().getString(d.j.setup));
        this.mNavigationBar.showBottomLine();
        this.isP = (SettingTextNormalImageView) this.isL.findViewById(d.g.accountSafeSetting);
        this.isQ = (SettingTextImageView) this.isL.findViewById(d.g.personInfo);
        this.isR = (TbSettingTextTipView) this.isL.findViewById(d.g.interest_label_setting);
        this.isR.setTopLineVisibility(true);
        this.isS = (TbSettingTextTipView) this.isL.findViewById(d.g.accountManager);
        this.isS.setTopLineVisibility(true);
        this.isT = (TbSettingTextTipView) this.isL.findViewById(d.g.browseSetting);
        this.isT.setBottomLineVisibility(true);
        this.isU = (TbSettingTextTipView) this.isL.findViewById(d.g.adSetting);
        this.isU.setBottomLineVisibility(true);
        this.isV = (TbSettingTextTipView) this.isL.findViewById(d.g.messageSetting);
        this.isV.setBottomLineVisibility(true);
        this.isT.setBottomLineVisibility(true);
        this.isW = (TbSettingTextTipView) this.isL.findViewById(d.g.secretSetting);
        this.isW.setBottomLineVisibility(true);
        this.isX = (SettingTextVersionView) this.isL.findViewById(d.g.versionInfo);
        this.isY = (TbSettingTextTipView) this.isL.findViewById(d.g.feedBack);
        this.isY.setTopLineVisibility(true);
        this.isY.setBottomLineVisibility(true);
        this.isZ = (TbSettingTextTipView) this.isL.findViewById(d.g.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.isZ.setVisibility(8);
            this.isZ.setBottomLineVisibility(false);
        } else {
            this.isZ.setVisibility(0);
            this.isZ.setBottomLineVisibility(true);
        }
        this.ita = (TbSettingTextNewDotView) this.isL.findViewById(d.g.systemhelpsetting);
        this.itb = (TextView) this.isL.findViewById(d.g.quit);
        this.itk = (RelativeLayout) this.isL.findViewById(d.g.eyeshield_mode);
        this.itl = (BdSwitchView) this.isL.findViewById(d.g.item_switch);
        l.b(this.isL.getPageContext().getPageActivity(), this.itl, 10, 10, 10, 10);
        this.itf = this.isL.findViewById(d.g.divide_view2);
        this.itg = this.isL.findViewById(d.g.divide_view1);
        this.ith = this.isL.findViewById(d.g.divide_view3);
        this.iti = this.isL.findViewById(d.g.divide_view4);
        this.itj = this.isL.findViewById(d.g.divide_view5);
        bZC();
        bZB();
        this.isQ.caC();
        jg(TbadkCoreApplication.getInst().getSkinType());
        this.itg.setVisibility(0);
        this.ith.setVisibility(0);
        this.iti.setVisibility(0);
        this.itj.setVisibility(0);
        U(clickListener);
        if (!bZE()) {
            this.isT.setTip(this.isL.getResources().getString(d.j.browsing_settings_tip_no_night));
            this.itf.setVisibility(8);
            this.itk.setVisibility(8);
            return;
        }
        this.itf.setVisibility(0);
        this.itk.setVisibility(0);
    }

    private boolean bZE() {
        return MessageManager.getInstance().runTask(2001281, Boolean.class) != null;
    }

    private void zn() {
        this.isO = new i(getPageContext().getPageActivity());
        this.isO.setTitleText(getPageContext().getString(d.j.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.f fVar = new com.baidu.tbadk.core.dialog.f(getPageContext().getString(d.j.quite_current_account), this.isO);
        fVar.setTextColor(d.C0236d.cp_cont_h);
        arrayList.add(fVar);
        this.isL.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.isL.getLayoutMode().onModeChanged(this.isO.abi());
        i.c cVar = new i.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(i iVar, int i, View view) {
                if (i == fVar.getId()) {
                    e.this.aty();
                    e.this.isM.yy(12);
                }
            }
        };
        i.a aVar = new i.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.i.a
            public void onClick() {
                e.this.aty();
            }
        };
        this.isO.P(arrayList);
        this.isO.a(cVar);
        this.isO.a(aVar);
        this.isN = new com.baidu.tbadk.core.dialog.g(this.mContext);
        this.isN.setCanceledOnTouchOutside(true);
        this.isN.setContentView(this.isO.abk());
    }

    private void U(View.OnClickListener onClickListener) {
        this.isP.setOnClickListener(onClickListener);
        this.ite.setOnClickListener(onClickListener);
        this.isQ.setOnClickListener(onClickListener);
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
        this.itl.setOnSwitchStateChangeListener(this.isL);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.ite) {
                    e.this.isM.yy(0);
                } else if (view == e.this.isQ) {
                    e.this.isM.yy(1);
                } else if (view == e.this.isR) {
                    e.this.isM.yy(15);
                } else if (view == e.this.isS) {
                    e.this.isM.yy(2);
                } else if (view == e.this.isT) {
                    e.this.isM.yy(3);
                } else if (view == e.this.isV) {
                    e.this.isM.yy(4);
                } else if (view == e.this.isW) {
                    e.this.isM.yy(9);
                } else if (view == e.this.isX) {
                    e.this.isM.yy(6);
                } else if (view == e.this.isY) {
                    e.this.isM.yy(7);
                } else if (view == e.this.isZ) {
                    e.this.isM.yy(8);
                } else if (view == e.this.ita) {
                    e.this.isM.yy(5);
                } else if (view == e.this.itb) {
                    e.this.isM.yy(10);
                } else if (view == e.this.isP) {
                    e.this.isM.yy(13);
                } else if (view == e.this.isU) {
                    e.this.isM.yy(16);
                }
            }
        };
    }

    public void bZF() {
        if (this.isN == null) {
            zn();
        }
        this.isN.showDialog();
    }

    public void aty() {
        if (this.isN != null) {
            this.isN.dismiss();
        }
    }

    public BdSwitchView bZG() {
        return this.itl;
    }
}
