package com.baidu.tieba.more;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class x implements com.baidu.adp.widget.BdSwitchView.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ w f2016a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.f2016a = wVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        com.baidu.tieba.d.a.a().b(switchState == BdSwitchView.SwitchState.ON);
        this.f2016a.o();
    }
}
