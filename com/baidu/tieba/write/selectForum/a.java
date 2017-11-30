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
    private ViewGroup byF = null;
    private HotTopicChangeFourmActivity hez;
    private final Context mContext;
    private List<HotTopicBussinessData> mData;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.hez = hotTopicChangeFourmActivity;
        this.mContext = this.hez.getPageContext().getContext();
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
    /* renamed from: vN */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String uF(String str) {
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
        C0141a c0141a;
        if (this.byF == null) {
            this.byF = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0141a = a(view != null ? view.getTag() : null, item);
        } else {
            c0141a = null;
        }
        if (c0141a != null) {
            return c0141a.mRootView;
        }
        return null;
    }

    private C0141a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0141a c0141a;
        if (obj == null) {
            c0141a = bGg();
        } else {
            c0141a = (C0141a) obj;
        }
        c0141a.heB.setText(uF(hotTopicBussinessData.mForumName));
        c0141a.heA.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        aj.j(c0141a.mRootView, d.f.select_forum_item_bg);
        aj.i(c0141a.heB, d.C0082d.cp_cont_b);
        aj.k(c0141a.cPw, d.C0082d.cp_bg_line_e);
        return c0141a;
    }

    private C0141a bGg() {
        C0141a c0141a = new C0141a();
        c0141a.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.hot_topic_change_item, (ViewGroup) null);
        aj.j(c0141a.mRootView, d.f.select_forum_item_bg);
        aj.i(c0141a.heB, d.C0082d.cp_cont_b);
        c0141a.heB = (TextView) c0141a.mRootView.findViewById(d.g.fourm_tv);
        c0141a.cPw = c0141a.mRootView.findViewById(d.g.line_view);
        c0141a.heA = (TbImageView) c0141a.mRootView.findViewById(d.g.icon_img);
        c0141a.heA.setDefaultBgResource(d.C0082d.cp_bg_line_e);
        c0141a.heA.setDefaultResource(d.f.transparent_bg);
        c0141a.heA.setDefaultErrorResource(d.f.icon_default_ba_120);
        c0141a.mRootView.setTag(c0141a);
        return c0141a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0141a {
        public View cPw;
        public TbImageView heA;
        public TextView heB;
        public View mRootView;

        private C0141a() {
        }
    }
}
