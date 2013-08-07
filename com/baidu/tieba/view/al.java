package com.baidu.tieba.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.slidingmenu.lib.R;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ai f1816a;

    private al(ai aiVar) {
        this.f1816a = aiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ al(ai aiVar, al alVar) {
        this(aiVar);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List list;
        list = this.f1816a.k;
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List list;
        list = this.f1816a.k;
        return list.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        List list;
        int i2;
        Context context;
        Context context2;
        Context context3;
        list = this.f1816a.k;
        com.baidu.tieba.data.bl blVar = (com.baidu.tieba.data.bl) list.get(i);
        if (view == null) {
            context3 = this.f1816a.f1813a;
            view = LayoutInflater.from(context3).inflate(R.layout.allinterest_list_item, viewGroup, false);
            an anVar = new an(this);
            anVar.f1818a = (TextView) view.findViewById(R.id.list_item_title);
            view.setTag(anVar);
        }
        an anVar2 = (an) view.getTag();
        anVar2.f1818a.setText(blVar.b());
        i2 = this.f1816a.m;
        if (i2 == 1) {
            TextView textView = anVar2.f1818a;
            context2 = this.f1816a.f1813a;
            textView.setTextColor(context2.getResources().getColor(R.color.c_acc5e0));
        } else {
            TextView textView2 = anVar2.f1818a;
            context = this.f1816a.f1813a;
            textView2.setTextColor(context.getResources().getColor(R.color.c_ffffff));
        }
        anVar2.f1818a.setOnClickListener(new am(this, blVar));
        return view;
    }
}
