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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class j {
    private final View.OnClickListener bRl;
    private final Context mContext;
    private int atB = Constants.MEDIA_INFO;
    private boolean ayY = true;
    private boolean mIsFromCDN = false;
    private float ayn = 0.4f;
    private LinkedList<IconData> bRj = null;
    private LinkedList<IconData> bRk = null;

    public j(Context context) {
        this.mContext = context;
        this.bRl = new k(this, context);
    }

    public void a(int i, boolean z, float f) {
        this.atB = i;
        this.ayY = z;
        this.ayn = f;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void a(View view, com.baidu.tieba.data.q qVar) {
        l lVar;
        int i;
        int i2 = 0;
        if (view.getTag() != null && (lVar = (l) view.getTag()) != null) {
            lVar.bRp.setText(String.valueOf(qVar.getForumName()) + this.mContext.getResources().getString(com.baidu.tieba.y.forum_name_suffix));
            lVar.bRp.setTag(qVar.getForumName());
            this.bRj = qVar.zd();
            if (lVar.aSO != null) {
                lVar.aSO.a(this.bRj, 3, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.forumfeed_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.forumfeed_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.forumfeed_icon_margin));
            }
            this.bRk = qVar.getTShowInfo();
            if (lVar.azs != null) {
                lVar.azs.a(this.bRk, 2, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_margin));
            }
            TbadkApplication.m251getInst().getSkinType();
            if (this.bRk != null && this.bRk.size() > 0) {
                lVar.bRs.setPadding(0, 0, 0, 0);
                aw.b(lVar.bRs, com.baidu.tieba.s.cp_cont_h, 1);
            } else {
                lVar.bRs.setPadding(this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.listview_item_padding), 0, 0, 0);
                aw.b(lVar.bRs, com.baidu.tieba.s.listview_item_author_time_text, 1);
            }
            lVar.bRs.setText(qVar.getUserName());
            lVar.bRu.setText(String.valueOf(qVar.getReplyNum()));
            lVar.bRt.setText(az.j(qVar.zc() * 1000));
            if (qVar.kB() != null && qVar.kB().trim().length() > 0) {
                lVar.bRr.setText(qVar.kB());
                lVar.bRr.setVisibility(0);
            } else {
                lVar.bRr.setText((CharSequence) null);
                lVar.bRr.setVisibility(8);
            }
            lVar.forumId = qVar.getForumId();
            lVar.threadId = qVar.getTid();
            ArrayList<VoiceData.VoiceModel> voices = qVar.getVoices();
            if (voices != null && voices.size() > 0) {
                lVar.bRw.setVisibility(0);
                VoiceData.VoiceModel voiceModel = voices.get(0);
                lVar.bRw.setVoiceModel(voiceModel);
                lVar.bRw.setTag(voiceModel);
                lVar.bRw.YL();
            } else {
                lVar.bRw.setVisibility(8);
            }
            LiveCardData liveCardData = qVar.getLiveCardData();
            if (qVar.ze()) {
                lVar.bRv.setVisibility(8);
                lVar.bRq.setText(c(view, qVar));
                lVar.bRx.setVisibility(0);
                lVar.bEn.setData(liveCardData);
            } else {
                lVar.bRx.setVisibility(8);
                if (qVar.getIsGood() > 0) {
                    lVar.bRq.setText(b(view, qVar));
                } else {
                    lVar.bRq.setText(qVar.zb());
                }
                if (com.baidu.tbadk.core.l.js().jw()) {
                    lVar.bRv.setVisibility(0);
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
                                lVar.bRv.setShowBig(this.ayY);
                                lVar.bRv.setData(mediaDataArr);
                                lVar.bRv.setFromCDN(this.mIsFromCDN);
                            }
                        } else {
                            lVar.bRv.setVisibility(8);
                        }
                    }
                } else {
                    lVar.bRv.setVisibility(8);
                }
            }
            lVar.mR = this.ayY;
            view.setTag(lVar);
        }
    }

    private SpannableString b(View view, com.baidu.tieba.data.q qVar) {
        Drawable drawable = view.getResources().getDrawable(com.baidu.tieba.u.icon_elite);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        ImageSpan imageSpan = new ImageSpan(drawable, 1);
        SpannableString spannableString = new SpannableString("  " + ((Object) qVar.zb()));
        spannableString.setSpan(imageSpan, 0, 1, 18);
        return spannableString;
    }

    private SpannableString c(View view, com.baidu.tieba.data.q qVar) {
        Drawable drawable = aw.getDrawable(com.baidu.tieba.u.icon_live_on);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        ImageSpan imageSpan = new ImageSpan(drawable, 1);
        SpannableString spannableString = new SpannableString("  " + ((Object) qVar.zb()));
        spannableString.setSpan(imageSpan, 0, 1, 18);
        return spannableString;
    }

    public View hA() {
        l lVar = new l(this);
        LinearLayout linearLayout = (LinearLayout) com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.forum_feed_item, null);
        lVar.bRn = (LinearLayout) linearLayout.findViewById(com.baidu.tieba.v.layoutForumTop);
        lVar.bRo = (RelativeLayout) linearLayout.findViewById(com.baidu.tieba.v.layoutForumBottom);
        lVar.bRp = (TextView) linearLayout.findViewById(com.baidu.tieba.v.textHomeListFrsName);
        lVar.bRq = (TextView) linearLayout.findViewById(com.baidu.tieba.v.textHomeListTitle);
        lVar.bRr = (TextView) linearLayout.findViewById(com.baidu.tieba.v.textHomeListAbstract);
        lVar.bRs = (TextView) linearLayout.findViewById(com.baidu.tieba.v.textHomeListAuthor);
        lVar.aSO = (UserIconBox) linearLayout.findViewById(com.baidu.tieba.v.user_icon_box);
        lVar.azs = (UserIconBox) linearLayout.findViewById(com.baidu.tieba.v.user_tshow_icon_box);
        lVar.bRt = (TextView) linearLayout.findViewById(com.baidu.tieba.v.textHomeListTime);
        lVar.bRu = (TextView) linearLayout.findViewById(com.baidu.tieba.v.textHomeListRplyNum);
        lVar.bRv = (CommonImageLayout) linearLayout.findViewById(com.baidu.tieba.v.layoutFeedImage);
        lVar.bRw = (PlayVoiceBnt) linearLayout.findViewById(com.baidu.tieba.v.abstract_voice);
        lVar.bRx = (LinearLayout) linearLayout.findViewById(com.baidu.tieba.v.feed_item_live_card);
        lVar.bEn = (LiveBroadcastCard) linearLayout.findViewById(com.baidu.tieba.v.feed_item_card);
        lVar.bRp.setOnClickListener(this.bRl);
        linearLayout.setOnClickListener(this.bRl);
        linearLayout.setTag(lVar);
        return linearLayout;
    }

    public void c(int i, View view) {
        l lVar;
        if (view != null && (lVar = (l) view.getTag()) != null && lVar.RH != i) {
            aw.h((View) lVar.bRp, com.baidu.tieba.u.bg_label);
            switch (i) {
                case 1:
                    b(lVar);
                    break;
                default:
                    a(lVar);
                    break;
            }
            lVar.RH = i;
        }
    }

    private void a(l lVar) {
        Resources resources = this.mContext.getResources();
        lVar.bRn.setBackgroundResource(com.baidu.tieba.u.forumfeed_frs_list_item_top_bg);
        lVar.bRu.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(com.baidu.tieba.u.icon_little_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        lVar.bRo.setBackgroundResource(com.baidu.tieba.u.forumfeed_frs_list_item_foot_bg);
    }

    private void b(l lVar) {
        this.mContext.getResources();
        aw.h(lVar.bRn, com.baidu.tieba.u.forumfeed_frs_list_item_top_bg);
        lVar.bRu.setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(com.baidu.tieba.u.icon_little_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        aw.h(lVar.bRo, com.baidu.tieba.u.forumfeed_frs_list_item_foot_bg);
    }
}
