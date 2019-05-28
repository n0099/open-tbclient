package com.baidu.tieba.pb.data;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes4.dex */
public class g {
    private boolean erj;
    private int hBO;
    private int hBP;
    private int hBQ;
    private List<String> hBR;
    private String hBS;
    private boolean hBT;
    private int hBU;
    private int status;

    public static g a(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        g gVar = new g();
        gVar.hBP = managerElection.begin_vote_time.intValue();
        gVar.erj = managerElection.can_vote.intValue() == 1;
        gVar.hBO = managerElection.vote_num.intValue();
        gVar.hBQ = managerElection.election_id.intValue();
        gVar.hBT = managerElection.is_show_distribute.intValue() == 1;
        gVar.hBU = managerElection.remainder_time.intValue();
        gVar.status = managerElection.status.intValue();
        gVar.hBS = managerElection.tail_text;
        gVar.hBR = managerElection.vote_condition;
        return gVar;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean bQm() {
        return this.hBT;
    }

    public int bQn() {
        return this.hBU;
    }

    public int bQo() {
        return this.hBO;
    }

    public List<String> bQp() {
        return this.hBR;
    }

    public String bQq() {
        return this.hBS;
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
        this.hBO = i;
    }
}
