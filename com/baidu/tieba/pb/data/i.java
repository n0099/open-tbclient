package com.baidu.tieba.pb.data;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes9.dex */
public class i {
    private boolean gKR;
    private int jZL;
    private int jZM;
    private List<String> jZN;
    private List<String> jZO;
    private List<String> jZP;
    private String jZQ;
    private boolean jZR;
    private int jZS;
    private int status;

    public static i b(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        i iVar = new i();
        iVar.jZM = managerElection.begin_vote_time.intValue();
        iVar.gKR = managerElection.can_vote.intValue() == 1;
        iVar.jZL = managerElection.vote_num.intValue();
        iVar.jZR = managerElection.is_show_distribute.intValue() == 1;
        iVar.jZS = managerElection.remainder_time.intValue();
        iVar.status = managerElection.status.intValue();
        iVar.jZQ = managerElection.tail_text;
        iVar.jZN = managerElection.vote_condition_pic;
        iVar.jZO = managerElection.vote_condition_title;
        iVar.jZP = managerElection.vote_condition;
        return iVar;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean cHw() {
        return this.jZR;
    }

    public int cHx() {
        return this.jZS;
    }

    public int cHy() {
        return this.jZL;
    }

    public List<String> cHz() {
        return this.jZO;
    }

    public List<String> cHA() {
        return this.jZP;
    }

    public String cHB() {
        return this.jZQ;
    }

    public boolean bNt() {
        return this.gKR;
    }

    public void lR(boolean z) {
        this.gKR = z;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void AY(int i) {
        this.jZL = i;
    }
}
