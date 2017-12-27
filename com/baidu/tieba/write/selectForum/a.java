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
    private ViewGroup cmO = null;
    private HotTopicChangeFourmActivity hPx;
    private final Context mContext;
    private List<HotTopicBussinessData> mData;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.hPx = hotTopicChangeFourmActivity;
        this.mContext = this.hPx.getPageContext().getContext();
    }

    public void setData(List<HotTopicBussinessData> list) {
        this.mData = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.G(this.mData)) {
            return 0;
        }
        return this.mData.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: yR */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String uN(String str) {
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
        C0170a c0170a;
        if (this.cmO == null) {
            this.cmO = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0170a = a(view != null ? view.getTag() : null, item);
        } else {
            c0170a = null;
        }
        if (c0170a != null) {
            return c0170a.mRootView;
        }
        return null;
    }

    private C0170a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0170a c0170a;
        if (obj == null) {
            c0170a = bMF();
        } else {
            c0170a = (C0170a) obj;
        }
        c0170a.hPz.setText(uN(hotTopicBussinessData.mForumName));
        c0170a.hPy.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        aj.s(c0170a.mRootView, d.f.select_forum_item_bg);
        aj.r(c0170a.hPz, d.C0108d.cp_cont_b);
        aj.t(c0170a.dEC, d.C0108d.cp_bg_line_e);
        return c0170a;
    }

    private C0170a bMF() {
        C0170a c0170a = new C0170a();
        c0170a.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.hot_topic_change_item, (ViewGroup) null);
        aj.s(c0170a.mRootView, d.f.select_forum_item_bg);
        aj.r(c0170a.hPz, d.C0108d.cp_cont_b);
        c0170a.hPz = (TextView) c0170a.mRootView.findViewById(d.g.fourm_tv);
        c0170a.dEC = c0170a.mRootView.findViewById(d.g.line_view);
        c0170a.hPy = (TbImageView) c0170a.mRootView.findViewById(d.g.icon_img);
        c0170a.hPy.setDefaultBgResource(d.C0108d.cp_bg_line_e);
        c0170a.hPy.setDefaultResource(d.f.transparent_bg);
        c0170a.hPy.setDefaultErrorResource(d.f.icon_default_ba_120);
        c0170a.mRootView.setTag(c0170a);
        return c0170a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0170a {
        public View dEC;
        public TbImageView hPy;
        public TextView hPz;
        public View mRootView;

        private C0170a() {
        }
    }
}
