package com.baidu.tieba.write.write.sticker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.e;
import com.baidu.tieba.write.write.sticker.a.a;
import com.baidu.tieba.write.write.sticker.a.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class StickerLayout extends FrameLayout {
    private List<StickerView> hKf;
    private FrameLayout.LayoutParams hKg;
    private int hKh;
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
        this.hKf = new ArrayList();
        this.hKg = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.hKg);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void bLH() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.hKf.remove(stickerView);
                StickerLayout.this.bab();
                if (cVar != null) {
                    cVar.bKe();
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
        this.hKf.add(stickerView);
        bab();
        if (cVar != null) {
            cVar.bKd();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.hKf.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                bab();
                if (cVar != null) {
                    cVar.bKe();
                }
            }
        }
    }

    public void bab() {
        if (this.hKf.size() > 0) {
            for (StickerView stickerView : this.hKf) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.hKh);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap bLI() {
        if (v.z(this.hKf)) {
            return null;
        }
        bab();
        return e.af(this);
    }

    public void setRemoveRes(int i) {
        this.hKh = i;
    }

    public List<StickerView> getStickerViews() {
        return this.hKf;
    }
}
