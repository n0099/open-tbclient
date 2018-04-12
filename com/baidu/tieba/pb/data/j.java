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
    public static final BdUniqueId fcI = BdUniqueId.gen();
    private long fcJ;
    private boolean fcK;
    private ArrayList<MuteUser> fcL;
    public long shareNum;
    public int fcG = -1;
    private boolean fcM = false;
    private boolean fcN = false;
    private int fcO = 1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fcI;
    }

    public void a(DataRes dataRes) {
        boolean z = true;
        if (dataRes != null) {
            if (dataRes.thread != null && dataRes.thread.agree != null) {
                this.fcJ = dataRes.thread.agree.agree_num.longValue();
                this.fcK = dataRes.thread.agree.has_agree.intValue() == 1;
                this.fcG = dataRes.thread.agree.agree_type.intValue();
            }
            if (this.fcL == null) {
                this.fcL = new ArrayList<>();
            }
            this.fcL.clear();
            if (dataRes.new_agree_user != null && dataRes.new_agree_user.size() > 0) {
                for (SimpleUser simpleUser : dataRes.new_agree_user) {
                    if (simpleUser != null) {
                        MuteUser muteUser = new MuteUser();
                        muteUser.parserProtobuf(simpleUser);
                        this.fcL.add(muteUser);
                    }
                }
            }
            if (dataRes.thread != null) {
                this.shareNum = dataRes.thread.share_num.longValue();
                this.fcN = (dataRes.thread.origin_thread_info == null || dataRes.thread.origin_thread_info.is_deleted.intValue() != 1) ? false : false;
            }
        }
    }

    public long aVU() {
        return this.fcJ;
    }

    public boolean aVV() {
        return this.fcN;
    }

    public boolean aVW() {
        return this.fcK;
    }

    public ArrayList<MuteUser> aVX() {
        return this.fcL;
    }

    public void pW(int i) {
        if (!this.fcK) {
            pY(i);
            return;
        }
        this.fcG = i;
        this.fcK = true;
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (currentAccountName != null) {
            Iterator<MuteUser> it = this.fcL.iterator();
            while (it.hasNext()) {
                MuteUser next = it.next();
                if (currentAccountName.equals(next.getUserName())) {
                    next.agreeType = i;
                    return;
                }
            }
        }
    }

    public void pX(int i) {
        this.fcO = i;
    }

    public int aVY() {
        return this.fcO;
    }

    public void pY(int i) {
        if (TbadkCoreApplication.isLogin()) {
            MuteUser muteUser = new MuteUser();
            muteUser.setUserId(TbadkCoreApplication.getCurrentAccount());
            muteUser.setUserName(TbadkCoreApplication.getCurrentAccountName());
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                muteUser.setNickName(TbadkCoreApplication.getCurrentAccountObj().getAccountNameShow());
            }
            muteUser.agreeType = i;
            if (this.fcL == null) {
                this.fcL = new ArrayList<>();
            }
            this.fcL.add(0, muteUser);
            if (this.fcJ < 0) {
                this.fcJ = 0L;
            }
            this.fcJ++;
            this.fcK = true;
            this.fcG = i;
        }
    }

    public void aVZ() {
        if (TbadkCoreApplication.isLogin()) {
            this.fcJ--;
            if (this.fcJ < 0) {
                this.fcJ = 0L;
            }
            this.fcK = false;
            this.fcG = -1;
            if (!v.w(this.fcL)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    Iterator<MuteUser> it = this.fcL.iterator();
                    while (it.hasNext()) {
                        MuteUser next = it.next();
                        if (next != null && currentAccount.equals(next.getUserId())) {
                            this.fcL.remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void jp(boolean z) {
        this.fcM = z;
    }

    public boolean aWa() {
        return this.fcM;
    }
}
