package com.baidu.tieba.pb.data;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes7.dex */
public class i {
    private boolean fAZ;
    private int iAA;
    private int iAB;
    private List<String> iAC;
    private String iAD;
    private boolean iAE;
    private int iAF;
    private int iAz;
    private int status;

    public static i a(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        i iVar = new i();
        iVar.iAA = managerElection.begin_vote_time.intValue();
        iVar.fAZ = managerElection.can_vote.intValue() == 1;
        iVar.iAz = managerElection.vote_num.intValue();
        iVar.iAB = managerElection.election_id.intValue();
        iVar.iAE = managerElection.is_show_distribute.intValue() == 1;
        iVar.iAF = managerElection.remainder_time.intValue();
        iVar.status = managerElection.status.intValue();
        iVar.iAD = managerElection.tail_text;
        iVar.iAC = managerElection.vote_condition;
        return iVar;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean cjx() {
        return this.iAE;
    }

    public int cjy() {
        return this.iAF;
    }

    public int cjz() {
        return this.iAz;
    }

    public List<String> cjA() {
        return this.iAC;
    }

    public String cjB() {
        return this.iAD;
    }

    public boolean bsz() {
        return this.fAZ;
    }

    public void kc(boolean z) {
        this.fAZ = z;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void yu(int i) {
        this.iAz = i;
    }
}
