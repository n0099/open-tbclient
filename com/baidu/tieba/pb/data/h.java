package com.baidu.tieba.pb.data;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes9.dex */
public class h {
    private boolean fDz;
    private int iCA;
    private int iCu;
    private int iCv;
    private int iCw;
    private List<String> iCx;
    private String iCy;
    private boolean iCz;
    private int status;

    public static h a(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        h hVar = new h();
        hVar.iCv = managerElection.begin_vote_time.intValue();
        hVar.fDz = managerElection.can_vote.intValue() == 1;
        hVar.iCu = managerElection.vote_num.intValue();
        hVar.iCw = managerElection.election_id.intValue();
        hVar.iCz = managerElection.is_show_distribute.intValue() == 1;
        hVar.iCA = managerElection.remainder_time.intValue();
        hVar.status = managerElection.status.intValue();
        hVar.iCy = managerElection.tail_text;
        hVar.iCx = managerElection.vote_condition;
        return hVar;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean ckX() {
        return this.iCz;
    }

    public int ckY() {
        return this.iCA;
    }

    public int ckZ() {
        return this.iCu;
    }

    public List<String> cla() {
        return this.iCx;
    }

    public String clb() {
        return this.iCy;
    }

    public boolean buf() {
        return this.fDz;
    }

    public void ke(boolean z) {
        this.fDz = z;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void yB(int i) {
        this.iCu = i;
    }
}
