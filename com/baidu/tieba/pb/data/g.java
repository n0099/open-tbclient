package com.baidu.tieba.pb.data;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes4.dex */
public class g {
    private boolean eGH;
    private int hJA;
    private List<String> hJB;
    private String hJC;
    private boolean hJD;
    private int hJE;
    private int hJy;
    private int hJz;
    private int status;

    public static g a(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        g gVar = new g();
        gVar.hJz = managerElection.begin_vote_time.intValue();
        gVar.eGH = managerElection.can_vote.intValue() == 1;
        gVar.hJy = managerElection.vote_num.intValue();
        gVar.hJA = managerElection.election_id.intValue();
        gVar.hJD = managerElection.is_show_distribute.intValue() == 1;
        gVar.hJE = managerElection.remainder_time.intValue();
        gVar.status = managerElection.status.intValue();
        gVar.hJC = managerElection.tail_text;
        gVar.hJB = managerElection.vote_condition;
        return gVar;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean bRa() {
        return this.hJD;
    }

    public int bRb() {
        return this.hJE;
    }

    public int bRc() {
        return this.hJy;
    }

    public List<String> bRd() {
        return this.hJB;
    }

    public String bRe() {
        return this.hJC;
    }

    public boolean aZv() {
        return this.eGH;
    }

    public void iA(boolean z) {
        this.eGH = z;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void wo(int i) {
        this.hJy = i;
    }
}
