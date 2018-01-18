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
    private ViewGroup cmX = null;
    private HotTopicChangeFourmActivity hFf;
    private final Context mContext;
    private List<HotTopicBussinessData> mData;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.hFf = hotTopicChangeFourmActivity;
        this.mContext = this.hFf.getPageContext().getContext();
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

    private String ui(String str) {
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
        C0169a c0169a;
        if (this.cmX == null) {
            this.cmX = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0169a = a(view != null ? view.getTag() : null, item);
        } else {
            c0169a = null;
        }
        if (c0169a != null) {
            return c0169a.mRootView;
        }
        return null;
    }

    private C0169a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0169a c0169a;
        if (obj == null) {
            c0169a = bGf();
        } else {
            c0169a = (C0169a) obj;
        }
        c0169a.hFh.setText(ui(hotTopicBussinessData.mForumName));
        c0169a.hFg.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        aj.s(c0169a.mRootView, d.f.select_forum_item_bg);
        aj.r(c0169a.hFh, d.C0107d.cp_cont_b);
        aj.t(c0169a.dJd, d.C0107d.cp_bg_line_e);
        return c0169a;
    }

    private C0169a bGf() {
        C0169a c0169a = new C0169a();
        c0169a.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.hot_topic_change_item, (ViewGroup) null);
        aj.s(c0169a.mRootView, d.f.select_forum_item_bg);
        aj.r(c0169a.hFh, d.C0107d.cp_cont_b);
        c0169a.hFh = (TextView) c0169a.mRootView.findViewById(d.g.fourm_tv);
        c0169a.dJd = c0169a.mRootView.findViewById(d.g.line_view);
        c0169a.hFg = (TbImageView) c0169a.mRootView.findViewById(d.g.icon_img);
        c0169a.hFg.setDefaultBgResource(d.C0107d.cp_bg_line_e);
        c0169a.hFg.setDefaultResource(d.f.transparent_bg);
        c0169a.hFg.setDefaultErrorResource(d.f.icon_default_ba_120);
        c0169a.mRootView.setTag(c0169a);
        return c0169a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0169a {
        public View dJd;
        public TbImageView hFg;
        public TextView hFh;
        public View mRootView;

        private C0169a() {
        }
    }
}
