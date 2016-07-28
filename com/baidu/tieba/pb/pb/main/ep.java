package com.baidu.tieba.pb.pb.main;

import android.os.Parcelable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ep {
    private boolean edf;
    private boolean edh;
    private com.baidu.tieba.pb.data.h eds;
    private String efK;
    private boolean efL;
    private boolean efM;
    private Parcelable efN;

    static {
        MessageManager.getInstance().registerListener(new eq(CmdConfigCustom.METHOD_ACCOUNT_CHANGE));
        MessageManager.getInstance().registerListener(new er(CmdConfigCustom.PB_RECORDER_RESET_CMD));
        MessageManager.getInstance().registerListener(new es(CmdConfigCustom.CMD_LIKE_FORUM));
        MessageManager.getInstance().registerListener(new et(CmdConfigCustom.CMD_UNLIKE_FORUM));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static ep efO = new ep(null);
    }

    public static ep aJZ() {
        return a.efO;
    }

    private ep() {
        this.efK = null;
        this.efL = false;
        this.eds = null;
        this.efM = false;
        this.efN = null;
        this.edh = true;
        this.edf = false;
    }

    /* synthetic */ ep(ep epVar) {
        this();
    }

    public void H(String str, boolean z) {
        this.efL = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.efK = null;
        } else if (!str.equals(this.efK)) {
            reset();
            this.efK = str;
        } else {
            this.efL = true;
        }
    }

    public com.baidu.tieba.pb.data.h getPbData() {
        if (!this.efL) {
            this.efM = false;
            return null;
        } else if (this.eds != null && this.eds.aGZ() != null && this.eds.aGZ().size() > 0) {
            this.efM = true;
            com.baidu.tieba.pb.data.h hVar = this.eds;
            this.eds = null;
            return hVar;
        } else {
            this.efM = false;
            this.eds = null;
            return null;
        }
    }

    public Parcelable aKa() {
        if (this.efM) {
            this.efM = false;
            Parcelable parcelable = this.efN;
            this.efN = null;
            return parcelable;
        }
        this.efN = null;
        return null;
    }

    public boolean aIX() {
        return this.edh;
    }

    public boolean aKb() {
        return this.edf;
    }

    public boolean a(com.baidu.tieba.pb.data.h hVar, Parcelable parcelable, boolean z, boolean z2) {
        this.efL = false;
        if (this.efK == null) {
            reset();
            return false;
        } else if (hVar == null) {
            reset();
            return false;
        } else if (hVar.aGZ() == null) {
            reset();
            return false;
        } else if (hVar.aGZ().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.eds = hVar;
            this.efM = false;
            this.efN = parcelable;
            this.edh = z;
            this.edf = z2;
            return true;
        }
    }

    public void reset() {
        this.efL = false;
        this.eds = null;
        this.efM = false;
        this.efN = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.eds != null && this.eds.aGX() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.h.b.c(this.eds.aGX().getId(), 0L)) {
                this.eds.aGX().setLike(i);
            }
        }
    }
}
