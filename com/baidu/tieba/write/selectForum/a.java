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
    private HotTopicChangeFourmActivity hXo;
    private final Context mContext;
    private List<HotTopicBussinessData> mData;
    private ViewGroup mParent = null;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.hXo = hotTopicChangeFourmActivity;
        this.mContext = this.hXo.getPageContext().getContext();
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
    /* renamed from: xx */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String xF(String str) {
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
        C0337a c0337a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0337a = a(view != null ? view.getTag() : null, item);
        } else {
            c0337a = null;
        }
        if (c0337a != null) {
            return c0337a.mRootView;
        }
        return null;
    }

    private C0337a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0337a c0337a;
        if (obj == null) {
            c0337a = bPb();
        } else {
            c0337a = (C0337a) obj;
        }
        c0337a.hXq.setText(xF(hotTopicBussinessData.mForumName));
        c0337a.hXp.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        al.i(c0337a.mRootView, e.f.select_forum_item_bg);
        al.h(c0337a.hXq, e.d.cp_cont_b);
        al.j(c0337a.dUo, e.d.cp_bg_line_e);
        return c0337a;
    }

    private C0337a bPb() {
        C0337a c0337a = new C0337a();
        c0337a.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.hot_topic_change_item, (ViewGroup) null);
        al.i(c0337a.mRootView, e.f.select_forum_item_bg);
        al.h(c0337a.hXq, e.d.cp_cont_b);
        c0337a.hXq = (TextView) c0337a.mRootView.findViewById(e.g.fourm_tv);
        c0337a.dUo = c0337a.mRootView.findViewById(e.g.line_view);
        c0337a.hXp = (TbImageView) c0337a.mRootView.findViewById(e.g.icon_img);
        c0337a.hXp.setDefaultBgResource(e.d.cp_bg_line_e);
        c0337a.hXp.setDefaultResource(e.f.transparent_bg);
        c0337a.hXp.setDefaultErrorResource(e.f.icon_default_ba_120);
        c0337a.mRootView.setTag(c0337a);
        return c0337a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0337a {
        public View dUo;
        public TbImageView hXp;
        public TextView hXq;
        public View mRootView;

        private C0337a() {
        }
    }
}
