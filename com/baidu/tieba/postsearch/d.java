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
    private PostSearchActivity iuH;
    private String iva;
    public ArrayList<String> ivj;
    public int ivb = 0;
    public int ivc = 0;
    public int ivd = 1;
    public int ive = 1;
    public int ivf = 1;
    public boolean ivg = false;
    public boolean ivh = false;
    public boolean ivi = false;
    private int ivk = 0;
    private final HttpMessageListener ivl = new HttpMessageListener(CmdConfigHttp.CMD_POST_SEARCH) { // from class: com.baidu.tieba.postsearch.d.1
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
                    d.this.iuH.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.yD(intValue);
                    d.this.cds();
                    d.this.cdv();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.iuH.getResources().getString(R.string.neterror);
                }
                d.this.iuH.showToast(errorString);
                d.this.iuH.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener ivm = new CustomMessageListener(2009001) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.ivj = (ArrayList) data;
                d.this.iuH.cde();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.iuH = postSearchActivity;
        this.iuH.registerListener(this.ivm);
        this.iuH.registerListener(this.ivl);
    }

    public boolean bg(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.fmZ)) {
            cdu();
        }
        switch (i) {
            case 1:
                return Cv(str);
            case 2:
                return Cw(str);
            case 3:
                return Cx(str);
            default:
                return false;
        }
    }

    public boolean Cv(String str) {
        if (this.ivg) {
            return false;
        }
        this.fmZ = str;
        this.ivk = 1;
        this.iuH.sendMessage(yC(this.ivk));
        this.ivg = true;
        return true;
    }

    public boolean Cw(String str) {
        if (this.ivh) {
            return false;
        }
        this.fmZ = str;
        this.ivk = 2;
        this.iuH.sendMessage(yC(this.ivk));
        this.ivh = true;
        return true;
    }

    public boolean Cx(String str) {
        if (this.ivi) {
            return false;
        }
        this.fmZ = str;
        this.ivk = 3;
        this.iuH.sendMessage(yC(this.ivk));
        this.ivi = true;
        return true;
    }

    public void cdr() {
        this.iuH.sendMessage(new CustomMessage(2009001));
    }

    public void cds() {
        if (!StringUtils.isNull(this.fmZ) && !this.fmZ.equals(this.iva)) {
            this.iuH.sendMessage(new CustomMessage(2009003, this.fmZ));
            this.iva = this.fmZ;
        }
    }

    public void cdt() {
        if (this.ivj != null) {
            this.ivj.clear();
        }
        this.iuH.sendMessage(new CustomMessage(2009004));
    }

    public void cdu() {
        this.ivd = 1;
        this.ive = 1;
        this.ivf = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdv() {
        if (this.ivj == null) {
            this.ivj = new ArrayList<>();
        }
        this.ivj.remove(this.fmZ);
        this.ivj.add(0, this.fmZ);
        dW(this.ivj);
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
        httpMessage.addParam("kw", this.iuH.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.ivk));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.ivd);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.ive);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.ivf);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yD(int i) {
        switch (i) {
            case 1:
                this.ivd++;
                return;
            case 2:
                this.ive++;
                return;
            case 3:
                this.ivf++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int yE(int i) {
        switch (i) {
            case 1:
                return this.ivd;
            case 2:
                return this.ive;
            case 3:
                return this.ivf;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yF(int i) {
        switch (i) {
            case 1:
                this.ivg = false;
                return;
            case 2:
                this.ivh = false;
                return;
            case 3:
                this.ivi = false;
                return;
            default:
                return;
        }
    }
}
