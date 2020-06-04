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
    public String hlt;
    private PostSearchActivity kFF;
    private String kFY;
    public ArrayList<String> kGh;
    public int kFZ = 0;
    public int kGa = 0;
    public int kGb = 1;
    public int kGc = 1;
    public int kGd = 1;
    public boolean kGe = false;
    public boolean kGf = false;
    public boolean kGg = false;
    private int kGi = 0;
    private final HttpMessageListener kGj = new HttpMessageListener(1003016) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.BY(intValue);
                boolean z = d.this.BX(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.kFF.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.BW(intValue);
                    d.this.cTg();
                    d.this.cTj();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.kFF.getResources().getString(R.string.neterror);
                }
                d.this.kFF.showToast(errorString);
                d.this.kFF.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener kGk = new CustomMessageListener(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.kGh = (ArrayList) data;
                d.this.kFF.cSS();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.kFF = postSearchActivity;
        this.kFF.registerListener(this.kGk);
        this.kFF.registerListener(this.kGj);
    }

    public boolean bx(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.hlt)) {
            cTi();
        }
        switch (i) {
            case 1:
                return KL(str);
            case 2:
                return KM(str);
            case 3:
                return KN(str);
            default:
                return false;
        }
    }

    public boolean KL(String str) {
        if (this.kGe) {
            return false;
        }
        this.hlt = str;
        this.kGi = 1;
        this.kFF.sendMessage(BV(this.kGi));
        this.kGe = true;
        return true;
    }

    public boolean KM(String str) {
        if (this.kGf) {
            return false;
        }
        this.hlt = str;
        this.kGi = 2;
        this.kFF.sendMessage(BV(this.kGi));
        this.kGf = true;
        return true;
    }

    public boolean KN(String str) {
        if (this.kGg) {
            return false;
        }
        this.hlt = str;
        this.kGi = 3;
        this.kFF.sendMessage(BV(this.kGi));
        this.kGg = true;
        return true;
    }

    public void cTf() {
        this.kFF.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void cTg() {
        if (!StringUtils.isNull(this.hlt) && !this.hlt.equals(this.kFY)) {
            this.kFF.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.hlt));
            this.kFY = this.hlt;
        }
    }

    public void cTh() {
        if (this.kGh != null) {
            this.kGh.clear();
        }
        this.kFF.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void cTi() {
        this.kGb = 1;
        this.kGc = 1;
        this.kGd = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTj() {
        if (this.kGh == null) {
            this.kGh = new ArrayList<>();
        }
        this.kGh.remove(this.hlt);
        this.kGh.add(0, this.hlt);
        et(this.kGh);
    }

    private void et(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage BV(int i) {
        HttpMessage httpMessage = new HttpMessage(1003016);
        httpMessage.addParam("word", this.hlt);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.kFF.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.kGi));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.kGb);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.kGc);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.kGd);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BW(int i) {
        switch (i) {
            case 1:
                this.kGb++;
                return;
            case 2:
                this.kGc++;
                return;
            case 3:
                this.kGd++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int BX(int i) {
        switch (i) {
            case 1:
                return this.kGb;
            case 2:
                return this.kGc;
            case 3:
                return this.kGd;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BY(int i) {
        switch (i) {
            case 1:
                this.kGe = false;
                return;
            case 2:
                this.kGf = false;
                return;
            case 3:
                this.kGg = false;
                return;
            default:
                return;
        }
    }
}
