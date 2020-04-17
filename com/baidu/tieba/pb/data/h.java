package com.baidu.tieba.pb.data;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes9.dex */
public class h {
    private boolean giY;
    private int jon;
    private int joo;
    private List<String> jop;
    private List<String> joq;
    private List<String> jor;
    private String jos;
    private boolean jot;
    private int jou;
    private int status;

    public static h b(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        h hVar = new h();
        hVar.joo = managerElection.begin_vote_time.intValue();
        hVar.giY = managerElection.can_vote.intValue() == 1;
        hVar.jon = managerElection.vote_num.intValue();
        hVar.jot = managerElection.is_show_distribute.intValue() == 1;
        hVar.jou = managerElection.remainder_time.intValue();
        hVar.status = managerElection.status.intValue();
        hVar.jos = managerElection.tail_text;
        hVar.jop = managerElection.vote_condition_pic;
        hVar.joq = managerElection.vote_condition_title;
        hVar.jor = managerElection.vote_condition;
        return hVar;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean cvY() {
        return this.jot;
    }

    public int cvZ() {
        return this.jou;
    }

    public int cwa() {
        return this.jon;
    }

    public List<String> cwb() {
        return this.joq;
    }

    public List<String> cwc() {
        return this.jor;
    }

    public String cwd() {
        return this.jos;
    }

    public boolean bDV() {
        return this.giY;
    }

    public void lm(boolean z) {
        this.giY = z;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void zk(int i) {
        this.jon = i;
    }
}
