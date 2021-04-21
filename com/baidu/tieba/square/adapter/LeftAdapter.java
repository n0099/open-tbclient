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
/* loaded from: classes4.dex */
public class LeftAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public Context f20867a;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f20869c;

    /* renamed from: b  reason: collision with root package name */
    public b f20868b = null;

    /* renamed from: d  reason: collision with root package name */
    public int f20870d = 0;

    /* loaded from: classes4.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f20871a;

        /* renamed from: b  reason: collision with root package name */
        public View f20872b;

        public ViewHolder(@NonNull LeftAdapter leftAdapter, View view) {
            super(view);
            this.f20871a = (TextView) view.findViewById(R.id.tv_class_name);
            this.f20872b = view.findViewById(R.id.tv_line);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f20873e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewHolder f20874f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f20875g;

        public a(int i, ViewHolder viewHolder, String str) {
            this.f20873e = i;
            this.f20874f = viewHolder;
            this.f20875g = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LeftAdapter.this.r(this.f20873e);
            if (LeftAdapter.this.f20868b != null) {
                LeftAdapter.this.f20868b.a(this.f20874f.itemView, this.f20873e, this.f20875g);
            }
            StatisticItem statisticItem = new StatisticItem("c13649");
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f20875g);
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(View view, int i, String str);
    }

    public LeftAdapter(Context context) {
        this.f20867a = context;
    }

    public String g(int i) {
        return (String) ListUtils.getItem(this.f20869c, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<String> list = this.f20869c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int h(String str) {
        return ListUtils.getPosition(this.f20869c, str);
    }

    public String m() {
        return g(this.f20870d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n */
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String str = this.f20869c.get(i);
        viewHolder.itemView.setTag(Integer.valueOf(i));
        viewHolder.f20871a.setText(str);
        if (this.f20870d == i) {
            viewHolder.f20872b.setVisibility(0);
            SkinManager.setBackgroundColor(viewHolder.f20872b, R.color.CAM_X0302);
            SkinManager.setBackgroundColor(viewHolder.itemView, R.color.CAM_X0205);
            SkinManager.setViewTextColor(viewHolder.f20871a, R.color.CAM_X0105);
        } else {
            viewHolder.f20872b.setVisibility(8);
            SkinManager.setBackgroundColor(viewHolder.itemView, R.color.CAM_X0204);
            SkinManager.setViewTextColor(viewHolder.f20871a, R.color.CAM_X0107);
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
        return new ViewHolder(this, LayoutInflater.from(this.f20867a).inflate(R.layout.left_item_layout, viewGroup, false));
    }

    public void p(int i, List<String> list) {
        this.f20870d = i;
        this.f20869c = list;
        notifyDataSetChanged();
    }

    public void q(b bVar) {
        this.f20868b = bVar;
    }

    public void r(int i) {
        this.f20870d = i;
        notifyDataSetChanged();
    }
}
