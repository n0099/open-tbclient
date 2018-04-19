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
    private MsgSettingItemView giC;
    private TbSettingTextTipView giD;
    private TbSettingTextTipView giE;
    private SettingTextVersionView giF;
    private TbSettingTextTipView giG;
    private TbSettingTextTipView giH;
    private TbSettingTextNewDotView giI;
    private TextView giJ;
    private RelativeLayout giK;
    private View giL;
    private MoreActivity git;
    private c giu;
    private AlertDialog giv;
    private View giw;
    private TbSettingTextTipView gix;
    private SettingTextImageView giy;
    private TbSettingTextTipView giz;
    private NavigationBar mNavigationBar;

    public d(MoreActivity moreActivity, c cVar) {
        super(moreActivity.getPageContext());
        this.git = moreActivity;
        this.giu = cVar;
        this.git.setContentView(d.i.more_activity);
        Cb();
    }

    public void bmf() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.giy.setVisibility(8);
        } else {
            this.giy.setVisibility(0);
        }
    }

    public void S(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.giy != null) {
                this.giy.bnf();
                return;
            }
            return;
        }
        this.giy.bng();
        this.giy.setIcon(str, z);
    }

    public void bmg() {
        if (this.giF != null) {
            this.giF.refresh();
        }
        if (this.giI != null) {
            this.giI.refresh();
        }
    }

    public void blh() {
        this.giy.recycle();
        this.giz.recycle();
        this.giA.recycle();
        this.giB.recycle();
        this.giD.recycle();
        this.giE.recycle();
        this.giF.recycle();
        this.giG.recycle();
        this.giH.recycle();
    }

    public void onChangeSkinType(int i) {
        ep(i);
        if (this.giw != null) {
            this.git.getLayoutMode().setNightMode(i == 1);
            this.git.getLayoutMode().u(this.giw);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MoreActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void ep(int i) {
        ak.j(this.giK, d.C0126d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.giy.ep(i);
        this.git.getLayoutMode().setNightMode(i == 1);
        this.git.getLayoutMode().u(this.giK);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.giC.d(this.git.getPageContext(), i);
        bmg();
    }

    private void Cb() {
        View.OnClickListener clickListener = getClickListener();
        this.giK = (RelativeLayout) this.git.findViewById(d.g.parent);
        this.git.findViewById(d.g.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.git.findViewById(d.g.view_navigation_bar);
        this.giL = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.git.getPageContext().getString(d.k.setup));
        this.mNavigationBar.showBottomLine();
        this.gix = (TbSettingTextTipView) this.git.findViewById(d.g.accountSafeSetting);
        this.giy = (SettingTextImageView) this.git.findViewById(d.g.personInfo);
        this.giz = (TbSettingTextTipView) this.git.findViewById(d.g.interest_label_setting);
        this.giz.setTopLineVisibility(true);
        this.giA = (TbSettingTextTipView) this.git.findViewById(d.g.accountManager);
        this.giA.setTopLineVisibility(true);
        this.giB = (TbSettingTextTipView) this.git.findViewById(d.g.browseSetting);
        this.giB.setBottomLineVisibility(true);
        this.giD = (TbSettingTextTipView) this.git.findViewById(d.g.messageSetting);
        this.giD.setBottomLineVisibility(true);
        this.giB.setBottomLineVisibility(true);
        this.giE = (TbSettingTextTipView) this.git.findViewById(d.g.secretSetting);
        this.giE.setBottomLineVisibility(true);
        this.giF = (SettingTextVersionView) this.git.findViewById(d.g.versionInfo);
        this.giG = (TbSettingTextTipView) this.git.findViewById(d.g.feedBack);
        this.giG.setTopLineVisibility(true);
        this.giG.setBottomLineVisibility(true);
        this.giH = (TbSettingTextTipView) this.git.findViewById(d.g.recommend);
        this.giC = (MsgSettingItemView) this.git.findViewById(d.g.memberAdSetting);
        bmh();
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.giH.setVisibility(8);
            this.giH.setBottomLineVisibility(false);
        } else {
            this.giH.setVisibility(0);
            this.giH.setBottomLineVisibility(true);
        }
        this.giI = (TbSettingTextNewDotView) this.git.findViewById(d.g.systemhelpsetting);
        this.giJ = (TextView) this.git.findViewById(d.g.quit);
        bmg();
        bmf();
        this.giy.bnf();
        ep(TbadkCoreApplication.getInst().getSkinType());
        R(clickListener);
        if (!blD()) {
            this.giB.setTip(this.git.getResources().getString(d.k.browsing_settings_tip_no_night));
        }
    }

    private void bmh() {
        int i;
        int i2 = 0;
        this.giC.setText(d.k.member_ad_setting_text);
        this.giC.setTipImageResource(d.f.label_red_svip);
        this.giC.setOnSwitchStateChangeListener(this.git);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            i = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i == 0) {
            this.giC.setVisibility(8);
        } else if (i2 == 0) {
            this.giC.jN();
        } else {
            this.giC.jM();
        }
    }

    public void bmi() {
        this.giC.jN();
    }

    public void bmj() {
        this.giC.jM();
    }

    private boolean blD() {
        return MessageManager.getInstance().runTask(2001281, Boolean.class) != null;
    }

    private void aZb() {
        this.giw = LayoutInflater.from(this.git.getPageContext().getPageActivity()).inflate(d.i.quit_dialog, (ViewGroup) null);
        this.git.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.git.getLayoutMode().u(this.giw);
        ((TextView) this.giw.findViewById(d.g.id_close_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.Vl();
                d.this.giu.ss(11);
            }
        });
        ((TextView) this.giw.findViewById(d.g.id_quit_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.Vl();
                d.this.giu.ss(12);
            }
        });
        this.giv = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
        this.giv.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.g.a(this.giv, this.mContext.getPageActivity());
        if (this.giv.getWindow() != null) {
            WindowManager.LayoutParams attributes = this.giv.getWindow().getAttributes();
            attributes.dimAmount = 0.7f;
            this.giv.getWindow().setAttributes(attributes);
            this.giv.getWindow().setContentView(this.giw);
        }
    }

    private void R(View.OnClickListener onClickListener) {
        this.gix.setOnClickListener(onClickListener);
        this.giL.setOnClickListener(onClickListener);
        this.giy.setOnClickListener(onClickListener);
        this.giz.setOnClickListener(onClickListener);
        this.giA.setOnClickListener(onClickListener);
        this.giB.setOnClickListener(onClickListener);
        this.giD.setOnClickListener(onClickListener);
        this.giE.setOnClickListener(onClickListener);
        this.giF.setOnClickListener(onClickListener);
        this.giG.setOnClickListener(onClickListener);
        this.giH.setOnClickListener(onClickListener);
        this.giI.setOnClickListener(onClickListener);
        this.giJ.setOnClickListener(onClickListener);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2 == d.this.giL) {
                    d.this.giu.ss(0);
                } else if (view2 == d.this.giy) {
                    d.this.giu.ss(1);
                } else if (view2 == d.this.giz) {
                    d.this.giu.ss(15);
                } else if (view2 == d.this.giA) {
                    d.this.giu.ss(2);
                } else if (view2 == d.this.giB) {
                    d.this.giu.ss(3);
                } else if (view2 == d.this.giD) {
                    d.this.giu.ss(4);
                } else if (view2 == d.this.giE) {
                    d.this.giu.ss(9);
                } else if (view2 == d.this.giF) {
                    d.this.giu.ss(6);
                } else if (view2 == d.this.giG) {
                    d.this.giu.ss(7);
                } else if (view2 == d.this.giH) {
                    d.this.giu.ss(8);
                } else if (view2 == d.this.giI) {
                    d.this.giu.ss(5);
                } else if (view2 == d.this.giJ) {
                    d.this.giu.ss(10);
                } else if (view2 == d.this.gix) {
                    d.this.giu.ss(13);
                }
            }
        };
    }

    public void bmk() {
        if (this.giv == null) {
            aZb();
        }
        com.baidu.adp.lib.g.g.a(this.giv, this.git.getPageContext());
    }

    public void Vl() {
        if (this.giv != null) {
            com.baidu.adp.lib.g.g.b(this.giv, this.git.getPageContext());
        }
    }
}
