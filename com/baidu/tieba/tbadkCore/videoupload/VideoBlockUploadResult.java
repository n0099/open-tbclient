package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.util.TbErrInfo;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class VideoBlockUploadResult extends OrmObject implements Serializable {
    public static final long serialVersionUID = 6275774976385764456L;
    public Error error;
    public String upload_id;
    public String video_url;

    public int getErrorCode() {
        Error error = this.error;
        if (error != null) {
            return error.errno;
        }
        return -3;
    }

    public String getErrorMessage() {
        Error error = this.error;
        if (error != null) {
            return error.usermsg;
        }
        return TbErrInfo.getErrMsg(-3);
    }

    public boolean isSuccess() {
        Error error = this.error;
        return error != null && error.errno == 0;
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
