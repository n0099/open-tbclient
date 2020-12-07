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
    private HListView goG;
    private View oJB;
    private View oJC;
    private View oJD;
    private boolean oJH;
    private a oKA;
    private AlaAudioModeDialogData oKB;
    private com.baidu.yuyinala.mode.b.a oKC;
    private com.baidu.yuyinala.mode.b.a oKD;
    private com.baidu.yuyinala.mode.a.a oKz;

    /* loaded from: classes4.dex */
    public interface a {
        void OT(int i);
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(a aVar) {
        this.oKA = aVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.g.dialog_ala_audio_mode;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaAudioModeDialogData alaAudioModeDialogData) {
        this.oKB = alaAudioModeDialogData;
        if (this.oKB != null && !ListUtils.isEmpty(alaAudioModeDialogData.getModeList())) {
            a(alaAudioModeDialogData.getModeList(), alaAudioModeDialogData.getChosenMode());
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.oKz = new com.baidu.yuyinala.mode.a.a(this.mTbPageContext.getPageActivity());
        this.goG = (HListView) getViewGroup().findViewById(a.f.mode_lv);
        this.goG.setAdapter((ListAdapter) this.oKz);
        this.goG.setDividerWidth(this.mTbPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds8));
        this.goG.setSelector(this.mTbPageContext.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.oJB = getViewGroup().findViewById(a.f.cancle_tv);
        this.oJC = getViewGroup().findViewById(a.f.confirm_tv);
        this.btg = (CommonEmptyView) getViewGroup().findViewById(a.f.mode_empty_view);
        this.oJD = getViewGroup().findViewById(a.f.mode_succ_view);
        this.oJB.setOnClickListener(this);
        this.oJC.setOnClickListener(this);
        this.goG.setOnItemClickListener(this);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.bAE = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oJB) {
            eky();
            if (this.bAE != null) {
                this.bAE.dismiss();
            }
        } else if (view == this.oJC) {
            this.oJH = true;
            confirm();
            if (this.bAE != null) {
                this.bAE.dismiss();
            }
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
    public void a(AdapterView<?> adapterView, View view, int i, long j) {
        OQ(i);
        com.baidu.yuyinala.mode.b.a item = this.oKz.getItem(i);
        if (item != this.oKC) {
            if (this.oKC != null) {
                this.oKC.Aq(false);
            }
            this.oKC = item;
            this.oKC.Aq(true);
            this.oKz.notifyDataSetChanged();
        }
    }

    public void OQ(int i) {
        if (i >= 0) {
            this.goG.smoothScrollToPosition(i);
        }
    }

    private void confirm() {
        if (this.oKD != this.oKC && this.oKC != null) {
            if (this.oKA != null) {
                this.oKA.OT(this.oKC.getMode());
            }
            this.oKC = null;
            this.oKD = null;
        }
    }

    private void eky() {
        if (this.oKD != this.oKC) {
            if (this.oKC != null) {
                this.oKC.Aq(false);
            }
            if (this.oKD != null) {
                this.oKD.Aq(true);
            }
            this.oKC = null;
            this.oKD = null;
            this.oKz.notifyDataSetChanged();
        }
    }

    private void a(List<com.baidu.yuyinala.mode.b.a> list, com.baidu.yuyinala.mode.b.a aVar) {
        this.oJD.setVisibility(0);
        this.btg.setVisibility(8);
        this.oKz.setModeList(list);
        this.oKC = aVar;
        this.oKD = aVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.oJH) {
            this.oJH = false;
        } else {
            eky();
        }
        a(null, null);
    }
}
