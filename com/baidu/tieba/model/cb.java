package com.baidu.tieba.model;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.SendAloneVoteData;
import com.baidu.tieba.data.SendPKVoteData;
/* loaded from: classes.dex */
public class cb extends com.baidu.adp.a.d {

    /* renamed from: a  reason: collision with root package name */
    private cc f1932a;
    private ce b;
    private cd c;
    private cf d;
    private SendAloneVoteData e;
    private SendPKVoteData f;
    private int g;
    private String h;
    private String i;
    private String j;
    private int k;

    public SendAloneVoteData a() {
        return this.e;
    }

    public SendPKVoteData b() {
        return this.f;
    }

    public String c() {
        return this.i;
    }

    public int d() {
        return this.g;
    }

    public String e() {
        return this.j;
    }

    public int f() {
        return this.k;
    }

    public int a(int i) {
        int be = TiebaApplication.g().be();
        if (i <= 0) {
            return 0;
        }
        if (i <= be) {
            return 1;
        }
        int round = Math.round(i / be);
        if (round > TiebaApplication.g().bd()) {
            return TiebaApplication.g().bd();
        }
        return round;
    }

    public void a(cd cdVar) {
        this.c = cdVar;
    }

    public void a(cf cfVar) {
        this.d = cfVar;
    }

    public void a(Intent intent) {
        this.g = intent.getIntExtra("votetype", 0);
        this.h = intent.getStringExtra("pkId");
        this.i = intent.getStringExtra("playerId");
        this.j = intent.getStringExtra("playerName");
        this.k = intent.getIntExtra("shakeNumber", 0);
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        switch (this.g) {
            case 1:
                if (this.f1932a != null) {
                    this.f1932a.cancel();
                    return true;
                }
                return true;
            case 2:
                if (this.b != null) {
                    this.b.cancel();
                    return true;
                }
                return true;
            default:
                return true;
        }
    }

    public void g() {
        switch (this.g) {
            case 1:
                this.f1932a = new cc(this, this.i, this.k);
                this.f1932a.execute(new Void[0]);
                return;
            case 2:
                this.b = new ce(this, this.h, this.i, this.k);
                this.b.execute(new Void[0]);
                return;
            default:
                return;
        }
    }

    public void a(Bundle bundle) {
        this.g = bundle.getInt("votetype");
        this.h = bundle.getString("pkId");
        this.i = bundle.getString("playerId");
        this.j = bundle.getString("playerName");
        this.k = bundle.getInt("shakeNumber");
        this.e = (SendAloneVoteData) bundle.getSerializable("sendAloneVoteData");
        this.f = (SendPKVoteData) bundle.getSerializable("sendPKVoteData");
    }

    public void b(Bundle bundle) {
        bundle.putInt("votetype", this.g);
        bundle.putString("pkId", this.h);
        bundle.putString("playerId", this.i);
        bundle.putString("playerName", this.j);
        bundle.putInt("shakeNumber", this.k);
        bundle.putSerializable("sendAloneVoteData", this.e);
        bundle.putSerializable("sendPKVoteData", this.f);
    }
}
