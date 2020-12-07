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
    public String iQJ;
    private String mCR;
    private PostSearchActivity mCz;
    public ArrayList<String> mDa;
    public int mCS = 0;
    public int mCT = 0;
    public int mCU = 1;
    public int mCV = 1;
    public int mCW = 1;
    public boolean mCX = false;
    public boolean mCY = false;
    public boolean mCZ = false;
    private int mDc = 0;
    private final HttpMessageListener mDd = new HttpMessageListener(1003016) { // from class: com.baidu.tieba.postsearch.d.1
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
                    d.this.mCz.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.IR(intValue);
                    d.this.dDD();
                    d.this.dDG();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.mCz.getResources().getString(R.string.neterror);
                }
                d.this.mCz.showToast(errorString);
                d.this.mCz.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener mDe = new CustomMessageListener(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.mDa = (ArrayList) data;
                d.this.mCz.dDp();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.mCz = postSearchActivity;
        this.mCz.registerListener(this.mDe);
        this.mCz.registerListener(this.mDd);
    }

    public boolean bE(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.iQJ)) {
            dDF();
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
        if (this.mCX) {
            return false;
        }
        this.iQJ = str;
        this.mDc = 1;
        this.mCz.sendMessage(IQ(this.mDc));
        this.mCX = true;
        return true;
    }

    public boolean Ry(String str) {
        if (this.mCY) {
            return false;
        }
        this.iQJ = str;
        this.mDc = 2;
        this.mCz.sendMessage(IQ(this.mDc));
        this.mCY = true;
        return true;
    }

    public boolean Rz(String str) {
        if (this.mCZ) {
            return false;
        }
        this.iQJ = str;
        this.mDc = 3;
        this.mCz.sendMessage(IQ(this.mDc));
        this.mCZ = true;
        return true;
    }

    public void dDC() {
        this.mCz.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void dDD() {
        if (!StringUtils.isNull(this.iQJ) && !this.iQJ.equals(this.mCR)) {
            this.mCz.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.iQJ));
            this.mCR = this.iQJ;
        }
    }

    public void dDE() {
        if (this.mDa != null) {
            this.mDa.clear();
        }
        this.mCz.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void dDF() {
        this.mCU = 1;
        this.mCV = 1;
        this.mCW = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDG() {
        if (this.mDa == null) {
            this.mDa = new ArrayList<>();
        }
        this.mDa.remove(this.iQJ);
        this.mDa.add(0, this.iQJ);
        fJ(this.mDa);
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
        httpMessage.addParam("word", this.iQJ);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.mCz.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.mDc));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.mCU);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.mCV);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.mCW);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IR(int i) {
        switch (i) {
            case 1:
                this.mCU++;
                return;
            case 2:
                this.mCV++;
                return;
            case 3:
                this.mCW++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int IS(int i) {
        switch (i) {
            case 1:
                return this.mCU;
            case 2:
                return this.mCV;
            case 3:
                return this.mCW;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IT(int i) {
        switch (i) {
            case 1:
                this.mCX = false;
                return;
            case 2:
                this.mCY = false;
                return;
            case 3:
                this.mCZ = false;
                return;
            default:
                return;
        }
    }
}
