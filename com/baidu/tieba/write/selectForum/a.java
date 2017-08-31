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
    private ViewGroup dKX = null;
    private HotTopicChangeFourmActivity gCZ;
    private final Context mContext;
    private List<HotTopicBussinessData> mData;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.gCZ = hotTopicChangeFourmActivity;
        this.mContext = this.gCZ.getPageContext().getContext();
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
    /* renamed from: ux */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String sZ(String str) {
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
        C0128a c0128a;
        if (this.dKX == null) {
            this.dKX = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0128a = a(view != null ? view.getTag() : null, item);
        } else {
            c0128a = null;
        }
        if (c0128a != null) {
            return c0128a.mRootView;
        }
        return null;
    }

    private C0128a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0128a c0128a;
        if (obj == null) {
            c0128a = byv();
        } else {
            c0128a = (C0128a) obj;
        }
        c0128a.gDb.setText(sZ(hotTopicBussinessData.mForumName));
        c0128a.gDa.c(hotTopicBussinessData.mForumAvatar, 10, false);
        aj.j(c0128a.mRootView, d.g.select_forum_item_bg);
        aj.i(c0128a.gDb, d.e.cp_cont_b);
        aj.k(c0128a.cwD, d.e.cp_bg_line_e);
        return c0128a;
    }

    private C0128a byv() {
        C0128a c0128a = new C0128a();
        c0128a.mRootView = LayoutInflater.from(this.mContext).inflate(d.j.hot_topic_change_item, (ViewGroup) null);
        aj.j(c0128a.mRootView, d.g.select_forum_item_bg);
        aj.i(c0128a.gDb, d.e.cp_cont_b);
        c0128a.gDb = (TextView) c0128a.mRootView.findViewById(d.h.fourm_tv);
        c0128a.cwD = c0128a.mRootView.findViewById(d.h.line_view);
        c0128a.gDa = (TbImageView) c0128a.mRootView.findViewById(d.h.icon_img);
        c0128a.gDa.setDefaultBgResource(d.e.cp_bg_line_e);
        c0128a.gDa.setDefaultResource(d.g.transparent_bg);
        c0128a.gDa.setDefaultErrorResource(d.g.icon_default_ba_120);
        c0128a.mRootView.setTag(c0128a);
        return c0128a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0128a {
        public View cwD;
        public TbImageView gDa;
        public TextView gDb;
        public View mRootView;

        private C0128a() {
        }
    }
}
