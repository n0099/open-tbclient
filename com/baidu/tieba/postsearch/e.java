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
public class e {
    public String dDb;
    private PostSearchActivity gxZ;
    public ArrayList<String> gyB;
    private String gys;
    public int gyt = 0;
    public int gyu = 0;
    public int gyv = 1;
    public int gyw = 1;
    public int gyx = 1;
    public boolean gyy = false;
    public boolean gyz = false;
    public boolean gyA = false;
    private int gyC = 0;
    private final HttpMessageListener gyD = new HttpMessageListener(CmdConfigHttp.CMD_POST_SEARCH) { // from class: com.baidu.tieba.postsearch.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                e.this.uc(intValue);
                boolean z = e.this.ub(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    e.this.gxZ.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    e.this.ua(intValue);
                    e.this.bnb();
                    e.this.bne();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = e.this.gxZ.getResources().getString(d.j.neterror);
                }
                e.this.gxZ.showToast(errorString);
                e.this.gxZ.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener gyE = new CustomMessageListener(2009001) { // from class: com.baidu.tieba.postsearch.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                e.this.gyB = (ArrayList) data;
                e.this.gxZ.bmN();
            }
        }
    };

    public e(PostSearchActivity postSearchActivity) {
        this.gxZ = postSearchActivity;
        this.gxZ.registerListener(this.gyE);
        this.gxZ.registerListener(this.gyD);
    }

    public boolean aC(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.dDb)) {
            bnd();
        }
        switch (i) {
            case 1:
                return rx(str);
            case 2:
                return ry(str);
            case 3:
                return rz(str);
            default:
                return false;
        }
    }

    public boolean rx(String str) {
        if (this.gyy) {
            return false;
        }
        this.dDb = str;
        this.gyC = 1;
        this.gxZ.sendMessage(tZ(this.gyC));
        this.gyy = true;
        return true;
    }

    public boolean ry(String str) {
        if (this.gyz) {
            return false;
        }
        this.dDb = str;
        this.gyC = 2;
        this.gxZ.sendMessage(tZ(this.gyC));
        this.gyz = true;
        return true;
    }

    public boolean rz(String str) {
        if (this.gyA) {
            return false;
        }
        this.dDb = str;
        this.gyC = 3;
        this.gxZ.sendMessage(tZ(this.gyC));
        this.gyA = true;
        return true;
    }

    public void bna() {
        this.gxZ.sendMessage(new CustomMessage(2009001));
    }

    public void bnb() {
        if (!StringUtils.isNull(this.dDb) && !this.dDb.equals(this.gys)) {
            this.gxZ.sendMessage(new CustomMessage(2009003, this.dDb));
            this.gys = this.dDb;
        }
    }

    public void bnc() {
        if (this.gyB != null) {
            this.gyB.clear();
        }
        this.gxZ.sendMessage(new CustomMessage(2009004));
    }

    public void bnd() {
        this.gyv = 1;
        this.gyw = 1;
        this.gyx = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bne() {
        if (this.gyB == null) {
            this.gyB = new ArrayList<>();
        }
        this.gyB.remove(this.dDb);
        this.gyB.add(0, this.dDb);
        di(this.gyB);
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

    private HttpMessage tZ(int i) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_POST_SEARCH);
        httpMessage.addParam("word", this.dDb);
        httpMessage.addParam(LegoListActivityConfig.RN, 30);
        httpMessage.addParam("kw", this.gxZ.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.gyC));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam("pn", this.gyv);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam("pn", this.gyw);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam("pn", this.gyx);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ua(int i) {
        switch (i) {
            case 1:
                this.gyv++;
                return;
            case 2:
                this.gyw++;
                return;
            case 3:
                this.gyx++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ub(int i) {
        switch (i) {
            case 1:
                return this.gyv;
            case 2:
                return this.gyw;
            case 3:
                return this.gyx;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uc(int i) {
        switch (i) {
            case 1:
                this.gyy = false;
                return;
            case 2:
                this.gyz = false;
                return;
            case 3:
                this.gyA = false;
                return;
            default:
                return;
        }
    }
}
