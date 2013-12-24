package com.baidu.tieba.person;

import com.baidu.tieba.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        HeadImageView headImageView;
        headImageView = this.a.d;
        eVar.a(headImageView);
    }
}
