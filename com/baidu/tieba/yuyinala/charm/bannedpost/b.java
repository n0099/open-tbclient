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
    private ArrayList<a.C0909a> eTF = new ArrayList<>();
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private String mRoomId;
    private int mType;
    private a ofJ;

    /* loaded from: classes10.dex */
    public interface a {
        void bQU();
    }

    public b(TbPageContext tbPageContext, String str, String str2, String str3, int i) {
        this.mPageContext = tbPageContext;
        this.mType = i;
        this.mRoomId = str3;
        this.mLiveId = str;
        this.mGroupId = str2;
    }

    public void setData(List<a.C0909a> list) {
        if (list != null) {
            this.eTF.clear();
            this.eTF.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eTF == null) {
            return 0;
        }
        return this.eTF.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Lp */
    public a.C0909a getItem(int i) {
        if (this.eTF == null) {
            return null;
        }
        return this.eTF.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0910b c0910b;
        a.C0909a item;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.yuyin_sdk_banned_post_list_item, viewGroup, false);
            C0910b c0910b2 = new C0910b();
            c0910b2.ofL = (BannedPostItemView) view.findViewById(a.f.item);
            view.setTag(c0910b2);
            c0910b = c0910b2;
        } else {
            c0910b = (C0910b) view.getTag();
        }
        if (c0910b != null && getItem(i) != null && (item = getItem(i)) != null) {
            c0910b.ofL.setData(item, this.mLiveId, this.mGroupId, this.mRoomId, this.mType);
            c0910b.ofL.setCallBack(new BannedPostItemView.a() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.b.1
                @Override // com.baidu.tieba.yuyinala.charm.bannedpost.BannedPostItemView.a
                public void UE(String str) {
                    Iterator it = b.this.eTF.iterator();
                    while (it.hasNext()) {
                        a.C0909a c0909a = (a.C0909a) it.next();
                        if (str.equals(c0909a.uk)) {
                            b.this.eTF.remove(c0909a);
                        }
                    }
                    b.this.notifyDataSetChanged();
                    if ((b.this.eTF == null || b.this.eTF.size() == 0) && b.this.ofJ != null) {
                        b.this.ofJ.bQU();
                    }
                }
            });
        }
        this.mPageContext.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* renamed from: com.baidu.tieba.yuyinala.charm.bannedpost.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private class C0910b {
        private BannedPostItemView ofL;

        private C0910b() {
        }
    }

    public void a(a aVar) {
        this.ofJ = aVar;
    }
}
