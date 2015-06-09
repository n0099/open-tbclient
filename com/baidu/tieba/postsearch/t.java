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
    public String bCg;
    private PostSearchActivity bXN;
    private String bYe;
    public ArrayList<String> bYn;
    public int bYf = 0;
    public int bYg = 0;
    public int bYh = 1;
    public int bYi = 1;
    public int bYj = 1;
    public boolean bYk = false;
    public boolean bYl = false;
    public boolean bYm = false;
    private int bYo = 0;
    private final HttpMessageListener bYp = new u(this, CmdConfigHttp.CMD_POST_SEARCH);
    private CustomMessageListener bCE = new v(this, 2009001);

    public t(PostSearchActivity postSearchActivity) {
        this.bXN = postSearchActivity;
        this.bXN.registerListener(this.bCE);
        this.bXN.registerListener(this.bYp);
    }

    public boolean P(String str, int i) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (!str.equals(this.bCg)) {
            agk();
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
        if (this.bYk) {
            return false;
        }
        this.bCg = str;
        this.bYo = 1;
        this.bXN.sendMessage(hX(this.bYo));
        this.bYk = true;
        return true;
    }

    public boolean iN(String str) {
        if (this.bYl) {
            return false;
        }
        this.bCg = str;
        this.bYo = 2;
        this.bXN.sendMessage(hX(this.bYo));
        this.bYl = true;
        return true;
    }

    public boolean iO(String str) {
        if (this.bYm) {
            return false;
        }
        this.bCg = str;
        this.bYo = 3;
        this.bXN.sendMessage(hX(this.bYo));
        this.bYm = true;
        return true;
    }

    public void agh() {
        this.bXN.sendMessage(new CustomMessage(2009001));
    }

    public void agi() {
        if (!StringUtils.isNull(this.bCg) && !this.bCg.equals(this.bYe)) {
            this.bXN.sendMessage(new CustomMessage(2009003, this.bCg));
            this.bYe = this.bCg;
        }
    }

    public void agj() {
        if (this.bYn != null) {
            this.bYn.clear();
        }
        this.bXN.sendMessage(new CustomMessage(2009004));
    }

    public void agk() {
        this.bYh = 1;
        this.bYi = 1;
        this.bYj = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agl() {
        if (this.bYn == null) {
            this.bYn = new ArrayList<>();
        }
        this.bYn.remove(this.bCg);
        this.bYn.add(0, this.bCg);
        aV(this.bYn);
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
        httpMessage.addParam("word", this.bCg);
        httpMessage.addParam("rn", (Object) 30);
        httpMessage.addParam("kw", this.bXN.mForumName);
        httpMessage.setExtra(Integer.valueOf(this.bYo));
        switch (i) {
            case 1:
                httpMessage.addParam("sm", (Object) 1);
                httpMessage.addParam("only_thread", (Object) 0);
                httpMessage.addParam("pn", Integer.valueOf(this.bYh));
                break;
            case 2:
                httpMessage.addParam("sm", (Object) 2);
                httpMessage.addParam("only_thread", (Object) 0);
                httpMessage.addParam("pn", Integer.valueOf(this.bYi));
                break;
            case 3:
                httpMessage.addParam("sm", (Object) 2);
                httpMessage.addParam("only_thread", (Object) 1);
                httpMessage.addParam("pn", Integer.valueOf(this.bYj));
                break;
        }
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hY(int i) {
        switch (i) {
            case 1:
                this.bYh++;
                return;
            case 2:
                this.bYi++;
                return;
            case 3:
                this.bYj++;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int hZ(int i) {
        switch (i) {
            case 1:
                return this.bYh;
            case 2:
                return this.bYi;
            case 3:
                return this.bYj;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ia(int i) {
        switch (i) {
            case 1:
                this.bYk = false;
            case 2:
                this.bYl = false;
                break;
            case 3:
                break;
            default:
                return;
        }
        this.bYm = false;
    }
}
