package com.baidu.tieba.person.post;

import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.person.post.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends CustomMessageListener {
    final /* synthetic */ v dEY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(v vVar, int i) {
        super(i);
        this.dEY = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        View view;
        View view2;
        boolean z;
        q qVar;
        v.a aVar;
        if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
            if (com.baidu.adp.lib.util.i.fq()) {
                z = this.dEY.avK;
                if (z) {
                    qVar = this.dEY.dEV;
                    qVar.hr(false);
                    aVar = this.dEY.dEX;
                    aVar.OJ();
                }
            }
            if (TbadkCoreApplication.isMyLive) {
                view2 = this.dEY.bel;
                BdListViewHelper.a(view2, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.fq());
                return;
            }
            view = this.dEY.bel;
            BdListViewHelper.a(view, BdListViewHelper.HeadType.HASTAB, true);
        }
    }
}
