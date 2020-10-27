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
    private List<View> aYs;
    private CommonEmptyView boq;
    private c gXb;
    private a okl;
    private BaseViewPager okm;
    private RoundRectPageIndicator okn;
    private View oko;
    private AlaEmoticonListDialogData okp;
    private List<List<com.baidu.yuyinala.emoticon.a.a>> okq;
    private long okr;
    private com.baidu.yuyinala.emoticon.a.a oks;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.yuyinala.emoticon.a.a aVar);

        void loadData();
    }

    public AlaEmoticonListView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aYs = new ArrayList();
        this.okq = new ArrayList();
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.h.activity_ala_audio_emoticon;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    /* renamed from: b */
    public void a(AlaEmoticonListDialogData alaEmoticonListDialogData) {
        a(alaEmoticonListDialogData, false);
    }

    public void a(AlaEmoticonListDialogData alaEmoticonListDialogData, boolean z) {
        this.okp = alaEmoticonListDialogData;
        if (z) {
            if (this.okp == null || ListUtils.isEmpty(alaEmoticonListDialogData.getEmoticonList())) {
                zv(alaEmoticonListDialogData.isNetError());
            } else {
                ck(alaEmoticonListDialogData.getEmoticonList());
            }
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.okm = (BaseViewPager) getViewGroup().findViewById(a.g.emoticon_vp);
        this.okn = (RoundRectPageIndicator) getViewGroup().findViewById(a.g.emoticon_indicator);
        this.oko = getViewGroup().findViewById(a.g.emoticon_succ_view);
        this.boq = (CommonEmptyView) getViewGroup().findViewById(a.g.emoticon_empty_view);
        this.okm.setOnPageChangeListener(this);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.okn.onPageSelected(i);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    public void a(a aVar) {
        this.okl = aVar;
    }

    public void a(c cVar) {
        this.gXb = cVar;
    }

    private void zv(boolean z) {
        this.boq.reset();
        this.boq.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.yuyinala.emoticon.AlaEmoticonListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaEmoticonListView.this.okl != null) {
                    AlaEmoticonListView.this.okl.loadData();
                    AlaEmoticonListView.this.boq.setVisibility(8);
                    AlaEmoticonListView.this.oko.setVisibility(0);
                }
            }
        });
        this.boq.setTitle(z ? a.i.sdk_net_no : a.i.sdk_net_fail_tip_rank);
        this.boq.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        this.boq.setVisibility(0);
        this.oko.setVisibility(8);
    }

    private BdGridView ge(List<com.baidu.yuyinala.emoticon.a.a> list) {
        com.baidu.yuyinala.emoticon.adapter.a aVar = new com.baidu.yuyinala.emoticon.adapter.a(getTbPageContext().getPageActivity());
        aVar.gf(list);
        BdGridView bdGridView = (BdGridView) LayoutInflater.from(getTbPageContext().getPageActivity()).inflate(a.h.view_emoticon_pager, (ViewGroup) null).findViewById(a.g.emoticon_gv);
        bdGridView.setAdapter((ListAdapter) aVar);
        bdGridView.setOnItemClickListener(this);
        return bdGridView;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.widget.Adapter] */
    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        long currentTimeMillis = System.currentTimeMillis();
        if (com.baidu.live.aj.b.UH().iI(ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount())) && currentTimeMillis - this.okr < this.okp.getSendIntervalTime() * 1000) {
            this.mTbPageContext.showToast(a.i.send_emoticon_interval_time_tips);
            return;
        }
        com.baidu.yuyinala.emoticon.a.a aVar = (com.baidu.yuyinala.emoticon.a.a) adapterView.getAdapter().getItem(i);
        this.okr = currentTimeMillis;
        this.oks = aVar;
        if (this.okl != null) {
            this.okl.a(aVar);
        }
        if (this.gXb != null && this.gXb.isShowing()) {
            this.gXb.dismiss();
        }
    }

    private void ck(List<com.baidu.yuyinala.emoticon.a.a> list) {
        ArrayList arrayList;
        int i = 0;
        this.boq.setVisibility(8);
        this.oko.setVisibility(0);
        this.aYs.clear();
        this.okm.setAdapter(null);
        this.okq.clear();
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
            this.okq.add(arrayList);
            this.aYs.add(ge(arrayList));
            int i3 = (this.oks == null || !arrayList.contains(this.oks)) ? i2 : i;
            i++;
            i2 = i3;
        }
        this.okm.setAdapter(new AlaEmoticonPagerAdapter(this.aYs));
        this.okn.setCount(ceil);
        this.okm.setCurrentItem(i2);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        ck(null);
    }
}
