package com.baidu.tieba.postsearch;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    public String bCf;
    private PostSearchActivity bXM;
    private String bYd;
    public ArrayList<String> bYm;
    public int bYe = 0;
    public int bYf = 0;
    public int bYg = 1;
    public int bYh = 1;
    public int bYi = 1;
    public boolean bYj = false;
    public boolean bYk = false;
    public boolean bYl = false;
    private int bYn = 0;
    private final HttpMessageListener bYo = new u(this, CmdConfigHttp.CMD_POST_SEARCH);
    private CustomMessageListener bCD = new v(this, 2009001);

    public t(PostSearchActivity postSearchActivity) {
        this.bXM = postSearchActivity;
        this.bXM.registerListener(this.bCD);
        this.bXM.registerListener(this.bYo);
    }

    public boolean P(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.bCf)) {
            agj();
        }
        switch (i) {
            case 1:
                return iM(str);
            case 2:
                return iN(str);
            case 3:
                return iO(str);
            default:
                return false;
        }
    }

    public boolean iM(String str) {
        if (this.bYj) {
            return false;
        }
        this.bCf = str;
        this.bYn = 1;
        this.bXM.sendMessage(hX(this.bYn));
        this.bYj = true;
        return true;
    }

    public boolean iN(String str) {
        if (this.bYk) {
            return false;
        }
        this.bCf = str;
        this.bYn = 2;
        this.bXM.sendMessage(hX(this.bYn));
        this.bYk = true;
        return true;
    }

    public boolean iO(String str) {
        if (this.bYl) {
            return false;
        }
        this.bCf = str;
        this.bYn = 3;
        this.bXM.sendMessage(hX(this.bYn));
        this.bYl = true;
        return true;
    }

    public void agg() {
        this.bXM.sendMessage(new CustomMessage(2009001));
    }

    public void agh() {
        if (!StringUtils.isNull(this.bCf) && !this.bCf.equals(this.bYd)) {
            this.bXM.sendMessage(new CustomMessage(2009003, this.bCf));
            this.bYd = this.bCf;
        }
    }

    public void agi() {
        if (this.bYm != null) {
            this.bYm.clear();
        }
        this.bXM.sendMessage(new CustomMessage(2009004));
    }

    public void agj() {
        this.bYg = 1;
        this.bYh = 1;
        this.bYi = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agk() {
        if (this.bYm == null) {
            this.bYm = new ArrayList<>();
        }
        this.bYm.remove(this.bCf);
        this.bYm.add(0, this.bCf);
        aV(this.bYm);
    }

    private void aV(List<String> list) {
        int size;
        if (list != null && list.size() - 5 > 0) {
            int size2 = list.size();
            for (int i = 0; i < size; i++) {
                list.remove((size2 - i) - 1);
            }
        }
    }

    private HttpMessage hX(int i) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_POST_SEARCH);
        httpMessage.addParam("word", this.bCf);
        httpMessage.addParam("rn", (Object) 30);
        httpMessage.addParam("kw", this.bXM.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.bYn));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", (Object) 1);
                httpMessage.addParam("only_thread", (Object) 0);
                httpMessage.addParam("pn", Integer.valueOf(this.bYg));
                break;
            case 2:
                httpMessage.addParam("sm", (Object) 2);
                httpMessage.addParam("only_thread", (Object) 0);
                httpMessage.addParam("pn", Integer.valueOf(this.bYh));
                break;
            case 3:
                httpMessage.addParam("sm", (Object) 2);
                httpMessage.addParam("only_thread", (Object) 1);
                httpMessage.addParam("pn", Integer.valueOf(this.bYi));
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hY(int i) {
        switch (i) {
            case 1:
                this.bYg++;
                return;
            case 2:
                this.bYh++;
                return;
            case 3:
                this.bYi++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int hZ(int i) {
        switch (i) {
            case 1:
                return this.bYg;
            case 2:
                return this.bYh;
            case 3:
                return this.bYi;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ia(int i) {
        switch (i) {
            case 1:
                this.bYj = false;
            case 2:
                this.bYk = false;
                break;
            case 3:
                break;
            default:
                return;
        }
        this.bYl = false;
    }
}
