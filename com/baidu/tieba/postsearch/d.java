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
/* loaded from: classes11.dex */
public class d {
    public String gWq;
    private String kmR;
    private PostSearchActivity kmy;
    public ArrayList<String> kna;
    public int kmS = 0;
    public int kmT = 0;
    public int kmU = 1;
    public int kmV = 1;
    public int kmW = 1;
    public boolean kmX = false;
    public boolean kmY = false;
    public boolean kmZ = false;
    private int knb = 0;
    private final HttpMessageListener knc = new HttpMessageListener(1003016) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.Bm(intValue);
                boolean z = d.this.Bl(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.kmy.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.Bk(intValue);
                    d.this.cLS();
                    d.this.cLV();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.kmy.getResources().getString(R.string.neterror);
                }
                d.this.kmy.showToast(errorString);
                d.this.kmy.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener knd = new CustomMessageListener(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.kna = (ArrayList) data;
                d.this.kmy.cLE();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.kmy = postSearchActivity;
        this.kmy.registerListener(this.knd);
        this.kmy.registerListener(this.knc);
    }

    public boolean bw(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.gWq)) {
            cLU();
        }
        switch (i) {
            case 1:
                return IV(str);
            case 2:
                return IW(str);
            case 3:
                return IX(str);
            default:
                return false;
        }
    }

    public boolean IV(String str) {
        if (this.kmX) {
            return false;
        }
        this.gWq = str;
        this.knb = 1;
        this.kmy.sendMessage(Bj(this.knb));
        this.kmX = true;
        return true;
    }

    public boolean IW(String str) {
        if (this.kmY) {
            return false;
        }
        this.gWq = str;
        this.knb = 2;
        this.kmy.sendMessage(Bj(this.knb));
        this.kmY = true;
        return true;
    }

    public boolean IX(String str) {
        if (this.kmZ) {
            return false;
        }
        this.gWq = str;
        this.knb = 3;
        this.kmy.sendMessage(Bj(this.knb));
        this.kmZ = true;
        return true;
    }

    public void cLR() {
        this.kmy.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void cLS() {
        if (!StringUtils.isNull(this.gWq) && !this.gWq.equals(this.kmR)) {
            this.kmy.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.gWq));
            this.kmR = this.gWq;
        }
    }

    public void cLT() {
        if (this.kna != null) {
            this.kna.clear();
        }
        this.kmy.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void cLU() {
        this.kmU = 1;
        this.kmV = 1;
        this.kmW = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLV() {
        if (this.kna == null) {
            this.kna = new ArrayList<>();
        }
        this.kna.remove(this.gWq);
        this.kna.add(0, this.gWq);
        ek(this.kna);
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

    private HttpMessage Bj(int i) {
        HttpMessage httpMessage = new HttpMessage(1003016);
        httpMessage.addParam("word", this.gWq);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.kmy.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.knb));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.kmU);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.kmV);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.kmW);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bk(int i) {
        switch (i) {
            case 1:
                this.kmU++;
                return;
            case 2:
                this.kmV++;
                return;
            case 3:
                this.kmW++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Bl(int i) {
        switch (i) {
            case 1:
                return this.kmU;
            case 2:
                return this.kmV;
            case 3:
                return this.kmW;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bm(int i) {
        switch (i) {
            case 1:
                this.kmX = false;
                return;
            case 2:
                this.kmY = false;
                return;
            case 3:
                this.kmZ = false;
                return;
            default:
                return;
        }
    }
}
