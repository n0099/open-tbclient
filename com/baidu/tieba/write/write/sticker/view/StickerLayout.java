package com.baidu.tieba.write.write.sticker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.util.g;
import com.baidu.tieba.write.write.sticker.a.a;
import com.baidu.tieba.write.write.sticker.a.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class StickerLayout extends FrameLayout {
    private Context mContext;
    private List<StickerView> odl;
    private FrameLayout.LayoutParams odm;
    private int odn;

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
        this.odl = new ArrayList();
        this.odm = new FrameLayout.LayoutParams(-1, -1);
    }

    public StickerView a(Bitmap bitmap, final c cVar) {
        final StickerView stickerView = new StickerView(this.mContext);
        stickerView.setImageBitmap(bitmap);
        stickerView.setLayoutParams(this.odm);
        stickerView.setmOnStickerActionListener(new a() { // from class: com.baidu.tieba.write.write.sticker.view.StickerLayout.1
            @Override // com.baidu.tieba.write.write.sticker.a.a
            public void cPq() {
                StickerLayout.this.removeView(stickerView);
                StickerLayout.this.odl.remove(stickerView);
                StickerLayout.this.dgS();
                if (cVar != null) {
                    cVar.dVI();
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
        this.odl.add(stickerView);
        dgS();
        if (cVar != null) {
            cVar.dVH();
        }
        return stickerView;
    }

    public void a(c cVar) {
        Iterator<StickerView> it = this.odl.iterator();
        while (it.hasNext()) {
            StickerView next = it.next();
            if (next != null) {
                removeView(next);
                it.remove();
                dgS();
                if (cVar != null) {
                    cVar.dVI();
                }
            }
        }
    }

    public void dgS() {
        if (this.odl.size() > 0) {
            for (StickerView stickerView : this.odl) {
                if (stickerView != null) {
                    stickerView.setRemoveRes(this.odn);
                    stickerView.setEdit(false);
                }
            }
        }
    }

    public Bitmap dXC() {
        if (x.isEmpty(this.odl)) {
            return null;
        }
        dgS();
        return g.bZ(this);
    }

    public void setRemoveRes(int i) {
        this.odn = i;
    }

    public List<StickerView> getStickerViews() {
        return this.odl;
    }
}
