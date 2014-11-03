package com.baidu.tieba.im.view;

import com.baidu.tbadk.coreExtra.util.TbCountDownTimer;
/* loaded from: classes.dex */
class i extends TbCountDownTimer {
    final /* synthetic */ NumCountDownView bjF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(NumCountDownView numCountDownView, long j, long j2) {
        super(j, j2);
        this.bjF = numCountDownView;
    }

    @Override // com.baidu.tbadk.coreExtra.util.TbCountDownTimer
    public void onTick(long j) {
        this.bjF.refreshText(j);
    }

    @Override // com.baidu.tbadk.coreExtra.util.TbCountDownTimer
    public void onFinish() {
        j jVar;
        j jVar2;
        jVar = this.bjF.mListerner;
        if (jVar != null) {
            jVar2 = this.bjF.mListerner;
            jVar2.onFinish();
        }
    }
}
