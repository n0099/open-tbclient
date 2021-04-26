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
    public String f18925a;

    /* renamed from: b  reason: collision with root package name */
    public Context f18926b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f18927c;

    /* renamed from: d  reason: collision with root package name */
    public b f18928d;

    /* loaded from: classes3.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f18929a;

        public ViewHolder(SearchMajorResultItemAdapter searchMajorResultItemAdapter, View view) {
            super(view);
            this.f18929a = (TextView) view.findViewById(R.id.tv_major_name);
        }
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f18930e;

        public a(String str) {
            this.f18930e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SearchMajorResultItemAdapter.this.f18928d != null) {
                SearchMajorResultItemAdapter.this.f18928d.a(this.f18930e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(String str);
    }

    public SearchMajorResultItemAdapter(Context context) {
        this.f18926b = context;
    }

    public final void d(TextView textView, String str) {
        if (textView == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f18925a)) {
            return;
        }
        String lowerCase = str.toLowerCase();
        String lowerCase2 = this.f18925a.toLowerCase();
        if (!lowerCase.contains(lowerCase2)) {
            textView.setText(str);
            return;
        }
        int indexOf = lowerCase.indexOf(lowerCase2);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.f18925a.length() + indexOf, 33);
        textView.setText(spannableStringBuilder);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i2) {
        List<String> list = this.f18927c;
        if (list == null) {
            return;
        }
        String str = list.get(i2);
        if (StringUtils.isNull(str)) {
            return;
        }
        viewHolder.f18929a.setText(str);
        SkinManager.setViewTextColor(viewHolder.f18929a, R.color.CAM_X0105);
        SkinManager.setBackgroundResource(viewHolder.itemView, R.drawable.more_pop_item_bg_selector);
        d(viewHolder.f18929a, str);
        viewHolder.itemView.setOnClickListener(new a(str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: f */
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return new ViewHolder(this, LayoutInflater.from(this.f18926b).inflate(R.layout.search_major_item_layout, viewGroup, false));
    }

    public void g(String str) {
        this.f18925a = str;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<String> list = this.f18927c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void h() {
        List<String> list = this.f18927c;
        if (list != null) {
            list.clear();
            notifyDataSetChanged();
        }
    }

    public void i(b bVar) {
        this.f18928d = bVar;
    }

    public void setData(List<String> list) {
        this.f18927c = list;
        notifyDataSetChanged();
    }
}
