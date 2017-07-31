package com.baidu.tieba.write.selectForum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private ViewGroup dCw = null;
    private HotTopicChangeFourmActivity gCu;
    private final Context mContext;
    private List<HotTopicBussinessData> mData;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.gCu = hotTopicChangeFourmActivity;
        this.mContext = this.gCu.getPageContext().getContext();
    }

    public void setData(List<HotTopicBussinessData> list) {
        this.mData = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (u.v(this.mData)) {
            return 0;
        }
        return this.mData.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ul */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String sX(String str) {
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
        C0124a c0124a;
        if (this.dCw == null) {
            this.dCw = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0124a = a(view != null ? view.getTag() : null, item);
        } else {
            c0124a = null;
        }
        if (c0124a != null) {
            return c0124a.mRootView;
        }
        return null;
    }

    private C0124a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0124a c0124a;
        if (obj == null) {
            c0124a = byG();
        } else {
            c0124a = (C0124a) obj;
        }
        c0124a.gCw.setText(sX(hotTopicBussinessData.mForumName));
        c0124a.gCv.c(hotTopicBussinessData.mForumAvatar, 10, false);
        ai.j(c0124a.mRootView, d.g.select_forum_item_bg);
        ai.i(c0124a.gCw, d.e.cp_cont_b);
        ai.k(c0124a.cpp, d.e.cp_bg_line_e);
        return c0124a;
    }

    private C0124a byG() {
        C0124a c0124a = new C0124a();
        c0124a.mRootView = LayoutInflater.from(this.mContext).inflate(d.j.hot_topic_change_item, (ViewGroup) null);
        ai.j(c0124a.mRootView, d.g.select_forum_item_bg);
        ai.i(c0124a.gCw, d.e.cp_cont_b);
        c0124a.gCw = (TextView) c0124a.mRootView.findViewById(d.h.fourm_tv);
        c0124a.cpp = c0124a.mRootView.findViewById(d.h.line_view);
        c0124a.gCv = (TbImageView) c0124a.mRootView.findViewById(d.h.icon_img);
        c0124a.gCv.setDefaultBgResource(d.e.cp_bg_line_e);
        c0124a.gCv.setDefaultResource(d.g.transparent_bg);
        c0124a.gCv.setDefaultErrorResource(d.g.icon_default_ba_120);
        c0124a.mRootView.setTag(c0124a);
        return c0124a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0124a {
        public View cpp;
        public TbImageView gCv;
        public TextView gCw;
        public View mRootView;

        private C0124a() {
        }
    }
}
