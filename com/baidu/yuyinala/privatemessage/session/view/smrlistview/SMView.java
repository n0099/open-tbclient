package com.baidu.yuyinala.privatemessage.session.view.smrlistview;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes10.dex */
public class SMView extends LinearLayout implements View.OnClickListener {
    private SMListView poa;
    private SMLayout pob;
    private c poc;
    private a pod;
    private int position;

    /* loaded from: classes10.dex */
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
        this.poa = sMListView;
        this.poc = cVar;
        int i = 0;
        for (e eVar : cVar.enw()) {
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
        if (this.pod != null && this.pob.isOpen()) {
            this.pod.a(this, this.poc, view.getId());
        }
    }

    public a getOnSwipeItemClickListener() {
        return this.pod;
    }

    public void setOnSwipeItemClickListener(a aVar) {
        this.pod = aVar;
    }

    public void setLayout(SMLayout sMLayout) {
        this.pob = sMLayout;
    }
}
