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
    private List<com.baidu.tieba.write.write.sticker.view.a> hNh;
    private FrameLayout.LayoutParams hNi;
    private int hNj;
    a hNk;
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
        this.hNh = new ArrayList();
        this.hNi = new FrameLayout.LayoutParams(-1, -1);
    }

    public com.baidu.tieba.write.write.sticker.view.a a(Bitmap bitmap, final c cVar) {
        final com.baidu.tieba.write.write.sticker.view.a aVar = new com.baidu.tieba.write.write.sticker.view.a(this.mContext);
        aVar.setImageBitmap(bitmap);
        aVar.setLayoutParams(this.hNi);
        aVar.setmOnStickerActionListener(new com.baidu.tieba.write.write.sticker.a.a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void bJD() {
                StickerLayout.this.removeView(aVar);
                StickerLayout.this.hNh.remove(aVar);
                StickerLayout.this.aYZ();
                if (cVar != null) {
                    cVar.bIc();
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
                if (StickerLayout.this.hNk != null) {
                    StickerLayout.this.hNk.b(aVar2);
                }
            }

            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void a(com.baidu.tieba.write.write.sticker.view.a aVar2) {
                if (StickerLayout.this.hNk != null) {
                    StickerLayout.this.hNk.a(aVar2);
                }
            }
        });
        addView(aVar);
        this.hNh.add(aVar);
        aYZ();
        if (cVar != null) {
            cVar.bIb();
        }
        return aVar;
    }

    public void a(c cVar) {
        Iterator<com.baidu.tieba.write.write.sticker.view.a> it = this.hNh.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.write.write.sticker.view.a next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                aYZ();
                if (cVar != null) {
                    cVar.bIc();
                }
            }
        }
    }

    public void aYZ() {
        if (this.hNh.size() > 0) {
            for (com.baidu.tieba.write.write.sticker.view.a aVar : this.hNh) {
                if (aVar != null) {
                    aVar.setRemoveRes(this.hNj);
                    aVar.setEdit(false);
                }
            }
        }
    }

    public Bitmap bJE() {
        if (v.E(this.hNh)) {
            return null;
        }
        aYZ();
        return d.bm(this);
    }

    public void setRemoveRes(int i) {
        this.hNj = i;
    }

    public void setStickerClickListener(a aVar) {
        this.hNk = aVar;
    }

    public List<com.baidu.tieba.write.write.sticker.view.a> getStickerViews() {
        return this.hNh;
    }
}
