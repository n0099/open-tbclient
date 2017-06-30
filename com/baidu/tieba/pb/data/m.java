package com.baidu.tieba.pb.data;

import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
import tbclient.PbPage.DataRes;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class m implements v {
    public static final BdUniqueId esg = BdUniqueId.gen();
    private boolean esh;
    private ArrayList<MuteUser> esi;
    private long praiseNum;
    public int ese = -1;
    private boolean esa = false;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return esg;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.thread != null && dataRes.thread.agree != null) {
                this.praiseNum = dataRes.thread.agree.agree_num.longValue();
                this.esh = dataRes.thread.agree.has_agree.intValue() == 1;
                this.ese = dataRes.thread.agree.agree_type.intValue();
            }
            if (this.esi == null) {
                this.esi = new ArrayList<>();
            }
            this.esi.clear();
            if (dataRes.new_agree_user != null && dataRes.new_agree_user.size() > 0) {
                for (SimpleUser simpleUser : dataRes.new_agree_user) {
                    if (simpleUser != null) {
                        MuteUser muteUser = new MuteUser();
                        muteUser.parserProtobuf(simpleUser);
                        this.esi.add(muteUser);
                    }
                }
            }
        }
    }

    public long getPraiseNum() {
        return this.praiseNum;
    }

    private String P(int i, String str) {
        String str2 = "";
        if (i == 4) {
            str2 = "<img src='" + w.g.icon_floor_big_trample + "'>";
        } else if (i == 1) {
            str2 = "<img src='" + w.g.icon_floor_big_praised + "'>";
        }
        return String.valueOf(str2) + str;
    }

    public String g(TextView textView) {
        int i;
        int af = com.baidu.adp.lib.util.k.af(textView.getContext()) - 240;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int g = com.baidu.adp.lib.util.k.g(textView.getContext(), w.f.ds36);
        if (z.t(this.esi)) {
            return sb.toString();
        }
        String accountNameShow = TbadkCoreApplication.getCurrentAccountObj() != null ? TbadkCoreApplication.getCurrentAccountObj().getAccountNameShow() : "";
        if (!this.esh || TextUtils.isEmpty(accountNameShow)) {
            i = 0;
        } else {
            int i2 = (this.ese == 4 || this.ese == 1) ? 1 : 0;
            sb.append(P(this.ese, accountNameShow)).append("、");
            sb2.append(accountNameShow).append("、");
            i = i2;
        }
        TextPaint paint = textView.getPaint();
        Iterator<MuteUser> it = this.esi.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            MuteUser next = it.next();
            if (paint.measureText(sb2.toString()) + (g * i) > af) {
                sb.append(textView.getContext().getResources().getString(w.l.etc));
                break;
            }
            String userName = StringUtils.isNull(next.getNickName()) ? next.getUserName() : next.getNickName();
            if (next != null && !StringUtils.isNull(userName) && !userName.equals(accountNameShow)) {
                sb.append(P(next.agreeType, userName)).append("、");
                sb2.append(userName).append("、");
            }
        }
        String sb3 = sb.toString();
        if (!sb3.endsWith(textView.getContext().getResources().getString(w.l.etc))) {
            return sb3.substring(0, sb3.length() - 1);
        }
        return sb3;
    }

    public boolean aMY() {
        return this.esh;
    }

    public ArrayList<MuteUser> aMZ() {
        return this.esi;
    }

    public void oC(int i) {
        if (!this.esh) {
            oD(i);
            return;
        }
        this.ese = i;
        this.esh = true;
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (currentAccountName != null) {
            Iterator<MuteUser> it = this.esi.iterator();
            while (it.hasNext()) {
                MuteUser next = it.next();
                if (currentAccountName.equals(next.getUserName())) {
                    next.agreeType = i;
                    return;
                }
            }
        }
    }

    public void oD(int i) {
        if (TbadkCoreApplication.isLogin()) {
            MuteUser muteUser = new MuteUser();
            muteUser.setUserId(TbadkCoreApplication.getCurrentAccount());
            muteUser.setUserName(TbadkCoreApplication.getCurrentAccountName());
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                muteUser.setNickName(TbadkCoreApplication.getCurrentAccountObj().getAccountNameShow());
            }
            muteUser.agreeType = i;
            if (this.esi == null) {
                this.esi = new ArrayList<>();
            }
            this.esi.add(0, muteUser);
            if (this.praiseNum < 0) {
                this.praiseNum = 0L;
            }
            this.praiseNum++;
            this.esh = true;
            this.ese = i;
        }
    }

    public void aNa() {
        if (TbadkCoreApplication.isLogin()) {
            this.praiseNum--;
            if (this.praiseNum < 0) {
                this.praiseNum = 0L;
            }
            this.esh = false;
            this.ese = -1;
            if (!z.t(this.esi)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    Iterator<MuteUser> it = this.esi.iterator();
                    while (it.hasNext()) {
                        MuteUser next = it.next();
                        if (next != null && currentAccount.equals(next.getUserId())) {
                            this.esi.remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void iu(boolean z) {
        this.esa = z;
    }

    public boolean aNb() {
        return this.esa;
    }
}
