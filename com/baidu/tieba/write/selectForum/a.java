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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes13.dex */
public class a extends BaseAdapter {
    private HotTopicChangeFourmActivity kOY;
    private final Context mContext;
    private List<HotTopicBussinessData> mData;
    private ViewGroup mParent = null;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.kOY = hotTopicChangeFourmActivity;
        this.mContext = this.kOY.getPageContext().getContext();
    }

    public void setData(List<HotTopicBussinessData> list) {
        this.mData = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.mData)) {
            return 0;
        }
        return this.mData.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Ej */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String KT(String str) {
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
        C0633a c0633a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0633a = a(view != null ? view.getTag() : null, item);
        } else {
            c0633a = null;
        }
        if (c0633a != null) {
            return c0633a.mRootView;
        }
        return null;
    }

    private C0633a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0633a c0633a;
        if (obj == null) {
            c0633a = cUW();
        } else {
            c0633a = (C0633a) obj;
        }
        c0633a.kPa.setText(KT(hotTopicBussinessData.mForumName));
        c0633a.kOZ.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        am.setBackgroundResource(c0633a.mRootView, R.drawable.select_forum_item_bg);
        am.setViewTextColor(c0633a.kPa, (int) R.color.cp_cont_b);
        am.setBackgroundColor(c0633a.gyI, R.color.cp_bg_line_e);
        return c0633a;
    }

    private C0633a cUW() {
        C0633a c0633a = new C0633a();
        c0633a.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.hot_topic_change_item, (ViewGroup) null);
        am.setBackgroundResource(c0633a.mRootView, R.drawable.select_forum_item_bg);
        am.setViewTextColor(c0633a.kPa, (int) R.color.cp_cont_b);
        c0633a.kPa = (TextView) c0633a.mRootView.findViewById(R.id.fourm_tv);
        c0633a.gyI = c0633a.mRootView.findViewById(R.id.line_view);
        c0633a.kOZ = (TbImageView) c0633a.mRootView.findViewById(R.id.icon_img);
        c0633a.kOZ.setDefaultBgResource(R.color.cp_bg_line_e);
        c0633a.kOZ.setDefaultResource(R.drawable.transparent_bg);
        c0633a.kOZ.setDefaultErrorResource(R.drawable.icon_default_ba_120);
        c0633a.mRootView.setTag(c0633a);
        return c0633a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class C0633a {
        public View gyI;
        public TbImageView kOZ;
        public TextView kPa;
        public View mRootView;

        private C0633a() {
        }
    }
}
