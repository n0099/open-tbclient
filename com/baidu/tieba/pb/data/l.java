package com.baidu.tieba.pb.data;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes2.dex */
public class l {
    private boolean iqz;
    private int lLa;
    private int lLb;
    private List<String> lLc;
    private List<String> lLd;
    private List<String> lLe;
    private String lLf;
    private boolean lLg;
    private int lLh;
    private int status;

    public static l b(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        l lVar = new l();
        lVar.lLb = managerElection.begin_vote_time.intValue();
        lVar.iqz = managerElection.can_vote.intValue() == 1;
        lVar.lLa = managerElection.vote_num.intValue();
        lVar.lLg = managerElection.is_show_distribute.intValue() == 1;
        lVar.lLh = managerElection.remainder_time.intValue();
        lVar.status = managerElection.status.intValue();
        lVar.lLf = managerElection.tail_text;
        lVar.lLc = managerElection.vote_condition_pic;
        lVar.lLd = managerElection.vote_condition_title;
        lVar.lLe = managerElection.vote_condition;
        return lVar;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean dlK() {
        return this.lLg;
    }

    public int dlL() {
        return this.lLh;
    }

    public int dlM() {
        return this.lLa;
    }

    public List<String> dlN() {
        return this.lLd;
    }

    public List<String> dlO() {
        return this.lLe;
    }

    public String dlP() {
        return this.lLf;
    }

    public boolean crl() {
        return this.iqz;
    }

    public void pq(boolean z) {
        this.iqz = z;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void Fv(int i) {
        this.lLa = i;
    }
}
