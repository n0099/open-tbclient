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
/* loaded from: classes10.dex */
public class c extends com.baidu.live.tieba.pb.interactionpopupwindow.b<AlaAudioModeDialogData> implements DialogInterface.OnDismissListener, View.OnClickListener, AdapterView.c {
    private com.baidu.live.tieba.pb.interactionpopupwindow.c bFL;
    private CommonEmptyView byj;
    private View cDe;
    private HListView gzf;
    private View oXU;
    private View oXV;
    private View oXW;
    private TextView oYX;
    private com.baidu.yuyinala.mode.a.a oYY;
    private a oYZ;
    private boolean oYa;
    private AlaAudioModeDialogData oZa;
    private com.baidu.yuyinala.mode.b.a oZb;
    private com.baidu.yuyinala.mode.b.a oZc;

    /* loaded from: classes10.dex */
    public interface a {
        void NC(int i);
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(a aVar) {
        this.oYZ = aVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.g.dialog_ala_audio_mode;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaAudioModeDialogData alaAudioModeDialogData) {
        this.oZa = alaAudioModeDialogData;
        if (this.oZa != null && !ListUtils.isEmpty(alaAudioModeDialogData.getModeList())) {
            a(alaAudioModeDialogData.getModeList(), alaAudioModeDialogData.getChosenMode());
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.oYY = new com.baidu.yuyinala.mode.a.a(this.mTbPageContext.getPageActivity());
        this.cDe = getViewGroup().findViewById(a.f.root_layout);
        this.gzf = (HListView) getViewGroup().findViewById(a.f.mode_lv);
        this.gzf.setAdapter((ListAdapter) this.oYY);
        this.gzf.setDividerWidth(this.mTbPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds8));
        this.gzf.setSelector(this.mTbPageContext.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.oXU = getViewGroup().findViewById(a.f.cancle_tv);
        this.oXV = getViewGroup().findViewById(a.f.confirm_tv);
        this.byj = (CommonEmptyView) getViewGroup().findViewById(a.f.mode_empty_view);
        this.oXW = getViewGroup().findViewById(a.f.mode_succ_view);
        this.oYX = (TextView) getViewGroup().findViewById(a.f.change_mode_notice);
        this.oXU.setOnClickListener(this);
        this.oXV.setOnClickListener(this);
        this.gzf.setOnItemClickListener(this);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.bFL = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oXU) {
            ejz();
            if (this.bFL != null) {
                this.bFL.dismiss();
            }
        } else if (view == this.oXV) {
            this.oYa = true;
            confirm();
            if (this.bFL != null) {
                this.bFL.dismiss();
            }
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
    public void a(AdapterView<?> adapterView, View view, int i, long j) {
        Nz(i);
        com.baidu.yuyinala.mode.b.a item = this.oYY.getItem(i);
        if (item != this.oZb) {
            if (this.oZb != null) {
                this.oZb.AF(false);
            }
            this.oZb = item;
            this.oZb.AF(true);
            this.oYY.notifyDataSetChanged();
        }
    }

    public void Nz(int i) {
        if (i >= 0) {
            this.gzf.smoothScrollToPosition(i);
        }
    }

    private void confirm() {
        if (this.oZc == this.oZb) {
            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.change_mode_noneed)).show();
        } else if (this.oZb != null) {
            if (this.oYZ != null) {
                this.oYZ.NC(this.oZb.getMode());
            }
            this.oZb = null;
            this.oZc = null;
        }
    }

    private void ejz() {
        if (this.oZc != this.oZb) {
            if (this.oZb != null) {
                this.oZb.AF(false);
            }
            if (this.oZc != null) {
                this.oZc.AF(true);
            }
            this.oZb = null;
            this.oZc = null;
            this.oYY.notifyDataSetChanged();
        }
    }

    private void a(List<com.baidu.yuyinala.mode.b.a> list, com.baidu.yuyinala.mode.b.a aVar) {
        int i;
        this.oXW.setVisibility(0);
        this.byj.setVisibility(8);
        this.oYY.setModeList(list);
        this.oZb = aVar;
        this.oZc = aVar;
        if (this.oZc != null && !StringUtils.isNull(this.oZc.getNotice())) {
            this.oYX.setText(this.oZc.getNotice());
            this.oYX.setVisibility(0);
            i = a.d.sdk_ds640;
        } else {
            this.oYX.setVisibility(8);
            i = a.d.sdk_ds570;
        }
        ViewGroup.LayoutParams layoutParams = this.cDe.getLayoutParams();
        layoutParams.height = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(i);
        this.cDe.setLayoutParams(layoutParams);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.oYa) {
            this.oYa = false;
        } else {
            ejz();
        }
        a(null, null);
    }
}
