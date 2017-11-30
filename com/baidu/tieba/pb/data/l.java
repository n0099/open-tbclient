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
    public static final BdUniqueId eOZ = BdUniqueId.gen();
    public long cLy;
    private long ePa;
    private boolean ePb;
    private ArrayList<MuteUser> ePc;
    public int eOX = -1;
    private boolean ePd = false;
    private int ePe = 1;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return eOZ;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.thread != null && dataRes.thread.agree != null) {
                this.ePa = dataRes.thread.agree.agree_num.longValue();
                this.ePb = dataRes.thread.agree.has_agree.intValue() == 1;
                this.eOX = dataRes.thread.agree.agree_type.intValue();
            }
            if (this.ePc == null) {
                this.ePc = new ArrayList<>();
            }
            this.ePc.clear();
            if (dataRes.new_agree_user != null && dataRes.new_agree_user.size() > 0) {
                for (SimpleUser simpleUser : dataRes.new_agree_user) {
                    if (simpleUser != null) {
                        MuteUser muteUser = new MuteUser();
                        muteUser.parserProtobuf(simpleUser);
                        this.ePc.add(muteUser);
                    }
                }
            }
            if (dataRes.thread != null) {
                this.cLy = dataRes.thread.share_num.longValue();
            }
        }
    }

    public long aRM() {
        return this.ePa;
    }

    public boolean aRN() {
        return this.ePb;
    }

    public ArrayList<MuteUser> aRO() {
        return this.ePc;
    }

    public void pD(int i) {
        if (!this.ePb) {
            pF(i);
            return;
        }
        this.eOX = i;
        this.ePb = true;
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (currentAccountName != null) {
            Iterator<MuteUser> it = this.ePc.iterator();
            while (it.hasNext()) {
                MuteUser next = it.next();
                if (currentAccountName.equals(next.getUserName())) {
                    next.agreeType = i;
                    return;
                }
            }
        }
    }

    public void pE(int i) {
        this.ePe = i;
    }

    public int aRP() {
        return this.ePe;
    }

    public void pF(int i) {
        if (TbadkCoreApplication.isLogin()) {
            MuteUser muteUser = new MuteUser();
            muteUser.setUserId(TbadkCoreApplication.getCurrentAccount());
            muteUser.setUserName(TbadkCoreApplication.getCurrentAccountName());
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                muteUser.setNickName(TbadkCoreApplication.getCurrentAccountObj().getAccountNameShow());
            }
            muteUser.agreeType = i;
            if (this.ePc == null) {
                this.ePc = new ArrayList<>();
            }
            this.ePc.add(0, muteUser);
            if (this.ePa < 0) {
                this.ePa = 0L;
            }
            this.ePa++;
            this.ePb = true;
            this.eOX = i;
        }
    }

    public void aRQ() {
        if (TbadkCoreApplication.isLogin()) {
            this.ePa--;
            if (this.ePa < 0) {
                this.ePa = 0L;
            }
            this.ePb = false;
            this.eOX = -1;
            if (!v.w(this.ePc)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    Iterator<MuteUser> it = this.ePc.iterator();
                    while (it.hasNext()) {
                        MuteUser next = it.next();
                        if (next != null && currentAccount.equals(next.getUserId())) {
                            this.ePc.remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void iW(boolean z) {
        this.ePd = z;
    }

    public boolean aRR() {
        return this.ePd;
    }
}
