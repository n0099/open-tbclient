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
    public static final BdUniqueId eQh = BdUniqueId.gen();
    public long cLM;
    private long eQi;
    private boolean eQj;
    private ArrayList<MuteUser> eQk;
    public int eQf = -1;
    private boolean eQl = false;
    private int eQm = 1;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return eQh;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.thread != null && dataRes.thread.agree != null) {
                this.eQi = dataRes.thread.agree.agree_num.longValue();
                this.eQj = dataRes.thread.agree.has_agree.intValue() == 1;
                this.eQf = dataRes.thread.agree.agree_type.intValue();
            }
            if (this.eQk == null) {
                this.eQk = new ArrayList<>();
            }
            this.eQk.clear();
            if (dataRes.new_agree_user != null && dataRes.new_agree_user.size() > 0) {
                for (SimpleUser simpleUser : dataRes.new_agree_user) {
                    if (simpleUser != null) {
                        MuteUser muteUser = new MuteUser();
                        muteUser.parserProtobuf(simpleUser);
                        this.eQk.add(muteUser);
                    }
                }
            }
            if (dataRes.thread != null) {
                this.cLM = dataRes.thread.share_num.longValue();
            }
        }
    }

    public long aRV() {
        return this.eQi;
    }

    public boolean aRW() {
        return this.eQj;
    }

    public ArrayList<MuteUser> aRX() {
        return this.eQk;
    }

    public void pK(int i) {
        if (!this.eQj) {
            pM(i);
            return;
        }
        this.eQf = i;
        this.eQj = true;
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (currentAccountName != null) {
            Iterator<MuteUser> it = this.eQk.iterator();
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
        this.eQm = i;
    }

    public int aRY() {
        return this.eQm;
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
            if (this.eQk == null) {
                this.eQk = new ArrayList<>();
            }
            this.eQk.add(0, muteUser);
            if (this.eQi < 0) {
                this.eQi = 0L;
            }
            this.eQi++;
            this.eQj = true;
            this.eQf = i;
        }
    }

    public void aRZ() {
        if (TbadkCoreApplication.isLogin()) {
            this.eQi--;
            if (this.eQi < 0) {
                this.eQi = 0L;
            }
            this.eQj = false;
            this.eQf = -1;
            if (!v.w(this.eQk)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    Iterator<MuteUser> it = this.eQk.iterator();
                    while (it.hasNext()) {
                        MuteUser next = it.next();
                        if (next != null && currentAccount.equals(next.getUserId())) {
                            this.eQk.remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void iX(boolean z) {
        this.eQl = z;
    }

    public boolean aSa() {
        return this.eQl;
    }
}
