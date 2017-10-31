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
    private ViewGroup brP = null;
    private HotTopicChangeFourmActivity gSw;
    private final Context mContext;
    private List<HotTopicBussinessData> mData;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.gSw = hotTopicChangeFourmActivity;
        this.mContext = this.gSw.getPageContext().getContext();
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
    /* renamed from: vo */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String tR(String str) {
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
        C0139a c0139a;
        if (this.brP == null) {
            this.brP = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0139a = a(view != null ? view.getTag() : null, item);
        } else {
            c0139a = null;
        }
        if (c0139a != null) {
            return c0139a.mRootView;
        }
        return null;
    }

    private C0139a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0139a c0139a;
        if (obj == null) {
            c0139a = bDo();
        } else {
            c0139a = (C0139a) obj;
        }
        c0139a.gSy.setText(tR(hotTopicBussinessData.mForumName));
        c0139a.gSx.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        aj.j(c0139a.mRootView, d.f.select_forum_item_bg);
        aj.i(c0139a.gSy, d.C0080d.cp_cont_b);
        aj.k(c0139a.cFT, d.C0080d.cp_bg_line_e);
        return c0139a;
    }

    private C0139a bDo() {
        C0139a c0139a = new C0139a();
        c0139a.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.hot_topic_change_item, (ViewGroup) null);
        aj.j(c0139a.mRootView, d.f.select_forum_item_bg);
        aj.i(c0139a.gSy, d.C0080d.cp_cont_b);
        c0139a.gSy = (TextView) c0139a.mRootView.findViewById(d.g.fourm_tv);
        c0139a.cFT = c0139a.mRootView.findViewById(d.g.line_view);
        c0139a.gSx = (TbImageView) c0139a.mRootView.findViewById(d.g.icon_img);
        c0139a.gSx.setDefaultBgResource(d.C0080d.cp_bg_line_e);
        c0139a.gSx.setDefaultResource(d.f.transparent_bg);
        c0139a.gSx.setDefaultErrorResource(d.f.icon_default_ba_120);
        c0139a.mRootView.setTag(c0139a);
        return c0139a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0139a {
        public View cFT;
        public TbImageView gSx;
        public TextView gSy;
        public View mRootView;

        private C0139a() {
        }
    }
}
