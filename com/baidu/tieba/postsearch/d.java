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
    public String dqC;
    public ArrayList<String> grD;
    private PostSearchActivity grb;
    private String gru;
    public int grv = 0;
    public int grw = 0;
    public int grx = 1;
    public int gry = 1;
    public int grz = 1;
    public boolean grA = false;
    public boolean grB = false;
    public boolean grC = false;
    private int grE = 0;
    private final HttpMessageListener grF = new HttpMessageListener(CmdConfigHttp.CMD_POST_SEARCH) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.so(intValue);
                boolean z = d.this.sn(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.grb.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.sm(intValue);
                    d.this.boF();
                    d.this.boI();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.grb.getResources().getString(e.j.neterror);
                }
                d.this.grb.showToast(errorString);
                d.this.grb.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener grG = new CustomMessageListener(2009001) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.grD = (ArrayList) data;
                d.this.grb.bor();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.grb = postSearchActivity;
        this.grb.registerListener(this.grG);
        this.grb.registerListener(this.grF);
    }

    public boolean aJ(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.dqC)) {
            boH();
        }
        switch (i) {
            case 1:
                return tb(str);
            case 2:
                return tc(str);
            case 3:
                return td(str);
            default:
                return false;
        }
    }

    public boolean tb(String str) {
        if (this.grA) {
            return false;
        }
        this.dqC = str;
        this.grE = 1;
        this.grb.sendMessage(sl(this.grE));
        this.grA = true;
        return true;
    }

    public boolean tc(String str) {
        if (this.grB) {
            return false;
        }
        this.dqC = str;
        this.grE = 2;
        this.grb.sendMessage(sl(this.grE));
        this.grB = true;
        return true;
    }

    public boolean td(String str) {
        if (this.grC) {
            return false;
        }
        this.dqC = str;
        this.grE = 3;
        this.grb.sendMessage(sl(this.grE));
        this.grC = true;
        return true;
    }

    public void boE() {
        this.grb.sendMessage(new CustomMessage(2009001));
    }

    public void boF() {
        if (!StringUtils.isNull(this.dqC) && !this.dqC.equals(this.gru)) {
            this.grb.sendMessage(new CustomMessage(2009003, this.dqC));
            this.gru = this.dqC;
        }
    }

    public void boG() {
        if (this.grD != null) {
            this.grD.clear();
        }
        this.grb.sendMessage(new CustomMessage(2009004));
    }

    public void boH() {
        this.grx = 1;
        this.gry = 1;
        this.grz = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boI() {
        if (this.grD == null) {
            this.grD = new ArrayList<>();
        }
        this.grD.remove(this.dqC);
        this.grD.add(0, this.dqC);
        dj(this.grD);
    }

    private void dj(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage sl(int i) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_POST_SEARCH);
        httpMessage.addParam("word", this.dqC);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.grb.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.grE));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.grx);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.gry);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.grz);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sm(int i) {
        switch (i) {
            case 1:
                this.grx++;
                return;
            case 2:
                this.gry++;
                return;
            case 3:
                this.grz++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int sn(int i) {
        switch (i) {
            case 1:
                return this.grx;
            case 2:
                return this.gry;
            case 3:
                return this.grz;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void so(int i) {
        switch (i) {
            case 1:
                this.grA = false;
                return;
            case 2:
                this.grB = false;
                return;
            case 3:
                this.grC = false;
                return;
            default:
                return;
        }
    }
}
