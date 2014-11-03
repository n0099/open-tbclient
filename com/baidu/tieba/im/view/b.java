package com.baidu.tieba.im.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class b {
    final /* synthetic */ ChatterboxDialog bjt;
    private View mView = null;
    private LinearLayout mLayout = null;
    private TextView aeG = null;
    private ImageView bju = null;
    private String bjv = null;

    public b(ChatterboxDialog chatterboxDialog, Context context) {
        this.bjt = chatterboxDialog;
        init(context);
    }

    private void init(Context context) {
        this.mView = com.baidu.adp.lib.g.b.ek().inflate(context, w.chatterbox_dialog_item, null);
        this.aeG = (TextView) this.mView.findViewById(v.chatterbox_text);
        this.mLayout = (LinearLayout) this.mView.findViewById(v.chatterbox_item_layout);
        this.bju = (ImageView) this.mView.findViewById(v.chatterbox_selected);
    }

    public boolean M(View view) {
        return this.mLayout.equals(view);
    }

    public void setIsSelected(boolean z) {
        if (z) {
            this.bju.setVisibility(0);
        } else {
            this.bju.setVisibility(8);
        }
    }

    public String getContent() {
        return this.bjv;
    }

    public void setContent(String str) {
        this.bjv = str;
    }

    public void setText(String str) {
        this.aeG.setText(str);
    }

    public String getText() {
        CharSequence text = this.aeG.getText();
        if (text != null) {
            return text.toString();
        }
        return null;
    }

    public View getView() {
        return this.mView;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mLayout.setOnClickListener(onClickListener);
    }
}
