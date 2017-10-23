package com.baidu.tieba.write.selectForum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private ViewGroup bqb = null;
    private HotTopicChangeFourmActivity gIy;
    private final Context mContext;
    private List<HotTopicBussinessData> mData;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.gIy = hotTopicChangeFourmActivity;
        this.mContext = this.gIy.getPageContext().getContext();
    }

    public void setData(List<HotTopicBussinessData> list) {
        this.mData = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.u(this.mData)) {
            return 0;
        }
        return this.mData.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uU */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String te(String str) {
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
        C0138a c0138a;
        if (this.bqb == null) {
            this.bqb = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0138a = a(view != null ? view.getTag() : null, item);
        } else {
            c0138a = null;
        }
        if (c0138a != null) {
            return c0138a.mRootView;
        }
        return null;
    }

    private C0138a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0138a c0138a;
        if (obj == null) {
            c0138a = bzQ();
        } else {
            c0138a = (C0138a) obj;
        }
        c0138a.gIA.setText(te(hotTopicBussinessData.mForumName));
        c0138a.gIz.c(hotTopicBussinessData.mForumAvatar, 10, false);
        aj.j(c0138a.mRootView, d.g.select_forum_item_bg);
        aj.i(c0138a.gIA, d.e.cp_cont_b);
        aj.k(c0138a.cya, d.e.cp_bg_line_e);
        return c0138a;
    }

    private C0138a bzQ() {
        C0138a c0138a = new C0138a();
        c0138a.mRootView = LayoutInflater.from(this.mContext).inflate(d.j.hot_topic_change_item, (ViewGroup) null);
        aj.j(c0138a.mRootView, d.g.select_forum_item_bg);
        aj.i(c0138a.gIA, d.e.cp_cont_b);
        c0138a.gIA = (TextView) c0138a.mRootView.findViewById(d.h.fourm_tv);
        c0138a.cya = c0138a.mRootView.findViewById(d.h.line_view);
        c0138a.gIz = (TbImageView) c0138a.mRootView.findViewById(d.h.icon_img);
        c0138a.gIz.setDefaultBgResource(d.e.cp_bg_line_e);
        c0138a.gIz.setDefaultResource(d.g.transparent_bg);
        c0138a.gIz.setDefaultErrorResource(d.g.icon_default_ba_120);
        c0138a.mRootView.setTag(c0138a);
        return c0138a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0138a {
        public View cya;
        public TextView gIA;
        public TbImageView gIz;
        public View mRootView;

        private C0138a() {
        }
    }
}
