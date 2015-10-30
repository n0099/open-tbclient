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
    public String bUV;
    private PostSearchActivity cDW;
    private String cEn;
    public ArrayList<String> cEw;
    public int cEo = 0;
    public int cEp = 0;
    public int cEq = 1;
    public int cEr = 1;
    public int cEs = 1;
    public boolean cEt = false;
    public boolean cEu = false;
    public boolean cEv = false;
    private int cEx = 0;
    private final HttpMessageListener cEy = new t(this, CmdConfigHttp.CMD_POST_SEARCH);
    private CustomMessageListener bVz = new u(this, CmdConfigCustom.GET_ALL_SEARCH_POST_DATA);

    public s(PostSearchActivity postSearchActivity) {
        this.cDW = postSearchActivity;
        this.cDW.registerListener(this.bVz);
        this.cDW.registerListener(this.cEy);
    }

    public boolean X(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.bUV)) {
            aos();
        }
        switch (i) {
            case 1:
                return kJ(str);
            case 2:
                return kK(str);
            case 3:
                return kL(str);
            default:
                return false;
        }
    }

    public boolean kJ(String str) {
        if (this.cEt) {
            return false;
        }
        this.bUV = str;
        this.cEx = 1;
        this.cDW.sendMessage(jW(this.cEx));
        this.cEt = true;
        return true;
    }

    public boolean kK(String str) {
        if (this.cEu) {
            return false;
        }
        this.bUV = str;
        this.cEx = 2;
        this.cDW.sendMessage(jW(this.cEx));
        this.cEu = true;
        return true;
    }

    public boolean kL(String str) {
        if (this.cEv) {
            return false;
        }
        this.bUV = str;
        this.cEx = 3;
        this.cDW.sendMessage(jW(this.cEx));
        this.cEv = true;
        return true;
    }

    public void aop() {
        this.cDW.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void aoq() {
        if (!StringUtils.isNull(this.bUV) && !this.bUV.equals(this.cEn)) {
            this.cDW.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.bUV));
            this.cEn = this.bUV;
        }
    }

    public void aor() {
        if (this.cEw != null) {
            this.cEw.clear();
        }
        this.cDW.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void aos() {
        this.cEq = 1;
        this.cEr = 1;
        this.cEs = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aot() {
        if (this.cEw == null) {
            this.cEw = new ArrayList<>();
        }
        this.cEw.remove(this.bUV);
        this.cEw.add(0, this.bUV);
        bi(this.cEw);
    }

    private void bi(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage jW(int i) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_POST_SEARCH);
        httpMessage.addParam("word", this.bUV);
        httpMessage.addParam("rn", (Object) 30);
        httpMessage.addParam("kw", this.cDW.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.cEx));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", (Object) 1);
                httpMessage.addParam("only_thread", (Object) 0);
                httpMessage.addParam("pn", Integer.valueOf(this.cEq));
                break;
            case 2:
                httpMessage.addParam("sm", (Object) 2);
                httpMessage.addParam("only_thread", (Object) 0);
                httpMessage.addParam("pn", Integer.valueOf(this.cEr));
                break;
            case 3:
                httpMessage.addParam("sm", (Object) 2);
                httpMessage.addParam("only_thread", (Object) 1);
                httpMessage.addParam("pn", Integer.valueOf(this.cEs));
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jX(int i) {
        switch (i) {
            case 1:
                this.cEq++;
                return;
            case 2:
                this.cEr++;
                return;
            case 3:
                this.cEs++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int jY(int i) {
        switch (i) {
            case 1:
                return this.cEq;
            case 2:
                return this.cEr;
            case 3:
                return this.cEs;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jZ(int i) {
        switch (i) {
            case 1:
                this.cEt = false;
                return;
            case 2:
                this.cEu = false;
                return;
            case 3:
                this.cEv = false;
                return;
            default:
                return;
        }
    }
}
