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
    private boolean aib = false;
    private ab dJq;

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.b
    public VideoFinishResult c(String str, File file) {
        int uA;
        boolean z = true;
        VideoFinishResult videoFinishResult = new VideoFinishResult();
        if (StringUtils.isNull(str) || file == null || !file.exists()) {
            videoFinishResult.setErrorNo(-20);
            videoFinishResult.setErrorMessage(TbErrInfo.getErrMsg(-20));
            videoFinishResult.setSuccess(false);
        } else {
            byte[] z2 = z(file);
            if (z2 == null || z2.length <= 0) {
                videoFinishResult.setErrorNo(-20);
                videoFinishResult.setErrorMessage(TbErrInfo.getErrMsg(-20));
                videoFinishResult.setSuccess(false);
            } else {
                this.dJq = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_SINGLE_UPLOAD_ADDRESS);
                this.dJq.d("video_chunk", z2);
                String str2 = null;
                if (this.aib) {
                    uA = this.dJq.uA();
                    str2 = this.dJq.getErrorString();
                } else {
                    String tY = this.dJq.tY();
                    if (this.dJq.uw().vq().qO()) {
                        videoFinishResult.parseJson(tY);
                        uA = 0;
                        z = false;
                    } else {
                        uA = this.dJq.uA();
                        str2 = this.dJq.getErrorString();
                    }
                }
                if (z) {
                    videoFinishResult.setErrorNo(uA);
                    videoFinishResult.setErrorMessage(str2);
                    videoFinishResult.setSuccess(false);
                }
            }
        }
        return videoFinishResult;
    }

    private byte[] z(File file) {
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
        this.aib = true;
        if (this.dJq != null) {
            this.dJq.gL();
        }
    }
}
