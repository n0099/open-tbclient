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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes10.dex */
public class d {
    private TextView dez;
    private View jDk;
    private b jDl;
    private TextView jDm;
    private BarImageView jDn;
    private TextView jDo;
    private TextView jDp;
    private LinearLayout jDq;
    private HeadImageView jbZ;
    private TextView title;

    /* loaded from: classes10.dex */
    public interface b {
        void IY(String str);

        void cBX();

        void eR(String str, String str2);
    }

    public d(Context context) {
        this.jDk = LayoutInflater.from(context).inflate(R.layout.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.jDk.findViewById(R.id.chosen_pb_title);
        this.jbZ = (HeadImageView) this.jDk.findViewById(R.id.chosen_pb_person_info_head);
        this.dez = (TextView) this.jDk.findViewById(R.id.chosen_pb_person_info_name);
        this.jDm = (TextView) this.jDk.findViewById(R.id.chosen_pb_bar_forum_name);
        this.jbZ.setRadius(l.dip2px(context, 2.0f));
        this.jDn = (BarImageView) this.jDk.findViewById(R.id.chosen_pb_bar_pic);
        this.jDo = (TextView) this.jDk.findViewById(R.id.chosen_pb_bar_attention_number);
        this.jDp = (TextView) this.jDk.findViewById(R.id.chosen_pb_bar_attention_button);
        this.jDp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.jDl != null) {
                    d.this.jDl.cBX();
                }
            }
        });
        this.jDq = (LinearLayout) this.jDk.findViewById(R.id.chosen_pb_bar_container);
    }

    public View cCa() {
        return this.jDk;
    }

    public void a(b bVar) {
        this.jDl = bVar;
    }

    public void Ja(String str) {
        if (!StringUtils.isNull(str) && this.jbZ != null) {
            this.jbZ.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.jDq.setVisibility(8);
                return;
            }
            k.aNQ().setForumNameForWaterImage(excellentPbThreadInfo.forum.forum_name);
            this.jDq.setVisibility(0);
            aL(context, excellentPbThreadInfo.forum.forum_name);
            if (this.jDn != null) {
                this.jDn.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.jDn.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.jDo != null && excellentPbThreadInfo.forum.member_count != null) {
                this.jDo.setText(aq.numFormatOver10000(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                qY(true);
            } else {
                qY(false);
            }
        }
    }

    public void setName(String str) {
        if (this.dez != null) {
            this.dez.setText(str);
        }
    }

    private void aL(Context context, String str) {
        if (this.jDm != null) {
            if (StringUtils.isNull(str)) {
                this.jDm.setVisibility(4);
                return;
            }
            this.jDm.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.jDm.setOnClickListener(new a(str));
            this.jDm.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            Ja(userInfo.portrait);
            this.jbZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.u(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.dez.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.u(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(long j, String str) {
        if (this.jDl != null) {
            this.jDl.eR(String.valueOf(j), str);
        }
    }

    public void qY(boolean z) {
        if (z) {
            this.jDp.setText(R.string.relate_forum_is_followed);
            am.setViewTextColor(this.jDp, R.color.cp_cont_d, 1);
            this.jDp.setEnabled(false);
            return;
        }
        this.jDp.setText(R.string.attention);
        this.jDp.setEnabled(true);
        am.setViewTextColor(this.jDp, R.color.cp_cont_g, 1);
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
            if (d.this.jDl != null) {
                d.this.jDl.IY(this.forumName);
            }
        }
    }
}
