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
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private final Context mContext;
    private List<HotTopicBussinessData> mData;
    private ViewGroup mParent = null;
    private HotTopicChangeFourmActivity ofU;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.ofU = hotTopicChangeFourmActivity;
        this.mContext = this.ofU.getPageContext().getContext();
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
    /* renamed from: Lp */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String Vd(String str) {
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
        C0899a c0899a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0899a = a(view != null ? view.getTag() : null, item);
        } else {
            c0899a = null;
        }
        if (c0899a != null) {
            return c0899a.mRootView;
        }
        return null;
    }

    private C0899a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0899a c0899a;
        if (obj == null) {
            c0899a = dXj();
        } else {
            c0899a = (C0899a) obj;
        }
        c0899a.ofW.setText(Vd(hotTopicBussinessData.mForumName));
        c0899a.ofV.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        ap.setBackgroundResource(c0899a.mRootView, R.drawable.select_forum_item_bg);
        ap.setViewTextColor(c0899a.ofW, R.color.CAM_X0105);
        ap.setBackgroundColor(c0899a.jsR, R.color.CAM_X0205);
        return c0899a;
    }

    private C0899a dXj() {
        C0899a c0899a = new C0899a();
        c0899a.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.hot_topic_change_item, (ViewGroup) null);
        ap.setBackgroundResource(c0899a.mRootView, R.drawable.select_forum_item_bg);
        ap.setViewTextColor(c0899a.ofW, R.color.CAM_X0105);
        c0899a.ofW = (TextView) c0899a.mRootView.findViewById(R.id.fourm_tv);
        c0899a.jsR = c0899a.mRootView.findViewById(R.id.line_view);
        c0899a.ofV = (TbImageView) c0899a.mRootView.findViewById(R.id.icon_img);
        c0899a.ofV.setDefaultBgResource(R.color.CAM_X0205);
        c0899a.ofV.setDefaultResource(R.drawable.transparent_bg);
        c0899a.mRootView.setTag(c0899a);
        return c0899a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0899a {
        public View jsR;
        public View mRootView;
        public TbImageView ofV;
        public TextView ofW;

        private C0899a() {
        }
    }
}
