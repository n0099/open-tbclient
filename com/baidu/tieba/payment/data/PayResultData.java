package com.baidu.tieba.payment.data;

import com.baidu.adp.lib.a.b.a.a.i;
import java.io.Serializable;
/* loaded from: classes.dex */
public class PayResultData extends i implements Serializable {
    private static final long serialVersionUID = 955562840790302592L;
    private UnusualInfo describe;
    private String pubkey;
    private PayVcodeInfoData vcode;
    private int wrongtime;

    public PayVcodeInfoData getVcode() {
        return this.vcode;
    }

    public void setVcode(PayVcodeInfoData payVcodeInfoData) {
        this.vcode = payVcodeInfoData;
    }

    public int getWrongtime() {
        return this.wrongtime;
    }

    public void setWrongtime(int i) {
        this.wrongtime = i;
    }

    public UnusualInfo getDescribe() {
        return this.describe;
    }

    public void setDescribe(UnusualInfo unusualInfo) {
        this.describe = unusualInfo;
    }

    public String getPubkey() {
        return this.pubkey;
    }

    public void setPubkey(String str) {
        this.pubkey = str;
    }

    /* loaded from: classes.dex */
    public static final class UnusualInfo extends i implements Serializable {
        private static final long serialVersionUID = 7762965384357134074L;
        private String url;
        private String word;

        public String getWord() {
            return this.word;
        }

        public void setWord(String str) {
            this.word = str;
        }

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String str) {
            this.url = str;
        }
    }
}
