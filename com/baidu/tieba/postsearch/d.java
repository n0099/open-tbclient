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
/* loaded from: classes11.dex */
public class d {
    public String gWw;
    private PostSearchActivity kmC;
    private String kmV;
    public ArrayList<String> kne;
    public int kmW = 0;
    public int kmX = 0;
    public int kmY = 1;
    public int kmZ = 1;
    public int kna = 1;
    public boolean knb = false;
    public boolean knc = false;
    public boolean knd = false;
    private int knf = 0;
    private final HttpMessageListener kng = new HttpMessageListener(1003016) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.Bm(intValue);
                boolean z = d.this.Bl(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.kmC.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.Bk(intValue);
                    d.this.cLQ();
                    d.this.cLT();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.kmC.getResources().getString(R.string.neterror);
                }
                d.this.kmC.showToast(errorString);
                d.this.kmC.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener knh = new CustomMessageListener(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.kne = (ArrayList) data;
                d.this.kmC.cLC();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.kmC = postSearchActivity;
        this.kmC.registerListener(this.knh);
        this.kmC.registerListener(this.kng);
    }

    public boolean bw(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.gWw)) {
            cLS();
        }
        switch (i) {
            case 1:
                return IY(str);
            case 2:
                return IZ(str);
            case 3:
                return Ja(str);
            default:
                return false;
        }
    }

    public boolean IY(String str) {
        if (this.knb) {
            return false;
        }
        this.gWw = str;
        this.knf = 1;
        this.kmC.sendMessage(Bj(this.knf));
        this.knb = true;
        return true;
    }

    public boolean IZ(String str) {
        if (this.knc) {
            return false;
        }
        this.gWw = str;
        this.knf = 2;
        this.kmC.sendMessage(Bj(this.knf));
        this.knc = true;
        return true;
    }

    public boolean Ja(String str) {
        if (this.knd) {
            return false;
        }
        this.gWw = str;
        this.knf = 3;
        this.kmC.sendMessage(Bj(this.knf));
        this.knd = true;
        return true;
    }

    public void cLP() {
        this.kmC.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void cLQ() {
        if (!StringUtils.isNull(this.gWw) && !this.gWw.equals(this.kmV)) {
            this.kmC.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.gWw));
            this.kmV = this.gWw;
        }
    }

    public void cLR() {
        if (this.kne != null) {
            this.kne.clear();
        }
        this.kmC.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void cLS() {
        this.kmY = 1;
        this.kmZ = 1;
        this.kna = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLT() {
        if (this.kne == null) {
            this.kne = new ArrayList<>();
        }
        this.kne.remove(this.gWw);
        this.kne.add(0, this.gWw);
        ek(this.kne);
    }

    private void ek(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage Bj(int i) {
        HttpMessage httpMessage = new HttpMessage(1003016);
        httpMessage.addParam("word", this.gWw);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.kmC.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.knf));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.kmY);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.kmZ);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.kna);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bk(int i) {
        switch (i) {
            case 1:
                this.kmY++;
                return;
            case 2:
                this.kmZ++;
                return;
            case 3:
                this.kna++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Bl(int i) {
        switch (i) {
            case 1:
                return this.kmY;
            case 2:
                return this.kmZ;
            case 3:
                return this.kna;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bm(int i) {
        switch (i) {
            case 1:
                this.knb = false;
                return;
            case 2:
                this.knc = false;
                return;
            case 3:
                this.knd = false;
                return;
            default:
                return;
        }
    }
}
