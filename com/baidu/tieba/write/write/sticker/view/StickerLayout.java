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
    private List<StickerView> iam;
    private FrameLayout.LayoutParams ian;
    private int iao;
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
        this.iam = new ArrayList();
        this.ian = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.ian);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void bQx() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.iam.remove(stickerView);
                StickerLayout.this.beD();
                if (cVar != null) {
                    cVar.bOV();
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
        this.iam.add(stickerView);
        beD();
        if (cVar != null) {
            cVar.bOU();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.iam.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                beD();
                if (cVar != null) {
                    cVar.bOV();
                }
            }
        }
    }

    public void beD() {
        if (this.iam.size() > 0) {
            for (StickerView stickerView : this.iam) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.iao);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap bQy() {
        if (v.I(this.iam)) {
            return null;
        }
        beD();
        return e.ae(this);
    }

    public void setRemoveRes(int i) {
        this.iao = i;
    }

    public List<StickerView> getStickerViews() {
        return this.iam;
    }
}
