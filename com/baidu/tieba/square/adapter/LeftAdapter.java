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
    public Context f21174a;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f21176c;

    /* renamed from: b  reason: collision with root package name */
    public b f21175b = null;

    /* renamed from: d  reason: collision with root package name */
    public int f21177d = 0;

    /* loaded from: classes5.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f21178a;

        /* renamed from: b  reason: collision with root package name */
        public View f21179b;

        public ViewHolder(@NonNull LeftAdapter leftAdapter, View view) {
            super(view);
            this.f21178a = (TextView) view.findViewById(R.id.tv_class_name);
            this.f21179b = view.findViewById(R.id.tv_line);
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f21180e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewHolder f21181f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f21182g;

        public a(int i, ViewHolder viewHolder, String str) {
            this.f21180e = i;
            this.f21181f = viewHolder;
            this.f21182g = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LeftAdapter.this.r(this.f21180e);
            if (LeftAdapter.this.f21175b != null) {
                LeftAdapter.this.f21175b.a(this.f21181f.itemView, this.f21180e, this.f21182g);
            }
            StatisticItem statisticItem = new StatisticItem("c13649");
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f21182g);
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(View view, int i, String str);
    }

    public LeftAdapter(Context context) {
        this.f21174a = context;
    }

    public String g(int i) {
        return (String) ListUtils.getItem(this.f21176c, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<String> list = this.f21176c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int h(String str) {
        return ListUtils.getPosition(this.f21176c, str);
    }

    public String m() {
        return g(this.f21177d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n */
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String str = this.f21176c.get(i);
        viewHolder.itemView.setTag(Integer.valueOf(i));
        viewHolder.f21178a.setText(str);
        if (this.f21177d == i) {
            viewHolder.f21179b.setVisibility(0);
            SkinManager.setBackgroundColor(viewHolder.f21179b, R.color.CAM_X0302);
            SkinManager.setBackgroundColor(viewHolder.itemView, R.color.CAM_X0205);
            SkinManager.setViewTextColor(viewHolder.f21178a, R.color.CAM_X0105);
        } else {
            viewHolder.f21179b.setVisibility(8);
            SkinManager.setBackgroundColor(viewHolder.itemView, R.color.CAM_X0204);
            SkinManager.setViewTextColor(viewHolder.f21178a, R.color.CAM_X0107);
        }
        if ("推荐".equals(m())) {
            StatisticItem statisticItem = new StatisticItem("c13641");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", 3);
            TiebaStatic.log(statisticItem);
        }
        viewHolder.itemView.setOnClickListener(new a(i, viewHolder, str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: o */
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(this, LayoutInflater.from(this.f21174a).inflate(R.layout.left_item_layout, viewGroup, false));
    }

    public void p(int i, List<String> list) {
        this.f21177d = i;
        this.f21176c = list;
        notifyDataSetChanged();
    }

    public void q(b bVar) {
        this.f21175b = bVar;
    }

    public void r(int i) {
        this.f21177d = i;
        notifyDataSetChanged();
    }
}
