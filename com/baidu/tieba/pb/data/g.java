package com.baidu.tieba.pb.data;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes4.dex */
public class g {
    private boolean ewo;
    private int hIV;
    private int hIW;
    private int hIX;
    private List<String> hIY;
    private String hIZ;
    private boolean hJa;
    private int hJb;
    private int status;

    public static g a(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        g gVar = new g();
        gVar.hIW = managerElection.begin_vote_time.intValue();
        gVar.ewo = managerElection.can_vote.intValue() == 1;
        gVar.hIV = managerElection.vote_num.intValue();
        gVar.hIX = managerElection.election_id.intValue();
        gVar.hJa = managerElection.is_show_distribute.intValue() == 1;
        gVar.hJb = managerElection.remainder_time.intValue();
        gVar.status = managerElection.status.intValue();
        gVar.hIZ = managerElection.tail_text;
        gVar.hIY = managerElection.vote_condition;
        return gVar;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean bTm() {
        return this.hJa;
    }

    public int bTn() {
        return this.hJb;
    }

    public int bTo() {
        return this.hIV;
    }

    public List<String> bTp() {
        return this.hIY;
    }

    public String bTq() {
        return this.hIZ;
    }

    public boolean aYO() {
        return this.ewo;
    }

    public void iu(boolean z) {
        this.ewo = z;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void xF(int i) {
        this.hIV = i;
    }
}
