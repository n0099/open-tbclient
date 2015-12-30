package com.baidu.tieba.personInfo;

import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.person.a;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements a.b {
    final /* synthetic */ d cWV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(d dVar) {
        this.cWV = dVar;
    }

    @Override // com.baidu.tieba.person.a.b
    public void a(int i, String str, ImageUploadResult imageUploadResult) {
        List list;
        if (i == 0 && imageUploadResult != null) {
            String str2 = null;
            if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                str2 = imageUploadResult.picInfo.bigPic.picUrl;
            }
            d dVar = this.cWV;
            list = this.cWV.cWs;
            dVar.g(str2, list);
        }
    }
}
