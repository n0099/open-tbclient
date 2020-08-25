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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes17.dex */
public class d {
    private TextView dzi;
    private HeadImageView jRV;
    private View kvV;
    private b kvW;
    private TextView kvX;
    private BarImageView kvY;
    private TextView kvZ;
    private TextView kwa;
    private LinearLayout kwb;
    private TextView title;

    /* loaded from: classes17.dex */
    public interface b {
        void Ng(String str);

        void cVb();

        void fr(String str, String str2);
    }

    public d(Context context) {
        this.kvV = LayoutInflater.from(context).inflate(R.layout.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.kvV.findViewById(R.id.chosen_pb_title);
        this.jRV = (HeadImageView) this.kvV.findViewById(R.id.chosen_pb_person_info_head);
        this.dzi = (TextView) this.kvV.findViewById(R.id.chosen_pb_person_info_name);
        this.kvX = (TextView) this.kvV.findViewById(R.id.chosen_pb_bar_forum_name);
        this.jRV.setRadius(l.dip2px(context, 2.0f));
        this.kvY = (BarImageView) this.kvV.findViewById(R.id.chosen_pb_bar_pic);
        this.kvZ = (TextView) this.kvV.findViewById(R.id.chosen_pb_bar_attention_number);
        this.kwa = (TextView) this.kvV.findViewById(R.id.chosen_pb_bar_attention_button);
        this.kwa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.kvW != null) {
                    d.this.kvW.cVb();
                }
            }
        });
        this.kwb = (LinearLayout) this.kvV.findViewById(R.id.chosen_pb_bar_container);
    }

    public View cVe() {
        return this.kvV;
    }

    public void a(b bVar) {
        this.kvW = bVar;
    }

    public void Ni(String str) {
        if (!StringUtils.isNull(str) && this.jRV != null) {
            this.jRV.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.kwb.setVisibility(8);
                return;
            }
            k.bbM().setForumNameForWaterImage(excellentPbThreadInfo.forum.forum_name);
            this.kwb.setVisibility(0);
            aO(context, excellentPbThreadInfo.forum.forum_name);
            if (this.kvY != null) {
                this.kvY.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.kvY.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.kvZ != null && excellentPbThreadInfo.forum.member_count != null) {
                this.kvZ.setText(at.numFormatOver10000(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                sy(true);
            } else {
                sy(false);
            }
        }
    }

    public void setName(String str) {
        if (this.dzi != null) {
            this.dzi.setText(str);
        }
    }

    private void aO(Context context, String str) {
        if (this.kvX != null) {
            if (StringUtils.isNull(str)) {
                this.kvX.setVisibility(4);
                return;
            }
            this.kvX.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.kvX.setOnClickListener(new a(str));
            this.kvX.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            Ni(userInfo.portrait);
            this.jRV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.v(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.dzi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.v(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(long j, String str) {
        if (this.kvW != null) {
            this.kvW.fr(String.valueOf(j), str);
        }
    }

    public void sy(boolean z) {
        if (z) {
            this.kwa.setText(R.string.relate_forum_is_followed);
            ap.setViewTextColor(this.kwa, R.color.cp_cont_d, 1);
            this.kwa.setEnabled(false);
            return;
        }
        this.kwa.setText(R.string.attention);
        this.kwa.setEnabled(true);
        ap.setViewTextColor(this.kwa, R.color.cp_cont_g, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class a implements View.OnClickListener {
        private String forumName;

        public a(String str) {
            this.forumName = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.kvW != null) {
                d.this.kvW.Ng(this.forumName);
            }
        }
    }
}
