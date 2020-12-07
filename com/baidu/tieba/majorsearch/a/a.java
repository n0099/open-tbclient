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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes24.dex */
public class a extends RecyclerView.Adapter<b> {
    private String ejE;
    private InterfaceC0809a lbs;
    private Context mContext;
    private List<String> mDataList;

    /* renamed from: com.baidu.tieba.majorsearch.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public interface InterfaceC0809a {
        void OJ(String str);
    }

    public a(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: I */
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
                bVar.lbv.setText(str);
                ap.setViewTextColor(bVar.lbv, R.color.CAM_X0105);
                ap.setBackgroundResource(bVar.itemView, R.drawable.more_pop_item_bg_selector);
                d(bVar.lbv, str);
                bVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.majorsearch.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.lbs != null) {
                            a.this.lbs.OJ(str);
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

    public void b(InterfaceC0809a interfaceC0809a) {
        this.lbs = interfaceC0809a;
    }

    public void setData(List<String> list) {
        this.mDataList = list;
        notifyDataSetChanged();
    }

    public void dgS() {
        if (this.mDataList != null) {
            this.mDataList.clear();
            notifyDataSetChanged();
        }
    }

    public void OB(String str) {
        this.ejE = str;
    }

    /* loaded from: classes24.dex */
    public class b extends RecyclerView.ViewHolder {
        TextView lbv;

        public b(View view) {
            super(view);
            this.lbv = (TextView) view.findViewById(R.id.tv_major_name);
        }
    }

    private void d(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.ejE)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.ejE.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ap.getColor(R.color.CAM_X0301));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.ejE.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }
}
