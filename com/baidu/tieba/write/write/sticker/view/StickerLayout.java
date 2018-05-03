package com.baidu.tieba.write.write.sticker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.d;
import com.baidu.tieba.write.write.sticker.a.a;
import com.baidu.tieba.write.write.sticker.a.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class StickerLayout extends FrameLayout {
    private List<StickerView> hjq;
    private FrameLayout.LayoutParams hjr;
    private int hjs;
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
        this.hjq = new ArrayList();
        this.hjr = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.hjr);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void bEv() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.hjq.remove(stickerView);
                StickerLayout.this.aTV();
                if (cVar != null) {
                    cVar.bCT();
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
        this.hjq.add(stickerView);
        aTV();
        if (cVar != null) {
            cVar.bCS();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.hjq.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                aTV();
                if (cVar != null) {
                    cVar.bCT();
                }
            }
        }
    }

    public void aTV() {
        if (this.hjq.size() > 0) {
            for (StickerView stickerView : this.hjq) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.hjs);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap bEw() {
        if (v.w(this.hjq)) {
            return null;
        }
        aTV();
        return d.R(this);
    }

    public void setRemoveRes(int i) {
        this.hjs = i;
    }

    public List<StickerView> getStickerViews() {
        return this.hjq;
    }
}
