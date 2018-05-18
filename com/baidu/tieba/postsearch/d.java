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
    public String cWR;
    private PostSearchActivity fTT;
    private String fUn;
    public ArrayList<String> fUw;
    public int fUo = 0;
    public int fUp = 0;
    public int fUq = 1;
    public int fUr = 1;
    public int fUs = 1;
    public boolean fUt = false;
    public boolean fUu = false;
    public boolean fUv = false;
    private int fUx = 0;
    private final HttpMessageListener fUy = new HttpMessageListener(CmdConfigHttp.CMD_POST_SEARCH) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.rz(intValue);
                boolean z = d.this.ry(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.fTT.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.rx(intValue);
                    d.this.bih();
                    d.this.bik();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.fTT.getResources().getString(d.k.neterror);
                }
                d.this.fTT.showToast(errorString);
                d.this.fTT.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener fUz = new CustomMessageListener(2009001) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.fUw = (ArrayList) data;
                d.this.fTT.bhT();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.fTT = postSearchActivity;
        this.fTT.registerListener(this.fUz);
        this.fTT.registerListener(this.fUy);
    }

    public boolean aE(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.cWR)) {
            bij();
        }
        switch (i) {
            case 1:
                return rG(str);
            case 2:
                return rH(str);
            case 3:
                return rI(str);
            default:
                return false;
        }
    }

    public boolean rG(String str) {
        if (this.fUt) {
            return false;
        }
        this.cWR = str;
        this.fUx = 1;
        this.fTT.sendMessage(rw(this.fUx));
        this.fUt = true;
        return true;
    }

    public boolean rH(String str) {
        if (this.fUu) {
            return false;
        }
        this.cWR = str;
        this.fUx = 2;
        this.fTT.sendMessage(rw(this.fUx));
        this.fUu = true;
        return true;
    }

    public boolean rI(String str) {
        if (this.fUv) {
            return false;
        }
        this.cWR = str;
        this.fUx = 3;
        this.fTT.sendMessage(rw(this.fUx));
        this.fUv = true;
        return true;
    }

    public void big() {
        this.fTT.sendMessage(new CustomMessage(2009001));
    }

    public void bih() {
        if (!StringUtils.isNull(this.cWR) && !this.cWR.equals(this.fUn)) {
            this.fTT.sendMessage(new CustomMessage(2009003, this.cWR));
            this.fUn = this.cWR;
        }
    }

    public void bii() {
        if (this.fUw != null) {
            this.fUw.clear();
        }
        this.fTT.sendMessage(new CustomMessage(2009004));
    }

    public void bij() {
        this.fUq = 1;
        this.fUr = 1;
        this.fUs = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bik() {
        if (this.fUw == null) {
            this.fUw = new ArrayList<>();
        }
        this.fUw.remove(this.cWR);
        this.fUw.add(0, this.cWR);
        dd(this.fUw);
    }

    private void dd(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage rw(int i) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_POST_SEARCH);
        httpMessage.addParam("word", this.cWR);
        httpMessage.addParam(LegoListActivityConfig.RN, 30);
        httpMessage.addParam("kw", this.fTT.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.fUx));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam("pn", this.fUq);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam("pn", this.fUr);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam("pn", this.fUs);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rx(int i) {
        switch (i) {
            case 1:
                this.fUq++;
                return;
            case 2:
                this.fUr++;
                return;
            case 3:
                this.fUs++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ry(int i) {
        switch (i) {
            case 1:
                return this.fUq;
            case 2:
                return this.fUr;
            case 3:
                return this.fUs;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rz(int i) {
        switch (i) {
            case 1:
                this.fUt = false;
                return;
            case 2:
                this.fUu = false;
                return;
            case 3:
                this.fUv = false;
                return;
            default:
                return;
        }
    }
}
