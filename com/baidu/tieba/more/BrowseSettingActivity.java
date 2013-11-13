package com.baidu.tieba.more;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
public class BrowseSettingActivity extends com.baidu.tieba.j implements com.baidu.adp.widget.BdSwitchView.c {

    /* renamed from: a  reason: collision with root package name */
    private w f1959a = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1959a = new w(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.f1959a.a(i);
    }

    public static void a(Context context) {
        context.startActivity(new Intent(context, BrowseSettingActivity.class));
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f1959a.a()) {
            this.f1959a.i();
        } else if (view == this.f1959a.e()) {
            this.f1959a.j();
        } else if (view == this.f1959a.f()) {
            this.f1959a.k();
        } else if (view == this.f1959a.g()) {
            this.f1959a.l();
        } else if (view == this.f1959a.h()) {
            this.f1959a.m();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.f1959a.b(1);
        } else {
            this.f1959a.b(0);
        }
    }
}
