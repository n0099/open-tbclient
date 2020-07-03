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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes10.dex */
public class d {
    private TextView djl;
    private View jYa;
    private b jYb;
    private TextView jYc;
    private BarImageView jYd;
    private TextView jYe;
    private TextView jYf;
    private LinearLayout jYg;
    private HeadImageView jtW;
    private TextView title;

    /* loaded from: classes10.dex */
    public interface b {
        void JB(String str);

        void cGD();

        void eY(String str, String str2);
    }

    public d(Context context) {
        this.jYa = LayoutInflater.from(context).inflate(R.layout.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.jYa.findViewById(R.id.chosen_pb_title);
        this.jtW = (HeadImageView) this.jYa.findViewById(R.id.chosen_pb_person_info_head);
        this.djl = (TextView) this.jYa.findViewById(R.id.chosen_pb_person_info_name);
        this.jYc = (TextView) this.jYa.findViewById(R.id.chosen_pb_bar_forum_name);
        this.jtW.setRadius(l.dip2px(context, 2.0f));
        this.jYd = (BarImageView) this.jYa.findViewById(R.id.chosen_pb_bar_pic);
        this.jYe = (TextView) this.jYa.findViewById(R.id.chosen_pb_bar_attention_number);
        this.jYf = (TextView) this.jYa.findViewById(R.id.chosen_pb_bar_attention_button);
        this.jYf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.jYb != null) {
                    d.this.jYb.cGD();
                }
            }
        });
        this.jYg = (LinearLayout) this.jYa.findViewById(R.id.chosen_pb_bar_container);
    }

    public View cGG() {
        return this.jYa;
    }

    public void a(b bVar) {
        this.jYb = bVar;
    }

    public void JD(String str) {
        if (!StringUtils.isNull(str) && this.jtW != null) {
            this.jtW.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.jYg.setVisibility(8);
                return;
            }
            k.aPA().setForumNameForWaterImage(excellentPbThreadInfo.forum.forum_name);
            this.jYg.setVisibility(0);
            aL(context, excellentPbThreadInfo.forum.forum_name);
            if (this.jYd != null) {
                this.jYd.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.jYd.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.jYe != null && excellentPbThreadInfo.forum.member_count != null) {
                this.jYe.setText(ar.numFormatOver10000(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                rm(true);
            } else {
                rm(false);
            }
        }
    }

    public void setName(String str) {
        if (this.djl != null) {
            this.djl.setText(str);
        }
    }

    private void aL(Context context, String str) {
        if (this.jYc != null) {
            if (StringUtils.isNull(str)) {
                this.jYc.setVisibility(4);
                return;
            }
            this.jYc.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.jYc.setOnClickListener(new a(str));
            this.jYc.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            JD(userInfo.portrait);
            this.jtW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.u(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.djl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.u(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(long j, String str) {
        if (this.jYb != null) {
            this.jYb.eY(String.valueOf(j), str);
        }
    }

    public void rm(boolean z) {
        if (z) {
            this.jYf.setText(R.string.relate_forum_is_followed);
            an.setViewTextColor(this.jYf, R.color.cp_cont_d, 1);
            this.jYf.setEnabled(false);
            return;
        }
        this.jYf.setText(R.string.attention);
        this.jYf.setEnabled(true);
        an.setViewTextColor(this.jYf, R.color.cp_cont_g, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        private String forumName;

        public a(String str) {
            this.forumName = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.jYb != null) {
                d.this.jYb.JB(this.forumName);
            }
        }
    }
}
