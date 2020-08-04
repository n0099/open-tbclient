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
    private List<StickerView> mEC;
    private FrameLayout.LayoutParams mED;
    private int mEE;

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
        this.mEC = new ArrayList();
        this.mED = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.mED);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void dxE() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.mEC.remove(stickerView);
                StickerLayout.this.cIB();
                if (cVar != null) {
                    cVar.dvT();
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
        this.mEC.add(stickerView);
        cIB();
        if (cVar != null) {
            cVar.dvS();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.mEC.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                cIB();
                if (cVar != null) {
                    cVar.dvT();
                }
            }
        }
    }

    public void cIB() {
        if (this.mEC.size() > 0) {
            for (StickerView stickerView : this.mEC) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.mEE);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap dxF() {
        if (x.isEmpty(this.mEC)) {
            return null;
        }
        cIB();
        return g.br(this);
    }

    public void setRemoveRes(int i) {
        this.mEE = i;
    }

    public List<StickerView> getStickerViews() {
        return this.mEC;
    }
}
