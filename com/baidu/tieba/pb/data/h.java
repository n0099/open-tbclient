package com.baidu.tieba.pb.data;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes9.dex */
public class h {
    private boolean fDM;
    private int iCG;
    private int iCH;
    private int iCI;
    private List<String> iCJ;
    private String iCK;
    private boolean iCL;
    private int iCM;
    private int status;

    public static h a(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        h hVar = new h();
        hVar.iCH = managerElection.begin_vote_time.intValue();
        hVar.fDM = managerElection.can_vote.intValue() == 1;
        hVar.iCG = managerElection.vote_num.intValue();
        hVar.iCI = managerElection.election_id.intValue();
        hVar.iCL = managerElection.is_show_distribute.intValue() == 1;
        hVar.iCM = managerElection.remainder_time.intValue();
        hVar.status = managerElection.status.intValue();
        hVar.iCK = managerElection.tail_text;
        hVar.iCJ = managerElection.vote_condition;
        return hVar;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean ckY() {
        return this.iCL;
    }

    public int ckZ() {
        return this.iCM;
    }

    public int cla() {
        return this.iCG;
    }

    public List<String> clb() {
        return this.iCJ;
    }

    public String clc() {
        return this.iCK;
    }

    public boolean bug() {
        return this.fDM;
    }

    public void ke(boolean z) {
        this.fDM = z;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void yB(int i) {
        this.iCG = i;
    }
}
