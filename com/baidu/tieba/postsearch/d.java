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
public class d {
    public String dhV;
    private String gjC;
    public ArrayList<String> gjL;
    private PostSearchActivity gjj;
    public int gjD = 0;
    public int gjE = 0;
    public int gjF = 1;
    public int gjG = 1;
    public int gjH = 1;
    public boolean gjI = false;
    public boolean gjJ = false;
    public boolean gjK = false;
    private int gjM = 0;
    private final HttpMessageListener gjN = new HttpMessageListener(CmdConfigHttp.CMD_POST_SEARCH) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.rU(intValue);
                boolean z = d.this.rT(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.gjj.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.rS(intValue);
                    d.this.bnJ();
                    d.this.bnM();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.gjj.getResources().getString(d.k.neterror);
                }
                d.this.gjj.showToast(errorString);
                d.this.gjj.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener gjO = new CustomMessageListener(2009001) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.gjL = (ArrayList) data;
                d.this.gjj.bnv();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.gjj = postSearchActivity;
        this.gjj.registerListener(this.gjO);
        this.gjj.registerListener(this.gjN);
    }

    public boolean aI(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.dhV)) {
            bnL();
        }
        switch (i) {
            case 1:
                return sx(str);
            case 2:
                return sy(str);
            case 3:
                return sz(str);
            default:
                return false;
        }
    }

    public boolean sx(String str) {
        if (this.gjI) {
            return false;
        }
        this.dhV = str;
        this.gjM = 1;
        this.gjj.sendMessage(rR(this.gjM));
        this.gjI = true;
        return true;
    }

    public boolean sy(String str) {
        if (this.gjJ) {
            return false;
        }
        this.dhV = str;
        this.gjM = 2;
        this.gjj.sendMessage(rR(this.gjM));
        this.gjJ = true;
        return true;
    }

    public boolean sz(String str) {
        if (this.gjK) {
            return false;
        }
        this.dhV = str;
        this.gjM = 3;
        this.gjj.sendMessage(rR(this.gjM));
        this.gjK = true;
        return true;
    }

    public void bnI() {
        this.gjj.sendMessage(new CustomMessage(2009001));
    }

    public void bnJ() {
        if (!StringUtils.isNull(this.dhV) && !this.dhV.equals(this.gjC)) {
            this.gjj.sendMessage(new CustomMessage(2009003, this.dhV));
            this.gjC = this.dhV;
        }
    }

    public void bnK() {
        if (this.gjL != null) {
            this.gjL.clear();
        }
        this.gjj.sendMessage(new CustomMessage(2009004));
    }

    public void bnL() {
        this.gjF = 1;
        this.gjG = 1;
        this.gjH = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnM() {
        if (this.gjL == null) {
            this.gjL = new ArrayList<>();
        }
        this.gjL.remove(this.dhV);
        this.gjL.add(0, this.dhV);
        dm(this.gjL);
    }

    private void dm(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage rR(int i) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_POST_SEARCH);
        httpMessage.addParam("word", this.dhV);
        httpMessage.addParam(LegoListActivityConfig.RN, 30);
        httpMessage.addParam("kw", this.gjj.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.gjM));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam("pn", this.gjF);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam("pn", this.gjG);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam("pn", this.gjH);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rS(int i) {
        switch (i) {
            case 1:
                this.gjF++;
                return;
            case 2:
                this.gjG++;
                return;
            case 3:
                this.gjH++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int rT(int i) {
        switch (i) {
            case 1:
                return this.gjF;
            case 2:
                return this.gjG;
            case 3:
                return this.gjH;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rU(int i) {
        switch (i) {
            case 1:
                this.gjI = false;
                return;
            case 2:
                this.gjJ = false;
                return;
            case 3:
                this.gjK = false;
                return;
            default:
                return;
        }
    }
}
