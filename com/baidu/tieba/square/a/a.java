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
    private InterfaceC0721a ldH = null;
    private int ldI = 0;
    private Context mContext;
    private List<String> mDataList;

    /* renamed from: com.baidu.tieba.square.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0721a {
        void a(View view, int i, String str);
    }

    public a(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: B */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new b(LayoutInflater.from(this.mContext).inflate(R.layout.left_item_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull final b bVar, final int i) {
        final String str = this.mDataList.get(i);
        bVar.itemView.setTag(Integer.valueOf(i));
        bVar.ldL.setText(str);
        if (this.ldI == i) {
            bVar.ldM.setVisibility(0);
            am.setBackgroundColor(bVar.ldM, R.color.cp_link_tip_e);
            am.setBackgroundColor(bVar.itemView, R.color.cp_bg_line_e);
            am.setViewTextColor(bVar.ldL, (int) R.color.cp_cont_b);
        } else {
            bVar.ldM.setVisibility(8);
            am.setBackgroundColor(bVar.itemView, R.color.cp_bg_line_c);
            am.setViewTextColor(bVar.ldL, (int) R.color.cp_cont_j);
        }
        if ("推荐".equals(dbG())) {
            an anVar = new an("c13641");
            anVar.s("uid", TbadkApplication.getCurrentAccountId());
            anVar.ag("obj_locate", 3);
            TiebaStatic.log(anVar);
        }
        bVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.DB(i);
                if (a.this.ldH != null) {
                    a.this.ldH.a(bVar.itemView, i, str);
                }
                an anVar2 = new an("c13649");
                anVar2.dh("resource_id", str);
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

    public void b(InterfaceC0721a interfaceC0721a) {
        this.ldH = interfaceC0721a;
    }

    public void p(int i, List<String> list) {
        this.ldI = i;
        this.mDataList = list;
        notifyDataSetChanged();
    }

    public void DB(int i) {
        this.ldI = i;
        notifyDataSetChanged();
    }

    public String dbG() {
        return DC(this.ldI);
    }

    public String DC(int i) {
        return (String) v.getItem(this.mDataList, i);
    }

    /* loaded from: classes9.dex */
    public class b extends RecyclerView.ViewHolder {
        private TextView ldL;
        private View ldM;

        public b(@NonNull View view) {
            super(view);
            this.ldL = (TextView) view.findViewById(R.id.tv_class_name);
            this.ldM = view.findViewById(R.id.tv_line);
        }
    }
}
