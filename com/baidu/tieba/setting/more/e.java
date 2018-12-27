package com.baidu.tieba.setting.more;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class e extends com.baidu.adp.base.c<MoreActivity> {
    private MoreActivity gZQ;
    private d gZR;
    private AlertDialog gZS;
    private View gZT;
    private TbSettingTextTipView gZU;
    private SettingTextImageView gZV;
    private TbSettingTextTipView gZW;
    private TbSettingTextTipView gZX;
    private TbSettingTextTipView gZY;
    private TbSettingTextTipView gZZ;
    private TbSettingTextTipView haa;
    private TbSettingTextTipView hab;
    private SettingTextVersionView hac;
    private TbSettingTextTipView had;
    private TbSettingTextTipView hae;
    private TbSettingTextNewDotView haf;
    private TextView hag;
    private RelativeLayout hah;
    private View hai;
    private View haj;
    private View hak;
    private View hal;
    private View ham;
    private View han;
    private View hao;
    private RelativeLayout hap;
    private BdSwitchView haq;
    private NavigationBar mNavigationBar;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.hak = null;
        this.hal = null;
        this.ham = null;
        this.han = null;
        this.hao = null;
        this.hap = null;
        this.haq = null;
        this.gZQ = moreActivity;
        this.gZR = dVar;
        this.gZQ.setContentView(e.h.more_activity);
        Ky();
        byg();
    }

    public void bye() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.gZV.setVisibility(8);
        } else {
            this.gZV.setVisibility(0);
        }
    }

    public void ac(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.gZV != null) {
                this.gZV.bzf();
                return;
            }
            return;
        }
        this.gZV.bzg();
        this.gZV.setIcon(str, z);
    }

    public void byf() {
        if (this.hac != null) {
            this.hac.refresh();
        }
        if (this.haf != null) {
            this.haf.refresh();
        }
    }

    public void byg() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.haq.nR();
        } else {
            this.haq.nS();
        }
    }

    public void uL(int i) {
        if (i == 1) {
            if (TbadkCoreApplication.getInst().getSkinType() != 1) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new am("c10647").aA("obj_type", "1").aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
            } else {
                return;
            }
        } else if (i == 0) {
            if (TbadkCoreApplication.getInst().getSkinType() != 0) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.log(new am("c10647").aA("obj_type", "0").aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
            } else {
                return;
            }
        }
        BitmapHelper.clearCashBitmap();
    }

    public void bxi() {
        this.gZV.recycle();
        this.gZW.recycle();
        this.gZX.recycle();
        this.gZY.recycle();
        this.haa.recycle();
        this.hab.recycle();
        this.hac.recycle();
        this.had.recycle();
        this.hae.recycle();
    }

    public void onChangeSkinType(int i) {
        fv(i);
        if (this.gZT != null) {
            this.gZQ.getLayoutMode().setNightMode(i == 1);
            this.gZQ.getLayoutMode().onModeChanged(this.gZT);
        }
    }

    public void fv(int i) {
        al.j(this.hah, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gZV.fv(i);
        this.gZQ.getLayoutMode().setNightMode(i == 1);
        this.gZQ.getLayoutMode().onModeChanged(this.hah);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        byf();
        this.haq.setBackgroundRes(al.dO(e.f.bg_switch_open), al.dO(e.f.bg_switch_close), al.dO(e.f.btn_handle));
        al.j(this.hai, e.d.cp_bg_line_d);
    }

    private void Ky() {
        View.OnClickListener clickListener = getClickListener();
        this.hah = (RelativeLayout) this.gZQ.findViewById(e.g.parent);
        this.hai = this.gZQ.findViewById(e.g.scroll);
        this.gZQ.findViewById(e.g.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.gZQ.findViewById(e.g.view_navigation_bar);
        this.haj = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.gZQ.getPageContext().getString(e.j.setup));
        this.mNavigationBar.showBottomLine();
        this.gZU = (TbSettingTextTipView) this.gZQ.findViewById(e.g.accountSafeSetting);
        this.gZV = (SettingTextImageView) this.gZQ.findViewById(e.g.personInfo);
        this.gZW = (TbSettingTextTipView) this.gZQ.findViewById(e.g.interest_label_setting);
        this.gZW.setTopLineVisibility(true);
        this.gZX = (TbSettingTextTipView) this.gZQ.findViewById(e.g.accountManager);
        this.gZX.setTopLineVisibility(true);
        this.gZY = (TbSettingTextTipView) this.gZQ.findViewById(e.g.browseSetting);
        this.gZY.setBottomLineVisibility(true);
        this.gZZ = (TbSettingTextTipView) this.gZQ.findViewById(e.g.adSetting);
        this.gZZ.setBottomLineVisibility(true);
        this.haa = (TbSettingTextTipView) this.gZQ.findViewById(e.g.messageSetting);
        this.haa.setBottomLineVisibility(true);
        this.gZY.setBottomLineVisibility(true);
        this.hab = (TbSettingTextTipView) this.gZQ.findViewById(e.g.secretSetting);
        this.hab.setBottomLineVisibility(true);
        this.hac = (SettingTextVersionView) this.gZQ.findViewById(e.g.versionInfo);
        this.had = (TbSettingTextTipView) this.gZQ.findViewById(e.g.feedBack);
        this.had.setTopLineVisibility(true);
        this.had.setBottomLineVisibility(true);
        this.hae = (TbSettingTextTipView) this.gZQ.findViewById(e.g.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.hae.setVisibility(8);
            this.hae.setBottomLineVisibility(false);
        } else {
            this.hae.setVisibility(0);
            this.hae.setBottomLineVisibility(true);
        }
        this.haf = (TbSettingTextNewDotView) this.gZQ.findViewById(e.g.systemhelpsetting);
        this.hag = (TextView) this.gZQ.findViewById(e.g.quit);
        this.hap = (RelativeLayout) this.gZQ.findViewById(e.g.eyeshield_mode);
        this.haq = (BdSwitchView) this.gZQ.findViewById(e.g.item_switch);
        l.b(this.gZQ.getPageContext().getPageActivity(), this.haq, 10, 10, 10, 10);
        this.hak = this.gZQ.findViewById(e.g.divide_view2);
        this.hal = this.gZQ.findViewById(e.g.divide_view1);
        this.ham = this.gZQ.findViewById(e.g.divide_view3);
        this.han = this.gZQ.findViewById(e.g.divide_view4);
        this.hao = this.gZQ.findViewById(e.g.divide_view5);
        byf();
        bye();
        this.gZV.bzf();
        fv(TbadkCoreApplication.getInst().getSkinType());
        this.hal.setVisibility(0);
        this.ham.setVisibility(0);
        this.han.setVisibility(0);
        this.hao.setVisibility(0);
        U(clickListener);
        if (!byh()) {
            this.gZY.setTip(this.gZQ.getResources().getString(e.j.browsing_settings_tip_no_night));
            this.hak.setVisibility(8);
            this.hap.setVisibility(8);
            return;
        }
        this.hak.setVisibility(0);
        this.hap.setVisibility(0);
    }

    private boolean byh() {
        return MessageManager.getInstance().runTask(2001281, Boolean.class) != null;
    }

    private void createDialog() {
        this.gZT = LayoutInflater.from(this.gZQ.getPageContext().getPageActivity()).inflate(e.h.quit_dialog, (ViewGroup) null);
        this.gZQ.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gZQ.getLayoutMode().onModeChanged(this.gZT);
        ((TextView) this.gZT.findViewById(e.g.id_close_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.Td();
                e.this.gZR.uG(11);
            }
        });
        ((TextView) this.gZT.findViewById(e.g.id_quit_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.Td();
                e.this.gZR.uG(12);
            }
        });
        this.gZS = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
        this.gZS.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.g.a(this.gZS, this.mContext.getPageActivity());
        if (this.gZS.getWindow() != null) {
            WindowManager.LayoutParams attributes = this.gZS.getWindow().getAttributes();
            attributes.dimAmount = 0.7f;
            this.gZS.getWindow().setAttributes(attributes);
            this.gZS.getWindow().setContentView(this.gZT);
        }
    }

    private void U(View.OnClickListener onClickListener) {
        this.gZU.setOnClickListener(onClickListener);
        this.haj.setOnClickListener(onClickListener);
        this.gZV.setOnClickListener(onClickListener);
        this.gZW.setOnClickListener(onClickListener);
        this.gZX.setOnClickListener(onClickListener);
        this.gZY.setOnClickListener(onClickListener);
        this.gZZ.setOnClickListener(onClickListener);
        this.haa.setOnClickListener(onClickListener);
        this.hab.setOnClickListener(onClickListener);
        this.hac.setOnClickListener(onClickListener);
        this.had.setOnClickListener(onClickListener);
        this.hae.setOnClickListener(onClickListener);
        this.haf.setOnClickListener(onClickListener);
        this.hag.setOnClickListener(onClickListener);
        this.haq.setOnSwitchStateChangeListener(this.gZQ);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.haj) {
                    e.this.gZR.uG(0);
                } else if (view == e.this.gZV) {
                    e.this.gZR.uG(1);
                } else if (view == e.this.gZW) {
                    e.this.gZR.uG(15);
                } else if (view == e.this.gZX) {
                    e.this.gZR.uG(2);
                } else if (view == e.this.gZY) {
                    e.this.gZR.uG(3);
                } else if (view == e.this.haa) {
                    e.this.gZR.uG(4);
                } else if (view == e.this.hab) {
                    e.this.gZR.uG(9);
                } else if (view == e.this.hac) {
                    e.this.gZR.uG(6);
                } else if (view == e.this.had) {
                    e.this.gZR.uG(7);
                } else if (view == e.this.hae) {
                    e.this.gZR.uG(8);
                } else if (view == e.this.haf) {
                    e.this.gZR.uG(5);
                } else if (view == e.this.hag) {
                    e.this.gZR.uG(10);
                } else if (view == e.this.gZU) {
                    e.this.gZR.uG(13);
                } else if (view == e.this.gZZ) {
                    e.this.gZR.uG(16);
                }
            }
        };
    }

    public void byi() {
        if (this.gZS == null) {
            createDialog();
        }
        com.baidu.adp.lib.g.g.a(this.gZS, this.gZQ.getPageContext());
    }

    public void Td() {
        if (this.gZS != null) {
            com.baidu.adp.lib.g.g.b(this.gZS, this.gZQ.getPageContext());
        }
    }

    public BdSwitchView byj() {
        return this.haq;
    }
}
