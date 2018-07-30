package com.baidu.tieba.write.write.sticker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.util.d;
import com.baidu.tieba.write.write.sticker.a.a;
import com.baidu.tieba.write.write.sticker.a.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class StickerLayout extends FrameLayout {
    private List<StickerView> hBG;
    private FrameLayout.LayoutParams hBH;
    private int hBI;
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
        this.hBG = new ArrayList();
        this.hBH = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.hBH);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void bIM() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.hBG.remove(stickerView);
                StickerLayout.this.aXT();
                if (cVar != null) {
                    cVar.bHj();
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
        this.hBG.add(stickerView);
        aXT();
        if (cVar != null) {
            cVar.bHi();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.hBG.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                aXT();
                if (cVar != null) {
                    cVar.bHj();
                }
            }
        }
    }

    public void aXT() {
        if (this.hBG.size() > 0) {
            for (StickerView stickerView : this.hBG) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.hBI);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap bIN() {
        if (w.z(this.hBG)) {
            return null;
        }
        aXT();
        return d.S(this);
    }

    public void setRemoveRes(int i) {
        this.hBI = i;
    }

    public List<StickerView> getStickerViews() {
        return this.hBG;
    }
}
