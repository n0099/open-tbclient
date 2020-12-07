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
    private List<StickerView> ogk;
    private FrameLayout.LayoutParams ogl;
    private int ogm;

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
        this.ogk = new ArrayList();
        this.ogl = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.ogl);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void cQa() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.ogk.remove(stickerView);
                StickerLayout.this.dkY();
                if (cVar != null) {
                    cVar.eap();
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
        this.ogk.add(stickerView);
        dkY();
        if (cVar != null) {
            cVar.eao();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.ogk.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                dkY();
                if (cVar != null) {
                    cVar.eap();
                }
            }
        }
    }

    public void dkY() {
        if (this.ogk.size() > 0) {
            for (StickerView stickerView : this.ogk) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.ogm);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap ecw() {
        if (y.isEmpty(this.ogk)) {
            return null;
        }
        dkY();
        return h.bQ(this);
    }

    public void setRemoveRes(int i) {
        this.ogm = i;
    }

    public List<StickerView> getStickerViews() {
        return this.ogk;
    }
}
