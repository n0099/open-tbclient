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
    private HotTopicChangeFourmActivity lAB;
    private final Context mContext;
    private List<HotTopicBussinessData> mData;
    private ViewGroup mParent = null;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.lAB = hotTopicChangeFourmActivity;
        this.mContext = this.lAB.getPageContext().getContext();
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

    private String MC(String str) {
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
        C0700a c0700a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0700a = a(view != null ? view.getTag() : null, item);
        } else {
            c0700a = null;
        }
        if (c0700a != null) {
            return c0700a.mRootView;
        }
        return null;
    }

    private C0700a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0700a c0700a;
        if (obj == null) {
            c0700a = dfV();
        } else {
            c0700a = (C0700a) obj;
        }
        c0700a.lAD.setText(MC(hotTopicBussinessData.mForumName));
        c0700a.lAC.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        am.setBackgroundResource(c0700a.mRootView, R.drawable.select_forum_item_bg);
        am.setViewTextColor(c0700a.lAD, (int) R.color.cp_cont_b);
        am.setBackgroundColor(c0700a.hji, R.color.cp_bg_line_e);
        return c0700a;
    }

    private C0700a dfV() {
        C0700a c0700a = new C0700a();
        c0700a.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.hot_topic_change_item, (ViewGroup) null);
        am.setBackgroundResource(c0700a.mRootView, R.drawable.select_forum_item_bg);
        am.setViewTextColor(c0700a.lAD, (int) R.color.cp_cont_b);
        c0700a.lAD = (TextView) c0700a.mRootView.findViewById(R.id.fourm_tv);
        c0700a.hji = c0700a.mRootView.findViewById(R.id.line_view);
        c0700a.lAC = (TbImageView) c0700a.mRootView.findViewById(R.id.icon_img);
        c0700a.lAC.setDefaultBgResource(R.color.cp_bg_line_e);
        c0700a.lAC.setDefaultResource(R.drawable.transparent_bg);
        c0700a.lAC.setDefaultErrorResource(R.drawable.icon_default_ba_120);
        c0700a.mRootView.setTag(c0700a);
        return c0700a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0700a {
        public View hji;
        public TbImageView lAC;
        public TextView lAD;
        public View mRootView;

        private C0700a() {
        }
    }
}
