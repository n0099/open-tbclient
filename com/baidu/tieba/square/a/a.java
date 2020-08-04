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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes16.dex */
public class a extends RecyclerView.Adapter<b> {
    private InterfaceC0748a lGg = null;
    private int lGh = 0;
    private Context mContext;
    private List<String> mDataList;

    /* renamed from: com.baidu.tieba.square.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public interface InterfaceC0748a {
        void a(View view, int i, String str);
    }

    public a(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: I */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new b(LayoutInflater.from(this.mContext).inflate(R.layout.left_item_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull final b bVar, final int i) {
        final String str = this.mDataList.get(i);
        bVar.itemView.setTag(Integer.valueOf(i));
        bVar.lGk.setText(str);
        if (this.lGh == i) {
            bVar.lGl.setVisibility(0);
            ao.setBackgroundColor(bVar.lGl, R.color.cp_link_tip_e);
            ao.setBackgroundColor(bVar.itemView, R.color.cp_bg_line_e);
            ao.setViewTextColor(bVar.lGk, R.color.cp_cont_b);
        } else {
            bVar.lGl.setVisibility(8);
            ao.setBackgroundColor(bVar.itemView, R.color.cp_bg_line_c);
            ao.setViewTextColor(bVar.lGk, R.color.cp_cont_j);
        }
        if ("推荐".equals(dju())) {
            ap apVar = new ap("c13641");
            apVar.t("uid", TbadkApplication.getCurrentAccountId());
            apVar.ah("obj_locate", 3);
            TiebaStatic.log(apVar);
        }
        bVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.Fb(i);
                if (a.this.lGg != null) {
                    a.this.lGg.a(bVar.itemView, i, str);
                }
                ap apVar2 = new ap("c13649");
                apVar2.dn("resource_id", str);
                TiebaStatic.log(apVar2);
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

    public void b(InterfaceC0748a interfaceC0748a) {
        this.lGg = interfaceC0748a;
    }

    public void p(int i, List<String> list) {
        this.lGh = i;
        this.mDataList = list;
        notifyDataSetChanged();
    }

    public void Fb(int i) {
        this.lGh = i;
        notifyDataSetChanged();
    }

    public String dju() {
        return Fc(this.lGh);
    }

    public String Fc(int i) {
        return (String) x.getItem(this.mDataList, i);
    }

    /* loaded from: classes16.dex */
    public class b extends RecyclerView.ViewHolder {
        private TextView lGk;
        private View lGl;

        public b(@NonNull View view) {
            super(view);
            this.lGk = (TextView) view.findViewById(R.id.tv_class_name);
            this.lGl = view.findViewById(R.id.tv_line);
        }
    }
}
