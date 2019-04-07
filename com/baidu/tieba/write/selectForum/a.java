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
    private HotTopicChangeFourmActivity jpe;
    private final Context mContext;
    private List<HotTopicBussinessData> mData;
    private ViewGroup mParent = null;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.jpe = hotTopicChangeFourmActivity;
        this.mContext = this.jpe.getPageContext().getContext();
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
    /* renamed from: Bl */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String Et(String str) {
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
        C0410a c0410a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0410a = a(view != null ? view.getTag() : null, item);
        } else {
            c0410a = null;
        }
        if (c0410a != null) {
            return c0410a.mRootView;
        }
        return null;
    }

    private C0410a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0410a c0410a;
        if (obj == null) {
            c0410a = cpC();
        } else {
            c0410a = (C0410a) obj;
        }
        c0410a.jpg.setText(Et(hotTopicBussinessData.mForumName));
        c0410a.jpf.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        al.k(c0410a.mRootView, d.f.select_forum_item_bg);
        al.j(c0410a.jpg, d.C0277d.cp_cont_b);
        al.l(c0410a.fiv, d.C0277d.cp_bg_line_e);
        return c0410a;
    }

    private C0410a cpC() {
        C0410a c0410a = new C0410a();
        c0410a.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.hot_topic_change_item, (ViewGroup) null);
        al.k(c0410a.mRootView, d.f.select_forum_item_bg);
        al.j(c0410a.jpg, d.C0277d.cp_cont_b);
        c0410a.jpg = (TextView) c0410a.mRootView.findViewById(d.g.fourm_tv);
        c0410a.fiv = c0410a.mRootView.findViewById(d.g.line_view);
        c0410a.jpf = (TbImageView) c0410a.mRootView.findViewById(d.g.icon_img);
        c0410a.jpf.setDefaultBgResource(d.C0277d.cp_bg_line_e);
        c0410a.jpf.setDefaultResource(d.f.transparent_bg);
        c0410a.jpf.setDefaultErrorResource(d.f.icon_default_ba_120);
        c0410a.mRootView.setTag(c0410a);
        return c0410a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0410a {
        public View fiv;
        public TbImageView jpf;
        public TextView jpg;
        public View mRootView;

        private C0410a() {
        }
    }
}
