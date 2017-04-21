package com.baidu.tieba.pb.pb.main;

import android.os.Parcelable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ep {
    private boolean enD;
    private boolean enF;
    private com.baidu.tieba.pb.data.f enR;
    private String eqS;
    private boolean eqT;
    private boolean eqU;
    private Parcelable eqV;

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
        private static ep eqW = new ep(null);
    }

    public static ep aNL() {
        return a.eqW;
    }

    private ep() {
        this.eqS = null;
        this.eqT = false;
        this.enR = null;
        this.eqU = false;
        this.eqV = null;
        this.enF = true;
        this.enD = false;
    }

    /* synthetic */ ep(ep epVar) {
        this();
    }

    public void O(String str, boolean z) {
        this.eqT = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.eqS = null;
        } else if (!str.equals(this.eqS)) {
            reset();
            this.eqS = str;
        } else {
            this.eqT = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.eqT) {
            this.eqU = false;
            return null;
        } else if (this.enR != null && this.enR.aKA() != null && this.enR.aKA().size() > 0) {
            this.eqU = true;
            com.baidu.tieba.pb.data.f fVar = this.enR;
            this.enR = null;
            return fVar;
        } else {
            this.eqU = false;
            this.enR = null;
            return null;
        }
    }

    public Parcelable aNM() {
        if (this.eqU) {
            this.eqU = false;
            Parcelable parcelable = this.eqV;
            this.eqV = null;
            return parcelable;
        }
        this.eqV = null;
        return null;
    }

    public boolean aMD() {
        return this.enF;
    }

    public boolean aNN() {
        return this.enD;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2) {
        this.eqT = false;
        if (this.eqS == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.aKA() == null) {
            reset();
            return false;
        } else if (fVar.aKA().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.enR = fVar;
            this.eqU = false;
            this.eqV = parcelable;
            this.enF = z;
            this.enD = z2;
            return true;
        }
    }

    public void reset() {
        this.eqT = false;
        this.enR = null;
        this.eqU = false;
        this.eqV = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.enR != null && this.enR.aKx() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.c(this.enR.aKx().getId(), 0L)) {
                this.enR.aKx().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null && this.enR != null && this.enR.aKA() != null && this.enR.aKA().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.enR.aKA().size();
                for (int i = 0; i < size; i++) {
                    if (this.enR.aKA().get(i) != null && this.enR.aKA().get(i).getAuthor() != null && currentAccount.equals(this.enR.aKA().get(i).getAuthor().getUserId()) && this.enR.aKA().get(i).getAuthor().getPendantData() != null) {
                        this.enR.aKA().get(i).getAuthor().getPendantData().cr(jVar.qB());
                        this.enR.aKA().get(i).getAuthor().getPendantData().N(jVar.CO());
                    }
                }
            }
        }
    }
}
