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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends RecyclerView.Adapter<b> {
    private InterfaceC0668a kLr = null;
    private int kLs = 0;
    private Context mContext;
    private List<String> mDataList;

    /* renamed from: com.baidu.tieba.square.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0668a {
        void a(View view, int i, String str);
    }

    public a(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: C */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new b(LayoutInflater.from(this.mContext).inflate(R.layout.left_item_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull final b bVar, final int i) {
        final String str = this.mDataList.get(i);
        bVar.itemView.setTag(Integer.valueOf(i));
        bVar.kLv.setText(str);
        if (this.kLs == i) {
            bVar.kLw.setVisibility(0);
            am.setBackgroundColor(bVar.kLw, R.color.cp_link_tip_e);
            am.setBackgroundColor(bVar.itemView, R.color.cp_bg_line_e);
            am.setViewTextColor(bVar.kLv, (int) R.color.cp_cont_b);
        } else {
            bVar.kLw.setVisibility(8);
            am.setBackgroundColor(bVar.itemView, R.color.cp_bg_line_c);
            am.setViewTextColor(bVar.kLv, (int) R.color.cp_cont_j);
        }
        if ("推荐".equals(cUC())) {
            an anVar = new an("c13641");
            anVar.t("uid", TbadkApplication.getCurrentAccountId());
            anVar.af("obj_locate", 3);
            TiebaStatic.log(anVar);
        }
        bVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.CR(i);
                if (a.this.kLr != null) {
                    a.this.kLr.a(bVar.itemView, i, str);
                }
                an anVar2 = new an("c13649");
                anVar2.cI("resource_id", str);
                TiebaStatic.log(anVar2);
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

    public void b(InterfaceC0668a interfaceC0668a) {
        this.kLr = interfaceC0668a;
    }

    public void p(int i, List<String> list) {
        this.kLs = i;
        this.mDataList = list;
        notifyDataSetChanged();
    }

    public void CR(int i) {
        this.kLs = i;
        notifyDataSetChanged();
    }

    public String cUC() {
        return CS(this.kLs);
    }

    public String CS(int i) {
        return (String) v.getItem(this.mDataList, i);
    }

    /* loaded from: classes9.dex */
    public class b extends RecyclerView.ViewHolder {
        private TextView kLv;
        private View kLw;

        public b(@NonNull View view) {
            super(view);
            this.kLv = (TextView) view.findViewById(R.id.tv_class_name);
            this.kLw = view.findViewById(R.id.tv_line);
        }
    }
}
