package com.baidu.tieba.square.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.atomData.CaptureActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class SearchBoxView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public Activity f20979e;

    /* renamed from: f  reason: collision with root package name */
    public String f20980f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f20981g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f20982h;
    public TextView i;
    public View.OnClickListener j;
    public View.OnClickListener k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CaptureActivityConfig(SearchBoxView.this.f20979e, 16003)));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.search_bg_layout) {
                TiebaStatic.eventStat(SearchBoxView.this.f20979e, SearchBoxView.this.f20980f, PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new IntentConfig(SearchBoxView.this.f20979e)));
            }
        }
    }

    public SearchBoxView(Context context) {
        super(context);
        this.f20980f = "sq_tb_search";
        this.f20981g = null;
        this.f20982h = null;
        this.i = null;
        this.j = new a();
        this.k = new b();
        c(context);
    }

    public final void c(Context context) {
        this.f20979e = (Activity) context;
        LayoutInflater.from(context).inflate(R.layout.widget_search_box, this);
        this.f20981g = (LinearLayout) findViewById(R.id.search_bg_layout);
        this.f20982h = (TextView) findViewById(R.id.search_bar_text);
        this.f20981g.setOnClickListener(this.k);
        TextView textView = (TextView) findViewById(R.id.search_from_qr);
        this.i = textView;
        textView.setOnClickListener(this.j);
    }

    public void setClickStatKey(String str) {
        this.f20980f = str;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.f20981g.setOnClickListener(onClickListener);
        }
    }

    public void setText(CharSequence charSequence) {
        this.f20982h.setHint(charSequence);
    }

    public void setText(int i) {
        this.f20982h.setHint(i);
    }

    public SearchBoxView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20980f = "sq_tb_search";
        this.f20981g = null;
        this.f20982h = null;
        this.i = null;
        this.j = new a();
        this.k = new b();
        c(context);
    }

    public SearchBoxView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20980f = "sq_tb_search";
        this.f20981g = null;
        this.f20982h = null;
        this.i = null;
        this.j = new a();
        this.k = new b();
        c(context);
    }
}
