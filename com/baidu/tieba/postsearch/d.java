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
    public String fsG;
    public ArrayList<String> iCC;
    private PostSearchActivity iCa;
    private String iCt;
    public int iCu = 0;
    public int iCv = 0;
    public int iCw = 1;
    public int iCx = 1;
    public int iCy = 1;
    public boolean iCz = false;
    public boolean iCA = false;
    public boolean iCB = false;
    private int iCD = 0;
    private final HttpMessageListener iCE = new HttpMessageListener(1003016) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.xT(intValue);
                boolean z = d.this.xS(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.iCa.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.xR(intValue);
                    d.this.cen();
                    d.this.ceq();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.iCa.getResources().getString(R.string.neterror);
                }
                d.this.iCa.showToast(errorString);
                d.this.iCa.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener iCF = new CustomMessageListener(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.iCC = (ArrayList) data;
                d.this.iCa.cdZ();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.iCa = postSearchActivity;
        this.iCa.registerListener(this.iCF);
        this.iCa.registerListener(this.iCE);
    }

    public boolean be(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.fsG)) {
            cep();
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
        if (this.iCz) {
            return false;
        }
        this.fsG = str;
        this.iCD = 1;
        this.iCa.sendMessage(xQ(this.iCD));
        this.iCz = true;
        return true;
    }

    public boolean Ce(String str) {
        if (this.iCA) {
            return false;
        }
        this.fsG = str;
        this.iCD = 2;
        this.iCa.sendMessage(xQ(this.iCD));
        this.iCA = true;
        return true;
    }

    public boolean Cf(String str) {
        if (this.iCB) {
            return false;
        }
        this.fsG = str;
        this.iCD = 3;
        this.iCa.sendMessage(xQ(this.iCD));
        this.iCB = true;
        return true;
    }

    public void cem() {
        this.iCa.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void cen() {
        if (!StringUtils.isNull(this.fsG) && !this.fsG.equals(this.iCt)) {
            this.iCa.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.fsG));
            this.iCt = this.fsG;
        }
    }

    public void ceo() {
        if (this.iCC != null) {
            this.iCC.clear();
        }
        this.iCa.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void cep() {
        this.iCw = 1;
        this.iCx = 1;
        this.iCy = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceq() {
        if (this.iCC == null) {
            this.iCC = new ArrayList<>();
        }
        this.iCC.remove(this.fsG);
        this.iCC.add(0, this.fsG);
        ek(this.iCC);
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

    private HttpMessage xQ(int i) {
        HttpMessage httpMessage = new HttpMessage(1003016);
        httpMessage.addParam("word", this.fsG);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.iCa.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.iCD));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.iCw);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.iCx);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.iCy);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xR(int i) {
        switch (i) {
            case 1:
                this.iCw++;
                return;
            case 2:
                this.iCx++;
                return;
            case 3:
                this.iCy++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int xS(int i) {
        switch (i) {
            case 1:
                return this.iCw;
            case 2:
                return this.iCx;
            case 3:
                return this.iCy;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xT(int i) {
        switch (i) {
            case 1:
                this.iCz = false;
                return;
            case 2:
                this.iCA = false;
                return;
            case 3:
                this.iCB = false;
                return;
            default:
                return;
        }
    }
}
