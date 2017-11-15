package com.baidu.tieba.pb.data;

import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.usermute.MuteUser;
import java.util.ArrayList;
import java.util.Iterator;
import tbclient.PbPage.DataRes;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class l implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId eHp = BdUniqueId.gen();
    private long eHq;
    private boolean eHr;
    private ArrayList<MuteUser> eHs;
    public int eHn = -1;
    private boolean eHt = false;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return eHp;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.thread != null && dataRes.thread.agree != null) {
                this.eHq = dataRes.thread.agree.agree_num.longValue();
                this.eHr = dataRes.thread.agree.has_agree.intValue() == 1;
                this.eHn = dataRes.thread.agree.agree_type.intValue();
            }
            if (this.eHs == null) {
                this.eHs = new ArrayList<>();
            }
            this.eHs.clear();
            if (dataRes.new_agree_user != null && dataRes.new_agree_user.size() > 0) {
                for (SimpleUser simpleUser : dataRes.new_agree_user) {
                    if (simpleUser != null) {
                        MuteUser muteUser = new MuteUser();
                        muteUser.parserProtobuf(simpleUser);
                        this.eHs.add(muteUser);
                    }
                }
            }
        }
    }

    public long aQA() {
        return this.eHq;
    }

    private String P(int i, String str) {
        String str2 = "";
        if (i == 4) {
            str2 = "<img src='" + d.f.icon_floor_big_trample + "'>";
        } else if (i == 1) {
            str2 = "<img src='" + d.f.icon_floor_big_praised + "'>";
        }
        return str2 + str;
    }

    public String h(TextView textView) {
        int i;
        int ac = com.baidu.adp.lib.util.l.ac(textView.getContext()) - 240;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int f = com.baidu.adp.lib.util.l.f(textView.getContext(), d.e.ds36);
        if (v.v(this.eHs)) {
            return sb.toString();
        }
        String accountNameShow = TbadkCoreApplication.getCurrentAccountObj() != null ? TbadkCoreApplication.getCurrentAccountObj().getAccountNameShow() : "";
        if (!this.eHr || TextUtils.isEmpty(accountNameShow)) {
            i = 0;
        } else {
            int i2 = (this.eHn == 4 || this.eHn == 1) ? 1 : 0;
            sb.append(P(this.eHn, accountNameShow)).append("、");
            sb2.append(accountNameShow).append("、");
            i = i2;
        }
        TextPaint paint = textView.getPaint();
        Iterator<MuteUser> it = this.eHs.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            MuteUser next = it.next();
            if (paint.measureText(sb2.toString()) + (f * i) > ac) {
                sb.append(textView.getContext().getResources().getString(d.j.etc));
                break;
            }
            String userName = StringUtils.isNull(next.getNickName()) ? next.getUserName() : next.getNickName();
            if (next != null && !StringUtils.isNull(userName) && !userName.equals(accountNameShow)) {
                sb.append(P(next.agreeType, userName)).append("、");
                sb2.append(userName).append("、");
            }
        }
        String sb3 = sb.toString();
        if (!sb3.endsWith(textView.getContext().getResources().getString(d.j.etc))) {
            return sb3.substring(0, sb3.length() - 1);
        }
        return sb3;
    }

    public boolean aQB() {
        return this.eHr;
    }

    public ArrayList<MuteUser> aQC() {
        return this.eHs;
    }

    public void pr(int i) {
        if (!this.eHr) {
            ps(i);
            return;
        }
        this.eHn = i;
        this.eHr = true;
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (currentAccountName != null) {
            Iterator<MuteUser> it = this.eHs.iterator();
            while (it.hasNext()) {
                MuteUser next = it.next();
                if (currentAccountName.equals(next.getUserName())) {
                    next.agreeType = i;
                    return;
                }
            }
        }
    }

    public void ps(int i) {
        if (TbadkCoreApplication.isLogin()) {
            MuteUser muteUser = new MuteUser();
            muteUser.setUserId(TbadkCoreApplication.getCurrentAccount());
            muteUser.setUserName(TbadkCoreApplication.getCurrentAccountName());
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                muteUser.setNickName(TbadkCoreApplication.getCurrentAccountObj().getAccountNameShow());
            }
            muteUser.agreeType = i;
            if (this.eHs == null) {
                this.eHs = new ArrayList<>();
            }
            this.eHs.add(0, muteUser);
            if (this.eHq < 0) {
                this.eHq = 0L;
            }
            this.eHq++;
            this.eHr = true;
            this.eHn = i;
        }
    }

    public void aQD() {
        if (TbadkCoreApplication.isLogin()) {
            this.eHq--;
            if (this.eHq < 0) {
                this.eHq = 0L;
            }
            this.eHr = false;
            this.eHn = -1;
            if (!v.v(this.eHs)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    Iterator<MuteUser> it = this.eHs.iterator();
                    while (it.hasNext()) {
                        MuteUser next = it.next();
                        if (next != null && currentAccount.equals(next.getUserId())) {
                            this.eHs.remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void iD(boolean z) {
        this.eHt = z;
    }

    public boolean aQE() {
        return this.eHt;
    }
}
