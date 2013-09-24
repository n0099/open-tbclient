package com.baidu.tieba.more;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ af f1478a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar) {
        this.f1478a = afVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.c cVar, String str, boolean z) {
        SettingTextImageView settingTextImageView;
        if (cVar == null) {
            return;
        }
        settingTextImageView = this.f1478a.f;
        settingTextImageView.setIcon(cVar);
    }
}
