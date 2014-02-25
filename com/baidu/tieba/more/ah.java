package com.baidu.tieba.more;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ ag a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar) {
        this.a = agVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        SettingTextImageView settingTextImageView;
        if (bVar == null) {
            return;
        }
        settingTextImageView = this.a.f;
        settingTextImageView.setIcon(bVar);
    }
}
