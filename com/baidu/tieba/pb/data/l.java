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
    public static final BdUniqueId eFL = BdUniqueId.gen();
    private boolean eFM;
    private ArrayList<MuteUser> eFN;
    private long praiseNum;
    public int eFJ = -1;
    private boolean eFO = false;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return eFL;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.thread != null && dataRes.thread.agree != null) {
                this.praiseNum = dataRes.thread.agree.agree_num.longValue();
                this.eFM = dataRes.thread.agree.has_agree.intValue() == 1;
                this.eFJ = dataRes.thread.agree.agree_type.intValue();
            }
            if (this.eFN == null) {
                this.eFN = new ArrayList<>();
            }
            this.eFN.clear();
            if (dataRes.new_agree_user != null && dataRes.new_agree_user.size() > 0) {
                for (SimpleUser simpleUser : dataRes.new_agree_user) {
                    if (simpleUser != null) {
                        MuteUser muteUser = new MuteUser();
                        muteUser.parserProtobuf(simpleUser);
                        this.eFN.add(muteUser);
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
            str2 = "<img src='" + d.g.icon_floor_big_trample + "'>";
        } else if (i == 1) {
            str2 = "<img src='" + d.g.icon_floor_big_praised + "'>";
        }
        return str2 + str;
    }

    public String h(TextView textView) {
        int i;
        int ae = com.baidu.adp.lib.util.k.ae(textView.getContext()) - 240;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int f = com.baidu.adp.lib.util.k.f(textView.getContext(), d.f.ds36);
        if (v.v(this.eFN)) {
            return sb.toString();
        }
        String accountNameShow = TbadkCoreApplication.getCurrentAccountObj() != null ? TbadkCoreApplication.getCurrentAccountObj().getAccountNameShow() : "";
        if (!this.eFM || TextUtils.isEmpty(accountNameShow)) {
            i = 0;
        } else {
            int i2 = (this.eFJ == 4 || this.eFJ == 1) ? 1 : 0;
            sb.append(P(this.eFJ, accountNameShow)).append("、");
            sb2.append(accountNameShow).append("、");
            i = i2;
        }
        TextPaint paint = textView.getPaint();
        Iterator<MuteUser> it = this.eFN.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            MuteUser next = it.next();
            if (paint.measureText(sb2.toString()) + (f * i) > ae) {
                sb.append(textView.getContext().getResources().getString(d.l.etc));
                break;
            }
            String userName = StringUtils.isNull(next.getNickName()) ? next.getUserName() : next.getNickName();
            if (next != null && !StringUtils.isNull(userName) && !userName.equals(accountNameShow)) {
                sb.append(P(next.agreeType, userName)).append("、");
                sb2.append(userName).append("、");
            }
        }
        String sb3 = sb.toString();
        if (!sb3.endsWith(textView.getContext().getResources().getString(d.l.etc))) {
            return sb3.substring(0, sb3.length() - 1);
        }
        return sb3;
    }

    public boolean aPL() {
        return this.eFM;
    }

    public ArrayList<MuteUser> aPM() {
        return this.eFN;
    }

    public void pe(int i) {
        if (!this.eFM) {
            pf(i);
            return;
        }
        this.eFJ = i;
        this.eFM = true;
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (currentAccountName != null) {
            Iterator<MuteUser> it = this.eFN.iterator();
            while (it.hasNext()) {
                MuteUser next = it.next();
                if (currentAccountName.equals(next.getUserName())) {
                    next.agreeType = i;
                    return;
                }
            }
        }
    }

    public void pf(int i) {
        if (TbadkCoreApplication.isLogin()) {
            MuteUser muteUser = new MuteUser();
            muteUser.setUserId(TbadkCoreApplication.getCurrentAccount());
            muteUser.setUserName(TbadkCoreApplication.getCurrentAccountName());
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                muteUser.setNickName(TbadkCoreApplication.getCurrentAccountObj().getAccountNameShow());
            }
            muteUser.agreeType = i;
            if (this.eFN == null) {
                this.eFN = new ArrayList<>();
            }
            this.eFN.add(0, muteUser);
            if (this.praiseNum < 0) {
                this.praiseNum = 0L;
            }
            this.praiseNum++;
            this.eFM = true;
            this.eFJ = i;
        }
    }

    public void aPN() {
        if (TbadkCoreApplication.isLogin()) {
            this.praiseNum--;
            if (this.praiseNum < 0) {
                this.praiseNum = 0L;
            }
            this.eFM = false;
            this.eFJ = -1;
            if (!v.v(this.eFN)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    Iterator<MuteUser> it = this.eFN.iterator();
                    while (it.hasNext()) {
                        MuteUser next = it.next();
                        if (next != null && currentAccount.equals(next.getUserId())) {
                            this.eFN.remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void iS(boolean z) {
        this.eFO = z;
    }

    public boolean aPO() {
        return this.eFO;
    }
}
