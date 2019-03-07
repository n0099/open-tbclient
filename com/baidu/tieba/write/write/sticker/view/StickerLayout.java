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
    private List<StickerView> jvr;
    private FrameLayout.LayoutParams jvs;
    private int jvt;
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
        this.jvr = new ArrayList();
        this.jvs = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.jvs);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void crE() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.jvr.remove(stickerView);
                StickerLayout.this.bGr();
                if (cVar != null) {
                    cVar.cqd();
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
        this.jvr.add(stickerView);
        bGr();
        if (cVar != null) {
            cVar.cqc();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.jvr.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                bGr();
                if (cVar != null) {
                    cVar.cqd();
                }
            }
        }
    }

    public void bGr() {
        if (this.jvr.size() > 0) {
            for (StickerView stickerView : this.jvr) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.jvt);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap crF() {
        if (v.T(this.jvr)) {
            return null;
        }
        bGr();
        return f.aZ(this);
    }

    public void setRemoveRes(int i) {
        this.jvt = i;
    }

    public List<StickerView> getStickerViews() {
        return this.jvr;
    }
}
