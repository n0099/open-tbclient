package com.baidu.tieba.write.write.sticker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.f;
import com.baidu.tieba.write.write.sticker.a.a;
import com.baidu.tieba.write.write.sticker.a.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class StickerLayout extends FrameLayout {
    private List<StickerView> jvt;
    private FrameLayout.LayoutParams jvu;
    private int jvv;
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
        this.jvt = new ArrayList();
        this.jvu = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.jvu);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void crP() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.jvt.remove(stickerView);
                StickerLayout.this.bGo();
                if (cVar != null) {
                    cVar.cqo();
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
        this.jvt.add(stickerView);
        bGo();
        if (cVar != null) {
            cVar.cqn();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.jvt.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                bGo();
                if (cVar != null) {
                    cVar.cqo();
                }
            }
        }
    }

    public void bGo() {
        if (this.jvt.size() > 0) {
            for (StickerView stickerView : this.jvt) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.jvv);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap crQ() {
        if (v.T(this.jvt)) {
            return null;
        }
        bGo();
        return f.aZ(this);
    }

    public void setRemoveRes(int i) {
        this.jvv = i;
    }

    public List<StickerView> getStickerViews() {
        return this.jvt;
    }
}
