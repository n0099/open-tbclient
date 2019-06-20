package com.baidu.tieba.pb.data;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes4.dex */
public class g {
    private boolean erj;
    private int hBP;
    private int hBQ;
    private int hBR;
    private List<String> hBS;
    private String hBT;
    private boolean hBU;
    private int hBV;
    private int status;

    public static g a(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        g gVar = new g();
        gVar.hBQ = managerElection.begin_vote_time.intValue();
        gVar.erj = managerElection.can_vote.intValue() == 1;
        gVar.hBP = managerElection.vote_num.intValue();
        gVar.hBR = managerElection.election_id.intValue();
        gVar.hBU = managerElection.is_show_distribute.intValue() == 1;
        gVar.hBV = managerElection.remainder_time.intValue();
        gVar.status = managerElection.status.intValue();
        gVar.hBT = managerElection.tail_text;
        gVar.hBS = managerElection.vote_condition;
        return gVar;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean bQn() {
        return this.hBU;
    }

    public int bQo() {
        return this.hBV;
    }

    public int bQp() {
        return this.hBP;
    }

    public List<String> bQq() {
        return this.hBS;
    }

    public String bQr() {
        return this.hBT;
    }

    public boolean aWQ() {
        return this.erj;
    }

    public void il(boolean z) {
        this.erj = z;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void wZ(int i) {
        this.hBP = i;
    }
}
