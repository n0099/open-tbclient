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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private final Context mContext;
    private List<HotTopicBussinessData> mData;
    private ViewGroup mParent = null;
    private HotTopicChangeFourmActivity mpu;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.mpu = hotTopicChangeFourmActivity;
        this.mContext = this.mpu.getPageContext().getContext();
    }

    public void setData(List<HotTopicBussinessData> list) {
        this.mData = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (w.isEmpty(this.mData)) {
            return 0;
        }
        return this.mData.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: GL */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String OX(String str) {
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
        C0770a c0770a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0770a = a(view != null ? view.getTag() : null, item);
        } else {
            c0770a = null;
        }
        if (c0770a != null) {
            return c0770a.mRootView;
        }
        return null;
    }

    private C0770a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0770a c0770a;
        if (obj == null) {
            c0770a = drO();
        } else {
            c0770a = (C0770a) obj;
        }
        c0770a.mpw.setText(OX(hotTopicBussinessData.mForumName));
        c0770a.mpv.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        an.setBackgroundResource(c0770a.mRootView, R.drawable.select_forum_item_bg);
        an.setViewTextColor(c0770a.mpw, (int) R.color.cp_cont_b);
        an.setBackgroundColor(c0770a.hLe, R.color.cp_bg_line_e);
        return c0770a;
    }

    private C0770a drO() {
        C0770a c0770a = new C0770a();
        c0770a.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.hot_topic_change_item, (ViewGroup) null);
        an.setBackgroundResource(c0770a.mRootView, R.drawable.select_forum_item_bg);
        an.setViewTextColor(c0770a.mpw, (int) R.color.cp_cont_b);
        c0770a.mpw = (TextView) c0770a.mRootView.findViewById(R.id.fourm_tv);
        c0770a.hLe = c0770a.mRootView.findViewById(R.id.line_view);
        c0770a.mpv = (TbImageView) c0770a.mRootView.findViewById(R.id.icon_img);
        c0770a.mpv.setDefaultBgResource(R.color.cp_bg_line_e);
        c0770a.mpv.setDefaultResource(R.drawable.transparent_bg);
        c0770a.mpv.setDefaultErrorResource(R.drawable.icon_default_ba_120);
        c0770a.mRootView.setTag(c0770a);
        return c0770a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0770a {
        public View hLe;
        public View mRootView;
        public TbImageView mpv;
        public TextView mpw;

        private C0770a() {
        }
    }
}
