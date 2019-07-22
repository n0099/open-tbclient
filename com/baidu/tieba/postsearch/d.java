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
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class d {
    public String frY;
    private PostSearchActivity iAZ;
    public ArrayList<String> iBB;
    private String iBs;
    public int iBt = 0;
    public int iBu = 0;
    public int iBv = 1;
    public int iBw = 1;
    public int iBx = 1;
    public boolean iBy = false;
    public boolean iBz = false;
    public boolean iBA = false;
    private int iBC = 0;
    private final HttpMessageListener iBD = new HttpMessageListener(CmdConfigHttp.CMD_POST_SEARCH) { // from class: com.baidu.tieba.postsearch.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
                d.this.zk(intValue);
                boolean z = d.this.zj(intValue) > 1;
                PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    d.this.iAZ.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                    d.this.zi(intValue);
                    d.this.cgk();
                    d.this.cgn();
                    return;
                }
                String errorString = postSearchHttpResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = d.this.iAZ.getResources().getString(R.string.neterror);
                }
                d.this.iAZ.showToast(errorString);
                d.this.iAZ.a(intValue, null, z);
            }
        }
    };
    private CustomMessageListener iBE = new CustomMessageListener(2009001) { // from class: com.baidu.tieba.postsearch.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof ArrayList)) {
                d.this.iBB = (ArrayList) data;
                d.this.iAZ.cfW();
            }
        }
    };

    public d(PostSearchActivity postSearchActivity) {
        this.iAZ = postSearchActivity;
        this.iAZ.registerListener(this.iBE);
        this.iAZ.registerListener(this.iBD);
    }

    public boolean bh(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.frY)) {
            cgm();
        }
        switch (i) {
            case 1:
                return Dk(str);
            case 2:
                return Dl(str);
            case 3:
                return Dm(str);
            default:
                return false;
        }
    }

    public boolean Dk(String str) {
        if (this.iBy) {
            return false;
        }
        this.frY = str;
        this.iBC = 1;
        this.iAZ.sendMessage(zh(this.iBC));
        this.iBy = true;
        return true;
    }

    public boolean Dl(String str) {
        if (this.iBz) {
            return false;
        }
        this.frY = str;
        this.iBC = 2;
        this.iAZ.sendMessage(zh(this.iBC));
        this.iBz = true;
        return true;
    }

    public boolean Dm(String str) {
        if (this.iBA) {
            return false;
        }
        this.frY = str;
        this.iBC = 3;
        this.iAZ.sendMessage(zh(this.iBC));
        this.iBA = true;
        return true;
    }

    public void cgj() {
        this.iAZ.sendMessage(new CustomMessage(2009001));
    }

    public void cgk() {
        if (!StringUtils.isNull(this.frY) && !this.frY.equals(this.iBs)) {
            this.iAZ.sendMessage(new CustomMessage(2009003, this.frY));
            this.iBs = this.frY;
        }
    }

    public void cgl() {
        if (this.iBB != null) {
            this.iBB.clear();
        }
        this.iAZ.sendMessage(new CustomMessage(2009004));
    }

    public void cgm() {
        this.iBv = 1;
        this.iBw = 1;
        this.iBx = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgn() {
        if (this.iBB == null) {
            this.iBB = new ArrayList<>();
        }
        this.iBB.remove(this.frY);
        this.iBB.add(0, this.frY);
        dY(this.iBB);
    }

    private void dY(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage zh(int i) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_POST_SEARCH);
        httpMessage.addParam("word", this.frY);
        httpMessage.addParam("rn", 30);
        httpMessage.addParam("kw", this.iAZ.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.iBC));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.iBv);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam(Config.PACKAGE_NAME, this.iBw);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam(Config.PACKAGE_NAME, this.iBx);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zi(int i) {
        switch (i) {
            case 1:
                this.iBv++;
                return;
            case 2:
                this.iBw++;
                return;
            case 3:
                this.iBx++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int zj(int i) {
        switch (i) {
            case 1:
                return this.iBv;
            case 2:
                return this.iBw;
            case 3:
                return this.iBx;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zk(int i) {
        switch (i) {
            case 1:
                this.iBy = false;
                return;
            case 2:
                this.iBz = false;
                return;
            case 3:
                this.iBA = false;
                return;
            default:
                return;
        }
    }
}
