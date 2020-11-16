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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes21.dex */
public class a extends RecyclerView.Adapter<b> {
    private Context mContext;
    private List<String> mDataList;
    private InterfaceC0849a mQG = null;
    private int mQH = 0;

    /* renamed from: com.baidu.tieba.square.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public interface InterfaceC0849a {
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
        bVar.mQK.setText(str);
        if (this.mQH == i) {
            bVar.mQL.setVisibility(0);
            ap.setBackgroundColor(bVar.mQL, R.color.CAM_X0302);
            ap.setBackgroundColor(bVar.itemView, R.color.CAM_X0205);
            ap.setViewTextColor(bVar.mQK, (int) R.color.CAM_X0105);
        } else {
            bVar.mQL.setVisibility(8);
            ap.setBackgroundColor(bVar.itemView, R.color.CAM_X0204);
            ap.setViewTextColor(bVar.mQK, (int) R.color.CAM_X0107);
        }
        if ("推荐".equals(dIb())) {
            ar arVar = new ar("c13641");
            arVar.w("uid", TbadkApplication.getCurrentAccountId());
            arVar.ak("obj_locate", 3);
            TiebaStatic.log(arVar);
        }
        bVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.vm(i);
                if (a.this.mQG != null) {
                    a.this.mQG.a(bVar.itemView, i, str);
                }
                ar arVar2 = new ar("c13649");
                arVar2.dR("resource_id", str);
                TiebaStatic.log(arVar2);
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

    public void b(InterfaceC0849a interfaceC0849a) {
        this.mQG = interfaceC0849a;
    }

    public void p(int i, List<String> list) {
        this.mQH = i;
        this.mDataList = list;
        notifyDataSetChanged();
    }

    public void vm(int i) {
        this.mQH = i;
        notifyDataSetChanged();
    }

    public String dIb() {
        return JP(this.mQH);
    }

    public String JP(int i) {
        return (String) y.getItem(this.mDataList, i);
    }

    public int RW(String str) {
        return y.getPosition(this.mDataList, str);
    }

    /* loaded from: classes21.dex */
    public class b extends RecyclerView.ViewHolder {
        private TextView mQK;
        private View mQL;

        public b(@NonNull View view) {
            super(view);
            this.mQK = (TextView) view.findViewById(R.id.tv_class_name);
            this.mQL = view.findViewById(R.id.tv_line);
        }
    }
}
