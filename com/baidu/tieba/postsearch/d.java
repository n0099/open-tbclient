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
/* loaded from: classes9.dex */
public class d {
    public String gkm;
    private String jAe;
    public ArrayList<String> jAn;
    private PostSearchActivity jzL;
    public int jAf = 0;
    public int jAg = 0;
    public int jAh = 1;
    public int jAi = 1;
    public int jAj = 1;
    public boolean jAk = false;
    public boolean jAl = false;
    public boolean jAm = false;
    private int jAo = 0;
    private final HttpMessageListener jAp = new HttpMessageListener(1003016) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.Au(intValue);
                boolean z = d.this.At(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.jzL.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.As(intValue);
                    d.this.czn();
                    d.this.czq();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.jzL.getResources().getString(R.string.neterror);
                }
                d.this.jzL.showToast(errorString);
                d.this.jzL.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener jAq = new CustomMessageListener(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.jAn = (ArrayList) data;
                d.this.jzL.cyZ();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.jzL = postSearchActivity;
        this.jzL.registerListener(this.jAq);
        this.jzL.registerListener(this.jAp);
    }

    public boolean bo(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.gkm)) {
            czp();
        }
        switch (i) {
            case 1:
                return GZ(str);
            case 2:
                return Ha(str);
            case 3:
                return Hb(str);
            default:
                return false;
        }
    }

    public boolean GZ(String str) {
        if (this.jAk) {
            return false;
        }
        this.gkm = str;
        this.jAo = 1;
        this.jzL.sendMessage(Ar(this.jAo));
        this.jAk = true;
        return true;
    }

    public boolean Ha(String str) {
        if (this.jAl) {
            return false;
        }
        this.gkm = str;
        this.jAo = 2;
        this.jzL.sendMessage(Ar(this.jAo));
        this.jAl = true;
        return true;
    }

    public boolean Hb(String str) {
        if (this.jAm) {
            return false;
        }
        this.gkm = str;
        this.jAo = 3;
        this.jzL.sendMessage(Ar(this.jAo));
        this.jAm = true;
        return true;
    }

    public void czm() {
        this.jzL.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void czn() {
        if (!StringUtils.isNull(this.gkm) && !this.gkm.equals(this.jAe)) {
            this.jzL.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.gkm));
            this.jAe = this.gkm;
        }
    }

    public void czo() {
        if (this.jAn != null) {
            this.jAn.clear();
        }
        this.jzL.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void czp() {
        this.jAh = 1;
        this.jAi = 1;
        this.jAj = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czq() {
        if (this.jAn == null) {
            this.jAn = new ArrayList<>();
        }
        this.jAn.remove(this.gkm);
        this.jAn.add(0, this.gkm);
        ec(this.jAn);
    }

    private void ec(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage Ar(int i) {
        HttpMessage httpMessage = new HttpMessage(1003016);
        httpMessage.addParam("word", this.gkm);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.jzL.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.jAo));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.jAh);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.jAi);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.jAj);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void As(int i) {
        switch (i) {
            case 1:
                this.jAh++;
                return;
            case 2:
                this.jAi++;
                return;
            case 3:
                this.jAj++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int At(int i) {
        switch (i) {
            case 1:
                return this.jAh;
            case 2:
                return this.jAi;
            case 3:
                return this.jAj;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Au(int i) {
        switch (i) {
            case 1:
                this.jAk = false;
                return;
            case 2:
                this.jAl = false;
                return;
            case 3:
                this.jAm = false;
                return;
            default:
                return;
        }
    }
}
