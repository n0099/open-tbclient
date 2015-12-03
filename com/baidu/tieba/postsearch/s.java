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
    public String clJ;
    public ArrayList<String> deB;
    private PostSearchActivity deb;
    private String des;
    public int det = 0;
    public int deu = 0;
    public int dev = 1;
    public int dew = 1;
    public int dex = 1;
    public boolean dey = false;
    public boolean dez = false;
    public boolean deA = false;
    private int deC = 0;
    private final HttpMessageListener deD = new t(this, CmdConfigHttp.CMD_POST_SEARCH);
    private CustomMessageListener cmo = new u(this, CmdConfigCustom.GET_ALL_SEARCH_POST_DATA);

    public s(PostSearchActivity postSearchActivity) {
        this.deb = postSearchActivity;
        this.deb.registerListener(this.cmo);
        this.deb.registerListener(this.deD);
    }

    public boolean ad(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.clJ)) {
            auK();
        }
        switch (i) {
            case 1:
                return lK(str);
            case 2:
                return lL(str);
            case 3:
                return lM(str);
            default:
                return false;
        }
    }

    public boolean lK(String str) {
        if (this.dey) {
            return false;
        }
        this.clJ = str;
        this.deC = 1;
        this.deb.sendMessage(lv(this.deC));
        this.dey = true;
        return true;
    }

    public boolean lL(String str) {
        if (this.dez) {
            return false;
        }
        this.clJ = str;
        this.deC = 2;
        this.deb.sendMessage(lv(this.deC));
        this.dez = true;
        return true;
    }

    public boolean lM(String str) {
        if (this.deA) {
            return false;
        }
        this.clJ = str;
        this.deC = 3;
        this.deb.sendMessage(lv(this.deC));
        this.deA = true;
        return true;
    }

    public void auH() {
        this.deb.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void auI() {
        if (!StringUtils.isNull(this.clJ) && !this.clJ.equals(this.des)) {
            this.deb.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.clJ));
            this.des = this.clJ;
        }
    }

    public void auJ() {
        if (this.deB != null) {
            this.deB.clear();
        }
        this.deb.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void auK() {
        this.dev = 1;
        this.dew = 1;
        this.dex = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auL() {
        if (this.deB == null) {
            this.deB = new ArrayList<>();
        }
        this.deB.remove(this.clJ);
        this.deB.add(0, this.clJ);
        by(this.deB);
    }

    private void by(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage lv(int i) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_POST_SEARCH);
        httpMessage.addParam("word", this.clJ);
        httpMessage.addParam("rn", (Object) 30);
        httpMessage.addParam("kw", this.deb.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.deC));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", (Object) 1);
                httpMessage.addParam("only_thread", (Object) 0);
                httpMessage.addParam("pn", Integer.valueOf(this.dev));
                break;
            case 2:
                httpMessage.addParam("sm", (Object) 2);
                httpMessage.addParam("only_thread", (Object) 0);
                httpMessage.addParam("pn", Integer.valueOf(this.dew));
                break;
            case 3:
                httpMessage.addParam("sm", (Object) 2);
                httpMessage.addParam("only_thread", (Object) 1);
                httpMessage.addParam("pn", Integer.valueOf(this.dex));
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lw(int i) {
        switch (i) {
            case 1:
                this.dev++;
                return;
            case 2:
                this.dew++;
                return;
            case 3:
                this.dex++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int lx(int i) {
        switch (i) {
            case 1:
                return this.dev;
            case 2:
                return this.dew;
            case 3:
                return this.dex;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ly(int i) {
        switch (i) {
            case 1:
                this.dey = false;
                return;
            case 2:
                this.dez = false;
                return;
            case 3:
                this.deA = false;
                return;
            default:
                return;
        }
    }
}
