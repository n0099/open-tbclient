package com.baidu.tieba.pb.data;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes2.dex */
public class k {
    private boolean ipA;
    private int lGR;
    private int lGS;
    private List<String> lGT;
    private List<String> lGU;
    private List<String> lGV;
    private String lGW;
    private boolean lGX;
    private int lGY;
    private int status;

    public static k b(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        k kVar = new k();
        kVar.lGS = managerElection.begin_vote_time.intValue();
        kVar.ipA = managerElection.can_vote.intValue() == 1;
        kVar.lGR = managerElection.vote_num.intValue();
        kVar.lGX = managerElection.is_show_distribute.intValue() == 1;
        kVar.lGY = managerElection.remainder_time.intValue();
        kVar.status = managerElection.status.intValue();
        kVar.lGW = managerElection.tail_text;
        kVar.lGT = managerElection.vote_condition_pic;
        kVar.lGU = managerElection.vote_condition_title;
        kVar.lGV = managerElection.vote_condition;
        return kVar;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean dnq() {
        return this.lGX;
    }

    public int dnr() {
        return this.lGY;
    }

    public int dnt() {
        return this.lGR;
    }

    public List<String> dnu() {
        return this.lGU;
    }

    public List<String> dnv() {
        return this.lGV;
    }

    public String dnw() {
        return this.lGW;
    }

    public boolean ctT() {
        return this.ipA;
    }

    public void pk(boolean z) {
        this.ipA = z;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void GI(int i) {
        this.lGR = i;
    }
}
