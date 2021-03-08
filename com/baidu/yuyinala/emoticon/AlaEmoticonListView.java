package com.baidu.yuyinala.emoticon;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.view.BaseViewPager;
import com.baidu.live.tbadk.core.view.BdGridView;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.tieba.pb.interactionpopupwindow.c;
import com.baidu.live.view.RoundRectPageIndicator;
import com.baidu.yuyinala.emoticon.adapter.AlaEmoticonPagerAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class AlaEmoticonListView extends com.baidu.live.tieba.pb.interactionpopupwindow.b<AlaEmoticonListDialogData> implements DialogInterface.OnDismissListener, AdapterView.OnItemClickListener, ViewPager.OnPageChangeListener {
    private static long oYE;
    private List<View> bcU;
    private CommonEmptyView byj;
    private c hzS;
    private RoundRectPageIndicator oYA;
    private View oYB;
    private AlaEmoticonListDialogData oYC;
    private List<List<com.baidu.yuyinala.emoticon.a.a>> oYD;
    private com.baidu.yuyinala.emoticon.a.a oYF;
    private a oYy;
    private BaseViewPager oYz;

    /* loaded from: classes10.dex */
    public interface a {
        void a(com.baidu.yuyinala.emoticon.a.a aVar);

        void loadData();
    }

    public AlaEmoticonListView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bcU = new ArrayList();
        this.oYD = new ArrayList();
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.g.activity_ala_audio_emoticon;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    /* renamed from: b */
    public void a(AlaEmoticonListDialogData alaEmoticonListDialogData) {
        a(alaEmoticonListDialogData, false);
    }

    public void a(AlaEmoticonListDialogData alaEmoticonListDialogData, boolean z) {
        this.oYC = alaEmoticonListDialogData;
        if (z) {
            if (this.oYC == null || ListUtils.isEmpty(alaEmoticonListDialogData.getEmoticonList())) {
                AG(alaEmoticonListDialogData.isNetError());
            } else {
                cx(alaEmoticonListDialogData.getEmoticonList());
            }
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.oYz = (BaseViewPager) getViewGroup().findViewById(a.f.emoticon_vp);
        this.oYA = (RoundRectPageIndicator) getViewGroup().findViewById(a.f.emoticon_indicator);
        this.oYB = getViewGroup().findViewById(a.f.emoticon_succ_view);
        this.byj = (CommonEmptyView) getViewGroup().findViewById(a.f.emoticon_empty_view);
        this.oYz.setOnPageChangeListener(this);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.oYA.onPageSelected(i);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    public void a(a aVar) {
        this.oYy = aVar;
    }

    public void a(c cVar) {
        this.hzS = cVar;
    }

    private void AG(boolean z) {
        this.byj.reset();
        this.byj.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.yuyinala.emoticon.AlaEmoticonListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaEmoticonListView.this.oYy != null) {
                    AlaEmoticonListView.this.oYy.loadData();
                    AlaEmoticonListView.this.byj.setVisibility(8);
                    AlaEmoticonListView.this.oYB.setVisibility(0);
                }
            }
        });
        this.byj.setTitle(z ? a.h.sdk_net_no : a.h.sdk_net_fail_tip_rank);
        this.byj.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        this.byj.setVisibility(0);
        this.oYB.setVisibility(8);
    }

    private BdGridView gs(List<com.baidu.yuyinala.emoticon.a.a> list) {
        com.baidu.yuyinala.emoticon.adapter.a aVar = new com.baidu.yuyinala.emoticon.adapter.a(getTbPageContext().getPageActivity());
        aVar.gt(list);
        BdGridView bdGridView = (BdGridView) LayoutInflater.from(getTbPageContext().getPageActivity()).inflate(a.g.view_emoticon_pager, (ViewGroup) null).findViewById(a.f.emoticon_gv);
        bdGridView.setAdapter((ListAdapter) aVar);
        bdGridView.setOnItemClickListener(this);
        return bdGridView;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.widget.Adapter] */
    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        long currentTimeMillis = System.currentTimeMillis();
        if (com.baidu.live.ao.a.Ym().iN(ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount())) && currentTimeMillis - oYE < this.oYC.getSendIntervalTime() * 1000) {
            this.mTbPageContext.showToast(a.h.send_emoticon_interval_time_tips);
            return;
        }
        com.baidu.yuyinala.emoticon.a.a aVar = (com.baidu.yuyinala.emoticon.a.a) adapterView.getAdapter().getItem(i);
        oYE = currentTimeMillis;
        this.oYF = aVar;
        if (this.oYy != null) {
            this.oYy.a(aVar);
        }
        if (this.hzS != null && this.hzS.isShowing()) {
            this.hzS.dismiss();
        }
    }

    private void cx(List<com.baidu.yuyinala.emoticon.a.a> list) {
        ArrayList arrayList;
        this.byj.setVisibility(8);
        this.oYB.setVisibility(0);
        this.bcU.clear();
        this.oYz.setAdapter(null);
        this.oYD.clear();
        int count = ListUtils.getCount(list);
        int ceil = (int) Math.ceil(count / 10.0d);
        int i = 0;
        int i2 = 0;
        while (i < ceil) {
            if (i == ceil - 1) {
                if (i * 10 == count - 1) {
                    arrayList = new ArrayList();
                    arrayList.add(list.get(count - 1));
                } else {
                    arrayList = new ArrayList(list.subList(i * 10, count));
                }
            } else {
                arrayList = new ArrayList();
                arrayList.addAll(list.subList(i * 10, (i + 1) * 10));
            }
            this.oYD.add(arrayList);
            this.bcU.add(gs(arrayList));
            int i3 = (this.oYF == null || !arrayList.contains(this.oYF)) ? i2 : i;
            i++;
            i2 = i3;
        }
        this.oYz.setAdapter(new AlaEmoticonPagerAdapter(this.bcU));
        this.oYA.setCount(ceil);
        this.oYz.setCurrentItem(i2);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        cx(null);
    }
}
