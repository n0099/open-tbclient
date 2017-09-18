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
    private ViewGroup boD = null;
    private HotTopicChangeFourmActivity gDS;
    private final Context mContext;
    private List<HotTopicBussinessData> mData;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.gDS = hotTopicChangeFourmActivity;
        this.mContext = this.gDS.getPageContext().getContext();
    }

    public void setData(List<HotTopicBussinessData> list) {
        this.mData = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.v(this.mData)) {
            return 0;
        }
        return this.mData.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uz */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String tb(String str) {
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
        C0127a c0127a;
        if (this.boD == null) {
            this.boD = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0127a = a(view != null ? view.getTag() : null, item);
        } else {
            c0127a = null;
        }
        if (c0127a != null) {
            return c0127a.mRootView;
        }
        return null;
    }

    private C0127a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0127a c0127a;
        if (obj == null) {
            c0127a = byG();
        } else {
            c0127a = (C0127a) obj;
        }
        c0127a.gDU.setText(tb(hotTopicBussinessData.mForumName));
        c0127a.gDT.c(hotTopicBussinessData.mForumAvatar, 10, false);
        aj.j(c0127a.mRootView, d.g.select_forum_item_bg);
        aj.i(c0127a.gDU, d.e.cp_cont_b);
        aj.k(c0127a.cxv, d.e.cp_bg_line_e);
        return c0127a;
    }

    private C0127a byG() {
        C0127a c0127a = new C0127a();
        c0127a.mRootView = LayoutInflater.from(this.mContext).inflate(d.j.hot_topic_change_item, (ViewGroup) null);
        aj.j(c0127a.mRootView, d.g.select_forum_item_bg);
        aj.i(c0127a.gDU, d.e.cp_cont_b);
        c0127a.gDU = (TextView) c0127a.mRootView.findViewById(d.h.fourm_tv);
        c0127a.cxv = c0127a.mRootView.findViewById(d.h.line_view);
        c0127a.gDT = (TbImageView) c0127a.mRootView.findViewById(d.h.icon_img);
        c0127a.gDT.setDefaultBgResource(d.e.cp_bg_line_e);
        c0127a.gDT.setDefaultResource(d.g.transparent_bg);
        c0127a.gDT.setDefaultErrorResource(d.g.icon_default_ba_120);
        c0127a.mRootView.setTag(c0127a);
        return c0127a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0127a {
        public View cxv;
        public TbImageView gDT;
        public TextView gDU;
        public View mRootView;

        private C0127a() {
        }
    }
}
