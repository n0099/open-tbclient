package com.baidu.tieba.pb.data;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes21.dex */
public class k {
    private boolean hSg;
    private int lom;
    private int loo;
    private List<String> lop;
    private List<String> loq;
    private List<String> lor;
    private String los;
    private boolean lot;
    private int lou;
    private int status;

    public static k b(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        k kVar = new k();
        kVar.loo = managerElection.begin_vote_time.intValue();
        kVar.hSg = managerElection.can_vote.intValue() == 1;
        kVar.lom = managerElection.vote_num.intValue();
        kVar.lot = managerElection.is_show_distribute.intValue() == 1;
        kVar.lou = managerElection.remainder_time.intValue();
        kVar.status = managerElection.status.intValue();
        kVar.los = managerElection.tail_text;
        kVar.lop = managerElection.vote_condition_pic;
        kVar.loq = managerElection.vote_condition_title;
        kVar.lor = managerElection.vote_condition;
        return kVar;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean diq() {
        return this.lot;
    }

    public int dir() {
        return this.lou;
    }

    public int dis() {
        return this.lom;
    }

    public List<String> dit() {
        return this.loq;
    }

    public List<String> diu() {
        return this.lor;
    }

    public String div() {
        return this.los;
    }

    public boolean cmL() {
        return this.hSg;
    }

    public void op(boolean z) {
        this.hSg = z;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void Gb(int i) {
        this.lom = i;
    }
}
