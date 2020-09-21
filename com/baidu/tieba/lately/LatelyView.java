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
    private LinearLayoutManager WN;
    private g fQf;
    private b hiP;
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
        this.hiP = new b(this);
        this.hiP.setType(1);
        this.WN = new LinearLayoutManager(getContext());
        this.mRecyclerView.setLayoutManager(this.WN);
        this.mRecyclerView.setAdapter(this.hiP);
    }

    @Override // com.baidu.tieba.d
    public String getTitle() {
        return getContext().getString(R.string.activity_select_forum_tab_recently);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.d
    /* renamed from: request */
    public void aw(String str) {
        RecentlyVisitedForumData cix = a.cis().cix();
        if (cix == null) {
            R(false, false);
            return;
        }
        LinkedList<VisitedForumData> forumData = cix.getForumData();
        if (y.isEmpty(forumData)) {
            R(false, false);
            return;
        }
        bHn();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<VisitedForumData> it = forumData.iterator();
        while (it.hasNext()) {
            VisitedForumData next = it.next();
            if (next != null) {
                i iVar = new i();
                iVar.forumId = next.getForumId();
                iVar.baJ = next.brX();
                iVar.forumName = next.getForumName();
                iVar.level = next.getLevel();
                iVar.eLM = next.bsd();
                iVar.eLN = next.bse();
                iVar.eLO = next.bsf();
                iVar.tabInfoList = next.bsg();
                iVar.eLP = next.bsh();
                if (iVar.eLM) {
                    arrayList2.add(iVar);
                } else {
                    arrayList.add(iVar);
                }
            }
        }
        arrayList2.addAll(arrayList);
        this.hiP.aO(arrayList2);
        this.hiP.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.d
    public void Dy(String str) {
    }

    public void R(boolean z, boolean z2) {
        if (!cdF()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.lately.LatelyView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            LatelyView.this.aw(null);
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(getResources().getDimensionPixelSize(R.dimen.tbds380));
            this.mRefreshView.attachView(this, z);
            if (z2) {
                this.mRefreshView.showRefreshButton();
            } else {
                this.mRefreshView.qL(R.drawable.new_pic_emotion_01);
                this.mRefreshView.hideRefreshButton();
            }
            this.mRefreshView.CK(getContext().getString(R.string.activity_select_forum_recently_empty));
            this.mRecyclerView.setVisibility(8);
        }
    }

    public void bHn() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.mRecyclerView.setVisibility(0);
    }

    public boolean cdF() {
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
            if (this.fQf != null) {
                this.fQf.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            this.hiP.notifyDataSetChanged();
        }
    }
}
