package com.baidu.tieba.pb.pb.main;

import android.os.Parcelable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class eq {
    private boolean ekh;
    private boolean ekj;
    private com.baidu.tieba.pb.data.f ekv;
    private String ent;
    private boolean enu;
    private boolean env;
    private Parcelable enw;

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
        private static eq enx = new eq(null);
    }

    public static eq aNi() {
        return a.enx;
    }

    private eq() {
        this.ent = null;
        this.enu = false;
        this.ekv = null;
        this.env = false;
        this.enw = null;
        this.ekj = true;
        this.ekh = false;
    }

    /* synthetic */ eq(eq eqVar) {
        this();
    }

    public void N(String str, boolean z) {
        this.enu = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.ent = null;
        } else if (!str.equals(this.ent)) {
            reset();
            this.ent = str;
        } else {
            this.enu = true;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        if (!this.enu) {
            this.env = false;
            return null;
        } else if (this.ekv != null && this.ekv.aKb() != null && this.ekv.aKb().size() > 0) {
            this.env = true;
            com.baidu.tieba.pb.data.f fVar = this.ekv;
            this.ekv = null;
            return fVar;
        } else {
            this.env = false;
            this.ekv = null;
            return null;
        }
    }

    public Parcelable aNj() {
        if (this.env) {
            this.env = false;
            Parcelable parcelable = this.enw;
            this.enw = null;
            return parcelable;
        }
        this.enw = null;
        return null;
    }

    public boolean aLY() {
        return this.ekj;
    }

    public boolean aNk() {
        return this.ekh;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, Parcelable parcelable, boolean z, boolean z2) {
        this.enu = false;
        if (this.ent == null) {
            reset();
            return false;
        } else if (fVar == null) {
            reset();
            return false;
        } else if (fVar.aKb() == null) {
            reset();
            return false;
        } else if (fVar.aKb().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.ekv = fVar;
            this.env = false;
            this.enw = parcelable;
            this.ekj = z;
            this.ekh = z2;
            return true;
        }
    }

    public void reset() {
        this.enu = false;
        this.ekv = null;
        this.env = false;
        this.enw = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.ekv != null && this.ekv.aJY() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.c(this.ekv.aJY().getId(), 0L)) {
                this.ekv.aJY().setLike(i);
            }
        }
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null && this.ekv != null && this.ekv.aKb() != null && this.ekv.aKb().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.ekv.aKb().size();
                for (int i = 0; i < size; i++) {
                    if (this.ekv.aKb().get(i) != null && this.ekv.aKb().get(i).getAuthor() != null && currentAccount.equals(this.ekv.aKb().get(i).getAuthor().getUserId()) && this.ekv.aKb().get(i).getAuthor().getPendantData() != null) {
                        this.ekv.aKb().get(i).getAuthor().getPendantData().cq(jVar.pL());
                        this.ekv.aKb().get(i).getAuthor().getPendantData().N(jVar.BX());
                    }
                }
            }
        }
    }
}
