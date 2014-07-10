package com.baidu.tieba.person;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements View.OnClickListener {
    final /* synthetic */ aw a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(aw awVar) {
        this.a = awVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        String str;
        int i;
        BaseFragmentActivity baseFragmentActivity;
        Context context2;
        String str2;
        int i2;
        BaseFragmentActivity baseFragmentActivity2;
        Context context3;
        String str3;
        int i3;
        BaseFragmentActivity baseFragmentActivity3;
        if (view.getId() == com.baidu.tieba.v.relationcardlikerelativelayout) {
            context3 = this.a.a;
            str3 = this.a.e;
            i3 = this.a.f;
            CustomMessage customMessage = new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.ay(context3, str3, i3, 1));
            baseFragmentActivity3 = this.a.c;
            baseFragmentActivity3.a(customMessage);
        } else if (view.getId() == com.baidu.tieba.v.relationcardfriendrelativelayout) {
            context2 = this.a.a;
            str2 = this.a.e;
            i2 = this.a.f;
            CustomMessage customMessage2 = new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.az(context2, str2, i2, 1));
            baseFragmentActivity2 = this.a.c;
            baseFragmentActivity2.a(customMessage2);
        } else if (view.getId() == com.baidu.tieba.v.relationcardgrouprelativelayout) {
            context = this.a.a;
            str = this.a.e;
            i = this.a.f;
            CustomMessage customMessage3 = new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.ba(context, str, i, 1));
            baseFragmentActivity = this.a.c;
            baseFragmentActivity.a(customMessage3);
        }
    }
}
