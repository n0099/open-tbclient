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
/* loaded from: classes8.dex */
public class d {
    public String jdX;
    private String mMJ;
    public ArrayList<String> mMS;
    private PostSearchActivity mMr;
    public int mMK = 0;
    public int mML = 0;
    public int mMM = 1;
    public int mMN = 1;
    public int mMO = 1;
    public boolean mMP = false;
    public boolean mMQ = false;
    public boolean mMR = false;
    private int mMT = 0;
    private final HttpMessageListener mMU = new HttpMessageListener(1003016) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.Hy(intValue);
                boolean z = d.this.Hx(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.mMr.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.Hw(intValue);
                    d.this.dBM();
                    d.this.dBP();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.mMr.getResources().getString(R.string.neterror);
                }
                d.this.mMr.showToast(errorString);
                d.this.mMr.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener mMV = new CustomMessageListener(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.mMS = (ArrayList) data;
                d.this.mMr.dBy();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.mMr = postSearchActivity;
        this.mMr.registerListener(this.mMV);
        this.mMr.registerListener(this.mMU);
    }

    public boolean bM(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.jdX)) {
            dBO();
        }
        switch (i) {
            case 1:
                return QM(str);
            case 2:
                return QN(str);
            case 3:
                return QO(str);
            default:
                return false;
        }
    }

    public boolean QM(String str) {
        if (this.mMP) {
            return false;
        }
        this.jdX = str;
        this.mMT = 1;
        this.mMr.sendMessage(Hv(this.mMT));
        this.mMP = true;
        return true;
    }

    public boolean QN(String str) {
        if (this.mMQ) {
            return false;
        }
        this.jdX = str;
        this.mMT = 2;
        this.mMr.sendMessage(Hv(this.mMT));
        this.mMQ = true;
        return true;
    }

    public boolean QO(String str) {
        if (this.mMR) {
            return false;
        }
        this.jdX = str;
        this.mMT = 3;
        this.mMr.sendMessage(Hv(this.mMT));
        this.mMR = true;
        return true;
    }

    public void dBL() {
        this.mMr.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void dBM() {
        if (!StringUtils.isNull(this.jdX) && !this.jdX.equals(this.mMJ)) {
            this.mMr.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.jdX));
            this.mMJ = this.jdX;
        }
    }

    public void dBN() {
        if (this.mMS != null) {
            this.mMS.clear();
        }
        this.mMr.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void dBO() {
        this.mMM = 1;
        this.mMN = 1;
        this.mMO = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBP() {
        if (this.mMS == null) {
            this.mMS = new ArrayList<>();
        }
        this.mMS.remove(this.jdX);
        this.mMS.add(0, this.jdX);
        fH(this.mMS);
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

    private HttpMessage Hv(int i) {
        HttpMessage httpMessage = new HttpMessage(1003016);
        httpMessage.addParam("word", this.jdX);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.mMr.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.mMT));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.mMM);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.mMN);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.mMO);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hw(int i) {
        switch (i) {
            case 1:
                this.mMM++;
                return;
            case 2:
                this.mMN++;
                return;
            case 3:
                this.mMO++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Hx(int i) {
        switch (i) {
            case 1:
                return this.mMM;
            case 2:
                return this.mMN;
            case 3:
                return this.mMO;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hy(int i) {
        switch (i) {
            case 1:
                this.mMP = false;
                return;
            case 2:
                this.mMQ = false;
                return;
            case 3:
                this.mMR = false;
                return;
            default:
                return;
        }
    }
}
