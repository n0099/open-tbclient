package com.baidu.tieba.pb.pb.main;

import android.os.Parcelable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ct {
    private boolean cDa;
    private boolean cDc;
    private String cEa;
    private boolean cEb;
    private boolean cEc;
    private Parcelable cEd;
    private com.baidu.tieba.pb.a.c czO;

    static {
        MessageManager.getInstance().registerListener(new cu(CmdConfigCustom.METHOD_ACCOUNT_CHANGE));
        MessageManager.getInstance().registerListener(new cv(CmdConfigCustom.PB_RECORDER_RESET_CMD));
        MessageManager.getInstance().registerListener(new cw(CmdConfigCustom.CMD_LIKE_FORUM));
        MessageManager.getInstance().registerListener(new cx(CmdConfigCustom.CMD_UNLIKE_FORUM));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static ct cEe = new ct(null);
    }

    public static ct ale() {
        return a.cEe;
    }

    private ct() {
        this.cEa = null;
        this.cEb = false;
        this.czO = null;
        this.cEc = false;
        this.cEd = null;
        this.cDc = true;
        this.cDa = false;
    }

    /* synthetic */ ct(ct ctVar) {
        this();
    }

    public void D(String str, boolean z) {
        this.cEb = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.cEa = null;
        } else if (!str.equals(this.cEa)) {
            reset();
            this.cEa = str;
        } else {
            this.cEb = true;
        }
    }

    public com.baidu.tieba.pb.a.c getPbData() {
        if (!this.cEb) {
            this.cEc = false;
            return null;
        } else if (this.czO != null && this.czO.ajA() != null && this.czO.ajA().size() > 0) {
            this.cEc = true;
            com.baidu.tieba.pb.a.c cVar = this.czO;
            this.czO = null;
            return cVar;
        } else {
            this.cEc = false;
            this.czO = null;
            return null;
        }
    }

    public Parcelable alf() {
        if (this.cEc) {
            this.cEc = false;
            Parcelable parcelable = this.cEd;
            this.cEd = null;
            return parcelable;
        }
        this.cEd = null;
        return null;
    }

    public boolean akF() {
        return this.cDc;
    }

    public boolean alg() {
        return this.cDa;
    }

    public boolean a(com.baidu.tieba.pb.a.c cVar, Parcelable parcelable, boolean z, boolean z2) {
        this.cEb = false;
        if (this.cEa == null) {
            reset();
            return false;
        } else if (cVar == null) {
            reset();
            return false;
        } else if (cVar.ajA() == null) {
            reset();
            return false;
        } else if (cVar.ajA().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.czO = cVar;
            this.cEc = false;
            this.cEd = parcelable;
            this.cDc = z;
            this.cDa = z2;
            return true;
        }
    }

    public void reset() {
        this.cEb = false;
        this.czO = null;
        this.cEc = false;
        this.cEd = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.czO != null && this.czO.ajy() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.h.b.c(this.czO.ajy().getId(), 0L)) {
                this.czO.ajy().setLike(i);
            }
        }
    }
}
