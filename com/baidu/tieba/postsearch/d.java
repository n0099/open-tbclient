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
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    public String dkJ;
    private PostSearchActivity gjJ;
    private String gkc;
    public ArrayList<String> gkl;
    public int gkd = 0;
    public int gke = 0;
    public int gkf = 1;
    public int gkg = 1;
    public int gkh = 1;
    public boolean gki = false;
    public boolean gkj = false;
    public boolean gkk = false;
    private int gkm = 0;
    private final HttpMessageListener gkn = new HttpMessageListener(CmdConfigHttp.CMD_POST_SEARCH) { // from class: com.baidu.tieba.postsearch.d.1
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
                    d.this.gjJ.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.rP(intValue);
                    d.this.blZ();
                    d.this.bmc();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.gjJ.getResources().getString(f.j.neterror);
                }
                d.this.gjJ.showToast(errorString);
                d.this.gjJ.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener gko = new CustomMessageListener(2009001) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.gkl = (ArrayList) data;
                d.this.gjJ.blL();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.gjJ = postSearchActivity;
        this.gjJ.registerListener(this.gko);
        this.gjJ.registerListener(this.gkn);
    }

    public boolean aE(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.dkJ)) {
            bmb();
        }
        switch (i) {
            case 1:
                return su(str);
            case 2:
                return sv(str);
            case 3:
                return sw(str);
            default:
                return false;
        }
    }

    public boolean su(String str) {
        if (this.gki) {
            return false;
        }
        this.dkJ = str;
        this.gkm = 1;
        this.gjJ.sendMessage(rO(this.gkm));
        this.gki = true;
        return true;
    }

    public boolean sv(String str) {
        if (this.gkj) {
            return false;
        }
        this.dkJ = str;
        this.gkm = 2;
        this.gjJ.sendMessage(rO(this.gkm));
        this.gkj = true;
        return true;
    }

    public boolean sw(String str) {
        if (this.gkk) {
            return false;
        }
        this.dkJ = str;
        this.gkm = 3;
        this.gjJ.sendMessage(rO(this.gkm));
        this.gkk = true;
        return true;
    }

    public void blY() {
        this.gjJ.sendMessage(new CustomMessage(2009001));
    }

    public void blZ() {
        if (!StringUtils.isNull(this.dkJ) && !this.dkJ.equals(this.gkc)) {
            this.gjJ.sendMessage(new CustomMessage(2009003, this.dkJ));
            this.gkc = this.dkJ;
        }
    }

    public void bma() {
        if (this.gkl != null) {
            this.gkl.clear();
        }
        this.gjJ.sendMessage(new CustomMessage(2009004));
    }

    public void bmb() {
        this.gkf = 1;
        this.gkg = 1;
        this.gkh = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmc() {
        if (this.gkl == null) {
            this.gkl = new ArrayList<>();
        }
        this.gkl.remove(this.dkJ);
        this.gkl.add(0, this.dkJ);
        di(this.gkl);
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
        httpMessage.addParam("word", this.dkJ);
        httpMessage.addParam(LegoListActivityConfig.RN, 30);
        httpMessage.addParam("kw", this.gjJ.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.gkm));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam("pn", this.gkf);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam("pn", this.gkg);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam("pn", this.gkh);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rP(int i) {
        switch (i) {
            case 1:
                this.gkf++;
                return;
            case 2:
                this.gkg++;
                return;
            case 3:
                this.gkh++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int rQ(int i) {
        switch (i) {
            case 1:
                return this.gkf;
            case 2:
                return this.gkg;
            case 3:
                return this.gkh;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rR(int i) {
        switch (i) {
            case 1:
                this.gki = false;
                return;
            case 2:
                this.gkj = false;
                return;
            case 3:
                this.gkk = false;
                return;
            default:
                return;
        }
    }
}
