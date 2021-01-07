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
    private HotTopicChangeFourmActivity oar;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.oar = hotTopicChangeFourmActivity;
        this.mContext = this.oar.getPageContext().getContext();
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

    private String Vm(String str) {
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
        C0913a c0913a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0913a = a(view != null ? view.getTag() : null, item);
        } else {
            c0913a = null;
        }
        if (c0913a != null) {
            return c0913a.mRootView;
        }
        return null;
    }

    private C0913a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0913a c0913a;
        if (obj == null) {
            c0913a = dYN();
        } else {
            c0913a = (C0913a) obj;
        }
        c0913a.oat.setText(Vm(hotTopicBussinessData.mForumName));
        c0913a.oas.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        ao.setBackgroundResource(c0913a.mRootView, R.drawable.select_forum_item_bg);
        ao.setViewTextColor(c0913a.oat, R.color.CAM_X0105);
        ao.setBackgroundColor(c0913a.jrR, R.color.CAM_X0205);
        return c0913a;
    }

    private C0913a dYN() {
        C0913a c0913a = new C0913a();
        c0913a.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.hot_topic_change_item, (ViewGroup) null);
        ao.setBackgroundResource(c0913a.mRootView, R.drawable.select_forum_item_bg);
        ao.setViewTextColor(c0913a.oat, R.color.CAM_X0105);
        c0913a.oat = (TextView) c0913a.mRootView.findViewById(R.id.fourm_tv);
        c0913a.jrR = c0913a.mRootView.findViewById(R.id.line_view);
        c0913a.oas = (TbImageView) c0913a.mRootView.findViewById(R.id.icon_img);
        c0913a.oas.setDefaultBgResource(R.color.CAM_X0205);
        c0913a.oas.setDefaultResource(R.drawable.transparent_bg);
        c0913a.mRootView.setTag(c0913a);
        return c0913a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0913a {
        public View jrR;
        public View mRootView;
        public TbImageView oas;
        public TextView oat;

        private C0913a() {
        }
    }
}
