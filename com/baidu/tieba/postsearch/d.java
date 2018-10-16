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
    private PostSearchActivity gyB;
    private String gyU;
    public ArrayList<String> gzd;
    public int gyV = 0;
    public int gyW = 0;
    public int gyX = 1;
    public int gyY = 1;
    public int gyZ = 1;
    public boolean gza = false;
    public boolean gzb = false;
    public boolean gzc = false;
    private int gze = 0;
    private final HttpMessageListener gzf = new HttpMessageListener(CmdConfigHttp.CMD_POST_SEARCH) { // from class: com.baidu.tieba.postsearch.d.1
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
                    d.this.gyB.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.sJ(intValue);
                    d.this.brU();
                    d.this.brX();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.gyB.getResources().getString(e.j.neterror);
                }
                d.this.gyB.showToast(errorString);
                d.this.gyB.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener gzg = new CustomMessageListener(2009001) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.gzd = (ArrayList) data;
                d.this.gyB.brG();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.gyB = postSearchActivity;
        this.gyB.registerListener(this.gzg);
        this.gyB.registerListener(this.gzf);
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
        if (this.gza) {
            return false;
        }
        this.dyD = str;
        this.gze = 1;
        this.gyB.sendMessage(sI(this.gze));
        this.gza = true;
        return true;
    }

    public boolean tC(String str) {
        if (this.gzb) {
            return false;
        }
        this.dyD = str;
        this.gze = 2;
        this.gyB.sendMessage(sI(this.gze));
        this.gzb = true;
        return true;
    }

    public boolean tD(String str) {
        if (this.gzc) {
            return false;
        }
        this.dyD = str;
        this.gze = 3;
        this.gyB.sendMessage(sI(this.gze));
        this.gzc = true;
        return true;
    }

    public void brT() {
        this.gyB.sendMessage(new CustomMessage(2009001));
    }

    public void brU() {
        if (!StringUtils.isNull(this.dyD) && !this.dyD.equals(this.gyU)) {
            this.gyB.sendMessage(new CustomMessage(2009003, this.dyD));
            this.gyU = this.dyD;
        }
    }

    public void brV() {
        if (this.gzd != null) {
            this.gzd.clear();
        }
        this.gyB.sendMessage(new CustomMessage(2009004));
    }

    public void brW() {
        this.gyX = 1;
        this.gyY = 1;
        this.gyZ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brX() {
        if (this.gzd == null) {
            this.gzd = new ArrayList<>();
        }
        this.gzd.remove(this.dyD);
        this.gzd.add(0, this.dyD);
        dx(this.gzd);
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
        httpMessage.addParam("kw", this.gyB.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.gze));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.gyX);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.gyY);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.gyZ);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sJ(int i) {
        switch (i) {
            case 1:
                this.gyX++;
                return;
            case 2:
                this.gyY++;
                return;
            case 3:
                this.gyZ++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int sK(int i) {
        switch (i) {
            case 1:
                return this.gyX;
            case 2:
                return this.gyY;
            case 3:
                return this.gyZ;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sL(int i) {
        switch (i) {
            case 1:
                this.gza = false;
                return;
            case 2:
                this.gzb = false;
                return;
            case 3:
                this.gzc = false;
                return;
            default:
                return;
        }
    }
}
