package com.baidu.tieba.pb.data;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes22.dex */
public class k {
    private boolean hzn;
    private List<String> kVA;
    private List<String> kVB;
    private List<String> kVC;
    private String kVD;
    private boolean kVE;
    private int kVF;
    private int kVy;
    private int kVz;
    private int status;

    public static k b(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        k kVar = new k();
        kVar.kVz = managerElection.begin_vote_time.intValue();
        kVar.hzn = managerElection.can_vote.intValue() == 1;
        kVar.kVy = managerElection.vote_num.intValue();
        kVar.kVE = managerElection.is_show_distribute.intValue() == 1;
        kVar.kVF = managerElection.remainder_time.intValue();
        kVar.status = managerElection.status.intValue();
        kVar.kVD = managerElection.tail_text;
        kVar.kVA = managerElection.vote_condition_pic;
        kVar.kVB = managerElection.vote_condition_title;
        kVar.kVC = managerElection.vote_condition;
        return kVar;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean ddj() {
        return this.kVE;
    }

    public int ddk() {
        return this.kVF;
    }

    public int ddl() {
        return this.kVy;
    }

    public List<String> ddm() {
        return this.kVB;
    }

    public List<String> ddn() {
        return this.kVC;
    }

    public String ddo() {
        return this.kVD;
    }

    public boolean chA() {
        return this.hzn;
    }

    public void nM(boolean z) {
        this.hzn = z;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void EX(int i) {
        this.kVy = i;
    }
}
