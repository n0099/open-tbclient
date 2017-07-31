package com.baidu.tieba.pb.data;

import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.u;
import com.baidu.tieba.d;
import com.baidu.tieba.usermute.MuteUser;
import java.util.ArrayList;
import java.util.Iterator;
import tbclient.PbPage.DataRes;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId eEC = BdUniqueId.gen();
    private boolean eED;
    private ArrayList<MuteUser> eEE;
    private long praiseNum;
    public int eEA = -1;
    private boolean eEw = false;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return eEC;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.thread != null && dataRes.thread.agree != null) {
                this.praiseNum = dataRes.thread.agree.agree_num.longValue();
                this.eED = dataRes.thread.agree.has_agree.intValue() == 1;
                this.eEA = dataRes.thread.agree.agree_type.intValue();
            }
            if (this.eEE == null) {
                this.eEE = new ArrayList<>();
            }
            this.eEE.clear();
            if (dataRes.new_agree_user != null && dataRes.new_agree_user.size() > 0) {
                for (SimpleUser simpleUser : dataRes.new_agree_user) {
                    if (simpleUser != null) {
                        MuteUser muteUser = new MuteUser();
                        muteUser.parserProtobuf(simpleUser);
                        this.eEE.add(muteUser);
                    }
                }
            }
        }
    }

    public long getPraiseNum() {
        return this.praiseNum;
    }

    private String R(int i, String str) {
        String str2 = "";
        if (i == 4) {
            str2 = "<img src='" + d.g.icon_floor_big_trample + "'>";
        } else if (i == 1) {
            str2 = "<img src='" + d.g.icon_floor_big_praised + "'>";
        }
        return str2 + str;
    }

    public String g(TextView textView) {
        int i;
        int ag = com.baidu.adp.lib.util.k.ag(textView.getContext()) - 240;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int g = com.baidu.adp.lib.util.k.g(textView.getContext(), d.f.ds36);
        if (u.v(this.eEE)) {
            return sb.toString();
        }
        String accountNameShow = TbadkCoreApplication.getCurrentAccountObj() != null ? TbadkCoreApplication.getCurrentAccountObj().getAccountNameShow() : "";
        if (!this.eED || TextUtils.isEmpty(accountNameShow)) {
            i = 0;
        } else {
            int i2 = (this.eEA == 4 || this.eEA == 1) ? 1 : 0;
            sb.append(R(this.eEA, accountNameShow)).append("、");
            sb2.append(accountNameShow).append("、");
            i = i2;
        }
        TextPaint paint = textView.getPaint();
        Iterator<MuteUser> it = this.eEE.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            MuteUser next = it.next();
            if (paint.measureText(sb2.toString()) + (g * i) > ag) {
                sb.append(textView.getContext().getResources().getString(d.l.etc));
                break;
            }
            String userName = StringUtils.isNull(next.getNickName()) ? next.getUserName() : next.getNickName();
            if (next != null && !StringUtils.isNull(userName) && !userName.equals(accountNameShow)) {
                sb.append(R(next.agreeType, userName)).append("、");
                sb2.append(userName).append("、");
            }
        }
        String sb3 = sb.toString();
        if (!sb3.endsWith(textView.getContext().getResources().getString(d.l.etc))) {
            return sb3.substring(0, sb3.length() - 1);
        }
        return sb3;
    }

    public boolean aPM() {
        return this.eED;
    }

    public ArrayList<MuteUser> aPN() {
        return this.eEE;
    }

    public void oL(int i) {
        if (!this.eED) {
            oM(i);
            return;
        }
        this.eEA = i;
        this.eED = true;
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (currentAccountName != null) {
            Iterator<MuteUser> it = this.eEE.iterator();
            while (it.hasNext()) {
                MuteUser next = it.next();
                if (currentAccountName.equals(next.getUserName())) {
                    next.agreeType = i;
                    return;
                }
            }
        }
    }

    public void oM(int i) {
        if (TbadkCoreApplication.isLogin()) {
            MuteUser muteUser = new MuteUser();
            muteUser.setUserId(TbadkCoreApplication.getCurrentAccount());
            muteUser.setUserName(TbadkCoreApplication.getCurrentAccountName());
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                muteUser.setNickName(TbadkCoreApplication.getCurrentAccountObj().getAccountNameShow());
            }
            muteUser.agreeType = i;
            if (this.eEE == null) {
                this.eEE = new ArrayList<>();
            }
            this.eEE.add(0, muteUser);
            if (this.praiseNum < 0) {
                this.praiseNum = 0L;
            }
            this.praiseNum++;
            this.eED = true;
            this.eEA = i;
        }
    }

    public void aPO() {
        if (TbadkCoreApplication.isLogin()) {
            this.praiseNum--;
            if (this.praiseNum < 0) {
                this.praiseNum = 0L;
            }
            this.eED = false;
            this.eEA = -1;
            if (!u.v(this.eEE)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    Iterator<MuteUser> it = this.eEE.iterator();
                    while (it.hasNext()) {
                        MuteUser next = it.next();
                        if (next != null && currentAccount.equals(next.getUserId())) {
                            this.eEE.remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void iO(boolean z) {
        this.eEw = z;
    }

    public boolean aPP() {
        return this.eEw;
    }
}
