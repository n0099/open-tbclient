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
    private ImageView jHY;
    private TextView kZA;
    private View kZB;
    private TextView kZC;
    private View kZD;
    private TextView kZE;
    private ImageView kZF;
    private TextView kZG;
    private TbImageView kZH;
    private k kZv;
    private View kZw;
    private TbImageView kZx;
    private View kZy;
    private TbImageView kZz;

    public b(Context context, boolean z, int i, k kVar) {
        super(context, z, i);
        this.kZv = kVar;
        this.kZw = this.mRootView.findViewById(R.id.pb_post_share_card);
        this.kZx = (TbImageView) this.mRootView.findViewById(R.id.pb_post_share_title);
        this.kZy = this.mRootView.findViewById(R.id.pb_share_origin_thread_img_container);
        this.kZz = (TbImageView) this.mRootView.findViewById(R.id.pb_share_origin_thread_img);
        this.kZz.setPlaceHolder(2);
        this.kZz.setConrers(15);
        this.kZz.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.kZz.setGifIconSupport(false);
        this.kZz.setLongIconSupport(false);
        this.kZA = (TextView) this.mRootView.findViewById(R.id.origin_thread_abstract);
        this.kZB = this.mRootView.findViewById(R.id.pb_share_origin_thread_gradient_mask);
        this.jHY = (ImageView) this.mRootView.findViewById(R.id.pb_post_share_video_play_iv);
        this.kZC = (TextView) this.mRootView.findViewById(R.id.pb_post_video_during_time_tv);
        this.kZD = this.mRootView.findViewById(R.id.pb_post_screen_shot_container);
        this.kZE = (TextView) this.mRootView.findViewById(R.id.post_share_screen_shot_title);
        this.kZF = (ImageView) this.mRootView.findViewById(R.id.post_share_screen_shot);
        this.kZG = (TextView) this.mRootView.findViewById(R.id.post_share_qcode_comment);
        this.kZH = (TbImageView) this.mRootView.findViewById(R.id.post_share_qcode);
        cZE();
    }

    private void cZE() {
    }

    @Override // com.baidu.tieba.sharesdk.d.c
    protected View bXU() {
        return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.pb_post_share_dialog_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.sharesdk.d.c
    public ShareItem Dh(int i) {
        ShareItem shareItem = this.kZp.get(1);
        if (shareItem == null) {
            shareItem = new ShareItem();
        }
        shareItem.efi = false;
        shareItem.efh = false;
        shareItem.content = "";
        shareItem.shareType = 1;
        shareItem.s(cK(this.kZw));
        shareItem.bbe();
        this.kZp.put(1, shareItem);
        return super.Dh(i);
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
        if (this.kZv != null) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
            int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            am.c(this.kZw, dimens, R.color.cp_bg_line_g, R.color.cp_bg_line_g);
            am.c(this.kZD, dimens2, R.color.cp_bg_line_d, R.color.cp_bg_line_d);
            am.setImageResource(this.kZx, R.drawable.pic_pb_share_logo);
            am.setViewTextColor(this.kZA, (int) R.color.cp_cont_b);
            if (this.kZv.cCY()) {
                com.baidu.tbadk.core.util.e.a.aVv().ln(0).i(R.color.cp_mask_b_alpha0, R.color.cp_mask_b_alpha50).ls(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10)).aR(this.kZB);
            }
            am.setViewTextColor(this.kZE, (int) R.color.cp_link_tip_a);
            am.setViewTextColor(this.kZG, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.kZC, R.color.cp_cont_a, 1);
            this.jHY.setImageDrawable(SvgManager.aUV().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
            this.kZA.setText(this.kZv.getContent());
            if (StringUtils.isNull(this.kZv.getThreadImgUrl())) {
                this.kZy.setVisibility(8);
            } else {
                this.kZz.startLoad(this.kZv.getThreadImgUrl(), 10, false);
            }
            if (this.kZv.cCY()) {
                this.kZC.setText(this.kZv.cCX());
            } else {
                this.kZB.setVisibility(8);
                this.jHY.setVisibility(8);
                this.kZC.setVisibility(8);
            }
            this.kZF.setImageBitmap(this.kZv.cCV());
            this.kZH.setImageBitmap(this.kZv.cCW());
            super.show();
        }
    }

    @Override // com.baidu.tieba.sharesdk.d.c
    protected void a(Window window) {
        window.setLayout(-1, -1);
    }
}
