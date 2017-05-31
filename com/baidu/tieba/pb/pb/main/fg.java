package com.baidu.tieba.pb.pb.main;

import android.os.Parcelable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class fg {
    private boolean epk;
    private boolean epm;
    private com.baidu.tieba.pb.data.f epx;
    private String esa;
    private boolean esb;
    private boolean esc;
    private Parcelable esd;

    static {
        MessageManager.getInstance().registerListener(new fh(CmdConfigCustom.METHOD_ACCOUNT_CHANGE));
        MessageManager.getInstance().registerListener(new fi(CmdConfigCustom.PB_RECORDER_RESET_CMD));
        MessageManager.getInstance().registerListener(new fj(CmdConfigCustom.CMD_LIKE_FORUM));
        MessageManager.getInstance().registerListener(new fk(CmdConfigCustom.CMD_UNLIKE_FORUM));
        MessageManager.getInstance().registerListener(new fl(CmdConfigCustom.CMD_UPDATE_PENDANT));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static fg ese = new fg(null);
    }

    public static fg aLX() {
        return a.ese;
    }

    private fg() {
        this.esa = null;
        this.esb = false;
        this.epx = null;
        this.esc = false;
        this.esd = null;
        this.epm = true;
        this.epk = false;
    }

    /* synthetic */ fg(fg fgVar) {
        this();
    }

    public void L(String str, boolean z) {
        this.esb = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.esa = null;
        } else if (!str.equals(this.esa)) {
            reset();
            this.esa = str;
        } else {
            this.esb = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.esb) {
            this.esc = false;
            return null;
        } else if (this.epx != null && this.epx.aID() != null && this.epx.aID().size() > 0) {
            this.esc = true;
            com.baidu.tieba.pb.data.f fVar = this.epx;
            this.epx = null;
            return fVar;
        } else {
            this.esc = false;
            this.epx = null;
            return null;
        }
    }

    public Parcelable aLY() {
        if (this.esc) {
            this.esc = false;
            Parcelable parcelable = this.esd;
            this.esd = null;
            return parcelable;
        }
        this.esd = null;
        return null;
    }

    public boolean aKN() {
        return this.epm;
    }

    public boolean aLZ() {
        return this.epk;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2) {
        this.esb = false;
        if (this.esa == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.aID() == null) {
            reset();
            return false;
        } else if (fVar.aID().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.epx = fVar;
            this.esc = false;
            this.esd = parcelable;
            this.epm = z;
            this.epk = z2;
            return true;
        }
    }

    public void reset() {
        this.esb = false;
        this.epx = null;
        this.esc = false;
        this.esd = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.epx != null && this.epx.aIz() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.c(this.epx.aIz().getId(), 0L)) {
                this.epx.aIz().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null && this.epx != null && this.epx.aID() != null && this.epx.aID().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.epx.aID().size();
                for (int i = 0; i < size; i++) {
                    if (this.epx.aID().get(i) != null && this.epx.aID().get(i).getAuthor() != null && currentAccount.equals(this.epx.aID().get(i).getAuthor().getUserId()) && this.epx.aID().get(i).getAuthor().getPendantData() != null) {
                        this.epx.aID().get(i).getAuthor().getPendantData().cq(jVar.pL());
                        this.epx.aID().get(i).getAuthor().getPendantData().O(jVar.BN());
                    }
                }
            }
        }
    }
}
