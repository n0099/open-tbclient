package com.baidu.tieba.pb.pb.main;

import android.os.Parcelable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class dd {
    private com.baidu.tieba.pb.a.c cDt;
    private boolean cGP;
    private boolean cGR;
    private String cHZ;
    private boolean cIa;
    private boolean cIb;
    private Parcelable cIc;

    static {
        MessageManager.getInstance().registerListener(new de(CmdConfigCustom.METHOD_ACCOUNT_CHANGE));
        MessageManager.getInstance().registerListener(new df(CmdConfigCustom.PB_RECORDER_RESET_CMD));
        MessageManager.getInstance().registerListener(new dg(CmdConfigCustom.CMD_LIKE_FORUM));
        MessageManager.getInstance().registerListener(new dh(CmdConfigCustom.CMD_UNLIKE_FORUM));
    }

    /* loaded from: classes.dex */
    private static class a {
        private static dd cId = new dd(null);
    }

    public static dd amq() {
        return a.cId;
    }

    private dd() {
        this.cHZ = null;
        this.cIa = false;
        this.cDt = null;
        this.cIb = false;
        this.cIc = null;
        this.cGR = true;
        this.cGP = false;
    }

    /* synthetic */ dd(dd ddVar) {
        this();
    }

    public void C(String str, boolean z) {
        this.cIa = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.cHZ = null;
        } else if (!str.equals(this.cHZ)) {
            reset();
            this.cHZ = str;
        } else {
            this.cIa = true;
        }
    }

    public com.baidu.tieba.pb.a.c getPbData() {
        if (!this.cIa) {
            this.cIb = false;
            return null;
        } else if (this.cDt != null && this.cDt.akI() != null && this.cDt.akI().size() > 0) {
            this.cIb = true;
            com.baidu.tieba.pb.a.c cVar = this.cDt;
            this.cDt = null;
            return cVar;
        } else {
            this.cIb = false;
            this.cDt = null;
            return null;
        }
    }

    public Parcelable amr() {
        if (this.cIb) {
            this.cIb = false;
            Parcelable parcelable = this.cIc;
            this.cIc = null;
            return parcelable;
        }
        this.cIc = null;
        return null;
    }

    public boolean alM() {
        return this.cGR;
    }

    public boolean ams() {
        return this.cGP;
    }

    public boolean a(com.baidu.tieba.pb.a.c cVar, Parcelable parcelable, boolean z, boolean z2) {
        this.cIa = false;
        if (this.cHZ == null) {
            reset();
            return false;
        } else if (cVar == null) {
            reset();
            return false;
        } else if (cVar.akI() == null) {
            reset();
            return false;
        } else if (cVar.akI().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.cDt = cVar;
            this.cIb = false;
            this.cIc = parcelable;
            this.cGR = z;
            this.cGP = z2;
            return true;
        }
    }

    public void reset() {
        this.cIa = false;
        this.cDt = null;
        this.cIb = false;
        this.cIc = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.cDt != null && this.cDt.akG() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.h.b.c(this.cDt.akG().getId(), 0L)) {
                this.cDt.akG().setLike(i);
            }
        }
    }
}
