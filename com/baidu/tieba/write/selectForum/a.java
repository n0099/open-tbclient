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
    private ViewGroup cqX = null;
    private HotTopicChangeFourmActivity hHi;
    private final Context mContext;
    private List<HotTopicBussinessData> mData;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.hHi = hotTopicChangeFourmActivity;
        this.mContext = this.hHi.getPageContext().getContext();
    }

    public void setData(List<HotTopicBussinessData> list) {
        this.mData = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.E(this.mData)) {
            return 0;
        }
        return this.mData.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: xu */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String uw(String str) {
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
        C0253a c0253a;
        if (this.cqX == null) {
            this.cqX = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0253a = a(view != null ? view.getTag() : null, item);
        } else {
            c0253a = null;
        }
        if (c0253a != null) {
            return c0253a.mRootView;
        }
        return null;
    }

    private C0253a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0253a c0253a;
        if (obj == null) {
            c0253a = bGZ();
        } else {
            c0253a = (C0253a) obj;
        }
        c0253a.hHk.setText(uw(hotTopicBussinessData.mForumName));
        c0253a.hHj.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        aj.s(c0253a.mRootView, d.f.select_forum_item_bg);
        aj.r(c0253a.hHk, d.C0141d.cp_cont_b);
        aj.t(c0253a.dMs, d.C0141d.cp_bg_line_e);
        return c0253a;
    }

    private C0253a bGZ() {
        C0253a c0253a = new C0253a();
        c0253a.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.hot_topic_change_item, (ViewGroup) null);
        aj.s(c0253a.mRootView, d.f.select_forum_item_bg);
        aj.r(c0253a.hHk, d.C0141d.cp_cont_b);
        c0253a.hHk = (TextView) c0253a.mRootView.findViewById(d.g.fourm_tv);
        c0253a.dMs = c0253a.mRootView.findViewById(d.g.line_view);
        c0253a.hHj = (TbImageView) c0253a.mRootView.findViewById(d.g.icon_img);
        c0253a.hHj.setDefaultBgResource(d.C0141d.cp_bg_line_e);
        c0253a.hHj.setDefaultResource(d.f.transparent_bg);
        c0253a.hHj.setDefaultErrorResource(d.f.icon_default_ba_120);
        c0253a.mRootView.setTag(c0253a);
        return c0253a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0253a {
        public View dMs;
        public TbImageView hHj;
        public TextView hHk;
        public View mRootView;

        private C0253a() {
        }
    }
}
