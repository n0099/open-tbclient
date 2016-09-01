package com.baidu.tieba.pb.pb.main;

import android.os.Parcelable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ep {
    private boolean epk;
    private boolean epm;
    private com.baidu.tieba.pb.data.h epx;
    private String erP;
    private boolean erQ;
    private boolean erR;
    private Parcelable erS;

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
        private static ep erT = new ep(null);
    }

    public static ep aOQ() {
        return a.erT;
    }

    private ep() {
        this.erP = null;
        this.erQ = false;
        this.epx = null;
        this.erR = false;
        this.erS = null;
        this.epm = true;
        this.epk = false;
    }

    /* synthetic */ ep(ep epVar) {
        this();
    }

    public void L(String str, boolean z) {
        this.erQ = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.erP = null;
        } else if (!str.equals(this.erP)) {
            reset();
            this.erP = str;
        } else {
            this.erQ = true;
        }
    }

    public com.baidu.tieba.pb.data.h getPbData() {
        if (!this.erQ) {
            this.erR = false;
            return null;
        } else if (this.epx != null && this.epx.aLR() != null && this.epx.aLR().size() > 0) {
            this.erR = true;
            com.baidu.tieba.pb.data.h hVar = this.epx;
            this.epx = null;
            return hVar;
        } else {
            this.erR = false;
            this.epx = null;
            return null;
        }
    }

    public Parcelable aOR() {
        if (this.erR) {
            this.erR = false;
            Parcelable parcelable = this.erS;
            this.erS = null;
            return parcelable;
        }
        this.erS = null;
        return null;
    }

    public boolean aNO() {
        return this.epm;
    }

    public boolean aOS() {
        return this.epk;
    }

    public boolean a(com.baidu.tieba.pb.data.h hVar, Parcelable parcelable, boolean z, boolean z2) {
        this.erQ = false;
        if (this.erP == null) {
            reset();
            return false;
        } else if (hVar == null) {
            reset();
            return false;
        } else if (hVar.aLR() == null) {
            reset();
            return false;
        } else if (hVar.aLR().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.epx = hVar;
            this.erR = false;
            this.erS = parcelable;
            this.epm = z;
            this.epk = z2;
            return true;
        }
    }

    public void reset() {
        this.erQ = false;
        this.epx = null;
        this.erR = false;
        this.erS = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.epx != null && this.epx.aLP() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.h.b.c(this.epx.aLP().getId(), 0L)) {
                this.epx.aLP().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null && this.epx != null && this.epx.aLR() != null && this.epx.aLR().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.epx.aLR().size();
                for (int i = 0; i < size; i++) {
                    if (this.epx.aLR().get(i) != null && this.epx.aLR().get(i).getAuthor() != null && currentAccount.equals(this.epx.aLR().get(i).getAuthor().getUserId()) && this.epx.aLR().get(i).getAuthor().getPendantData() != null) {
                        this.epx.aLR().get(i).getAuthor().getPendantData().cq(jVar.rc());
                        this.epx.aLR().get(i).getAuthor().getPendantData().P(jVar.Cd());
                    }
                }
            }
        }
    }
}
