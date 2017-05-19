package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.usermute.MuteUser;
import java.util.ArrayList;
import java.util.Iterator;
import tbclient.PbPage.DataRes;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class k implements v {
    public static final BdUniqueId edG = BdUniqueId.gen();
    private boolean edH;
    private ArrayList<MuteUser> edI;
    private String edJ;
    private boolean edK = false;
    private long praiseNum;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return edG;
    }

    public void a(DataRes dataRes) {
        StringBuilder sb;
        int i;
        if (dataRes != null) {
            if (dataRes.thread != null && dataRes.thread.agree != null) {
                this.praiseNum = dataRes.thread.agree.agree_num.longValue();
                this.edH = dataRes.thread.agree.has_agree.intValue() == 1;
            }
            if (this.edI == null) {
                this.edI = new ArrayList<>();
            }
            this.edI.clear();
            this.edJ = null;
            if (dataRes.new_agree_user != null && dataRes.new_agree_user.size() > 0) {
                StringBuilder sb2 = new StringBuilder();
                int size = dataRes.new_agree_user.size() <= 5 ? dataRes.new_agree_user.size() : 5;
                String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
                if (!this.edH || StringUtils.isNull(currentAccountName)) {
                    sb = null;
                    i = size;
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(UtilHelper.getFixedBarText(currentAccountName, 5, true, false));
                    sb = sb3;
                    i = size - 1;
                }
                int i2 = 0;
                for (SimpleUser simpleUser : dataRes.new_agree_user) {
                    if (simpleUser != null) {
                        MuteUser muteUser = new MuteUser();
                        muteUser.parserProtobuf(simpleUser);
                        this.edI.add(muteUser);
                        if (i2 < i && muteUser.getUserName() != null && !muteUser.getUserName().equals(currentAccountName)) {
                            sb2.append(UtilHelper.getFixedBarText(muteUser.getUserName(), 5, true, false));
                            if (i2 != i - 1) {
                                sb2.append("、");
                            }
                            i2++;
                        }
                    }
                }
                if (sb == null) {
                    this.edJ = sb2.toString();
                    return;
                }
                if (sb2.length() > 0) {
                    sb.append("、");
                    sb.append((CharSequence) sb2);
                }
                this.edJ = sb.toString();
            }
        }
    }

    public long getPraiseNum() {
        return this.praiseNum;
    }

    public void aIj() {
        if (x.r(this.edI)) {
            this.edJ = null;
            return;
        }
        int q = x.q(this.edI);
        int i = q <= 5 ? q : 5;
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            if (this.edI.get(i2) != null && !StringUtils.isNull(this.edI.get(i2).getUserName())) {
                sb.append(UtilHelper.getFixedBarText(this.edI.get(i2).getUserName(), 5, true, false));
                if (i2 != i - 1) {
                    sb.append("、");
                }
            }
        }
        this.edJ = sb.toString();
    }

    public String aIk() {
        return this.edJ;
    }

    public boolean aIl() {
        return this.edH;
    }

    public ArrayList<MuteUser> aIm() {
        return this.edI;
    }

    public void aIn() {
        if (TbadkCoreApplication.isLogin()) {
            MuteUser muteUser = new MuteUser();
            muteUser.setUserId(TbadkCoreApplication.getCurrentAccount());
            muteUser.setUserName(TbadkCoreApplication.getCurrentAccountName());
            if (this.edI == null) {
                this.edI = new ArrayList<>();
            }
            this.edI.add(0, muteUser);
            if (this.praiseNum < 0) {
                this.praiseNum = 0L;
            }
            this.praiseNum++;
            this.edH = true;
            aIj();
        }
    }

    public void aIo() {
        if (TbadkCoreApplication.isLogin()) {
            this.praiseNum--;
            if (this.praiseNum < 0) {
                this.praiseNum = 0L;
            }
            this.edH = false;
            if (!x.r(this.edI)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    Iterator<MuteUser> it = this.edI.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MuteUser next = it.next();
                        if (next != null && currentAccount.equals(next.getUserId())) {
                            this.edI.remove(next);
                            break;
                        }
                    }
                    aIj();
                }
            }
        }
    }

    public void hK(boolean z) {
        this.edK = z;
    }

    public boolean aIp() {
        return this.edK;
    }
}
