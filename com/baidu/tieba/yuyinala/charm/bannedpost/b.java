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
    private ArrayList<a.C0912a> eVV = new ArrayList<>();
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private String mRoomId;
    private int mType;
    private a opC;

    /* loaded from: classes11.dex */
    public interface a {
        void bRy();
    }

    public b(TbPageContext tbPageContext, String str, String str2, String str3, int i) {
        this.mPageContext = tbPageContext;
        this.mType = i;
        this.mRoomId = str3;
        this.mLiveId = str;
        this.mGroupId = str2;
    }

    public void setData(List<a.C0912a> list) {
        if (list != null) {
            this.eVV.clear();
            this.eVV.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eVV == null) {
            return 0;
        }
        return this.eVV.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: LJ */
    public a.C0912a getItem(int i) {
        if (this.eVV == null) {
            return null;
        }
        return this.eVV.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0913b c0913b;
        a.C0912a item;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.yuyin_sdk_banned_post_list_item, viewGroup, false);
            C0913b c0913b2 = new C0913b();
            c0913b2.opE = (BannedPostItemView) view.findViewById(a.f.item);
            view.setTag(c0913b2);
            c0913b = c0913b2;
        } else {
            c0913b = (C0913b) view.getTag();
        }
        if (c0913b != null && getItem(i) != null && (item = getItem(i)) != null) {
            c0913b.opE.setData(item, this.mLiveId, this.mGroupId, this.mRoomId, this.mType);
            c0913b.opE.setCallBack(new BannedPostItemView.a() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.b.1
                @Override // com.baidu.tieba.yuyinala.charm.bannedpost.BannedPostItemView.a
                public void VC(String str) {
                    Iterator it = b.this.eVV.iterator();
                    while (it.hasNext()) {
                        a.C0912a c0912a = (a.C0912a) it.next();
                        if (str.equals(c0912a.uk)) {
                            b.this.eVV.remove(c0912a);
                        }
                    }
                    b.this.notifyDataSetChanged();
                    if ((b.this.eVV == null || b.this.eVV.size() == 0) && b.this.opC != null) {
                        b.this.opC.bRy();
                    }
                }
            });
        }
        this.mPageContext.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* renamed from: com.baidu.tieba.yuyinala.charm.bannedpost.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0913b {
        private BannedPostItemView opE;

        private C0913b() {
        }
    }

    public void a(a aVar) {
        this.opC = aVar;
    }
}
