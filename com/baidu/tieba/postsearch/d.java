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
    public String hDo;
    private PostSearchActivity lgU;
    private String lhm;
    public ArrayList<String> lhv;
    public int lhn = 0;
    public int lho = 0;
    public int lhp = 1;
    public int lhq = 1;
    public int lhr = 1;
    public boolean lhs = false;
    public boolean lht = false;
    public boolean lhu = false;
    private int lhw = 0;
    private final HttpMessageListener lhx = new HttpMessageListener(1003016) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.Dw(intValue);
                boolean z = d.this.Dv(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.lgU.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.Du(intValue);
                    d.this.daE();
                    d.this.daH();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.lgU.getResources().getString(R.string.neterror);
                }
                d.this.lgU.showToast(errorString);
                d.this.lgU.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener lhy = new CustomMessageListener(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.lhv = (ArrayList) data;
                d.this.lgU.daq();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.lgU = postSearchActivity;
        this.lgU.registerListener(this.lhy);
        this.lgU.registerListener(this.lhx);
    }

    public boolean bu(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.hDo)) {
            daG();
        }
        switch (i) {
            case 1:
                return LU(str);
            case 2:
                return LV(str);
            case 3:
                return LW(str);
            default:
                return false;
        }
    }

    public boolean LU(String str) {
        if (this.lhs) {
            return false;
        }
        this.hDo = str;
        this.lhw = 1;
        this.lgU.sendMessage(Dt(this.lhw));
        this.lhs = true;
        return true;
    }

    public boolean LV(String str) {
        if (this.lht) {
            return false;
        }
        this.hDo = str;
        this.lhw = 2;
        this.lgU.sendMessage(Dt(this.lhw));
        this.lht = true;
        return true;
    }

    public boolean LW(String str) {
        if (this.lhu) {
            return false;
        }
        this.hDo = str;
        this.lhw = 3;
        this.lgU.sendMessage(Dt(this.lhw));
        this.lhu = true;
        return true;
    }

    public void daD() {
        this.lgU.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void daE() {
        if (!StringUtils.isNull(this.hDo) && !this.hDo.equals(this.lhm)) {
            this.lgU.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.hDo));
            this.lhm = this.hDo;
        }
    }

    public void daF() {
        if (this.lhv != null) {
            this.lhv.clear();
        }
        this.lgU.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void daG() {
        this.lhp = 1;
        this.lhq = 1;
        this.lhr = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void daH() {
        if (this.lhv == null) {
            this.lhv = new ArrayList<>();
        }
        this.lhv.remove(this.hDo);
        this.lhv.add(0, this.hDo);
        eN(this.lhv);
    }

    private void eN(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage Dt(int i) {
        HttpMessage httpMessage = new HttpMessage(1003016);
        httpMessage.addParam("word", this.hDo);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.lgU.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.lhw));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.lhp);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.lhq);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.lhr);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Du(int i) {
        switch (i) {
            case 1:
                this.lhp++;
                return;
            case 2:
                this.lhq++;
                return;
            case 3:
                this.lhr++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Dv(int i) {
        switch (i) {
            case 1:
                return this.lhp;
            case 2:
                return this.lhq;
            case 3:
                return this.lhr;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dw(int i) {
        switch (i) {
            case 1:
                this.lhs = false;
                return;
            case 2:
                this.lht = false;
                return;
            case 3:
                this.lhu = false;
                return;
            default:
                return;
        }
    }
}
