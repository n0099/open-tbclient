package com.baidu.tieba.postsearch;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    public String dJR;
    private PostSearchActivity gKP;
    private String gLi;
    public ArrayList<String> gLr;
    public int gLj = 0;
    public int gLk = 0;
    public int gLl = 1;
    public int gLm = 1;
    public int gLn = 1;
    public boolean gLo = false;
    public boolean gLp = false;
    public boolean gLq = false;
    private int gLs = 0;
    private final HttpMessageListener gLt = new HttpMessageListener(CmdConfigHttp.CMD_POST_SEARCH) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.tP(intValue);
                boolean z = d.this.tO(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.gKP.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.tN(intValue);
                    d.this.buD();
                    d.this.buG();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.gKP.getResources().getString(e.j.neterror);
                }
                d.this.gKP.showToast(errorString);
                d.this.gKP.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener gLu = new CustomMessageListener(2009001) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.gLr = (ArrayList) data;
                d.this.gKP.bup();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.gKP = postSearchActivity;
        this.gKP.registerListener(this.gLu);
        this.gKP.registerListener(this.gLt);
    }

    public boolean aP(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.dJR)) {
            buF();
        }
        switch (i) {
            case 1:
                return uA(str);
            case 2:
                return uB(str);
            case 3:
                return uC(str);
            default:
                return false;
        }
    }

    public boolean uA(String str) {
        if (this.gLo) {
            return false;
        }
        this.dJR = str;
        this.gLs = 1;
        this.gKP.sendMessage(tM(this.gLs));
        this.gLo = true;
        return true;
    }

    public boolean uB(String str) {
        if (this.gLp) {
            return false;
        }
        this.dJR = str;
        this.gLs = 2;
        this.gKP.sendMessage(tM(this.gLs));
        this.gLp = true;
        return true;
    }

    public boolean uC(String str) {
        if (this.gLq) {
            return false;
        }
        this.dJR = str;
        this.gLs = 3;
        this.gKP.sendMessage(tM(this.gLs));
        this.gLq = true;
        return true;
    }

    public void buC() {
        this.gKP.sendMessage(new CustomMessage(2009001));
    }

    public void buD() {
        if (!StringUtils.isNull(this.dJR) && !this.dJR.equals(this.gLi)) {
            this.gKP.sendMessage(new CustomMessage(2009003, this.dJR));
            this.gLi = this.dJR;
        }
    }

    public void buE() {
        if (this.gLr != null) {
            this.gLr.clear();
        }
        this.gKP.sendMessage(new CustomMessage(2009004));
    }

    public void buF() {
        this.gLl = 1;
        this.gLm = 1;
        this.gLn = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buG() {
        if (this.gLr == null) {
            this.gLr = new ArrayList<>();
        }
        this.gLr.remove(this.dJR);
        this.gLr.add(0, this.dJR);
        dB(this.gLr);
    }

    private void dB(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage tM(int i) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_POST_SEARCH);
        httpMessage.addParam("word", this.dJR);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.gKP.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.gLs));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.gLl);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.gLm);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.gLn);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tN(int i) {
        switch (i) {
            case 1:
                this.gLl++;
                return;
            case 2:
                this.gLm++;
                return;
            case 3:
                this.gLn++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int tO(int i) {
        switch (i) {
            case 1:
                return this.gLl;
            case 2:
                return this.gLm;
            case 3:
                return this.gLn;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tP(int i) {
        switch (i) {
            case 1:
                this.gLo = false;
                return;
            case 2:
                this.gLp = false;
                return;
            case 3:
                this.gLq = false;
                return;
            default:
                return;
        }
    }
}
