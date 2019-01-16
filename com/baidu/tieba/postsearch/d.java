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
    public String dJQ;
    private PostSearchActivity gKO;
    private String gLh;
    public ArrayList<String> gLq;
    public int gLi = 0;
    public int gLj = 0;
    public int gLk = 1;
    public int gLl = 1;
    public int gLm = 1;
    public boolean gLn = false;
    public boolean gLo = false;
    public boolean gLp = false;
    private int gLr = 0;
    private final HttpMessageListener gLs = new HttpMessageListener(CmdConfigHttp.CMD_POST_SEARCH) { // from class: com.baidu.tieba.postsearch.d.1
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
                    d.this.gKO.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.tN(intValue);
                    d.this.buD();
                    d.this.buG();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.gKO.getResources().getString(e.j.neterror);
                }
                d.this.gKO.showToast(errorString);
                d.this.gKO.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener gLt = new CustomMessageListener(2009001) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.gLq = (ArrayList) data;
                d.this.gKO.bup();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.gKO = postSearchActivity;
        this.gKO.registerListener(this.gLt);
        this.gKO.registerListener(this.gLs);
    }

    public boolean aP(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.dJQ)) {
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
        if (this.gLn) {
            return false;
        }
        this.dJQ = str;
        this.gLr = 1;
        this.gKO.sendMessage(tM(this.gLr));
        this.gLn = true;
        return true;
    }

    public boolean uB(String str) {
        if (this.gLo) {
            return false;
        }
        this.dJQ = str;
        this.gLr = 2;
        this.gKO.sendMessage(tM(this.gLr));
        this.gLo = true;
        return true;
    }

    public boolean uC(String str) {
        if (this.gLp) {
            return false;
        }
        this.dJQ = str;
        this.gLr = 3;
        this.gKO.sendMessage(tM(this.gLr));
        this.gLp = true;
        return true;
    }

    public void buC() {
        this.gKO.sendMessage(new CustomMessage(2009001));
    }

    public void buD() {
        if (!StringUtils.isNull(this.dJQ) && !this.dJQ.equals(this.gLh)) {
            this.gKO.sendMessage(new CustomMessage(2009003, this.dJQ));
            this.gLh = this.dJQ;
        }
    }

    public void buE() {
        if (this.gLq != null) {
            this.gLq.clear();
        }
        this.gKO.sendMessage(new CustomMessage(2009004));
    }

    public void buF() {
        this.gLk = 1;
        this.gLl = 1;
        this.gLm = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buG() {
        if (this.gLq == null) {
            this.gLq = new ArrayList<>();
        }
        this.gLq.remove(this.dJQ);
        this.gLq.add(0, this.dJQ);
        dB(this.gLq);
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
        httpMessage.addParam("word", this.dJQ);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.gKO.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.gLr));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.gLk);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.gLl);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.gLm);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tN(int i) {
        switch (i) {
            case 1:
                this.gLk++;
                return;
            case 2:
                this.gLl++;
                return;
            case 3:
                this.gLm++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int tO(int i) {
        switch (i) {
            case 1:
                return this.gLk;
            case 2:
                return this.gLl;
            case 3:
                return this.gLm;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tP(int i) {
        switch (i) {
            case 1:
                this.gLn = false;
                return;
            case 2:
                this.gLo = false;
                return;
            case 3:
                this.gLp = false;
                return;
            default:
                return;
        }
    }
}
