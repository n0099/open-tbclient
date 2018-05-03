package com.baidu.tieba.postsearch;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    public String cVK;
    private PostSearchActivity fSN;
    private String fTh;
    public ArrayList<String> fTq;
    public int fTi = 0;
    public int fTj = 0;
    public int fTk = 1;
    public int fTl = 1;
    public int fTm = 1;
    public boolean fTn = false;
    public boolean fTo = false;
    public boolean fTp = false;
    private int fTr = 0;
    private final HttpMessageListener fTs = new HttpMessageListener(CmdConfigHttp.CMD_POST_SEARCH) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.rA(intValue);
                boolean z = d.this.rz(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.fSN.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.ry(intValue);
                    d.this.bih();
                    d.this.bik();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.fSN.getResources().getString(d.k.neterror);
                }
                d.this.fSN.showToast(errorString);
                d.this.fSN.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener fTt = new CustomMessageListener(2009001) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.fTq = (ArrayList) data;
                d.this.fSN.bhT();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.fSN = postSearchActivity;
        this.fSN.registerListener(this.fTt);
        this.fSN.registerListener(this.fTs);
    }

    public boolean aE(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.cVK)) {
            bij();
        }
        switch (i) {
            case 1:
                return rD(str);
            case 2:
                return rE(str);
            case 3:
                return rF(str);
            default:
                return false;
        }
    }

    public boolean rD(String str) {
        if (this.fTn) {
            return false;
        }
        this.cVK = str;
        this.fTr = 1;
        this.fSN.sendMessage(rx(this.fTr));
        this.fTn = true;
        return true;
    }

    public boolean rE(String str) {
        if (this.fTo) {
            return false;
        }
        this.cVK = str;
        this.fTr = 2;
        this.fSN.sendMessage(rx(this.fTr));
        this.fTo = true;
        return true;
    }

    public boolean rF(String str) {
        if (this.fTp) {
            return false;
        }
        this.cVK = str;
        this.fTr = 3;
        this.fSN.sendMessage(rx(this.fTr));
        this.fTp = true;
        return true;
    }

    public void big() {
        this.fSN.sendMessage(new CustomMessage(2009001));
    }

    public void bih() {
        if (!StringUtils.isNull(this.cVK) && !this.cVK.equals(this.fTh)) {
            this.fSN.sendMessage(new CustomMessage(2009003, this.cVK));
            this.fTh = this.cVK;
        }
    }

    public void bii() {
        if (this.fTq != null) {
            this.fTq.clear();
        }
        this.fSN.sendMessage(new CustomMessage(2009004));
    }

    public void bij() {
        this.fTk = 1;
        this.fTl = 1;
        this.fTm = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bik() {
        if (this.fTq == null) {
            this.fTq = new ArrayList<>();
        }
        this.fTq.remove(this.cVK);
        this.fTq.add(0, this.cVK);
        da(this.fTq);
    }

    private void da(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage rx(int i) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_POST_SEARCH);
        httpMessage.addParam("word", this.cVK);
        httpMessage.addParam(LegoListActivityConfig.RN, 30);
        httpMessage.addParam("kw", this.fSN.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.fTr));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam("pn", this.fTk);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam("pn", this.fTl);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam("pn", this.fTm);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ry(int i) {
        switch (i) {
            case 1:
                this.fTk++;
                return;
            case 2:
                this.fTl++;
                return;
            case 3:
                this.fTm++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int rz(int i) {
        switch (i) {
            case 1:
                return this.fTk;
            case 2:
                return this.fTl;
            case 3:
                return this.fTm;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rA(int i) {
        switch (i) {
            case 1:
                this.fTn = false;
                return;
            case 2:
                this.fTo = false;
                return;
            case 3:
                this.fTp = false;
                return;
            default:
                return;
        }
    }
}
