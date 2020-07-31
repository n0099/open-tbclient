package com.baidu.tieba.majorsearch.a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes18.dex */
public class a extends RecyclerView.Adapter<b> {
    private String drQ;
    private InterfaceC0695a jIe;
    private Context mContext;
    private List<String> mDataList;

    /* renamed from: com.baidu.tieba.majorsearch.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public interface InterfaceC0695a {
        void Jh(String str);
    }

    public a(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: E */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new b(LayoutInflater.from(this.mContext).inflate(R.layout.search_major_item_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull b bVar, int i) {
        if (this.mDataList != null) {
            final String str = this.mDataList.get(i);
            if (!StringUtils.isNull(str)) {
                bVar.jIh.setText(str);
                ao.setViewTextColor(bVar.jIh, R.color.cp_cont_b);
                ao.setBackgroundResource(bVar.itemView, R.drawable.more_pop_item_bg_selector);
                c(bVar.jIh, str);
                bVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.majorsearch.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.jIe != null) {
                            a.this.jIe.Jh(str);
                        }
                    }
                });
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.mDataList == null) {
            return 0;
        }
        return this.mDataList.size();
    }

    public void b(InterfaceC0695a interfaceC0695a) {
        this.jIe = interfaceC0695a;
    }

    public void setData(List<String> list) {
        this.mDataList = list;
        notifyDataSetChanged();
    }

    public void cEs() {
        if (this.mDataList != null) {
            this.mDataList.clear();
            notifyDataSetChanged();
        }
    }

    public void IX(String str) {
        this.drQ = str;
    }

    /* loaded from: classes18.dex */
    public class b extends RecyclerView.ViewHolder {
        TextView jIh;

        public b(View view) {
            super(view);
            this.jIh = (TextView) view.findViewById(R.id.tv_major_name);
        }
    }

    private void c(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.drQ)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.drQ.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ao.getColor(R.color.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.drQ.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }
}
