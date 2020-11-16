package com.baidu.tieba.lately;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.data.i;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import com.baidu.tieba.b.b;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.c.a;
import com.baidu.tieba.enterForum.data.RecentlyVisitedForumData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes21.dex */
public class LatelyView extends FrameLayout implements d<String> {
    private LinearLayoutManager Xj;
    private g grV;
    private b hQD;
    private RecyclerView mRecyclerView;
    private h mRefreshView;
    private int mSkinType;

    public LatelyView(Context context) {
        this(context, null);
    }

    public LatelyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LatelyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.select_forum_lately_layout, (ViewGroup) this, true);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.select_forum_list);
        this.hQD = new b(this);
        this.hQD.setType(1);
        this.Xj = new LinearLayoutManager(getContext());
        this.mRecyclerView.setLayoutManager(this.Xj);
        this.mRecyclerView.setAdapter(this.hQD);
    }

    @Override // com.baidu.tieba.d
    public String getTitle() {
        return getContext().getString(R.string.activity_select_forum_tab_recently);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.d
    /* renamed from: request */
    public void az(String str) {
        RecentlyVisitedForumData cre = a.cqZ().cre();
        if (cre == null) {
            U(false, false);
            return;
        }
        LinkedList<VisitedForumData> forumData = cre.getForumData();
        if (y.isEmpty(forumData)) {
            U(false, false);
            return;
        }
        VB();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<VisitedForumData> it = forumData.iterator();
        while (it.hasNext()) {
            VisitedForumData next = it.next();
            if (next != null) {
                i iVar = new i();
                iVar.forumId = next.getForumId();
                iVar.bfc = next.byp();
                iVar.forumName = next.getForumName();
                iVar.level = next.getLevel();
                iVar.flq = next.byv();
                iVar.flr = next.byw();
                iVar.fls = next.byx();
                iVar.tabInfoList = next.byy();
                iVar.flt = next.byz();
                if (iVar.flq) {
                    arrayList2.add(iVar);
                } else {
                    arrayList.add(iVar);
                }
            }
        }
        arrayList2.addAll(arrayList);
        this.hQD.bi(arrayList2);
        this.hQD.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.d
    public void Er(String str) {
    }

    public void U(boolean z, boolean z2) {
        if (!cmm()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.lately.LatelyView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            LatelyView.this.az(null);
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(getResources().getDimensionPixelSize(R.dimen.tbds380));
            this.mRefreshView.attachView(this, z);
            if (z2) {
                this.mRefreshView.showRefreshButton();
            } else {
                this.mRefreshView.sc(R.drawable.new_pic_emotion_01);
                this.mRefreshView.hideRefreshButton();
            }
            this.mRefreshView.DC(getContext().getString(R.string.activity_select_forum_empty));
            this.mRecyclerView.setVisibility(8);
        }
    }

    public void VB() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.mRecyclerView.setVisibility(0);
    }

    public boolean cmm() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    @Override // com.baidu.tieba.d
    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.grV != null) {
                this.grV.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            this.hQD.notifyDataSetChanged();
        }
    }
}
