package com.baidu.tieba.write.selectForum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private HotTopicChangeFourmActivity hMS;
    private final Context mContext;
    private List<HotTopicBussinessData> mData;
    private ViewGroup mParent = null;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.hMS = hotTopicChangeFourmActivity;
        this.mContext = this.hMS.getPageContext().getContext();
    }

    public void setData(List<HotTopicBussinessData> list) {
        this.mData = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.I(this.mData)) {
            return 0;
        }
        return this.mData.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wN */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String wZ(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (str.length() > 14) {
            return str.substring(0, 13) + "...";
        }
        return str;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0323a c0323a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0323a = a(view != null ? view.getTag() : null, item);
        } else {
            c0323a = null;
        }
        if (c0323a != null) {
            return c0323a.mRootView;
        }
        return null;
    }

    private C0323a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0323a c0323a;
        if (obj == null) {
            c0323a = bMf();
        } else {
            c0323a = (C0323a) obj;
        }
        c0323a.hMU.setText(wZ(hotTopicBussinessData.mForumName));
        c0323a.hMT.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        al.i(c0323a.mRootView, e.f.select_forum_item_bg);
        al.h(c0323a.hMU, e.d.cp_cont_b);
        al.j(c0323a.dKU, e.d.cp_bg_line_e);
        return c0323a;
    }

    private C0323a bMf() {
        C0323a c0323a = new C0323a();
        c0323a.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.hot_topic_change_item, (ViewGroup) null);
        al.i(c0323a.mRootView, e.f.select_forum_item_bg);
        al.h(c0323a.hMU, e.d.cp_cont_b);
        c0323a.hMU = (TextView) c0323a.mRootView.findViewById(e.g.fourm_tv);
        c0323a.dKU = c0323a.mRootView.findViewById(e.g.line_view);
        c0323a.hMT = (TbImageView) c0323a.mRootView.findViewById(e.g.icon_img);
        c0323a.hMT.setDefaultBgResource(e.d.cp_bg_line_e);
        c0323a.hMT.setDefaultResource(e.f.transparent_bg);
        c0323a.hMT.setDefaultErrorResource(e.f.icon_default_ba_120);
        c0323a.mRootView.setTag(c0323a);
        return c0323a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0323a {
        public View dKU;
        public TbImageView hMT;
        public TextView hMU;
        public View mRootView;

        private C0323a() {
        }
    }
}
