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
/* loaded from: classes13.dex */
public class StickerLayout extends FrameLayout {
    private List<StickerView> kWZ;
    private FrameLayout.LayoutParams kXa;
    private int kXb;
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
        this.kWZ = new ArrayList();
        this.kXa = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.kXa);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void cXH() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.kWZ.remove(stickerView);
                StickerLayout.this.cje();
                if (cVar != null) {
                    cVar.cWc();
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
        this.kWZ.add(stickerView);
        cje();
        if (cVar != null) {
            cVar.cWb();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.kWZ.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                cje();
                if (cVar != null) {
                    cVar.cWc();
                }
            }
        }
    }

    public void cje() {
        if (this.kWZ.size() > 0) {
            for (StickerView stickerView : this.kWZ) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.kXb);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap cXI() {
        if (v.isEmpty(this.kWZ)) {
            return null;
        }
        cje();
        return g.bi(this);
    }

    public void setRemoveRes(int i) {
        this.kXb = i;
    }

    public List<StickerView> getStickerViews() {
        return this.kWZ;
    }
}
