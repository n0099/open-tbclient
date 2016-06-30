package com.baidu.tieba.person;

import android.content.Intent;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.a;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class k implements a.c {
    final /* synthetic */ j eds;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.eds = jVar;
    }

    @Override // com.baidu.tbadk.img.a.c
    public void a(String str, ImageUploadResult imageUploadResult) {
        EditHeadActivity editHeadActivity;
        EditHeadActivity editHeadActivity2;
        EditHeadActivity editHeadActivity3;
        EditHeadActivity editHeadActivity4;
        EditHeadActivity editHeadActivity5;
        String str2;
        EditHeadActivity editHeadActivity6;
        EditHeadActivity editHeadActivity7;
        editHeadActivity = this.eds.this$0;
        editHeadActivity.closeLoadingDialog();
        editHeadActivity2 = this.eds.this$0;
        Intent intent = editHeadActivity2.getIntent();
        if (imageUploadResult != null) {
            if (imageUploadResult.error_code != 0) {
                editHeadActivity7 = this.eds.this$0;
                editHeadActivity7.showToast(u.j.upload_pic_error, false);
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
                editHeadActivity5 = this.eds.this$0;
                str2 = editHeadActivity5.ecS;
                if (EditHeadActivityConfig.FROM_MISSON_SET_COVER.equals(str2)) {
                    editHeadActivity6 = this.eds.this$0;
                    editHeadActivity6.c(photoUrlData);
                }
                intent.putExtra(EditHeadActivity.PHOTO_RESOURCE, String.valueOf(imageUploadResult.picId));
                intent.putExtra(EditHeadActivity.PIC_INFO, photoUrlData);
            }
        }
        editHeadActivity3 = this.eds.this$0;
        editHeadActivity3.setResult(-1, intent);
        editHeadActivity4 = this.eds.this$0;
        editHeadActivity4.finish();
    }
}
