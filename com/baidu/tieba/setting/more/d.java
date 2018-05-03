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
    private TbSettingTextTipView giA;
    private TbSettingTextTipView giB;
    private SettingTextVersionView giC;
    private TbSettingTextTipView giD;
    private TbSettingTextTipView giE;
    private TbSettingTextNewDotView giF;
    private TextView giG;
    private RelativeLayout giH;
    private View giI;
    private MoreActivity giq;
    private c gir;
    private AlertDialog gis;
    private View git;
    private TbSettingTextTipView giu;
    private SettingTextImageView giv;
    private TbSettingTextTipView giw;
    private TbSettingTextTipView gix;
    private TbSettingTextTipView giy;
    private MsgSettingItemView giz;
    private NavigationBar mNavigationBar;

    public d(MoreActivity moreActivity, c cVar) {
        super(moreActivity.getPageContext());
        this.giq = moreActivity;
        this.gir = cVar;
        this.giq.setContentView(d.i.more_activity);
        Cb();
    }

    public void bmf() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.giv.setVisibility(8);
        } else {
            this.giv.setVisibility(0);
        }
    }

    public void S(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.giv != null) {
                this.giv.bnf();
                return;
            }
            return;
        }
        this.giv.bng();
        this.giv.setIcon(str, z);
    }

    public void bmg() {
        if (this.giC != null) {
            this.giC.refresh();
        }
        if (this.giF != null) {
            this.giF.refresh();
        }
    }

    public void blh() {
        this.giv.recycle();
        this.giw.recycle();
        this.gix.recycle();
        this.giy.recycle();
        this.giA.recycle();
        this.giB.recycle();
        this.giC.recycle();
        this.giD.recycle();
        this.giE.recycle();
    }

    public void onChangeSkinType(int i) {
        ep(i);
        if (this.git != null) {
            this.giq.getLayoutMode().setNightMode(i == 1);
            this.giq.getLayoutMode().u(this.git);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MoreActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void ep(int i) {
        ak.j(this.giH, d.C0126d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.giv.ep(i);
        this.giq.getLayoutMode().setNightMode(i == 1);
        this.giq.getLayoutMode().u(this.giH);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.giz.d(this.giq.getPageContext(), i);
        bmg();
    }

    private void Cb() {
        View.OnClickListener clickListener = getClickListener();
        this.giH = (RelativeLayout) this.giq.findViewById(d.g.parent);
        this.giq.findViewById(d.g.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.giq.findViewById(d.g.view_navigation_bar);
        this.giI = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.giq.getPageContext().getString(d.k.setup));
        this.mNavigationBar.showBottomLine();
        this.giu = (TbSettingTextTipView) this.giq.findViewById(d.g.accountSafeSetting);
        this.giv = (SettingTextImageView) this.giq.findViewById(d.g.personInfo);
        this.giw = (TbSettingTextTipView) this.giq.findViewById(d.g.interest_label_setting);
        this.giw.setTopLineVisibility(true);
        this.gix = (TbSettingTextTipView) this.giq.findViewById(d.g.accountManager);
        this.gix.setTopLineVisibility(true);
        this.giy = (TbSettingTextTipView) this.giq.findViewById(d.g.browseSetting);
        this.giy.setBottomLineVisibility(true);
        this.giA = (TbSettingTextTipView) this.giq.findViewById(d.g.messageSetting);
        this.giA.setBottomLineVisibility(true);
        this.giy.setBottomLineVisibility(true);
        this.giB = (TbSettingTextTipView) this.giq.findViewById(d.g.secretSetting);
        this.giB.setBottomLineVisibility(true);
        this.giC = (SettingTextVersionView) this.giq.findViewById(d.g.versionInfo);
        this.giD = (TbSettingTextTipView) this.giq.findViewById(d.g.feedBack);
        this.giD.setTopLineVisibility(true);
        this.giD.setBottomLineVisibility(true);
        this.giE = (TbSettingTextTipView) this.giq.findViewById(d.g.recommend);
        this.giz = (MsgSettingItemView) this.giq.findViewById(d.g.memberAdSetting);
        bmh();
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.giE.setVisibility(8);
            this.giE.setBottomLineVisibility(false);
        } else {
            this.giE.setVisibility(0);
            this.giE.setBottomLineVisibility(true);
        }
        this.giF = (TbSettingTextNewDotView) this.giq.findViewById(d.g.systemhelpsetting);
        this.giG = (TextView) this.giq.findViewById(d.g.quit);
        bmg();
        bmf();
        this.giv.bnf();
        ep(TbadkCoreApplication.getInst().getSkinType());
        R(clickListener);
        if (!blD()) {
            this.giy.setTip(this.giq.getResources().getString(d.k.browsing_settings_tip_no_night));
        }
    }

    private void bmh() {
        int i;
        int i2 = 0;
        this.giz.setText(d.k.member_ad_setting_text);
        this.giz.setTipImageResource(d.f.label_red_svip);
        this.giz.setOnSwitchStateChangeListener(this.giq);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.giz.setVisibility(8);
        } else if (i2 == 0) {
            this.giz.jN();
        } else {
            this.giz.jM();
        }
    }

    public void bmi() {
        this.giz.jN();
    }

    public void bmj() {
        this.giz.jM();
    }

    private boolean blD() {
        return MessageManager.getInstance().runTask(2001281, Boolean.class) != null;
    }

    private void aZb() {
        this.git = LayoutInflater.from(this.giq.getPageContext().getPageActivity()).inflate(d.i.quit_dialog, (ViewGroup) null);
        this.giq.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.giq.getLayoutMode().u(this.git);
        ((TextView) this.git.findViewById(d.g.id_close_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.Vl();
                d.this.gir.ss(11);
            }
        });
        ((TextView) this.git.findViewById(d.g.id_quit_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.Vl();
                d.this.gir.ss(12);
            }
        });
        this.gis = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
        this.gis.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.g.a(this.gis, this.mContext.getPageActivity());
        if (this.gis.getWindow() != null) {
            WindowManager.LayoutParams attributes = this.gis.getWindow().getAttributes();
            attributes.dimAmount = 0.7f;
            this.gis.getWindow().setAttributes(attributes);
            this.gis.getWindow().setContentView(this.git);
        }
    }

    private void R(View.OnClickListener onClickListener) {
        this.giu.setOnClickListener(onClickListener);
        this.giI.setOnClickListener(onClickListener);
        this.giv.setOnClickListener(onClickListener);
        this.giw.setOnClickListener(onClickListener);
        this.gix.setOnClickListener(onClickListener);
        this.giy.setOnClickListener(onClickListener);
        this.giA.setOnClickListener(onClickListener);
        this.giB.setOnClickListener(onClickListener);
        this.giC.setOnClickListener(onClickListener);
        this.giD.setOnClickListener(onClickListener);
        this.giE.setOnClickListener(onClickListener);
        this.giF.setOnClickListener(onClickListener);
        this.giG.setOnClickListener(onClickListener);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2 == d.this.giI) {
                    d.this.gir.ss(0);
                } else if (view2 == d.this.giv) {
                    d.this.gir.ss(1);
                } else if (view2 == d.this.giw) {
                    d.this.gir.ss(15);
                } else if (view2 == d.this.gix) {
                    d.this.gir.ss(2);
                } else if (view2 == d.this.giy) {
                    d.this.gir.ss(3);
                } else if (view2 == d.this.giA) {
                    d.this.gir.ss(4);
                } else if (view2 == d.this.giB) {
                    d.this.gir.ss(9);
                } else if (view2 == d.this.giC) {
                    d.this.gir.ss(6);
                } else if (view2 == d.this.giD) {
                    d.this.gir.ss(7);
                } else if (view2 == d.this.giE) {
                    d.this.gir.ss(8);
                } else if (view2 == d.this.giF) {
                    d.this.gir.ss(5);
                } else if (view2 == d.this.giG) {
                    d.this.gir.ss(10);
                } else if (view2 == d.this.giu) {
                    d.this.gir.ss(13);
                }
            }
        };
    }

    public void bmk() {
        if (this.gis == null) {
            aZb();
        }
        com.baidu.adp.lib.g.g.a(this.gis, this.giq.getPageContext());
    }

    public void Vl() {
        if (this.gis != null) {
            com.baidu.adp.lib.g.g.b(this.gis, this.giq.getPageContext());
        }
    }
}
