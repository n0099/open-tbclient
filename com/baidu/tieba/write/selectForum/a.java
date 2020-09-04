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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private final Context mContext;
    private List<HotTopicBussinessData> mData;
    private ViewGroup mParent = null;
    private HotTopicChangeFourmActivity mQf;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.mQf = hotTopicChangeFourmActivity;
        this.mContext = this.mQf.getPageContext().getContext();
    }

    public void setData(List<HotTopicBussinessData> list) {
        this.mData = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.mData)) {
            return 0;
        }
        return this.mData.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: JD */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String SH(String str) {
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
        C0834a c0834a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0834a = a(view != null ? view.getTag() : null, item);
        } else {
            c0834a = null;
        }
        if (c0834a != null) {
            return c0834a.mRootView;
        }
        return null;
    }

    private C0834a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0834a c0834a;
        if (obj == null) {
            c0834a = dGK();
        } else {
            c0834a = (C0834a) obj;
        }
        c0834a.mQh.setText(SH(hotTopicBussinessData.mForumName));
        c0834a.mQg.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        ap.setBackgroundResource(c0834a.mRootView, R.drawable.select_forum_item_bg);
        ap.setViewTextColor(c0834a.mQh, R.color.cp_cont_b);
        ap.setBackgroundColor(c0834a.ifu, R.color.cp_bg_line_e);
        return c0834a;
    }

    private C0834a dGK() {
        C0834a c0834a = new C0834a();
        c0834a.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.hot_topic_change_item, (ViewGroup) null);
        ap.setBackgroundResource(c0834a.mRootView, R.drawable.select_forum_item_bg);
        ap.setViewTextColor(c0834a.mQh, R.color.cp_cont_b);
        c0834a.mQh = (TextView) c0834a.mRootView.findViewById(R.id.fourm_tv);
        c0834a.ifu = c0834a.mRootView.findViewById(R.id.line_view);
        c0834a.mQg = (TbImageView) c0834a.mRootView.findViewById(R.id.icon_img);
        c0834a.mQg.setDefaultBgResource(R.color.cp_bg_line_e);
        c0834a.mQg.setDefaultResource(R.drawable.transparent_bg);
        c0834a.mQg.setDefaultErrorResource(R.drawable.icon_default_ba_120);
        c0834a.mRootView.setTag(c0834a);
        return c0834a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0834a {
        public View ifu;
        public TbImageView mQg;
        public TextView mQh;
        public View mRootView;

        private C0834a() {
        }
    }
}
