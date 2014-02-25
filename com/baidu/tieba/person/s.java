package com.baidu.tieba.person;

import android.content.Intent;
import com.baidu.tieba.im.data.PhotoUrlData;
import com.baidu.tieba.img.ImageUploadResult;
/* loaded from: classes.dex */
class s implements com.baidu.tieba.img.d {
    final /* synthetic */ r a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.a = rVar;
    }

    @Override // com.baidu.tieba.img.d
    public void a(String str, ImageUploadResult imageUploadResult) {
        EditHeadActivity editHeadActivity;
        EditHeadActivity editHeadActivity2;
        EditHeadActivity editHeadActivity3;
        EditHeadActivity editHeadActivity4;
        editHeadActivity = this.a.a;
        editHeadActivity.closeLoadingDialog();
        editHeadActivity2 = this.a.a;
        Intent intent = editHeadActivity2.getIntent();
        if (imageUploadResult != null) {
            PhotoUrlData photoUrlData = new PhotoUrlData();
            photoUrlData.setPicId(String.valueOf(imageUploadResult.picId));
            if (imageUploadResult.picInfo != null) {
                if (imageUploadResult.picInfo.bigPic != null) {
                    photoUrlData.setBigurl(imageUploadResult.picInfo.bigPic.picUrl);
                }
                if (imageUploadResult.picInfo.smallPic != null) {
                    photoUrlData.setSmallurl(imageUploadResult.picInfo.smallPic.picUrl);
                }
            }
            intent.putExtra(EditHeadActivity.a, String.valueOf(imageUploadResult.picId));
            intent.putExtra(EditHeadActivity.b, photoUrlData);
        }
        editHeadActivity3 = this.a.a;
        editHeadActivity3.setResult(-1, intent);
        editHeadActivity4 = this.a.a;
        editHeadActivity4.finish();
    }
}
