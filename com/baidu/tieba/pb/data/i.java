package com.baidu.tieba.pb.data;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes9.dex */
public class i {
    private boolean gyf;
    private int jGb;
    private int jGc;
    private List<String> jGd;
    private List<String> jGe;
    private List<String> jGf;
    private String jGg;
    private boolean jGh;
    private int jGi;
    private int status;

    public static i b(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        i iVar = new i();
        iVar.jGc = managerElection.begin_vote_time.intValue();
        iVar.gyf = managerElection.can_vote.intValue() == 1;
        iVar.jGb = managerElection.vote_num.intValue();
        iVar.jGh = managerElection.is_show_distribute.intValue() == 1;
        iVar.jGi = managerElection.remainder_time.intValue();
        iVar.status = managerElection.status.intValue();
        iVar.jGg = managerElection.tail_text;
        iVar.jGd = managerElection.vote_condition_pic;
        iVar.jGe = managerElection.vote_condition_title;
        iVar.jGf = managerElection.vote_condition;
        return iVar;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean cDf() {
        return this.jGh;
    }

    public int cDg() {
        return this.jGi;
    }

    public int cDh() {
        return this.jGb;
    }

    public List<String> cDi() {
        return this.jGe;
    }

    public List<String> cDj() {
        return this.jGf;
    }

    public String cDk() {
        return this.jGg;
    }

    public boolean bKn() {
        return this.gyf;
    }

    public void lI(boolean z) {
        this.gyf = z;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void zW(int i) {
        this.jGb = i;
    }
}
