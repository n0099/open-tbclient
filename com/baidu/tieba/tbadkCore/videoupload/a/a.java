package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tieba.tbadkCore.videoupload.UploadResult;
import java.io.File;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a {
    private ab Ua;
    private boolean aib = false;

    public void cancel() {
        if (this.Ua != null) {
            this.Ua.gL();
        }
        this.aib = true;
    }

    public com.baidu.tieba.tbadkCore.videoupload.c b(String str, com.baidu.tbadk.coreExtra.data.c cVar) {
        boolean z;
        int uA;
        String errorString;
        com.baidu.tieba.tbadkCore.videoupload.c cVar2 = new com.baidu.tieba.tbadkCore.videoupload.c();
        long totalLength = cVar.getTotalLength();
        long j = totalLength % 512000 == 0 ? totalLength / 512000 : (totalLength / 512000) + 1;
        cVar2.ni((int) j);
        int wL = cVar.wL();
        if (wL < j) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(str), "r");
            if (randomAccessFile.skipBytes(512000 * wL) < 512000 * wL) {
                cVar2.setSuccess(false);
                randomAccessFile.close();
                return cVar2;
            }
            com.baidu.tieba.tbadkCore.videoupload.b.aGs();
            while (true) {
                int i = wL;
                if (i < j) {
                    int i2 = 512000;
                    if (i == j - 1) {
                        i2 = (int) (totalLength - (512000 * (j - 1)));
                    }
                    byte[] bArr = new byte[i2];
                    int read = randomAccessFile.read(bArr, 0, i2);
                    if (read != -1) {
                        this.Ua = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_UPLOAD_ADDRESS);
                        this.Ua.d("video_chunk", bArr);
                        this.Ua.o("video_md5", cVar.wK());
                        this.Ua.o("chunk_length", String.valueOf(read));
                        this.Ua.o("total_length", String.valueOf(totalLength));
                        this.Ua.o("chunk_no", String.valueOf(i + 1));
                        this.Ua.o("total_num", String.valueOf(j));
                        if (this.aib) {
                            z = true;
                            uA = this.Ua.uA();
                            errorString = this.Ua.getErrorString();
                        } else {
                            String tY = this.Ua.tY();
                            if (this.Ua.uw().vq().qO()) {
                                i objectWithJsonStr = i.objectWithJsonStr(tY, UploadResult.class);
                                if (objectWithJsonStr instanceof UploadResult) {
                                    UploadResult uploadResult = (UploadResult) objectWithJsonStr;
                                    if (!uploadResult.isSuccess()) {
                                        z = true;
                                        uA = uploadResult.getErrorCode();
                                        errorString = uploadResult.getErrorMessage();
                                    }
                                }
                                errorString = null;
                                uA = 0;
                                z = false;
                            } else {
                                z = true;
                                uA = this.Ua.uA();
                                errorString = this.Ua.getErrorString();
                            }
                            if (!z) {
                                cVar.dc(i + 1);
                                com.baidu.tieba.tbadkCore.videoupload.b.c(cVar);
                            }
                        }
                        if (z) {
                            cVar2.setErrorNo(uA);
                            cVar2.setErrorMessage(errorString);
                            cVar2.setSuccess(false);
                            randomAccessFile.close();
                            return cVar2;
                        }
                    }
                    wL = i + 1;
                } else {
                    randomAccessFile.close();
                    break;
                }
            }
        }
        cVar2.setSuccess(true);
        return cVar2;
    }
}
