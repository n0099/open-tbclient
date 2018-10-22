package com.baidu.tieba.write.write.sticker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.e;
import com.baidu.tieba.write.write.sticker.a.a;
import com.baidu.tieba.write.write.sticker.a.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class StickerLayout extends FrameLayout {
    private List<StickerView> hRs;
    private FrameLayout.LayoutParams hRt;
    private int hRu;
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
        this.hRs = new ArrayList();
        this.hRt = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.hRt);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void bOS() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.hRs.remove(stickerView);
                StickerLayout.this.bdn();
                if (cVar != null) {
                    cVar.bNq();
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
        this.hRs.add(stickerView);
        bdn();
        if (cVar != null) {
            cVar.bNp();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.hRs.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                bdn();
                if (cVar != null) {
                    cVar.bNq();
                }
            }
        }
    }

    public void bdn() {
        if (this.hRs.size() > 0) {
            for (StickerView stickerView : this.hRs) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.hRu);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap bOT() {
        if (v.J(this.hRs)) {
            return null;
        }
        bdn();
        return e.af(this);
    }

    public void setRemoveRes(int i) {
        this.hRu = i;
    }

    public List<StickerView> getStickerViews() {
        return this.hRs;
    }
}
