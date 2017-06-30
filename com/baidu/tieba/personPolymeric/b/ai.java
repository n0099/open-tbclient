package com.baidu.tieba.personPolymeric.b;

import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.person.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements a.b {
    final /* synthetic */ z eVB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(z zVar) {
        this.eVB = zVar;
    }

    @Override // com.baidu.tieba.person.a.b
    public void a(int i, String str, ImageUploadResult imageUploadResult) {
        if (i == 0 && imageUploadResult != null) {
            String str2 = null;
            if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                str2 = imageUploadResult.picInfo.bigPic.picUrl;
            }
            aj.j(str2, this.eVB.aVl());
            this.eVB.jV(true);
        }
    }
}
