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
    private ArrayList<a.C0897a> eHj = new ArrayList<>();
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private String mRoomId;
    private int mType;
    private a nTE;

    /* loaded from: classes4.dex */
    public interface a {
        void bOx();
    }

    public b(TbPageContext tbPageContext, String str, String str2, String str3, int i) {
        this.mPageContext = tbPageContext;
        this.mType = i;
        this.mRoomId = str3;
        this.mLiveId = str;
        this.mGroupId = str2;
    }

    public void setData(List<a.C0897a> list) {
        if (list != null) {
            this.eHj.clear();
            this.eHj.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eHj == null) {
            return 0;
        }
        return this.eHj.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Ms */
    public a.C0897a getItem(int i) {
        if (this.eHj == null) {
            return null;
        }
        return this.eHj.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0898b c0898b;
        a.C0897a item;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.yuyin_sdk_banned_post_list_item, viewGroup, false);
            C0898b c0898b2 = new C0898b();
            c0898b2.nTG = (BannedPostItemView) view.findViewById(a.f.item);
            view.setTag(c0898b2);
            c0898b = c0898b2;
        } else {
            c0898b = (C0898b) view.getTag();
        }
        if (c0898b != null && getItem(i) != null && (item = getItem(i)) != null) {
            c0898b.nTG.setData(item, this.mLiveId, this.mGroupId, this.mRoomId, this.mType);
            c0898b.nTG.setCallBack(new BannedPostItemView.a() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.b.1
                @Override // com.baidu.tieba.yuyinala.charm.bannedpost.BannedPostItemView.a
                public void UX(String str) {
                    Iterator it = b.this.eHj.iterator();
                    while (it.hasNext()) {
                        a.C0897a c0897a = (a.C0897a) it.next();
                        if (str.equals(c0897a.uk)) {
                            b.this.eHj.remove(c0897a);
                        }
                    }
                    b.this.notifyDataSetChanged();
                    if ((b.this.eHj == null || b.this.eHj.size() == 0) && b.this.nTE != null) {
                        b.this.nTE.bOx();
                    }
                }
            });
        }
        this.mPageContext.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* renamed from: com.baidu.tieba.yuyinala.charm.bannedpost.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0898b {
        private BannedPostItemView nTG;

        private C0898b() {
        }
    }

    public void a(a aVar) {
        this.nTE = aVar;
    }
}
