package com.baidu.tieba.yuyinala.liveroom.tippop;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.tippop.AlaTopTipView;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a {
    private final List<AlaTopTipView> hOM;
    private com.baidu.live.liveroom.a.a hOO;
    private final AlaTopTipView.a owR;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.hOM = new LinkedList();
        this.owR = new AlaTopTipView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.tippop.a.1
            @Override // com.baidu.tieba.yuyinala.liveroom.tippop.AlaTopTipView.a
            public void cC(View view) {
                a.this.hOM.remove(view);
            }
        };
        this.hOO = aVar;
    }

    public void a(ViewGroup viewGroup, String str, int i, boolean z) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
            if (z) {
                alaTopTipView.setDuration(0);
            }
            alaTopTipView.setType(i);
            alaTopTipView.setText(str);
            alaTopTipView.setOnTipCompletedCallback(this.owR);
            alaTopTipView.v(viewGroup, 0);
            this.hOM.add(alaTopTipView);
        }
    }

    public void c(ViewGroup viewGroup, String str, int i) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            if (i != 1 || this.hOO == null || this.hOO.ff(9)) {
                AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
                alaTopTipView.setType(i);
                alaTopTipView.setText(str);
                alaTopTipView.setOnTipCompletedCallback(this.owR);
                alaTopTipView.v(viewGroup, 0);
                this.hOM.add(alaTopTipView);
            }
        }
    }

    public boolean xA(int i) {
        if (this.hOM.isEmpty()) {
            return false;
        }
        for (AlaTopTipView alaTopTipView : this.hOM) {
            if (alaTopTipView.getType() == i) {
                return true;
            }
        }
        return false;
    }

    public void xB(int i) {
        for (AlaTopTipView alaTopTipView : this.hOM) {
            if (alaTopTipView.getType() == i) {
                alaTopTipView.gI(true);
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void DC() {
        super.DC();
        for (AlaTopTipView alaTopTipView : this.hOM) {
            alaTopTipView.gI(false);
        }
        this.hOM.clear();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        for (AlaTopTipView alaTopTipView : this.hOM) {
            alaTopTipView.gI(false);
        }
        this.hOM.clear();
    }
}
