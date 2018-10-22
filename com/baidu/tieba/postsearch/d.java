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
    public String dyD;
    private PostSearchActivity gyC;
    private String gyV;
    public ArrayList<String> gze;
    public int gyW = 0;
    public int gyX = 0;
    public int gyY = 1;
    public int gyZ = 1;
    public int gza = 1;
    public boolean gzb = false;
    public boolean gzc = false;
    public boolean gzd = false;
    private int gzf = 0;
    private final HttpMessageListener gzg = new HttpMessageListener(CmdConfigHttp.CMD_POST_SEARCH) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.sL(intValue);
                boolean z = d.this.sK(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.gyC.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.sJ(intValue);
                    d.this.brU();
                    d.this.brX();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.gyC.getResources().getString(e.j.neterror);
                }
                d.this.gyC.showToast(errorString);
                d.this.gyC.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener gzh = new CustomMessageListener(2009001) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.gze = (ArrayList) data;
                d.this.gyC.brG();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.gyC = postSearchActivity;
        this.gyC.registerListener(this.gzh);
        this.gyC.registerListener(this.gzg);
    }

    public boolean aN(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.dyD)) {
            brW();
        }
        switch (i) {
            case 1:
                return tB(str);
            case 2:
                return tC(str);
            case 3:
                return tD(str);
            default:
                return false;
        }
    }

    public boolean tB(String str) {
        if (this.gzb) {
            return false;
        }
        this.dyD = str;
        this.gzf = 1;
        this.gyC.sendMessage(sI(this.gzf));
        this.gzb = true;
        return true;
    }

    public boolean tC(String str) {
        if (this.gzc) {
            return false;
        }
        this.dyD = str;
        this.gzf = 2;
        this.gyC.sendMessage(sI(this.gzf));
        this.gzc = true;
        return true;
    }

    public boolean tD(String str) {
        if (this.gzd) {
            return false;
        }
        this.dyD = str;
        this.gzf = 3;
        this.gyC.sendMessage(sI(this.gzf));
        this.gzd = true;
        return true;
    }

    public void brT() {
        this.gyC.sendMessage(new CustomMessage(2009001));
    }

    public void brU() {
        if (!StringUtils.isNull(this.dyD) && !this.dyD.equals(this.gyV)) {
            this.gyC.sendMessage(new CustomMessage(2009003, this.dyD));
            this.gyV = this.dyD;
        }
    }

    public void brV() {
        if (this.gze != null) {
            this.gze.clear();
        }
        this.gyC.sendMessage(new CustomMessage(2009004));
    }

    public void brW() {
        this.gyY = 1;
        this.gyZ = 1;
        this.gza = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brX() {
        if (this.gze == null) {
            this.gze = new ArrayList<>();
        }
        this.gze.remove(this.dyD);
        this.gze.add(0, this.dyD);
        dx(this.gze);
    }

    private void dx(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage sI(int i) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_POST_SEARCH);
        httpMessage.addParam("word", this.dyD);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.gyC.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.gzf));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.gyY);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.gyZ);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.gza);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sJ(int i) {
        switch (i) {
            case 1:
                this.gyY++;
                return;
            case 2:
                this.gyZ++;
                return;
            case 3:
                this.gza++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int sK(int i) {
        switch (i) {
            case 1:
                return this.gyY;
            case 2:
                return this.gyZ;
            case 3:
                return this.gza;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sL(int i) {
        switch (i) {
            case 1:
                this.gzb = false;
                return;
            case 2:
                this.gzc = false;
                return;
            case 3:
                this.gzd = false;
                return;
            default:
                return;
        }
    }
}
