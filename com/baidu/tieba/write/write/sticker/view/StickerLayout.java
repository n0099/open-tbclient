package com.baidu.tieba.write.write.sticker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.util.g;
import com.baidu.tieba.write.write.sticker.a.a;
import com.baidu.tieba.write.write.sticker.a.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class StickerLayout extends FrameLayout {
    private Context mContext;
    private List<StickerView> mXU;
    private FrameLayout.LayoutParams mXV;
    private int mXW;

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
        this.mXU = new ArrayList();
        this.mXV = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.mXV);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void cyg() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.mXU.remove(stickerView);
                StickerLayout.this.cTr();
                if (cVar != null) {
                    cVar.dHF();
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
        this.mXU.add(stickerView);
        cTr();
        if (cVar != null) {
            cVar.dHE();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.mXU.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                cTr();
                if (cVar != null) {
                    cVar.dHF();
                }
            }
        }
    }

    public void cTr() {
        if (this.mXU.size() > 0) {
            for (StickerView stickerView : this.mXU) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.mXW);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap dJB() {
        if (y.isEmpty(this.mXU)) {
            return null;
        }
        cTr();
        return g.bt(this);
    }

    public void setRemoveRes(int i) {
        this.mXW = i;
    }

    public List<StickerView> getStickerViews() {
        return this.mXU;
    }
}
