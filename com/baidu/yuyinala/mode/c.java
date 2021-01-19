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
/* loaded from: classes10.dex */
public class c extends com.baidu.live.tieba.pb.interactionpopupwindow.b<AlaAudioModeDialogData> implements DialogInterface.OnDismissListener, View.OnClickListener, AdapterView.c {
    private com.baidu.live.tieba.pb.interactionpopupwindow.c bAF;
    private CommonEmptyView btf;
    private View czi;
    private HListView guy;
    private View oLj;
    private View oLk;
    private View oLl;
    private boolean oLp;
    private TextView oMm;
    private com.baidu.yuyinala.mode.a.a oMn;
    private a oMo;
    private AlaAudioModeDialogData oMp;
    private com.baidu.yuyinala.mode.b.a oMq;
    private com.baidu.yuyinala.mode.b.a oMr;

    /* loaded from: classes10.dex */
    public interface a {
        void Nb(int i);
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(a aVar) {
        this.oMo = aVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.g.dialog_ala_audio_mode;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaAudioModeDialogData alaAudioModeDialogData) {
        this.oMp = alaAudioModeDialogData;
        if (this.oMp != null && !ListUtils.isEmpty(alaAudioModeDialogData.getModeList())) {
            a(alaAudioModeDialogData.getModeList(), alaAudioModeDialogData.getChosenMode());
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.oMn = new com.baidu.yuyinala.mode.a.a(this.mTbPageContext.getPageActivity());
        this.czi = getViewGroup().findViewById(a.f.root_layout);
        this.guy = (HListView) getViewGroup().findViewById(a.f.mode_lv);
        this.guy.setAdapter((ListAdapter) this.oMn);
        this.guy.setDividerWidth(this.mTbPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds8));
        this.guy.setSelector(this.mTbPageContext.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.oLj = getViewGroup().findViewById(a.f.cancle_tv);
        this.oLk = getViewGroup().findViewById(a.f.confirm_tv);
        this.btf = (CommonEmptyView) getViewGroup().findViewById(a.f.mode_empty_view);
        this.oLl = getViewGroup().findViewById(a.f.mode_succ_view);
        this.oMm = (TextView) getViewGroup().findViewById(a.f.change_mode_notice);
        this.oLj.setOnClickListener(this);
        this.oLk.setOnClickListener(this);
        this.guy.setOnItemClickListener(this);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.bAF = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oLj) {
            egP();
            if (this.bAF != null) {
                this.bAF.dismiss();
            }
        } else if (view == this.oLk) {
            this.oLp = true;
            confirm();
            if (this.bAF != null) {
                this.bAF.dismiss();
            }
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
    public void a(AdapterView<?> adapterView, View view, int i, long j) {
        MY(i);
        com.baidu.yuyinala.mode.b.a item = this.oMn.getItem(i);
        if (item != this.oMq) {
            if (this.oMq != null) {
                this.oMq.An(false);
            }
            this.oMq = item;
            this.oMq.An(true);
            this.oMn.notifyDataSetChanged();
        }
    }

    public void MY(int i) {
        if (i >= 0) {
            this.guy.smoothScrollToPosition(i);
        }
    }

    private void confirm() {
        if (this.oMr != this.oMq && this.oMq != null) {
            if (this.oMo != null) {
                this.oMo.Nb(this.oMq.getMode());
            }
            this.oMq = null;
            this.oMr = null;
        }
    }

    private void egP() {
        if (this.oMr != this.oMq) {
            if (this.oMq != null) {
                this.oMq.An(false);
            }
            if (this.oMr != null) {
                this.oMr.An(true);
            }
            this.oMq = null;
            this.oMr = null;
            this.oMn.notifyDataSetChanged();
        }
    }

    private void a(List<com.baidu.yuyinala.mode.b.a> list, com.baidu.yuyinala.mode.b.a aVar) {
        int i;
        this.oLl.setVisibility(0);
        this.btf.setVisibility(8);
        this.oMn.setModeList(list);
        this.oMq = aVar;
        this.oMr = aVar;
        if (this.oMr != null && !StringUtils.isNull(this.oMr.getNotice())) {
            this.oMm.setText(this.oMr.getNotice());
            this.oMm.setVisibility(0);
            i = a.d.sdk_ds640;
        } else {
            this.oMm.setVisibility(8);
            i = a.d.sdk_ds570;
        }
        ViewGroup.LayoutParams layoutParams = this.czi.getLayoutParams();
        layoutParams.height = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(i);
        this.czi.setLayoutParams(layoutParams);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.oLp) {
            this.oLp = false;
        } else {
            egP();
        }
        a(null, null);
    }
}
