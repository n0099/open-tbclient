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
    private List<StickerView> nxr;
    private FrameLayout.LayoutParams nxs;
    private int nxt;

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
        this.nxr = new ArrayList();
        this.nxs = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.nxs);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void cFx() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.nxr.remove(stickerView);
                StickerLayout.this.daF();
                if (cVar != null) {
                    cVar.dPm();
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
        this.nxr.add(stickerView);
        daF();
        if (cVar != null) {
            cVar.dPl();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.nxr.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                daF();
                if (cVar != null) {
                    cVar.dPm();
                }
            }
        }
    }

    public void daF() {
        if (this.nxr.size() > 0) {
            for (StickerView stickerView : this.nxr) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.nxt);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap dRl() {
        if (y.isEmpty(this.nxr)) {
            return null;
        }
        daF();
        return h.bB(this);
    }

    public void setRemoveRes(int i) {
        this.nxt = i;
    }

    public List<StickerView> getStickerViews() {
        return this.nxr;
    }
}
