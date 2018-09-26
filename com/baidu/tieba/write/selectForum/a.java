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
    private HotTopicChangeFourmActivity hDU;
    private final Context mContext;
    private List<HotTopicBussinessData> mData;
    private ViewGroup mParent = null;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.hDU = hotTopicChangeFourmActivity;
        this.mContext = this.hDU.getPageContext().getContext();
    }

    public void setData(List<HotTopicBussinessData> list) {
        this.mData = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.z(this.mData)) {
            return 0;
        }
        return this.mData.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vX */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String wt(String str) {
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
        C0260a c0260a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0260a = a(view != null ? view.getTag() : null, item);
        } else {
            c0260a = null;
        }
        if (c0260a != null) {
            return c0260a.mRootView;
        }
        return null;
    }

    private C0260a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0260a c0260a;
        if (obj == null) {
            c0260a = bJu();
        } else {
            c0260a = (C0260a) obj;
        }
        c0260a.hDW.setText(wt(hotTopicBussinessData.mForumName));
        c0260a.hDV.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        al.i(c0260a.mRootView, e.f.select_forum_item_bg);
        al.h(c0260a.hDW, e.d.cp_cont_b);
        al.j(c0260a.dBQ, e.d.cp_bg_line_e);
        return c0260a;
    }

    private C0260a bJu() {
        C0260a c0260a = new C0260a();
        c0260a.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.hot_topic_change_item, (ViewGroup) null);
        al.i(c0260a.mRootView, e.f.select_forum_item_bg);
        al.h(c0260a.hDW, e.d.cp_cont_b);
        c0260a.hDW = (TextView) c0260a.mRootView.findViewById(e.g.fourm_tv);
        c0260a.dBQ = c0260a.mRootView.findViewById(e.g.line_view);
        c0260a.hDV = (TbImageView) c0260a.mRootView.findViewById(e.g.icon_img);
        c0260a.hDV.setDefaultBgResource(e.d.cp_bg_line_e);
        c0260a.hDV.setDefaultResource(e.f.transparent_bg);
        c0260a.hDV.setDefaultErrorResource(e.f.icon_default_ba_120);
        c0260a.mRootView.setTag(c0260a);
        return c0260a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0260a {
        public View dBQ;
        public TbImageView hDV;
        public TextView hDW;
        public View mRootView;

        private C0260a() {
        }
    }
}
