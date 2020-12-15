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
    private ImageView jQH;
    private LinearLayout naA;
    private PlayVoiceBntNew naB;
    private m nal;
    private View nam;
    private View nan;
    private View nao;
    private TbImageView nap;
    private LinearLayout naq;
    private TbImageView nar;
    private TextView nas;
    private View nat;
    private TextView nau;
    private TextView nav;
    private TbImageView naw;
    private View nax;
    private TextView nay;
    private TextView naz;
    private View rootView;

    public b(Context context, boolean z, int i, m mVar) {
        super(context, z, i);
        this.nal = mVar;
        this.rootView = this.mRootView.findViewById(R.id.pb_post_share_root_view);
        this.nam = this.mRootView.findViewById(R.id.pb_post_share_card_container);
        this.nan = this.mRootView.findViewById(R.id.pb_post_share_card);
        this.nao = this.mRootView.findViewById(R.id.pb_post_share_card_content);
        this.nap = (TbImageView) this.mRootView.findViewById(R.id.pb_post_share_title);
        this.naq = (LinearLayout) this.mRootView.findViewById(R.id.pb_share_thread_container);
        this.nar = (TbImageView) this.mRootView.findViewById(R.id.pb_share_origin_thread_img);
        this.nar.setPlaceHolder(2);
        this.nar.setConrers(15);
        this.nar.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.nar.setGifIconSupport(false);
        this.nar.setLongIconSupport(false);
        this.nas = (TextView) this.mRootView.findViewById(R.id.origin_thread_abstract);
        this.nat = this.mRootView.findViewById(R.id.pb_share_origin_thread_gradient_mask);
        this.jQH = (ImageView) this.mRootView.findViewById(R.id.pb_post_share_video_play_iv);
        this.nau = (TextView) this.mRootView.findViewById(R.id.post_share_screen_shot_title);
        this.nav = (TextView) this.mRootView.findViewById(R.id.post_share_qcode_comment);
        this.naw = (TbImageView) this.mRootView.findViewById(R.id.post_share_qcode);
        this.nax = this.mRootView.findViewById(R.id.post_share_reply_user_id_guide_line);
        this.nay = (TextView) this.mRootView.findViewById(R.id.post_share_reply_user_id);
        this.naz = (TextView) this.mRootView.findViewById(R.id.post_share_comment_text);
        this.naA = (LinearLayout) this.mRootView.findViewById(R.id.post_share_comment_image_container);
        this.naB = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.post_share_comment_voice);
        a(context, mVar.dnN().dPj());
        dLl();
        Kt(2);
    }

    private void dLl() {
    }

    @Override // com.baidu.tieba.sharesdk.view.c
    protected View cFB() {
        return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.pb_post_share_dialog_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.sharesdk.view.c
    public ShareItem Kl(int i) {
        ShareItem shareItem = this.naf.get(1);
        if (shareItem == null) {
            shareItem = new ShareItem();
        }
        shareItem.fnR = false;
        shareItem.fnQ = false;
        shareItem.content = "";
        shareItem.shareType = 1;
        shareItem.w(dY(this.nam));
        shareItem.bAm();
        this.naf.put(1, shareItem);
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
        if (this.nal != null) {
            this.rootView.setBackgroundColor(ap.getColor(R.color.CAM_X0209));
            ap.d(this.nao, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds31), R.color.CAM_X0211, R.color.CAM_X0211);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            gradientDrawable.setColor(ap.getColor(R.color.CAM_X0206));
            this.naq.setBackgroundDrawable(gradientDrawable);
            ap.setViewTextColor(this.nas, (int) R.color.CAM_X0107);
            this.nas.setText(this.nal.getContent());
            dLm();
            ap.setBackgroundColor(this.nax, R.color.CAM_X0109);
            String name_show = this.nal.dnN().boP().getName_show();
            if (name_show.length() > 10) {
                name_show = name_show.substring(0, 10) + StringHelper.STRING_MORE;
            }
            this.nay.setText(name_show);
            ap.setViewTextColor(this.nay, (int) R.color.CAM_X0109);
            ap.setViewTextColor(this.nau, (int) R.color.CAM_X0304);
            ap.setViewTextColor(this.nav, (int) R.color.CAM_X0105);
            this.naw.setImageBitmap(this.nal.dnM());
            ap.setImageResource(this.nap, R.drawable.pic_pb_post_share_logo);
            xH(false);
            super.show();
        }
    }

    @Override // com.baidu.tieba.sharesdk.view.c
    protected void b(Window window) {
        window.setLayout(-1, -1);
    }

    private void dLm() {
        switch (this.nal.getThreadType()) {
            case 0:
                if (!StringUtils.isNull(this.nal.getThreadImgUrl())) {
                    this.nar.startLoad(this.nal.getThreadImgUrl(), 10, false);
                    return;
                }
                this.nar.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_article_thread));
                this.nar.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return;
            case 11:
                this.nar.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_voice_thread));
                this.nar.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return;
            case 40:
                this.nat.setVisibility(0);
                this.jQH.setVisibility(0);
                this.jQH.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_voide_thread_play));
                com.baidu.tbadk.core.util.e.a.buz().qf(0).l(R.color.CAM_X0601, R.color.CAM_X0604).qm(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10)).bq(this.nat);
                this.nar.startLoad(this.nal.getThreadImgUrl(), 10, false);
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
                            if (this.naz.getVisibility() == 8) {
                                ap.setViewTextColor(this.naz, (int) R.color.CAM_X0105);
                                this.naz.setText(next.bIJ());
                                this.naz.setVisibility(0);
                                break;
                            } else {
                                continue;
                            }
                        case 512:
                            this.naB.setVoiceModel((VoiceData.VoiceModel) next.bIK().bJD());
                            if (this.naz.getVisibility() == 0 || this.naA.getVisibility() == 0) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.naB.getLayoutParams();
                                if (this.naz.getVisibility() == 0 && this.naA.getVisibility() == 8) {
                                    layoutParams.topMargin = l.getDimens(context, R.dimen.tbds39);
                                } else {
                                    layoutParams.topMargin = l.getDimens(context, R.dimen.tbds42);
                                }
                                this.naB.setLayoutParams(layoutParams);
                            }
                            this.naB.setVisibility(0);
                            continue;
                    }
                }
            }
            if (!tbRichText.bID().isEmpty()) {
                if (this.naz.getVisibility() == 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.naA.getLayoutParams();
                    layoutParams2.topMargin = l.getDimens(context, R.dimen.tbds37);
                    this.naA.setLayoutParams(layoutParams2);
                }
                this.naA.setVisibility(0);
                if (fS(tbRichText.bID())) {
                    this.naA.addView(a(context, a(tbRichText.bID().get(0), this.nal.dnO()), tbRichText.bID().get(0), true, this.nal.dnO().mIsFromCDN));
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
                this.naA.addView(a(context, a(list.get(i), this.nal.dnO()), list.get(i), i == 0, this.nal.dnO().mIsFromCDN));
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
