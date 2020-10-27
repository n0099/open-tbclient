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
    private HotTopicChangeFourmActivity nBW;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.nBW = hotTopicChangeFourmActivity;
        this.mContext = this.nBW.getPageContext().getContext();
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
    /* renamed from: Lg */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String Uu(String str) {
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
        C0864a c0864a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0864a = a(view != null ? view.getTag() : null, item);
        } else {
            c0864a = null;
        }
        if (c0864a != null) {
            return c0864a.mRootView;
        }
        return null;
    }

    private C0864a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0864a c0864a;
        if (obj == null) {
            c0864a = dRv();
        } else {
            c0864a = (C0864a) obj;
        }
        c0864a.nBY.setText(Uu(hotTopicBussinessData.mForumName));
        c0864a.nBX.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        ap.setBackgroundResource(c0864a.mRootView, R.drawable.select_forum_item_bg);
        ap.setViewTextColor(c0864a.nBY, R.color.cp_cont_b);
        ap.setBackgroundColor(c0864a.iNL, R.color.cp_bg_line_e);
        return c0864a;
    }

    private C0864a dRv() {
        C0864a c0864a = new C0864a();
        c0864a.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.hot_topic_change_item, (ViewGroup) null);
        ap.setBackgroundResource(c0864a.mRootView, R.drawable.select_forum_item_bg);
        ap.setViewTextColor(c0864a.nBY, R.color.cp_cont_b);
        c0864a.nBY = (TextView) c0864a.mRootView.findViewById(R.id.fourm_tv);
        c0864a.iNL = c0864a.mRootView.findViewById(R.id.line_view);
        c0864a.nBX = (TbImageView) c0864a.mRootView.findViewById(R.id.icon_img);
        c0864a.nBX.setDefaultBgResource(R.color.cp_bg_line_e);
        c0864a.nBX.setDefaultResource(R.drawable.transparent_bg);
        c0864a.nBX.setDefaultErrorResource(R.drawable.icon_default_ba_120);
        c0864a.mRootView.setTag(c0864a);
        return c0864a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0864a {
        public View iNL;
        public View mRootView;
        public TbImageView nBX;
        public TextView nBY;

        private C0864a() {
        }
    }
}
