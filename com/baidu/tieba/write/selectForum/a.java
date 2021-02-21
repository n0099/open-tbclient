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
    private HotTopicChangeFourmActivity ogu;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.ogu = hotTopicChangeFourmActivity;
        this.mContext = this.ogu.getPageContext().getContext();
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
    /* renamed from: Lq */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String Vp(String str) {
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
        C0901a c0901a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0901a = a(view != null ? view.getTag() : null, item);
        } else {
            c0901a = null;
        }
        if (c0901a != null) {
            return c0901a.mRootView;
        }
        return null;
    }

    private C0901a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0901a c0901a;
        if (obj == null) {
            c0901a = dXr();
        } else {
            c0901a = (C0901a) obj;
        }
        c0901a.ogw.setText(Vp(hotTopicBussinessData.mForumName));
        c0901a.ogv.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        ap.setBackgroundResource(c0901a.mRootView, R.drawable.select_forum_item_bg);
        ap.setViewTextColor(c0901a.ogw, R.color.CAM_X0105);
        ap.setBackgroundColor(c0901a.jtf, R.color.CAM_X0205);
        return c0901a;
    }

    private C0901a dXr() {
        C0901a c0901a = new C0901a();
        c0901a.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.hot_topic_change_item, (ViewGroup) null);
        ap.setBackgroundResource(c0901a.mRootView, R.drawable.select_forum_item_bg);
        ap.setViewTextColor(c0901a.ogw, R.color.CAM_X0105);
        c0901a.ogw = (TextView) c0901a.mRootView.findViewById(R.id.fourm_tv);
        c0901a.jtf = c0901a.mRootView.findViewById(R.id.line_view);
        c0901a.ogv = (TbImageView) c0901a.mRootView.findViewById(R.id.icon_img);
        c0901a.ogv.setDefaultBgResource(R.color.CAM_X0205);
        c0901a.ogv.setDefaultResource(R.drawable.transparent_bg);
        c0901a.mRootView.setTag(c0901a);
        return c0901a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0901a {
        public View jtf;
        public View mRootView;
        public TbImageView ogv;
        public TextView ogw;

        private C0901a() {
        }
    }
}
