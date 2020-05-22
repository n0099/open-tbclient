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
    public String hli;
    private String kEQ;
    public ArrayList<String> kEZ;
    private PostSearchActivity kEx;
    public int kER = 0;
    public int kES = 0;
    public int kET = 1;
    public int kEU = 1;
    public int kEV = 1;
    public boolean kEW = false;
    public boolean kEX = false;
    public boolean kEY = false;
    private int kFa = 0;
    private final HttpMessageListener kFb = new HttpMessageListener(1003016) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.BW(intValue);
                boolean z = d.this.BV(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.kEx.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.BU(intValue);
                    d.this.cSQ();
                    d.this.cST();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.kEx.getResources().getString(R.string.neterror);
                }
                d.this.kEx.showToast(errorString);
                d.this.kEx.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener kFc = new CustomMessageListener(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.kEZ = (ArrayList) data;
                d.this.kEx.cSC();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.kEx = postSearchActivity;
        this.kEx.registerListener(this.kFc);
        this.kEx.registerListener(this.kFb);
    }

    public boolean bx(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.hli)) {
            cSS();
        }
        switch (i) {
            case 1:
                return KK(str);
            case 2:
                return KL(str);
            case 3:
                return KM(str);
            default:
                return false;
        }
    }

    public boolean KK(String str) {
        if (this.kEW) {
            return false;
        }
        this.hli = str;
        this.kFa = 1;
        this.kEx.sendMessage(BT(this.kFa));
        this.kEW = true;
        return true;
    }

    public boolean KL(String str) {
        if (this.kEX) {
            return false;
        }
        this.hli = str;
        this.kFa = 2;
        this.kEx.sendMessage(BT(this.kFa));
        this.kEX = true;
        return true;
    }

    public boolean KM(String str) {
        if (this.kEY) {
            return false;
        }
        this.hli = str;
        this.kFa = 3;
        this.kEx.sendMessage(BT(this.kFa));
        this.kEY = true;
        return true;
    }

    public void cSP() {
        this.kEx.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void cSQ() {
        if (!StringUtils.isNull(this.hli) && !this.hli.equals(this.kEQ)) {
            this.kEx.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.hli));
            this.kEQ = this.hli;
        }
    }

    public void cSR() {
        if (this.kEZ != null) {
            this.kEZ.clear();
        }
        this.kEx.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void cSS() {
        this.kET = 1;
        this.kEU = 1;
        this.kEV = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cST() {
        if (this.kEZ == null) {
            this.kEZ = new ArrayList<>();
        }
        this.kEZ.remove(this.hli);
        this.kEZ.add(0, this.hli);
        er(this.kEZ);
    }

    private void er(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage BT(int i) {
        HttpMessage httpMessage = new HttpMessage(1003016);
        httpMessage.addParam("word", this.hli);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.kEx.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.kFa));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.kET);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.kEU);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.kEV);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BU(int i) {
        switch (i) {
            case 1:
                this.kET++;
                return;
            case 2:
                this.kEU++;
                return;
            case 3:
                this.kEV++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int BV(int i) {
        switch (i) {
            case 1:
                return this.kET;
            case 2:
                return this.kEU;
            case 3:
                return this.kEV;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BW(int i) {
        switch (i) {
            case 1:
                this.kEW = false;
                return;
            case 2:
                this.kEX = false;
                return;
            case 3:
                this.kEY = false;
                return;
            default:
                return;
        }
    }
}
