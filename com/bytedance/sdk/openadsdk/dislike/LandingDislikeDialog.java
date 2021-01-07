package com.bytedance.sdk.openadsdk.dislike;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ak;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class LandingDislikeDialog extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private View f7312a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f7313b;
    private TTDislikeListView c;
    private b d;
    private l e;
    private a f;
    private boolean g;

    /* loaded from: classes4.dex */
    public interface a {
        void a();

        void a(int i, FilterWord filterWord);

        void a(View view);

        void b(View view);
    }

    public LandingDislikeDialog(@NonNull Context context, @NonNull l lVar) {
        this(context);
        this.e = lVar;
        b();
    }

    public LandingDislikeDialog(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public LandingDislikeDialog(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LandingDislikeDialog(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = false;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        setClickable(true);
        setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LandingDislikeDialog.this.a(true);
            }
        });
        setBackgroundColor(Color.parseColor("#80000000"));
        this.f7312a = LayoutInflater.from(context).inflate(ac.f(context, "tt_dislike_dialog_layout2"), (ViewGroup) this, false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.width = ak.c(getContext(), 345.0f);
        this.f7312a.setLayoutParams(layoutParams);
        this.f7312a.setClickable(true);
        c();
        b();
    }

    private void b() {
        if (this.e != null) {
            this.d = new b(LayoutInflater.from(getContext()), this.e.Y());
            this.c.setAdapter((ListAdapter) this.d);
            this.c.setMaterialMeta(this.e);
        }
    }

    private void c() {
        this.f7313b = (TextView) this.f7312a.findViewById(ac.e(getContext(), "tt_edit_suggestion"));
        this.f7313b.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandingDislikeDialog.this.f != null) {
                    LandingDislikeDialog.this.a(false);
                    LandingDislikeDialog.this.f.a();
                }
            }
        });
        this.c = (TTDislikeListView) this.f7312a.findViewById(ac.e(getContext(), "tt_filer_words_lv"));
        this.c.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (LandingDislikeDialog.this.f != null) {
                    try {
                        LandingDislikeDialog.this.f.a(i, LandingDislikeDialog.this.e.Y().get(i));
                    } catch (Throwable th) {
                    }
                }
                LandingDislikeDialog.this.a(true);
            }
        });
    }

    public void a() {
        if (this.f7312a.getParent() == null) {
            addView(this.f7312a);
        }
        d();
        setVisibility(0);
        this.g = true;
        if (this.f != null) {
            this.f.a(this);
        }
    }

    public void a(boolean z) {
        setVisibility(8);
        this.g = false;
        if (this.f != null && z) {
            this.f.b(this);
        }
    }

    private void d() {
        if (this.c != null) {
            this.c.setVisibility(0);
        }
    }

    public void setCallback(a aVar) {
        this.f = aVar;
    }

    /* loaded from: classes4.dex */
    public class b extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        private boolean f7318b = true;
        private final List<FilterWord> c;
        private final LayoutInflater d;

        public b(LayoutInflater layoutInflater, List<FilterWord> list) {
            this.c = list;
            this.d = layoutInflater;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.c == null) {
                return 0;
            }
            return this.c.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.c.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                a aVar2 = new a();
                view = this.d.inflate(ac.f(this.d.getContext(), "tt_dialog_listview_item"), viewGroup, false);
                aVar2.f7319a = (TextView) view.findViewById(ac.e(this.d.getContext(), "tt_item_tv"));
                aVar2.f7320b = (FlowLayout) view.findViewById(ac.e(this.d.getContext(), "tt_item_tv_son"));
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            FilterWord filterWord = this.c.get(i);
            aVar.f7319a.setText(filterWord.getName());
            if (!filterWord.hasSecondOptions()) {
                if (i != this.c.size() - 1) {
                    aVar.f7319a.setBackgroundResource(ac.d(this.d.getContext(), "tt_dislike_middle_seletor"));
                } else {
                    aVar.f7319a.setBackgroundResource(ac.d(this.d.getContext(), "tt_dislike_bottom_seletor"));
                }
            }
            if (this.f7318b && i == 0) {
                aVar.f7319a.setBackgroundResource(ac.d(this.d.getContext(), "tt_dislike_top_seletor"));
            }
            if (filterWord.hasSecondOptions()) {
                aVar.f7320b.removeAllViews();
                for (int i2 = 0; i2 < filterWord.getOptions().size(); i2++) {
                    TextView textView = (TextView) this.d.inflate(ac.f(this.d.getContext(), "tt_dislike_flowlayout_tv"), (ViewGroup) aVar.f7320b, false);
                    textView.setText(filterWord.getOptions().get(i2).getName());
                    textView.setOnClickListener(new c(filterWord.getOptions().get(i2), i2));
                    aVar.f7320b.addView(textView);
                }
                aVar.f7320b.setVisibility(0);
            } else {
                aVar.f7320b.setVisibility(8);
            }
            return view;
        }

        /* loaded from: classes4.dex */
        private class a {

            /* renamed from: a  reason: collision with root package name */
            TextView f7319a;

            /* renamed from: b  reason: collision with root package name */
            FlowLayout f7320b;

            private a() {
            }
        }
    }

    /* loaded from: classes4.dex */
    private class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        private FilterWord f7322b;
        private int c;

        public c(FilterWord filterWord, int i) {
            this.f7322b = filterWord;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LandingDislikeDialog.this.f.a(this.c, this.f7322b);
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f7322b);
            com.bytedance.sdk.openadsdk.c.d.a(LandingDislikeDialog.this.e, arrayList);
            LandingDislikeDialog.this.a(true);
        }
    }
}
