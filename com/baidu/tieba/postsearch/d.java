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
    public String jel;
    private PostSearchActivity mMG;
    private String mMY;
    public ArrayList<String> mNh;
    public int mMZ = 0;
    public int mNa = 0;
    public int mNb = 1;
    public int mNc = 1;
    public int mNd = 1;
    public boolean mNe = false;
    public boolean mNf = false;
    public boolean mNg = false;
    private int mNi = 0;
    private final HttpMessageListener mNj = new HttpMessageListener(1003016) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.Hy(intValue);
                boolean z = d.this.Hx(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.mMG.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.Hw(intValue);
                    d.this.dBT();
                    d.this.dBW();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.mMG.getResources().getString(R.string.neterror);
                }
                d.this.mMG.showToast(errorString);
                d.this.mMG.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener mNk = new CustomMessageListener(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.mNh = (ArrayList) data;
                d.this.mMG.dBF();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.mMG = postSearchActivity;
        this.mMG.registerListener(this.mNk);
        this.mMG.registerListener(this.mNj);
    }

    public boolean bM(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.jel)) {
            dBV();
        }
        switch (i) {
            case 1:
                return QN(str);
            case 2:
                return QO(str);
            case 3:
                return QP(str);
            default:
                return false;
        }
    }

    public boolean QN(String str) {
        if (this.mNe) {
            return false;
        }
        this.jel = str;
        this.mNi = 1;
        this.mMG.sendMessage(Hv(this.mNi));
        this.mNe = true;
        return true;
    }

    public boolean QO(String str) {
        if (this.mNf) {
            return false;
        }
        this.jel = str;
        this.mNi = 2;
        this.mMG.sendMessage(Hv(this.mNi));
        this.mNf = true;
        return true;
    }

    public boolean QP(String str) {
        if (this.mNg) {
            return false;
        }
        this.jel = str;
        this.mNi = 3;
        this.mMG.sendMessage(Hv(this.mNi));
        this.mNg = true;
        return true;
    }

    public void dBS() {
        this.mMG.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void dBT() {
        if (!StringUtils.isNull(this.jel) && !this.jel.equals(this.mMY)) {
            this.mMG.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.jel));
            this.mMY = this.jel;
        }
    }

    public void dBU() {
        if (this.mNh != null) {
            this.mNh.clear();
        }
        this.mMG.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void dBV() {
        this.mNb = 1;
        this.mNc = 1;
        this.mNd = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBW() {
        if (this.mNh == null) {
            this.mNh = new ArrayList<>();
        }
        this.mNh.remove(this.jel);
        this.mNh.add(0, this.jel);
        fH(this.mNh);
    }

    private void fH(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage Hv(int i) {
        HttpMessage httpMessage = new HttpMessage(1003016);
        httpMessage.addParam("word", this.jel);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.mMG.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.mNi));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.mNb);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.mNc);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.mNd);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hw(int i) {
        switch (i) {
            case 1:
                this.mNb++;
                return;
            case 2:
                this.mNc++;
                return;
            case 3:
                this.mNd++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Hx(int i) {
        switch (i) {
            case 1:
                return this.mNb;
            case 2:
                return this.mNc;
            case 3:
                return this.mNd;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hy(int i) {
        switch (i) {
            case 1:
                this.mNe = false;
                return;
            case 2:
                this.mNf = false;
                return;
            case 3:
                this.mNg = false;
                return;
            default:
                return;
        }
    }
}
