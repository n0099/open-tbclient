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
    public String dzU;
    public ArrayList<String> gAF;
    private PostSearchActivity gAd;
    private String gAw;
    public int gAx = 0;
    public int gAy = 0;
    public int gAz = 1;
    public int gAA = 1;
    public int gAB = 1;
    public boolean gAC = false;
    public boolean gAD = false;
    public boolean gAE = false;
    private int gAG = 0;
    private final HttpMessageListener gAH = new HttpMessageListener(CmdConfigHttp.CMD_POST_SEARCH) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.te(intValue);
                boolean z = d.this.td(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.gAd.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.tc(intValue);
                    d.this.brq();
                    d.this.brt();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.gAd.getResources().getString(e.j.neterror);
                }
                d.this.gAd.showToast(errorString);
                d.this.gAd.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener gAI = new CustomMessageListener(2009001) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.gAF = (ArrayList) data;
                d.this.gAd.brc();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.gAd = postSearchActivity;
        this.gAd.registerListener(this.gAI);
        this.gAd.registerListener(this.gAH);
    }

    public boolean aN(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.dzU)) {
            brs();
        }
        switch (i) {
            case 1:
                return tF(str);
            case 2:
                return tG(str);
            case 3:
                return tH(str);
            default:
                return false;
        }
    }

    public boolean tF(String str) {
        if (this.gAC) {
            return false;
        }
        this.dzU = str;
        this.gAG = 1;
        this.gAd.sendMessage(tb(this.gAG));
        this.gAC = true;
        return true;
    }

    public boolean tG(String str) {
        if (this.gAD) {
            return false;
        }
        this.dzU = str;
        this.gAG = 2;
        this.gAd.sendMessage(tb(this.gAG));
        this.gAD = true;
        return true;
    }

    public boolean tH(String str) {
        if (this.gAE) {
            return false;
        }
        this.dzU = str;
        this.gAG = 3;
        this.gAd.sendMessage(tb(this.gAG));
        this.gAE = true;
        return true;
    }

    public void brp() {
        this.gAd.sendMessage(new CustomMessage(2009001));
    }

    public void brq() {
        if (!StringUtils.isNull(this.dzU) && !this.dzU.equals(this.gAw)) {
            this.gAd.sendMessage(new CustomMessage(2009003, this.dzU));
            this.gAw = this.dzU;
        }
    }

    public void brr() {
        if (this.gAF != null) {
            this.gAF.clear();
        }
        this.gAd.sendMessage(new CustomMessage(2009004));
    }

    public void brs() {
        this.gAz = 1;
        this.gAA = 1;
        this.gAB = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brt() {
        if (this.gAF == null) {
            this.gAF = new ArrayList<>();
        }
        this.gAF.remove(this.dzU);
        this.gAF.add(0, this.dzU);
        dv(this.gAF);
    }

    private void dv(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage tb(int i) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_POST_SEARCH);
        httpMessage.addParam("word", this.dzU);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.gAd.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.gAG));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.gAz);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.gAA);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.gAB);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tc(int i) {
        switch (i) {
            case 1:
                this.gAz++;
                return;
            case 2:
                this.gAA++;
                return;
            case 3:
                this.gAB++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int td(int i) {
        switch (i) {
            case 1:
                return this.gAz;
            case 2:
                return this.gAA;
            case 3:
                return this.gAB;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void te(int i) {
        switch (i) {
            case 1:
                this.gAC = false;
                return;
            case 2:
                this.gAD = false;
                return;
            case 3:
                this.gAE = false;
                return;
            default:
                return;
        }
    }
}
