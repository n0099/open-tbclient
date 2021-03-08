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
/* loaded from: classes10.dex */
public class b extends BaseAdapter {
    private ArrayList<a.C0920a> eXu = new ArrayList<>();
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private String mRoomId;
    private int mType;
    private a osi;

    /* loaded from: classes10.dex */
    public interface a {
        void bRL();
    }

    public b(TbPageContext tbPageContext, String str, String str2, String str3, int i) {
        this.mPageContext = tbPageContext;
        this.mType = i;
        this.mRoomId = str3;
        this.mLiveId = str;
        this.mGroupId = str2;
    }

    public void setData(List<a.C0920a> list) {
        if (list != null) {
            this.eXu.clear();
            this.eXu.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eXu == null) {
            return 0;
        }
        return this.eXu.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: LO */
    public a.C0920a getItem(int i) {
        if (this.eXu == null) {
            return null;
        }
        return this.eXu.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0921b c0921b;
        a.C0920a item;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.yuyin_sdk_banned_post_list_item, viewGroup, false);
            C0921b c0921b2 = new C0921b();
            c0921b2.osk = (BannedPostItemView) view.findViewById(a.f.item);
            view.setTag(c0921b2);
            c0921b = c0921b2;
        } else {
            c0921b = (C0921b) view.getTag();
        }
        if (c0921b != null && getItem(i) != null && (item = getItem(i)) != null) {
            c0921b.osk.setData(item, this.mLiveId, this.mGroupId, this.mRoomId, this.mType);
            c0921b.osk.setCallBack(new BannedPostItemView.a() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.b.1
                @Override // com.baidu.tieba.yuyinala.charm.bannedpost.BannedPostItemView.a
                public void VV(String str) {
                    Iterator it = b.this.eXu.iterator();
                    while (it.hasNext()) {
                        a.C0920a c0920a = (a.C0920a) it.next();
                        if (str.equals(c0920a.uk)) {
                            b.this.eXu.remove(c0920a);
                        }
                    }
                    b.this.notifyDataSetChanged();
                    if ((b.this.eXu == null || b.this.eXu.size() == 0) && b.this.osi != null) {
                        b.this.osi.bRL();
                    }
                }
            });
        }
        this.mPageContext.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* renamed from: com.baidu.tieba.yuyinala.charm.bannedpost.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private class C0921b {
        private BannedPostItemView osk;

        private C0921b() {
        }
    }

    public void a(a aVar) {
        this.osi = aVar;
    }
}
