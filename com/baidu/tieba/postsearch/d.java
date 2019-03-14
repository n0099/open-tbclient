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
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class d {
    public String eXh;
    private String icF;
    public ArrayList<String> icO;
    private PostSearchActivity icn;
    public int icG = 0;
    public int icH = 0;
    public int icI = 1;
    public int icJ = 1;
    public int icK = 1;
    public boolean icL = false;
    public boolean icM = false;
    public boolean icN = false;
    private int icP = 0;
    private final HttpMessageListener icQ = new HttpMessageListener(CmdConfigHttp.CMD_POST_SEARCH) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.xC(intValue);
                boolean z = d.this.xB(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.icn.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.xA(intValue);
                    d.this.bVs();
                    d.this.bVv();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.icn.getResources().getString(d.j.neterror);
                }
                d.this.icn.showToast(errorString);
                d.this.icn.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener icR = new CustomMessageListener(2009001) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.icO = (ArrayList) data;
                d.this.icn.bVe();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.icn = postSearchActivity;
        this.icn.registerListener(this.icR);
        this.icn.registerListener(this.icQ);
    }

    public boolean bk(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.eXh)) {
            bVu();
        }
        switch (i) {
            case 1:
                return Be(str);
            case 2:
                return Bf(str);
            case 3:
                return Bg(str);
            default:
                return false;
        }
    }

    public boolean Be(String str) {
        if (this.icL) {
            return false;
        }
        this.eXh = str;
        this.icP = 1;
        this.icn.sendMessage(xz(this.icP));
        this.icL = true;
        return true;
    }

    public boolean Bf(String str) {
        if (this.icM) {
            return false;
        }
        this.eXh = str;
        this.icP = 2;
        this.icn.sendMessage(xz(this.icP));
        this.icM = true;
        return true;
    }

    public boolean Bg(String str) {
        if (this.icN) {
            return false;
        }
        this.eXh = str;
        this.icP = 3;
        this.icn.sendMessage(xz(this.icP));
        this.icN = true;
        return true;
    }

    public void bVr() {
        this.icn.sendMessage(new CustomMessage(2009001));
    }

    public void bVs() {
        if (!StringUtils.isNull(this.eXh) && !this.eXh.equals(this.icF)) {
            this.icn.sendMessage(new CustomMessage(2009003, this.eXh));
            this.icF = this.eXh;
        }
    }

    public void bVt() {
        if (this.icO != null) {
            this.icO.clear();
        }
        this.icn.sendMessage(new CustomMessage(2009004));
    }

    public void bVu() {
        this.icI = 1;
        this.icJ = 1;
        this.icK = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVv() {
        if (this.icO == null) {
            this.icO = new ArrayList<>();
        }
        this.icO.remove(this.eXh);
        this.icO.add(0, this.eXh);
        dP(this.icO);
    }

    private void dP(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage xz(int i) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_POST_SEARCH);
        httpMessage.addParam("word", this.eXh);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.icn.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.icP));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.icI);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.icJ);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.icK);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xA(int i) {
        switch (i) {
            case 1:
                this.icI++;
                return;
            case 2:
                this.icJ++;
                return;
            case 3:
                this.icK++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int xB(int i) {
        switch (i) {
            case 1:
                return this.icI;
            case 2:
                return this.icJ;
            case 3:
                return this.icK;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xC(int i) {
        switch (i) {
            case 1:
                this.icL = false;
                return;
            case 2:
                this.icM = false;
                return;
            case 3:
                this.icN = false;
                return;
            default:
                return;
        }
    }
}
