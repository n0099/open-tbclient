package com.baidu.tieba.yuyinala.liveroom.tippop;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.tippop.AlaTopTipView;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a {
    private final List<AlaTopTipView> hnB;
    private com.baidu.live.liveroom.a.a hnD;
    private final AlaTopTipView.a nSW;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.hnB = new LinkedList();
        this.nSW = new AlaTopTipView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.tippop.a.1
            @Override // com.baidu.tieba.yuyinala.liveroom.tippop.AlaTopTipView.a
            public void ce(View view) {
                a.this.hnB.remove(view);
            }
        };
        this.hnD = aVar;
    }

    public void a(ViewGroup viewGroup, String str, int i, boolean z) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
            if (z) {
                alaTopTipView.setDuration(0);
            }
            alaTopTipView.setType(i);
            alaTopTipView.setText(str);
            alaTopTipView.setOnTipCompletedCallback(this.nSW);
            alaTopTipView.r(viewGroup, 0);
            this.hnB.add(alaTopTipView);
        }
    }

    public void a(ViewGroup viewGroup, String str, int i) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            if (i != 1 || this.hnD == null || this.hnD.eO(9)) {
                AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
                alaTopTipView.setType(i);
                alaTopTipView.setText(str);
                alaTopTipView.setOnTipCompletedCallback(this.nSW);
                alaTopTipView.r(viewGroup, 0);
                this.hnB.add(alaTopTipView);
            }
        }
    }

    public boolean vY(int i) {
        if (this.hnB.isEmpty()) {
            return false;
        }
        for (AlaTopTipView alaTopTipView : this.hnB) {
            if (alaTopTipView.getType() == i) {
                return true;
            }
        }
        return false;
    }

    public void vZ(int i) {
        for (AlaTopTipView alaTopTipView : this.hnB) {
            if (alaTopTipView.getType() == i) {
                alaTopTipView.fY(true);
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void CT() {
        super.CT();
        for (AlaTopTipView alaTopTipView : this.hnB) {
            alaTopTipView.fY(false);
        }
        this.hnB.clear();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        for (AlaTopTipView alaTopTipView : this.hnB) {
            alaTopTipView.fY(false);
        }
        this.hnB.clear();
    }
}
