package com.baidu.tieba.write.write.sticker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.util.g;
import com.baidu.tieba.write.write.sticker.a.a;
import com.baidu.tieba.write.write.sticker.a.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class StickerLayout extends FrameLayout {
    private Context mContext;
    private List<StickerView> ohR;
    private FrameLayout.LayoutParams ohS;
    private int ohT;

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
        this.ohR = new ArrayList();
        this.ohS = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.ohS);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void cTh() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.ohR.remove(stickerView);
                StickerLayout.this.dkJ();
                if (cVar != null) {
                    cVar.dZz();
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
        this.ohR.add(stickerView);
        dkJ();
        if (cVar != null) {
            cVar.dZy();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.ohR.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                dkJ();
                if (cVar != null) {
                    cVar.dZz();
                }
            }
        }
    }

    public void dkJ() {
        if (this.ohR.size() > 0) {
            for (StickerView stickerView : this.ohR) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.ohT);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap ebt() {
        if (x.isEmpty(this.ohR)) {
            return null;
        }
        dkJ();
        return g.bZ(this);
    }

    public void setRemoveRes(int i) {
        this.ohT = i;
    }

    public List<StickerView> getStickerViews() {
        return this.ohR;
    }
}
