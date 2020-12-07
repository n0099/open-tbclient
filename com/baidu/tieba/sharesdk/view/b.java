package com.baidu.tieba.sharesdk.view;

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
    private ImageView jQF;
    private m naj;
    private View nak;
    private View nal;
    private View nam;
    private TbImageView nan;
    private LinearLayout nao;
    private TbImageView nap;
    private TextView naq;
    private View nar;
    private TextView nas;
    private TextView nat;
    private TbImageView nau;
    private View nav;
    private TextView naw;
    private TextView nax;
    private LinearLayout nay;
    private PlayVoiceBntNew naz;
    private View rootView;

    public b(Context context, boolean z, int i, m mVar) {
        super(context, z, i);
        this.naj = mVar;
        this.rootView = this.mRootView.findViewById(R.id.pb_post_share_root_view);
        this.nak = this.mRootView.findViewById(R.id.pb_post_share_card_container);
        this.nal = this.mRootView.findViewById(R.id.pb_post_share_card);
        this.nam = this.mRootView.findViewById(R.id.pb_post_share_card_content);
        this.nan = (TbImageView) this.mRootView.findViewById(R.id.pb_post_share_title);
        this.nao = (LinearLayout) this.mRootView.findViewById(R.id.pb_share_thread_container);
        this.nap = (TbImageView) this.mRootView.findViewById(R.id.pb_share_origin_thread_img);
        this.nap.setPlaceHolder(2);
        this.nap.setConrers(15);
        this.nap.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.nap.setGifIconSupport(false);
        this.nap.setLongIconSupport(false);
        this.naq = (TextView) this.mRootView.findViewById(R.id.origin_thread_abstract);
        this.nar = this.mRootView.findViewById(R.id.pb_share_origin_thread_gradient_mask);
        this.jQF = (ImageView) this.mRootView.findViewById(R.id.pb_post_share_video_play_iv);
        this.nas = (TextView) this.mRootView.findViewById(R.id.post_share_screen_shot_title);
        this.nat = (TextView) this.mRootView.findViewById(R.id.post_share_qcode_comment);
        this.nau = (TbImageView) this.mRootView.findViewById(R.id.post_share_qcode);
        this.nav = this.mRootView.findViewById(R.id.post_share_reply_user_id_guide_line);
        this.naw = (TextView) this.mRootView.findViewById(R.id.post_share_reply_user_id);
        this.nax = (TextView) this.mRootView.findViewById(R.id.post_share_comment_text);
        this.nay = (LinearLayout) this.mRootView.findViewById(R.id.post_share_comment_image_container);
        this.naz = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.post_share_comment_voice);
        a(context, mVar.dnM().dPi());
        dLk();
        Kt(2);
    }

    private void dLk() {
    }

    @Override // com.baidu.tieba.sharesdk.view.c
    protected View cFA() {
        return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.pb_post_share_dialog_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.sharesdk.view.c
    public ShareItem Kl(int i) {
        ShareItem shareItem = this.nad.get(1);
        if (shareItem == null) {
            shareItem = new ShareItem();
        }
        shareItem.fnR = false;
        shareItem.fnQ = false;
        shareItem.content = "";
        shareItem.shareType = 1;
        shareItem.w(dY(this.nak));
        shareItem.bAm();
        this.nad.put(1, shareItem);
        return super.Kl(i);
    }

    private Bitmap dY(View view) {
        if (view == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_4444);
        createBitmap.eraseColor(ap.getColor(R.color.CAM_X0206));
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    @Override // com.baidu.tieba.sharesdk.view.c
    public void show() {
        if (this.naj != null) {
            this.rootView.setBackgroundColor(ap.getColor(R.color.CAM_X0209));
            ap.d(this.nam, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds31), R.color.CAM_X0211, R.color.CAM_X0211);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            gradientDrawable.setColor(ap.getColor(R.color.CAM_X0206));
            this.nao.setBackgroundDrawable(gradientDrawable);
            ap.setViewTextColor(this.naq, R.color.CAM_X0107);
            this.naq.setText(this.naj.getContent());
            dLl();
            ap.setBackgroundColor(this.nav, R.color.CAM_X0109);
            String name_show = this.naj.dnM().boP().getName_show();
            if (name_show.length() > 10) {
                name_show = name_show.substring(0, 10) + StringHelper.STRING_MORE;
            }
            this.naw.setText(name_show);
            ap.setViewTextColor(this.naw, R.color.CAM_X0109);
            ap.setViewTextColor(this.nas, R.color.CAM_X0304);
            ap.setViewTextColor(this.nat, R.color.CAM_X0105);
            this.nau.setImageBitmap(this.naj.dnL());
            ap.setImageResource(this.nan, R.drawable.pic_pb_post_share_logo);
            xH(false);
            super.show();
        }
    }

    @Override // com.baidu.tieba.sharesdk.view.c
    protected void b(Window window) {
        window.setLayout(-1, -1);
    }

    private void dLl() {
        switch (this.naj.getThreadType()) {
            case 0:
                if (!StringUtils.isNull(this.naj.getThreadImgUrl())) {
                    this.nap.startLoad(this.naj.getThreadImgUrl(), 10, false);
                    return;
                }
                this.nap.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_article_thread));
                this.nap.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return;
            case 11:
                this.nap.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_voice_thread));
                this.nap.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return;
            case 40:
                this.nar.setVisibility(0);
                this.jQF.setVisibility(0);
                this.jQF.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_voide_thread_play));
                com.baidu.tbadk.core.util.e.a.buz().qf(0).l(R.color.CAM_X0601, R.color.CAM_X0604).qm(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10)).bq(this.nar);
                this.nap.startLoad(this.naj.getThreadImgUrl(), 10, false);
                return;
            default:
                return;
        }
    }

    public void a(Context context, TbRichText tbRichText) {
        if (tbRichText != null && tbRichText.bIC() != null && !tbRichText.bIC().isEmpty()) {
            Iterator<TbRichTextData> it = tbRichText.bIC().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null) {
                    switch (next.getType()) {
                        case 1:
                            if (this.nax.getVisibility() == 8) {
                                ap.setViewTextColor(this.nax, R.color.CAM_X0105);
                                this.nax.setText(next.bIJ());
                                this.nax.setVisibility(0);
                                break;
                            } else {
                                continue;
                            }
                        case 512:
                            this.naz.setVoiceModel((VoiceData.VoiceModel) next.bIK().bJD());
                            if (this.nax.getVisibility() == 0 || this.nay.getVisibility() == 0) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.naz.getLayoutParams();
                                if (this.nax.getVisibility() == 0 && this.nay.getVisibility() == 8) {
                                    layoutParams.topMargin = l.getDimens(context, R.dimen.tbds39);
                                } else {
                                    layoutParams.topMargin = l.getDimens(context, R.dimen.tbds42);
                                }
                                this.naz.setLayoutParams(layoutParams);
                            }
                            this.naz.setVisibility(0);
                            continue;
                    }
                }
            }
            if (!tbRichText.bID().isEmpty()) {
                if (this.nax.getVisibility() == 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.nay.getLayoutParams();
                    layoutParams2.topMargin = l.getDimens(context, R.dimen.tbds37);
                    this.nay.setLayoutParams(layoutParams2);
                }
                this.nay.setVisibility(0);
                if (fS(tbRichText.bID())) {
                    this.nay.addView(a(context, a(tbRichText.bID().get(0), this.naj.dnN()), tbRichText.bID().get(0), true, this.naj.dnN().mIsFromCDN));
                } else {
                    c(context, tbRichText.bID());
                }
            }
        }
    }

    private void c(Context context, List<TbRichTextImageInfo> list) {
        int i = 0;
        while (i < list.size() && i != 3) {
            if (!list.get(i).bJc()) {
                this.nay.addView(a(context, a(list.get(i), this.naj.dnN()), list.get(i), i == 0, this.naj.dnN().mIsFromCDN));
            }
            i++;
        }
    }

    private TbImageView a(Context context, String str, TbRichTextImageInfo tbRichTextImageInfo, boolean z, boolean z2) {
        int[] ae = ae(tbRichTextImageInfo.getWidth(), tbRichTextImageInfo.getHeight(), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds981));
        TbImageView tbImageView = new TbImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ae[0], ae[1]);
        if (!z) {
            layoutParams.setMargins(0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), 0, 0);
        }
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (tbRichTextImageInfo.bJc()) {
            tbImageView.setLongIconSupport(true);
            tbImageView.setIsLongPic(true);
        }
        tbImageView.setConrers(15);
        tbImageView.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        tbImageView.startLoad(str, z2 ? 17 : 18, false);
        return tbImageView;
    }

    private boolean fS(List<TbRichTextImageInfo> list) {
        for (TbRichTextImageInfo tbRichTextImageInfo : list) {
            if (!tbRichTextImageInfo.bJc()) {
                return false;
            }
        }
        return true;
    }

    private String a(TbRichTextImageInfo tbRichTextImageInfo, com.baidu.tbadk.widget.richText.a aVar) {
        return aVar.bIB() ? tbRichTextImageInfo.bIU() : tbRichTextImageInfo.bIX();
    }

    private int[] ae(int i, int i2, int i3) {
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
