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
    private HotTopicChangeFourmActivity npx;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.npx = hotTopicChangeFourmActivity;
        this.mContext = this.npx.getPageContext().getContext();
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
    /* renamed from: KO */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String TV(String str) {
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
        C0849a c0849a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0849a = a(view != null ? view.getTag() : null, item);
        } else {
            c0849a = null;
        }
        if (c0849a != null) {
            return c0849a.mRootView;
        }
        return null;
    }

    private C0849a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0849a c0849a;
        if (obj == null) {
            c0849a = dOn();
        } else {
            c0849a = (C0849a) obj;
        }
        c0849a.npz.setText(TV(hotTopicBussinessData.mForumName));
        c0849a.npy.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        ap.setBackgroundResource(c0849a.mRootView, R.drawable.select_forum_item_bg);
        ap.setViewTextColor(c0849a.npz, R.color.cp_cont_b);
        ap.setBackgroundColor(c0849a.iBp, R.color.cp_bg_line_e);
        return c0849a;
    }

    private C0849a dOn() {
        C0849a c0849a = new C0849a();
        c0849a.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.hot_topic_change_item, (ViewGroup) null);
        ap.setBackgroundResource(c0849a.mRootView, R.drawable.select_forum_item_bg);
        ap.setViewTextColor(c0849a.npz, R.color.cp_cont_b);
        c0849a.npz = (TextView) c0849a.mRootView.findViewById(R.id.fourm_tv);
        c0849a.iBp = c0849a.mRootView.findViewById(R.id.line_view);
        c0849a.npy = (TbImageView) c0849a.mRootView.findViewById(R.id.icon_img);
        c0849a.npy.setDefaultBgResource(R.color.cp_bg_line_e);
        c0849a.npy.setDefaultResource(R.drawable.transparent_bg);
        c0849a.npy.setDefaultErrorResource(R.drawable.icon_default_ba_120);
        c0849a.mRootView.setTag(c0849a);
        return c0849a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0849a {
        public View iBp;
        public View mRootView;
        public TbImageView npy;
        public TextView npz;

        private C0849a() {
        }
    }
}
