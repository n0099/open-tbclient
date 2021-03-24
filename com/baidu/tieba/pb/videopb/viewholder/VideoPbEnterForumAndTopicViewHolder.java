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
import d.b.b.e.p.k;
import d.b.h0.r.q.a2;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class VideoPbEnterForumAndTopicViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public Context f20108a;

    /* renamed from: b  reason: collision with root package name */
    public FlowLabelLayout f20109b;

    /* renamed from: c  reason: collision with root package name */
    public ThreadForumEnterButton f20110c;

    /* renamed from: d  reason: collision with root package name */
    public List<TopicEnterButton> f20111d;

    public VideoPbEnterForumAndTopicViewHolder(Context context, View view) {
        super(view);
        this.f20108a = context;
        this.f20109b = (FlowLabelLayout) ((ViewGroup) view).getChildAt(0);
    }

    public void b() {
        ThreadForumEnterButton threadForumEnterButton = this.f20110c;
        if (threadForumEnterButton != null) {
            threadForumEnterButton.d();
        }
        List<TopicEnterButton> list = this.f20111d;
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
        this.f20109b.removeAllViews();
        List<TopicEnterButton> list = this.f20111d;
        if (list != null) {
            list.clear();
        }
        if (!k.isEmpty(a2Var.i0())) {
            ThreadForumEnterButton threadForumEnterButton = new ThreadForumEnterButton(this.f20108a);
            this.f20110c = threadForumEnterButton;
            threadForumEnterButton.a(a2Var);
            this.f20109b.addView(this.f20110c, new ViewGroup.LayoutParams(-2, -2));
        }
        WorksInfoData worksInfoData = a2Var.E2;
        if (worksInfoData == null || ListUtils.isEmpty(worksInfoData.topicListData)) {
            return;
        }
        if (this.f20111d == null) {
            this.f20111d = new LinkedList();
        }
        for (RecommendTopicData.RecommendTopicListData recommendTopicListData : a2Var.E2.topicListData) {
            TopicEnterButton topicEnterButton = new TopicEnterButton(this.f20108a);
            topicEnterButton.f(recommendTopicListData);
            this.f20109b.addView(topicEnterButton, new ViewGroup.LayoutParams(-2, -2));
            this.f20111d.add(topicEnterButton);
        }
    }
}
