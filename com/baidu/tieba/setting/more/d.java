package com.baidu.tieba.setting.more;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class d extends com.baidu.adp.base.c<MoreActivity> {
    private TbSettingTextTipView gjA;
    private SettingTextImageView gjB;
    private TbSettingTextTipView gjC;
    private TbSettingTextTipView gjD;
    private TbSettingTextTipView gjE;
    private MsgSettingItemView gjF;
    private TbSettingTextTipView gjG;
    private TbSettingTextTipView gjH;
    private SettingTextVersionView gjI;
    private TbSettingTextTipView gjJ;
    private TbSettingTextTipView gjK;
    private TbSettingTextNewDotView gjL;
    private TextView gjM;
    private RelativeLayout gjN;
    private View gjO;
    private MoreActivity gjw;
    private c gjx;
    private AlertDialog gjy;
    private View gjz;
    private NavigationBar mNavigationBar;

    public d(MoreActivity moreActivity, c cVar) {
        super(moreActivity.getPageContext());
        this.gjw = moreActivity;
        this.gjx = cVar;
        this.gjw.setContentView(d.i.more_activity);
        BZ();
    }

    public void bme() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.gjB.setVisibility(8);
        } else {
            this.gjB.setVisibility(0);
        }
    }

    public void S(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.gjB != null) {
                this.gjB.bne();
                return;
            }
            return;
        }
        this.gjB.bnf();
        this.gjB.setIcon(str, z);
    }

    public void bmf() {
        if (this.gjI != null) {
            this.gjI.refresh();
        }
        if (this.gjL != null) {
            this.gjL.refresh();
        }
    }

    public void blg() {
        this.gjB.recycle();
        this.gjC.recycle();
        this.gjD.recycle();
        this.gjE.recycle();
        this.gjG.recycle();
        this.gjH.recycle();
        this.gjI.recycle();
        this.gjJ.recycle();
        this.gjK.recycle();
    }

    public void onChangeSkinType(int i) {
        eq(i);
        if (this.gjz != null) {
            this.gjw.getLayoutMode().setNightMode(i == 1);
            this.gjw.getLayoutMode().u(this.gjz);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MoreActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void eq(int i) {
        ak.j(this.gjN, d.C0126d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gjB.eq(i);
        this.gjw.getLayoutMode().setNightMode(i == 1);
        this.gjw.getLayoutMode().u(this.gjN);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gjF.d(this.gjw.getPageContext(), i);
        bmf();
    }

    private void BZ() {
        View.OnClickListener clickListener = getClickListener();
        this.gjN = (RelativeLayout) this.gjw.findViewById(d.g.parent);
        this.gjw.findViewById(d.g.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.gjw.findViewById(d.g.view_navigation_bar);
        this.gjO = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.gjw.getPageContext().getString(d.k.setup));
        this.mNavigationBar.showBottomLine();
        this.gjA = (TbSettingTextTipView) this.gjw.findViewById(d.g.accountSafeSetting);
        this.gjB = (SettingTextImageView) this.gjw.findViewById(d.g.personInfo);
        this.gjC = (TbSettingTextTipView) this.gjw.findViewById(d.g.interest_label_setting);
        this.gjC.setTopLineVisibility(true);
        this.gjD = (TbSettingTextTipView) this.gjw.findViewById(d.g.accountManager);
        this.gjD.setTopLineVisibility(true);
        this.gjE = (TbSettingTextTipView) this.gjw.findViewById(d.g.browseSetting);
        this.gjE.setBottomLineVisibility(true);
        this.gjG = (TbSettingTextTipView) this.gjw.findViewById(d.g.messageSetting);
        this.gjG.setBottomLineVisibility(true);
        this.gjE.setBottomLineVisibility(true);
        this.gjH = (TbSettingTextTipView) this.gjw.findViewById(d.g.secretSetting);
        this.gjH.setBottomLineVisibility(true);
        this.gjI = (SettingTextVersionView) this.gjw.findViewById(d.g.versionInfo);
        this.gjJ = (TbSettingTextTipView) this.gjw.findViewById(d.g.feedBack);
        this.gjJ.setTopLineVisibility(true);
        this.gjJ.setBottomLineVisibility(true);
        this.gjK = (TbSettingTextTipView) this.gjw.findViewById(d.g.recommend);
        this.gjF = (MsgSettingItemView) this.gjw.findViewById(d.g.memberAdSetting);
        bmg();
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.gjK.setVisibility(8);
            this.gjK.setBottomLineVisibility(false);
        } else {
            this.gjK.setVisibility(0);
            this.gjK.setBottomLineVisibility(true);
        }
        this.gjL = (TbSettingTextNewDotView) this.gjw.findViewById(d.g.systemhelpsetting);
        this.gjM = (TextView) this.gjw.findViewById(d.g.quit);
        bmf();
        bme();
        this.gjB.bne();
        eq(TbadkCoreApplication.getInst().getSkinType());
        R(clickListener);
        if (!blC()) {
            this.gjE.setTip(this.gjw.getResources().getString(d.k.browsing_settings_tip_no_night));
        }
    }

    private void bmg() {
        int i;
        int i2 = 0;
        this.gjF.setText(d.k.member_ad_setting_text);
        this.gjF.setTipImageResource(d.f.label_red_svip);
        this.gjF.setOnSwitchStateChangeListener(this.gjw);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.gjF.setVisibility(8);
        } else if (i2 == 0) {
            this.gjF.jN();
        } else {
            this.gjF.jM();
        }
    }

    public void bmh() {
        this.gjF.jN();
    }

    public void bmi() {
        this.gjF.jM();
    }

    private boolean blC() {
        return MessageManager.getInstance().runTask(2001281, Boolean.class) != null;
    }

    private void aZb() {
        this.gjz = LayoutInflater.from(this.gjw.getPageContext().getPageActivity()).inflate(d.i.quit_dialog, (ViewGroup) null);
        this.gjw.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gjw.getLayoutMode().u(this.gjz);
        ((TextView) this.gjz.findViewById(d.g.id_close_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.Vp();
                d.this.gjx.sr(11);
            }
        });
        ((TextView) this.gjz.findViewById(d.g.id_quit_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.Vp();
                d.this.gjx.sr(12);
            }
        });
        this.gjy = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
        this.gjy.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.g.a(this.gjy, this.mContext.getPageActivity());
        if (this.gjy.getWindow() != null) {
            WindowManager.LayoutParams attributes = this.gjy.getWindow().getAttributes();
            attributes.dimAmount = 0.7f;
            this.gjy.getWindow().setAttributes(attributes);
            this.gjy.getWindow().setContentView(this.gjz);
        }
    }

    private void R(View.OnClickListener onClickListener) {
        this.gjA.setOnClickListener(onClickListener);
        this.gjO.setOnClickListener(onClickListener);
        this.gjB.setOnClickListener(onClickListener);
        this.gjC.setOnClickListener(onClickListener);
        this.gjD.setOnClickListener(onClickListener);
        this.gjE.setOnClickListener(onClickListener);
        this.gjG.setOnClickListener(onClickListener);
        this.gjH.setOnClickListener(onClickListener);
        this.gjI.setOnClickListener(onClickListener);
        this.gjJ.setOnClickListener(onClickListener);
        this.gjK.setOnClickListener(onClickListener);
        this.gjL.setOnClickListener(onClickListener);
        this.gjM.setOnClickListener(onClickListener);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2 == d.this.gjO) {
                    d.this.gjx.sr(0);
                } else if (view2 == d.this.gjB) {
                    d.this.gjx.sr(1);
                } else if (view2 == d.this.gjC) {
                    d.this.gjx.sr(15);
                } else if (view2 == d.this.gjD) {
                    d.this.gjx.sr(2);
                } else if (view2 == d.this.gjE) {
                    d.this.gjx.sr(3);
                } else if (view2 == d.this.gjG) {
                    d.this.gjx.sr(4);
                } else if (view2 == d.this.gjH) {
                    d.this.gjx.sr(9);
                } else if (view2 == d.this.gjI) {
                    d.this.gjx.sr(6);
                } else if (view2 == d.this.gjJ) {
                    d.this.gjx.sr(7);
                } else if (view2 == d.this.gjK) {
                    d.this.gjx.sr(8);
                } else if (view2 == d.this.gjL) {
                    d.this.gjx.sr(5);
                } else if (view2 == d.this.gjM) {
                    d.this.gjx.sr(10);
                } else if (view2 == d.this.gjA) {
                    d.this.gjx.sr(13);
                }
            }
        };
    }

    public void bmj() {
        if (this.gjy == null) {
            aZb();
        }
        com.baidu.adp.lib.g.g.a(this.gjy, this.gjw.getPageContext());
    }

    public void Vp() {
        if (this.gjy != null) {
            com.baidu.adp.lib.g.g.b(this.gjy, this.gjw.getPageContext());
        }
    }
}
