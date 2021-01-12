package com.bytedance.sdk.openadsdk.core.d;

import androidx.annotation.NonNull;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public final int f6503a;

    /* renamed from: b  reason: collision with root package name */
    public final int f6504b;
    public final int c;
    public final int d;
    public final long e;
    public final long f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;

    private j(@NonNull a aVar) {
        this.f6503a = aVar.f;
        this.f6504b = aVar.e;
        this.c = aVar.d;
        this.d = aVar.c;
        this.e = aVar.f6506b;
        this.f = aVar.f6505a;
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
    }

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private long f6505a;

        /* renamed from: b  reason: collision with root package name */
        private long f6506b;
        private int c;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;
        private int i;
        private int j;

        public a a(long j) {
            this.f6505a = j;
            return this;
        }

        public a b(long j) {
            this.f6506b = j;
            return this;
        }

        public a a(int i) {
            this.c = i;
            return this;
        }

        public a b(int i) {
            this.d = i;
            return this;
        }

        public a c(int i) {
            this.e = i;
            return this;
        }

        public a d(int i) {
            this.f = i;
            return this;
        }

        public a e(int i) {
            this.g = i;
            return this;
        }

        public a f(int i) {
            this.h = i;
            return this;
        }

        public a g(int i) {
            this.i = i;
            return this;
        }

        public a h(int i) {
            this.j = i;
            return this;
        }

        public j a() {
            return new j(this);
        }
    }
}
