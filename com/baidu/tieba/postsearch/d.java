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
/* loaded from: classes24.dex */
public class d {
    public String iQL;
    private PostSearchActivity mCB;
    private String mCT;
    public ArrayList<String> mDd;
    public int mCU = 0;
    public int mCV = 0;
    public int mCW = 1;
    public int mCX = 1;
    public int mCY = 1;
    public boolean mCZ = false;
    public boolean mDa = false;
    public boolean mDc = false;
    private int mDe = 0;
    private final HttpMessageListener mDf = new HttpMessageListener(1003016) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.IT(intValue);
                boolean z = d.this.IS(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.mCB.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.IR(intValue);
                    d.this.dDE();
                    d.this.dDH();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.mCB.getResources().getString(R.string.neterror);
                }
                d.this.mCB.showToast(errorString);
                d.this.mCB.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener mDg = new CustomMessageListener(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.mDd = (ArrayList) data;
                d.this.mCB.dDq();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.mCB = postSearchActivity;
        this.mCB.registerListener(this.mDg);
        this.mCB.registerListener(this.mDf);
    }

    public boolean bE(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.iQL)) {
            dDG();
        }
        switch (i) {
            case 1:
                return Rx(str);
            case 2:
                return Ry(str);
            case 3:
                return Rz(str);
            default:
                return false;
        }
    }

    public boolean Rx(String str) {
        if (this.mCZ) {
            return false;
        }
        this.iQL = str;
        this.mDe = 1;
        this.mCB.sendMessage(IQ(this.mDe));
        this.mCZ = true;
        return true;
    }

    public boolean Ry(String str) {
        if (this.mDa) {
            return false;
        }
        this.iQL = str;
        this.mDe = 2;
        this.mCB.sendMessage(IQ(this.mDe));
        this.mDa = true;
        return true;
    }

    public boolean Rz(String str) {
        if (this.mDc) {
            return false;
        }
        this.iQL = str;
        this.mDe = 3;
        this.mCB.sendMessage(IQ(this.mDe));
        this.mDc = true;
        return true;
    }

    public void dDD() {
        this.mCB.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void dDE() {
        if (!StringUtils.isNull(this.iQL) && !this.iQL.equals(this.mCT)) {
            this.mCB.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.iQL));
            this.mCT = this.iQL;
        }
    }

    public void dDF() {
        if (this.mDd != null) {
            this.mDd.clear();
        }
        this.mCB.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void dDG() {
        this.mCW = 1;
        this.mCX = 1;
        this.mCY = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDH() {
        if (this.mDd == null) {
            this.mDd = new ArrayList<>();
        }
        this.mDd.remove(this.iQL);
        this.mDd.add(0, this.iQL);
        fJ(this.mDd);
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

    private HttpMessage IQ(int i) {
        HttpMessage httpMessage = new HttpMessage(1003016);
        httpMessage.addParam("word", this.iQL);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.mCB.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.mDe));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.mCW);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.mCX);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.mCY);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IR(int i) {
        switch (i) {
            case 1:
                this.mCW++;
                return;
            case 2:
                this.mCX++;
                return;
            case 3:
                this.mCY++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int IS(int i) {
        switch (i) {
            case 1:
                return this.mCW;
            case 2:
                return this.mCX;
            case 3:
                return this.mCY;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IT(int i) {
        switch (i) {
            case 1:
                this.mCZ = false;
                return;
            case 2:
                this.mDa = false;
                return;
            case 3:
                this.mDc = false;
                return;
            default:
                return;
        }
    }
}
