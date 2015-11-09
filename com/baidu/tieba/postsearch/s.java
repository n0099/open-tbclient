package com.baidu.tieba.postsearch;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class s {
    public String bVw;
    private String cFJ;
    public ArrayList<String> cFS;
    private PostSearchActivity cFs;
    public int cFK = 0;
    public int cFL = 0;
    public int cFM = 1;
    public int cFN = 1;
    public int cFO = 1;
    public boolean cFP = false;
    public boolean cFQ = false;
    public boolean cFR = false;
    private int cFT = 0;
    private final HttpMessageListener cFU = new t(this, CmdConfigHttp.CMD_POST_SEARCH);
    private CustomMessageListener bWa = new u(this, CmdConfigCustom.GET_ALL_SEARCH_POST_DATA);

    public s(PostSearchActivity postSearchActivity) {
        this.cFs = postSearchActivity;
        this.cFs.registerListener(this.bWa);
        this.cFs.registerListener(this.cFU);
    }

    public boolean X(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.bVw)) {
            aoY();
        }
        switch (i) {
            case 1:
                return kN(str);
            case 2:
                return kO(str);
            case 3:
                return kP(str);
            default:
                return false;
        }
    }

    public boolean kN(String str) {
        if (this.cFP) {
            return false;
        }
        this.bVw = str;
        this.cFT = 1;
        this.cFs.sendMessage(kk(this.cFT));
        this.cFP = true;
        return true;
    }

    public boolean kO(String str) {
        if (this.cFQ) {
            return false;
        }
        this.bVw = str;
        this.cFT = 2;
        this.cFs.sendMessage(kk(this.cFT));
        this.cFQ = true;
        return true;
    }

    public boolean kP(String str) {
        if (this.cFR) {
            return false;
        }
        this.bVw = str;
        this.cFT = 3;
        this.cFs.sendMessage(kk(this.cFT));
        this.cFR = true;
        return true;
    }

    public void aoV() {
        this.cFs.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void aoW() {
        if (!StringUtils.isNull(this.bVw) && !this.bVw.equals(this.cFJ)) {
            this.cFs.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.bVw));
            this.cFJ = this.bVw;
        }
    }

    public void aoX() {
        if (this.cFS != null) {
            this.cFS.clear();
        }
        this.cFs.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void aoY() {
        this.cFM = 1;
        this.cFN = 1;
        this.cFO = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoZ() {
        if (this.cFS == null) {
            this.cFS = new ArrayList<>();
        }
        this.cFS.remove(this.bVw);
        this.cFS.add(0, this.bVw);
        bm(this.cFS);
    }

    private void bm(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage kk(int i) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_POST_SEARCH);
        httpMessage.addParam("word", this.bVw);
        httpMessage.addParam("rn", (Object) 30);
        httpMessage.addParam("kw", this.cFs.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.cFT));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", (Object) 1);
                httpMessage.addParam("only_thread", (Object) 0);
                httpMessage.addParam("pn", Integer.valueOf(this.cFM));
                break;
            case 2:
                httpMessage.addParam("sm", (Object) 2);
                httpMessage.addParam("only_thread", (Object) 0);
                httpMessage.addParam("pn", Integer.valueOf(this.cFN));
                break;
            case 3:
                httpMessage.addParam("sm", (Object) 2);
                httpMessage.addParam("only_thread", (Object) 1);
                httpMessage.addParam("pn", Integer.valueOf(this.cFO));
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kl(int i) {
        switch (i) {
            case 1:
                this.cFM++;
                return;
            case 2:
                this.cFN++;
                return;
            case 3:
                this.cFO++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int km(int i) {
        switch (i) {
            case 1:
                return this.cFM;
            case 2:
                return this.cFN;
            case 3:
                return this.cFO;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kn(int i) {
        switch (i) {
            case 1:
                this.cFP = false;
                return;
            case 2:
                this.cFQ = false;
                return;
            case 3:
                this.cFR = false;
                return;
            default:
                return;
        }
    }
}
