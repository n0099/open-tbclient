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
/* loaded from: classes23.dex */
public class b extends c {
    private ImageView iUO;
    private TextView mdA;
    private LinearLayout mdB;
    private PlayVoiceBntNew mdC;
    private m mdm;
    private View mdn;
    private View mdo;
    private View mdp;
    private TbImageView mdq;
    private LinearLayout mdr;
    private TbImageView mds;
    private TextView mdt;
    private View mdu;
    private TextView mdv;
    private TextView mdw;
    private TbImageView mdx;
    private View mdy;
    private TextView mdz;
    private View rootView;

    public b(Context context, boolean z, int i, m mVar) {
        super(context, z, i);
        this.mdm = mVar;
        this.rootView = this.mRootView.findViewById(R.id.pb_post_share_root_view);
        this.mdn = this.mRootView.findViewById(R.id.pb_post_share_card_container);
        this.mdo = this.mRootView.findViewById(R.id.pb_post_share_card);
        this.mdp = this.mRootView.findViewById(R.id.pb_post_share_card_content);
        this.mdq = (TbImageView) this.mRootView.findViewById(R.id.pb_post_share_title);
        this.mdr = (LinearLayout) this.mRootView.findViewById(R.id.pb_share_thread_container);
        this.mds = (TbImageView) this.mRootView.findViewById(R.id.pb_share_origin_thread_img);
        this.mds.setPlaceHolder(2);
        this.mds.setConrers(15);
        this.mds.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.mds.setGifIconSupport(false);
        this.mds.setLongIconSupport(false);
        this.mdt = (TextView) this.mRootView.findViewById(R.id.origin_thread_abstract);
        this.mdu = this.mRootView.findViewById(R.id.pb_share_origin_thread_gradient_mask);
        this.iUO = (ImageView) this.mRootView.findViewById(R.id.pb_post_share_video_play_iv);
        this.mdv = (TextView) this.mRootView.findViewById(R.id.post_share_screen_shot_title);
        this.mdw = (TextView) this.mRootView.findViewById(R.id.post_share_qcode_comment);
        this.mdx = (TbImageView) this.mRootView.findViewById(R.id.post_share_qcode);
        this.mdy = this.mRootView.findViewById(R.id.post_share_reply_user_id_guide_line);
        this.mdz = (TextView) this.mRootView.findViewById(R.id.post_share_reply_user_id);
        this.mdA = (TextView) this.mRootView.findViewById(R.id.post_share_comment_text);
        this.mdB = (LinearLayout) this.mRootView.findViewById(R.id.post_share_comment_image_container);
        this.mdC = (PlayVoiceBntNew) this.mRootView.findViewById(R.id.post_share_comment_voice);
        a(context, mVar.cZH().dAF());
        dwN();
    }

    private void dwN() {
    }

    @Override // com.baidu.tieba.sharesdk.d.c
    protected View csC() {
        return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.pb_post_share_dialog_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.sharesdk.d.c
    public ShareItem HH(int i) {
        ShareItem shareItem = this.mdg.get(1);
        if (shareItem == null) {
            shareItem = new ShareItem();
        }
        shareItem.eGP = false;
        shareItem.eGO = false;
        shareItem.content = "";
        shareItem.shareType = 1;
        shareItem.w(dt(this.mdn));
        shareItem.bqu();
        this.mdg.put(1, shareItem);
        return super.HH(i);
    }

    private Bitmap dt(View view) {
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
        if (this.mdm != null) {
            this.rootView.setBackgroundColor(ap.getColor(R.color.cp_bg_line_j));
            ap.c(this.mdp, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds31), R.color.cp_bg_line_k, R.color.cp_bg_line_k);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            gradientDrawable.setColor(ap.getColor(R.color.cp_bg_line_g));
            this.mdr.setBackgroundDrawable(gradientDrawable);
            ap.setViewTextColor(this.mdt, R.color.cp_cont_j);
            this.mdt.setText(this.mdm.getContent());
            dwO();
            ap.setBackgroundColor(this.mdy, R.color.cp_cont_d);
            String name_show = this.mdm.cZH().bfy().getName_show();
            if (name_show.length() > 10) {
                name_show = name_show.substring(0, 10) + StringHelper.STRING_MORE;
            }
            this.mdz.setText(name_show);
            ap.setViewTextColor(this.mdz, R.color.cp_cont_d);
            ap.setViewTextColor(this.mdv, R.color.cp_link_tip_c);
            ap.setViewTextColor(this.mdw, R.color.cp_cont_b);
            this.mdx.setImageBitmap(this.mdm.cZG());
            ap.setImageResource(this.mdq, R.drawable.pic_pb_post_share_logo);
            super.show();
        }
    }

    @Override // com.baidu.tieba.sharesdk.d.c
    protected void b(Window window) {
        window.setLayout(-1, -1);
    }

    private void dwO() {
        switch (this.mdm.getThreadType()) {
            case 0:
                if (!StringUtils.isNull(this.mdm.getThreadImgUrl())) {
                    this.mds.startLoad(this.mdm.getThreadImgUrl(), 10, false);
                    return;
                }
                this.mds.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_article_thread));
                this.mds.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return;
            case 11:
                this.mds.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_voice_thread));
                this.mds.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return;
            case 40:
                this.mdu.setVisibility(0);
                this.iUO.setVisibility(0);
                this.iUO.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_voide_thread_play));
                com.baidu.tbadk.core.util.e.a.bkL().oq(0).i(R.color.cp_mask_b_alpha0, R.color.cp_mask_b_alpha25).ov(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10)).bb(this.mdu);
                this.mds.startLoad(this.mdm.getThreadImgUrl(), 10, false);
                return;
            default:
                return;
        }
    }

    public void a(Context context, TbRichText tbRichText) {
        if (tbRichText != null && tbRichText.byG() != null && !tbRichText.byG().isEmpty()) {
            Iterator<TbRichTextData> it = tbRichText.byG().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null) {
                    switch (next.getType()) {
                        case 1:
                            if (this.mdA.getVisibility() == 8) {
                                ap.setViewTextColor(this.mdA, R.color.cp_cont_b);
                                this.mdA.setText(next.byN());
                                this.mdA.setVisibility(0);
                                break;
                            } else {
                                continue;
                            }
                        case 512:
                            this.mdC.setVoiceModel((VoiceData.VoiceModel) next.byO().bzI());
                            if (this.mdA.getVisibility() == 0 || this.mdB.getVisibility() == 0) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mdC.getLayoutParams();
                                if (this.mdA.getVisibility() == 0 && this.mdB.getVisibility() == 8) {
                                    layoutParams.topMargin = l.getDimens(context, R.dimen.tbds39);
                                } else {
                                    layoutParams.topMargin = l.getDimens(context, R.dimen.tbds42);
                                }
                                this.mdC.setLayoutParams(layoutParams);
                            }
                            this.mdC.setVisibility(0);
                            continue;
                    }
                }
            }
            if (!tbRichText.byH().isEmpty()) {
                if (this.mdA.getVisibility() == 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mdB.getLayoutParams();
                    layoutParams2.topMargin = l.getDimens(context, R.dimen.tbds37);
                    this.mdB.setLayoutParams(layoutParams2);
                }
                this.mdB.setVisibility(0);
                if (fk(tbRichText.byH())) {
                    this.mdB.addView(a(context, a(tbRichText.byH().get(0), this.mdm.cZI()), tbRichText.byH().get(0), true, this.mdm.cZI().mIsFromCDN));
                } else {
                    c(context, tbRichText.byH());
                }
            }
        }
    }

    private void c(Context context, List<TbRichTextImageInfo> list) {
        int i = 0;
        while (i < list.size() && i != 3) {
            if (!list.get(i).bzh()) {
                this.mdB.addView(a(context, a(list.get(i), this.mdm.cZI()), list.get(i), i == 0, this.mdm.cZI().mIsFromCDN));
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
        if (tbRichTextImageInfo.bzh()) {
            tbImageView.setLongIconSupport(true);
            tbImageView.setIsLongPic(true);
        }
        tbImageView.setConrers(15);
        tbImageView.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        tbImageView.startLoad(str, z2 ? 17 : 18, false);
        return tbImageView;
    }

    private boolean fk(List<TbRichTextImageInfo> list) {
        for (TbRichTextImageInfo tbRichTextImageInfo : list) {
            if (!tbRichTextImageInfo.bzh()) {
                return false;
            }
        }
        return true;
    }

    private String a(TbRichTextImageInfo tbRichTextImageInfo, com.baidu.tbadk.widget.richText.a aVar) {
        return aVar.byF() ? tbRichTextImageInfo.byZ() : tbRichTextImageInfo.bzc();
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
