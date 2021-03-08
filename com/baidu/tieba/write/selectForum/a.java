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
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private final Context mContext;
    private List<HotTopicBussinessData> mData;
    private ViewGroup mParent = null;
    private HotTopicChangeFourmActivity oiz;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.oiz = hotTopicChangeFourmActivity;
        this.mContext = this.oiz.getPageContext().getContext();
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
    /* renamed from: Lu */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String Vw(String str) {
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
        C0907a c0907a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0907a = a(view != null ? view.getTag() : null, item);
        } else {
            c0907a = null;
        }
        if (c0907a != null) {
            return c0907a.mRootView;
        }
        return null;
    }

    private C0907a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0907a c0907a;
        if (obj == null) {
            c0907a = dXz();
        } else {
            c0907a = (C0907a) obj;
        }
        c0907a.oiB.setText(Vw(hotTopicBussinessData.mForumName));
        c0907a.oiA.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        ap.setBackgroundResource(c0907a.mRootView, R.drawable.select_forum_item_bg);
        ap.setViewTextColor(c0907a.oiB, R.color.CAM_X0105);
        ap.setBackgroundColor(c0907a.juO, R.color.CAM_X0205);
        return c0907a;
    }

    private C0907a dXz() {
        C0907a c0907a = new C0907a();
        c0907a.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.hot_topic_change_item, (ViewGroup) null);
        ap.setBackgroundResource(c0907a.mRootView, R.drawable.select_forum_item_bg);
        ap.setViewTextColor(c0907a.oiB, R.color.CAM_X0105);
        c0907a.oiB = (TextView) c0907a.mRootView.findViewById(R.id.fourm_tv);
        c0907a.juO = c0907a.mRootView.findViewById(R.id.line_view);
        c0907a.oiA = (TbImageView) c0907a.mRootView.findViewById(R.id.icon_img);
        c0907a.oiA.setDefaultBgResource(R.color.CAM_X0205);
        c0907a.oiA.setDefaultResource(R.drawable.transparent_bg);
        c0907a.mRootView.setTag(c0907a);
        return c0907a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0907a {
        public View juO;
        public View mRootView;
        public TbImageView oiA;
        public TextView oiB;

        private C0907a() {
        }
    }
}
