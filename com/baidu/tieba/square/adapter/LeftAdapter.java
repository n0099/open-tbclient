package com.baidu.tieba.square.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes2.dex */
public class LeftAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context mContext;
    private List<String> mDataList;
    private a nks = null;
    private int nkt = 0;

    /* loaded from: classes2.dex */
    public interface a {
        void a(View view, int i, String str);
    }

    public LeftAdapter(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: Q */
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.left_item_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        final String str = this.mDataList.get(i);
        viewHolder.itemView.setTag(Integer.valueOf(i));
        viewHolder.nkw.setText(str);
        if (this.nkt == i) {
            viewHolder.nkx.setVisibility(0);
            ao.setBackgroundColor(viewHolder.nkx, R.color.CAM_X0302);
            ao.setBackgroundColor(viewHolder.itemView, R.color.CAM_X0205);
            ao.setViewTextColor(viewHolder.nkw, R.color.CAM_X0105);
        } else {
            viewHolder.nkx.setVisibility(8);
            ao.setBackgroundColor(viewHolder.itemView, R.color.CAM_X0204);
            ao.setViewTextColor(viewHolder.nkw, R.color.CAM_X0107);
        }
        if ("推荐".equals(dNl())) {
            aq aqVar = new aq("c13641");
            aqVar.w("uid", TbadkApplication.getCurrentAccountId());
            aqVar.an("obj_locate", 3);
            TiebaStatic.log(aqVar);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.adapter.LeftAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LeftAdapter.this.we(i);
                if (LeftAdapter.this.nks != null) {
                    LeftAdapter.this.nks.a(viewHolder.itemView, i, str);
                }
                aq aqVar2 = new aq("c13649");
                aqVar2.dX("resource_id", str);
                TiebaStatic.log(aqVar2);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.mDataList == null) {
            return 0;
        }
        return this.mDataList.size();
    }

    public void b(a aVar) {
        this.nks = aVar;
    }

    public void p(int i, List<String> list) {
        this.nkt = i;
        this.mDataList = list;
        notifyDataSetChanged();
    }

    public void we(int i) {
        this.nkt = i;
        notifyDataSetChanged();
    }

    public String dNl() {
        return KA(this.nkt);
    }

    public String KA(int i) {
        return (String) x.getItem(this.mDataList, i);
    }

    public int SS(String str) {
        return x.getPosition(this.mDataList, str);
    }

    /* loaded from: classes2.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nkw;
        private View nkx;

        public ViewHolder(@NonNull View view) {
            super(view);
            this.nkw = (TextView) view.findViewById(R.id.tv_class_name);
            this.nkx = view.findViewById(R.id.tv_line);
        }
    }
}
