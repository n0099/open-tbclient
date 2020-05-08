package com.baidu.tieba.pb.data;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes9.dex */
public class h {
    private boolean gje;
    private int jor;
    private int jos;
    private List<String> jot;
    private List<String> jou;
    private List<String> jov;
    private String jow;
    private boolean jox;
    private int joy;
    private int status;

    public static h b(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        h hVar = new h();
        hVar.jos = managerElection.begin_vote_time.intValue();
        hVar.gje = managerElection.can_vote.intValue() == 1;
        hVar.jor = managerElection.vote_num.intValue();
        hVar.jox = managerElection.is_show_distribute.intValue() == 1;
        hVar.joy = managerElection.remainder_time.intValue();
        hVar.status = managerElection.status.intValue();
        hVar.jow = managerElection.tail_text;
        hVar.jot = managerElection.vote_condition_pic;
        hVar.jou = managerElection.vote_condition_title;
        hVar.jov = managerElection.vote_condition;
        return hVar;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean cvV() {
        return this.jox;
    }

    public int cvW() {
        return this.joy;
    }

    public int cvX() {
        return this.jor;
    }

    public List<String> cvY() {
        return this.jou;
    }

    public List<String> cvZ() {
        return this.jov;
    }

    public String cwa() {
        return this.jow;
    }

    public boolean bDT() {
        return this.gje;
    }

    public void lm(boolean z) {
        this.gje = z;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void zk(int i) {
        this.jor = i;
    }
}
