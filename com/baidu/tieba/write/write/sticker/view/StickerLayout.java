package com.baidu.tieba.write.write.sticker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.d;
import com.baidu.tieba.write.write.sticker.a.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class StickerLayout extends FrameLayout {
    private List<com.baidu.tieba.write.write.sticker.view.a> hLB;
    private FrameLayout.LayoutParams hLC;
    private int hLD;
    a hLE;
    private Context mContext;

    /* loaded from: classes2.dex */
    public interface a {
        void a(com.baidu.tieba.write.write.sticker.view.a aVar);

        void b(com.baidu.tieba.write.write.sticker.view.a aVar);
    }

    public StickerLayout(Context context) {
        this(context, null);
    }

    public StickerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.hLB = new ArrayList();
        this.hLC = new FrameLayout.LayoutParams(-1, -1);
    }

    public com.baidu.tieba.write.write.sticker.view.a a(Bitmap bitmap, final c cVar) {
        final com.baidu.tieba.write.write.sticker.view.a aVar = new com.baidu.tieba.write.write.sticker.view.a(this.mContext);
        aVar.setImageBitmap(bitmap);
        aVar.setLayoutParams(this.hLC);
        aVar.setmOnStickerActionListener(new com.baidu.tieba.write.write.sticker.a.a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void bIP() {
                StickerLayout.this.removeView(aVar);
                StickerLayout.this.hLB.remove(aVar);
                StickerLayout.this.aXm();
                if (cVar != null) {
                    cVar.bHn();
                }
            }

            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void a(com.baidu.tieba.write.write.sticker.view.a aVar2, boolean z) {
                aVar2.setEdit(z);
                if (z) {
                    aVar2.bringToFront();
                }
            }

            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void b(com.baidu.tieba.write.write.sticker.view.a aVar2) {
                if (StickerLayout.this.hLE != null) {
                    StickerLayout.this.hLE.b(aVar2);
                }
            }

            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void a(com.baidu.tieba.write.write.sticker.view.a aVar2) {
                if (StickerLayout.this.hLE != null) {
                    StickerLayout.this.hLE.a(aVar2);
                }
            }
        });
        addView(aVar);
        this.hLB.add(aVar);
        aXm();
        if (cVar != null) {
            cVar.bHm();
        }
        return aVar;
    }

    public void a(c cVar) {
        Iterator<com.baidu.tieba.write.write.sticker.view.a> it = this.hLB.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.write.write.sticker.view.a next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                aXm();
                if (cVar != null) {
                    cVar.bHn();
                }
            }
        }
    }

    public void aXm() {
        if (this.hLB.size() > 0) {
            for (com.baidu.tieba.write.write.sticker.view.a aVar : this.hLB) {
                if (aVar != null) {
                    aVar.setRemoveRes(this.hLD);
                    aVar.setEdit(false);
                }
            }
        }
    }

    public Bitmap bIQ() {
        if (v.E(this.hLB)) {
            return null;
        }
        aXm();
        return d.bm(this);
    }

    public void setRemoveRes(int i) {
        this.hLD = i;
    }

    public void setStickerClickListener(a aVar) {
        this.hLE = aVar;
    }

    public List<com.baidu.tieba.write.write.sticker.view.a> getStickerViews() {
        return this.hLB;
    }
}
