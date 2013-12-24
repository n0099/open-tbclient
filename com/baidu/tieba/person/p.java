package com.baidu.tieba.person;

import android.content.Intent;
import com.baidu.tieba.im.data.PhotoUrlData;
import com.baidu.tieba.im.data.UploadPicData2;
/* loaded from: classes.dex */
class p implements com.baidu.tieba.im.model.ah {
    final /* synthetic */ o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.a = oVar;
    }

    @Override // com.baidu.tieba.im.model.ah
    public void a(String str, UploadPicData2 uploadPicData2) {
        this.a.a.closeLoadingDialog();
        Intent intent = this.a.a.getIntent();
        if (uploadPicData2 != null) {
            PhotoUrlData photoUrlData = new PhotoUrlData();
            photoUrlData.setPicId(String.valueOf(uploadPicData2.picId));
            if (uploadPicData2.picInfo != null) {
                if (uploadPicData2.picInfo.bigPic != null) {
                    photoUrlData.setBigurl(uploadPicData2.picInfo.bigPic.picUrl);
                }
                if (uploadPicData2.picInfo.smallPic != null) {
                    photoUrlData.setSmallurl(uploadPicData2.picInfo.smallPic.picUrl);
                }
            }
            intent.putExtra(EditHeadActivity.a, String.valueOf(uploadPicData2.picId));
            intent.putExtra(EditHeadActivity.b, photoUrlData);
        }
        this.a.a.setResult(-1, intent);
        this.a.a.finish();
    }
}
