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
/* loaded from: classes11.dex */
public class StickerLayout extends FrameLayout {
    private List<StickerView> kUx;
    private FrameLayout.LayoutParams kUy;
    private int kUz;
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
        this.kUx = new ArrayList();
        this.kUy = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.kUy);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void cVQ() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.kUx.remove(stickerView);
                StickerLayout.this.chc();
                if (cVar != null) {
                    cVar.cUm();
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
        this.kUx.add(stickerView);
        chc();
        if (cVar != null) {
            cVar.cUl();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.kUx.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                chc();
                if (cVar != null) {
                    cVar.cUm();
                }
            }
        }
    }

    public void chc() {
        if (this.kUx.size() > 0) {
            for (StickerView stickerView : this.kUx) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.kUz);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap cVR() {
        if (v.isEmpty(this.kUx)) {
            return null;
        }
        chc();
        return g.bi(this);
    }

    public void setRemoveRes(int i) {
        this.kUz = i;
    }

    public List<StickerView> getStickerViews() {
        return this.kUx;
    }
}
