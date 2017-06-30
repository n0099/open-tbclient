package com.baidu.tieba.pb.pb.main;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.a.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dz implements d.a {
    final /* synthetic */ dy exY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dz(dy dyVar) {
        this.exY = dyVar;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean a(View view, MotionEvent motionEvent) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE, 2));
        return true;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean c(View view, MotionEvent motionEvent) {
        com.baidu.tieba.pb.a.d dVar;
        com.baidu.tieba.pb.a.d dVar2;
        com.baidu.tieba.pb.a.d dVar3;
        dVar = this.exY.aPs;
        if (dVar != null) {
            dVar2 = this.exY.aPs;
            dVar2.aS(view);
            dVar3 = this.exY.aPs;
            dVar3.onSingleTapConfirmed(motionEvent);
            return true;
        }
        return true;
    }
}
