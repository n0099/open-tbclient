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
    private PostSearchActivity lgS;
    private String lhk;
    public ArrayList<String> lht;
    public int lhl = 0;
    public int lhm = 0;
    public int lhn = 1;
    public int lho = 1;
    public int lhp = 1;
    public boolean lhq = false;
    public boolean lhr = false;
    public boolean lhs = false;
    private int lhu = 0;
    private final HttpMessageListener lhv = new HttpMessageListener(1003016) { // from class: com.baidu.tieba.postsearch.d.1
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
                    d.this.lgS.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.Du(intValue);
                    d.this.daE();
                    d.this.daH();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.lgS.getResources().getString(R.string.neterror);
                }
                d.this.lgS.showToast(errorString);
                d.this.lgS.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener lhw = new CustomMessageListener(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.lht = (ArrayList) data;
                d.this.lgS.daq();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.lgS = postSearchActivity;
        this.lgS.registerListener(this.lhw);
        this.lgS.registerListener(this.lhv);
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
        if (this.lhq) {
            return false;
        }
        this.hDo = str;
        this.lhu = 1;
        this.lgS.sendMessage(Dt(this.lhu));
        this.lhq = true;
        return true;
    }

    public boolean LV(String str) {
        if (this.lhr) {
            return false;
        }
        this.hDo = str;
        this.lhu = 2;
        this.lgS.sendMessage(Dt(this.lhu));
        this.lhr = true;
        return true;
    }

    public boolean LW(String str) {
        if (this.lhs) {
            return false;
        }
        this.hDo = str;
        this.lhu = 3;
        this.lgS.sendMessage(Dt(this.lhu));
        this.lhs = true;
        return true;
    }

    public void daD() {
        this.lgS.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void daE() {
        if (!StringUtils.isNull(this.hDo) && !this.hDo.equals(this.lhk)) {
            this.lgS.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.hDo));
            this.lhk = this.hDo;
        }
    }

    public void daF() {
        if (this.lht != null) {
            this.lht.clear();
        }
        this.lgS.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void daG() {
        this.lhn = 1;
        this.lho = 1;
        this.lhp = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void daH() {
        if (this.lht == null) {
            this.lht = new ArrayList<>();
        }
        this.lht.remove(this.hDo);
        this.lht.add(0, this.hDo);
        eN(this.lht);
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
        httpMessage.addParam("kw", this.lgS.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.lhu));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.lhn);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.lho);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.lhp);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Du(int i) {
        switch (i) {
            case 1:
                this.lhn++;
                return;
            case 2:
                this.lho++;
                return;
            case 3:
                this.lhp++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Dv(int i) {
        switch (i) {
            case 1:
                return this.lhn;
            case 2:
                return this.lho;
            case 3:
                return this.lhp;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dw(int i) {
        switch (i) {
            case 1:
                this.lhq = false;
                return;
            case 2:
                this.lhr = false;
                return;
            case 3:
                this.lhs = false;
                return;
            default:
                return;
        }
    }
}
