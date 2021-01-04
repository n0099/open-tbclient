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
    public String jcX;
    private PostSearchActivity mHS;
    private String mIl;
    public ArrayList<String> mIw;
    public int mIm = 0;
    public int mIn = 0;
    public int mIo = 1;
    public int mIq = 1;
    public int mIr = 1;
    public boolean mIt = false;
    public boolean mIu = false;
    public boolean mIv = false;
    private int mIx = 0;
    private final HttpMessageListener mIy = new HttpMessageListener(1003016) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.IN(intValue);
                boolean z = d.this.IM(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.mHS.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.IL(intValue);
                    d.this.dDt();
                    d.this.dDw();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.mHS.getResources().getString(R.string.neterror);
                }
                d.this.mHS.showToast(errorString);
                d.this.mHS.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener mIz = new CustomMessageListener(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.mIw = (ArrayList) data;
                d.this.mHS.dDf();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.mHS = postSearchActivity;
        this.mHS.registerListener(this.mIz);
        this.mHS.registerListener(this.mIy);
    }

    public boolean bL(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.jcX)) {
            dDv();
        }
        switch (i) {
            case 1:
                return Rd(str);
            case 2:
                return Re(str);
            case 3:
                return Rf(str);
            default:
                return false;
        }
    }

    public boolean Rd(String str) {
        if (this.mIt) {
            return false;
        }
        this.jcX = str;
        this.mIx = 1;
        this.mHS.sendMessage(IK(this.mIx));
        this.mIt = true;
        return true;
    }

    public boolean Re(String str) {
        if (this.mIu) {
            return false;
        }
        this.jcX = str;
        this.mIx = 2;
        this.mHS.sendMessage(IK(this.mIx));
        this.mIu = true;
        return true;
    }

    public boolean Rf(String str) {
        if (this.mIv) {
            return false;
        }
        this.jcX = str;
        this.mIx = 3;
        this.mHS.sendMessage(IK(this.mIx));
        this.mIv = true;
        return true;
    }

    public void dDs() {
        this.mHS.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void dDt() {
        if (!StringUtils.isNull(this.jcX) && !this.jcX.equals(this.mIl)) {
            this.mHS.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.jcX));
            this.mIl = this.jcX;
        }
    }

    public void dDu() {
        if (this.mIw != null) {
            this.mIw.clear();
        }
        this.mHS.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void dDv() {
        this.mIo = 1;
        this.mIq = 1;
        this.mIr = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDw() {
        if (this.mIw == null) {
            this.mIw = new ArrayList<>();
        }
        this.mIw.remove(this.jcX);
        this.mIw.add(0, this.jcX);
        fJ(this.mIw);
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

    private HttpMessage IK(int i) {
        HttpMessage httpMessage = new HttpMessage(1003016);
        httpMessage.addParam("word", this.jcX);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.mHS.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.mIx));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.mIo);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.mIq);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.mIr);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IL(int i) {
        switch (i) {
            case 1:
                this.mIo++;
                return;
            case 2:
                this.mIq++;
                return;
            case 3:
                this.mIr++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int IM(int i) {
        switch (i) {
            case 1:
                return this.mIo;
            case 2:
                return this.mIq;
            case 3:
                return this.mIr;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IN(int i) {
        switch (i) {
            case 1:
                this.mIt = false;
                return;
            case 2:
                this.mIu = false;
                return;
            case 3:
                this.mIv = false;
                return;
            default:
                return;
        }
    }
}
