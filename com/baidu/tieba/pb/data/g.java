package com.baidu.tieba.pb.data;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes4.dex */
public class g {
    private boolean eri;
    private int hBL;
    private int hBM;
    private int hBN;
    private List<String> hBO;
    private String hBP;
    private boolean hBQ;
    private int hBR;
    private int status;

    public static g a(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        g gVar = new g();
        gVar.hBM = managerElection.begin_vote_time.intValue();
        gVar.eri = managerElection.can_vote.intValue() == 1;
        gVar.hBL = managerElection.vote_num.intValue();
        gVar.hBN = managerElection.election_id.intValue();
        gVar.hBQ = managerElection.is_show_distribute.intValue() == 1;
        gVar.hBR = managerElection.remainder_time.intValue();
        gVar.status = managerElection.status.intValue();
        gVar.hBP = managerElection.tail_text;
        gVar.hBO = managerElection.vote_condition;
        return gVar;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean bQj() {
        return this.hBQ;
    }

    public int bQk() {
        return this.hBR;
    }

    public int bQl() {
        return this.hBL;
    }

    public List<String> bQm() {
        return this.hBO;
    }

    public String bQn() {
        return this.hBP;
    }

    public boolean aWN() {
        return this.eri;
    }

    public void il(boolean z) {
        this.eri = z;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void wZ(int i) {
        this.hBL = i;
    }
}
