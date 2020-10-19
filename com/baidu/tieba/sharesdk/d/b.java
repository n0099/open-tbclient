package com.baidu.tieba.sharesdk.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.m;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes24.dex */
public class b extends c {
    private ImageView jjM;
    private m msR;
    private View msS;
    private View msT;
    private View msU;
    private TbImageView msV;
    private LinearLayout msW;
    private TbImageView msX;
    private TextView msY;
    private View msZ;
    private TextView mta;
    private TextView mtb;
    private TbImageView mtc;
    private View mtd;
    private TextView mte;
    private TextView mtf;
    private LinearLayout mtg;
    private PlayVoiceBntNew mth;
    private View rootView;

    public b(Context context, boolean z, int i, m mVar) {
        super(context, z, i);
        this.msR = mVar;
        this.rootView = this.mRootView.findViewById(R.id.pb_post_share_root_view);
        this.msS = this.mRootView.findViewById(R.id.pb_post_share_card_container);
        this.msT = this.mRootView.findViewById(R.id.pb_post_share_card);
        this.msU = this.mRootView.findViewById(R.id.pb_post_share_card_content);
        this.msV = (TbImageView) this.mRootView.findViewById(R.id.pb_post_share_title);
        this.msW = (LinearLayout) this.mRootView.findViewById(R.id.pb_share_thread_container);
        this.msX = (TbImageView) this.mRootView.findViewById(R.id.pb_share_origin_thread_img);
        this.msX.setPlaceHolder(2);
        this.msX.setConrers(15);
        this.msX.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.msX.setGifIconSupport(false);
        this.msX.setLongIconSupport(false);
        this.msY = (TextView) this.mRootView.findViewById(R.id.origin_thread_abstract);
        this.msZ = this.mRootView.findViewById(R.id.pb_share_origin_thread_gradient_mask);
        this.jjM = (ImageView) this.mRootView.findViewById(R.id.pb_post_share_video_play_iv);
        this.mta = (TextView) this.mRootView.findViewById(R.id.post_share_screen_shot_title);
        this.mtb = (TextView) this.mRootView.findViewById(R.id.post_share_qcode_comment);
        this.mtc = (TbImageView) this.mRootView.findViewById(R.id.post_share_qcode);
        this.mtd = this.mRootView.findViewById(R.id.post_share_reply_user_id_guide_line);
        this.mte = (TextView) this.mRootView.findViewById(R.id.post_share_reply_user_id);
        this.mtf = (TextView) this.mRootView.findViewById(R.id.post_share_comment_text);
        this.mtg = (LinearLayout) this.mRootView.findViewById(R.id.post_share_comment_image_container);
        this.mth = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.post_share_comment_voice);
        a(context, mVar.ddq().dEr());
        dAy();
    }

    private void dAy() {
    }

    @Override // com.baidu.tieba.sharesdk.d.c
    protected View cvZ() {
        return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.pb_post_share_dialog_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.sharesdk.d.c
    public ShareItem In(int i) {
        ShareItem shareItem = this.msL.get(1);
        if (shareItem == null) {
            shareItem = new ShareItem();
        }
        shareItem.eSW = false;
        shareItem.eSV = false;
        shareItem.content = "";
        shareItem.shareType = 1;
        shareItem.w(dx(this.msS));
        shareItem.bte();
        this.msL.put(1, shareItem);
        return super.In(i);
    }

    private Bitmap dx(View view) {
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
        if (this.msR != null) {
            this.rootView.setBackgroundColor(ap.getColor(R.color.cp_bg_line_j));
            ap.c(this.msU, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds31), R.color.cp_bg_line_k, R.color.cp_bg_line_k);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            gradientDrawable.setColor(ap.getColor(R.color.cp_bg_line_g));
            this.msW.setBackgroundDrawable(gradientDrawable);
            ap.setViewTextColor(this.msY, R.color.cp_cont_j);
            this.msY.setText(this.msR.getContent());
            dAz();
            ap.setBackgroundColor(this.mtd, R.color.cp_cont_d);
            String name_show = this.msR.ddq().bih().getName_show();
            if (name_show.length() > 10) {
                name_show = name_show.substring(0, 10) + StringHelper.STRING_MORE;
            }
            this.mte.setText(name_show);
            ap.setViewTextColor(this.mte, R.color.cp_cont_d);
            ap.setViewTextColor(this.mta, R.color.cp_link_tip_c);
            ap.setViewTextColor(this.mtb, R.color.cp_cont_b);
            this.mtc.setImageBitmap(this.msR.ddp());
            ap.setImageResource(this.msV, R.drawable.pic_pb_post_share_logo);
            super.show();
        }
    }

    @Override // com.baidu.tieba.sharesdk.d.c
    protected void b(Window window) {
        window.setLayout(-1, -1);
    }

    private void dAz() {
        switch (this.msR.getThreadType()) {
            case 0:
                if (!StringUtils.isNull(this.msR.getThreadImgUrl())) {
                    this.msX.startLoad(this.msR.getThreadImgUrl(), 10, false);
                    return;
                }
                this.msX.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_article_thread));
                this.msX.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return;
            case 11:
                this.msX.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_voice_thread));
                this.msX.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return;
            case 40:
                this.msZ.setVisibility(0);
                this.jjM.setVisibility(0);
                this.jjM.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_voide_thread_play));
                com.baidu.tbadk.core.util.e.a.bnv().oO(0).i(R.color.cp_mask_b_alpha0, R.color.cp_mask_b_alpha25).oT(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10)).bf(this.msZ);
                this.msX.startLoad(this.msR.getThreadImgUrl(), 10, false);
                return;
            default:
                return;
        }
    }

    public void a(Context context, TbRichText tbRichText) {
        if (tbRichText != null && tbRichText.bBq() != null && !tbRichText.bBq().isEmpty()) {
            Iterator<TbRichTextData> it = tbRichText.bBq().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null) {
                    switch (next.getType()) {
                        case 1:
                            if (this.mtf.getVisibility() == 8) {
                                ap.setViewTextColor(this.mtf, R.color.cp_cont_b);
                                this.mtf.setText(next.bBx());
                                this.mtf.setVisibility(0);
                                break;
                            } else {
                                continue;
                            }
                        case 512:
                            this.mth.setVoiceModel((VoiceData.VoiceModel) next.bBy().bCs());
                            if (this.mtf.getVisibility() == 0 || this.mtg.getVisibility() == 0) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mth.getLayoutParams();
                                if (this.mtf.getVisibility() == 0 && this.mtg.getVisibility() == 8) {
                                    layoutParams.topMargin = l.getDimens(context, R.dimen.tbds39);
                                } else {
                                    layoutParams.topMargin = l.getDimens(context, R.dimen.tbds42);
                                }
                                this.mth.setLayoutParams(layoutParams);
                            }
                            this.mth.setVisibility(0);
                            continue;
                    }
                }
            }
            if (!tbRichText.bBr().isEmpty()) {
                if (this.mtf.getVisibility() == 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mtg.getLayoutParams();
                    layoutParams2.topMargin = l.getDimens(context, R.dimen.tbds37);
                    this.mtg.setLayoutParams(layoutParams2);
                }
                this.mtg.setVisibility(0);
                if (fn(tbRichText.bBr())) {
                    this.mtg.addView(a(context, a(tbRichText.bBr().get(0), this.msR.ddr()), tbRichText.bBr().get(0), true, this.msR.ddr().mIsFromCDN));
                } else {
                    c(context, tbRichText.bBr());
                }
            }
        }
    }

    private void c(Context context, List<TbRichTextImageInfo> list) {
        int i = 0;
        while (i < list.size() && i != 3) {
            if (!list.get(i).bBR()) {
                this.mtg.addView(a(context, a(list.get(i), this.msR.ddr()), list.get(i), i == 0, this.msR.ddr().mIsFromCDN));
            }
            i++;
        }
    }

    private TbImageView a(Context context, String str, TbRichTextImageInfo tbRichTextImageInfo, boolean z, boolean z2) {
        int[] ac = ac(tbRichTextImageInfo.getWidth(), tbRichTextImageInfo.getHeight(), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds981));
        TbImageView tbImageView = new TbImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ac[0], ac[1]);
        if (!z) {
            layoutParams.setMargins(0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), 0, 0);
        }
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (tbRichTextImageInfo.bBR()) {
            tbImageView.setLongIconSupport(true);
            tbImageView.setIsLongPic(true);
        }
        tbImageView.setConrers(15);
        tbImageView.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        tbImageView.startLoad(str, z2 ? 17 : 18, false);
        return tbImageView;
    }

    private boolean fn(List<TbRichTextImageInfo> list) {
        for (TbRichTextImageInfo tbRichTextImageInfo : list) {
            if (!tbRichTextImageInfo.bBR()) {
                return false;
            }
        }
        return true;
    }

    private String a(TbRichTextImageInfo tbRichTextImageInfo, com.baidu.tbadk.widget.richText.a aVar) {
        return aVar.bBp() ? tbRichTextImageInfo.bBJ() : tbRichTextImageInfo.bBM();
    }

    private int[] ac(int i, int i2, int i3) {
        int i4;
        int[] iArr = new int[2];
        iArr[0] = i3;
        float f = (i * 1.0f) / (i3 * 1.0f);
        if (f <= 1.0f) {
            i4 = (int) (i2 / f);
        } else {
            i4 = (int) (f * i2);
        }
        iArr[1] = i4;
        return iArr;
    }
}
