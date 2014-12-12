package com.baidu.tieba.more;

import android.app.AlertDialog;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextNewDotView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.g<MoreActivity> {
    private MoreActivity buC;
    private q buD;
    private AlertDialog buE;
    private SettingTextImageView buF;
    private TbSettingTextTipView buG;
    private TbSettingTextTipView buH;
    private TbSettingTextTipView buI;
    private TbSettingTextTipView buJ;
    private SettingTextVersionView buK;
    private TbSettingTextTipView buL;
    private TbSettingTextTipView buM;
    private View buN;
    private TbSettingTextNewDotView buO;
    private TbSettingTextTipView buP;
    private RelativeLayout buQ;
    private View buR;
    private NavigationBar mNavigationBar;

    public af(MoreActivity moreActivity, q qVar) {
        super(moreActivity.getPageContext());
        this.buC = moreActivity;
        this.buD = qVar;
        this.buC.setContentView(com.baidu.tieba.x.more_activity);
        tD();
    }

    public void Vn() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.buF.setVisibility(8);
        } else {
            this.buF.setVisibility(0);
        }
    }

    public void u(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.buF != null) {
                this.buF.VL();
                return;
            }
            return;
        }
        this.buF.VM();
        this.buF.v(str, z);
    }

    public void refreshNewVersion() {
        if (this.buK != null) {
            this.buK.refresh();
        }
        if (this.buO != null) {
            this.buO.refresh();
        }
    }

    public void Rq() {
        this.buF.recycle();
        this.buG.recycle();
        this.buH.recycle();
        this.buI.recycle();
        this.buJ.recycle();
        this.buK.recycle();
        this.buL.recycle();
        this.buM.recycle();
        this.buP.recycle();
    }

    public void onChangeSkinType(int i) {
        cT(i);
    }

    public void cT(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.buF.cT(i);
        this.buC.getLayoutMode().ab(i == 1);
        this.buC.getLayoutMode().h(this.buQ);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        refreshNewVersion();
    }

    private void tD() {
        View.OnClickListener Vo = Vo();
        this.buQ = (RelativeLayout) this.buC.findViewById(com.baidu.tieba.w.parent);
        this.mNavigationBar = (NavigationBar) this.buC.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.buR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.buC.getPageContext().getString(com.baidu.tieba.z.setup));
        this.buF = (SettingTextImageView) this.buC.findViewById(com.baidu.tieba.w.personInfo);
        this.buG = (TbSettingTextTipView) this.buC.findViewById(com.baidu.tieba.w.accountManager);
        this.buH = (TbSettingTextTipView) this.buC.findViewById(com.baidu.tieba.w.browseSetting);
        this.buI = (TbSettingTextTipView) this.buC.findViewById(com.baidu.tieba.w.messageSetting);
        this.buJ = (TbSettingTextTipView) this.buC.findViewById(com.baidu.tieba.w.secretSetting);
        this.buK = (SettingTextVersionView) this.buC.findViewById(com.baidu.tieba.w.versionInfo);
        this.buL = (TbSettingTextTipView) this.buC.findViewById(com.baidu.tieba.w.feedBack);
        this.buM = (TbSettingTextTipView) this.buC.findViewById(com.baidu.tieba.w.recommend);
        this.buN = this.buC.findViewById(com.baidu.tieba.w.line_recommend_layout);
        if (!TbadkCoreApplication.m255getInst().getIsAppOn()) {
            this.buM.setVisibility(8);
            this.buN.setVisibility(8);
        } else {
            this.buM.setVisibility(0);
            this.buN.setVisibility(0);
        }
        this.buO = (TbSettingTextNewDotView) this.buC.findViewById(com.baidu.tieba.w.systemhelpsetting);
        this.buP = (TbSettingTextTipView) this.buC.findViewById(com.baidu.tieba.w.quit);
        refreshNewVersion();
        Vn();
        this.buF.VL();
        cT(TbadkCoreApplication.m255getInst().getSkinType());
        w(Vo);
        Oh();
    }

    private void Oh() {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.buC.getPageContext().getPageActivity(), com.baidu.tieba.x.quit_dialog, null);
        ((LinearLayout) inflate.findViewById(com.baidu.tieba.w.id_close_ll)).setOnClickListener(new ag(this));
        ((LinearLayout) inflate.findViewById(com.baidu.tieba.w.id_quit_ll)).setOnClickListener(new ah(this));
        this.buE = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
        this.buE.setView(inflate, 0, 0, 0, 0);
    }

    private void w(View.OnClickListener onClickListener) {
        this.buR.setOnClickListener(onClickListener);
        this.buF.setOnClickListener(onClickListener);
        this.buG.setOnClickListener(onClickListener);
        this.buH.setOnClickListener(onClickListener);
        this.buI.setOnClickListener(onClickListener);
        this.buJ.setOnClickListener(onClickListener);
        this.buK.setOnClickListener(onClickListener);
        this.buL.setOnClickListener(onClickListener);
        this.buM.setOnClickListener(onClickListener);
        this.buO.setOnClickListener(onClickListener);
        this.buP.setOnClickListener(onClickListener);
    }

    private View.OnClickListener Vo() {
        return new ai(this);
    }

    public void Vp() {
        if (this.buE != null) {
            com.baidu.adp.lib.g.k.a(this.buE, this.buC.getPageContext());
        }
    }
}
