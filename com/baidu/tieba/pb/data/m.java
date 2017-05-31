package com.baidu.tieba.pb.data;

import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
import tbclient.PbPage.DataRes;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class m implements v {
    public static final BdUniqueId eji = BdUniqueId.gen();
    private boolean ejj;
    private ArrayList<MuteUser> ejk;
    private long praiseNum;
    public int ejg = -1;
    private boolean ejd = false;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eji;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.thread != null && dataRes.thread.agree != null) {
                this.praiseNum = dataRes.thread.agree.agree_num.longValue();
                this.ejj = dataRes.thread.agree.has_agree.intValue() == 1;
                this.ejg = dataRes.thread.agree.agree_type.intValue();
            }
            if (this.ejk == null) {
                this.ejk = new ArrayList<>();
            }
            this.ejk.clear();
            if (dataRes.new_agree_user != null && dataRes.new_agree_user.size() > 0) {
                for (SimpleUser simpleUser : dataRes.new_agree_user) {
                    if (simpleUser != null) {
                        MuteUser muteUser = new MuteUser();
                        muteUser.parserProtobuf(simpleUser);
                        this.ejk.add(muteUser);
                    }
                }
            }
        }
    }

    public long getPraiseNum() {
        return this.praiseNum;
    }

    private String M(int i, String str) {
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
        int i2 = 1;
        int af = com.baidu.adp.lib.util.k.af(textView.getContext()) - 240;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int g = com.baidu.adp.lib.util.k.g(textView.getContext(), w.f.ds36);
        if (x.r(this.ejk)) {
            return sb.toString();
        }
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!this.ejj || TextUtils.isEmpty(currentAccountName)) {
            i = 0;
        } else {
            if (this.ejg != 4 && this.ejg != 1) {
                i2 = 0;
            }
            sb.append(M(this.ejg, currentAccountName)).append("、");
            sb2.append(currentAccountName).append("、");
            i = i2;
        }
        TextPaint paint = textView.getPaint();
        Iterator<MuteUser> it = this.ejk.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            MuteUser next = it.next();
            if (paint.measureText(sb2.toString()) + (g * i) > af) {
                sb.append(textView.getContext().getResources().getString(w.l.etc));
                break;
            } else if (next != null && !StringUtils.isNull(next.getUserName()) && !next.getUserName().equals(currentAccountName)) {
                sb.append(M(next.agreeType, next.getUserName())).append("、");
                sb2.append(next.getUserName()).append("、");
            }
        }
        String sb3 = sb.toString();
        if (!sb3.endsWith(textView.getContext().getResources().getString(w.l.etc))) {
            return sb3.substring(0, sb3.length() - 1);
        }
        return sb3;
    }

    public boolean aJe() {
        return this.ejj;
    }

    public ArrayList<MuteUser> aJf() {
        return this.ejk;
    }

    public void om(int i) {
        if (!this.ejj) {
            on(i);
            return;
        }
        this.ejg = i;
        this.ejj = true;
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (currentAccountName != null) {
            Iterator<MuteUser> it = this.ejk.iterator();
            while (it.hasNext()) {
                MuteUser next = it.next();
                if (currentAccountName.equals(next.getUserName())) {
                    next.agreeType = i;
                    return;
                }
            }
        }
    }

    public void on(int i) {
        if (TbadkCoreApplication.isLogin()) {
            MuteUser muteUser = new MuteUser();
            muteUser.setUserId(TbadkCoreApplication.getCurrentAccount());
            muteUser.setUserName(TbadkCoreApplication.getCurrentAccountName());
            muteUser.agreeType = i;
            if (this.ejk == null) {
                this.ejk = new ArrayList<>();
            }
            this.ejk.add(0, muteUser);
            if (this.praiseNum < 0) {
                this.praiseNum = 0L;
            }
            this.praiseNum++;
            this.ejj = true;
            this.ejg = i;
        }
    }

    public void aJg() {
        if (TbadkCoreApplication.isLogin()) {
            this.praiseNum--;
            if (this.praiseNum < 0) {
                this.praiseNum = 0L;
            }
            this.ejj = false;
            this.ejg = -1;
            if (!x.r(this.ejk)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    Iterator<MuteUser> it = this.ejk.iterator();
                    while (it.hasNext()) {
                        MuteUser next = it.next();
                        if (next != null && currentAccount.equals(next.getUserId())) {
                            this.ejk.remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void hY(boolean z) {
        this.ejd = z;
    }

    public boolean aJh() {
        return this.ejd;
    }
}
