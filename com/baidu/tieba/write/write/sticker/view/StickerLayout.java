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
/* loaded from: classes3.dex */
public class StickerLayout extends FrameLayout {
    private Context mContext;
    private List<StickerView> nhS;
    private FrameLayout.LayoutParams nhT;
    private int nhU;

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
        this.nhS = new ArrayList();
        this.nhT = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.nhT);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void cBO() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.nhS.remove(stickerView);
                StickerLayout.this.cWW();
                if (cVar != null) {
                    cVar.dLA();
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
        this.nhS.add(stickerView);
        cWW();
        if (cVar != null) {
            cVar.dLz();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.nhS.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                cWW();
                if (cVar != null) {
                    cVar.dLA();
                }
            }
        }
    }

    public void cWW() {
        if (this.nhS.size() > 0) {
            for (StickerView stickerView : this.nhS) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.nhU);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap dNz() {
        if (y.isEmpty(this.nhS)) {
            return null;
        }
        cWW();
        return h.bx(this);
    }

    public void setRemoveRes(int i) {
        this.nhU = i;
    }

    public List<StickerView> getStickerViews() {
        return this.nhS;
    }
}
