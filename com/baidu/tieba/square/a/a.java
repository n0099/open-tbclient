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
/* loaded from: classes22.dex */
public class a extends RecyclerView.Adapter<b> {
    private Context mContext;
    private List<String> mDataList;
    private InterfaceC0864a neL = null;
    private int neM = 0;

    /* renamed from: com.baidu.tieba.square.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC0864a {
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
        bVar.neP.setText(str);
        if (this.neM == i) {
            bVar.neQ.setVisibility(0);
            ap.setBackgroundColor(bVar.neQ, R.color.CAM_X0302);
            ap.setBackgroundColor(bVar.itemView, R.color.CAM_X0205);
            ap.setViewTextColor(bVar.neP, (int) R.color.CAM_X0105);
        } else {
            bVar.neQ.setVisibility(8);
            ap.setBackgroundColor(bVar.itemView, R.color.CAM_X0204);
            ap.setViewTextColor(bVar.neP, (int) R.color.CAM_X0107);
        }
        if ("推荐".equals(dNr())) {
            ar arVar = new ar("c13641");
            arVar.w("uid", TbadkApplication.getCurrentAccountId());
            arVar.al("obj_locate", 3);
            TiebaStatic.log(arVar);
        }
        bVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.vT(i);
                if (a.this.neL != null) {
                    a.this.neL.a(bVar.itemView, i, str);
                }
                ar arVar2 = new ar("c13649");
                arVar2.dY("resource_id", str);
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

    public void b(InterfaceC0864a interfaceC0864a) {
        this.neL = interfaceC0864a;
    }

    public void p(int i, List<String> list) {
        this.neM = i;
        this.mDataList = list;
        notifyDataSetChanged();
    }

    public void vT(int i) {
        this.neM = i;
        notifyDataSetChanged();
    }

    public String dNr() {
        return KF(this.neM);
    }

    public String KF(int i) {
        return (String) y.getItem(this.mDataList, i);
    }

    public int Tk(String str) {
        return y.getPosition(this.mDataList, str);
    }

    /* loaded from: classes22.dex */
    public class b extends RecyclerView.ViewHolder {
        private TextView neP;
        private View neQ;

        public b(@NonNull View view) {
            super(view);
            this.neP = (TextView) view.findViewById(R.id.tv_class_name);
            this.neQ = view.findViewById(R.id.tv_line);
        }
    }
}
