package com.baidu.tieba.write.selectForum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private ViewGroup bHh = null;
    private HotTopicChangeFourmActivity hdM;
    private final Context mContext;
    private List<HotTopicBussinessData> mData;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.hdM = hotTopicChangeFourmActivity;
        this.mContext = this.hdM.getPageContext().getContext();
    }

    public void setData(List<HotTopicBussinessData> list) {
        this.mData = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.w(this.mData)) {
            return 0;
        }
        return this.mData.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uY */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String uM(String str) {
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
    public View getView(int i, View view2, ViewGroup viewGroup) {
        C0235a c0235a;
        if (this.bHh == null) {
            this.bHh = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0235a = a(view2 != null ? view2.getTag() : null, item);
        } else {
            c0235a = null;
        }
        if (c0235a != null) {
            return c0235a.mRootView;
        }
        return null;
    }

    private C0235a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0235a c0235a;
        if (obj == null) {
            c0235a = bCl();
        } else {
            c0235a = (C0235a) obj;
        }
        c0235a.hdO.setText(uM(hotTopicBussinessData.mForumName));
        c0235a.hdN.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        ak.i(c0235a.mRootView, d.f.select_forum_item_bg);
        ak.h(c0235a.hdO, d.C0126d.cp_cont_b);
        ak.j(c0235a.deT, d.C0126d.cp_bg_line_e);
        return c0235a;
    }

    private C0235a bCl() {
        C0235a c0235a = new C0235a();
        c0235a.mRootView = LayoutInflater.from(this.mContext).inflate(d.i.hot_topic_change_item, (ViewGroup) null);
        ak.i(c0235a.mRootView, d.f.select_forum_item_bg);
        ak.h(c0235a.hdO, d.C0126d.cp_cont_b);
        c0235a.hdO = (TextView) c0235a.mRootView.findViewById(d.g.fourm_tv);
        c0235a.deT = c0235a.mRootView.findViewById(d.g.line_view);
        c0235a.hdN = (TbImageView) c0235a.mRootView.findViewById(d.g.icon_img);
        c0235a.hdN.setDefaultBgResource(d.C0126d.cp_bg_line_e);
        c0235a.hdN.setDefaultResource(d.f.transparent_bg);
        c0235a.hdN.setDefaultErrorResource(d.f.icon_default_ba_120);
        c0235a.mRootView.setTag(c0235a);
        return c0235a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0235a {
        public View deT;
        public TbImageView hdN;
        public TextView hdO;
        public View mRootView;

        private C0235a() {
        }
    }
}
