package com.baidu.tieba.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.Queue;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<Void, f, f> {
    final Queue<f> a;
    final /* synthetic */ e b;

    public g(e eVar, Queue<f> queue) {
        this.b = eVar;
        this.a = queue;
        super.setPriority(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public f a(Void... voidArr) {
        while (true) {
            f poll = this.a.poll();
            if (poll == null) {
                break;
            } else if (isCancelled()) {
                this.a.add(poll);
                break;
            } else {
                com.baidu.adp.widget.ImageView.b c = com.baidu.tbadk.imageManager.e.a().c(poll.a.toCachedKey(poll.c));
                if (c != null) {
                    poll.d = c;
                    poll.e = true;
                } else {
                    Bitmap b = this.b.b(poll.a, poll.c);
                    if (b != null) {
                        poll.d = new com.baidu.adp.widget.ImageView.b(b, false, poll.a.getFilePath());
                    }
                }
                c((Object[]) new f[]{poll});
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(f fVar) {
        super.a((g) fVar);
        this.b.c = null;
        this.b.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(f... fVarArr) {
        if (fVarArr != null) {
            for (f fVar : fVarArr) {
                com.baidu.adp.widget.ImageView.b bVar = fVar.d;
                if (bVar != null && !fVar.e) {
                    com.baidu.tbadk.imageManager.e.a().b(fVar.a.toCachedKey(fVar.c), bVar);
                }
                if (fVar.b != null) {
                    fVar.b.a(bVar, fVar.a.toCachedKey(fVar.c), fVar.e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void c() {
        super.c();
        this.b.c = null;
        while (true) {
            f poll = this.a.poll();
            if (poll != null) {
                if (poll.b != null) {
                    poll.b.a(null, poll.a.toCachedKey(poll.c), false);
                }
            } else {
                return;
            }
        }
    }
}
