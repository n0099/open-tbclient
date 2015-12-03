package com.baidu.tieba.themeCenter.dressCenter;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalBackdropGroupActivityConfig;
import com.baidu.tbadk.core.atomData.TopThemeListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements AdapterView.OnItemClickListener {
    final /* synthetic */ f dGd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.dGd = fVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v15, resolved type: com.baidu.tieba.themeCenter.dressCenter.DressupCenterActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        c cVar;
        c cVar2;
        DressupCenterActivity dressupCenterActivity;
        DressupCenterActivity dressupCenterActivity2;
        DressupCenterActivity dressupCenterActivity3;
        DressupCenterActivity dressupCenterActivity4;
        cVar = this.dGd.dGc;
        j item = cVar.getItem(i);
        if (item != null) {
            com.baidu.tbadk.core.sharedPref.b.tZ().putLong("dressup_center_red_tip_" + TbadkCoreApplication.getCurrentAccount() + "_" + item.getType(), System.currentTimeMillis() / 1000);
            cVar2 = this.dGd.dGc;
            cVar2.notifyDataSetChanged();
            if (!StringUtils.isNull(item.getType())) {
                String type = item.getType();
                switch (com.baidu.adp.lib.h.b.g(type, 0)) {
                    case 1:
                        TiebaStatic.log("c10263");
                        dressupCenterActivity3 = this.dGd.dGa;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopThemeListActivityConfig(dressupCenterActivity3.getActivity())));
                        return;
                    case 2:
                        TiebaStatic.log("c10264");
                        dressupCenterActivity2 = this.dGd.dGa;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalBackdropGroupActivityConfig(dressupCenterActivity2.getActivity())));
                        return;
                    case 3:
                        dressupCenterActivity = this.dGd.dGa;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleGroupActivityConfig(dressupCenterActivity.getActivity())));
                        return;
                    default:
                        bf vD = bf.vD();
                        dressupCenterActivity4 = this.dGd.dGa;
                        vD.b(dressupCenterActivity4.getPageContext(), new String[]{type});
                        return;
                }
            }
        }
    }
}
