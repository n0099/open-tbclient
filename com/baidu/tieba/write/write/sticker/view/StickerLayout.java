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
/* loaded from: classes2.dex */
public class StickerLayout extends FrameLayout {
    private List<StickerView> lHa;
    private FrameLayout.LayoutParams lHb;
    private int lHc;
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
        this.lHa = new ArrayList();
        this.lHb = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.lHb);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void dip() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.lHa.remove(stickerView);
                StickerLayout.this.ctK();
                if (cVar != null) {
                    cVar.dgK();
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
        this.lHa.add(stickerView);
        ctK();
        if (cVar != null) {
            cVar.dgJ();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.lHa.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                ctK();
                if (cVar != null) {
                    cVar.dgK();
                }
            }
        }
    }

    public void ctK() {
        if (this.lHa.size() > 0) {
            for (StickerView stickerView : this.lHa) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.lHc);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap diq() {
        if (v.isEmpty(this.lHa)) {
            return null;
        }
        ctK();
        return g.bj(this);
    }

    public void setRemoveRes(int i) {
        this.lHc = i;
    }

    public List<StickerView> getStickerViews() {
        return this.lHa;
    }
}
