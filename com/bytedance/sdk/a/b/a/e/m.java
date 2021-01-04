package com.bytedance.sdk.a.b.a.e;

import java.io.IOException;
import java.util.List;
/* loaded from: classes4.dex */
public interface m {
    public static final m pkR = new m() { // from class: com.bytedance.sdk.a.b.a.e.m.1
        @Override // com.bytedance.sdk.a.b.a.e.m
        public boolean q(int i, List<c> list) {
            return true;
        }

        @Override // com.bytedance.sdk.a.b.a.e.m
        public boolean c(int i, List<c> list, boolean z) {
            return true;
        }

        @Override // com.bytedance.sdk.a.b.a.e.m
        public boolean b(int i, com.bytedance.sdk.a.a.e eVar, int i2, boolean z) throws IOException {
            eVar.h(i2);
            return true;
        }

        @Override // com.bytedance.sdk.a.b.a.e.m
        public void a(int i, b bVar) {
        }
    };

    void a(int i, b bVar);

    boolean b(int i, com.bytedance.sdk.a.a.e eVar, int i2, boolean z) throws IOException;

    boolean c(int i, List<c> list, boolean z);

    boolean q(int i, List<c> list);
}
