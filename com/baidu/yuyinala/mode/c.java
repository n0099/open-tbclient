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
    private com.baidu.live.tieba.pb.interactionpopupwindow.c bAE;
    private CommonEmptyView btg;
    private HListView goI;
    private View oJD;
    private View oJE;
    private View oJF;
    private boolean oJJ;
    private com.baidu.yuyinala.mode.a.a oKB;
    private a oKC;
    private AlaAudioModeDialogData oKD;
    private com.baidu.yuyinala.mode.b.a oKE;
    private com.baidu.yuyinala.mode.b.a oKF;

    /* loaded from: classes4.dex */
    public interface a {
        void OT(int i);
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(a aVar) {
        this.oKC = aVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.g.dialog_ala_audio_mode;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaAudioModeDialogData alaAudioModeDialogData) {
        this.oKD = alaAudioModeDialogData;
        if (this.oKD != null && !ListUtils.isEmpty(alaAudioModeDialogData.getModeList())) {
            a(alaAudioModeDialogData.getModeList(), alaAudioModeDialogData.getChosenMode());
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.oKB = new com.baidu.yuyinala.mode.a.a(this.mTbPageContext.getPageActivity());
        this.goI = (HListView) getViewGroup().findViewById(a.f.mode_lv);
        this.goI.setAdapter((ListAdapter) this.oKB);
        this.goI.setDividerWidth(this.mTbPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds8));
        this.goI.setSelector(this.mTbPageContext.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.oJD = getViewGroup().findViewById(a.f.cancle_tv);
        this.oJE = getViewGroup().findViewById(a.f.confirm_tv);
        this.btg = (CommonEmptyView) getViewGroup().findViewById(a.f.mode_empty_view);
        this.oJF = getViewGroup().findViewById(a.f.mode_succ_view);
        this.oJD.setOnClickListener(this);
        this.oJE.setOnClickListener(this);
        this.goI.setOnItemClickListener(this);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.bAE = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oJD) {
            ekz();
            if (this.bAE != null) {
                this.bAE.dismiss();
            }
        } else if (view == this.oJE) {
            this.oJJ = true;
            confirm();
            if (this.bAE != null) {
                this.bAE.dismiss();
            }
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
    public void a(AdapterView<?> adapterView, View view, int i, long j) {
        OQ(i);
        com.baidu.yuyinala.mode.b.a item = this.oKB.getItem(i);
        if (item != this.oKE) {
            if (this.oKE != null) {
                this.oKE.Aq(false);
            }
            this.oKE = item;
            this.oKE.Aq(true);
            this.oKB.notifyDataSetChanged();
        }
    }

    public void OQ(int i) {
        if (i >= 0) {
            this.goI.smoothScrollToPosition(i);
        }
    }

    private void confirm() {
        if (this.oKF != this.oKE && this.oKE != null) {
            if (this.oKC != null) {
                this.oKC.OT(this.oKE.getMode());
            }
            this.oKE = null;
            this.oKF = null;
        }
    }

    private void ekz() {
        if (this.oKF != this.oKE) {
            if (this.oKE != null) {
                this.oKE.Aq(false);
            }
            if (this.oKF != null) {
                this.oKF.Aq(true);
            }
            this.oKE = null;
            this.oKF = null;
            this.oKB.notifyDataSetChanged();
        }
    }

    private void a(List<com.baidu.yuyinala.mode.b.a> list, com.baidu.yuyinala.mode.b.a aVar) {
        this.oJF.setVisibility(0);
        this.btg.setVisibility(8);
        this.oKB.setModeList(list);
        this.oKE = aVar;
        this.oKF = aVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.oJJ) {
            this.oJJ = false;
        } else {
            ekz();
        }
        a(null, null);
    }
}
