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
    private List<StickerView> ogm;
    private FrameLayout.LayoutParams ogn;
    private int ogo;

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
        this.ogm = new ArrayList();
        this.ogn = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.ogn);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void cQb() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.ogm.remove(stickerView);
                StickerLayout.this.dkZ();
                if (cVar != null) {
                    cVar.eaq();
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
        this.ogm.add(stickerView);
        dkZ();
        if (cVar != null) {
            cVar.eap();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.ogm.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                dkZ();
                if (cVar != null) {
                    cVar.eaq();
                }
            }
        }
    }

    public void dkZ() {
        if (this.ogm.size() > 0) {
            for (StickerView stickerView : this.ogm) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.ogo);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap ecx() {
        if (y.isEmpty(this.ogm)) {
            return null;
        }
        dkZ();
        return h.bQ(this);
    }

    public void setRemoveRes(int i) {
        this.ogo = i;
    }

    public List<StickerView> getStickerViews() {
        return this.ogm;
    }
}
