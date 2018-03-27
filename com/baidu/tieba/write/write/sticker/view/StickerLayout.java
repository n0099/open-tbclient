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
    private List<com.baidu.tieba.write.write.sticker.view.a> hNF;
    private FrameLayout.LayoutParams hNG;
    private int hNH;
    a hNI;
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
        this.hNF = new ArrayList();
        this.hNG = new FrameLayout.LayoutParams(-1, -1);
    }

    public com.baidu.tieba.write.write.sticker.view.a a(Bitmap bitmap, final c cVar) {
        final com.baidu.tieba.write.write.sticker.view.a aVar = new com.baidu.tieba.write.write.sticker.view.a(this.mContext);
        aVar.setImageBitmap(bitmap);
        aVar.setLayoutParams(this.hNG);
        aVar.setmOnStickerActionListener(new com.baidu.tieba.write.write.sticker.a.a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void bJI() {
                StickerLayout.this.removeView(aVar);
                StickerLayout.this.hNF.remove(aVar);
                StickerLayout.this.aZa();
                if (cVar != null) {
                    cVar.bIh();
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
                if (StickerLayout.this.hNI != null) {
                    StickerLayout.this.hNI.b(aVar2);
                }
            }

            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void a(com.baidu.tieba.write.write.sticker.view.a aVar2) {
                if (StickerLayout.this.hNI != null) {
                    StickerLayout.this.hNI.a(aVar2);
                }
            }
        });
        addView(aVar);
        this.hNF.add(aVar);
        aZa();
        if (cVar != null) {
            cVar.bIg();
        }
        return aVar;
    }

    public void a(c cVar) {
        Iterator<com.baidu.tieba.write.write.sticker.view.a> it = this.hNF.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.write.write.sticker.view.a next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                aZa();
                if (cVar != null) {
                    cVar.bIh();
                }
            }
        }
    }

    public void aZa() {
        if (this.hNF.size() > 0) {
            for (com.baidu.tieba.write.write.sticker.view.a aVar : this.hNF) {
                if (aVar != null) {
                    aVar.setRemoveRes(this.hNH);
                    aVar.setEdit(false);
                }
            }
        }
    }

    public Bitmap bJJ() {
        if (v.E(this.hNF)) {
            return null;
        }
        aZa();
        return d.bm(this);
    }

    public void setRemoveRes(int i) {
        this.hNH = i;
    }

    public void setStickerClickListener(a aVar) {
        this.hNI = aVar;
    }

    public List<com.baidu.tieba.write.write.sticker.view.a> getStickerViews() {
        return this.hNF;
    }
}
