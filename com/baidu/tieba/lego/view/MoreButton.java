package com.baidu.tieba.lego.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.model.c;
import com.baidu.tieba.tbadkCore.v;
/* loaded from: classes9.dex */
public class MoreButton extends TextView {
    public MoreButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MoreButton(Context context) {
        super(context, null, 0);
    }

    public MoreButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setData(final c cVar, final TbPageContext tbPageContext) {
        if (cVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        setText(cVar.ddC());
        if (!TextUtils.isEmpty(cVar.ddE())) {
            setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.view.MoreButton.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    v.h(tbPageContext, cVar.ddE());
                }
            });
        } else {
            setOnClickListener(null);
        }
    }
}
