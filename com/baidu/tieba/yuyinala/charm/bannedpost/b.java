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
    private ArrayList<a.C0894a> eIM = new ArrayList<>();
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private String mRoomId;
    private int mType;
    private a nSb;

    /* loaded from: classes4.dex */
    public interface a {
        void bPe();
    }

    public b(TbPageContext tbPageContext, String str, String str2, String str3, int i) {
        this.mPageContext = tbPageContext;
        this.mType = i;
        this.mRoomId = str3;
        this.mLiveId = str;
        this.mGroupId = str2;
    }

    public void setData(List<a.C0894a> list) {
        if (list != null) {
            this.eIM.clear();
            this.eIM.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eIM == null) {
            return 0;
        }
        return this.eIM.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: LP */
    public a.C0894a getItem(int i) {
        if (this.eIM == null) {
            return null;
        }
        return this.eIM.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0895b c0895b;
        a.C0894a item;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.yuyin_sdk_banned_post_list_item, viewGroup, false);
            C0895b c0895b2 = new C0895b();
            c0895b2.nSd = (BannedPostItemView) view.findViewById(a.f.item);
            view.setTag(c0895b2);
            c0895b = c0895b2;
        } else {
            c0895b = (C0895b) view.getTag();
        }
        if (c0895b != null && getItem(i) != null && (item = getItem(i)) != null) {
            c0895b.nSd.setData(item, this.mLiveId, this.mGroupId, this.mRoomId, this.mType);
            c0895b.nSd.setCallBack(new BannedPostItemView.a() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.b.1
                @Override // com.baidu.tieba.yuyinala.charm.bannedpost.BannedPostItemView.a
                public void Vm(String str) {
                    Iterator it = b.this.eIM.iterator();
                    while (it.hasNext()) {
                        a.C0894a c0894a = (a.C0894a) it.next();
                        if (str.equals(c0894a.uk)) {
                            b.this.eIM.remove(c0894a);
                        }
                    }
                    b.this.notifyDataSetChanged();
                    if ((b.this.eIM == null || b.this.eIM.size() == 0) && b.this.nSb != null) {
                        b.this.nSb.bPe();
                    }
                }
            });
        }
        this.mPageContext.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* renamed from: com.baidu.tieba.yuyinala.charm.bannedpost.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0895b {
        private BannedPostItemView nSd;

        private C0895b() {
        }
    }

    public void a(a aVar) {
        this.nSb = aVar;
    }
}
