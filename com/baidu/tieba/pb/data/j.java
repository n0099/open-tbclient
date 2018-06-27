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
    public static final BdUniqueId ftc = BdUniqueId.gen();
    private long ftd;
    private boolean fte;
    private ArrayList<MuteUser> ftf;
    public long shareNum;
    public int fta = -1;
    private boolean ftg = false;
    private boolean fth = false;
    private int fti = 1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return ftc;
    }

    public void b(DataRes dataRes) {
        boolean z = true;
        if (dataRes != null) {
            if (dataRes.thread != null && dataRes.thread.agree != null) {
                this.ftd = dataRes.thread.agree.agree_num.longValue();
                this.fte = dataRes.thread.agree.has_agree.intValue() == 1;
                this.fta = dataRes.thread.agree.agree_type.intValue();
            }
            if (this.ftf == null) {
                this.ftf = new ArrayList<>();
            }
            this.ftf.clear();
            if (dataRes.new_agree_user != null && dataRes.new_agree_user.size() > 0) {
                for (SimpleUser simpleUser : dataRes.new_agree_user) {
                    if (simpleUser != null) {
                        MuteUser muteUser = new MuteUser();
                        muteUser.parserProtobuf(simpleUser);
                        this.ftf.add(muteUser);
                    }
                }
            }
            if (dataRes.thread != null) {
                this.shareNum = dataRes.thread.share_num.longValue();
                this.fth = (dataRes.thread.origin_thread_info == null || dataRes.thread.origin_thread_info.is_deleted.intValue() != 1) ? false : false;
            }
        }
    }

    public long bby() {
        return this.ftd;
    }

    public boolean bbz() {
        return this.fth;
    }

    public boolean bbA() {
        return this.fte;
    }

    public ArrayList<MuteUser> bbB() {
        return this.ftf;
    }

    public void qn(int i) {
        if (!this.fte) {
            qp(i);
            return;
        }
        this.fta = i;
        this.fte = true;
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (currentAccountName != null) {
            Iterator<MuteUser> it = this.ftf.iterator();
            while (it.hasNext()) {
                MuteUser next = it.next();
                if (currentAccountName.equals(next.getUserName())) {
                    next.agreeType = i;
                    return;
                }
            }
        }
    }

    public void qo(int i) {
        this.fti = i;
    }

    public int bbC() {
        return this.fti;
    }

    public void qp(int i) {
        if (TbadkCoreApplication.isLogin()) {
            MuteUser muteUser = new MuteUser();
            muteUser.setUserId(TbadkCoreApplication.getCurrentAccount());
            muteUser.setUserName(TbadkCoreApplication.getCurrentAccountName());
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                muteUser.setNickName(TbadkCoreApplication.getCurrentAccountObj().getAccountNameShow());
            }
            muteUser.agreeType = i;
            if (this.ftf == null) {
                this.ftf = new ArrayList<>();
            }
            this.ftf.add(0, muteUser);
            if (this.ftd < 0) {
                this.ftd = 0L;
            }
            this.ftd++;
            this.fte = true;
            this.fta = i;
        }
    }

    public void bbD() {
        if (TbadkCoreApplication.isLogin()) {
            this.ftd--;
            if (this.ftd < 0) {
                this.ftd = 0L;
            }
            this.fte = false;
            this.fta = -1;
            if (!w.A(this.ftf)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    Iterator<MuteUser> it = this.ftf.iterator();
                    while (it.hasNext()) {
                        MuteUser next = it.next();
                        if (next != null && currentAccount.equals(next.getUserId())) {
                            this.ftf.remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void jF(boolean z) {
        this.ftg = z;
    }

    public boolean bbE() {
        return this.ftg;
    }
}
