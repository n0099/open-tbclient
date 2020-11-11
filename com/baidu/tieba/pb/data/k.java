package com.baidu.tieba.pb.data;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes22.dex */
public class k {
    private boolean hRG;
    private int lnU;
    private int lnV;
    private List<String> lnW;
    private List<String> lnX;
    private List<String> lnY;
    private String lnZ;
    private boolean loa;
    private int lob;
    private int status;

    public static k b(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        k kVar = new k();
        kVar.lnV = managerElection.begin_vote_time.intValue();
        kVar.hRG = managerElection.can_vote.intValue() == 1;
        kVar.lnU = managerElection.vote_num.intValue();
        kVar.loa = managerElection.is_show_distribute.intValue() == 1;
        kVar.lob = managerElection.remainder_time.intValue();
        kVar.status = managerElection.status.intValue();
        kVar.lnZ = managerElection.tail_text;
        kVar.lnW = managerElection.vote_condition_pic;
        kVar.lnX = managerElection.vote_condition_title;
        kVar.lnY = managerElection.vote_condition;
        return kVar;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean diT() {
        return this.loa;
    }

    public int diU() {
        return this.lob;
    }

    public int diV() {
        return this.lnU;
    }

    public List<String> diW() {
        return this.lnX;
    }

    public List<String> diX() {
        return this.lnY;
    }

    public String diY() {
        return this.lnZ;
    }

    public boolean cnj() {
        return this.hRG;
    }

    public void on(boolean z) {
        this.hRG = z;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void FD(int i) {
        this.lnU = i;
    }
}
