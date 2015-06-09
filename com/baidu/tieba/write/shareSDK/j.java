package com.baidu.tieba.write.shareSDK;

import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageUploadResult;
/* loaded from: classes.dex */
class j implements com.baidu.tieba.tbadkCore.writeModel.c {
    final /* synthetic */ WriteShareActivity cAu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(WriteShareActivity writeShareActivity) {
        this.cAu = writeShareActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.c
    public void a(ImageUploadResult imageUploadResult, boolean z) {
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        WriteData writeData6;
        if (imageUploadResult == null || imageUploadResult.picInfo == null || imageUploadResult.picInfo.originPic == null) {
            writeData = this.cAu.cup;
            writeData.setShareSummaryImg("");
            writeData2 = this.cAu.cup;
            writeData2.setShareSummaryImgHeight(0);
            writeData3 = this.cAu.cup;
            writeData3.setShareSummaryImgWidth(0);
            return;
        }
        writeData4 = this.cAu.cup;
        writeData4.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
        writeData5 = this.cAu.cup;
        writeData5.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
        writeData6 = this.cAu.cup;
        writeData6.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
    }
}
