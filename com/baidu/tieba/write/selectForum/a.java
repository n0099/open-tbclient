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
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private HotTopicChangeFourmActivity lTP;
    private final Context mContext;
    private List<HotTopicBussinessData> mData;
    private ViewGroup mParent = null;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.lTP = hotTopicChangeFourmActivity;
        this.mContext = this.lTP.getPageContext().getContext();
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
    /* renamed from: FE */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String Op(String str) {
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
        C0753a c0753a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0753a = a(view != null ? view.getTag() : null, item);
        } else {
            c0753a = null;
        }
        if (c0753a != null) {
            return c0753a.mRootView;
        }
        return null;
    }

    private C0753a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0753a c0753a;
        if (obj == null) {
            c0753a = dnl();
        } else {
            c0753a = (C0753a) obj;
        }
        c0753a.lTR.setText(Op(hotTopicBussinessData.mForumName));
        c0753a.lTQ.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        am.setBackgroundResource(c0753a.mRootView, R.drawable.select_forum_item_bg);
        am.setViewTextColor(c0753a.lTR, (int) R.color.cp_cont_b);
        am.setBackgroundColor(c0753a.hxW, R.color.cp_bg_line_e);
        return c0753a;
    }

    private C0753a dnl() {
        C0753a c0753a = new C0753a();
        c0753a.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.hot_topic_change_item, (ViewGroup) null);
        am.setBackgroundResource(c0753a.mRootView, R.drawable.select_forum_item_bg);
        am.setViewTextColor(c0753a.lTR, (int) R.color.cp_cont_b);
        c0753a.lTR = (TextView) c0753a.mRootView.findViewById(R.id.fourm_tv);
        c0753a.hxW = c0753a.mRootView.findViewById(R.id.line_view);
        c0753a.lTQ = (TbImageView) c0753a.mRootView.findViewById(R.id.icon_img);
        c0753a.lTQ.setDefaultBgResource(R.color.cp_bg_line_e);
        c0753a.lTQ.setDefaultResource(R.drawable.transparent_bg);
        c0753a.lTQ.setDefaultErrorResource(R.drawable.icon_default_ba_120);
        c0753a.mRootView.setTag(c0753a);
        return c0753a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0753a {
        public View hxW;
        public TbImageView lTQ;
        public TextView lTR;
        public View mRootView;

        private C0753a() {
        }
    }
}
