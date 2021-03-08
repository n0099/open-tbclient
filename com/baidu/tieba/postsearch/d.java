package com.baidu.tieba.postsearch;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.mobstat.Config;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class d {
    public String jfU;
    private PostSearchActivity mOI;
    private String mPa;
    public ArrayList<String> mPj;
    public int mPb = 0;
    public int mPc = 0;
    public int mPd = 1;
    public int mPe = 1;
    public int mPf = 1;
    public boolean mPg = false;
    public boolean mPh = false;
    public boolean mPi = false;
    private int mPk = 0;
    private final HttpMessageListener mPl = new HttpMessageListener(1003016) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.HB(intValue);
                boolean z = d.this.HA(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.mOI.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.Hz(intValue);
                    d.this.dCb();
                    d.this.dCe();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.mOI.getResources().getString(R.string.neterror);
                }
                d.this.mOI.showToast(errorString);
                d.this.mOI.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener mPo = new CustomMessageListener(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.mPj = (ArrayList) data;
                d.this.mOI.dBN();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.mOI = postSearchActivity;
        this.mOI.registerListener(this.mPo);
        this.mOI.registerListener(this.mPl);
    }

    public boolean bM(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.jfU)) {
            dCd();
        }
        switch (i) {
            case 1:
                return QT(str);
            case 2:
                return QU(str);
            case 3:
                return QV(str);
            default:
                return false;
        }
    }

    public boolean QT(String str) {
        if (this.mPg) {
            return false;
        }
        this.jfU = str;
        this.mPk = 1;
        this.mOI.sendMessage(Hy(this.mPk));
        this.mPg = true;
        return true;
    }

    public boolean QU(String str) {
        if (this.mPh) {
            return false;
        }
        this.jfU = str;
        this.mPk = 2;
        this.mOI.sendMessage(Hy(this.mPk));
        this.mPh = true;
        return true;
    }

    public boolean QV(String str) {
        if (this.mPi) {
            return false;
        }
        this.jfU = str;
        this.mPk = 3;
        this.mOI.sendMessage(Hy(this.mPk));
        this.mPi = true;
        return true;
    }

    public void dCa() {
        this.mOI.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void dCb() {
        if (!StringUtils.isNull(this.jfU) && !this.jfU.equals(this.mPa)) {
            this.mOI.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.jfU));
            this.mPa = this.jfU;
        }
    }

    public void dCc() {
        if (this.mPj != null) {
            this.mPj.clear();
        }
        this.mOI.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void dCd() {
        this.mPd = 1;
        this.mPe = 1;
        this.mPf = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCe() {
        if (this.mPj == null) {
            this.mPj = new ArrayList<>();
        }
        this.mPj.remove(this.jfU);
        this.mPj.add(0, this.jfU);
        fH(this.mPj);
    }

    private void fH(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage Hy(int i) {
        HttpMessage httpMessage = new HttpMessage(1003016);
        httpMessage.addParam("word", this.jfU);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.mOI.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.mPk));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.mPd);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.mPe);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.mPf);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hz(int i) {
        switch (i) {
            case 1:
                this.mPd++;
                return;
            case 2:
                this.mPe++;
                return;
            case 3:
                this.mPf++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int HA(int i) {
        switch (i) {
            case 1:
                return this.mPd;
            case 2:
                return this.mPe;
            case 3:
                return this.mPf;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HB(int i) {
        switch (i) {
            case 1:
                this.mPg = false;
                return;
            case 2:
                this.mPh = false;
                return;
            case 3:
                this.mPi = false;
                return;
            default:
                return;
        }
    }
}
