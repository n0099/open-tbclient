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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.k;
/* loaded from: classes11.dex */
public class b extends c {
    private ImageView jJe;
    private k laF;
    private View laG;
    private TbImageView laH;
    private View laI;
    private TbImageView laJ;
    private TextView laK;
    private View laL;
    private TextView laM;
    private View laN;
    private TextView laO;
    private ImageView laP;
    private TextView laQ;
    private TbImageView laR;

    public b(Context context, boolean z, int i, k kVar) {
        super(context, z, i);
        this.laF = kVar;
        this.laG = this.mRootView.findViewById(R.id.pb_post_share_card);
        this.laH = (TbImageView) this.mRootView.findViewById(R.id.pb_post_share_title);
        this.laI = this.mRootView.findViewById(R.id.pb_share_origin_thread_img_container);
        this.laJ = (TbImageView) this.mRootView.findViewById(R.id.pb_share_origin_thread_img);
        this.laJ.setPlaceHolder(2);
        this.laJ.setConrers(15);
        this.laJ.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.laJ.setGifIconSupport(false);
        this.laJ.setLongIconSupport(false);
        this.laK = (TextView) this.mRootView.findViewById(R.id.origin_thread_abstract);
        this.laL = this.mRootView.findViewById(R.id.pb_share_origin_thread_gradient_mask);
        this.jJe = (ImageView) this.mRootView.findViewById(R.id.pb_post_share_video_play_iv);
        this.laM = (TextView) this.mRootView.findViewById(R.id.pb_post_video_during_time_tv);
        this.laN = this.mRootView.findViewById(R.id.pb_post_screen_shot_container);
        this.laO = (TextView) this.mRootView.findViewById(R.id.post_share_screen_shot_title);
        this.laP = (ImageView) this.mRootView.findViewById(R.id.post_share_screen_shot);
        this.laQ = (TextView) this.mRootView.findViewById(R.id.post_share_qcode_comment);
        this.laR = (TbImageView) this.mRootView.findViewById(R.id.post_share_qcode);
        cZU();
    }

    private void cZU() {
    }

    @Override // com.baidu.tieba.sharesdk.d.c
    protected View bXX() {
        return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.pb_post_share_dialog_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.sharesdk.d.c
    public ShareItem Dj(int i) {
        ShareItem shareItem = this.laz.get(1);
        if (shareItem == null) {
            shareItem = new ShareItem();
        }
        shareItem.efi = false;
        shareItem.efh = false;
        shareItem.content = "";
        shareItem.shareType = 1;
        shareItem.s(cK(this.laG));
        shareItem.bbf();
        this.laz.put(1, shareItem);
        return super.Dj(i);
    }

    private Bitmap cK(View view) {
        if (view == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_4444);
        createBitmap.eraseColor(am.getColor(R.color.cp_bg_line_g));
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    @Override // com.baidu.tieba.sharesdk.d.c
    public void show() {
        if (this.laF != null) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
            int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            am.c(this.laG, dimens, R.color.cp_bg_line_g, R.color.cp_bg_line_g);
            am.c(this.laN, dimens2, R.color.cp_bg_line_d, R.color.cp_bg_line_d);
            am.setImageResource(this.laH, R.drawable.pic_pb_share_logo);
            am.setViewTextColor(this.laK, (int) R.color.cp_cont_b);
            if (this.laF.cDo()) {
                com.baidu.tbadk.core.util.e.a.aVw().lp(0).i(R.color.cp_mask_b_alpha0, R.color.cp_mask_b_alpha50).lu(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10)).aR(this.laL);
            }
            am.setViewTextColor(this.laO, (int) R.color.cp_link_tip_a);
            am.setViewTextColor(this.laQ, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.laM, R.color.cp_cont_a, 1);
            this.jJe.setImageDrawable(SvgManager.aUW().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
            this.laK.setText(this.laF.getContent());
            if (StringUtils.isNull(this.laF.getThreadImgUrl())) {
                this.laI.setVisibility(8);
            } else {
                this.laJ.startLoad(this.laF.getThreadImgUrl(), 10, false);
            }
            if (this.laF.cDo()) {
                this.laM.setText(this.laF.cDn());
            } else {
                this.laL.setVisibility(8);
                this.jJe.setVisibility(8);
                this.laM.setVisibility(8);
            }
            this.laP.setImageBitmap(this.laF.cDl());
            this.laR.setImageBitmap(this.laF.cDm());
            super.show();
        }
    }

    @Override // com.baidu.tieba.sharesdk.d.c
    protected void a(Window window) {
        window.setLayout(-1, -1);
    }
}
