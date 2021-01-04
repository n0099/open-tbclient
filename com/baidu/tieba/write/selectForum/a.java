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
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private final Context mContext;
    private List<HotTopicBussinessData> mData;
    private ViewGroup mParent = null;
    private HotTopicChangeFourmActivity oas;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.oas = hotTopicChangeFourmActivity;
        this.mContext = this.oas.getPageContext().getContext();
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
    /* renamed from: MB */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String Vn(String str) {
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
        C0875a c0875a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0875a = a(view != null ? view.getTag() : null, item);
        } else {
            c0875a = null;
        }
        if (c0875a != null) {
            return c0875a.mRootView;
        }
        return null;
    }

    private C0875a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0875a c0875a;
        if (obj == null) {
            c0875a = dYM();
        } else {
            c0875a = (C0875a) obj;
        }
        c0875a.oau.setText(Vn(hotTopicBussinessData.mForumName));
        c0875a.oat.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        ao.setBackgroundResource(c0875a.mRootView, R.drawable.select_forum_item_bg);
        ao.setViewTextColor(c0875a.oau, R.color.CAM_X0105);
        ao.setBackgroundColor(c0875a.jrR, R.color.CAM_X0205);
        return c0875a;
    }

    private C0875a dYM() {
        C0875a c0875a = new C0875a();
        c0875a.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.hot_topic_change_item, (ViewGroup) null);
        ao.setBackgroundResource(c0875a.mRootView, R.drawable.select_forum_item_bg);
        ao.setViewTextColor(c0875a.oau, R.color.CAM_X0105);
        c0875a.oau = (TextView) c0875a.mRootView.findViewById(R.id.fourm_tv);
        c0875a.jrR = c0875a.mRootView.findViewById(R.id.line_view);
        c0875a.oat = (TbImageView) c0875a.mRootView.findViewById(R.id.icon_img);
        c0875a.oat.setDefaultBgResource(R.color.CAM_X0205);
        c0875a.oat.setDefaultResource(R.drawable.transparent_bg);
        c0875a.mRootView.setTag(c0875a);
        return c0875a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0875a {
        public View jrR;
        public View mRootView;
        public TbImageView oat;
        public TextView oau;

        private C0875a() {
        }
    }
}
