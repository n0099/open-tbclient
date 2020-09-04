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
    private ImageView iMi;
    private m lTP;
    private View lTQ;
    private TbImageView lTR;
    private View lTS;
    private TbImageView lTT;
    private TextView lTU;
    private View lTV;
    private TextView lTW;
    private View lTX;
    private TextView lTY;
    private ImageView lTZ;
    private TextView lUa;
    private TbImageView lUb;

    public b(Context context, boolean z, int i, m mVar) {
        super(context, z, i);
        this.lTP = mVar;
        this.lTQ = this.mRootView.findViewById(R.id.pb_post_share_card);
        this.lTR = (TbImageView) this.mRootView.findViewById(R.id.pb_post_share_title);
        this.lTS = this.mRootView.findViewById(R.id.pb_share_origin_thread_img_container);
        this.lTT = (TbImageView) this.mRootView.findViewById(R.id.pb_share_origin_thread_img);
        this.lTT.setPlaceHolder(2);
        this.lTT.setConrers(15);
        this.lTT.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.lTT.setGifIconSupport(false);
        this.lTT.setLongIconSupport(false);
        this.lTU = (TextView) this.mRootView.findViewById(R.id.origin_thread_abstract);
        this.lTV = this.mRootView.findViewById(R.id.pb_share_origin_thread_gradient_mask);
        this.iMi = (ImageView) this.mRootView.findViewById(R.id.pb_post_share_video_play_iv);
        this.lTW = (TextView) this.mRootView.findViewById(R.id.pb_post_video_during_time_tv);
        this.lTX = this.mRootView.findViewById(R.id.pb_post_screen_shot_container);
        this.lTY = (TextView) this.mRootView.findViewById(R.id.post_share_screen_shot_title);
        this.lTZ = (ImageView) this.mRootView.findViewById(R.id.post_share_screen_shot);
        this.lUa = (TextView) this.mRootView.findViewById(R.id.post_share_qcode_comment);
        this.lUb = (TbImageView) this.mRootView.findViewById(R.id.post_share_qcode);
        dsV();
    }

    private void dsV() {
    }

    @Override // com.baidu.tieba.sharesdk.d.c
    protected View cpp() {
        return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.pb_post_share_dialog_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.sharesdk.d.c
    public ShareItem He(int i) {
        ShareItem shareItem = this.lTJ.get(1);
        if (shareItem == null) {
            shareItem = new ShareItem();
        }
        shareItem.eEJ = false;
        shareItem.eEI = false;
        shareItem.content = "";
        shareItem.shareType = 1;
        shareItem.w(cV(this.lTQ));
        shareItem.bpA();
        this.lTJ.put(1, shareItem);
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
        if (this.lTP != null) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
            int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            ap.c(this.lTQ, dimens, R.color.cp_bg_line_g, R.color.cp_bg_line_g);
            ap.c(this.lTX, dimens2, R.color.cp_bg_line_d, R.color.cp_bg_line_d);
            ap.setImageResource(this.lTR, R.drawable.pic_pb_share_logo);
            ap.setViewTextColor(this.lTU, (int) R.color.cp_cont_b);
            if (this.lTP.cWe()) {
                com.baidu.tbadk.core.util.e.a.bjQ().oe(0).i(R.color.cp_mask_b_alpha0, R.color.cp_mask_b_alpha50).oj(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10)).aZ(this.lTV);
            }
            ap.setViewTextColor(this.lTY, (int) R.color.cp_link_tip_a);
            ap.setViewTextColor(this.lUa, (int) R.color.cp_cont_j);
            ap.setViewTextColor(this.lTW, R.color.cp_cont_a, 1);
            this.iMi.setImageDrawable(SvgManager.bjq().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
            this.lTU.setText(this.lTP.getContent());
            if (StringUtils.isNull(this.lTP.getThreadImgUrl())) {
                this.lTS.setVisibility(8);
            } else {
                this.lTT.startLoad(this.lTP.getThreadImgUrl(), 10, false);
            }
            if (this.lTP.cWe()) {
                this.lTW.setText(this.lTP.cWd());
            } else {
                this.lTV.setVisibility(8);
                this.iMi.setVisibility(8);
                this.lTW.setVisibility(8);
            }
            this.lTZ.setImageBitmap(this.lTP.cWb());
            this.lUb.setImageBitmap(this.lTP.cWc());
            super.show();
        }
    }

    @Override // com.baidu.tieba.sharesdk.d.c
    protected void b(Window window) {
        window.setLayout(-1, -1);
    }
}
