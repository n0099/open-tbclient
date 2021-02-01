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
    private HListView gxi;
    private View oVp;
    private View oVq;
    private View oVr;
    private boolean oVv;
    private TextView oWs;
    private com.baidu.yuyinala.mode.a.a oWt;
    private a oWu;
    private AlaAudioModeDialogData oWv;
    private com.baidu.yuyinala.mode.b.a oWw;
    private com.baidu.yuyinala.mode.b.a oWx;

    /* loaded from: classes11.dex */
    public interface a {
        void Nx(int i);
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(a aVar) {
        this.oWu = aVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.g.dialog_ala_audio_mode;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaAudioModeDialogData alaAudioModeDialogData) {
        this.oWv = alaAudioModeDialogData;
        if (this.oWv != null && !ListUtils.isEmpty(alaAudioModeDialogData.getModeList())) {
            a(alaAudioModeDialogData.getModeList(), alaAudioModeDialogData.getChosenMode());
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.oWt = new com.baidu.yuyinala.mode.a.a(this.mTbPageContext.getPageActivity());
        this.cBE = getViewGroup().findViewById(a.f.root_layout);
        this.gxi = (HListView) getViewGroup().findViewById(a.f.mode_lv);
        this.gxi.setAdapter((ListAdapter) this.oWt);
        this.gxi.setDividerWidth(this.mTbPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds8));
        this.gxi.setSelector(this.mTbPageContext.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.oVp = getViewGroup().findViewById(a.f.cancle_tv);
        this.oVq = getViewGroup().findViewById(a.f.confirm_tv);
        this.bwJ = (CommonEmptyView) getViewGroup().findViewById(a.f.mode_empty_view);
        this.oVr = getViewGroup().findViewById(a.f.mode_succ_view);
        this.oWs = (TextView) getViewGroup().findViewById(a.f.change_mode_notice);
        this.oVp.setOnClickListener(this);
        this.oVq.setOnClickListener(this);
        this.gxi.setOnItemClickListener(this);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.bEl = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oVp) {
            ejh();
            if (this.bEl != null) {
                this.bEl.dismiss();
            }
        } else if (view == this.oVq) {
            this.oVv = true;
            confirm();
            if (this.bEl != null) {
                this.bEl.dismiss();
            }
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
    public void a(AdapterView<?> adapterView, View view, int i, long j) {
        Nu(i);
        com.baidu.yuyinala.mode.b.a item = this.oWt.getItem(i);
        if (item != this.oWw) {
            if (this.oWw != null) {
                this.oWw.AG(false);
            }
            this.oWw = item;
            this.oWw.AG(true);
            this.oWt.notifyDataSetChanged();
        }
    }

    public void Nu(int i) {
        if (i >= 0) {
            this.gxi.smoothScrollToPosition(i);
        }
    }

    private void confirm() {
        if (this.oWx == this.oWw) {
            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.change_mode_noneed)).show();
        } else if (this.oWw != null) {
            if (this.oWu != null) {
                this.oWu.Nx(this.oWw.getMode());
            }
            this.oWw = null;
            this.oWx = null;
        }
    }

    private void ejh() {
        if (this.oWx != this.oWw) {
            if (this.oWw != null) {
                this.oWw.AG(false);
            }
            if (this.oWx != null) {
                this.oWx.AG(true);
            }
            this.oWw = null;
            this.oWx = null;
            this.oWt.notifyDataSetChanged();
        }
    }

    private void a(List<com.baidu.yuyinala.mode.b.a> list, com.baidu.yuyinala.mode.b.a aVar) {
        int i;
        this.oVr.setVisibility(0);
        this.bwJ.setVisibility(8);
        this.oWt.setModeList(list);
        this.oWw = aVar;
        this.oWx = aVar;
        if (this.oWx != null && !StringUtils.isNull(this.oWx.getNotice())) {
            this.oWs.setText(this.oWx.getNotice());
            this.oWs.setVisibility(0);
            i = a.d.sdk_ds640;
        } else {
            this.oWs.setVisibility(8);
            i = a.d.sdk_ds570;
        }
        ViewGroup.LayoutParams layoutParams = this.cBE.getLayoutParams();
        layoutParams.height = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(i);
        this.cBE.setLayoutParams(layoutParams);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.oVv) {
            this.oVv = false;
        } else {
            ejh();
        }
        a(null, null);
    }
}
