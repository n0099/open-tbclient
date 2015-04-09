package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextNewDotView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {
    final /* synthetic */ aa cbm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(aa aaVar) {
        this.cbm = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        SettingTextImageView settingTextImageView;
        TbSettingTextTipView tbSettingTextTipView;
        TbSettingTextTipView tbSettingTextTipView2;
        TbSettingTextTipView tbSettingTextTipView3;
        TbSettingTextTipView tbSettingTextTipView4;
        SettingTextVersionView settingTextVersionView;
        TbSettingTextTipView tbSettingTextTipView5;
        TbSettingTextTipView tbSettingTextTipView6;
        TbSettingTextNewDotView tbSettingTextNewDotView;
        TextView textView;
        q qVar;
        q qVar2;
        q qVar3;
        q qVar4;
        q qVar5;
        q qVar6;
        q qVar7;
        q qVar8;
        q qVar9;
        q qVar10;
        q qVar11;
        view2 = this.cbm.bNY;
        if (view == view2) {
            qVar11 = this.cbm.caY;
            qVar11.hW(0);
            return;
        }
        settingTextImageView = this.cbm.cba;
        if (view == settingTextImageView) {
            qVar10 = this.cbm.caY;
            qVar10.hW(1);
            return;
        }
        tbSettingTextTipView = this.cbm.cbb;
        if (view == tbSettingTextTipView) {
            qVar9 = this.cbm.caY;
            qVar9.hW(2);
            return;
        }
        tbSettingTextTipView2 = this.cbm.cbc;
        if (view == tbSettingTextTipView2) {
            qVar8 = this.cbm.caY;
            qVar8.hW(3);
            return;
        }
        tbSettingTextTipView3 = this.cbm.cbd;
        if (view == tbSettingTextTipView3) {
            qVar7 = this.cbm.caY;
            qVar7.hW(4);
            return;
        }
        tbSettingTextTipView4 = this.cbm.cbe;
        if (view == tbSettingTextTipView4) {
            qVar6 = this.cbm.caY;
            qVar6.hW(9);
            return;
        }
        settingTextVersionView = this.cbm.cbf;
        if (view == settingTextVersionView) {
            qVar5 = this.cbm.caY;
            qVar5.hW(6);
            return;
        }
        tbSettingTextTipView5 = this.cbm.cbg;
        if (view == tbSettingTextTipView5) {
            qVar4 = this.cbm.caY;
            qVar4.hW(7);
            return;
        }
        tbSettingTextTipView6 = this.cbm.cbh;
        if (view == tbSettingTextTipView6) {
            qVar3 = this.cbm.caY;
            qVar3.hW(8);
            return;
        }
        tbSettingTextNewDotView = this.cbm.cbj;
        if (view == tbSettingTextNewDotView) {
            qVar2 = this.cbm.caY;
            qVar2.hW(5);
            return;
        }
        textView = this.cbm.cbk;
        if (view == textView) {
            qVar = this.cbm.caY;
            qVar.hW(10);
        }
    }
}
