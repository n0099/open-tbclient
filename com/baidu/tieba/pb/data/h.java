package com.baidu.tieba.pb.data;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes9.dex */
public class h {
    private boolean fEu;
    private int iEh;
    private int iEi;
    private int iEj;
    private List<String> iEk;
    private String iEl;
    private boolean iEm;
    private int iEn;
    private int status;

    public static h a(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        h hVar = new h();
        hVar.iEi = managerElection.begin_vote_time.intValue();
        hVar.fEu = managerElection.can_vote.intValue() == 1;
        hVar.iEh = managerElection.vote_num.intValue();
        hVar.iEj = managerElection.election_id.intValue();
        hVar.iEm = managerElection.is_show_distribute.intValue() == 1;
        hVar.iEn = managerElection.remainder_time.intValue();
        hVar.status = managerElection.status.intValue();
        hVar.iEl = managerElection.tail_text;
        hVar.iEk = managerElection.vote_condition;
        return hVar;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean clt() {
        return this.iEm;
    }

    public int clu() {
        return this.iEn;
    }

    public int clv() {
        return this.iEh;
    }

    public List<String> clw() {
        return this.iEk;
    }

    public String clx() {
        return this.iEl;
    }

    public boolean bul() {
        return this.fEu;
    }

    public void kj(boolean z) {
        this.fEu = z;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void yJ(int i) {
        this.iEh = i;
    }
}
