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
    public String eWU;
    public ArrayList<String> icB;
    private PostSearchActivity ica;
    private String ics;
    public int ict = 0;
    public int icu = 0;
    public int icv = 1;
    public int icw = 1;
    public int icx = 1;
    public boolean icy = false;
    public boolean icz = false;
    public boolean icA = false;
    private int icC = 0;
    private final HttpMessageListener icD = new HttpMessageListener(CmdConfigHttp.CMD_POST_SEARCH) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.xy(intValue);
                boolean z = d.this.xx(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.ica.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.xw(intValue);
                    d.this.bVo();
                    d.this.bVr();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.ica.getResources().getString(d.j.neterror);
                }
                d.this.ica.showToast(errorString);
                d.this.ica.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener icE = new CustomMessageListener(2009001) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.icB = (ArrayList) data;
                d.this.ica.bVa();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.ica = postSearchActivity;
        this.ica.registerListener(this.icE);
        this.ica.registerListener(this.icD);
    }

    public boolean bk(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.eWU)) {
            bVq();
        }
        switch (i) {
            case 1:
                return Bd(str);
            case 2:
                return Be(str);
            case 3:
                return Bf(str);
            default:
                return false;
        }
    }

    public boolean Bd(String str) {
        if (this.icy) {
            return false;
        }
        this.eWU = str;
        this.icC = 1;
        this.ica.sendMessage(xv(this.icC));
        this.icy = true;
        return true;
    }

    public boolean Be(String str) {
        if (this.icz) {
            return false;
        }
        this.eWU = str;
        this.icC = 2;
        this.ica.sendMessage(xv(this.icC));
        this.icz = true;
        return true;
    }

    public boolean Bf(String str) {
        if (this.icA) {
            return false;
        }
        this.eWU = str;
        this.icC = 3;
        this.ica.sendMessage(xv(this.icC));
        this.icA = true;
        return true;
    }

    public void bVn() {
        this.ica.sendMessage(new CustomMessage(2009001));
    }

    public void bVo() {
        if (!StringUtils.isNull(this.eWU) && !this.eWU.equals(this.ics)) {
            this.ica.sendMessage(new CustomMessage(2009003, this.eWU));
            this.ics = this.eWU;
        }
    }

    public void bVp() {
        if (this.icB != null) {
            this.icB.clear();
        }
        this.ica.sendMessage(new CustomMessage(2009004));
    }

    public void bVq() {
        this.icv = 1;
        this.icw = 1;
        this.icx = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVr() {
        if (this.icB == null) {
            this.icB = new ArrayList<>();
        }
        this.icB.remove(this.eWU);
        this.icB.add(0, this.eWU);
        dM(this.icB);
    }

    private void dM(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage xv(int i) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_POST_SEARCH);
        httpMessage.addParam("word", this.eWU);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.ica.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.icC));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.icv);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.icw);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.icx);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xw(int i) {
        switch (i) {
            case 1:
                this.icv++;
                return;
            case 2:
                this.icw++;
                return;
            case 3:
                this.icx++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int xx(int i) {
        switch (i) {
            case 1:
                return this.icv;
            case 2:
                return this.icw;
            case 3:
                return this.icx;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xy(int i) {
        switch (i) {
            case 1:
                this.icy = false;
                return;
            case 2:
                this.icz = false;
                return;
            case 3:
                this.icA = false;
                return;
            default:
                return;
        }
    }
}
