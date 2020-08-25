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
/* loaded from: classes18.dex */
public class d {
    public String hQD;
    private String lxF;
    public ArrayList<String> lxO;
    private PostSearchActivity lxn;
    public int lxG = 0;
    public int lxH = 0;
    public int lxI = 1;
    public int lxJ = 1;
    public int lxK = 1;
    public boolean lxL = false;
    public boolean lxM = false;
    public boolean lxN = false;
    private int lxP = 0;
    private final HttpMessageListener lxQ = new HttpMessageListener(1003016) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.FR(intValue);
                boolean z = d.this.FQ(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.lxn.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.FP(intValue);
                    d.this.dlI();
                    d.this.dlL();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.lxn.getResources().getString(R.string.neterror);
                }
                d.this.lxn.showToast(errorString);
                d.this.lxn.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener lxR = new CustomMessageListener(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.lxO = (ArrayList) data;
                d.this.lxn.dlu();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.lxn = postSearchActivity;
        this.lxn.registerListener(this.lxR);
        this.lxn.registerListener(this.lxQ);
    }

    public boolean bz(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.hQD)) {
            dlK();
        }
        switch (i) {
            case 1:
                return ON(str);
            case 2:
                return OO(str);
            case 3:
                return OP(str);
            default:
                return false;
        }
    }

    public boolean ON(String str) {
        if (this.lxL) {
            return false;
        }
        this.hQD = str;
        this.lxP = 1;
        this.lxn.sendMessage(FO(this.lxP));
        this.lxL = true;
        return true;
    }

    public boolean OO(String str) {
        if (this.lxM) {
            return false;
        }
        this.hQD = str;
        this.lxP = 2;
        this.lxn.sendMessage(FO(this.lxP));
        this.lxM = true;
        return true;
    }

    public boolean OP(String str) {
        if (this.lxN) {
            return false;
        }
        this.hQD = str;
        this.lxP = 3;
        this.lxn.sendMessage(FO(this.lxP));
        this.lxN = true;
        return true;
    }

    public void dlH() {
        this.lxn.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void dlI() {
        if (!StringUtils.isNull(this.hQD) && !this.hQD.equals(this.lxF)) {
            this.lxn.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.hQD));
            this.lxF = this.hQD;
        }
    }

    public void dlJ() {
        if (this.lxO != null) {
            this.lxO.clear();
        }
        this.lxn.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void dlK() {
        this.lxI = 1;
        this.lxJ = 1;
        this.lxK = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlL() {
        if (this.lxO == null) {
            this.lxO = new ArrayList<>();
        }
        this.lxO.remove(this.hQD);
        this.lxO.add(0, this.hQD);
        eV(this.lxO);
    }

    private void eV(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage FO(int i) {
        HttpMessage httpMessage = new HttpMessage(1003016);
        httpMessage.addParam("word", this.hQD);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.lxn.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.lxP));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.lxI);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.lxJ);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.lxK);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FP(int i) {
        switch (i) {
            case 1:
                this.lxI++;
                return;
            case 2:
                this.lxJ++;
                return;
            case 3:
                this.lxK++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int FQ(int i) {
        switch (i) {
            case 1:
                return this.lxI;
            case 2:
                return this.lxJ;
            case 3:
                return this.lxK;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FR(int i) {
        switch (i) {
            case 1:
                this.lxL = false;
                return;
            case 2:
                this.lxM = false;
                return;
            case 3:
                this.lxN = false;
                return;
            default:
                return;
        }
    }
}
