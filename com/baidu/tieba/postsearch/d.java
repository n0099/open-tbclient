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
    public String hQJ;
    private String lxQ;
    public ArrayList<String> lxZ;
    private PostSearchActivity lxy;
    public int lxR = 0;
    public int lxS = 0;
    public int lxT = 1;
    public int lxU = 1;
    public int lxV = 1;
    public boolean lxW = false;
    public boolean lxX = false;
    public boolean lxY = false;
    private int lya = 0;
    private final HttpMessageListener lyb = new HttpMessageListener(1003016) { // from class: com.baidu.tieba.postsearch.d.1
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
                    d.this.lxy.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.FP(intValue);
                    d.this.dlL();
                    d.this.dlO();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.lxy.getResources().getString(R.string.neterror);
                }
                d.this.lxy.showToast(errorString);
                d.this.lxy.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener lyc = new CustomMessageListener(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.lxZ = (ArrayList) data;
                d.this.lxy.dlx();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.lxy = postSearchActivity;
        this.lxy.registerListener(this.lyc);
        this.lxy.registerListener(this.lyb);
    }

    public boolean bz(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.hQJ)) {
            dlN();
        }
        switch (i) {
            case 1:
                return OO(str);
            case 2:
                return OP(str);
            case 3:
                return OQ(str);
            default:
                return false;
        }
    }

    public boolean OO(String str) {
        if (this.lxW) {
            return false;
        }
        this.hQJ = str;
        this.lya = 1;
        this.lxy.sendMessage(FO(this.lya));
        this.lxW = true;
        return true;
    }

    public boolean OP(String str) {
        if (this.lxX) {
            return false;
        }
        this.hQJ = str;
        this.lya = 2;
        this.lxy.sendMessage(FO(this.lya));
        this.lxX = true;
        return true;
    }

    public boolean OQ(String str) {
        if (this.lxY) {
            return false;
        }
        this.hQJ = str;
        this.lya = 3;
        this.lxy.sendMessage(FO(this.lya));
        this.lxY = true;
        return true;
    }

    public void dlK() {
        this.lxy.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void dlL() {
        if (!StringUtils.isNull(this.hQJ) && !this.hQJ.equals(this.lxQ)) {
            this.lxy.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.hQJ));
            this.lxQ = this.hQJ;
        }
    }

    public void dlM() {
        if (this.lxZ != null) {
            this.lxZ.clear();
        }
        this.lxy.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void dlN() {
        this.lxT = 1;
        this.lxU = 1;
        this.lxV = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlO() {
        if (this.lxZ == null) {
            this.lxZ = new ArrayList<>();
        }
        this.lxZ.remove(this.hQJ);
        this.lxZ.add(0, this.hQJ);
        eV(this.lxZ);
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
        httpMessage.addParam("word", this.hQJ);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.lxy.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.lya));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.lxT);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.lxU);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.lxV);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FP(int i) {
        switch (i) {
            case 1:
                this.lxT++;
                return;
            case 2:
                this.lxU++;
                return;
            case 3:
                this.lxV++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int FQ(int i) {
        switch (i) {
            case 1:
                return this.lxT;
            case 2:
                return this.lxU;
            case 3:
                return this.lxV;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FR(int i) {
        switch (i) {
            case 1:
                this.lxW = false;
                return;
            case 2:
                this.lxX = false;
                return;
            case 3:
                this.lxY = false;
                return;
            default:
                return;
        }
    }
}
