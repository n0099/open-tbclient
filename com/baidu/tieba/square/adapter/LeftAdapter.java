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
    public Context f21432a;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f21434c;

    /* renamed from: b  reason: collision with root package name */
    public b f21433b = null;

    /* renamed from: d  reason: collision with root package name */
    public int f21435d = 0;

    /* loaded from: classes5.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f21436a;

        /* renamed from: b  reason: collision with root package name */
        public View f21437b;

        public ViewHolder(@NonNull LeftAdapter leftAdapter, View view) {
            super(view);
            this.f21436a = (TextView) view.findViewById(R.id.tv_class_name);
            this.f21437b = view.findViewById(R.id.tv_line);
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f21438e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewHolder f21439f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f21440g;

        public a(int i2, ViewHolder viewHolder, String str) {
            this.f21438e = i2;
            this.f21439f = viewHolder;
            this.f21440g = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LeftAdapter.this.k(this.f21438e);
            if (LeftAdapter.this.f21433b != null) {
                LeftAdapter.this.f21433b.a(this.f21439f.itemView, this.f21438e, this.f21440g);
            }
            StatisticItem statisticItem = new StatisticItem("c13649");
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f21440g);
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(View view, int i2, String str);
    }

    public LeftAdapter(Context context) {
        this.f21432a = context;
    }

    public String d(int i2) {
        return (String) ListUtils.getItem(this.f21434c, i2);
    }

    public int e(String str) {
        return ListUtils.getPosition(this.f21434c, str);
    }

    public String f() {
        return d(this.f21435d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i2) {
        String str = this.f21434c.get(i2);
        viewHolder.itemView.setTag(Integer.valueOf(i2));
        viewHolder.f21436a.setText(str);
        if (this.f21435d == i2) {
            viewHolder.f21437b.setVisibility(0);
            SkinManager.setBackgroundColor(viewHolder.f21437b, R.color.CAM_X0302);
            SkinManager.setBackgroundColor(viewHolder.itemView, R.color.CAM_X0205);
            SkinManager.setViewTextColor(viewHolder.f21436a, R.color.CAM_X0105);
        } else {
            viewHolder.f21437b.setVisibility(8);
            SkinManager.setBackgroundColor(viewHolder.itemView, R.color.CAM_X0204);
            SkinManager.setViewTextColor(viewHolder.f21436a, R.color.CAM_X0107);
        }
        if ("推荐".equals(f())) {
            StatisticItem statisticItem = new StatisticItem("c13641");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", 3);
            TiebaStatic.log(statisticItem);
        }
        viewHolder.itemView.setOnClickListener(new a(i2, viewHolder, str));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<String> list = this.f21434c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: h */
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return new ViewHolder(this, LayoutInflater.from(this.f21432a).inflate(R.layout.left_item_layout, viewGroup, false));
    }

    public void i(int i2, List<String> list) {
        this.f21435d = i2;
        this.f21434c = list;
        notifyDataSetChanged();
    }

    public void j(b bVar) {
        this.f21433b = bVar;
    }

    public void k(int i2) {
        this.f21435d = i2;
        notifyDataSetChanged();
    }
}
