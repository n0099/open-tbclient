package com.baidu.tieba.pb.pb.main;

import android.os.Parcelable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class er {
    private boolean ene;
    private boolean eng;
    private com.baidu.tieba.pb.data.f ens;
    private String eqs;
    private boolean eqt;
    private boolean equ;
    private Parcelable eqv;

    static {
        MessageManager.getInstance().registerListener(new es(CmdConfigCustom.METHOD_ACCOUNT_CHANGE));
        MessageManager.getInstance().registerListener(new et(CmdConfigCustom.PB_RECORDER_RESET_CMD));
        MessageManager.getInstance().registerListener(new eu(CmdConfigCustom.CMD_LIKE_FORUM));
        MessageManager.getInstance().registerListener(new ev(CmdConfigCustom.CMD_UNLIKE_FORUM));
        MessageManager.getInstance().registerListener(new ew(CmdConfigCustom.CMD_UPDATE_PENDANT));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static er eqw = new er(null);
    }

    public static er aMB() {
        return a.eqw;
    }

    private er() {
        this.eqs = null;
        this.eqt = false;
        this.ens = null;
        this.equ = false;
        this.eqv = null;
        this.eng = true;
        this.ene = false;
    }

    /* synthetic */ er(er erVar) {
        this();
    }

    public void O(String str, boolean z) {
        this.eqt = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.eqs = null;
        } else if (!str.equals(this.eqs)) {
            reset();
            this.eqs = str;
        } else {
            this.eqt = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.eqt) {
            this.equ = false;
            return null;
        } else if (this.ens != null && this.ens.aJs() != null && this.ens.aJs().size() > 0) {
            this.equ = true;
            com.baidu.tieba.pb.data.f fVar = this.ens;
            this.ens = null;
            return fVar;
        } else {
            this.equ = false;
            this.ens = null;
            return null;
        }
    }

    public Parcelable aMC() {
        if (this.equ) {
            this.equ = false;
            Parcelable parcelable = this.eqv;
            this.eqv = null;
            return parcelable;
        }
        this.eqv = null;
        return null;
    }

    public boolean aLu() {
        return this.eng;
    }

    public boolean aMD() {
        return this.ene;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2) {
        this.eqt = false;
        if (this.eqs == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.aJs() == null) {
            reset();
            return false;
        } else if (fVar.aJs().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.ens = fVar;
            this.equ = false;
            this.eqv = parcelable;
            this.eng = z;
            this.ene = z2;
            return true;
        }
    }

    public void reset() {
        this.eqt = false;
        this.ens = null;
        this.equ = false;
        this.eqv = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.ens != null && this.ens.aJp() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.c(this.ens.aJp().getId(), 0L)) {
                this.ens.aJp().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null && this.ens != null && this.ens.aJs() != null && this.ens.aJs().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.ens.aJs().size();
                for (int i = 0; i < size; i++) {
                    if (this.ens.aJs().get(i) != null && this.ens.aJs().get(i).getAuthor() != null && currentAccount.equals(this.ens.aJs().get(i).getAuthor().getUserId()) && this.ens.aJs().get(i).getAuthor().getPendantData() != null) {
                        this.ens.aJs().get(i).getAuthor().getPendantData().ck(jVar.qd());
                        this.ens.aJs().get(i).getAuthor().getPendantData().N(jVar.Cq());
                    }
                }
            }
        }
    }
}
