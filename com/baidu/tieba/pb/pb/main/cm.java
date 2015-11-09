package com.baidu.tieba.pb.pb.main;

import android.os.Parcelable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class cm {
    private com.baidu.tieba.pb.a.c chr;
    private boolean ckA;
    private boolean ckC;
    private String clo;
    private boolean clp;
    private boolean clq;
    private Parcelable clr;

    static {
        MessageManager.getInstance().registerListener(new cn(CmdConfigCustom.METHOD_ACCOUNT_CHANGE));
        MessageManager.getInstance().registerListener(new co(CmdConfigCustom.PB_RECORDER_RESET_CMD));
        MessageManager.getInstance().registerListener(new cp(CmdConfigCustom.CMD_LIKE_FORUM));
        MessageManager.getInstance().registerListener(new cq(CmdConfigCustom.CMD_UNLIKE_FORUM));
    }

    /* loaded from: classes.dex */
    private static class a {
        private static cm cls = new cm(null);
    }

    public static cm agF() {
        return a.cls;
    }

    private cm() {
        this.clo = null;
        this.clp = false;
        this.chr = null;
        this.clq = false;
        this.clr = null;
        this.ckC = true;
        this.ckA = false;
    }

    /* synthetic */ cm(cm cmVar) {
        this();
    }

    public void B(String str, boolean z) {
        this.clp = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.clo = null;
        } else if (!str.equals(this.clo)) {
            reset();
            this.clo = str;
        } else {
            this.clp = true;
        }
    }

    public com.baidu.tieba.pb.a.c getPbData() {
        if (!this.clp) {
            this.clq = false;
            return null;
        } else if (this.chr != null && this.chr.afi() != null && this.chr.afi().size() > 0) {
            this.clq = true;
            com.baidu.tieba.pb.a.c cVar = this.chr;
            this.chr = null;
            return cVar;
        } else {
            this.clq = false;
            this.chr = null;
            return null;
        }
    }

    public Parcelable agG() {
        if (this.clq) {
            this.clq = false;
            Parcelable parcelable = this.clr;
            this.clr = null;
            return parcelable;
        }
        this.clr = null;
        return null;
    }

    public boolean agm() {
        return this.ckC;
    }

    public boolean agH() {
        return this.ckA;
    }

    public boolean a(com.baidu.tieba.pb.a.c cVar, Parcelable parcelable, boolean z, boolean z2) {
        this.clp = false;
        if (this.clo == null) {
            reset();
            return false;
        } else if (cVar == null) {
            reset();
            return false;
        } else if (cVar.afi() == null) {
            reset();
            return false;
        } else if (cVar.afi().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.chr = cVar;
            this.clq = false;
            this.clr = parcelable;
            this.ckC = z;
            this.ckA = z2;
            return true;
        }
    }

    public void reset() {
        this.clp = false;
        this.chr = null;
        this.clq = false;
        this.clr = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.chr != null && this.chr.afg() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.c(this.chr.afg().getId(), 0L)) {
                this.chr.afg().setLike(i);
            }
        }
    }
}
