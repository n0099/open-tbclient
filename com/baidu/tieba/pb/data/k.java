package com.baidu.tieba.pb.data;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes2.dex */
public class k {
    private boolean ipA;
    private int lGS;
    private int lGT;
    private List<String> lGU;
    private List<String> lGV;
    private List<String> lGW;
    private String lGX;
    private boolean lGY;
    private int lGZ;
    private int status;

    public static k b(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        k kVar = new k();
        kVar.lGT = managerElection.begin_vote_time.intValue();
        kVar.ipA = managerElection.can_vote.intValue() == 1;
        kVar.lGS = managerElection.vote_num.intValue();
        kVar.lGY = managerElection.is_show_distribute.intValue() == 1;
        kVar.lGZ = managerElection.remainder_time.intValue();
        kVar.status = managerElection.status.intValue();
        kVar.lGX = managerElection.tail_text;
        kVar.lGU = managerElection.vote_condition_pic;
        kVar.lGV = managerElection.vote_condition_title;
        kVar.lGW = managerElection.vote_condition;
        return kVar;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean dnp() {
        return this.lGY;
    }

    public int dnq() {
        return this.lGZ;
    }

    public int dnr() {
        return this.lGS;
    }

    public List<String> dnt() {
        return this.lGV;
    }

    public List<String> dnu() {
        return this.lGW;
    }

    public String dnv() {
        return this.lGX;
    }

    public boolean ctS() {
        return this.ipA;
    }

    public void pk(boolean z) {
        this.ipA = z;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void GI(int i) {
        this.lGS = i;
    }
}
