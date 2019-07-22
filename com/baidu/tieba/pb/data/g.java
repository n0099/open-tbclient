package com.baidu.tieba.pb.data;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes4.dex */
public class g {
    private boolean ewh;
    private int hIc;
    private int hId;
    private int hIe;
    private List<String> hIf;
    private String hIg;
    private boolean hIh;
    private int hIi;
    private int status;

    public static g a(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        g gVar = new g();
        gVar.hId = managerElection.begin_vote_time.intValue();
        gVar.ewh = managerElection.can_vote.intValue() == 1;
        gVar.hIc = managerElection.vote_num.intValue();
        gVar.hIe = managerElection.election_id.intValue();
        gVar.hIh = managerElection.is_show_distribute.intValue() == 1;
        gVar.hIi = managerElection.remainder_time.intValue();
        gVar.status = managerElection.status.intValue();
        gVar.hIg = managerElection.tail_text;
        gVar.hIf = managerElection.vote_condition;
        return gVar;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean bSY() {
        return this.hIh;
    }

    public int bSZ() {
        return this.hIi;
    }

    public int bTa() {
        return this.hIc;
    }

    public List<String> bTb() {
        return this.hIf;
    }

    public String bTc() {
        return this.hIg;
    }

    public boolean aYM() {
        return this.ewh;
    }

    public void iu(boolean z) {
        this.ewh = z;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void xD(int i) {
        this.hIc = i;
    }
}
