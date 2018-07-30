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
    public static final BdUniqueId fto = BdUniqueId.gen();
    private long ftp;
    private boolean ftq;
    private ArrayList<MuteUser> ftr;
    public long shareNum;
    public int ftm = -1;
    private boolean fts = false;
    private boolean ftt = false;
    private int ftu = 1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fto;
    }

    public void b(DataRes dataRes) {
        boolean z = true;
        if (dataRes != null) {
            if (dataRes.thread != null && dataRes.thread.agree != null) {
                this.ftp = dataRes.thread.agree.agree_num.longValue();
                this.ftq = dataRes.thread.agree.has_agree.intValue() == 1;
                this.ftm = dataRes.thread.agree.agree_type.intValue();
            }
            if (this.ftr == null) {
                this.ftr = new ArrayList<>();
            }
            this.ftr.clear();
            if (dataRes.new_agree_user != null && dataRes.new_agree_user.size() > 0) {
                for (SimpleUser simpleUser : dataRes.new_agree_user) {
                    if (simpleUser != null) {
                        MuteUser muteUser = new MuteUser();
                        muteUser.parserProtobuf(simpleUser);
                        this.ftr.add(muteUser);
                    }
                }
            }
            if (dataRes.thread != null) {
                this.shareNum = dataRes.thread.share_num.longValue();
                this.ftt = (dataRes.thread.origin_thread_info == null || dataRes.thread.origin_thread_info.is_deleted.intValue() != 1) ? false : false;
            }
        }
    }

    public long aZR() {
        return this.ftp;
    }

    public boolean aZS() {
        return this.ftt;
    }

    public boolean aZT() {
        return this.ftq;
    }

    public ArrayList<MuteUser> aZU() {
        return this.ftr;
    }

    public void qk(int i) {
        if (!this.ftq) {
            qm(i);
            return;
        }
        this.ftm = i;
        this.ftq = true;
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (currentAccountName != null) {
            Iterator<MuteUser> it = this.ftr.iterator();
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
        this.ftu = i;
    }

    public int aZV() {
        return this.ftu;
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
            if (this.ftr == null) {
                this.ftr = new ArrayList<>();
            }
            this.ftr.add(0, muteUser);
            if (this.ftp < 0) {
                this.ftp = 0L;
            }
            this.ftp++;
            this.ftq = true;
            this.ftm = i;
        }
    }

    public void aZW() {
        if (TbadkCoreApplication.isLogin()) {
            this.ftp--;
            if (this.ftp < 0) {
                this.ftp = 0L;
            }
            this.ftq = false;
            this.ftm = -1;
            if (!w.z(this.ftr)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    Iterator<MuteUser> it = this.ftr.iterator();
                    while (it.hasNext()) {
                        MuteUser next = it.next();
                        if (next != null && currentAccount.equals(next.getUserId())) {
                            this.ftr.remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void jr(boolean z) {
        this.fts = z;
    }

    public boolean aZX() {
        return this.fts;
    }
}
