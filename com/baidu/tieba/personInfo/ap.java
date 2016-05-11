package com.baidu.tieba.personInfo;

import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.person.a;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements a.b {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(f fVar) {
        this.this$0 = fVar;
    }

    @Override // com.baidu.tieba.person.a.b
    public void a(int i, String str, ImageUploadResult imageUploadResult) {
        List list;
        if (i == 0 && imageUploadResult != null) {
            String str2 = null;
            if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                str2 = imageUploadResult.picInfo.bigPic.picUrl;
            }
            f fVar = this.this$0;
            list = this.this$0.dFK;
            fVar.g(str2, list);
            this.this$0.hy(true);
        }
    }
}
