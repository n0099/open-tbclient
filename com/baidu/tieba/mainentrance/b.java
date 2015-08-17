package com.baidu.tieba.mainentrance;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private BaseActivity<?> aSJ;
    private List<c> bPG;

    public b(BaseActivity<?> baseActivity) {
        this.aSJ = baseActivity;
    }

    public void aP(List<c> list) {
        this.bPG = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bPG == null) {
            return 0;
        }
        return this.bPG.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: hI */
    public c getItem(int i) {
        int count = getCount();
        if (i < 0 || i >= count) {
            return null;
        }
        return this.bPG.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.aSJ.getPageContext().getPageActivity()).inflate(i.g.square_dialog_search_item, (ViewGroup) null);
            a aVar2 = new a(this, null);
            aVar2.bOK = (BarImageView) view.findViewById(i.f.forum_avatar);
            aVar2.bOK.setGifIconSupport(false);
            aVar2.aOi = (TextView) view.findViewById(i.f.name);
            aVar2.bOL = (TextView) view.findViewById(i.f.member_count);
            aVar2.bOM = (TextView) view.findViewById(i.f.thread_count);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        c item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            String ZM = item.ZM();
            aVar.bOK.setTag(ZM);
            aVar.bOK.d(ZM, 10, false);
            aVar.aOi.setText(item.getForumName());
            aVar.bOL.setText(String.valueOf(this.aSJ.getPageContext().getString(i.C0057i.forum_list_attention_tv)) + ar(item.ZN()));
            aVar.bOM.setText(String.valueOf(this.aSJ.getPageContext().getString(i.C0057i.forum_list_thread_tv)) + ar(item.ZO()));
            if (i == getCount() - 1) {
                view.findViewById(i.f.square_lv_search_forum_divider).setVisibility(8);
            } else {
                view.findViewById(i.f.square_lv_search_forum_divider).setVisibility(0);
            }
            this.aSJ.getLayoutMode().ad(skinType == 1);
            this.aSJ.getLayoutMode().k(view);
        }
        return view;
    }

    public String ar(long j) {
        if (j >= 100000) {
            return aq.q(j);
        }
        return String.valueOf(j);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView aOi;
        BarImageView bOK;
        TextView bOL;
        TextView bOM;

        private a() {
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }
}
