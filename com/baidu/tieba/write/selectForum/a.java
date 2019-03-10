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
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private HotTopicChangeFourmActivity jpx;
    private final Context mContext;
    private List<HotTopicBussinessData> mData;
    private ViewGroup mParent = null;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.jpx = hotTopicChangeFourmActivity;
        this.mContext = this.jpx.getPageContext().getContext();
    }

    public void setData(List<HotTopicBussinessData> list) {
        this.mData = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.T(this.mData)) {
            return 0;
        }
        return this.mData.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Bp */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String Ew(String str) {
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
        C0317a c0317a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0317a = a(view != null ? view.getTag() : null, item);
        } else {
            c0317a = null;
        }
        if (c0317a != null) {
            return c0317a.mRootView;
        }
        return null;
    }

    private C0317a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0317a c0317a;
        if (obj == null) {
            c0317a = cpB();
        } else {
            c0317a = (C0317a) obj;
        }
        c0317a.jpz.setText(Ew(hotTopicBussinessData.mForumName));
        c0317a.jpy.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        al.k(c0317a.mRootView, d.f.select_forum_item_bg);
        al.j(c0317a.jpz, d.C0236d.cp_cont_b);
        al.l(c0317a.fiL, d.C0236d.cp_bg_line_e);
        return c0317a;
    }

    private C0317a cpB() {
        C0317a c0317a = new C0317a();
        c0317a.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.hot_topic_change_item, (ViewGroup) null);
        al.k(c0317a.mRootView, d.f.select_forum_item_bg);
        al.j(c0317a.jpz, d.C0236d.cp_cont_b);
        c0317a.jpz = (TextView) c0317a.mRootView.findViewById(d.g.fourm_tv);
        c0317a.fiL = c0317a.mRootView.findViewById(d.g.line_view);
        c0317a.jpy = (TbImageView) c0317a.mRootView.findViewById(d.g.icon_img);
        c0317a.jpy.setDefaultBgResource(d.C0236d.cp_bg_line_e);
        c0317a.jpy.setDefaultResource(d.f.transparent_bg);
        c0317a.jpy.setDefaultErrorResource(d.f.icon_default_ba_120);
        c0317a.mRootView.setTag(c0317a);
        return c0317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0317a {
        public View fiL;
        public TbImageView jpy;
        public TextView jpz;
        public View mRootView;

        private C0317a() {
        }
    }
}
