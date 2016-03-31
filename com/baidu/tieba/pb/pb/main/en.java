package com.baidu.tieba.pb.pb.main;

import android.os.Parcelable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class en {
    private com.baidu.tieba.pb.data.e ddF;
    private boolean diF;
    private boolean diH;
    private String dks;
    private boolean dkt;
    private boolean dku;
    private Parcelable dkv;

    static {
        MessageManager.getInstance().registerListener(new eo(CmdConfigCustom.METHOD_ACCOUNT_CHANGE));
        MessageManager.getInstance().registerListener(new ep(CmdConfigCustom.PB_RECORDER_RESET_CMD));
        MessageManager.getInstance().registerListener(new eq(CmdConfigCustom.CMD_LIKE_FORUM));
        MessageManager.getInstance().registerListener(new er(CmdConfigCustom.CMD_UNLIKE_FORUM));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static en dkw = new en(null);
    }

    public static en aya() {
        return a.dkw;
    }

    private en() {
        this.dks = null;
        this.dkt = false;
        this.ddF = null;
        this.dku = false;
        this.dkv = null;
        this.diH = true;
        this.diF = false;
    }

    /* synthetic */ en(en enVar) {
        this();
    }

    public void D(String str, boolean z) {
        this.dkt = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.dks = null;
        } else if (!str.equals(this.dks)) {
            reset();
            this.dks = str;
        } else {
            this.dkt = true;
        }
    }

    public com.baidu.tieba.pb.data.e getPbData() {
        if (!this.dkt) {
            this.dku = false;
            return null;
        } else if (this.ddF != null && this.ddF.avw() != null && this.ddF.avw().size() > 0) {
            this.dku = true;
            com.baidu.tieba.pb.data.e eVar = this.ddF;
            this.ddF = null;
            return eVar;
        } else {
            this.dku = false;
            this.ddF = null;
            return null;
        }
    }

    public Parcelable ayb() {
        if (this.dku) {
            this.dku = false;
            Parcelable parcelable = this.dkv;
            this.dkv = null;
            return parcelable;
        }
        this.dkv = null;
        return null;
    }

    public boolean axe() {
        return this.diH;
    }

    public boolean ayc() {
        return this.diF;
    }

    public boolean a(com.baidu.tieba.pb.data.e eVar, Parcelable parcelable, boolean z, boolean z2) {
        this.dkt = false;
        if (this.dks == null) {
            reset();
            return false;
        } else if (eVar == null) {
            reset();
            return false;
        } else if (eVar.avw() == null) {
            reset();
            return false;
        } else if (eVar.avw().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.ddF = eVar;
            this.dku = false;
            this.dkv = parcelable;
            this.diH = z;
            this.diF = z2;
            return true;
        }
    }

    public void reset() {
        this.dkt = false;
        this.ddF = null;
        this.dku = false;
        this.dkv = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.ddF != null && this.ddF.avu() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.h.b.c(this.ddF.avu().getId(), 0L)) {
                this.ddF.avu().setLike(i);
            }
        }
    }
}
