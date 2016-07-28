package com.baidu.tieba.person.a;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ f epZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.epZ = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.person.data.d dVar;
        com.baidu.tieba.person.data.d dVar2;
        BaseFragmentActivity baseFragmentActivity;
        com.baidu.tieba.person.data.d dVar3;
        BaseFragmentActivity baseFragmentActivity2;
        dVar = this.epZ.epY;
        if (dVar != null) {
            dVar2 = this.epZ.epY;
            if (!StringUtils.isNull(dVar2.erR)) {
                if (!TbadkCoreApplication.m10getInst().appResponseToIntentClass(MyBookrackActivityConfig.class)) {
                    baseFragmentActivity2 = this.epZ.bgI;
                    com.baidu.adp.lib.util.k.showToast(baseFragmentActivity2.getPageContext().getPageActivity(), u.j.book_plugin_not_install_tip);
                    return;
                }
                baseFragmentActivity = this.epZ.bgI;
                Activity pageActivity = baseFragmentActivity.getPageContext().getPageActivity();
                dVar3 = this.epZ.epY;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyBookrackActivityConfig(pageActivity, 0, dVar3.erR)));
                TiebaStatic.log(new ay("c11390").s("obj_type", 2));
            }
        }
    }
}
