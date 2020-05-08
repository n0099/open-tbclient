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
    private List<StickerView> lHe;
    private FrameLayout.LayoutParams lHf;
    private int lHg;
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
        this.lHe = new ArrayList();
        this.lHf = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.lHf);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void dim() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.lHe.remove(stickerView);
                StickerLayout.this.ctH();
                if (cVar != null) {
                    cVar.dgH();
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
        this.lHe.add(stickerView);
        ctH();
        if (cVar != null) {
            cVar.dgG();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.lHe.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                ctH();
                if (cVar != null) {
                    cVar.dgH();
                }
            }
        }
    }

    public void ctH() {
        if (this.lHe.size() > 0) {
            for (StickerView stickerView : this.lHe) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.lHg);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap din() {
        if (v.isEmpty(this.lHe)) {
            return null;
        }
        ctH();
        return g.bj(this);
    }

    public void setRemoveRes(int i) {
        this.lHg = i;
    }

    public List<StickerView> getStickerViews() {
        return this.lHe;
    }
}
