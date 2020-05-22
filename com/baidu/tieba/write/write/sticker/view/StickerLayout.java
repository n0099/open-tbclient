package com.baidu.tieba.write.write.sticker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.g;
import com.baidu.tieba.write.write.sticker.a.a;
import com.baidu.tieba.write.write.sticker.a.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class StickerLayout extends FrameLayout {
    private Context mContext;
    private List<StickerView> mau;
    private FrameLayout.LayoutParams mav;
    private int maw;

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
        this.mau = new ArrayList();
        this.mav = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.mav);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void dpE() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.mau.remove(stickerView);
                StickerLayout.this.cAk();
                if (cVar != null) {
                    cVar.dnZ();
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
        this.mau.add(stickerView);
        cAk();
        if (cVar != null) {
            cVar.dnY();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.mau.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                cAk();
                if (cVar != null) {
                    cVar.dnZ();
                }
            }
        }
    }

    public void cAk() {
        if (this.mau.size() > 0) {
            for (StickerView stickerView : this.mau) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.maw);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap dpF() {
        if (v.isEmpty(this.mau)) {
            return null;
        }
        cAk();
        return g.bk(this);
    }

    public void setRemoveRes(int i) {
        this.maw = i;
    }

    public List<StickerView> getStickerViews() {
        return this.mau;
    }
}
