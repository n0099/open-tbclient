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
    public String fmY;
    private PostSearchActivity iuE;
    private String iuX;
    public ArrayList<String> ivg;
    public int iuY = 0;
    public int iuZ = 0;
    public int iva = 1;
    public int ivb = 1;
    public int ivc = 1;
    public boolean ivd = false;
    public boolean ive = false;
    public boolean ivf = false;
    private int ivh = 0;
    private final HttpMessageListener ivi = new HttpMessageListener(CmdConfigHttp.CMD_POST_SEARCH) { // from class: com.baidu.tieba.postsearch.d.1
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
                    d.this.iuE.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.yD(intValue);
                    d.this.cdp();
                    d.this.cds();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.iuE.getResources().getString(R.string.neterror);
                }
                d.this.iuE.showToast(errorString);
                d.this.iuE.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener ivj = new CustomMessageListener(2009001) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.ivg = (ArrayList) data;
                d.this.iuE.cdb();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.iuE = postSearchActivity;
        this.iuE.registerListener(this.ivj);
        this.iuE.registerListener(this.ivi);
    }

    public boolean bg(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.fmY)) {
            cdr();
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
        if (this.ivd) {
            return false;
        }
        this.fmY = str;
        this.ivh = 1;
        this.iuE.sendMessage(yC(this.ivh));
        this.ivd = true;
        return true;
    }

    public boolean Cw(String str) {
        if (this.ive) {
            return false;
        }
        this.fmY = str;
        this.ivh = 2;
        this.iuE.sendMessage(yC(this.ivh));
        this.ive = true;
        return true;
    }

    public boolean Cx(String str) {
        if (this.ivf) {
            return false;
        }
        this.fmY = str;
        this.ivh = 3;
        this.iuE.sendMessage(yC(this.ivh));
        this.ivf = true;
        return true;
    }

    public void cdo() {
        this.iuE.sendMessage(new CustomMessage(2009001));
    }

    public void cdp() {
        if (!StringUtils.isNull(this.fmY) && !this.fmY.equals(this.iuX)) {
            this.iuE.sendMessage(new CustomMessage(2009003, this.fmY));
            this.iuX = this.fmY;
        }
    }

    public void cdq() {
        if (this.ivg != null) {
            this.ivg.clear();
        }
        this.iuE.sendMessage(new CustomMessage(2009004));
    }

    public void cdr() {
        this.iva = 1;
        this.ivb = 1;
        this.ivc = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cds() {
        if (this.ivg == null) {
            this.ivg = new ArrayList<>();
        }
        this.ivg.remove(this.fmY);
        this.ivg.add(0, this.fmY);
        dW(this.ivg);
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
        httpMessage.addParam("word", this.fmY);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.iuE.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.ivh));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.iva);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.ivb);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.ivc);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yD(int i) {
        switch (i) {
            case 1:
                this.iva++;
                return;
            case 2:
                this.ivb++;
                return;
            case 3:
                this.ivc++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int yE(int i) {
        switch (i) {
            case 1:
                return this.iva;
            case 2:
                return this.ivb;
            case 3:
                return this.ivc;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yF(int i) {
        switch (i) {
            case 1:
                this.ivd = false;
                return;
            case 2:
                this.ive = false;
                return;
            case 3:
                this.ivf = false;
                return;
            default:
                return;
        }
    }
}
