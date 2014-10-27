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
    final /* synthetic */ ChatterboxDialog bjf;
    private View mView = null;
    private LinearLayout mLayout = null;
    private TextView aey = null;
    private ImageView bjg = null;
    private String bjh = null;

    public b(ChatterboxDialog chatterboxDialog, Context context) {
        this.bjf = chatterboxDialog;
        init(context);
    }

    private void init(Context context) {
        this.mView = com.baidu.adp.lib.g.b.ek().inflate(context, w.chatterbox_dialog_item, null);
        this.aey = (TextView) this.mView.findViewById(v.chatterbox_text);
        this.mLayout = (LinearLayout) this.mView.findViewById(v.chatterbox_item_layout);
        this.bjg = (ImageView) this.mView.findViewById(v.chatterbox_selected);
    }

    public boolean M(View view) {
        return this.mLayout.equals(view);
    }

    public void setIsSelected(boolean z) {
        if (z) {
            this.bjg.setVisibility(0);
        } else {
            this.bjg.setVisibility(8);
        }
    }

    public String getContent() {
        return this.bjh;
    }

    public void setContent(String str) {
        this.bjh = str;
    }

    public void setText(String str) {
        this.aey.setText(str);
    }

    public String getText() {
        CharSequence text = this.aey.getText();
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
