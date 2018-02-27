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
    public String dCP;
    private PostSearchActivity gxO;
    private String gyh;
    public ArrayList<String> gyq;
    public int gyi = 0;
    public int gyj = 0;
    public int gyk = 1;
    public int gyl = 1;
    public int gym = 1;
    public boolean gyn = false;
    public boolean gyo = false;
    public boolean gyp = false;
    private int gyr = 0;
    private final HttpMessageListener gys = new HttpMessageListener(CmdConfigHttp.CMD_POST_SEARCH) { // from class: com.baidu.tieba.postsearch.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                e.this.ud(intValue);
                boolean z = e.this.uc(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    e.this.gxO.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    e.this.ub(intValue);
                    e.this.bna();
                    e.this.bnd();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = e.this.gxO.getResources().getString(d.j.neterror);
                }
                e.this.gxO.showToast(errorString);
                e.this.gxO.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener gyt = new CustomMessageListener(2009001) { // from class: com.baidu.tieba.postsearch.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                e.this.gyq = (ArrayList) data;
                e.this.gxO.bmM();
            }
        }
    };

    public e(PostSearchActivity postSearchActivity) {
        this.gxO = postSearchActivity;
        this.gxO.registerListener(this.gyt);
        this.gxO.registerListener(this.gys);
    }

    public boolean aC(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.dCP)) {
            bnc();
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
        if (this.gyn) {
            return false;
        }
        this.dCP = str;
        this.gyr = 1;
        this.gxO.sendMessage(ua(this.gyr));
        this.gyn = true;
        return true;
    }

    public boolean ry(String str) {
        if (this.gyo) {
            return false;
        }
        this.dCP = str;
        this.gyr = 2;
        this.gxO.sendMessage(ua(this.gyr));
        this.gyo = true;
        return true;
    }

    public boolean rz(String str) {
        if (this.gyp) {
            return false;
        }
        this.dCP = str;
        this.gyr = 3;
        this.gxO.sendMessage(ua(this.gyr));
        this.gyp = true;
        return true;
    }

    public void bmZ() {
        this.gxO.sendMessage(new CustomMessage(2009001));
    }

    public void bna() {
        if (!StringUtils.isNull(this.dCP) && !this.dCP.equals(this.gyh)) {
            this.gxO.sendMessage(new CustomMessage(2009003, this.dCP));
            this.gyh = this.dCP;
        }
    }

    public void bnb() {
        if (this.gyq != null) {
            this.gyq.clear();
        }
        this.gxO.sendMessage(new CustomMessage(2009004));
    }

    public void bnc() {
        this.gyk = 1;
        this.gyl = 1;
        this.gym = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnd() {
        if (this.gyq == null) {
            this.gyq = new ArrayList<>();
        }
        this.gyq.remove(this.dCP);
        this.gyq.add(0, this.dCP);
        di(this.gyq);
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

    private HttpMessage ua(int i) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_POST_SEARCH);
        httpMessage.addParam("word", this.dCP);
        httpMessage.addParam(LegoListActivityConfig.RN, 30);
        httpMessage.addParam("kw", this.gxO.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.gyr));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam("pn", this.gyk);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam("pn", this.gyl);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam("pn", this.gym);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ub(int i) {
        switch (i) {
            case 1:
                this.gyk++;
                return;
            case 2:
                this.gyl++;
                return;
            case 3:
                this.gym++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int uc(int i) {
        switch (i) {
            case 1:
                return this.gyk;
            case 2:
                return this.gyl;
            case 3:
                return this.gym;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ud(int i) {
        switch (i) {
            case 1:
                this.gyn = false;
                return;
            case 2:
                this.gyo = false;
                return;
            case 3:
                this.gyp = false;
                return;
            default:
                return;
        }
    }
}
