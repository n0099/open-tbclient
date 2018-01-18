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
public class l implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId fEh = BdUniqueId.gen();
    public long dFs;
    private long fEi;
    private boolean fEj;
    private ArrayList<MuteUser> fEk;
    public int fEf = -1;
    private boolean fEl = false;
    private boolean fEm = false;
    private int fEn = 1;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return fEh;
    }

    public void a(DataRes dataRes) {
        boolean z = true;
        if (dataRes != null) {
            if (dataRes.thread != null && dataRes.thread.agree != null) {
                this.fEi = dataRes.thread.agree.agree_num.longValue();
                this.fEj = dataRes.thread.agree.has_agree.intValue() == 1;
                this.fEf = dataRes.thread.agree.agree_type.intValue();
            }
            if (this.fEk == null) {
                this.fEk = new ArrayList<>();
            }
            this.fEk.clear();
            if (dataRes.new_agree_user != null && dataRes.new_agree_user.size() > 0) {
                for (SimpleUser simpleUser : dataRes.new_agree_user) {
                    if (simpleUser != null) {
                        MuteUser muteUser = new MuteUser();
                        muteUser.parserProtobuf(simpleUser);
                        this.fEk.add(muteUser);
                    }
                }
            }
            if (dataRes.thread != null) {
                this.dFs = dataRes.thread.share_num.longValue();
                this.fEm = (dataRes.thread.origin_thread_info == null || dataRes.thread.origin_thread_info.is_deleted.intValue() != 1) ? false : false;
            }
        }
    }

    public long aZl() {
        return this.fEi;
    }

    public boolean aZm() {
        return this.fEm;
    }

    public boolean aZn() {
        return this.fEj;
    }

    public ArrayList<MuteUser> aZo() {
        return this.fEk;
    }

    public void sx(int i) {
        if (!this.fEj) {
            sz(i);
            return;
        }
        this.fEf = i;
        this.fEj = true;
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (currentAccountName != null) {
            Iterator<MuteUser> it = this.fEk.iterator();
            while (it.hasNext()) {
                MuteUser next = it.next();
                if (currentAccountName.equals(next.getUserName())) {
                    next.agreeType = i;
                    return;
                }
            }
        }
    }

    public void sy(int i) {
        this.fEn = i;
    }

    public int aZp() {
        return this.fEn;
    }

    public void sz(int i) {
        if (TbadkCoreApplication.isLogin()) {
            MuteUser muteUser = new MuteUser();
            muteUser.setUserId(TbadkCoreApplication.getCurrentAccount());
            muteUser.setUserName(TbadkCoreApplication.getCurrentAccountName());
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                muteUser.setNickName(TbadkCoreApplication.getCurrentAccountObj().getAccountNameShow());
            }
            muteUser.agreeType = i;
            if (this.fEk == null) {
                this.fEk = new ArrayList<>();
            }
            this.fEk.add(0, muteUser);
            if (this.fEi < 0) {
                this.fEi = 0L;
            }
            this.fEi++;
            this.fEj = true;
            this.fEf = i;
        }
    }

    public void aZq() {
        if (TbadkCoreApplication.isLogin()) {
            this.fEi--;
            if (this.fEi < 0) {
                this.fEi = 0L;
            }
            this.fEj = false;
            this.fEf = -1;
            if (!v.E(this.fEk)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    Iterator<MuteUser> it = this.fEk.iterator();
                    while (it.hasNext()) {
                        MuteUser next = it.next();
                        if (next != null && currentAccount.equals(next.getUserId())) {
                            this.fEk.remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void jC(boolean z) {
        this.fEl = z;
    }

    public boolean aZr() {
        return this.fEl;
    }
}
