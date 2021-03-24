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
    public Context f21173a;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f21175c;

    /* renamed from: b  reason: collision with root package name */
    public b f21174b = null;

    /* renamed from: d  reason: collision with root package name */
    public int f21176d = 0;

    /* loaded from: classes5.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f21177a;

        /* renamed from: b  reason: collision with root package name */
        public View f21178b;

        public ViewHolder(@NonNull LeftAdapter leftAdapter, View view) {
            super(view);
            this.f21177a = (TextView) view.findViewById(R.id.tv_class_name);
            this.f21178b = view.findViewById(R.id.tv_line);
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f21179e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewHolder f21180f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f21181g;

        public a(int i, ViewHolder viewHolder, String str) {
            this.f21179e = i;
            this.f21180f = viewHolder;
            this.f21181g = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LeftAdapter.this.r(this.f21179e);
            if (LeftAdapter.this.f21174b != null) {
                LeftAdapter.this.f21174b.a(this.f21180f.itemView, this.f21179e, this.f21181g);
            }
            StatisticItem statisticItem = new StatisticItem("c13649");
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f21181g);
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(View view, int i, String str);
    }

    public LeftAdapter(Context context) {
        this.f21173a = context;
    }

    public String g(int i) {
        return (String) ListUtils.getItem(this.f21175c, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<String> list = this.f21175c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int h(String str) {
        return ListUtils.getPosition(this.f21175c, str);
    }

    public String m() {
        return g(this.f21176d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n */
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String str = this.f21175c.get(i);
        viewHolder.itemView.setTag(Integer.valueOf(i));
        viewHolder.f21177a.setText(str);
        if (this.f21176d == i) {
            viewHolder.f21178b.setVisibility(0);
            SkinManager.setBackgroundColor(viewHolder.f21178b, R.color.CAM_X0302);
            SkinManager.setBackgroundColor(viewHolder.itemView, R.color.CAM_X0205);
            SkinManager.setViewTextColor(viewHolder.f21177a, R.color.CAM_X0105);
        } else {
            viewHolder.f21178b.setVisibility(8);
            SkinManager.setBackgroundColor(viewHolder.itemView, R.color.CAM_X0204);
            SkinManager.setViewTextColor(viewHolder.f21177a, R.color.CAM_X0107);
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
        return new ViewHolder(this, LayoutInflater.from(this.f21173a).inflate(R.layout.left_item_layout, viewGroup, false));
    }

    public void p(int i, List<String> list) {
        this.f21176d = i;
        this.f21175c = list;
        notifyDataSetChanged();
    }

    public void q(b bVar) {
        this.f21174b = bVar;
    }

    public void r(int i) {
        this.f21176d = i;
        notifyDataSetChanged();
    }
}
