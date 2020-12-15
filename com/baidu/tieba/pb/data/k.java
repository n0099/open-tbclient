package com.baidu.tieba.pb.data;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes22.dex */
public class k {
    private boolean idb;
    private int lBM;
    private int lBN;
    private List<String> lBO;
    private List<String> lBP;
    private List<String> lBQ;
    private String lBR;
    private boolean lBS;
    private int lBT;
    private int status;

    public static k b(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        k kVar = new k();
        kVar.lBN = managerElection.begin_vote_time.intValue();
        kVar.idb = managerElection.can_vote.intValue() == 1;
        kVar.lBM = managerElection.vote_num.intValue();
        kVar.lBS = managerElection.is_show_distribute.intValue() == 1;
        kVar.lBT = managerElection.remainder_time.intValue();
        kVar.status = managerElection.status.intValue();
        kVar.lBR = managerElection.tail_text;
        kVar.lBO = managerElection.vote_condition_pic;
        kVar.lBP = managerElection.vote_condition_title;
        kVar.lBQ = managerElection.vote_condition;
        return kVar;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean dnG() {
        return this.lBS;
    }

    public int dnH() {
        return this.lBT;
    }

    public int dnI() {
        return this.lBM;
    }

    public List<String> dnJ() {
        return this.lBP;
    }

    public List<String> dnK() {
        return this.lBQ;
    }

    public String dnL() {
        return this.lBR;
    }

    public boolean cqZ() {
        return this.idb;
    }

    public void oL(boolean z) {
        this.idb = z;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void GQ(int i) {
        this.lBM = i;
    }
}
