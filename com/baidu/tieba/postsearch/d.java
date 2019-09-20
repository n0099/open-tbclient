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
    public String fuk;
    private String iEO;
    public ArrayList<String> iEX;
    private PostSearchActivity iEv;
    public int iEP = 0;
    public int iEQ = 0;
    public int iER = 1;
    public int iES = 1;
    public int iET = 1;
    public boolean iEU = false;
    public boolean iEV = false;
    public boolean iEW = false;
    private int iEY = 0;
    private final HttpMessageListener iEZ = new HttpMessageListener(CmdConfigHttp.CMD_POST_SEARCH) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.zp(intValue);
                boolean z = d.this.zo(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.iEv.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.zn(intValue);
                    d.this.chq();
                    d.this.cht();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.iEv.getResources().getString(R.string.neterror);
                }
                d.this.iEv.showToast(errorString);
                d.this.iEv.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener iFa = new CustomMessageListener(2009001) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.iEX = (ArrayList) data;
                d.this.iEv.chc();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.iEv = postSearchActivity;
        this.iEv.registerListener(this.iFa);
        this.iEv.registerListener(this.iEZ);
    }

    public boolean bj(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.fuk)) {
            chs();
        }
        switch (i) {
            case 1:
                return DK(str);
            case 2:
                return DL(str);
            case 3:
                return DM(str);
            default:
                return false;
        }
    }

    public boolean DK(String str) {
        if (this.iEU) {
            return false;
        }
        this.fuk = str;
        this.iEY = 1;
        this.iEv.sendMessage(zm(this.iEY));
        this.iEU = true;
        return true;
    }

    public boolean DL(String str) {
        if (this.iEV) {
            return false;
        }
        this.fuk = str;
        this.iEY = 2;
        this.iEv.sendMessage(zm(this.iEY));
        this.iEV = true;
        return true;
    }

    public boolean DM(String str) {
        if (this.iEW) {
            return false;
        }
        this.fuk = str;
        this.iEY = 3;
        this.iEv.sendMessage(zm(this.iEY));
        this.iEW = true;
        return true;
    }

    public void chp() {
        this.iEv.sendMessage(new CustomMessage(2009001));
    }

    public void chq() {
        if (!StringUtils.isNull(this.fuk) && !this.fuk.equals(this.iEO)) {
            this.iEv.sendMessage(new CustomMessage(2009003, this.fuk));
            this.iEO = this.fuk;
        }
    }

    public void chr() {
        if (this.iEX != null) {
            this.iEX.clear();
        }
        this.iEv.sendMessage(new CustomMessage(2009004));
    }

    public void chs() {
        this.iER = 1;
        this.iES = 1;
        this.iET = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cht() {
        if (this.iEX == null) {
            this.iEX = new ArrayList<>();
        }
        this.iEX.remove(this.fuk);
        this.iEX.add(0, this.fuk);
        dX(this.iEX);
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

    private HttpMessage zm(int i) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_POST_SEARCH);
        httpMessage.addParam("word", this.fuk);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.iEv.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.iEY));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.iER);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.iES);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.iET);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zn(int i) {
        switch (i) {
            case 1:
                this.iER++;
                return;
            case 2:
                this.iES++;
                return;
            case 3:
                this.iET++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int zo(int i) {
        switch (i) {
            case 1:
                return this.iER;
            case 2:
                return this.iES;
            case 3:
                return this.iET;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zp(int i) {
        switch (i) {
            case 1:
                this.iEU = false;
                return;
            case 2:
                this.iEV = false;
                return;
            case 3:
                this.iEW = false;
                return;
            default:
                return;
        }
    }
}
