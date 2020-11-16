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
/* loaded from: classes23.dex */
public class b extends c {
    private ImageView jDd;
    private m mMg;
    private View mMh;
    private View mMi;
    private View mMj;
    private TbImageView mMk;
    private LinearLayout mMl;
    private TbImageView mMm;
    private TextView mMn;
    private View mMo;
    private TextView mMp;
    private TextView mMq;
    private TbImageView mMr;
    private View mMs;
    private TextView mMt;
    private TextView mMu;
    private LinearLayout mMv;
    private PlayVoiceBntNew mMw;
    private View rootView;

    public b(Context context, boolean z, int i, m mVar) {
        super(context, z, i);
        this.mMg = mVar;
        this.rootView = this.mRootView.findViewById(R.id.pb_post_share_root_view);
        this.mMh = this.mRootView.findViewById(R.id.pb_post_share_card_container);
        this.mMi = this.mRootView.findViewById(R.id.pb_post_share_card);
        this.mMj = this.mRootView.findViewById(R.id.pb_post_share_card_content);
        this.mMk = (TbImageView) this.mRootView.findViewById(R.id.pb_post_share_title);
        this.mMl = (LinearLayout) this.mRootView.findViewById(R.id.pb_share_thread_container);
        this.mMm = (TbImageView) this.mRootView.findViewById(R.id.pb_share_origin_thread_img);
        this.mMm.setPlaceHolder(2);
        this.mMm.setConrers(15);
        this.mMm.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.mMm.setGifIconSupport(false);
        this.mMm.setLongIconSupport(false);
        this.mMn = (TextView) this.mRootView.findViewById(R.id.origin_thread_abstract);
        this.mMo = this.mRootView.findViewById(R.id.pb_share_origin_thread_gradient_mask);
        this.jDd = (ImageView) this.mRootView.findViewById(R.id.pb_post_share_video_play_iv);
        this.mMp = (TextView) this.mRootView.findViewById(R.id.post_share_screen_shot_title);
        this.mMq = (TextView) this.mRootView.findViewById(R.id.post_share_qcode_comment);
        this.mMr = (TbImageView) this.mRootView.findViewById(R.id.post_share_qcode);
        this.mMs = this.mRootView.findViewById(R.id.post_share_reply_user_id_guide_line);
        this.mMt = (TextView) this.mRootView.findViewById(R.id.post_share_reply_user_id);
        this.mMu = (TextView) this.mRootView.findViewById(R.id.post_share_comment_text);
        this.mMv = (LinearLayout) this.mRootView.findViewById(R.id.post_share_comment_image_container);
        this.mMw = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.post_share_comment_voice);
        a(context, mVar.dix().dJS());
        dFW();
        JC(2);
    }

    private void dFW() {
    }

    @Override // com.baidu.tieba.sharesdk.view.c
    protected View cBk() {
        return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.pb_post_share_dialog_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.sharesdk.view.c
    public ShareItem Ju(int i) {
        ShareItem shareItem = this.mMa.get(1);
        if (shareItem == null) {
            shareItem = new ShareItem();
        }
        shareItem.fgr = false;
        shareItem.fgq = false;
        shareItem.content = "";
        shareItem.shareType = 1;
        shareItem.w(dN(this.mMh));
        shareItem.bwM();
        this.mMa.put(1, shareItem);
        return super.Ju(i);
    }

    private Bitmap dN(View view) {
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
        if (this.mMg != null) {
            this.rootView.setBackgroundColor(ap.getColor(R.color.CAM_X0209));
            ap.c(this.mMj, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds31), R.color.CAM_X0211, R.color.CAM_X0211);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            gradientDrawable.setColor(ap.getColor(R.color.CAM_X0206));
            this.mMl.setBackgroundDrawable(gradientDrawable);
            ap.setViewTextColor(this.mMn, R.color.CAM_X0107);
            this.mMn.setText(this.mMg.getContent());
            dFX();
            ap.setBackgroundColor(this.mMs, R.color.CAM_X0109);
            String name_show = this.mMg.dix().blC().getName_show();
            if (name_show.length() > 10) {
                name_show = name_show.substring(0, 10) + StringHelper.STRING_MORE;
            }
            this.mMt.setText(name_show);
            ap.setViewTextColor(this.mMt, R.color.CAM_X0109);
            ap.setViewTextColor(this.mMp, R.color.CAM_X0304);
            ap.setViewTextColor(this.mMq, R.color.CAM_X0105);
            this.mMr.setImageBitmap(this.mMg.diw());
            ap.setImageResource(this.mMk, R.drawable.pic_pb_post_share_logo);
            xd(false);
            super.show();
        }
    }

    @Override // com.baidu.tieba.sharesdk.view.c
    protected void b(Window window) {
        window.setLayout(-1, -1);
    }

    private void dFX() {
        switch (this.mMg.getThreadType()) {
            case 0:
                if (!StringUtils.isNull(this.mMg.getThreadImgUrl())) {
                    this.mMm.startLoad(this.mMg.getThreadImgUrl(), 10, false);
                    return;
                }
                this.mMm.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_article_thread));
                this.mMm.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return;
            case 11:
                this.mMm.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_voice_thread));
                this.mMm.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return;
            case 40:
                this.mMo.setVisibility(0);
                this.jDd.setVisibility(0);
                this.jDd.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_voide_thread_play));
                com.baidu.tbadk.core.util.e.a.brc().pF(0).l(R.color.CAM_X0601, R.color.CAM_X0604).pM(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10)).bn(this.mMo);
                this.mMm.startLoad(this.mMg.getThreadImgUrl(), 10, false);
                return;
            default:
                return;
        }
    }

    public void a(Context context, TbRichText tbRichText) {
        if (tbRichText != null && tbRichText.bFb() != null && !tbRichText.bFb().isEmpty()) {
            Iterator<TbRichTextData> it = tbRichText.bFb().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null) {
                    switch (next.getType()) {
                        case 1:
                            if (this.mMu.getVisibility() == 8) {
                                ap.setViewTextColor(this.mMu, R.color.CAM_X0105);
                                this.mMu.setText(next.bFi());
                                this.mMu.setVisibility(0);
                                break;
                            } else {
                                continue;
                            }
                        case 512:
                            this.mMw.setVoiceModel((VoiceData.VoiceModel) next.bFj().bGd());
                            if (this.mMu.getVisibility() == 0 || this.mMv.getVisibility() == 0) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mMw.getLayoutParams();
                                if (this.mMu.getVisibility() == 0 && this.mMv.getVisibility() == 8) {
                                    layoutParams.topMargin = l.getDimens(context, R.dimen.tbds39);
                                } else {
                                    layoutParams.topMargin = l.getDimens(context, R.dimen.tbds42);
                                }
                                this.mMw.setLayoutParams(layoutParams);
                            }
                            this.mMw.setVisibility(0);
                            continue;
                    }
                }
            }
            if (!tbRichText.bFc().isEmpty()) {
                if (this.mMu.getVisibility() == 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mMv.getLayoutParams();
                    layoutParams2.topMargin = l.getDimens(context, R.dimen.tbds37);
                    this.mMv.setLayoutParams(layoutParams2);
                }
                this.mMv.setVisibility(0);
                if (fE(tbRichText.bFc())) {
                    this.mMv.addView(a(context, a(tbRichText.bFc().get(0), this.mMg.diy()), tbRichText.bFc().get(0), true, this.mMg.diy().mIsFromCDN));
                } else {
                    c(context, tbRichText.bFc());
                }
            }
        }
    }

    private void c(Context context, List<TbRichTextImageInfo> list) {
        int i = 0;
        while (i < list.size() && i != 3) {
            if (!list.get(i).bFC()) {
                this.mMv.addView(a(context, a(list.get(i), this.mMg.diy()), list.get(i), i == 0, this.mMg.diy().mIsFromCDN));
            }
            i++;
        }
    }

    private TbImageView a(Context context, String str, TbRichTextImageInfo tbRichTextImageInfo, boolean z, boolean z2) {
        int[] af = af(tbRichTextImageInfo.getWidth(), tbRichTextImageInfo.getHeight(), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds981));
        TbImageView tbImageView = new TbImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(af[0], af[1]);
        if (!z) {
            layoutParams.setMargins(0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), 0, 0);
        }
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (tbRichTextImageInfo.bFC()) {
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
            if (!tbRichTextImageInfo.bFC()) {
                return false;
            }
        }
        return true;
    }

    private String a(TbRichTextImageInfo tbRichTextImageInfo, com.baidu.tbadk.widget.richText.a aVar) {
        return aVar.bFa() ? tbRichTextImageInfo.bFu() : tbRichTextImageInfo.bFx();
    }

    private int[] af(int i, int i2, int i3) {
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
