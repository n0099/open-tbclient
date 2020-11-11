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
    private ImageView jCg;
    private View mLA;
    private TbImageView mLB;
    private LinearLayout mLC;
    private TbImageView mLD;
    private TextView mLE;
    private View mLF;
    private TextView mLG;
    private TextView mLH;
    private TbImageView mLI;
    private View mLJ;
    private TextView mLK;
    private TextView mLL;
    private LinearLayout mLM;
    private PlayVoiceBntNew mLN;
    private m mLx;
    private View mLy;
    private View mLz;
    private View rootView;

    public b(Context context, boolean z, int i, m mVar) {
        super(context, z, i);
        this.mLx = mVar;
        this.rootView = this.mRootView.findViewById(R.id.pb_post_share_root_view);
        this.mLy = this.mRootView.findViewById(R.id.pb_post_share_card_container);
        this.mLz = this.mRootView.findViewById(R.id.pb_post_share_card);
        this.mLA = this.mRootView.findViewById(R.id.pb_post_share_card_content);
        this.mLB = (TbImageView) this.mRootView.findViewById(R.id.pb_post_share_title);
        this.mLC = (LinearLayout) this.mRootView.findViewById(R.id.pb_share_thread_container);
        this.mLD = (TbImageView) this.mRootView.findViewById(R.id.pb_share_origin_thread_img);
        this.mLD.setPlaceHolder(2);
        this.mLD.setConrers(15);
        this.mLD.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.mLD.setGifIconSupport(false);
        this.mLD.setLongIconSupport(false);
        this.mLE = (TextView) this.mRootView.findViewById(R.id.origin_thread_abstract);
        this.mLF = this.mRootView.findViewById(R.id.pb_share_origin_thread_gradient_mask);
        this.jCg = (ImageView) this.mRootView.findViewById(R.id.pb_post_share_video_play_iv);
        this.mLG = (TextView) this.mRootView.findViewById(R.id.post_share_screen_shot_title);
        this.mLH = (TextView) this.mRootView.findViewById(R.id.post_share_qcode_comment);
        this.mLI = (TbImageView) this.mRootView.findViewById(R.id.post_share_qcode);
        this.mLJ = this.mRootView.findViewById(R.id.post_share_reply_user_id_guide_line);
        this.mLK = (TextView) this.mRootView.findViewById(R.id.post_share_reply_user_id);
        this.mLL = (TextView) this.mRootView.findViewById(R.id.post_share_comment_text);
        this.mLM = (LinearLayout) this.mRootView.findViewById(R.id.post_share_comment_image_container);
        this.mLN = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.post_share_comment_voice);
        a(context, mVar.dja().dKb());
        dGi();
    }

    private void dGi() {
    }

    @Override // com.baidu.tieba.sharesdk.d.c
    protected View cBH() {
        return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.pb_post_share_dialog_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.sharesdk.d.c
    public ShareItem IT(int i) {
        ShareItem shareItem = this.mLr.get(1);
        if (shareItem == null) {
            shareItem = new ShareItem();
        }
        shareItem.fhj = false;
        shareItem.fhi = false;
        shareItem.content = "";
        shareItem.shareType = 1;
        shareItem.w(dG(this.mLy));
        shareItem.bxw();
        this.mLr.put(1, shareItem);
        return super.IT(i);
    }

    private Bitmap dG(View view) {
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
        if (this.mLx != null) {
            this.rootView.setBackgroundColor(ap.getColor(R.color.cp_bg_line_j));
            ap.c(this.mLA, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds31), R.color.cp_bg_line_k, R.color.cp_bg_line_k);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            gradientDrawable.setColor(ap.getColor(R.color.cp_bg_line_g));
            this.mLC.setBackgroundDrawable(gradientDrawable);
            ap.setViewTextColor(this.mLE, (int) R.color.cp_cont_j);
            this.mLE.setText(this.mLx.getContent());
            dGj();
            ap.setBackgroundColor(this.mLJ, R.color.cp_cont_d);
            String name_show = this.mLx.dja().bmA().getName_show();
            if (name_show.length() > 10) {
                name_show = name_show.substring(0, 10) + StringHelper.STRING_MORE;
            }
            this.mLK.setText(name_show);
            ap.setViewTextColor(this.mLK, (int) R.color.cp_cont_d);
            ap.setViewTextColor(this.mLG, (int) R.color.cp_link_tip_c);
            ap.setViewTextColor(this.mLH, (int) R.color.cp_cont_b);
            this.mLI.setImageBitmap(this.mLx.diZ());
            ap.setImageResource(this.mLB, R.drawable.pic_pb_post_share_logo);
            super.show();
        }
    }

    @Override // com.baidu.tieba.sharesdk.d.c
    protected void b(Window window) {
        window.setLayout(-1, -1);
    }

    private void dGj() {
        switch (this.mLx.getThreadType()) {
            case 0:
                if (!StringUtils.isNull(this.mLx.getThreadImgUrl())) {
                    this.mLD.startLoad(this.mLx.getThreadImgUrl(), 10, false);
                    return;
                }
                this.mLD.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_article_thread));
                this.mLD.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return;
            case 11:
                this.mLD.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_voice_thread));
                this.mLD.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return;
            case 40:
                this.mLF.setVisibility(0);
                this.jCg.setVisibility(0);
                this.jCg.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_voide_thread_play));
                com.baidu.tbadk.core.util.e.a.brO().pj(0).i(R.color.cp_mask_b_alpha0, R.color.cp_mask_b_alpha25).pp(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10)).bk(this.mLF);
                this.mLD.startLoad(this.mLx.getThreadImgUrl(), 10, false);
                return;
            default:
                return;
        }
    }

    public void a(Context context, TbRichText tbRichText) {
        if (tbRichText != null && tbRichText.bFI() != null && !tbRichText.bFI().isEmpty()) {
            Iterator<TbRichTextData> it = tbRichText.bFI().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null) {
                    switch (next.getType()) {
                        case 1:
                            if (this.mLL.getVisibility() == 8) {
                                ap.setViewTextColor(this.mLL, (int) R.color.cp_cont_b);
                                this.mLL.setText(next.bFP());
                                this.mLL.setVisibility(0);
                                break;
                            } else {
                                continue;
                            }
                        case 512:
                            this.mLN.setVoiceModel((VoiceData.VoiceModel) next.bFQ().bGK());
                            if (this.mLL.getVisibility() == 0 || this.mLM.getVisibility() == 0) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mLN.getLayoutParams();
                                if (this.mLL.getVisibility() == 0 && this.mLM.getVisibility() == 8) {
                                    layoutParams.topMargin = l.getDimens(context, R.dimen.tbds39);
                                } else {
                                    layoutParams.topMargin = l.getDimens(context, R.dimen.tbds42);
                                }
                                this.mLN.setLayoutParams(layoutParams);
                            }
                            this.mLN.setVisibility(0);
                            continue;
                    }
                }
            }
            if (!tbRichText.bFJ().isEmpty()) {
                if (this.mLL.getVisibility() == 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mLM.getLayoutParams();
                    layoutParams2.topMargin = l.getDimens(context, R.dimen.tbds37);
                    this.mLM.setLayoutParams(layoutParams2);
                }
                this.mLM.setVisibility(0);
                if (fE(tbRichText.bFJ())) {
                    this.mLM.addView(a(context, a(tbRichText.bFJ().get(0), this.mLx.djb()), tbRichText.bFJ().get(0), true, this.mLx.djb().mIsFromCDN));
                } else {
                    c(context, tbRichText.bFJ());
                }
            }
        }
    }

    private void c(Context context, List<TbRichTextImageInfo> list) {
        int i = 0;
        while (i < list.size() && i != 3) {
            if (!list.get(i).bGj()) {
                this.mLM.addView(a(context, a(list.get(i), this.mLx.djb()), list.get(i), i == 0, this.mLx.djb().mIsFromCDN));
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
        if (tbRichTextImageInfo.bGj()) {
            tbImageView.setLongIconSupport(true);
            tbImageView.setIsLongPic(true);
        }
        tbImageView.setConrers(15);
        tbImageView.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        tbImageView.startLoad(str, z2 ? 17 : 18, false);
        return tbImageView;
    }

    private boolean fE(List<TbRichTextImageInfo> list) {
        for (TbRichTextImageInfo tbRichTextImageInfo : list) {
            if (!tbRichTextImageInfo.bGj()) {
                return false;
            }
        }
        return true;
    }

    private String a(TbRichTextImageInfo tbRichTextImageInfo, com.baidu.tbadk.widget.richText.a aVar) {
        return aVar.bFH() ? tbRichTextImageInfo.bGb() : tbRichTextImageInfo.bGe();
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
