package com.baidu.tieba.yuyinala.liveroom.tippop;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.tippop.AlaTopTipView;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes10.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a {
    private final List<AlaTopTipView> hKg;
    private com.baidu.live.liveroom.a.a hKi;
    private final AlaTopTipView.a osl;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.hKg = new LinkedList();
        this.osl = new AlaTopTipView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.tippop.a.1
            @Override // com.baidu.tieba.yuyinala.liveroom.tippop.AlaTopTipView.a
            public void cC(View view) {
                a.this.hKg.remove(view);
            }
        };
        this.hKi = aVar;
    }

    public void a(ViewGroup viewGroup, String str, int i, boolean z) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
            if (z) {
                alaTopTipView.setDuration(0);
            }
            alaTopTipView.setType(i);
            alaTopTipView.setText(str);
            alaTopTipView.setOnTipCompletedCallback(this.osl);
            alaTopTipView.v(viewGroup, 0);
            this.hKg.add(alaTopTipView);
        }
    }

    public void c(ViewGroup viewGroup, String str, int i) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            if (i != 1 || this.hKi == null || this.hKi.dz(9)) {
                AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
                alaTopTipView.setType(i);
                alaTopTipView.setText(str);
                alaTopTipView.setOnTipCompletedCallback(this.osl);
                alaTopTipView.v(viewGroup, 0);
                this.hKg.add(alaTopTipView);
            }
        }
    }

    public boolean vU(int i) {
        if (this.hKg.isEmpty()) {
            return false;
        }
        for (AlaTopTipView alaTopTipView : this.hKg) {
            if (alaTopTipView.getType() == i) {
                return true;
            }
        }
        return false;
    }

    public void vV(int i) {
        for (AlaTopTipView alaTopTipView : this.hKg) {
            if (alaTopTipView.getType() == i) {
                alaTopTipView.gE(true);
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void zH() {
        super.zH();
        for (AlaTopTipView alaTopTipView : this.hKg) {
            alaTopTipView.gE(false);
        }
        this.hKg.clear();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        for (AlaTopTipView alaTopTipView : this.hKg) {
            alaTopTipView.gE(false);
        }
        this.hKg.clear();
    }
}
