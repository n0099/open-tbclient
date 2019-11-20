package com.baidu.tieba.write.write.sticker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.f;
import com.baidu.tieba.write.write.sticker.a.a;
import com.baidu.tieba.write.write.sticker.a.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class StickerLayout extends FrameLayout {
    private List<StickerView> jWj;
    private FrameLayout.LayoutParams jWk;
    private int jWl;
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
        this.jWj = new ArrayList();
        this.jWk = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.jWk);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void cAM() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.jWj.remove(stickerView);
                StickerLayout.this.bOK();
                if (cVar != null) {
                    cVar.czj();
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
        this.jWj.add(stickerView);
        bOK();
        if (cVar != null) {
            cVar.czi();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.jWj.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                bOK();
                if (cVar != null) {
                    cVar.czj();
                }
            }
        }
    }

    public void bOK() {
        if (this.jWj.size() > 0) {
            for (StickerView stickerView : this.jWj) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.jWl);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap cAN() {
        if (v.isEmpty(this.jWj)) {
            return null;
        }
        bOK();
        return f.bh(this);
    }

    public void setRemoveRes(int i) {
        this.jWl = i;
    }

    public List<StickerView> getStickerViews() {
        return this.jWj;
    }
}
