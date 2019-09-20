package com.baidu.tieba.pb.data;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes4.dex */
public class g {
    private boolean exY;
    private int hKS;
    private int hKT;
    private int hKU;
    private List<String> hKV;
    private String hKW;
    private boolean hKX;
    private int hKY;
    private int status;

    public static g a(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        g gVar = new g();
        gVar.hKT = managerElection.begin_vote_time.intValue();
        gVar.exY = managerElection.can_vote.intValue() == 1;
        gVar.hKS = managerElection.vote_num.intValue();
        gVar.hKU = managerElection.election_id.intValue();
        gVar.hKX = managerElection.is_show_distribute.intValue() == 1;
        gVar.hKY = managerElection.remainder_time.intValue();
        gVar.status = managerElection.status.intValue();
        gVar.hKW = managerElection.tail_text;
        gVar.hKV = managerElection.vote_condition;
        return gVar;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean bTZ() {
        return this.hKX;
    }

    public int bUa() {
        return this.hKY;
    }

    public int bUb() {
        return this.hKS;
    }

    public List<String> bUc() {
        return this.hKV;
    }

    public String bUd() {
        return this.hKW;
    }

    public boolean aZs() {
        return this.exY;
    }

    public void ix(boolean z) {
        this.exY = z;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void xI(int i) {
        this.hKS = i;
    }
}
