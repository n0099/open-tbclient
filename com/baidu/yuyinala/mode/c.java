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
    private View oLi;
    private View oLj;
    private View oLk;
    private boolean oLo;
    private TextView oMl;
    private com.baidu.yuyinala.mode.a.a oMm;
    private a oMn;
    private AlaAudioModeDialogData oMo;
    private com.baidu.yuyinala.mode.b.a oMp;
    private com.baidu.yuyinala.mode.b.a oMq;

    /* loaded from: classes10.dex */
    public interface a {
        void Nb(int i);
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(a aVar) {
        this.oMn = aVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.g.dialog_ala_audio_mode;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaAudioModeDialogData alaAudioModeDialogData) {
        this.oMo = alaAudioModeDialogData;
        if (this.oMo != null && !ListUtils.isEmpty(alaAudioModeDialogData.getModeList())) {
            a(alaAudioModeDialogData.getModeList(), alaAudioModeDialogData.getChosenMode());
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.oMm = new com.baidu.yuyinala.mode.a.a(this.mTbPageContext.getPageActivity());
        this.czi = getViewGroup().findViewById(a.f.root_layout);
        this.guy = (HListView) getViewGroup().findViewById(a.f.mode_lv);
        this.guy.setAdapter((ListAdapter) this.oMm);
        this.guy.setDividerWidth(this.mTbPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds8));
        this.guy.setSelector(this.mTbPageContext.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.oLi = getViewGroup().findViewById(a.f.cancle_tv);
        this.oLj = getViewGroup().findViewById(a.f.confirm_tv);
        this.btf = (CommonEmptyView) getViewGroup().findViewById(a.f.mode_empty_view);
        this.oLk = getViewGroup().findViewById(a.f.mode_succ_view);
        this.oMl = (TextView) getViewGroup().findViewById(a.f.change_mode_notice);
        this.oLi.setOnClickListener(this);
        this.oLj.setOnClickListener(this);
        this.guy.setOnItemClickListener(this);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.bAF = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oLi) {
            egP();
            if (this.bAF != null) {
                this.bAF.dismiss();
            }
        } else if (view == this.oLj) {
            this.oLo = true;
            confirm();
            if (this.bAF != null) {
                this.bAF.dismiss();
            }
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
    public void a(AdapterView<?> adapterView, View view, int i, long j) {
        MY(i);
        com.baidu.yuyinala.mode.b.a item = this.oMm.getItem(i);
        if (item != this.oMp) {
            if (this.oMp != null) {
                this.oMp.An(false);
            }
            this.oMp = item;
            this.oMp.An(true);
            this.oMm.notifyDataSetChanged();
        }
    }

    public void MY(int i) {
        if (i >= 0) {
            this.guy.smoothScrollToPosition(i);
        }
    }

    private void confirm() {
        if (this.oMq != this.oMp && this.oMp != null) {
            if (this.oMn != null) {
                this.oMn.Nb(this.oMp.getMode());
            }
            this.oMp = null;
            this.oMq = null;
        }
    }

    private void egP() {
        if (this.oMq != this.oMp) {
            if (this.oMp != null) {
                this.oMp.An(false);
            }
            if (this.oMq != null) {
                this.oMq.An(true);
            }
            this.oMp = null;
            this.oMq = null;
            this.oMm.notifyDataSetChanged();
        }
    }

    private void a(List<com.baidu.yuyinala.mode.b.a> list, com.baidu.yuyinala.mode.b.a aVar) {
        int i;
        this.oLk.setVisibility(0);
        this.btf.setVisibility(8);
        this.oMm.setModeList(list);
        this.oMp = aVar;
        this.oMq = aVar;
        if (this.oMq != null && !StringUtils.isNull(this.oMq.getNotice())) {
            this.oMl.setText(this.oMq.getNotice());
            this.oMl.setVisibility(0);
            i = a.d.sdk_ds640;
        } else {
            this.oMl.setVisibility(8);
            i = a.d.sdk_ds570;
        }
        ViewGroup.LayoutParams layoutParams = this.czi.getLayoutParams();
        layoutParams.height = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(i);
        this.czi.setLayoutParams(layoutParams);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.oLo) {
            this.oLo = false;
        } else {
            egP();
        }
        a(null, null);
    }
}
