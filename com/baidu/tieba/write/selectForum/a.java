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
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private HotTopicChangeFourmActivity jIi;
    private final Context mContext;
    private List<HotTopicBussinessData> mData;
    private ViewGroup mParent = null;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.jIi = hotTopicChangeFourmActivity;
        this.mContext = this.jIi.getPageContext().getContext();
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
    /* renamed from: Cu */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String FP(String str) {
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
        C0429a c0429a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0429a = a(view != null ? view.getTag() : null, item);
        } else {
            c0429a = null;
        }
        if (c0429a != null) {
            return c0429a.mRootView;
        }
        return null;
    }

    private C0429a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0429a c0429a;
        if (obj == null) {
            c0429a = cxK();
        } else {
            c0429a = (C0429a) obj;
        }
        c0429a.jIk.setText(FP(hotTopicBussinessData.mForumName));
        c0429a.jIj.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        al.k(c0429a.mRootView, R.drawable.select_forum_item_bg);
        al.j(c0429a.jIk, R.color.cp_cont_b);
        al.l(c0429a.fyS, R.color.cp_bg_line_e);
        return c0429a;
    }

    private C0429a cxK() {
        C0429a c0429a = new C0429a();
        c0429a.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.hot_topic_change_item, (ViewGroup) null);
        al.k(c0429a.mRootView, R.drawable.select_forum_item_bg);
        al.j(c0429a.jIk, R.color.cp_cont_b);
        c0429a.jIk = (TextView) c0429a.mRootView.findViewById(R.id.fourm_tv);
        c0429a.fyS = c0429a.mRootView.findViewById(R.id.line_view);
        c0429a.jIj = (TbImageView) c0429a.mRootView.findViewById(R.id.icon_img);
        c0429a.jIj.setDefaultBgResource(R.color.cp_bg_line_e);
        c0429a.jIj.setDefaultResource(R.drawable.transparent_bg);
        c0429a.jIj.setDefaultErrorResource(R.drawable.icon_default_ba_120);
        c0429a.mRootView.setTag(c0429a);
        return c0429a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0429a {
        public View fyS;
        public TbImageView jIj;
        public TextView jIk;
        public View mRootView;

        private C0429a() {
        }
    }
}
