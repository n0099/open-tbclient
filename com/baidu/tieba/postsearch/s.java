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
    public String bQt;
    private PostSearchActivity coG;
    private String coX;
    public ArrayList<String> cpg;
    public int coY = 0;
    public int coZ = 0;
    public int cpa = 1;
    public int cpb = 1;
    public int cpc = 1;
    public boolean cpd = false;
    public boolean cpe = false;
    public boolean cpf = false;
    private int cph = 0;
    private final HttpMessageListener cpi = new t(this, CmdConfigHttp.CMD_POST_SEARCH);
    private CustomMessageListener bQX = new u(this, CmdConfigCustom.GET_ALL_SEARCH_POST_DATA);

    public s(PostSearchActivity postSearchActivity) {
        this.coG = postSearchActivity;
        this.coG.registerListener(this.bQX);
        this.coG.registerListener(this.cpi);
    }

    public boolean T(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.bQt)) {
            aii();
        }
        switch (i) {
            case 1:
                return jG(str);
            case 2:
                return jH(str);
            case 3:
                return jI(str);
            default:
                return false;
        }
    }

    public boolean jG(String str) {
        if (this.cpd) {
            return false;
        }
        this.bQt = str;
        this.cph = 1;
        this.coG.sendMessage(iR(this.cph));
        this.cpd = true;
        return true;
    }

    public boolean jH(String str) {
        if (this.cpe) {
            return false;
        }
        this.bQt = str;
        this.cph = 2;
        this.coG.sendMessage(iR(this.cph));
        this.cpe = true;
        return true;
    }

    public boolean jI(String str) {
        if (this.cpf) {
            return false;
        }
        this.bQt = str;
        this.cph = 3;
        this.coG.sendMessage(iR(this.cph));
        this.cpf = true;
        return true;
    }

    public void aif() {
        this.coG.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void aig() {
        if (!StringUtils.isNull(this.bQt) && !this.bQt.equals(this.coX)) {
            this.coG.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.bQt));
            this.coX = this.bQt;
        }
    }

    public void aih() {
        if (this.cpg != null) {
            this.cpg.clear();
        }
        this.coG.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void aii() {
        this.cpa = 1;
        this.cpb = 1;
        this.cpc = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aij() {
        if (this.cpg == null) {
            this.cpg = new ArrayList<>();
        }
        this.cpg.remove(this.bQt);
        this.cpg.add(0, this.bQt);
        aZ(this.cpg);
    }

    private void aZ(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage iR(int i) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_POST_SEARCH);
        httpMessage.addParam("word", this.bQt);
        httpMessage.addParam("rn", (Object) 30);
        httpMessage.addParam("kw", this.coG.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.cph));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", (Object) 1);
                httpMessage.addParam("only_thread", (Object) 0);
                httpMessage.addParam("pn", Integer.valueOf(this.cpa));
                break;
            case 2:
                httpMessage.addParam("sm", (Object) 2);
                httpMessage.addParam("only_thread", (Object) 0);
                httpMessage.addParam("pn", Integer.valueOf(this.cpb));
                break;
            case 3:
                httpMessage.addParam("sm", (Object) 2);
                httpMessage.addParam("only_thread", (Object) 1);
                httpMessage.addParam("pn", Integer.valueOf(this.cpc));
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iS(int i) {
        switch (i) {
            case 1:
                this.cpa++;
                return;
            case 2:
                this.cpb++;
                return;
            case 3:
                this.cpc++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int iT(int i) {
        switch (i) {
            case 1:
                return this.cpa;
            case 2:
                return this.cpb;
            case 3:
                return this.cpc;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iU(int i) {
        switch (i) {
            case 1:
                this.cpd = false;
                return;
            case 2:
                this.cpe = false;
                return;
            case 3:
                this.cpf = false;
                return;
            default:
                return;
        }
    }
}
