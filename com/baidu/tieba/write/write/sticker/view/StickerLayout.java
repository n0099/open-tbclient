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
    private List<StickerView> ieH;
    private FrameLayout.LayoutParams ieI;
    private int ieJ;
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
        this.ieH = new ArrayList();
        this.ieI = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.ieI);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void bRV() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.ieH.remove(stickerView);
                StickerLayout.this.bfO();
                if (cVar != null) {
                    cVar.bQt();
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
        this.ieH.add(stickerView);
        bfO();
        if (cVar != null) {
            cVar.bQs();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.ieH.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                bfO();
                if (cVar != null) {
                    cVar.bQt();
                }
            }
        }
    }

    public void bfO() {
        if (this.ieH.size() > 0) {
            for (StickerView stickerView : this.ieH) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.ieJ);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap bRW() {
        if (v.I(this.ieH)) {
            return null;
        }
        bfO();
        return e.ae(this);
    }

    public void setRemoveRes(int i) {
        this.ieJ = i;
    }

    public List<StickerView> getStickerViews() {
        return this.ieH;
    }
}
