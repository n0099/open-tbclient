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
    public String bUK;
    private PostSearchActivity cDL;
    private String cEc;
    public ArrayList<String> cEl;
    public int cEd = 0;
    public int cEe = 0;
    public int cEf = 1;
    public int cEg = 1;
    public int cEh = 1;
    public boolean cEi = false;
    public boolean cEj = false;
    public boolean cEk = false;
    private int cEm = 0;
    private final HttpMessageListener cEn = new t(this, CmdConfigHttp.CMD_POST_SEARCH);
    private CustomMessageListener bVo = new u(this, CmdConfigCustom.GET_ALL_SEARCH_POST_DATA);

    public s(PostSearchActivity postSearchActivity) {
        this.cDL = postSearchActivity;
        this.cDL.registerListener(this.bVo);
        this.cDL.registerListener(this.cEn);
    }

    public boolean X(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.bUK)) {
            aow();
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
        if (this.cEi) {
            return false;
        }
        this.bUK = str;
        this.cEm = 1;
        this.cDL.sendMessage(jW(this.cEm));
        this.cEi = true;
        return true;
    }

    public boolean kK(String str) {
        if (this.cEj) {
            return false;
        }
        this.bUK = str;
        this.cEm = 2;
        this.cDL.sendMessage(jW(this.cEm));
        this.cEj = true;
        return true;
    }

    public boolean kL(String str) {
        if (this.cEk) {
            return false;
        }
        this.bUK = str;
        this.cEm = 3;
        this.cDL.sendMessage(jW(this.cEm));
        this.cEk = true;
        return true;
    }

    public void aot() {
        this.cDL.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void aou() {
        if (!StringUtils.isNull(this.bUK) && !this.bUK.equals(this.cEc)) {
            this.cDL.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.bUK));
            this.cEc = this.bUK;
        }
    }

    public void aov() {
        if (this.cEl != null) {
            this.cEl.clear();
        }
        this.cDL.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void aow() {
        this.cEf = 1;
        this.cEg = 1;
        this.cEh = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aox() {
        if (this.cEl == null) {
            this.cEl = new ArrayList<>();
        }
        this.cEl.remove(this.bUK);
        this.cEl.add(0, this.bUK);
        bi(this.cEl);
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
        httpMessage.addParam("word", this.bUK);
        httpMessage.addParam("rn", (Object) 30);
        httpMessage.addParam("kw", this.cDL.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.cEm));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", (Object) 1);
                httpMessage.addParam("only_thread", (Object) 0);
                httpMessage.addParam("pn", Integer.valueOf(this.cEf));
                break;
            case 2:
                httpMessage.addParam("sm", (Object) 2);
                httpMessage.addParam("only_thread", (Object) 0);
                httpMessage.addParam("pn", Integer.valueOf(this.cEg));
                break;
            case 3:
                httpMessage.addParam("sm", (Object) 2);
                httpMessage.addParam("only_thread", (Object) 1);
                httpMessage.addParam("pn", Integer.valueOf(this.cEh));
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jX(int i) {
        switch (i) {
            case 1:
                this.cEf++;
                return;
            case 2:
                this.cEg++;
                return;
            case 3:
                this.cEh++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int jY(int i) {
        switch (i) {
            case 1:
                return this.cEf;
            case 2:
                return this.cEg;
            case 3:
                return this.cEh;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jZ(int i) {
        switch (i) {
            case 1:
                this.cEi = false;
                return;
            case 2:
                this.cEj = false;
                return;
            case 3:
                this.cEk = false;
                return;
            default:
                return;
        }
    }
}
