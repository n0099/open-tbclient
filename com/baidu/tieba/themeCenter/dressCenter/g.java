package com.baidu.tieba.themeCenter.dressCenter;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalBackdropGroupActivityConfig;
import com.baidu.tbadk.core.atomData.TopThemeListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.az;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements AdapterView.OnItemClickListener {
    final /* synthetic */ f dhU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.dhU = fVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: com.baidu.tieba.themeCenter.dressCenter.DressupCenterActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        c cVar;
        c cVar2;
        DressupCenterActivity dressupCenterActivity;
        DressupCenterActivity dressupCenterActivity2;
        DressupCenterActivity dressupCenterActivity3;
        cVar = this.dhU.dhT;
        j item = cVar.getItem(i);
        if (item != null) {
            com.baidu.tbadk.core.sharedPref.b.tu().putLong("dressup_center_red_tip_" + TbadkCoreApplication.getCurrentAccount() + "_" + item.getType(), System.currentTimeMillis() / 1000);
            cVar2 = this.dhU.dhT;
            cVar2.notifyDataSetChanged();
            if (!StringUtils.isNull(item.getType())) {
                String type = item.getType();
                if (type.equalsIgnoreCase("1")) {
                    TiebaStatic.log("c10263");
                    dressupCenterActivity3 = this.dhU.dhS;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopThemeListActivityConfig(dressupCenterActivity3.getActivity())));
                } else if (type.equalsIgnoreCase("2")) {
                    TiebaStatic.log("c10264");
                    dressupCenterActivity2 = this.dhU.dhS;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalBackdropGroupActivityConfig(dressupCenterActivity2.getActivity())));
                } else {
                    az uX = az.uX();
                    dressupCenterActivity = this.dhU.dhS;
                    uX.b(dressupCenterActivity.getPageContext(), new String[]{type});
                }
            }
        }
    }
}
