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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends RecyclerView.Adapter<b> {
    private InterfaceC0738a lyO = null;
    private int lyP = 0;
    private Context mContext;
    private List<String> mDataList;

    /* renamed from: com.baidu.tieba.square.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0738a {
        void a(View view, int i, String str);
    }

    public a(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: H */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new b(LayoutInflater.from(this.mContext).inflate(R.layout.left_item_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull final b bVar, final int i) {
        final String str = this.mDataList.get(i);
        bVar.itemView.setTag(Integer.valueOf(i));
        bVar.lyS.setText(str);
        if (this.lyP == i) {
            bVar.lyT.setVisibility(0);
            an.setBackgroundColor(bVar.lyT, R.color.cp_link_tip_e);
            an.setBackgroundColor(bVar.itemView, R.color.cp_bg_line_e);
            an.setViewTextColor(bVar.lyS, (int) R.color.cp_cont_b);
        } else {
            bVar.lyT.setVisibility(8);
            an.setBackgroundColor(bVar.itemView, R.color.cp_bg_line_c);
            an.setViewTextColor(bVar.lyS, (int) R.color.cp_cont_j);
        }
        if ("推荐".equals(dgk())) {
            ao aoVar = new ao("c13641");
            aoVar.s("uid", TbadkApplication.getCurrentAccountId());
            aoVar.ag("obj_locate", 3);
            TiebaStatic.log(aoVar);
        }
        bVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.EF(i);
                if (a.this.lyO != null) {
                    a.this.lyO.a(bVar.itemView, i, str);
                }
                ao aoVar2 = new ao("c13649");
                aoVar2.dk("resource_id", str);
                TiebaStatic.log(aoVar2);
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

    public void b(InterfaceC0738a interfaceC0738a) {
        this.lyO = interfaceC0738a;
    }

    public void p(int i, List<String> list) {
        this.lyP = i;
        this.mDataList = list;
        notifyDataSetChanged();
    }

    public void EF(int i) {
        this.lyP = i;
        notifyDataSetChanged();
    }

    public String dgk() {
        return EG(this.lyP);
    }

    public String EG(int i) {
        return (String) w.getItem(this.mDataList, i);
    }

    /* loaded from: classes9.dex */
    public class b extends RecyclerView.ViewHolder {
        private TextView lyS;
        private View lyT;

        public b(@NonNull View view) {
            super(view);
            this.lyS = (TextView) view.findViewById(R.id.tv_class_name);
            this.lyT = view.findViewById(R.id.tv_line);
        }
    }
}
