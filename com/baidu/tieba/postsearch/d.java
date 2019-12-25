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
/* loaded from: classes8.dex */
public class d {
    public String ghc;
    private String jwC;
    public ArrayList<String> jwL;
    private PostSearchActivity jwj;
    public int jwD = 0;
    public int jwE = 0;
    public int jwF = 1;
    public int jwG = 1;
    public int jwH = 1;
    public boolean jwI = false;
    public boolean jwJ = false;
    public boolean jwK = false;
    private int jwM = 0;
    private final HttpMessageListener jwN = new HttpMessageListener(1003016) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.Ap(intValue);
                boolean z = d.this.Ao(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.jwj.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.An(intValue);
                    d.this.cyg();
                    d.this.cyj();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.jwj.getResources().getString(R.string.neterror);
                }
                d.this.jwj.showToast(errorString);
                d.this.jwj.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener jwO = new CustomMessageListener(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.jwL = (ArrayList) data;
                d.this.jwj.cxS();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.jwj = postSearchActivity;
        this.jwj.registerListener(this.jwO);
        this.jwj.registerListener(this.jwN);
    }

    public boolean bn(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.ghc)) {
            cyi();
        }
        switch (i) {
            case 1:
                return GP(str);
            case 2:
                return GQ(str);
            case 3:
                return GR(str);
            default:
                return false;
        }
    }

    public boolean GP(String str) {
        if (this.jwI) {
            return false;
        }
        this.ghc = str;
        this.jwM = 1;
        this.jwj.sendMessage(Am(this.jwM));
        this.jwI = true;
        return true;
    }

    public boolean GQ(String str) {
        if (this.jwJ) {
            return false;
        }
        this.ghc = str;
        this.jwM = 2;
        this.jwj.sendMessage(Am(this.jwM));
        this.jwJ = true;
        return true;
    }

    public boolean GR(String str) {
        if (this.jwK) {
            return false;
        }
        this.ghc = str;
        this.jwM = 3;
        this.jwj.sendMessage(Am(this.jwM));
        this.jwK = true;
        return true;
    }

    public void cyf() {
        this.jwj.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void cyg() {
        if (!StringUtils.isNull(this.ghc) && !this.ghc.equals(this.jwC)) {
            this.jwj.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.ghc));
            this.jwC = this.ghc;
        }
    }

    public void cyh() {
        if (this.jwL != null) {
            this.jwL.clear();
        }
        this.jwj.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void cyi() {
        this.jwF = 1;
        this.jwG = 1;
        this.jwH = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyj() {
        if (this.jwL == null) {
            this.jwL = new ArrayList<>();
        }
        this.jwL.remove(this.ghc);
        this.jwL.add(0, this.ghc);
        ec(this.jwL);
    }

    private void ec(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage Am(int i) {
        HttpMessage httpMessage = new HttpMessage(1003016);
        httpMessage.addParam("word", this.ghc);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.jwj.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.jwM));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.jwF);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.jwG);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.jwH);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void An(int i) {
        switch (i) {
            case 1:
                this.jwF++;
                return;
            case 2:
                this.jwG++;
                return;
            case 3:
                this.jwH++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Ao(int i) {
        switch (i) {
            case 1:
                return this.jwF;
            case 2:
                return this.jwG;
            case 3:
                return this.jwH;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ap(int i) {
        switch (i) {
            case 1:
                this.jwI = false;
                return;
            case 2:
                this.jwJ = false;
                return;
            case 3:
                this.jwK = false;
                return;
            default:
                return;
        }
    }
}
