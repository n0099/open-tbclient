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
    public static final BdUniqueId fpi = BdUniqueId.gen();
    private long fpj;
    private boolean fpk;
    private ArrayList<MuteUser> fpl;
    public long shareNum;
    public int fpg = -1;
    private boolean fpm = false;
    private boolean fpn = false;
    private int fpo = 1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fpi;
    }

    public void a(DataRes dataRes) {
        boolean z = true;
        if (dataRes != null) {
            if (dataRes.thread != null && dataRes.thread.agree != null) {
                this.fpj = dataRes.thread.agree.agree_num.longValue();
                this.fpk = dataRes.thread.agree.has_agree.intValue() == 1;
                this.fpg = dataRes.thread.agree.agree_type.intValue();
            }
            if (this.fpl == null) {
                this.fpl = new ArrayList<>();
            }
            this.fpl.clear();
            if (dataRes.new_agree_user != null && dataRes.new_agree_user.size() > 0) {
                for (SimpleUser simpleUser : dataRes.new_agree_user) {
                    if (simpleUser != null) {
                        MuteUser muteUser = new MuteUser();
                        muteUser.parserProtobuf(simpleUser);
                        this.fpl.add(muteUser);
                    }
                }
            }
            if (dataRes.thread != null) {
                this.shareNum = dataRes.thread.share_num.longValue();
                this.fpn = (dataRes.thread.origin_thread_info == null || dataRes.thread.origin_thread_info.is_deleted.intValue() != 1) ? false : false;
            }
        }
    }

    public long baQ() {
        return this.fpj;
    }

    public boolean baR() {
        return this.fpn;
    }

    public boolean baS() {
        return this.fpk;
    }

    public ArrayList<MuteUser> baT() {
        return this.fpl;
    }

    public void qg(int i) {
        if (!this.fpk) {
            qi(i);
            return;
        }
        this.fpg = i;
        this.fpk = true;
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (currentAccountName != null) {
            Iterator<MuteUser> it = this.fpl.iterator();
            while (it.hasNext()) {
                MuteUser next = it.next();
                if (currentAccountName.equals(next.getUserName())) {
                    next.agreeType = i;
                    return;
                }
            }
        }
    }

    public void qh(int i) {
        this.fpo = i;
    }

    public int baU() {
        return this.fpo;
    }

    public void qi(int i) {
        if (TbadkCoreApplication.isLogin()) {
            MuteUser muteUser = new MuteUser();
            muteUser.setUserId(TbadkCoreApplication.getCurrentAccount());
            muteUser.setUserName(TbadkCoreApplication.getCurrentAccountName());
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                muteUser.setNickName(TbadkCoreApplication.getCurrentAccountObj().getAccountNameShow());
            }
            muteUser.agreeType = i;
            if (this.fpl == null) {
                this.fpl = new ArrayList<>();
            }
            this.fpl.add(0, muteUser);
            if (this.fpj < 0) {
                this.fpj = 0L;
            }
            this.fpj++;
            this.fpk = true;
            this.fpg = i;
        }
    }

    public void baV() {
        if (TbadkCoreApplication.isLogin()) {
            this.fpj--;
            if (this.fpj < 0) {
                this.fpj = 0L;
            }
            this.fpk = false;
            this.fpg = -1;
            if (!w.z(this.fpl)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    Iterator<MuteUser> it = this.fpl.iterator();
                    while (it.hasNext()) {
                        MuteUser next = it.next();
                        if (next != null && currentAccount.equals(next.getUserId())) {
                            this.fpl.remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void jw(boolean z) {
        this.fpm = z;
    }

    public boolean baW() {
        return this.fpm;
    }
}
