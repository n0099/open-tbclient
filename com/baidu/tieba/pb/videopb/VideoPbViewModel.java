package com.baidu.tieba.pb.videopb;

import android.content.Intent;
import android.graphics.Rect;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.pb.pb.main.PbModel;
import d.a.i0.r.q.a2;
import d.a.j0.d2.h.e;
import d.a.j0.d2.o.k;
/* loaded from: classes3.dex */
public class VideoPbViewModel extends ViewModel {

    /* renamed from: b  reason: collision with root package name */
    public PbModel f20246b;

    /* renamed from: a  reason: collision with root package name */
    public k f20245a = new k();

    /* renamed from: c  reason: collision with root package name */
    public int f20247c = 0;

    public void a(PbModel pbModel) {
        this.f20246b = pbModel;
    }

    public MutableLiveData<Integer> b() {
        return this.f20245a.a();
    }

    public e c() {
        return this.f20245a.b();
    }

    public e d() {
        return this.f20245a.c();
    }

    public MutableLiveData<Boolean> e() {
        return this.f20245a.d();
    }

    public MutableLiveData<Boolean> f() {
        return this.f20245a.e();
    }

    public MutableLiveData<a2> g() {
        return this.f20245a.f();
    }

    public Rect h() {
        if (this.f20245a.g() == null || this.f20245a.g().isEmpty()) {
            return null;
        }
        return this.f20245a.g();
    }

    public MutableLiveData<a2> i() {
        return this.f20245a.h();
    }

    public MutableLiveData<a2> j() {
        return this.f20245a.i();
    }

    public void k(Intent intent) {
        this.f20245a.v((Rect) intent.getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA));
        this.f20245a.t(intent.getBooleanExtra("key_jump_to_comment_area", false));
    }

    public boolean l() {
        return this.f20245a.k();
    }

    public boolean m() {
        return this.f20245a.l();
    }

    public MutableLiveData<Boolean> n() {
        return this.f20245a.m();
    }

    public void o(boolean z) {
        if (this.f20245a.f().getValue() != null) {
            e M = this.f20246b.M(this.f20245a.f().getValue());
            if (M != null) {
                this.f20245a.j().addLast(this.f20245a.b());
                this.f20245a.n(M);
                this.f20245a.u(!ListUtils.isEmpty(M.f()) ? M.f().get(0) : null);
                this.f20245a.w(this.f20245a.j().getLast() != null ? this.f20245a.j().getLast().L() : null);
                this.f20246b.N1(z ? 21 : 22);
                this.f20246b.i1(M);
                this.f20245a.r(true);
            }
        }
    }

    public void p() {
        e pollLast = this.f20245a.j().pollLast();
        if (pollLast != null) {
            this.f20245a.n(pollLast);
            this.f20245a.u(!ListUtils.isEmpty(pollLast.f()) ? pollLast.f().get(0) : null);
            this.f20245a.w(this.f20245a.j().peekLast() != null ? this.f20245a.j().peekLast().L() : null);
            this.f20246b.i1(pollLast);
            this.f20245a.r(true);
        }
    }

    public void q(a2 a2Var) {
        e M;
        if (a2Var == null || (M = this.f20246b.M(a2Var)) == null) {
            return;
        }
        this.f20245a.j().addLast(this.f20245a.b());
        this.f20245a.n(M);
        this.f20245a.u(!ListUtils.isEmpty(M.f()) ? M.f().get(0) : null);
        this.f20245a.w(this.f20245a.j().getLast() != null ? this.f20245a.j().getLast().L() : null);
        this.f20246b.N1(20);
        this.f20246b.i1(M);
        this.f20245a.r(true);
    }

    public void r(e eVar, int i2) {
        if (i2 >= this.f20247c) {
            this.f20247c = i2;
            this.f20245a.o(eVar);
            if (eVar != null) {
                k kVar = this.f20245a;
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
            this.f20245a.n(eVar);
        }
    }

    public void t(boolean z) {
        this.f20245a.q(z);
    }

    public void u(boolean z) {
        this.f20245a.r(z);
    }

    public void v(boolean z) {
        this.f20245a.s(z);
    }

    public void w(boolean z) {
        this.f20245a.t(z);
    }
}
