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
    public static final BdUniqueId fEC = BdUniqueId.gen();
    public long dFN;
    private long fED;
    private boolean fEE;
    private ArrayList<MuteUser> fEF;
    public int fEA = -1;
    private boolean fEG = false;
    private boolean fEH = false;
    private int fEI = 1;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return fEC;
    }

    public void a(DataRes dataRes) {
        boolean z = true;
        if (dataRes != null) {
            if (dataRes.thread != null && dataRes.thread.agree != null) {
                this.fED = dataRes.thread.agree.agree_num.longValue();
                this.fEE = dataRes.thread.agree.has_agree.intValue() == 1;
                this.fEA = dataRes.thread.agree.agree_type.intValue();
            }
            if (this.fEF == null) {
                this.fEF = new ArrayList<>();
            }
            this.fEF.clear();
            if (dataRes.new_agree_user != null && dataRes.new_agree_user.size() > 0) {
                for (SimpleUser simpleUser : dataRes.new_agree_user) {
                    if (simpleUser != null) {
                        MuteUser muteUser = new MuteUser();
                        muteUser.parserProtobuf(simpleUser);
                        this.fEF.add(muteUser);
                    }
                }
            }
            if (dataRes.thread != null) {
                this.dFN = dataRes.thread.share_num.longValue();
                this.fEH = (dataRes.thread.origin_thread_info == null || dataRes.thread.origin_thread_info.is_deleted.intValue() != 1) ? false : false;
            }
        }
    }

    public long aZq() {
        return this.fED;
    }

    public boolean aZr() {
        return this.fEH;
    }

    public boolean aZs() {
        return this.fEE;
    }

    public ArrayList<MuteUser> aZt() {
        return this.fEF;
    }

    public void sx(int i) {
        if (!this.fEE) {
            sz(i);
            return;
        }
        this.fEA = i;
        this.fEE = true;
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (currentAccountName != null) {
            Iterator<MuteUser> it = this.fEF.iterator();
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
        this.fEI = i;
    }

    public int aZu() {
        return this.fEI;
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
            if (this.fEF == null) {
                this.fEF = new ArrayList<>();
            }
            this.fEF.add(0, muteUser);
            if (this.fED < 0) {
                this.fED = 0L;
            }
            this.fED++;
            this.fEE = true;
            this.fEA = i;
        }
    }

    public void aZv() {
        if (TbadkCoreApplication.isLogin()) {
            this.fED--;
            if (this.fED < 0) {
                this.fED = 0L;
            }
            this.fEE = false;
            this.fEA = -1;
            if (!v.E(this.fEF)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    Iterator<MuteUser> it = this.fEF.iterator();
                    while (it.hasNext()) {
                        MuteUser next = it.next();
                        if (next != null && currentAccount.equals(next.getUserId())) {
                            this.fEF.remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void jF(boolean z) {
        this.fEG = z;
    }

    public boolean aZw() {
        return this.fEG;
    }
}
