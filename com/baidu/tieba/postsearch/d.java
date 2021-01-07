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
    private PostSearchActivity mHR;
    private String mIk;
    public ArrayList<String> mIv;
    public int mIl = 0;
    public int mIm = 0;
    public int mIn = 1;
    public int mIo = 1;
    public int mIq = 1;
    public boolean mIr = false;
    public boolean mIt = false;
    public boolean mIu = false;
    private int mIw = 0;
    private final HttpMessageListener mIx = new HttpMessageListener(1003016) { // from class: com.baidu.tieba.postsearch.d.1
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
                    d.this.mHR.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.IL(intValue);
                    d.this.dDu();
                    d.this.dDx();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.mHR.getResources().getString(R.string.neterror);
                }
                d.this.mHR.showToast(errorString);
                d.this.mHR.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener mIy = new CustomMessageListener(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.mIv = (ArrayList) data;
                d.this.mHR.dDg();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.mHR = postSearchActivity;
        this.mHR.registerListener(this.mIy);
        this.mHR.registerListener(this.mIx);
    }

    public boolean bL(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.jcX)) {
            dDw();
        }
        switch (i) {
            case 1:
                return Rc(str);
            case 2:
                return Rd(str);
            case 3:
                return Re(str);
            default:
                return false;
        }
    }

    public boolean Rc(String str) {
        if (this.mIr) {
            return false;
        }
        this.jcX = str;
        this.mIw = 1;
        this.mHR.sendMessage(IK(this.mIw));
        this.mIr = true;
        return true;
    }

    public boolean Rd(String str) {
        if (this.mIt) {
            return false;
        }
        this.jcX = str;
        this.mIw = 2;
        this.mHR.sendMessage(IK(this.mIw));
        this.mIt = true;
        return true;
    }

    public boolean Re(String str) {
        if (this.mIu) {
            return false;
        }
        this.jcX = str;
        this.mIw = 3;
        this.mHR.sendMessage(IK(this.mIw));
        this.mIu = true;
        return true;
    }

    public void dDt() {
        this.mHR.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void dDu() {
        if (!StringUtils.isNull(this.jcX) && !this.jcX.equals(this.mIk)) {
            this.mHR.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.jcX));
            this.mIk = this.jcX;
        }
    }

    public void dDv() {
        if (this.mIv != null) {
            this.mIv.clear();
        }
        this.mHR.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void dDw() {
        this.mIn = 1;
        this.mIo = 1;
        this.mIq = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDx() {
        if (this.mIv == null) {
            this.mIv = new ArrayList<>();
        }
        this.mIv.remove(this.jcX);
        this.mIv.add(0, this.jcX);
        fJ(this.mIv);
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
        httpMessage.addParam("kw", this.mHR.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.mIw));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.mIn);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.mIo);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.mIq);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IL(int i) {
        switch (i) {
            case 1:
                this.mIn++;
                return;
            case 2:
                this.mIo++;
                return;
            case 3:
                this.mIq++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int IM(int i) {
        switch (i) {
            case 1:
                return this.mIn;
            case 2:
                return this.mIo;
            case 3:
                return this.mIq;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IN(int i) {
        switch (i) {
            case 1:
                this.mIr = false;
                return;
            case 2:
                this.mIt = false;
                return;
            case 3:
                this.mIu = false;
                return;
            default:
                return;
        }
    }
}
