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
/* loaded from: classes7.dex */
public class d {
    public String iYq;
    private String mDE;
    public ArrayList<String> mDN;
    private PostSearchActivity mDk;
    public int mDF = 0;
    public int mDG = 0;
    public int mDH = 1;
    public int mDI = 1;
    public int mDJ = 1;
    public boolean mDK = false;
    public boolean mDL = false;
    public boolean mDM = false;
    private int mDO = 0;
    private final HttpMessageListener mDP = new HttpMessageListener(1003016) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.Hg(intValue);
                boolean z = d.this.Hf(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.mDk.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.He(intValue);
                    d.this.dzC();
                    d.this.dzF();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.mDk.getResources().getString(R.string.neterror);
                }
                d.this.mDk.showToast(errorString);
                d.this.mDk.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener mDQ = new CustomMessageListener(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.mDN = (ArrayList) data;
                d.this.mDk.dzo();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.mDk = postSearchActivity;
        this.mDk.registerListener(this.mDQ);
        this.mDk.registerListener(this.mDP);
    }

    public boolean bM(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.iYq)) {
            dzE();
        }
        switch (i) {
            case 1:
                return PV(str);
            case 2:
                return PW(str);
            case 3:
                return PX(str);
            default:
                return false;
        }
    }

    public boolean PV(String str) {
        if (this.mDK) {
            return false;
        }
        this.iYq = str;
        this.mDO = 1;
        this.mDk.sendMessage(Hd(this.mDO));
        this.mDK = true;
        return true;
    }

    public boolean PW(String str) {
        if (this.mDL) {
            return false;
        }
        this.iYq = str;
        this.mDO = 2;
        this.mDk.sendMessage(Hd(this.mDO));
        this.mDL = true;
        return true;
    }

    public boolean PX(String str) {
        if (this.mDM) {
            return false;
        }
        this.iYq = str;
        this.mDO = 3;
        this.mDk.sendMessage(Hd(this.mDO));
        this.mDM = true;
        return true;
    }

    public void dzB() {
        this.mDk.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void dzC() {
        if (!StringUtils.isNull(this.iYq) && !this.iYq.equals(this.mDE)) {
            this.mDk.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.iYq));
            this.mDE = this.iYq;
        }
    }

    public void dzD() {
        if (this.mDN != null) {
            this.mDN.clear();
        }
        this.mDk.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void dzE() {
        this.mDH = 1;
        this.mDI = 1;
        this.mDJ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzF() {
        if (this.mDN == null) {
            this.mDN = new ArrayList<>();
        }
        this.mDN.remove(this.iYq);
        this.mDN.add(0, this.iYq);
        fJ(this.mDN);
    }

    private void fJ(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage Hd(int i) {
        HttpMessage httpMessage = new HttpMessage(1003016);
        httpMessage.addParam("word", this.iYq);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.mDk.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.mDO));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.mDH);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.mDI);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.mDJ);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void He(int i) {
        switch (i) {
            case 1:
                this.mDH++;
                return;
            case 2:
                this.mDI++;
                return;
            case 3:
                this.mDJ++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Hf(int i) {
        switch (i) {
            case 1:
                return this.mDH;
            case 2:
                return this.mDI;
            case 3:
                return this.mDJ;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hg(int i) {
        switch (i) {
            case 1:
                this.mDK = false;
                return;
            case 2:
                this.mDL = false;
                return;
            case 3:
                this.mDM = false;
                return;
            default:
                return;
        }
    }
}
