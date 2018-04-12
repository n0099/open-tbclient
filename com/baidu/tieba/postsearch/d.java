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
    public String cVN;
    private PostSearchActivity fSQ;
    private String fTk;
    public ArrayList<String> fTt;
    public int fTl = 0;
    public int fTm = 0;
    public int fTn = 1;
    public int fTo = 1;
    public int fTp = 1;
    public boolean fTq = false;
    public boolean fTr = false;
    public boolean fTs = false;
    private int fTu = 0;
    private final HttpMessageListener fTv = new HttpMessageListener(CmdConfigHttp.CMD_POST_SEARCH) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.rB(intValue);
                boolean z = d.this.rA(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.fSQ.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.rz(intValue);
                    d.this.bih();
                    d.this.bik();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.fSQ.getResources().getString(d.k.neterror);
                }
                d.this.fSQ.showToast(errorString);
                d.this.fSQ.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener fTw = new CustomMessageListener(2009001) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.fTt = (ArrayList) data;
                d.this.fSQ.bhT();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.fSQ = postSearchActivity;
        this.fSQ.registerListener(this.fTw);
        this.fSQ.registerListener(this.fTv);
    }

    public boolean aE(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.cVN)) {
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
        if (this.fTq) {
            return false;
        }
        this.cVN = str;
        this.fTu = 1;
        this.fSQ.sendMessage(ry(this.fTu));
        this.fTq = true;
        return true;
    }

    public boolean rE(String str) {
        if (this.fTr) {
            return false;
        }
        this.cVN = str;
        this.fTu = 2;
        this.fSQ.sendMessage(ry(this.fTu));
        this.fTr = true;
        return true;
    }

    public boolean rF(String str) {
        if (this.fTs) {
            return false;
        }
        this.cVN = str;
        this.fTu = 3;
        this.fSQ.sendMessage(ry(this.fTu));
        this.fTs = true;
        return true;
    }

    public void big() {
        this.fSQ.sendMessage(new CustomMessage(2009001));
    }

    public void bih() {
        if (!StringUtils.isNull(this.cVN) && !this.cVN.equals(this.fTk)) {
            this.fSQ.sendMessage(new CustomMessage(2009003, this.cVN));
            this.fTk = this.cVN;
        }
    }

    public void bii() {
        if (this.fTt != null) {
            this.fTt.clear();
        }
        this.fSQ.sendMessage(new CustomMessage(2009004));
    }

    public void bij() {
        this.fTn = 1;
        this.fTo = 1;
        this.fTp = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bik() {
        if (this.fTt == null) {
            this.fTt = new ArrayList<>();
        }
        this.fTt.remove(this.cVN);
        this.fTt.add(0, this.cVN);
        da(this.fTt);
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

    private HttpMessage ry(int i) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_POST_SEARCH);
        httpMessage.addParam("word", this.cVN);
        httpMessage.addParam(LegoListActivityConfig.RN, 30);
        httpMessage.addParam("kw", this.fSQ.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.fTu));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam("pn", this.fTn);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam("pn", this.fTo);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam("pn", this.fTp);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rz(int i) {
        switch (i) {
            case 1:
                this.fTn++;
                return;
            case 2:
                this.fTo++;
                return;
            case 3:
                this.fTp++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int rA(int i) {
        switch (i) {
            case 1:
                return this.fTn;
            case 2:
                return this.fTo;
            case 3:
                return this.fTp;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rB(int i) {
        switch (i) {
            case 1:
                this.fTq = false;
                return;
            case 2:
                this.fTr = false;
                return;
            case 3:
                this.fTs = false;
                return;
            default:
                return;
        }
    }
}
