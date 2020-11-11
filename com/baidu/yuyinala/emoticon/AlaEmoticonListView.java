package com.baidu.yuyinala.emoticon;

import android.content.DialogInterface;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
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
/* loaded from: classes4.dex */
public class AlaEmoticonListView extends com.baidu.live.tieba.pb.interactionpopupwindow.b<AlaEmoticonListDialogData> implements DialogInterface.OnDismissListener, ViewPager.OnPageChangeListener, AdapterView.OnItemClickListener {
    private List<View> aZK;
    private CommonEmptyView bpJ;
    private c hdf;
    private a otq;
    private BaseViewPager otr;
    private RoundRectPageIndicator ots;
    private View ott;
    private AlaEmoticonListDialogData otu;
    private List<List<com.baidu.yuyinala.emoticon.a.a>> otv;
    private long otw;
    private com.baidu.yuyinala.emoticon.a.a otx;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.yuyinala.emoticon.a.a aVar);

        void loadData();
    }

    public AlaEmoticonListView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aZK = new ArrayList();
        this.otv = new ArrayList();
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
        this.otu = alaEmoticonListDialogData;
        if (z) {
            if (this.otu == null || ListUtils.isEmpty(alaEmoticonListDialogData.getEmoticonList())) {
                zG(alaEmoticonListDialogData.isNetError());
            } else {
                cr(alaEmoticonListDialogData.getEmoticonList());
            }
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.otr = (BaseViewPager) getViewGroup().findViewById(a.f.emoticon_vp);
        this.ots = (RoundRectPageIndicator) getViewGroup().findViewById(a.f.emoticon_indicator);
        this.ott = getViewGroup().findViewById(a.f.emoticon_succ_view);
        this.bpJ = (CommonEmptyView) getViewGroup().findViewById(a.f.emoticon_empty_view);
        this.otr.setOnPageChangeListener(this);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.ots.onPageSelected(i);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    public void a(a aVar) {
        this.otq = aVar;
    }

    public void a(c cVar) {
        this.hdf = cVar;
    }

    private void zG(boolean z) {
        this.bpJ.reset();
        this.bpJ.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.yuyinala.emoticon.AlaEmoticonListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaEmoticonListView.this.otq != null) {
                    AlaEmoticonListView.this.otq.loadData();
                    AlaEmoticonListView.this.bpJ.setVisibility(8);
                    AlaEmoticonListView.this.ott.setVisibility(0);
                }
            }
        });
        this.bpJ.setTitle(z ? a.h.sdk_net_no : a.h.sdk_net_fail_tip_rank);
        this.bpJ.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        this.bpJ.setVisibility(0);
        this.ott.setVisibility(8);
    }

    private BdGridView gn(List<com.baidu.yuyinala.emoticon.a.a> list) {
        com.baidu.yuyinala.emoticon.adapter.a aVar = new com.baidu.yuyinala.emoticon.adapter.a(getTbPageContext().getPageActivity());
        aVar.go(list);
        BdGridView bdGridView = (BdGridView) LayoutInflater.from(getTbPageContext().getPageActivity()).inflate(a.g.view_emoticon_pager, (ViewGroup) null).findViewById(a.f.emoticon_gv);
        bdGridView.setAdapter((ListAdapter) aVar);
        bdGridView.setOnItemClickListener(this);
        return bdGridView;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.widget.Adapter] */
    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        long currentTimeMillis = System.currentTimeMillis();
        if (com.baidu.live.al.b.Xh().iV(ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount())) && currentTimeMillis - this.otw < this.otu.getSendIntervalTime() * 1000) {
            this.mTbPageContext.showToast(a.h.send_emoticon_interval_time_tips);
            return;
        }
        com.baidu.yuyinala.emoticon.a.a aVar = (com.baidu.yuyinala.emoticon.a.a) adapterView.getAdapter().getItem(i);
        this.otw = currentTimeMillis;
        this.otx = aVar;
        if (this.otq != null) {
            this.otq.a(aVar);
        }
        if (this.hdf != null && this.hdf.isShowing()) {
            this.hdf.dismiss();
        }
    }

    private void cr(List<com.baidu.yuyinala.emoticon.a.a> list) {
        ArrayList arrayList;
        int i = 0;
        this.bpJ.setVisibility(8);
        this.ott.setVisibility(0);
        this.aZK.clear();
        this.otr.setAdapter(null);
        this.otv.clear();
        int count = ListUtils.getCount(list);
        int ceil = (int) Math.ceil(count / 10.0d);
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
            this.otv.add(arrayList);
            this.aZK.add(gn(arrayList));
            int i3 = (this.otx == null || !arrayList.contains(this.otx)) ? i2 : i;
            i++;
            i2 = i3;
        }
        this.otr.setAdapter(new AlaEmoticonPagerAdapter(this.aZK));
        this.ots.setCount(ceil);
        this.otr.setCurrentItem(i2);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        cr(null);
    }
}
