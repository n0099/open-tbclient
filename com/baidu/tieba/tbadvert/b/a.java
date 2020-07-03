package com.baidu.tieba.tbadvert.b;

import com.baidu.adp.lib.e.b;
import com.baidu.tbadk.core.util.w;
/* loaded from: classes13.dex */
public class a {
    private com.baidu.tieba.tbadvert.a.a lKe;
    private InterfaceC0747a lKf;
    private InterfaceC0747a lKg = new InterfaceC0747a() { // from class: com.baidu.tieba.tbadvert.b.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0747a
        public void aI(Object obj) {
            if (a.this.lKf != null) {
                a.this.lKf.aI(obj);
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0747a
        public void djx() {
            a.this.lKe = null;
            if (a.this.lKf != null) {
                a.this.lKf.djx();
            }
        }
    };
    private b<com.baidu.adp.widget.ImageView.a> lKh = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadvert.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar == null || aVar.getRawBitmap() == null) {
                if (a.this.lKf != null) {
                    a.this.lKf.djx();
                }
            } else if (a.this.lKf != null) {
                a.this.lKf.aI(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.lKf != null) {
                a.this.lKf.djx();
            }
        }
    };

    /* renamed from: com.baidu.tieba.tbadvert.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0747a {
        void aI(Object obj);

        void djx();
    }

    public com.baidu.tieba.tbadvert.a.b djB() {
        if (this.lKe == null || w.isEmpty(this.lKe.lKd)) {
            return null;
        }
        for (com.baidu.tieba.tbadvert.a.b bVar : this.lKe.lKd) {
            if (bVar != null && bVar.djA() && bVar.dMR == 3) {
                return bVar;
            }
        }
        return null;
    }

    public void a(InterfaceC0747a interfaceC0747a) {
        this.lKf = interfaceC0747a;
    }
}
