package com.baidu.yuyinala.privatemessage.session.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.sdk.a;
import com.baidu.yuyinala.privatemessage.session.b.j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private LayoutInflater kzG;
    private Context mContext;
    private List<com.baidu.yuyinala.privatemessage.session.b.a> mDatas = new ArrayList();
    private Set<com.baidu.yuyinala.privatemessage.session.b.a> pjK = new HashSet();

    public a(Context context, List<com.baidu.yuyinala.privatemessage.session.b.a> list) {
        this.mContext = context;
        this.mDatas.clear();
        this.mDatas.addAll(list);
        if (this.mContext != null) {
            this.kzG = LayoutInflater.from(context);
        }
    }

    public void Oh(int i) {
        if (this.mDatas != null && this.mDatas.size() > i && i >= 0) {
            this.mDatas.remove(i);
            notifyDataSetChanged();
        }
    }

    public void setData(List<com.baidu.yuyinala.privatemessage.session.b.a> list) {
        this.mDatas.clear();
        if (list != null) {
            this.mDatas.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void cv(List<com.baidu.yuyinala.privatemessage.session.b.a> list) {
        for (int i = 0; i < list.size(); i++) {
            this.mDatas.add(list.get(i));
        }
        notifyDataSetChanged();
    }

    public void a(com.baidu.yuyinala.privatemessage.session.b.a aVar) {
        if (aVar != null) {
            for (int i = 0; i < this.mDatas.size(); i++) {
                if ((this.mDatas.get(i) instanceof j) && (aVar instanceof j) && ((j) this.mDatas.get(i)).contacter == ((j) aVar).contacter) {
                    this.mDatas.remove(i);
                }
            }
            this.mDatas.add(0, aVar);
            notifyDataSetChanged();
        }
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
    /* renamed from: Oi */
    public com.baidu.yuyinala.privatemessage.session.b.a getItem(int i) {
        return this.mDatas.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        com.baidu.yuyinala.privatemessage.session.viewholder.a aVar;
        if (view == null && this.kzG != null) {
            view = this.kzG.inflate(a.g.yuyin_item_user_message, viewGroup, false);
            com.baidu.yuyinala.privatemessage.session.viewholder.a aVar2 = new com.baidu.yuyinala.privatemessage.session.viewholder.a(view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (com.baidu.yuyinala.privatemessage.session.viewholder.a) view.getTag();
        }
        if ((getItem(i) instanceof j) && aVar != null) {
            aVar.a((j) getItem(i));
        }
        return view;
    }
}
