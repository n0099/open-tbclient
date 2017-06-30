package com.baidu.tieba.pb.pb.main;

import android.os.Parcelable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class fp {
    private String eBl;
    private boolean eBm;
    private boolean eBn;
    private Parcelable eBo;
    private com.baidu.tieba.pb.data.f eyH;
    private boolean eyu;
    private boolean eyw;

    static {
        MessageManager.getInstance().registerListener(new fq(CmdConfigCustom.METHOD_ACCOUNT_CHANGE));
        MessageManager.getInstance().registerListener(new fr(CmdConfigCustom.PB_RECORDER_RESET_CMD));
        MessageManager.getInstance().registerListener(new fs(CmdConfigCustom.CMD_LIKE_FORUM));
        MessageManager.getInstance().registerListener(new ft(CmdConfigCustom.CMD_UNLIKE_FORUM));
        MessageManager.getInstance().registerListener(new fu(CmdConfigCustom.CMD_UPDATE_PENDANT));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static fp eBp = new fp(null);
    }

    public static fp aPV() {
        return a.eBp;
    }

    private fp() {
        this.eBl = null;
        this.eBm = false;
        this.eyH = null;
        this.eBn = false;
        this.eBo = null;
        this.eyw = true;
        this.eyu = false;
    }

    /* synthetic */ fp(fp fpVar) {
        this();
    }

    public void Q(String str, boolean z) {
        this.eBm = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.eBl = null;
        } else if (!str.equals(this.eBl)) {
            reset();
            this.eBl = str;
        } else {
            this.eBm = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.eBm) {
            this.eBn = false;
            return null;
        } else if (this.eyH != null && this.eyH.aMx() != null && this.eyH.aMx().size() > 0) {
            this.eBn = true;
            com.baidu.tieba.pb.data.f fVar = this.eyH;
            this.eyH = null;
            return fVar;
        } else {
            this.eBn = false;
            this.eyH = null;
            return null;
        }
    }

    public Parcelable aPW() {
        if (this.eBn) {
            this.eBn = false;
            Parcelable parcelable = this.eBo;
            this.eBo = null;
            return parcelable;
        }
        this.eBo = null;
        return null;
    }

    public boolean aOK() {
        return this.eyw;
    }

    public boolean aPX() {
        return this.eyu;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2) {
        this.eBm = false;
        if (this.eBl == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.aMx() == null) {
            reset();
            return false;
        } else if (fVar.aMx().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.eyH = fVar;
            this.eBn = false;
            this.eBo = parcelable;
            this.eyw = z;
            this.eyu = z2;
            return true;
        }
    }

    public void reset() {
        this.eBm = false;
        this.eyH = null;
        this.eBn = false;
        this.eBo = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.eyH != null && this.eyH.aMt() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.c(this.eyH.aMt().getId(), 0L)) {
                this.eyH.aMt().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null && this.eyH != null && this.eyH.aMx() != null && this.eyH.aMx().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.eyH.aMx().size();
                for (int i = 0; i < size; i++) {
                    if (this.eyH.aMx().get(i) != null && this.eyH.aMx().get(i).getAuthor() != null && currentAccount.equals(this.eyH.aMx().get(i).getAuthor().getUserId()) && this.eyH.aMx().get(i).getAuthor().getPendantData() != null) {
                        this.eyH.aMx().get(i).getAuthor().getPendantData().cw(jVar.pI());
                        this.eyH.aMx().get(i).getAuthor().getPendantData().P(jVar.Ch());
                    }
                }
            }
        }
    }
}
