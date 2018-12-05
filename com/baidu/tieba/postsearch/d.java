package com.baidu.tieba.postsearch;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    public String dGt;
    private PostSearchActivity gGT;
    private String gHm;
    public ArrayList<String> gHv;
    public int gHn = 0;
    public int gHo = 0;
    public int gHp = 1;
    public int gHq = 1;
    public int gHr = 1;
    public boolean gHs = false;
    public boolean gHt = false;
    public boolean gHu = false;
    private int gHw = 0;
    private final HttpMessageListener gHx = new HttpMessageListener(CmdConfigHttp.CMD_POST_SEARCH) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.ty(intValue);
                boolean z = d.this.tx(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.gGT.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.tw(intValue);
                    d.this.btj();
                    d.this.btm();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.gGT.getResources().getString(e.j.neterror);
                }
                d.this.gGT.showToast(errorString);
                d.this.gGT.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener gHy = new CustomMessageListener(2009001) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.gHv = (ArrayList) data;
                d.this.gGT.bsV();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.gGT = postSearchActivity;
        this.gGT.registerListener(this.gHy);
        this.gGT.registerListener(this.gHx);
    }

    public boolean aO(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.dGt)) {
            btl();
        }
        switch (i) {
            case 1:
                return uh(str);
            case 2:
                return ui(str);
            case 3:
                return uj(str);
            default:
                return false;
        }
    }

    public boolean uh(String str) {
        if (this.gHs) {
            return false;
        }
        this.dGt = str;
        this.gHw = 1;
        this.gGT.sendMessage(tv(this.gHw));
        this.gHs = true;
        return true;
    }

    public boolean ui(String str) {
        if (this.gHt) {
            return false;
        }
        this.dGt = str;
        this.gHw = 2;
        this.gGT.sendMessage(tv(this.gHw));
        this.gHt = true;
        return true;
    }

    public boolean uj(String str) {
        if (this.gHu) {
            return false;
        }
        this.dGt = str;
        this.gHw = 3;
        this.gGT.sendMessage(tv(this.gHw));
        this.gHu = true;
        return true;
    }

    public void bti() {
        this.gGT.sendMessage(new CustomMessage(2009001));
    }

    public void btj() {
        if (!StringUtils.isNull(this.dGt) && !this.dGt.equals(this.gHm)) {
            this.gGT.sendMessage(new CustomMessage(2009003, this.dGt));
            this.gHm = this.dGt;
        }
    }

    public void btk() {
        if (this.gHv != null) {
            this.gHv.clear();
        }
        this.gGT.sendMessage(new CustomMessage(2009004));
    }

    public void btl() {
        this.gHp = 1;
        this.gHq = 1;
        this.gHr = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btm() {
        if (this.gHv == null) {
            this.gHv = new ArrayList<>();
        }
        this.gHv.remove(this.dGt);
        this.gHv.add(0, this.dGt);
        dz(this.gHv);
    }

    private void dz(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage tv(int i) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_POST_SEARCH);
        httpMessage.addParam("word", this.dGt);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.gGT.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.gHw));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.gHp);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.gHq);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.gHr);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tw(int i) {
        switch (i) {
            case 1:
                this.gHp++;
                return;
            case 2:
                this.gHq++;
                return;
            case 3:
                this.gHr++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int tx(int i) {
        switch (i) {
            case 1:
                return this.gHp;
            case 2:
                return this.gHq;
            case 3:
                return this.gHr;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ty(int i) {
        switch (i) {
            case 1:
                this.gHs = false;
                return;
            case 2:
                this.gHt = false;
                return;
            case 3:
                this.gHu = false;
                return;
            default:
                return;
        }
    }
}
