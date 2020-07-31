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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.m;
/* loaded from: classes18.dex */
public class b extends c {
    private ImageView ixp;
    private m lBT;
    private View lBU;
    private TbImageView lBV;
    private View lBW;
    private TbImageView lBX;
    private TextView lBY;
    private View lBZ;
    private TextView lCa;
    private View lCb;
    private TextView lCc;
    private ImageView lCd;
    private TextView lCe;
    private TbImageView lCf;

    public b(Context context, boolean z, int i, m mVar) {
        super(context, z, i);
        this.lBT = mVar;
        this.lBU = this.mRootView.findViewById(R.id.pb_post_share_card);
        this.lBV = (TbImageView) this.mRootView.findViewById(R.id.pb_post_share_title);
        this.lBW = this.mRootView.findViewById(R.id.pb_share_origin_thread_img_container);
        this.lBX = (TbImageView) this.mRootView.findViewById(R.id.pb_share_origin_thread_img);
        this.lBX.setPlaceHolder(2);
        this.lBX.setConrers(15);
        this.lBX.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.lBX.setGifIconSupport(false);
        this.lBX.setLongIconSupport(false);
        this.lBY = (TextView) this.mRootView.findViewById(R.id.origin_thread_abstract);
        this.lBZ = this.mRootView.findViewById(R.id.pb_share_origin_thread_gradient_mask);
        this.ixp = (ImageView) this.mRootView.findViewById(R.id.pb_post_share_video_play_iv);
        this.lCa = (TextView) this.mRootView.findViewById(R.id.pb_post_video_during_time_tv);
        this.lCb = this.mRootView.findViewById(R.id.pb_post_screen_shot_container);
        this.lCc = (TextView) this.mRootView.findViewById(R.id.post_share_screen_shot_title);
        this.lCd = (ImageView) this.mRootView.findViewById(R.id.post_share_screen_shot);
        this.lCe = (TextView) this.mRootView.findViewById(R.id.post_share_qcode_comment);
        this.lCf = (TbImageView) this.mRootView.findViewById(R.id.post_share_qcode);
        dhu();
    }

    private void dhu() {
    }

    @Override // com.baidu.tieba.sharesdk.d.c
    protected View ceK() {
        return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.pb_post_share_dialog_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.sharesdk.d.c
    public ShareItem EH(int i) {
        ShareItem shareItem = this.lBN.get(1);
        if (shareItem == null) {
            shareItem = new ShareItem();
        }
        shareItem.euf = false;
        shareItem.eue = false;
        shareItem.content = "";
        shareItem.shareType = 1;
        shareItem.w(cR(this.lBU));
        shareItem.bgO();
        this.lBN.put(1, shareItem);
        return super.EH(i);
    }

    private Bitmap cR(View view) {
        if (view == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_4444);
        createBitmap.eraseColor(ao.getColor(R.color.cp_bg_line_g));
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    @Override // com.baidu.tieba.sharesdk.d.c
    public void show() {
        if (this.lBT != null) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
            int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            ao.c(this.lBU, dimens, R.color.cp_bg_line_g, R.color.cp_bg_line_g);
            ao.c(this.lCb, dimens2, R.color.cp_bg_line_d, R.color.cp_bg_line_d);
            ao.setImageResource(this.lBV, R.drawable.pic_pb_share_logo);
            ao.setViewTextColor(this.lBY, R.color.cp_cont_b);
            if (this.lBT.cLp()) {
                com.baidu.tbadk.core.util.e.a.bbr().ma(0).i(R.color.cp_mask_b_alpha0, R.color.cp_mask_b_alpha50).mf(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10)).aX(this.lBZ);
            }
            ao.setViewTextColor(this.lCc, R.color.cp_link_tip_a);
            ao.setViewTextColor(this.lCe, R.color.cp_cont_j);
            ao.setViewTextColor(this.lCa, R.color.cp_cont_a, 1);
            this.ixp.setImageDrawable(SvgManager.baR().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
            this.lBY.setText(this.lBT.getContent());
            if (StringUtils.isNull(this.lBT.getThreadImgUrl())) {
                this.lBW.setVisibility(8);
            } else {
                this.lBX.startLoad(this.lBT.getThreadImgUrl(), 10, false);
            }
            if (this.lBT.cLp()) {
                this.lCa.setText(this.lBT.cLo());
            } else {
                this.lBZ.setVisibility(8);
                this.ixp.setVisibility(8);
                this.lCa.setVisibility(8);
            }
            this.lCd.setImageBitmap(this.lBT.cLm());
            this.lCf.setImageBitmap(this.lBT.cLn());
            super.show();
        }
    }

    @Override // com.baidu.tieba.sharesdk.d.c
    protected void b(Window window) {
        window.setLayout(-1, -1);
    }
}
