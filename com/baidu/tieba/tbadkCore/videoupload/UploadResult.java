package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.tbadk.core.util.TbErrInfo;
import java.io.Serializable;
/* loaded from: classes.dex */
public class UploadResult extends i implements Serializable {
    private static final long serialVersionUID = -3626660571829304660L;
    public int chunk_length;
    public int chunk_no;
    public Error error;
    public int total_length;
    public int total_num;
    public long upload_time;
    public String video_md5;

    public boolean isSuccess() {
        return this.error == null || this.error.errno == 0;
    }

    public String getErrorMessage() {
        return this.error != null ? this.error.usermsg : TbErrInfo.getErrMsg(-3);
    }

    public int getErrorCode() {
        if (this.error != null) {
            return this.error.errno;
        }
        return -3;
    }
}
