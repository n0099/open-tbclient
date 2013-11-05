package com.baidu.tieba.person;

import android.content.Intent;
import com.baidu.tieba.im.data.PhotoUrlData;
import com.baidu.tieba.im.data.UploadPicData2;
/* loaded from: classes.dex */
class p implements com.baidu.tieba.im.model.u {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f2222a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.f2222a = oVar;
    }

    @Override // com.baidu.tieba.im.model.u
    public void a(String str, UploadPicData2 uploadPicData2) {
        this.f2222a.f2221a.j();
        Intent intent = this.f2222a.f2221a.getIntent();
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
            intent.putExtra(EditHeadActivity.f2157a, String.valueOf(uploadPicData2.picId));
            intent.putExtra(EditHeadActivity.b, photoUrlData);
        }
        this.f2222a.f2221a.setResult(-1, intent);
        this.f2222a.f2221a.finish();
    }
}
