package com.baidu.tieba.mainentrance;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private View.OnClickListener bKS;
    private BaseActivity<?> bix;
    private List<c> cKv;

    public b(BaseActivity<?> baseActivity) {
        this.bix = baseActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cKv == null) {
            return 0;
        }
        if (this.cKv.size() >= 8) {
            return 4;
        }
        return this.cKv.size() / 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: kP */
    public c getItem(int i) {
        return (c) com.baidu.tbadk.core.util.y.b(this.cKv, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.bix.getPageContext().getPageActivity()).inflate(t.h.square_search_recommand_fourm_item, (ViewGroup) null);
            aVar = new a(this, null);
            ArrayList<View> arrayList = new ArrayList();
            arrayList.add(view.findViewById(t.g.recommand_forum_item_left));
            arrayList.add(view.findViewById(t.g.recommand_forum_item_right));
            for (View view2 : arrayList) {
                C0071b c0071b = new C0071b(this, null);
                c0071b.cEY = (BarImageView) view2.findViewById(t.g.forum_avatar);
                c0071b.cEY.setGifIconSupport(false);
                c0071b.aRQ = (TextView) view2.findViewById(t.g.name);
                c0071b.cEZ = (TextView) view2.findViewById(t.g.member_count);
                view2.setOnClickListener(this.bKS);
                c0071b.cKy = view2;
                aVar.cKw.add(c0071b);
            }
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < aVar.cKw.size()) {
                c cVar = (c) com.baidu.tbadk.core.util.y.b(this.cKv, (i * 2) + i3);
                C0071b c0071b2 = (C0071b) com.baidu.tbadk.core.util.y.b(aVar.cKw, i3);
                if (cVar == null || c0071b2 == null) {
                    break;
                }
                String aor = cVar.aor();
                c0071b2.cEY.setTag(aor);
                c0071b2.cEY.c(aor, 10, false);
                c0071b2.aRQ.setText(cVar.getForumName());
                c0071b2.cEZ.setText(String.valueOf(this.bix.getPageContext().getString(t.j.forum_list_attention_tv)) + bp(cVar.aos() > 0 ? cVar.aos() : 0L));
                c0071b2.cKy.setTag(Integer.valueOf((i * 2) + i3));
                i2 = i3 + 1;
            } else {
                this.bix.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
                this.bix.getLayoutMode().x(view);
            }
        }
        return view;
    }

    public String bp(long j) {
        if (j >= 100000) {
            return ay.E(j);
        }
        return String.valueOf(j);
    }

    /* renamed from: com.baidu.tieba.mainentrance.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0071b {
        TextView aRQ;
        BarImageView cEY;
        TextView cEZ;
        View cKy;

        private C0071b() {
        }

        /* synthetic */ C0071b(b bVar, C0071b c0071b) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private class a {
        List<C0071b> cKw;

        private a() {
            this.cKw = new ArrayList();
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }

    public void y(View.OnClickListener onClickListener) {
        this.bKS = onClickListener;
    }
}
