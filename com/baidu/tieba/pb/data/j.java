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
    public static final BdUniqueId fIe = BdUniqueId.gen();
    private long fIf;
    private boolean fIg;
    private ArrayList<MuteUser> fIh;
    public long shareNum;
    public int fIc = -1;
    private boolean fIi = false;
    private boolean fIj = false;
    private int fIk = 1;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return fIe;
    }

    public void a(DataRes dataRes) {
        boolean z = true;
        if (dataRes != null) {
            if (dataRes.thread != null && dataRes.thread.agree != null) {
                this.fIf = dataRes.thread.agree.agree_num.longValue();
                this.fIg = dataRes.thread.agree.has_agree.intValue() == 1;
                this.fIc = dataRes.thread.agree.agree_type.intValue();
            }
            if (this.fIh == null) {
                this.fIh = new ArrayList<>();
            }
            this.fIh.clear();
            if (dataRes.new_agree_user != null && dataRes.new_agree_user.size() > 0) {
                for (SimpleUser simpleUser : dataRes.new_agree_user) {
                    if (simpleUser != null) {
                        MuteUser muteUser = new MuteUser();
                        muteUser.parserProtobuf(simpleUser);
                        this.fIh.add(muteUser);
                    }
                }
            }
            if (dataRes.thread != null) {
                this.shareNum = dataRes.thread.share_num.longValue();
                this.fIj = (dataRes.thread.origin_thread_info == null || dataRes.thread.origin_thread_info.is_deleted.intValue() != 1) ? false : false;
            }
        }
    }

    public long baV() {
        return this.fIf;
    }

    public boolean baW() {
        return this.fIj;
    }

    public boolean baX() {
        return this.fIg;
    }

    public ArrayList<MuteUser> baY() {
        return this.fIh;
    }

    public void sB(int i) {
        if (!this.fIg) {
            sD(i);
            return;
        }
        this.fIc = i;
        this.fIg = true;
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (currentAccountName != null) {
            Iterator<MuteUser> it = this.fIh.iterator();
            while (it.hasNext()) {
                MuteUser next = it.next();
                if (currentAccountName.equals(next.getUserName())) {
                    next.agreeType = i;
                    return;
                }
            }
        }
    }

    public void sC(int i) {
        this.fIk = i;
    }

    public int baZ() {
        return this.fIk;
    }

    public void sD(int i) {
        if (TbadkCoreApplication.isLogin()) {
            MuteUser muteUser = new MuteUser();
            muteUser.setUserId(TbadkCoreApplication.getCurrentAccount());
            muteUser.setUserName(TbadkCoreApplication.getCurrentAccountName());
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                muteUser.setNickName(TbadkCoreApplication.getCurrentAccountObj().getAccountNameShow());
            }
            muteUser.agreeType = i;
            if (this.fIh == null) {
                this.fIh = new ArrayList<>();
            }
            this.fIh.add(0, muteUser);
            if (this.fIf < 0) {
                this.fIf = 0L;
            }
            this.fIf++;
            this.fIg = true;
            this.fIc = i;
        }
    }

    public void bba() {
        if (TbadkCoreApplication.isLogin()) {
            this.fIf--;
            if (this.fIf < 0) {
                this.fIf = 0L;
            }
            this.fIg = false;
            this.fIc = -1;
            if (!v.E(this.fIh)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    Iterator<MuteUser> it = this.fIh.iterator();
                    while (it.hasNext()) {
                        MuteUser next = it.next();
                        if (next != null && currentAccount.equals(next.getUserId())) {
                            this.fIh.remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void jT(boolean z) {
        this.fIi = z;
    }

    public boolean bbb() {
        return this.fIi;
    }
}
