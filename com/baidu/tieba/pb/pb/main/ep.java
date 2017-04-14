package com.baidu.tieba.pb.pb.main;

import android.os.Parcelable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ep {
    private boolean ell;
    private boolean eln;
    private com.baidu.tieba.pb.data.f elz;
    private String eoB;
    private boolean eoC;
    private boolean eoD;
    private Parcelable eoE;

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
        private static ep eoF = new ep(null);
    }

    public static ep aMK() {
        return a.eoF;
    }

    private ep() {
        this.eoB = null;
        this.eoC = false;
        this.elz = null;
        this.eoD = false;
        this.eoE = null;
        this.eln = true;
        this.ell = false;
    }

    /* synthetic */ ep(ep epVar) {
        this();
    }

    public void O(String str, boolean z) {
        this.eoC = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.eoB = null;
        } else if (!str.equals(this.eoB)) {
            reset();
            this.eoB = str;
        } else {
            this.eoC = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.eoC) {
            this.eoD = false;
            return null;
        } else if (this.elz != null && this.elz.aJz() != null && this.elz.aJz().size() > 0) {
            this.eoD = true;
            com.baidu.tieba.pb.data.f fVar = this.elz;
            this.elz = null;
            return fVar;
        } else {
            this.eoD = false;
            this.elz = null;
            return null;
        }
    }

    public Parcelable aML() {
        if (this.eoD) {
            this.eoD = false;
            Parcelable parcelable = this.eoE;
            this.eoE = null;
            return parcelable;
        }
        this.eoE = null;
        return null;
    }

    public boolean aLC() {
        return this.eln;
    }

    public boolean aMM() {
        return this.ell;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2) {
        this.eoC = false;
        if (this.eoB == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.aJz() == null) {
            reset();
            return false;
        } else if (fVar.aJz().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.elz = fVar;
            this.eoD = false;
            this.eoE = parcelable;
            this.eln = z;
            this.ell = z2;
            return true;
        }
    }

    public void reset() {
        this.eoC = false;
        this.elz = null;
        this.eoD = false;
        this.eoE = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.elz != null && this.elz.aJw() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.c(this.elz.aJw().getId(), 0L)) {
                this.elz.aJw().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null && this.elz != null && this.elz.aJz() != null && this.elz.aJz().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.elz.aJz().size();
                for (int i = 0; i < size; i++) {
                    if (this.elz.aJz().get(i) != null && this.elz.aJz().get(i).getAuthor() != null && currentAccount.equals(this.elz.aJz().get(i).getAuthor().getUserId()) && this.elz.aJz().get(i).getAuthor().getPendantData() != null) {
                        this.elz.aJz().get(i).getAuthor().getPendantData().cr(jVar.qB());
                        this.elz.aJz().get(i).getAuthor().getPendantData().N(jVar.CO());
                    }
                }
            }
        }
    }
}
