package com.baidu.tieba.yuyinala.charm.bannedpost;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.charm.bannedpost.BannedPostItemView;
import com.baidu.tieba.yuyinala.charm.bannedpost.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {
    private ArrayList<a.C0879a> eCX = new ArrayList<>();
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private String mRoomId;
    private int mType;
    private a nMh;

    /* loaded from: classes4.dex */
    public interface a {
        void bME();
    }

    public b(TbPageContext tbPageContext, String str, String str2, String str3, int i) {
        this.mPageContext = tbPageContext;
        this.mType = i;
        this.mRoomId = str3;
        this.mLiveId = str;
        this.mGroupId = str2;
    }

    public void setData(List<a.C0879a> list) {
        if (list != null) {
            this.eCX.clear();
            this.eCX.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eCX == null) {
            return 0;
        }
        return this.eCX.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: LC */
    public a.C0879a getItem(int i) {
        if (this.eCX == null) {
            return null;
        }
        return this.eCX.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0880b c0880b;
        a.C0879a item;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(a.h.yuyin_sdk_banned_post_list_item, viewGroup, false);
            C0880b c0880b2 = new C0880b();
            c0880b2.nMj = (BannedPostItemView) view.findViewById(a.g.item);
            view.setTag(c0880b2);
            c0880b = c0880b2;
        } else {
            c0880b = (C0880b) view.getTag();
        }
        if (c0880b != null && getItem(i) != null && (item = getItem(i)) != null) {
            c0880b.nMj.setData(item, this.mLiveId, this.mGroupId, this.mRoomId, this.mType);
            c0880b.nMj.setCallBack(new BannedPostItemView.a() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.b.1
                @Override // com.baidu.tieba.yuyinala.charm.bannedpost.BannedPostItemView.a
                public void UV(String str) {
                    Iterator it = b.this.eCX.iterator();
                    while (it.hasNext()) {
                        a.C0879a c0879a = (a.C0879a) it.next();
                        if (str.equals(c0879a.uk)) {
                            b.this.eCX.remove(c0879a);
                        }
                    }
                    b.this.notifyDataSetChanged();
                    if ((b.this.eCX == null || b.this.eCX.size() == 0) && b.this.nMh != null) {
                        b.this.nMh.bME();
                    }
                }
            });
        }
        this.mPageContext.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* renamed from: com.baidu.tieba.yuyinala.charm.bannedpost.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0880b {
        private BannedPostItemView nMj;

        private C0880b() {
        }
    }

    public void a(a aVar) {
        this.nMh = aVar;
    }
}
