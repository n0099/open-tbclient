package com.baidu.tieba.payment.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class PayVcodeInfoData extends OrmObject implements Serializable {
    public static final long serialVersionUID = -8287150497543582408L;
    public String captcha_code_type;
    public String captcha_vcode_str;
    public String str_reason;
    public String vcode_pic_url;

    public String getCaptcha_code_type() {
        return this.captcha_code_type;
    }

    public String getCaptcha_vcode_str() {
        return this.captcha_vcode_str;
    }

    public String getStr_reason() {
        return this.str_reason;
    }

    public String getVcode_pic_url() {
        return this.vcode_pic_url;
    }

    public void setCaptcha_code_type(String str) {
        this.captcha_code_type = str;
    }

    public void setCaptcha_vcode_str(String str) {
        this.captcha_vcode_str = str;
    }

    public void setStr_reason(String str) {
        this.str_reason = str;
    }

    public void setVcode_pic_url(String str) {
        this.vcode_pic_url = str;
    }
}
