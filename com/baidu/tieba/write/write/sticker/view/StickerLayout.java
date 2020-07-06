package com.baidu.tieba.write.write.sticker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.util.g;
import com.baidu.tieba.write.write.sticker.a.a;
import com.baidu.tieba.write.write.sticker.a.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class StickerLayout extends FrameLayout {
    private Context mContext;
    private List<StickerView> mww;
    private FrameLayout.LayoutParams mwx;
    private int mwy;

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
        this.mww = new ArrayList();
        this.mwx = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.mwx);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void dur() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.mww.remove(stickerView);
                StickerLayout.this.cES();
                if (cVar != null) {
                    cVar.dsG();
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
        this.mww.add(stickerView);
        cES();
        if (cVar != null) {
            cVar.dsF();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.mww.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                cES();
                if (cVar != null) {
                    cVar.dsG();
                }
            }
        }
    }

    public void cES() {
        if (this.mww.size() > 0) {
            for (StickerView stickerView : this.mww) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.mwy);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap dus() {
        if (w.isEmpty(this.mww)) {
            return null;
        }
        cES();
        return g.bl(this);
    }

    public void setRemoveRes(int i) {
        this.mwy = i;
    }

    public List<StickerView> getStickerViews() {
        return this.mww;
    }
}
