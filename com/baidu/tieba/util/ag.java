package com.baidu.tieba.util;
/* loaded from: classes.dex */
public class ag {
    private com.baidu.tieba.im.model.am c;
    private aj d;
    private double a = 0.0d;
    private double b = 0.0d;
    private com.baidu.adp.lib.c.d e = new ah(this);
    private com.baidu.tieba.im.messageCenter.g f = new ai(this);

    public ag(aj ajVar) {
        this.c = null;
        this.d = null;
        this.c = new com.baidu.tieba.im.model.am();
        this.d = ajVar;
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
