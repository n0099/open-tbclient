package com.baidu.yuyinala.mode;

import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdToast;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import java.util.List;
/* loaded from: classes11.dex */
public class c extends com.baidu.live.tieba.pb.interactionpopupwindow.b<AlaAudioModeDialogData> implements DialogInterface.OnDismissListener, View.OnClickListener, AdapterView.c {
    private com.baidu.live.tieba.pb.interactionpopupwindow.c bEl;
    private CommonEmptyView bwJ;
    private View cBE;
    private HListView gxw;
    private View oVP;
    private View oVQ;
    private View oVR;
    private boolean oVV;
    private TextView oWS;
    private com.baidu.yuyinala.mode.a.a oWT;
    private a oWU;
    private AlaAudioModeDialogData oWV;
    private com.baidu.yuyinala.mode.b.a oWW;
    private com.baidu.yuyinala.mode.b.a oWX;

    /* loaded from: classes11.dex */
    public interface a {
        void Ny(int i);
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(a aVar) {
        this.oWU = aVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.g.dialog_ala_audio_mode;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaAudioModeDialogData alaAudioModeDialogData) {
        this.oWV = alaAudioModeDialogData;
        if (this.oWV != null && !ListUtils.isEmpty(alaAudioModeDialogData.getModeList())) {
            a(alaAudioModeDialogData.getModeList(), alaAudioModeDialogData.getChosenMode());
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.oWT = new com.baidu.yuyinala.mode.a.a(this.mTbPageContext.getPageActivity());
        this.cBE = getViewGroup().findViewById(a.f.root_layout);
        this.gxw = (HListView) getViewGroup().findViewById(a.f.mode_lv);
        this.gxw.setAdapter((ListAdapter) this.oWT);
        this.gxw.setDividerWidth(this.mTbPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds8));
        this.gxw.setSelector(this.mTbPageContext.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.oVP = getViewGroup().findViewById(a.f.cancle_tv);
        this.oVQ = getViewGroup().findViewById(a.f.confirm_tv);
        this.bwJ = (CommonEmptyView) getViewGroup().findViewById(a.f.mode_empty_view);
        this.oVR = getViewGroup().findViewById(a.f.mode_succ_view);
        this.oWS = (TextView) getViewGroup().findViewById(a.f.change_mode_notice);
        this.oVP.setOnClickListener(this);
        this.oVQ.setOnClickListener(this);
        this.gxw.setOnItemClickListener(this);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.bEl = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oVP) {
            ejp();
            if (this.bEl != null) {
                this.bEl.dismiss();
            }
        } else if (view == this.oVQ) {
            this.oVV = true;
            confirm();
            if (this.bEl != null) {
                this.bEl.dismiss();
            }
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
    public void a(AdapterView<?> adapterView, View view, int i, long j) {
        Nv(i);
        com.baidu.yuyinala.mode.b.a item = this.oWT.getItem(i);
        if (item != this.oWW) {
            if (this.oWW != null) {
                this.oWW.AG(false);
            }
            this.oWW = item;
            this.oWW.AG(true);
            this.oWT.notifyDataSetChanged();
        }
    }

    public void Nv(int i) {
        if (i >= 0) {
            this.gxw.smoothScrollToPosition(i);
        }
    }

    private void confirm() {
        if (this.oWX == this.oWW) {
            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.change_mode_noneed)).show();
        } else if (this.oWW != null) {
            if (this.oWU != null) {
                this.oWU.Ny(this.oWW.getMode());
            }
            this.oWW = null;
            this.oWX = null;
        }
    }

    private void ejp() {
        if (this.oWX != this.oWW) {
            if (this.oWW != null) {
                this.oWW.AG(false);
            }
            if (this.oWX != null) {
                this.oWX.AG(true);
            }
            this.oWW = null;
            this.oWX = null;
            this.oWT.notifyDataSetChanged();
        }
    }

    private void a(List<com.baidu.yuyinala.mode.b.a> list, com.baidu.yuyinala.mode.b.a aVar) {
        int i;
        this.oVR.setVisibility(0);
        this.bwJ.setVisibility(8);
        this.oWT.setModeList(list);
        this.oWW = aVar;
        this.oWX = aVar;
        if (this.oWX != null && !StringUtils.isNull(this.oWX.getNotice())) {
            this.oWS.setText(this.oWX.getNotice());
            this.oWS.setVisibility(0);
            i = a.d.sdk_ds640;
        } else {
            this.oWS.setVisibility(8);
            i = a.d.sdk_ds570;
        }
        ViewGroup.LayoutParams layoutParams = this.cBE.getLayoutParams();
        layoutParams.height = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(i);
        this.cBE.setLayoutParams(layoutParams);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.oVV) {
            this.oVV = false;
        } else {
            ejp();
        }
        a(null, null);
    }
}
