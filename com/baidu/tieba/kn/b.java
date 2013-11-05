package com.baidu.tieba.kn;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    int f1734a;
    int b;
    int c;
    int d;
    private c e;

    public b(long j) {
        this.f1734a = (int) (j / 86400);
        this.b = (int) ((j % 86400) / 3600);
        this.c = (int) ((j % 3600) / 60);
        this.d = (int) (j % 60);
    }

    public void a(c cVar) {
        this.e = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        if (this.d == 0 && this.c == 0 && this.b == 0 && this.f1734a == 0) {
            if (this.e != null) {
                this.e.f_();
            }
            return false;
        }
        this.d--;
        if (this.d < 0) {
            this.d = 59;
            this.c--;
            if (this.c < 0) {
                this.c = 59;
                this.b--;
                if (this.b < 0) {
                    this.b = 11;
                    this.f1734a--;
                }
            }
        }
        return true;
    }

    public String toString() {
        if (this.f1734a == 0) {
            if (this.b == 0) {
                if (this.c == 0) {
                    return String.format("0分%d秒", Integer.valueOf(this.d));
                }
                return String.format("%d分%d秒", Integer.valueOf(this.c), Integer.valueOf(this.d));
            }
            return String.format("%d时%d分%d秒", Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d));
        }
        return String.format("%d天%d时%d分%d秒", Integer.valueOf(this.f1734a), Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d));
    }
}
