package com.baidu.tieba.pb.pb.main;

import android.os.Parcelable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class el {
    private boolean dQQ;
    private boolean dQS;
    private com.baidu.tieba.pb.data.h dRe;
    private String dTi;
    private boolean dTj;
    private boolean dTk;
    private Parcelable dTl;

    static {
        MessageManager.getInstance().registerListener(new em(CmdConfigCustom.METHOD_ACCOUNT_CHANGE));
        MessageManager.getInstance().registerListener(new en(CmdConfigCustom.PB_RECORDER_RESET_CMD));
        MessageManager.getInstance().registerListener(new eo(CmdConfigCustom.CMD_LIKE_FORUM));
        MessageManager.getInstance().registerListener(new ep(CmdConfigCustom.CMD_UNLIKE_FORUM));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static el dTm = new el(null);
    }

    public static el aGM() {
        return a.dTm;
    }

    private el() {
        this.dTi = null;
        this.dTj = false;
        this.dRe = null;
        this.dTk = false;
        this.dTl = null;
        this.dQS = true;
        this.dQQ = false;
    }

    /* synthetic */ el(el elVar) {
        this();
    }

    public void H(String str, boolean z) {
        this.dTj = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.dTi = null;
        } else if (!str.equals(this.dTi)) {
            reset();
            this.dTi = str;
        } else {
            this.dTj = true;
        }
    }

    public com.baidu.tieba.pb.data.h getPbData() {
        if (!this.dTj) {
            this.dTk = false;
            return null;
        } else if (this.dRe != null && this.dRe.aDP() != null && this.dRe.aDP().size() > 0) {
            this.dTk = true;
            com.baidu.tieba.pb.data.h hVar = this.dRe;
            this.dRe = null;
            return hVar;
        } else {
            this.dTk = false;
            this.dRe = null;
            return null;
        }
    }

    public Parcelable aGN() {
        if (this.dTk) {
            this.dTk = false;
            Parcelable parcelable = this.dTl;
            this.dTl = null;
            return parcelable;
        }
        this.dTl = null;
        return null;
    }

    public boolean aFM() {
        return this.dQS;
    }

    public boolean aGO() {
        return this.dQQ;
    }

    public boolean a(com.baidu.tieba.pb.data.h hVar, Parcelable parcelable, boolean z, boolean z2) {
        this.dTj = false;
        if (this.dTi == null) {
            reset();
            return false;
        } else if (hVar == null) {
            reset();
            return false;
        } else if (hVar.aDP() == null) {
            reset();
            return false;
        } else if (hVar.aDP().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.dRe = hVar;
            this.dTk = false;
            this.dTl = parcelable;
            this.dQS = z;
            this.dQQ = z2;
            return true;
        }
    }

    public void reset() {
        this.dTj = false;
        this.dRe = null;
        this.dTk = false;
        this.dTl = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.dRe != null && this.dRe.aDN() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.h.b.c(this.dRe.aDN().getId(), 0L)) {
                this.dRe.aDN().setLike(i);
            }
        }
    }
}
