package com.baidu.tieba.pb.data;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes16.dex */
public class k {
    private boolean hdn;
    private int kxI;
    private int kxJ;
    private List<String> kxK;
    private List<String> kxL;
    private List<String> kxM;
    private String kxN;
    private boolean kxO;
    private int kxP;
    private int status;

    public static k b(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        k kVar = new k();
        kVar.kxJ = managerElection.begin_vote_time.intValue();
        kVar.hdn = managerElection.can_vote.intValue() == 1;
        kVar.kxI = managerElection.vote_num.intValue();
        kVar.kxO = managerElection.is_show_distribute.intValue() == 1;
        kVar.kxP = managerElection.remainder_time.intValue();
        kVar.status = managerElection.status.intValue();
        kVar.kxN = managerElection.tail_text;
        kVar.kxK = managerElection.vote_condition_pic;
        kVar.kxL = managerElection.vote_condition_title;
        kVar.kxM = managerElection.vote_condition;
        return kVar;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean cVU() {
        return this.kxO;
    }

    public int cVV() {
        return this.kxP;
    }

    public int cVW() {
        return this.kxI;
    }

    public List<String> cVX() {
        return this.kxL;
    }

    public List<String> cVY() {
        return this.kxM;
    }

    public String cVZ() {
        return this.kxN;
    }

    public boolean caP() {
        return this.hdn;
    }

    public void mZ(boolean z) {
        this.hdn = z;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void DQ(int i) {
        this.kxI = i;
    }
}
