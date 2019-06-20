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
    public String fmZ;
    private PostSearchActivity iuI;
    private String ivb;
    public ArrayList<String> ivk;
    public int ivc = 0;
    public int ivd = 0;
    public int ive = 1;
    public int ivf = 1;
    public int ivg = 1;
    public boolean ivh = false;
    public boolean ivi = false;
    public boolean ivj = false;
    private int ivl = 0;
    private final HttpMessageListener ivm = new HttpMessageListener(CmdConfigHttp.CMD_POST_SEARCH) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.yF(intValue);
                boolean z = d.this.yE(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.iuI.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.yD(intValue);
                    d.this.cdt();
                    d.this.cdw();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.iuI.getResources().getString(R.string.neterror);
                }
                d.this.iuI.showToast(errorString);
                d.this.iuI.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener ivn = new CustomMessageListener(2009001) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.ivk = (ArrayList) data;
                d.this.iuI.cdf();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.iuI = postSearchActivity;
        this.iuI.registerListener(this.ivn);
        this.iuI.registerListener(this.ivm);
    }

    public boolean bg(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.fmZ)) {
            cdv();
        }
        switch (i) {
            case 1:
                return Cx(str);
            case 2:
                return Cy(str);
            case 3:
                return Cz(str);
            default:
                return false;
        }
    }

    public boolean Cx(String str) {
        if (this.ivh) {
            return false;
        }
        this.fmZ = str;
        this.ivl = 1;
        this.iuI.sendMessage(yC(this.ivl));
        this.ivh = true;
        return true;
    }

    public boolean Cy(String str) {
        if (this.ivi) {
            return false;
        }
        this.fmZ = str;
        this.ivl = 2;
        this.iuI.sendMessage(yC(this.ivl));
        this.ivi = true;
        return true;
    }

    public boolean Cz(String str) {
        if (this.ivj) {
            return false;
        }
        this.fmZ = str;
        this.ivl = 3;
        this.iuI.sendMessage(yC(this.ivl));
        this.ivj = true;
        return true;
    }

    public void cds() {
        this.iuI.sendMessage(new CustomMessage(2009001));
    }

    public void cdt() {
        if (!StringUtils.isNull(this.fmZ) && !this.fmZ.equals(this.ivb)) {
            this.iuI.sendMessage(new CustomMessage(2009003, this.fmZ));
            this.ivb = this.fmZ;
        }
    }

    public void cdu() {
        if (this.ivk != null) {
            this.ivk.clear();
        }
        this.iuI.sendMessage(new CustomMessage(2009004));
    }

    public void cdv() {
        this.ive = 1;
        this.ivf = 1;
        this.ivg = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdw() {
        if (this.ivk == null) {
            this.ivk = new ArrayList<>();
        }
        this.ivk.remove(this.fmZ);
        this.ivk.add(0, this.fmZ);
        dW(this.ivk);
    }

    private void dW(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage yC(int i) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_POST_SEARCH);
        httpMessage.addParam("word", this.fmZ);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.iuI.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.ivl));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.ive);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.ivf);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.ivg);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yD(int i) {
        switch (i) {
            case 1:
                this.ive++;
                return;
            case 2:
                this.ivf++;
                return;
            case 3:
                this.ivg++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int yE(int i) {
        switch (i) {
            case 1:
                return this.ive;
            case 2:
                return this.ivf;
            case 3:
                return this.ivg;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yF(int i) {
        switch (i) {
            case 1:
                this.ivh = false;
                return;
            case 2:
                this.ivi = false;
                return;
            case 3:
                this.ivj = false;
                return;
            default:
                return;
        }
    }
}
