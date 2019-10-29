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
/* loaded from: classes6.dex */
public class d {
    public String ftx;
    private PostSearchActivity iCR;
    private String iDk;
    public ArrayList<String> iDt;
    public int iDl = 0;
    public int iDm = 0;
    public int iDn = 1;
    public int iDo = 1;
    public int iDp = 1;
    public boolean iDq = false;
    public boolean iDr = false;
    public boolean iDs = false;
    private int iDu = 0;
    private final HttpMessageListener iDv = new HttpMessageListener(1003016) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.xU(intValue);
                boolean z = d.this.xT(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.iCR.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.xS(intValue);
                    d.this.cep();
                    d.this.ces();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.iCR.getResources().getString(R.string.neterror);
                }
                d.this.iCR.showToast(errorString);
                d.this.iCR.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener iDw = new CustomMessageListener(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.iDt = (ArrayList) data;
                d.this.iCR.ceb();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.iCR = postSearchActivity;
        this.iCR.registerListener(this.iDw);
        this.iCR.registerListener(this.iDv);
    }

    public boolean be(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.ftx)) {
            cer();
        }
        switch (i) {
            case 1:
                return Cd(str);
            case 2:
                return Ce(str);
            case 3:
                return Cf(str);
            default:
                return false;
        }
    }

    public boolean Cd(String str) {
        if (this.iDq) {
            return false;
        }
        this.ftx = str;
        this.iDu = 1;
        this.iCR.sendMessage(xR(this.iDu));
        this.iDq = true;
        return true;
    }

    public boolean Ce(String str) {
        if (this.iDr) {
            return false;
        }
        this.ftx = str;
        this.iDu = 2;
        this.iCR.sendMessage(xR(this.iDu));
        this.iDr = true;
        return true;
    }

    public boolean Cf(String str) {
        if (this.iDs) {
            return false;
        }
        this.ftx = str;
        this.iDu = 3;
        this.iCR.sendMessage(xR(this.iDu));
        this.iDs = true;
        return true;
    }

    public void ceo() {
        this.iCR.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void cep() {
        if (!StringUtils.isNull(this.ftx) && !this.ftx.equals(this.iDk)) {
            this.iCR.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.ftx));
            this.iDk = this.ftx;
        }
    }

    public void ceq() {
        if (this.iDt != null) {
            this.iDt.clear();
        }
        this.iCR.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void cer() {
        this.iDn = 1;
        this.iDo = 1;
        this.iDp = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ces() {
        if (this.iDt == null) {
            this.iDt = new ArrayList<>();
        }
        this.iDt.remove(this.ftx);
        this.iDt.add(0, this.ftx);
        ek(this.iDt);
    }

    private void ek(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage xR(int i) {
        HttpMessage httpMessage = new HttpMessage(1003016);
        httpMessage.addParam("word", this.ftx);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.iCR.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.iDu));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.iDn);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.iDo);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.iDp);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xS(int i) {
        switch (i) {
            case 1:
                this.iDn++;
                return;
            case 2:
                this.iDo++;
                return;
            case 3:
                this.iDp++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int xT(int i) {
        switch (i) {
            case 1:
                return this.iDn;
            case 2:
                return this.iDo;
            case 3:
                return this.iDp;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xU(int i) {
        switch (i) {
            case 1:
                this.iDq = false;
                return;
            case 2:
                this.iDr = false;
                return;
            case 3:
                this.iDs = false;
                return;
            default:
                return;
        }
    }
}
