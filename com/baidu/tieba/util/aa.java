package com.baidu.tieba.util;
/* loaded from: classes.dex */
public class aa {
    private com.baidu.tieba.im.model.z c;
    private ad d;

    /* renamed from: a  reason: collision with root package name */
    private double f2575a = 0.0d;
    private double b = 0.0d;
    private com.baidu.adp.lib.c.d e = new ab(this);
    private com.baidu.tieba.im.messageCenter.g f = new ac(this);

    public aa(ad adVar) {
        this.c = null;
        this.d = null;
        this.c = new com.baidu.tieba.im.model.z();
        this.d = adVar;
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
