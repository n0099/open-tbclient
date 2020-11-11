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
    private InterfaceC0846a mPN = null;
    private int mPO = 0;

    /* renamed from: com.baidu.tieba.square.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC0846a {
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
        bVar.mPR.setText(str);
        if (this.mPO == i) {
            bVar.mPS.setVisibility(0);
            ap.setBackgroundColor(bVar.mPS, R.color.cp_link_tip_e);
            ap.setBackgroundColor(bVar.itemView, R.color.cp_bg_line_e);
            ap.setViewTextColor(bVar.mPR, (int) R.color.cp_cont_b);
        } else {
            bVar.mPS.setVisibility(8);
            ap.setBackgroundColor(bVar.itemView, R.color.cp_bg_line_c);
            ap.setViewTextColor(bVar.mPR, (int) R.color.cp_cont_j);
        }
        if ("推荐".equals(dIk())) {
            aq aqVar = new aq("c13641");
            aqVar.w("uid", TbadkApplication.getCurrentAccountId());
            aqVar.al("obj_locate", 3);
            TiebaStatic.log(aqVar);
        }
        bVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.uO(i);
                if (a.this.mPN != null) {
                    a.this.mPN.a(bVar.itemView, i, str);
                }
                aq aqVar2 = new aq("c13649");
                aqVar2.dR("resource_id", str);
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

    public void b(InterfaceC0846a interfaceC0846a) {
        this.mPN = interfaceC0846a;
    }

    public void p(int i, List<String> list) {
        this.mPO = i;
        this.mDataList = list;
        notifyDataSetChanged();
    }

    public void uO(int i) {
        this.mPO = i;
        notifyDataSetChanged();
    }

    public String dIk() {
        return Jn(this.mPO);
    }

    public String Jn(int i) {
        return (String) y.getItem(this.mDataList, i);
    }

    public int Sv(String str) {
        return y.getPosition(this.mDataList, str);
    }

    /* loaded from: classes22.dex */
    public class b extends RecyclerView.ViewHolder {
        private TextView mPR;
        private View mPS;

        public b(@NonNull View view) {
            super(view);
            this.mPR = (TextView) view.findViewById(R.id.tv_class_name);
            this.mPS = view.findViewById(R.id.tv_line);
        }
    }
}
