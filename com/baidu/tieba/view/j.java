package com.baidu.tieba.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class j {
    private final View.OnClickListener bQW;
    private final Context mContext;
    private int ats = Constants.MEDIA_INFO;
    private boolean ayP = true;
    private boolean mIsFromCDN = false;
    private float aye = 0.4f;
    private LinkedList<IconData> bQU = null;
    private LinkedList<IconData> bQV = null;

    public j(Context context) {
        this.mContext = context;
        this.bQW = new k(this, context);
    }

    public void a(int i, boolean z, float f) {
        this.ats = i;
        this.ayP = z;
        this.aye = f;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void a(View view, com.baidu.tieba.data.q qVar) {
        l lVar;
        int i;
        int i2 = 0;
        if (view.getTag() != null && (lVar = (l) view.getTag()) != null) {
            lVar.bRa.setText(String.valueOf(qVar.getForumName()) + this.mContext.getResources().getString(com.baidu.tieba.y.forum_name_suffix));
            lVar.bRa.setTag(qVar.getForumName());
            this.bQU = qVar.zb();
            if (lVar.aSA != null) {
                lVar.aSA.a(this.bQU, 3, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.forumfeed_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.forumfeed_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.forumfeed_icon_margin));
            }
            this.bQV = qVar.getTShowInfo();
            if (lVar.azj != null) {
                lVar.azj.a(this.bQV, 2, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_margin));
            }
            TbadkApplication.m251getInst().getSkinType();
            if (this.bQV != null && this.bQV.size() > 0) {
                lVar.bRd.setPadding(0, 0, 0, 0);
                aw.b(lVar.bRd, com.baidu.tieba.s.cp_cont_h, 1);
            } else {
                lVar.bRd.setPadding(this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.listview_item_padding), 0, 0, 0);
                aw.b(lVar.bRd, com.baidu.tieba.s.listview_item_author_time_text, 1);
            }
            lVar.bRd.setText(qVar.getUserName());
            lVar.bRf.setText(String.valueOf(qVar.getReplyNum()));
            lVar.bRe.setText(ay.j(qVar.za() * 1000));
            if (qVar.kB() != null && qVar.kB().trim().length() > 0) {
                lVar.bRc.setText(qVar.kB());
                lVar.bRc.setVisibility(0);
            } else {
                lVar.bRc.setText((CharSequence) null);
                lVar.bRc.setVisibility(8);
            }
            lVar.forumId = qVar.getForumId();
            lVar.threadId = qVar.getTid();
            ArrayList<VoiceData.VoiceModel> voices = qVar.getVoices();
            if (voices != null && voices.size() > 0) {
                lVar.bRh.setVisibility(0);
                VoiceData.VoiceModel voiceModel = voices.get(0);
                lVar.bRh.setVoiceModel(voiceModel);
                lVar.bRh.setTag(voiceModel);
                lVar.bRh.YI();
            } else {
                lVar.bRh.setVisibility(8);
            }
            LiveCardData liveCardData = qVar.getLiveCardData();
            if (qVar.zc()) {
                lVar.bRg.setVisibility(8);
                lVar.bRb.setText(c(view, qVar));
                lVar.bRi.setVisibility(0);
                lVar.bDZ.setData(liveCardData);
            } else {
                lVar.bRi.setVisibility(8);
                if (qVar.getIsGood() > 0) {
                    lVar.bRb.setText(b(view, qVar));
                } else {
                    lVar.bRb.setText(qVar.yZ());
                }
                if (com.baidu.tbadk.core.k.js().jw()) {
                    lVar.bRg.setVisibility(0);
                    ArrayList<MediaData> medias = qVar.getMedias();
                    if (medias != null) {
                        if (medias.size() > 0) {
                            int size = medias.size();
                            int i3 = size > 3 ? 3 : size;
                            if (i3 > 0) {
                                MediaData[] mediaDataArr = new MediaData[i3];
                                int i4 = 0;
                                while (i2 < medias.size() && i4 < i3) {
                                    if (medias.get(i2).getType() == 3 || medias.get(i2).getType() == 5) {
                                        mediaDataArr[i4] = medias.get(i2);
                                        i = i4 + 1;
                                    } else {
                                        i = i4;
                                    }
                                    i2++;
                                    i4 = i;
                                }
                                lVar.bRg.setShowBig(this.ayP);
                                lVar.bRg.setData(mediaDataArr);
                                lVar.bRg.setFromCDN(this.mIsFromCDN);
                            }
                        } else {
                            lVar.bRg.setVisibility(8);
                        }
                    }
                } else {
                    lVar.bRg.setVisibility(8);
                }
            }
            lVar.mR = this.ayP;
            view.setTag(lVar);
        }
    }

    private SpannableString b(View view, com.baidu.tieba.data.q qVar) {
        Drawable drawable = view.getResources().getDrawable(com.baidu.tieba.u.icon_elite);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        ImageSpan imageSpan = new ImageSpan(drawable, 1);
        SpannableString spannableString = new SpannableString("  " + ((Object) qVar.yZ()));
        spannableString.setSpan(imageSpan, 0, 1, 18);
        return spannableString;
    }

    private SpannableString c(View view, com.baidu.tieba.data.q qVar) {
        Drawable drawable = aw.getDrawable(com.baidu.tieba.u.icon_live_on);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        ImageSpan imageSpan = new ImageSpan(drawable, 1);
        SpannableString spannableString = new SpannableString("  " + ((Object) qVar.yZ()));
        spannableString.setSpan(imageSpan, 0, 1, 18);
        return spannableString;
    }

    public View hA() {
        l lVar = new l(this);
        LinearLayout linearLayout = (LinearLayout) com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.forum_feed_item, null);
        lVar.bQY = (LinearLayout) linearLayout.findViewById(com.baidu.tieba.v.layoutForumTop);
        lVar.bQZ = (RelativeLayout) linearLayout.findViewById(com.baidu.tieba.v.layoutForumBottom);
        lVar.bRa = (TextView) linearLayout.findViewById(com.baidu.tieba.v.textHomeListFrsName);
        lVar.bRb = (TextView) linearLayout.findViewById(com.baidu.tieba.v.textHomeListTitle);
        lVar.bRc = (TextView) linearLayout.findViewById(com.baidu.tieba.v.textHomeListAbstract);
        lVar.bRd = (TextView) linearLayout.findViewById(com.baidu.tieba.v.textHomeListAuthor);
        lVar.aSA = (UserIconBox) linearLayout.findViewById(com.baidu.tieba.v.user_icon_box);
        lVar.azj = (UserIconBox) linearLayout.findViewById(com.baidu.tieba.v.user_tshow_icon_box);
        lVar.bRe = (TextView) linearLayout.findViewById(com.baidu.tieba.v.textHomeListTime);
        lVar.bRf = (TextView) linearLayout.findViewById(com.baidu.tieba.v.textHomeListRplyNum);
        lVar.bRg = (CommonImageLayout) linearLayout.findViewById(com.baidu.tieba.v.layoutFeedImage);
        lVar.bRh = (PlayVoiceBnt) linearLayout.findViewById(com.baidu.tieba.v.abstract_voice);
        lVar.bRi = (LinearLayout) linearLayout.findViewById(com.baidu.tieba.v.feed_item_live_card);
        lVar.bDZ = (LiveBroadcastCard) linearLayout.findViewById(com.baidu.tieba.v.feed_item_card);
        lVar.bRa.setOnClickListener(this.bQW);
        linearLayout.setOnClickListener(this.bQW);
        linearLayout.setTag(lVar);
        return linearLayout;
    }

    public void c(int i, View view) {
        l lVar;
        if (view != null && (lVar = (l) view.getTag()) != null && lVar.RD != i) {
            aw.h((View) lVar.bRa, com.baidu.tieba.u.bg_label);
            switch (i) {
                case 1:
                    b(lVar);
                    break;
                default:
                    a(lVar);
                    break;
            }
            lVar.RD = i;
        }
    }

    private void a(l lVar) {
        Resources resources = this.mContext.getResources();
        lVar.bQY.setBackgroundResource(com.baidu.tieba.u.forumfeed_frs_list_item_top_bg);
        lVar.bRf.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(com.baidu.tieba.u.icon_little_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        lVar.bQZ.setBackgroundResource(com.baidu.tieba.u.forumfeed_frs_list_item_foot_bg);
    }

    private void b(l lVar) {
        this.mContext.getResources();
        aw.h(lVar.bQY, com.baidu.tieba.u.forumfeed_frs_list_item_top_bg);
        lVar.bRf.setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(com.baidu.tieba.u.icon_little_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        aw.h(lVar.bQZ, com.baidu.tieba.u.forumfeed_frs_list_item_foot_bg);
    }
}
