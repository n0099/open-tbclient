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
    private List<StickerView> hBI;
    private FrameLayout.LayoutParams hBJ;
    private int hBK;
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
        this.hBI = new ArrayList();
        this.hBJ = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.hBJ);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void bIQ() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.hBI.remove(stickerView);
                StickerLayout.this.aXO();
                if (cVar != null) {
                    cVar.bHn();
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
        this.hBI.add(stickerView);
        aXO();
        if (cVar != null) {
            cVar.bHm();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.hBI.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                aXO();
                if (cVar != null) {
                    cVar.bHn();
                }
            }
        }
    }

    public void aXO() {
        if (this.hBI.size() > 0) {
            for (StickerView stickerView : this.hBI) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.hBK);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap bIR() {
        if (w.z(this.hBI)) {
            return null;
        }
        aXO();
        return d.S(this);
    }

    public void setRemoveRes(int i) {
        this.hBK = i;
    }

    public List<StickerView> getStickerViews() {
        return this.hBI;
    }
}
