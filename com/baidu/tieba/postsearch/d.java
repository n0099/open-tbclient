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
    public String iFd;
    public ArrayList<String> moC;
    private PostSearchActivity moa;
    private String mot;
    public int mou = 0;
    public int mov = 0;
    public int mow = 1;
    public int mox = 1;
    public int moy = 1;
    public boolean moz = false;
    public boolean moA = false;
    public boolean moB = false;
    private int moD = 0;
    private final HttpMessageListener moE = new HttpMessageListener(1003016) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.HE(intValue);
                boolean z = d.this.HD(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.moa.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.HC(intValue);
                    d.this.dyM();
                    d.this.dyP();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.moa.getResources().getString(R.string.neterror);
                }
                d.this.moa.showToast(errorString);
                d.this.moa.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener moF = new CustomMessageListener(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.moC = (ArrayList) data;
                d.this.moa.dyy();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.moa = postSearchActivity;
        this.moa.registerListener(this.moF);
        this.moa.registerListener(this.moE);
    }

    public boolean bD(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.iFd)) {
            dyO();
        }
        switch (i) {
            case 1:
                return QT(str);
            case 2:
                return QU(str);
            case 3:
                return QV(str);
            default:
                return false;
        }
    }

    public boolean QT(String str) {
        if (this.moz) {
            return false;
        }
        this.iFd = str;
        this.moD = 1;
        this.moa.sendMessage(HB(this.moD));
        this.moz = true;
        return true;
    }

    public boolean QU(String str) {
        if (this.moA) {
            return false;
        }
        this.iFd = str;
        this.moD = 2;
        this.moa.sendMessage(HB(this.moD));
        this.moA = true;
        return true;
    }

    public boolean QV(String str) {
        if (this.moB) {
            return false;
        }
        this.iFd = str;
        this.moD = 3;
        this.moa.sendMessage(HB(this.moD));
        this.moB = true;
        return true;
    }

    public void dyL() {
        this.moa.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void dyM() {
        if (!StringUtils.isNull(this.iFd) && !this.iFd.equals(this.mot)) {
            this.moa.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.iFd));
            this.mot = this.iFd;
        }
    }

    public void dyN() {
        if (this.moC != null) {
            this.moC.clear();
        }
        this.moa.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void dyO() {
        this.mow = 1;
        this.mox = 1;
        this.moy = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyP() {
        if (this.moC == null) {
            this.moC = new ArrayList<>();
        }
        this.moC.remove(this.iFd);
        this.moC.add(0, this.iFd);
        fx(this.moC);
    }

    private void fx(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage HB(int i) {
        HttpMessage httpMessage = new HttpMessage(1003016);
        httpMessage.addParam("word", this.iFd);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.moa.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.moD));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.mow);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.mox);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.moy);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HC(int i) {
        switch (i) {
            case 1:
                this.mow++;
                return;
            case 2:
                this.mox++;
                return;
            case 3:
                this.moy++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int HD(int i) {
        switch (i) {
            case 1:
                return this.mow;
            case 2:
                return this.mox;
            case 3:
                return this.moy;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HE(int i) {
        switch (i) {
            case 1:
                this.moz = false;
                return;
            case 2:
                this.moA = false;
                return;
            case 3:
                this.moB = false;
                return;
            default:
                return;
        }
    }
}
