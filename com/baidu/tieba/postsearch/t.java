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
public class t {
    public String cpN;
    private PostSearchActivity djG;
    private String djY;
    public ArrayList<String> dkh;
    public int djZ = 0;
    public int dka = 0;
    public int dkb = 1;
    public int dkc = 1;
    public int dkd = 1;
    public boolean dke = false;
    public boolean dkf = false;
    public boolean dkg = false;
    private int dki = 0;
    private final HttpMessageListener dkj = new u(this, CmdConfigHttp.CMD_POST_SEARCH);
    private CustomMessageListener cqr = new v(this, CmdConfigCustom.GET_ALL_SEARCH_POST_DATA);

    public t(PostSearchActivity postSearchActivity) {
        this.djG = postSearchActivity;
        this.djG.registerListener(this.cqr);
        this.djG.registerListener(this.dkj);
    }

    public boolean ae(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.cpN)) {
            awD();
        }
        switch (i) {
            case 1:
                return lH(str);
            case 2:
                return lI(str);
            case 3:
                return lJ(str);
            default:
                return false;
        }
    }

    public boolean lH(String str) {
        if (this.dke) {
            return false;
        }
        this.cpN = str;
        this.dki = 1;
        this.djG.sendMessage(lU(this.dki));
        this.dke = true;
        return true;
    }

    public boolean lI(String str) {
        if (this.dkf) {
            return false;
        }
        this.cpN = str;
        this.dki = 2;
        this.djG.sendMessage(lU(this.dki));
        this.dkf = true;
        return true;
    }

    public boolean lJ(String str) {
        if (this.dkg) {
            return false;
        }
        this.cpN = str;
        this.dki = 3;
        this.djG.sendMessage(lU(this.dki));
        this.dkg = true;
        return true;
    }

    public void awA() {
        this.djG.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void awB() {
        if (!StringUtils.isNull(this.cpN) && !this.cpN.equals(this.djY)) {
            this.djG.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.cpN));
            this.djY = this.cpN;
        }
    }

    public void awC() {
        if (this.dkh != null) {
            this.dkh.clear();
        }
        this.djG.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void awD() {
        this.dkb = 1;
        this.dkc = 1;
        this.dkd = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awE() {
        if (this.dkh == null) {
            this.dkh = new ArrayList<>();
        }
        this.dkh.remove(this.cpN);
        this.dkh.add(0, this.cpN);
        bw(this.dkh);
    }

    private void bw(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage lU(int i) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_POST_SEARCH);
        httpMessage.addParam("word", this.cpN);
        httpMessage.addParam("rn", (Object) 30);
        httpMessage.addParam("kw", this.djG.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.dki));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", (Object) 1);
                httpMessage.addParam("only_thread", (Object) 0);
                httpMessage.addParam("pn", Integer.valueOf(this.dkb));
                break;
            case 2:
                httpMessage.addParam("sm", (Object) 2);
                httpMessage.addParam("only_thread", (Object) 0);
                httpMessage.addParam("pn", Integer.valueOf(this.dkc));
                break;
            case 3:
                httpMessage.addParam("sm", (Object) 2);
                httpMessage.addParam("only_thread", (Object) 1);
                httpMessage.addParam("pn", Integer.valueOf(this.dkd));
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lV(int i) {
        switch (i) {
            case 1:
                this.dkb++;
                return;
            case 2:
                this.dkc++;
                return;
            case 3:
                this.dkd++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int lW(int i) {
        switch (i) {
            case 1:
                return this.dkb;
            case 2:
                return this.dkc;
            case 3:
                return this.dkd;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lX(int i) {
        switch (i) {
            case 1:
                this.dke = false;
                return;
            case 2:
                this.dkf = false;
                return;
            case 3:
                this.dkg = false;
                return;
            default:
                return;
        }
    }
}
