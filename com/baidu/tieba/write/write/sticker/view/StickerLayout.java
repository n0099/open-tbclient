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
/* loaded from: classes3.dex */
public class StickerLayout extends FrameLayout {
    private Context mContext;
    private List<StickerView> nPJ;
    private FrameLayout.LayoutParams nPK;
    private int nPL;

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
        this.nPJ = new ArrayList();
        this.nPK = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.nPK);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void cLf() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.nPJ.remove(stickerView);
                StickerLayout.this.dgp();
                if (cVar != null) {
                    cVar.dUU();
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
        this.nPJ.add(stickerView);
        dgp();
        if (cVar != null) {
            cVar.dUT();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.nPJ.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                dgp();
                if (cVar != null) {
                    cVar.dUU();
                }
            }
        }
    }

    public void dgp() {
        if (this.nPJ.size() > 0) {
            for (StickerView stickerView : this.nPJ) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.nPL);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap dWT() {
        if (y.isEmpty(this.nPJ)) {
            return null;
        }
        dgp();
        return h.bG(this);
    }

    public void setRemoveRes(int i) {
        this.nPL = i;
    }

    public List<StickerView> getStickerViews() {
        return this.nPJ;
    }
}
