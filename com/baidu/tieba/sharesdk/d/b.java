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
    private ImageView jwj;
    private TbImageView mFA;
    private LinearLayout mFB;
    private TbImageView mFC;
    private TextView mFD;
    private View mFE;
    private TextView mFF;
    private TextView mFG;
    private TbImageView mFH;
    private View mFI;
    private TextView mFJ;
    private TextView mFK;
    private LinearLayout mFL;
    private PlayVoiceBntNew mFM;
    private m mFw;
    private View mFx;
    private View mFy;
    private View mFz;
    private View rootView;

    public b(Context context, boolean z, int i, m mVar) {
        super(context, z, i);
        this.mFw = mVar;
        this.rootView = this.mRootView.findViewById(R.id.pb_post_share_root_view);
        this.mFx = this.mRootView.findViewById(R.id.pb_post_share_card_container);
        this.mFy = this.mRootView.findViewById(R.id.pb_post_share_card);
        this.mFz = this.mRootView.findViewById(R.id.pb_post_share_card_content);
        this.mFA = (TbImageView) this.mRootView.findViewById(R.id.pb_post_share_title);
        this.mFB = (LinearLayout) this.mRootView.findViewById(R.id.pb_share_thread_container);
        this.mFC = (TbImageView) this.mRootView.findViewById(R.id.pb_share_origin_thread_img);
        this.mFC.setPlaceHolder(2);
        this.mFC.setConrers(15);
        this.mFC.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.mFC.setGifIconSupport(false);
        this.mFC.setLongIconSupport(false);
        this.mFD = (TextView) this.mRootView.findViewById(R.id.origin_thread_abstract);
        this.mFE = this.mRootView.findViewById(R.id.pb_share_origin_thread_gradient_mask);
        this.jwj = (ImageView) this.mRootView.findViewById(R.id.pb_post_share_video_play_iv);
        this.mFF = (TextView) this.mRootView.findViewById(R.id.post_share_screen_shot_title);
        this.mFG = (TextView) this.mRootView.findViewById(R.id.post_share_qcode_comment);
        this.mFH = (TbImageView) this.mRootView.findViewById(R.id.post_share_qcode);
        this.mFI = this.mRootView.findViewById(R.id.post_share_reply_user_id_guide_line);
        this.mFJ = (TextView) this.mRootView.findViewById(R.id.post_share_reply_user_id);
        this.mFK = (TextView) this.mRootView.findViewById(R.id.post_share_comment_text);
        this.mFL = (LinearLayout) this.mRootView.findViewById(R.id.post_share_comment_image_container);
        this.mFM = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.post_share_comment_voice);
        a(context, mVar.dgy().dHz());
        dDG();
    }

    private void dDG() {
    }

    @Override // com.baidu.tieba.sharesdk.d.c
    protected View czg() {
        return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.pb_post_share_dialog_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.sharesdk.d.c
    public ShareItem IG(int i) {
        ShareItem shareItem = this.mFq.get(1);
        if (shareItem == null) {
            shareItem = new ShareItem();
        }
        shareItem.fbs = false;
        shareItem.fbr = false;
        shareItem.content = "";
        shareItem.shareType = 1;
        shareItem.w(dB(this.mFx));
        shareItem.buX();
        this.mFq.put(1, shareItem);
        return super.IG(i);
    }

    private Bitmap dB(View view) {
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
        if (this.mFw != null) {
            this.rootView.setBackgroundColor(ap.getColor(R.color.cp_bg_line_j));
            ap.c(this.mFz, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds31), R.color.cp_bg_line_k, R.color.cp_bg_line_k);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            gradientDrawable.setColor(ap.getColor(R.color.cp_bg_line_g));
            this.mFB.setBackgroundDrawable(gradientDrawable);
            ap.setViewTextColor(this.mFD, R.color.cp_cont_j);
            this.mFD.setText(this.mFw.getContent());
            dDH();
            ap.setBackgroundColor(this.mFI, R.color.cp_cont_d);
            String name_show = this.mFw.dgy().bka().getName_show();
            if (name_show.length() > 10) {
                name_show = name_show.substring(0, 10) + StringHelper.STRING_MORE;
            }
            this.mFJ.setText(name_show);
            ap.setViewTextColor(this.mFJ, R.color.cp_cont_d);
            ap.setViewTextColor(this.mFF, R.color.cp_link_tip_c);
            ap.setViewTextColor(this.mFG, R.color.cp_cont_b);
            this.mFH.setImageBitmap(this.mFw.dgx());
            ap.setImageResource(this.mFA, R.drawable.pic_pb_post_share_logo);
            super.show();
        }
    }

    @Override // com.baidu.tieba.sharesdk.d.c
    protected void b(Window window) {
        window.setLayout(-1, -1);
    }

    private void dDH() {
        switch (this.mFw.getThreadType()) {
            case 0:
                if (!StringUtils.isNull(this.mFw.getThreadImgUrl())) {
                    this.mFC.startLoad(this.mFw.getThreadImgUrl(), 10, false);
                    return;
                }
                this.mFC.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_article_thread));
                this.mFC.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return;
            case 11:
                this.mFC.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_voice_thread));
                this.mFC.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return;
            case 40:
                this.mFE.setVisibility(0);
                this.jwj.setVisibility(0);
                this.jwj.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_voide_thread_play));
                com.baidu.tbadk.core.util.e.a.bpo().oZ(0).i(R.color.cp_mask_b_alpha0, R.color.cp_mask_b_alpha25).pe(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10)).bg(this.mFE);
                this.mFC.startLoad(this.mFw.getThreadImgUrl(), 10, false);
                return;
            default:
                return;
        }
    }

    public void a(Context context, TbRichText tbRichText) {
        if (tbRichText != null && tbRichText.bDj() != null && !tbRichText.bDj().isEmpty()) {
            Iterator<TbRichTextData> it = tbRichText.bDj().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null) {
                    switch (next.getType()) {
                        case 1:
                            if (this.mFK.getVisibility() == 8) {
                                ap.setViewTextColor(this.mFK, R.color.cp_cont_b);
                                this.mFK.setText(next.bDq());
                                this.mFK.setVisibility(0);
                                break;
                            } else {
                                continue;
                            }
                        case 512:
                            this.mFM.setVoiceModel((VoiceData.VoiceModel) next.bDr().bEl());
                            if (this.mFK.getVisibility() == 0 || this.mFL.getVisibility() == 0) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mFM.getLayoutParams();
                                if (this.mFK.getVisibility() == 0 && this.mFL.getVisibility() == 8) {
                                    layoutParams.topMargin = l.getDimens(context, R.dimen.tbds39);
                                } else {
                                    layoutParams.topMargin = l.getDimens(context, R.dimen.tbds42);
                                }
                                this.mFM.setLayoutParams(layoutParams);
                            }
                            this.mFM.setVisibility(0);
                            continue;
                    }
                }
            }
            if (!tbRichText.bDk().isEmpty()) {
                if (this.mFK.getVisibility() == 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mFL.getLayoutParams();
                    layoutParams2.topMargin = l.getDimens(context, R.dimen.tbds37);
                    this.mFL.setLayoutParams(layoutParams2);
                }
                this.mFL.setVisibility(0);
                if (fw(tbRichText.bDk())) {
                    this.mFL.addView(a(context, a(tbRichText.bDk().get(0), this.mFw.dgz()), tbRichText.bDk().get(0), true, this.mFw.dgz().mIsFromCDN));
                } else {
                    c(context, tbRichText.bDk());
                }
            }
        }
    }

    private void c(Context context, List<TbRichTextImageInfo> list) {
        int i = 0;
        while (i < list.size() && i != 3) {
            if (!list.get(i).bDK()) {
                this.mFL.addView(a(context, a(list.get(i), this.mFw.dgz()), list.get(i), i == 0, this.mFw.dgz().mIsFromCDN));
            }
            i++;
        }
    }

    private TbImageView a(Context context, String str, TbRichTextImageInfo tbRichTextImageInfo, boolean z, boolean z2) {
        int[] ad = ad(tbRichTextImageInfo.getWidth(), tbRichTextImageInfo.getHeight(), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds981));
        TbImageView tbImageView = new TbImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ad[0], ad[1]);
        if (!z) {
            layoutParams.setMargins(0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), 0, 0);
        }
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (tbRichTextImageInfo.bDK()) {
            tbImageView.setLongIconSupport(true);
            tbImageView.setIsLongPic(true);
        }
        tbImageView.setConrers(15);
        tbImageView.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        tbImageView.startLoad(str, z2 ? 17 : 18, false);
        return tbImageView;
    }

    private boolean fw(List<TbRichTextImageInfo> list) {
        for (TbRichTextImageInfo tbRichTextImageInfo : list) {
            if (!tbRichTextImageInfo.bDK()) {
                return false;
            }
        }
        return true;
    }

    private String a(TbRichTextImageInfo tbRichTextImageInfo, com.baidu.tbadk.widget.richText.a aVar) {
        return aVar.bDi() ? tbRichTextImageInfo.bDC() : tbRichTextImageInfo.bDF();
    }

    private int[] ad(int i, int i2, int i3) {
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
