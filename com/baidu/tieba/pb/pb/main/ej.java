package com.baidu.tieba.pb.pb.main;

import android.os.Parcelable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ej {
    private com.baidu.tieba.pb.data.f ebE;
    private boolean ebq;
    private boolean ebs;
    private boolean eeA;
    private Parcelable eeB;
    private String eey;
    private boolean eez;

    static {
        MessageManager.getInstance().registerListener(new ek(CmdConfigCustom.METHOD_ACCOUNT_CHANGE));
        MessageManager.getInstance().registerListener(new el(CmdConfigCustom.PB_RECORDER_RESET_CMD));
        MessageManager.getInstance().registerListener(new em(CmdConfigCustom.CMD_LIKE_FORUM));
        MessageManager.getInstance().registerListener(new en(CmdConfigCustom.CMD_UNLIKE_FORUM));
        MessageManager.getInstance().registerListener(new eo(CmdConfigCustom.CMD_UPDATE_PENDANT));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static ej eeC = new ej(null);
    }

    public static ej aLu() {
        return a.eeC;
    }

    private ej() {
        this.eey = null;
        this.eez = false;
        this.ebE = null;
        this.eeA = false;
        this.eeB = null;
        this.ebs = true;
        this.ebq = false;
    }

    /* synthetic */ ej(ej ejVar) {
        this();
    }

    public void N(String str, boolean z) {
        this.eez = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.eey = null;
        } else if (!str.equals(this.eey)) {
            reset();
            this.eey = str;
        } else {
            this.eez = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.eez) {
            this.eeA = false;
            return null;
        } else if (this.ebE != null && this.ebE.aIm() != null && this.ebE.aIm().size() > 0) {
            this.eeA = true;
            com.baidu.tieba.pb.data.f fVar = this.ebE;
            this.ebE = null;
            return fVar;
        } else {
            this.eeA = false;
            this.ebE = null;
            return null;
        }
    }

    public Parcelable aLv() {
        if (this.eeA) {
            this.eeA = false;
            Parcelable parcelable = this.eeB;
            this.eeB = null;
            return parcelable;
        }
        this.eeB = null;
        return null;
    }

    public boolean aKl() {
        return this.ebs;
    }

    public boolean aLw() {
        return this.ebq;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2) {
        this.eez = false;
        if (this.eey == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.aIm() == null) {
            reset();
            return false;
        } else if (fVar.aIm().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.ebE = fVar;
            this.eeA = false;
            this.eeB = parcelable;
            this.ebs = z;
            this.ebq = z2;
            return true;
        }
    }

    public void reset() {
        this.eez = false;
        this.ebE = null;
        this.eeA = false;
        this.eeB = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.ebE != null && this.ebE.aIk() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.h.b.c(this.ebE.aIk().getId(), 0L)) {
                this.ebE.aIk().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.k kVar) {
        if (kVar != null && this.ebE != null && this.ebE.aIm() != null && this.ebE.aIm().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.ebE.aIm().size();
                for (int i = 0; i < size; i++) {
                    if (this.ebE.aIm().get(i) != null && this.ebE.aIm().get(i).getAuthor() != null && currentAccount.equals(this.ebE.aIm().get(i).getAuthor().getUserId()) && this.ebE.aIm().get(i).getAuthor().getPendantData() != null) {
                        this.ebE.aIm().get(i).getAuthor().getPendantData().cs(kVar.pS());
                        this.ebE.aIm().get(i).getAuthor().getPendantData().O(kVar.Cb());
                    }
                }
            }
        }
    }
}
