package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/* loaded from: classes.dex */
public class d implements b {
    private boolean agY = false;
    private ab dBN;

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult c(String str, File file) {
        int uQ;
        boolean z = true;
        VideoFinishResult videoFinishResult = new VideoFinishResult();
        if (StringUtils.isNull(str) || file == null || !file.exists()) {
            videoFinishResult.setErrorNo(-20);
            videoFinishResult.setErrorMessage(TbErrInfo.getErrMsg(-20));
            videoFinishResult.setSuccess(false);
        } else {
            byte[] A = A(file);
            if (A == null || A.length <= 0) {
                videoFinishResult.setErrorNo(-20);
                videoFinishResult.setErrorMessage(TbErrInfo.getErrMsg(-20));
                videoFinishResult.setSuccess(false);
            } else {
                this.dBN = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_SINGLE_UPLOAD_ADDRESS);
                this.dBN.d("video_chunk", A);
                String str2 = null;
                if (this.agY) {
                    uQ = this.dBN.uQ();
                    str2 = this.dBN.getErrorString();
                } else {
                    String uo = this.dBN.uo();
                    if (this.dBN.uM().vG().rf()) {
                        videoFinishResult.parseJson(uo);
                        uQ = 0;
                        z = false;
                    } else {
                        uQ = this.dBN.uQ();
                        str2 = this.dBN.getErrorString();
                    }
                }
                if (z) {
                    videoFinishResult.setErrorNo(uQ);
                    videoFinishResult.setErrorMessage(str2);
                    videoFinishResult.setSuccess(false);
                }
            }
        }
        return videoFinishResult;
    }

    private byte[] A(File file) {
        byte[] bArr = null;
        if (file != null) {
            try {
                if (file.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                    byte[] bArr2 = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr2, 0, 1024);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    bArr = byteArrayOutputStream.toByteArray();
                    return bArr;
                }
                return null;
            } catch (IOException e) {
                return bArr;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public void cancel() {
        this.agY = true;
        if (this.dBN != null) {
            this.dBN.gL();
        }
    }
}
