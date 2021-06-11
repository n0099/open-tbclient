package com.baidu.tieba.square.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes5.dex */
public class LeftAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public Context f20673a;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f20675c;

    /* renamed from: b  reason: collision with root package name */
    public b f20674b = null;

    /* renamed from: d  reason: collision with root package name */
    public int f20676d = 0;

    /* loaded from: classes5.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f20677a;

        /* renamed from: b  reason: collision with root package name */
        public View f20678b;

        public ViewHolder(@NonNull LeftAdapter leftAdapter, View view) {
            super(view);
            this.f20677a = (TextView) view.findViewById(R.id.tv_class_name);
            this.f20678b = view.findViewById(R.id.tv_line);
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f20679e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewHolder f20680f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f20681g;

        public a(int i2, ViewHolder viewHolder, String str) {
            this.f20679e = i2;
            this.f20680f = viewHolder;
            this.f20681g = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LeftAdapter.this.r(this.f20679e);
            if (LeftAdapter.this.f20674b != null) {
                LeftAdapter.this.f20674b.a(this.f20680f.itemView, this.f20679e, this.f20681g);
            }
            StatisticItem statisticItem = new StatisticItem("c13649");
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f20681g);
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(View view, int i2, String str);
    }

    public LeftAdapter(Context context) {
        this.f20673a = context;
    }

    public String g(int i2) {
        return (String) ListUtils.getItem(this.f20675c, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<String> list = this.f20675c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int h(String str) {
        return ListUtils.getPosition(this.f20675c, str);
    }

    public String m() {
        return g(this.f20676d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n */
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i2) {
        String str = this.f20675c.get(i2);
        viewHolder.itemView.setTag(Integer.valueOf(i2));
        viewHolder.f20677a.setText(str);
        if (this.f20676d == i2) {
            viewHolder.f20678b.setVisibility(0);
            SkinManager.setBackgroundColor(viewHolder.f20678b, R.color.CAM_X0302);
            SkinManager.setBackgroundColor(viewHolder.itemView, R.color.CAM_X0205);
            SkinManager.setViewTextColor(viewHolder.f20677a, R.color.CAM_X0105);
        } else {
            viewHolder.f20678b.setVisibility(8);
            SkinManager.setBackgroundColor(viewHolder.itemView, R.color.CAM_X0204);
            SkinManager.setViewTextColor(viewHolder.f20677a, R.color.CAM_X0107);
        }
        if ("推荐".equals(m())) {
            StatisticItem statisticItem = new StatisticItem("c13641");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", 3);
            TiebaStatic.log(statisticItem);
        }
        viewHolder.itemView.setOnClickListener(new a(i2, viewHolder, str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: o */
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return new ViewHolder(this, LayoutInflater.from(this.f20673a).inflate(R.layout.left_item_layout, viewGroup, false));
    }

    public void p(int i2, List<String> list) {
        this.f20676d = i2;
        this.f20675c = list;
        notifyDataSetChanged();
    }

    public void q(b bVar) {
        this.f20674b = bVar;
    }

    public void r(int i2) {
        this.f20676d = i2;
        notifyDataSetChanged();
    }
}
