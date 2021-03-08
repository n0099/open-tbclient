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
    private final List<AlaTopTipView> hQB;
    private com.baidu.live.liveroom.a.a hQD;
    private final AlaTopTipView.a oEG;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.hQB = new LinkedList();
        this.oEG = new AlaTopTipView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.tippop.a.1
            @Override // com.baidu.tieba.yuyinala.liveroom.tippop.AlaTopTipView.a
            public void cy(View view) {
                a.this.hQB.remove(view);
            }
        };
        this.hQD = aVar;
    }

    public void a(ViewGroup viewGroup, String str, int i, boolean z) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
            if (z) {
                alaTopTipView.setDuration(0);
            }
            alaTopTipView.setType(i);
            alaTopTipView.setText(str);
            alaTopTipView.setOnTipCompletedCallback(this.oEG);
            alaTopTipView.w(viewGroup, 0);
            this.hQB.add(alaTopTipView);
        }
    }

    public void a(ViewGroup viewGroup, String str, int i) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            if (i != 1 || this.hQD == null || this.hQD.dG(9)) {
                AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
                alaTopTipView.setType(i);
                alaTopTipView.setText(str);
                alaTopTipView.setOnTipCompletedCallback(this.oEG);
                alaTopTipView.w(viewGroup, 0);
                this.hQB.add(alaTopTipView);
            }
        }
    }

    public boolean wh(int i) {
        if (this.hQB.isEmpty()) {
            return false;
        }
        for (AlaTopTipView alaTopTipView : this.hQB) {
            if (alaTopTipView.getType() == i) {
                return true;
            }
        }
        return false;
    }

    public void wi(int i) {
        for (AlaTopTipView alaTopTipView : this.hQB) {
            if (alaTopTipView.getType() == i) {
                alaTopTipView.gG(true);
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void Au() {
        super.Au();
        for (AlaTopTipView alaTopTipView : this.hQB) {
            alaTopTipView.gG(false);
        }
        this.hQB.clear();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        for (AlaTopTipView alaTopTipView : this.hQB) {
            alaTopTipView.gG(false);
        }
        this.hQB.clear();
    }
}
