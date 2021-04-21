package com.baidu.tieba.pb.videopb;

import android.content.Intent;
import android.graphics.Rect;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.pb.pb.main.PbModel;
import d.b.i0.r.q.a2;
import d.b.j0.d2.h.e;
import d.b.j0.d2.o.k;
/* loaded from: classes3.dex */
public class VideoPbViewModel extends ViewModel {

    /* renamed from: b  reason: collision with root package name */
    public PbModel f19761b;

    /* renamed from: a  reason: collision with root package name */
    public k f19760a = new k();

    /* renamed from: c  reason: collision with root package name */
    public int f19762c = 0;

    public void a(PbModel pbModel) {
        this.f19761b = pbModel;
    }

    public MutableLiveData<Integer> b() {
        return this.f19760a.a();
    }

    public e c() {
        return this.f19760a.b();
    }

    public e d() {
        return this.f19760a.c();
    }

    public MutableLiveData<Boolean> e() {
        return this.f19760a.d();
    }

    public MutableLiveData<Boolean> f() {
        return this.f19760a.e();
    }

    public MutableLiveData<a2> g() {
        return this.f19760a.f();
    }

    public Rect h() {
        if (this.f19760a.g() == null || this.f19760a.g().isEmpty()) {
            return null;
        }
        return this.f19760a.g();
    }

    public MutableLiveData<a2> i() {
        return this.f19760a.h();
    }

    public MutableLiveData<a2> j() {
        return this.f19760a.i();
    }

    public void k(Intent intent) {
        this.f19760a.v((Rect) intent.getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA));
        this.f19760a.t(intent.getBooleanExtra("key_jump_to_comment_area", false));
    }

    public boolean l() {
        return this.f19760a.k();
    }

    public boolean m() {
        return this.f19760a.l();
    }

    public MutableLiveData<Boolean> n() {
        return this.f19760a.m();
    }

    public void o(boolean z) {
        if (this.f19760a.f().getValue() != null) {
            e M = this.f19761b.M(this.f19760a.f().getValue());
            if (M != null) {
                this.f19760a.j().addLast(this.f19760a.b());
                this.f19760a.n(M);
                this.f19760a.u(!ListUtils.isEmpty(M.f()) ? M.f().get(0) : null);
                this.f19760a.w(this.f19760a.j().getLast() != null ? this.f19760a.j().getLast().L() : null);
                this.f19761b.N1(z ? 21 : 22);
                this.f19761b.i1(M);
                this.f19760a.r(true);
            }
        }
    }

    public void p() {
        e pollLast = this.f19760a.j().pollLast();
        if (pollLast != null) {
            this.f19760a.n(pollLast);
            this.f19760a.u(!ListUtils.isEmpty(pollLast.f()) ? pollLast.f().get(0) : null);
            this.f19760a.w(this.f19760a.j().peekLast() != null ? this.f19760a.j().peekLast().L() : null);
            this.f19761b.i1(pollLast);
            this.f19760a.r(true);
        }
    }

    public void q(a2 a2Var) {
        e M;
        if (a2Var == null || (M = this.f19761b.M(a2Var)) == null) {
            return;
        }
        this.f19760a.j().addLast(this.f19760a.b());
        this.f19760a.n(M);
        this.f19760a.u(!ListUtils.isEmpty(M.f()) ? M.f().get(0) : null);
        this.f19760a.w(this.f19760a.j().getLast() != null ? this.f19760a.j().getLast().L() : null);
        this.f19761b.N1(20);
        this.f19761b.i1(M);
        this.f19760a.r(true);
    }

    public void r(e eVar, int i) {
        if (i >= this.f19762c) {
            this.f19762c = i;
            this.f19760a.o(eVar);
            if (eVar != null) {
                k kVar = this.f19760a;
                boolean z = true;
                if (eVar.s() != 1 && !eVar.a0()) {
                    z = false;
                }
                kVar.p(z);
            }
        }
    }

    public void s(e eVar, int i) {
        if (i == 3) {
            this.f19760a.n(eVar);
        }
    }

    public void t(boolean z) {
        this.f19760a.q(z);
    }

    public void u(boolean z) {
        this.f19760a.r(z);
    }

    public void v(boolean z) {
        this.f19760a.s(z);
    }

    public void w(boolean z) {
        this.f19760a.t(z);
    }
}
