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
    public String gmn;
    private PostSearchActivity jAG;
    private String jAZ;
    public ArrayList<String> jBi;
    public int jBa = 0;
    public int jBb = 0;
    public int jBc = 1;
    public int jBd = 1;
    public int jBe = 1;
    public boolean jBf = false;
    public boolean jBg = false;
    public boolean jBh = false;
    private int jBj = 0;
    private final HttpMessageListener jBk = new HttpMessageListener(1003016) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.AE(intValue);
                boolean z = d.this.AD(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.jAG.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.AC(intValue);
                    d.this.cAK();
                    d.this.cAN();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.jAG.getResources().getString(R.string.neterror);
                }
                d.this.jAG.showToast(errorString);
                d.this.jAG.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener jBl = new CustomMessageListener(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.jBi = (ArrayList) data;
                d.this.jAG.cAw();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.jAG = postSearchActivity;
        this.jAG.registerListener(this.jBl);
        this.jAG.registerListener(this.jBk);
    }

    public boolean bm(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.gmn)) {
            cAM();
        }
        switch (i) {
            case 1:
                return Hn(str);
            case 2:
                return Ho(str);
            case 3:
                return Hp(str);
            default:
                return false;
        }
    }

    public boolean Hn(String str) {
        if (this.jBf) {
            return false;
        }
        this.gmn = str;
        this.jBj = 1;
        this.jAG.sendMessage(AB(this.jBj));
        this.jBf = true;
        return true;
    }

    public boolean Ho(String str) {
        if (this.jBg) {
            return false;
        }
        this.gmn = str;
        this.jBj = 2;
        this.jAG.sendMessage(AB(this.jBj));
        this.jBg = true;
        return true;
    }

    public boolean Hp(String str) {
        if (this.jBh) {
            return false;
        }
        this.gmn = str;
        this.jBj = 3;
        this.jAG.sendMessage(AB(this.jBj));
        this.jBh = true;
        return true;
    }

    public void cAJ() {
        this.jAG.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void cAK() {
        if (!StringUtils.isNull(this.gmn) && !this.gmn.equals(this.jAZ)) {
            this.jAG.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.gmn));
            this.jAZ = this.gmn;
        }
    }

    public void cAL() {
        if (this.jBi != null) {
            this.jBi.clear();
        }
        this.jAG.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void cAM() {
        this.jBc = 1;
        this.jBd = 1;
        this.jBe = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAN() {
        if (this.jBi == null) {
            this.jBi = new ArrayList<>();
        }
        this.jBi.remove(this.gmn);
        this.jBi.add(0, this.gmn);
        dZ(this.jBi);
    }

    private void dZ(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage AB(int i) {
        HttpMessage httpMessage = new HttpMessage(1003016);
        httpMessage.addParam("word", this.gmn);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.jAG.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.jBj));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.jBc);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.jBd);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.jBe);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AC(int i) {
        switch (i) {
            case 1:
                this.jBc++;
                return;
            case 2:
                this.jBd++;
                return;
            case 3:
                this.jBe++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int AD(int i) {
        switch (i) {
            case 1:
                return this.jBc;
            case 2:
                return this.jBd;
            case 3:
                return this.jBe;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AE(int i) {
        switch (i) {
            case 1:
                this.jBf = false;
                return;
            case 2:
                this.jBg = false;
                return;
            case 3:
                this.jBh = false;
                return;
            default:
                return;
        }
    }
}
