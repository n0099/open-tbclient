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
    public String hxA;
    private PostSearchActivity kZB;
    private String kZU;
    public ArrayList<String> lad;
    public int kZV = 0;
    public int kZW = 0;
    public int kZX = 1;
    public int kZY = 1;
    public int kZZ = 1;
    public boolean laa = false;
    public boolean lab = false;
    public boolean lac = false;
    private int lae = 0;
    private final HttpMessageListener laf = new HttpMessageListener(1003016) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.Da(intValue);
                boolean z = d.this.CZ(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.kZB.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.CY(intValue);
                    d.this.cXw();
                    d.this.cXz();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.kZB.getResources().getString(R.string.neterror);
                }
                d.this.kZB.showToast(errorString);
                d.this.kZB.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener lag = new CustomMessageListener(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.lad = (ArrayList) data;
                d.this.kZB.cXi();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.kZB = postSearchActivity;
        this.kZB.registerListener(this.lag);
        this.kZB.registerListener(this.laf);
    }

    public boolean bw(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.hxA)) {
            cXy();
        }
        switch (i) {
            case 1:
                return Lm(str);
            case 2:
                return Ln(str);
            case 3:
                return Lo(str);
            default:
                return false;
        }
    }

    public boolean Lm(String str) {
        if (this.laa) {
            return false;
        }
        this.hxA = str;
        this.lae = 1;
        this.kZB.sendMessage(CX(this.lae));
        this.laa = true;
        return true;
    }

    public boolean Ln(String str) {
        if (this.lab) {
            return false;
        }
        this.hxA = str;
        this.lae = 2;
        this.kZB.sendMessage(CX(this.lae));
        this.lab = true;
        return true;
    }

    public boolean Lo(String str) {
        if (this.lac) {
            return false;
        }
        this.hxA = str;
        this.lae = 3;
        this.kZB.sendMessage(CX(this.lae));
        this.lac = true;
        return true;
    }

    public void cXv() {
        this.kZB.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void cXw() {
        if (!StringUtils.isNull(this.hxA) && !this.hxA.equals(this.kZU)) {
            this.kZB.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.hxA));
            this.kZU = this.hxA;
        }
    }

    public void cXx() {
        if (this.lad != null) {
            this.lad.clear();
        }
        this.kZB.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void cXy() {
        this.kZX = 1;
        this.kZY = 1;
        this.kZZ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXz() {
        if (this.lad == null) {
            this.lad = new ArrayList<>();
        }
        this.lad.remove(this.hxA);
        this.lad.add(0, this.hxA);
        eH(this.lad);
    }

    private void eH(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage CX(int i) {
        HttpMessage httpMessage = new HttpMessage(1003016);
        httpMessage.addParam("word", this.hxA);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.kZB.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.lae));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.kZX);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.kZY);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.kZZ);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CY(int i) {
        switch (i) {
            case 1:
                this.kZX++;
                return;
            case 2:
                this.kZY++;
                return;
            case 3:
                this.kZZ++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int CZ(int i) {
        switch (i) {
            case 1:
                return this.kZX;
            case 2:
                return this.kZY;
            case 3:
                return this.kZZ;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Da(int i) {
        switch (i) {
            case 1:
                this.laa = false;
                return;
            case 2:
                this.lab = false;
                return;
            case 3:
                this.lac = false;
                return;
            default:
                return;
        }
    }
}
