package com.baidu.tieba.pb.data;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes22.dex */
public class k {
    private boolean icZ;
    private int lBK;
    private int lBL;
    private List<String> lBM;
    private List<String> lBN;
    private List<String> lBO;
    private String lBP;
    private boolean lBQ;
    private int lBR;
    private int status;

    public static k b(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        k kVar = new k();
        kVar.lBL = managerElection.begin_vote_time.intValue();
        kVar.icZ = managerElection.can_vote.intValue() == 1;
        kVar.lBK = managerElection.vote_num.intValue();
        kVar.lBQ = managerElection.is_show_distribute.intValue() == 1;
        kVar.lBR = managerElection.remainder_time.intValue();
        kVar.status = managerElection.status.intValue();
        kVar.lBP = managerElection.tail_text;
        kVar.lBM = managerElection.vote_condition_pic;
        kVar.lBN = managerElection.vote_condition_title;
        kVar.lBO = managerElection.vote_condition;
        return kVar;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean dnF() {
        return this.lBQ;
    }

    public int dnG() {
        return this.lBR;
    }

    public int dnH() {
        return this.lBK;
    }

    public List<String> dnI() {
        return this.lBN;
    }

    public List<String> dnJ() {
        return this.lBO;
    }

    public String dnK() {
        return this.lBP;
    }

    public boolean cqY() {
        return this.icZ;
    }

    public void oL(boolean z) {
        this.icZ = z;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void GQ(int i) {
        this.lBK = i;
    }
}
