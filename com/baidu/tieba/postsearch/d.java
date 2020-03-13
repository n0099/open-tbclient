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
    public String gmC;
    private PostSearchActivity jAU;
    private String jBn;
    public ArrayList<String> jBw;
    public int jBo = 0;
    public int jBp = 0;
    public int jBq = 1;
    public int jBr = 1;
    public int jBs = 1;
    public boolean jBt = false;
    public boolean jBu = false;
    public boolean jBv = false;
    private int jBx = 0;
    private final HttpMessageListener jBy = new HttpMessageListener(1003016) { // from class: com.baidu.tieba.postsearch.d.1
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
                    d.this.jAU.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.AC(intValue);
                    d.this.cAN();
                    d.this.cAQ();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.jAU.getResources().getString(R.string.neterror);
                }
                d.this.jAU.showToast(errorString);
                d.this.jAU.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener jBz = new CustomMessageListener(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.jBw = (ArrayList) data;
                d.this.jAU.cAz();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.jAU = postSearchActivity;
        this.jAU.registerListener(this.jBz);
        this.jAU.registerListener(this.jBy);
    }

    public boolean bm(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.gmC)) {
            cAP();
        }
        switch (i) {
            case 1:
                return Ho(str);
            case 2:
                return Hp(str);
            case 3:
                return Hq(str);
            default:
                return false;
        }
    }

    public boolean Ho(String str) {
        if (this.jBt) {
            return false;
        }
        this.gmC = str;
        this.jBx = 1;
        this.jAU.sendMessage(AB(this.jBx));
        this.jBt = true;
        return true;
    }

    public boolean Hp(String str) {
        if (this.jBu) {
            return false;
        }
        this.gmC = str;
        this.jBx = 2;
        this.jAU.sendMessage(AB(this.jBx));
        this.jBu = true;
        return true;
    }

    public boolean Hq(String str) {
        if (this.jBv) {
            return false;
        }
        this.gmC = str;
        this.jBx = 3;
        this.jAU.sendMessage(AB(this.jBx));
        this.jBv = true;
        return true;
    }

    public void cAM() {
        this.jAU.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void cAN() {
        if (!StringUtils.isNull(this.gmC) && !this.gmC.equals(this.jBn)) {
            this.jAU.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.gmC));
            this.jBn = this.gmC;
        }
    }

    public void cAO() {
        if (this.jBw != null) {
            this.jBw.clear();
        }
        this.jAU.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void cAP() {
        this.jBq = 1;
        this.jBr = 1;
        this.jBs = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAQ() {
        if (this.jBw == null) {
            this.jBw = new ArrayList<>();
        }
        this.jBw.remove(this.gmC);
        this.jBw.add(0, this.gmC);
        dZ(this.jBw);
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
        httpMessage.addParam("word", this.gmC);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.jAU.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.jBx));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.jBq);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.jBr);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.jBs);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AC(int i) {
        switch (i) {
            case 1:
                this.jBq++;
                return;
            case 2:
                this.jBr++;
                return;
            case 3:
                this.jBs++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int AD(int i) {
        switch (i) {
            case 1:
                return this.jBq;
            case 2:
                return this.jBr;
            case 3:
                return this.jBs;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AE(int i) {
        switch (i) {
            case 1:
                this.jBt = false;
                return;
            case 2:
                this.jBu = false;
                return;
            case 3:
                this.jBv = false;
                return;
            default:
                return;
        }
    }
}
