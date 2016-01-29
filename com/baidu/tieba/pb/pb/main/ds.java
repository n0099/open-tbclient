package com.baidu.tieba.pb.pb.main;

import android.os.Parcelable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ds {
    private com.baidu.tieba.pb.a.c cKn;
    private boolean cOu;
    private boolean cOw;
    private String cQb;
    private boolean cQc;
    private boolean cQd;
    private Parcelable cQe;

    static {
        MessageManager.getInstance().registerListener(new dt(CmdConfigCustom.METHOD_ACCOUNT_CHANGE));
        MessageManager.getInstance().registerListener(new du(CmdConfigCustom.PB_RECORDER_RESET_CMD));
        MessageManager.getInstance().registerListener(new dv(CmdConfigCustom.CMD_LIKE_FORUM));
        MessageManager.getInstance().registerListener(new dw(CmdConfigCustom.CMD_UNLIKE_FORUM));
    }

    /* loaded from: classes.dex */
    private static class a {
        private static ds cQf = new ds(null);
    }

    public static ds aqK() {
        return a.cQf;
    }

    private ds() {
        this.cQb = null;
        this.cQc = false;
        this.cKn = null;
        this.cQd = false;
        this.cQe = null;
        this.cOw = true;
        this.cOu = false;
    }

    /* synthetic */ ds(ds dsVar) {
        this();
    }

    public void C(String str, boolean z) {
        this.cQc = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.cQb = null;
        } else if (!str.equals(this.cQb)) {
            reset();
            this.cQb = str;
        } else {
            this.cQc = true;
        }
    }

    public com.baidu.tieba.pb.a.c getPbData() {
        if (!this.cQc) {
            this.cQd = false;
            return null;
        } else if (this.cKn != null && this.cKn.aoG() != null && this.cKn.aoG().size() > 0) {
            this.cQd = true;
            com.baidu.tieba.pb.a.c cVar = this.cKn;
            this.cKn = null;
            return cVar;
        } else {
            this.cQd = false;
            this.cKn = null;
            return null;
        }
    }

    public Parcelable aqL() {
        if (this.cQd) {
            this.cQd = false;
            Parcelable parcelable = this.cQe;
            this.cQe = null;
            return parcelable;
        }
        this.cQe = null;
        return null;
    }

    public boolean apP() {
        return this.cOw;
    }

    public boolean aqM() {
        return this.cOu;
    }

    public boolean a(com.baidu.tieba.pb.a.c cVar, Parcelable parcelable, boolean z, boolean z2) {
        this.cQc = false;
        if (this.cQb == null) {
            reset();
            return false;
        } else if (cVar == null) {
            reset();
            return false;
        } else if (cVar.aoG() == null) {
            reset();
            return false;
        } else if (cVar.aoG().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.cKn = cVar;
            this.cQd = false;
            this.cQe = parcelable;
            this.cOw = z;
            this.cOu = z2;
            return true;
        }
    }

    public void reset() {
        this.cQc = false;
        this.cKn = null;
        this.cQd = false;
        this.cQe = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.cKn != null && this.cKn.aoE() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.h.b.c(this.cKn.aoE().getId(), 0L)) {
                this.cKn.aoE().setLike(i);
            }
        }
    }
}
