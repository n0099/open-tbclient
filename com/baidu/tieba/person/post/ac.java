package com.baidu.tieba.person.post;

import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.person.post.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends CustomMessageListener {
    final /* synthetic */ x eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(x xVar, int i) {
        super(i);
        this.eob = xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        View view;
        View view2;
        boolean z;
        q qVar;
        x.a aVar;
        if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
            if (com.baidu.adp.lib.util.i.fr()) {
                z = this.eob.awA;
                if (z) {
                    qVar = this.eob.enX;
                    qVar.im(false);
                    aVar = this.eob.enZ;
                    aVar.Un();
                }
            }
            if (TbadkCoreApplication.isMyLive) {
                view2 = this.eob.bAA;
                BdListViewHelper.a(view2, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.fr());
                return;
            }
            view = this.eob.bAA;
            BdListViewHelper.a(view, BdListViewHelper.HeadType.HASTAB, true);
        }
    }
}
