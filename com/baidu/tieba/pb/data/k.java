package com.baidu.tieba.pb.data;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes16.dex */
public class k {
    private boolean gQx;
    private int kio;
    private int kip;
    private List<String> kiq;
    private List<String> kir;
    private List<String> kis;
    private String kit;
    private boolean kiu;
    private int kiv;
    private int status;

    public static k b(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        k kVar = new k();
        kVar.kip = managerElection.begin_vote_time.intValue();
        kVar.gQx = managerElection.can_vote.intValue() == 1;
        kVar.kio = managerElection.vote_num.intValue();
        kVar.kiu = managerElection.is_show_distribute.intValue() == 1;
        kVar.kiv = managerElection.remainder_time.intValue();
        kVar.status = managerElection.status.intValue();
        kVar.kit = managerElection.tail_text;
        kVar.kiq = managerElection.vote_condition_pic;
        kVar.kir = managerElection.vote_condition_title;
        kVar.kis = managerElection.vote_condition;
        return kVar;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean cLg() {
        return this.kiu;
    }

    public int cLh() {
        return this.kiv;
    }

    public int cLi() {
        return this.kio;
    }

    public List<String> cLj() {
        return this.kir;
    }

    public List<String> cLk() {
        return this.kis;
    }

    public String cLl() {
        return this.kit;
    }

    public boolean bQE() {
        return this.gQx;
    }

    public void mw(boolean z) {
        this.gQx = z;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void Bx(int i) {
        this.kio = i;
    }
}
