package com.baidu.yuyinala.mode;

import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import java.util.List;
/* loaded from: classes11.dex */
public class c extends com.baidu.live.tieba.pb.interactionpopupwindow.b<AlaAudioModeDialogData> implements DialogInterface.OnDismissListener, View.OnClickListener, AdapterView.c {
    private com.baidu.live.tieba.pb.interactionpopupwindow.c bFr;
    private CommonEmptyView bxT;
    private View cDU;
    private HListView gzf;
    private View oPK;
    private View oPL;
    private View oPM;
    private boolean oPQ;
    private TextView oQN;
    private com.baidu.yuyinala.mode.a.a oQO;
    private a oQP;
    private AlaAudioModeDialogData oQQ;
    private com.baidu.yuyinala.mode.b.a oQR;
    private com.baidu.yuyinala.mode.b.a oQS;

    /* loaded from: classes11.dex */
    public interface a {
        void OI(int i);
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(a aVar) {
        this.oQP = aVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.g.dialog_ala_audio_mode;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaAudioModeDialogData alaAudioModeDialogData) {
        this.oQQ = alaAudioModeDialogData;
        if (this.oQQ != null && !ListUtils.isEmpty(alaAudioModeDialogData.getModeList())) {
            a(alaAudioModeDialogData.getModeList(), alaAudioModeDialogData.getChosenMode());
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.oQO = new com.baidu.yuyinala.mode.a.a(this.mTbPageContext.getPageActivity());
        this.cDU = getViewGroup().findViewById(a.f.root_layout);
        this.gzf = (HListView) getViewGroup().findViewById(a.f.mode_lv);
        this.gzf.setAdapter((ListAdapter) this.oQO);
        this.gzf.setDividerWidth(this.mTbPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds8));
        this.gzf.setSelector(this.mTbPageContext.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.oPK = getViewGroup().findViewById(a.f.cancle_tv);
        this.oPL = getViewGroup().findViewById(a.f.confirm_tv);
        this.bxT = (CommonEmptyView) getViewGroup().findViewById(a.f.mode_empty_view);
        this.oPM = getViewGroup().findViewById(a.f.mode_succ_view);
        this.oQN = (TextView) getViewGroup().findViewById(a.f.change_mode_notice);
        this.oPK.setOnClickListener(this);
        this.oPL.setOnClickListener(this);
        this.gzf.setOnItemClickListener(this);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.bFr = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oPK) {
            ekJ();
            if (this.bFr != null) {
                this.bFr.dismiss();
            }
        } else if (view == this.oPL) {
            this.oPQ = true;
            confirm();
            if (this.bFr != null) {
                this.bFr.dismiss();
            }
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
    public void a(AdapterView<?> adapterView, View view, int i, long j) {
        OF(i);
        com.baidu.yuyinala.mode.b.a item = this.oQO.getItem(i);
        if (item != this.oQR) {
            if (this.oQR != null) {
                this.oQR.Ar(false);
            }
            this.oQR = item;
            this.oQR.Ar(true);
            this.oQO.notifyDataSetChanged();
        }
    }

    public void OF(int i) {
        if (i >= 0) {
            this.gzf.smoothScrollToPosition(i);
        }
    }

    private void confirm() {
        if (this.oQS != this.oQR && this.oQR != null) {
            if (this.oQP != null) {
                this.oQP.OI(this.oQR.getMode());
            }
            this.oQR = null;
            this.oQS = null;
        }
    }

    private void ekJ() {
        if (this.oQS != this.oQR) {
            if (this.oQR != null) {
                this.oQR.Ar(false);
            }
            if (this.oQS != null) {
                this.oQS.Ar(true);
            }
            this.oQR = null;
            this.oQS = null;
            this.oQO.notifyDataSetChanged();
        }
    }

    private void a(List<com.baidu.yuyinala.mode.b.a> list, com.baidu.yuyinala.mode.b.a aVar) {
        int i;
        this.oPM.setVisibility(0);
        this.bxT.setVisibility(8);
        this.oQO.setModeList(list);
        this.oQR = aVar;
        this.oQS = aVar;
        if (this.oQS != null && !StringUtils.isNull(this.oQS.getNotice())) {
            this.oQN.setText(this.oQS.getNotice());
            this.oQN.setVisibility(0);
            i = a.d.sdk_ds640;
        } else {
            this.oQN.setVisibility(8);
            i = a.d.sdk_ds570;
        }
        ViewGroup.LayoutParams layoutParams = this.cDU.getLayoutParams();
        layoutParams.height = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(i);
        this.cDU.setLayoutParams(layoutParams);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.oPQ) {
            this.oPQ = false;
        } else {
            ekJ();
        }
        a(null, null);
    }
}
