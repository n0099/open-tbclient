package com.baidu.tieba.person;

import android.content.Intent;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.a;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class i implements a.c {
    final /* synthetic */ h chZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.chZ = hVar;
    }

    @Override // com.baidu.tbadk.img.a.c
    public void a(String str, ImageUploadResult imageUploadResult) {
        EditHeadActivity editHeadActivity;
        EditHeadActivity editHeadActivity2;
        EditHeadActivity editHeadActivity3;
        EditHeadActivity editHeadActivity4;
        EditHeadActivity editHeadActivity5;
        editHeadActivity = this.chZ.this$0;
        editHeadActivity.closeLoadingDialog();
        editHeadActivity2 = this.chZ.this$0;
        Intent intent = editHeadActivity2.getIntent();
        if (imageUploadResult != null) {
            if (imageUploadResult.error_code != 0) {
                editHeadActivity5 = this.chZ.this$0;
                editHeadActivity5.showToast(i.C0057i.upload_pic_error, false);
            } else {
                PhotoUrlData photoUrlData = new PhotoUrlData();
                photoUrlData.setPicId(String.valueOf(imageUploadResult.picId));
                if (imageUploadResult.picInfo != null) {
                    if (imageUploadResult.picInfo.bigPic != null) {
                        photoUrlData.setBigurl(imageUploadResult.picInfo.bigPic.picUrl);
                    }
                    if (imageUploadResult.picInfo.smallPic != null) {
                        photoUrlData.setSmallurl(imageUploadResult.picInfo.smallPic.picUrl);
                    }
                    if (imageUploadResult.getUploadedPicInfo() != null && !StringUtils.isNull(imageUploadResult.getUploadedPicInfo().toPostString())) {
                        photoUrlData.setToServerPhotoInfo(imageUploadResult.getUploadedPicInfo().toPostString());
                    }
                }
                intent.putExtra(EditHeadActivity.PHOTO_RESOURCE, String.valueOf(imageUploadResult.picId));
                intent.putExtra(EditHeadActivity.PIC_INFO, photoUrlData);
            }
        }
        editHeadActivity3 = this.chZ.this$0;
        editHeadActivity3.setResult(-1, intent);
        editHeadActivity4 = this.chZ.this$0;
        editHeadActivity4.finish();
    }
}
