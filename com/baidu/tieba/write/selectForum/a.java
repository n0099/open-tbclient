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
    private ViewGroup byH = null;
    private HotTopicChangeFourmActivity hhr;
    private final Context mContext;
    private List<HotTopicBussinessData> mData;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.hhr = hotTopicChangeFourmActivity;
        this.mContext = this.hhr.getPageContext().getContext();
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
        C0158a c0158a;
        if (this.byH == null) {
            this.byH = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0158a = a(view != null ? view.getTag() : null, item);
        } else {
            c0158a = null;
        }
        if (c0158a != null) {
            return c0158a.mRootView;
        }
        return null;
    }

    private C0158a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0158a c0158a;
        if (obj == null) {
            c0158a = bGS();
        } else {
            c0158a = (C0158a) obj;
        }
        c0158a.hht.setText(uK(hotTopicBussinessData.mForumName));
        c0158a.hhs.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        aj.j(c0158a.mRootView, d.f.select_forum_item_bg);
        aj.i(c0158a.hht, d.C0096d.cp_cont_b);
        aj.k(c0158a.cPH, d.C0096d.cp_bg_line_e);
        return c0158a;
    }

    private C0158a bGS() {
        C0158a c0158a = new C0158a();
        c0158a.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.hot_topic_change_item, (ViewGroup) null);
        aj.j(c0158a.mRootView, d.f.select_forum_item_bg);
        aj.i(c0158a.hht, d.C0096d.cp_cont_b);
        c0158a.hht = (TextView) c0158a.mRootView.findViewById(d.g.fourm_tv);
        c0158a.cPH = c0158a.mRootView.findViewById(d.g.line_view);
        c0158a.hhs = (TbImageView) c0158a.mRootView.findViewById(d.g.icon_img);
        c0158a.hhs.setDefaultBgResource(d.C0096d.cp_bg_line_e);
        c0158a.hhs.setDefaultResource(d.f.transparent_bg);
        c0158a.hhs.setDefaultErrorResource(d.f.icon_default_ba_120);
        c0158a.mRootView.setTag(c0158a);
        return c0158a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0158a {
        public View cPH;
        public TbImageView hhs;
        public TextView hht;
        public View mRootView;

        private C0158a() {
        }
    }
}
