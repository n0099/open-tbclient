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
    public static final BdUniqueId fCH = BdUniqueId.gen();
    public long dAR;
    private long fCI;
    private boolean fCJ;
    private ArrayList<MuteUser> fCK;
    public int fCF = -1;
    private boolean fCL = false;
    private boolean fCM = false;
    private int fCN = 1;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return fCH;
    }

    public void a(DataRes dataRes) {
        boolean z = true;
        if (dataRes != null) {
            if (dataRes.thread != null && dataRes.thread.agree != null) {
                this.fCI = dataRes.thread.agree.agree_num.longValue();
                this.fCJ = dataRes.thread.agree.has_agree.intValue() == 1;
                this.fCF = dataRes.thread.agree.agree_type.intValue();
            }
            if (this.fCK == null) {
                this.fCK = new ArrayList<>();
            }
            this.fCK.clear();
            if (dataRes.new_agree_user != null && dataRes.new_agree_user.size() > 0) {
                for (SimpleUser simpleUser : dataRes.new_agree_user) {
                    if (simpleUser != null) {
                        MuteUser muteUser = new MuteUser();
                        muteUser.parserProtobuf(simpleUser);
                        this.fCK.add(muteUser);
                    }
                }
            }
            if (dataRes.thread != null) {
                this.dAR = dataRes.thread.share_num.longValue();
                this.fCM = (dataRes.thread.origin_thread_info == null || dataRes.thread.origin_thread_info.is_deleted.intValue() != 1) ? false : false;
            }
        }
    }

    public long aZh() {
        return this.fCI;
    }

    public boolean aZi() {
        return this.fCM;
    }

    public boolean aZj() {
        return this.fCJ;
    }

    public ArrayList<MuteUser> aZk() {
        return this.fCK;
    }

    public void sE(int i) {
        if (!this.fCJ) {
            sG(i);
            return;
        }
        this.fCF = i;
        this.fCJ = true;
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (currentAccountName != null) {
            Iterator<MuteUser> it = this.fCK.iterator();
            while (it.hasNext()) {
                MuteUser next = it.next();
                if (currentAccountName.equals(next.getUserName())) {
                    next.agreeType = i;
                    return;
                }
            }
        }
    }

    public void sF(int i) {
        this.fCN = i;
    }

    public int aZl() {
        return this.fCN;
    }

    public void sG(int i) {
        if (TbadkCoreApplication.isLogin()) {
            MuteUser muteUser = new MuteUser();
            muteUser.setUserId(TbadkCoreApplication.getCurrentAccount());
            muteUser.setUserName(TbadkCoreApplication.getCurrentAccountName());
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                muteUser.setNickName(TbadkCoreApplication.getCurrentAccountObj().getAccountNameShow());
            }
            muteUser.agreeType = i;
            if (this.fCK == null) {
                this.fCK = new ArrayList<>();
            }
            this.fCK.add(0, muteUser);
            if (this.fCI < 0) {
                this.fCI = 0L;
            }
            this.fCI++;
            this.fCJ = true;
            this.fCF = i;
        }
    }

    public void aZm() {
        if (TbadkCoreApplication.isLogin()) {
            this.fCI--;
            if (this.fCI < 0) {
                this.fCI = 0L;
            }
            this.fCJ = false;
            this.fCF = -1;
            if (!v.G(this.fCK)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    Iterator<MuteUser> it = this.fCK.iterator();
                    while (it.hasNext()) {
                        MuteUser next = it.next();
                        if (next != null && currentAccount.equals(next.getUserId())) {
                            this.fCK.remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void jz(boolean z) {
        this.fCL = z;
    }

    public boolean aZn() {
        return this.fCL;
    }
}
