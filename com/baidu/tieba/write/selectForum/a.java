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
    private HotTopicChangeFourmActivity nXz;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.nXz = hotTopicChangeFourmActivity;
        this.mContext = this.nXz.getPageContext().getContext();
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
    /* renamed from: MO */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String VL(String str) {
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
        C0898a c0898a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0898a = a(view != null ? view.getTag() : null, item);
        } else {
            c0898a = null;
        }
        if (c0898a != null) {
            return c0898a.mRootView;
        }
        return null;
    }

    private C0898a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0898a c0898a;
        if (obj == null) {
            c0898a = dZp();
        } else {
            c0898a = (C0898a) obj;
        }
        c0898a.nXB.setText(VL(hotTopicBussinessData.mForumName));
        c0898a.nXA.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        ap.setBackgroundResource(c0898a.mRootView, R.drawable.select_forum_item_bg);
        ap.setViewTextColor(c0898a.nXB, R.color.CAM_X0105);
        ap.setBackgroundColor(c0898a.jfs, R.color.CAM_X0205);
        return c0898a;
    }

    private C0898a dZp() {
        C0898a c0898a = new C0898a();
        c0898a.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.hot_topic_change_item, (ViewGroup) null);
        ap.setBackgroundResource(c0898a.mRootView, R.drawable.select_forum_item_bg);
        ap.setViewTextColor(c0898a.nXB, R.color.CAM_X0105);
        c0898a.nXB = (TextView) c0898a.mRootView.findViewById(R.id.fourm_tv);
        c0898a.jfs = c0898a.mRootView.findViewById(R.id.line_view);
        c0898a.nXA = (TbImageView) c0898a.mRootView.findViewById(R.id.icon_img);
        c0898a.nXA.setDefaultBgResource(R.color.CAM_X0205);
        c0898a.nXA.setDefaultResource(R.drawable.transparent_bg);
        c0898a.nXA.setDefaultErrorResource(R.drawable.icon_default_ba_120);
        c0898a.mRootView.setTag(c0898a);
        return c0898a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0898a {
        public View jfs;
        public View mRootView;
        public TbImageView nXA;
        public TextView nXB;

        private C0898a() {
        }
    }
}
