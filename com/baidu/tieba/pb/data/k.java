package com.baidu.tieba.pb.data;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes22.dex */
public class k {
    private boolean hLJ;
    private int lhX;
    private int lhY;
    private List<String> lhZ;
    private List<String> lia;
    private List<String> lib;
    private String lic;
    private boolean lid;
    private int lie;
    private int status;

    public static k b(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        k kVar = new k();
        kVar.lhY = managerElection.begin_vote_time.intValue();
        kVar.hLJ = managerElection.can_vote.intValue() == 1;
        kVar.lhX = managerElection.vote_num.intValue();
        kVar.lid = managerElection.is_show_distribute.intValue() == 1;
        kVar.lie = managerElection.remainder_time.intValue();
        kVar.status = managerElection.status.intValue();
        kVar.lic = managerElection.tail_text;
        kVar.lhZ = managerElection.vote_condition_pic;
        kVar.lia = managerElection.vote_condition_title;
        kVar.lib = managerElection.vote_condition;
        return kVar;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean dgr() {
        return this.lid;
    }

    public int dgs() {
        return this.lie;
    }

    public int dgt() {
        return this.lhX;
    }

    public List<String> dgu() {
        return this.lia;
    }

    public List<String> dgv() {
        return this.lib;
    }

    public String dgw() {
        return this.lic;
    }

    public boolean ckH() {
        return this.hLJ;
    }

    public void oe(boolean z) {
        this.hLJ = z;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void Fq(int i) {
        this.lhX = i;
    }
}
