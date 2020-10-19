package com.baidu.tieba.square.a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes22.dex */
public class a extends RecyclerView.Adapter<b> {
    private Context mContext;
    private List<String> mDataList;
    private InterfaceC0816a mxg = null;
    private int mxh = 0;

    /* renamed from: com.baidu.tieba.square.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC0816a {
        void a(View view, int i, String str);
    }

    public a(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: M */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new b(LayoutInflater.from(this.mContext).inflate(R.layout.left_item_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull final b bVar, final int i) {
        final String str = this.mDataList.get(i);
        bVar.itemView.setTag(Integer.valueOf(i));
        bVar.mxk.setText(str);
        if (this.mxh == i) {
            bVar.mxl.setVisibility(0);
            ap.setBackgroundColor(bVar.mxl, R.color.cp_link_tip_e);
            ap.setBackgroundColor(bVar.itemView, R.color.cp_bg_line_e);
            ap.setViewTextColor(bVar.mxk, R.color.cp_cont_b);
        } else {
            bVar.mxl.setVisibility(8);
            ap.setBackgroundColor(bVar.itemView, R.color.cp_bg_line_c);
            ap.setViewTextColor(bVar.mxk, R.color.cp_cont_j);
        }
        if ("推荐".equals(dCA())) {
            aq aqVar = new aq("c13641");
            aqVar.u("uid", TbadkApplication.getCurrentAccountId());
            aqVar.aj("obj_locate", 3);
            TiebaStatic.log(aqVar);
        }
        bVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.IH(i);
                if (a.this.mxg != null) {
                    a.this.mxg.a(bVar.itemView, i, str);
                }
                aq aqVar2 = new aq("c13649");
                aqVar2.dK("resource_id", str);
                TiebaStatic.log(aqVar2);
            }
        });
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.mDataList == null) {
            return 0;
        }
        return this.mDataList.size();
    }

    public void b(InterfaceC0816a interfaceC0816a) {
        this.mxg = interfaceC0816a;
    }

    public void p(int i, List<String> list) {
        this.mxh = i;
        this.mDataList = list;
        notifyDataSetChanged();
    }

    public void IH(int i) {
        this.mxh = i;
        notifyDataSetChanged();
    }

    public String dCA() {
        return II(this.mxh);
    }

    public String II(int i) {
        return (String) y.getItem(this.mDataList, i);
    }

    public int RF(String str) {
        return y.getPosition(this.mDataList, str);
    }

    /* loaded from: classes22.dex */
    public class b extends RecyclerView.ViewHolder {
        private TextView mxk;
        private View mxl;

        public b(@NonNull View view) {
            super(view);
            this.mxk = (TextView) view.findViewById(R.id.tv_class_name);
            this.mxl = view.findViewById(R.id.tv_line);
        }
    }
}
