package com.baidu.tieba.pb.data;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes9.dex */
public class i {
    private boolean gxU;
    private int jEV;
    private int jEW;
    private List<String> jEX;
    private List<String> jEY;
    private List<String> jEZ;
    private String jFa;
    private boolean jFb;
    private int jFc;
    private int status;

    public static i b(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        i iVar = new i();
        iVar.jEW = managerElection.begin_vote_time.intValue();
        iVar.gxU = managerElection.can_vote.intValue() == 1;
        iVar.jEV = managerElection.vote_num.intValue();
        iVar.jFb = managerElection.is_show_distribute.intValue() == 1;
        iVar.jFc = managerElection.remainder_time.intValue();
        iVar.status = managerElection.status.intValue();
        iVar.jFa = managerElection.tail_text;
        iVar.jEX = managerElection.vote_condition_pic;
        iVar.jEY = managerElection.vote_condition_title;
        iVar.jEZ = managerElection.vote_condition;
        return iVar;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean cCP() {
        return this.jFb;
    }

    public int cCQ() {
        return this.jFc;
    }

    public int cCR() {
        return this.jEV;
    }

    public List<String> cCS() {
        return this.jEY;
    }

    public List<String> cCT() {
        return this.jEZ;
    }

    public String cCU() {
        return this.jFa;
    }

    public boolean bKl() {
        return this.gxU;
    }

    public void lI(boolean z) {
        this.gxU = z;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void zU(int i) {
        this.jEV = i;
    }
}
