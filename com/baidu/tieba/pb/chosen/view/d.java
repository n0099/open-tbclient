package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes23.dex */
public class d {
    private TextView egV;
    private HeadImageView kVQ;
    private BarImageView lAa;
    private TextView lAb;
    private TextView lAc;
    private LinearLayout lAd;
    private View lzX;
    private b lzY;
    private TextView lzZ;
    private TextView title;

    /* loaded from: classes23.dex */
    public interface b {
        void PR(String str);

        void dmJ();

        void fW(String str, String str2);
    }

    public d(Context context) {
        this.lzX = LayoutInflater.from(context).inflate(R.layout.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.lzX.findViewById(R.id.chosen_pb_title);
        this.kVQ = (HeadImageView) this.lzX.findViewById(R.id.chosen_pb_person_info_head);
        this.egV = (TextView) this.lzX.findViewById(R.id.chosen_pb_person_info_name);
        this.lzZ = (TextView) this.lzX.findViewById(R.id.chosen_pb_bar_forum_name);
        this.kVQ.setRadius(l.dip2px(context, 2.0f));
        this.lAa = (BarImageView) this.lzX.findViewById(R.id.chosen_pb_bar_pic);
        this.lAb = (TextView) this.lzX.findViewById(R.id.chosen_pb_bar_attention_number);
        this.lAc = (TextView) this.lzX.findViewById(R.id.chosen_pb_bar_attention_button);
        this.lAc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.lzY != null) {
                    d.this.lzY.dmJ();
                }
            }
        });
        this.lAd = (LinearLayout) this.lzX.findViewById(R.id.chosen_pb_bar_container);
    }

    public View dmM() {
        return this.lzX;
    }

    public void a(b bVar) {
        this.lzY = bVar;
    }

    public void PT(String str) {
        if (!StringUtils.isNull(str) && this.kVQ != null) {
            this.kVQ.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.lAd.setVisibility(8);
                return;
            }
            k.blV().setForumNameForWaterImage(excellentPbThreadInfo.forum.forum_name);
            this.lAd.setVisibility(0);
            aW(context, excellentPbThreadInfo.forum.forum_name);
            if (this.lAa != null) {
                this.lAa.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.lAa.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.lAb != null && excellentPbThreadInfo.forum.member_count != null) {
                this.lAb.setText(au.numFormatOver10000(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                uu(true);
            } else {
                uu(false);
            }
        }
    }

    public void setName(String str) {
        if (this.egV != null) {
            this.egV.setText(str);
        }
    }

    private void aW(Context context, String str) {
        if (this.lzZ != null) {
            if (StringUtils.isNull(str)) {
                this.lzZ.setVisibility(4);
                return;
            }
            this.lzZ.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.lzZ.setOnClickListener(new a(str));
            this.lzZ.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            PT(userInfo.portrait);
            this.kVQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.z(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.egV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.z(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(long j, String str) {
        if (this.lzY != null) {
            this.lzY.fW(String.valueOf(j), str);
        }
    }

    public void uu(boolean z) {
        if (z) {
            this.lAc.setText(R.string.relate_forum_is_followed);
            ap.setViewTextColor(this.lAc, R.color.CAM_X0109, 1);
            this.lAc.setEnabled(false);
            return;
        }
        this.lAc.setText(R.string.attention);
        this.lAc.setEnabled(true);
        ap.setViewTextColor(this.lAc, R.color.CAM_X0111, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class a implements View.OnClickListener {
        private String forumName;

        public a(String str) {
            this.forumName = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.lzY != null) {
                d.this.lzY.PR(this.forumName);
            }
        }
    }
}
