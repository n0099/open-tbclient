package com.baidu.tieba.write.shareSDK;

import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* loaded from: classes.dex */
class i implements a.b {
    final /* synthetic */ WriteShareActivity dog;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(WriteShareActivity writeShareActivity) {
        this.dog = writeShareActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.b
    public void a(ImageUploadResult imageUploadResult, boolean z) {
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        WriteData writeData6;
        if (imageUploadResult == null || imageUploadResult.picInfo == null || imageUploadResult.picInfo.originPic == null) {
            writeData = this.dog.ddI;
            writeData.setShareSummaryImg("");
            writeData2 = this.dog.ddI;
            writeData2.setShareSummaryImgHeight(0);
            writeData3 = this.dog.ddI;
            writeData3.setShareSummaryImgWidth(0);
            return;
        }
        writeData4 = this.dog.ddI;
        writeData4.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
        writeData5 = this.dog.ddI;
        writeData5.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
        writeData6 = this.dog.ddI;
        writeData6.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
    }
}
