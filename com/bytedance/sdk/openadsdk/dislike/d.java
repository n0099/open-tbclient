package com.bytedance.sdk.openadsdk.dislike;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ak;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends TTDislikeDialogAbstract {

    /* renamed from: a  reason: collision with root package name */
    private TextView f7044a;

    /* renamed from: b  reason: collision with root package name */
    private TTDislikeListView f7045b;
    private b c;
    private l d;
    private a e;

    /* loaded from: classes4.dex */
    public interface a {
        void a();

        void a(int i, FilterWord filterWord);

        void b();

        void c();
    }

    public d(Context context, l lVar) {
        super(context, ac.g(context, "tt_dislikeDialog_new"));
        this.d = lVar;
    }

    public void a(l lVar) {
        if (this.c != null && lVar != null) {
            this.d = lVar;
            this.c.a(this.d.Y());
            setMaterialMeta(this.d);
        }
    }

    public void a(String str) {
        if (str != null) {
            this.d.b(str);
            a(this.d);
        }
    }

    public void a(a aVar) {
        this.e = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        setMaterialMeta(this.d);
        a();
        a(getContext());
        b();
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract
    public int getLayoutId() {
        return ac.f(getContext(), "tt_dislike_dialog_layout2");
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract
    public int[] getTTDislikeListViewIds() {
        return new int[]{ac.e(getContext(), "tt_filer_words_lv")};
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract
    public ViewGroup.LayoutParams getLayoutParams() {
        return new ViewGroup.LayoutParams(ak.c(getContext(), 345.0f), -2);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        c();
    }

    @RequiresApi(api = 26)
    private void a() {
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setAttributes(window.getAttributes());
        }
    }

    private void b() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bytedance.sdk.openadsdk.dislike.d.1
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (d.this.e != null) {
                    d.this.e.a();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.sdk.openadsdk.dislike.d.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (d.this.e != null) {
                    d.this.e.b();
                }
            }
        });
        this.c = new b(getLayoutInflater(), this.d.Y());
        this.f7045b.setAdapter((ListAdapter) this.c);
    }

    private void a(Context context) {
        this.f7044a = (TextView) findViewById(ac.e(getContext(), "tt_edit_suggestion"));
        this.f7044a.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.e != null) {
                    d.this.dismiss();
                    d.this.e.c();
                }
            }
        });
        this.f7045b = (TTDislikeListView) findViewById(ac.e(getContext(), "tt_filer_words_lv"));
        this.f7045b.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.d.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.e != null) {
                    try {
                        d.this.e.a(i, d.this.d.Y().get(i));
                    } catch (Throwable th) {
                    }
                }
                d.this.dismiss();
            }
        });
    }

    private void c() {
        if (this.f7045b != null) {
            this.f7045b.setVisibility(0);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        private boolean f7051b = true;
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
                aVar2.f7052a = (TextView) view.findViewById(ac.e(this.d.getContext(), "tt_item_tv"));
                aVar2.f7053b = (FlowLayout) view.findViewById(ac.e(this.d.getContext(), "tt_item_tv_son"));
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            FilterWord filterWord = this.c.get(i);
            aVar.f7052a.setText(filterWord.getName());
            if (!filterWord.hasSecondOptions()) {
                if (i != this.c.size() - 1) {
                    aVar.f7052a.setBackgroundResource(ac.d(this.d.getContext(), "tt_dislike_middle_seletor"));
                } else {
                    aVar.f7052a.setBackgroundResource(ac.d(this.d.getContext(), "tt_dislike_bottom_seletor"));
                }
            }
            if (this.f7051b && i == 0) {
                aVar.f7052a.setBackgroundResource(ac.d(this.d.getContext(), "tt_dislike_top_seletor"));
            }
            if (filterWord.hasSecondOptions()) {
                aVar.f7053b.removeAllViews();
                for (int i2 = 0; i2 < filterWord.getOptions().size(); i2++) {
                    TextView textView = (TextView) this.d.inflate(ac.f(this.d.getContext(), "tt_dislike_flowlayout_tv"), (ViewGroup) aVar.f7053b, false);
                    textView.setText(filterWord.getOptions().get(i2).getName());
                    textView.setOnClickListener(new c(filterWord.getOptions().get(i2), i2));
                    aVar.f7053b.addView(textView);
                }
                aVar.f7053b.setVisibility(0);
            } else {
                aVar.f7053b.setVisibility(8);
            }
            return view;
        }

        public void a(List<FilterWord> list) {
            if (list != null && !list.isEmpty()) {
                this.c.clear();
                this.c.addAll(list);
                notifyDataSetChanged();
            }
        }

        /* loaded from: classes4.dex */
        private class a {

            /* renamed from: a  reason: collision with root package name */
            TextView f7052a;

            /* renamed from: b  reason: collision with root package name */
            FlowLayout f7053b;

            private a() {
            }
        }
    }

    /* loaded from: classes4.dex */
    private class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        private FilterWord f7055b;
        private int c;

        public c(FilterWord filterWord, int i) {
            this.f7055b = filterWord;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.e.a(this.c, this.f7055b);
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f7055b);
            com.bytedance.sdk.openadsdk.c.d.a(d.this.d, arrayList);
            d.this.dismiss();
        }
    }
}
