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
    public String cLn;
    public ArrayList<String> dSI;
    private PostSearchActivity dSg;
    private String dSz;
    public int dSA = 0;
    public int dSB = 0;
    public int dSC = 1;
    public int dSD = 1;
    public int dSE = 1;
    public boolean dSF = false;
    public boolean dSG = false;
    public boolean dSH = false;
    private int dSJ = 0;
    private final HttpMessageListener dSK = new u(this, CmdConfigHttp.CMD_POST_SEARCH);
    private CustomMessageListener cLR = new v(this, CmdConfigCustom.GET_ALL_SEARCH_POST_DATA);

    public t(PostSearchActivity postSearchActivity) {
        this.dSg = postSearchActivity;
        this.dSg.registerListener(this.cLR);
        this.dSg.registerListener(this.dSK);
    }

    public boolean ap(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.cLn)) {
            aKN();
        }
        switch (i) {
            case 1:
                return nl(str);
            case 2:
                return nm(str);
            case 3:
                return nn(str);
            default:
                return false;
        }
    }

    public boolean nl(String str) {
        if (this.dSF) {
            return false;
        }
        this.cLn = str;
        this.dSJ = 1;
        this.dSg.sendMessage(oe(this.dSJ));
        this.dSF = true;
        return true;
    }

    public boolean nm(String str) {
        if (this.dSG) {
            return false;
        }
        this.cLn = str;
        this.dSJ = 2;
        this.dSg.sendMessage(oe(this.dSJ));
        this.dSG = true;
        return true;
    }

    public boolean nn(String str) {
        if (this.dSH) {
            return false;
        }
        this.cLn = str;
        this.dSJ = 3;
        this.dSg.sendMessage(oe(this.dSJ));
        this.dSH = true;
        return true;
    }

    public void aKK() {
        this.dSg.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void aKL() {
        if (!StringUtils.isNull(this.cLn) && !this.cLn.equals(this.dSz)) {
            this.dSg.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.cLn));
            this.dSz = this.cLn;
        }
    }

    public void aKM() {
        if (this.dSI != null) {
            this.dSI.clear();
        }
        this.dSg.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void aKN() {
        this.dSC = 1;
        this.dSD = 1;
        this.dSE = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKO() {
        if (this.dSI == null) {
            this.dSI = new ArrayList<>();
        }
        this.dSI.remove(this.cLn);
        this.dSI.add(0, this.cLn);
        cc(this.dSI);
    }

    private void cc(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage oe(int i) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_POST_SEARCH);
        httpMessage.addParam("word", this.cLn);
        httpMessage.addParam(LegoListActivityConfig.RN, 30);
        httpMessage.addParam("kw", this.dSg.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.dSJ));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", 1);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam("pn", this.dSC);
                break;
            case 2:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 0);
                httpMessage.addParam("pn", this.dSD);
                break;
            case 3:
                httpMessage.addParam("sm", 2);
                httpMessage.addParam("only_thread", 1);
                httpMessage.addParam("pn", this.dSE);
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void of(int i) {
        switch (i) {
            case 1:
                this.dSC++;
                return;
            case 2:
                this.dSD++;
                return;
            case 3:
                this.dSE++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int og(int i) {
        switch (i) {
            case 1:
                return this.dSC;
            case 2:
                return this.dSD;
            case 3:
                return this.dSE;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oh(int i) {
        switch (i) {
            case 1:
                this.dSF = false;
                return;
            case 2:
                this.dSG = false;
                return;
            case 3:
                this.dSH = false;
                return;
            default:
                return;
        }
    }
}
