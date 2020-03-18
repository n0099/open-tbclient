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
    public String gnk;
    private String jCM;
    public ArrayList<String> jCV;
    private PostSearchActivity jCt;
    public int jCN = 0;
    public int jCO = 0;
    public int jCP = 1;
    public int jCQ = 1;
    public int jCR = 1;
    public boolean jCS = false;
    public boolean jCT = false;
    public boolean jCU = false;
    private int jCW = 0;
    private final HttpMessageListener jCX = new HttpMessageListener(1003016) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.AM(intValue);
                boolean z = d.this.AL(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.jCt.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.AK(intValue);
                    d.this.cBh();
                    d.this.cBk();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.jCt.getResources().getString(R.string.neterror);
                }
                d.this.jCt.showToast(errorString);
                d.this.jCt.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener jCY = new CustomMessageListener(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.jCV = (ArrayList) data;
                d.this.jCt.cAT();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.jCt = postSearchActivity;
        this.jCt.registerListener(this.jCY);
        this.jCt.registerListener(this.jCX);
    }

    public boolean bm(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.gnk)) {
            cBj();
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
        if (this.jCS) {
            return false;
        }
        this.gnk = str;
        this.jCW = 1;
        this.jCt.sendMessage(AJ(this.jCW));
        this.jCS = true;
        return true;
    }

    public boolean Ho(String str) {
        if (this.jCT) {
            return false;
        }
        this.gnk = str;
        this.jCW = 2;
        this.jCt.sendMessage(AJ(this.jCW));
        this.jCT = true;
        return true;
    }

    public boolean Hp(String str) {
        if (this.jCU) {
            return false;
        }
        this.gnk = str;
        this.jCW = 3;
        this.jCt.sendMessage(AJ(this.jCW));
        this.jCU = true;
        return true;
    }

    public void cBg() {
        this.jCt.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void cBh() {
        if (!StringUtils.isNull(this.gnk) && !this.gnk.equals(this.jCM)) {
            this.jCt.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.gnk));
            this.jCM = this.gnk;
        }
    }

    public void cBi() {
        if (this.jCV != null) {
            this.jCV.clear();
        }
        this.jCt.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void cBj() {
        this.jCP = 1;
        this.jCQ = 1;
        this.jCR = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBk() {
        if (this.jCV == null) {
            this.jCV = new ArrayList<>();
        }
        this.jCV.remove(this.gnk);
        this.jCV.add(0, this.gnk);
        dZ(this.jCV);
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

    private HttpMessage AJ(int i) {
        HttpMessage httpMessage = new HttpMessage(1003016);
        httpMessage.addParam("word", this.gnk);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.jCt.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.jCW));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.jCP);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.jCQ);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.jCR);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AK(int i) {
        switch (i) {
            case 1:
                this.jCP++;
                return;
            case 2:
                this.jCQ++;
                return;
            case 3:
                this.jCR++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int AL(int i) {
        switch (i) {
            case 1:
                return this.jCP;
            case 2:
                return this.jCQ;
            case 3:
                return this.jCR;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AM(int i) {
        switch (i) {
            case 1:
                this.jCS = false;
                return;
            case 2:
                this.jCT = false;
                return;
            case 3:
                this.jCU = false;
                return;
            default:
                return;
        }
    }
}
