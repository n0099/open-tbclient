package com.baidu.tieba.util;
/* loaded from: classes.dex */
public class ai {
    private com.baidu.tieba.im.model.am c;
    private al d;
    private double a = 0.0d;
    private double b = 0.0d;
    private com.baidu.adp.lib.c.d e = new aj(this);
    private com.baidu.tieba.im.messageCenter.g f = new ak(this);

    public ai(al alVar) {
        this.c = null;
        this.d = null;
        this.c = new com.baidu.tieba.im.model.am();
        this.d = alVar;
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
