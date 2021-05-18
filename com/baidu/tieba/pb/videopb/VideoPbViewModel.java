package com.baidu.tieba.pb.videopb;

import android.content.Intent;
import android.graphics.Rect;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.pb.pb.main.PbModel;
import d.a.j0.r.q.a2;
import d.a.k0.d2.h.e;
import d.a.k0.d2.o.k;
/* loaded from: classes5.dex */
public class VideoPbViewModel extends ViewModel {

    /* renamed from: b  reason: collision with root package name */
    public PbModel f19534b;

    /* renamed from: a  reason: collision with root package name */
    public k f19533a = new k();

    /* renamed from: c  reason: collision with root package name */
    public int f19535c = 0;

    public void a(PbModel pbModel) {
        this.f19534b = pbModel;
    }

    public MutableLiveData<Integer> b() {
        return this.f19533a.a();
    }

    public e c() {
        return this.f19533a.b();
    }

    public e d() {
        return this.f19533a.c();
    }

    public MutableLiveData<Boolean> e() {
        return this.f19533a.d();
    }

    public MutableLiveData<Boolean> f() {
        return this.f19533a.e();
    }

    public MutableLiveData<a2> g() {
        return this.f19533a.f();
    }

    public Rect h() {
        if (this.f19533a.g() == null || this.f19533a.g().isEmpty()) {
            return null;
        }
        return this.f19533a.g();
    }

    public MutableLiveData<a2> i() {
        return this.f19533a.h();
    }

    public MutableLiveData<a2> j() {
        return this.f19533a.i();
    }

    public void k(Intent intent) {
        this.f19533a.v((Rect) intent.getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA));
        this.f19533a.t(intent.getBooleanExtra("key_jump_to_comment_area", false));
    }

    public boolean l() {
        return this.f19533a.k();
    }

    public boolean m() {
        return this.f19533a.l();
    }

    public MutableLiveData<Boolean> n() {
        return this.f19533a.m();
    }

    public void o(boolean z) {
        if (this.f19533a.f().getValue() != null) {
            e M = this.f19534b.M(this.f19533a.f().getValue());
            if (M != null) {
                this.f19533a.j().addLast(this.f19533a.b());
                this.f19533a.n(M);
                this.f19533a.u(!ListUtils.isEmpty(M.f()) ? M.f().get(0) : null);
                this.f19533a.w(this.f19533a.j().getLast() != null ? this.f19533a.j().getLast().L() : null);
                this.f19534b.N1(z ? 21 : 22);
                this.f19534b.i1(M);
                this.f19533a.r(true);
            }
        }
    }

    public void p() {
        e pollLast = this.f19533a.j().pollLast();
        if (pollLast != null) {
            this.f19533a.n(pollLast);
            this.f19533a.u(!ListUtils.isEmpty(pollLast.f()) ? pollLast.f().get(0) : null);
            this.f19533a.w(this.f19533a.j().peekLast() != null ? this.f19533a.j().peekLast().L() : null);
            this.f19534b.i1(pollLast);
            this.f19533a.r(true);
        }
    }

    public void q(a2 a2Var) {
        e M;
        if (a2Var == null || (M = this.f19534b.M(a2Var)) == null) {
            return;
        }
        this.f19533a.j().addLast(this.f19533a.b());
        this.f19533a.n(M);
        this.f19533a.u(!ListUtils.isEmpty(M.f()) ? M.f().get(0) : null);
        this.f19533a.w(this.f19533a.j().getLast() != null ? this.f19533a.j().getLast().L() : null);
        this.f19534b.N1(20);
        this.f19534b.i1(M);
        this.f19533a.r(true);
    }

    public void r(e eVar, int i2) {
        if (i2 >= this.f19535c) {
            this.f19535c = i2;
            this.f19533a.o(eVar);
            if (eVar != null) {
                k kVar = this.f19533a;
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
            this.f19533a.n(eVar);
        }
    }

    public void t(boolean z) {
        this.f19533a.q(z);
    }

    public void u(boolean z) {
        this.f19533a.r(z);
    }

    public void v(boolean z) {
        this.f19533a.s(z);
    }

    public void w(boolean z) {
        this.f19533a.t(z);
    }
}
