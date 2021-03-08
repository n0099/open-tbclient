package com.baidu.tieba.pb.data;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes2.dex */
public class l {
    private boolean isw;
    private int lNr;
    private int lNs;
    private List<String> lNt;
    private List<String> lNu;
    private List<String> lNv;
    private String lNw;
    private boolean lNx;
    private int lNy;
    private int status;

    public static l b(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        l lVar = new l();
        lVar.lNs = managerElection.begin_vote_time.intValue();
        lVar.isw = managerElection.can_vote.intValue() == 1;
        lVar.lNr = managerElection.vote_num.intValue();
        lVar.lNx = managerElection.is_show_distribute.intValue() == 1;
        lVar.lNy = managerElection.remainder_time.intValue();
        lVar.status = managerElection.status.intValue();
        lVar.lNw = managerElection.tail_text;
        lVar.lNt = managerElection.vote_condition_pic;
        lVar.lNu = managerElection.vote_condition_title;
        lVar.lNv = managerElection.vote_condition;
        return lVar;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean dma() {
        return this.lNx;
    }

    public int dmb() {
        return this.lNy;
    }

    public int dmc() {
        return this.lNr;
    }

    public List<String> dmd() {
        return this.lNu;
    }

    public List<String> dme() {
        return this.lNv;
    }

    public String dmf() {
        return this.lNw;
    }

    public boolean cry() {
        return this.isw;
    }

    public void pq(boolean z) {
        this.isw = z;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void Fy(int i) {
        this.lNr = i;
    }
}
