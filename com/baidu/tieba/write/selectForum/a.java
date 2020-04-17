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
    private HotTopicChangeFourmActivity lAx;
    private final Context mContext;
    private List<HotTopicBussinessData> mData;
    private ViewGroup mParent = null;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.lAx = hotTopicChangeFourmActivity;
        this.mContext = this.lAx.getPageContext().getContext();
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
    /* renamed from: ER */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String Mz(String str) {
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
        C0679a c0679a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0679a = a(view != null ? view.getTag() : null, item);
        } else {
            c0679a = null;
        }
        if (c0679a != null) {
            return c0679a.mRootView;
        }
        return null;
    }

    private C0679a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0679a c0679a;
        if (obj == null) {
            c0679a = dfX();
        } else {
            c0679a = (C0679a) obj;
        }
        c0679a.lAz.setText(Mz(hotTopicBussinessData.mForumName));
        c0679a.lAy.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        am.setBackgroundResource(c0679a.mRootView, R.drawable.select_forum_item_bg);
        am.setViewTextColor(c0679a.lAz, (int) R.color.cp_cont_b);
        am.setBackgroundColor(c0679a.hjc, R.color.cp_bg_line_e);
        return c0679a;
    }

    private C0679a dfX() {
        C0679a c0679a = new C0679a();
        c0679a.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.hot_topic_change_item, (ViewGroup) null);
        am.setBackgroundResource(c0679a.mRootView, R.drawable.select_forum_item_bg);
        am.setViewTextColor(c0679a.lAz, (int) R.color.cp_cont_b);
        c0679a.lAz = (TextView) c0679a.mRootView.findViewById(R.id.fourm_tv);
        c0679a.hjc = c0679a.mRootView.findViewById(R.id.line_view);
        c0679a.lAy = (TbImageView) c0679a.mRootView.findViewById(R.id.icon_img);
        c0679a.lAy.setDefaultBgResource(R.color.cp_bg_line_e);
        c0679a.lAy.setDefaultResource(R.drawable.transparent_bg);
        c0679a.lAy.setDefaultErrorResource(R.drawable.icon_default_ba_120);
        c0679a.mRootView.setTag(c0679a);
        return c0679a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0679a {
        public View hjc;
        public TbImageView lAy;
        public TextView lAz;
        public View mRootView;

        private C0679a() {
        }
    }
}
