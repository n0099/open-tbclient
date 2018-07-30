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
    public String dkL;
    private PostSearchActivity gjK;
    private String gkd;
    public ArrayList<String> gkm;
    public int gke = 0;
    public int gkf = 0;
    public int gkg = 1;
    public int gkh = 1;
    public int gki = 1;
    public boolean gkj = false;
    public boolean gkk = false;
    public boolean gkl = false;
    private int gkn = 0;
    private final HttpMessageListener gko = new HttpMessageListener(CmdConfigHttp.CMD_POST_SEARCH) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.rR(intValue);
                boolean z = d.this.rQ(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.gjK.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.rP(intValue);
                    d.this.bmc();
                    d.this.bmf();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.gjK.getResources().getString(d.j.neterror);
                }
                d.this.gjK.showToast(errorString);
                d.this.gjK.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener gkp = new CustomMessageListener(2009001) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.gkm = (ArrayList) data;
                d.this.gjK.blO();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.gjK = postSearchActivity;
        this.gjK.registerListener(this.gkp);
        this.gjK.registerListener(this.gko);
    }

    public boolean aE(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.dkL)) {
            bme();
        }
        switch (i) {
            case 1:
                return sq(str);
            case 2:
                return ss(str);
            case 3:
                return st(str);
            default:
                return false;
        }
    }

    public boolean sq(String str) {
        if (this.gkj) {
            return false;
        }
        this.dkL = str;
        this.gkn = 1;
        this.gjK.sendMessage(rO(this.gkn));
        this.gkj = true;
        return true;
    }

    public boolean ss(String str) {
        if (this.gkk) {
            return false;
        }
        this.dkL = str;
        this.gkn = 2;
        this.gjK.sendMessage(rO(this.gkn));
        this.gkk = true;
        return true;
    }

    public boolean st(String str) {
        if (this.gkl) {
            return false;
        }
        this.dkL = str;
        this.gkn = 3;
        this.gjK.sendMessage(rO(this.gkn));
        this.gkl = true;
        return true;
    }

    public void bmb() {
        this.gjK.sendMessage(new CustomMessage(2009001));
    }

    public void bmc() {
        if (!StringUtils.isNull(this.dkL) && !this.dkL.equals(this.gkd)) {
            this.gjK.sendMessage(new CustomMessage(2009003, this.dkL));
            this.gkd = this.dkL;
        }
    }

    public void bmd() {
        if (this.gkm != null) {
            this.gkm.clear();
        }
        this.gjK.sendMessage(new CustomMessage(2009004));
    }

    public void bme() {
        this.gkg = 1;
        this.gkh = 1;
        this.gki = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmf() {
        if (this.gkm == null) {
            this.gkm = new ArrayList<>();
        }
        this.gkm.remove(this.dkL);
        this.gkm.add(0, this.dkL);
        di(this.gkm);
    }

    private void di(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage rO(int i) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_POST_SEARCH);
        httpMessage.addParam("word", this.dkL);
        httpMessage.addParam(LegoListActivityConfig.RN, 30);
        httpMessage.addParam("kw", this.gjK.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.gkn));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam("pn", this.gkg);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam("pn", this.gkh);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam("pn", this.gki);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rP(int i) {
        switch (i) {
            case 1:
                this.gkg++;
                return;
            case 2:
                this.gkh++;
                return;
            case 3:
                this.gki++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int rQ(int i) {
        switch (i) {
            case 1:
                return this.gkg;
            case 2:
                return this.gkh;
            case 3:
                return this.gki;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rR(int i) {
        switch (i) {
            case 1:
                this.gkj = false;
                return;
            case 2:
                this.gkk = false;
                return;
            case 3:
                this.gkl = false;
                return;
            default:
                return;
        }
    }
}
