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
    private HotTopicChangeFourmActivity hYv;
    private final Context mContext;
    private List<HotTopicBussinessData> mData;
    private ViewGroup mParent = null;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.hYv = hotTopicChangeFourmActivity;
        this.mContext = this.hYv.getPageContext().getContext();
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
    /* renamed from: xz */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String xV(String str) {
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
        C0336a c0336a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0336a = a(view != null ? view.getTag() : null, item);
        } else {
            c0336a = null;
        }
        if (c0336a != null) {
            return c0336a.mRootView;
        }
        return null;
    }

    private C0336a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0336a c0336a;
        if (obj == null) {
            c0336a = bPJ();
        } else {
            c0336a = (C0336a) obj;
        }
        c0336a.hYx.setText(xV(hotTopicBussinessData.mForumName));
        c0336a.hYw.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        al.i(c0336a.mRootView, e.f.select_forum_item_bg);
        al.h(c0336a.hYx, e.d.cp_cont_b);
        al.j(c0336a.dUU, e.d.cp_bg_line_e);
        return c0336a;
    }

    private C0336a bPJ() {
        C0336a c0336a = new C0336a();
        c0336a.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.hot_topic_change_item, (ViewGroup) null);
        al.i(c0336a.mRootView, e.f.select_forum_item_bg);
        al.h(c0336a.hYx, e.d.cp_cont_b);
        c0336a.hYx = (TextView) c0336a.mRootView.findViewById(e.g.fourm_tv);
        c0336a.dUU = c0336a.mRootView.findViewById(e.g.line_view);
        c0336a.hYw = (TbImageView) c0336a.mRootView.findViewById(e.g.icon_img);
        c0336a.hYw.setDefaultBgResource(e.d.cp_bg_line_e);
        c0336a.hYw.setDefaultResource(e.f.transparent_bg);
        c0336a.hYw.setDefaultErrorResource(e.f.icon_default_ba_120);
        c0336a.mRootView.setTag(c0336a);
        return c0336a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0336a {
        public View dUU;
        public TbImageView hYw;
        public TextView hYx;
        public View mRootView;

        private C0336a() {
        }
    }
}
