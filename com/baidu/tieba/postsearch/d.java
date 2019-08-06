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
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class d {
    public String fsx;
    public ArrayList<String> iCF;
    private PostSearchActivity iCd;
    private String iCw;
    public int iCx = 0;
    public int iCy = 0;
    public int iCz = 1;
    public int iCA = 1;
    public int iCB = 1;
    public boolean iCC = false;
    public boolean iCD = false;
    public boolean iCE = false;
    private int iCG = 0;
    private final HttpMessageListener iCH = new HttpMessageListener(CmdConfigHttp.CMD_POST_SEARCH) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.zm(intValue);
                boolean z = d.this.zl(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.iCd.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.zk(intValue);
                    d.this.cgC();
                    d.this.cgF();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.iCd.getResources().getString(R.string.neterror);
                }
                d.this.iCd.showToast(errorString);
                d.this.iCd.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener iCI = new CustomMessageListener(2009001) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.iCF = (ArrayList) data;
                d.this.iCd.cgo();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.iCd = postSearchActivity;
        this.iCd.registerListener(this.iCI);
        this.iCd.registerListener(this.iCH);
    }

    public boolean bh(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.fsx)) {
            cgE();
        }
        switch (i) {
            case 1:
                return Dl(str);
            case 2:
                return Dm(str);
            case 3:
                return Dn(str);
            default:
                return false;
        }
    }

    public boolean Dl(String str) {
        if (this.iCC) {
            return false;
        }
        this.fsx = str;
        this.iCG = 1;
        this.iCd.sendMessage(zj(this.iCG));
        this.iCC = true;
        return true;
    }

    public boolean Dm(String str) {
        if (this.iCD) {
            return false;
        }
        this.fsx = str;
        this.iCG = 2;
        this.iCd.sendMessage(zj(this.iCG));
        this.iCD = true;
        return true;
    }

    public boolean Dn(String str) {
        if (this.iCE) {
            return false;
        }
        this.fsx = str;
        this.iCG = 3;
        this.iCd.sendMessage(zj(this.iCG));
        this.iCE = true;
        return true;
    }

    public void cgB() {
        this.iCd.sendMessage(new CustomMessage(2009001));
    }

    public void cgC() {
        if (!StringUtils.isNull(this.fsx) && !this.fsx.equals(this.iCw)) {
            this.iCd.sendMessage(new CustomMessage(2009003, this.fsx));
            this.iCw = this.fsx;
        }
    }

    public void cgD() {
        if (this.iCF != null) {
            this.iCF.clear();
        }
        this.iCd.sendMessage(new CustomMessage(2009004));
    }

    public void cgE() {
        this.iCz = 1;
        this.iCA = 1;
        this.iCB = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgF() {
        if (this.iCF == null) {
            this.iCF = new ArrayList<>();
        }
        this.iCF.remove(this.fsx);
        this.iCF.add(0, this.fsx);
        dX(this.iCF);
    }

    private void dX(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage zj(int i) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_POST_SEARCH);
        httpMessage.addParam("word", this.fsx);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.iCd.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.iCG));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.iCz);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.iCA);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.iCB);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zk(int i) {
        switch (i) {
            case 1:
                this.iCz++;
                return;
            case 2:
                this.iCA++;
                return;
            case 3:
                this.iCB++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int zl(int i) {
        switch (i) {
            case 1:
                return this.iCz;
            case 2:
                return this.iCA;
            case 3:
                return this.iCB;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zm(int i) {
        switch (i) {
            case 1:
                this.iCC = false;
                return;
            case 2:
                this.iCD = false;
                return;
            case 3:
                this.iCE = false;
                return;
            default:
                return;
        }
    }
}
