package com.baidu.tieba.pb.pb.main;

import android.os.Parcelable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class eq {
    private String eAp;
    private boolean eAq;
    private boolean eAr;
    private Parcelable eAs;
    private boolean exb;
    private boolean exd;
    private com.baidu.tieba.pb.data.h exo;

    static {
        MessageManager.getInstance().registerListener(new er(CmdConfigCustom.METHOD_ACCOUNT_CHANGE));
        MessageManager.getInstance().registerListener(new es(CmdConfigCustom.PB_RECORDER_RESET_CMD));
        MessageManager.getInstance().registerListener(new et(CmdConfigCustom.CMD_LIKE_FORUM));
        MessageManager.getInstance().registerListener(new eu(CmdConfigCustom.CMD_UNLIKE_FORUM));
        MessageManager.getInstance().registerListener(new ev(CmdConfigCustom.CMD_UPDATE_PENDANT));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static eq eAt = new eq(null);
    }

    public static eq aRA() {
        return a.eAt;
    }

    private eq() {
        this.eAp = null;
        this.eAq = false;
        this.exo = null;
        this.eAr = false;
        this.eAs = null;
        this.exd = true;
        this.exb = false;
    }

    /* synthetic */ eq(eq eqVar) {
        this();
    }

    public void M(String str, boolean z) {
        this.eAq = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.eAp = null;
        } else if (!str.equals(this.eAp)) {
            reset();
            this.eAp = str;
        } else {
            this.eAq = true;
        }
    }

    public com.baidu.tieba.pb.data.h getPbData() {
        if (!this.eAq) {
            this.eAr = false;
            return null;
        } else if (this.exo != null && this.exo.aOm() != null && this.exo.aOm().size() > 0) {
            this.eAr = true;
            com.baidu.tieba.pb.data.h hVar = this.exo;
            this.exo = null;
            return hVar;
        } else {
            this.eAr = false;
            this.exo = null;
            return null;
        }
    }

    public Parcelable aRB() {
        if (this.eAr) {
            this.eAr = false;
            Parcelable parcelable = this.eAs;
            this.eAs = null;
            return parcelable;
        }
        this.eAs = null;
        return null;
    }

    public boolean aQp() {
        return this.exd;
    }

    public boolean aRC() {
        return this.exb;
    }

    public boolean a(com.baidu.tieba.pb.data.h hVar, Parcelable parcelable, boolean z, boolean z2) {
        this.eAq = false;
        if (this.eAp == null) {
            reset();
            return false;
        } else if (hVar == null) {
            reset();
            return false;
        } else if (hVar.aOm() == null) {
            reset();
            return false;
        } else if (hVar.aOm().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.exo = hVar;
            this.eAr = false;
            this.eAs = parcelable;
            this.exd = z;
            this.exb = z2;
            return true;
        }
    }

    public void reset() {
        this.eAq = false;
        this.exo = null;
        this.eAr = false;
        this.eAs = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.exo != null && this.exo.aOk() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.h.b.c(this.exo.aOk().getId(), 0L)) {
                this.exo.aOk().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.k kVar) {
        if (kVar != null && this.exo != null && this.exo.aOm() != null && this.exo.aOm().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.exo.aOm().size();
                for (int i = 0; i < size; i++) {
                    if (this.exo.aOm().get(i) != null && this.exo.aOm().get(i).getAuthor() != null && currentAccount.equals(this.exo.aOm().get(i).getAuthor().getUserId()) && this.exo.aOm().get(i).getAuthor().getPendantData() != null) {
                        this.exo.aOm().get(i).getAuthor().getPendantData().cs(kVar.pR());
                        this.exo.aOm().get(i).getAuthor().getPendantData().P(kVar.Co());
                    }
                }
            }
        }
    }
}
