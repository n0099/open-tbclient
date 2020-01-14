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
    private String jAj;
    public ArrayList<String> jAs;
    private PostSearchActivity jzQ;
    public int jAk = 0;
    public int jAl = 0;
    public int jAm = 1;
    public int jAn = 1;
    public int jAo = 1;
    public boolean jAp = false;
    public boolean jAq = false;
    public boolean jAr = false;
    private int jAt = 0;
    private final HttpMessageListener jAu = new HttpMessageListener(1003016) { // from class: com.baidu.tieba.postsearch.d.1
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
                    d.this.jzQ.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.As(intValue);
                    d.this.czp();
                    d.this.czs();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.jzQ.getResources().getString(R.string.neterror);
                }
                d.this.jzQ.showToast(errorString);
                d.this.jzQ.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener jAv = new CustomMessageListener(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.jAs = (ArrayList) data;
                d.this.jzQ.czb();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.jzQ = postSearchActivity;
        this.jzQ.registerListener(this.jAv);
        this.jzQ.registerListener(this.jAu);
    }

    public boolean bo(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.gkm)) {
            czr();
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
        if (this.jAp) {
            return false;
        }
        this.gkm = str;
        this.jAt = 1;
        this.jzQ.sendMessage(Ar(this.jAt));
        this.jAp = true;
        return true;
    }

    public boolean Ha(String str) {
        if (this.jAq) {
            return false;
        }
        this.gkm = str;
        this.jAt = 2;
        this.jzQ.sendMessage(Ar(this.jAt));
        this.jAq = true;
        return true;
    }

    public boolean Hb(String str) {
        if (this.jAr) {
            return false;
        }
        this.gkm = str;
        this.jAt = 3;
        this.jzQ.sendMessage(Ar(this.jAt));
        this.jAr = true;
        return true;
    }

    public void czo() {
        this.jzQ.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void czp() {
        if (!StringUtils.isNull(this.gkm) && !this.gkm.equals(this.jAj)) {
            this.jzQ.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.gkm));
            this.jAj = this.gkm;
        }
    }

    public void czq() {
        if (this.jAs != null) {
            this.jAs.clear();
        }
        this.jzQ.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void czr() {
        this.jAm = 1;
        this.jAn = 1;
        this.jAo = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czs() {
        if (this.jAs == null) {
            this.jAs = new ArrayList<>();
        }
        this.jAs.remove(this.gkm);
        this.jAs.add(0, this.gkm);
        ec(this.jAs);
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
        httpMessage.addParam("kw", this.jzQ.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.jAt));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.jAm);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.jAn);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.jAo);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void As(int i) {
        switch (i) {
            case 1:
                this.jAm++;
                return;
            case 2:
                this.jAn++;
                return;
            case 3:
                this.jAo++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int At(int i) {
        switch (i) {
            case 1:
                return this.jAm;
            case 2:
                return this.jAn;
            case 3:
                return this.jAo;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Au(int i) {
        switch (i) {
            case 1:
                this.jAp = false;
                return;
            case 2:
                this.jAq = false;
                return;
            case 3:
                this.jAr = false;
                return;
            default:
                return;
        }
    }
}
