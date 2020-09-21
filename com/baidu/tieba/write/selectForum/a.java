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
    private HotTopicChangeFourmActivity mZX;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.mZX = hotTopicChangeFourmActivity;
        this.mContext = this.mZX.getPageContext().getContext();
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
    /* renamed from: Ki */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String Th(String str) {
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
        C0831a c0831a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0831a = a(view != null ? view.getTag() : null, item);
        } else {
            c0831a = null;
        }
        if (c0831a != null) {
            return c0831a.mRootView;
        }
        return null;
    }

    private C0831a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0831a c0831a;
        if (obj == null) {
            c0831a = dKB();
        } else {
            c0831a = (C0831a) obj;
        }
        c0831a.mZZ.setText(Th(hotTopicBussinessData.mForumName));
        c0831a.mZY.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        ap.setBackgroundResource(c0831a.mRootView, R.drawable.select_forum_item_bg);
        ap.setViewTextColor(c0831a.mZZ, R.color.cp_cont_b);
        ap.setBackgroundColor(c0831a.imv, R.color.cp_bg_line_e);
        return c0831a;
    }

    private C0831a dKB() {
        C0831a c0831a = new C0831a();
        c0831a.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.hot_topic_change_item, (ViewGroup) null);
        ap.setBackgroundResource(c0831a.mRootView, R.drawable.select_forum_item_bg);
        ap.setViewTextColor(c0831a.mZZ, R.color.cp_cont_b);
        c0831a.mZZ = (TextView) c0831a.mRootView.findViewById(R.id.fourm_tv);
        c0831a.imv = c0831a.mRootView.findViewById(R.id.line_view);
        c0831a.mZY = (TbImageView) c0831a.mRootView.findViewById(R.id.icon_img);
        c0831a.mZY.setDefaultBgResource(R.color.cp_bg_line_e);
        c0831a.mZY.setDefaultResource(R.drawable.transparent_bg);
        c0831a.mZY.setDefaultErrorResource(R.drawable.icon_default_ba_120);
        c0831a.mRootView.setTag(c0831a);
        return c0831a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0831a {
        public View imv;
        public View mRootView;
        public TbImageView mZY;
        public TextView mZZ;

        private C0831a() {
        }
    }
}
