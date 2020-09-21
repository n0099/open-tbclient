package com.baidu.tieba.pb.data;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes21.dex */
public class k {
    private boolean hks;
    private int kGn;
    private int kGo;
    private List<String> kGp;
    private List<String> kGq;
    private List<String> kGr;
    private String kGs;
    private boolean kGt;
    private int kGu;
    private int status;

    public static k b(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        k kVar = new k();
        kVar.kGo = managerElection.begin_vote_time.intValue();
        kVar.hks = managerElection.can_vote.intValue() == 1;
        kVar.kGn = managerElection.vote_num.intValue();
        kVar.kGt = managerElection.is_show_distribute.intValue() == 1;
        kVar.kGu = managerElection.remainder_time.intValue();
        kVar.status = managerElection.status.intValue();
        kVar.kGs = managerElection.tail_text;
        kVar.kGp = managerElection.vote_condition_pic;
        kVar.kGq = managerElection.vote_condition_title;
        kVar.kGr = managerElection.vote_condition;
        return kVar;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean cZA() {
        return this.kGt;
    }

    public int cZB() {
        return this.kGu;
    }

    public int cZC() {
        return this.kGn;
    }

    public List<String> cZD() {
        return this.kGq;
    }

    public List<String> cZE() {
        return this.kGr;
    }

    public String cZF() {
        return this.kGs;
    }

    public boolean cee() {
        return this.hks;
    }

    public void nh(boolean z) {
        this.hks = z;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void Er(int i) {
        this.kGn = i;
    }
}
