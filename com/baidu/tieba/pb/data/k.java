package com.baidu.tieba.pb.data;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes16.dex */
public class k {
    private boolean hdr;
    private int kxP;
    private int kxQ;
    private List<String> kxR;
    private List<String> kxS;
    private List<String> kxT;
    private String kxU;
    private boolean kxV;
    private int kxW;
    private int status;

    public static k b(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        k kVar = new k();
        kVar.kxQ = managerElection.begin_vote_time.intValue();
        kVar.hdr = managerElection.can_vote.intValue() == 1;
        kVar.kxP = managerElection.vote_num.intValue();
        kVar.kxV = managerElection.is_show_distribute.intValue() == 1;
        kVar.kxW = managerElection.remainder_time.intValue();
        kVar.status = managerElection.status.intValue();
        kVar.kxU = managerElection.tail_text;
        kVar.kxR = managerElection.vote_condition_pic;
        kVar.kxS = managerElection.vote_condition_title;
        kVar.kxT = managerElection.vote_condition;
        return kVar;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean cVV() {
        return this.kxV;
    }

    public int cVW() {
        return this.kxW;
    }

    public int cVX() {
        return this.kxP;
    }

    public List<String> cVY() {
        return this.kxS;
    }

    public List<String> cVZ() {
        return this.kxT;
    }

    public String cWa() {
        return this.kxU;
    }

    public boolean caQ() {
        return this.hdr;
    }

    public void nb(boolean z) {
        this.hdr = z;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void DQ(int i) {
        this.kxP = i;
    }
}
