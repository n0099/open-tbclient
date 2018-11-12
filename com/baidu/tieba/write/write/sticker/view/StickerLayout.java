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
    private List<StickerView> hTc;
    private FrameLayout.LayoutParams hTd;
    private int hTe;
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
        this.hTc = new ArrayList();
        this.hTd = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.hTd);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void bOr() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.hTc.remove(stickerView);
                StickerLayout.this.bcM();
                if (cVar != null) {
                    cVar.bMP();
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
        this.hTc.add(stickerView);
        bcM();
        if (cVar != null) {
            cVar.bMO();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.hTc.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                bcM();
                if (cVar != null) {
                    cVar.bMP();
                }
            }
        }
    }

    public void bcM() {
        if (this.hTc.size() > 0) {
            for (StickerView stickerView : this.hTc) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.hTe);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap bOs() {
        if (v.I(this.hTc)) {
            return null;
        }
        bcM();
        return e.ae(this);
    }

    public void setRemoveRes(int i) {
        this.hTe = i;
    }

    public List<StickerView> getStickerViews() {
        return this.hTc;
    }
}
