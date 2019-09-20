package com.baidu.tieba.write.selectForum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private HotTopicChangeFourmActivity jSQ;
    private final Context mContext;
    private List<HotTopicBussinessData> mData;
    private ViewGroup mParent = null;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.jSQ = hotTopicChangeFourmActivity;
        this.mContext = this.jSQ.getPageContext().getContext();
    }

    public void setData(List<HotTopicBussinessData> list) {
        this.mData = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.aa(this.mData)) {
            return 0;
        }
        return this.mData.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Dh */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String Hm(String str) {
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
        C0445a c0445a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0445a = a(view != null ? view.getTag() : null, item);
        } else {
            c0445a = null;
        }
        if (c0445a != null) {
            return c0445a.mRootView;
        }
        return null;
    }

    private C0445a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0445a c0445a;
        if (obj == null) {
            c0445a = cBQ();
        } else {
            c0445a = (C0445a) obj;
        }
        c0445a.jSS.setText(Hm(hotTopicBussinessData.mForumName));
        c0445a.jSR.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        am.k(c0445a.mRootView, R.drawable.select_forum_item_bg);
        am.j(c0445a.jSS, R.color.cp_cont_b);
        am.l(c0445a.fGr, R.color.cp_bg_line_e);
        return c0445a;
    }

    private C0445a cBQ() {
        C0445a c0445a = new C0445a();
        c0445a.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.hot_topic_change_item, (ViewGroup) null);
        am.k(c0445a.mRootView, R.drawable.select_forum_item_bg);
        am.j(c0445a.jSS, R.color.cp_cont_b);
        c0445a.jSS = (TextView) c0445a.mRootView.findViewById(R.id.fourm_tv);
        c0445a.fGr = c0445a.mRootView.findViewById(R.id.line_view);
        c0445a.jSR = (TbImageView) c0445a.mRootView.findViewById(R.id.icon_img);
        c0445a.jSR.setDefaultBgResource(R.color.cp_bg_line_e);
        c0445a.jSR.setDefaultResource(R.drawable.transparent_bg);
        c0445a.jSR.setDefaultErrorResource(R.drawable.icon_default_ba_120);
        c0445a.mRootView.setTag(c0445a);
        return c0445a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0445a {
        public View fGr;
        public TbImageView jSR;
        public TextView jSS;
        public View mRootView;

        private C0445a() {
        }
    }
}
