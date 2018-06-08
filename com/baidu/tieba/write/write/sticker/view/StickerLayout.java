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
    private List<StickerView> hwp;
    private FrameLayout.LayoutParams hwq;
    private int hwr;
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
        this.hwp = new ArrayList();
        this.hwq = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.hwq);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void bJy() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.hwp.remove(stickerView);
                StickerLayout.this.aYR();
                if (cVar != null) {
                    cVar.bHW();
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
        this.hwp.add(stickerView);
        aYR();
        if (cVar != null) {
            cVar.bHV();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.hwp.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                aYR();
                if (cVar != null) {
                    cVar.bHW();
                }
            }
        }
    }

    public void aYR() {
        if (this.hwp.size() > 0) {
            for (StickerView stickerView : this.hwp) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.hwr);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap bJz() {
        if (w.z(this.hwp)) {
            return null;
        }
        aYR();
        return d.R(this);
    }

    public void setRemoveRes(int i) {
        this.hwr = i;
    }

    public List<StickerView> getStickerViews() {
        return this.hwp;
    }
}
