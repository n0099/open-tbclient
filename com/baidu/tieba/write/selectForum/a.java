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
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private HotTopicChangeFourmActivity jPL;
    private final Context mContext;
    private List<HotTopicBussinessData> mData;
    private ViewGroup mParent = null;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.jPL = hotTopicChangeFourmActivity;
        this.mContext = this.jPL.getPageContext().getContext();
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
    /* renamed from: BC */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String FD(String str) {
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
        C0535a c0535a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0535a = a(view != null ? view.getTag() : null, item);
        } else {
            c0535a = null;
        }
        if (c0535a != null) {
            return c0535a.mRootView;
        }
        return null;
    }

    private C0535a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0535a c0535a;
        if (obj == null) {
            c0535a = cyy();
        } else {
            c0535a = (C0535a) obj;
        }
        c0535a.jPN.setText(FD(hotTopicBussinessData.mForumName));
        c0535a.jPM.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        am.setBackgroundResource(c0535a.mRootView, R.drawable.select_forum_item_bg);
        am.setViewTextColor(c0535a.jPN, (int) R.color.cp_cont_b);
        am.setBackgroundColor(c0535a.fER, R.color.cp_bg_line_e);
        return c0535a;
    }

    private C0535a cyy() {
        C0535a c0535a = new C0535a();
        c0535a.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.hot_topic_change_item, (ViewGroup) null);
        am.setBackgroundResource(c0535a.mRootView, R.drawable.select_forum_item_bg);
        am.setViewTextColor(c0535a.jPN, (int) R.color.cp_cont_b);
        c0535a.jPN = (TextView) c0535a.mRootView.findViewById(R.id.fourm_tv);
        c0535a.fER = c0535a.mRootView.findViewById(R.id.line_view);
        c0535a.jPM = (TbImageView) c0535a.mRootView.findViewById(R.id.icon_img);
        c0535a.jPM.setDefaultBgResource(R.color.cp_bg_line_e);
        c0535a.jPM.setDefaultResource(R.drawable.transparent_bg);
        c0535a.jPM.setDefaultErrorResource(R.drawable.icon_default_ba_120);
        c0535a.mRootView.setTag(c0535a);
        return c0535a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0535a {
        public View fER;
        public TbImageView jPM;
        public TextView jPN;
        public View mRootView;

        private C0535a() {
        }
    }
}
