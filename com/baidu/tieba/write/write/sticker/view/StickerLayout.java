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
    private List<com.baidu.tieba.write.write.sticker.view.a> hNu;
    private FrameLayout.LayoutParams hNv;
    private int hNw;
    a hNx;
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
        this.hNu = new ArrayList();
        this.hNv = new FrameLayout.LayoutParams(-1, -1);
    }

    public com.baidu.tieba.write.write.sticker.view.a a(Bitmap bitmap, final c cVar) {
        final com.baidu.tieba.write.write.sticker.view.a aVar = new com.baidu.tieba.write.write.sticker.view.a(this.mContext);
        aVar.setImageBitmap(bitmap);
        aVar.setLayoutParams(this.hNv);
        aVar.setmOnStickerActionListener(new com.baidu.tieba.write.write.sticker.a.a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void bJE() {
                StickerLayout.this.removeView(aVar);
                StickerLayout.this.hNu.remove(aVar);
                StickerLayout.this.aZa();
                if (cVar != null) {
                    cVar.bId();
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
                if (StickerLayout.this.hNx != null) {
                    StickerLayout.this.hNx.b(aVar2);
                }
            }

            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void a(com.baidu.tieba.write.write.sticker.view.a aVar2) {
                if (StickerLayout.this.hNx != null) {
                    StickerLayout.this.hNx.a(aVar2);
                }
            }
        });
        addView(aVar);
        this.hNu.add(aVar);
        aZa();
        if (cVar != null) {
            cVar.bIc();
        }
        return aVar;
    }

    public void a(c cVar) {
        Iterator<com.baidu.tieba.write.write.sticker.view.a> it = this.hNu.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.write.write.sticker.view.a next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                aZa();
                if (cVar != null) {
                    cVar.bId();
                }
            }
        }
    }

    public void aZa() {
        if (this.hNu.size() > 0) {
            for (com.baidu.tieba.write.write.sticker.view.a aVar : this.hNu) {
                if (aVar != null) {
                    aVar.setRemoveRes(this.hNw);
                    aVar.setEdit(false);
                }
            }
        }
    }

    public Bitmap bJF() {
        if (v.E(this.hNu)) {
            return null;
        }
        aZa();
        return d.bm(this);
    }

    public void setRemoveRes(int i) {
        this.hNw = i;
    }

    public void setStickerClickListener(a aVar) {
        this.hNx = aVar;
    }

    public List<com.baidu.tieba.write.write.sticker.view.a> getStickerViews() {
        return this.hNu;
    }
}
