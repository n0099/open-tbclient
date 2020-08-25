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
    private List<StickerView> mXC;
    private FrameLayout.LayoutParams mXD;
    private int mXE;

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
        this.mXC = new ArrayList();
        this.mXD = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.mXD);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void cyf() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.mXC.remove(stickerView);
                StickerLayout.this.cTq();
                if (cVar != null) {
                    cVar.dHw();
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
        this.mXC.add(stickerView);
        cTq();
        if (cVar != null) {
            cVar.dHv();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.mXC.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                cTq();
                if (cVar != null) {
                    cVar.dHw();
                }
            }
        }
    }

    public void cTq() {
        if (this.mXC.size() > 0) {
            for (StickerView stickerView : this.mXC) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.mXE);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap dJs() {
        if (y.isEmpty(this.mXC)) {
            return null;
        }
        cTq();
        return g.bt(this);
    }

    public void setRemoveRes(int i) {
        this.mXE = i;
    }

    public List<StickerView> getStickerViews() {
        return this.mXC;
    }
}
