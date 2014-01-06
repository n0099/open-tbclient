package com.baidu.tieba.util;
/* loaded from: classes.dex */
public class ad {
    private com.baidu.tieba.im.model.ak c;
    private ag d;
    private double a = 0.0d;
    private double b = 0.0d;
    private com.baidu.adp.lib.c.d e = new ae(this);
    private com.baidu.tieba.im.messageCenter.g f = new af(this);

    public ad(ag agVar) {
        this.c = null;
        this.d = null;
        this.c = new com.baidu.tieba.im.model.ak();
        this.d = agVar;
        com.baidu.tieba.im.messageCenter.e.a().a(103010, this.f);
    }

    public void a() {
        com.baidu.adp.lib.c.a.a().a(true, this.e);
    }

    public void b() {
        this.c.b();
        com.baidu.tieba.im.messageCenter.e.a().a(this.f);
    }
}
