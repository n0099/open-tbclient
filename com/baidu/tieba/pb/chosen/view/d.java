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
/* loaded from: classes23.dex */
public class d {
    private TextView ebD;
    private HeadImageView kIj;
    private View lmh;
    private b lmi;
    private TextView lmj;
    private BarImageView lmk;
    private TextView lml;
    private TextView lmm;
    private LinearLayout lmn;
    private TextView title;

    /* loaded from: classes23.dex */
    public interface b {
        void Pn(String str);

        void dia();

        void fR(String str, String str2);
    }

    public d(Context context) {
        this.lmh = LayoutInflater.from(context).inflate(R.layout.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.lmh.findViewById(R.id.chosen_pb_title);
        this.kIj = (HeadImageView) this.lmh.findViewById(R.id.chosen_pb_person_info_head);
        this.ebD = (TextView) this.lmh.findViewById(R.id.chosen_pb_person_info_name);
        this.lmj = (TextView) this.lmh.findViewById(R.id.chosen_pb_bar_forum_name);
        this.kIj.setRadius(l.dip2px(context, 2.0f));
        this.lmk = (BarImageView) this.lmh.findViewById(R.id.chosen_pb_bar_pic);
        this.lml = (TextView) this.lmh.findViewById(R.id.chosen_pb_bar_attention_number);
        this.lmm = (TextView) this.lmh.findViewById(R.id.chosen_pb_bar_attention_button);
        this.lmm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.lmi != null) {
                    d.this.lmi.dia();
                }
            }
        });
        this.lmn = (LinearLayout) this.lmh.findViewById(R.id.chosen_pb_bar_container);
    }

    public View did() {
        return this.lmh;
    }

    public void a(b bVar) {
        this.lmi = bVar;
    }

    public void Pp(String str) {
        if (!StringUtils.isNull(str) && this.kIj != null) {
            this.kIj.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.lmn.setVisibility(8);
                return;
            }
            k.bjH().setForumNameForWaterImage(excellentPbThreadInfo.forum.forum_name);
            this.lmn.setVisibility(0);
            aV(context, excellentPbThreadInfo.forum.forum_name);
            if (this.lmk != null) {
                this.lmk.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.lmk.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.lml != null && excellentPbThreadInfo.forum.member_count != null) {
                this.lml.setText(at.numFormatOver10000(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                tP(true);
            } else {
                tP(false);
            }
        }
    }

    public void setName(String str) {
        if (this.ebD != null) {
            this.ebD.setText(str);
        }
    }

    private void aV(Context context, String str) {
        if (this.lmj != null) {
            if (StringUtils.isNull(str)) {
                this.lmj.setVisibility(4);
                return;
            }
            this.lmj.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.lmj.setOnClickListener(new a(str));
            this.lmj.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            Pp(userInfo.portrait);
            this.kIj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.x(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.ebD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.x(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(long j, String str) {
        if (this.lmi != null) {
            this.lmi.fR(String.valueOf(j), str);
        }
    }

    public void tP(boolean z) {
        if (z) {
            this.lmm.setText(R.string.relate_forum_is_followed);
            ap.setViewTextColor(this.lmm, R.color.cp_cont_d, 1);
            this.lmm.setEnabled(false);
            return;
        }
        this.lmm.setText(R.string.attention);
        this.lmm.setEnabled(true);
        ap.setViewTextColor(this.lmm, R.color.cp_cont_g, 1);
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
            if (d.this.lmi != null) {
                d.this.lmi.Pn(this.forumName);
            }
        }
    }
}
