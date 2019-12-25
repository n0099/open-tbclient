package com.baidu.tieba.pb.data;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes6.dex */
public class i {
    private boolean fxO;
    private int iwV;
    private int iwW;
    private int iwX;
    private List<String> iwY;
    private String iwZ;
    private boolean ixa;
    private int ixb;
    private int status;

    public static i a(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        i iVar = new i();
        iVar.iwW = managerElection.begin_vote_time.intValue();
        iVar.fxO = managerElection.can_vote.intValue() == 1;
        iVar.iwV = managerElection.vote_num.intValue();
        iVar.iwX = managerElection.election_id.intValue();
        iVar.ixa = managerElection.is_show_distribute.intValue() == 1;
        iVar.ixb = managerElection.remainder_time.intValue();
        iVar.status = managerElection.status.intValue();
        iVar.iwZ = managerElection.tail_text;
        iVar.iwY = managerElection.vote_condition;
        return iVar;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean cip() {
        return this.ixa;
    }

    public int ciq() {
        return this.ixb;
    }

    public int cir() {
        return this.iwV;
    }

    public List<String> cis() {
        return this.iwY;
    }

    public String cit() {
        return this.iwZ;
    }

    public boolean brx() {
        return this.fxO;
    }

    public void jR(boolean z) {
        this.fxO = z;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void yp(int i) {
        this.iwV = i;
    }
}
