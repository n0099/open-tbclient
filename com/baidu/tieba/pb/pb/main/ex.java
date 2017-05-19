package com.baidu.tieba.pb.pb.main;

import android.os.Parcelable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ex {
    private boolean ejA;
    private com.baidu.tieba.pb.data.f ejL;
    private boolean ejy;
    private String emn;
    private boolean emo;
    private boolean emp;
    private Parcelable emq;

    static {
        MessageManager.getInstance().registerListener(new ey(CmdConfigCustom.METHOD_ACCOUNT_CHANGE));
        MessageManager.getInstance().registerListener(new ez(CmdConfigCustom.PB_RECORDER_RESET_CMD));
        MessageManager.getInstance().registerListener(new fa(CmdConfigCustom.CMD_LIKE_FORUM));
        MessageManager.getInstance().registerListener(new fb(CmdConfigCustom.CMD_UNLIKE_FORUM));
        MessageManager.getInstance().registerListener(new fc(CmdConfigCustom.CMD_UPDATE_PENDANT));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static ex emr = new ex(null);
    }

    public static ex aLb() {
        return a.emr;
    }

    private ex() {
        this.emn = null;
        this.emo = false;
        this.ejL = null;
        this.emp = false;
        this.emq = null;
        this.ejA = true;
        this.ejy = false;
    }

    /* synthetic */ ex(ex exVar) {
        this();
    }

    public void O(String str, boolean z) {
        this.emo = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.emn = null;
        } else if (!str.equals(this.emn)) {
            reset();
            this.emn = str;
        } else {
            this.emo = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.emo) {
            this.emp = false;
            return null;
        } else if (this.ejL != null && this.ejL.aHI() != null && this.ejL.aHI().size() > 0) {
            this.emp = true;
            com.baidu.tieba.pb.data.f fVar = this.ejL;
            this.ejL = null;
            return fVar;
        } else {
            this.emp = false;
            this.ejL = null;
            return null;
        }
    }

    public Parcelable aLc() {
        if (this.emp) {
            this.emp = false;
            Parcelable parcelable = this.emq;
            this.emq = null;
            return parcelable;
        }
        this.emq = null;
        return null;
    }

    public boolean aJT() {
        return this.ejA;
    }

    public boolean aLd() {
        return this.ejy;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2) {
        this.emo = false;
        if (this.emn == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.aHI() == null) {
            reset();
            return false;
        } else if (fVar.aHI().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.ejL = fVar;
            this.emp = false;
            this.emq = parcelable;
            this.ejA = z;
            this.ejy = z2;
            return true;
        }
    }

    public void reset() {
        this.emo = false;
        this.ejL = null;
        this.emp = false;
        this.emq = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.ejL != null && this.ejL.aHE() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.c(this.ejL.aHE().getId(), 0L)) {
                this.ejL.aHE().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.i iVar) {
        if (iVar != null && this.ejL != null && this.ejL.aHI() != null && this.ejL.aHI().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.ejL.aHI().size();
                for (int i = 0; i < size; i++) {
                    if (this.ejL.aHI().get(i) != null && this.ejL.aHI().get(i).getAuthor() != null && currentAccount.equals(this.ejL.aHI().get(i).getAuthor().getUserId()) && this.ejL.aHI().get(i).getAuthor().getPendantData() != null) {
                        this.ejL.aHI().get(i).getAuthor().getPendantData().cr(iVar.pT());
                        this.ejL.aHI().get(i).getAuthor().getPendantData().O(iVar.BT());
                    }
                }
            }
        }
    }
}
