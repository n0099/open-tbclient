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
    private List<View> bdb;
    private CommonEmptyView bxT;
    private c hyr;
    private a oQo;
    private BaseViewPager oQp;
    private RoundRectPageIndicator oQq;
    private View oQr;
    private AlaEmoticonListDialogData oQs;
    private List<List<com.baidu.yuyinala.emoticon.a.a>> oQt;
    private long oQu;
    private com.baidu.yuyinala.emoticon.a.a oQv;

    /* loaded from: classes11.dex */
    public interface a {
        void a(com.baidu.yuyinala.emoticon.a.a aVar);

        void loadData();
    }

    public AlaEmoticonListView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bdb = new ArrayList();
        this.oQt = new ArrayList();
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
        this.oQs = alaEmoticonListDialogData;
        if (z) {
            if (this.oQs == null || ListUtils.isEmpty(alaEmoticonListDialogData.getEmoticonList())) {
                As(alaEmoticonListDialogData.isNetError());
            } else {
                cC(alaEmoticonListDialogData.getEmoticonList());
            }
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.oQp = (BaseViewPager) getViewGroup().findViewById(a.f.emoticon_vp);
        this.oQq = (RoundRectPageIndicator) getViewGroup().findViewById(a.f.emoticon_indicator);
        this.oQr = getViewGroup().findViewById(a.f.emoticon_succ_view);
        this.bxT = (CommonEmptyView) getViewGroup().findViewById(a.f.emoticon_empty_view);
        this.oQp.setOnPageChangeListener(this);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.oQq.onPageSelected(i);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    public void a(a aVar) {
        this.oQo = aVar;
    }

    public void a(c cVar) {
        this.hyr = cVar;
    }

    private void As(boolean z) {
        this.bxT.reset();
        this.bxT.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.yuyinala.emoticon.AlaEmoticonListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaEmoticonListView.this.oQo != null) {
                    AlaEmoticonListView.this.oQo.loadData();
                    AlaEmoticonListView.this.bxT.setVisibility(8);
                    AlaEmoticonListView.this.oQr.setVisibility(0);
                }
            }
        });
        this.bxT.setTitle(z ? a.h.sdk_net_no : a.h.sdk_net_fail_tip_rank);
        this.bxT.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        this.bxT.setVisibility(0);
        this.oQr.setVisibility(8);
    }

    private BdGridView gu(List<com.baidu.yuyinala.emoticon.a.a> list) {
        com.baidu.yuyinala.emoticon.adapter.a aVar = new com.baidu.yuyinala.emoticon.adapter.a(getTbPageContext().getPageActivity());
        aVar.gv(list);
        BdGridView bdGridView = (BdGridView) LayoutInflater.from(getTbPageContext().getPageActivity()).inflate(a.g.view_emoticon_pager, (ViewGroup) null).findViewById(a.f.emoticon_gv);
        bdGridView.setAdapter((ListAdapter) aVar);
        bdGridView.setOnItemClickListener(this);
        return bdGridView;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.widget.Adapter] */
    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        long currentTimeMillis = System.currentTimeMillis();
        if (com.baidu.live.aq.a.aan().jm(ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount())) && currentTimeMillis - this.oQu < this.oQs.getSendIntervalTime() * 1000) {
            this.mTbPageContext.showToast(a.h.send_emoticon_interval_time_tips);
            return;
        }
        com.baidu.yuyinala.emoticon.a.a aVar = (com.baidu.yuyinala.emoticon.a.a) adapterView.getAdapter().getItem(i);
        this.oQu = currentTimeMillis;
        this.oQv = aVar;
        if (this.oQo != null) {
            this.oQo.a(aVar);
        }
        if (this.hyr != null && this.hyr.isShowing()) {
            this.hyr.dismiss();
        }
    }

    private void cC(List<com.baidu.yuyinala.emoticon.a.a> list) {
        ArrayList arrayList;
        this.bxT.setVisibility(8);
        this.oQr.setVisibility(0);
        this.bdb.clear();
        this.oQp.setAdapter(null);
        this.oQt.clear();
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
            this.oQt.add(arrayList);
            this.bdb.add(gu(arrayList));
            int i3 = (this.oQv == null || !arrayList.contains(this.oQv)) ? i2 : i;
            i++;
            i2 = i3;
        }
        this.oQp.setAdapter(new AlaEmoticonPagerAdapter(this.bdb));
        this.oQq.setCount(ceil);
        this.oQp.setCurrentItem(i2);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        cC(null);
    }
}
