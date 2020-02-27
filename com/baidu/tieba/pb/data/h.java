package com.baidu.tieba.pb.data;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes9.dex */
public class h {
    private boolean fDx;
    private int iCs;
    private int iCt;
    private int iCu;
    private List<String> iCv;
    private String iCw;
    private boolean iCx;
    private int iCy;
    private int status;

    public static h a(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        h hVar = new h();
        hVar.iCt = managerElection.begin_vote_time.intValue();
        hVar.fDx = managerElection.can_vote.intValue() == 1;
        hVar.iCs = managerElection.vote_num.intValue();
        hVar.iCu = managerElection.election_id.intValue();
        hVar.iCx = managerElection.is_show_distribute.intValue() == 1;
        hVar.iCy = managerElection.remainder_time.intValue();
        hVar.status = managerElection.status.intValue();
        hVar.iCw = managerElection.tail_text;
        hVar.iCv = managerElection.vote_condition;
        return hVar;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean ckV() {
        return this.iCx;
    }

    public int ckW() {
        return this.iCy;
    }

    public int ckX() {
        return this.iCs;
    }

    public List<String> ckY() {
        return this.iCv;
    }

    public String ckZ() {
        return this.iCw;
    }

    public boolean bud() {
        return this.fDx;
    }

    public void ke(boolean z) {
        this.fDx = z;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void yB(int i) {
        this.iCs = i;
    }
}
