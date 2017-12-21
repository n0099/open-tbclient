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
    private ViewGroup byL = null;
    private HotTopicChangeFourmActivity hhw;
    private final Context mContext;
    private List<HotTopicBussinessData> mData;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.hhw = hotTopicChangeFourmActivity;
        this.mContext = this.hhw.getPageContext().getContext();
    }

    public void setData(List<HotTopicBussinessData> list) {
        this.mData = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.w(this.mData)) {
            return 0;
        }
        return this.mData.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wa */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String uK(String str) {
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
        C0157a c0157a;
        if (this.byL == null) {
            this.byL = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0157a = a(view != null ? view.getTag() : null, item);
        } else {
            c0157a = null;
        }
        if (c0157a != null) {
            return c0157a.mRootView;
        }
        return null;
    }

    private C0157a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0157a c0157a;
        if (obj == null) {
            c0157a = bGS();
        } else {
            c0157a = (C0157a) obj;
        }
        c0157a.hhy.setText(uK(hotTopicBussinessData.mForumName));
        c0157a.hhx.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        aj.j(c0157a.mRootView, d.f.select_forum_item_bg);
        aj.i(c0157a.hhy, d.C0095d.cp_cont_b);
        aj.k(c0157a.cPL, d.C0095d.cp_bg_line_e);
        return c0157a;
    }

    private C0157a bGS() {
        C0157a c0157a = new C0157a();
        c0157a.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.hot_topic_change_item, (ViewGroup) null);
        aj.j(c0157a.mRootView, d.f.select_forum_item_bg);
        aj.i(c0157a.hhy, d.C0095d.cp_cont_b);
        c0157a.hhy = (TextView) c0157a.mRootView.findViewById(d.g.fourm_tv);
        c0157a.cPL = c0157a.mRootView.findViewById(d.g.line_view);
        c0157a.hhx = (TbImageView) c0157a.mRootView.findViewById(d.g.icon_img);
        c0157a.hhx.setDefaultBgResource(d.C0095d.cp_bg_line_e);
        c0157a.hhx.setDefaultResource(d.f.transparent_bg);
        c0157a.hhx.setDefaultErrorResource(d.f.icon_default_ba_120);
        c0157a.mRootView.setTag(c0157a);
        return c0157a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0157a {
        public View cPL;
        public TbImageView hhx;
        public TextView hhy;
        public View mRootView;

        private C0157a() {
        }
    }
}
