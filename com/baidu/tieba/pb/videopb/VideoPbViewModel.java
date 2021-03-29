package com.baidu.tieba.pb.videopb;

import android.content.Intent;
import android.graphics.Rect;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.pb.pb.main.PbModel;
import d.b.h0.r.q.a2;
import d.b.i0.c2.h.e;
import d.b.i0.c2.o.d;
/* loaded from: classes5.dex */
public class VideoPbViewModel extends ViewModel {

    /* renamed from: b  reason: collision with root package name */
    public PbModel f20066b;

    /* renamed from: a  reason: collision with root package name */
    public d f20065a = new d();

    /* renamed from: c  reason: collision with root package name */
    public int f20067c = 0;

    public void a(PbModel pbModel) {
        this.f20066b = pbModel;
    }

    public MutableLiveData<Integer> b() {
        return this.f20065a.a();
    }

    public e c() {
        return this.f20065a.b();
    }

    public e d() {
        return this.f20065a.c();
    }

    public MutableLiveData<Boolean> e() {
        return this.f20065a.d();
    }

    public MutableLiveData<Boolean> f() {
        return this.f20065a.e();
    }

    public MutableLiveData<a2> g() {
        return this.f20065a.f();
    }

    public Rect h() {
        if (this.f20065a.g() == null || this.f20065a.g().isEmpty()) {
            return null;
        }
        return this.f20065a.g();
    }

    public MutableLiveData<a2> i() {
        return this.f20065a.h();
    }

    public MutableLiveData<a2> j() {
        return this.f20065a.i();
    }

    public void k(Intent intent) {
        this.f20065a.v((Rect) intent.getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA));
        this.f20065a.t(intent.getBooleanExtra("key_jump_to_comment_area", false));
    }

    public boolean l() {
        return this.f20065a.k();
    }

    public boolean m() {
        return this.f20065a.l();
    }

    public MutableLiveData<Boolean> n() {
        return this.f20065a.m();
    }

    public void o(boolean z) {
        if (this.f20065a.f().getValue() != null) {
            e M = this.f20066b.M(this.f20065a.f().getValue());
            if (M != null) {
                this.f20065a.j().addLast(this.f20065a.b());
                this.f20065a.n(M);
                this.f20065a.u(!ListUtils.isEmpty(M.f()) ? M.f().get(0) : null);
                this.f20065a.w(this.f20065a.j().getLast() != null ? this.f20065a.j().getLast().L() : null);
                this.f20066b.N1(z ? 21 : 22);
                this.f20066b.i1(M);
                this.f20065a.r(true);
            }
        }
    }

    public void p() {
        e pollLast = this.f20065a.j().pollLast();
        if (pollLast != null) {
            this.f20065a.n(pollLast);
            this.f20065a.u(!ListUtils.isEmpty(pollLast.f()) ? pollLast.f().get(0) : null);
            this.f20065a.w(this.f20065a.j().peekLast() != null ? this.f20065a.j().peekLast().L() : null);
            this.f20066b.i1(pollLast);
            this.f20065a.r(true);
        }
    }

    public void q(a2 a2Var) {
        e M;
        if (a2Var == null || (M = this.f20066b.M(a2Var)) == null) {
            return;
        }
        this.f20065a.j().addLast(this.f20065a.b());
        this.f20065a.n(M);
        this.f20065a.u(!ListUtils.isEmpty(M.f()) ? M.f().get(0) : null);
        this.f20065a.w(this.f20065a.j().getLast() != null ? this.f20065a.j().getLast().L() : null);
        this.f20066b.N1(20);
        this.f20066b.i1(M);
        this.f20065a.r(true);
    }

    public void r(e eVar, int i) {
        if (i >= this.f20067c) {
            this.f20067c = i;
            this.f20065a.o(eVar);
            if (eVar != null) {
                d dVar = this.f20065a;
                boolean z = true;
                if (eVar.s() != 1 && !eVar.Z()) {
                    z = false;
                }
                dVar.p(z);
            }
        }
    }

    public void s(e eVar, int i) {
        if (i == 3) {
            this.f20065a.n(eVar);
        }
    }

    public void t(boolean z) {
        this.f20065a.q(z);
    }

    public void u(boolean z) {
        this.f20065a.r(z);
    }

    public void v(boolean z) {
        this.f20065a.s(z);
    }

    public void w(boolean z) {
        this.f20065a.t(z);
    }
}
