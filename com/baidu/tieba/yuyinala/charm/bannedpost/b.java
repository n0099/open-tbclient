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
    private ArrayList<a.C0926a> eYq = new ArrayList<>();
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private String mRoomId;
    private int mType;
    private a okn;

    /* loaded from: classes11.dex */
    public interface a {
        void bUM();
    }

    public b(TbPageContext tbPageContext, String str, String str2, String str3, int i) {
        this.mPageContext = tbPageContext;
        this.mType = i;
        this.mRoomId = str3;
        this.mLiveId = str;
        this.mGroupId = str2;
    }

    public void setData(List<a.C0926a> list) {
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
    public a.C0926a getItem(int i) {
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
        C0927b c0927b;
        a.C0926a item;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.yuyin_sdk_banned_post_list_item, viewGroup, false);
            C0927b c0927b2 = new C0927b();
            c0927b2.okp = (BannedPostItemView) view.findViewById(a.f.item);
            view.setTag(c0927b2);
            c0927b = c0927b2;
        } else {
            c0927b = (C0927b) view.getTag();
        }
        if (c0927b != null && getItem(i) != null && (item = getItem(i)) != null) {
            c0927b.okp.setData(item, this.mLiveId, this.mGroupId, this.mRoomId, this.mType);
            c0927b.okp.setCallBack(new BannedPostItemView.a() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.b.1
                @Override // com.baidu.tieba.yuyinala.charm.bannedpost.BannedPostItemView.a
                public void VL(String str) {
                    Iterator it = b.this.eYq.iterator();
                    while (it.hasNext()) {
                        a.C0926a c0926a = (a.C0926a) it.next();
                        if (str.equals(c0926a.uk)) {
                            b.this.eYq.remove(c0926a);
                        }
                    }
                    b.this.notifyDataSetChanged();
                    if ((b.this.eYq == null || b.this.eYq.size() == 0) && b.this.okn != null) {
                        b.this.okn.bUM();
                    }
                }
            });
        }
        this.mPageContext.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* renamed from: com.baidu.tieba.yuyinala.charm.bannedpost.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0927b {
        private BannedPostItemView okp;

        private C0927b() {
        }
    }

    public void a(a aVar) {
        this.okn = aVar;
    }
}
