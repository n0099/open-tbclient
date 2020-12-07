package com.baidu.yuyinala.privatemessage.session.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.sdk.a;
import com.baidu.yuyinala.privatemessage.session.b.j;
import com.baidu.yuyinala.privatemessage.session.view.c;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes4.dex */
public class a extends c {
    private LayoutInflater kiE;
    private Context mContext;
    private List<com.baidu.yuyinala.privatemessage.session.b.a> mDatas;
    private Set<com.baidu.yuyinala.privatemessage.session.b.a> oXn = new HashSet();

    public a(Context context, List<com.baidu.yuyinala.privatemessage.session.b.a> list) {
        this.mContext = context;
        this.mDatas = list;
        if (this.mContext != null) {
            this.kiE = LayoutInflater.from(context);
        }
    }

    public void PE(int i) {
        if (this.mDatas != null && this.mDatas.size() > i && i >= 0) {
            this.mDatas.remove(i);
            notifyDataSetChanged();
        }
    }

    public void setData(List<com.baidu.yuyinala.privatemessage.session.b.a> list) {
        this.mDatas = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mDatas != null) {
            return this.mDatas.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: PF */
    public com.baidu.yuyinala.privatemessage.session.b.a getItem(int i) {
        return this.mDatas.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        com.baidu.yuyinala.privatemessage.session.d.a aVar;
        if (view == null && this.kiE != null) {
            view = this.kiE.inflate(a.g.yuyin_item_user_message, viewGroup, false);
            com.baidu.yuyinala.privatemessage.session.d.a aVar2 = new com.baidu.yuyinala.privatemessage.session.d.a(view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (com.baidu.yuyinala.privatemessage.session.d.a) view.getTag();
        }
        if ((getItem(i) instanceof j) && aVar != null) {
            aVar.a((j) getItem(i));
        }
        return super.m(i, view);
    }
}
