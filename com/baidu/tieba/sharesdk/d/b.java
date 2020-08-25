package com.baidu.tieba.sharesdk.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.m;
/* loaded from: classes18.dex */
public class b extends c {
    private ImageView iMc;
    private m lTA;
    private View lTB;
    private TbImageView lTC;
    private View lTD;
    private TbImageView lTE;
    private TextView lTF;
    private View lTG;
    private TextView lTH;
    private View lTI;
    private TextView lTJ;
    private ImageView lTK;
    private TextView lTL;
    private TbImageView lTM;

    public b(Context context, boolean z, int i, m mVar) {
        super(context, z, i);
        this.lTA = mVar;
        this.lTB = this.mRootView.findViewById(R.id.pb_post_share_card);
        this.lTC = (TbImageView) this.mRootView.findViewById(R.id.pb_post_share_title);
        this.lTD = this.mRootView.findViewById(R.id.pb_share_origin_thread_img_container);
        this.lTE = (TbImageView) this.mRootView.findViewById(R.id.pb_share_origin_thread_img);
        this.lTE.setPlaceHolder(2);
        this.lTE.setConrers(15);
        this.lTE.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.lTE.setGifIconSupport(false);
        this.lTE.setLongIconSupport(false);
        this.lTF = (TextView) this.mRootView.findViewById(R.id.origin_thread_abstract);
        this.lTG = this.mRootView.findViewById(R.id.pb_share_origin_thread_gradient_mask);
        this.iMc = (ImageView) this.mRootView.findViewById(R.id.pb_post_share_video_play_iv);
        this.lTH = (TextView) this.mRootView.findViewById(R.id.pb_post_video_during_time_tv);
        this.lTI = this.mRootView.findViewById(R.id.pb_post_screen_shot_container);
        this.lTJ = (TextView) this.mRootView.findViewById(R.id.post_share_screen_shot_title);
        this.lTK = (ImageView) this.mRootView.findViewById(R.id.post_share_screen_shot);
        this.lTL = (TextView) this.mRootView.findViewById(R.id.post_share_qcode_comment);
        this.lTM = (TbImageView) this.mRootView.findViewById(R.id.post_share_qcode);
        dsQ();
    }

    private void dsQ() {
    }

    @Override // com.baidu.tieba.sharesdk.d.c
    protected View cpo() {
        return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.pb_post_share_dialog_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.sharesdk.d.c
    public ShareItem He(int i) {
        ShareItem shareItem = this.lTu.get(1);
        if (shareItem == null) {
            shareItem = new ShareItem();
        }
        shareItem.eEF = false;
        shareItem.eEE = false;
        shareItem.content = "";
        shareItem.shareType = 1;
        shareItem.w(cV(this.lTB));
        shareItem.bpz();
        this.lTu.put(1, shareItem);
        return super.He(i);
    }

    private Bitmap cV(View view) {
        if (view == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_4444);
        createBitmap.eraseColor(ap.getColor(R.color.cp_bg_line_g));
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    @Override // com.baidu.tieba.sharesdk.d.c
    public void show() {
        if (this.lTA != null) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
            int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            ap.c(this.lTB, dimens, R.color.cp_bg_line_g, R.color.cp_bg_line_g);
            ap.c(this.lTI, dimens2, R.color.cp_bg_line_d, R.color.cp_bg_line_d);
            ap.setImageResource(this.lTC, R.drawable.pic_pb_share_logo);
            ap.setViewTextColor(this.lTF, R.color.cp_cont_b);
            if (this.lTA.cWd()) {
                com.baidu.tbadk.core.util.e.a.bjQ().oe(0).i(R.color.cp_mask_b_alpha0, R.color.cp_mask_b_alpha50).oj(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10)).aZ(this.lTG);
            }
            ap.setViewTextColor(this.lTJ, R.color.cp_link_tip_a);
            ap.setViewTextColor(this.lTL, R.color.cp_cont_j);
            ap.setViewTextColor(this.lTH, R.color.cp_cont_a, 1);
            this.iMc.setImageDrawable(SvgManager.bjq().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
            this.lTF.setText(this.lTA.getContent());
            if (StringUtils.isNull(this.lTA.getThreadImgUrl())) {
                this.lTD.setVisibility(8);
            } else {
                this.lTE.startLoad(this.lTA.getThreadImgUrl(), 10, false);
            }
            if (this.lTA.cWd()) {
                this.lTH.setText(this.lTA.cWc());
            } else {
                this.lTG.setVisibility(8);
                this.iMc.setVisibility(8);
                this.lTH.setVisibility(8);
            }
            this.lTK.setImageBitmap(this.lTA.cWa());
            this.lTM.setImageBitmap(this.lTA.cWb());
            super.show();
        }
    }

    @Override // com.baidu.tieba.sharesdk.d.c
    protected void b(Window window) {
        window.setLayout(-1, -1);
    }
}
