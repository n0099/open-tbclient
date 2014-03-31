package com.baidu.tieba.more;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
public class BrowseSettingActivity extends com.baidu.tbadk.a implements com.baidu.adp.widget.BdSwitchView.c {
    private j a = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new j(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.a.a(i);
    }

    public static void a(Context context) {
        context.startActivity(new Intent(context, BrowseSettingActivity.class));
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.a.a()) {
            this.a.g();
        } else if (view == this.a.d()) {
            this.a.h();
        } else {
            j jVar = this.a;
            if (view == null) {
                this.a.i();
            } else if (view == this.a.e()) {
                this.a.j();
            } else if (view == this.a.f()) {
                this.a.k();
            }
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public final void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.a.b(1);
        } else {
            this.a.b(0);
        }
    }
}
