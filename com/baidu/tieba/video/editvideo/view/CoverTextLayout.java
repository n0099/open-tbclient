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
    private TextView gvK;
    private TextView gvL;
    private TextView gvM;
    private TextView gvN;
    private int gvO;
    private a gvP;
    private View.OnClickListener gvQ;

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
        this.gvQ = new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.CoverTextLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CoverTextLayout.this.gvP != null && view != null && (view.getTag() instanceof Integer)) {
                    CoverTextLayout.this.gvP.bI(view);
                    CoverTextLayout.this.gvO = ((Integer) view.getTag()).intValue();
                }
            }
        };
        LayoutInflater.from(getContext()).inflate(d.j.layout_cover_text, this);
        init();
    }

    private void init() {
        this.gvK = (TextView) findViewById(d.h.cover_text_no);
        this.gvL = (TextView) findViewById(d.h.cover_text_blue);
        this.gvM = (TextView) findViewById(d.h.cover_text_black);
        this.gvN = (TextView) findViewById(d.h.cover_text_transparent);
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            childAt.setTag(Integer.valueOf(i));
            childAt.setOnClickListener(this.gvQ);
        }
        this.gvO = 0;
    }

    public int getCurrentTextIndex() {
        return this.gvO;
    }

    public void setOnTextClickCallback(a aVar) {
        this.gvP = aVar;
    }
}
