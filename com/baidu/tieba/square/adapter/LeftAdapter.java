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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes2.dex */
public class LeftAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context mContext;
    private List<String> mDataList;
    private a nsa = null;
    private int nsb = 0;

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
    /* renamed from: R */
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.left_item_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        final String str = this.mDataList.get(i);
        viewHolder.itemView.setTag(Integer.valueOf(i));
        viewHolder.nse.setText(str);
        if (this.nsb == i) {
            viewHolder.nsf.setVisibility(0);
            ap.setBackgroundColor(viewHolder.nsf, R.color.CAM_X0302);
            ap.setBackgroundColor(viewHolder.itemView, R.color.CAM_X0205);
            ap.setViewTextColor(viewHolder.nse, R.color.CAM_X0105);
        } else {
            viewHolder.nsf.setVisibility(8);
            ap.setBackgroundColor(viewHolder.itemView, R.color.CAM_X0204);
            ap.setViewTextColor(viewHolder.nse, R.color.CAM_X0107);
        }
        if ("推荐".equals(dLU())) {
            ar arVar = new ar("c13641");
            arVar.v("uid", TbadkApplication.getCurrentAccountId());
            arVar.aq("obj_locate", 3);
            TiebaStatic.log(arVar);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.adapter.LeftAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LeftAdapter.this.uG(i);
                if (LeftAdapter.this.nsa != null) {
                    LeftAdapter.this.nsa.a(viewHolder.itemView, i, str);
                }
                ar arVar2 = new ar("c13649");
                arVar2.dR("resource_id", str);
                TiebaStatic.log(arVar2);
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
        this.nsa = aVar;
    }

    public void setData(int i, List<String> list) {
        this.nsb = i;
        this.mDataList = list;
        notifyDataSetChanged();
    }

    public void uG(int i) {
        this.nsb = i;
        notifyDataSetChanged();
    }

    public String dLU() {
        return Jr(this.nsb);
    }

    public String Jr(int i) {
        return (String) y.getItem(this.mDataList, i);
    }

    public int Ta(String str) {
        return y.getPosition(this.mDataList, str);
    }

    /* loaded from: classes2.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nse;
        private View nsf;

        public ViewHolder(@NonNull View view) {
            super(view);
            this.nse = (TextView) view.findViewById(R.id.tv_class_name);
            this.nsf = view.findViewById(R.id.tv_line);
        }
    }
}
