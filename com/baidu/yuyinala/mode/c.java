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
    private CommonEmptyView bnY;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c bvu;
    private HListView ggw;
    private boolean ouB;
    private View ouv;
    private View ouw;
    private View oux;
    private com.baidu.yuyinala.mode.a.a ovt;
    private a ovu;
    private AlaAudioModeDialogData ovv;
    private com.baidu.yuyinala.mode.b.a ovw;
    private com.baidu.yuyinala.mode.b.a ovx;

    /* loaded from: classes4.dex */
    public interface a {
        void NV(int i);
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(a aVar) {
        this.ovu = aVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.g.dialog_ala_audio_mode;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaAudioModeDialogData alaAudioModeDialogData) {
        this.ovv = alaAudioModeDialogData;
        if (this.ovv != null && !ListUtils.isEmpty(alaAudioModeDialogData.getModeList())) {
            a(alaAudioModeDialogData.getModeList(), alaAudioModeDialogData.getChosenMode());
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.ovt = new com.baidu.yuyinala.mode.a.a(this.mTbPageContext.getPageActivity());
        this.ggw = (HListView) getViewGroup().findViewById(a.f.mode_lv);
        this.ggw.setAdapter((ListAdapter) this.ovt);
        this.ggw.setDividerWidth(this.mTbPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds8));
        this.ggw.setSelector(this.mTbPageContext.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.ouv = getViewGroup().findViewById(a.f.cancle_tv);
        this.ouw = getViewGroup().findViewById(a.f.confirm_tv);
        this.bnY = (CommonEmptyView) getViewGroup().findViewById(a.f.mode_empty_view);
        this.oux = getViewGroup().findViewById(a.f.mode_succ_view);
        this.ouv.setOnClickListener(this);
        this.ouw.setOnClickListener(this);
        this.ggw.setOnItemClickListener(this);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.bvu = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ouv) {
            eeL();
            if (this.bvu != null) {
                this.bvu.dismiss();
            }
        } else if (view == this.ouw) {
            this.ouB = true;
            confirm();
            if (this.bvu != null) {
                this.bvu.dismiss();
            }
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
    public void a(AdapterView<?> adapterView, View view, int i, long j) {
        NS(i);
        com.baidu.yuyinala.mode.b.a item = this.ovt.getItem(i);
        if (item != this.ovw) {
            if (this.ovw != null) {
                this.ovw.zM(false);
            }
            this.ovw = item;
            this.ovw.zM(true);
            this.ovt.notifyDataSetChanged();
        }
    }

    public void NS(int i) {
        if (i >= 0) {
            this.ggw.smoothScrollToPosition(i);
        }
    }

    private void confirm() {
        if (this.ovx != this.ovw && this.ovw != null) {
            if (this.ovu != null) {
                this.ovu.NV(this.ovw.getMode());
            }
            this.ovw = null;
            this.ovx = null;
        }
    }

    private void eeL() {
        if (this.ovx != this.ovw) {
            if (this.ovw != null) {
                this.ovw.zM(false);
            }
            if (this.ovx != null) {
                this.ovx.zM(true);
            }
            this.ovw = null;
            this.ovx = null;
            this.ovt.notifyDataSetChanged();
        }
    }

    private void a(List<com.baidu.yuyinala.mode.b.a> list, com.baidu.yuyinala.mode.b.a aVar) {
        this.oux.setVisibility(0);
        this.bnY.setVisibility(8);
        this.ovt.setModeList(list);
        this.ovw = aVar;
        this.ovx = aVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.ouB) {
            this.ouB = false;
        } else {
            eeL();
        }
        a(null, null);
    }
}
