package com.baidu.tieba.pb.pb.main;

import android.os.Parcelable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ee {
    private com.baidu.tieba.pb.data.e dfY;
    private boolean dla;
    private boolean dlc;
    private String dmR;
    private boolean dmS;
    private boolean dmT;
    private Parcelable dmU;

    static {
        MessageManager.getInstance().registerListener(new ef(CmdConfigCustom.METHOD_ACCOUNT_CHANGE));
        MessageManager.getInstance().registerListener(new eg(CmdConfigCustom.PB_RECORDER_RESET_CMD));
        MessageManager.getInstance().registerListener(new eh(CmdConfigCustom.CMD_LIKE_FORUM));
        MessageManager.getInstance().registerListener(new ei(CmdConfigCustom.CMD_UNLIKE_FORUM));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static ee dmV = new ee(null);
    }

    public static ee ayA() {
        return a.dmV;
    }

    private ee() {
        this.dmR = null;
        this.dmS = false;
        this.dfY = null;
        this.dmT = false;
        this.dmU = null;
        this.dlc = true;
        this.dla = false;
    }

    /* synthetic */ ee(ee eeVar) {
        this();
    }

    public void F(String str, boolean z) {
        this.dmS = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.dmR = null;
        } else if (!str.equals(this.dmR)) {
            reset();
            this.dmR = str;
        } else {
            this.dmS = true;
        }
    }

    public com.baidu.tieba.pb.data.e getPbData() {
        if (!this.dmS) {
            this.dmT = false;
            return null;
        } else if (this.dfY != null && this.dfY.avC() != null && this.dfY.avC().size() > 0) {
            this.dmT = true;
            com.baidu.tieba.pb.data.e eVar = this.dfY;
            this.dfY = null;
            return eVar;
        } else {
            this.dmT = false;
            this.dfY = null;
            return null;
        }
    }

    public Parcelable ayB() {
        if (this.dmT) {
            this.dmT = false;
            Parcelable parcelable = this.dmU;
            this.dmU = null;
            return parcelable;
        }
        this.dmU = null;
        return null;
    }

    public boolean axB() {
        return this.dlc;
    }

    public boolean ayC() {
        return this.dla;
    }

    public boolean a(com.baidu.tieba.pb.data.e eVar, Parcelable parcelable, boolean z, boolean z2) {
        this.dmS = false;
        if (this.dmR == null) {
            reset();
            return false;
        } else if (eVar == null) {
            reset();
            return false;
        } else if (eVar.avC() == null) {
            reset();
            return false;
        } else if (eVar.avC().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.dfY = eVar;
            this.dmT = false;
            this.dmU = parcelable;
            this.dlc = z;
            this.dla = z2;
            return true;
        }
    }

    public void reset() {
        this.dmS = false;
        this.dfY = null;
        this.dmT = false;
        this.dmU = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.dfY != null && this.dfY.avA() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.h.b.c(this.dfY.avA().getId(), 0L)) {
                this.dfY.avA().setLike(i);
            }
        }
    }
}
