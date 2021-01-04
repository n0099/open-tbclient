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
/* loaded from: classes11.dex */
public class b extends BaseAdapter {
    private ArrayList<a.C0888a> eYq = new ArrayList<>();
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private String mRoomId;
    private int mType;
    private a oko;

    /* loaded from: classes11.dex */
    public interface a {
        void bUL();
    }

    public b(TbPageContext tbPageContext, String str, String str2, String str3, int i) {
        this.mPageContext = tbPageContext;
        this.mType = i;
        this.mRoomId = str3;
        this.mLiveId = str;
        this.mGroupId = str2;
    }

    public void setData(List<a.C0888a> list) {
        if (list != null) {
            this.eYq.clear();
            this.eYq.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eYq == null) {
            return 0;
        }
        return this.eYq.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: MW */
    public a.C0888a getItem(int i) {
        if (this.eYq == null) {
            return null;
        }
        return this.eYq.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0889b c0889b;
        a.C0888a item;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.yuyin_sdk_banned_post_list_item, viewGroup, false);
            C0889b c0889b2 = new C0889b();
            c0889b2.okq = (BannedPostItemView) view.findViewById(a.f.item);
            view.setTag(c0889b2);
            c0889b = c0889b2;
        } else {
            c0889b = (C0889b) view.getTag();
        }
        if (c0889b != null && getItem(i) != null && (item = getItem(i)) != null) {
            c0889b.okq.setData(item, this.mLiveId, this.mGroupId, this.mRoomId, this.mType);
            c0889b.okq.setCallBack(new BannedPostItemView.a() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.b.1
                @Override // com.baidu.tieba.yuyinala.charm.bannedpost.BannedPostItemView.a
                public void VM(String str) {
                    Iterator it = b.this.eYq.iterator();
                    while (it.hasNext()) {
                        a.C0888a c0888a = (a.C0888a) it.next();
                        if (str.equals(c0888a.uk)) {
                            b.this.eYq.remove(c0888a);
                        }
                    }
                    b.this.notifyDataSetChanged();
                    if ((b.this.eYq == null || b.this.eYq.size() == 0) && b.this.oko != null) {
                        b.this.oko.bUL();
                    }
                }
            });
        }
        this.mPageContext.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* renamed from: com.baidu.tieba.yuyinala.charm.bannedpost.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0889b {
        private BannedPostItemView okq;

        private C0889b() {
        }
    }

    public void a(a aVar) {
        this.oko = aVar;
    }
}
