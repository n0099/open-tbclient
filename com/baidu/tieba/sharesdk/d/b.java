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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.k;
/* loaded from: classes11.dex */
public class b extends c {
    private ImageView irl;
    private k luC;
    private View luD;
    private TbImageView luE;
    private View luF;
    private TbImageView luG;
    private TextView luH;
    private View luI;
    private TextView luJ;
    private View luK;
    private TextView luL;
    private ImageView luM;
    private TextView luN;
    private TbImageView luO;

    public b(Context context, boolean z, int i, k kVar) {
        super(context, z, i);
        this.luC = kVar;
        this.luD = this.mRootView.findViewById(R.id.pb_post_share_card);
        this.luE = (TbImageView) this.mRootView.findViewById(R.id.pb_post_share_title);
        this.luF = this.mRootView.findViewById(R.id.pb_share_origin_thread_img_container);
        this.luG = (TbImageView) this.mRootView.findViewById(R.id.pb_share_origin_thread_img);
        this.luG.setPlaceHolder(2);
        this.luG.setConrers(15);
        this.luG.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.luG.setGifIconSupport(false);
        this.luG.setLongIconSupport(false);
        this.luH = (TextView) this.mRootView.findViewById(R.id.origin_thread_abstract);
        this.luI = this.mRootView.findViewById(R.id.pb_share_origin_thread_gradient_mask);
        this.irl = (ImageView) this.mRootView.findViewById(R.id.pb_post_share_video_play_iv);
        this.luJ = (TextView) this.mRootView.findViewById(R.id.pb_post_video_during_time_tv);
        this.luK = this.mRootView.findViewById(R.id.pb_post_screen_shot_container);
        this.luL = (TextView) this.mRootView.findViewById(R.id.post_share_screen_shot_title);
        this.luM = (ImageView) this.mRootView.findViewById(R.id.post_share_screen_shot);
        this.luN = (TextView) this.mRootView.findViewById(R.id.post_share_qcode_comment);
        this.luO = (TbImageView) this.mRootView.findViewById(R.id.post_share_qcode);
        dek();
    }

    private void dek() {
    }

    @Override // com.baidu.tieba.sharesdk.d.c
    protected View cbl() {
        return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.pb_post_share_dialog_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.sharesdk.d.c
    public ShareItem El(int i) {
        ShareItem shareItem = this.luw.get(1);
        if (shareItem == null) {
            shareItem = new ShareItem();
        }
        shareItem.enT = false;
        shareItem.enS = false;
        shareItem.content = "";
        shareItem.shareType = 1;
        shareItem.t(cL(this.luD));
        shareItem.bdh();
        this.luw.put(1, shareItem);
        return super.El(i);
    }

    private Bitmap cL(View view) {
        if (view == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_4444);
        createBitmap.eraseColor(an.getColor(R.color.cp_bg_line_g));
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    @Override // com.baidu.tieba.sharesdk.d.c
    public void show() {
        if (this.luC != null) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
            int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            an.c(this.luD, dimens, R.color.cp_bg_line_g, R.color.cp_bg_line_g);
            an.c(this.luK, dimens2, R.color.cp_bg_line_d, R.color.cp_bg_line_d);
            an.setImageResource(this.luE, R.drawable.pic_pb_share_logo);
            an.setViewTextColor(this.luH, (int) R.color.cp_cont_b);
            if (this.luC.cHE()) {
                com.baidu.tbadk.core.util.e.a.aXq().lG(0).i(R.color.cp_mask_b_alpha0, R.color.cp_mask_b_alpha50).lL(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10)).aR(this.luI);
            }
            an.setViewTextColor(this.luL, (int) R.color.cp_link_tip_a);
            an.setViewTextColor(this.luN, (int) R.color.cp_cont_j);
            an.setViewTextColor(this.luJ, R.color.cp_cont_a, 1);
            this.irl.setImageDrawable(SvgManager.aWQ().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
            this.luH.setText(this.luC.getContent());
            if (StringUtils.isNull(this.luC.getThreadImgUrl())) {
                this.luF.setVisibility(8);
            } else {
                this.luG.startLoad(this.luC.getThreadImgUrl(), 10, false);
            }
            if (this.luC.cHE()) {
                this.luJ.setText(this.luC.cHD());
            } else {
                this.luI.setVisibility(8);
                this.irl.setVisibility(8);
                this.luJ.setVisibility(8);
            }
            this.luM.setImageBitmap(this.luC.cHB());
            this.luO.setImageBitmap(this.luC.cHC());
            super.show();
        }
    }

    @Override // com.baidu.tieba.sharesdk.d.c
    protected void a(Window window) {
        window.setLayout(-1, -1);
    }
}
