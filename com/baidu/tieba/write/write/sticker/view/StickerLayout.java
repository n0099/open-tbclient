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
/* loaded from: classes7.dex */
public class StickerLayout extends FrameLayout {
    private Context mContext;
    private List<StickerView> opJ;
    private FrameLayout.LayoutParams opK;
    private int opL;

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
        this.opJ = new ArrayList();
        this.opK = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.opK);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void cRD() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.opJ.remove(stickerView);
                StickerLayout.this.djj();
                if (cVar != null) {
                    cVar.dYj();
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
        this.opJ.add(stickerView);
        djj();
        if (cVar != null) {
            cVar.dYi();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.opJ.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                djj();
                if (cVar != null) {
                    cVar.dYj();
                }
            }
        }
    }

    public void djj() {
        if (this.opJ.size() > 0) {
            for (StickerView stickerView : this.opJ) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.opL);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap ead() {
        if (y.isEmpty(this.opJ)) {
            return null;
        }
        djj();
        return h.bV(this);
    }

    public void setRemoveRes(int i) {
        this.opL = i;
    }

    public List<StickerView> getStickerViews() {
        return this.opJ;
    }
}
