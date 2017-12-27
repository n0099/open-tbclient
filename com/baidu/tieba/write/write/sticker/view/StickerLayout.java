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
    private List<com.baidu.tieba.write.write.sticker.view.a> hVR;
    private FrameLayout.LayoutParams hVS;
    private int hVT;
    a hVU;
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
        this.hVR = new ArrayList();
        this.hVS = new FrameLayout.LayoutParams(-1, -1);
    }

    public com.baidu.tieba.write.write.sticker.view.a a(Bitmap bitmap, final c cVar) {
        final com.baidu.tieba.write.write.sticker.view.a aVar = new com.baidu.tieba.write.write.sticker.view.a(this.mContext);
        aVar.setImageBitmap(bitmap);
        aVar.setLayoutParams(this.hVS);
        aVar.setmOnStickerActionListener(new com.baidu.tieba.write.write.sticker.a.a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void bPm() {
                StickerLayout.this.removeView(aVar);
                StickerLayout.this.hVR.remove(aVar);
                StickerLayout.this.aXh();
                if (cVar != null) {
                    cVar.bNN();
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
                if (StickerLayout.this.hVU != null) {
                    StickerLayout.this.hVU.b(aVar2);
                }
            }

            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void a(com.baidu.tieba.write.write.sticker.view.a aVar2) {
                if (StickerLayout.this.hVU != null) {
                    StickerLayout.this.hVU.a(aVar2);
                }
            }
        });
        addView(aVar);
        this.hVR.add(aVar);
        aXh();
        if (cVar != null) {
            cVar.bNM();
        }
        return aVar;
    }

    public void a(c cVar) {
        Iterator<com.baidu.tieba.write.write.sticker.view.a> it = this.hVR.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.write.write.sticker.view.a next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                aXh();
                if (cVar != null) {
                    cVar.bNN();
                }
            }
        }
    }

    public void aXh() {
        if (this.hVR.size() > 0) {
            for (com.baidu.tieba.write.write.sticker.view.a aVar : this.hVR) {
                if (aVar != null) {
                    aVar.setRemoveRes(this.hVT);
                    aVar.setEdit(false);
                }
            }
        }
    }

    public Bitmap bPn() {
        if (v.G(this.hVR)) {
            return null;
        }
        aXh();
        return d.bk(this);
    }

    public void setRemoveRes(int i) {
        this.hVT = i;
    }

    public void setStickerClickListener(a aVar) {
        this.hVU = aVar;
    }

    public List<com.baidu.tieba.write.write.sticker.view.a> getStickerViews() {
        return this.hVR;
    }
}
