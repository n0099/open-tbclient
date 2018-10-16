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
    private HotTopicChangeFourmActivity hLh;
    private final Context mContext;
    private List<HotTopicBussinessData> mData;
    private ViewGroup mParent = null;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.hLh = hotTopicChangeFourmActivity;
        this.mContext = this.hLh.getPageContext().getContext();
    }

    public void setData(List<HotTopicBussinessData> list) {
        this.mData = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.J(this.mData)) {
            return 0;
        }
        return this.mData.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wu */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String wU(String str) {
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
        C0295a c0295a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0295a = a(view != null ? view.getTag() : null, item);
        } else {
            c0295a = null;
        }
        if (c0295a != null) {
            return c0295a.mRootView;
        }
        return null;
    }

    private C0295a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0295a c0295a;
        if (obj == null) {
            c0295a = bMG();
        } else {
            c0295a = (C0295a) obj;
        }
        c0295a.hLj.setText(wU(hotTopicBussinessData.mForumName));
        c0295a.hLi.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        al.i(c0295a.mRootView, e.f.select_forum_item_bg);
        al.h(c0295a.hLj, e.d.cp_cont_b);
        al.j(c0295a.dJQ, e.d.cp_bg_line_e);
        return c0295a;
    }

    private C0295a bMG() {
        C0295a c0295a = new C0295a();
        c0295a.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.hot_topic_change_item, (ViewGroup) null);
        al.i(c0295a.mRootView, e.f.select_forum_item_bg);
        al.h(c0295a.hLj, e.d.cp_cont_b);
        c0295a.hLj = (TextView) c0295a.mRootView.findViewById(e.g.fourm_tv);
        c0295a.dJQ = c0295a.mRootView.findViewById(e.g.line_view);
        c0295a.hLi = (TbImageView) c0295a.mRootView.findViewById(e.g.icon_img);
        c0295a.hLi.setDefaultBgResource(e.d.cp_bg_line_e);
        c0295a.hLi.setDefaultResource(e.f.transparent_bg);
        c0295a.hLi.setDefaultErrorResource(e.f.icon_default_ba_120);
        c0295a.mRootView.setTag(c0295a);
        return c0295a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0295a {
        public View dJQ;
        public TbImageView hLi;
        public TextView hLj;
        public View mRootView;

        private C0295a() {
        }
    }
}
