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
    public String dJh;
    private PostSearchActivity gJK;
    private String gKd;
    public ArrayList<String> gKm;
    public int gKe = 0;
    public int gKf = 0;
    public int gKg = 1;
    public int gKh = 1;
    public int gKi = 1;
    public boolean gKj = false;
    public boolean gKk = false;
    public boolean gKl = false;
    private int gKn = 0;
    private final HttpMessageListener gKo = new HttpMessageListener(CmdConfigHttp.CMD_POST_SEARCH) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.tL(intValue);
                boolean z = d.this.tK(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.gJK.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.tJ(intValue);
                    d.this.btU();
                    d.this.btX();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.gJK.getResources().getString(e.j.neterror);
                }
                d.this.gJK.showToast(errorString);
                d.this.gJK.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener gKp = new CustomMessageListener(2009001) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.gKm = (ArrayList) data;
                d.this.gJK.btG();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.gJK = postSearchActivity;
        this.gJK.registerListener(this.gKp);
        this.gJK.registerListener(this.gKo);
    }

    public boolean aP(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.dJh)) {
            btW();
        }
        switch (i) {
            case 1:
                return uk(str);
            case 2:
                return ul(str);
            case 3:
                return um(str);
            default:
                return false;
        }
    }

    public boolean uk(String str) {
        if (this.gKj) {
            return false;
        }
        this.dJh = str;
        this.gKn = 1;
        this.gJK.sendMessage(tI(this.gKn));
        this.gKj = true;
        return true;
    }

    public boolean ul(String str) {
        if (this.gKk) {
            return false;
        }
        this.dJh = str;
        this.gKn = 2;
        this.gJK.sendMessage(tI(this.gKn));
        this.gKk = true;
        return true;
    }

    public boolean um(String str) {
        if (this.gKl) {
            return false;
        }
        this.dJh = str;
        this.gKn = 3;
        this.gJK.sendMessage(tI(this.gKn));
        this.gKl = true;
        return true;
    }

    public void btT() {
        this.gJK.sendMessage(new CustomMessage(2009001));
    }

    public void btU() {
        if (!StringUtils.isNull(this.dJh) && !this.dJh.equals(this.gKd)) {
            this.gJK.sendMessage(new CustomMessage(2009003, this.dJh));
            this.gKd = this.dJh;
        }
    }

    public void btV() {
        if (this.gKm != null) {
            this.gKm.clear();
        }
        this.gJK.sendMessage(new CustomMessage(2009004));
    }

    public void btW() {
        this.gKg = 1;
        this.gKh = 1;
        this.gKi = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btX() {
        if (this.gKm == null) {
            this.gKm = new ArrayList<>();
        }
        this.gKm.remove(this.dJh);
        this.gKm.add(0, this.dJh);
        dA(this.gKm);
    }

    private void dA(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage tI(int i) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_POST_SEARCH);
        httpMessage.addParam("word", this.dJh);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.gJK.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.gKn));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.gKg);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.gKh);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.gKi);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tJ(int i) {
        switch (i) {
            case 1:
                this.gKg++;
                return;
            case 2:
                this.gKh++;
                return;
            case 3:
                this.gKi++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int tK(int i) {
        switch (i) {
            case 1:
                return this.gKg;
            case 2:
                return this.gKh;
            case 3:
                return this.gKi;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tL(int i) {
        switch (i) {
            case 1:
                this.gKj = false;
                return;
            case 2:
                this.gKk = false;
                return;
            case 3:
                this.gKl = false;
                return;
            default:
                return;
        }
    }
}
