package com.baidu.tieba.write.selectForum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private ViewGroup dEt = null;
    private HotTopicChangeFourmActivity gEm;
    private final Context mContext;
    private List<HotTopicBussinessData> mData;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.gEm = hotTopicChangeFourmActivity;
        this.mContext = this.gEm.getPageContext().getContext();
    }

    public void setData(List<HotTopicBussinessData> list) {
        this.mData = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (u.v(this.mData)) {
            return 0;
        }
        return this.mData.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uu */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String te(String str) {
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
        C0125a c0125a;
        if (this.dEt == null) {
            this.dEt = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0125a = a(view != null ? view.getTag() : null, item);
        } else {
            c0125a = null;
        }
        if (c0125a != null) {
            return c0125a.mRootView;
        }
        return null;
    }

    private C0125a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0125a c0125a;
        if (obj == null) {
            c0125a = bzf();
        } else {
            c0125a = (C0125a) obj;
        }
        c0125a.gEo.setText(te(hotTopicBussinessData.mForumName));
        c0125a.gEn.c(hotTopicBussinessData.mForumAvatar, 10, false);
        ai.j(c0125a.mRootView, d.g.select_forum_item_bg);
        ai.i(c0125a.gEo, d.e.cp_cont_b);
        ai.k(c0125a.cpY, d.e.cp_bg_line_e);
        return c0125a;
    }

    private C0125a bzf() {
        C0125a c0125a = new C0125a();
        c0125a.mRootView = LayoutInflater.from(this.mContext).inflate(d.j.hot_topic_change_item, (ViewGroup) null);
        ai.j(c0125a.mRootView, d.g.select_forum_item_bg);
        ai.i(c0125a.gEo, d.e.cp_cont_b);
        c0125a.gEo = (TextView) c0125a.mRootView.findViewById(d.h.fourm_tv);
        c0125a.cpY = c0125a.mRootView.findViewById(d.h.line_view);
        c0125a.gEn = (TbImageView) c0125a.mRootView.findViewById(d.h.icon_img);
        c0125a.gEn.setDefaultBgResource(d.e.cp_bg_line_e);
        c0125a.gEn.setDefaultResource(d.g.transparent_bg);
        c0125a.gEn.setDefaultErrorResource(d.g.icon_default_ba_120);
        c0125a.mRootView.setTag(c0125a);
        return c0125a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0125a {
        public View cpY;
        public TbImageView gEn;
        public TextView gEo;
        public View mRootView;

        private C0125a() {
        }
    }
}
