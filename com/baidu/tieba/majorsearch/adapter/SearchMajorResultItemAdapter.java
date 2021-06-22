package com.baidu.tieba.majorsearch.adapter;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class SearchMajorResultItemAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public String f18278a;

    /* renamed from: b  reason: collision with root package name */
    public Context f18279b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f18280c;

    /* renamed from: d  reason: collision with root package name */
    public b f18281d;

    /* loaded from: classes3.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f18282a;

        public ViewHolder(SearchMajorResultItemAdapter searchMajorResultItemAdapter, View view) {
            super(view);
            this.f18282a = (TextView) view.findViewById(R.id.tv_major_name);
        }
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f18283e;

        public a(String str) {
            this.f18283e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SearchMajorResultItemAdapter.this.f18281d != null) {
                SearchMajorResultItemAdapter.this.f18281d.a(this.f18283e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(String str);
    }

    public SearchMajorResultItemAdapter(Context context) {
        this.f18279b = context;
    }

    public final void d(TextView textView, String str) {
        if (textView == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f18278a)) {
            return;
        }
        String lowerCase = str.toLowerCase();
        String lowerCase2 = this.f18278a.toLowerCase();
        if (!lowerCase.contains(lowerCase2)) {
            textView.setText(str);
            return;
        }
        int indexOf = lowerCase.indexOf(lowerCase2);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.f18278a.length() + indexOf, 33);
        textView.setText(spannableStringBuilder);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i2) {
        List<String> list = this.f18280c;
        if (list == null) {
            return;
        }
        String str = list.get(i2);
        if (StringUtils.isNull(str)) {
            return;
        }
        viewHolder.f18282a.setText(str);
        SkinManager.setViewTextColor(viewHolder.f18282a, R.color.CAM_X0105);
        SkinManager.setBackgroundResource(viewHolder.itemView, R.drawable.more_pop_item_bg_selector);
        d(viewHolder.f18282a, str);
        viewHolder.itemView.setOnClickListener(new a(str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: f */
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return new ViewHolder(this, LayoutInflater.from(this.f18279b).inflate(R.layout.search_major_item_layout, viewGroup, false));
    }

    public void g(String str) {
        this.f18278a = str;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<String> list = this.f18280c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void m() {
        List<String> list = this.f18280c;
        if (list != null) {
            list.clear();
            notifyDataSetChanged();
        }
    }

    public void n(b bVar) {
        this.f18281d = bVar;
    }

    public void setData(List<String> list) {
        this.f18280c = list;
        notifyDataSetChanged();
    }
}
