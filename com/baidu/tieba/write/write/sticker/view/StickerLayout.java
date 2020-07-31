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
/* loaded from: classes3.dex */
public class StickerLayout extends FrameLayout {
    private Context mContext;
    private List<StickerView> mEA;
    private FrameLayout.LayoutParams mEB;
    private int mEC;

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
        this.mEA = new ArrayList();
        this.mEB = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.mEB);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void dxD() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.mEA.remove(stickerView);
                StickerLayout.this.cIB();
                if (cVar != null) {
                    cVar.dvS();
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
        this.mEA.add(stickerView);
        cIB();
        if (cVar != null) {
            cVar.dvR();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.mEA.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                cIB();
                if (cVar != null) {
                    cVar.dvS();
                }
            }
        }
    }

    public void cIB() {
        if (this.mEA.size() > 0) {
            for (StickerView stickerView : this.mEA) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.mEC);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap dxE() {
        if (x.isEmpty(this.mEA)) {
            return null;
        }
        cIB();
        return g.br(this);
    }

    public void setRemoveRes(int i) {
        this.mEC = i;
    }

    public List<StickerView> getStickerViews() {
        return this.mEA;
    }
}
