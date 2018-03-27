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
public class e {
    public String dCS;
    public ArrayList<String> gyG;
    private PostSearchActivity gye;
    private String gyx;
    public int gyy = 0;
    public int gyz = 0;
    public int gyA = 1;
    public int gyB = 1;
    public int gyC = 1;
    public boolean gyD = false;
    public boolean gyE = false;
    public boolean gyF = false;
    private int gyH = 0;
    private final HttpMessageListener gyI = new HttpMessageListener(CmdConfigHttp.CMD_POST_SEARCH) { // from class: com.baidu.tieba.postsearch.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                e.this.ud(intValue);
                boolean z = e.this.uc(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    e.this.gye.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    e.this.ub(intValue);
                    e.this.bnb();
                    e.this.bne();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = e.this.gye.getResources().getString(d.j.neterror);
                }
                e.this.gye.showToast(errorString);
                e.this.gye.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener gyJ = new CustomMessageListener(2009001) { // from class: com.baidu.tieba.postsearch.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                e.this.gyG = (ArrayList) data;
                e.this.gye.bmN();
            }
        }
    };

    public e(PostSearchActivity postSearchActivity) {
        this.gye = postSearchActivity;
        this.gye.registerListener(this.gyJ);
        this.gye.registerListener(this.gyI);
    }

    public boolean aC(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.dCS)) {
            bnd();
        }
        switch (i) {
            case 1:
                return rx(str);
            case 2:
                return ry(str);
            case 3:
                return rz(str);
            default:
                return false;
        }
    }

    public boolean rx(String str) {
        if (this.gyD) {
            return false;
        }
        this.dCS = str;
        this.gyH = 1;
        this.gye.sendMessage(ua(this.gyH));
        this.gyD = true;
        return true;
    }

    public boolean ry(String str) {
        if (this.gyE) {
            return false;
        }
        this.dCS = str;
        this.gyH = 2;
        this.gye.sendMessage(ua(this.gyH));
        this.gyE = true;
        return true;
    }

    public boolean rz(String str) {
        if (this.gyF) {
            return false;
        }
        this.dCS = str;
        this.gyH = 3;
        this.gye.sendMessage(ua(this.gyH));
        this.gyF = true;
        return true;
    }

    public void bna() {
        this.gye.sendMessage(new CustomMessage(2009001));
    }

    public void bnb() {
        if (!StringUtils.isNull(this.dCS) && !this.dCS.equals(this.gyx)) {
            this.gye.sendMessage(new CustomMessage(2009003, this.dCS));
            this.gyx = this.dCS;
        }
    }

    public void bnc() {
        if (this.gyG != null) {
            this.gyG.clear();
        }
        this.gye.sendMessage(new CustomMessage(2009004));
    }

    public void bnd() {
        this.gyA = 1;
        this.gyB = 1;
        this.gyC = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bne() {
        if (this.gyG == null) {
            this.gyG = new ArrayList<>();
        }
        this.gyG.remove(this.dCS);
        this.gyG.add(0, this.dCS);
        di(this.gyG);
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

    private HttpMessage ua(int i) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_POST_SEARCH);
        httpMessage.addParam("word", this.dCS);
        httpMessage.addParam(LegoListActivityConfig.RN, 30);
        httpMessage.addParam("kw", this.gye.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.gyH));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam("pn", this.gyA);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam("pn", this.gyB);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam("pn", this.gyC);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ub(int i) {
        switch (i) {
            case 1:
                this.gyA++;
                return;
            case 2:
                this.gyB++;
                return;
            case 3:
                this.gyC++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int uc(int i) {
        switch (i) {
            case 1:
                return this.gyA;
            case 2:
                return this.gyB;
            case 3:
                return this.gyC;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ud(int i) {
        switch (i) {
            case 1:
                this.gyD = false;
                return;
            case 2:
                this.gyE = false;
                return;
            case 3:
                this.gyF = false;
                return;
            default:
                return;
        }
    }
}
