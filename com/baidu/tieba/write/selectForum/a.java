package com.baidu.tieba.write.selectForum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private HotTopicChangeFourmActivity lVa;
    private final Context mContext;
    private List<HotTopicBussinessData> mData;
    private ViewGroup mParent = null;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.lVa = hotTopicChangeFourmActivity;
        this.mContext = this.lVa.getPageContext().getContext();
    }

    public void setData(List<HotTopicBussinessData> list) {
        this.mData = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.mData)) {
            return 0;
        }
        return this.mData.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: FG */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String Oq(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (str.length() > 14) {
            return str.substring(0, 13) + StringHelper.STRING_MORE;
        }
        return str;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0754a c0754a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0754a = a(view != null ? view.getTag() : null, item);
        } else {
            c0754a = null;
        }
        if (c0754a != null) {
            return c0754a.mRootView;
        }
        return null;
    }

    private C0754a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0754a c0754a;
        if (obj == null) {
            c0754a = dnC();
        } else {
            c0754a = (C0754a) obj;
        }
        c0754a.lVc.setText(Oq(hotTopicBussinessData.mForumName));
        c0754a.lVb.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        am.setBackgroundResource(c0754a.mRootView, R.drawable.select_forum_item_bg);
        am.setViewTextColor(c0754a.lVc, (int) R.color.cp_cont_b);
        am.setBackgroundColor(c0754a.hyh, R.color.cp_bg_line_e);
        return c0754a;
    }

    private C0754a dnC() {
        C0754a c0754a = new C0754a();
        c0754a.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.hot_topic_change_item, (ViewGroup) null);
        am.setBackgroundResource(c0754a.mRootView, R.drawable.select_forum_item_bg);
        am.setViewTextColor(c0754a.lVc, (int) R.color.cp_cont_b);
        c0754a.lVc = (TextView) c0754a.mRootView.findViewById(R.id.fourm_tv);
        c0754a.hyh = c0754a.mRootView.findViewById(R.id.line_view);
        c0754a.lVb = (TbImageView) c0754a.mRootView.findViewById(R.id.icon_img);
        c0754a.lVb.setDefaultBgResource(R.color.cp_bg_line_e);
        c0754a.lVb.setDefaultResource(R.drawable.transparent_bg);
        c0754a.lVb.setDefaultErrorResource(R.drawable.icon_default_ba_120);
        c0754a.mRootView.setTag(c0754a);
        return c0754a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0754a {
        public View hyh;
        public TbImageView lVb;
        public TextView lVc;
        public View mRootView;

        private C0754a() {
        }
    }
}
