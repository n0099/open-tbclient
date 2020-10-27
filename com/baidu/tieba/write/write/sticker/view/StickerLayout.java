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
    private List<StickerView> nJP;
    private FrameLayout.LayoutParams nJQ;
    private int nJR;

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
        this.nJP = new ArrayList();
        this.nJQ = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.nJQ);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void cIE() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.nJP.remove(stickerView);
                StickerLayout.this.ddN();
                if (cVar != null) {
                    cVar.dSu();
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
        this.nJP.add(stickerView);
        ddN();
        if (cVar != null) {
            cVar.dSt();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.nJP.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                ddN();
                if (cVar != null) {
                    cVar.dSu();
                }
            }
        }
    }

    public void ddN() {
        if (this.nJP.size() > 0) {
            for (StickerView stickerView : this.nJP) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.nJR);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap dUt() {
        if (y.isEmpty(this.nJP)) {
            return null;
        }
        ddN();
        return h.bC(this);
    }

    public void setRemoveRes(int i) {
        this.nJR = i;
    }

    public List<StickerView> getStickerViews() {
        return this.nJP;
    }
}
