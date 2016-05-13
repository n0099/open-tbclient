package com.baidu.tieba.postsearch;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    public String cMj;
    private PostSearchActivity dUY;
    public ArrayList<String> dVA;
    private String dVr;
    public int dVs = 0;
    public int dVt = 0;
    public int dVu = 1;
    public int dVv = 1;
    public int dVw = 1;
    public boolean dVx = false;
    public boolean dVy = false;
    public boolean dVz = false;
    private int dVB = 0;
    private final HttpMessageListener dVC = new u(this, CmdConfigHttp.CMD_POST_SEARCH);
    private CustomMessageListener cMN = new v(this, CmdConfigCustom.GET_ALL_SEARCH_POST_DATA);

    public t(PostSearchActivity postSearchActivity) {
        this.dUY = postSearchActivity;
        this.dUY.registerListener(this.cMN);
        this.dUY.registerListener(this.dVC);
    }

    public boolean au(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.cMj)) {
            aKU();
        }
        switch (i) {
            case 1:
                return nk(str);
            case 2:
                return nl(str);
            case 3:
                return nm(str);
            default:
                return false;
        }
    }

    public boolean nk(String str) {
        if (this.dVx) {
            return false;
        }
        this.cMj = str;
        this.dVB = 1;
        this.dUY.sendMessage(nT(this.dVB));
        this.dVx = true;
        return true;
    }

    public boolean nl(String str) {
        if (this.dVy) {
            return false;
        }
        this.cMj = str;
        this.dVB = 2;
        this.dUY.sendMessage(nT(this.dVB));
        this.dVy = true;
        return true;
    }

    public boolean nm(String str) {
        if (this.dVz) {
            return false;
        }
        this.cMj = str;
        this.dVB = 3;
        this.dUY.sendMessage(nT(this.dVB));
        this.dVz = true;
        return true;
    }

    public void aKR() {
        this.dUY.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void aKS() {
        if (!StringUtils.isNull(this.cMj) && !this.cMj.equals(this.dVr)) {
            this.dUY.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.cMj));
            this.dVr = this.cMj;
        }
    }

    public void aKT() {
        if (this.dVA != null) {
            this.dVA.clear();
        }
        this.dUY.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void aKU() {
        this.dVu = 1;
        this.dVv = 1;
        this.dVw = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKV() {
        if (this.dVA == null) {
            this.dVA = new ArrayList<>();
        }
        this.dVA.remove(this.cMj);
        this.dVA.add(0, this.cMj);
        ce(this.dVA);
    }

    private void ce(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage nT(int i) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_POST_SEARCH);
        httpMessage.addParam("word", this.cMj);
        httpMessage.addParam(LegoListActivityConfig.RN, 30);
        httpMessage.addParam("kw", this.dUY.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.dVB));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam("pn", this.dVu);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam("pn", this.dVv);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam("pn", this.dVw);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nU(int i) {
        switch (i) {
            case 1:
                this.dVu++;
                return;
            case 2:
                this.dVv++;
                return;
            case 3:
                this.dVw++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int nV(int i) {
        switch (i) {
            case 1:
                return this.dVu;
            case 2:
                return this.dVv;
            case 3:
                return this.dVw;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nW(int i) {
        switch (i) {
            case 1:
                this.dVx = false;
                return;
            case 2:
                this.dVy = false;
                return;
            case 3:
                this.dVz = false;
                return;
            default:
                return;
        }
    }
}
