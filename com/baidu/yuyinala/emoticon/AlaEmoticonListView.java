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
    private List<View> bbt;
    private CommonEmptyView btg;
    private c hmw;
    private a oKc;
    private BaseViewPager oKd;
    private RoundRectPageIndicator oKe;
    private View oKf;
    private AlaEmoticonListDialogData oKg;
    private List<List<com.baidu.yuyinala.emoticon.a.a>> oKh;
    private long oKi;
    private com.baidu.yuyinala.emoticon.a.a oKj;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.yuyinala.emoticon.a.a aVar);

        void loadData();
    }

    public AlaEmoticonListView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bbt = new ArrayList();
        this.oKh = new ArrayList();
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
        this.oKg = alaEmoticonListDialogData;
        if (z) {
            if (this.oKg == null || ListUtils.isEmpty(alaEmoticonListDialogData.getEmoticonList())) {
                Ar(alaEmoticonListDialogData.isNetError());
            } else {
                cv(alaEmoticonListDialogData.getEmoticonList());
            }
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.oKd = (BaseViewPager) getViewGroup().findViewById(a.f.emoticon_vp);
        this.oKe = (RoundRectPageIndicator) getViewGroup().findViewById(a.f.emoticon_indicator);
        this.oKf = getViewGroup().findViewById(a.f.emoticon_succ_view);
        this.btg = (CommonEmptyView) getViewGroup().findViewById(a.f.emoticon_empty_view);
        this.oKd.setOnPageChangeListener(this);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.oKe.onPageSelected(i);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    public void a(a aVar) {
        this.oKc = aVar;
    }

    public void a(c cVar) {
        this.hmw = cVar;
    }

    private void Ar(boolean z) {
        this.btg.reset();
        this.btg.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.yuyinala.emoticon.AlaEmoticonListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaEmoticonListView.this.oKc != null) {
                    AlaEmoticonListView.this.oKc.loadData();
                    AlaEmoticonListView.this.btg.setVisibility(8);
                    AlaEmoticonListView.this.oKf.setVisibility(0);
                }
            }
        });
        this.btg.setTitle(z ? a.h.sdk_net_no : a.h.sdk_net_fail_tip_rank);
        this.btg.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        this.btg.setVisibility(0);
        this.oKf.setVisibility(8);
    }

    private BdGridView gC(List<com.baidu.yuyinala.emoticon.a.a> list) {
        com.baidu.yuyinala.emoticon.adapter.a aVar = new com.baidu.yuyinala.emoticon.adapter.a(getTbPageContext().getPageActivity());
        aVar.gD(list);
        BdGridView bdGridView = (BdGridView) LayoutInflater.from(getTbPageContext().getPageActivity()).inflate(a.g.view_emoticon_pager, (ViewGroup) null).findViewById(a.f.emoticon_gv);
        bdGridView.setAdapter((ListAdapter) aVar);
        bdGridView.setOnItemClickListener(this);
        return bdGridView;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.widget.Adapter] */
    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        long currentTimeMillis = System.currentTimeMillis();
        if (com.baidu.live.ap.b.YX().jt(ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount())) && currentTimeMillis - this.oKi < this.oKg.getSendIntervalTime() * 1000) {
            this.mTbPageContext.showToast(a.h.send_emoticon_interval_time_tips);
            return;
        }
        com.baidu.yuyinala.emoticon.a.a aVar = (com.baidu.yuyinala.emoticon.a.a) adapterView.getAdapter().getItem(i);
        this.oKi = currentTimeMillis;
        this.oKj = aVar;
        if (this.oKc != null) {
            this.oKc.a(aVar);
        }
        if (this.hmw != null && this.hmw.isShowing()) {
            this.hmw.dismiss();
        }
    }

    private void cv(List<com.baidu.yuyinala.emoticon.a.a> list) {
        ArrayList arrayList;
        int i = 0;
        this.btg.setVisibility(8);
        this.oKf.setVisibility(0);
        this.bbt.clear();
        this.oKd.setAdapter(null);
        this.oKh.clear();
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
            this.oKh.add(arrayList);
            this.bbt.add(gC(arrayList));
            int i3 = (this.oKj == null || !arrayList.contains(this.oKj)) ? i2 : i;
            i++;
            i2 = i3;
        }
        this.oKd.setAdapter(new AlaEmoticonPagerAdapter(this.bbt));
        this.oKe.setCount(ceil);
        this.oKd.setCurrentItem(i2);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        cv(null);
    }
}
