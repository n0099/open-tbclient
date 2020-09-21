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
/* loaded from: classes23.dex */
public class d {
    public String hXJ;
    private String lGH;
    public ArrayList<String> lGQ;
    private PostSearchActivity lGp;
    public int lGI = 0;
    public int lGJ = 0;
    public int lGK = 1;
    public int lGL = 1;
    public int lGM = 1;
    public boolean lGN = false;
    public boolean lGO = false;
    public boolean lGP = false;
    private int lGR = 0;
    private final HttpMessageListener lGS = new HttpMessageListener(1003016) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.Gs(intValue);
                boolean z = d.this.Gr(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.lGp.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.Gq(intValue);
                    d.this.dps();
                    d.this.dpv();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.lGp.getResources().getString(R.string.neterror);
                }
                d.this.lGp.showToast(errorString);
                d.this.lGp.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener lGT = new CustomMessageListener(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.lGQ = (ArrayList) data;
                d.this.lGp.dpe();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.lGp = postSearchActivity;
        this.lGp.registerListener(this.lGT);
        this.lGp.registerListener(this.lGS);
    }

    public boolean bz(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.hXJ)) {
            dpu();
        }
        switch (i) {
            case 1:
                return Pp(str);
            case 2:
                return Pq(str);
            case 3:
                return Pr(str);
            default:
                return false;
        }
    }

    public boolean Pp(String str) {
        if (this.lGN) {
            return false;
        }
        this.hXJ = str;
        this.lGR = 1;
        this.lGp.sendMessage(Gp(this.lGR));
        this.lGN = true;
        return true;
    }

    public boolean Pq(String str) {
        if (this.lGO) {
            return false;
        }
        this.hXJ = str;
        this.lGR = 2;
        this.lGp.sendMessage(Gp(this.lGR));
        this.lGO = true;
        return true;
    }

    public boolean Pr(String str) {
        if (this.lGP) {
            return false;
        }
        this.hXJ = str;
        this.lGR = 3;
        this.lGp.sendMessage(Gp(this.lGR));
        this.lGP = true;
        return true;
    }

    public void dpr() {
        this.lGp.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void dps() {
        if (!StringUtils.isNull(this.hXJ) && !this.hXJ.equals(this.lGH)) {
            this.lGp.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.hXJ));
            this.lGH = this.hXJ;
        }
    }

    public void dpt() {
        if (this.lGQ != null) {
            this.lGQ.clear();
        }
        this.lGp.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void dpu() {
        this.lGK = 1;
        this.lGL = 1;
        this.lGM = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpv() {
        if (this.lGQ == null) {
            this.lGQ = new ArrayList<>();
        }
        this.lGQ.remove(this.hXJ);
        this.lGQ.add(0, this.hXJ);
        fd(this.lGQ);
    }

    private void fd(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage Gp(int i) {
        HttpMessage httpMessage = new HttpMessage(1003016);
        httpMessage.addParam("word", this.hXJ);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.lGp.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.lGR));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.lGK);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.lGL);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.lGM);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gq(int i) {
        switch (i) {
            case 1:
                this.lGK++;
                return;
            case 2:
                this.lGL++;
                return;
            case 3:
                this.lGM++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Gr(int i) {
        switch (i) {
            case 1:
                return this.lGK;
            case 2:
                return this.lGL;
            case 3:
                return this.lGM;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gs(int i) {
        switch (i) {
            case 1:
                this.lGN = false;
                return;
            case 2:
                this.lGO = false;
                return;
            case 3:
                this.lGP = false;
                return;
            default:
                return;
        }
    }
}
