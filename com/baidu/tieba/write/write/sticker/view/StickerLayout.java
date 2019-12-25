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
/* loaded from: classes10.dex */
public class StickerLayout extends FrameLayout {
    private List<StickerView> kQW;
    private FrameLayout.LayoutParams kQX;
    private int kQY;
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
        this.kQW = new ArrayList();
        this.kQX = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.kQX);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void cUN() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.kQW.remove(stickerView);
                StickerLayout.this.cfU();
                if (cVar != null) {
                    cVar.cTj();
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
        this.kQW.add(stickerView);
        cfU();
        if (cVar != null) {
            cVar.cTi();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.kQW.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                cfU();
                if (cVar != null) {
                    cVar.cTj();
                }
            }
        }
    }

    public void cfU() {
        if (this.kQW.size() > 0) {
            for (StickerView stickerView : this.kQW) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.kQY);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap cUO() {
        if (v.isEmpty(this.kQW)) {
            return null;
        }
        cfU();
        return g.be(this);
    }

    public void setRemoveRes(int i) {
        this.kQY = i;
    }

    public List<StickerView> getStickerViews() {
        return this.kQW;
    }
}
