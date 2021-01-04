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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes8.dex */
public class SearchMajorResultItemAdapter extends RecyclerView.Adapter<ViewHolder> {
    private String esI;
    private a lgY;
    private Context mContext;
    private List<String> mDataList;

    /* loaded from: classes8.dex */
    public interface a {
        void Or(String str);
    }

    public SearchMajorResultItemAdapter(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: M */
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.search_major_item_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        if (this.mDataList != null) {
            final String str = this.mDataList.get(i);
            if (!StringUtils.isNull(str)) {
                viewHolder.lhb.setText(str);
                ao.setViewTextColor(viewHolder.lhb, R.color.CAM_X0105);
                ao.setBackgroundResource(viewHolder.itemView, R.drawable.more_pop_item_bg_selector);
                e(viewHolder.lhb, str);
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.majorsearch.adapter.SearchMajorResultItemAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (SearchMajorResultItemAdapter.this.lgY != null) {
                            SearchMajorResultItemAdapter.this.lgY.Or(str);
                        }
                    }
                });
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.mDataList == null) {
            return 0;
        }
        return this.mDataList.size();
    }

    public void b(a aVar) {
        this.lgY = aVar;
    }

    public void setData(List<String> list) {
        this.mDataList = list;
        notifyDataSetChanged();
    }

    public void dgF() {
        if (this.mDataList != null) {
            this.mDataList.clear();
            notifyDataSetChanged();
        }
    }

    public void Oj(String str) {
        this.esI = str;
    }

    /* loaded from: classes8.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView lhb;

        public ViewHolder(View view) {
            super(view);
            this.lhb = (TextView) view.findViewById(R.id.tv_major_name);
        }
    }

    private void e(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.esI)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.esI.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ao.getColor(R.color.CAM_X0301));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.esI.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }
}
