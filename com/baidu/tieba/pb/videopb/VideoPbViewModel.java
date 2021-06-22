package com.baidu.tieba.pb.videopb;

import android.content.Intent;
import android.graphics.Rect;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.pb.pb.main.PbModel;
import d.a.n0.r.q.a2;
import d.a.o0.e2.h.e;
import d.a.o0.e2.o.k;
/* loaded from: classes5.dex */
public class VideoPbViewModel extends ViewModel {

    /* renamed from: b  reason: collision with root package name */
    public PbModel f19615b;

    /* renamed from: a  reason: collision with root package name */
    public k f19614a = new k();

    /* renamed from: c  reason: collision with root package name */
    public int f19616c = 0;

    public void a(PbModel pbModel) {
        this.f19615b = pbModel;
    }

    public MutableLiveData<Integer> b() {
        return this.f19614a.a();
    }

    public e c() {
        return this.f19614a.b();
    }

    public e d() {
        return this.f19614a.c();
    }

    public MutableLiveData<Boolean> e() {
        return this.f19614a.d();
    }

    public MutableLiveData<Boolean> f() {
        return this.f19614a.e();
    }

    public MutableLiveData<a2> g() {
        return this.f19614a.f();
    }

    public Rect h() {
        if (this.f19614a.g() == null || this.f19614a.g().isEmpty()) {
            return null;
        }
        return this.f19614a.g();
    }

    public MutableLiveData<a2> i() {
        return this.f19614a.h();
    }

    public MutableLiveData<a2> j() {
        return this.f19614a.i();
    }

    public void k(Intent intent) {
        this.f19614a.v((Rect) intent.getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA));
        this.f19614a.t(intent.getBooleanExtra("key_jump_to_comment_area", false));
    }

    public boolean l() {
        return this.f19614a.k();
    }

    public boolean m() {
        return this.f19614a.l();
    }

    public MutableLiveData<Boolean> n() {
        return this.f19614a.m();
    }

    public void o(boolean z) {
        if (this.f19614a.f().getValue() != null) {
            e Q = this.f19615b.Q(this.f19614a.f().getValue());
            if (Q != null) {
                this.f19614a.j().addLast(this.f19614a.b());
                this.f19614a.n(Q);
                this.f19614a.u(!ListUtils.isEmpty(Q.f()) ? Q.f().get(0) : null);
                this.f19614a.w(this.f19614a.j().getLast() != null ? this.f19614a.j().getLast().L() : null);
                this.f19615b.Q1(z ? 21 : 22);
                this.f19615b.l1(Q);
                this.f19614a.r(true);
            }
        }
    }

    public void p() {
        e pollLast = this.f19614a.j().pollLast();
        if (pollLast != null) {
            this.f19614a.n(pollLast);
            this.f19614a.u(!ListUtils.isEmpty(pollLast.f()) ? pollLast.f().get(0) : null);
            this.f19614a.w(this.f19614a.j().peekLast() != null ? this.f19614a.j().peekLast().L() : null);
            this.f19615b.l1(pollLast);
            this.f19614a.r(true);
        }
    }

    public void q(a2 a2Var) {
        e Q;
        if (a2Var == null || (Q = this.f19615b.Q(a2Var)) == null) {
            return;
        }
        this.f19614a.j().addLast(this.f19614a.b());
        this.f19614a.n(Q);
        this.f19614a.u(!ListUtils.isEmpty(Q.f()) ? Q.f().get(0) : null);
        this.f19614a.w(this.f19614a.j().getLast() != null ? this.f19614a.j().getLast().L() : null);
        this.f19615b.Q1(20);
        this.f19615b.l1(Q);
        this.f19614a.r(true);
    }

    public void r(e eVar, int i2) {
        if (i2 >= this.f19616c) {
            this.f19616c = i2;
            this.f19614a.o(eVar);
            if (eVar != null) {
                k kVar = this.f19614a;
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
            this.f19614a.n(eVar);
        }
    }

    public void t(boolean z) {
        this.f19614a.q(z);
    }

    public void u(boolean z) {
        this.f19614a.r(z);
    }

    public void v(boolean z) {
        this.f19614a.s(z);
    }

    public void w(boolean z) {
        this.f19614a.t(z);
    }
}
