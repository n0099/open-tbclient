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
    public String gmp;
    private PostSearchActivity jAI;
    private String jBb;
    public ArrayList<String> jBk;
    public int jBc = 0;
    public int jBd = 0;
    public int jBe = 1;
    public int jBf = 1;
    public int jBg = 1;
    public boolean jBh = false;
    public boolean jBi = false;
    public boolean jBj = false;
    private int jBl = 0;
    private final HttpMessageListener jBm = new HttpMessageListener(1003016) { // from class: com.baidu.tieba.postsearch.d.1
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
                    d.this.jAI.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.AC(intValue);
                    d.this.cAM();
                    d.this.cAP();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.jAI.getResources().getString(R.string.neterror);
                }
                d.this.jAI.showToast(errorString);
                d.this.jAI.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener jBn = new CustomMessageListener(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.jBk = (ArrayList) data;
                d.this.jAI.cAy();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.jAI = postSearchActivity;
        this.jAI.registerListener(this.jBn);
        this.jAI.registerListener(this.jBm);
    }

    public boolean bm(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.gmp)) {
            cAO();
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
        if (this.jBh) {
            return false;
        }
        this.gmp = str;
        this.jBl = 1;
        this.jAI.sendMessage(AB(this.jBl));
        this.jBh = true;
        return true;
    }

    public boolean Ho(String str) {
        if (this.jBi) {
            return false;
        }
        this.gmp = str;
        this.jBl = 2;
        this.jAI.sendMessage(AB(this.jBl));
        this.jBi = true;
        return true;
    }

    public boolean Hp(String str) {
        if (this.jBj) {
            return false;
        }
        this.gmp = str;
        this.jBl = 3;
        this.jAI.sendMessage(AB(this.jBl));
        this.jBj = true;
        return true;
    }

    public void cAL() {
        this.jAI.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void cAM() {
        if (!StringUtils.isNull(this.gmp) && !this.gmp.equals(this.jBb)) {
            this.jAI.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.gmp));
            this.jBb = this.gmp;
        }
    }

    public void cAN() {
        if (this.jBk != null) {
            this.jBk.clear();
        }
        this.jAI.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void cAO() {
        this.jBe = 1;
        this.jBf = 1;
        this.jBg = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAP() {
        if (this.jBk == null) {
            this.jBk = new ArrayList<>();
        }
        this.jBk.remove(this.gmp);
        this.jBk.add(0, this.gmp);
        dZ(this.jBk);
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
        httpMessage.addParam("word", this.gmp);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.jAI.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.jBl));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.jBe);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.jBf);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.jBg);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AC(int i) {
        switch (i) {
            case 1:
                this.jBe++;
                return;
            case 2:
                this.jBf++;
                return;
            case 3:
                this.jBg++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int AD(int i) {
        switch (i) {
            case 1:
                return this.jBe;
            case 2:
                return this.jBf;
            case 3:
                return this.jBg;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AE(int i) {
        switch (i) {
            case 1:
                this.jBh = false;
                return;
            case 2:
                this.jBi = false;
                return;
            case 3:
                this.jBj = false;
                return;
            default:
                return;
        }
    }
}
