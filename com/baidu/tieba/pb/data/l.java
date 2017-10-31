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
    public static final BdUniqueId eGV = BdUniqueId.gen();
    private long eGW;
    private boolean eGX;
    private ArrayList<MuteUser> eGY;
    public int eGT = -1;
    private boolean eGZ = false;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return eGV;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.thread != null && dataRes.thread.agree != null) {
                this.eGW = dataRes.thread.agree.agree_num.longValue();
                this.eGX = dataRes.thread.agree.has_agree.intValue() == 1;
                this.eGT = dataRes.thread.agree.agree_type.intValue();
            }
            if (this.eGY == null) {
                this.eGY = new ArrayList<>();
            }
            this.eGY.clear();
            if (dataRes.new_agree_user != null && dataRes.new_agree_user.size() > 0) {
                for (SimpleUser simpleUser : dataRes.new_agree_user) {
                    if (simpleUser != null) {
                        MuteUser muteUser = new MuteUser();
                        muteUser.parserProtobuf(simpleUser);
                        this.eGY.add(muteUser);
                    }
                }
            }
        }
    }

    public long aQs() {
        return this.eGW;
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
        if (v.v(this.eGY)) {
            return sb.toString();
        }
        String accountNameShow = TbadkCoreApplication.getCurrentAccountObj() != null ? TbadkCoreApplication.getCurrentAccountObj().getAccountNameShow() : "";
        if (!this.eGX || TextUtils.isEmpty(accountNameShow)) {
            i = 0;
        } else {
            int i2 = (this.eGT == 4 || this.eGT == 1) ? 1 : 0;
            sb.append(P(this.eGT, accountNameShow)).append("、");
            sb2.append(accountNameShow).append("、");
            i = i2;
        }
        TextPaint paint = textView.getPaint();
        Iterator<MuteUser> it = this.eGY.iterator();
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

    public boolean aQt() {
        return this.eGX;
    }

    public ArrayList<MuteUser> aQu() {
        return this.eGY;
    }

    public void pq(int i) {
        if (!this.eGX) {
            pr(i);
            return;
        }
        this.eGT = i;
        this.eGX = true;
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (currentAccountName != null) {
            Iterator<MuteUser> it = this.eGY.iterator();
            while (it.hasNext()) {
                MuteUser next = it.next();
                if (currentAccountName.equals(next.getUserName())) {
                    next.agreeType = i;
                    return;
                }
            }
        }
    }

    public void pr(int i) {
        if (TbadkCoreApplication.isLogin()) {
            MuteUser muteUser = new MuteUser();
            muteUser.setUserId(TbadkCoreApplication.getCurrentAccount());
            muteUser.setUserName(TbadkCoreApplication.getCurrentAccountName());
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                muteUser.setNickName(TbadkCoreApplication.getCurrentAccountObj().getAccountNameShow());
            }
            muteUser.agreeType = i;
            if (this.eGY == null) {
                this.eGY = new ArrayList<>();
            }
            this.eGY.add(0, muteUser);
            if (this.eGW < 0) {
                this.eGW = 0L;
            }
            this.eGW++;
            this.eGX = true;
            this.eGT = i;
        }
    }

    public void aQv() {
        if (TbadkCoreApplication.isLogin()) {
            this.eGW--;
            if (this.eGW < 0) {
                this.eGW = 0L;
            }
            this.eGX = false;
            this.eGT = -1;
            if (!v.v(this.eGY)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    Iterator<MuteUser> it = this.eGY.iterator();
                    while (it.hasNext()) {
                        MuteUser next = it.next();
                        if (next != null && currentAccount.equals(next.getUserId())) {
                            this.eGY.remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void ix(boolean z) {
        this.eGZ = z;
    }

    public boolean aQw() {
        return this.eGZ;
    }
}
