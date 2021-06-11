package com.baidu.tieba.pb.videopb;

import android.content.Intent;
import android.graphics.Rect;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.pb.pb.main.PbModel;
import d.a.m0.r.q.a2;
import d.a.n0.e2.h.e;
import d.a.n0.e2.o.k;
/* loaded from: classes5.dex */
public class VideoPbViewModel extends ViewModel {

    /* renamed from: b  reason: collision with root package name */
    public PbModel f19533b;

    /* renamed from: a  reason: collision with root package name */
    public k f19532a = new k();

    /* renamed from: c  reason: collision with root package name */
    public int f19534c = 0;

    public void a(PbModel pbModel) {
        this.f19533b = pbModel;
    }

    public MutableLiveData<Integer> b() {
        return this.f19532a.a();
    }

    public e c() {
        return this.f19532a.b();
    }

    public e d() {
        return this.f19532a.c();
    }

    public MutableLiveData<Boolean> e() {
        return this.f19532a.d();
    }

    public MutableLiveData<Boolean> f() {
        return this.f19532a.e();
    }

    public MutableLiveData<a2> g() {
        return this.f19532a.f();
    }

    public Rect h() {
        if (this.f19532a.g() == null || this.f19532a.g().isEmpty()) {
            return null;
        }
        return this.f19532a.g();
    }

    public MutableLiveData<a2> i() {
        return this.f19532a.h();
    }

    public MutableLiveData<a2> j() {
        return this.f19532a.i();
    }

    public void k(Intent intent) {
        this.f19532a.v((Rect) intent.getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA));
        this.f19532a.t(intent.getBooleanExtra("key_jump_to_comment_area", false));
    }

    public boolean l() {
        return this.f19532a.k();
    }

    public boolean m() {
        return this.f19532a.l();
    }

    public MutableLiveData<Boolean> n() {
        return this.f19532a.m();
    }

    public void o(boolean z) {
        if (this.f19532a.f().getValue() != null) {
            e Q = this.f19533b.Q(this.f19532a.f().getValue());
            if (Q != null) {
                this.f19532a.j().addLast(this.f19532a.b());
                this.f19532a.n(Q);
                this.f19532a.u(!ListUtils.isEmpty(Q.f()) ? Q.f().get(0) : null);
                this.f19532a.w(this.f19532a.j().getLast() != null ? this.f19532a.j().getLast().L() : null);
                this.f19533b.Q1(z ? 21 : 22);
                this.f19533b.l1(Q);
                this.f19532a.r(true);
            }
        }
    }

    public void p() {
        e pollLast = this.f19532a.j().pollLast();
        if (pollLast != null) {
            this.f19532a.n(pollLast);
            this.f19532a.u(!ListUtils.isEmpty(pollLast.f()) ? pollLast.f().get(0) : null);
            this.f19532a.w(this.f19532a.j().peekLast() != null ? this.f19532a.j().peekLast().L() : null);
            this.f19533b.l1(pollLast);
            this.f19532a.r(true);
        }
    }

    public void q(a2 a2Var) {
        e Q;
        if (a2Var == null || (Q = this.f19533b.Q(a2Var)) == null) {
            return;
        }
        this.f19532a.j().addLast(this.f19532a.b());
        this.f19532a.n(Q);
        this.f19532a.u(!ListUtils.isEmpty(Q.f()) ? Q.f().get(0) : null);
        this.f19532a.w(this.f19532a.j().getLast() != null ? this.f19532a.j().getLast().L() : null);
        this.f19533b.Q1(20);
        this.f19533b.l1(Q);
        this.f19532a.r(true);
    }

    public void r(e eVar, int i2) {
        if (i2 >= this.f19534c) {
            this.f19534c = i2;
            this.f19532a.o(eVar);
            if (eVar != null) {
                k kVar = this.f19532a;
                boolean z = true;
                if (eVar.s() != 1 && !eVar.a0()) {
                    z = false;
                }
                kVar.p(z);
            }
        }
    }

    public void s(e eVar, int i2) {
        if (i2 == 3) {
            this.f19532a.n(eVar);
        }
    }

    public void t(boolean z) {
        this.f19532a.q(z);
    }

    public void u(boolean z) {
        this.f19532a.r(z);
    }

    public void v(boolean z) {
        this.f19532a.s(z);
    }

    public void w(boolean z) {
        this.f19532a.t(z);
    }
}
