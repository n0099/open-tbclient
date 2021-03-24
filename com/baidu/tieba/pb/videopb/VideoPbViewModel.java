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
    public PbModel f20065b;

    /* renamed from: a  reason: collision with root package name */
    public d f20064a = new d();

    /* renamed from: c  reason: collision with root package name */
    public int f20066c = 0;

    public void a(PbModel pbModel) {
        this.f20065b = pbModel;
    }

    public MutableLiveData<Integer> b() {
        return this.f20064a.a();
    }

    public e c() {
        return this.f20064a.b();
    }

    public e d() {
        return this.f20064a.c();
    }

    public MutableLiveData<Boolean> e() {
        return this.f20064a.d();
    }

    public MutableLiveData<Boolean> f() {
        return this.f20064a.e();
    }

    public MutableLiveData<a2> g() {
        return this.f20064a.f();
    }

    public Rect h() {
        if (this.f20064a.g() == null || this.f20064a.g().isEmpty()) {
            return null;
        }
        return this.f20064a.g();
    }

    public MutableLiveData<a2> i() {
        return this.f20064a.h();
    }

    public MutableLiveData<a2> j() {
        return this.f20064a.i();
    }

    public void k(Intent intent) {
        this.f20064a.v((Rect) intent.getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA));
        this.f20064a.t(intent.getBooleanExtra("key_jump_to_comment_area", false));
    }

    public boolean l() {
        return this.f20064a.k();
    }

    public boolean m() {
        return this.f20064a.l();
    }

    public MutableLiveData<Boolean> n() {
        return this.f20064a.m();
    }

    public void o(boolean z) {
        if (this.f20064a.f().getValue() != null) {
            e M = this.f20065b.M(this.f20064a.f().getValue());
            if (M != null) {
                this.f20064a.j().addLast(this.f20064a.b());
                this.f20064a.n(M);
                this.f20064a.u(!ListUtils.isEmpty(M.f()) ? M.f().get(0) : null);
                this.f20064a.w(this.f20064a.j().getLast() != null ? this.f20064a.j().getLast().L() : null);
                this.f20065b.N1(z ? 21 : 22);
                this.f20065b.i1(M);
                this.f20064a.r(true);
            }
        }
    }

    public void p() {
        e pollLast = this.f20064a.j().pollLast();
        if (pollLast != null) {
            this.f20064a.n(pollLast);
            this.f20064a.u(!ListUtils.isEmpty(pollLast.f()) ? pollLast.f().get(0) : null);
            this.f20064a.w(this.f20064a.j().peekLast() != null ? this.f20064a.j().peekLast().L() : null);
            this.f20065b.i1(pollLast);
            this.f20064a.r(true);
        }
    }

    public void q(a2 a2Var) {
        e M;
        if (a2Var == null || (M = this.f20065b.M(a2Var)) == null) {
            return;
        }
        this.f20064a.j().addLast(this.f20064a.b());
        this.f20064a.n(M);
        this.f20064a.u(!ListUtils.isEmpty(M.f()) ? M.f().get(0) : null);
        this.f20064a.w(this.f20064a.j().getLast() != null ? this.f20064a.j().getLast().L() : null);
        this.f20065b.N1(20);
        this.f20065b.i1(M);
        this.f20064a.r(true);
    }

    public void r(e eVar, int i) {
        if (i >= this.f20066c) {
            this.f20066c = i;
            this.f20064a.o(eVar);
            if (eVar != null) {
                d dVar = this.f20064a;
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
            this.f20064a.n(eVar);
        }
    }

    public void t(boolean z) {
        this.f20064a.q(z);
    }

    public void u(boolean z) {
        this.f20064a.r(z);
    }

    public void v(boolean z) {
        this.f20064a.s(z);
    }

    public void w(boolean z) {
        this.f20064a.t(z);
    }
}
