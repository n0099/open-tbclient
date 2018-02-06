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
    private ViewGroup crh = null;
    private HotTopicChangeFourmActivity hGX;
    private final Context mContext;
    private List<HotTopicBussinessData> mData;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.hGX = hotTopicChangeFourmActivity;
        this.mContext = this.hGX.getPageContext().getContext();
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
    /* renamed from: xt */
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
        C0252a c0252a;
        if (this.crh == null) {
            this.crh = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0252a = a(view != null ? view.getTag() : null, item);
        } else {
            c0252a = null;
        }
        if (c0252a != null) {
            return c0252a.mRootView;
        }
        return null;
    }

    private C0252a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0252a c0252a;
        if (obj == null) {
            c0252a = bGV();
        } else {
            c0252a = (C0252a) obj;
        }
        c0252a.hGZ.setText(uw(hotTopicBussinessData.mForumName));
        c0252a.hGY.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        aj.s(c0252a.mRootView, d.f.select_forum_item_bg);
        aj.r(c0252a.hGZ, d.C0140d.cp_cont_b);
        aj.t(c0252a.dMz, d.C0140d.cp_bg_line_e);
        return c0252a;
    }

    private C0252a bGV() {
        C0252a c0252a = new C0252a();
        c0252a.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.hot_topic_change_item, (ViewGroup) null);
        aj.s(c0252a.mRootView, d.f.select_forum_item_bg);
        aj.r(c0252a.hGZ, d.C0140d.cp_cont_b);
        c0252a.hGZ = (TextView) c0252a.mRootView.findViewById(d.g.fourm_tv);
        c0252a.dMz = c0252a.mRootView.findViewById(d.g.line_view);
        c0252a.hGY = (TbImageView) c0252a.mRootView.findViewById(d.g.icon_img);
        c0252a.hGY.setDefaultBgResource(d.C0140d.cp_bg_line_e);
        c0252a.hGY.setDefaultResource(d.f.transparent_bg);
        c0252a.hGY.setDefaultErrorResource(d.f.icon_default_ba_120);
        c0252a.mRootView.setTag(c0252a);
        return c0252a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0252a {
        public View dMz;
        public TbImageView hGY;
        public TextView hGZ;
        public View mRootView;

        private C0252a() {
        }
    }
}
