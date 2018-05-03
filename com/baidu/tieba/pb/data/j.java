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
    public static final BdUniqueId fcF = BdUniqueId.gen();
    private long fcG;
    private boolean fcH;
    private ArrayList<MuteUser> fcI;
    public long shareNum;
    public int fcD = -1;
    private boolean fcJ = false;
    private boolean fcK = false;
    private int fcL = 1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fcF;
    }

    public void a(DataRes dataRes) {
        boolean z = true;
        if (dataRes != null) {
            if (dataRes.thread != null && dataRes.thread.agree != null) {
                this.fcG = dataRes.thread.agree.agree_num.longValue();
                this.fcH = dataRes.thread.agree.has_agree.intValue() == 1;
                this.fcD = dataRes.thread.agree.agree_type.intValue();
            }
            if (this.fcI == null) {
                this.fcI = new ArrayList<>();
            }
            this.fcI.clear();
            if (dataRes.new_agree_user != null && dataRes.new_agree_user.size() > 0) {
                for (SimpleUser simpleUser : dataRes.new_agree_user) {
                    if (simpleUser != null) {
                        MuteUser muteUser = new MuteUser();
                        muteUser.parserProtobuf(simpleUser);
                        this.fcI.add(muteUser);
                    }
                }
            }
            if (dataRes.thread != null) {
                this.shareNum = dataRes.thread.share_num.longValue();
                this.fcK = (dataRes.thread.origin_thread_info == null || dataRes.thread.origin_thread_info.is_deleted.intValue() != 1) ? false : false;
            }
        }
    }

    public long aVU() {
        return this.fcG;
    }

    public boolean aVV() {
        return this.fcK;
    }

    public boolean aVW() {
        return this.fcH;
    }

    public ArrayList<MuteUser> aVX() {
        return this.fcI;
    }

    public void pV(int i) {
        if (!this.fcH) {
            pX(i);
            return;
        }
        this.fcD = i;
        this.fcH = true;
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (currentAccountName != null) {
            Iterator<MuteUser> it = this.fcI.iterator();
            while (it.hasNext()) {
                MuteUser next = it.next();
                if (currentAccountName.equals(next.getUserName())) {
                    next.agreeType = i;
                    return;
                }
            }
        }
    }

    public void pW(int i) {
        this.fcL = i;
    }

    public int aVY() {
        return this.fcL;
    }

    public void pX(int i) {
        if (TbadkCoreApplication.isLogin()) {
            MuteUser muteUser = new MuteUser();
            muteUser.setUserId(TbadkCoreApplication.getCurrentAccount());
            muteUser.setUserName(TbadkCoreApplication.getCurrentAccountName());
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                muteUser.setNickName(TbadkCoreApplication.getCurrentAccountObj().getAccountNameShow());
            }
            muteUser.agreeType = i;
            if (this.fcI == null) {
                this.fcI = new ArrayList<>();
            }
            this.fcI.add(0, muteUser);
            if (this.fcG < 0) {
                this.fcG = 0L;
            }
            this.fcG++;
            this.fcH = true;
            this.fcD = i;
        }
    }

    public void aVZ() {
        if (TbadkCoreApplication.isLogin()) {
            this.fcG--;
            if (this.fcG < 0) {
                this.fcG = 0L;
            }
            this.fcH = false;
            this.fcD = -1;
            if (!v.w(this.fcI)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    Iterator<MuteUser> it = this.fcI.iterator();
                    while (it.hasNext()) {
                        MuteUser next = it.next();
                        if (next != null && currentAccount.equals(next.getUserId())) {
                            this.fcI.remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void jp(boolean z) {
        this.fcJ = z;
    }

    public boolean aWa() {
        return this.fcJ;
    }
}
