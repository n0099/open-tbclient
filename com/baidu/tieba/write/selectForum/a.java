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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private final Context mContext;
    private List<HotTopicBussinessData> mData;
    private ViewGroup mParent = null;
    private HotTopicChangeFourmActivity mxw;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.mxw = hotTopicChangeFourmActivity;
        this.mContext = this.mxw.getPageContext().getContext();
    }

    public void setData(List<HotTopicBussinessData> list) {
        this.mData = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (x.isEmpty(this.mData)) {
            return 0;
        }
        return this.mData.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Hg */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String PJ(String str) {
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
        C0781a c0781a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0781a = a(view != null ? view.getTag() : null, item);
        } else {
            c0781a = null;
        }
        if (c0781a != null) {
            return c0781a.mRootView;
        }
        return null;
    }

    private C0781a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0781a c0781a;
        if (obj == null) {
            c0781a = dve();
        } else {
            c0781a = (C0781a) obj;
        }
        c0781a.mxy.setText(PJ(hotTopicBussinessData.mForumName));
        c0781a.mxx.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        ao.setBackgroundResource(c0781a.mRootView, R.drawable.select_forum_item_bg);
        ao.setViewTextColor(c0781a.mxy, R.color.cp_cont_b);
        ao.setBackgroundColor(c0781a.hRd, R.color.cp_bg_line_e);
        return c0781a;
    }

    private C0781a dve() {
        C0781a c0781a = new C0781a();
        c0781a.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.hot_topic_change_item, (ViewGroup) null);
        ao.setBackgroundResource(c0781a.mRootView, R.drawable.select_forum_item_bg);
        ao.setViewTextColor(c0781a.mxy, R.color.cp_cont_b);
        c0781a.mxy = (TextView) c0781a.mRootView.findViewById(R.id.fourm_tv);
        c0781a.hRd = c0781a.mRootView.findViewById(R.id.line_view);
        c0781a.mxx = (TbImageView) c0781a.mRootView.findViewById(R.id.icon_img);
        c0781a.mxx.setDefaultBgResource(R.color.cp_bg_line_e);
        c0781a.mxx.setDefaultResource(R.drawable.transparent_bg);
        c0781a.mxx.setDefaultErrorResource(R.drawable.icon_default_ba_120);
        c0781a.mRootView.setTag(c0781a);
        return c0781a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0781a {
        public View hRd;
        public View mRootView;
        public TbImageView mxx;
        public TextView mxy;

        private C0781a() {
        }
    }
}
