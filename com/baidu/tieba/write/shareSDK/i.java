package com.baidu.tieba.write.shareSDK;

import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* loaded from: classes.dex */
class i implements a.b {
    final /* synthetic */ WriteShareActivity fac;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(WriteShareActivity writeShareActivity) {
        this.fac = writeShareActivity;
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
            writeData = this.fac.evE;
            writeData.setShareSummaryImg("");
            writeData2 = this.fac.evE;
            writeData2.setShareSummaryImgHeight(0);
            writeData3 = this.fac.evE;
            writeData3.setShareSummaryImgWidth(0);
            return;
        }
        writeData4 = this.fac.evE;
        writeData4.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
        writeData5 = this.fac.evE;
        writeData5.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
        writeData6 = this.fac.evE;
        writeData6.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
    }
}
