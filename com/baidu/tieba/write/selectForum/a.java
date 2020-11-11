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
    private HotTopicChangeFourmActivity nHQ;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.nHQ = hotTopicChangeFourmActivity;
        this.mContext = this.nHQ.getPageContext().getContext();
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
    /* renamed from: Lt */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String UL(String str) {
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
        C0879a c0879a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0879a = a(view != null ? view.getTag() : null, item);
        } else {
            c0879a = null;
        }
        if (c0879a != null) {
            return c0879a.mRootView;
        }
        return null;
    }

    private C0879a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0879a c0879a;
        if (obj == null) {
            c0879a = dTV();
        } else {
            c0879a = (C0879a) obj;
        }
        c0879a.nHS.setText(UL(hotTopicBussinessData.mForumName));
        c0879a.nHR.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        ap.setBackgroundResource(c0879a.mRootView, R.drawable.select_forum_item_bg);
        ap.setViewTextColor(c0879a.nHS, R.color.cp_cont_b);
        ap.setBackgroundColor(c0879a.iTI, R.color.cp_bg_line_e);
        return c0879a;
    }

    private C0879a dTV() {
        C0879a c0879a = new C0879a();
        c0879a.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.hot_topic_change_item, (ViewGroup) null);
        ap.setBackgroundResource(c0879a.mRootView, R.drawable.select_forum_item_bg);
        ap.setViewTextColor(c0879a.nHS, R.color.cp_cont_b);
        c0879a.nHS = (TextView) c0879a.mRootView.findViewById(R.id.fourm_tv);
        c0879a.iTI = c0879a.mRootView.findViewById(R.id.line_view);
        c0879a.nHR = (TbImageView) c0879a.mRootView.findViewById(R.id.icon_img);
        c0879a.nHR.setDefaultBgResource(R.color.cp_bg_line_e);
        c0879a.nHR.setDefaultResource(R.drawable.transparent_bg);
        c0879a.nHR.setDefaultErrorResource(R.drawable.icon_default_ba_120);
        c0879a.mRootView.setTag(c0879a);
        return c0879a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0879a {
        public View iTI;
        public View mRootView;
        public TbImageView nHR;
        public TextView nHS;

        private C0879a() {
        }
    }
}
