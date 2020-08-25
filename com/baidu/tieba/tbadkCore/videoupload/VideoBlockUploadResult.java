package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.util.TbErrInfo;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class VideoBlockUploadResult extends OrmObject implements Serializable {
    private static final long serialVersionUID = 6275774976385764456L;
    public Error error;
    public String upload_id;
    public String video_url;

    public boolean isSuccess() {
        return this.error != null && this.error.errno == 0;
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

    public void setErrorMessage(String str) {
        if (this.error == null) {
            this.error = new Error();
        }
        this.error.usermsg = str;
    }

    public void setErrorNo(int i) {
        if (this.error == null) {
            this.error = new Error();
        }
        this.error.errno = i;
    }
}
