package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.usermute.MuteUser;
import java.util.ArrayList;
import java.util.Iterator;
import tbclient.PbPage.DataRes;
import tbclient.SimpleUser;
/* loaded from: classes2.dex */
public class j implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId fHO = BdUniqueId.gen();
    private long fHP;
    private boolean fHQ;
    private ArrayList<MuteUser> fHR;
    public long shareNum;
    public int fHM = -1;
    private boolean fHS = false;
    private boolean fHT = false;
    private int fHU = 1;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return fHO;
    }

    public void a(DataRes dataRes) {
        boolean z = true;
        if (dataRes != null) {
            if (dataRes.thread != null && dataRes.thread.agree != null) {
                this.fHP = dataRes.thread.agree.agree_num.longValue();
                this.fHQ = dataRes.thread.agree.has_agree.intValue() == 1;
                this.fHM = dataRes.thread.agree.agree_type.intValue();
            }
            if (this.fHR == null) {
                this.fHR = new ArrayList<>();
            }
            this.fHR.clear();
            if (dataRes.new_agree_user != null && dataRes.new_agree_user.size() > 0) {
                for (SimpleUser simpleUser : dataRes.new_agree_user) {
                    if (simpleUser != null) {
                        MuteUser muteUser = new MuteUser();
                        muteUser.parserProtobuf(simpleUser);
                        this.fHR.add(muteUser);
                    }
                }
            }
            if (dataRes.thread != null) {
                this.shareNum = dataRes.thread.share_num.longValue();
                this.fHT = (dataRes.thread.origin_thread_info == null || dataRes.thread.origin_thread_info.is_deleted.intValue() != 1) ? false : false;
            }
        }
    }

    public long baU() {
        return this.fHP;
    }

    public boolean baV() {
        return this.fHT;
    }

    public boolean baW() {
        return this.fHQ;
    }

    public ArrayList<MuteUser> baX() {
        return this.fHR;
    }

    public void sB(int i) {
        if (!this.fHQ) {
            sD(i);
            return;
        }
        this.fHM = i;
        this.fHQ = true;
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (currentAccountName != null) {
            Iterator<MuteUser> it = this.fHR.iterator();
            while (it.hasNext()) {
                MuteUser next = it.next();
                if (currentAccountName.equals(next.getUserName())) {
                    next.agreeType = i;
                    return;
                }
            }
        }
    }

    public void sC(int i) {
        this.fHU = i;
    }

    public int baY() {
        return this.fHU;
    }

    public void sD(int i) {
        if (TbadkCoreApplication.isLogin()) {
            MuteUser muteUser = new MuteUser();
            muteUser.setUserId(TbadkCoreApplication.getCurrentAccount());
            muteUser.setUserName(TbadkCoreApplication.getCurrentAccountName());
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                muteUser.setNickName(TbadkCoreApplication.getCurrentAccountObj().getAccountNameShow());
            }
            muteUser.agreeType = i;
            if (this.fHR == null) {
                this.fHR = new ArrayList<>();
            }
            this.fHR.add(0, muteUser);
            if (this.fHP < 0) {
                this.fHP = 0L;
            }
            this.fHP++;
            this.fHQ = true;
            this.fHM = i;
        }
    }

    public void baZ() {
        if (TbadkCoreApplication.isLogin()) {
            this.fHP--;
            if (this.fHP < 0) {
                this.fHP = 0L;
            }
            this.fHQ = false;
            this.fHM = -1;
            if (!v.E(this.fHR)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    Iterator<MuteUser> it = this.fHR.iterator();
                    while (it.hasNext()) {
                        MuteUser next = it.next();
                        if (next != null && currentAccount.equals(next.getUserId())) {
                            this.fHR.remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void jO(boolean z) {
        this.fHS = z;
    }

    public boolean bba() {
        return this.fHS;
    }
}
