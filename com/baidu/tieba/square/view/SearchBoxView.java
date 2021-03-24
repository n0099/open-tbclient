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
/* loaded from: classes5.dex */
public class SearchBoxView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public Activity f21293e;

    /* renamed from: f  reason: collision with root package name */
    public String f21294f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f21295g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f21296h;
    public TextView i;
    public View.OnClickListener j;
    public View.OnClickListener k;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CaptureActivityConfig(SearchBoxView.this.f21293e, 16003)));
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.search_bg_layout) {
                TiebaStatic.eventStat(SearchBoxView.this.f21293e, SearchBoxView.this.f21294f, PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new IntentConfig(SearchBoxView.this.f21293e)));
            }
        }
    }

    public SearchBoxView(Context context) {
        super(context);
        this.f21294f = "sq_tb_search";
        this.f21295g = null;
        this.f21296h = null;
        this.i = null;
        this.j = new a();
        this.k = new b();
        c(context);
    }

    public final void c(Context context) {
        this.f21293e = (Activity) context;
        LayoutInflater.from(context).inflate(R.layout.widget_search_box, this);
        this.f21295g = (LinearLayout) findViewById(R.id.search_bg_layout);
        this.f21296h = (TextView) findViewById(R.id.search_bar_text);
        this.f21295g.setOnClickListener(this.k);
        TextView textView = (TextView) findViewById(R.id.search_from_qr);
        this.i = textView;
        textView.setOnClickListener(this.j);
    }

    public void setClickStatKey(String str) {
        this.f21294f = str;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.f21295g.setOnClickListener(onClickListener);
        }
    }

    public void setText(CharSequence charSequence) {
        this.f21296h.setHint(charSequence);
    }

    public void setText(int i) {
        this.f21296h.setHint(i);
    }

    public SearchBoxView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21294f = "sq_tb_search";
        this.f21295g = null;
        this.f21296h = null;
        this.i = null;
        this.j = new a();
        this.k = new b();
        c(context);
    }

    public SearchBoxView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f21294f = "sq_tb_search";
        this.f21295g = null;
        this.f21296h = null;
        this.i = null;
        this.j = new a();
        this.k = new b();
        c(context);
    }
}
