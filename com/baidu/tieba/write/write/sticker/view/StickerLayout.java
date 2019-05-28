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
    private List<StickerView> jOw;
    private FrameLayout.LayoutParams jOx;
    private int jOy;
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
        this.jOw = new ArrayList();
        this.jOx = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.jOx);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void czY() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.jOw.remove(stickerView);
                StickerLayout.this.bOb();
                if (cVar != null) {
                    cVar.cyv();
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
        this.jOw.add(stickerView);
        bOb();
        if (cVar != null) {
            cVar.cyu();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.jOw.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                bOb();
                if (cVar != null) {
                    cVar.cyv();
                }
            }
        }
    }

    public void bOb() {
        if (this.jOw.size() > 0) {
            for (StickerView stickerView : this.jOw) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.jOy);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap czZ() {
        if (v.aa(this.jOw)) {
            return null;
        }
        bOb();
        return f.bf(this);
    }

    public void setRemoveRes(int i) {
        this.jOy = i;
    }

    public List<StickerView> getStickerViews() {
        return this.jOw;
    }
}
