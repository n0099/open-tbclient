package com.baidu.tieba.video.editvideo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class CoverTextLayout extends LinearLayout {
    private TextView gvY;
    private TextView gvZ;
    private TextView gwa;
    private TextView gwb;
    private int gwc;
    private a gwd;
    private View.OnClickListener gwe;

    /* loaded from: classes2.dex */
    public interface a {
        void bI(View view);
    }

    public CoverTextLayout(Context context) {
        this(context, null);
    }

    public CoverTextLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoverTextLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gwe = new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverTextLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CoverTextLayout.this.gwd != null && view != null && (view.getTag() instanceof Integer)) {
                    CoverTextLayout.this.gwd.bI(view);
                    CoverTextLayout.this.gwc = ((Integer) view.getTag()).intValue();
                }
            }
        };
        LayoutInflater.from(getContext()).inflate(d.j.layout_cover_text, this);
        init();
    }

    private void init() {
        this.gvY = (TextView) findViewById(d.h.cover_text_no);
        this.gvZ = (TextView) findViewById(d.h.cover_text_blue);
        this.gwa = (TextView) findViewById(d.h.cover_text_black);
        this.gwb = (TextView) findViewById(d.h.cover_text_transparent);
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            childAt.setTag(Integer.valueOf(i));
            childAt.setOnClickListener(this.gwe);
        }
        this.gwc = 0;
    }

    public int getCurrentTextIndex() {
        return this.gwc;
    }

    public void setOnTextClickCallback(a aVar) {
        this.gwd = aVar;
    }
}
