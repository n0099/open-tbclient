package com.baidu.tieba.pb.data;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes2.dex */
public class k {
    private boolean ikR;
    private int lCm;
    private int lCn;
    private List<String> lCo;
    private List<String> lCp;
    private List<String> lCq;
    private String lCr;
    private boolean lCs;
    private int lCt;
    private int status;

    public static k b(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        k kVar = new k();
        kVar.lCn = managerElection.begin_vote_time.intValue();
        kVar.ikR = managerElection.can_vote.intValue() == 1;
        kVar.lCm = managerElection.vote_num.intValue();
        kVar.lCs = managerElection.is_show_distribute.intValue() == 1;
        kVar.lCt = managerElection.remainder_time.intValue();
        kVar.status = managerElection.status.intValue();
        kVar.lCr = managerElection.tail_text;
        kVar.lCo = managerElection.vote_condition_pic;
        kVar.lCp = managerElection.vote_condition_title;
        kVar.lCq = managerElection.vote_condition;
        return kVar;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean djy() {
        return this.lCs;
    }

    public int djz() {
        return this.lCt;
    }

    public int djA() {
        return this.lCm;
    }

    public List<String> djB() {
        return this.lCp;
    }

    public List<String> djC() {
        return this.lCq;
    }

    public String djD() {
        return this.lCr;
    }

    public boolean cqb() {
        return this.ikR;
    }

    public void pg(boolean z) {
        this.ikR = z;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void Fc(int i) {
        this.lCm = i;
    }
}
