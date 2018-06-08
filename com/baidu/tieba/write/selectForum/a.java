package com.baidu.tieba.write.selectForum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private HotTopicChangeFourmActivity hqI;
    private final Context mContext;
    private List<HotTopicBussinessData> mData;
    private ViewGroup mParent = null;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.hqI = hotTopicChangeFourmActivity;
        this.mContext = this.hqI.getPageContext().getContext();
    }

    public void setData(List<HotTopicBussinessData> list) {
        this.mData = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (w.z(this.mData)) {
            return 0;
        }
        return this.mData.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vp */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String vJ(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (str.length() > 14) {
            return str.substring(0, 13) + "...";
        }
        return str;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0252a c0252a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0252a = a(view != null ? view.getTag() : null, item);
        } else {
            c0252a = null;
        }
        if (c0252a != null) {
            return c0252a.mRootView;
        }
        return null;
    }

    private C0252a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0252a c0252a;
        if (obj == null) {
            c0252a = bHo();
        } else {
            c0252a = (C0252a) obj;
        }
        c0252a.hqK.setText(vJ(hotTopicBussinessData.mForumName));
        c0252a.hqJ.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        al.i(c0252a.mRootView, d.f.select_forum_item_bg);
        al.h(c0252a.hqK, d.C0141d.cp_cont_b);
        al.j(c0252a.dpm, d.C0141d.cp_bg_line_e);
        return c0252a;
    }

    private C0252a bHo() {
        C0252a c0252a = new C0252a();
        c0252a.mRootView = LayoutInflater.from(this.mContext).inflate(d.i.hot_topic_change_item, (ViewGroup) null);
        al.i(c0252a.mRootView, d.f.select_forum_item_bg);
        al.h(c0252a.hqK, d.C0141d.cp_cont_b);
        c0252a.hqK = (TextView) c0252a.mRootView.findViewById(d.g.fourm_tv);
        c0252a.dpm = c0252a.mRootView.findViewById(d.g.line_view);
        c0252a.hqJ = (TbImageView) c0252a.mRootView.findViewById(d.g.icon_img);
        c0252a.hqJ.setDefaultBgResource(d.C0141d.cp_bg_line_e);
        c0252a.hqJ.setDefaultResource(d.f.transparent_bg);
        c0252a.hqJ.setDefaultErrorResource(d.f.icon_default_ba_120);
        c0252a.mRootView.setTag(c0252a);
        return c0252a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0252a {
        public View dpm;
        public TbImageView hqJ;
        public TextView hqK;
        public View mRootView;

        private C0252a() {
        }
    }
}
