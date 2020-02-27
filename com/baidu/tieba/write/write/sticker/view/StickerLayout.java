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
    private List<StickerView> kVi;
    private FrameLayout.LayoutParams kVj;
    private int kVk;
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
        this.kVi = new ArrayList();
        this.kVj = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.kVj);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void cXg() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.kVi.remove(stickerView);
                StickerLayout.this.ciH();
                if (cVar != null) {
                    cVar.cVC();
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
        this.kVi.add(stickerView);
        ciH();
        if (cVar != null) {
            cVar.cVB();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.kVi.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                ciH();
                if (cVar != null) {
                    cVar.cVC();
                }
            }
        }
    }

    public void ciH() {
        if (this.kVi.size() > 0) {
            for (StickerView stickerView : this.kVi) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.kVk);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap cXh() {
        if (v.isEmpty(this.kVi)) {
            return null;
        }
        ciH();
        return g.bi(this);
    }

    public void setRemoveRes(int i) {
        this.kVk = i;
    }

    public List<StickerView> getStickerViews() {
        return this.kVi;
    }
}
