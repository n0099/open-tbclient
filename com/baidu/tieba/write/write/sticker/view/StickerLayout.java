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
    private List<StickerView> mwt;
    private FrameLayout.LayoutParams mwu;
    private int mwv;

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
        this.mwt = new ArrayList();
        this.mwu = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.mwu);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void dun() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.mwt.remove(stickerView);
                StickerLayout.this.cER();
                if (cVar != null) {
                    cVar.dsC();
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
        this.mwt.add(stickerView);
        cER();
        if (cVar != null) {
            cVar.dsB();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.mwt.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                cER();
                if (cVar != null) {
                    cVar.dsC();
                }
            }
        }
    }

    public void cER() {
        if (this.mwt.size() > 0) {
            for (StickerView stickerView : this.mwt) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.mwv);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap duo() {
        if (w.isEmpty(this.mwt)) {
            return null;
        }
        cER();
        return g.bl(this);
    }

    public void setRemoveRes(int i) {
        this.mwv = i;
    }

    public List<StickerView> getStickerViews() {
        return this.mwt;
    }
}
