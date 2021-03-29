package com.baidu.tieba.payment.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class PayResultData extends OrmObject implements Serializable {
    public static final long serialVersionUID = 955562840790302592L;
    public UnusualInfo describe;
    public String pubkey;
    public PayVcodeInfoData vcode;
    public int wrongtime;

    /* loaded from: classes3.dex */
    public static final class UnusualInfo extends OrmObject implements Serializable {
        public static final long serialVersionUID = 7762965384357134074L;
        public String url;
        public String word;

        public String getUrl() {
            return this.url;
        }

        public String getWord() {
            return this.word;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public void setWord(String str) {
            this.word = str;
        }
    }

    public UnusualInfo getDescribe() {
        return this.describe;
    }

    public String getPubkey() {
        return this.pubkey;
    }

    public PayVcodeInfoData getVcode() {
        return this.vcode;
    }

    public int getWrongtime() {
        return this.wrongtime;
    }

    public void setDescribe(UnusualInfo unusualInfo) {
        this.describe = unusualInfo;
    }

    public void setPubkey(String str) {
        this.pubkey = str;
    }

    public void setVcode(PayVcodeInfoData payVcodeInfoData) {
        this.vcode = payVcodeInfoData;
    }

    public void setWrongtime(int i) {
        this.wrongtime = i;
    }
}
