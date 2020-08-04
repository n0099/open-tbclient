package com.baidu.tieba.pb.data;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes16.dex */
public class k {
    private boolean gQx;
    private int kiq;
    private int kir;
    private List<String> kis;
    private List<String> kit;
    private List<String> kiu;
    private String kiv;
    private boolean kiw;
    private int kix;
    private int status;

    public static k b(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        k kVar = new k();
        kVar.kir = managerElection.begin_vote_time.intValue();
        kVar.gQx = managerElection.can_vote.intValue() == 1;
        kVar.kiq = managerElection.vote_num.intValue();
        kVar.kiw = managerElection.is_show_distribute.intValue() == 1;
        kVar.kix = managerElection.remainder_time.intValue();
        kVar.status = managerElection.status.intValue();
        kVar.kiv = managerElection.tail_text;
        kVar.kis = managerElection.vote_condition_pic;
        kVar.kit = managerElection.vote_condition_title;
        kVar.kiu = managerElection.vote_condition;
        return kVar;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean cLg() {
        return this.kiw;
    }

    public int cLh() {
        return this.kix;
    }

    public int cLi() {
        return this.kiq;
    }

    public List<String> cLj() {
        return this.kit;
    }

    public List<String> cLk() {
        return this.kiu;
    }

    public String cLl() {
        return this.kiv;
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
        this.kiq = i;
    }
}
