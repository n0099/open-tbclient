package com.baidu.tieba.more;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ w a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.a = wVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        SettingTextImageView settingTextImageView;
        if (bVar == null) {
            return;
        }
        settingTextImageView = this.a.g;
        settingTextImageView.setIcon(bVar);
    }
}
