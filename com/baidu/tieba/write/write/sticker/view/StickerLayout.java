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
    private FrameLayout.LayoutParams idA;
    private int idB;
    private List<StickerView> idz;
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
        this.idz = new ArrayList();
        this.idA = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.idA);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void bRn() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.idz.remove(stickerView);
                StickerLayout.this.bfo();
                if (cVar != null) {
                    cVar.bPL();
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
        this.idz.add(stickerView);
        bfo();
        if (cVar != null) {
            cVar.bPK();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.idz.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                bfo();
                if (cVar != null) {
                    cVar.bPL();
                }
            }
        }
    }

    public void bfo() {
        if (this.idz.size() > 0) {
            for (StickerView stickerView : this.idz) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.idB);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap bRo() {
        if (v.I(this.idz)) {
            return null;
        }
        bfo();
        return e.ae(this);
    }

    public void setRemoveRes(int i) {
        this.idB = i;
    }

    public List<StickerView> getStickerViews() {
        return this.idz;
    }
}
