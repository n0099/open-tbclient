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
/* loaded from: classes24.dex */
public class d {
    public String imJ;
    private PostSearchActivity lVD;
    private String lVV;
    public ArrayList<String> lWe;
    public int lVW = 0;
    public int lVX = 0;
    public int lVY = 1;
    public int lVZ = 1;
    public int lWa = 1;
    public boolean lWb = false;
    public boolean lWc = false;
    public boolean lWd = false;
    private int lWf = 0;
    private final HttpMessageListener lWg = new HttpMessageListener(1003016) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.GY(intValue);
                boolean z = d.this.GX(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.lVD.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.GW(intValue);
                    d.this.dtd();
                    d.this.dtg();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.lVD.getResources().getString(R.string.neterror);
                }
                d.this.lVD.showToast(errorString);
                d.this.lVD.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener lWh = new CustomMessageListener(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.lWe = (ArrayList) data;
                d.this.lVD.dsP();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.lVD = postSearchActivity;
        this.lVD.registerListener(this.lWh);
        this.lVD.registerListener(this.lWg);
    }

    public boolean bA(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.imJ)) {
            dtf();
        }
        switch (i) {
            case 1:
                return Qe(str);
            case 2:
                return Qf(str);
            case 3:
                return Qg(str);
            default:
                return false;
        }
    }

    public boolean Qe(String str) {
        if (this.lWb) {
            return false;
        }
        this.imJ = str;
        this.lWf = 1;
        this.lVD.sendMessage(GV(this.lWf));
        this.lWb = true;
        return true;
    }

    public boolean Qf(String str) {
        if (this.lWc) {
            return false;
        }
        this.imJ = str;
        this.lWf = 2;
        this.lVD.sendMessage(GV(this.lWf));
        this.lWc = true;
        return true;
    }

    public boolean Qg(String str) {
        if (this.lWd) {
            return false;
        }
        this.imJ = str;
        this.lWf = 3;
        this.lVD.sendMessage(GV(this.lWf));
        this.lWd = true;
        return true;
    }

    public void dtc() {
        this.lVD.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void dtd() {
        if (!StringUtils.isNull(this.imJ) && !this.imJ.equals(this.lVV)) {
            this.lVD.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.imJ));
            this.lVV = this.imJ;
        }
    }

    public void dte() {
        if (this.lWe != null) {
            this.lWe.clear();
        }
        this.lVD.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void dtf() {
        this.lVY = 1;
        this.lVZ = 1;
        this.lWa = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtg() {
        if (this.lWe == null) {
            this.lWe = new ArrayList<>();
        }
        this.lWe.remove(this.imJ);
        this.lWe.add(0, this.imJ);
        fg(this.lWe);
    }

    private void fg(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage GV(int i) {
        HttpMessage httpMessage = new HttpMessage(1003016);
        httpMessage.addParam("word", this.imJ);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.lVD.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.lWf));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.lVY);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.lVZ);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.lWa);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GW(int i) {
        switch (i) {
            case 1:
                this.lVY++;
                return;
            case 2:
                this.lVZ++;
                return;
            case 3:
                this.lWa++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int GX(int i) {
        switch (i) {
            case 1:
                return this.lVY;
            case 2:
                return this.lVZ;
            case 3:
                return this.lWa;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GY(int i) {
        switch (i) {
            case 1:
                this.lWb = false;
                return;
            case 2:
                this.lWc = false;
                return;
            case 3:
                this.lWd = false;
                return;
            default:
                return;
        }
    }
}
