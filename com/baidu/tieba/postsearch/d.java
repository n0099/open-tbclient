package com.baidu.tieba.postsearch;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    public String dge;
    private String gfC;
    public ArrayList<String> gfL;
    private PostSearchActivity gfi;
    public int gfD = 0;
    public int gfE = 0;
    public int gfF = 1;
    public int gfG = 1;
    public int gfH = 1;
    public boolean gfI = false;
    public boolean gfJ = false;
    public boolean gfK = false;
    private int gfM = 0;
    private final HttpMessageListener gfN = new HttpMessageListener(CmdConfigHttp.CMD_POST_SEARCH) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.rL(intValue);
                boolean z = d.this.rK(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.gfi.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.rJ(intValue);
                    d.this.bnf();
                    d.this.bni();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.gfi.getResources().getString(d.k.neterror);
                }
                d.this.gfi.showToast(errorString);
                d.this.gfi.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener gfO = new CustomMessageListener(2009001) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.gfL = (ArrayList) data;
                d.this.gfi.bmR();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.gfi = postSearchActivity;
        this.gfi.registerListener(this.gfO);
        this.gfi.registerListener(this.gfN);
    }

    public boolean aH(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.dge)) {
            bnh();
        }
        switch (i) {
            case 1:
                return sy(str);
            case 2:
                return sz(str);
            case 3:
                return sA(str);
            default:
                return false;
        }
    }

    public boolean sy(String str) {
        if (this.gfI) {
            return false;
        }
        this.dge = str;
        this.gfM = 1;
        this.gfi.sendMessage(rI(this.gfM));
        this.gfI = true;
        return true;
    }

    public boolean sz(String str) {
        if (this.gfJ) {
            return false;
        }
        this.dge = str;
        this.gfM = 2;
        this.gfi.sendMessage(rI(this.gfM));
        this.gfJ = true;
        return true;
    }

    public boolean sA(String str) {
        if (this.gfK) {
            return false;
        }
        this.dge = str;
        this.gfM = 3;
        this.gfi.sendMessage(rI(this.gfM));
        this.gfK = true;
        return true;
    }

    public void bne() {
        this.gfi.sendMessage(new CustomMessage(2009001));
    }

    public void bnf() {
        if (!StringUtils.isNull(this.dge) && !this.dge.equals(this.gfC)) {
            this.gfi.sendMessage(new CustomMessage(2009003, this.dge));
            this.gfC = this.dge;
        }
    }

    public void bng() {
        if (this.gfL != null) {
            this.gfL.clear();
        }
        this.gfi.sendMessage(new CustomMessage(2009004));
    }

    public void bnh() {
        this.gfF = 1;
        this.gfG = 1;
        this.gfH = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bni() {
        if (this.gfL == null) {
            this.gfL = new ArrayList<>();
        }
        this.gfL.remove(this.dge);
        this.gfL.add(0, this.dge);
        di(this.gfL);
    }

    private void di(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage rI(int i) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_POST_SEARCH);
        httpMessage.addParam("word", this.dge);
        httpMessage.addParam(LegoListActivityConfig.RN, 30);
        httpMessage.addParam("kw", this.gfi.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.gfM));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam("pn", this.gfF);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam("pn", this.gfG);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam("pn", this.gfH);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rJ(int i) {
        switch (i) {
            case 1:
                this.gfF++;
                return;
            case 2:
                this.gfG++;
                return;
            case 3:
                this.gfH++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int rK(int i) {
        switch (i) {
            case 1:
                return this.gfF;
            case 2:
                return this.gfG;
            case 3:
                return this.gfH;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rL(int i) {
        switch (i) {
            case 1:
                this.gfI = false;
                return;
            case 2:
                this.gfJ = false;
                return;
            case 3:
                this.gfK = false;
                return;
            default:
                return;
        }
    }
}
