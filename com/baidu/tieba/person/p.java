package com.baidu.tieba.person;

import android.content.Intent;
import com.baidu.tieba.im.data.PhotoUrlData;
import com.baidu.tieba.im.data.UploadPicData2;
/* loaded from: classes.dex */
class p implements com.baidu.tieba.im.model.w {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f2361a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.f2361a = oVar;
    }

    @Override // com.baidu.tieba.im.model.w
    public void a(String str, UploadPicData2 uploadPicData2) {
        this.f2361a.f2360a.closeLoadingDialog();
        Intent intent = this.f2361a.f2360a.getIntent();
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
            intent.putExtra(EditHeadActivity.f2292a, String.valueOf(uploadPicData2.picId));
            intent.putExtra(EditHeadActivity.b, photoUrlData);
        }
        this.f2361a.f2360a.setResult(-1, intent);
        this.f2361a.f2360a.finish();
    }
}
