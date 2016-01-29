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
    public String cws;
    private PostSearchActivity dxA;
    private String dxT;
    public ArrayList<String> dyc;
    public int dxU = 0;
    public int dxV = 0;
    public int dxW = 1;
    public int dxX = 1;
    public int dxY = 1;
    public boolean dxZ = false;
    public boolean dya = false;
    public boolean dyb = false;
    private int dyd = 0;
    private final HttpMessageListener dye = new u(this, CmdConfigHttp.CMD_POST_SEARCH);
    private CustomMessageListener cwW = new v(this, CmdConfigCustom.GET_ALL_SEARCH_POST_DATA);

    public t(PostSearchActivity postSearchActivity) {
        this.dxA = postSearchActivity;
        this.dxA.registerListener(this.cwW);
        this.dxA.registerListener(this.dye);
    }

    public boolean ag(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.cws)) {
            aCZ();
        }
        switch (i) {
            case 1:
                return lW(str);
            case 2:
                return lX(str);
            case 3:
                return lY(str);
            default:
                return false;
        }
    }

    public boolean lW(String str) {
        if (this.dxZ) {
            return false;
        }
        this.cws = str;
        this.dyd = 1;
        this.dxA.sendMessage(mV(this.dyd));
        this.dxZ = true;
        return true;
    }

    public boolean lX(String str) {
        if (this.dya) {
            return false;
        }
        this.cws = str;
        this.dyd = 2;
        this.dxA.sendMessage(mV(this.dyd));
        this.dya = true;
        return true;
    }

    public boolean lY(String str) {
        if (this.dyb) {
            return false;
        }
        this.cws = str;
        this.dyd = 3;
        this.dxA.sendMessage(mV(this.dyd));
        this.dyb = true;
        return true;
    }

    public void aCW() {
        this.dxA.sendMessage(new CustomMessage(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA));
    }

    public void aCX() {
        if (!StringUtils.isNull(this.cws) && !this.cws.equals(this.dxT)) {
            this.dxA.sendMessage(new CustomMessage((int) CmdConfigCustom.SAVE_SEARCH_POST_DATA, this.cws));
            this.dxT = this.cws;
        }
    }

    public void aCY() {
        if (this.dyc != null) {
            this.dyc.clear();
        }
        this.dxA.sendMessage(new CustomMessage(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA));
    }

    public void aCZ() {
        this.dxW = 1;
        this.dxX = 1;
        this.dxY = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDa() {
        if (this.dyc == null) {
            this.dyc = new ArrayList<>();
        }
        this.dyc.remove(this.cws);
        this.dyc.add(0, this.cws);
        bG(this.dyc);
    }

    private void bG(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage mV(int i) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_POST_SEARCH);
        httpMessage.addParam("word", this.cws);
        httpMessage.addParam("rn", (Object) 30);
        httpMessage.addParam("kw", this.dxA.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.dyd));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", (Object) 1);
                httpMessage.addParam("only_thread", (Object) 0);
                httpMessage.addParam("pn", Integer.valueOf(this.dxW));
                break;
            case 2:
                httpMessage.addParam("sm", (Object) 2);
                httpMessage.addParam("only_thread", (Object) 0);
                httpMessage.addParam("pn", Integer.valueOf(this.dxX));
                break;
            case 3:
                httpMessage.addParam("sm", (Object) 2);
                httpMessage.addParam("only_thread", (Object) 1);
                httpMessage.addParam("pn", Integer.valueOf(this.dxY));
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mW(int i) {
        switch (i) {
            case 1:
                this.dxW++;
                return;
            case 2:
                this.dxX++;
                return;
            case 3:
                this.dxY++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int mX(int i) {
        switch (i) {
            case 1:
                return this.dxW;
            case 2:
                return this.dxX;
            case 3:
                return this.dxY;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mY(int i) {
        switch (i) {
            case 1:
                this.dxZ = false;
                return;
            case 2:
                this.dya = false;
                return;
            case 3:
                this.dyb = false;
                return;
            default:
                return;
        }
    }
}
