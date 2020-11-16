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
    private HotTopicChangeFourmActivity nJr;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.nJr = hotTopicChangeFourmActivity;
        this.mContext = this.nJr.getPageContext().getContext();
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
    /* renamed from: LW */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String Uw(String str) {
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
        C0882a c0882a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0882a = a(view != null ? view.getTag() : null, item);
        } else {
            c0882a = null;
        }
        if (c0882a != null) {
            return c0882a.mRootView;
        }
        return null;
    }

    private C0882a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0882a c0882a;
        if (obj == null) {
            c0882a = dTU();
        } else {
            c0882a = (C0882a) obj;
        }
        c0882a.nJt.setText(Uw(hotTopicBussinessData.mForumName));
        c0882a.nJs.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        ap.setBackgroundResource(c0882a.mRootView, R.drawable.select_forum_item_bg);
        ap.setViewTextColor(c0882a.nJt, R.color.CAM_X0105);
        ap.setBackgroundColor(c0882a.iUu, R.color.CAM_X0205);
        return c0882a;
    }

    private C0882a dTU() {
        C0882a c0882a = new C0882a();
        c0882a.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.hot_topic_change_item, (ViewGroup) null);
        ap.setBackgroundResource(c0882a.mRootView, R.drawable.select_forum_item_bg);
        ap.setViewTextColor(c0882a.nJt, R.color.CAM_X0105);
        c0882a.nJt = (TextView) c0882a.mRootView.findViewById(R.id.fourm_tv);
        c0882a.iUu = c0882a.mRootView.findViewById(R.id.line_view);
        c0882a.nJs = (TbImageView) c0882a.mRootView.findViewById(R.id.icon_img);
        c0882a.nJs.setDefaultBgResource(R.color.CAM_X0205);
        c0882a.nJs.setDefaultResource(R.drawable.transparent_bg);
        c0882a.nJs.setDefaultErrorResource(R.drawable.icon_default_ba_120);
        c0882a.mRootView.setTag(c0882a);
        return c0882a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0882a {
        public View iUu;
        public View mRootView;
        public TbImageView nJs;
        public TextView nJt;

        private C0882a() {
        }
    }
}
