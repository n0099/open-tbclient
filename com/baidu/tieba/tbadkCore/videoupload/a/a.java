package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tieba.tbadkCore.videoupload.UploadResult;
import java.io.File;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class a {
    private ab Ty;
    private boolean agY = false;

    public void cancel() {
        if (this.Ty != null) {
            this.Ty.gL();
        }
        this.agY = true;
    }

    public com.baidu.tieba.tbadkCore.videoupload.c b(String str, com.baidu.tbadk.coreExtra.data.c cVar) {
        boolean z;
        int uQ;
        String errorString;
        com.baidu.tieba.tbadkCore.videoupload.c cVar2 = new com.baidu.tieba.tbadkCore.videoupload.c();
        long totalLength = cVar.getTotalLength();
        long j = totalLength % 512000 == 0 ? totalLength / 512000 : (totalLength / 512000) + 1;
        cVar2.mG((int) j);
        int xc = cVar.xc();
        if (xc < j) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(str), "r");
            if (randomAccessFile.skipBytes(512000 * xc) < 512000 * xc) {
                cVar2.setSuccess(false);
                randomAccessFile.close();
                return cVar2;
            }
            com.baidu.tieba.tbadkCore.videoupload.b.aEe();
            while (true) {
                int i = xc;
                if (i < j) {
                    int i2 = 512000;
                    if (i == j - 1) {
                        i2 = (int) (totalLength - (512000 * (j - 1)));
                    }
                    byte[] bArr = new byte[i2];
                    int read = randomAccessFile.read(bArr, 0, i2);
                    if (read != -1) {
                        this.Ty = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VIDEO_UPLOAD_ADDRESS);
                        this.Ty.d("video_chunk", bArr);
                        this.Ty.o("video_md5", cVar.xb());
                        this.Ty.o("chunk_length", String.valueOf(read));
                        this.Ty.o("total_length", String.valueOf(totalLength));
                        this.Ty.o("chunk_no", String.valueOf(i + 1));
                        this.Ty.o("total_num", String.valueOf(j));
                        if (this.agY) {
                            z = true;
                            uQ = this.Ty.uQ();
                            errorString = this.Ty.getErrorString();
                        } else {
                            String uo = this.Ty.uo();
                            if (this.Ty.uM().vG().rf()) {
                                i objectWithJsonStr = i.objectWithJsonStr(uo, UploadResult.class);
                                if (objectWithJsonStr instanceof UploadResult) {
                                    UploadResult uploadResult = (UploadResult) objectWithJsonStr;
                                    if (!uploadResult.isSuccess()) {
                                        z = true;
                                        uQ = uploadResult.getErrorCode();
                                        errorString = uploadResult.getErrorMessage();
                                    }
                                }
                                errorString = null;
                                uQ = 0;
                                z = false;
                            } else {
                                z = true;
                                uQ = this.Ty.uQ();
                                errorString = this.Ty.getErrorString();
                            }
                            if (!z) {
                                cVar.dj(i + 1);
                                com.baidu.tieba.tbadkCore.videoupload.b.c(cVar);
                            }
                        }
                        if (z) {
                            cVar2.setErrorNo(uQ);
                            cVar2.setErrorMessage(errorString);
                            cVar2.setSuccess(false);
                            randomAccessFile.close();
                            return cVar2;
                        }
                    }
                    xc = i + 1;
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
