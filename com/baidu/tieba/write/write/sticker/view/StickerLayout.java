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
/* loaded from: classes2.dex */
public class StickerLayout extends FrameLayout {
    private Context mContext;
    private List<StickerView> mbF;
    private FrameLayout.LayoutParams mbG;
    private int mbH;

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
        this.mbF = new ArrayList();
        this.mbG = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.mbG);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void dpS() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.mbF.remove(stickerView);
                StickerLayout.this.cAB();
                if (cVar != null) {
                    cVar.doo();
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
        this.mbF.add(stickerView);
        cAB();
        if (cVar != null) {
            cVar.don();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.mbF.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                cAB();
                if (cVar != null) {
                    cVar.doo();
                }
            }
        }
    }

    public void cAB() {
        if (this.mbF.size() > 0) {
            for (StickerView stickerView : this.mbF) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.mbH);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap dpT() {
        if (v.isEmpty(this.mbF)) {
            return null;
        }
        cAB();
        return g.bk(this);
    }

    public void setRemoveRes(int i) {
        this.mbH = i;
    }

    public List<StickerView> getStickerViews() {
        return this.mbF;
    }
}
