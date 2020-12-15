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
    private HeadImageView kVS;
    private b lAa;
    private TextView lAb;
    private BarImageView lAc;
    private TextView lAd;
    private TextView lAe;
    private LinearLayout lAf;
    private View lzZ;
    private TextView title;

    /* loaded from: classes23.dex */
    public interface b {
        void PR(String str);

        void dmK();

        void fW(String str, String str2);
    }

    public d(Context context) {
        this.lzZ = LayoutInflater.from(context).inflate(R.layout.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.lzZ.findViewById(R.id.chosen_pb_title);
        this.kVS = (HeadImageView) this.lzZ.findViewById(R.id.chosen_pb_person_info_head);
        this.egV = (TextView) this.lzZ.findViewById(R.id.chosen_pb_person_info_name);
        this.lAb = (TextView) this.lzZ.findViewById(R.id.chosen_pb_bar_forum_name);
        this.kVS.setRadius(l.dip2px(context, 2.0f));
        this.lAc = (BarImageView) this.lzZ.findViewById(R.id.chosen_pb_bar_pic);
        this.lAd = (TextView) this.lzZ.findViewById(R.id.chosen_pb_bar_attention_number);
        this.lAe = (TextView) this.lzZ.findViewById(R.id.chosen_pb_bar_attention_button);
        this.lAe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.lAa != null) {
                    d.this.lAa.dmK();
                }
            }
        });
        this.lAf = (LinearLayout) this.lzZ.findViewById(R.id.chosen_pb_bar_container);
    }

    public View dmN() {
        return this.lzZ;
    }

    public void a(b bVar) {
        this.lAa = bVar;
    }

    public void PT(String str) {
        if (!StringUtils.isNull(str) && this.kVS != null) {
            this.kVS.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.lAf.setVisibility(8);
                return;
            }
            k.blV().setForumNameForWaterImage(excellentPbThreadInfo.forum.forum_name);
            this.lAf.setVisibility(0);
            aW(context, excellentPbThreadInfo.forum.forum_name);
            if (this.lAc != null) {
                this.lAc.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.lAc.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.lAd != null && excellentPbThreadInfo.forum.member_count != null) {
                this.lAd.setText(au.numFormatOver10000(excellentPbThreadInfo.forum.member_count.intValue()));
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
        if (this.lAb != null) {
            if (StringUtils.isNull(str)) {
                this.lAb.setVisibility(4);
                return;
            }
            this.lAb.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.lAb.setOnClickListener(new a(str));
            this.lAb.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            PT(userInfo.portrait);
            this.kVS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
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
        if (this.lAa != null) {
            this.lAa.fW(String.valueOf(j), str);
        }
    }

    public void uu(boolean z) {
        if (z) {
            this.lAe.setText(R.string.relate_forum_is_followed);
            ap.setViewTextColor(this.lAe, R.color.CAM_X0109, 1);
            this.lAe.setEnabled(false);
            return;
        }
        this.lAe.setText(R.string.attention);
        this.lAe.setEnabled(true);
        ap.setViewTextColor(this.lAe, R.color.CAM_X0111, 1);
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
            if (d.this.lAa != null) {
                d.this.lAa.PR(this.forumName);
            }
        }
    }
}
