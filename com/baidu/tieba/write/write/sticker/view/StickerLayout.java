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
    private int hAA;
    private List<StickerView> hAy;
    private FrameLayout.LayoutParams hAz;
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
        this.hAy = new ArrayList();
        this.hAz = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.hAz);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void bJZ() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.hAy.remove(stickerView);
                StickerLayout.this.aZy();
                if (cVar != null) {
                    cVar.bIx();
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
        this.hAy.add(stickerView);
        aZy();
        if (cVar != null) {
            cVar.bIw();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.hAy.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                aZy();
                if (cVar != null) {
                    cVar.bIx();
                }
            }
        }
    }

    public void aZy() {
        if (this.hAy.size() > 0) {
            for (StickerView stickerView : this.hAy) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.hAA);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap bKa() {
        if (w.A(this.hAy)) {
            return null;
        }
        aZy();
        return d.S(this);
    }

    public void setRemoveRes(int i) {
        this.hAA = i;
    }

    public List<StickerView> getStickerViews() {
        return this.hAy;
    }
}
