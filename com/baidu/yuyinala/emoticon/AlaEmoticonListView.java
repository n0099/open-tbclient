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
/* loaded from: classes11.dex */
public class AlaEmoticonListView extends com.baidu.live.tieba.pb.interactionpopupwindow.b<AlaEmoticonListDialogData> implements DialogInterface.OnDismissListener, AdapterView.OnItemClickListener, ViewPager.OnPageChangeListener {
    private static long oVZ;
    private List<View> bbu;
    private CommonEmptyView bwJ;
    private c hxV;
    private a oVT;
    private BaseViewPager oVU;
    private RoundRectPageIndicator oVV;
    private View oVW;
    private AlaEmoticonListDialogData oVX;
    private List<List<com.baidu.yuyinala.emoticon.a.a>> oVY;
    private com.baidu.yuyinala.emoticon.a.a oWa;

    /* loaded from: classes11.dex */
    public interface a {
        void a(com.baidu.yuyinala.emoticon.a.a aVar);

        void loadData();
    }

    public AlaEmoticonListView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bbu = new ArrayList();
        this.oVY = new ArrayList();
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
        this.oVX = alaEmoticonListDialogData;
        if (z) {
            if (this.oVX == null || ListUtils.isEmpty(alaEmoticonListDialogData.getEmoticonList())) {
                AH(alaEmoticonListDialogData.isNetError());
            } else {
                cx(alaEmoticonListDialogData.getEmoticonList());
            }
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.oVU = (BaseViewPager) getViewGroup().findViewById(a.f.emoticon_vp);
        this.oVV = (RoundRectPageIndicator) getViewGroup().findViewById(a.f.emoticon_indicator);
        this.oVW = getViewGroup().findViewById(a.f.emoticon_succ_view);
        this.bwJ = (CommonEmptyView) getViewGroup().findViewById(a.f.emoticon_empty_view);
        this.oVU.setOnPageChangeListener(this);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.oVV.onPageSelected(i);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    public void a(a aVar) {
        this.oVT = aVar;
    }

    public void a(c cVar) {
        this.hxV = cVar;
    }

    private void AH(boolean z) {
        this.bwJ.reset();
        this.bwJ.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.yuyinala.emoticon.AlaEmoticonListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaEmoticonListView.this.oVT != null) {
                    AlaEmoticonListView.this.oVT.loadData();
                    AlaEmoticonListView.this.bwJ.setVisibility(8);
                    AlaEmoticonListView.this.oVW.setVisibility(0);
                }
            }
        });
        this.bwJ.setTitle(z ? a.h.sdk_net_no : a.h.sdk_net_fail_tip_rank);
        this.bwJ.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        this.bwJ.setVisibility(0);
        this.oVW.setVisibility(8);
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
        if (com.baidu.live.ao.a.Yj().iH(ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount())) && currentTimeMillis - oVZ < this.oVX.getSendIntervalTime() * 1000) {
            this.mTbPageContext.showToast(a.h.send_emoticon_interval_time_tips);
            return;
        }
        com.baidu.yuyinala.emoticon.a.a aVar = (com.baidu.yuyinala.emoticon.a.a) adapterView.getAdapter().getItem(i);
        oVZ = currentTimeMillis;
        this.oWa = aVar;
        if (this.oVT != null) {
            this.oVT.a(aVar);
        }
        if (this.hxV != null && this.hxV.isShowing()) {
            this.hxV.dismiss();
        }
    }

    private void cx(List<com.baidu.yuyinala.emoticon.a.a> list) {
        ArrayList arrayList;
        this.bwJ.setVisibility(8);
        this.oVW.setVisibility(0);
        this.bbu.clear();
        this.oVU.setAdapter(null);
        this.oVY.clear();
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
            this.oVY.add(arrayList);
            this.bbu.add(gs(arrayList));
            int i3 = (this.oWa == null || !arrayList.contains(this.oWa)) ? i2 : i;
            i++;
            i2 = i3;
        }
        this.oVU.setAdapter(new AlaEmoticonPagerAdapter(this.bbu));
        this.oVV.setCount(ceil);
        this.oVU.setCurrentItem(i2);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        cx(null);
    }
}
