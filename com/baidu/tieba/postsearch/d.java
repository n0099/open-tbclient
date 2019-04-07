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
    public String eWT;
    private PostSearchActivity ibZ;
    public ArrayList<String> icA;
    private String icr;
    public int ics = 0;
    public int ict = 0;
    public int icu = 1;
    public int icv = 1;
    public int icw = 1;
    public boolean icx = false;
    public boolean icy = false;
    public boolean icz = false;
    private int icB = 0;
    private final HttpMessageListener icC = new HttpMessageListener(CmdConfigHttp.CMD_POST_SEARCH) { // from class: com.baidu.tieba.postsearch.d.1
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
                    d.this.ibZ.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.xw(intValue);
                    d.this.bVo();
                    d.this.bVr();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.ibZ.getResources().getString(d.j.neterror);
                }
                d.this.ibZ.showToast(errorString);
                d.this.ibZ.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener icD = new CustomMessageListener(2009001) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.icA = (ArrayList) data;
                d.this.ibZ.bVa();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.ibZ = postSearchActivity;
        this.ibZ.registerListener(this.icD);
        this.ibZ.registerListener(this.icC);
    }

    public boolean bk(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.eWT)) {
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
        if (this.icx) {
            return false;
        }
        this.eWT = str;
        this.icB = 1;
        this.ibZ.sendMessage(xv(this.icB));
        this.icx = true;
        return true;
    }

    public boolean Be(String str) {
        if (this.icy) {
            return false;
        }
        this.eWT = str;
        this.icB = 2;
        this.ibZ.sendMessage(xv(this.icB));
        this.icy = true;
        return true;
    }

    public boolean Bf(String str) {
        if (this.icz) {
            return false;
        }
        this.eWT = str;
        this.icB = 3;
        this.ibZ.sendMessage(xv(this.icB));
        this.icz = true;
        return true;
    }

    public void bVn() {
        this.ibZ.sendMessage(new CustomMessage(2009001));
    }

    public void bVo() {
        if (!StringUtils.isNull(this.eWT) && !this.eWT.equals(this.icr)) {
            this.ibZ.sendMessage(new CustomMessage(2009003, this.eWT));
            this.icr = this.eWT;
        }
    }

    public void bVp() {
        if (this.icA != null) {
            this.icA.clear();
        }
        this.ibZ.sendMessage(new CustomMessage(2009004));
    }

    public void bVq() {
        this.icu = 1;
        this.icv = 1;
        this.icw = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVr() {
        if (this.icA == null) {
            this.icA = new ArrayList<>();
        }
        this.icA.remove(this.eWT);
        this.icA.add(0, this.eWT);
        dM(this.icA);
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
        httpMessage.addParam("word", this.eWT);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.ibZ.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.icB));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.icu);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.icv);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.icw);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xw(int i) {
        switch (i) {
            case 1:
                this.icu++;
                return;
            case 2:
                this.icv++;
                return;
            case 3:
                this.icw++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int xx(int i) {
        switch (i) {
            case 1:
                return this.icu;
            case 2:
                return this.icv;
            case 3:
                return this.icw;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xy(int i) {
        switch (i) {
            case 1:
                this.icx = false;
                return;
            case 2:
                this.icy = false;
                return;
            case 3:
                this.icz = false;
                return;
            default:
                return;
        }
    }
}
