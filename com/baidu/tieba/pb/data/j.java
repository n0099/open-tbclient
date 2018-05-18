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
public class j implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId fdM = BdUniqueId.gen();
    private long fdN;
    private boolean fdO;
    private ArrayList<MuteUser> fdP;
    public long shareNum;
    public int fdK = -1;
    private boolean fdQ = false;
    private boolean fdR = false;
    private int fdS = 1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fdM;
    }

    public void a(DataRes dataRes) {
        boolean z = true;
        if (dataRes != null) {
            if (dataRes.thread != null && dataRes.thread.agree != null) {
                this.fdN = dataRes.thread.agree.agree_num.longValue();
                this.fdO = dataRes.thread.agree.has_agree.intValue() == 1;
                this.fdK = dataRes.thread.agree.agree_type.intValue();
            }
            if (this.fdP == null) {
                this.fdP = new ArrayList<>();
            }
            this.fdP.clear();
            if (dataRes.new_agree_user != null && dataRes.new_agree_user.size() > 0) {
                for (SimpleUser simpleUser : dataRes.new_agree_user) {
                    if (simpleUser != null) {
                        MuteUser muteUser = new MuteUser();
                        muteUser.parserProtobuf(simpleUser);
                        this.fdP.add(muteUser);
                    }
                }
            }
            if (dataRes.thread != null) {
                this.shareNum = dataRes.thread.share_num.longValue();
                this.fdR = (dataRes.thread.origin_thread_info == null || dataRes.thread.origin_thread_info.is_deleted.intValue() != 1) ? false : false;
            }
        }
    }

    public long aVU() {
        return this.fdN;
    }

    public boolean aVV() {
        return this.fdR;
    }

    public boolean aVW() {
        return this.fdO;
    }

    public ArrayList<MuteUser> aVX() {
        return this.fdP;
    }

    public void pU(int i) {
        if (!this.fdO) {
            pW(i);
            return;
        }
        this.fdK = i;
        this.fdO = true;
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (currentAccountName != null) {
            Iterator<MuteUser> it = this.fdP.iterator();
            while (it.hasNext()) {
                MuteUser next = it.next();
                if (currentAccountName.equals(next.getUserName())) {
                    next.agreeType = i;
                    return;
                }
            }
        }
    }

    public void pV(int i) {
        this.fdS = i;
    }

    public int aVY() {
        return this.fdS;
    }

    public void pW(int i) {
        if (TbadkCoreApplication.isLogin()) {
            MuteUser muteUser = new MuteUser();
            muteUser.setUserId(TbadkCoreApplication.getCurrentAccount());
            muteUser.setUserName(TbadkCoreApplication.getCurrentAccountName());
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                muteUser.setNickName(TbadkCoreApplication.getCurrentAccountObj().getAccountNameShow());
            }
            muteUser.agreeType = i;
            if (this.fdP == null) {
                this.fdP = new ArrayList<>();
            }
            this.fdP.add(0, muteUser);
            if (this.fdN < 0) {
                this.fdN = 0L;
            }
            this.fdN++;
            this.fdO = true;
            this.fdK = i;
        }
    }

    public void aVZ() {
        if (TbadkCoreApplication.isLogin()) {
            this.fdN--;
            if (this.fdN < 0) {
                this.fdN = 0L;
            }
            this.fdO = false;
            this.fdK = -1;
            if (!v.w(this.fdP)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    Iterator<MuteUser> it = this.fdP.iterator();
                    while (it.hasNext()) {
                        MuteUser next = it.next();
                        if (next != null && currentAccount.equals(next.getUserId())) {
                            this.fdP.remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void jq(boolean z) {
        this.fdQ = z;
    }

    public boolean aWa() {
        return this.fdQ;
    }
}
