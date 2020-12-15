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
    private ArrayList<a.C0914a> eOt = new ArrayList<>();
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private String mRoomId;
    private int mType;
    private a oiE;

    /* loaded from: classes4.dex */
    public interface a {
        void bSj();
    }

    public b(TbPageContext tbPageContext, String str, String str2, String str3, int i) {
        this.mPageContext = tbPageContext;
        this.mType = i;
        this.mRoomId = str3;
        this.mLiveId = str;
        this.mGroupId = str2;
    }

    public void setData(List<a.C0914a> list) {
        if (list != null) {
            this.eOt.clear();
            this.eOt.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eOt == null) {
            return 0;
        }
        return this.eOt.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Nk */
    public a.C0914a getItem(int i) {
        if (this.eOt == null) {
            return null;
        }
        return this.eOt.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0915b c0915b;
        a.C0914a item;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.yuyin_sdk_banned_post_list_item, viewGroup, false);
            C0915b c0915b2 = new C0915b();
            c0915b2.oiG = (BannedPostItemView) view.findViewById(a.f.item);
            view.setTag(c0915b2);
            c0915b = c0915b2;
        } else {
            c0915b = (C0915b) view.getTag();
        }
        if (c0915b != null && getItem(i) != null && (item = getItem(i)) != null) {
            c0915b.oiG.setData(item, this.mLiveId, this.mGroupId, this.mRoomId, this.mType);
            c0915b.oiG.setCallBack(new BannedPostItemView.a() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.b.1
                @Override // com.baidu.tieba.yuyinala.charm.bannedpost.BannedPostItemView.a
                public void Wm(String str) {
                    Iterator it = b.this.eOt.iterator();
                    while (it.hasNext()) {
                        a.C0914a c0914a = (a.C0914a) it.next();
                        if (str.equals(c0914a.uk)) {
                            b.this.eOt.remove(c0914a);
                        }
                    }
                    b.this.notifyDataSetChanged();
                    if ((b.this.eOt == null || b.this.eOt.size() == 0) && b.this.oiE != null) {
                        b.this.oiE.bSj();
                    }
                }
            });
        }
        this.mPageContext.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* renamed from: com.baidu.tieba.yuyinala.charm.bannedpost.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0915b {
        private BannedPostItemView oiG;

        private C0915b() {
        }
    }

    public void a(a aVar) {
        this.oiE = aVar;
    }
}
