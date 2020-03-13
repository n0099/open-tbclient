package com.baidu.tieba.write.write.sticker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.g;
import com.baidu.tieba.write.write.sticker.a.a;
import com.baidu.tieba.write.write.sticker.a.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes13.dex */
public class StickerLayout extends FrameLayout {
    private List<StickerView> kVw;
    private FrameLayout.LayoutParams kVx;
    private int kVy;
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
        this.kVw = new ArrayList();
        this.kVx = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.kVx);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void cXj() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.kVw.remove(stickerView);
                StickerLayout.this.ciK();
                if (cVar != null) {
                    cVar.cVF();
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
        this.kVw.add(stickerView);
        ciK();
        if (cVar != null) {
            cVar.cVE();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.kVw.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                ciK();
                if (cVar != null) {
                    cVar.cVF();
                }
            }
        }
    }

    public void ciK() {
        if (this.kVw.size() > 0) {
            for (StickerView stickerView : this.kVw) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.kVy);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap cXk() {
        if (v.isEmpty(this.kVw)) {
            return null;
        }
        ciK();
        return g.bi(this);
    }

    public void setRemoveRes(int i) {
        this.kVy = i;
    }

    public List<StickerView> getStickerViews() {
        return this.kVw;
    }
}
