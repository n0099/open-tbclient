package com.baidu.tieba.write.write.sticker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.f;
import com.baidu.tieba.write.write.sticker.a.a;
import com.baidu.tieba.write.write.sticker.a.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class StickerLayout extends FrameLayout {
    private List<StickerView> jZb;
    private FrameLayout.LayoutParams jZc;
    private int jZd;
    private Context mContext;

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
        this.jZb = new ArrayList();
        this.jZc = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.jZc);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void cEe() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.jZb.remove(stickerView);
                StickerLayout.this.bRN();
                if (cVar != null) {
                    cVar.cCB();
                }
            }

            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void a(StickerView stickerView2, boolean z) {
                stickerView2.setEdit(z);
                if (z) {
                    stickerView2.bringToFront();
                }
            }

            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void b(StickerView stickerView2) {
            }

            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void a(StickerView stickerView2) {
            }
        });
        addView(stickerView);
        this.jZb.add(stickerView);
        bRN();
        if (cVar != null) {
            cVar.cCA();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.jZb.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                bRN();
                if (cVar != null) {
                    cVar.cCB();
                }
            }
        }
    }

    public void bRN() {
        if (this.jZb.size() > 0) {
            for (StickerView stickerView : this.jZb) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.jZd);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap cEf() {
        if (v.aa(this.jZb)) {
            return null;
        }
        bRN();
        return f.bh(this);
    }

    public void setRemoveRes(int i) {
        this.jZd = i;
    }

    public List<StickerView> getStickerViews() {
        return this.jZb;
    }
}
