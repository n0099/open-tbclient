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
    private List<StickerView> jvC;
    private FrameLayout.LayoutParams jvD;
    private int jvE;
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
        this.jvC = new ArrayList();
        this.jvD = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.jvD);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void crR() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.jvC.remove(stickerView);
                StickerLayout.this.bGr();
                if (cVar != null) {
                    cVar.cqq();
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
        this.jvC.add(stickerView);
        bGr();
        if (cVar != null) {
            cVar.cqp();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.jvC.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                bGr();
                if (cVar != null) {
                    cVar.cqq();
                }
            }
        }
    }

    public void bGr() {
        if (this.jvC.size() > 0) {
            for (StickerView stickerView : this.jvC) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.jvE);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap crS() {
        if (v.T(this.jvC)) {
            return null;
        }
        bGr();
        return f.aZ(this);
    }

    public void setRemoveRes(int i) {
        this.jvE = i;
    }

    public List<StickerView> getStickerViews() {
        return this.jvC;
    }
}
