package com.baidu.tieba.pb.data;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes4.dex */
public class g {
    private boolean eFQ;
    private int hIH;
    private int hII;
    private int hIJ;
    private List<String> hIK;
    private String hIL;
    private boolean hIM;
    private int hIN;
    private int status;

    public static g a(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        g gVar = new g();
        gVar.hII = managerElection.begin_vote_time.intValue();
        gVar.eFQ = managerElection.can_vote.intValue() == 1;
        gVar.hIH = managerElection.vote_num.intValue();
        gVar.hIJ = managerElection.election_id.intValue();
        gVar.hIM = managerElection.is_show_distribute.intValue() == 1;
        gVar.hIN = managerElection.remainder_time.intValue();
        gVar.status = managerElection.status.intValue();
        gVar.hIL = managerElection.tail_text;
        gVar.hIK = managerElection.vote_condition;
        return gVar;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean bQY() {
        return this.hIM;
    }

    public int bQZ() {
        return this.hIN;
    }

    public int bRa() {
        return this.hIH;
    }

    public List<String> bRb() {
        return this.hIK;
    }

    public String bRc() {
        return this.hIL;
    }

    public boolean aZt() {
        return this.eFQ;
    }

    public void iA(boolean z) {
        this.eFQ = z;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void wn(int i) {
        this.hIH = i;
    }
}
