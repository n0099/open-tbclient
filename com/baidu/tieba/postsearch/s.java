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
    public String bQZ;
    public ArrayList<String> cxD;
    private PostSearchActivity cxd;
    private String cxu;
    public int cxv = 0;
    public int cxw = 0;
    public int cxx = 1;
    public int cxy = 1;
    public int cxz = 1;
    public boolean cxA = false;
    public boolean cxB = false;
    public boolean cxC = false;
    private int cxE = 0;
    private final HttpMessageListener cxF = new t(this, CmdConfigHttp.CMD_POST_SEARCH);
    private CustomMessageListener bRD = new u(this, CmdConfigCustom.GET_ALL_SEARCH_POST_DATA);

    public s(PostSearchActivity postSearchActivity) {
        this.cxd = postSearchActivity;
        this.cxd.registerListener(this.bRD);
        this.cxd.registerListener(this.cxF);
    }

    public boolean V(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.bQZ)) {
            amm();
        }
        switch (i) {
            case 1:
                return kl(str);
            case 2:
                return km(str);
            case 3:
                return kn(str);
            default:
                return false;
        }
    }

    public boolean kl(String str) {
        if (this.cxA) {
            return false;
        }
        this.bQZ = str;
        this.cxE = 1;
        this.cxd.sendMessage(jB(this.cxE));
        this.cxA = true;
        return true;
    }

    public boolean km(String str) {
        if (this.cxB) {
            return false;
        }
        this.bQZ = str;
        this.cxE = 2;
        this.cxd.sendMessage(jB(this.cxE));
        this.cxB = true;
        return true;
    }

    public boolean kn(String str) {
        if (this.cxC) {
            return false;
        }
        this.bQZ = str;
        this.cxE = 3;
        this.cxd.sendMessage(jB(this.cxE));
        this.cxC = true;
        return true;
    }

    public void amj() {
        this.cxd.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void amk() {
        if (!StringUtils.isNull(this.bQZ) && !this.bQZ.equals(this.cxu)) {
            this.cxd.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.bQZ));
            this.cxu = this.bQZ;
        }
    }

    public void aml() {
        if (this.cxD != null) {
            this.cxD.clear();
        }
        this.cxd.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void amm() {
        this.cxx = 1;
        this.cxy = 1;
        this.cxz = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amn() {
        if (this.cxD == null) {
            this.cxD = new ArrayList<>();
        }
        this.cxD.remove(this.bQZ);
        this.cxD.add(0, this.bQZ);
        bh(this.cxD);
    }

    private void bh(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage jB(int i) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_POST_SEARCH);
        httpMessage.addParam("word", this.bQZ);
        httpMessage.addParam("rn", (Object) 30);
        httpMessage.addParam("kw", this.cxd.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.cxE));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", (Object) 1);
                httpMessage.addParam("only_thread", (Object) 0);
                httpMessage.addParam("pn", Integer.valueOf(this.cxx));
                break;
            case 2:
                httpMessage.addParam("sm", (Object) 2);
                httpMessage.addParam("only_thread", (Object) 0);
                httpMessage.addParam("pn", Integer.valueOf(this.cxy));
                break;
            case 3:
                httpMessage.addParam("sm", (Object) 2);
                httpMessage.addParam("only_thread", (Object) 1);
                httpMessage.addParam("pn", Integer.valueOf(this.cxz));
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jC(int i) {
        switch (i) {
            case 1:
                this.cxx++;
                return;
            case 2:
                this.cxy++;
                return;
            case 3:
                this.cxz++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int jD(int i) {
        switch (i) {
            case 1:
                return this.cxx;
            case 2:
                return this.cxy;
            case 3:
                return this.cxz;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jE(int i) {
        switch (i) {
            case 1:
                this.cxA = false;
                return;
            case 2:
                this.cxB = false;
                return;
            case 3:
                this.cxC = false;
                return;
            default:
                return;
        }
    }
}
