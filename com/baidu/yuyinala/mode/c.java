package com.baidu.yuyinala.mode;

import android.content.DialogInterface;
import android.view.View;
import android.widget.ListAdapter;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends com.baidu.live.tieba.pb.interactionpopupwindow.b<AlaAudioModeDialogData> implements DialogInterface.OnDismissListener, View.OnClickListener, AdapterView.c {
    private CommonEmptyView bpJ;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c bxf;
    private HListView ggP;
    private View osR;
    private View osS;
    private View osT;
    private boolean osX;
    private com.baidu.yuyinala.mode.a.a otP;
    private a otQ;
    private AlaAudioModeDialogData otR;
    private com.baidu.yuyinala.mode.b.a otS;
    private com.baidu.yuyinala.mode.b.a otT;

    /* loaded from: classes4.dex */
    public interface a {
        void Ns(int i);
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(a aVar) {
        this.otQ = aVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.g.dialog_ala_audio_mode;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaAudioModeDialogData alaAudioModeDialogData) {
        this.otR = alaAudioModeDialogData;
        if (this.otR != null && !ListUtils.isEmpty(alaAudioModeDialogData.getModeList())) {
            a(alaAudioModeDialogData.getModeList(), alaAudioModeDialogData.getChosenMode());
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.otP = new com.baidu.yuyinala.mode.a.a(this.mTbPageContext.getPageActivity());
        this.ggP = (HListView) getViewGroup().findViewById(a.f.mode_lv);
        this.ggP.setAdapter((ListAdapter) this.otP);
        this.ggP.setDividerWidth(this.mTbPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds8));
        this.ggP.setSelector(this.mTbPageContext.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.osR = getViewGroup().findViewById(a.f.cancle_tv);
        this.osS = getViewGroup().findViewById(a.f.confirm_tv);
        this.bpJ = (CommonEmptyView) getViewGroup().findViewById(a.f.mode_empty_view);
        this.osT = getViewGroup().findViewById(a.f.mode_succ_view);
        this.osR.setOnClickListener(this);
        this.osS.setOnClickListener(this);
        this.ggP.setOnItemClickListener(this);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.bxf = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.osR) {
            eeN();
            if (this.bxf != null) {
                this.bxf.dismiss();
            }
        } else if (view == this.osS) {
            this.osX = true;
            confirm();
            if (this.bxf != null) {
                this.bxf.dismiss();
            }
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
    public void a(AdapterView<?> adapterView, View view, int i, long j) {
        Np(i);
        com.baidu.yuyinala.mode.b.a item = this.otP.getItem(i);
        if (item != this.otS) {
            if (this.otS != null) {
                this.otS.zF(false);
            }
            this.otS = item;
            this.otS.zF(true);
            this.otP.notifyDataSetChanged();
        }
    }

    public void Np(int i) {
        if (i >= 0) {
            this.ggP.smoothScrollToPosition(i);
        }
    }

    private void confirm() {
        if (this.otT != this.otS && this.otS != null) {
            if (this.otQ != null) {
                this.otQ.Ns(this.otS.getMode());
            }
            this.otS = null;
            this.otT = null;
        }
    }

    private void eeN() {
        if (this.otT != this.otS) {
            if (this.otS != null) {
                this.otS.zF(false);
            }
            if (this.otT != null) {
                this.otT.zF(true);
            }
            this.otS = null;
            this.otT = null;
            this.otP.notifyDataSetChanged();
        }
    }

    private void a(List<com.baidu.yuyinala.mode.b.a> list, com.baidu.yuyinala.mode.b.a aVar) {
        this.osT.setVisibility(0);
        this.bpJ.setVisibility(8);
        this.otP.setModeList(list);
        this.otS = aVar;
        this.otT = aVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.osX) {
            this.osX = false;
        } else {
            eeN();
        }
        a(null, null);
    }
}
