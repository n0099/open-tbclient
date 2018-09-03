package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.usermute.MuteUser;
import java.util.ArrayList;
import java.util.Iterator;
import tbclient.PbPage.DataRes;
import tbclient.SimpleUser;
/* loaded from: classes2.dex */
public class j implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId fth = BdUniqueId.gen();
    private long fti;
    private boolean ftj;
    private ArrayList<MuteUser> ftk;
    public long shareNum;
    public int ftf = -1;
    private boolean ftl = false;
    private boolean ftm = false;
    private int ftn = 1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fth;
    }

    public void b(DataRes dataRes) {
        boolean z = true;
        if (dataRes != null) {
            if (dataRes.thread != null && dataRes.thread.agree != null) {
                this.fti = dataRes.thread.agree.agree_num.longValue();
                this.ftj = dataRes.thread.agree.has_agree.intValue() == 1;
                this.ftf = dataRes.thread.agree.agree_type.intValue();
            }
            if (this.ftk == null) {
                this.ftk = new ArrayList<>();
            }
            this.ftk.clear();
            if (dataRes.new_agree_user != null && dataRes.new_agree_user.size() > 0) {
                for (SimpleUser simpleUser : dataRes.new_agree_user) {
                    if (simpleUser != null) {
                        MuteUser muteUser = new MuteUser();
                        muteUser.parserProtobuf(simpleUser);
                        this.ftk.add(muteUser);
                    }
                }
            }
            if (dataRes.thread != null) {
                this.shareNum = dataRes.thread.share_num.longValue();
                this.ftm = (dataRes.thread.origin_thread_info == null || dataRes.thread.origin_thread_info.is_deleted.intValue() != 1) ? false : false;
            }
        }
    }

    public long aZM() {
        return this.fti;
    }

    public boolean aZN() {
        return this.ftm;
    }

    public boolean aZO() {
        return this.ftj;
    }

    public ArrayList<MuteUser> aZP() {
        return this.ftk;
    }

    public void qk(int i) {
        if (!this.ftj) {
            qm(i);
            return;
        }
        this.ftf = i;
        this.ftj = true;
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (currentAccountName != null) {
            Iterator<MuteUser> it = this.ftk.iterator();
            while (it.hasNext()) {
                MuteUser next = it.next();
                if (currentAccountName.equals(next.getUserName())) {
                    next.agreeType = i;
                    return;
                }
            }
        }
    }

    public void ql(int i) {
        this.ftn = i;
    }

    public int aZQ() {
        return this.ftn;
    }

    public void qm(int i) {
        if (TbadkCoreApplication.isLogin()) {
            MuteUser muteUser = new MuteUser();
            muteUser.setUserId(TbadkCoreApplication.getCurrentAccount());
            muteUser.setUserName(TbadkCoreApplication.getCurrentAccountName());
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                muteUser.setNickName(TbadkCoreApplication.getCurrentAccountObj().getAccountNameShow());
            }
            muteUser.agreeType = i;
            if (this.ftk == null) {
                this.ftk = new ArrayList<>();
            }
            this.ftk.add(0, muteUser);
            if (this.fti < 0) {
                this.fti = 0L;
            }
            this.fti++;
            this.ftj = true;
            this.ftf = i;
        }
    }

    public void aZR() {
        if (TbadkCoreApplication.isLogin()) {
            this.fti--;
            if (this.fti < 0) {
                this.fti = 0L;
            }
            this.ftj = false;
            this.ftf = -1;
            if (!w.z(this.ftk)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    Iterator<MuteUser> it = this.ftk.iterator();
                    while (it.hasNext()) {
                        MuteUser next = it.next();
                        if (next != null && currentAccount.equals(next.getUserId())) {
                            this.ftk.remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void jr(boolean z) {
        this.ftl = z;
    }

    public boolean aZS() {
        return this.ftl;
    }
}
