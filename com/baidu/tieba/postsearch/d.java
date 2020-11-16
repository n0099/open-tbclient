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
/* loaded from: classes23.dex */
public class d {
    public String iFR;
    private String moN;
    public ArrayList<String> moW;
    private PostSearchActivity mov;
    public int moO = 0;
    public int moP = 0;
    public int moQ = 1;
    public int moR = 1;
    public int moS = 1;
    public boolean moT = false;
    public boolean moU = false;
    public boolean moV = false;
    private int moX = 0;
    private final HttpMessageListener moY = new HttpMessageListener(1003016) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.Ic(intValue);
                boolean z = d.this.Ib(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.mov.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.Ia(intValue);
                    d.this.dym();
                    d.this.dyp();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.mov.getResources().getString(R.string.neterror);
                }
                d.this.mov.showToast(errorString);
                d.this.mov.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener moZ = new CustomMessageListener(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.moW = (ArrayList) data;
                d.this.mov.dxY();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.mov = postSearchActivity;
        this.mov.registerListener(this.moZ);
        this.mov.registerListener(this.moY);
    }

    public boolean bC(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.iFR)) {
            dyo();
        }
        switch (i) {
            case 1:
                return Qo(str);
            case 2:
                return Qp(str);
            case 3:
                return Qq(str);
            default:
                return false;
        }
    }

    public boolean Qo(String str) {
        if (this.moT) {
            return false;
        }
        this.iFR = str;
        this.moX = 1;
        this.mov.sendMessage(HZ(this.moX));
        this.moT = true;
        return true;
    }

    public boolean Qp(String str) {
        if (this.moU) {
            return false;
        }
        this.iFR = str;
        this.moX = 2;
        this.mov.sendMessage(HZ(this.moX));
        this.moU = true;
        return true;
    }

    public boolean Qq(String str) {
        if (this.moV) {
            return false;
        }
        this.iFR = str;
        this.moX = 3;
        this.mov.sendMessage(HZ(this.moX));
        this.moV = true;
        return true;
    }

    public void dyl() {
        this.mov.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void dym() {
        if (!StringUtils.isNull(this.iFR) && !this.iFR.equals(this.moN)) {
            this.mov.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.iFR));
            this.moN = this.iFR;
        }
    }

    public void dyn() {
        if (this.moW != null) {
            this.moW.clear();
        }
        this.mov.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void dyo() {
        this.moQ = 1;
        this.moR = 1;
        this.moS = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyp() {
        if (this.moW == null) {
            this.moW = new ArrayList<>();
        }
        this.moW.remove(this.iFR);
        this.moW.add(0, this.iFR);
        fx(this.moW);
    }

    private void fx(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage HZ(int i) {
        HttpMessage httpMessage = new HttpMessage(1003016);
        httpMessage.addParam("word", this.iFR);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.mov.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.moX));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.moQ);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.moR);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.moS);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ia(int i) {
        switch (i) {
            case 1:
                this.moQ++;
                return;
            case 2:
                this.moR++;
                return;
            case 3:
                this.moS++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Ib(int i) {
        switch (i) {
            case 1:
                return this.moQ;
            case 2:
                return this.moR;
            case 3:
                return this.moS;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ic(int i) {
        switch (i) {
            case 1:
                this.moT = false;
                return;
            case 2:
                this.moU = false;
                return;
            case 3:
                this.moV = false;
                return;
            default:
                return;
        }
    }
}
