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
    public String izg;
    public ArrayList<String> miF;
    private PostSearchActivity mic;
    private String miw;
    public int mix = 0;
    public int miy = 0;
    public int miz = 1;
    public int miA = 1;
    public int miB = 1;
    public boolean miC = false;
    public boolean miD = false;
    public boolean miE = false;
    private int miG = 0;
    private final HttpMessageListener miH = new HttpMessageListener(1003016) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.Hr(intValue);
                boolean z = d.this.Hq(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.mic.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.Hp(intValue);
                    d.this.dwk();
                    d.this.dwn();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.mic.getResources().getString(R.string.neterror);
                }
                d.this.mic.showToast(errorString);
                d.this.mic.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener miI = new CustomMessageListener(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.miF = (ArrayList) data;
                d.this.mic.dvW();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.mic = postSearchActivity;
        this.mic.registerListener(this.miI);
        this.mic.registerListener(this.miH);
    }

    public boolean bB(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.izg)) {
            dwm();
        }
        switch (i) {
            case 1:
                return QC(str);
            case 2:
                return QD(str);
            case 3:
                return QE(str);
            default:
                return false;
        }
    }

    public boolean QC(String str) {
        if (this.miC) {
            return false;
        }
        this.izg = str;
        this.miG = 1;
        this.mic.sendMessage(Ho(this.miG));
        this.miC = true;
        return true;
    }

    public boolean QD(String str) {
        if (this.miD) {
            return false;
        }
        this.izg = str;
        this.miG = 2;
        this.mic.sendMessage(Ho(this.miG));
        this.miD = true;
        return true;
    }

    public boolean QE(String str) {
        if (this.miE) {
            return false;
        }
        this.izg = str;
        this.miG = 3;
        this.mic.sendMessage(Ho(this.miG));
        this.miE = true;
        return true;
    }

    public void dwj() {
        this.mic.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void dwk() {
        if (!StringUtils.isNull(this.izg) && !this.izg.equals(this.miw)) {
            this.mic.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.izg));
            this.miw = this.izg;
        }
    }

    public void dwl() {
        if (this.miF != null) {
            this.miF.clear();
        }
        this.mic.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void dwm() {
        this.miz = 1;
        this.miA = 1;
        this.miB = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwn() {
        if (this.miF == null) {
            this.miF = new ArrayList<>();
        }
        this.miF.remove(this.izg);
        this.miF.add(0, this.izg);
        fp(this.miF);
    }

    private void fp(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage Ho(int i) {
        HttpMessage httpMessage = new HttpMessage(1003016);
        httpMessage.addParam("word", this.izg);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.mic.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.miG));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.miz);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.miA);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.miB);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hp(int i) {
        switch (i) {
            case 1:
                this.miz++;
                return;
            case 2:
                this.miA++;
                return;
            case 3:
                this.miB++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Hq(int i) {
        switch (i) {
            case 1:
                return this.miz;
            case 2:
                return this.miA;
            case 3:
                return this.miB;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hr(int i) {
        switch (i) {
            case 1:
                this.miC = false;
                return;
            case 2:
                this.miD = false;
                return;
            case 3:
                this.miE = false;
                return;
            default:
                return;
        }
    }
}
