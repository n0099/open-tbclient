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
    /* renamed from: Bo */
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
        C0314a c0314a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0314a = a(view != null ? view.getTag() : null, item);
        } else {
            c0314a = null;
        }
        if (c0314a != null) {
            return c0314a.mRootView;
        }
        return null;
    }

    private C0314a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0314a c0314a;
        if (obj == null) {
            c0314a = cpr();
        } else {
            c0314a = (C0314a) obj;
        }
        c0314a.jpg.setText(Et(hotTopicBussinessData.mForumName));
        c0314a.jpf.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        al.k(c0314a.mRootView, d.f.select_forum_item_bg);
        al.j(c0314a.jpg, d.C0236d.cp_cont_b);
        al.l(c0314a.fiL, d.C0236d.cp_bg_line_e);
        return c0314a;
    }

    private C0314a cpr() {
        C0314a c0314a = new C0314a();
        c0314a.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.hot_topic_change_item, (ViewGroup) null);
        al.k(c0314a.mRootView, d.f.select_forum_item_bg);
        al.j(c0314a.jpg, d.C0236d.cp_cont_b);
        c0314a.jpg = (TextView) c0314a.mRootView.findViewById(d.g.fourm_tv);
        c0314a.fiL = c0314a.mRootView.findViewById(d.g.line_view);
        c0314a.jpf = (TbImageView) c0314a.mRootView.findViewById(d.g.icon_img);
        c0314a.jpf.setDefaultBgResource(d.C0236d.cp_bg_line_e);
        c0314a.jpf.setDefaultResource(d.f.transparent_bg);
        c0314a.jpf.setDefaultErrorResource(d.f.icon_default_ba_120);
        c0314a.mRootView.setTag(c0314a);
        return c0314a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0314a {
        public View fiL;
        public TbImageView jpf;
        public TextView jpg;
        public View mRootView;

        private C0314a() {
        }
    }
}
