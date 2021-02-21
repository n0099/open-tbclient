package com.baidu.tieba.pb.data;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes2.dex */
public class l {
    private boolean iqN;
    private int lLp;
    private int lLq;
    private List<String> lLr;
    private List<String> lLs;
    private List<String> lLt;
    private String lLu;
    private boolean lLv;
    private int lLw;
    private int status;

    public static l b(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        l lVar = new l();
        lVar.lLq = managerElection.begin_vote_time.intValue();
        lVar.iqN = managerElection.can_vote.intValue() == 1;
        lVar.lLp = managerElection.vote_num.intValue();
        lVar.lLv = managerElection.is_show_distribute.intValue() == 1;
        lVar.lLw = managerElection.remainder_time.intValue();
        lVar.status = managerElection.status.intValue();
        lVar.lLu = managerElection.tail_text;
        lVar.lLr = managerElection.vote_condition_pic;
        lVar.lLs = managerElection.vote_condition_title;
        lVar.lLt = managerElection.vote_condition;
        return lVar;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean dlR() {
        return this.lLv;
    }

    public int dlS() {
        return this.lLw;
    }

    public int dlT() {
        return this.lLp;
    }

    public List<String> dlU() {
        return this.lLs;
    }

    public List<String> dlV() {
        return this.lLt;
    }

    public String dlW() {
        return this.lLu;
    }

    public boolean crs() {
        return this.iqN;
    }

    public void pq(boolean z) {
        this.iqN = z;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void Fv(int i) {
        this.lLp = i;
    }
}
