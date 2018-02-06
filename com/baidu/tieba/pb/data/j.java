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
public class j implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId fHZ = BdUniqueId.gen();
    private long fIa;
    private boolean fIb;
    private ArrayList<MuteUser> fIc;
    public long shareNum;
    public int fHX = -1;
    private boolean fId = false;
    private boolean fIe = false;
    private int fIf = 1;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return fHZ;
    }

    public void a(DataRes dataRes) {
        boolean z = true;
        if (dataRes != null) {
            if (dataRes.thread != null && dataRes.thread.agree != null) {
                this.fIa = dataRes.thread.agree.agree_num.longValue();
                this.fIb = dataRes.thread.agree.has_agree.intValue() == 1;
                this.fHX = dataRes.thread.agree.agree_type.intValue();
            }
            if (this.fIc == null) {
                this.fIc = new ArrayList<>();
            }
            this.fIc.clear();
            if (dataRes.new_agree_user != null && dataRes.new_agree_user.size() > 0) {
                for (SimpleUser simpleUser : dataRes.new_agree_user) {
                    if (simpleUser != null) {
                        MuteUser muteUser = new MuteUser();
                        muteUser.parserProtobuf(simpleUser);
                        this.fIc.add(muteUser);
                    }
                }
            }
            if (dataRes.thread != null) {
                this.shareNum = dataRes.thread.share_num.longValue();
                this.fIe = (dataRes.thread.origin_thread_info == null || dataRes.thread.origin_thread_info.is_deleted.intValue() != 1) ? false : false;
            }
        }
    }

    public long baV() {
        return this.fIa;
    }

    public boolean baW() {
        return this.fIe;
    }

    public boolean baX() {
        return this.fIb;
    }

    public ArrayList<MuteUser> baY() {
        return this.fIc;
    }

    public void sA(int i) {
        if (!this.fIb) {
            sC(i);
            return;
        }
        this.fHX = i;
        this.fIb = true;
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (currentAccountName != null) {
            Iterator<MuteUser> it = this.fIc.iterator();
            while (it.hasNext()) {
                MuteUser next = it.next();
                if (currentAccountName.equals(next.getUserName())) {
                    next.agreeType = i;
                    return;
                }
            }
        }
    }

    public void sB(int i) {
        this.fIf = i;
    }

    public int baZ() {
        return this.fIf;
    }

    public void sC(int i) {
        if (TbadkCoreApplication.isLogin()) {
            MuteUser muteUser = new MuteUser();
            muteUser.setUserId(TbadkCoreApplication.getCurrentAccount());
            muteUser.setUserName(TbadkCoreApplication.getCurrentAccountName());
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                muteUser.setNickName(TbadkCoreApplication.getCurrentAccountObj().getAccountNameShow());
            }
            muteUser.agreeType = i;
            if (this.fIc == null) {
                this.fIc = new ArrayList<>();
            }
            this.fIc.add(0, muteUser);
            if (this.fIa < 0) {
                this.fIa = 0L;
            }
            this.fIa++;
            this.fIb = true;
            this.fHX = i;
        }
    }

    public void bba() {
        if (TbadkCoreApplication.isLogin()) {
            this.fIa--;
            if (this.fIa < 0) {
                this.fIa = 0L;
            }
            this.fIb = false;
            this.fHX = -1;
            if (!v.E(this.fIc)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    Iterator<MuteUser> it = this.fIc.iterator();
                    while (it.hasNext()) {
                        MuteUser next = it.next();
                        if (next != null && currentAccount.equals(next.getUserId())) {
                            this.fIc.remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void jO(boolean z) {
        this.fId = z;
    }

    public boolean bbb() {
        return this.fId;
    }
}
