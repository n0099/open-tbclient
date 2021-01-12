package com.baidu.tieba.payment.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
/* loaded from: classes8.dex */
public class PayVcodeInfoData extends OrmObject implements Serializable {
    private static final long serialVersionUID = -8287150497543582408L;
    private String captcha_code_type;
    private String captcha_vcode_str;
    private String str_reason;
    private String vcode_pic_url;

    public String getCaptcha_vcode_str() {
        return this.captcha_vcode_str;
    }

    public void setCaptcha_vcode_str(String str) {
        this.captcha_vcode_str = str;
    }

    public String getStr_reason() {
        return this.str_reason;
    }

    public void setStr_reason(String str) {
        this.str_reason = str;
    }

    public String getCaptcha_code_type() {
        return this.captcha_code_type;
    }

    public void setCaptcha_code_type(String str) {
        this.captcha_code_type = str;
    }

    public String getVcode_pic_url() {
        return this.vcode_pic_url;
    }

    public void setVcode_pic_url(String str) {
        this.vcode_pic_url = str;
    }
}
