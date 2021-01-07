package com.baidu.yuyinala.privatemessage.session.view.smrlistview;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes11.dex */
public class SMView extends LinearLayout implements View.OnClickListener {
    private SMListView pfI;
    private SMLayout pfJ;
    private c pfK;
    private a pfL;
    private int position;

    /* loaded from: classes11.dex */
    public interface a {
        void a(SMView sMView, c cVar, int i);
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public SMView(c cVar, SMListView sMListView) {
        super(cVar.getContext());
        this.pfI = sMListView;
        this.pfK = cVar;
        int i = 0;
        for (e eVar : cVar.eoH()) {
            a(eVar, i);
            i++;
        }
    }

    private void a(e eVar, int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(eVar.getWidth(), -1);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setId(i);
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackgroundDrawable(eVar.getBackground());
        linearLayout.setOnClickListener(this);
        addView(linearLayout);
        if (eVar.getIcon() != null) {
            linearLayout.addView(a(eVar));
        }
        if (!TextUtils.isEmpty(eVar.getTitle())) {
            linearLayout.addView(b(eVar));
        }
    }

    private ImageView a(e eVar) {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageDrawable(eVar.getIcon());
        return imageView;
    }

    private TextView b(e eVar) {
        TextView textView = new TextView(getContext());
        textView.setText(eVar.getTitle());
        textView.setGravity(17);
        textView.setTextSize(eVar.getTitleSize());
        textView.setTextColor(eVar.getTitleColor());
        return textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.pfL != null && this.pfJ.isOpen()) {
            this.pfL.a(this, this.pfK, view.getId());
        }
    }

    public a getOnSwipeItemClickListener() {
        return this.pfL;
    }

    public void setOnSwipeItemClickListener(a aVar) {
        this.pfL = aVar;
    }

    public void setLayout(SMLayout sMLayout) {
        this.pfJ = sMLayout;
    }
}
