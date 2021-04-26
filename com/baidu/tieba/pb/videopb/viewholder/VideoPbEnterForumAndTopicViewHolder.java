package com.baidu.tieba.pb.videopb.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.data.RecommendTopicData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tbadk.core.view.TopicEnterButton;
import com.baidu.tbadk.widget.layout.FlowLabelLayout;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import d.a.c.e.p.k;
import d.a.i0.r.q.a2;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class VideoPbEnterForumAndTopicViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public Context f20295a;

    /* renamed from: b  reason: collision with root package name */
    public FlowLabelLayout f20296b;

    /* renamed from: c  reason: collision with root package name */
    public ThreadForumEnterButton f20297c;

    /* renamed from: d  reason: collision with root package name */
    public List<TopicEnterButton> f20298d;

    public VideoPbEnterForumAndTopicViewHolder(Context context, View view) {
        super(view);
        this.f20295a = context;
        this.f20296b = (FlowLabelLayout) ((ViewGroup) view).getChildAt(0);
    }

    public void b() {
        ThreadForumEnterButton threadForumEnterButton = this.f20297c;
        if (threadForumEnterButton != null) {
            threadForumEnterButton.d();
        }
        List<TopicEnterButton> list = this.f20298d;
        if (list != null) {
            for (TopicEnterButton topicEnterButton : list) {
                topicEnterButton.a();
            }
        }
    }

    public void setData(a2 a2Var) {
        if (a2Var == null) {
            return;
        }
        this.f20296b.removeAllViews();
        List<TopicEnterButton> list = this.f20298d;
        if (list != null) {
            list.clear();
        }
        if (!k.isEmpty(a2Var.i0())) {
            ThreadForumEnterButton threadForumEnterButton = new ThreadForumEnterButton(this.f20295a);
            this.f20297c = threadForumEnterButton;
            threadForumEnterButton.a(a2Var);
            this.f20296b.addView(this.f20297c, new ViewGroup.LayoutParams(-2, -2));
        }
        WorksInfoData worksInfoData = a2Var.E2;
        if (worksInfoData == null || ListUtils.isEmpty(worksInfoData.topicListData)) {
            return;
        }
        if (this.f20298d == null) {
            this.f20298d = new LinkedList();
        }
        for (RecommendTopicData.RecommendTopicListData recommendTopicListData : a2Var.E2.topicListData) {
            TopicEnterButton topicEnterButton = new TopicEnterButton(this.f20295a);
            topicEnterButton.f(recommendTopicListData);
            this.f20296b.addView(topicEnterButton, new ViewGroup.LayoutParams(-2, -2));
            this.f20298d.add(topicEnterButton);
        }
    }
}
