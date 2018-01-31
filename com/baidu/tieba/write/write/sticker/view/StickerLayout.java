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
    private List<com.baidu.tieba.write.write.sticker.view.a> hLV;
    private FrameLayout.LayoutParams hLW;
    private int hLX;
    a hLY;
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
        this.hLV = new ArrayList();
        this.hLW = new FrameLayout.LayoutParams(-1, -1);
    }

    public com.baidu.tieba.write.write.sticker.view.a a(Bitmap bitmap, final c cVar) {
        final com.baidu.tieba.write.write.sticker.view.a aVar = new com.baidu.tieba.write.write.sticker.view.a(this.mContext);
        aVar.setImageBitmap(bitmap);
        aVar.setLayoutParams(this.hLW);
        aVar.setmOnStickerActionListener(new com.baidu.tieba.write.write.sticker.a.a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void bIR() {
                StickerLayout.this.removeView(aVar);
                StickerLayout.this.hLV.remove(aVar);
                StickerLayout.this.aXr();
                if (cVar != null) {
                    cVar.bHp();
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
                if (StickerLayout.this.hLY != null) {
                    StickerLayout.this.hLY.b(aVar2);
                }
            }

            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void a(com.baidu.tieba.write.write.sticker.view.a aVar2) {
                if (StickerLayout.this.hLY != null) {
                    StickerLayout.this.hLY.a(aVar2);
                }
            }
        });
        addView(aVar);
        this.hLV.add(aVar);
        aXr();
        if (cVar != null) {
            cVar.bHo();
        }
        return aVar;
    }

    public void a(c cVar) {
        Iterator<com.baidu.tieba.write.write.sticker.view.a> it = this.hLV.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.write.write.sticker.view.a next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                aXr();
                if (cVar != null) {
                    cVar.bHp();
                }
            }
        }
    }

    public void aXr() {
        if (this.hLV.size() > 0) {
            for (com.baidu.tieba.write.write.sticker.view.a aVar : this.hLV) {
                if (aVar != null) {
                    aVar.setRemoveRes(this.hLX);
                    aVar.setEdit(false);
                }
            }
        }
    }

    public Bitmap bIS() {
        if (v.E(this.hLV)) {
            return null;
        }
        aXr();
        return d.bm(this);
    }

    public void setRemoveRes(int i) {
        this.hLX = i;
    }

    public void setStickerClickListener(a aVar) {
        this.hLY = aVar;
    }

    public List<com.baidu.tieba.write.write.sticker.view.a> getStickerViews() {
        return this.hLV;
    }
}
