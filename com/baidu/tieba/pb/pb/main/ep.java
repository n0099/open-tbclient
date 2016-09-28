package com.baidu.tieba.pb.pb.main;

import android.os.Parcelable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ep {
    private boolean eri;
    private boolean erk;
    private com.baidu.tieba.pb.data.h erv;
    private String etY;
    private boolean etZ;
    private boolean eua;
    private Parcelable eub;

    static {
        MessageManager.getInstance().registerListener(new eq(CmdConfigCustom.METHOD_ACCOUNT_CHANGE));
        MessageManager.getInstance().registerListener(new er(CmdConfigCustom.PB_RECORDER_RESET_CMD));
        MessageManager.getInstance().registerListener(new es(CmdConfigCustom.CMD_LIKE_FORUM));
        MessageManager.getInstance().registerListener(new et(CmdConfigCustom.CMD_UNLIKE_FORUM));
        MessageManager.getInstance().registerListener(new eu(CmdConfigCustom.CMD_UPDATE_PENDANT));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static ep euc = new ep(null);
    }

    public static ep aPz() {
        return a.euc;
    }

    private ep() {
        this.etY = null;
        this.etZ = false;
        this.erv = null;
        this.eua = false;
        this.eub = null;
        this.erk = true;
        this.eri = false;
    }

    /* synthetic */ ep(ep epVar) {
        this();
    }

    public void M(String str, boolean z) {
        this.etZ = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.etY = null;
        } else if (!str.equals(this.etY)) {
            reset();
            this.etY = str;
        } else {
            this.etZ = true;
        }
    }

    public com.baidu.tieba.pb.data.h getPbData() {
        if (!this.etZ) {
            this.eua = false;
            return null;
        } else if (this.erv != null && this.erv.aMt() != null && this.erv.aMt().size() > 0) {
            this.eua = true;
            com.baidu.tieba.pb.data.h hVar = this.erv;
            this.erv = null;
            return hVar;
        } else {
            this.eua = false;
            this.erv = null;
            return null;
        }
    }

    public Parcelable aPA() {
        if (this.eua) {
            this.eua = false;
            Parcelable parcelable = this.eub;
            this.eub = null;
            return parcelable;
        }
        this.eub = null;
        return null;
    }

    public boolean aOw() {
        return this.erk;
    }

    public boolean aPB() {
        return this.eri;
    }

    public boolean a(com.baidu.tieba.pb.data.h hVar, Parcelable parcelable, boolean z, boolean z2) {
        this.etZ = false;
        if (this.etY == null) {
            reset();
            return false;
        } else if (hVar == null) {
            reset();
            return false;
        } else if (hVar.aMt() == null) {
            reset();
            return false;
        } else if (hVar.aMt().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.erv = hVar;
            this.eua = false;
            this.eub = parcelable;
            this.erk = z;
            this.eri = z2;
            return true;
        }
    }

    public void reset() {
        this.etZ = false;
        this.erv = null;
        this.eua = false;
        this.eub = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.erv != null && this.erv.aMr() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.h.b.c(this.erv.aMr().getId(), 0L)) {
                this.erv.aMr().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null && this.erv != null && this.erv.aMt() != null && this.erv.aMt().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.erv.aMt().size();
                for (int i = 0; i < size; i++) {
                    if (this.erv.aMt().get(i) != null && this.erv.aMt().get(i).getAuthor() != null && currentAccount.equals(this.erv.aMt().get(i).getAuthor().getUserId()) && this.erv.aMt().get(i).getAuthor().getPendantData() != null) {
                        this.erv.aMt().get(i).getAuthor().getPendantData().cq(jVar.pO());
                        this.erv.aMt().get(i).getAuthor().getPendantData().Q(jVar.Cg());
                    }
                }
            }
        }
    }
}
