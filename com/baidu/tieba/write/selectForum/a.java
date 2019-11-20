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
        C0540a c0540a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0540a = a(view != null ? view.getTag() : null, item);
        } else {
            c0540a = null;
        }
        if (c0540a != null) {
            return c0540a.mRootView;
        }
        return null;
    }

    private C0540a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0540a c0540a;
        if (obj == null) {
            c0540a = cyy();
        } else {
            c0540a = (C0540a) obj;
        }
        c0540a.jPN.setText(FD(hotTopicBussinessData.mForumName));
        c0540a.jPM.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        am.setBackgroundResource(c0540a.mRootView, R.drawable.select_forum_item_bg);
        am.setViewTextColor(c0540a.jPN, (int) R.color.cp_cont_b);
        am.setBackgroundColor(c0540a.fER, R.color.cp_bg_line_e);
        return c0540a;
    }

    private C0540a cyy() {
        C0540a c0540a = new C0540a();
        c0540a.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.hot_topic_change_item, (ViewGroup) null);
        am.setBackgroundResource(c0540a.mRootView, R.drawable.select_forum_item_bg);
        am.setViewTextColor(c0540a.jPN, (int) R.color.cp_cont_b);
        c0540a.jPN = (TextView) c0540a.mRootView.findViewById(R.id.fourm_tv);
        c0540a.fER = c0540a.mRootView.findViewById(R.id.line_view);
        c0540a.jPM = (TbImageView) c0540a.mRootView.findViewById(R.id.icon_img);
        c0540a.jPM.setDefaultBgResource(R.color.cp_bg_line_e);
        c0540a.jPM.setDefaultResource(R.drawable.transparent_bg);
        c0540a.jPM.setDefaultErrorResource(R.drawable.icon_default_ba_120);
        c0540a.mRootView.setTag(c0540a);
        return c0540a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0540a {
        public View fER;
        public TbImageView jPM;
        public TextView jPN;
        public View mRootView;

        private C0540a() {
        }
    }
}
