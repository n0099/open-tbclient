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
/* loaded from: classes.dex */
public class l implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId eQc = BdUniqueId.gen();
    public long cLI;
    private long eQd;
    private boolean eQe;
    private ArrayList<MuteUser> eQf;
    public int eQa = -1;
    private boolean eQg = false;
    private int eQh = 1;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return eQc;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.thread != null && dataRes.thread.agree != null) {
                this.eQd = dataRes.thread.agree.agree_num.longValue();
                this.eQe = dataRes.thread.agree.has_agree.intValue() == 1;
                this.eQa = dataRes.thread.agree.agree_type.intValue();
            }
            if (this.eQf == null) {
                this.eQf = new ArrayList<>();
            }
            this.eQf.clear();
            if (dataRes.new_agree_user != null && dataRes.new_agree_user.size() > 0) {
                for (SimpleUser simpleUser : dataRes.new_agree_user) {
                    if (simpleUser != null) {
                        MuteUser muteUser = new MuteUser();
                        muteUser.parserProtobuf(simpleUser);
                        this.eQf.add(muteUser);
                    }
                }
            }
            if (dataRes.thread != null) {
                this.cLI = dataRes.thread.share_num.longValue();
            }
        }
    }

    public long aRV() {
        return this.eQd;
    }

    public boolean aRW() {
        return this.eQe;
    }

    public ArrayList<MuteUser> aRX() {
        return this.eQf;
    }

    public void pK(int i) {
        if (!this.eQe) {
            pM(i);
            return;
        }
        this.eQa = i;
        this.eQe = true;
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (currentAccountName != null) {
            Iterator<MuteUser> it = this.eQf.iterator();
            while (it.hasNext()) {
                MuteUser next = it.next();
                if (currentAccountName.equals(next.getUserName())) {
                    next.agreeType = i;
                    return;
                }
            }
        }
    }

    public void pL(int i) {
        this.eQh = i;
    }

    public int aRY() {
        return this.eQh;
    }

    public void pM(int i) {
        if (TbadkCoreApplication.isLogin()) {
            MuteUser muteUser = new MuteUser();
            muteUser.setUserId(TbadkCoreApplication.getCurrentAccount());
            muteUser.setUserName(TbadkCoreApplication.getCurrentAccountName());
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                muteUser.setNickName(TbadkCoreApplication.getCurrentAccountObj().getAccountNameShow());
            }
            muteUser.agreeType = i;
            if (this.eQf == null) {
                this.eQf = new ArrayList<>();
            }
            this.eQf.add(0, muteUser);
            if (this.eQd < 0) {
                this.eQd = 0L;
            }
            this.eQd++;
            this.eQe = true;
            this.eQa = i;
        }
    }

    public void aRZ() {
        if (TbadkCoreApplication.isLogin()) {
            this.eQd--;
            if (this.eQd < 0) {
                this.eQd = 0L;
            }
            this.eQe = false;
            this.eQa = -1;
            if (!v.w(this.eQf)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    Iterator<MuteUser> it = this.eQf.iterator();
                    while (it.hasNext()) {
                        MuteUser next = it.next();
                        if (next != null && currentAccount.equals(next.getUserId())) {
                            this.eQf.remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void iX(boolean z) {
        this.eQg = z;
    }

    public boolean aSa() {
        return this.eQg;
    }
}
