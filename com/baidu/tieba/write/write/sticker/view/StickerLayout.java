package com.baidu.tieba.write.write.sticker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.util.h;
import com.baidu.tieba.write.write.sticker.a.a;
import com.baidu.tieba.write.write.sticker.a.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class StickerLayout extends FrameLayout {
    private Context mContext;
    private List<StickerView> onD;
    private FrameLayout.LayoutParams onE;
    private int onF;

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
        this.onD = new ArrayList();
        this.onE = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.onE);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void cRw() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.onD.remove(stickerView);
                StickerLayout.this.dja();
                if (cVar != null) {
                    cVar.dYb();
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
        this.onD.add(stickerView);
        dja();
        if (cVar != null) {
            cVar.dYa();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.onD.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                dja();
                if (cVar != null) {
                    cVar.dYb();
                }
            }
        }
    }

    public void dja() {
        if (this.onD.size() > 0) {
            for (StickerView stickerView : this.onD) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.onF);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap dZV() {
        if (y.isEmpty(this.onD)) {
            return null;
        }
        dja();
        return h.bV(this);
    }

    public void setRemoveRes(int i) {
        this.onF = i;
    }

    public List<StickerView> getStickerViews() {
        return this.onD;
    }
}
