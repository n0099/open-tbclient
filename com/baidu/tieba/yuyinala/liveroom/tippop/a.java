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
    private final List<AlaTopTipView> htg;
    private com.baidu.live.liveroom.a.a hti;
    private final AlaTopTipView.a obN;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.htg = new LinkedList();
        this.obN = new AlaTopTipView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.tippop.a.1
            @Override // com.baidu.tieba.yuyinala.liveroom.tippop.AlaTopTipView.a
            public void cm(View view) {
                a.this.htg.remove(view);
            }
        };
        this.hti = aVar;
    }

    public void a(ViewGroup viewGroup, String str, int i, boolean z) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
            if (z) {
                alaTopTipView.setDuration(0);
            }
            alaTopTipView.setType(i);
            alaTopTipView.setText(str);
            alaTopTipView.setOnTipCompletedCallback(this.obN);
            alaTopTipView.r(viewGroup, 0);
            this.htg.add(alaTopTipView);
        }
    }

    public void a(ViewGroup viewGroup, String str, int i) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            if (i != 1 || this.hti == null || this.hti.eK(9)) {
                AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
                alaTopTipView.setType(i);
                alaTopTipView.setText(str);
                alaTopTipView.setOnTipCompletedCallback(this.obN);
                alaTopTipView.r(viewGroup, 0);
                this.htg.add(alaTopTipView);
            }
        }
    }

    public boolean wJ(int i) {
        if (this.htg.isEmpty()) {
            return false;
        }
        for (AlaTopTipView alaTopTipView : this.htg) {
            if (alaTopTipView.getType() == i) {
                return true;
            }
        }
        return false;
    }

    public void wK(int i) {
        for (AlaTopTipView alaTopTipView : this.htg) {
            if (alaTopTipView.getType() == i) {
                alaTopTipView.gk(true);
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void CD() {
        super.CD();
        for (AlaTopTipView alaTopTipView : this.htg) {
            alaTopTipView.gk(false);
        }
        this.htg.clear();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        for (AlaTopTipView alaTopTipView : this.htg) {
            alaTopTipView.gk(false);
        }
        this.htg.clear();
    }
}
